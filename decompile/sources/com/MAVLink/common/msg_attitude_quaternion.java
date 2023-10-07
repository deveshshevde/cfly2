package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_attitude_quaternion extends MAVLinkMessage {
    private static final long serialVersionUID = 31;

    /* renamed from: d  reason: collision with root package name */
    public int f6523d;

    /* renamed from: e  reason: collision with root package name */
    public float f6524e;

    /* renamed from: f  reason: collision with root package name */
    public float f6525f;

    /* renamed from: g  reason: collision with root package name */
    public float f6526g;

    /* renamed from: h  reason: collision with root package name */
    public float f6527h;

    /* renamed from: i  reason: collision with root package name */
    public float f6528i;

    /* renamed from: j  reason: collision with root package name */
    public float f6529j;

    /* renamed from: k  reason: collision with root package name */
    public float f6530k;

    public msg_attitude_quaternion() {
        this.f6280c = 31;
    }

    public msg_attitude_quaternion(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 31;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6523d = aVar.e();
        this.f6524e = aVar.g();
        this.f6525f = aVar.g();
        this.f6526g = aVar.g();
        this.f6527h = aVar.g();
        this.f6528i = aVar.g();
        this.f6529j = aVar.g();
        this.f6530k = aVar.g();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ATTITUDE_QUATERNION - time_boot_ms:" + this.f6523d + " q1:" + this.f6524e + " q2:" + this.f6525f + " q3:" + this.f6526g + " q4:" + this.f6527h + " rollspeed:" + this.f6528i + " pitchspeed:" + this.f6529j + " yawspeed:" + this.f6530k + "";
    }
}
