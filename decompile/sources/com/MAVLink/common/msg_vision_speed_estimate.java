package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_vision_speed_estimate extends MAVLinkMessage {
    private static final long serialVersionUID = 103;

    /* renamed from: d  reason: collision with root package name */
    public long f7334d;

    /* renamed from: e  reason: collision with root package name */
    public float f7335e;

    /* renamed from: f  reason: collision with root package name */
    public float f7336f;

    /* renamed from: g  reason: collision with root package name */
    public float f7337g;

    public msg_vision_speed_estimate() {
        this.f6280c = 103;
    }

    public msg_vision_speed_estimate(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 103;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7334d = aVar.f();
        this.f7335e = aVar.g();
        this.f7336f = aVar.g();
        this.f7337g = aVar.g();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_VISION_SPEED_ESTIMATE - usec:" + this.f7334d + " x:" + this.f7335e + " y:" + this.f7336f + " z:" + this.f7337g + "";
    }
}
