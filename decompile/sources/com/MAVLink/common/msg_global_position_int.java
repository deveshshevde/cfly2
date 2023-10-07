package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_global_position_int extends MAVLinkMessage {
    private static final long serialVersionUID = 33;

    /* renamed from: d  reason: collision with root package name */
    public int f6644d;

    /* renamed from: e  reason: collision with root package name */
    public int f6645e;

    /* renamed from: f  reason: collision with root package name */
    public int f6646f;

    /* renamed from: g  reason: collision with root package name */
    public int f6647g;

    /* renamed from: h  reason: collision with root package name */
    public int f6648h;

    /* renamed from: i  reason: collision with root package name */
    public short f6649i;

    /* renamed from: j  reason: collision with root package name */
    public short f6650j;

    /* renamed from: k  reason: collision with root package name */
    public short f6651k;

    /* renamed from: l  reason: collision with root package name */
    public short f6652l;

    public msg_global_position_int() {
        this.f6280c = 33;
    }

    public msg_global_position_int(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 33;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6644d = aVar.e();
        this.f6645e = aVar.e();
        this.f6646f = aVar.e();
        this.f6647g = aVar.e();
        this.f6648h = aVar.e();
        this.f6649i = aVar.d();
        this.f6650j = aVar.d();
        this.f6651k = aVar.d();
        this.f6652l = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GLOBAL_POSITION_INT - time_boot_ms:" + this.f6644d + " lat:" + this.f6645e + " lon:" + this.f6646f + " alt:" + this.f6647g + " relative_alt:" + this.f6648h + " vx:" + this.f6649i + " vy:" + this.f6650j + " vz:" + this.f6651k + " hdg:" + this.f6652l + "";
    }
}
