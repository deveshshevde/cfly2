package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_raw_imu extends MAVLinkMessage {
    private static final long serialVersionUID = 27;

    /* renamed from: d  reason: collision with root package name */
    public long f7059d;

    /* renamed from: e  reason: collision with root package name */
    public short f7060e;

    /* renamed from: f  reason: collision with root package name */
    public short f7061f;

    /* renamed from: g  reason: collision with root package name */
    public short f7062g;

    /* renamed from: h  reason: collision with root package name */
    public short f7063h;

    /* renamed from: i  reason: collision with root package name */
    public short f7064i;

    /* renamed from: j  reason: collision with root package name */
    public short f7065j;

    /* renamed from: k  reason: collision with root package name */
    public short f7066k;

    /* renamed from: l  reason: collision with root package name */
    public short f7067l;

    /* renamed from: m  reason: collision with root package name */
    public short f7068m;

    public msg_raw_imu() {
        this.f6280c = 27;
    }

    public msg_raw_imu(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 27;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7059d = aVar.f();
        this.f7060e = aVar.d();
        this.f7061f = aVar.d();
        this.f7062g = aVar.d();
        this.f7063h = aVar.d();
        this.f7064i = aVar.d();
        this.f7065j = aVar.d();
        this.f7066k = aVar.d();
        this.f7067l = aVar.d();
        this.f7068m = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RAW_IMU - time_usec:" + this.f7059d + " xacc:" + this.f7060e + " yacc:" + this.f7061f + " zacc:" + this.f7062g + " xgyro:" + this.f7063h + " ygyro:" + this.f7064i + " zgyro:" + this.f7065j + " xmag:" + this.f7066k + " ymag:" + this.f7067l + " zmag:" + this.f7068m + "";
    }
}
