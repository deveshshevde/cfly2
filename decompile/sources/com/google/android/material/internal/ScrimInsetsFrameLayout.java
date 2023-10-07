package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.R;
import t.ac;
import t.ak;
import t.u;

public class ScrimInsetsFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Drawable f19208a;

    /* renamed from: b  reason: collision with root package name */
    Rect f19209b;

    /* renamed from: c  reason: collision with root package name */
    private Rect f19210c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19211d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19212e;

    public ScrimInsetsFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19210c = new Rect();
        this.f19211d = true;
        this.f19212e = true;
        TypedArray a2 = l.a(context, attributeSet, R.styleable.ScrimInsetsFrameLayout, i2, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f19208a = a2.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        a2.recycle();
        setWillNotDraw(true);
        ac.a((View) this, (u) new u() {
            public ak a(View view, ak akVar) {
                if (ScrimInsetsFrameLayout.this.f19209b == null) {
                    ScrimInsetsFrameLayout.this.f19209b = new Rect();
                }
                ScrimInsetsFrameLayout.this.f19209b.set(akVar.a(), akVar.b(), akVar.c(), akVar.d());
                ScrimInsetsFrameLayout.this.a(akVar);
                ScrimInsetsFrameLayout.this.setWillNotDraw(!akVar.e() || ScrimInsetsFrameLayout.this.f19208a == null);
                ac.e(ScrimInsetsFrameLayout.this);
                return akVar.g();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(ak akVar) {
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f19209b != null && this.f19208a != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            if (this.f19211d) {
                this.f19210c.set(0, 0, width, this.f19209b.top);
                this.f19208a.setBounds(this.f19210c);
                this.f19208a.draw(canvas);
            }
            if (this.f19212e) {
                this.f19210c.set(0, height - this.f19209b.bottom, width, height);
                this.f19208a.setBounds(this.f19210c);
                this.f19208a.draw(canvas);
            }
            this.f19210c.set(0, this.f19209b.top, this.f19209b.left, height - this.f19209b.bottom);
            this.f19208a.setBounds(this.f19210c);
            this.f19208a.draw(canvas);
            this.f19210c.set(width - this.f19209b.right, this.f19209b.top, width, height - this.f19209b.bottom);
            this.f19208a.setBounds(this.f19210c);
            this.f19208a.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f19208a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f19208a;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z2) {
        this.f19212e = z2;
    }

    public void setDrawTopInsetForeground(boolean z2) {
        this.f19211d = z2;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f19208a = drawable;
    }
}
