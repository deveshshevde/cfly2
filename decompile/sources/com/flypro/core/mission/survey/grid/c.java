package com.flypro.core.mission.survey.grid;

import com.flypro.core.polygon.Polygon;
import ef.a;
import el.b;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private Polygon f14447a;

    /* renamed from: b  reason: collision with root package name */
    private Double f14448b;

    /* renamed from: c  reason: collision with root package name */
    private Double f14449c;

    /* renamed from: d  reason: collision with root package name */
    private a f14450d;

    /* renamed from: e  reason: collision with root package name */
    private Double f14451e;

    /* renamed from: f  reason: collision with root package name */
    private b f14452f;

    public c(Polygon polygon, b bVar, a aVar) {
        this.f14447a = polygon;
        this.f14450d = aVar;
        this.f14448b = bVar.g();
        this.f14449c = Double.valueOf(bVar.e().a());
        this.f14451e = Double.valueOf(bVar.d().a());
    }

    public b a(boolean z2) throws Exception {
        a aVar = new a(new d(new CircumscribedGrid(this.f14447a.a(), this.f14448b, this.f14449c).a(), this.f14447a.b()).a(), this.f14451e);
        aVar.a(this.f14450d, z2);
        b bVar = new b(aVar.a(), aVar.b());
        this.f14452f = bVar;
        return bVar;
    }
}
