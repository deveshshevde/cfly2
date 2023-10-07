package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class cp {

    /* renamed from: c  reason: collision with root package name */
    public final int f17568c;

    public cp(int i2) {
        this.f17568c = i2;
    }

    static /* synthetic */ Status a(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void a(Status status);

    public abstract void a(x xVar, boolean z2);

    public abstract void a(Exception exc);

    public abstract void d(bh<?> bhVar) throws DeadObjectException;
}
