package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_heartbeat extends MAVLinkMessage {
    private static final long serialVersionUID = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f6732d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6733e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6734f;

    /* renamed from: g  reason: collision with root package name */
    public byte f6735g;

    /* renamed from: h  reason: collision with root package name */
    public byte f6736h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6737i;

    public msg_heartbeat() {
        this.f6280c = 0;
    }

    public msg_heartbeat(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 0;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 9;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 0;
        mAVLinkPacket.f6250f.a(this.f6732d);
        mAVLinkPacket.f6250f.b(this.f6733e);
        mAVLinkPacket.f6250f.b(this.f6734f);
        mAVLinkPacket.f6250f.b(this.f6735g);
        mAVLinkPacket.f6250f.b(this.f6736h);
        mAVLinkPacket.f6250f.b(this.f6737i);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f6732d = aVar.e();
        this.f6733e = aVar.c();
        this.f6734f = aVar.c();
        this.f6735g = aVar.c();
        this.f6736h = aVar.c();
        this.f6737i = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HEARTBEAT - custom_mode:" + this.f6732d + " type:" + this.f6733e + " autopilot:" + this.f6734f + " base_mode:" + this.f6735g + " system_status:" + this.f6736h + " mavlink_version:" + this.f6737i + "";
    }
}
