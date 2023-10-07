package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_gps2_raw extends MAVLinkMessage {
    private static final long serialVersionUID = 124;

    /* renamed from: d  reason: collision with root package name */
    public long f6671d;

    /* renamed from: e  reason: collision with root package name */
    public int f6672e;

    /* renamed from: f  reason: collision with root package name */
    public int f6673f;

    /* renamed from: g  reason: collision with root package name */
    public int f6674g;

    /* renamed from: h  reason: collision with root package name */
    public int f6675h;

    /* renamed from: i  reason: collision with root package name */
    public short f6676i;

    /* renamed from: j  reason: collision with root package name */
    public short f6677j;

    /* renamed from: k  reason: collision with root package name */
    public short f6678k;

    /* renamed from: l  reason: collision with root package name */
    public short f6679l;

    /* renamed from: m  reason: collision with root package name */
    public byte f6680m;

    /* renamed from: n  reason: collision with root package name */
    public byte f6681n;

    /* renamed from: o  reason: collision with root package name */
    public byte f6682o;

    public msg_gps2_raw() {
        this.f6280c = 124;
    }

    public msg_gps2_raw(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 124;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6671d = aVar.f();
        this.f6672e = aVar.e();
        this.f6673f = aVar.e();
        this.f6674g = aVar.e();
        this.f6675h = aVar.e();
        this.f6676i = aVar.d();
        this.f6677j = aVar.d();
        this.f6678k = aVar.d();
        this.f6679l = aVar.d();
        this.f6680m = aVar.c();
        this.f6681n = aVar.c();
        this.f6682o = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GPS2_RAW - time_usec:" + this.f6671d + " lat:" + this.f6672e + " lon:" + this.f6673f + " alt:" + this.f6674g + " dgps_age:" + this.f6675h + " eph:" + this.f6676i + " epv:" + this.f6677j + " vel:" + this.f6678k + " cog:" + this.f6679l + " fix_type:" + this.f6680m + " satellites_visible:" + this.f6681n + " dgps_numch:" + this.f6682o + "";
    }
}
