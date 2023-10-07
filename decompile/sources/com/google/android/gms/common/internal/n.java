package com.google.android.gms.common.internal;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static n f17849a;

    /* renamed from: b  reason: collision with root package name */
    private static final RootTelemetryConfiguration f17850b = new RootTelemetryConfiguration(0, false, false, 0, 0);

    /* renamed from: c  reason: collision with root package name */
    private RootTelemetryConfiguration f17851c;

    private n() {
    }

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            if (f17849a == null) {
                f17849a = new n();
            }
            nVar = f17849a;
        }
        return nVar;
    }

    public final synchronized void a(RootTelemetryConfiguration rootTelemetryConfiguration) {
        if (rootTelemetryConfiguration == null) {
            this.f17851c = f17850b;
            return;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration2 = this.f17851c;
        if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.c() < rootTelemetryConfiguration.c()) {
            this.f17851c = rootTelemetryConfiguration;
        }
    }

    public RootTelemetryConfiguration b() {
        return this.f17851c;
    }
}
