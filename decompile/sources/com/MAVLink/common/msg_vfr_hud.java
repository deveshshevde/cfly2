package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_vfr_hud extends MAVLinkMessage {
    private static final long serialVersionUID = 74;

    /* renamed from: d  reason: collision with root package name */
    public float f7307d;

    /* renamed from: e  reason: collision with root package name */
    public float f7308e;

    /* renamed from: f  reason: collision with root package name */
    public float f7309f;

    /* renamed from: g  reason: collision with root package name */
    public float f7310g;

    /* renamed from: h  reason: collision with root package name */
    public short f7311h;

    /* renamed from: i  reason: collision with root package name */
    public short f7312i;

    public msg_vfr_hud() {
        this.f6280c = 74;
    }

    public msg_vfr_hud(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 74;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7307d = aVar.g();
        this.f7308e = aVar.g();
        this.f7309f = aVar.g();
        this.f7310g = aVar.g();
        this.f7311h = aVar.d();
        this.f7312i = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_VFR_HUD - airspeed:" + this.f7307d + " groundspeed:" + this.f7308e + " alt:" + this.f7309f + " climb:" + this.f7310g + " heading:" + this.f7311h + " throttle:" + this.f7312i + "";
    }
}
