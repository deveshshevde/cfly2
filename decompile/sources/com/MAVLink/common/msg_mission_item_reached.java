package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_mission_item_reached extends MAVLinkMessage {
    private static final long serialVersionUID = 46;

    /* renamed from: d  reason: collision with root package name */
    public short f6960d;

    public msg_mission_item_reached() {
        this.f6280c = 46;
    }

    public msg_mission_item_reached(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 46;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6960d = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_ITEM_REACHED - seq:" + this.f6960d + "";
    }
}
