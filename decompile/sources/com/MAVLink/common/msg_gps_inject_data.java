package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_gps_inject_data extends MAVLinkMessage {
    private static final long serialVersionUID = 123;

    /* renamed from: d  reason: collision with root package name */
    public byte f6699d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6700e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6701f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f6702g = new byte[110];

    public msg_gps_inject_data() {
        this.f6280c = 123;
    }

    public msg_gps_inject_data(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 123;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6699d = aVar.c();
        this.f6700e = aVar.c();
        this.f6701f = aVar.c();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6702g;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GPS_INJECT_DATA - target_system:" + this.f6699d + " target_component:" + this.f6700e + " len:" + this.f6701f + " data:" + this.f6702g + "";
    }
}
