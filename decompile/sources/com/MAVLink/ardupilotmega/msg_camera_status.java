package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_camera_status extends MAVLinkMessage {
    private static final long serialVersionUID = 179;

    /* renamed from: d  reason: collision with root package name */
    public long f6351d;

    /* renamed from: e  reason: collision with root package name */
    public float f6352e;

    /* renamed from: f  reason: collision with root package name */
    public float f6353f;

    /* renamed from: g  reason: collision with root package name */
    public float f6354g;

    /* renamed from: h  reason: collision with root package name */
    public float f6355h;

    /* renamed from: i  reason: collision with root package name */
    public short f6356i;

    /* renamed from: j  reason: collision with root package name */
    public byte f6357j;

    /* renamed from: k  reason: collision with root package name */
    public byte f6358k;

    /* renamed from: l  reason: collision with root package name */
    public byte f6359l;

    public msg_camera_status() {
        this.f6280c = 179;
    }

    public msg_camera_status(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 179;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6351d = aVar.f();
        this.f6352e = aVar.g();
        this.f6353f = aVar.g();
        this.f6354g = aVar.g();
        this.f6355h = aVar.g();
        this.f6356i = aVar.d();
        this.f6357j = aVar.c();
        this.f6358k = aVar.c();
        this.f6359l = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_CAMERA_STATUS - time_usec:" + this.f6351d + " p1:" + this.f6352e + " p2:" + this.f6353f + " p3:" + this.f6354g + " p4:" + this.f6355h + " img_idx:" + this.f6356i + " target_system:" + this.f6357j + " cam_idx:" + this.f6358k + " event_id:" + this.f6359l + "";
    }
}
