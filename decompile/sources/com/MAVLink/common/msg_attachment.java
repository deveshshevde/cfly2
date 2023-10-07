package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_attachment extends MAVLinkMessage {
    private static final long serialVersionUID = 10;

    /* renamed from: d  reason: collision with root package name */
    public int f6495d;

    /* renamed from: e  reason: collision with root package name */
    public int f6496e;

    /* renamed from: f  reason: collision with root package name */
    public int f6497f;

    /* renamed from: g  reason: collision with root package name */
    public int f6498g;

    /* renamed from: h  reason: collision with root package name */
    public int f6499h;

    /* renamed from: i  reason: collision with root package name */
    public short f6500i;

    /* renamed from: j  reason: collision with root package name */
    public short f6501j;

    /* renamed from: k  reason: collision with root package name */
    public byte f6502k;

    /* renamed from: l  reason: collision with root package name */
    public byte f6503l;

    public msg_attachment() {
        this.f6280c = 10;
    }

    public msg_attachment(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 10;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 10;
        mAVLinkPacket.f6245a = 26;
        mAVLinkPacket.f6250f.a(this.f6495d);
        mAVLinkPacket.f6250f.a(this.f6496e);
        mAVLinkPacket.f6250f.a(this.f6497f);
        mAVLinkPacket.f6250f.a(this.f6498g);
        mAVLinkPacket.f6250f.a(this.f6499h);
        mAVLinkPacket.f6250f.a(this.f6500i);
        mAVLinkPacket.f6250f.a(this.f6501j);
        mAVLinkPacket.f6250f.b(this.f6502k);
        mAVLinkPacket.f6250f.b(this.f6503l);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f6495d = aVar.e();
        this.f6496e = aVar.e();
        this.f6497f = aVar.e();
        this.f6498g = aVar.e();
        this.f6499h = aVar.e();
        this.f6500i = aVar.d();
        this.f6501j = aVar.d();
        this.f6502k = aVar.c();
        this.f6503l = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ATTACHMENT - lat:" + this.f6495d + " lng:" + this.f6496e + " id:" + this.f6497f + " time:" + this.f6498g + " version:" + this.f6499h + " charge:" + this.f6500i + " temp:" + this.f6501j + " type:" + this.f6502k + " mode:" + this.f6503l + "";
    }
}
