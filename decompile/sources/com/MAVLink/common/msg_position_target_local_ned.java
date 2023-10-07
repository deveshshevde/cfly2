package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_position_target_local_ned extends MAVLinkMessage {
    private static final long serialVersionUID = 85;

    /* renamed from: d  reason: collision with root package name */
    public int f7037d;

    /* renamed from: e  reason: collision with root package name */
    public float f7038e;

    /* renamed from: f  reason: collision with root package name */
    public float f7039f;

    /* renamed from: g  reason: collision with root package name */
    public float f7040g;

    /* renamed from: h  reason: collision with root package name */
    public float f7041h;

    /* renamed from: i  reason: collision with root package name */
    public float f7042i;

    /* renamed from: j  reason: collision with root package name */
    public float f7043j;

    /* renamed from: k  reason: collision with root package name */
    public float f7044k;

    /* renamed from: l  reason: collision with root package name */
    public float f7045l;

    /* renamed from: m  reason: collision with root package name */
    public float f7046m;

    /* renamed from: n  reason: collision with root package name */
    public short f7047n;

    /* renamed from: o  reason: collision with root package name */
    public byte f7048o;

    public msg_position_target_local_ned() {
        this.f6280c = 85;
    }

    public msg_position_target_local_ned(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 85;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7037d = aVar.e();
        this.f7038e = aVar.g();
        this.f7039f = aVar.g();
        this.f7040g = aVar.g();
        this.f7041h = aVar.g();
        this.f7042i = aVar.g();
        this.f7043j = aVar.g();
        this.f7044k = aVar.g();
        this.f7045l = aVar.g();
        this.f7046m = aVar.g();
        this.f7047n = aVar.d();
        this.f7048o = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_POSITION_TARGET_LOCAL_NED - time_boot_ms:" + this.f7037d + " x:" + this.f7038e + " y:" + this.f7039f + " z:" + this.f7040g + " vx:" + this.f7041h + " vy:" + this.f7042i + " vz:" + this.f7043j + " afx:" + this.f7044k + " afy:" + this.f7045l + " afz:" + this.f7046m + " type_mask:" + this.f7047n + " coordinate_frame:" + this.f7048o + "";
    }
}
