package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_nav_controller_output extends MAVLinkMessage {
    private static final long serialVersionUID = 62;

    /* renamed from: d  reason: collision with root package name */
    public float f6983d;

    /* renamed from: e  reason: collision with root package name */
    public float f6984e;

    /* renamed from: f  reason: collision with root package name */
    public float f6985f;

    /* renamed from: g  reason: collision with root package name */
    public float f6986g;

    /* renamed from: h  reason: collision with root package name */
    public float f6987h;

    /* renamed from: i  reason: collision with root package name */
    public short f6988i;

    /* renamed from: j  reason: collision with root package name */
    public short f6989j;

    /* renamed from: k  reason: collision with root package name */
    public short f6990k;

    public msg_nav_controller_output() {
        this.f6280c = 62;
    }

    public msg_nav_controller_output(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 62;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6983d = aVar.g();
        this.f6984e = aVar.g();
        this.f6985f = aVar.g();
        this.f6986g = aVar.g();
        this.f6987h = aVar.g();
        this.f6988i = aVar.d();
        this.f6989j = aVar.d();
        this.f6990k = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_NAV_CONTROLLER_OUTPUT - nav_roll:" + this.f6983d + " nav_pitch:" + this.f6984e + " alt_error:" + this.f6985f + " aspd_error:" + this.f6986g + " xtrack_error:" + this.f6987h + " nav_bearing:" + this.f6988i + " target_bearing:" + this.f6989j + " wp_dist:" + this.f6990k + "";
    }
}
