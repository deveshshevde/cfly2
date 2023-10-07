package com.xeagle.android.widgets.spinnerWheel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.blankj.utilcode.constant.MemoryConstants;
import com.cfly.uav_pro.R;
import com.xeagle.android.widgets.spinnerWheel.g;
import ll.c;

public class WheelHorizontalView extends AbstractWheelView {
    private int A;

    /* renamed from: y  reason: collision with root package name */
    protected int f26066y;

    /* renamed from: z  reason: collision with root package name */
    private final String f26067z;

    public WheelHorizontalView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WheelHorizontalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WheelHorizontalView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f26067z = WheelHorizontalView.class.getSimpleName();
        this.A = 0;
        if (isInEditMode()) {
            c cVar = new c(context, 0, 100);
            cVar.a((int) R.layout.wheel_text_centered);
            setViewAdapter(cVar);
            setCurrentItem(50);
        }
    }

    private int d(int i2, int i3) {
        this.f26028h.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f26028h.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(i2, 0));
        int measuredHeight = this.f26028h.getMeasuredHeight();
        if (i3 != 1073741824) {
            int max = Math.max(measuredHeight + (this.f26048q * 2), getSuggestedMinimumHeight());
            if (i3 != Integer.MIN_VALUE || i2 >= max) {
                i2 = max;
            }
        }
        this.f26028h.measure(View.MeasureSpec.makeMeasureSpec(400, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(i2 - (this.f26048q * 2), MemoryConstants.GB));
        return i2;
    }

    /* access modifiers changed from: protected */
    public float a(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    /* access modifiers changed from: protected */
    public g a(g.a aVar) {
        return new e(getContext(), aVar);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas) {
        canvas.save();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int itemDimension = getItemDimension();
        this.f26054w.eraseColor(0);
        Canvas canvas2 = new Canvas(this.f26054w);
        Canvas canvas3 = new Canvas(this.f26054w);
        canvas2.translate((float) ((-(((this.f26021a - this.f26029i) * itemDimension) + ((itemDimension - getWidth()) / 2))) + this.f26027g), (float) this.f26048q);
        this.f26028h.draw(canvas2);
        this.f26055x.eraseColor(0);
        Canvas canvas4 = new Canvas(this.f26055x);
        if (this.f26049r != null) {
            int i2 = this.f26066y;
            int width = ((getWidth() - itemDimension) - i2) / 2;
            int i3 = i2 + width;
            canvas4.save();
            canvas4.clipRect(width, 0, i3, measuredHeight);
            this.f26049r.setBounds(width, 0, i3, measuredHeight);
            this.f26049r.draw(canvas4);
            canvas4.restore();
            canvas4.save();
            int i4 = width + itemDimension;
            int i5 = i3 + itemDimension;
            canvas4.clipRect(i4, 0, i5, measuredHeight);
            this.f26049r.setBounds(i4, 0, i5, measuredHeight);
            this.f26049r.draw(canvas4);
            canvas4.restore();
        }
        float f2 = (float) measuredWidth;
        float f3 = (float) measuredHeight;
        canvas3.drawRect(0.0f, 0.0f, f2, f3, this.f26050s);
        canvas4.drawRect(0.0f, 0.0f, f2, f3, this.f26051t);
        canvas.drawBitmap(this.f26054w, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(this.f26055x, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.xeagle.R.styleable.WheelHorizontalView, i2, 0);
        this.f26066y = obtainStyledAttributes.getDimensionPixelSize(0, 2);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void e() {
        if (this.f26028h == null) {
            this.f26028h = new LinearLayout(getContext());
            this.f26028h.setOrientation(0);
        }
    }

    /* access modifiers changed from: protected */
    public void f() {
        this.f26028h.layout(0, 0, getMeasuredWidth(), getMeasuredHeight() - (this.f26048q * 2));
    }

    /* access modifiers changed from: protected */
    public int getBaseDimension() {
        return getWidth();
    }

    /* access modifiers changed from: protected */
    public int getItemDimension() {
        int i2 = this.A;
        if (i2 != 0) {
            return i2;
        }
        if (this.f26028h == null || this.f26028h.getChildAt(0) == null) {
            return getBaseDimension() / this.f26022b;
        }
        int measuredWidth = this.f26028h.getChildAt(0).getMeasuredWidth();
        this.A = measuredWidth;
        return measuredWidth;
    }

    public c getViewAdapter() {
        return (c) this.f26030j;
    }

    /* access modifiers changed from: protected */
    public void k() {
        this.f26028h.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f26028h.measure(View.MeasureSpec.makeMeasureSpec(getWidth() + getItemDimension(), 0), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        j();
        int d2 = d(size2, mode2);
        if (mode != 1073741824) {
            int max = Math.max(getItemDimension() * (this.f26022b - (this.f26047p / 100)), getSuggestedMinimumWidth());
            size = mode == Integer.MIN_VALUE ? Math.min(max, size) : max;
        }
        setMeasuredDimension(size, d2);
    }

    public void setSelectionDividerWidth(int i2) {
        this.f26066y = i2;
    }

    public void setSelectorPaintCoeff(float f2) {
        LinearGradient linearGradient;
        int measuredWidth = getMeasuredWidth();
        int itemDimension = getItemDimension();
        float f3 = (float) measuredWidth;
        float f4 = ((float) itemDimension) / f3;
        float f5 = (1.0f - f4) / 2.0f;
        float f6 = (f4 + 1.0f) / 2.0f;
        float f7 = ((float) this.f26044m) * (1.0f - f2);
        float f8 = (f2 * 255.0f) + f7;
        if (this.f26022b == 2) {
            int round = Math.round(f8) << 24;
            int round2 = Math.round(f7) << 24;
            linearGradient = new LinearGradient(0.0f, 0.0f, f3, 0.0f, new int[]{round2, round, -16777216, -16777216, round, round2}, new float[]{0.0f, f5, f5, f6, f6, 1.0f}, Shader.TileMode.CLAMP);
        } else {
            float f9 = ((float) (itemDimension * 3)) / f3;
            float f10 = (1.0f - f9) / 2.0f;
            float f11 = (f9 + 1.0f) / 2.0f;
            float f12 = ((255.0f * f10) / f5) * f2;
            Math.round(f8);
            int round3 = Math.round(f7 + f12) << 24;
            Math.round(f12);
            linearGradient = new LinearGradient(0.0f, 0.0f, f3, 0.0f, new int[]{round3, round3, round3, round3, -16777216, -16777216, round3, round3, round3, round3}, new float[]{0.0f, f10, f10, f5, f5, f6, f6, f11, f11, 1.0f}, Shader.TileMode.CLAMP);
        }
        this.f26050s.setShader(linearGradient);
        invalidate();
    }

    public void setViewAdapter(c cVar) {
        super.setViewAdapter(cVar);
    }
}
