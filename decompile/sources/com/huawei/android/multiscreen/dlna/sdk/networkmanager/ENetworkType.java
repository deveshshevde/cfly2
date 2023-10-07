package com.huawei.android.multiscreen.dlna.sdk.networkmanager;

public enum ENetworkType {
    NO_NETWORK(-1),
    WIFI(0),
    ETHERNET(1),
    WIMAX(2),
    WIFI_DIRECT(3),
    Bluetooth(4);
    

    /* renamed from: g  reason: collision with root package name */
    private int f20891g;

    private ENetworkType(int i2) {
        this.f20891g = i2;
    }

    static ENetworkType a(int i2) {
        ENetworkType eNetworkType = NO_NETWORK;
        return i2 != -1 ? i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? eNetworkType : Bluetooth : WIFI_DIRECT : WIMAX : ETHERNET : WIFI : eNetworkType;
    }

    public int a() {
        return this.f20891g;
    }
}
