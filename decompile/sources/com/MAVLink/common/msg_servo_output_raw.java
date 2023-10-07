package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_servo_output_raw extends MAVLinkMessage {
    private static final long serialVersionUID = 36;

    /* renamed from: d  reason: collision with root package name */
    public int f7184d;

    /* renamed from: e  reason: collision with root package name */
    public short f7185e;

    /* renamed from: f  reason: collision with root package name */
    public short f7186f;

    /* renamed from: g  reason: collision with root package name */
    public short f7187g;

    /* renamed from: h  reason: collision with root package name */
    public short f7188h;

    /* renamed from: i  reason: collision with root package name */
    public short f7189i;

    /* renamed from: j  reason: collision with root package name */
    public short f7190j;

    /* renamed from: k  reason: collision with root package name */
    public short f7191k;

    /* renamed from: l  reason: collision with root package name */
    public short f7192l;

    /* renamed from: m  reason: collision with root package name */
    public byte f7193m;

    public msg_servo_output_raw() {
        this.f6280c = 36;
    }

    public msg_servo_output_raw(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 36;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7184d = aVar.e();
        this.f7185e = aVar.d();
        this.f7186f = aVar.d();
        this.f7187g = aVar.d();
        this.f7188h = aVar.d();
        this.f7189i = aVar.d();
        this.f7190j = aVar.d();
        this.f7191k = aVar.d();
        this.f7192l = aVar.d();
        this.f7193m = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SERVO_OUTPUT_RAW - time_usec:" + this.f7184d + " servo1_raw:" + this.f7185e + " servo2_raw:" + this.f7186f + " servo3_raw:" + this.f7187g + " servo4_raw:" + this.f7188h + " servo5_raw:" + this.f7189i + " servo6_raw:" + this.f7190j + " servo7_raw:" + this.f7191k + " servo8_raw:" + this.f7192l + " port:" + this.f7193m + "";
    }
}
