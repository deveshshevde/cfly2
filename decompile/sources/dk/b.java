package dk;

import android.content.Context;
import android.graphics.drawable.Animatable;
import df.c;
import dk.b;
import dm.a;
import dm.d;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public abstract class b<BUILDER extends b<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements d {

    /* renamed from: a  reason: collision with root package name */
    private static final d<Object> f26729a = new c<Object>() {
        public void a(String str, Object obj, Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final NullPointerException f26730b = new NullPointerException("No image request was specified!");

    /* renamed from: q  reason: collision with root package name */
    private static final AtomicLong f26731q = new AtomicLong();

    /* renamed from: c  reason: collision with root package name */
    private final Context f26732c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<d> f26733d;

    /* renamed from: e  reason: collision with root package name */
    private Object f26734e;

    /* renamed from: f  reason: collision with root package name */
    private REQUEST f26735f;

    /* renamed from: g  reason: collision with root package name */
    private REQUEST f26736g;

    /* renamed from: h  reason: collision with root package name */
    private REQUEST[] f26737h;

    /* renamed from: i  reason: collision with root package name */
    private df.d<dj.b<IMAGE>> f26738i;

    /* renamed from: j  reason: collision with root package name */
    private d<? super INFO> f26739j;

    /* renamed from: k  reason: collision with root package name */
    private e f26740k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f26741l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f26742m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f26743n;

    /* renamed from: o  reason: collision with root package name */
    private String f26744o;

    /* renamed from: p  reason: collision with root package name */
    private a f26745p;

    /* renamed from: a */
    public BUILDER b(a aVar) {
        this.f26745p = aVar;
        return h();
    }

    public BUILDER a(Object obj) {
        this.f26734e = obj;
        return h();
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        Set<d> set = this.f26733d;
        if (set != null) {
            for (d a2 : set) {
                aVar.a(a2);
            }
        }
        d<? super INFO> dVar = this.f26739j;
        if (dVar != null) {
            aVar.a(dVar);
        }
        if (this.f26742m) {
            aVar.a(f26729a);
        }
    }

    public boolean a() {
        return this.f26743n;
    }

    public BUILDER b(REQUEST request) {
        this.f26735f = request;
        return h();
    }

    public e b() {
        return this.f26740k;
    }

    /* access modifiers changed from: protected */
    public void b(a aVar) {
        if (this.f26741l) {
            aVar.b().a(this.f26741l);
            c(aVar);
        }
    }

    public String c() {
        return this.f26744o;
    }

    /* access modifiers changed from: protected */
    public void c(a aVar) {
        if (aVar.c() == null) {
            aVar.a(dl.a.a(this.f26732c));
        }
    }

    /* renamed from: d */
    public a i() {
        REQUEST request;
        e();
        if (this.f26735f == null && this.f26737h == null && (request = this.f26736g) != null) {
            this.f26735f = request;
            this.f26736g = null;
        }
        return f();
    }

    /* access modifiers changed from: protected */
    public void e() {
        boolean z2 = false;
        c.b(this.f26737h == null || this.f26735f == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.f26738i == null || (this.f26737h == null && this.f26735f == null && this.f26736g == null)) {
            z2 = true;
        }
        c.b(z2, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    /* access modifiers changed from: protected */
    public a f() {
        if (ds.b.b()) {
            ds.b.a("AbstractDraweeControllerBuilder#buildController");
        }
        a g2 = g();
        g2.a(a());
        g2.a(c());
        g2.a(b());
        b(g2);
        a(g2);
        if (ds.b.b()) {
            ds.b.a();
        }
        return g2;
    }

    /* access modifiers changed from: protected */
    public abstract a g();

    /* access modifiers changed from: protected */
    public final BUILDER h() {
        return this;
    }
}
