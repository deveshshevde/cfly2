package com.MAVLink.common;

import android.content.Context;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_mission_item extends MAVLinkMessage {
    private static final long serialVersionUID = 39;

    /* renamed from: d  reason: collision with root package name */
    public float f6931d;

    /* renamed from: e  reason: collision with root package name */
    public float f6932e;

    /* renamed from: f  reason: collision with root package name */
    public float f6933f;

    /* renamed from: g  reason: collision with root package name */
    public float f6934g;

    /* renamed from: h  reason: collision with root package name */
    public float f6935h;

    /* renamed from: i  reason: collision with root package name */
    public float f6936i;

    /* renamed from: j  reason: collision with root package name */
    public float f6937j;

    /* renamed from: k  reason: collision with root package name */
    public short f6938k;

    /* renamed from: l  reason: collision with root package name */
    public short f6939l;

    /* renamed from: m  reason: collision with root package name */
    public byte f6940m;

    /* renamed from: n  reason: collision with root package name */
    public byte f6941n;

    /* renamed from: o  reason: collision with root package name */
    public byte f6942o;

    /* renamed from: p  reason: collision with root package name */
    public byte f6943p;

    /* renamed from: q  reason: collision with root package name */
    public byte f6944q;

    /* renamed from: r  reason: collision with root package name */
    public Context f6945r;

    public msg_mission_item(Context context) {
        this.f6280c = 39;
        this.f6945r = context;
    }

    public msg_mission_item(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 39;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 37;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 39;
        mAVLinkPacket.f6250f.a(this.f6931d);
        mAVLinkPacket.f6250f.a(this.f6932e);
        mAVLinkPacket.f6250f.a(this.f6933f);
        mAVLinkPacket.f6250f.a(this.f6934g);
        mAVLinkPacket.f6250f.a(this.f6935h);
        mAVLinkPacket.f6250f.a(this.f6936i);
        mAVLinkPacket.f6250f.a(this.f6937j);
        mAVLinkPacket.f6250f.a(this.f6938k);
        mAVLinkPacket.f6250f.a(this.f6939l);
        mAVLinkPacket.f6250f.b(this.f6940m);
        mAVLinkPacket.f6250f.b(this.f6941n);
        mAVLinkPacket.f6250f.b(this.f6942o);
        mAVLinkPacket.f6250f.b(this.f6943p);
        mAVLinkPacket.f6250f.b(this.f6944q);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f6931d = aVar.g();
        this.f6932e = aVar.g();
        this.f6933f = aVar.g();
        this.f6934g = aVar.g();
        this.f6935h = aVar.g();
        this.f6936i = aVar.g();
        this.f6937j = aVar.g();
        this.f6938k = aVar.d();
        this.f6939l = aVar.d();
        this.f6940m = aVar.c();
        this.f6941n = aVar.c();
        this.f6942o = aVar.c();
        this.f6943p = aVar.c();
        this.f6944q = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_ITEM - param1:" + this.f6931d + " param2:" + this.f6932e + " param3:" + this.f6933f + " param4:" + this.f6934g + " x:" + this.f6935h + " y:" + this.f6936i + " z:" + this.f6937j + " seq:" + this.f6938k + " command:" + this.f6939l + " target_system:" + this.f6940m + " target_component:" + this.f6941n + " frame:" + this.f6942o + " current:" + this.f6943p + " autocontinue:" + this.f6944q + "";
    }
}
