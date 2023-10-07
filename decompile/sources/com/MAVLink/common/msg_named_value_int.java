package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_named_value_int extends MAVLinkMessage {
    private static final long serialVersionUID = 252;

    /* renamed from: d  reason: collision with root package name */
    public int f6980d;

    /* renamed from: e  reason: collision with root package name */
    public int f6981e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f6982f = new byte[10];

    public msg_named_value_int() {
        this.f6280c = 252;
    }

    public msg_named_value_int(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 252;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6980d = aVar.e();
        this.f6981e = aVar.e();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6982f;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_NAMED_VALUE_INT - time_boot_ms:" + this.f6980d + " value:" + this.f6981e + " name:" + this.f6982f + "";
    }
}
