package com.danikula.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import da.b;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

final class h {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f11058a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private final String f11059b;

    /* renamed from: c  reason: collision with root package name */
    private volatile e f11060c;

    /* renamed from: d  reason: collision with root package name */
    private final List<b> f11061d;

    /* renamed from: e  reason: collision with root package name */
    private final b f11062e;

    /* renamed from: f  reason: collision with root package name */
    private final c f11063f;

    private static final class a extends Handler implements b {

        /* renamed from: a  reason: collision with root package name */
        private final String f11064a;

        /* renamed from: b  reason: collision with root package name */
        private final List<b> f11065b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f11064a = str;
            this.f11065b = list;
        }

        public void a(File file, String str, int i2) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i2;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        public void handleMessage(Message message) {
            for (b a2 : this.f11065b) {
                a2.a((File) message.obj, this.f11064a, message.arg1);
            }
        }
    }

    public h(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f11061d = copyOnWriteArrayList;
        this.f11059b = (String) l.a(str);
        this.f11063f = (c) l.a(cVar);
        this.f11062e = new a(str, copyOnWriteArrayList);
    }

    private synchronized void c() throws ProxyCacheException {
        this.f11060c = this.f11060c == null ? e() : this.f11060c;
    }

    private synchronized void d() {
        if (this.f11058a.decrementAndGet() <= 0) {
            this.f11060c.a();
            this.f11060c = null;
        }
    }

    private e e() throws ProxyCacheException {
        e eVar = new e(new i(this.f11059b, this.f11063f.f11030d, this.f11063f.f11031e), new b(this.f11063f.a(this.f11059b), this.f11063f.f11029c));
        eVar.a(this.f11062e);
        return eVar;
    }

    public void a() {
        this.f11061d.clear();
        if (this.f11060c != null) {
            this.f11060c.a((b) null);
            this.f11060c.a();
            this.f11060c = null;
        }
        this.f11058a.set(0);
    }

    public void a(b bVar) {
        this.f11061d.add(bVar);
    }

    public void a(d dVar, Socket socket) throws ProxyCacheException, IOException {
        c();
        try {
            this.f11058a.incrementAndGet();
            this.f11060c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.f11058a.get();
    }

    public void b(b bVar) {
        this.f11061d.remove(bVar);
    }
}
