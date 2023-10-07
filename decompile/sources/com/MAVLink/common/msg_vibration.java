package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_vibration extends MAVLinkMessage {
    private static final long serialVersionUID = 241;

    /* renamed from: d  reason: collision with root package name */
    public long f7313d;

    /* renamed from: e  reason: collision with root package name */
    public float f7314e;

    /* renamed from: f  reason: collision with root package name */
    public float f7315f;

    /* renamed from: g  reason: collision with root package name */
    public float f7316g;

    /* renamed from: h  reason: collision with root package name */
    public long f7317h;

    /* renamed from: i  reason: collision with root package name */
    public long f7318i;

    /* renamed from: j  reason: collision with root package name */
    public long f7319j;

    public msg_vibration() {
        this.f6280c = 241;
    }

    public msg_vibration(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 241;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7313d = aVar.f();
        this.f7314e = aVar.g();
        this.f7315f = aVar.g();
        this.f7316g = aVar.g();
        this.f7317h = aVar.f();
        this.f7318i = aVar.f();
        this.f7319j = aVar.f();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_VIBRATION - time_usec:" + this.f7313d + " vibration_x:" + this.f7314e + " vibration_y:" + this.f7315f + " vibration_z:" + this.f7316g + " clipping_0:" + this.f7317h + " clipping_1:" + this.f7318i + " clipping_2:" + this.f7319j + "";
    }
}
