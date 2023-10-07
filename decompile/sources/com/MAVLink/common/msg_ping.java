package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_ping extends MAVLinkMessage {
    private static final long serialVersionUID = 4;

    /* renamed from: d  reason: collision with root package name */
    public long f7021d;

    /* renamed from: e  reason: collision with root package name */
    public int f7022e;

    /* renamed from: f  reason: collision with root package name */
    public byte f7023f;

    /* renamed from: g  reason: collision with root package name */
    public byte f7024g;

    public msg_ping() {
        this.f6280c = 4;
    }

    public msg_ping(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 4;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7021d = aVar.f();
        this.f7022e = aVar.e();
        this.f7023f = aVar.c();
        this.f7024g = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_PING - time_usec:" + this.f7021d + " seq:" + this.f7022e + " target_system:" + this.f7023f + " target_component:" + this.f7024g + "";
    }
}
