package com.xeagle.android.widgets.spinnerWheel;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f26068a;

    /* renamed from: b  reason: collision with root package name */
    private int f26069b;

    public a() {
        this(0, 0);
    }

    public a(int i2, int i3) {
        this.f26068a = i2;
        this.f26069b = i3;
    }

    public int a() {
        return this.f26068a;
    }

    public boolean a(int i2) {
        return i2 >= a() && i2 <= b();
    }

    public int b() {
        return (a() + c()) - 1;
    }

    public int c() {
        return this.f26069b;
    }
}
