package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_safety_allowed_area extends MAVLinkMessage {
    private static final long serialVersionUID = 55;

    /* renamed from: d  reason: collision with root package name */
    public float f7138d;

    /* renamed from: e  reason: collision with root package name */
    public float f7139e;

    /* renamed from: f  reason: collision with root package name */
    public float f7140f;

    /* renamed from: g  reason: collision with root package name */
    public float f7141g;

    /* renamed from: h  reason: collision with root package name */
    public float f7142h;

    /* renamed from: i  reason: collision with root package name */
    public float f7143i;

    /* renamed from: j  reason: collision with root package name */
    public byte f7144j;

    public msg_safety_allowed_area() {
        this.f6280c = 55;
    }

    public msg_safety_allowed_area(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 55;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7138d = aVar.g();
        this.f7139e = aVar.g();
        this.f7140f = aVar.g();
        this.f7141g = aVar.g();
        this.f7142h = aVar.g();
        this.f7143i = aVar.g();
        this.f7144j = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SAFETY_ALLOWED_AREA - p1x:" + this.f7138d + " p1y:" + this.f7139e + " p1z:" + this.f7140f + " p2x:" + this.f7141g + " p2y:" + this.f7142h + " p2z:" + this.f7143i + " frame:" + this.f7144j + "";
    }
}
