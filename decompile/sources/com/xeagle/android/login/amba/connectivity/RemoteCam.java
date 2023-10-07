package com.xeagle.android.login.amba.connectivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.util.e;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.utils.v;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kx.d;
import org.json.JSONException;
import org.json.JSONObject;

public class RemoteCam implements IChannelListener {
    public static final int CAM_CONNECTIVITY_BLE_WIFI = 2;
    public static final int CAM_CONNECTIVITY_BT_BT = 1;
    public static final int CAM_CONNECTIVITY_BT_WIFI = 4;
    public static final int CAM_CONNECTIVITY_INVALID = 0;
    public static final int CAM_CONNECTIVITY_WIFI_WIFI = 3;
    private static final String TAG = "RemoteCam";
    private static CmdChannelBLE mCmdChannelBLE;
    private static CmdChannelWIFI mCmdChannelWIFI;
    private static DataChannelWIFI mDataChannelWIFI;
    private static final ExecutorService worker = Executors.newSingleThreadExecutor();
    private String mBlueAddrConnected;
    private String mBlueAddrRequested;
    /* access modifiers changed from: private */
    public CmdChannel mCmdChannel;
    private int mConnectivityType;
    private Context mContext;
    /* access modifiers changed from: private */
    public DataChannel mDataChannel;
    private String mGetFileName;
    /* access modifiers changed from: private */
    public IChannelListener mListener;
    private final ConcurrentHashMap<String, IChannelListener> mListeners = new ConcurrentHashMap<>();
    private String mMediaInfoReply;
    private int mMediaInfoStep;
    /* access modifiers changed from: private */
    public String mPutFileName;
    /* access modifiers changed from: private */
    public String mSDCardDirectory;
    private String mSdInfo;
    private String mWifiHostURL;
    private String mWifiIpAddr;
    private String mWifiSSIDConnected;
    private String mWifiSSIDRequested;
    /* access modifiers changed from: private */
    public String mZoomInfoType;
    private Boolean mfDataChannelConnected;

    public RemoteCam(Context context, v vVar, IChannelListener iChannelListener, DroneInterfaces.b bVar) {
        this.mContext = context;
        this.mListener = iChannelListener;
        this.mConnectivityType = 0;
        if (mCmdChannelWIFI == null) {
            mCmdChannelWIFI = new CmdChannelWIFI(context, this, bVar);
            mDataChannelWIFI = new DataChannelWIFI(this);
            setWifiIP("172.50.10.1", 7878, 8787);
            if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                mCmdChannelBLE = new CmdChannelBLE(this);
            }
        }
        setTcpConnectListener(vVar);
    }

    private boolean connectToCmdBLE() {
        if (this.mBlueAddrRequested.equals(this.mBlueAddrConnected)) {
            return true;
        }
        if (mCmdChannelBLE.connectTo(this.mBlueAddrRequested)) {
            this.mBlueAddrConnected = this.mBlueAddrRequested;
            this.mCmdChannel = mCmdChannelBLE;
            return true;
        }
        this.mBlueAddrConnected = null;
        return false;
    }

    /* access modifiers changed from: private */
    public boolean connectToCmdChannel() {
        int i2 = this.mConnectivityType;
        if (i2 == 2) {
            return connectToCmdBLE();
        }
        if (i2 == 3) {
            return connectToCmdWIFI();
        }
        if (this.mListener != null) {
            this.mListener.onChannelEvent(4, this.mContext.getString(R.string.connect_failed), new String[0]);
        }
        return false;
    }

    private boolean connectToCmdWIFI() {
        if (this.mWifiSSIDRequested.equals(this.mWifiSSIDConnected)) {
            return true;
        }
        this.mWifiSSIDConnected = null;
        if (!mCmdChannelWIFI.connect()) {
            return false;
        }
        this.mCmdChannel = mCmdChannelWIFI;
        this.mWifiSSIDConnected = this.mWifiSSIDRequested;
        return true;
    }

    /* access modifiers changed from: private */
    public boolean connectToDataChannel() {
        int i2 = this.mConnectivityType;
        if (i2 == 2 || i2 == 3) {
            return connectToDataWIFI();
        }
        if (this.mListener != null) {
            this.mListener.onChannelEvent(4, this.mContext.getString(R.string.connect_failed), new String[0]);
        }
        return false;
    }

    private boolean connectToDataWIFI() {
        if (this.mfDataChannelConnected.booleanValue()) {
            return true;
        }
        String g2 = new e(this.mContext.getApplicationContext()).g();
        this.mWifiIpAddr = g2;
        this.mCmdChannel.setClntInfo("TCP", g2);
        if (!mDataChannelWIFI.connect()) {
            return false;
        }
        this.mDataChannel = mDataChannelWIFI;
        this.mfDataChannelConnected = true;
        return true;
    }

    public void addIChannelListener(String str, IChannelListener iChannelListener) {
        this.mListeners.put(str, iChannelListener);
    }

    public void burnFW(final String str) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.burnFW(str);
                }
            }
        });
    }

    public void cancelGetFile(final String str) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.cancelGetFile(str);
                    RemoteCam.this.mDataChannel.cancelGetFile();
                }
            }
        });
    }

    public void cancelPutFile(final String str) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.cancelPutFile(str, RemoteCam.this.mDataChannel.cancelPutFile());
                }
            }
        });
    }

    public boolean checkSessionId() {
        CmdChannel cmdChannel = this.mCmdChannel;
        if (cmdChannel != null) {
            return cmdChannel.checkSessionID();
        }
        return false;
    }

    public void deleteFile(final String str, final int i2) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.deleteFile(str, i2);
                }
            }
        });
    }

    public void forceSplit() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.forceSplit();
                }
            }
        });
    }

    public void formatSD(final String str) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.formatSD(str);
                }
            }
        });
    }

    public void fusedNewDevice() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.fusedNewDevice();
                }
            }
        });
    }

    public void getAllSettings() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.getAllSettings();
                }
            }
        });
    }

    public void getBatteryLevel() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.getBatteryLevel();
                }
            }
        });
    }

    public void getDigitalZoom() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.getSetting("DigitalZoom");
                }
            }
        });
    }

    public void getFile(final String str) {
        StringBuilder sb;
        String str2;
        String replace = str.replace("000/", "");
        this.mGetFileName = replace;
        if (replace.contains("AA")) {
            this.mGetFileName = this.mGetFileName.replace("AA", "");
        }
        int lastIndexOf = this.mGetFileName.lastIndexOf(47);
        String str3 = this.mGetFileName;
        String substring = str3.substring(lastIndexOf + 1, str3.length());
        this.mGetFileName = substring;
        if (substring.contains("MP4")) {
            sb = new StringBuilder();
            str2 = "video_20";
        } else {
            if (this.mGetFileName.contains("JPG")) {
                sb = new StringBuilder();
                str2 = "image_20";
            }
            worker.execute(new Runnable() {
                public void run() {
                    if (RemoteCam.this.connectToCmdChannel() && RemoteCam.this.connectToDataChannel()) {
                        RemoteCam.this.mCmdChannel.getFile(str);
                    }
                }
            });
        }
        sb.append(str2);
        sb.append(this.mGetFileName);
        this.mGetFileName = sb.toString();
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel() && RemoteCam.this.connectToDataChannel()) {
                    RemoteCam.this.mCmdChannel.getFile(str);
                }
            }
        });
    }

    public void getInfo(final String str) {
        this.mGetFileName = str.substring(str.lastIndexOf(47) + 1, str.length());
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.getInfo(str);
                }
            }
        });
    }

    public void getMediaInfo() {
        this.mMediaInfoStep = 0;
        this.mMediaInfoReply = "";
        worker.execute(new Runnable() {
            public final void run() {
                RemoteCam.this.lambda$getMediaInfo$1$RemoteCam();
            }
        });
    }

    public void getRecordTime() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.getRecordTime();
                }
            }
        });
    }

    public void getSdSpace() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.getSpace("total");
                    RemoteCam.this.mCmdChannel.getSpace("free");
                }
            }
        });
    }

    public void getSdcardStatus() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.getSpace("info");
                }
            }
        });
    }

    public void getSecStream_bit() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.getSecStream_bit("SecStream_BitRate");
                }
            }
        });
    }

    public void getSetting(final String str) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.getSetting(str);
                }
            }
        });
    }

    public void getSettingOptions(final String str) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.getSettingOptions(str);
                }
            }
        });
    }

    public void getThumb(final String str) {
        final int lastIndexOf = str.lastIndexOf(47);
        this.mGetFileName = str.substring(lastIndexOf + 1, str.length()) + ".thumb";
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    int length = str.length();
                    String str = str.substring(length + -3, length).toLowerCase().equals("jpg") ? "thumb" : "idr";
                    String str2 = str;
                    RemoteCam.this.mCmdChannel.getThumb(str2.substring(lastIndexOf + 1, str2.length()).replace("AA", "AB"), str);
                }
            }
        });
    }

    public void getTotalSpace() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.getSpace("total");
                }
            }
        });
    }

    public void getVersion(final String str) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.getVersion(str);
                }
            }
        });
    }

    public void getWifi_ChanBW() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.getSecStream_bit("Wifi_ChanBW");
                }
            }
        });
    }

    public void getZoomInfo(final String str) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    String unused = RemoteCam.this.mZoomInfoType = str;
                    RemoteCam.this.mCmdChannel.getZoomInfo(str);
                }
            }
        });
    }

    public boolean isHasSsid() {
        String str;
        String str2 = this.mWifiSSIDConnected;
        if (str2 == null || (str = this.mWifiSSIDRequested) == null) {
            return false;
        }
        return str2.equalsIgnoreCase(str);
    }

    public /* synthetic */ void lambda$getMediaInfo$1$RemoteCam() {
        if (connectToCmdChannel() && this.mCmdChannel.getNumFiles("photo")) {
            this.mCmdChannel.getNumFiles("video");
            this.mCmdChannel.getNumFiles("total");
            this.mCmdChannel.getSpace("free");
            this.mCmdChannel.getSpace("total");
            this.mCmdChannel.getDevInfo();
        }
    }

    public /* synthetic */ void lambda$wakeUp$0$RemoteCam() {
        if (this.mConnectivityType == 3) {
            mCmdChannelWIFI.wakeup((WifiManager) this.mContext.getApplicationContext().getSystemService("wifi"), "amba discovery", 7877, 7877);
        }
    }

    public void listDir(final String str) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.listDir(str);
                }
            }
        });
    }

    public void onChannelEvent(int i2, Object obj, String... strArr) {
        StringBuilder sb;
        String s2;
        StringBuilder sb2;
        String str;
        String str2;
        String str3 = null;
        if (i2 == 7) {
            int parseInt = Integer.parseInt((String) obj);
            Log.i("CmdChannel", "onChannelEvent: --file size----" + parseInt);
            if (this.mGetFileName.contains("MP4")) {
                sb = new StringBuilder();
                s2 = d.q(this.mContext);
            } else {
                if (this.mGetFileName.contains("JPG")) {
                    sb = new StringBuilder();
                    s2 = d.s(this.mContext);
                }
                this.mDataChannel.getFile(str3, parseInt);
            }
            sb.append(s2);
            sb.append("/");
            sb.append(this.mGetFileName);
            str3 = sb.toString();
            this.mDataChannel.getFile(str3, parseInt);
        } else if (i2 == 19) {
            Log.i("CmdChannel", "onChannelEvent:----put firmware--- " + this.mPutFileName);
            this.mDataChannel.putFile(this.mPutFileName);
        } else if (i2 == 37) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.getInt("rval") != 0) {
                this.mListener.onChannelEvent(4, "GET_THUMB failed", new String[0]);
                return;
            }
            this.mDataChannel.getFile(d.p(this.mContext) + "/" + this.mGetFileName, jSONObject.getInt(GLImage.KEY_SIZE));
        } else if (i2 == 39) {
            this.mListener.onChannelEvent(i2, this.mZoomInfoType, (String) obj);
        } else if (i2 == 16) {
            int i3 = this.mMediaInfoStep + 1;
            this.mMediaInfoStep = i3;
            if (i3 == 1) {
                sb2 = new StringBuilder();
                sb2.append(this.mMediaInfoReply);
                str = "\nPhoto Files: ";
            } else if (i3 == 2) {
                sb2 = new StringBuilder();
                sb2.append(this.mMediaInfoReply);
                str = "\nVideo Files: ";
            } else {
                sb2 = new StringBuilder();
                sb2.append(this.mMediaInfoReply);
                str = "\nTotal Files: ";
            }
            sb2.append(str);
            this.mMediaInfoReply = sb2.toString();
            this.mMediaInfoReply += ((String) obj);
        } else if (i2 != 17) {
            IChannelListener iChannelListener = this.mListener;
            if (iChannelListener != null) {
                iChannelListener.onChannelEvent(i2, obj, new String[0]);
            }
        } else {
            try {
                JSONObject jSONObject2 = (JSONObject) obj;
                if (this.mSDCardDirectory == null) {
                    if (jSONObject2.has("media_folder")) {
                        String string = jSONObject2.getString("media_folder");
                        String substring = string.substring(0, string.length() - 1);
                        str2 = substring.substring(0, substring.lastIndexOf(47) + 1);
                    } else {
                        str2 = "/tmp/fuse_d/";
                    }
                    this.mSDCardDirectory = str2;
                    Log.e("CmdChannel", "SD directory: " + this.mSDCardDirectory);
                    return;
                }
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!next.equals("rval")) {
                        if (!next.equals("msg_id")) {
                            this.mMediaInfoReply += "\n" + next + ": " + jSONObject2.getString(next);
                        }
                    }
                }
                this.mListener.onChannelEvent(i2, this.mMediaInfoReply, new String[0]);
                this.mMediaInfoReply = null;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void putFile(final String str, final String str2) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel() && RemoteCam.this.connectToDataChannel()) {
                    RemoteCam.this.mListener.onChannelEvent(IChannelListener.DATA_CHANNEL_EVENT_PUT_MD5, (Object) null, new String[0]);
                    File file = new File(str);
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        byte[] bArr = new byte[4096];
                        MessageDigest instance = MessageDigest.getInstance("MD5");
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            instance.update(bArr, 0, read);
                        }
                        byte[] digest = instance.digest();
                        StringBuilder sb = new StringBuilder();
                        int length = digest.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            sb.append(String.format("%02x", new Object[]{Integer.valueOf(digest[i2] & 255)}));
                        }
                        String sb2 = sb.toString();
                        fileInputStream.close();
                        String unused = RemoteCam.this.mPutFileName = str;
                        RemoteCam.this.mCmdChannel.putFile(str2, sb2, file.length());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    public void removeIChannelListener(String str) {
        if (this.mListeners.size() > 0) {
            this.mListeners.remove(str);
        }
    }

    public void reset() {
        this.mBlueAddrConnected = null;
        this.mWifiSSIDConnected = null;
        this.mSDCardDirectory = "/tmp/SD0/";
        this.mfDataChannelConnected = false;
        CmdChannel cmdChannel = this.mCmdChannel;
        if (cmdChannel != null) {
            cmdChannel.reset();
        }
    }

    public void resetInFly() {
        this.mBlueAddrConnected = null;
        this.mWifiSSIDConnected = null;
        this.mSDCardDirectory = "/tmp/SD0/";
        this.mfDataChannelConnected = false;
    }

    public String sdCardDirectory() {
        return this.mSDCardDirectory;
    }

    public String sendChanBw(String str, String str2) {
        return this.mCmdChannel.sendChanBw(str, str2);
    }

    public void sendCommand(final String str) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.sendRequest(str);
                }
            }
        });
    }

    public void setBitRate(final int i2) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.setBitRate(i2);
                }
            }
        });
    }

    public RemoteCam setBtDeviceAddr(String str) {
        this.mBlueAddrRequested = str;
        return this;
    }

    public RemoteCam setChannelListener(IChannelListener iChannelListener) {
        Log.i("CmdChannel", "setChannelListener: ---");
        this.mListener = iChannelListener;
        return this;
    }

    public RemoteCam setConnectivity(int i2) {
        if (this.mConnectivityType != i2) {
            reset();
            this.mConnectivityType = i2;
        }
        return this;
    }

    public void setCtlClient(final String str) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.setClntInfo("TCP", str);
                }
            }
        });
    }

    public void setDigitalZoom(final int i2) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.setCommonSetting("DigitalZoom", i2);
                }
            }
        });
    }

    public void setMediaAttribute(final String str, final int i2) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.setMediaAttribute(str, i2);
                }
            }
        });
    }

    public void setSecStream_bit(final String str) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.setSecStream_bit("SecStream_BitRate", str);
                }
            }
        });
    }

    public void setSetting(final String str) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.setSetting(str);
                }
            }
        });
    }

    public void setSetting(String str, String str2) {
        final String str3 = "\"type\":\"" + str + "\",\"param\":\"" + str2 + "\"";
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.setSetting(str3);
                }
            }
        });
    }

    public void setTcpConnectListener(v vVar) {
        CmdChannelWIFI cmdChannelWIFI = mCmdChannelWIFI;
        if (cmdChannelWIFI != null) {
            cmdChannelWIFI.setTcpListener(vVar);
        }
    }

    public RemoteCam setWifiIP(String str, int i2, int i3) {
        this.mWifiHostURL = str;
        mCmdChannelWIFI.setIP(str, i2);
        mDataChannelWIFI.setIP(str, i3);
        return this;
    }

    public RemoteCam setWifiInfo(String str, String str2) {
        this.mWifiSSIDRequested = str;
        this.mWifiIpAddr = str2;
        return this;
    }

    public void setWifiSsid(final String str) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.setWifiSsid(str);
                }
            }
        });
    }

    public void setWifi_ChanBW(final String str) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.setSecStream_bit("Wifi_ChanBW", str);
                }
            }
        });
    }

    public void setZoom(final String str, final int i2) {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.setZoom(str, i2);
                }
            }
        });
    }

    public void standBy() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.standBy();
                }
            }
        });
    }

    public void startRecord() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.startRecord();
                }
            }
        });
    }

    public void startSession() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.startSession();
                    if (RemoteCam.this.mSDCardDirectory == null) {
                        RemoteCam.this.mCmdChannel.getDevInfo();
                    }
                }
            }
        });
    }

    public void startVF() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.resetViewfinder();
                }
            }
        });
    }

    public void stopPhoto() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.stopPhoto();
                }
            }
        });
    }

    public void stopRecord() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.stopRecord();
                }
            }
        });
    }

    public void stopSession() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.stopSession();
                }
            }
        });
    }

    public void stopVF() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.stopViewfinder();
                }
            }
        });
    }

    public String streamFile(String str) {
        return "rtsp://" + this.mWifiHostURL + str;
    }

    public void switchCameraMode() {
        worker.execute(new Runnable("\"type\":\"Switch_mode\",\"param\":\"nil\"") {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.setSetting("\"type\":\"Switch_mode\",\"param\":\"nil\"");
                }
            }
        });
    }

    public void takePhoto() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.takePhoto();
                }
            }
        });
    }

    public void upgradeFirmware() {
        worker.execute(new Runnable() {
            public void run() {
                if (RemoteCam.this.connectToCmdChannel()) {
                    RemoteCam.this.mCmdChannel.upgradeFirmware();
                }
            }
        });
    }

    public void wakeUp() {
        worker.execute(new Runnable() {
            public final void run() {
                RemoteCam.this.lambda$wakeUp$0$RemoteCam();
            }
        });
    }
}
