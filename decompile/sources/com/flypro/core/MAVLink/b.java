package com.flypro.core.MAVLink;

import com.MAVLink.common.msg_heartbeat;
import en.a;

public class b {
    public static void a(a aVar, byte b2) {
        msg_heartbeat msg_heartbeat = new msg_heartbeat();
        msg_heartbeat.f6737i = b2;
        aVar.j().a(msg_heartbeat.a());
    }
}
