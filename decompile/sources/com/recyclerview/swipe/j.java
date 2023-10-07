package com.recyclerview.swipe;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private Context f21544a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f21545b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f21546c;

    /* renamed from: d  reason: collision with root package name */
    private String f21547d;

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f21548e;

    /* renamed from: f  reason: collision with root package name */
    private int f21549f;

    /* renamed from: g  reason: collision with root package name */
    private Typeface f21550g;

    /* renamed from: h  reason: collision with root package name */
    private int f21551h;

    /* renamed from: i  reason: collision with root package name */
    private int f21552i = -2;

    /* renamed from: j  reason: collision with root package name */
    private int f21553j = -2;

    /* renamed from: k  reason: collision with root package name */
    private int f21554k = 0;

    public j(Context context) {
        this.f21544a = context;
    }

    public Drawable a() {
        return this.f21545b;
    }

    public j a(int i2) {
        this.f21545b = d.a(this.f21544a, i2);
        return this;
    }

    public j a(String str) {
        this.f21547d = str;
        return this;
    }

    public Drawable b() {
        return this.f21546c;
    }

    public j b(int i2) {
        a(this.f21544a.getString(i2));
        return this;
    }

    public ColorStateList c() {
        return this.f21548e;
    }

    public j c(int i2) {
        this.f21548e = ColorStateList.valueOf(i2);
        return this;
    }

    public int d() {
        return this.f21549f;
    }

    public j d(int i2) {
        this.f21552i = i2;
        return this;
    }

    public j e(int i2) {
        this.f21553j = i2;
        return this;
    }

    public String e() {
        return this.f21547d;
    }

    public int f() {
        return this.f21551h;
    }

    public Typeface g() {
        return this.f21550g;
    }

    public int h() {
        return this.f21552i;
    }

    public int i() {
        return this.f21553j;
    }

    public int j() {
        return this.f21554k;
    }
}
