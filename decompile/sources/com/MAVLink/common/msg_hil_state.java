package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_hil_state extends MAVLinkMessage {
    private static final long serialVersionUID = 90;

    /* renamed from: d  reason: collision with root package name */
    public long f6814d;

    /* renamed from: e  reason: collision with root package name */
    public float f6815e;

    /* renamed from: f  reason: collision with root package name */
    public float f6816f;

    /* renamed from: g  reason: collision with root package name */
    public float f6817g;

    /* renamed from: h  reason: collision with root package name */
    public float f6818h;

    /* renamed from: i  reason: collision with root package name */
    public float f6819i;

    /* renamed from: j  reason: collision with root package name */
    public float f6820j;

    /* renamed from: k  reason: collision with root package name */
    public int f6821k;

    /* renamed from: l  reason: collision with root package name */
    public int f6822l;

    /* renamed from: m  reason: collision with root package name */
    public int f6823m;

    /* renamed from: n  reason: collision with root package name */
    public short f6824n;

    /* renamed from: o  reason: collision with root package name */
    public short f6825o;

    /* renamed from: p  reason: collision with root package name */
    public short f6826p;

    /* renamed from: q  reason: collision with root package name */
    public short f6827q;

    /* renamed from: r  reason: collision with root package name */
    public short f6828r;

    /* renamed from: s  reason: collision with root package name */
    public short f6829s;

    public msg_hil_state() {
        this.f6280c = 90;
    }

    public msg_hil_state(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 90;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6814d = aVar.f();
        this.f6815e = aVar.g();
        this.f6816f = aVar.g();
        this.f6817g = aVar.g();
        this.f6818h = aVar.g();
        this.f6819i = aVar.g();
        this.f6820j = aVar.g();
        this.f6821k = aVar.e();
        this.f6822l = aVar.e();
        this.f6823m = aVar.e();
        this.f6824n = aVar.d();
        this.f6825o = aVar.d();
        this.f6826p = aVar.d();
        this.f6827q = aVar.d();
        this.f6828r = aVar.d();
        this.f6829s = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HIL_STATE - time_usec:" + this.f6814d + " roll:" + this.f6815e + " pitch:" + this.f6816f + " yaw:" + this.f6817g + " rollspeed:" + this.f6818h + " pitchspeed:" + this.f6819i + " yawspeed:" + this.f6820j + " lat:" + this.f6821k + " lon:" + this.f6822l + " alt:" + this.f6823m + " vx:" + this.f6824n + " vy:" + this.f6825o + " vz:" + this.f6826p + " xacc:" + this.f6827q + " yacc:" + this.f6828r + " zacc:" + this.f6829s + "";
    }
}
