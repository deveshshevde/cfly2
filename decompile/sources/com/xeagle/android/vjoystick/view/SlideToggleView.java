package com.xeagle.android.vjoystick.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xeagle.R;
import x.c;

public class SlideToggleView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static float f25420a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public c f25421b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f25422c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ImageView f25423d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f25424e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f25425f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f25426g;

    /* renamed from: h  reason: collision with root package name */
    private int f25427h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f25428i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public a f25429j;

    /* renamed from: k  reason: collision with root package name */
    private c.a f25430k;

    public interface a {
        void a(SlideToggleView slideToggleView);

        void a(SlideToggleView slideToggleView, int i2, int i3, int i4);
    }

    public SlideToggleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlideToggleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideToggleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f25430k = new c.a() {
            public int a(View view, int i2, int i3) {
                int paddingLeft = SlideToggleView.this.getPaddingLeft() + SlideToggleView.this.f25424e;
                if (i2 < paddingLeft) {
                    i2 = paddingLeft;
                }
                int measuredWidth = ((SlideToggleView.this.getMeasuredWidth() - SlideToggleView.this.getPaddingRight()) - SlideToggleView.this.f25425f) - SlideToggleView.this.f25423d.getMeasuredWidth();
                return i2 > measuredWidth ? measuredWidth : i2;
            }

            public void a(View view, float f2, float f3) {
                if (view != SlideToggleView.this.f25423d) {
                    return;
                }
                if ((((((SlideToggleView.this.getMeasuredWidth() - SlideToggleView.this.getPaddingLeft()) - SlideToggleView.this.getPaddingRight()) - SlideToggleView.this.f25424e) - SlideToggleView.this.f25425f) - SlideToggleView.this.f25423d.getMeasuredWidth()) - ((view.getLeft() - SlideToggleView.this.getPaddingLeft()) - SlideToggleView.this.f25424e) <= SlideToggleView.this.f25428i) {
                    SlideToggleView.this.a();
                    if (SlideToggleView.this.f25429j != null) {
                        SlideToggleView.this.f25429j.a(SlideToggleView.this);
                        return;
                    }
                    return;
                }
                SlideToggleView.this.f25421b.a(SlideToggleView.this.getPaddingLeft() + SlideToggleView.this.f25424e, SlideToggleView.this.getPaddingTop() + SlideToggleView.this.f25426g);
                SlideToggleView.this.invalidate();
            }

            public void a(View view, int i2) {
                ViewParent parent = view.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }

            public void a(View view, int i2, int i3, int i4, int i5) {
                if (SlideToggleView.this.f25429j != null) {
                    SlideToggleView.this.f25429j.a(SlideToggleView.this, i2, ((((SlideToggleView.this.getMeasuredWidth() - SlideToggleView.this.getPaddingLeft()) - SlideToggleView.this.getPaddingRight()) - SlideToggleView.this.f25424e) - SlideToggleView.this.f25425f) - SlideToggleView.this.f25423d.getMeasuredWidth(), (i2 - SlideToggleView.this.getPaddingLeft()) - SlideToggleView.this.f25424e);
                }
            }

            public int b(View view, int i2, int i3) {
                return SlideToggleView.this.getPaddingTop() + SlideToggleView.this.f25426g;
            }

            public boolean b(View view, int i2) {
                return view == SlideToggleView.this.f25423d;
            }
        };
        a(context, attributeSet, i2);
        this.f25421b = c.a((ViewGroup) this, 1.0f, this.f25430k);
    }

    public static float a(Context context) {
        if (f25420a <= 0.0f) {
            f25420a = context.getResources().getDisplayMetrics().density;
        }
        return f25420a;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * a(context)) + 0.5f);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlideToggleView, i2, 0);
        String string = obtainStyledAttributes.getString(6);
        int color = obtainStyledAttributes.getColor(7, -1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, a(context, 14.0f));
        Drawable drawable = obtainStyledAttributes.getDrawable(5);
        this.f25424e = obtainStyledAttributes.getDimensionPixelSize(1, 4);
        this.f25425f = obtainStyledAttributes.getDimensionPixelSize(2, 4);
        this.f25426g = obtainStyledAttributes.getDimensionPixelSize(3, 4);
        this.f25427h = obtainStyledAttributes.getDimensionPixelSize(0, 4);
        this.f25428i = obtainStyledAttributes.getDimensionPixelSize(4, 10);
        obtainStyledAttributes.recycle();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        TextView textView = new TextView(context);
        this.f25422c = textView;
        textView.setText(string);
        this.f25422c.setTextColor(color);
        this.f25422c.setTextSize(0, (float) dimensionPixelSize);
        addView(this.f25422c, layoutParams);
        ImageView imageView = new ImageView(context);
        this.f25423d = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f25423d.setImageDrawable(drawable);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.setMargins(this.f25424e, this.f25426g, this.f25425f, this.f25427h);
        addView(this.f25423d, layoutParams2);
    }

    public void a() {
        this.f25421b.a((View) this.f25423d, ((getMeasuredWidth() - getPaddingRight()) - this.f25425f) - this.f25423d.getMeasuredWidth(), getPaddingTop() + this.f25426g);
        invalidate();
    }

    public void computeScroll() {
        if (this.f25421b.a(true)) {
            invalidate();
        } else {
            super.computeScroll();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f25421b.a(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f25421b.b(motionEvent);
        return true;
    }

    public void setBlockDrawable(Drawable drawable) {
        this.f25423d.setImageDrawable(drawable);
    }

    public void setRemainDistance(int i2) {
        this.f25428i = i2;
    }

    public void setSlideToggleListener(a aVar) {
        this.f25429j = aVar;
    }

    public void setText(String str) {
        this.f25422c.setText(str);
    }

    public void setTextColor(int i2) {
        this.f25422c.setTextColor(i2);
    }

    public void setTextSize(float f2) {
        this.f25422c.setTextSize(f2);
    }
}
