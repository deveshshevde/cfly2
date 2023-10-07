package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_scaled_imu extends MAVLinkMessage {
    private static final long serialVersionUID = 26;

    /* renamed from: d  reason: collision with root package name */
    public int f7154d;

    /* renamed from: e  reason: collision with root package name */
    public short f7155e;

    /* renamed from: f  reason: collision with root package name */
    public short f7156f;

    /* renamed from: g  reason: collision with root package name */
    public short f7157g;

    /* renamed from: h  reason: collision with root package name */
    public short f7158h;

    /* renamed from: i  reason: collision with root package name */
    public short f7159i;

    /* renamed from: j  reason: collision with root package name */
    public short f7160j;

    /* renamed from: k  reason: collision with root package name */
    public short f7161k;

    /* renamed from: l  reason: collision with root package name */
    public short f7162l;

    /* renamed from: m  reason: collision with root package name */
    public short f7163m;

    public msg_scaled_imu() {
        this.f6280c = 26;
    }

    public msg_scaled_imu(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 26;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7154d = aVar.e();
        this.f7155e = aVar.d();
        this.f7156f = aVar.d();
        this.f7157g = aVar.d();
        this.f7158h = aVar.d();
        this.f7159i = aVar.d();
        this.f7160j = aVar.d();
        this.f7161k = aVar.d();
        this.f7162l = aVar.d();
        this.f7163m = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SCALED_IMU - time_boot_ms:" + this.f7154d + " xacc:" + this.f7155e + " yacc:" + this.f7156f + " zacc:" + this.f7157g + " xgyro:" + this.f7158h + " ygyro:" + this.f7159i + " zgyro:" + this.f7160j + " xmag:" + this.f7161k + " ymag:" + this.f7162l + " zmag:" + this.f7163m + "";
    }
}
