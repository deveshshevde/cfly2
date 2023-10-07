package com.flyco.tablayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.blankj.utilcode.constant.MemoryConstants;
import com.flyco.tablayout.R;

public class MsgView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private Context f11512a;

    /* renamed from: b  reason: collision with root package name */
    private GradientDrawable f11513b;

    /* renamed from: c  reason: collision with root package name */
    private int f11514c;

    /* renamed from: d  reason: collision with root package name */
    private int f11515d;

    /* renamed from: e  reason: collision with root package name */
    private int f11516e;

    /* renamed from: f  reason: collision with root package name */
    private int f11517f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11518g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11519h;

    public MsgView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MsgView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MsgView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11513b = new GradientDrawable();
        this.f11512a = context;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MsgView);
        this.f11514c = obtainStyledAttributes.getColor(R.styleable.MsgView_mv_backgroundColor, 0);
        this.f11515d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MsgView_mv_cornerRadius, 0);
        this.f11516e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MsgView_mv_strokeWidth, 0);
        this.f11517f = obtainStyledAttributes.getColor(R.styleable.MsgView_mv_strokeColor, 0);
        this.f11518g = obtainStyledAttributes.getBoolean(R.styleable.MsgView_mv_isRadiusHalfHeight, false);
        this.f11519h = obtainStyledAttributes.getBoolean(R.styleable.MsgView_mv_isWidthHeightEqual, false);
        obtainStyledAttributes.recycle();
    }

    private void a(GradientDrawable gradientDrawable, int i2, int i3) {
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius((float) this.f11515d);
        gradientDrawable.setStroke(this.f11516e, i3);
    }

    /* access modifiers changed from: protected */
    public int a(float f2) {
        return (int) ((f2 * this.f11512a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public boolean a() {
        return this.f11518g;
    }

    public boolean b() {
        return this.f11519h;
    }

    public void c() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        a(this.f11513b, this.f11514c, this.f11517f);
        stateListDrawable.addState(new int[]{-16842919}, this.f11513b);
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(stateListDrawable);
        } else {
            setBackgroundDrawable(stateListDrawable);
        }
    }

    public int getBackgroundColor() {
        return this.f11514c;
    }

    public int getCornerRadius() {
        return this.f11515d;
    }

    public int getStrokeColor() {
        return this.f11517f;
    }

    public int getStrokeWidth() {
        return this.f11516e;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (a()) {
            setCornerRadius(getHeight() / 2);
        } else {
            c();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (!b() || getWidth() <= 0 || getHeight() <= 0) {
            super.onMeasure(i2, i3);
            return;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(getWidth(), getHeight()), MemoryConstants.GB);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public void setBackgroundColor(int i2) {
        this.f11514c = i2;
        c();
    }

    public void setCornerRadius(int i2) {
        this.f11515d = a((float) i2);
        c();
    }

    public void setIsRadiusHalfHeight(boolean z2) {
        this.f11518g = z2;
        c();
    }

    public void setIsWidthHeightEqual(boolean z2) {
        this.f11519h = z2;
        c();
    }

    public void setStrokeColor(int i2) {
        this.f11517f = i2;
        c();
    }

    public void setStrokeWidth(int i2) {
        this.f11516e = a((float) i2);
        c();
    }
}
