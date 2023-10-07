package com.flypro.core.MAVLink;

import com.MAVLink.common.msg_command_ack;
import com.MAVLink.common.msg_command_long;
import en.a;

public class e {
    public static void a(int i2, a aVar) {
        msg_command_ack msg_command_ack = new msg_command_ack();
        msg_command_ack.f6564d = (short) i2;
        msg_command_ack.f6565e = 1;
        aVar.j().a(msg_command_ack.a());
    }

    public static void a(a aVar) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.f6587l = -1;
        msg_command_long.f6588m = 1;
        msg_command_long.f6586k = 241;
        msg_command_long.f6579d = 0.0f;
        msg_command_long.f6580e = 0.0f;
        msg_command_long.f6581f = 0.0f;
        msg_command_long.f6582g = 0.0f;
        msg_command_long.f6583h = 1.0f;
        msg_command_long.f6584i = 0.0f;
        msg_command_long.f6585j = 0.0f;
        msg_command_long.f6589n = 0;
        aVar.j().a(msg_command_long.a());
    }

    public static void b(a aVar) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.f6587l = -1;
        msg_command_long.f6588m = 1;
        msg_command_long.f6586k = 241;
        msg_command_long.f6579d = 0.0f;
        msg_command_long.f6580e = 0.0f;
        msg_command_long.f6581f = 0.0f;
        msg_command_long.f6582g = 0.0f;
        msg_command_long.f6583h = 2.0f;
        msg_command_long.f6584i = 0.0f;
        msg_command_long.f6585j = 0.0f;
        msg_command_long.f6589n = 0;
        aVar.j().a(msg_command_long.a());
    }
}
