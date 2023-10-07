package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_statustext extends MAVLinkMessage {
    private static final long serialVersionUID = 253;

    /* renamed from: d  reason: collision with root package name */
    public byte f7267d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f7268e = new byte[50];

    public msg_statustext() {
        this.f6280c = 253;
    }

    public msg_statustext(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 253;
        a(mAVLinkPacket.f6250f);
    }

    public String a() {
        String str = "";
        int i2 = 0;
        while (i2 < 50 && this.f7268e[i2] != 0) {
            str = str + ((char) this.f7268e[i2]);
            i2++;
        }
        return str;
    }

    public void a(a aVar) {
        aVar.b();
        this.f7267d = aVar.c();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f7268e;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_STATUSTEXT - severity:" + this.f7267d + " text:" + this.f7268e + "";
    }
}
