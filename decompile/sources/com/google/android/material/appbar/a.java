package com.google.android.material.appbar;

import android.view.View;
import t.ac;

class a {

    /* renamed from: a  reason: collision with root package name */
    private final View f18481a;

    /* renamed from: b  reason: collision with root package name */
    private int f18482b;

    /* renamed from: c  reason: collision with root package name */
    private int f18483c;

    /* renamed from: d  reason: collision with root package name */
    private int f18484d;

    /* renamed from: e  reason: collision with root package name */
    private int f18485e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18486f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18487g = true;

    public a(View view) {
        this.f18481a = view;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f18482b = this.f18481a.getTop();
        this.f18483c = this.f18481a.getLeft();
    }

    public boolean a(int i2) {
        if (!this.f18486f || this.f18484d == i2) {
            return false;
        }
        this.f18484d = i2;
        b();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        View view = this.f18481a;
        ac.e(view, this.f18484d - (view.getTop() - this.f18482b));
        View view2 = this.f18481a;
        ac.f(view2, this.f18485e - (view2.getLeft() - this.f18483c));
    }

    public boolean b(int i2) {
        if (!this.f18487g || this.f18485e == i2) {
            return false;
        }
        this.f18485e = i2;
        b();
        return true;
    }

    public int c() {
        return this.f18484d;
    }

    public int d() {
        return this.f18482b;
    }
}
