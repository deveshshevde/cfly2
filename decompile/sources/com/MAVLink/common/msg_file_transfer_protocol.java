package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_file_transfer_protocol extends MAVLinkMessage {
    private static final long serialVersionUID = 110;

    /* renamed from: d  reason: collision with root package name */
    public byte f6637d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6638e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6639f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f6640g = new byte[251];

    public msg_file_transfer_protocol() {
        this.f6280c = 110;
    }

    public msg_file_transfer_protocol(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 110;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6637d = aVar.c();
        this.f6638e = aVar.c();
        this.f6639f = aVar.c();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6640g;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_FILE_TRANSFER_PROTOCOL - target_network:" + this.f6637d + " target_system:" + this.f6638e + " target_component:" + this.f6639f + " payload:" + this.f6640g + "";
    }
}
