package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_log_data extends MAVLinkMessage {
    private static final long serialVersionUID = 120;

    /* renamed from: d  reason: collision with root package name */
    public int f6883d;

    /* renamed from: e  reason: collision with root package name */
    public short f6884e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6885f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f6886g = new byte[90];

    public msg_log_data() {
        this.f6280c = 120;
    }

    public msg_log_data(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 120;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6883d = aVar.e();
        this.f6884e = aVar.d();
        this.f6885f = aVar.c();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6886g;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOG_DATA - ofs:" + this.f6883d + " id:" + this.f6884e + " count:" + this.f6885f + " data:" + this.f6886g + "";
    }
}
