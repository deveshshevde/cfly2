package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_mission_item_int extends MAVLinkMessage {
    private static final long serialVersionUID = 73;

    /* renamed from: d  reason: collision with root package name */
    public float f6946d;

    /* renamed from: e  reason: collision with root package name */
    public float f6947e;

    /* renamed from: f  reason: collision with root package name */
    public float f6948f;

    /* renamed from: g  reason: collision with root package name */
    public float f6949g;

    /* renamed from: h  reason: collision with root package name */
    public int f6950h;

    /* renamed from: i  reason: collision with root package name */
    public int f6951i;

    /* renamed from: j  reason: collision with root package name */
    public float f6952j;

    /* renamed from: k  reason: collision with root package name */
    public short f6953k;

    /* renamed from: l  reason: collision with root package name */
    public short f6954l;

    /* renamed from: m  reason: collision with root package name */
    public byte f6955m;

    /* renamed from: n  reason: collision with root package name */
    public byte f6956n;

    /* renamed from: o  reason: collision with root package name */
    public byte f6957o;

    /* renamed from: p  reason: collision with root package name */
    public byte f6958p;

    /* renamed from: q  reason: collision with root package name */
    public byte f6959q;

    public msg_mission_item_int() {
        this.f6280c = 73;
    }

    public msg_mission_item_int(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 73;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6946d = aVar.g();
        this.f6947e = aVar.g();
        this.f6948f = aVar.g();
        this.f6949g = aVar.g();
        this.f6950h = aVar.e();
        this.f6951i = aVar.e();
        this.f6952j = aVar.g();
        this.f6953k = aVar.d();
        this.f6954l = aVar.d();
        this.f6955m = aVar.c();
        this.f6956n = aVar.c();
        this.f6957o = aVar.c();
        this.f6958p = aVar.c();
        this.f6959q = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_ITEM_INT - param1:" + this.f6946d + " param2:" + this.f6947e + " param3:" + this.f6948f + " param4:" + this.f6949g + " x:" + this.f6950h + " y:" + this.f6951i + " z:" + this.f6952j + " seq:" + this.f6953k + " command:" + this.f6954l + " target_system:" + this.f6955m + " target_component:" + this.f6956n + " frame:" + this.f6957o + " current:" + this.f6958p + " autocontinue:" + this.f6959q + "";
    }
}
