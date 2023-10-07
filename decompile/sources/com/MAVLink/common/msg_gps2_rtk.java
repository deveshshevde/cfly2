package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_gps2_rtk extends MAVLinkMessage {
    private static final long serialVersionUID = 128;

    /* renamed from: d  reason: collision with root package name */
    public int f6683d;

    /* renamed from: e  reason: collision with root package name */
    public int f6684e;

    /* renamed from: f  reason: collision with root package name */
    public int f6685f;

    /* renamed from: g  reason: collision with root package name */
    public int f6686g;

    /* renamed from: h  reason: collision with root package name */
    public int f6687h;

    /* renamed from: i  reason: collision with root package name */
    public int f6688i;

    /* renamed from: j  reason: collision with root package name */
    public int f6689j;

    /* renamed from: k  reason: collision with root package name */
    public short f6690k;

    /* renamed from: l  reason: collision with root package name */
    public byte f6691l;

    /* renamed from: m  reason: collision with root package name */
    public byte f6692m;

    /* renamed from: n  reason: collision with root package name */
    public byte f6693n;

    /* renamed from: o  reason: collision with root package name */
    public byte f6694o;

    /* renamed from: p  reason: collision with root package name */
    public byte f6695p;

    public msg_gps2_rtk() {
        this.f6280c = 128;
    }

    public msg_gps2_rtk(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 128;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6683d = aVar.e();
        this.f6684e = aVar.e();
        this.f6685f = aVar.e();
        this.f6686g = aVar.e();
        this.f6687h = aVar.e();
        this.f6688i = aVar.e();
        this.f6689j = aVar.e();
        this.f6690k = aVar.d();
        this.f6691l = aVar.c();
        this.f6692m = aVar.c();
        this.f6693n = aVar.c();
        this.f6694o = aVar.c();
        this.f6695p = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GPS2_RTK - time_last_baseline_ms:" + this.f6683d + " tow:" + this.f6684e + " baseline_a_mm:" + this.f6685f + " baseline_b_mm:" + this.f6686g + " baseline_c_mm:" + this.f6687h + " accuracy:" + this.f6688i + " iar_num_hypotheses:" + this.f6689j + " wn:" + this.f6690k + " rtk_receiver_id:" + this.f6691l + " rtk_health:" + this.f6692m + " rtk_rate:" + this.f6693n + " nsats:" + this.f6694o + " baseline_coords_type:" + this.f6695p + "";
    }
}
