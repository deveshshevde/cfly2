package com.amap.api.mapcore.util;

import com.autonavi.base.ae.gmap.style.StyleItem;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class co {

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, StyleItem> f8191a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private Object f8192b = null;

    /* renamed from: c  reason: collision with root package name */
    private StyleItem[] f8193c;

    public final Map<Integer, StyleItem> a() {
        return this.f8191a;
    }

    public final StyleItem[] b() {
        Map<Integer, StyleItem> map = this.f8191a;
        if (!(map == null || map.size() == 0)) {
            ArrayList arrayList = new ArrayList();
            for (StyleItem next : this.f8191a.values()) {
                if (next.isValid()) {
                    arrayList.add(next);
                }
            }
            int size = arrayList.size();
            if (size > 0) {
                StyleItem[] styleItemArr = (StyleItem[]) arrayList.toArray(new StyleItem[size]);
                this.f8193c = styleItemArr;
                return styleItemArr;
            }
        }
        return null;
    }

    public final StyleItem[] c() {
        return this.f8193c;
    }

    public final Object d() {
        return this.f8192b;
    }
}
