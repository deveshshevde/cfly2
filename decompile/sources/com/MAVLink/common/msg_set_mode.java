package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_set_mode extends MAVLinkMessage {
    private static final long serialVersionUID = 11;

    /* renamed from: d  reason: collision with root package name */
    public int f7207d;

    /* renamed from: e  reason: collision with root package name */
    public byte f7208e;

    /* renamed from: f  reason: collision with root package name */
    public byte f7209f;

    public msg_set_mode() {
        this.f6280c = 11;
    }

    public msg_set_mode(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 11;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 6;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 11;
        mAVLinkPacket.f6250f.a(this.f7207d);
        mAVLinkPacket.f6250f.b(this.f7208e);
        mAVLinkPacket.f6250f.b(this.f7209f);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f7207d = aVar.e();
        this.f7208e = aVar.c();
        this.f7209f = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_MODE - custom_mode:" + this.f7207d + " target_system:" + this.f7208e + " base_mode:" + this.f7209f + "";
    }
}
