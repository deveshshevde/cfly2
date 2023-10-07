package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_request_data_stream extends MAVLinkMessage {
    private static final long serialVersionUID = 66;

    /* renamed from: d  reason: collision with root package name */
    public short f7133d;

    /* renamed from: e  reason: collision with root package name */
    public byte f7134e;

    /* renamed from: f  reason: collision with root package name */
    public byte f7135f;

    /* renamed from: g  reason: collision with root package name */
    public byte f7136g;

    /* renamed from: h  reason: collision with root package name */
    public byte f7137h;

    public msg_request_data_stream() {
        this.f6280c = 66;
    }

    public msg_request_data_stream(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 66;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 6;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 66;
        mAVLinkPacket.f6250f.a(this.f7133d);
        mAVLinkPacket.f6250f.b(this.f7134e);
        mAVLinkPacket.f6250f.b(this.f7135f);
        mAVLinkPacket.f6250f.b(this.f7136g);
        mAVLinkPacket.f6250f.b(this.f7137h);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f7133d = aVar.d();
        this.f7134e = aVar.c();
        this.f7135f = aVar.c();
        this.f7136g = aVar.c();
        this.f7137h = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_REQUEST_DATA_STREAM - req_message_rate:" + this.f7133d + " target_system:" + this.f7134e + " target_component:" + this.f7135f + " req_stream_id:" + this.f7136g + " start_stop:" + this.f7137h + "";
    }
}
