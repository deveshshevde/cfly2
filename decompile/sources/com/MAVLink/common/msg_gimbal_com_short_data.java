package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_gimbal_com_short_data extends MAVLinkMessage {
    private static final long serialVersionUID = 16;

    /* renamed from: d  reason: collision with root package name */
    public byte f6642d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f6643e = new byte[8];

    public msg_gimbal_com_short_data() {
        this.f6280c = 16;
    }

    public msg_gimbal_com_short_data(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 16;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6642d = aVar.c();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6643e;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GIMBAL_COM_SHORT_DATA - cmd:" + this.f6642d + " data:" + this.f6643e + "";
    }
}
