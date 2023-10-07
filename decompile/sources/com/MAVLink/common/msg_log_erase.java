package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_log_erase extends MAVLinkMessage {
    private static final long serialVersionUID = 121;

    /* renamed from: d  reason: collision with root package name */
    public byte f6892d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6893e;

    public msg_log_erase() {
        this.f6280c = 121;
    }

    public msg_log_erase(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 121;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6892d = aVar.c();
        this.f6893e = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOG_ERASE - target_system:" + this.f6892d + " target_component:" + this.f6893e + "";
    }
}
