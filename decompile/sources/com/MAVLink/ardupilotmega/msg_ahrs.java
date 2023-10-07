package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_ahrs extends MAVLinkMessage {
    private static final long serialVersionUID = 163;

    /* renamed from: d  reason: collision with root package name */
    public float f6305d;

    /* renamed from: e  reason: collision with root package name */
    public float f6306e;

    /* renamed from: f  reason: collision with root package name */
    public float f6307f;

    /* renamed from: g  reason: collision with root package name */
    public float f6308g;

    /* renamed from: h  reason: collision with root package name */
    public float f6309h;

    /* renamed from: i  reason: collision with root package name */
    public float f6310i;

    /* renamed from: j  reason: collision with root package name */
    public float f6311j;

    public msg_ahrs() {
        this.f6280c = 163;
    }

    public msg_ahrs(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 163;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6305d = aVar.g();
        this.f6306e = aVar.g();
        this.f6307f = aVar.g();
        this.f6308g = aVar.g();
        this.f6309h = aVar.g();
        this.f6310i = aVar.g();
        this.f6311j = aVar.g();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_AHRS - omegaIx:" + this.f6305d + " omegaIy:" + this.f6306e + " omegaIz:" + this.f6307f + " accel_weight:" + this.f6308g + " renorm_val:" + this.f6309h + " error_rp:" + this.f6310i + " error_yaw:" + this.f6311j + "";
    }
}
