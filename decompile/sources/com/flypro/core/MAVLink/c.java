package com.flypro.core.MAVLink;

import com.MAVLink.common.msg_command_long;
import en.a;

public class c {
    public static void a(a aVar, boolean z2) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.f6587l = -1;
        msg_command_long.f6588m = 1;
        msg_command_long.f6586k = 400;
        msg_command_long.f6579d = z2 ? 1.0f : 0.0f;
        msg_command_long.f6580e = 0.0f;
        msg_command_long.f6581f = 0.0f;
        msg_command_long.f6582g = 0.0f;
        msg_command_long.f6583h = 0.0f;
        msg_command_long.f6584i = 0.0f;
        msg_command_long.f6585j = 0.0f;
        msg_command_long.f6589n = 0;
        aVar.j().a(msg_command_long.a());
    }
}
