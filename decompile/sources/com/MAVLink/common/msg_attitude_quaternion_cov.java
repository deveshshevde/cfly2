package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_attitude_quaternion_cov extends MAVLinkMessage {
    private static final long serialVersionUID = 61;

    /* renamed from: d  reason: collision with root package name */
    public int f6531d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f6532e = new float[4];

    /* renamed from: f  reason: collision with root package name */
    public float f6533f;

    /* renamed from: g  reason: collision with root package name */
    public float f6534g;

    /* renamed from: h  reason: collision with root package name */
    public float f6535h;

    /* renamed from: i  reason: collision with root package name */
    public float[] f6536i = new float[9];

    public msg_attitude_quaternion_cov() {
        this.f6280c = 61;
    }

    public msg_attitude_quaternion_cov(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 61;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6531d = aVar.e();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            float[] fArr = this.f6532e;
            if (i3 >= fArr.length) {
                break;
            }
            fArr[i3] = aVar.g();
            i3++;
        }
        this.f6533f = aVar.g();
        this.f6534g = aVar.g();
        this.f6535h = aVar.g();
        while (true) {
            float[] fArr2 = this.f6536i;
            if (i2 < fArr2.length) {
                fArr2[i2] = aVar.g();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ATTITUDE_QUATERNION_COV - time_boot_ms:" + this.f6531d + " q:" + this.f6532e + " rollspeed:" + this.f6533f + " pitchspeed:" + this.f6534g + " yawspeed:" + this.f6535h + " covariance:" + this.f6536i + "";
    }
}
