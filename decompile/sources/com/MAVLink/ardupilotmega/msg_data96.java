package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_data96 extends MAVLinkMessage {
    private static final long serialVersionUID = 172;

    /* renamed from: d  reason: collision with root package name */
    public byte f6375d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6376e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f6377f = new byte[96];

    public msg_data96() {
        this.f6280c = 172;
    }

    public msg_data96(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 172;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6375d = aVar.c();
        this.f6376e = aVar.c();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6377f;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DATA96 - type:" + this.f6375d + " len:" + this.f6376e + " data:" + this.f6377f + "";
    }
}
