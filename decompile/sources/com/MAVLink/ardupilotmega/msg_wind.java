package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_wind extends MAVLinkMessage {
    private static final long serialVersionUID = 168;

    /* renamed from: d  reason: collision with root package name */
    public float f6492d;

    /* renamed from: e  reason: collision with root package name */
    public float f6493e;

    /* renamed from: f  reason: collision with root package name */
    public float f6494f;

    public msg_wind() {
        this.f6280c = 168;
    }

    public msg_wind(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 168;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6492d = aVar.g();
        this.f6493e = aVar.g();
        this.f6494f = aVar.g();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_WIND - direction:" + this.f6492d + " speed:" + this.f6493e + " speed_z:" + this.f6494f + "";
    }
}
