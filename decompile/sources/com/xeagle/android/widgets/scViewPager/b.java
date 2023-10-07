package com.xeagle.android.widgets.scViewPager;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private View f25971a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Integer, ArrayList<a>> f25972b;

    public void a(int i2, float f2) {
        ArrayList arrayList = this.f25972b.get(Integer.valueOf(i2));
        if (arrayList != null) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((a) it2.next()).a(this.f25971a, f2);
            }
        }
    }
}
