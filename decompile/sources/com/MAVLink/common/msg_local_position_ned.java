package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_local_position_ned extends MAVLinkMessage {
    private static final long serialVersionUID = 32;

    /* renamed from: d  reason: collision with root package name */
    public int f6859d;

    /* renamed from: e  reason: collision with root package name */
    public float f6860e;

    /* renamed from: f  reason: collision with root package name */
    public float f6861f;

    /* renamed from: g  reason: collision with root package name */
    public float f6862g;

    /* renamed from: h  reason: collision with root package name */
    public float f6863h;

    /* renamed from: i  reason: collision with root package name */
    public float f6864i;

    /* renamed from: j  reason: collision with root package name */
    public float f6865j;

    public msg_local_position_ned() {
        this.f6280c = 32;
    }

    public msg_local_position_ned(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 32;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6859d = aVar.e();
        this.f6860e = aVar.g();
        this.f6861f = aVar.g();
        this.f6862g = aVar.g();
        this.f6863h = aVar.g();
        this.f6864i = aVar.g();
        this.f6865j = aVar.g();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOCAL_POSITION_NED - time_boot_ms:" + this.f6859d + " x:" + this.f6860e + " y:" + this.f6861f + " z:" + this.f6862g + " vx:" + this.f6863h + " vy:" + this.f6864i + " vz:" + this.f6865j + "";
    }
}
