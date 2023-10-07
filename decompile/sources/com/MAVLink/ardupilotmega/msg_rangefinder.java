package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_rangefinder extends MAVLinkMessage {
    private static final long serialVersionUID = 173;

    /* renamed from: d  reason: collision with root package name */
    public float f6462d;

    /* renamed from: e  reason: collision with root package name */
    public float f6463e;

    public msg_rangefinder() {
        this.f6280c = 173;
    }

    public msg_rangefinder(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 173;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6462d = aVar.g();
        this.f6463e = aVar.g();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RANGEFINDER - distance:" + this.f6462d + " voltage:" + this.f6463e + "";
    }
}
