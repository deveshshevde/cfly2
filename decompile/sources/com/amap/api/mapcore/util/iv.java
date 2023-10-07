package com.amap.api.mapcore.util;

import android.text.TextUtils;

public final class iv {

    /* renamed from: b  reason: collision with root package name */
    private static iv f9362b;

    /* renamed from: a  reason: collision with root package name */
    long f9363a = 0;

    /* renamed from: c  reason: collision with root package name */
    private iz f9364c = null;

    /* renamed from: d  reason: collision with root package name */
    private long f9365d = 0;

    /* renamed from: e  reason: collision with root package name */
    private long f9366e = 0;

    private iv() {
    }

    public static synchronized iv a() {
        iv ivVar;
        synchronized (iv.class) {
            if (f9362b == null) {
                f9362b = new iv();
            }
            ivVar = f9362b;
        }
        return ivVar;
    }

    public final iz a(iz izVar) {
        iz izVar2 = izVar;
        if (is.b() - this.f9363a > 30000) {
            this.f9364c = izVar2;
            this.f9363a = is.b();
            return this.f9364c;
        }
        this.f9363a = is.b();
        if (!jd.a(this.f9364c) || !jd.a(izVar)) {
            this.f9365d = is.b();
            this.f9364c = izVar2;
            return izVar2;
        } else if (izVar.getTime() == this.f9364c.getTime() && izVar.getAccuracy() < 300.0f) {
            return izVar2;
        } else {
            if (izVar.getProvider().equalsIgnoreCase("gps")) {
                this.f9365d = is.b();
                this.f9364c = izVar2;
                return izVar2;
            } else if (izVar.c() != this.f9364c.c()) {
                this.f9365d = is.b();
                this.f9364c = izVar2;
                return izVar2;
            } else if (izVar.getBuildingId().equals(this.f9364c.getBuildingId()) || TextUtils.isEmpty(izVar.getBuildingId())) {
                float a2 = is.a(new double[]{izVar.getLatitude(), izVar.getLongitude(), this.f9364c.getLatitude(), this.f9364c.getLongitude()});
                float accuracy = this.f9364c.getAccuracy();
                float accuracy2 = izVar.getAccuracy();
                float f2 = accuracy2 - accuracy;
                long b2 = is.b();
                long j2 = b2 - this.f9365d;
                if ((accuracy < 101.0f && accuracy2 > 299.0f) || (accuracy > 299.0f && accuracy2 > 299.0f)) {
                    long j3 = this.f9366e;
                    if (j3 == 0) {
                        this.f9366e = b2;
                    } else if (b2 - j3 > 30000) {
                        this.f9365d = b2;
                        this.f9364c = izVar2;
                        this.f9366e = 0;
                        return izVar2;
                    }
                    return this.f9364c;
                } else if (accuracy2 >= 101.0f || accuracy <= 299.0f) {
                    if (accuracy2 <= 299.0f) {
                        this.f9366e = 0;
                    }
                    if (a2 >= 10.0f || ((double) a2) <= 0.1d || accuracy2 <= 5.0f) {
                        if (f2 < 300.0f) {
                            this.f9365d = is.b();
                            this.f9364c = izVar2;
                            return izVar2;
                        } else if (j2 < 30000) {
                            return this.f9364c;
                        } else {
                            this.f9365d = is.b();
                            this.f9364c = izVar2;
                            return izVar2;
                        }
                    } else if (f2 >= -300.0f) {
                        return this.f9364c;
                    } else {
                        if (accuracy / accuracy2 < 2.0f) {
                            return this.f9364c;
                        }
                        this.f9365d = b2;
                        this.f9364c = izVar2;
                        return izVar2;
                    }
                } else {
                    this.f9365d = b2;
                    this.f9364c = izVar2;
                    this.f9366e = 0;
                    return izVar2;
                }
            } else {
                this.f9365d = is.b();
                this.f9364c = izVar2;
                return izVar2;
            }
        }
    }
}
