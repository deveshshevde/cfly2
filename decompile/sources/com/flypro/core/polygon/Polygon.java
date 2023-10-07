package com.flypro.core.polygon;

import ef.a;
import eg.b;
import java.util.ArrayList;
import java.util.List;

public class Polygon {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f14464a = new ArrayList();

    public class InvalidPolygon extends Exception {
        private static final long serialVersionUID = 1;

        /* renamed from: a  reason: collision with root package name */
        public int f14465a;

        public InvalidPolygon(int i2) {
            this.f14465a = i2;
        }
    }

    public List<a> a() {
        return this.f14464a;
    }

    public void a(a aVar) {
        this.f14464a.add(aVar);
    }

    public void a(a aVar, int i2) {
        this.f14464a.get(i2).a(aVar);
    }

    public void a(List<a> list) {
        for (a a2 : list) {
            a(a2);
        }
    }

    public List<b> b() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < this.f14464a.size()) {
            arrayList.add(new b(this.f14464a.get(i2), this.f14464a.get(i2 == 0 ? this.f14464a.size() - 1 : i2 - 1)));
            i2++;
        }
        return arrayList;
    }

    public ej.b c() {
        return eg.a.a(this);
    }

    public void d() throws Exception {
        if (this.f14464a.size() < 3) {
            throw new InvalidPolygon(this.f14464a.size());
        }
    }
}
