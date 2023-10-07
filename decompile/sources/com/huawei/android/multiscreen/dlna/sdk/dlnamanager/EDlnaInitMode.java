package com.huawei.android.multiscreen.dlna.sdk.dlnamanager;

public enum EDlnaInitMode {
    DMS_DMR_DMP(0),
    DMS_DMR(1),
    DMS_DMP(2),
    DMS(3),
    DMP(4),
    DMR(5),
    DMR_DMP(6),
    DMS_DMC(7),
    DMR_DMC(8),
    DMC(9),
    DMS_DMR_DMC(10);
    

    /* renamed from: l  reason: collision with root package name */
    private int f20764l;

    private EDlnaInitMode(int i2) {
        this.f20764l = i2;
    }

    public int a() {
        return this.f20764l;
    }
}
