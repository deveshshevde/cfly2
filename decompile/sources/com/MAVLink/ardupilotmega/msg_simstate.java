package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_simstate extends MAVLinkMessage {
    private static final long serialVersionUID = 164;

    /* renamed from: d  reason: collision with root package name */
    public float f6481d;

    /* renamed from: e  reason: collision with root package name */
    public float f6482e;

    /* renamed from: f  reason: collision with root package name */
    public float f6483f;

    /* renamed from: g  reason: collision with root package name */
    public float f6484g;

    /* renamed from: h  reason: collision with root package name */
    public float f6485h;

    /* renamed from: i  reason: collision with root package name */
    public float f6486i;

    /* renamed from: j  reason: collision with root package name */
    public float f6487j;

    /* renamed from: k  reason: collision with root package name */
    public float f6488k;

    /* renamed from: l  reason: collision with root package name */
    public float f6489l;

    /* renamed from: m  reason: collision with root package name */
    public int f6490m;

    /* renamed from: n  reason: collision with root package name */
    public int f6491n;

    public msg_simstate() {
        this.f6280c = 164;
    }

    public msg_simstate(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 164;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6481d = aVar.g();
        this.f6482e = aVar.g();
        this.f6483f = aVar.g();
        this.f6484g = aVar.g();
        this.f6485h = aVar.g();
        this.f6486i = aVar.g();
        this.f6487j = aVar.g();
        this.f6488k = aVar.g();
        this.f6489l = aVar.g();
        this.f6490m = aVar.e();
        this.f6491n = aVar.e();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SIMSTATE - roll:" + this.f6481d + " pitch:" + this.f6482e + " yaw:" + this.f6483f + " xacc:" + this.f6484g + " yacc:" + this.f6485h + " zacc:" + this.f6486i + " xgyro:" + this.f6487j + " ygyro:" + this.f6488k + " zgyro:" + this.f6489l + " lat:" + this.f6490m + " lng:" + this.f6491n + "";
    }
}
