package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_data16 extends MAVLinkMessage {
    private static final long serialVersionUID = 169;

    /* renamed from: d  reason: collision with root package name */
    public byte f6366d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6367e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f6368f = new byte[16];

    public msg_data16() {
        this.f6280c = 169;
    }

    public msg_data16(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 169;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6366d = aVar.c();
        this.f6367e = aVar.c();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6368f;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DATA16 - type:" + this.f6366d + " len:" + this.f6367e + " data:" + this.f6368f + "";
    }
}
