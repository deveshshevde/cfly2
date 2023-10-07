package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f16584a = new b("");

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f16585b;

    /* renamed from: c  reason: collision with root package name */
    public final Layout.Alignment f16586c;

    /* renamed from: d  reason: collision with root package name */
    public final Bitmap f16587d;

    /* renamed from: e  reason: collision with root package name */
    public final float f16588e;

    /* renamed from: f  reason: collision with root package name */
    public final int f16589f;

    /* renamed from: g  reason: collision with root package name */
    public final int f16590g;

    /* renamed from: h  reason: collision with root package name */
    public final float f16591h;

    /* renamed from: i  reason: collision with root package name */
    public final int f16592i;

    /* renamed from: j  reason: collision with root package name */
    public final float f16593j;

    /* renamed from: k  reason: collision with root package name */
    public final float f16594k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f16595l;

    /* renamed from: m  reason: collision with root package name */
    public final int f16596m;

    /* renamed from: n  reason: collision with root package name */
    public final int f16597n;

    /* renamed from: o  reason: collision with root package name */
    public final float f16598o;

    public b(Bitmap bitmap, float f2, int i2, float f3, int i3, float f4, float f5) {
        this((CharSequence) null, (Layout.Alignment) null, bitmap, f3, 0, i3, f2, i2, Integer.MIN_VALUE, -3.4028235E38f, f4, f5, false, -16777216);
    }

    public b(CharSequence charSequence) {
        this(charSequence, (Layout.Alignment) null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4) {
        this(charSequence, alignment, f2, i2, i3, f3, i4, f4, false, -16777216);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4, int i5, float f5) {
        this(charSequence, alignment, (Bitmap) null, f2, i2, i3, f3, i4, i5, f5, f4, -3.4028235E38f, false, -16777216);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4, boolean z2, int i5) {
        this(charSequence, alignment, (Bitmap) null, f2, i2, i3, f3, i4, Integer.MIN_VALUE, -3.4028235E38f, f4, -3.4028235E38f, z2, i5);
    }

    private b(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap, float f2, int i2, int i3, float f3, int i4, int i5, float f4, float f5, float f6, boolean z2, int i6) {
        this.f16585b = charSequence;
        this.f16586c = alignment;
        this.f16587d = bitmap;
        this.f16588e = f2;
        this.f16589f = i2;
        this.f16590g = i3;
        this.f16591h = f3;
        this.f16592i = i4;
        this.f16593j = f5;
        this.f16594k = f6;
        this.f16595l = z2;
        this.f16596m = i6;
        this.f16597n = i5;
        this.f16598o = f4;
    }
}
