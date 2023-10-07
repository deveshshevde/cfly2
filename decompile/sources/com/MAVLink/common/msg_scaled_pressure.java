package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_scaled_pressure extends MAVLinkMessage {
    private static final long serialVersionUID = 29;

    /* renamed from: d  reason: collision with root package name */
    public int f7174d;

    /* renamed from: e  reason: collision with root package name */
    public float f7175e;

    /* renamed from: f  reason: collision with root package name */
    public float f7176f;

    /* renamed from: g  reason: collision with root package name */
    public short f7177g;

    public msg_scaled_pressure() {
        this.f6280c = 29;
    }

    public msg_scaled_pressure(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 29;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7174d = aVar.e();
        this.f7175e = aVar.g();
        this.f7176f = aVar.g();
        this.f7177g = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SCALED_PRESSURE - time_boot_ms:" + this.f7174d + " press_abs:" + this.f7175e + " press_diff:" + this.f7176f + " temperature:" + this.f7177g + "";
    }
}
