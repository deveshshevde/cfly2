package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_rc_channels extends MAVLinkMessage {
    private static final long serialVersionUID = 65;

    /* renamed from: d  reason: collision with root package name */
    public int f7074d;

    /* renamed from: e  reason: collision with root package name */
    public short f7075e;

    /* renamed from: f  reason: collision with root package name */
    public short f7076f;

    /* renamed from: g  reason: collision with root package name */
    public short f7077g;

    /* renamed from: h  reason: collision with root package name */
    public short f7078h;

    /* renamed from: i  reason: collision with root package name */
    public short f7079i;

    /* renamed from: j  reason: collision with root package name */
    public short f7080j;

    /* renamed from: k  reason: collision with root package name */
    public short f7081k;

    /* renamed from: l  reason: collision with root package name */
    public short f7082l;

    /* renamed from: m  reason: collision with root package name */
    public short f7083m;

    /* renamed from: n  reason: collision with root package name */
    public short f7084n;

    /* renamed from: o  reason: collision with root package name */
    public short f7085o;

    /* renamed from: p  reason: collision with root package name */
    public short f7086p;

    /* renamed from: q  reason: collision with root package name */
    public short f7087q;

    /* renamed from: r  reason: collision with root package name */
    public short f7088r;

    /* renamed from: s  reason: collision with root package name */
    public short f7089s;

    /* renamed from: t  reason: collision with root package name */
    public short f7090t;

    /* renamed from: u  reason: collision with root package name */
    public short f7091u;

    /* renamed from: v  reason: collision with root package name */
    public short f7092v;

    /* renamed from: w  reason: collision with root package name */
    public byte f7093w;

    /* renamed from: x  reason: collision with root package name */
    public byte f7094x;

    public msg_rc_channels() {
        this.f6280c = 65;
    }

    public msg_rc_channels(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 65;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7074d = aVar.e();
        this.f7075e = aVar.d();
        this.f7076f = aVar.d();
        this.f7077g = aVar.d();
        this.f7078h = aVar.d();
        this.f7079i = aVar.d();
        this.f7080j = aVar.d();
        this.f7081k = aVar.d();
        this.f7082l = aVar.d();
        this.f7083m = aVar.d();
        this.f7084n = aVar.d();
        this.f7085o = aVar.d();
        this.f7086p = aVar.d();
        this.f7087q = aVar.d();
        this.f7088r = aVar.d();
        this.f7089s = aVar.d();
        this.f7090t = aVar.d();
        this.f7091u = aVar.d();
        this.f7092v = aVar.d();
        this.f7093w = aVar.c();
        this.f7094x = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RC_CHANNELS - time_boot_ms:" + this.f7074d + " chan1_raw:" + this.f7075e + " chan2_raw:" + this.f7076f + " chan3_raw:" + this.f7077g + " chan4_raw:" + this.f7078h + " chan5_raw:" + this.f7079i + " chan6_raw:" + this.f7080j + " chan7_raw:" + this.f7081k + " chan8_raw:" + this.f7082l + " chan9_raw:" + this.f7083m + " chan10_raw:" + this.f7084n + " chan11_raw:" + this.f7085o + " chan12_raw:" + this.f7086p + " chan13_raw:" + this.f7087q + " chan14_raw:" + this.f7088r + " chan15_raw:" + this.f7089s + " chan16_raw:" + this.f7090t + " chan17_raw:" + this.f7091u + " chan18_raw:" + this.f7092v + " chancount:" + this.f7093w + " rssi:" + this.f7094x + "";
    }
}
