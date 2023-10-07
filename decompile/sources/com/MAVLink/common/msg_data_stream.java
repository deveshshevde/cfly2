package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_data_stream extends MAVLinkMessage {
    private static final long serialVersionUID = 67;

    /* renamed from: d  reason: collision with root package name */
    public short f6607d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6608e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6609f;

    public msg_data_stream() {
        this.f6280c = 67;
    }

    public msg_data_stream(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 67;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6607d = aVar.d();
        this.f6608e = aVar.c();
        this.f6609f = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DATA_STREAM - message_rate:" + this.f6607d + " stream_id:" + this.f6608e + " on_off:" + this.f6609f + "";
    }
}
