package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_attitude_target extends MAVLinkMessage {
    private static final long serialVersionUID = 83;

    /* renamed from: d  reason: collision with root package name */
    public int f6537d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f6538e = new float[4];

    /* renamed from: f  reason: collision with root package name */
    public float f6539f;

    /* renamed from: g  reason: collision with root package name */
    public float f6540g;

    /* renamed from: h  reason: collision with root package name */
    public float f6541h;

    /* renamed from: i  reason: collision with root package name */
    public float f6542i;

    /* renamed from: j  reason: collision with root package name */
    public byte f6543j;

    public msg_attitude_target() {
        this.f6280c = 83;
    }

    public msg_attitude_target(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 83;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6537d = aVar.e();
        int i2 = 0;
        while (true) {
            float[] fArr = this.f6538e;
            if (i2 < fArr.length) {
                fArr[i2] = aVar.g();
                i2++;
            } else {
                this.f6539f = aVar.g();
                this.f6540g = aVar.g();
                this.f6541h = aVar.g();
                this.f6542i = aVar.g();
                this.f6543j = aVar.c();
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ATTITUDE_TARGET - time_boot_ms:" + this.f6537d + " q:" + this.f6538e + " body_roll_rate:" + this.f6539f + " body_pitch_rate:" + this.f6540g + " body_yaw_rate:" + this.f6541h + " thrust:" + this.f6542i + " type_mask:" + this.f6543j + "";
    }
}
