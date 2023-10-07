package org.apache.commons.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.Charset;
import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;

public abstract class c {

    /* renamed from: j  reason: collision with root package name */
    private static final SocketFactory f32762j = SocketFactory.getDefault();

    /* renamed from: k  reason: collision with root package name */
    private static final ServerSocketFactory f32763k = ServerSocketFactory.getDefault();

    /* renamed from: a  reason: collision with root package name */
    protected int f32764a = 0;

    /* renamed from: b  reason: collision with root package name */
    protected Socket f32765b = null;

    /* renamed from: c  reason: collision with root package name */
    protected String f32766c = null;

    /* renamed from: d  reason: collision with root package name */
    protected int f32767d = 0;

    /* renamed from: e  reason: collision with root package name */
    protected InputStream f32768e = null;

    /* renamed from: f  reason: collision with root package name */
    protected OutputStream f32769f = null;

    /* renamed from: g  reason: collision with root package name */
    protected SocketFactory f32770g = f32762j;

    /* renamed from: h  reason: collision with root package name */
    protected ServerSocketFactory f32771h = f32763k;

    /* renamed from: i  reason: collision with root package name */
    protected int f32772i = 60000;

    /* renamed from: l  reason: collision with root package name */
    private ProtocolCommandSupport f32773l;

    /* renamed from: m  reason: collision with root package name */
    private int f32774m = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f32775n = -1;

    /* renamed from: o  reason: collision with root package name */
    private Charset f32776o = Charset.defaultCharset();

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private void a(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws SocketException, IOException {
        Socket createSocket = this.f32770g.createSocket();
        this.f32765b = createSocket;
        int i4 = this.f32774m;
        if (i4 != -1) {
            createSocket.setReceiveBufferSize(i4);
        }
        int i5 = this.f32775n;
        if (i5 != -1) {
            this.f32765b.setSendBufferSize(i5);
        }
        if (inetAddress2 != null) {
            this.f32765b.bind(new InetSocketAddress(inetAddress2, i3));
        }
        this.f32765b.connect(new InetSocketAddress(inetAddress, i2), this.f32772i);
        a();
    }

    private void b(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a() throws IOException {
        b();
        this.f32768e = this.f32765b.getInputStream();
        this.f32769f = this.f32765b.getOutputStream();
    }

    public void a(int i2) {
        this.f32767d = i2;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, String str) {
        if (g().a() > 0) {
            g().a(i2, str);
        }
    }

    public void a(String str, int i2) throws SocketException, IOException {
        this.f32766c = str;
        a(InetAddress.getByName(str), i2, (InetAddress) null, -1);
    }

    /* access modifiers changed from: protected */
    public void a(String str, String str2) {
        if (g().a() > 0) {
            g().a(str, str2);
        }
    }

    public void a(b bVar) {
        g().a(bVar);
    }

    public boolean a(Socket socket) {
        return socket.getInetAddress().equals(f());
    }

    /* access modifiers changed from: protected */
    public void b() throws SocketException {
        this.f32765b.setSoTimeout(this.f32764a);
    }

    public void c() throws IOException {
        b(this.f32765b);
        a((Closeable) this.f32768e);
        a((Closeable) this.f32769f);
        this.f32765b = null;
        this.f32766c = null;
        this.f32768e = null;
        this.f32769f = null;
    }

    public boolean d() {
        Socket socket = this.f32765b;
        if (socket == null) {
            return false;
        }
        return socket.isConnected();
    }

    public InetAddress e() {
        return this.f32765b.getLocalAddress();
    }

    public InetAddress f() {
        return this.f32765b.getInetAddress();
    }

    /* access modifiers changed from: protected */
    public ProtocolCommandSupport g() {
        return this.f32773l;
    }
}
