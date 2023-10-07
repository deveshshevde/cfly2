package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_command_long extends MAVLinkMessage {
    private static final long serialVersionUID = 76;

    /* renamed from: d  reason: collision with root package name */
    public float f6579d;

    /* renamed from: e  reason: collision with root package name */
    public float f6580e;

    /* renamed from: f  reason: collision with root package name */
    public float f6581f;

    /* renamed from: g  reason: collision with root package name */
    public float f6582g;

    /* renamed from: h  reason: collision with root package name */
    public float f6583h;

    /* renamed from: i  reason: collision with root package name */
    public float f6584i;

    /* renamed from: j  reason: collision with root package name */
    public float f6585j;

    /* renamed from: k  reason: collision with root package name */
    public short f6586k;

    /* renamed from: l  reason: collision with root package name */
    public byte f6587l;

    /* renamed from: m  reason: collision with root package name */
    public byte f6588m;

    /* renamed from: n  reason: collision with root package name */
    public byte f6589n;

    public msg_command_long() {
        this.f6280c = 76;
    }

    public msg_command_long(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 76;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 33;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 76;
        mAVLinkPacket.f6250f.a(this.f6579d);
        mAVLinkPacket.f6250f.a(this.f6580e);
        mAVLinkPacket.f6250f.a(this.f6581f);
        mAVLinkPacket.f6250f.a(this.f6582g);
        mAVLinkPacket.f6250f.a(this.f6583h);
        mAVLinkPacket.f6250f.a(this.f6584i);
        mAVLinkPacket.f6250f.a(this.f6585j);
        mAVLinkPacket.f6250f.a(this.f6586k);
        mAVLinkPacket.f6250f.b(this.f6587l);
        mAVLinkPacket.f6250f.b(this.f6588m);
        mAVLinkPacket.f6250f.b(this.f6589n);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f6579d = aVar.g();
        this.f6580e = aVar.g();
        this.f6581f = aVar.g();
        this.f6582g = aVar.g();
        this.f6583h = aVar.g();
        this.f6584i = aVar.g();
        this.f6585j = aVar.g();
        this.f6586k = aVar.d();
        this.f6587l = aVar.c();
        this.f6588m = aVar.c();
        this.f6589n = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_COMMAND_LONG - param1:" + this.f6579d + " param2:" + this.f6580e + " param3:" + this.f6581f + " param4:" + this.f6582g + " param5:" + this.f6583h + " param6:" + this.f6584i + " param7:" + this.f6585j + " command:" + this.f6586k + " target_system:" + this.f6587l + " target_component:" + this.f6588m + " confirmation:" + this.f6589n + "";
    }
}
