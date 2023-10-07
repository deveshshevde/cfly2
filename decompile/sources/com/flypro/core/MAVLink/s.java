package com.flypro.core.MAVLink;

import com.MAVLink.common.msg_remote_app_requestorset;
import en.a;

public class s {
    public static void a(a aVar, int i2, int i3) {
        msg_remote_app_requestorset msg_remote_app_requestorset = new msg_remote_app_requestorset();
        msg_remote_app_requestorset.f7129d = (byte) i2;
        msg_remote_app_requestorset.f7130e = (byte) i3;
        aVar.j().a(msg_remote_app_requestorset.a());
    }
}
