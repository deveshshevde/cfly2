package com.flypro.core.MAVLink;

import com.MAVLink.common.msg_attachment2;
import en.a;

public class q {
    public static void a(a aVar) {
        a(aVar, 3, 0, 1, 0);
    }

    public static void a(a aVar, int i2) {
        a(aVar, 2, 0, i2);
    }

    public static void a(a aVar, int i2, int i3, int i4) {
        a(aVar, 4, i3, i2, i4);
    }

    public static void a(a aVar, int i2, int i3, int i4, int i5) {
        a(aVar, 0, 0, i3, i5, 0, 0, 0, i4, i2);
    }

    public static void a(a aVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        msg_attachment2 msg_attachment2 = new msg_attachment2();
        msg_attachment2.f6504d = i2;
        msg_attachment2.f6505e = i3;
        msg_attachment2.f6508h = (short) i7;
        msg_attachment2.f6506f = i4;
        msg_attachment2.f6515o = (byte) i10;
        msg_attachment2.f6509i = i8;
        msg_attachment2.f6514n = (byte) i9;
        msg_attachment2.f6510j = i6;
        msg_attachment2.f6507g = i5;
        aVar.j().a(msg_attachment2.a());
    }

    public static void b(a aVar) {
        a(aVar, 3, 0, 2, 0);
    }

    public static void b(a aVar, int i2) {
        b(aVar, 0, 2, i2);
    }

    public static void b(a aVar, int i2, int i3, int i4) {
        a(aVar, 5, i2, i3, i4);
    }
}
