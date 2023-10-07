package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.d;

public interface aw {
    <A extends a.b, R extends g, T extends d.a<R, A>> T a(T t2);

    void a();

    void a(int i2);

    void a(Bundle bundle);

    void a(ConnectionResult connectionResult, a<?> aVar, boolean z2);

    <A extends a.b, T extends d.a<? extends g, A>> T b(T t2);

    void b();

    boolean d();
}
