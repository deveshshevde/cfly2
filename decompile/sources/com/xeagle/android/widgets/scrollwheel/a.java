package com.xeagle.android.widgets.scrollwheel;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private int f26017a;

    /* renamed from: b  reason: collision with root package name */
    private int f26018b;

    /* renamed from: c  reason: collision with root package name */
    private String f26019c;

    public a() {
        this(0, 9);
    }

    public a(int i2, int i3) {
        this(i2, i3, (String) null);
    }

    public a(int i2, int i3, String str) {
        this.f26017a = i2;
        this.f26018b = i3;
        this.f26019c = str;
    }

    public int a() {
        return (this.f26018b - this.f26017a) + 1;
    }

    public String a(int i2) {
        if (i2 < 0 || i2 >= a()) {
            return null;
        }
        int i3 = this.f26017a + i2;
        String str = this.f26019c;
        if (str == null) {
            return Integer.toString(i3);
        }
        return String.format(str, new Object[]{Integer.valueOf(i3)});
    }

    public int b() {
        int length = Integer.toString(Math.max(Math.abs(this.f26018b), Math.abs(this.f26017a))).length();
        return this.f26017a < 0 ? length + 1 : length;
    }
}
