package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_mission_current extends MAVLinkMessage {
    private static final long serialVersionUID = 42;

    /* renamed from: d  reason: collision with root package name */
    public short f6930d;

    public msg_mission_current() {
        this.f6280c = 42;
    }

    public msg_mission_current(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 42;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6930d = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_CURRENT - seq:" + this.f6930d + "";
    }
}
