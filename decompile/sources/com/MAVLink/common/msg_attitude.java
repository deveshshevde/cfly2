package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_attitude extends MAVLinkMessage {
    private static final long serialVersionUID = 30;

    /* renamed from: d  reason: collision with root package name */
    public int f6516d;

    /* renamed from: e  reason: collision with root package name */
    public float f6517e;

    /* renamed from: f  reason: collision with root package name */
    public float f6518f;

    /* renamed from: g  reason: collision with root package name */
    public float f6519g;

    /* renamed from: h  reason: collision with root package name */
    public float f6520h;

    /* renamed from: i  reason: collision with root package name */
    public float f6521i;

    /* renamed from: j  reason: collision with root package name */
    public float f6522j;

    public msg_attitude() {
        this.f6280c = 30;
    }

    public msg_attitude(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 30;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6516d = aVar.e();
        this.f6517e = aVar.g();
        this.f6518f = aVar.g();
        this.f6519g = aVar.g();
        this.f6520h = aVar.g();
        this.f6521i = aVar.g();
        this.f6522j = aVar.g();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ATTITUDE - time_boot_ms:" + this.f6516d + " roll:" + this.f6517e + " pitch:" + this.f6518f + " yaw:" + this.f6519g + " rollspeed:" + this.f6520h + " pitchspeed:" + this.f6521i + " yawspeed:" + this.f6522j + "";
    }
}
