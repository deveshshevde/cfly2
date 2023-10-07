package hl;

import java.util.ArrayList;
import java.util.List;

public class c {
    public static List<com.huantansheng.easyphotos.models.puzzle.c> a(int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        if (i2 == 1) {
            while (i3 < 4) {
                arrayList.add(new b(i3));
                i3++;
            }
        } else if (i2 == 2) {
            while (i3 < 2) {
                arrayList.add(new e(i3));
                i3++;
            }
        } else if (i2 == 3) {
            while (i3 < 6) {
                arrayList.add(new d(i3));
                i3++;
            }
        }
        return arrayList;
    }
}
