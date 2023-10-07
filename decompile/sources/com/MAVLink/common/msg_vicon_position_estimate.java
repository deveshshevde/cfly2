package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_vicon_position_estimate extends MAVLinkMessage {
    private static final long serialVersionUID = 104;

    /* renamed from: d  reason: collision with root package name */
    public long f7320d;

    /* renamed from: e  reason: collision with root package name */
    public float f7321e;

    /* renamed from: f  reason: collision with root package name */
    public float f7322f;

    /* renamed from: g  reason: collision with root package name */
    public float f7323g;

    /* renamed from: h  reason: collision with root package name */
    public float f7324h;

    /* renamed from: i  reason: collision with root package name */
    public float f7325i;

    /* renamed from: j  reason: collision with root package name */
    public float f7326j;

    public msg_vicon_position_estimate() {
        this.f6280c = 104;
    }

    public msg_vicon_position_estimate(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 104;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7320d = aVar.f();
        this.f7321e = aVar.g();
        this.f7322f = aVar.g();
        this.f7323g = aVar.g();
        this.f7324h = aVar.g();
        this.f7325i = aVar.g();
        this.f7326j = aVar.g();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_VICON_POSITION_ESTIMATE - usec:" + this.f7320d + " x:" + this.f7321e + " y:" + this.f7322f + " z:" + this.f7323g + " roll:" + this.f7324h + " pitch:" + this.f7325i + " yaw:" + this.f7326j + "";
    }
}
