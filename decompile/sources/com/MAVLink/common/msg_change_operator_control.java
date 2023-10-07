package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_change_operator_control extends MAVLinkMessage {
    private static final long serialVersionUID = 5;

    /* renamed from: d  reason: collision with root package name */
    public byte f6557d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6558e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6559f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f6560g = new byte[25];

    public msg_change_operator_control() {
        this.f6280c = 5;
    }

    public msg_change_operator_control(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 5;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6557d = aVar.c();
        this.f6558e = aVar.c();
        this.f6559f = aVar.c();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6560g;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL - target_system:" + this.f6557d + " control_request:" + this.f6558e + " version:" + this.f6559f + " passkey:" + this.f6560g + "";
    }
}
