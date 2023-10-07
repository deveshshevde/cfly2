package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_fence_status extends MAVLinkMessage {
    private static final long serialVersionUID = 162;

    /* renamed from: d  reason: collision with root package name */
    public int f6408d;

    /* renamed from: e  reason: collision with root package name */
    public short f6409e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6410f;

    /* renamed from: g  reason: collision with root package name */
    public byte f6411g;

    public msg_fence_status() {
        this.f6280c = 162;
    }

    public msg_fence_status(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 162;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6408d = aVar.e();
        this.f6409e = aVar.d();
        this.f6410f = aVar.c();
        this.f6411g = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_FENCE_STATUS - breach_time:" + this.f6408d + " breach_count:" + this.f6409e + " breach_status:" + this.f6410f + " breach_type:" + this.f6411g + "";
    }
}
