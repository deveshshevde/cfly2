package com.liulishuo.filedownloader;

import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.liulishuo.filedownloader.a;
import com.liulishuo.filedownloader.d;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.b;
import com.liulishuo.filedownloader.x;
import iq.f;
import java.io.File;
import java.util.ArrayList;

public class c implements a, a.b, d.a {

    /* renamed from: a  reason: collision with root package name */
    volatile int f21172a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final x f21173b;

    /* renamed from: c  reason: collision with root package name */
    private final x.a f21174c;

    /* renamed from: d  reason: collision with root package name */
    private int f21175d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<a.C0139a> f21176e;

    /* renamed from: f  reason: collision with root package name */
    private final String f21177f;

    /* renamed from: g  reason: collision with root package name */
    private String f21178g;

    /* renamed from: h  reason: collision with root package name */
    private String f21179h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f21180i;

    /* renamed from: j  reason: collision with root package name */
    private FileDownloadHeader f21181j;

    /* renamed from: k  reason: collision with root package name */
    private i f21182k;

    /* renamed from: l  reason: collision with root package name */
    private Object f21183l;

    /* renamed from: m  reason: collision with root package name */
    private int f21184m = 0;

    /* renamed from: n  reason: collision with root package name */
    private boolean f21185n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f21186o = false;

    /* renamed from: p  reason: collision with root package name */
    private int f21187p = 100;

    /* renamed from: q  reason: collision with root package name */
    private int f21188q = 10;

    /* renamed from: r  reason: collision with root package name */
    private boolean f21189r = false;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public boolean f21190s = false;

    /* renamed from: t  reason: collision with root package name */
    private final Object f21191t;

    /* renamed from: u  reason: collision with root package name */
    private final Object f21192u = new Object();

    /* renamed from: v  reason: collision with root package name */
    private volatile boolean f21193v = false;

    private static final class a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        private final c f21194a;

        private a(c cVar) {
            this.f21194a = cVar;
            boolean unused = cVar.f21190s = true;
        }

        public int a() {
            int e2 = this.f21194a.e();
            if (iq.d.f29057a) {
                iq.d.c(this, "add the task[%d] to the queue", Integer.valueOf(e2));
            }
            h.a().c(this.f21194a);
            return e2;
        }
    }

    c(String str) {
        this.f21177f = str;
        Object obj = new Object();
        this.f21191t = obj;
        d dVar = new d(this, obj);
        this.f21173b = dVar;
        this.f21174c = dVar;
    }

    private int Q() {
        if (!L()) {
            if (!b()) {
                E();
            }
            this.f21173b.e();
            return e();
        } else if (M()) {
            throw new IllegalStateException(f.a("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(e())));
        } else {
            throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.f21173b.toString());
        }
    }

    public a A() {
        return this;
    }

    public x.a B() {
        return this.f21174c;
    }

    public boolean C() {
        return b.a((int) r());
    }

    public int D() {
        return this.f21172a;
    }

    public void E() {
        this.f21172a = m() != null ? m().hashCode() : hashCode();
    }

    public boolean F() {
        return this.f21193v;
    }

    public void G() {
        this.f21193v = true;
    }

    public void H() {
        this.f21173b.m();
        if (h.a().a((a.b) this)) {
            this.f21193v = false;
        }
    }

    public void I() {
        Q();
    }

    public Object J() {
        return this.f21191t;
    }

    public boolean K() {
        ArrayList<a.C0139a> arrayList = this.f21176e;
        return arrayList != null && arrayList.size() > 0;
    }

    public boolean L() {
        return this.f21173b.g() != 0;
    }

    public boolean M() {
        if (q.a().h().a(this)) {
            return true;
        }
        return b.b(r());
    }

    public FileDownloadHeader N() {
        return this.f21181j;
    }

    public a.b O() {
        return this;
    }

    public ArrayList<a.C0139a> P() {
        return this.f21176e;
    }

    public a.c a() {
        return new a();
    }

    public a a(i iVar) {
        this.f21182k = iVar;
        if (iq.d.f29057a) {
            iq.d.c(this, "setListener %s", iVar);
        }
        return this;
    }

    public a a(String str) {
        return a(str, false);
    }

    public a a(String str, boolean z2) {
        this.f21178g = str;
        if (iq.d.f29057a) {
            iq.d.c(this, "setPath %s", str);
        }
        this.f21180i = z2;
        this.f21179h = z2 ? null : new File(str).getName();
        return this;
    }

    public boolean a(int i2) {
        return e() == i2;
    }

    public void b(String str) {
        this.f21179h = str;
    }

    public boolean b() {
        return this.f21172a != 0;
    }

    public int c() {
        if (!this.f21190s) {
            return Q();
        }
        throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
    }

    public boolean d() {
        boolean f2;
        synchronized (this.f21191t) {
            f2 = this.f21173b.f();
        }
        return f2;
    }

    public int e() {
        int i2 = this.f21175d;
        if (i2 != 0) {
            return i2;
        }
        if (TextUtils.isEmpty(this.f21178g) || TextUtils.isEmpty(this.f21177f)) {
            return 0;
        }
        int a2 = f.a(this.f21177f, this.f21178g, this.f21180i);
        this.f21175d = a2;
        return a2;
    }

    public String f() {
        return this.f21177f;
    }

    public int g() {
        return this.f21187p;
    }

    public int h() {
        return this.f21188q;
    }

    public String i() {
        return this.f21178g;
    }

    public boolean j() {
        return this.f21180i;
    }

    public String k() {
        return this.f21179h;
    }

    public String l() {
        return f.a(i(), j(), k());
    }

    public i m() {
        return this.f21182k;
    }

    public int n() {
        return this.f21173b.h() > 2147483647L ? SubsamplingScaleImageView.TILE_SIZE_AUTO : (int) this.f21173b.h();
    }

    public long o() {
        return this.f21173b.h();
    }

    public int p() {
        return this.f21173b.i() > 2147483647L ? SubsamplingScaleImageView.TILE_SIZE_AUTO : (int) this.f21173b.i();
    }

    public long q() {
        return this.f21173b.i();
    }

    public byte r() {
        return this.f21173b.g();
    }

    public boolean s() {
        return this.f21189r;
    }

    public Throwable t() {
        return this.f21173b.j();
    }

    public String toString() {
        return f.a("%d@%s", Integer.valueOf(e()), super.toString());
    }

    public Object u() {
        return this.f21183l;
    }

    public int v() {
        return this.f21184m;
    }

    public int w() {
        return this.f21173b.k();
    }

    public boolean x() {
        return this.f21185n;
    }

    public boolean y() {
        return this.f21173b.l();
    }

    public boolean z() {
        return this.f21186o;
    }
}
