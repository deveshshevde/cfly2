package com.xeagle.android.login.common.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.gson.Gson;
import com.xeagle.android.login.beans.O;
import com.xeagle.android.login.event.RcJsonEvent;
import com.xeagle.android.utils.c;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;

public class RcUdpReceiver extends Service {
    private ByteBuffer buf = ByteBuffer.allocate(256);
    /* access modifiers changed from: private */
    public boolean isRec;
    /* access modifiers changed from: private */
    public DatagramSocket socket = null;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
        this.isRec = false;
        stopSelf();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(20000);
            this.socket = datagramSocket;
            datagramSocket.setBroadcast(true);
            this.socket.setReuseAddress(true);
            this.isRec = true;
            startRecv();
        } catch (SocketException e2) {
            e2.printStackTrace();
            Log.i("UDP", "onStartCommand: ---connect failed");
        }
        return super.onStartCommand(intent, i2, i3);
    }

    public void startRecv() {
        new Thread(new Runnable() {
            public void run() {
                if (RcUdpReceiver.this.socket != null) {
                    byte[] bArr = new byte[91];
                    DatagramPacket datagramPacket = new DatagramPacket(bArr, 91);
                    while (RcUdpReceiver.this.isRec) {
                        try {
                            RcUdpReceiver.this.socket.receive(datagramPacket);
                            int length = datagramPacket.getLength();
                            byte[] bArr2 = new byte[length];
                            System.arraycopy(bArr, 0, bArr2, 0, length);
                            String trim = new String(bArr2).trim();
                            if (c.d(trim.substring(trim.indexOf("{")))) {
                                org.greenrobot.eventbus.c.a().d(new RcJsonEvent((O) new Gson().fromJson(trim.substring(trim.indexOf("{")), O.class)));
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
