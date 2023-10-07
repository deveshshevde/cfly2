package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_scaled_imu2 extends MAVLinkMessage {
    private static final long serialVersionUID = 116;

    /* renamed from: d  reason: collision with root package name */
    public int f7164d;

    /* renamed from: e  reason: collision with root package name */
    public short f7165e;

    /* renamed from: f  reason: collision with root package name */
    public short f7166f;

    /* renamed from: g  reason: collision with root package name */
    public short f7167g;

    /* renamed from: h  reason: collision with root package name */
    public short f7168h;

    /* renamed from: i  reason: collision with root package name */
    public short f7169i;

    /* renamed from: j  reason: collision with root package name */
    public short f7170j;

    /* renamed from: k  reason: collision with root package name */
    public short f7171k;

    /* renamed from: l  reason: collision with root package name */
    public short f7172l;

    /* renamed from: m  reason: collision with root package name */
    public short f7173m;

    public msg_scaled_imu2() {
        this.f6280c = 116;
    }

    public msg_scaled_imu2(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 116;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7164d = aVar.e();
        this.f7165e = aVar.d();
        this.f7166f = aVar.d();
        this.f7167g = aVar.d();
        this.f7168h = aVar.d();
        this.f7169i = aVar.d();
        this.f7170j = aVar.d();
        this.f7171k = aVar.d();
        this.f7172l = aVar.d();
        this.f7173m = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SCALED_IMU2 - time_boot_ms:" + this.f7164d + " xacc:" + this.f7165e + " yacc:" + this.f7166f + " zacc:" + this.f7167g + " xgyro:" + this.f7168h + " ygyro:" + this.f7169i + " zgyro:" + this.f7170j + " xmag:" + this.f7171k + " ymag:" + this.f7172l + " zmag:" + this.f7173m + "";
    }
}
