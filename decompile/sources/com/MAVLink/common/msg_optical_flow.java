package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_optical_flow extends MAVLinkMessage {
    private static final long serialVersionUID = 100;

    /* renamed from: d  reason: collision with root package name */
    public long f6997d;

    /* renamed from: e  reason: collision with root package name */
    public float f6998e;

    /* renamed from: f  reason: collision with root package name */
    public float f6999f;

    /* renamed from: g  reason: collision with root package name */
    public float f7000g;

    /* renamed from: h  reason: collision with root package name */
    public short f7001h;

    /* renamed from: i  reason: collision with root package name */
    public short f7002i;

    /* renamed from: j  reason: collision with root package name */
    public byte f7003j;

    /* renamed from: k  reason: collision with root package name */
    public byte f7004k;

    public msg_optical_flow() {
        this.f6280c = 100;
    }

    public msg_optical_flow(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 100;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6997d = aVar.f();
        this.f6998e = aVar.g();
        this.f6999f = aVar.g();
        this.f7000g = aVar.g();
        this.f7001h = aVar.d();
        this.f7002i = aVar.d();
        this.f7003j = aVar.c();
        this.f7004k = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_OPTICAL_FLOW - time_usec:" + this.f6997d + " flow_comp_m_x:" + this.f6998e + " flow_comp_m_y:" + this.f6999f + " ground_distance:" + this.f7000g + " flow_x:" + this.f7001h + " flow_y:" + this.f7002i + " sensor_id:" + this.f7003j + " quality:" + this.f7004k + "";
    }
}
