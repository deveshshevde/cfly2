package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_debug extends MAVLinkMessage {
    private static final long serialVersionUID = 254;

    /* renamed from: d  reason: collision with root package name */
    public int f6617d;

    /* renamed from: e  reason: collision with root package name */
    public float f6618e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6619f;

    public msg_debug() {
        this.f6280c = 254;
    }

    public msg_debug(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 254;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6617d = aVar.e();
        this.f6618e = aVar.g();
        this.f6619f = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DEBUG - time_boot_ms:" + this.f6617d + " value:" + this.f6618e + " ind:" + this.f6619f + "";
    }
}
