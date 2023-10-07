package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_rally_point extends MAVLinkMessage {
    private static final long serialVersionUID = 175;

    /* renamed from: d  reason: collision with root package name */
    public int f6452d;

    /* renamed from: e  reason: collision with root package name */
    public int f6453e;

    /* renamed from: f  reason: collision with root package name */
    public short f6454f;

    /* renamed from: g  reason: collision with root package name */
    public short f6455g;

    /* renamed from: h  reason: collision with root package name */
    public short f6456h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6457i;

    /* renamed from: j  reason: collision with root package name */
    public byte f6458j;

    /* renamed from: k  reason: collision with root package name */
    public byte f6459k;

    /* renamed from: l  reason: collision with root package name */
    public byte f6460l;

    /* renamed from: m  reason: collision with root package name */
    public byte f6461m;

    public msg_rally_point() {
        this.f6280c = 175;
    }

    public msg_rally_point(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 175;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6452d = aVar.e();
        this.f6453e = aVar.e();
        this.f6454f = aVar.d();
        this.f6455g = aVar.d();
        this.f6456h = aVar.d();
        this.f6457i = aVar.c();
        this.f6458j = aVar.c();
        this.f6459k = aVar.c();
        this.f6460l = aVar.c();
        this.f6461m = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RALLY_POINT - lat:" + this.f6452d + " lng:" + this.f6453e + " alt:" + this.f6454f + " break_alt:" + this.f6455g + " land_dir:" + this.f6456h + " target_system:" + this.f6457i + " target_component:" + this.f6458j + " idx:" + this.f6459k + " count:" + this.f6460l + " flags:" + this.f6461m + "";
    }
}
