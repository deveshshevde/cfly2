package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.b;

final class bs<T> implements a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final f f17509a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17510b;

    /* renamed from: c  reason: collision with root package name */
    private final b<?> f17511c;

    /* renamed from: d  reason: collision with root package name */
    private final long f17512d;

    /* renamed from: e  reason: collision with root package name */
    private final long f17513e;

    bs(f fVar, int i2, b<?> bVar, long j2, long j3, String str, String str2) {
        this.f17509a = fVar;
        this.f17510b = i2;
        this.f17511c = bVar;
        this.f17512d = j2;
        this.f17513e = j3;
    }

    static <T> bs<T> a(f fVar, int i2, b<?> bVar) {
        boolean z2;
        if (!fVar.e()) {
            return null;
        }
        RootTelemetryConfiguration b2 = n.a().b();
        if (b2 == null) {
            z2 = true;
        } else if (!b2.d()) {
            return null;
        } else {
            z2 = b2.e();
            bh a2 = fVar.a(bVar);
            if (a2 != null) {
                if (!(a2.d() instanceof d)) {
                    return null;
                }
                d dVar = (d) a2.d();
                if (dVar.hasConnectionInfo() && !dVar.isConnecting()) {
                    ConnectionTelemetryConfiguration a3 = a((bh<?>) a2, (d<?>) dVar, i2);
                    if (a3 == null) {
                        return null;
                    }
                    a2.h();
                    z2 = a3.c();
                }
            }
        }
        return new bs(fVar, i2, bVar, z2 ? System.currentTimeMillis() : 0, z2 ? SystemClock.elapsedRealtime() : 0, (String) null, (String) null);
    }

    private static ConnectionTelemetryConfiguration a(bh<?> bhVar, d<?> dVar, int i2) {
        int[] d2;
        int[] e2;
        ConnectionTelemetryConfiguration telemetryConfiguration = dVar.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.b() || ((d2 = telemetryConfiguration.d()) != null ? !com.google.android.gms.common.util.a.a(d2, i2) : !((e2 = telemetryConfiguration.e()) == null || !com.google.android.gms.common.util.a.a(e2, i2))) || bhVar.b() >= telemetryConfiguration.a()) {
            return null;
        }
        return telemetryConfiguration;
    }

    public final void a(b<T> bVar) {
        bh a2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long j2;
        long j3;
        if (this.f17509a.e()) {
            RootTelemetryConfiguration b2 = n.a().b();
            if ((b2 == null || b2.d()) && (a2 = this.f17509a.a(this.f17511c)) != null && (a2.d() instanceof d)) {
                d dVar = (d) a2.d();
                boolean z2 = true;
                boolean z3 = this.f17512d > 0;
                int gCoreServiceId = dVar.getGCoreServiceId();
                if (b2 != null) {
                    boolean e2 = z3 & b2.e();
                    int a3 = b2.a();
                    int b3 = b2.b();
                    i4 = b2.c();
                    if (dVar.hasConnectionInfo() && !dVar.isConnecting()) {
                        ConnectionTelemetryConfiguration a4 = a((bh<?>) a2, (d<?>) dVar, this.f17510b);
                        if (a4 != null) {
                            if (!a4.c() || this.f17512d <= 0) {
                                z2 = false;
                            }
                            b3 = a4.a();
                            e2 = z2;
                        } else {
                            return;
                        }
                    }
                    i3 = a3;
                    i2 = b3;
                } else {
                    i4 = 0;
                    i3 = 5000;
                    i2 = 100;
                }
                f fVar = this.f17509a;
                if (bVar.e()) {
                    i6 = 0;
                    i5 = 0;
                } else {
                    if (bVar.c()) {
                        i6 = 100;
                    } else {
                        Exception a5 = bVar.a();
                        if (a5 instanceof ApiException) {
                            Status a6 = ((ApiException) a5).a();
                            int a7 = a6.a();
                            ConnectionResult b4 = a6.b();
                            i5 = b4 == null ? -1 : b4.a();
                            i6 = a7;
                        } else {
                            i6 = 101;
                        }
                    }
                    i5 = -1;
                }
                if (z3) {
                    long j4 = this.f17512d;
                    j2 = System.currentTimeMillis();
                    j3 = j4;
                    i7 = (int) (SystemClock.elapsedRealtime() - this.f17513e);
                } else {
                    j3 = 0;
                    j2 = 0;
                    i7 = -1;
                }
                fVar.a(new MethodInvocation(this.f17510b, i6, i5, j3, j2, (String) null, (String) null, gCoreServiceId, i7), i4, (long) i3, i2);
            }
        }
    }
}
