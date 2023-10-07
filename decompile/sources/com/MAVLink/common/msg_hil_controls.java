package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_hil_controls extends MAVLinkMessage {
    private static final long serialVersionUID = 91;

    /* renamed from: d  reason: collision with root package name */
    public long f6753d;

    /* renamed from: e  reason: collision with root package name */
    public float f6754e;

    /* renamed from: f  reason: collision with root package name */
    public float f6755f;

    /* renamed from: g  reason: collision with root package name */
    public float f6756g;

    /* renamed from: h  reason: collision with root package name */
    public float f6757h;

    /* renamed from: i  reason: collision with root package name */
    public float f6758i;

    /* renamed from: j  reason: collision with root package name */
    public float f6759j;

    /* renamed from: k  reason: collision with root package name */
    public float f6760k;

    /* renamed from: l  reason: collision with root package name */
    public float f6761l;

    /* renamed from: m  reason: collision with root package name */
    public byte f6762m;

    /* renamed from: n  reason: collision with root package name */
    public byte f6763n;

    public msg_hil_controls() {
        this.f6280c = 91;
    }

    public msg_hil_controls(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 91;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6753d = aVar.f();
        this.f6754e = aVar.g();
        this.f6755f = aVar.g();
        this.f6756g = aVar.g();
        this.f6757h = aVar.g();
        this.f6758i = aVar.g();
        this.f6759j = aVar.g();
        this.f6760k = aVar.g();
        this.f6761l = aVar.g();
        this.f6762m = aVar.c();
        this.f6763n = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HIL_CONTROLS - time_usec:" + this.f6753d + " roll_ailerons:" + this.f6754e + " pitch_elevator:" + this.f6755f + " yaw_rudder:" + this.f6756g + " throttle:" + this.f6757h + " aux1:" + this.f6758i + " aux2:" + this.f6759j + " aux3:" + this.f6760k + " aux4:" + this.f6761l + " mode:" + this.f6762m + " nav_mode:" + this.f6763n + "";
    }
}
