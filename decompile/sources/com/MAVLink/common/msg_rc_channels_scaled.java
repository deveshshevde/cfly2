package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_rc_channels_scaled extends MAVLinkMessage {
    private static final long serialVersionUID = 34;

    /* renamed from: d  reason: collision with root package name */
    public int f7118d;

    /* renamed from: e  reason: collision with root package name */
    public short f7119e;

    /* renamed from: f  reason: collision with root package name */
    public short f7120f;

    /* renamed from: g  reason: collision with root package name */
    public short f7121g;

    /* renamed from: h  reason: collision with root package name */
    public short f7122h;

    /* renamed from: i  reason: collision with root package name */
    public short f7123i;

    /* renamed from: j  reason: collision with root package name */
    public short f7124j;

    /* renamed from: k  reason: collision with root package name */
    public short f7125k;

    /* renamed from: l  reason: collision with root package name */
    public short f7126l;

    /* renamed from: m  reason: collision with root package name */
    public byte f7127m;

    /* renamed from: n  reason: collision with root package name */
    public byte f7128n;

    public msg_rc_channels_scaled() {
        this.f6280c = 34;
    }

    public msg_rc_channels_scaled(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 34;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7118d = aVar.e();
        this.f7119e = aVar.d();
        this.f7120f = aVar.d();
        this.f7121g = aVar.d();
        this.f7122h = aVar.d();
        this.f7123i = aVar.d();
        this.f7124j = aVar.d();
        this.f7125k = aVar.d();
        this.f7126l = aVar.d();
        this.f7127m = aVar.c();
        this.f7128n = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RC_CHANNELS_SCALED - time_boot_ms:" + this.f7118d + " chan1_scaled:" + this.f7119e + " chan2_scaled:" + this.f7120f + " chan3_scaled:" + this.f7121g + " chan4_scaled:" + this.f7122h + " chan5_scaled:" + this.f7123i + " chan6_scaled:" + this.f7124j + " chan7_scaled:" + this.f7125k + " chan8_scaled:" + this.f7126l + " port:" + this.f7127m + " rssi:" + this.f7128n + "";
    }
}
