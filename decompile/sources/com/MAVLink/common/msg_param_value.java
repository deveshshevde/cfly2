package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_param_value extends MAVLinkMessage {
    private static final long serialVersionUID = 22;

    /* renamed from: d  reason: collision with root package name */
    public float f7016d;

    /* renamed from: e  reason: collision with root package name */
    public short f7017e;

    /* renamed from: f  reason: collision with root package name */
    public short f7018f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f7019g = new byte[16];

    /* renamed from: h  reason: collision with root package name */
    public byte f7020h;

    public msg_param_value() {
        this.f6280c = 22;
    }

    public msg_param_value(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 22;
        a(mAVLinkPacket.f6250f);
    }

    public String a() {
        String str = "";
        int i2 = 0;
        while (i2 < 16 && this.f7019g[i2] != 0) {
            str = str + ((char) this.f7019g[i2]);
            i2++;
        }
        return str;
    }

    public void a(a aVar) {
        aVar.b();
        this.f7016d = aVar.g();
        this.f7017e = aVar.d();
        this.f7018f = aVar.d();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f7019g;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                this.f7020h = aVar.c();
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_PARAM_VALUE - param_value:" + this.f7016d + " param_count:" + this.f7017e + " param_index:" + this.f7018f + " param_id:" + this.f7019g + " param_type:" + this.f7020h + "";
    }
}
