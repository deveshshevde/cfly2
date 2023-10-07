package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_mission_clear_all extends MAVLinkMessage {
    private static final long serialVersionUID = 45;

    /* renamed from: d  reason: collision with root package name */
    public byte f6925d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6926e;

    public msg_mission_clear_all() {
        this.f6280c = 45;
    }

    public msg_mission_clear_all(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 45;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 2;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 45;
        mAVLinkPacket.f6250f.b(this.f6925d);
        mAVLinkPacket.f6250f.b(this.f6926e);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f6925d = aVar.c();
        this.f6926e = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_CLEAR_ALL - target_system:" + this.f6925d + " target_component:" + this.f6926e + "";
    }
}
