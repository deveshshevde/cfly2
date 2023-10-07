package com.flypro.core.MAVLink;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.common.msg_heartbeat;
import en.a;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final msg_heartbeat f14140a;

    /* renamed from: b  reason: collision with root package name */
    private static final MAVLinkPacket f14141b;

    static {
        msg_heartbeat msg_heartbeat = new msg_heartbeat();
        f14140a = msg_heartbeat;
        msg_heartbeat.f6733e = 6;
        msg_heartbeat.f6734f = 0;
        f14141b = msg_heartbeat.a();
    }

    public static void a(a aVar) {
        if (aVar != null) {
            aVar.j().a(f14141b);
        }
    }
}
