package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_mission_ack extends MAVLinkMessage {
    private static final long serialVersionUID = 47;

    /* renamed from: d  reason: collision with root package name */
    public byte f6922d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6923e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6924f;

    public msg_mission_ack() {
        this.f6280c = 47;
    }

    public msg_mission_ack(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 47;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6922d = aVar.c();
        this.f6923e = aVar.c();
        this.f6924f = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_ACK - target_system:" + this.f6922d + " target_component:" + this.f6923e + " type:" + this.f6924f + "";
    }
}
