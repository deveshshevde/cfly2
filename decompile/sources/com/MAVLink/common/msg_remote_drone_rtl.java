package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_remote_drone_rtl extends MAVLinkMessage {
    private static final long serialVersionUID = 9;

    /* renamed from: d  reason: collision with root package name */
    public byte f7131d;

    /* renamed from: e  reason: collision with root package name */
    public byte f7132e;

    public msg_remote_drone_rtl() {
        this.f6280c = 9;
    }

    public msg_remote_drone_rtl(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 9;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7131d = aVar.c();
        this.f7132e = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_REMOTE_DRONE_RTL - is_rtl:" + this.f7131d + " param2:" + this.f7132e + "";
    }
}
