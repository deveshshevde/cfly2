package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_mount_configure extends MAVLinkMessage {
    private static final long serialVersionUID = 156;

    /* renamed from: d  reason: collision with root package name */
    public byte f6425d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6426e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6427f;

    /* renamed from: g  reason: collision with root package name */
    public byte f6428g;

    /* renamed from: h  reason: collision with root package name */
    public byte f6429h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6430i;

    public msg_mount_configure() {
        this.f6280c = 156;
    }

    public msg_mount_configure(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 156;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6425d = aVar.c();
        this.f6426e = aVar.c();
        this.f6427f = aVar.c();
        this.f6428g = aVar.c();
        this.f6429h = aVar.c();
        this.f6430i = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MOUNT_CONFIGURE - target_system:" + this.f6425d + " target_component:" + this.f6426e + " mount_mode:" + this.f6427f + " stab_roll:" + this.f6428g + " stab_pitch:" + this.f6429h + " stab_yaw:" + this.f6430i + "";
    }
}
