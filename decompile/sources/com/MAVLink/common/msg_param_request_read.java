package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_param_request_read extends MAVLinkMessage {
    private static final long serialVersionUID = 20;

    /* renamed from: d  reason: collision with root package name */
    public short f7007d;

    /* renamed from: e  reason: collision with root package name */
    public byte f7008e;

    /* renamed from: f  reason: collision with root package name */
    public byte f7009f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f7010g = new byte[16];

    public msg_param_request_read() {
        this.f6280c = 20;
    }

    public msg_param_request_read(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 20;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 20;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 20;
        mAVLinkPacket.f6250f.a(this.f7007d);
        mAVLinkPacket.f6250f.b(this.f7008e);
        mAVLinkPacket.f6250f.b(this.f7009f);
        for (byte b2 : this.f7010g) {
            mAVLinkPacket.f6250f.b(b2);
        }
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f7007d = aVar.d();
        this.f7008e = aVar.c();
        this.f7009f = aVar.c();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f7010g;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public void a(String str) {
        int min = Math.min(str.length(), 16);
        for (int i2 = 0; i2 < min; i2++) {
            this.f7010g[i2] = (byte) str.charAt(i2);
        }
        while (min < 16) {
            this.f7010g[min] = 0;
            min++;
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_PARAM_REQUEST_READ - param_index:" + this.f7007d + " target_system:" + this.f7008e + " target_component:" + this.f7009f + " param_id:" + this.f7010g + "";
    }
}
