package com.xeagle.android.newUI.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class RoundRelativeLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private float f24134a;

    /* renamed from: b  reason: collision with root package name */
    private Path f24135b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f24136c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f24137d;

    public RoundRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24134a = 14.0f;
        this.f24137d = true;
        a();
    }

    private void a() {
        setWillNotDraw(false);
        this.f24135b = new Path();
        this.f24136c = new RectF();
    }

    private void b() {
        this.f24135b.reset();
        this.f24135b.addArc(this.f24136c, -180.0f, 180.0f);
    }

    public void draw(Canvas canvas) {
        if (this.f24137d) {
            canvas.clipPath(this.f24135b);
        }
        super.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.f24136c.set(0.0f, 0.0f, (float) getMeasuredWidth(), (float) (getMeasuredHeight() * 2));
        b();
    }

    public void setMap(boolean z2) {
        this.f24137d = z2;
        postInvalidate();
    }

    public void setRoundLayoutRadius(float f2) {
        this.f24134a = f2;
        b();
        postInvalidate();
    }
}
