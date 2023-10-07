package com.danikula.videocache;

import android.content.Context;
import android.net.Uri;
import da.f;
import dc.d;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final Object f11041a;

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f11042b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, h> f11043c;

    /* renamed from: d  reason: collision with root package name */
    private final ServerSocket f11044d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11045e;

    /* renamed from: f  reason: collision with root package name */
    private final Thread f11046f;

    /* renamed from: g  reason: collision with root package name */
    private final c f11047g;

    /* renamed from: h  reason: collision with root package name */
    private final k f11048h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private File f11049a;

        /* renamed from: b  reason: collision with root package name */
        private da.c f11050b = new f();

        /* renamed from: c  reason: collision with root package name */
        private da.a f11051c = new da.g(IjkMediaMeta.AV_CH_STEREO_LEFT);

        /* renamed from: d  reason: collision with root package name */
        private dc.c f11052d;

        /* renamed from: e  reason: collision with root package name */
        private db.b f11053e = new db.a();

        public a(Context context) {
            this.f11052d = d.a(context);
            this.f11049a = q.a(context);
        }

        private c b() {
            return new c(this.f11049a, this.f11050b, this.f11051c, this.f11052d, this.f11053e);
        }

        public a a(long j2) {
            this.f11051c = new da.g(j2);
            return this;
        }

        public a a(da.c cVar) {
            this.f11050b = (da.c) l.a(cVar);
            return this;
        }

        public a a(db.b bVar) {
            this.f11053e = (db.b) l.a(bVar);
            return this;
        }

        public a a(File file) {
            this.f11049a = (File) l.a(file);
            return this;
        }

        public g a() {
            return new g(b());
        }
    }

    private final class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final Socket f11055b;

        public b(Socket socket) {
            this.f11055b = socket;
        }

        public void run() {
            g.this.a(this.f11055b);
        }
    }

    private final class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final CountDownLatch f11057b;

        public c(CountDownLatch countDownLatch) {
            this.f11057b = countDownLatch;
        }

        public void run() {
            this.f11057b.countDown();
            g.this.d();
        }
    }

    private g(c cVar) {
        this.f11041a = new Object();
        this.f11042b = Executors.newFixedThreadPool(8);
        this.f11043c = new ConcurrentHashMap();
        this.f11047g = (c) l.a(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f11044d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f11045e = localPort;
            j.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.f11046f = thread;
            thread.start();
            countDownLatch.await();
            this.f11048h = new k("127.0.0.1", localPort);
            f.a("Proxy cache server started. Is it alive? " + b());
        } catch (IOException | InterruptedException e2) {
            this.f11042b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e2);
        }
    }

    private void a(File file) {
        try {
            this.f11047g.f11029c.a(file);
        } catch (IOException e2) {
            f.a("Error touching file " + file, (Exception) e2);
        }
    }

    private void a(Throwable th) {
        f.c("HttpProxyCacheServer error", th.getMessage());
    }

    /* access modifiers changed from: private */
    public void a(Socket socket) {
        StringBuilder sb;
        try {
            d a2 = d.a(socket.getInputStream());
            String c2 = n.c(a2.f11034a);
            if (this.f11048h.a(c2)) {
                this.f11048h.a(socket);
            } else {
                e(c2).a(a2, socket);
            }
            b(socket);
            sb = new StringBuilder();
        } catch (SocketException unused) {
            b(socket);
            sb = new StringBuilder();
        } catch (ProxyCacheException | IOException e2) {
            a((Throwable) new ProxyCacheException("Error processing request", e2));
            b(socket);
            sb = new StringBuilder();
        } catch (Throwable th) {
            b(socket);
            f.a("Opened connections: " + e());
            throw th;
        }
        sb.append("Opened connections: ");
        sb.append(e());
        f.a(sb.toString());
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private boolean b() {
        return this.f11048h.a(3, 70);
    }

    private String c(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", new Object[]{"127.0.0.1", Integer.valueOf(this.f11045e), n.b(str)});
    }

    private void c() {
        synchronized (this.f11041a) {
            for (h a2 : this.f11043c.values()) {
                a2.a();
            }
            this.f11043c.clear();
        }
    }

    private void c(Socket socket) {
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (IOException | SocketException unused) {
        }
    }

    private File d(String str) {
        return new File(this.f11047g.f11027a, this.f11047g.f11028b.a(str));
    }

    /* access modifiers changed from: private */
    public void d() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                this.f11042b.submit(new b(this.f11044d.accept()));
            } catch (IOException e2) {
                a((Throwable) new ProxyCacheException("Error during waiting connection", e2));
                return;
            }
        }
    }

    private void d(Socket socket) {
        try {
            if (!socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (IOException e2) {
            f.b("Failed to close socket on proxy side: {}. It seems client have already closed connection.", e2.getMessage());
        }
    }

    private int e() {
        int i2;
        synchronized (this.f11041a) {
            i2 = 0;
            for (h b2 : this.f11043c.values()) {
                i2 += b2.b();
            }
        }
        return i2;
    }

    private h e(String str) throws ProxyCacheException {
        h hVar;
        synchronized (this.f11041a) {
            hVar = this.f11043c.get(str);
            if (hVar == null) {
                hVar = new h(str, this.f11047g);
                this.f11043c.put(str, hVar);
            }
        }
        return hVar;
    }

    private void e(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException unused) {
        }
    }

    public String a(String str) {
        return a(str, true);
    }

    public String a(String str, boolean z2) {
        if (!z2 || !b(str)) {
            return b() ? c(str) : str;
        }
        File d2 = d(str);
        a(d2);
        return Uri.fromFile(d2).toString();
    }

    public void a() {
        f.a("Shutdown proxy server");
        c();
        this.f11047g.f11030d.a();
        this.f11046f.interrupt();
        try {
            if (!this.f11044d.isClosed()) {
                this.f11044d.close();
            }
        } catch (IOException e2) {
            a((Throwable) new ProxyCacheException("Error shutting down proxy server", e2));
        }
    }

    public void a(b bVar) {
        l.a(bVar);
        synchronized (this.f11041a) {
            for (h b2 : this.f11043c.values()) {
                b2.b(bVar);
            }
        }
    }

    public void a(b bVar, String str) {
        l.a(bVar, str);
        synchronized (this.f11041a) {
            try {
                e(str).a(bVar);
            } catch (ProxyCacheException e2) {
                f.b("Error registering cache listener", e2.getMessage());
            }
        }
    }

    public boolean b(String str) {
        l.a(str, "Url can't be null!");
        return d(str).exists();
    }
}
