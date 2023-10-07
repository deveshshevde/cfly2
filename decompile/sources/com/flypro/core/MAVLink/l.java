package com.flypro.core.MAVLink;

import com.MAVLink.ardupilotmega.msg_digicam_control;
import com.MAVLink.common.msg_command_long;
import com.MAVLink.common.msg_drone_angle;
import en.a;

public class l {
    public static void a(a aVar) {
        msg_digicam_control msg_digicam_control = new msg_digicam_control();
        msg_digicam_control.f6390e = -1;
        msg_digicam_control.f6391f = 1;
        msg_digicam_control.f6396k = 1;
        aVar.j().a(msg_digicam_control.a());
    }

    public static void a(a aVar, ef.a aVar2) {
        msg_drone_angle msg_drone_angle = new msg_drone_angle();
        msg_drone_angle.f6633d = (int) (aVar2.d() * 1.0E7d);
        msg_drone_angle.f6634e = (int) (aVar2.c() * 1.0E7d);
        aVar.j().a(msg_drone_angle.a());
    }

    public static void a(a aVar, boolean z2) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.f6587l = -1;
        msg_command_long.f6588m = 1;
        msg_command_long.f6586k = 211;
        msg_command_long.f6580e = z2 ? 0.0f : 1.0f;
        aVar.j().a(msg_command_long.a());
    }
}
