package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_mount_status extends MAVLinkMessage {
    private static final long serialVersionUID = 158;

    /* renamed from: d  reason: collision with root package name */
    public int f6437d;

    /* renamed from: e  reason: collision with root package name */
    public int f6438e;

    /* renamed from: f  reason: collision with root package name */
    public int f6439f;

    /* renamed from: g  reason: collision with root package name */
    public byte f6440g;

    /* renamed from: h  reason: collision with root package name */
    public byte f6441h;

    public msg_mount_status() {
        this.f6280c = 158;
    }

    public msg_mount_status(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 158;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6437d = aVar.e();
        this.f6438e = aVar.e();
        this.f6439f = aVar.e();
        this.f6440g = aVar.c();
        this.f6441h = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MOUNT_STATUS - pointing_a:" + this.f6437d + " pointing_b:" + this.f6438e + " pointing_c:" + this.f6439f + " target_system:" + this.f6440g + " target_component:" + this.f6441h + "";
    }
}
