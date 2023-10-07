package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;

public class CircularRevealCardView extends MaterialCardView implements c {

    /* renamed from: e  reason: collision with root package name */
    private final b f18864e;

    public CircularRevealCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircularRevealCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18864e = new b(this);
    }

    public void a() {
        this.f18864e.a();
    }

    public void a(Canvas canvas) {
        super.draw(canvas);
    }

    public boolean c() {
        return super.isOpaque();
    }

    public void draw(Canvas canvas) {
        b bVar = this.f18864e;
        if (bVar != null) {
            bVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f18864e.e();
    }

    public int getCircularRevealScrimColor() {
        return this.f18864e.d();
    }

    public c.d getRevealInfo() {
        return this.f18864e.c();
    }

    public boolean isOpaque() {
        b bVar = this.f18864e;
        return bVar != null ? bVar.f() : super.isOpaque();
    }

    public void q_() {
        this.f18864e.b();
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f18864e.a(drawable);
    }

    public void setCircularRevealScrimColor(int i2) {
        this.f18864e.a(i2);
    }

    public void setRevealInfo(c.d dVar) {
        this.f18864e.a(dVar);
    }
}
