package com.flypro.core.MAVLink;

import com.MAVLink.common.msg_command_long;
import en.a;

public class t {
    public static void a(a aVar, float f2, float f3) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.f6587l = -1;
        msg_command_long.f6588m = 1;
        msg_command_long.f6586k = 179;
        msg_command_long.f6579d = 3.0f;
        msg_command_long.f6580e = 0.0f;
        msg_command_long.f6581f = 0.0f;
        msg_command_long.f6582g = 0.0f;
        msg_command_long.f6583h = f2;
        msg_command_long.f6584i = f3;
        msg_command_long.f6585j = 0.0f;
        msg_command_long.f6589n = 0;
        aVar.j().a(msg_command_long.a());
    }
}
