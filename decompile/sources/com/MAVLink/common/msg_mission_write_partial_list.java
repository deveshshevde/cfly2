package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_mission_write_partial_list extends MAVLinkMessage {
    private static final long serialVersionUID = 38;

    /* renamed from: d  reason: collision with root package name */
    public short f6973d;

    /* renamed from: e  reason: collision with root package name */
    public short f6974e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6975f;

    /* renamed from: g  reason: collision with root package name */
    public byte f6976g;

    public msg_mission_write_partial_list() {
        this.f6280c = 38;
    }

    public msg_mission_write_partial_list(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 38;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6973d = aVar.d();
        this.f6974e = aVar.d();
        this.f6975f = aVar.c();
        this.f6976g = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_WRITE_PARTIAL_LIST - start_index:" + this.f6973d + " end_index:" + this.f6974e + " target_system:" + this.f6975f + " target_component:" + this.f6976g + "";
    }
}
