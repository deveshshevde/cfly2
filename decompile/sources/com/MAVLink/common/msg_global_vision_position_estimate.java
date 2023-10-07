package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_global_vision_position_estimate extends MAVLinkMessage {
    private static final long serialVersionUID = 101;

    /* renamed from: d  reason: collision with root package name */
    public long f6664d;

    /* renamed from: e  reason: collision with root package name */
    public float f6665e;

    /* renamed from: f  reason: collision with root package name */
    public float f6666f;

    /* renamed from: g  reason: collision with root package name */
    public float f6667g;

    /* renamed from: h  reason: collision with root package name */
    public float f6668h;

    /* renamed from: i  reason: collision with root package name */
    public float f6669i;

    /* renamed from: j  reason: collision with root package name */
    public float f6670j;

    public msg_global_vision_position_estimate() {
        this.f6280c = 101;
    }

    public msg_global_vision_position_estimate(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 101;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6664d = aVar.f();
        this.f6665e = aVar.g();
        this.f6666f = aVar.g();
        this.f6667g = aVar.g();
        this.f6668h = aVar.g();
        this.f6669i = aVar.g();
        this.f6670j = aVar.g();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GLOBAL_VISION_POSITION_ESTIMATE - usec:" + this.f6664d + " x:" + this.f6665e + " y:" + this.f6666f + " z:" + this.f6667g + " roll:" + this.f6668h + " pitch:" + this.f6669i + " yaw:" + this.f6670j + "";
    }
}
