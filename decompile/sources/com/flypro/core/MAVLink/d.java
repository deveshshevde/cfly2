package com.flypro.core.MAVLink;

import com.MAVLink.common.msg_attachment;
import en.a;

public class d {
    public static void a(a aVar) {
        a(aVar, 1, 0, 0, 0);
    }

    public static void a(a aVar, int i2) {
        a(aVar, 2, i2, 0, 0);
    }

    public static void a(a aVar, int i2, int i3) {
        a(aVar, i2, 0, 0, 0, 0, 0, 0, i3, 5);
    }

    public static void a(a aVar, int i2, int i3, int i4, int i5) {
        a(aVar, 0, 0, i3, i5, 0, 0, 0, i4, i2);
    }

    public static void a(a aVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        msg_attachment msg_attachment = new msg_attachment();
        msg_attachment.f6495d = i2;
        msg_attachment.f6496e = i3;
        msg_attachment.f6500i = (short) i7;
        msg_attachment.f6497f = i4;
        msg_attachment.f6503l = (byte) i10;
        msg_attachment.f6501j = (short) i8;
        msg_attachment.f6502k = (byte) i9;
        msg_attachment.f6499h = i6;
        msg_attachment.f6498g = i5;
        aVar.j().a(msg_attachment.a());
    }

    public static void a(a aVar, String str) {
        if (str != null) {
            String[] split = str.replace("V", "").split("\\.");
            if (split.length == 3) {
                a(aVar, 0, 0, 2, 0, (Integer.parseInt(split[0]) * 100000) + (Integer.parseInt(split[1]) * 1000) + Integer.parseInt(split[2]), 0, 0, 0, 3);
            }
        }
    }

    public static void a(a aVar, boolean z2) {
        a(aVar, 0, 0, 0, 0, 0, 0, 0, z2 ? 1 : 0, 4);
    }
}
