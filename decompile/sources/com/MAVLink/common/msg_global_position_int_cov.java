package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_global_position_int_cov extends MAVLinkMessage {
    private static final long serialVersionUID = 63;

    /* renamed from: d  reason: collision with root package name */
    public long f6653d;

    /* renamed from: e  reason: collision with root package name */
    public int f6654e;

    /* renamed from: f  reason: collision with root package name */
    public int f6655f;

    /* renamed from: g  reason: collision with root package name */
    public int f6656g;

    /* renamed from: h  reason: collision with root package name */
    public int f6657h;

    /* renamed from: i  reason: collision with root package name */
    public int f6658i;

    /* renamed from: j  reason: collision with root package name */
    public float f6659j;

    /* renamed from: k  reason: collision with root package name */
    public float f6660k;

    /* renamed from: l  reason: collision with root package name */
    public float f6661l;

    /* renamed from: m  reason: collision with root package name */
    public float[] f6662m = new float[36];

    /* renamed from: n  reason: collision with root package name */
    public byte f6663n;

    public msg_global_position_int_cov() {
        this.f6280c = 63;
    }

    public msg_global_position_int_cov(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 63;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6653d = aVar.f();
        this.f6654e = aVar.e();
        this.f6655f = aVar.e();
        this.f6656g = aVar.e();
        this.f6657h = aVar.e();
        this.f6658i = aVar.e();
        this.f6659j = aVar.g();
        this.f6660k = aVar.g();
        this.f6661l = aVar.g();
        int i2 = 0;
        while (true) {
            float[] fArr = this.f6662m;
            if (i2 < fArr.length) {
                fArr[i2] = aVar.g();
                i2++;
            } else {
                this.f6663n = aVar.c();
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GLOBAL_POSITION_INT_COV - time_utc:" + this.f6653d + " time_boot_ms:" + this.f6654e + " lat:" + this.f6655f + " lon:" + this.f6656g + " alt:" + this.f6657h + " relative_alt:" + this.f6658i + " vx:" + this.f6659j + " vy:" + this.f6660k + " vz:" + this.f6661l + " covariance:" + this.f6662m + " estimator_type:" + this.f6663n + "";
    }
}
