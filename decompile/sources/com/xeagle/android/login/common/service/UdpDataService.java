package com.xeagle.android.login.common.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.flypro.core.util.e;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import ka.a;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class UdpDataService extends Service {
    /* access modifiers changed from: private */
    public e function;
    private boolean isRecv;
    /* access modifiers changed from: private */
    public boolean isRunning;
    /* access modifiers changed from: private */
    public boolean isSendMsg;
    private UdpBinder mBinder;
    private RecvThread recvThread;
    /* access modifiers changed from: private */
    public DatagramSocket socket;

    public interface OnReceiveDataListener {
        void onReceiveDataListener(String str);

        void onReceiveError(String str);
    }

    private class RecvThread extends Thread {
        private OnReceiveDataListener listener;

        public RecvThread(OnReceiveDataListener onReceiveDataListener) {
            this.listener = onReceiveDataListener;
        }

        public void run() {
            while (UdpDataService.this.isRunning) {
                byte[] bArr = new byte[256];
                DatagramPacket datagramPacket = new DatagramPacket(bArr, 256);
                try {
                    if (UdpDataService.this.socket == null) {
                        Log.i("UDP", "run: ----null socket");
                        this.listener.onReceiveError("socket is NullPointer");
                        return;
                    }
                    UdpDataService.this.socket.receive(datagramPacket);
                    if (datagramPacket.getLength() > 0) {
                        this.listener.onReceiveDataListener(new String(bArr, 0, datagramPacket.getLength()).trim());
                    } else {
                        this.listener.onReceiveError("data length is null");
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    this.listener.onReceiveError(e2.getMessage());
                    Log.i("UDP", "startRecv: ------->>>接收失败");
                }
            }
        }
    }

    public class UdpBinder extends Binder {
        public UdpBinder() {
        }

        public UdpDataService getService() {
            return UdpDataService.this;
        }
    }

    private void initSocket() {
        try {
            send("test", this.function.g().contains("192.168.10") ? "192.168.10.254" : "172.50.10.254", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE);
            DatagramSocket datagramSocket = new DatagramSocket((SocketAddress) null);
            this.socket = datagramSocket;
            datagramSocket.setBroadcast(true);
            this.socket.setReuseAddress(true);
            this.socket.bind(new InetSocketAddress(IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE));
            this.isRunning = true;
        } catch (SocketException e2) {
            e2.printStackTrace();
            Log.i("UDP", "UdpChannelCon: ------socket connect failed---" + e2.getMessage());
        }
    }

    public /* synthetic */ void lambda$send$0$UdpDataService(String str, int i2) {
        byte[] bytes = str.getBytes();
        try {
            DatagramPacket datagramPacket = this.function.g().contains("192.168.10") ? new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.10.254"), i2) : new DatagramPacket(bytes, bytes.length, InetAddress.getByName("172.50.10.254"), i2);
            this.isRunning = true;
            DatagramSocket datagramSocket = this.socket;
            if (datagramSocket != null) {
                datagramSocket.send(datagramPacket);
            }
        } catch (Exception e2) {
            Log.i("UDP", "send: -----发送失败---" + e2.getMessage());
            e2.printStackTrace();
        }
    }

    public IBinder onBind(Intent intent) {
        if (this.mBinder == null) {
            this.mBinder = new UdpBinder();
        }
        return this.mBinder;
    }

    public void onCreate() {
        super.onCreate();
        Log.i("UDP", "onCreate:----- ");
        this.function = new e(getApplicationContext());
        initSocket();
    }

    public void onDestroy() {
        super.onDestroy();
        stopSelf();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        Log.i("UDP", "onStartCommand: ----");
        return super.onStartCommand(intent, i2, i3);
    }

    public void recData() {
        new Thread(new Runnable() {
            public void run() {
                String startRecv = UdpDataService.this.startRecv();
                Log.i("UDP", "run: -----" + startRecv);
            }
        }).start();
    }

    public void send(String str, String str2, int i2) {
        a.a().b().execute(new Runnable(str, i2) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                UdpDataService.this.lambda$send$0$UdpDataService(this.f$1, this.f$2);
            }
        });
    }

    public void send(final String str, String str2, final int i2, final OnReceiveDataListener onReceiveDataListener) {
        a.a().b().execute(new Runnable() {
            public void run() {
                OnReceiveDataListener onReceiveDataListener;
                String message;
                byte[] bytes = str.getBytes();
                try {
                    DatagramPacket datagramPacket = UdpDataService.this.function.g().contains("192.168.10") ? new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.10.254"), i2) : new DatagramPacket(bytes, bytes.length, InetAddress.getByName("172.50.10.254"), i2);
                    boolean unused = UdpDataService.this.isRunning = true;
                    if (UdpDataService.this.socket != null) {
                        boolean unused2 = UdpDataService.this.isSendMsg = true;
                        UdpDataService.this.startRecv(onReceiveDataListener);
                        UdpDataService.this.socket.send(datagramPacket);
                    }
                } catch (UnknownHostException e2) {
                    e2.printStackTrace();
                    onReceiveDataListener = onReceiveDataListener;
                    if (onReceiveDataListener != null) {
                        message = e2.getMessage();
                        onReceiveDataListener.onReceiveError(message);
                    }
                } catch (IOException e3) {
                    Log.i("UDP", "send: -----发送失败---" + e3.getMessage());
                    e3.printStackTrace();
                    onReceiveDataListener = onReceiveDataListener;
                    if (onReceiveDataListener != null) {
                        message = e3.getMessage();
                        onReceiveDataListener.onReceiveError(message);
                    }
                }
            }
        });
    }

    public boolean sendMsg(String str) {
        byte[] bytes = str.getBytes();
        try {
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("172.50.10.254"), IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE);
            DatagramSocket datagramSocket = this.socket;
            if (datagramSocket != null) {
                datagramSocket.send(datagramPacket);
            }
            return true;
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
            return false;
        } catch (IOException e3) {
            Log.i("UDP", "send: -----发送失败");
            e3.printStackTrace();
            return false;
        }
    }

    public String startRecv() {
        byte[] bArr = new byte[64];
        try {
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 64);
            this.socket.receive(datagramPacket);
            int length = datagramPacket.getLength();
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            return new String(bArr2).trim();
        } catch (IOException e2) {
            e2.printStackTrace();
            Log.i("UDP", "startRecv: ------->>>接收失败---" + e2.getMessage());
            return "";
        }
    }

    public void startRecv(final OnReceiveDataListener onReceiveDataListener) {
        final byte[] bArr = new byte[64];
        final DatagramPacket datagramPacket = new DatagramPacket(bArr, 64);
        new Thread(new Runnable() {
            public void run() {
                while (UdpDataService.this.isSendMsg) {
                    try {
                        UdpDataService.this.socket.receive(datagramPacket);
                        if (datagramPacket.getLength() > 0) {
                            int length = datagramPacket.getLength();
                            byte[] bArr = new byte[length];
                            boolean unused = UdpDataService.this.isSendMsg = false;
                            System.arraycopy(bArr, 0, bArr, 0, length);
                            OnReceiveDataListener onReceiveDataListener = onReceiveDataListener;
                            if (onReceiveDataListener != null) {
                                onReceiveDataListener.onReceiveDataListener(new String(bArr).trim());
                            }
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        OnReceiveDataListener onReceiveDataListener2 = onReceiveDataListener;
                        if (onReceiveDataListener2 != null) {
                            onReceiveDataListener2.onReceiveError(e2.getMessage());
                        }
                        Log.i("UDP", "startRecv: ------->>>接收失败---" + e2.getMessage());
                    }
                }
            }
        }).start();
    }

    public void stop() {
        this.isRunning = false;
        RecvThread recvThread2 = this.recvThread;
        if (recvThread2 != null && recvThread2.isAlive()) {
            this.recvThread.interrupt();
            this.recvThread = null;
        }
    }
}
