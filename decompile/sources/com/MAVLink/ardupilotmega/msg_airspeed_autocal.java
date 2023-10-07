package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_airspeed_autocal extends MAVLinkMessage {
    private static final long serialVersionUID = 174;

    /* renamed from: d  reason: collision with root package name */
    public float f6318d;

    /* renamed from: e  reason: collision with root package name */
    public float f6319e;

    /* renamed from: f  reason: collision with root package name */
    public float f6320f;

    /* renamed from: g  reason: collision with root package name */
    public float f6321g;

    /* renamed from: h  reason: collision with root package name */
    public float f6322h;

    /* renamed from: i  reason: collision with root package name */
    public float f6323i;

    /* renamed from: j  reason: collision with root package name */
    public float f6324j;

    /* renamed from: k  reason: collision with root package name */
    public float f6325k;

    /* renamed from: l  reason: collision with root package name */
    public float f6326l;

    /* renamed from: m  reason: collision with root package name */
    public float f6327m;

    /* renamed from: n  reason: collision with root package name */
    public float f6328n;

    /* renamed from: o  reason: collision with root package name */
    public float f6329o;

    public msg_airspeed_autocal() {
        this.f6280c = 174;
    }

    public msg_airspeed_autocal(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 174;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6318d = aVar.g();
        this.f6319e = aVar.g();
        this.f6320f = aVar.g();
        this.f6321g = aVar.g();
        this.f6322h = aVar.g();
        this.f6323i = aVar.g();
        this.f6324j = aVar.g();
        this.f6325k = aVar.g();
        this.f6326l = aVar.g();
        this.f6327m = aVar.g();
        this.f6328n = aVar.g();
        this.f6329o = aVar.g();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_AIRSPEED_AUTOCAL - vx:" + this.f6318d + " vy:" + this.f6319e + " vz:" + this.f6320f + " diff_pressure:" + this.f6321g + " EAS2TAS:" + this.f6322h + " ratio:" + this.f6323i + " state_x:" + this.f6324j + " state_y:" + this.f6325k + " state_z:" + this.f6326l + " Pax:" + this.f6327m + " Pby:" + this.f6328n + " Pcz:" + this.f6329o + "";
    }
}
