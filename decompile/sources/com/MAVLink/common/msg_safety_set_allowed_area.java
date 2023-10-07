package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_safety_set_allowed_area extends MAVLinkMessage {
    private static final long serialVersionUID = 54;

    /* renamed from: d  reason: collision with root package name */
    public float f7145d;

    /* renamed from: e  reason: collision with root package name */
    public float f7146e;

    /* renamed from: f  reason: collision with root package name */
    public float f7147f;

    /* renamed from: g  reason: collision with root package name */
    public float f7148g;

    /* renamed from: h  reason: collision with root package name */
    public float f7149h;

    /* renamed from: i  reason: collision with root package name */
    public float f7150i;

    /* renamed from: j  reason: collision with root package name */
    public byte f7151j;

    /* renamed from: k  reason: collision with root package name */
    public byte f7152k;

    /* renamed from: l  reason: collision with root package name */
    public byte f7153l;

    public msg_safety_set_allowed_area() {
        this.f6280c = 54;
    }

    public msg_safety_set_allowed_area(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 54;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7145d = aVar.g();
        this.f7146e = aVar.g();
        this.f7147f = aVar.g();
        this.f7148g = aVar.g();
        this.f7149h = aVar.g();
        this.f7150i = aVar.g();
        this.f7151j = aVar.c();
        this.f7152k = aVar.c();
        this.f7153l = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SAFETY_SET_ALLOWED_AREA - p1x:" + this.f7145d + " p1y:" + this.f7146e + " p1z:" + this.f7147f + " p2x:" + this.f7148g + " p2y:" + this.f7149h + " p2z:" + this.f7150i + " target_system:" + this.f7151j + " target_component:" + this.f7152k + " frame:" + this.f7153l + "";
    }
}
