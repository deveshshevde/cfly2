package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_serial_control extends MAVLinkMessage {
    private static final long serialVersionUID = 126;

    /* renamed from: d  reason: collision with root package name */
    public int f7178d;

    /* renamed from: e  reason: collision with root package name */
    public short f7179e;

    /* renamed from: f  reason: collision with root package name */
    public byte f7180f;

    /* renamed from: g  reason: collision with root package name */
    public byte f7181g;

    /* renamed from: h  reason: collision with root package name */
    public byte f7182h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f7183i = new byte[70];

    public msg_serial_control() {
        this.f6280c = 126;
    }

    public msg_serial_control(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 126;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7178d = aVar.e();
        this.f7179e = aVar.d();
        this.f7180f = aVar.c();
        this.f7181g = aVar.c();
        this.f7182h = aVar.c();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f7183i;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SERIAL_CONTROL - baudrate:" + this.f7178d + " timeout:" + this.f7179e + " device:" + this.f7180f + " flags:" + this.f7181g + " count:" + this.f7182h + " data:" + this.f7183i + "";
    }
}
