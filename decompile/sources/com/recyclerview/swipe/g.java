package com.recyclerview.swipe;

import java.util.ArrayList;
import java.util.List;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private SwipeMenuLayout f21538a;

    /* renamed from: b  reason: collision with root package name */
    private int f21539b;

    /* renamed from: c  reason: collision with root package name */
    private int f21540c = 0;

    /* renamed from: d  reason: collision with root package name */
    private List<j> f21541d;

    public g(SwipeMenuLayout swipeMenuLayout, int i2) {
        this.f21538a = swipeMenuLayout;
        this.f21539b = i2;
        this.f21541d = new ArrayList(2);
    }

    public int a() {
        return this.f21540c;
    }

    public void a(j jVar) {
        this.f21541d.add(jVar);
    }

    public List<j> b() {
        return this.f21541d;
    }
}
