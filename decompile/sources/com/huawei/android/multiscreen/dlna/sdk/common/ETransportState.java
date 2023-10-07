package com.huawei.android.multiscreen.dlna.sdk.common;

public enum ETransportState {
    INVALID(-1),
    STOPPED(0),
    PLAYING(1),
    PAUSED_PLAYBACK(2),
    PAUSED_RECODING(3),
    NO_MEDIA_PRESENT(4);
    

    /* renamed from: g  reason: collision with root package name */
    private int f20708g;

    private ETransportState(int i2) {
        this.f20708g = i2;
    }
}
