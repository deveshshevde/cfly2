package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.hd;

public class gy {

    /* renamed from: a  reason: collision with root package name */
    private ha f8989a;

    /* renamed from: b  reason: collision with root package name */
    private hd f8990b;

    /* renamed from: c  reason: collision with root package name */
    private long f8991c;

    /* renamed from: d  reason: collision with root package name */
    private long f8992d;

    public interface a {
        void onDownload(byte[] bArr, long j2);

        void onException(Throwable th);

        void onFinish();

        void onStop();
    }

    public gy(hd hdVar) {
        this(hdVar, (byte) 0);
    }

    private gy(hd hdVar, byte b2) {
        this(hdVar, 0, -1, false);
    }

    public gy(hd hdVar, long j2, long j3, boolean z2) {
        this.f8990b = hdVar;
        this.f8991c = j2;
        this.f8992d = j3;
        hdVar.setHttpProtocol(z2 ? hd.c.HTTPS : hd.c.HTTP);
        this.f8990b.setDegradeAbility(hd.a.SINGLE);
    }

    public final void a() {
        ha haVar = this.f8989a;
        if (haVar != null) {
            haVar.a();
        }
    }

    public final void a(a aVar) {
        try {
            ha haVar = new ha();
            this.f8989a = haVar;
            haVar.b(this.f8992d);
            this.f8989a.a(this.f8991c);
            gw.a();
            if (gw.c(this.f8990b)) {
                this.f8990b.setDegradeType(hd.b.NEVER_GRADE);
                this.f8989a.a(this.f8990b, aVar);
                return;
            }
            this.f8990b.setDegradeType(hd.b.DEGRADE_ONLY);
            this.f8989a.a(this.f8990b, aVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
