package com.MAVLink.ardupilotmega;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f6303a = {50, 124, IChannelListener.CMD_CHANNEL_START_SESSION_FAILED, 0, 237, 217, 104, 119, 2, 154, 37, 89, 120, 166, 252, 196, 49, 25, 9, 0, 214, 159, 220, 168, 24, 23, 170, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 67, 115, 39, 246, 185, 104, 237, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 212, 9, 254, 230, 28, 28, IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL, 221, 232, 11, 153, 41, 39, 0, 0, 0, 0, 15, 3, 0, 0, 0, 0, 0, 153, 183, 51, 82, 118, 148, 21, 0, 243, 72, 81, 175, 38, 20, 158, 152, 143, 0, 0, 0, 106, 49, 22, 29, 12, 241, 233, 0, 231, 183, 63, 54, 0, 0, 0, 0, 0, 0, 0, 175, 102, 158, 208, 56, 93, 211, 108, 32, 185, 84, 0, 0, 124, 119, 4, 76, 128, 56, 116, IChannelListener.CMD_CHANNEL_ERROR_CONNECT, 237, 203, 250, 87, 203, 220, 25, 226, 0, 29, 223, 85, 6, 229, 203, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 42, 49, 0, IChannelListener.CMD_CHANNEL_ERROR_CONNECT, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 0, 0, 0, 0, 0, 0, 8, 204, 49, 170, 44, 83, 46, 0};

    /* renamed from: b  reason: collision with root package name */
    private int f6304b;

    public a() {
        a();
    }

    public void a() {
        this.f6304b = 65535;
    }

    public void a(int i2) {
        int i3 = this.f6304b;
        int i4 = (i2 & 255) ^ (i3 & 255);
        int i5 = i4 ^ ((i4 << 4) & 255);
        this.f6304b = ((i5 >> 4) & 15) ^ ((((i3 >> 8) & 255) ^ (i5 << 8)) ^ (i5 << 3));
    }

    public int b() {
        return (this.f6304b >> 8) & 255;
    }

    public void b(int i2) {
        a(this.f6303a[i2]);
    }

    public int c() {
        return this.f6304b & 255;
    }

    public void d() {
        this.f6304b = 0;
    }
}
