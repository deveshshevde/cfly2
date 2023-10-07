package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_vision_position_estimate extends MAVLinkMessage {
    private static final long serialVersionUID = 102;

    /* renamed from: d  reason: collision with root package name */
    public long f7327d;

    /* renamed from: e  reason: collision with root package name */
    public float f7328e;

    /* renamed from: f  reason: collision with root package name */
    public float f7329f;

    /* renamed from: g  reason: collision with root package name */
    public float f7330g;

    /* renamed from: h  reason: collision with root package name */
    public float f7331h;

    /* renamed from: i  reason: collision with root package name */
    public float f7332i;

    /* renamed from: j  reason: collision with root package name */
    public float f7333j;

    public msg_vision_position_estimate() {
        this.f6280c = 102;
    }

    public msg_vision_position_estimate(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 102;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7327d = aVar.f();
        this.f7328e = aVar.g();
        this.f7329f = aVar.g();
        this.f7330g = aVar.g();
        this.f7331h = aVar.g();
        this.f7332i = aVar.g();
        this.f7333j = aVar.g();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_VISION_POSITION_ESTIMATE - usec:" + this.f7327d + " x:" + this.f7328e + " y:" + this.f7329f + " z:" + this.f7330g + " roll:" + this.f7331h + " pitch:" + this.f7332i + " yaw:" + this.f7333j + "";
    }
}
