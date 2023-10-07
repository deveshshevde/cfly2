package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_yyz_calibration extends MAVLinkMessage {
    private static final long serialVersionUID = 71;

    /* renamed from: d  reason: collision with root package name */
    public byte f7338d;

    /* renamed from: e  reason: collision with root package name */
    public byte f7339e;

    /* renamed from: f  reason: collision with root package name */
    public byte f7340f;

    public msg_yyz_calibration() {
        this.f6280c = 71;
    }

    public msg_yyz_calibration(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 71;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 3;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 71;
        mAVLinkPacket.f6250f.b(this.f7338d);
        mAVLinkPacket.f6250f.b(this.f7339e);
        mAVLinkPacket.f6250f.b(this.f7340f);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f7338d = aVar.c();
        this.f7339e = aVar.c();
        this.f7340f = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_YYZ_CALIBRATION - target_system:" + this.f7338d + " target_component:" + this.f7339e + " status:" + this.f7340f + "";
    }
}
