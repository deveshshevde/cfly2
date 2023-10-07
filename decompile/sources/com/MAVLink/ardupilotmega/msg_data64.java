package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_data64 extends MAVLinkMessage {
    private static final long serialVersionUID = 171;

    /* renamed from: d  reason: collision with root package name */
    public byte f6372d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6373e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f6374f = new byte[64];

    public msg_data64() {
        this.f6280c = 171;
    }

    public msg_data64(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 171;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6372d = aVar.c();
        this.f6373e = aVar.c();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6374f;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DATA64 - type:" + this.f6372d + " len:" + this.f6373e + " data:" + this.f6374f + "";
    }
}
