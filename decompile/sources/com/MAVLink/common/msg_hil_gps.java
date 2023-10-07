package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_hil_gps extends MAVLinkMessage {
    private static final long serialVersionUID = 113;

    /* renamed from: d  reason: collision with root package name */
    public long f6764d;

    /* renamed from: e  reason: collision with root package name */
    public int f6765e;

    /* renamed from: f  reason: collision with root package name */
    public int f6766f;

    /* renamed from: g  reason: collision with root package name */
    public int f6767g;

    /* renamed from: h  reason: collision with root package name */
    public short f6768h;

    /* renamed from: i  reason: collision with root package name */
    public short f6769i;

    /* renamed from: j  reason: collision with root package name */
    public short f6770j;

    /* renamed from: k  reason: collision with root package name */
    public short f6771k;

    /* renamed from: l  reason: collision with root package name */
    public short f6772l;

    /* renamed from: m  reason: collision with root package name */
    public short f6773m;

    /* renamed from: n  reason: collision with root package name */
    public short f6774n;

    /* renamed from: o  reason: collision with root package name */
    public byte f6775o;

    /* renamed from: p  reason: collision with root package name */
    public byte f6776p;

    public msg_hil_gps() {
        this.f6280c = 113;
    }

    public msg_hil_gps(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 113;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6764d = aVar.f();
        this.f6765e = aVar.e();
        this.f6766f = aVar.e();
        this.f6767g = aVar.e();
        this.f6768h = aVar.d();
        this.f6769i = aVar.d();
        this.f6770j = aVar.d();
        this.f6771k = aVar.d();
        this.f6772l = aVar.d();
        this.f6773m = aVar.d();
        this.f6774n = aVar.d();
        this.f6775o = aVar.c();
        this.f6776p = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HIL_GPS - time_usec:" + this.f6764d + " lat:" + this.f6765e + " lon:" + this.f6766f + " alt:" + this.f6767g + " eph:" + this.f6768h + " epv:" + this.f6769i + " vel:" + this.f6770j + " vn:" + this.f6771k + " ve:" + this.f6772l + " vd:" + this.f6773m + " cog:" + this.f6774n + " fix_type:" + this.f6775o + " satellites_visible:" + this.f6776p + "";
    }
}
