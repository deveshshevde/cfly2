package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_meminfo extends MAVLinkMessage {
    private static final long serialVersionUID = 152;

    /* renamed from: d  reason: collision with root package name */
    public short f6423d;

    /* renamed from: e  reason: collision with root package name */
    public short f6424e;

    public msg_meminfo() {
        this.f6280c = 152;
    }

    public msg_meminfo(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 152;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6423d = aVar.d();
        this.f6424e = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MEMINFO - brkval:" + this.f6423d + " freemem:" + this.f6424e + "";
    }
}
