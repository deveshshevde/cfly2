package com.liulishuo.filedownloader.services;

import iq.c;
import iq.f;

public class b implements c.d {
    public int a(int i2, String str, String str2, boolean z2) {
        return a(str, str2, z2);
    }

    public int a(String str, String str2, boolean z2) {
        String a2;
        if (z2) {
            a2 = f.a("%sp%s@dir", str, str2);
        } else {
            a2 = f.a("%sp%s", str, str2);
        }
        return f.e(a2).hashCode();
    }
}
