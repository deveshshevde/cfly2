package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_log_entry extends MAVLinkMessage {
    private static final long serialVersionUID = 118;

    /* renamed from: d  reason: collision with root package name */
    public int f6887d;

    /* renamed from: e  reason: collision with root package name */
    public int f6888e;

    /* renamed from: f  reason: collision with root package name */
    public short f6889f;

    /* renamed from: g  reason: collision with root package name */
    public short f6890g;

    /* renamed from: h  reason: collision with root package name */
    public short f6891h;

    public msg_log_entry() {
        this.f6280c = 118;
    }

    public msg_log_entry(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 118;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6887d = aVar.e();
        this.f6888e = aVar.e();
        this.f6889f = aVar.d();
        this.f6890g = aVar.d();
        this.f6891h = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LOG_ENTRY - time_utc:" + this.f6887d + " size:" + this.f6888e + " id:" + this.f6889f + " num_logs:" + this.f6890g + " last_log_num:" + this.f6891h + "";
    }
}
