package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_compassmot_status extends MAVLinkMessage {
    private static final long serialVersionUID = 177;

    /* renamed from: d  reason: collision with root package name */
    public float f6360d;

    /* renamed from: e  reason: collision with root package name */
    public float f6361e;

    /* renamed from: f  reason: collision with root package name */
    public float f6362f;

    /* renamed from: g  reason: collision with root package name */
    public float f6363g;

    /* renamed from: h  reason: collision with root package name */
    public short f6364h;

    /* renamed from: i  reason: collision with root package name */
    public short f6365i;

    public msg_compassmot_status() {
        this.f6280c = 177;
    }

    public msg_compassmot_status(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 177;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6360d = aVar.g();
        this.f6361e = aVar.g();
        this.f6362f = aVar.g();
        this.f6363g = aVar.g();
        this.f6364h = aVar.d();
        this.f6365i = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_COMPASSMOT_STATUS - current:" + this.f6360d + " CompensationX:" + this.f6361e + " CompensationY:" + this.f6362f + " CompensationZ:" + this.f6363g + " throttle:" + this.f6364h + " interference:" + this.f6365i + "";
    }
}
