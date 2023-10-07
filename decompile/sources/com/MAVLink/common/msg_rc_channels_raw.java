package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_rc_channels_raw extends MAVLinkMessage {
    private static final long serialVersionUID = 35;

    /* renamed from: d  reason: collision with root package name */
    public int f7107d;

    /* renamed from: e  reason: collision with root package name */
    public short f7108e;

    /* renamed from: f  reason: collision with root package name */
    public short f7109f;

    /* renamed from: g  reason: collision with root package name */
    public short f7110g;

    /* renamed from: h  reason: collision with root package name */
    public short f7111h;

    /* renamed from: i  reason: collision with root package name */
    public short f7112i;

    /* renamed from: j  reason: collision with root package name */
    public short f7113j;

    /* renamed from: k  reason: collision with root package name */
    public short f7114k;

    /* renamed from: l  reason: collision with root package name */
    public short f7115l;

    /* renamed from: m  reason: collision with root package name */
    public byte f7116m;

    /* renamed from: n  reason: collision with root package name */
    public byte f7117n;

    public msg_rc_channels_raw() {
        this.f6280c = 35;
    }

    public msg_rc_channels_raw(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 35;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7107d = aVar.e();
        this.f7108e = aVar.d();
        this.f7109f = aVar.d();
        this.f7110g = aVar.d();
        this.f7111h = aVar.d();
        this.f7112i = aVar.d();
        this.f7113j = aVar.d();
        this.f7114k = aVar.d();
        this.f7115l = aVar.d();
        this.f7116m = aVar.c();
        this.f7117n = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RC_CHANNELS_RAW - time_boot_ms:" + this.f7107d + " chan1_raw:" + this.f7108e + " chan2_raw:" + this.f7109f + " chan3_raw:" + this.f7110g + " chan4_raw:" + this.f7111h + " chan5_raw:" + this.f7112i + " chan6_raw:" + this.f7113j + " chan7_raw:" + this.f7114k + " chan8_raw:" + this.f7115l + " port:" + this.f7116m + " rssi:" + this.f7117n + "";
    }
}
