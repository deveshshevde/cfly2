package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.d.a;
import com.google.android.gms.common.internal.m;

public final class cm<A extends d.a<? extends g, a.b>> extends cp {

    /* renamed from: a  reason: collision with root package name */
    protected final A f17563a;

    public cm(int i2, A a2) {
        super(i2);
        this.f17563a = (d.a) m.a(a2, (Object) "Null methods are not runnable.");
    }

    public final void a(Status status) {
        try {
            this.f17563a.setFailedResult(status);
        } catch (IllegalStateException e2) {
            Log.w("ApiCallRunner", "Exception reporting failure", e2);
        }
    }

    public final void a(x xVar, boolean z2) {
        xVar.a((BasePendingResult<? extends g>) this.f17563a, z2);
    }

    public final void a(Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        try {
            this.f17563a.setFailedResult(new Status(10, sb.toString()));
        } catch (IllegalStateException e2) {
            Log.w("ApiCallRunner", "Exception reporting failure", e2);
        }
    }

    public final void d(bh<?> bhVar) throws DeadObjectException {
        try {
            this.f17563a.run(bhVar.d());
        } catch (RuntimeException e2) {
            a((Exception) e2);
        }
    }
}
