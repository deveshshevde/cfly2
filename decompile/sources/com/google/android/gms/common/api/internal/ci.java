package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.c;

abstract class ci<T> extends bp {

    /* renamed from: a  reason: collision with root package name */
    protected final c<T> f17549a;

    public ci(int i2, c<T> cVar) {
        super(i2);
        this.f17549a = cVar;
    }

    public final void a(Status status) {
        this.f17549a.b((Exception) new ApiException(status));
    }

    public void a(x xVar, boolean z2) {
    }

    public final void a(Exception exc) {
        this.f17549a.b(exc);
    }

    /* access modifiers changed from: protected */
    public abstract void c(bh<?> bhVar) throws RemoteException;

    public final void d(bh<?> bhVar) throws DeadObjectException {
        try {
            c(bhVar);
        } catch (DeadObjectException e2) {
            a(cp.a((RemoteException) e2));
            throw e2;
        } catch (RemoteException e3) {
            a(cp.a(e3));
        } catch (RuntimeException e4) {
            this.f17549a.b((Exception) e4);
        }
    }
}
