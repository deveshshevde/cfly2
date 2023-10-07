package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_command_int extends MAVLinkMessage {
    private static final long serialVersionUID = 75;

    /* renamed from: d  reason: collision with root package name */
    public float f6566d;

    /* renamed from: e  reason: collision with root package name */
    public float f6567e;

    /* renamed from: f  reason: collision with root package name */
    public float f6568f;

    /* renamed from: g  reason: collision with root package name */
    public float f6569g;

    /* renamed from: h  reason: collision with root package name */
    public int f6570h;

    /* renamed from: i  reason: collision with root package name */
    public int f6571i;

    /* renamed from: j  reason: collision with root package name */
    public float f6572j;

    /* renamed from: k  reason: collision with root package name */
    public short f6573k;

    /* renamed from: l  reason: collision with root package name */
    public byte f6574l;

    /* renamed from: m  reason: collision with root package name */
    public byte f6575m;

    /* renamed from: n  reason: collision with root package name */
    public byte f6576n;

    /* renamed from: o  reason: collision with root package name */
    public byte f6577o;

    /* renamed from: p  reason: collision with root package name */
    public byte f6578p;

    public msg_command_int() {
        this.f6280c = 75;
    }

    public msg_command_int(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 75;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6566d = aVar.g();
        this.f6567e = aVar.g();
        this.f6568f = aVar.g();
        this.f6569g = aVar.g();
        this.f6570h = aVar.e();
        this.f6571i = aVar.e();
        this.f6572j = aVar.g();
        this.f6573k = aVar.d();
        this.f6574l = aVar.c();
        this.f6575m = aVar.c();
        this.f6576n = aVar.c();
        this.f6577o = aVar.c();
        this.f6578p = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_COMMAND_INT - param1:" + this.f6566d + " param2:" + this.f6567e + " param3:" + this.f6568f + " param4:" + this.f6569g + " x:" + this.f6570h + " y:" + this.f6571i + " z:" + this.f6572j + " command:" + this.f6573k + " target_system:" + this.f6574l + " target_component:" + this.f6575m + " frame:" + this.f6576n + " current:" + this.f6577o + " autocontinue:" + this.f6578p + "";
    }
}
