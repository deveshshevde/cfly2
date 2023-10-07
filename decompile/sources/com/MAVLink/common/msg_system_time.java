package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_system_time extends MAVLinkMessage {
    private static final long serialVersionUID = 2;

    /* renamed from: d  reason: collision with root package name */
    public long f7282d;

    /* renamed from: e  reason: collision with root package name */
    public int f7283e;

    public msg_system_time() {
        this.f6280c = 2;
    }

    public msg_system_time(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 2;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7282d = aVar.f();
        this.f7283e = aVar.e();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SYSTEM_TIME - time_unix_usec:" + this.f7282d + " time_boot_ms:" + this.f7283e + "";
    }
}
