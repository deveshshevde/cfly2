package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_set_attitude_target extends MAVLinkMessage {
    private static final long serialVersionUID = 82;

    /* renamed from: d  reason: collision with root package name */
    public int f7194d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f7195e = new float[4];

    /* renamed from: f  reason: collision with root package name */
    public float f7196f;

    /* renamed from: g  reason: collision with root package name */
    public float f7197g;

    /* renamed from: h  reason: collision with root package name */
    public float f7198h;

    /* renamed from: i  reason: collision with root package name */
    public float f7199i;

    /* renamed from: j  reason: collision with root package name */
    public byte f7200j;

    /* renamed from: k  reason: collision with root package name */
    public byte f7201k;

    /* renamed from: l  reason: collision with root package name */
    public byte f7202l;

    public msg_set_attitude_target() {
        this.f6280c = 82;
    }

    public msg_set_attitude_target(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 82;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7194d = aVar.e();
        int i2 = 0;
        while (true) {
            float[] fArr = this.f7195e;
            if (i2 < fArr.length) {
                fArr[i2] = aVar.g();
                i2++;
            } else {
                this.f7196f = aVar.g();
                this.f7197g = aVar.g();
                this.f7198h = aVar.g();
                this.f7199i = aVar.g();
                this.f7200j = aVar.c();
                this.f7201k = aVar.c();
                this.f7202l = aVar.c();
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_ATTITUDE_TARGET - time_boot_ms:" + this.f7194d + " q:" + this.f7195e + " body_roll_rate:" + this.f7196f + " body_pitch_rate:" + this.f7197g + " body_yaw_rate:" + this.f7198h + " thrust:" + this.f7199i + " target_system:" + this.f7200j + " target_component:" + this.f7201k + " type_mask:" + this.f7202l + "";
    }
}
