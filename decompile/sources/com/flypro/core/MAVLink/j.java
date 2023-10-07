package com.flypro.core.MAVLink;

import android.util.Log;
import com.MAVLink.common.msg_param_request_list;
import com.MAVLink.common.msg_param_request_read;
import com.MAVLink.common.msg_param_set;
import com.flypro.core.parameters.Parameter;
import en.a;

public class j {
    public static void a(a aVar) {
        Log.i("Param", "readParameter: ---get request list----");
        msg_param_request_list msg_param_request_list = new msg_param_request_list();
        msg_param_request_list.f7005d = -1;
        msg_param_request_list.f7006e = 1;
        aVar.j().a(msg_param_request_list.a());
    }

    public static void a(a aVar, Parameter parameter) {
        Log.i("Param", "senddParameter: ---name----" + parameter.f14455a);
        msg_param_set msg_param_set = new msg_param_set();
        msg_param_set.f7012e = -1;
        msg_param_set.f7013f = 1;
        msg_param_set.a(parameter.f14455a);
        msg_param_set.f7015h = (byte) parameter.f14457c;
        msg_param_set.f7011d = (float) parameter.f14456b;
        aVar.j().a(msg_param_set.a());
    }

    public static void a(a aVar, String str) {
        Log.i("Param", "readParameter: ---name----" + str);
        msg_param_request_read msg_param_request_read = new msg_param_request_read();
        msg_param_request_read.f7007d = -1;
        msg_param_request_read.f7008e = -1;
        msg_param_request_read.f7009f = 1;
        msg_param_request_read.a(str);
        aVar.j().a(msg_param_request_read.a());
    }
}
