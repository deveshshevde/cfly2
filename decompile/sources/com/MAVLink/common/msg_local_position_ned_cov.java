package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_local_position_ned_cov extends MAVLinkMessage {
    private static final long serialVersionUID = 64;

    /* renamed from: d  reason: collision with root package name */
    public long f6866d;

    /* renamed from: e  reason: collision with root package name */
    public int f6867e;

    /* renamed from: f  reason: collision with root package name */
    public float f6868f;

    /* renamed from: g  reason: collision with root package name */
    public float f6869g;

    /* renamed from: h  reason: collision with root package name */
    public float f6870h;

    /* renamed from: i  reason: collision with root package name */
    public float f6871i;

    /* renamed from: j  reason: collision with root package name */
    public float f6872j;

    /* renamed from: k  reason: collision with root package name */
    public float f6873k;

    /* renamed from: l  reason: collision with root package name */
    public float[] f6874l = new float[36];

    /* renamed from: m  reason: collision with root package name */
    public byte f6875m;

    public msg_local_position_ned_cov() {
        this.f6280c = 64;
    }

    public msg_local_position_ned_cov(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 64;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6866d = aVar.f();
        this.f6867e = aVar.e();
        this.f6868f = aVar.g();
        this.f6869g = aVar.g();
        this.f6870h = aVar.g();
        this.f6871i = aVar.g();
        this.f6872j = aVar.g();
        this.f6873k = aVar.g();
        int i2 = 0;
        while (true) {
            float[] fArr = this.f6874l;
            if (i2 < fArr.length) {
                fArr[i2] = aVar.g();
                i2++;
            } else {
                this.f6875m = aVar.c();
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOCAL_POSITION_NED_COV - time_utc:" + this.f6866d + " time_boot_ms:" + this.f6867e + " x:" + this.f6868f + " y:" + this.f6869g + " z:" + this.f6870h + " vx:" + this.f6871i + " vy:" + this.f6872j + " vz:" + this.f6873k + " covariance:" + this.f6874l + " estimator_type:" + this.f6875m + "";
    }
}
