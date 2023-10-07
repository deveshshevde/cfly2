package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_log_request_data extends MAVLinkMessage {
    private static final long serialVersionUID = 119;

    /* renamed from: d  reason: collision with root package name */
    public int f6894d;

    /* renamed from: e  reason: collision with root package name */
    public int f6895e;

    /* renamed from: f  reason: collision with root package name */
    public short f6896f;

    /* renamed from: g  reason: collision with root package name */
    public byte f6897g;

    /* renamed from: h  reason: collision with root package name */
    public byte f6898h;

    public msg_log_request_data() {
        this.f6280c = 119;
    }

    public msg_log_request_data(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 119;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6894d = aVar.e();
        this.f6895e = aVar.e();
        this.f6896f = aVar.d();
        this.f6897g = aVar.c();
        this.f6898h = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOG_REQUEST_DATA - ofs:" + this.f6894d + " count:" + this.f6895e + " id:" + this.f6896f + " target_system:" + this.f6897g + " target_component:" + this.f6898h + "";
    }
}
