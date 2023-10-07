package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_change_operator_control_ack extends MAVLinkMessage {
    private static final long serialVersionUID = 6;

    /* renamed from: d  reason: collision with root package name */
    public byte f6561d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6562e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6563f;

    public msg_change_operator_control_ack() {
        this.f6280c = 6;
    }

    public msg_change_operator_control_ack(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 6;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6561d = aVar.c();
        this.f6562e = aVar.c();
        this.f6563f = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK - gcs_system_id:" + this.f6561d + " control_request:" + this.f6562e + " ack:" + this.f6563f + "";
    }
}
