package com.amap.api.mapcore.util;

public interface bm {

    public enum a {
        amap_exception(-1),
        network_exception(-1),
        file_io_exception(0),
        success_no_exception(1),
        cancel_no_exception(2);
        

        /* renamed from: f  reason: collision with root package name */
        private int f8088f;

        private a(int i2) {
            this.f8088f = i2;
        }
    }

    void a(long j2, long j3);

    void a(a aVar);

    void m();

    void n();

    void o();
}
