package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_hil_state_quaternion extends MAVLinkMessage {
    private static final long serialVersionUID = 115;

    /* renamed from: d  reason: collision with root package name */
    public long f6830d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f6831e = new float[4];

    /* renamed from: f  reason: collision with root package name */
    public float f6832f;

    /* renamed from: g  reason: collision with root package name */
    public float f6833g;

    /* renamed from: h  reason: collision with root package name */
    public float f6834h;

    /* renamed from: i  reason: collision with root package name */
    public int f6835i;

    /* renamed from: j  reason: collision with root package name */
    public int f6836j;

    /* renamed from: k  reason: collision with root package name */
    public int f6837k;

    /* renamed from: l  reason: collision with root package name */
    public short f6838l;

    /* renamed from: m  reason: collision with root package name */
    public short f6839m;

    /* renamed from: n  reason: collision with root package name */
    public short f6840n;

    /* renamed from: o  reason: collision with root package name */
    public short f6841o;

    /* renamed from: p  reason: collision with root package name */
    public short f6842p;

    /* renamed from: q  reason: collision with root package name */
    public short f6843q;

    /* renamed from: r  reason: collision with root package name */
    public short f6844r;

    /* renamed from: s  reason: collision with root package name */
    public short f6845s;

    public msg_hil_state_quaternion() {
        this.f6280c = 115;
    }

    public msg_hil_state_quaternion(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 115;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6830d = aVar.f();
        int i2 = 0;
        while (true) {
            float[] fArr = this.f6831e;
            if (i2 < fArr.length) {
                fArr[i2] = aVar.g();
                i2++;
            } else {
                this.f6832f = aVar.g();
                this.f6833g = aVar.g();
                this.f6834h = aVar.g();
                this.f6835i = aVar.e();
                this.f6836j = aVar.e();
                this.f6837k = aVar.e();
                this.f6838l = aVar.d();
                this.f6839m = aVar.d();
                this.f6840n = aVar.d();
                this.f6841o = aVar.d();
                this.f6842p = aVar.d();
                this.f6843q = aVar.d();
                this.f6844r = aVar.d();
                this.f6845s = aVar.d();
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HIL_STATE_QUATERNION - time_usec:" + this.f6830d + " attitude_quaternion:" + this.f6831e + " rollspeed:" + this.f6832f + " pitchspeed:" + this.f6833g + " yawspeed:" + this.f6834h + " lat:" + this.f6835i + " lon:" + this.f6836j + " alt:" + this.f6837k + " vx:" + this.f6838l + " vy:" + this.f6839m + " vz:" + this.f6840n + " ind_airspeed:" + this.f6841o + " true_airspeed:" + this.f6842p + " xacc:" + this.f6843q + " yacc:" + this.f6844r + " zacc:" + this.f6845s + "";
    }
}
