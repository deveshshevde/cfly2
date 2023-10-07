package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_mission_set_current extends MAVLinkMessage {
    private static final long serialVersionUID = 41;

    /* renamed from: d  reason: collision with root package name */
    public short f6970d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6971e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6972f;

    public msg_mission_set_current() {
        this.f6280c = 41;
    }

    public msg_mission_set_current(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 41;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 4;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 41;
        mAVLinkPacket.f6250f.a(this.f6970d);
        mAVLinkPacket.f6250f.b(this.f6971e);
        mAVLinkPacket.f6250f.b(this.f6972f);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f6970d = aVar.d();
        this.f6971e = aVar.c();
        this.f6972f = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_SET_CURRENT - seq:" + this.f6970d + " target_system:" + this.f6971e + " target_component:" + this.f6972f + "";
    }
}
