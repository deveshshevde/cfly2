package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_mission_count extends MAVLinkMessage {
    private static final long serialVersionUID = 44;

    /* renamed from: d  reason: collision with root package name */
    public short f6927d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6928e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6929f;

    public msg_mission_count() {
        this.f6280c = 44;
    }

    public msg_mission_count(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 44;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 4;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 44;
        mAVLinkPacket.f6250f.a(this.f6927d);
        mAVLinkPacket.f6250f.b(this.f6928e);
        mAVLinkPacket.f6250f.b(this.f6929f);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f6927d = aVar.d();
        this.f6928e = aVar.c();
        this.f6929f = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_COUNT - count:" + this.f6927d + " target_system:" + this.f6928e + " target_component:" + this.f6929f + "";
    }
}
