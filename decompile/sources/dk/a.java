package dk;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.a;
import com.facebook.drawee.components.b;
import dl.a;
import dm.c;
import java.util.concurrent.Executor;

public abstract class a<T, INFO> implements a.C0087a, a.C0166a, dm.a {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f26706b = a.class;

    /* renamed from: a  reason: collision with root package name */
    protected d<INFO> f26707a;

    /* renamed from: c  reason: collision with root package name */
    private final DraweeEventTracker f26708c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.drawee.components.a f26709d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f26710e;

    /* renamed from: f  reason: collision with root package name */
    private b f26711f;

    /* renamed from: g  reason: collision with root package name */
    private dl.a f26712g;

    /* renamed from: h  reason: collision with root package name */
    private e f26713h;

    /* renamed from: i  reason: collision with root package name */
    private c f26714i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f26715j;

    /* renamed from: k  reason: collision with root package name */
    private String f26716k;

    /* renamed from: l  reason: collision with root package name */
    private Object f26717l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f26718m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f26719n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f26720o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f26721p;

    /* renamed from: q  reason: collision with root package name */
    private String f26722q;

    /* renamed from: r  reason: collision with root package name */
    private dj.b<T> f26723r;

    /* renamed from: s  reason: collision with root package name */
    private T f26724s;

    /* renamed from: t  reason: collision with root package name */
    private Drawable f26725t;

    /* renamed from: dk.a$a  reason: collision with other inner class name */
    private static class C0165a<INFO> extends f<INFO> {
        private C0165a() {
        }

        public static <INFO> C0165a<INFO> a(d<? super INFO> dVar, d<? super INFO> dVar2) {
            if (ds.b.b()) {
                ds.b.a("AbstractDraweeController#createInternal");
            }
            C0165a<INFO> aVar = new C0165a<>();
            aVar.a(dVar);
            aVar.a(dVar2);
            if (ds.b.b()) {
                ds.b.a();
            }
            return aVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r5, dj.b<T> r6, T r7, float r8, boolean r9, boolean r10, boolean r11) {
        /*
            r4 = this;
            boolean r0 = ds.b.b()     // Catch:{ all -> 0x00d4 }
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = "AbstractDraweeController#onNewResultInternal"
            ds.b.a(r0)     // Catch:{ all -> 0x00d4 }
        L_0x000b:
            boolean r0 = r4.a((java.lang.String) r5, r6)     // Catch:{ all -> 0x00d4 }
            if (r0 != 0) goto L_0x0026
            java.lang.String r5 = "ignore_old_datasource @ onNewResult"
            r4.b(r5, r7)     // Catch:{ all -> 0x00d4 }
            r4.e(r7)     // Catch:{ all -> 0x00d4 }
            r6.b()     // Catch:{ all -> 0x00d4 }
            boolean r5 = ds.b.b()
            if (r5 == 0) goto L_0x0025
            ds.b.a()
        L_0x0025:
            return
        L_0x0026:
            com.facebook.drawee.components.DraweeEventTracker r0 = r4.f26708c     // Catch:{ all -> 0x00d4 }
            if (r9 == 0) goto L_0x002d
            com.facebook.drawee.components.DraweeEventTracker$Event r1 = com.facebook.drawee.components.DraweeEventTracker.Event.ON_DATASOURCE_RESULT     // Catch:{ all -> 0x00d4 }
            goto L_0x002f
        L_0x002d:
            com.facebook.drawee.components.DraweeEventTracker$Event r1 = com.facebook.drawee.components.DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT     // Catch:{ all -> 0x00d4 }
        L_0x002f:
            r0.a(r1)     // Catch:{ all -> 0x00d4 }
            android.graphics.drawable.Drawable r6 = r4.a(r7)     // Catch:{ Exception -> 0x00be }
            T r0 = r4.f26724s     // Catch:{ all -> 0x00d4 }
            android.graphics.drawable.Drawable r1 = r4.f26725t     // Catch:{ all -> 0x00d4 }
            r4.f26724s = r7     // Catch:{ all -> 0x00d4 }
            r4.f26725t = r6     // Catch:{ all -> 0x00d4 }
            java.lang.String r2 = "release_previous_result @ onNewResult"
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r9 == 0) goto L_0x0063
            java.lang.String r8 = "set_final_result @ onNewResult"
            r4.b(r8, r7)     // Catch:{ all -> 0x0061 }
            r8 = 0
            r4.f26723r = r8     // Catch:{ all -> 0x0061 }
            dm.c r8 = r4.f26714i     // Catch:{ all -> 0x0061 }
            r8.a(r6, r3, r10)     // Catch:{ all -> 0x0061 }
            dk.d r8 = r4.d()     // Catch:{ all -> 0x0061 }
            java.lang.Object r9 = r4.b(r7)     // Catch:{ all -> 0x0061 }
            android.graphics.drawable.Animatable r10 = r4.k()     // Catch:{ all -> 0x0061 }
        L_0x005d:
            r8.a(r5, r9, r10)     // Catch:{ all -> 0x0061 }
            goto L_0x0091
        L_0x0061:
            r5 = move-exception
            goto L_0x00ac
        L_0x0063:
            if (r11 == 0) goto L_0x007c
            java.lang.String r8 = "set_temporary_result @ onNewResult"
            r4.b(r8, r7)     // Catch:{ all -> 0x0061 }
            dm.c r8 = r4.f26714i     // Catch:{ all -> 0x0061 }
            r8.a(r6, r3, r10)     // Catch:{ all -> 0x0061 }
            dk.d r8 = r4.d()     // Catch:{ all -> 0x0061 }
            java.lang.Object r9 = r4.b(r7)     // Catch:{ all -> 0x0061 }
            android.graphics.drawable.Animatable r10 = r4.k()     // Catch:{ all -> 0x0061 }
            goto L_0x005d
        L_0x007c:
            java.lang.String r9 = "set_intermediate_result @ onNewResult"
            r4.b(r9, r7)     // Catch:{ all -> 0x0061 }
            dm.c r9 = r4.f26714i     // Catch:{ all -> 0x0061 }
            r9.a(r6, r8, r10)     // Catch:{ all -> 0x0061 }
            dk.d r8 = r4.d()     // Catch:{ all -> 0x0061 }
            java.lang.Object r9 = r4.b(r7)     // Catch:{ all -> 0x0061 }
            r8.b((java.lang.String) r5, r9)     // Catch:{ all -> 0x0061 }
        L_0x0091:
            if (r1 == 0) goto L_0x0098
            if (r1 == r6) goto L_0x0098
            r4.a((android.graphics.drawable.Drawable) r1)     // Catch:{ all -> 0x00d4 }
        L_0x0098:
            if (r0 == 0) goto L_0x00a2
            if (r0 == r7) goto L_0x00a2
            r4.b(r2, r0)     // Catch:{ all -> 0x00d4 }
            r4.e(r0)     // Catch:{ all -> 0x00d4 }
        L_0x00a2:
            boolean r5 = ds.b.b()
            if (r5 == 0) goto L_0x00ab
            ds.b.a()
        L_0x00ab:
            return
        L_0x00ac:
            if (r1 == 0) goto L_0x00b3
            if (r1 == r6) goto L_0x00b3
            r4.a((android.graphics.drawable.Drawable) r1)     // Catch:{ all -> 0x00d4 }
        L_0x00b3:
            if (r0 == 0) goto L_0x00bd
            if (r0 == r7) goto L_0x00bd
            r4.b(r2, r0)     // Catch:{ all -> 0x00d4 }
            r4.e(r0)     // Catch:{ all -> 0x00d4 }
        L_0x00bd:
            throw r5     // Catch:{ all -> 0x00d4 }
        L_0x00be:
            r8 = move-exception
            java.lang.String r10 = "drawable_failed @ onNewResult"
            r4.b(r10, r7)     // Catch:{ all -> 0x00d4 }
            r4.e(r7)     // Catch:{ all -> 0x00d4 }
            r4.a(r5, r6, r8, r9)     // Catch:{ all -> 0x00d4 }
            boolean r5 = ds.b.b()
            if (r5 == 0) goto L_0x00d3
            ds.b.a()
        L_0x00d3:
            return
        L_0x00d4:
            r5 = move-exception
            boolean r6 = ds.b.b()
            if (r6 == 0) goto L_0x00de
            ds.b.a()
        L_0x00de:
            goto L_0x00e0
        L_0x00df:
            throw r5
        L_0x00e0:
            goto L_0x00df
        */
        throw new UnsupportedOperationException("Method not decompiled: dk.a.a(java.lang.String, dj.b, java.lang.Object, float, boolean, boolean, boolean):void");
    }

    private void a(String str, dj.b<T> bVar, Throwable th, boolean z2) {
        Drawable drawable;
        if (ds.b.b()) {
            ds.b.a("AbstractDraweeController#onFailureInternal");
        }
        if (!a(str, bVar)) {
            a("ignore_old_datasource @ onFailure", th);
            bVar.b();
            if (ds.b.b()) {
                ds.b.a();
                return;
            }
            return;
        }
        this.f26708c.a(z2 ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z2) {
            a("final_failed @ onFailure", th);
            this.f26723r = null;
            this.f26720o = true;
            if (this.f26721p && (drawable = this.f26725t) != null) {
                this.f26714i.a(drawable, 1.0f, true);
            } else if (o()) {
                this.f26714i.b(th);
            } else {
                this.f26714i.a(th);
            }
            d().b(this.f26716k, th);
        } else {
            a("intermediate_failed @ onFailure", th);
            d().a(this.f26716k, th);
        }
        if (ds.b.b()) {
            ds.b.a();
        }
    }

    private void a(String str, Throwable th) {
        if (dg.a.a(2)) {
            dg.a.a(f26706b, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.f26716k, str, th);
        }
    }

    private boolean a(String str, dj.b<T> bVar) {
        if (bVar == null && this.f26723r == null) {
            return true;
        }
        return str.equals(this.f26716k) && bVar == this.f26723r && this.f26719n;
    }

    private void b(String str, T t2) {
        if (dg.a.a(2)) {
            dg.a.a(f26706b, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.f26716k, str, c(t2), Integer.valueOf(d(t2)));
        }
    }

    private void n() {
        boolean z2 = this.f26719n;
        this.f26719n = false;
        this.f26720o = false;
        dj.b<T> bVar = this.f26723r;
        if (bVar != null) {
            bVar.b();
            this.f26723r = null;
        }
        Drawable drawable = this.f26725t;
        if (drawable != null) {
            a(drawable);
        }
        if (this.f26722q != null) {
            this.f26722q = null;
        }
        this.f26725t = null;
        T t2 = this.f26724s;
        if (t2 != null) {
            b("release", t2);
            e(this.f26724s);
            this.f26724s = null;
        }
        if (z2) {
            d().a(this.f26716k);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f26711f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean o() {
        /*
            r1 = this;
            boolean r0 = r1.f26720o
            if (r0 == 0) goto L_0x0010
            com.facebook.drawee.components.b r0 = r1.f26711f
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dk.a.o():boolean");
    }

    /* access modifiers changed from: protected */
    public abstract Drawable a(T t2);

    public void a() {
        this.f26708c.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        b bVar = this.f26711f;
        if (bVar != null) {
            bVar.b();
        }
        dl.a aVar = this.f26712g;
        if (aVar != null) {
            aVar.b();
        }
        c cVar = this.f26714i;
        if (cVar != null) {
            cVar.b();
        }
        n();
    }

    /* access modifiers changed from: protected */
    public abstract void a(Drawable drawable);

    public void a(d<? super INFO> dVar) {
        df.c.a(dVar);
        d<INFO> dVar2 = this.f26707a;
        if (dVar2 instanceof C0165a) {
            ((C0165a) dVar2).a(dVar);
        } else if (dVar2 != null) {
            this.f26707a = C0165a.a(dVar2, dVar);
        } else {
            this.f26707a = dVar;
        }
    }

    public void a(e eVar) {
        this.f26713h = eVar;
    }

    /* access modifiers changed from: protected */
    public void a(dl.a aVar) {
        this.f26712g = aVar;
        if (aVar != null) {
            aVar.a((a.C0166a) this);
        }
    }

    public void a(dm.b bVar) {
        if (dg.a.a(2)) {
            dg.a.a(f26706b, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.f26716k, bVar);
        }
        this.f26708c.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.f26719n) {
            this.f26709d.b(this);
            a();
        }
        c cVar = this.f26714i;
        if (cVar != null) {
            cVar.a((Drawable) null);
            this.f26714i = null;
        }
        if (bVar != null) {
            df.c.a(bVar instanceof c);
            c cVar2 = (c) bVar;
            this.f26714i = cVar2;
            cVar2.a(this.f26715j);
        }
    }

    public void a(String str) {
        this.f26722q = str;
    }

    /* access modifiers changed from: protected */
    public void a(String str, T t2) {
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) {
        this.f26721p = z2;
    }

    public boolean a(MotionEvent motionEvent) {
        if (dg.a.a(2)) {
            dg.a.a(f26706b, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.f26716k, motionEvent);
        }
        dl.a aVar = this.f26712g;
        if (aVar == null) {
            return false;
        }
        if (!aVar.c() && !h()) {
            return false;
        }
        this.f26712g.a(motionEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public b b() {
        if (this.f26711f == null) {
            this.f26711f = new b();
        }
        return this.f26711f;
    }

    /* access modifiers changed from: protected */
    public abstract INFO b(T t2);

    /* access modifiers changed from: protected */
    public dl.a c() {
        return this.f26712g;
    }

    /* access modifiers changed from: protected */
    public String c(T t2) {
        return t2 != null ? t2.getClass().getSimpleName() : "<null>";
    }

    /* access modifiers changed from: protected */
    public int d(T t2) {
        return System.identityHashCode(t2);
    }

    /* access modifiers changed from: protected */
    public d<INFO> d() {
        d<INFO> dVar = this.f26707a;
        return dVar == null ? c.a() : dVar;
    }

    public dm.b e() {
        return this.f26714i;
    }

    /* access modifiers changed from: protected */
    public abstract void e(T t2);

    public void f() {
        if (ds.b.b()) {
            ds.b.a("AbstractDraweeController#onAttach");
        }
        if (dg.a.a(2)) {
            dg.a.a(f26706b, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.f26716k, this.f26719n ? "request already submitted" : "request needs submit");
        }
        this.f26708c.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        df.c.a(this.f26714i);
        this.f26709d.b(this);
        this.f26718m = true;
        if (!this.f26719n) {
            j();
        }
        if (ds.b.b()) {
            ds.b.a();
        }
    }

    public void g() {
        if (ds.b.b()) {
            ds.b.a("AbstractDraweeController#onDetach");
        }
        if (dg.a.a(2)) {
            dg.a.a(f26706b, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.f26716k);
        }
        this.f26708c.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.f26718m = false;
        this.f26709d.a(this);
        if (ds.b.b()) {
            ds.b.a();
        }
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        return o();
    }

    public boolean i() {
        if (dg.a.a(2)) {
            dg.a.a(f26706b, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.f26716k);
        }
        if (!o()) {
            return false;
        }
        this.f26711f.d();
        this.f26714i.b();
        j();
        return true;
    }

    /* access modifiers changed from: protected */
    public void j() {
        if (ds.b.b()) {
            ds.b.a("AbstractDraweeController#submitRequest");
        }
        Object m2 = m();
        if (m2 != null) {
            if (ds.b.b()) {
                ds.b.a("AbstractDraweeController#submitRequest->cache");
            }
            this.f26723r = null;
            this.f26719n = true;
            this.f26720o = false;
            this.f26708c.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            d().a(this.f26716k, this.f26717l);
            a(this.f26716k, m2);
            a(this.f26716k, this.f26723r, m2, 1.0f, true, true, true);
            if (ds.b.b()) {
                ds.b.a();
            }
            if (ds.b.b()) {
                ds.b.a();
                return;
            }
            return;
        }
        this.f26708c.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        d().a(this.f26716k, this.f26717l);
        this.f26714i.a(0.0f, true);
        this.f26719n = true;
        this.f26720o = false;
        this.f26723r = l();
        if (dg.a.a(2)) {
            dg.a.a(f26706b, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.f26716k, Integer.valueOf(System.identityHashCode(this.f26723r)));
        }
        final String str = this.f26716k;
        final boolean a2 = this.f26723r.a();
        this.f26723r.a(new dj.a<T>() {
        }, this.f26710e);
        if (ds.b.b()) {
            ds.b.a();
        }
    }

    public Animatable k() {
        Drawable drawable = this.f26725t;
        if (drawable instanceof Animatable) {
            return (Animatable) drawable;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract dj.b<T> l();

    /* access modifiers changed from: protected */
    public T m() {
        return null;
    }

    public String toString() {
        return df.b.a((Object) this).a("isAttached", this.f26718m).a("isRequestSubmitted", this.f26719n).a("hasFetchFailed", this.f26720o).a("fetchedImage", d(this.f26724s)).a("events", (Object) this.f26708c.toString()).toString();
    }
}
