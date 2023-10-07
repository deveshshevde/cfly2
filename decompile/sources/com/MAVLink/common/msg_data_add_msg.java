package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_data_add_msg extends MAVLinkMessage {
    private static final long serialVersionUID = 72;

    /* renamed from: d  reason: collision with root package name */
    public short f6596d;

    /* renamed from: e  reason: collision with root package name */
    public short f6597e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6598f;

    /* renamed from: g  reason: collision with root package name */
    public byte f6599g;

    /* renamed from: h  reason: collision with root package name */
    public byte f6600h;

    public msg_data_add_msg() {
        this.f6280c = 72;
    }

    public msg_data_add_msg(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 72;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 72;
        mAVLinkPacket.f6245a = 7;
        mAVLinkPacket.f6250f.a(this.f6596d);
        mAVLinkPacket.f6250f.a(this.f6597e);
        mAVLinkPacket.f6250f.b(this.f6598f);
        mAVLinkPacket.f6250f.b(this.f6599g);
        mAVLinkPacket.f6250f.b(this.f6600h);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f6596d = aVar.d();
        this.f6597e = aVar.d();
        this.f6598f = aVar.c();
        this.f6599g = aVar.c();
        this.f6600h = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DATA_ADD_MSG - gps_vertical_vel:" + this.f6596d + " head_angel:" + this.f6597e + " gps_level_vel:" + this.f6598f + " gps_hdop:" + this.f6599g + " rssi:" + this.f6600h + "";
    }
}
