package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.material.circularreveal.c;

public class CircularRevealFrameLayout extends FrameLayout implements c {

    /* renamed from: a  reason: collision with root package name */
    private final b f18842a;

    public CircularRevealFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircularRevealFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18842a = new b(this);
    }

    public void a() {
        this.f18842a.a();
    }

    public void a(Canvas canvas) {
        super.draw(canvas);
    }

    public boolean c() {
        return super.isOpaque();
    }

    public void draw(Canvas canvas) {
        b bVar = this.f18842a;
        if (bVar != null) {
            bVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f18842a.e();
    }

    public int getCircularRevealScrimColor() {
        return this.f18842a.d();
    }

    public c.d getRevealInfo() {
        return this.f18842a.c();
    }

    public boolean isOpaque() {
        b bVar = this.f18842a;
        return bVar != null ? bVar.f() : super.isOpaque();
    }

    public void q_() {
        this.f18842a.b();
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f18842a.a(drawable);
    }

    public void setCircularRevealScrimColor(int i2) {
        this.f18842a.a(i2);
    }

    public void setRevealInfo(c.d dVar) {
        this.f18842a.a(dVar);
    }
}
