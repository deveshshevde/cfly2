package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_sensor_offsets extends MAVLinkMessage {
    private static final long serialVersionUID = 150;

    /* renamed from: d  reason: collision with root package name */
    public float f6464d;

    /* renamed from: e  reason: collision with root package name */
    public int f6465e;

    /* renamed from: f  reason: collision with root package name */
    public int f6466f;

    /* renamed from: g  reason: collision with root package name */
    public float f6467g;

    /* renamed from: h  reason: collision with root package name */
    public float f6468h;

    /* renamed from: i  reason: collision with root package name */
    public float f6469i;

    /* renamed from: j  reason: collision with root package name */
    public float f6470j;

    /* renamed from: k  reason: collision with root package name */
    public float f6471k;

    /* renamed from: l  reason: collision with root package name */
    public float f6472l;

    /* renamed from: m  reason: collision with root package name */
    public short f6473m;

    /* renamed from: n  reason: collision with root package name */
    public short f6474n;

    /* renamed from: o  reason: collision with root package name */
    public short f6475o;

    public msg_sensor_offsets() {
        this.f6280c = 150;
    }

    public msg_sensor_offsets(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 150;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6464d = aVar.g();
        this.f6465e = aVar.e();
        this.f6466f = aVar.e();
        this.f6467g = aVar.g();
        this.f6468h = aVar.g();
        this.f6469i = aVar.g();
        this.f6470j = aVar.g();
        this.f6471k = aVar.g();
        this.f6472l = aVar.g();
        this.f6473m = aVar.d();
        this.f6474n = aVar.d();
        this.f6475o = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SENSOR_OFFSETS - mag_declination:" + this.f6464d + " raw_press:" + this.f6465e + " raw_temp:" + this.f6466f + " gyro_cal_x:" + this.f6467g + " gyro_cal_y:" + this.f6468h + " gyro_cal_z:" + this.f6469i + " accel_cal_x:" + this.f6470j + " accel_cal_y:" + this.f6471k + " accel_cal_z:" + this.f6472l + " mag_ofs_x:" + this.f6473m + " mag_ofs_y:" + this.f6474n + " mag_ofs_z:" + this.f6475o + "";
    }
}
