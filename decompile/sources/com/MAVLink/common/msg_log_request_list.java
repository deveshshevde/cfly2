package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_log_request_list extends MAVLinkMessage {
    private static final long serialVersionUID = 117;

    /* renamed from: d  reason: collision with root package name */
    public short f6901d;

    /* renamed from: e  reason: collision with root package name */
    public short f6902e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6903f;

    /* renamed from: g  reason: collision with root package name */
    public byte f6904g;

    public msg_log_request_list() {
        this.f6280c = 117;
    }

    public msg_log_request_list(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 117;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6901d = aVar.d();
        this.f6902e = aVar.d();
        this.f6903f = aVar.c();
        this.f6904g = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOG_REQUEST_LIST - start:" + this.f6901d + " end:" + this.f6902e + " target_system:" + this.f6903f + " target_component:" + this.f6904g + "";
    }
}
