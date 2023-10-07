package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_autopilot_version extends MAVLinkMessage {
    private static final long serialVersionUID = 148;

    /* renamed from: d  reason: collision with root package name */
    public long f6545d;

    /* renamed from: e  reason: collision with root package name */
    public int f6546e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f6547f = new byte[8];

    public msg_autopilot_version() {
        this.f6280c = 148;
    }

    public msg_autopilot_version(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 148;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6545d = aVar.f();
        this.f6546e = aVar.e();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6547f;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_AUTOPILOT_VERSION - capabilities:" + this.f6545d + " version:" + this.f6546e + " custom_version:" + this.f6547f + "";
    }
}
