package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_v2_extension extends MAVLinkMessage {
    private static final long serialVersionUID = 248;

    /* renamed from: d  reason: collision with root package name */
    public short f7302d;

    /* renamed from: e  reason: collision with root package name */
    public byte f7303e;

    /* renamed from: f  reason: collision with root package name */
    public byte f7304f;

    /* renamed from: g  reason: collision with root package name */
    public byte f7305g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f7306h = new byte[249];

    public msg_v2_extension() {
        this.f6280c = 248;
    }

    public msg_v2_extension(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 248;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7302d = aVar.d();
        this.f7303e = aVar.c();
        this.f7304f = aVar.c();
        this.f7305g = aVar.c();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f7306h;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_V2_EXTENSION - message_type:" + this.f7302d + " target_network:" + this.f7303e + " target_system:" + this.f7304f + " target_component:" + this.f7305g + " payload:" + this.f7306h + "";
    }
}
