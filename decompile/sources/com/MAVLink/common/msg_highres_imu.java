package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_highres_imu extends MAVLinkMessage {
    private static final long serialVersionUID = 105;

    /* renamed from: d  reason: collision with root package name */
    public long f6738d;

    /* renamed from: e  reason: collision with root package name */
    public float f6739e;

    /* renamed from: f  reason: collision with root package name */
    public float f6740f;

    /* renamed from: g  reason: collision with root package name */
    public float f6741g;

    /* renamed from: h  reason: collision with root package name */
    public float f6742h;

    /* renamed from: i  reason: collision with root package name */
    public float f6743i;

    /* renamed from: j  reason: collision with root package name */
    public float f6744j;

    /* renamed from: k  reason: collision with root package name */
    public float f6745k;

    /* renamed from: l  reason: collision with root package name */
    public float f6746l;

    /* renamed from: m  reason: collision with root package name */
    public float f6747m;

    /* renamed from: n  reason: collision with root package name */
    public float f6748n;

    /* renamed from: o  reason: collision with root package name */
    public float f6749o;

    /* renamed from: p  reason: collision with root package name */
    public float f6750p;

    /* renamed from: q  reason: collision with root package name */
    public float f6751q;

    /* renamed from: r  reason: collision with root package name */
    public short f6752r;

    public msg_highres_imu() {
        this.f6280c = 105;
    }

    public msg_highres_imu(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 105;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6738d = aVar.f();
        this.f6739e = aVar.g();
        this.f6740f = aVar.g();
        this.f6741g = aVar.g();
        this.f6742h = aVar.g();
        this.f6743i = aVar.g();
        this.f6744j = aVar.g();
        this.f6745k = aVar.g();
        this.f6746l = aVar.g();
        this.f6747m = aVar.g();
        this.f6748n = aVar.g();
        this.f6749o = aVar.g();
        this.f6750p = aVar.g();
        this.f6751q = aVar.g();
        this.f6752r = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HIGHRES_IMU - time_usec:" + this.f6738d + " xacc:" + this.f6739e + " yacc:" + this.f6740f + " zacc:" + this.f6741g + " xgyro:" + this.f6742h + " ygyro:" + this.f6743i + " zgyro:" + this.f6744j + " xmag:" + this.f6745k + " ymag:" + this.f6746l + " zmag:" + this.f6747m + " abs_pressure:" + this.f6748n + " diff_pressure:" + this.f6749o + " pressure_alt:" + this.f6750p + " temperature:" + this.f6751q + " fields_updated:" + this.f6752r + "";
    }
}
