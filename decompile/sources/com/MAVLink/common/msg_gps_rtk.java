package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_gps_rtk extends MAVLinkMessage {
    private static final long serialVersionUID = 127;

    /* renamed from: d  reason: collision with root package name */
    public int f6713d;

    /* renamed from: e  reason: collision with root package name */
    public int f6714e;

    /* renamed from: f  reason: collision with root package name */
    public int f6715f;

    /* renamed from: g  reason: collision with root package name */
    public int f6716g;

    /* renamed from: h  reason: collision with root package name */
    public int f6717h;

    /* renamed from: i  reason: collision with root package name */
    public int f6718i;

    /* renamed from: j  reason: collision with root package name */
    public int f6719j;

    /* renamed from: k  reason: collision with root package name */
    public short f6720k;

    /* renamed from: l  reason: collision with root package name */
    public byte f6721l;

    /* renamed from: m  reason: collision with root package name */
    public byte f6722m;

    /* renamed from: n  reason: collision with root package name */
    public byte f6723n;

    /* renamed from: o  reason: collision with root package name */
    public byte f6724o;

    /* renamed from: p  reason: collision with root package name */
    public byte f6725p;

    public msg_gps_rtk() {
        this.f6280c = 127;
    }

    public msg_gps_rtk(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 127;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6713d = aVar.e();
        this.f6714e = aVar.e();
        this.f6715f = aVar.e();
        this.f6716g = aVar.e();
        this.f6717h = aVar.e();
        this.f6718i = aVar.e();
        this.f6719j = aVar.e();
        this.f6720k = aVar.d();
        this.f6721l = aVar.c();
        this.f6722m = aVar.c();
        this.f6723n = aVar.c();
        this.f6724o = aVar.c();
        this.f6725p = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GPS_RTK - time_last_baseline_ms:" + this.f6713d + " tow:" + this.f6714e + " baseline_a_mm:" + this.f6715f + " baseline_b_mm:" + this.f6716g + " baseline_c_mm:" + this.f6717h + " accuracy:" + this.f6718i + " iar_num_hypotheses:" + this.f6719j + " wn:" + this.f6720k + " rtk_receiver_id:" + this.f6721l + " rtk_health:" + this.f6722m + " rtk_rate:" + this.f6723n + " nsats:" + this.f6724o + " baseline_coords_type:" + this.f6725p + "";
    }
}
