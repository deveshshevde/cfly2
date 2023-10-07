package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_command_ack extends MAVLinkMessage {
    private static final long serialVersionUID = 77;

    /* renamed from: d  reason: collision with root package name */
    public short f6564d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6565e;

    public msg_command_ack() {
        this.f6280c = 77;
    }

    public msg_command_ack(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 77;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 3;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 77;
        mAVLinkPacket.f6250f.a(this.f6564d);
        mAVLinkPacket.f6250f.b(this.f6565e);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f6564d = aVar.d();
        this.f6565e = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_COMMAND_ACK - command:" + this.f6564d + " result:" + this.f6565e + "";
    }
}
