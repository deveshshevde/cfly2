package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_mission_request extends MAVLinkMessage {
    private static final long serialVersionUID = 40;

    /* renamed from: d  reason: collision with root package name */
    public short f6961d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6962e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6963f;

    public msg_mission_request() {
        this.f6280c = 40;
    }

    public msg_mission_request(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 40;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6961d = aVar.d();
        this.f6962e = aVar.c();
        this.f6963f = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_REQUEST - seq:" + this.f6961d + " target_system:" + this.f6962e + " target_component:" + this.f6963f + "";
    }
}
