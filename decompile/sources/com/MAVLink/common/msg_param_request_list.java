package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_param_request_list extends MAVLinkMessage {
    private static final long serialVersionUID = 21;

    /* renamed from: d  reason: collision with root package name */
    public byte f7005d;

    /* renamed from: e  reason: collision with root package name */
    public byte f7006e;

    public msg_param_request_list() {
        this.f6280c = 21;
    }

    public msg_param_request_list(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 21;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 2;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 21;
        mAVLinkPacket.f6250f.b(this.f7005d);
        mAVLinkPacket.f6250f.b(this.f7006e);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f7005d = aVar.c();
        this.f7006e = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_PARAM_REQUEST_LIST - target_system:" + this.f7005d + " target_component:" + this.f7006e + "";
    }
}
