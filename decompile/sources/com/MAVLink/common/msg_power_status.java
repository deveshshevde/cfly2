package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_power_status extends MAVLinkMessage {
    private static final long serialVersionUID = 125;

    /* renamed from: d  reason: collision with root package name */
    public short f7049d;

    /* renamed from: e  reason: collision with root package name */
    public short f7050e;

    /* renamed from: f  reason: collision with root package name */
    public short f7051f;

    public msg_power_status() {
        this.f6280c = 125;
    }

    public msg_power_status(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 125;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7049d = aVar.d();
        this.f7050e = aVar.d();
        this.f7051f = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_POWER_STATUS - Vcc:" + this.f7049d + " Vservo:" + this.f7050e + " flags:" + this.f7051f + "";
    }
}
