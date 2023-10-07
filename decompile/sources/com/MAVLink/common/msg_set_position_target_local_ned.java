package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_set_position_target_local_ned extends MAVLinkMessage {
    private static final long serialVersionUID = 84;

    /* renamed from: d  reason: collision with root package name */
    public int f7224d;

    /* renamed from: e  reason: collision with root package name */
    public float f7225e;

    /* renamed from: f  reason: collision with root package name */
    public float f7226f;

    /* renamed from: g  reason: collision with root package name */
    public float f7227g;

    /* renamed from: h  reason: collision with root package name */
    public float f7228h;

    /* renamed from: i  reason: collision with root package name */
    public float f7229i;

    /* renamed from: j  reason: collision with root package name */
    public float f7230j;

    /* renamed from: k  reason: collision with root package name */
    public float f7231k;

    /* renamed from: l  reason: collision with root package name */
    public float f7232l;

    /* renamed from: m  reason: collision with root package name */
    public float f7233m;

    /* renamed from: n  reason: collision with root package name */
    public short f7234n;

    /* renamed from: o  reason: collision with root package name */
    public byte f7235o;

    /* renamed from: p  reason: collision with root package name */
    public byte f7236p;

    /* renamed from: q  reason: collision with root package name */
    public byte f7237q;

    public msg_set_position_target_local_ned() {
        this.f6280c = 84;
    }

    public msg_set_position_target_local_ned(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 84;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7224d = aVar.e();
        this.f7225e = aVar.g();
        this.f7226f = aVar.g();
        this.f7227g = aVar.g();
        this.f7228h = aVar.g();
        this.f7229i = aVar.g();
        this.f7230j = aVar.g();
        this.f7231k = aVar.g();
        this.f7232l = aVar.g();
        this.f7233m = aVar.g();
        this.f7234n = aVar.d();
        this.f7235o = aVar.c();
        this.f7236p = aVar.c();
        this.f7237q = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_POSITION_TARGET_LOCAL_NED - time_boot_ms:" + this.f7224d + " x:" + this.f7225e + " y:" + this.f7226f + " z:" + this.f7227g + " vx:" + this.f7228h + " vy:" + this.f7229i + " vz:" + this.f7230j + " afx:" + this.f7231k + " afy:" + this.f7232l + " afz:" + this.f7233m + " type_mask:" + this.f7234n + " target_system:" + this.f7235o + " target_component:" + this.f7236p + " coordinate_frame:" + this.f7237q + "";
    }
}
