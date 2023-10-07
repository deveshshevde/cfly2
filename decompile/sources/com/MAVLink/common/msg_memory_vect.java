package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_memory_vect extends MAVLinkMessage {
    private static final long serialVersionUID = 249;

    /* renamed from: d  reason: collision with root package name */
    public short f6918d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6919e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6920f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f6921g = new byte[32];

    public msg_memory_vect() {
        this.f6280c = 249;
    }

    public msg_memory_vect(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 249;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6918d = aVar.d();
        this.f6919e = aVar.c();
        this.f6920f = aVar.c();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6921g;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MEMORY_VECT - address:" + this.f6918d + " ver:" + this.f6919e + " type:" + this.f6920f + " value:" + this.f6921g + "";
    }
}
