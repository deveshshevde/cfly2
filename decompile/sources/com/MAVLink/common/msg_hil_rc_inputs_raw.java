package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_hil_rc_inputs_raw extends MAVLinkMessage {
    private static final long serialVersionUID = 92;

    /* renamed from: d  reason: collision with root package name */
    public long f6785d;

    /* renamed from: e  reason: collision with root package name */
    public short f6786e;

    /* renamed from: f  reason: collision with root package name */
    public short f6787f;

    /* renamed from: g  reason: collision with root package name */
    public short f6788g;

    /* renamed from: h  reason: collision with root package name */
    public short f6789h;

    /* renamed from: i  reason: collision with root package name */
    public short f6790i;

    /* renamed from: j  reason: collision with root package name */
    public short f6791j;

    /* renamed from: k  reason: collision with root package name */
    public short f6792k;

    /* renamed from: l  reason: collision with root package name */
    public short f6793l;

    /* renamed from: m  reason: collision with root package name */
    public short f6794m;

    /* renamed from: n  reason: collision with root package name */
    public short f6795n;

    /* renamed from: o  reason: collision with root package name */
    public short f6796o;

    /* renamed from: p  reason: collision with root package name */
    public short f6797p;

    /* renamed from: q  reason: collision with root package name */
    public byte f6798q;

    public msg_hil_rc_inputs_raw() {
        this.f6280c = 92;
    }

    public msg_hil_rc_inputs_raw(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 92;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6785d = aVar.f();
        this.f6786e = aVar.d();
        this.f6787f = aVar.d();
        this.f6788g = aVar.d();
        this.f6789h = aVar.d();
        this.f6790i = aVar.d();
        this.f6791j = aVar.d();
        this.f6792k = aVar.d();
        this.f6793l = aVar.d();
        this.f6794m = aVar.d();
        this.f6795n = aVar.d();
        this.f6796o = aVar.d();
        this.f6797p = aVar.d();
        this.f6798q = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HIL_RC_INPUTS_RAW - time_usec:" + this.f6785d + " chan1_raw:" + this.f6786e + " chan2_raw:" + this.f6787f + " chan3_raw:" + this.f6788g + " chan4_raw:" + this.f6789h + " chan5_raw:" + this.f6790i + " chan6_raw:" + this.f6791j + " chan7_raw:" + this.f6792k + " chan8_raw:" + this.f6793l + " chan9_raw:" + this.f6794m + " chan10_raw:" + this.f6795n + " chan11_raw:" + this.f6796o + " chan12_raw:" + this.f6797p + " rssi:" + this.f6798q + "";
    }
}
