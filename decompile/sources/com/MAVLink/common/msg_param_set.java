package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_param_set extends MAVLinkMessage {
    private static final long serialVersionUID = 23;

    /* renamed from: d  reason: collision with root package name */
    public float f7011d;

    /* renamed from: e  reason: collision with root package name */
    public byte f7012e;

    /* renamed from: f  reason: collision with root package name */
    public byte f7013f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f7014g = new byte[16];

    /* renamed from: h  reason: collision with root package name */
    public byte f7015h;

    public msg_param_set() {
        this.f6280c = 23;
    }

    public msg_param_set(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 23;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 23;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 23;
        mAVLinkPacket.f6250f.a(this.f7011d);
        mAVLinkPacket.f6250f.b(this.f7012e);
        mAVLinkPacket.f6250f.b(this.f7013f);
        for (byte b2 : this.f7014g) {
            mAVLinkPacket.f6250f.b(b2);
        }
        mAVLinkPacket.f6250f.b(this.f7015h);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f7011d = aVar.g();
        this.f7012e = aVar.c();
        this.f7013f = aVar.c();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f7014g;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                this.f7015h = aVar.c();
                return;
            }
        }
    }

    public void a(String str) {
        int min = Math.min(str.length(), 16);
        for (int i2 = 0; i2 < min; i2++) {
            this.f7014g[i2] = (byte) str.charAt(i2);
        }
        while (min < 16) {
            this.f7014g[min] = 0;
            min++;
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_PARAM_SET - param_value:" + this.f7011d + " target_system:" + this.f7012e + " target_component:" + this.f7013f + " param_id:" + this.f7014g + " param_type:" + this.f7015h + "";
    }
}
