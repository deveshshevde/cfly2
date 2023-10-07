package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_hil_sensor extends MAVLinkMessage {
    private static final long serialVersionUID = 107;

    /* renamed from: d  reason: collision with root package name */
    public long f6799d;

    /* renamed from: e  reason: collision with root package name */
    public float f6800e;

    /* renamed from: f  reason: collision with root package name */
    public float f6801f;

    /* renamed from: g  reason: collision with root package name */
    public float f6802g;

    /* renamed from: h  reason: collision with root package name */
    public float f6803h;

    /* renamed from: i  reason: collision with root package name */
    public float f6804i;

    /* renamed from: j  reason: collision with root package name */
    public float f6805j;

    /* renamed from: k  reason: collision with root package name */
    public float f6806k;

    /* renamed from: l  reason: collision with root package name */
    public float f6807l;

    /* renamed from: m  reason: collision with root package name */
    public float f6808m;

    /* renamed from: n  reason: collision with root package name */
    public float f6809n;

    /* renamed from: o  reason: collision with root package name */
    public float f6810o;

    /* renamed from: p  reason: collision with root package name */
    public float f6811p;

    /* renamed from: q  reason: collision with root package name */
    public float f6812q;

    /* renamed from: r  reason: collision with root package name */
    public int f6813r;

    public msg_hil_sensor() {
        this.f6280c = 107;
    }

    public msg_hil_sensor(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 107;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6799d = aVar.f();
        this.f6800e = aVar.g();
        this.f6801f = aVar.g();
        this.f6802g = aVar.g();
        this.f6803h = aVar.g();
        this.f6804i = aVar.g();
        this.f6805j = aVar.g();
        this.f6806k = aVar.g();
        this.f6807l = aVar.g();
        this.f6808m = aVar.g();
        this.f6809n = aVar.g();
        this.f6810o = aVar.g();
        this.f6811p = aVar.g();
        this.f6812q = aVar.g();
        this.f6813r = aVar.e();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HIL_SENSOR - time_usec:" + this.f6799d + " xacc:" + this.f6800e + " yacc:" + this.f6801f + " zacc:" + this.f6802g + " xgyro:" + this.f6803h + " ygyro:" + this.f6804i + " zgyro:" + this.f6805j + " xmag:" + this.f6806k + " ymag:" + this.f6807l + " zmag:" + this.f6808m + " abs_pressure:" + this.f6809n + " diff_pressure:" + this.f6810o + " pressure_alt:" + this.f6811p + " temperature:" + this.f6812q + " fields_updated:" + this.f6813r + "";
    }
}
