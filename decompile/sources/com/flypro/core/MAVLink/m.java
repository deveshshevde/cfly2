package com.flypro.core.MAVLink;

import com.MAVLink.common.msg_request_data_stream;
import com.flypro.core.MAVLink.a;

public class m {
    private static void a(a.C0089a aVar, int i2, int i3) {
        msg_request_data_stream msg_request_data_stream = new msg_request_data_stream();
        msg_request_data_stream.f7134e = -1;
        msg_request_data_stream.f7135f = 1;
        msg_request_data_stream.f7133d = (short) i3;
        msg_request_data_stream.f7136g = (byte) i2;
        if (i3 > 0) {
            msg_request_data_stream.f7137h = 1;
        } else {
            msg_request_data_stream.f7137h = 0;
        }
        aVar.a(msg_request_data_stream.a());
    }

    public static void a(a.C0089a aVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        a(aVar, 10, i3);
        a(aVar, 1, i8);
        a(aVar, 8, i9);
        a(aVar, 3, i7);
    }
}
