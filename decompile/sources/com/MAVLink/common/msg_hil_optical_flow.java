package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_hil_optical_flow extends MAVLinkMessage {
    private static final long serialVersionUID = 114;

    /* renamed from: d  reason: collision with root package name */
    public long f6777d;

    /* renamed from: e  reason: collision with root package name */
    public float f6778e;

    /* renamed from: f  reason: collision with root package name */
    public float f6779f;

    /* renamed from: g  reason: collision with root package name */
    public float f6780g;

    /* renamed from: h  reason: collision with root package name */
    public short f6781h;

    /* renamed from: i  reason: collision with root package name */
    public short f6782i;

    /* renamed from: j  reason: collision with root package name */
    public byte f6783j;

    /* renamed from: k  reason: collision with root package name */
    public byte f6784k;

    public msg_hil_optical_flow() {
        this.f6280c = 114;
    }

    public msg_hil_optical_flow(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 114;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6777d = aVar.f();
        this.f6778e = aVar.g();
        this.f6779f = aVar.g();
        this.f6780g = aVar.g();
        this.f6781h = aVar.d();
        this.f6782i = aVar.d();
        this.f6783j = aVar.c();
        this.f6784k = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HIL_OPTICAL_FLOW - time_usec:" + this.f6777d + " flow_comp_m_x:" + this.f6778e + " flow_comp_m_y:" + this.f6779f + " ground_distance:" + this.f6780g + " flow_x:" + this.f6781h + " flow_y:" + this.f6782i + " sensor_id:" + this.f6783j + " quality:" + this.f6784k + "";
    }
}
