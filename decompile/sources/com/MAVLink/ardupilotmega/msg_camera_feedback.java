package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_camera_feedback extends MAVLinkMessage {
    private static final long serialVersionUID = 180;

    /* renamed from: d  reason: collision with root package name */
    public long f6338d;

    /* renamed from: e  reason: collision with root package name */
    public int f6339e;

    /* renamed from: f  reason: collision with root package name */
    public int f6340f;

    /* renamed from: g  reason: collision with root package name */
    public float f6341g;

    /* renamed from: h  reason: collision with root package name */
    public float f6342h;

    /* renamed from: i  reason: collision with root package name */
    public float f6343i;

    /* renamed from: j  reason: collision with root package name */
    public float f6344j;

    /* renamed from: k  reason: collision with root package name */
    public float f6345k;

    /* renamed from: l  reason: collision with root package name */
    public float f6346l;

    /* renamed from: m  reason: collision with root package name */
    public short f6347m;

    /* renamed from: n  reason: collision with root package name */
    public byte f6348n;

    /* renamed from: o  reason: collision with root package name */
    public byte f6349o;

    /* renamed from: p  reason: collision with root package name */
    public byte f6350p;

    public msg_camera_feedback() {
        this.f6280c = 180;
    }

    public msg_camera_feedback(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 180;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6338d = aVar.f();
        this.f6339e = aVar.e();
        this.f6340f = aVar.e();
        this.f6341g = aVar.g();
        this.f6342h = aVar.g();
        this.f6343i = aVar.g();
        this.f6344j = aVar.g();
        this.f6345k = aVar.g();
        this.f6346l = aVar.g();
        this.f6347m = aVar.d();
        this.f6348n = aVar.c();
        this.f6349o = aVar.c();
        this.f6350p = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_CAMERA_FEEDBACK - time_usec:" + this.f6338d + " lat:" + this.f6339e + " lng:" + this.f6340f + " alt_msl:" + this.f6341g + " alt_rel:" + this.f6342h + " roll:" + this.f6343i + " pitch:" + this.f6344j + " yaw:" + this.f6345k + " foc_len:" + this.f6346l + " img_idx:" + this.f6347m + " target_system:" + this.f6348n + " cam_idx:" + this.f6349o + " flags:" + this.f6350p + "";
    }
}
