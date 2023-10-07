package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_mission_request_partial_list extends MAVLinkMessage {
    private static final long serialVersionUID = 37;

    /* renamed from: d  reason: collision with root package name */
    public short f6966d;

    /* renamed from: e  reason: collision with root package name */
    public short f6967e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6968f;

    /* renamed from: g  reason: collision with root package name */
    public byte f6969g;

    public msg_mission_request_partial_list() {
        this.f6280c = 37;
    }

    public msg_mission_request_partial_list(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 37;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6966d = aVar.d();
        this.f6967e = aVar.d();
        this.f6968f = aVar.c();
        this.f6969g = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_REQUEST_PARTIAL_LIST - start_index:" + this.f6966d + " end_index:" + this.f6967e + " target_system:" + this.f6968f + " target_component:" + this.f6969g + "";
    }
}
