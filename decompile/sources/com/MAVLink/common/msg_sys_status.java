package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_sys_status extends MAVLinkMessage {
    private static final long serialVersionUID = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f7269d;

    /* renamed from: e  reason: collision with root package name */
    public int f7270e;

    /* renamed from: f  reason: collision with root package name */
    public int f7271f;

    /* renamed from: g  reason: collision with root package name */
    public short f7272g;

    /* renamed from: h  reason: collision with root package name */
    public short f7273h;

    /* renamed from: i  reason: collision with root package name */
    public short f7274i;

    /* renamed from: j  reason: collision with root package name */
    public short f7275j;

    /* renamed from: k  reason: collision with root package name */
    public short f7276k;

    /* renamed from: l  reason: collision with root package name */
    public short f7277l;

    /* renamed from: m  reason: collision with root package name */
    public short f7278m;

    /* renamed from: n  reason: collision with root package name */
    public short f7279n;

    /* renamed from: o  reason: collision with root package name */
    public short f7280o;

    /* renamed from: p  reason: collision with root package name */
    public byte f7281p;

    public msg_sys_status() {
        this.f6280c = 1;
    }

    public msg_sys_status(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 1;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7269d = aVar.e();
        this.f7270e = aVar.e();
        this.f7271f = aVar.e();
        this.f7272g = aVar.d();
        this.f7273h = aVar.d();
        this.f7274i = aVar.d();
        this.f7275j = aVar.d();
        this.f7276k = aVar.d();
        this.f7277l = aVar.d();
        this.f7278m = aVar.d();
        this.f7279n = aVar.d();
        this.f7280o = aVar.d();
        this.f7281p = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SYS_STATUS - onboard_control_sensors_present:" + this.f7269d + " onboard_control_sensors_enabled:" + this.f7270e + " onboard_control_sensors_health:" + this.f7271f + " load:" + this.f7272g + " voltage_battery:" + this.f7273h + " current_battery:" + this.f7274i + " drop_rate_comm:" + this.f7275j + " errors_comm:" + this.f7276k + " errors_count1:" + this.f7277l + " errors_count2:" + this.f7278m + " errors_count3:" + this.f7279n + " errors_count4:" + this.f7280o + " battery_remaining:" + this.f7281p + "";
    }
}
