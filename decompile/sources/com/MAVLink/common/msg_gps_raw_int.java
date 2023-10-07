package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_gps_raw_int extends MAVLinkMessage {
    private static final long serialVersionUID = 24;

    /* renamed from: d  reason: collision with root package name */
    public long f6703d;

    /* renamed from: e  reason: collision with root package name */
    public int f6704e;

    /* renamed from: f  reason: collision with root package name */
    public int f6705f;

    /* renamed from: g  reason: collision with root package name */
    public int f6706g;

    /* renamed from: h  reason: collision with root package name */
    public short f6707h;

    /* renamed from: i  reason: collision with root package name */
    public short f6708i;

    /* renamed from: j  reason: collision with root package name */
    public short f6709j;

    /* renamed from: k  reason: collision with root package name */
    public short f6710k;

    /* renamed from: l  reason: collision with root package name */
    public byte f6711l;

    /* renamed from: m  reason: collision with root package name */
    public byte f6712m;

    public msg_gps_raw_int() {
        this.f6280c = 24;
    }

    public msg_gps_raw_int(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 24;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6703d = aVar.f();
        this.f6704e = aVar.e();
        this.f6705f = aVar.e();
        this.f6706g = aVar.e();
        this.f6707h = aVar.d();
        this.f6708i = aVar.d();
        this.f6709j = aVar.d();
        this.f6710k = aVar.d();
        this.f6711l = aVar.c();
        this.f6712m = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GPS_RAW_INT - time_usec:" + this.f6703d + " lat:" + this.f6704e + " lon:" + this.f6705f + " alt:" + this.f6706g + " eph:" + this.f6707h + " epv:" + this.f6708i + " vel:" + this.f6709j + " cog:" + this.f6710k + " fix_type:" + this.f6711l + " satellites_visible:" + this.f6712m + "";
    }
}
