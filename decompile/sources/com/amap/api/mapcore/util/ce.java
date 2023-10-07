package com.amap.api.mapcore.util;

public final class ce {

    /* renamed from: a  reason: collision with root package name */
    private a f8130a;

    /* renamed from: b  reason: collision with root package name */
    private b f8131b;

    /* renamed from: c  reason: collision with root package name */
    private b f8132c;

    public static class a extends cd {
    }

    public static class b extends cd {
    }

    public final synchronized void a() {
        a aVar = this.f8130a;
        if (aVar != null) {
            aVar.a();
            this.f8130a = null;
        }
        b bVar = this.f8131b;
        if (bVar != null) {
            bVar.a();
            this.f8131b = null;
        }
        b bVar2 = this.f8132c;
        if (bVar2 != null) {
            bVar2.a();
            this.f8132c = null;
        }
    }
}
