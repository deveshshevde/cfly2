package com.huantansheng.easyphotos.models.puzzle;

import hl.b;
import hl.d;
import hm.a;
import hm.c;
import hm.f;
import hm.g;
import hm.h;
import hm.i;
import hm.j;
import hm.k;
import java.util.ArrayList;
import java.util.List;

public class e {
    public static c a(int i2, int i3, int i4) {
        if (i2 == 0) {
            return i3 != 1 ? i3 != 2 ? i3 != 3 ? new b(i4) : new d(i4) : new hl.e(i4) : new b(i4);
        }
        switch (i3) {
            case 1:
                return new f(i4);
            case 2:
                return new k(i4);
            case 3:
                return new j(i4);
            case 4:
                return new c(i4);
            case 5:
                return new hm.b(i4);
            case 6:
                return new h(i4);
            case 7:
                return new g(i4);
            case 8:
                return new a(i4);
            case 9:
                return new hm.d(i4);
            default:
                return new f(i4);
        }
    }

    public static List<c> a(int i2) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(hl.c.a(i2));
        arrayList.addAll(i.a(i2));
        return arrayList;
    }
}
