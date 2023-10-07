package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_set_mag_offsets extends MAVLinkMessage {
    private static final long serialVersionUID = 151;

    /* renamed from: d  reason: collision with root package name */
    public short f6476d;

    /* renamed from: e  reason: collision with root package name */
    public short f6477e;

    /* renamed from: f  reason: collision with root package name */
    public short f6478f;

    /* renamed from: g  reason: collision with root package name */
    public byte f6479g;

    /* renamed from: h  reason: collision with root package name */
    public byte f6480h;

    public msg_set_mag_offsets() {
        this.f6280c = 151;
    }

    public msg_set_mag_offsets(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 151;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6476d = aVar.d();
        this.f6477e = aVar.d();
        this.f6478f = aVar.d();
        this.f6479g = aVar.c();
        this.f6480h = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_MAG_OFFSETS - mag_ofs_x:" + this.f6476d + " mag_ofs_y:" + this.f6477e + " mag_ofs_z:" + this.f6478f + " target_system:" + this.f6479g + " target_component:" + this.f6480h + "";
    }
}
