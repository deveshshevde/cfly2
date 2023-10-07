package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_log_request_end extends MAVLinkMessage {
    private static final long serialVersionUID = 122;

    /* renamed from: d  reason: collision with root package name */
    public byte f6899d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6900e;

    public msg_log_request_end() {
        this.f6280c = 122;
    }

    public msg_log_request_end(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 122;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6899d = aVar.c();
        this.f6900e = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOG_REQUEST_END - target_system:" + this.f6899d + " target_component:" + this.f6900e + "";
    }
}
