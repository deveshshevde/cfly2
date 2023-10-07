package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_digicam_configure extends MAVLinkMessage {
    private static final long serialVersionUID = 154;

    /* renamed from: d  reason: collision with root package name */
    public float f6378d;

    /* renamed from: e  reason: collision with root package name */
    public short f6379e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6380f;

    /* renamed from: g  reason: collision with root package name */
    public byte f6381g;

    /* renamed from: h  reason: collision with root package name */
    public byte f6382h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6383i;

    /* renamed from: j  reason: collision with root package name */
    public byte f6384j;

    /* renamed from: k  reason: collision with root package name */
    public byte f6385k;

    /* renamed from: l  reason: collision with root package name */
    public byte f6386l;

    /* renamed from: m  reason: collision with root package name */
    public byte f6387m;

    /* renamed from: n  reason: collision with root package name */
    public byte f6388n;

    public msg_digicam_configure() {
        this.f6280c = 154;
    }

    public msg_digicam_configure(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 154;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6378d = aVar.g();
        this.f6379e = aVar.d();
        this.f6380f = aVar.c();
        this.f6381g = aVar.c();
        this.f6382h = aVar.c();
        this.f6383i = aVar.c();
        this.f6384j = aVar.c();
        this.f6385k = aVar.c();
        this.f6386l = aVar.c();
        this.f6387m = aVar.c();
        this.f6388n = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DIGICAM_CONFIGURE - extra_value:" + this.f6378d + " shutter_speed:" + this.f6379e + " target_system:" + this.f6380f + " target_component:" + this.f6381g + " mode:" + this.f6382h + " aperture:" + this.f6383i + " iso:" + this.f6384j + " exposure_type:" + this.f6385k + " command_id:" + this.f6386l + " engine_cut_off:" + this.f6387m + " extra_param:" + this.f6388n + "";
    }
}
