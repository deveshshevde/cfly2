package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_sim_state extends MAVLinkMessage {
    private static final long serialVersionUID = 108;

    /* renamed from: d  reason: collision with root package name */
    public float f7238d;

    /* renamed from: e  reason: collision with root package name */
    public float f7239e;

    /* renamed from: f  reason: collision with root package name */
    public float f7240f;

    /* renamed from: g  reason: collision with root package name */
    public float f7241g;

    /* renamed from: h  reason: collision with root package name */
    public float f7242h;

    /* renamed from: i  reason: collision with root package name */
    public float f7243i;

    /* renamed from: j  reason: collision with root package name */
    public float f7244j;

    /* renamed from: k  reason: collision with root package name */
    public float f7245k;

    /* renamed from: l  reason: collision with root package name */
    public float f7246l;

    /* renamed from: m  reason: collision with root package name */
    public float f7247m;

    /* renamed from: n  reason: collision with root package name */
    public float f7248n;

    /* renamed from: o  reason: collision with root package name */
    public float f7249o;

    /* renamed from: p  reason: collision with root package name */
    public float f7250p;

    /* renamed from: q  reason: collision with root package name */
    public float f7251q;

    /* renamed from: r  reason: collision with root package name */
    public float f7252r;

    /* renamed from: s  reason: collision with root package name */
    public float f7253s;

    /* renamed from: t  reason: collision with root package name */
    public float f7254t;

    /* renamed from: u  reason: collision with root package name */
    public float f7255u;

    /* renamed from: v  reason: collision with root package name */
    public float f7256v;

    /* renamed from: w  reason: collision with root package name */
    public float f7257w;

    /* renamed from: x  reason: collision with root package name */
    public float f7258x;

    public msg_sim_state() {
        this.f6280c = 108;
    }

    public msg_sim_state(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 108;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7238d = aVar.g();
        this.f7239e = aVar.g();
        this.f7240f = aVar.g();
        this.f7241g = aVar.g();
        this.f7242h = aVar.g();
        this.f7243i = aVar.g();
        this.f7244j = aVar.g();
        this.f7245k = aVar.g();
        this.f7246l = aVar.g();
        this.f7247m = aVar.g();
        this.f7248n = aVar.g();
        this.f7249o = aVar.g();
        this.f7250p = aVar.g();
        this.f7251q = aVar.g();
        this.f7252r = aVar.g();
        this.f7253s = aVar.g();
        this.f7254t = aVar.g();
        this.f7255u = aVar.g();
        this.f7256v = aVar.g();
        this.f7257w = aVar.g();
        this.f7258x = aVar.g();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SIM_STATE - q1:" + this.f7238d + " q2:" + this.f7239e + " q3:" + this.f7240f + " q4:" + this.f7241g + " roll:" + this.f7242h + " pitch:" + this.f7243i + " yaw:" + this.f7244j + " xacc:" + this.f7245k + " yacc:" + this.f7246l + " zacc:" + this.f7247m + " xgyro:" + this.f7248n + " ygyro:" + this.f7249o + " zgyro:" + this.f7250p + " lat:" + this.f7251q + " lon:" + this.f7252r + " alt:" + this.f7253s + " std_dev_horz:" + this.f7254t + " std_dev_vert:" + this.f7255u + " vn:" + this.f7256v + " ve:" + this.f7257w + " vd:" + this.f7258x + "";
    }
}
