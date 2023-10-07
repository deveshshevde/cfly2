package com.flypro.core.mission.survey.grid;

import eg.b;
import eg.c;
import eg.d;
import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private List<ef.a> f14441a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private List<b> f14442b;

    /* renamed from: c  reason: collision with root package name */
    private Double f14443c;

    /* renamed from: d  reason: collision with root package name */
    private List<ef.a> f14444d = new ArrayList();

    public a(List<b> list, Double d2) {
        this.f14442b = list;
        this.f14443c = d2;
    }

    private ef.a a(b bVar, ef.a aVar, boolean z2) throws Exception {
        ef.a b2 = bVar.b(aVar);
        ef.a a2 = bVar.a(aVar);
        this.f14442b.remove(bVar);
        a(b2, a2);
        this.f14441a.add(b2);
        this.f14441a.add(a2);
        if (this.f14444d.size() <= 2000) {
            return a2;
        }
        throw new Exception("Too many camera positions");
    }

    private void a(ef.a aVar, ef.a aVar2) {
        this.f14444d.addAll(new c(aVar, aVar2).a(this.f14443c.doubleValue()));
    }

    public List<ef.a> a() {
        return this.f14441a;
    }

    public void a(ef.a aVar, boolean z2) throws Exception {
        while (this.f14442b.size() > 0) {
            List<b> list = this.f14442b;
            aVar = a(z2 ? d.a(aVar, list) : list.get(0), aVar, z2);
        }
    }

    public List<ef.a> b() {
        return this.f14444d;
    }
}
