package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_mount_control extends MAVLinkMessage {
    private static final long serialVersionUID = 157;

    /* renamed from: d  reason: collision with root package name */
    public int f6431d;

    /* renamed from: e  reason: collision with root package name */
    public int f6432e;

    /* renamed from: f  reason: collision with root package name */
    public int f6433f;

    /* renamed from: g  reason: collision with root package name */
    public byte f6434g;

    /* renamed from: h  reason: collision with root package name */
    public byte f6435h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6436i;

    public msg_mount_control() {
        this.f6280c = 157;
    }

    public msg_mount_control(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 157;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6431d = aVar.e();
        this.f6432e = aVar.e();
        this.f6433f = aVar.e();
        this.f6434g = aVar.c();
        this.f6435h = aVar.c();
        this.f6436i = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MOUNT_CONTROL - input_a:" + this.f6431d + " input_b:" + this.f6432e + " input_c:" + this.f6433f + " target_system:" + this.f6434g + " target_component:" + this.f6435h + " save_position:" + this.f6436i + "";
    }
}
