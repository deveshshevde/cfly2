package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.m;
import java.lang.ref.WeakReference;

public final class cj<R extends g> extends k<R> implements h<R> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public j<? super R, ? extends g> f17550a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public cj<? extends g> f17551b = null;

    /* renamed from: c  reason: collision with root package name */
    private volatile i<? super R> f17552c = null;

    /* renamed from: d  reason: collision with root package name */
    private e<R> f17553d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Object f17554e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private Status f17555f = null;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final WeakReference<d> f17556g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final ch f17557h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f17558i = false;

    public cj(WeakReference<d> weakReference) {
        m.a(weakReference, (Object) "GoogleApiClient reference must not be null");
        this.f17556g = weakReference;
        d dVar = (d) weakReference.get();
        this.f17557h = new ch(this, dVar != null ? dVar.a() : Looper.getMainLooper());
    }

    /* access modifiers changed from: private */
    public final void a(Status status) {
        synchronized (this.f17554e) {
            this.f17555f = status;
            b(status);
        }
    }

    private final void b() {
        if (this.f17550a != null || this.f17552c != null) {
            d dVar = (d) this.f17556g.get();
            if (!(this.f17558i || this.f17550a == null || dVar == null)) {
                dVar.a(this);
                this.f17558i = true;
            }
            Status status = this.f17555f;
            if (status != null) {
                b(status);
                return;
            }
            e<R> eVar = this.f17553d;
            if (eVar != null) {
                eVar.setResultCallback(this);
            }
        }
    }

    private final void b(Status status) {
        synchronized (this.f17554e) {
            j<? super R, ? extends g> jVar = this.f17550a;
            if (jVar != null) {
                ((cj) m.a(this.f17551b)).a((Status) m.a(jVar.a(status), (Object) "onFailure must not return null"));
            } else if (c()) {
                ((i) m.a(this.f17552c)).a(status);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void b(g gVar) {
        if (gVar instanceof f) {
            try {
                ((f) gVar).release();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(gVar);
                String.valueOf(valueOf).length();
                Log.w("TransformedResultImpl", "Unable to release ".concat(String.valueOf(valueOf)), e2);
            }
        }
    }

    private final boolean c() {
        return (this.f17552c == null || ((d) this.f17556g.get()) == null) ? false : true;
    }

    public final <S extends g> k<S> a(j<? super R, ? extends S> jVar) {
        cj<? extends g> cjVar;
        synchronized (this.f17554e) {
            boolean z2 = true;
            m.b(this.f17550a == null, "Cannot call then() twice.");
            if (this.f17552c != null) {
                z2 = false;
            }
            m.b(z2, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f17550a = jVar;
            cjVar = new cj<>(this.f17556g);
            this.f17551b = cjVar;
            b();
        }
        return cjVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f17552c = null;
    }

    public final void a(e<?> eVar) {
        synchronized (this.f17554e) {
            this.f17553d = eVar;
            b();
        }
    }

    public final void a(R r2) {
        synchronized (this.f17554e) {
            if (!r2.getStatus().e()) {
                a(r2.getStatus());
                b((g) r2);
            } else if (this.f17550a != null) {
                by.a().submit(new cg(this, r2));
            } else if (c()) {
                ((i) m.a(this.f17552c)).b(r2);
            }
        }
    }
}
