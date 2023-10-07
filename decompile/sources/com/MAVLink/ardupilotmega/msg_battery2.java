package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_battery2 extends MAVLinkMessage {
    private static final long serialVersionUID = 181;

    /* renamed from: d  reason: collision with root package name */
    public short f6336d;

    /* renamed from: e  reason: collision with root package name */
    public short f6337e;

    public msg_battery2() {
        this.f6280c = 181;
    }

    public msg_battery2(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 181;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6336d = aVar.d();
        this.f6337e = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_BATTERY2 - voltage:" + this.f6336d + " current_battery:" + this.f6337e + "";
    }
}
