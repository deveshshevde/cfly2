package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.tasks.c;

public final class cn<ResultT> extends bp {

    /* renamed from: a  reason: collision with root package name */
    private final s<a.b, ResultT> f17564a;

    /* renamed from: b  reason: collision with root package name */
    private final c<ResultT> f17565b;

    /* renamed from: d  reason: collision with root package name */
    private final r f17566d;

    public cn(int i2, s<a.b, ResultT> sVar, c<ResultT> cVar, r rVar) {
        super(i2);
        this.f17565b = cVar;
        this.f17564a = sVar;
        this.f17566d = rVar;
        if (i2 == 2 && sVar.b()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    public final void a(Status status) {
        this.f17565b.b(this.f17566d.a(status));
    }

    public final void a(x xVar, boolean z2) {
        xVar.a(this.f17565b, z2);
    }

    public final void a(Exception exc) {
        this.f17565b.b(exc);
    }

    public final boolean a(bh<?> bhVar) {
        return this.f17564a.b();
    }

    public final Feature[] b(bh<?> bhVar) {
        return this.f17564a.d();
    }

    public final void d(bh<?> bhVar) throws DeadObjectException {
        try {
            this.f17564a.a(bhVar.d(), this.f17565b);
        } catch (DeadObjectException e2) {
            throw e2;
        } catch (RemoteException e3) {
            a(cp.a(e3));
        } catch (RuntimeException e4) {
            this.f17565b.b((Exception) e4);
        }
    }
}
