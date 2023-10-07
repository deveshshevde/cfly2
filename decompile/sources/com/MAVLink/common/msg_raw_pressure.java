package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_raw_pressure extends MAVLinkMessage {
    private static final long serialVersionUID = 28;

    /* renamed from: d  reason: collision with root package name */
    public long f7069d;

    /* renamed from: e  reason: collision with root package name */
    public short f7070e;

    /* renamed from: f  reason: collision with root package name */
    public short f7071f;

    /* renamed from: g  reason: collision with root package name */
    public short f7072g;

    /* renamed from: h  reason: collision with root package name */
    public short f7073h;

    public msg_raw_pressure() {
        this.f6280c = 28;
    }

    public msg_raw_pressure(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 28;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7069d = aVar.f();
        this.f7070e = aVar.d();
        this.f7071f = aVar.d();
        this.f7072g = aVar.d();
        this.f7073h = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RAW_PRESSURE - time_usec:" + this.f7069d + " press_abs:" + this.f7070e + " press_diff1:" + this.f7071f + " press_diff2:" + this.f7072g + " temperature:" + this.f7073h + "";
    }
}
