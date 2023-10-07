package com.flypro.core.MAVLink;

import com.MAVLink.common.msg_mission_clear_all;
import com.MAVLink.common.msg_mission_count;
import com.MAVLink.common.msg_mission_request_list;
import com.MAVLink.common.msg_mission_set_current;
import en.a;

public class o {
    public static void a(a aVar) {
        msg_mission_request_list msg_mission_request_list = new msg_mission_request_list();
        msg_mission_request_list.f6964d = -1;
        msg_mission_request_list.f6965e = 1;
        aVar.j().a(msg_mission_request_list.a());
    }

    public static void a(a aVar, int i2) {
        msg_mission_count msg_mission_count = new msg_mission_count();
        msg_mission_count.f6928e = -1;
        msg_mission_count.f6929f = 1;
        msg_mission_count.f6927d = (short) i2;
        aVar.j().a(msg_mission_count.a());
    }

    public static void a(a aVar, short s2) {
        msg_mission_set_current msg_mission_set_current = new msg_mission_set_current();
        msg_mission_set_current.f6971e = -1;
        msg_mission_set_current.f6972f = 1;
        msg_mission_set_current.f6970d = s2;
        aVar.j().a(msg_mission_set_current.a());
    }

    public static void b(a aVar) {
        msg_mission_clear_all msg_mission_clear_all = new msg_mission_clear_all();
        msg_mission_clear_all.f6925d = -1;
        msg_mission_clear_all.f6926e = 1;
        aVar.j().a(msg_mission_clear_all.a());
    }
}
