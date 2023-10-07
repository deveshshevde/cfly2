package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_hwstatus extends MAVLinkMessage {
    private static final long serialVersionUID = 165;

    /* renamed from: d  reason: collision with root package name */
    public short f6412d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6413e;

    public msg_hwstatus() {
        this.f6280c = 165;
    }

    public msg_hwstatus(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 165;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6412d = aVar.d();
        this.f6413e = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HWSTATUS - Vcc:" + this.f6412d + " I2Cerr:" + this.f6413e + "";
    }
}
