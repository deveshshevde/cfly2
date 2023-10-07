package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_attachment2 extends MAVLinkMessage {
    private static final long serialVersionUID = 15;

    /* renamed from: d  reason: collision with root package name */
    public int f6504d;

    /* renamed from: e  reason: collision with root package name */
    public int f6505e;

    /* renamed from: f  reason: collision with root package name */
    public int f6506f;

    /* renamed from: g  reason: collision with root package name */
    public int f6507g;

    /* renamed from: h  reason: collision with root package name */
    public int f6508h;

    /* renamed from: i  reason: collision with root package name */
    public int f6509i;

    /* renamed from: j  reason: collision with root package name */
    public int f6510j;

    /* renamed from: k  reason: collision with root package name */
    public int f6511k;

    /* renamed from: l  reason: collision with root package name */
    public int f6512l;

    /* renamed from: m  reason: collision with root package name */
    public int f6513m;

    /* renamed from: n  reason: collision with root package name */
    public byte f6514n;

    /* renamed from: o  reason: collision with root package name */
    public byte f6515o;

    public msg_attachment2() {
        this.f6280c = 15;
    }

    public msg_attachment2(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 15;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6245a = 42;
        mAVLinkPacket.f6249e = 15;
        mAVLinkPacket.f6250f.a(this.f6504d);
        mAVLinkPacket.f6250f.a(this.f6505e);
        mAVLinkPacket.f6250f.a(this.f6506f);
        mAVLinkPacket.f6250f.a(this.f6507g);
        mAVLinkPacket.f6250f.a(this.f6508h);
        mAVLinkPacket.f6250f.a(this.f6509i);
        mAVLinkPacket.f6250f.a(this.f6510j);
        mAVLinkPacket.f6250f.a(this.f6511k);
        mAVLinkPacket.f6250f.a(this.f6512l);
        mAVLinkPacket.f6250f.a(this.f6513m);
        mAVLinkPacket.f6250f.b(this.f6514n);
        mAVLinkPacket.f6250f.b(this.f6515o);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f6504d = aVar.e();
        this.f6505e = aVar.e();
        this.f6506f = aVar.e();
        this.f6507g = aVar.e();
        this.f6508h = aVar.e();
        this.f6509i = aVar.e();
        this.f6510j = aVar.e();
        this.f6511k = aVar.e();
        this.f6512l = aVar.e();
        this.f6513m = aVar.e();
        this.f6514n = aVar.c();
        this.f6515o = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ATTACHMENT2 - id1:" + this.f6504d + " id2:" + this.f6505e + " id3:" + this.f6506f + " time:" + this.f6507g + " charge:" + this.f6508h + " temp:" + this.f6509i + " version:" + this.f6510j + " dev_type:" + this.f6511k + " extra1:" + this.f6512l + " extra2:" + this.f6513m + " type:" + this.f6514n + " mode:" + this.f6515o + "";
    }
}
