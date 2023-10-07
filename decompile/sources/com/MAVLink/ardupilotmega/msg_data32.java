package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_data32 extends MAVLinkMessage {
    private static final long serialVersionUID = 170;

    /* renamed from: d  reason: collision with root package name */
    public byte f6369d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6370e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f6371f = new byte[32];

    public msg_data32() {
        this.f6280c = 170;
    }

    public msg_data32(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 170;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6369d = aVar.c();
        this.f6370e = aVar.c();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6371f;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DATA32 - type:" + this.f6369d + " len:" + this.f6370e + " data:" + this.f6371f + "";
    }
}
