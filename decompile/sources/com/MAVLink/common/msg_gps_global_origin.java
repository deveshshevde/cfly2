package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_gps_global_origin extends MAVLinkMessage {
    private static final long serialVersionUID = 49;

    /* renamed from: d  reason: collision with root package name */
    public int f6696d;

    /* renamed from: e  reason: collision with root package name */
    public int f6697e;

    /* renamed from: f  reason: collision with root package name */
    public int f6698f;

    public msg_gps_global_origin() {
        this.f6280c = 49;
    }

    public msg_gps_global_origin(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 49;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6696d = aVar.e();
        this.f6697e = aVar.e();
        this.f6698f = aVar.e();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GPS_GLOBAL_ORIGIN - latitude:" + this.f6696d + " longitude:" + this.f6697e + " altitude:" + this.f6698f + "";
    }
}
