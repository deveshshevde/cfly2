package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_manual_control extends MAVLinkMessage {
    private static final long serialVersionUID = 69;

    /* renamed from: d  reason: collision with root package name */
    public short f6905d;

    /* renamed from: e  reason: collision with root package name */
    public short f6906e;

    /* renamed from: f  reason: collision with root package name */
    public short f6907f;

    /* renamed from: g  reason: collision with root package name */
    public short f6908g;

    /* renamed from: h  reason: collision with root package name */
    public short f6909h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6910i;

    public msg_manual_control() {
        this.f6280c = 69;
    }

    public msg_manual_control(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 69;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6905d = aVar.d();
        this.f6906e = aVar.d();
        this.f6907f = aVar.d();
        this.f6908g = aVar.d();
        this.f6909h = aVar.d();
        this.f6910i = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MANUAL_CONTROL - x:" + this.f6905d + " y:" + this.f6906e + " z:" + this.f6907f + " r:" + this.f6908g + " buttons:" + this.f6909h + " target:" + this.f6910i + "";
    }
}
