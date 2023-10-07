package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_mission_request_list extends MAVLinkMessage {
    private static final long serialVersionUID = 43;

    /* renamed from: d  reason: collision with root package name */
    public byte f6964d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6965e;

    public msg_mission_request_list() {
        this.f6280c = 43;
    }

    public msg_mission_request_list(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 43;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 2;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 43;
        mAVLinkPacket.f6250f.b(this.f6964d);
        mAVLinkPacket.f6250f.b(this.f6965e);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f6964d = aVar.c();
        this.f6965e = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_REQUEST_LIST - target_system:" + this.f6964d + " target_component:" + this.f6965e + "";
    }
}
