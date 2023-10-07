package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_rc_channels_override extends MAVLinkMessage {
    private static final long serialVersionUID = 70;

    /* renamed from: d  reason: collision with root package name */
    public short f7095d;

    /* renamed from: e  reason: collision with root package name */
    public short f7096e;

    /* renamed from: f  reason: collision with root package name */
    public short f7097f;

    /* renamed from: g  reason: collision with root package name */
    public short f7098g;

    /* renamed from: h  reason: collision with root package name */
    public short f7099h;

    /* renamed from: i  reason: collision with root package name */
    public short f7100i;

    /* renamed from: j  reason: collision with root package name */
    public short f7101j;

    /* renamed from: k  reason: collision with root package name */
    public short f7102k;

    /* renamed from: l  reason: collision with root package name */
    public short f7103l;

    /* renamed from: m  reason: collision with root package name */
    public short f7104m;

    /* renamed from: n  reason: collision with root package name */
    public byte f7105n;

    /* renamed from: o  reason: collision with root package name */
    public byte f7106o;

    public msg_rc_channels_override() {
        this.f6280c = 70;
    }

    public msg_rc_channels_override(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 70;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 22;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 70;
        mAVLinkPacket.f6250f.a(this.f7095d);
        mAVLinkPacket.f6250f.a(this.f7096e);
        mAVLinkPacket.f6250f.a(this.f7097f);
        mAVLinkPacket.f6250f.a(this.f7098g);
        mAVLinkPacket.f6250f.a(this.f7099h);
        mAVLinkPacket.f6250f.a(this.f7100i);
        mAVLinkPacket.f6250f.a(this.f7101j);
        mAVLinkPacket.f6250f.a(this.f7102k);
        mAVLinkPacket.f6250f.a(this.f7103l);
        mAVLinkPacket.f6250f.a(this.f7104m);
        mAVLinkPacket.f6250f.b(this.f7105n);
        mAVLinkPacket.f6250f.b(this.f7106o);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f7095d = aVar.d();
        this.f7096e = aVar.d();
        this.f7097f = aVar.d();
        this.f7098g = aVar.d();
        this.f7099h = aVar.d();
        this.f7100i = aVar.d();
        this.f7101j = aVar.d();
        this.f7102k = aVar.d();
        this.f7103l = aVar.d();
        this.f7104m = aVar.d();
        this.f7105n = aVar.c();
        this.f7106o = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RC_CHANNELS_OVERRIDE - chan1_raw:" + this.f7095d + " chan2_raw:" + this.f7096e + " chan3_raw:" + this.f7097f + " chan4_raw:" + this.f7098g + " chan5_raw:" + this.f7099h + " chan6_raw:" + this.f7100i + " chan7_raw:" + this.f7101j + " chan8_raw:" + this.f7102k + "chan9_raw:" + this.f7103l + "chan10_raw:" + this.f7104m + " target_system:" + this.f7105n + " target_component:" + this.f7106o + "";
    }
}
