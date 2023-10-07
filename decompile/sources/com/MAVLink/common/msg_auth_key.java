package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_auth_key extends MAVLinkMessage {
    private static final long serialVersionUID = 7;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f6544d = new byte[32];

    public msg_auth_key() {
        this.f6280c = 7;
    }

    public msg_auth_key(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 7;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6544d;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_AUTH_KEY - key:" + this.f6544d + "";
    }
}
