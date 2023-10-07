package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_rally_fetch_point extends MAVLinkMessage {
    private static final long serialVersionUID = 176;

    /* renamed from: d  reason: collision with root package name */
    public byte f6449d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6450e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6451f;

    public msg_rally_fetch_point() {
        this.f6280c = 176;
    }

    public msg_rally_fetch_point(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 176;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6449d = aVar.c();
        this.f6450e = aVar.c();
        this.f6451f = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RALLY_FETCH_POINT - target_system:" + this.f6449d + " target_component:" + this.f6450e + " idx:" + this.f6451f + "";
    }
}
