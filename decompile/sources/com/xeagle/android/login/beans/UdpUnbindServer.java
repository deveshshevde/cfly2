package com.xeagle.android.login.beans;

import android.util.Log;
import com.xeagle.android.utils.c;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class UdpUnbindServer {
    private ByteBuffer buf = ByteBuffer.allocate(60);
    private boolean isRecv;
    /* access modifiers changed from: private */
    public boolean isRunning;
    private DatagramSocket sendSocket;
    /* access modifiers changed from: private */
    public DatagramSocket socket;

    public interface OnReceiveDataListener {
        void onReceiveDataListener(String str);
    }

    private class RecvThread extends Thread {
        private OnReceiveDataListener listener;

        public RecvThread(OnReceiveDataListener onReceiveDataListener) {
            this.listener = onReceiveDataListener;
        }

        public void run() {
            while (UdpUnbindServer.this.isRunning) {
                byte[] bArr = new byte[60];
                DatagramPacket datagramPacket = new DatagramPacket(bArr, 60);
                try {
                    if (UdpUnbindServer.this.socket == null) {
                        this.listener.onReceiveDataListener("null");
                        return;
                    }
                    UdpUnbindServer.this.socket.receive(datagramPacket);
                    int length = datagramPacket.getLength();
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, 0, bArr2, 0, length);
                    if (length > 0) {
                        boolean unused = UdpUnbindServer.this.isRunning = false;
                        this.listener.onReceiveDataListener(new String(bArr2).trim());
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    this.listener.onReceiveDataListener("null");
                    boolean unused2 = UdpUnbindServer.this.isRunning = false;
                    Log.i("UDP", "startRecv: ------->>>接收失败");
                }
            }
        }
    }

    public UdpUnbindServer() {
        initSocket();
    }

    private void initSocket() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(IMediaPlayer.MEDIA_INFO_OPEN_INPUT);
            this.socket = datagramSocket;
            datagramSocket.setBroadcast(true);
            this.socket.setReuseAddress(true);
            this.isRunning = true;
        } catch (SocketException e2) {
            e2.printStackTrace();
            Log.i("APK", "UdpChannelCon: ------socket connect failed");
        }
    }

    public void send(String str, String str2, int i2) {
        byte[] bytes = str.getBytes();
        try {
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("172.50.10.1"), IMediaPlayer.MEDIA_INFO_OPEN_INPUT);
            this.isRunning = true;
            DatagramSocket datagramSocket = new DatagramSocket();
            this.sendSocket = datagramSocket;
            datagramSocket.send(datagramPacket);
            Log.i("UDP", "send:----- " + new String(datagramPacket.getData()));
            this.sendSocket.close();
        } catch (UnknownHostException e2) {
            Log.i("UDP", "send:---unknown-- " + e2.getMessage());
            e2.printStackTrace();
        } catch (IOException e3) {
            Log.i("UDP", "send: -----发送失败");
            e3.printStackTrace();
        }
    }

    public void sendBuffer(byte[] bArr, String str, int i2) {
        try {
            DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, InetAddress.getByName("172.50.10.1"), IMediaPlayer.MEDIA_INFO_OPEN_INPUT);
            this.isRunning = true;
            DatagramSocket datagramSocket = new DatagramSocket();
            this.sendSocket = datagramSocket;
            datagramSocket.send(datagramPacket);
            Log.i("UDP", "send:----- " + c.a(datagramPacket.getData()));
            this.sendSocket.close();
        } catch (UnknownHostException e2) {
            Log.i("UDP", "send:---unknown-- " + e2.getMessage());
            e2.printStackTrace();
        } catch (IOException e3) {
            Log.i("UDP", "send: -----发送失败");
            e3.printStackTrace();
        }
    }

    public String startRecv() {
        byte[] bArr = new byte[60];
        DatagramPacket datagramPacket = new DatagramPacket(bArr, 60);
        try {
            DatagramSocket datagramSocket = this.socket;
            if (datagramSocket == null) {
                return "";
            }
            datagramSocket.receive(datagramPacket);
            int length = datagramPacket.getLength();
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            return new String(bArr2).trim();
        } catch (IOException e2) {
            e2.printStackTrace();
            Log.i("UDP", "startRecv: ------->>>接收失败");
            return "";
        }
    }

    public void startRecvByListener(OnReceiveDataListener onReceiveDataListener) {
        new RecvThread(onReceiveDataListener).start();
    }
}
