package com.huawei.android.multiscreen.dlna.sdk.dlnamanager;

public enum EDlnaProductType {
    Unknown(0),
    HuaweiPhone(1),
    HuaweiSTB(2),
    HuaweiPad(3),
    HuaweiWS860S(4),
    HuaweiOthers(5);
    

    /* renamed from: g  reason: collision with root package name */
    private int f20772g;

    private EDlnaProductType(int i2) {
        this.f20772g = i2;
    }

    public int a() {
        return this.f20772g;
    }
}
