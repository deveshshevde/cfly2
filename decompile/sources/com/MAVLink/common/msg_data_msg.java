package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_data_msg extends MAVLinkMessage {
    private static final long serialVersionUID = 12;

    /* renamed from: d  reason: collision with root package name */
    public int f6601d;

    /* renamed from: e  reason: collision with root package name */
    public int f6602e;

    /* renamed from: f  reason: collision with root package name */
    public short f6603f;

    /* renamed from: g  reason: collision with root package name */
    public short f6604g;

    /* renamed from: h  reason: collision with root package name */
    public byte f6605h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6606i;

    public msg_data_msg() {
        this.f6280c = 12;
    }

    public msg_data_msg(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 12;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 14;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 12;
        mAVLinkPacket.f6250f.a(this.f6601d);
        mAVLinkPacket.f6250f.a(this.f6602e);
        mAVLinkPacket.f6250f.a(this.f6603f);
        mAVLinkPacket.f6250f.a(this.f6604g);
        mAVLinkPacket.f6250f.b(this.f6605h);
        mAVLinkPacket.f6250f.b(this.f6606i);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f6601d = aVar.e();
        this.f6602e = aVar.e();
        this.f6603f = aVar.d();
        this.f6604g = aVar.d();
        this.f6605h = aVar.c();
        this.f6606i = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DATA_MSG - lat:" + this.f6601d + " lon:" + this.f6602e + " alt:" + this.f6603f + " vol_bat:" + this.f6604g + " gps_num:" + this.f6605h + "";
    }
}
