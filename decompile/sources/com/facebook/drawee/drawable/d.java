package com.facebook.drawee.drawable;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private int f11167a = -1;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11168b = false;

    /* renamed from: c  reason: collision with root package name */
    private ColorFilter f11169c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f11170d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f11171e = -1;

    public void a(int i2) {
        this.f11167a = i2;
    }

    public void a(ColorFilter colorFilter) {
        this.f11169c = colorFilter;
        this.f11168b = true;
    }

    public void a(Drawable drawable) {
        if (drawable != null) {
            int i2 = this.f11167a;
            if (i2 != -1) {
                drawable.setAlpha(i2);
            }
            if (this.f11168b) {
                drawable.setColorFilter(this.f11169c);
            }
            int i3 = this.f11170d;
            boolean z2 = true;
            if (i3 != -1) {
                drawable.setDither(i3 != 0);
            }
            int i4 = this.f11171e;
            if (i4 != -1) {
                if (i4 == 0) {
                    z2 = false;
                }
                drawable.setFilterBitmap(z2);
            }
        }
    }

    public void a(boolean z2) {
        this.f11170d = z2 ? 1 : 0;
    }

    public void b(boolean z2) {
        this.f11171e = z2 ? 1 : 0;
    }
}
