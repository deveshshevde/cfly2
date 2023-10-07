package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_sonar_dug extends MAVLinkMessage {
    private static final long serialVersionUID = 8;

    /* renamed from: d  reason: collision with root package name */
    public short f7259d;

    /* renamed from: e  reason: collision with root package name */
    public short f7260e;

    /* renamed from: f  reason: collision with root package name */
    public short f7261f;

    /* renamed from: g  reason: collision with root package name */
    public short f7262g;

    /* renamed from: h  reason: collision with root package name */
    public short f7263h;

    /* renamed from: i  reason: collision with root package name */
    public short f7264i;

    /* renamed from: j  reason: collision with root package name */
    public short f7265j;

    /* renamed from: k  reason: collision with root package name */
    public short f7266k;

    public msg_sonar_dug() {
        this.f6280c = 8;
    }

    public msg_sonar_dug(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 8;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7259d = aVar.d();
        this.f7260e = aVar.d();
        this.f7261f = aVar.d();
        this.f7262g = aVar.d();
        this.f7263h = aVar.d();
        this.f7264i = aVar.d();
        this.f7265j = aVar.d();
        this.f7266k = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SONAR_DUG - bar_alt:" + this.f7259d + " bar_vel:" + this.f7260e + " bar_dest:" + this.f7261f + " status:" + this.f7262g + " sonar_alt:" + this.f7263h + " sonar_vel:" + this.f7264i + " sonar_dest:" + this.f7265j + " offset:" + this.f7266k + "";
    }
}
