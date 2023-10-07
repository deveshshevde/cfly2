package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import gw.h;
import gw.m;

class c extends h {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f19812a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f19813b;

    /* renamed from: c  reason: collision with root package name */
    private int f19814c;

    c() {
        this((m) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    c(m mVar) {
        super(mVar == null ? new m() : mVar);
        this.f19812a = new Paint(1);
        c();
        this.f19813b = new RectF();
    }

    private void a(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (a(callback)) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, (Paint) null);
                return;
            }
            return;
        }
        b(canvas);
    }

    private boolean a(Drawable.Callback callback) {
        return callback instanceof View;
    }

    private void b(Canvas canvas) {
        int i2;
        if (Build.VERSION.SDK_INT >= 21) {
            i2 = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null);
        } else {
            i2 = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null, 31);
        }
        this.f19814c = i2;
    }

    private void c() {
        this.f19812a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f19812a.setColor(-1);
        this.f19812a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private void c(Canvas canvas) {
        if (!a(getCallback())) {
            canvas.restoreToCount(this.f19814c);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3, float f4, float f5) {
        if (f2 != this.f19813b.left || f3 != this.f19813b.top || f4 != this.f19813b.right || f5 != this.f19813b.bottom) {
            this.f19813b.set(f2, f3, f4, f5);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(RectF rectF) {
        a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return !this.f19813b.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void draw(Canvas canvas) {
        a(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f19813b, this.f19812a);
        c(canvas);
    }
}
