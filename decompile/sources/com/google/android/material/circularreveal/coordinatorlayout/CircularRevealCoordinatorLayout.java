package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;

public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements c {

    /* renamed from: f  reason: collision with root package name */
    private final b f18865f;

    public CircularRevealCoordinatorLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircularRevealCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18865f = new b(this);
    }

    public void a() {
        this.f18865f.a();
    }

    public void a(Canvas canvas) {
        super.draw(canvas);
    }

    public boolean c() {
        return super.isOpaque();
    }

    public void draw(Canvas canvas) {
        b bVar = this.f18865f;
        if (bVar != null) {
            bVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f18865f.e();
    }

    public int getCircularRevealScrimColor() {
        return this.f18865f.d();
    }

    public c.d getRevealInfo() {
        return this.f18865f.c();
    }

    public boolean isOpaque() {
        b bVar = this.f18865f;
        return bVar != null ? bVar.f() : super.isOpaque();
    }

    public void q_() {
        this.f18865f.b();
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f18865f.a(drawable);
    }

    public void setCircularRevealScrimColor(int i2) {
        this.f18865f.a(i2);
    }

    public void setRevealInfo(c.d dVar) {
        this.f18865f.a(dVar);
    }
}
