package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_position_target_global_int extends MAVLinkMessage {
    private static final long serialVersionUID = 87;

    /* renamed from: d  reason: collision with root package name */
    public int f7025d;

    /* renamed from: e  reason: collision with root package name */
    public int f7026e;

    /* renamed from: f  reason: collision with root package name */
    public int f7027f;

    /* renamed from: g  reason: collision with root package name */
    public float f7028g;

    /* renamed from: h  reason: collision with root package name */
    public float f7029h;

    /* renamed from: i  reason: collision with root package name */
    public float f7030i;

    /* renamed from: j  reason: collision with root package name */
    public float f7031j;

    /* renamed from: k  reason: collision with root package name */
    public float f7032k;

    /* renamed from: l  reason: collision with root package name */
    public float f7033l;

    /* renamed from: m  reason: collision with root package name */
    public float f7034m;

    /* renamed from: n  reason: collision with root package name */
    public short f7035n;

    /* renamed from: o  reason: collision with root package name */
    public byte f7036o;

    public msg_position_target_global_int() {
        this.f6280c = 87;
    }

    public msg_position_target_global_int(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 87;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7025d = aVar.e();
        this.f7026e = aVar.e();
        this.f7027f = aVar.e();
        this.f7028g = aVar.g();
        this.f7029h = aVar.g();
        this.f7030i = aVar.g();
        this.f7031j = aVar.g();
        this.f7032k = aVar.g();
        this.f7033l = aVar.g();
        this.f7034m = aVar.g();
        this.f7035n = aVar.d();
        this.f7036o = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_POSITION_TARGET_GLOBAL_INT - time_boot_ms:" + this.f7025d + " lat_int:" + this.f7026e + " lon_int:" + this.f7027f + " alt:" + this.f7028g + " vx:" + this.f7029h + " vy:" + this.f7030i + " vz:" + this.f7031j + " afx:" + this.f7032k + " afy:" + this.f7033l + " afz:" + this.f7034m + " type_mask:" + this.f7035n + " coordinate_frame:" + this.f7036o + "";
    }
}
