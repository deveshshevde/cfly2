package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_set_position_target_global_int extends MAVLinkMessage {
    private static final long serialVersionUID = 86;

    /* renamed from: d  reason: collision with root package name */
    public int f7210d;

    /* renamed from: e  reason: collision with root package name */
    public int f7211e;

    /* renamed from: f  reason: collision with root package name */
    public int f7212f;

    /* renamed from: g  reason: collision with root package name */
    public float f7213g;

    /* renamed from: h  reason: collision with root package name */
    public float f7214h;

    /* renamed from: i  reason: collision with root package name */
    public float f7215i;

    /* renamed from: j  reason: collision with root package name */
    public float f7216j;

    /* renamed from: k  reason: collision with root package name */
    public float f7217k;

    /* renamed from: l  reason: collision with root package name */
    public float f7218l;

    /* renamed from: m  reason: collision with root package name */
    public float f7219m;

    /* renamed from: n  reason: collision with root package name */
    public short f7220n;

    /* renamed from: o  reason: collision with root package name */
    public byte f7221o;

    /* renamed from: p  reason: collision with root package name */
    public byte f7222p;

    /* renamed from: q  reason: collision with root package name */
    public byte f7223q;

    public msg_set_position_target_global_int() {
        this.f6280c = 86;
    }

    public msg_set_position_target_global_int(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 86;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7210d = aVar.e();
        this.f7211e = aVar.e();
        this.f7212f = aVar.e();
        this.f7213g = aVar.g();
        this.f7214h = aVar.g();
        this.f7215i = aVar.g();
        this.f7216j = aVar.g();
        this.f7217k = aVar.g();
        this.f7218l = aVar.g();
        this.f7219m = aVar.g();
        this.f7220n = aVar.d();
        this.f7221o = aVar.c();
        this.f7222p = aVar.c();
        this.f7223q = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_POSITION_TARGET_GLOBAL_INT - time_boot_ms:" + this.f7210d + " lat_int:" + this.f7211e + " lon_int:" + this.f7212f + " alt:" + this.f7213g + " vx:" + this.f7214h + " vy:" + this.f7215i + " vz:" + this.f7216j + " afx:" + this.f7217k + " afy:" + this.f7218l + " afz:" + this.f7219m + " type_mask:" + this.f7220n + " target_system:" + this.f7221o + " target_component:" + this.f7222p + " coordinate_frame:" + this.f7223q + "";
    }
}
