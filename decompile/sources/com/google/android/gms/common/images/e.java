package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.internal.base.zak;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    final c f17732a;

    /* renamed from: b  reason: collision with root package name */
    protected int f17733b;

    /* access modifiers changed from: package-private */
    public final void a(Context context, Bitmap bitmap, boolean z2) {
        c.a((Object) bitmap);
        a(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }

    /* access modifiers changed from: package-private */
    public final void a(Context context, zak zak, boolean z2) {
        int i2 = this.f17733b;
        a(i2 != 0 ? context.getResources().getDrawable(i2) : null, z2, false, false);
    }

    /* access modifiers changed from: protected */
    public abstract void a(Drawable drawable, boolean z2, boolean z3, boolean z4);
}
