package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public final class UdpDataSource extends d {

    /* renamed from: a  reason: collision with root package name */
    private final int f16969a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f16970b;

    /* renamed from: c  reason: collision with root package name */
    private final DatagramPacket f16971c;

    /* renamed from: d  reason: collision with root package name */
    private Uri f16972d;

    /* renamed from: e  reason: collision with root package name */
    private DatagramSocket f16973e;

    /* renamed from: f  reason: collision with root package name */
    private MulticastSocket f16974f;

    /* renamed from: g  reason: collision with root package name */
    private InetAddress f16975g;

    /* renamed from: h  reason: collision with root package name */
    private InetSocketAddress f16976h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f16977i;

    /* renamed from: j  reason: collision with root package name */
    private int f16978j;

    public static final class UdpDataSourceException extends IOException {
        public UdpDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public UdpDataSource() {
        this(GSYVideoView.CHANGE_DELAY_TIME);
    }

    public UdpDataSource(int i2) {
        this(i2, 8000);
    }

    public UdpDataSource(int i2, int i3) {
        super(true);
        this.f16969a = i3;
        byte[] bArr = new byte[i2];
        this.f16970b = bArr;
        this.f16971c = new DatagramPacket(bArr, 0, i2);
    }

    public int a(byte[] bArr, int i2, int i3) throws UdpDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        if (this.f16978j == 0) {
            try {
                this.f16973e.receive(this.f16971c);
                int length = this.f16971c.getLength();
                this.f16978j = length;
                a(length);
            } catch (IOException e2) {
                throw new UdpDataSourceException(e2);
            }
        }
        int length2 = this.f16971c.getLength();
        int i4 = this.f16978j;
        int min = Math.min(i4, i3);
        System.arraycopy(this.f16970b, length2 - i4, bArr, i2, min);
        this.f16978j -= min;
        return min;
    }

    public long a(h hVar) throws UdpDataSourceException {
        DatagramSocket datagramSocket;
        Uri uri = hVar.f16995a;
        this.f16972d = uri;
        String host = uri.getHost();
        int port = this.f16972d.getPort();
        b(hVar);
        try {
            this.f16975g = InetAddress.getByName(host);
            this.f16976h = new InetSocketAddress(this.f16975g, port);
            if (this.f16975g.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(this.f16976h);
                this.f16974f = multicastSocket;
                multicastSocket.joinGroup(this.f16975g);
                datagramSocket = this.f16974f;
            } else {
                datagramSocket = new DatagramSocket(this.f16976h);
            }
            this.f16973e = datagramSocket;
            try {
                this.f16973e.setSoTimeout(this.f16969a);
                this.f16977i = true;
                c(hVar);
                return -1;
            } catch (SocketException e2) {
                throw new UdpDataSourceException(e2);
            }
        } catch (IOException e3) {
            throw new UdpDataSourceException(e3);
        }
    }

    public Uri a() {
        return this.f16972d;
    }

    public void c() {
        this.f16972d = null;
        MulticastSocket multicastSocket = this.f16974f;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(this.f16975g);
            } catch (IOException unused) {
            }
            this.f16974f = null;
        }
        DatagramSocket datagramSocket = this.f16973e;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f16973e = null;
        }
        this.f16975g = null;
        this.f16976h = null;
        this.f16978j = 0;
        if (this.f16977i) {
            this.f16977i = false;
            d();
        }
    }
}
