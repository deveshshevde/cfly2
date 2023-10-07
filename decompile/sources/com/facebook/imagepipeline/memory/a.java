package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import df.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f11354a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11355b;

    /* renamed from: c  reason: collision with root package name */
    private final dh.a<Bitmap> f11356c;

    public a(int i2, int i3) {
        boolean z2 = true;
        c.a(i2 > 0);
        c.a(i3 <= 0 ? false : z2);
        this.f11354a = i2;
        this.f11355b = i3;
        this.f11356c = new dh.a<Bitmap>() {
        };
    }
}
