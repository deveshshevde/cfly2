package com.flypro.core.MAVLink;

import android.content.Context;
import com.MAVLink.Messages.ApmModes;
import com.MAVLink.common.msg_data_msg;
import com.MAVLink.common.msg_mission_item;
import com.MAVLink.common.msg_set_mode;
import en.a;

public class h {
    public static void a(Context context, a aVar, double d2, double d3, double d4) {
        msg_mission_item msg_mission_item = new msg_mission_item(context);
        msg_mission_item.f6938k = 0;
        msg_mission_item.f6943p = 2;
        msg_mission_item.f6942o = 0;
        msg_mission_item.f6939l = 16;
        msg_mission_item.f6931d = 0.0f;
        msg_mission_item.f6932e = 0.0f;
        msg_mission_item.f6933f = 0.0f;
        msg_mission_item.f6934g = 0.0f;
        msg_mission_item.f6935h = (float) d2;
        msg_mission_item.f6936i = (float) d3;
        msg_mission_item.f6937j = (float) d4;
        msg_mission_item.f6944q = 1;
        msg_mission_item.f6940m = -1;
        msg_mission_item.f6941n = 1;
        aVar.j().a(msg_mission_item.a());
    }

    public static void a(a aVar, double d2, double d3, double d4) {
        msg_data_msg msg_data_msg = new msg_data_msg();
        msg_data_msg.f6601d = (int) (d2 * 1.0E7d);
        msg_data_msg.f6602e = (int) (d3 * 1.0E7d);
        msg_data_msg.f6603f = (short) ((int) d4);
        aVar.j().a(msg_data_msg.a());
    }

    public static void a(a aVar, ApmModes apmModes) {
        msg_set_mode msg_set_mode = new msg_set_mode();
        msg_set_mode.f7208e = -1;
        msg_set_mode.f7209f = 1;
        msg_set_mode.f7207d = apmModes.a();
        aVar.j().a(msg_set_mode.a());
    }
}
