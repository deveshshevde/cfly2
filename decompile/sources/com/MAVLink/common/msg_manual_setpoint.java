package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_manual_setpoint extends MAVLinkMessage {
    private static final long serialVersionUID = 81;

    /* renamed from: d  reason: collision with root package name */
    public int f6911d;

    /* renamed from: e  reason: collision with root package name */
    public float f6912e;

    /* renamed from: f  reason: collision with root package name */
    public float f6913f;

    /* renamed from: g  reason: collision with root package name */
    public float f6914g;

    /* renamed from: h  reason: collision with root package name */
    public float f6915h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6916i;

    /* renamed from: j  reason: collision with root package name */
    public byte f6917j;

    public msg_manual_setpoint() {
        this.f6280c = 81;
    }

    public msg_manual_setpoint(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 81;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6911d = aVar.e();
        this.f6912e = aVar.g();
        this.f6913f = aVar.g();
        this.f6914g = aVar.g();
        this.f6915h = aVar.g();
        this.f6916i = aVar.c();
        this.f6917j = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MANUAL_SETPOINT - time_boot_ms:" + this.f6911d + " roll:" + this.f6912e + " pitch:" + this.f6913f + " yaw:" + this.f6914g + " thrust:" + this.f6915h + " mode_switch:" + this.f6916i + " manual_override_switch:" + this.f6917j + "";
    }
}
