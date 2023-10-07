package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_fence_fetch_point extends MAVLinkMessage {
    private static final long serialVersionUID = 161;

    /* renamed from: d  reason: collision with root package name */
    public byte f6399d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6400e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6401f;

    public msg_fence_fetch_point() {
        this.f6280c = 161;
    }

    public msg_fence_fetch_point(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 161;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6399d = aVar.c();
        this.f6400e = aVar.c();
        this.f6401f = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_FENCE_FETCH_POINT - target_system:" + this.f6399d + " target_component:" + this.f6400e + " idx:" + this.f6401f + "";
    }
}
