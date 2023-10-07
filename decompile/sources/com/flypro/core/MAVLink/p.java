package com.flypro.core.MAVLink;

import com.MAVLink.common.msg_data_add_msg;
import en.a;

public class p {
    public static void a(a aVar, int i2, int i3, int i4, int i5, int i6) {
        msg_data_add_msg msg_data_add_msg = new msg_data_add_msg();
        msg_data_add_msg.f6600h = (byte) i2;
        msg_data_add_msg.f6597e = (short) i3;
        msg_data_add_msg.f6596d = (short) i4;
        msg_data_add_msg.f6598f = (byte) i5;
        msg_data_add_msg.f6599g = (byte) i6;
        aVar.j().a(msg_data_add_msg.a());
    }
}
