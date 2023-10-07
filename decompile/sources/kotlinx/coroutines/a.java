package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.l;
import mm.b;
import mm.m;

public abstract class a<T> extends bm implements c<T>, af, bg {

    /* renamed from: a  reason: collision with root package name */
    protected final f f30289a;

    /* renamed from: c  reason: collision with root package name */
    private final f f30290c;

    public a(f fVar, boolean z2) {
        super(z2);
        this.f30289a = fVar;
        this.f30290c = fVar.plus(this);
    }

    /* access modifiers changed from: protected */
    public void a(T t2) {
    }

    public final void a(Throwable th) {
        ac.a(this.f30290c, th);
    }

    /* access modifiers changed from: protected */
    public void a(Throwable th, boolean z2) {
    }

    public final <R> void a(CoroutineStart coroutineStart, R r2, m<? super R, ? super c<? super T>, ? extends Object> mVar) {
        x_();
        e.a(coroutineStart, r2, this, (b<? super Throwable, l>) null, mVar);
    }

    public boolean a() {
        return super.a();
    }

    /* access modifiers changed from: protected */
    public final void b(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            a(uVar.f30513a, uVar.b());
            return;
        }
        a(obj);
    }

    public f c() {
        return this.f30290c;
    }

    /* access modifiers changed from: protected */
    public void c(Object obj) {
        d(obj);
    }

    /* access modifiers changed from: protected */
    public void d() {
    }

    public final void e() {
        d();
    }

    /* access modifiers changed from: protected */
    public String f() {
        return ah.b(this) + " was cancelled";
    }

    public String g() {
        String a2 = z.a(this.f30290c);
        if (a2 == null) {
            return super.g();
        }
        return '\"' + a2 + "\":" + super.g();
    }

    public final f getContext() {
        return this.f30290c;
    }

    public final void resumeWith(Object obj) {
        Object f2 = f(x.a(obj, (b) null, 1, (Object) null));
        if (f2 != bn.f30356a) {
            c(f2);
        }
    }

    public final void x_() {
        a((bg) this.f30289a.get(bg.f30343b));
    }
}
