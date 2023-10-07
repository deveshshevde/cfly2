package com.amap.api.maps.model;

import com.amap.api.mapcore.util.cu;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private final cu f9756a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9757b;

    /* renamed from: c  reason: collision with root package name */
    private List<WeightedLatLng> f9758c;

    /* renamed from: d  reason: collision with root package name */
    private List<a> f9759d;

    private a(double d2, double d3, double d4, double d5, int i2) {
        this(new cu(d2, d3, d4, d5), i2);
    }

    protected a(cu cuVar) {
        this(cuVar, 0);
    }

    private a(cu cuVar, int i2) {
        this.f9759d = null;
        this.f9756a = cuVar;
        this.f9757b = i2;
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.f9759d = arrayList;
        arrayList.add(new a(this.f9756a.f8208a, this.f9756a.f8212e, this.f9756a.f8209b, this.f9756a.f8213f, this.f9757b + 1));
        this.f9759d.add(new a(this.f9756a.f8212e, this.f9756a.f8210c, this.f9756a.f8209b, this.f9756a.f8213f, this.f9757b + 1));
        this.f9759d.add(new a(this.f9756a.f8208a, this.f9756a.f8212e, this.f9756a.f8213f, this.f9756a.f8211d, this.f9757b + 1));
        this.f9759d.add(new a(this.f9756a.f8212e, this.f9756a.f8210c, this.f9756a.f8213f, this.f9756a.f8211d, this.f9757b + 1));
        List<WeightedLatLng> list = this.f9758c;
        this.f9758c = null;
        for (WeightedLatLng next : list) {
            a(next.getPoint().f10009x, next.getPoint().f10010y, next);
        }
    }

    private void a(double d2, double d3, WeightedLatLng weightedLatLng) {
        List<a> list;
        int i2;
        if (this.f9759d != null) {
            int i3 = (d3 > this.f9756a.f8213f ? 1 : (d3 == this.f9756a.f8213f ? 0 : -1));
            double d4 = this.f9756a.f8212e;
            if (i3 < 0) {
                int i4 = (d2 > d4 ? 1 : (d2 == d4 ? 0 : -1));
                list = this.f9759d;
                i2 = i4 < 0 ? 0 : 1;
            } else {
                int i5 = (d2 > d4 ? 1 : (d2 == d4 ? 0 : -1));
                list = this.f9759d;
                i2 = i5 < 0 ? 2 : 3;
            }
            list.get(i2).a(d2, d3, weightedLatLng);
            return;
        }
        if (this.f9758c == null) {
            this.f9758c = new ArrayList();
        }
        this.f9758c.add(weightedLatLng);
        if (this.f9758c.size() > 50 && this.f9757b < 40) {
            a();
        }
    }

    private void a(cu cuVar, Collection<WeightedLatLng> collection) {
        if (this.f9756a.a(cuVar)) {
            List<a> list = this.f9759d;
            if (list != null) {
                for (a a2 : list) {
                    a2.a(cuVar, collection);
                }
            } else if (this.f9758c == null) {
            } else {
                if (cuVar.b(this.f9756a)) {
                    collection.addAll(this.f9758c);
                    return;
                }
                for (WeightedLatLng next : this.f9758c) {
                    if (cuVar.a(next.getPoint())) {
                        collection.add(next);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Collection<WeightedLatLng> a(cu cuVar) {
        ArrayList arrayList = new ArrayList();
        a(cuVar, arrayList);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public final void a(WeightedLatLng weightedLatLng) {
        DPoint point = weightedLatLng.getPoint();
        if (this.f9756a.a(point.f10009x, point.f10010y)) {
            a(point.f10009x, point.f10010y, weightedLatLng);
        }
    }
}
