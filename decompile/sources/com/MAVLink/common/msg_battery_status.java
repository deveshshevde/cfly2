package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_battery_status extends MAVLinkMessage {
    private static final long serialVersionUID = 147;

    /* renamed from: d  reason: collision with root package name */
    public int f6548d;

    /* renamed from: e  reason: collision with root package name */
    public int f6549e;

    /* renamed from: f  reason: collision with root package name */
    public short f6550f;

    /* renamed from: g  reason: collision with root package name */
    public short[] f6551g = new short[10];

    /* renamed from: h  reason: collision with root package name */
    public short f6552h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6553i;

    /* renamed from: j  reason: collision with root package name */
    public byte f6554j;

    /* renamed from: k  reason: collision with root package name */
    public byte f6555k;

    /* renamed from: l  reason: collision with root package name */
    public byte f6556l;

    public msg_battery_status() {
        this.f6280c = 147;
    }

    public msg_battery_status(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 147;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6548d = aVar.e();
        this.f6549e = aVar.e();
        this.f6550f = aVar.d();
        int i2 = 0;
        while (true) {
            short[] sArr = this.f6551g;
            if (i2 < sArr.length) {
                sArr[i2] = aVar.d();
                i2++;
            } else {
                this.f6552h = aVar.d();
                this.f6553i = aVar.c();
                this.f6554j = aVar.c();
                this.f6555k = aVar.c();
                this.f6556l = aVar.c();
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_BATTERY_STATUS - current_consumed:" + this.f6548d + " energy_consumed:" + this.f6549e + " temperature:" + this.f6550f + " voltages:" + this.f6551g + " current_battery:" + this.f6552h + " id:" + this.f6553i + " function:" + this.f6554j + " type:" + this.f6555k + " battery_remaining:" + this.f6556l + "";
    }
}
