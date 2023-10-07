package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_limits_status extends MAVLinkMessage {
    private static final long serialVersionUID = 167;

    /* renamed from: d  reason: collision with root package name */
    public int f6414d;

    /* renamed from: e  reason: collision with root package name */
    public int f6415e;

    /* renamed from: f  reason: collision with root package name */
    public int f6416f;

    /* renamed from: g  reason: collision with root package name */
    public int f6417g;

    /* renamed from: h  reason: collision with root package name */
    public short f6418h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6419i;

    /* renamed from: j  reason: collision with root package name */
    public byte f6420j;

    /* renamed from: k  reason: collision with root package name */
    public byte f6421k;

    /* renamed from: l  reason: collision with root package name */
    public byte f6422l;

    public msg_limits_status() {
        this.f6280c = 167;
    }

    public msg_limits_status(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 167;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6414d = aVar.e();
        this.f6415e = aVar.e();
        this.f6416f = aVar.e();
        this.f6417g = aVar.e();
        this.f6418h = aVar.d();
        this.f6419i = aVar.c();
        this.f6420j = aVar.c();
        this.f6421k = aVar.c();
        this.f6422l = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LIMITS_STATUS - last_trigger:" + this.f6414d + " last_action:" + this.f6415e + " last_recovery:" + this.f6416f + " last_clear:" + this.f6417g + " breach_count:" + this.f6418h + " limits_state:" + this.f6419i + " mods_enabled:" + this.f6420j + " mods_required:" + this.f6421k + " mods_triggered:" + this.f6422l + "";
    }
}
