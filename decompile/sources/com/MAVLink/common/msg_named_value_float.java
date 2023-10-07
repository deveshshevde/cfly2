package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_named_value_float extends MAVLinkMessage {
    private static final long serialVersionUID = 251;

    /* renamed from: d  reason: collision with root package name */
    public int f6977d;

    /* renamed from: e  reason: collision with root package name */
    public float f6978e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f6979f = new byte[10];

    public msg_named_value_float() {
        this.f6280c = 251;
    }

    public msg_named_value_float(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 251;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6977d = aVar.e();
        this.f6978e = aVar.g();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6979f;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_NAMED_VALUE_FLOAT - time_boot_ms:" + this.f6977d + " value:" + this.f6978e + " name:" + this.f6979f + "";
    }
}
