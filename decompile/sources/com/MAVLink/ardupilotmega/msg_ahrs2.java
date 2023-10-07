package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_ahrs2 extends MAVLinkMessage {
    private static final long serialVersionUID = 178;

    /* renamed from: d  reason: collision with root package name */
    public float f6312d;

    /* renamed from: e  reason: collision with root package name */
    public float f6313e;

    /* renamed from: f  reason: collision with root package name */
    public float f6314f;

    /* renamed from: g  reason: collision with root package name */
    public float f6315g;

    /* renamed from: h  reason: collision with root package name */
    public int f6316h;

    /* renamed from: i  reason: collision with root package name */
    public int f6317i;

    public msg_ahrs2() {
        this.f6280c = 178;
    }

    public msg_ahrs2(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 178;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6312d = aVar.g();
        this.f6313e = aVar.g();
        this.f6314f = aVar.g();
        this.f6315g = aVar.g();
        this.f6316h = aVar.e();
        this.f6317i = aVar.e();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_AHRS2 - roll:" + this.f6312d + " pitch:" + this.f6313e + " yaw:" + this.f6314f + " altitude:" + this.f6315g + " lat:" + this.f6316h + " lng:" + this.f6317i + "";
    }
}
