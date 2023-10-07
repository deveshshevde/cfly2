package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_omnidirectional_flow extends MAVLinkMessage {
    private static final long serialVersionUID = 106;

    /* renamed from: d  reason: collision with root package name */
    public long f6991d;

    /* renamed from: e  reason: collision with root package name */
    public float f6992e;

    /* renamed from: f  reason: collision with root package name */
    public short[] f6993f = new short[10];

    /* renamed from: g  reason: collision with root package name */
    public short[] f6994g = new short[10];

    /* renamed from: h  reason: collision with root package name */
    public byte f6995h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6996i;

    public msg_omnidirectional_flow() {
        this.f6280c = 106;
    }

    public msg_omnidirectional_flow(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 106;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6991d = aVar.f();
        this.f6992e = aVar.g();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            short[] sArr = this.f6993f;
            if (i3 >= sArr.length) {
                break;
            }
            sArr[i3] = aVar.d();
            i3++;
        }
        while (true) {
            short[] sArr2 = this.f6994g;
            if (i2 < sArr2.length) {
                sArr2[i2] = aVar.d();
                i2++;
            } else {
                this.f6995h = aVar.c();
                this.f6996i = aVar.c();
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_OMNIDIRECTIONAL_FLOW - time_usec:" + this.f6991d + " front_distance_m:" + this.f6992e + " left:" + this.f6993f + " right:" + this.f6994g + " sensor_id:" + this.f6995h + " quality:" + this.f6996i + "";
    }
}
