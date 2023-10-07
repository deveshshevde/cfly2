package jt;

import android.util.Log;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private DatagramSocket f29769a;

    /* renamed from: b  reason: collision with root package name */
    private DatagramSocket f29770b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f29771c;

    /* renamed from: d  reason: collision with root package name */
    private ByteBuffer f29772d = ByteBuffer.allocate(60);

    public a() {
        b();
    }

    private void b() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE);
            this.f29769a = datagramSocket;
            datagramSocket.setBroadcast(true);
            this.f29769a.setReuseAddress(true);
            this.f29771c = true;
        } catch (SocketException e2) {
            e2.printStackTrace();
            Log.i("APK", "UdpChannelCon: ------socket connect failed");
        }
    }

    public String a() {
        byte[] bArr = new byte[60];
        DatagramPacket datagramPacket = new DatagramPacket(bArr, 60);
        try {
            DatagramSocket datagramSocket = this.f29769a;
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

    public void a(String str, String str2, int i2) {
        byte[] bytes = str.getBytes();
        try {
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("172.50.10.254"), IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE);
            this.f29771c = true;
            DatagramSocket datagramSocket = new DatagramSocket();
            this.f29770b = datagramSocket;
            datagramSocket.send(datagramPacket);
            this.f29770b.close();
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            Log.i("UDP", "send: -----发送失败");
            e3.printStackTrace();
        }
    }
}
