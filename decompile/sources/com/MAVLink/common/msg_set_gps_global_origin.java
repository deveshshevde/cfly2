package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_set_gps_global_origin extends MAVLinkMessage {
    private static final long serialVersionUID = 48;

    /* renamed from: d  reason: collision with root package name */
    public int f7203d;

    /* renamed from: e  reason: collision with root package name */
    public int f7204e;

    /* renamed from: f  reason: collision with root package name */
    public int f7205f;

    /* renamed from: g  reason: collision with root package name */
    public byte f7206g;

    public msg_set_gps_global_origin() {
        this.f6280c = 48;
    }

    public msg_set_gps_global_origin(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 48;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7203d = aVar.e();
        this.f7204e = aVar.e();
        this.f7205f = aVar.e();
        this.f7206g = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_GPS_GLOBAL_ORIGIN - latitude:" + this.f7203d + " longitude:" + this.f7204e + " altitude:" + this.f7205f + " target_system:" + this.f7206g + "";
    }
}
