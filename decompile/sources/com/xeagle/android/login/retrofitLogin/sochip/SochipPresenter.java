package com.xeagle.android.login.retrofitLogin.sochip;

import android.content.Context;
import android.util.Log;
import ch.a;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.util.e;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;
import com.xeagle.android.login.retrofitLogin.RequestCallBack;
import com.xeagle.android.login.retrofitLogin.sochip.SochipContract;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import jo.az;
import org.greenrobot.eventbus.c;
import org.json.JSONException;
import org.json.JSONObject;

public class SochipPresenter extends SochipContract.loadPresenter {
    private static final int CONN_TIME_OUT = 15000;
    private static final int READ_TIME_OUT = 5000;
    public static final int SOCHIP_TCP_HEART = 5;
    public static final int SOCHIP_TCP_PHOTO = 3;
    public static final int SOCHIP_TCP_RECORD = 1;
    public static final int SOCHIP_TCP_SDCARD_INSERT = 2;
    public static final int SOCHIP_TCP_SESSION = 4;
    private static final String TAG = "Sochip";
    private Context context;
    private DroneInterfaces.b handler;
    private int heartInterval = 2;
    Runnable heartRunnable = new Runnable() {
        public void run() {
            SochipPresenter.this.sendHeart();
        }
    };
    private Thread ioThread;
    private boolean isStartSend = false;
    /* access modifiers changed from: private */
    public SochipContract.loadView lLoadView;
    private SochipTcpListener listener;
    private SochipModel loadModel;
    private byte[] mBuffer = new byte[1024];
    private BufferedInputStream mInputStream;
    private BufferedOutputStream mOutputStream;
    private boolean mReplyReceived;
    private final Object mRxLock = new Object();
    private Socket mSocket;
    private long resetTime = 0;
    private Thread sendThread;
    private String serverIp;
    private int serverPort;
    private long startTime = 0;

    public interface SochipTcpListener {
        void onTcpListener(int i2, Object obj, String... strArr);
    }

    public SochipPresenter(Context context2, DroneInterfaces.b bVar) {
        this.context = context2;
        this.handler = bVar;
        this.loadModel = new SochipModel();
    }

    private void handleResponse(String str) {
        try {
            Log.i(TAG, "handleResponse: -----" + str);
            JSONObject jSONObject = new JSONObject(str);
            if (str.contains("event")) {
                int i2 = jSONObject.getInt("event");
                int i3 = jSONObject.getInt("status");
                if (i2 == 5001) {
                    Log.i(TAG, "handleResponse: -----录像---" + i3);
                    SochipTcpListener sochipTcpListener = this.listener;
                    if (sochipTcpListener != null) {
                        sochipTcpListener.onTcpListener(1, Integer.valueOf(i3), new String[0]);
                    }
                } else if (i2 == 5002) {
                    Log.i(TAG, "handleResponse:------卡插拔 ---" + i3);
                    SochipTcpListener sochipTcpListener2 = this.listener;
                    if (sochipTcpListener2 != null) {
                        sochipTcpListener2.onTcpListener(2, Integer.valueOf(i3), new String[0]);
                    }
                } else if (i2 == 5004) {
                    if (System.currentTimeMillis() - this.startTime > 60) {
                        Log.i(TAG, "handleResponse:------拍照 -----" + i3);
                        SochipTcpListener sochipTcpListener3 = this.listener;
                        if (sochipTcpListener3 != null) {
                            sochipTcpListener3.onTcpListener(3, Integer.valueOf(i3), new String[0]);
                            this.startTime = System.currentTimeMillis();
                        }
                    }
                }
            } else if (str.contains("msg_id")) {
                int i4 = jSONObject.getInt("msg_id");
                if (i4 == 257) {
                    int i5 = jSONObject.getInt("code");
                    Log.i(TAG, "handleResponse:-----code--- +code");
                    SochipTcpListener sochipTcpListener4 = this.listener;
                    if (sochipTcpListener4 != null) {
                        sochipTcpListener4.onTcpListener(4, Integer.valueOf(i5), new String[0]);
                    }
                } else if (i4 == 2049) {
                    int i6 = jSONObject.getInt("info");
                    SochipTcpListener sochipTcpListener5 = this.listener;
                    if (sochipTcpListener5 != null) {
                        sochipTcpListener5.onTcpListener(5, Integer.valueOf(i6), new String[0]);
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void sendHeart() {
        sendCameraMsgByBackground("{\"cmd_id\":\"4016\"}");
        this.handler.removeCallbacks(this.heartRunnable);
        this.handler.postDelayed(this.heartRunnable, (long) (this.heartInterval * 1000));
    }

    private boolean startSessionWithIp(String str, String str2) {
        return sendCameraMsgByBackground("{\"cmd_id\":4017,\"ip\":\"" + str + "\",\"mac\":\"" + str2 + "\"}");
    }

    private void unbindSessionWithIp(String str, String str2) {
        sendCameraMsgByBackground("{\"cmd_id\":4018,\"ip\":\"" + str + "\",\"mac\":\"" + str2 + "\"}");
    }

    /* access modifiers changed from: protected */
    public int cameraType() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public void connectToTcp() throws IOException {
        InetAddress byName = InetAddress.getByName(this.serverIp);
        Socket socket = new Socket();
        this.mSocket = socket;
        socket.connect(new InetSocketAddress(byName, this.serverPort));
        this.mInputStream = new BufferedInputStream(this.mSocket.getInputStream());
        this.mOutputStream = new BufferedOutputStream(this.mSocket.getOutputStream());
        sendHeart();
    }

    /* access modifiers changed from: protected */
    public void disconnectTcp() throws IOException {
        Socket socket = this.mSocket;
        if (socket != null) {
            socket.close();
            this.handler.removeCallbacks(this.heartRunnable);
        }
    }

    public void getCameraStatus(String str, int i2, final int i3) {
        this.loadModel.getCameraStatus(str, i2, i3, new RequestCallBack() {
            public void onError(Throwable th) {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socError(i3, th.getMessage());
                }
            }

            public void onFailure() {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socFailure(i3);
                }
            }

            public void onSuccess(Object obj) {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socSuccess(i3, obj);
                }
            }
        });
    }

    public void getFirmwareVersion(String str, int i2, final int i3) {
        this.loadModel.getFirmwareVersion(str, i2, i3, new RequestCallBack() {
            public void onError(Throwable th) {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socError(i3, th.getMessage());
                }
            }

            public void onFailure() {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socFailure(i3);
                }
            }

            public void onSuccess(Object obj) {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socSuccess(i3, obj);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public DroneInterfaces.b getMainHandler() {
        return this.handler;
    }

    public void getRecordStatus(String str, int i2, final int i3) {
        this.loadModel.getRecordStatus(str, i2, i3, new RequestCallBack() {
            public void onError(Throwable th) {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socError(i3, th.getMessage());
                }
            }

            public void onFailure() {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socFailure(i3);
                }
            }

            public void onSuccess(Object obj) {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socSuccess(i3, obj);
                }
            }
        });
    }

    public void getRecordTime(String str, int i2, final int i3) {
        this.loadModel.getRecordTime(str, i2, i3, new RequestCallBack() {
            public void onError(Throwable th) {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socError(i3, th.getMessage());
                }
            }

            public void onFailure() {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socFailure(i3);
                }
            }

            public void onSuccess(Object obj) {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socSuccess(i3, obj);
                }
            }
        });
    }

    public void getSdcardStatus(String str, int i2, final int i3) {
        Log.i(TAG, "getSdcardStatus:----- ");
        this.loadModel.getSdcardStatus(str, i2, i3, new RequestCallBack() {
            public void onError(Throwable th) {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socError(i3, th.getMessage());
                }
            }

            public void onFailure() {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socFailure(i3);
                }
            }

            public void onSuccess(Object obj) {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socSuccess(i3, obj);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void handleMsg(String str) {
        if (str != null) {
            try {
                new JSONObject(str);
            } catch (JSONException e2) {
                Log.i(TAG, "JSON segment: " + str);
                e2.printStackTrace();
            }
            if (str.contains("event") || str.contains("msg_id")) {
                handleResponse(str);
                this.mReplyReceived = true;
                synchronized (this.mRxLock) {
                    this.mRxLock.notify();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isUnbind() {
        return ((XEagleApp) this.context).m().d();
    }

    /* access modifiers changed from: protected */
    public void loadIpAndPort() {
        this.serverIp = "172.50.10.1";
        this.serverPort = 9999;
    }

    /* access modifiers changed from: protected */
    public String readFromChannel() {
        try {
            BufferedInputStream bufferedInputStream = this.mInputStream;
            if (bufferedInputStream == null) {
                return null;
            }
            return new String(this.mBuffer, 0, bufferedInputStream.read(this.mBuffer));
        } catch (IOException e2) {
            e2.printStackTrace();
            Log.e(TAG, "readData: -----" + e2.getMessage());
            if ("Connection reset".equalsIgnoreCase(e2.getMessage())) {
                if (System.currentTimeMillis() - this.resetTime <= 100) {
                    return null;
                }
                c.a().d(new az(true));
                this.resetTime = System.currentTimeMillis();
                return null;
            } else if ("length=1024; regionStart=0; regionLength=-1".equalsIgnoreCase(e2.getMessage())) {
                getRecordStatus(CameraGlobal.BASE_URL, 1, CameraGlobal.GET_RECORD_STATUS);
                return null;
            } else {
                reportCommunicationError(e2.getMessage());
                return null;
            }
        } catch (StringIndexOutOfBoundsException unused) {
            return null;
        }
    }

    public void regRemoteRecord(String str, int i2, int i3, int i4) {
        this.loadModel.remoteRecord(str, i2, i3, i4, new RequestCallBack() {
            public void onError(Throwable th) {
                Log.i("Listener", "onError:---request- ");
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socError(1100, th.getMessage());
                }
            }

            public void onFailure() {
                SochipPresenter.this.lLoadView.socFailure(1100);
            }

            public void onSuccess(Object obj) {
                Log.i("Listener", "onSuccess:---request- ");
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socSuccess(1100, obj);
                }
            }
        });
    }

    public void regRemoteTakePhoto(String str, int i2, int i3, int i4) {
        this.loadModel.remoteTakePhoto(str, i2, i3, i4, new RequestCallBack() {
            public void onError(Throwable th) {
                Log.i("Listener", "onError:---request- ");
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socError(CameraGlobal.SET_REMOTE_TAKEPHOTO, th.getMessage());
                }
            }

            public void onFailure() {
                SochipPresenter.this.lLoadView.socFailure(CameraGlobal.SET_REMOTE_TAKEPHOTO);
            }

            public void onSuccess(Object obj) {
                Log.i("Listener", "onSuccess:---request- ");
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socSuccess(CameraGlobal.SET_REMOTE_TAKEPHOTO, obj);
                }
            }
        });
    }

    public void setCmdAndInt(String str, int i2, final int i3, int i4) {
        this.loadModel.setCmdAndInt(str, i2, i3, i4, new RequestCallBack() {
            public void onError(Throwable th) {
                Log.i("Listener", "onError:---request- ");
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socError(i3, th.getMessage());
                }
            }

            public void onFailure() {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socFailure(i3);
                }
            }

            public void onSuccess(Object obj) {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socSuccess(i3, obj);
                }
            }
        });
    }

    public void setCmdAndStr(String str, int i2, final int i3, String str2) {
        this.loadModel.setCmdAndStr(str, i2, i3, str2, new RequestCallBack() {
            public void onError(Throwable th) {
                Log.i("Listener", "onError:---request- ");
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socError(i3, th.getMessage());
                }
            }

            public void onFailure() {
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socFailure(i3);
                }
            }

            public void onSuccess(Object obj) {
                Log.i("Listener", "onSuccess:---request- ");
                if (SochipPresenter.this.lLoadView != null) {
                    SochipPresenter.this.lLoadView.socSuccess(i3, obj);
                }
            }
        });
    }

    public void setSochipListener(SochipTcpListener sochipTcpListener) {
        this.listener = sochipTcpListener;
    }

    public void setlLoadView(SochipContract.loadView loadview) {
        this.lLoadView = loadview;
    }

    public void startSession(Context context2) {
        e eVar = new e(context2);
        if (eVar.g().contains("172.50.10") || eVar.g().contains("192.168.10")) {
            ((XEagleApp) context2).j().t();
            this.heartInterval = 2;
            startSessionWithIp(eVar.g(), a.a());
        }
    }

    public void unbindSession(Context context2) {
        e eVar = new e(context2);
        if (eVar.g().contains("172.50.10") || eVar.g().contains("192.168.10")) {
            unbindSessionWithIp(eVar.g(), a.a());
        }
    }

    /* access modifiers changed from: protected */
    public void writeToChannel(byte[] bArr) throws IOException {
        BufferedOutputStream bufferedOutputStream = this.mOutputStream;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.write(bArr);
            this.mOutputStream.flush();
        }
    }
}
