package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_drone_angle extends MAVLinkMessage {
    private static final long serialVersionUID = 13;

    /* renamed from: d  reason: collision with root package name */
    public int f6633d;

    /* renamed from: e  reason: collision with root package name */
    public int f6634e;

    public msg_drone_angle() {
        this.f6280c = 13;
    }

    public msg_drone_angle(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 13;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 8;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 13;
        mAVLinkPacket.f6250f.a(this.f6633d);
        mAVLinkPacket.f6250f.a(this.f6634e);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f6633d = aVar.e();
        this.f6634e = aVar.e();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DRONE_ANGLE - lat:" + this.f6633d + " lon:" + this.f6634e + "";
    }
}
