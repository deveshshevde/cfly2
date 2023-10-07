package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_gimbal_com_cmd extends MAVLinkMessage {
    private static final long serialVersionUID = 14;

    /* renamed from: d  reason: collision with root package name */
    public byte f6641d;

    public msg_gimbal_com_cmd() {
        this.f6280c = 14;
    }

    public msg_gimbal_com_cmd(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 14;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6641d = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GIMBAL_COM_CMD - cmd:" + this.f6641d + "";
    }
}
