package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;
import com.google.android.material.circularreveal.c;

public class CircularRevealGridLayout extends GridLayout implements c {

    /* renamed from: a  reason: collision with root package name */
    private final b f18843a;

    public CircularRevealGridLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircularRevealGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18843a = new b(this);
    }

    public void a() {
        this.f18843a.a();
    }

    public void a(Canvas canvas) {
        super.draw(canvas);
    }

    public boolean c() {
        return super.isOpaque();
    }

    public void draw(Canvas canvas) {
        b bVar = this.f18843a;
        if (bVar != null) {
            bVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f18843a.e();
    }

    public int getCircularRevealScrimColor() {
        return this.f18843a.d();
    }

    public c.d getRevealInfo() {
        return this.f18843a.c();
    }

    public boolean isOpaque() {
        b bVar = this.f18843a;
        return bVar != null ? bVar.f() : super.isOpaque();
    }

    public void q_() {
        this.f18843a.b();
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f18843a.a(drawable);
    }

    public void setCircularRevealScrimColor(int i2) {
        this.f18843a.a(i2);
    }

    public void setRevealInfo(c.d dVar) {
        this.f18843a.a(dVar);
    }
}
