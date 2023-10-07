package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.google.android.material.circularreveal.c;

public class CircularRevealLinearLayout extends LinearLayout implements c {

    /* renamed from: a  reason: collision with root package name */
    private final b f18844a;

    public CircularRevealLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircularRevealLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18844a = new b(this);
    }

    public void a() {
        this.f18844a.a();
    }

    public void a(Canvas canvas) {
        super.draw(canvas);
    }

    public boolean c() {
        return super.isOpaque();
    }

    public void draw(Canvas canvas) {
        b bVar = this.f18844a;
        if (bVar != null) {
            bVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f18844a.e();
    }

    public int getCircularRevealScrimColor() {
        return this.f18844a.d();
    }

    public c.d getRevealInfo() {
        return this.f18844a.c();
    }

    public boolean isOpaque() {
        b bVar = this.f18844a;
        return bVar != null ? bVar.f() : super.isOpaque();
    }

    public void q_() {
        this.f18844a.b();
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f18844a.a(drawable);
    }

    public void setCircularRevealScrimColor(int i2) {
        this.f18844a.a(i2);
    }

    public void setRevealInfo(c.d dVar) {
        this.f18844a.a(dVar);
    }
}
