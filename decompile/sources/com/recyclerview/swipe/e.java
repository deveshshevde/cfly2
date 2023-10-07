package com.recyclerview.swipe;

import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;

abstract class e {

    /* renamed from: a  reason: collision with root package name */
    protected a f21532a = new a();

    /* renamed from: b  reason: collision with root package name */
    private int f21533b;

    /* renamed from: c  reason: collision with root package name */
    private View f21534c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f21535a;

        /* renamed from: b  reason: collision with root package name */
        public int f21536b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f21537c;
    }

    public e(int i2, View view) {
        this.f21533b = i2;
        this.f21534c = view;
    }

    public abstract a a(int i2, int i3);

    public abstract void a(OverScroller overScroller, int i2, int i3);

    public boolean a() {
        View view = this.f21534c;
        return (view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0;
    }

    public boolean a(int i2) {
        return i2 == 0 && (-c().getWidth()) * b() != 0;
    }

    public abstract boolean a(int i2, float f2);

    public int b() {
        return this.f21533b;
    }

    public abstract void b(OverScroller overScroller, int i2, int i3);

    public View c() {
        return this.f21534c;
    }

    public int d() {
        return this.f21534c.getWidth();
    }
}
