package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_local_position_ned_system_global_offset extends MAVLinkMessage {
    private static final long serialVersionUID = 89;

    /* renamed from: d  reason: collision with root package name */
    public int f6876d;

    /* renamed from: e  reason: collision with root package name */
    public float f6877e;

    /* renamed from: f  reason: collision with root package name */
    public float f6878f;

    /* renamed from: g  reason: collision with root package name */
    public float f6879g;

    /* renamed from: h  reason: collision with root package name */
    public float f6880h;

    /* renamed from: i  reason: collision with root package name */
    public float f6881i;

    /* renamed from: j  reason: collision with root package name */
    public float f6882j;

    public msg_local_position_ned_system_global_offset() {
        this.f6280c = 89;
    }

    public msg_local_position_ned_system_global_offset(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 89;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6876d = aVar.e();
        this.f6877e = aVar.g();
        this.f6878f = aVar.g();
        this.f6879g = aVar.g();
        this.f6880h = aVar.g();
        this.f6881i = aVar.g();
        this.f6882j = aVar.g();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOCAL_POSITION_NED_SYSTEM_GLOBAL_OFFSET - time_boot_ms:" + this.f6876d + " x:" + this.f6877e + " y:" + this.f6878f + " z:" + this.f6879g + " roll:" + this.f6880h + " pitch:" + this.f6881i + " yaw:" + this.f6882j + "";
    }
}
