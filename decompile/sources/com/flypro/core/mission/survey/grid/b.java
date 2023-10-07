package com.flypro.core.mission.survey.grid;

import ef.a;
import eg.f;
import ej.c;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f14445a;

    /* renamed from: b  reason: collision with root package name */
    private List<a> f14446b;

    public b(List<a> list, List<a> list2) {
        this.f14445a = list;
        this.f14446b = list2;
    }

    public c a() {
        return f.a(this.f14445a);
    }

    public int b() {
        return this.f14445a.size() / 2;
    }

    public List<a> c() {
        return this.f14446b;
    }

    public int d() {
        return c().size();
    }
}
