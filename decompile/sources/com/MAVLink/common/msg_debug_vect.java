package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_debug_vect extends MAVLinkMessage {
    private static final long serialVersionUID = 250;

    /* renamed from: d  reason: collision with root package name */
    public long f6620d;

    /* renamed from: e  reason: collision with root package name */
    public float f6621e;

    /* renamed from: f  reason: collision with root package name */
    public float f6622f;

    /* renamed from: g  reason: collision with root package name */
    public float f6623g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f6624h = new byte[10];

    public msg_debug_vect() {
        this.f6280c = 250;
    }

    public msg_debug_vect(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 250;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6620d = aVar.f();
        this.f6621e = aVar.g();
        this.f6622f = aVar.g();
        this.f6623g = aVar.g();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6624h;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DEBUG_VECT - time_usec:" + this.f6620d + " x:" + this.f6621e + " y:" + this.f6622f + " z:" + this.f6623g + " name:" + this.f6624h + "";
    }
}
