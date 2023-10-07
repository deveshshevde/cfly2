package com.afollestad.materialdialogs.color.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.b;
import ay.e;
import com.afollestad.materialdialogs.color.R;
import kotlin.jvm.internal.h;

public final class ColorCircleView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f7526a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f7527b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7528c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f7529d;

    /* renamed from: e  reason: collision with root package name */
    private int f7530e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    private int f7531f = -12303292;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ColorCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.c(context, "context");
        Paint paint = new Paint();
        this.f7526a = paint;
        Paint paint2 = new Paint();
        this.f7527b = paint2;
        int a2 = e.f5573a.a(this, R.dimen.color_circle_view_border);
        this.f7528c = a2;
        setWillNotDraw(false);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setColor(-16777216);
        paint.setStrokeWidth((float) a2);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint2.setColor(-12303292);
    }

    public final int getBorder() {
        return this.f7531f;
    }

    public final int getColor() {
        return this.f7530e;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7529d = null;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        h.c(canvas, "canvas");
        super.onDraw(canvas);
        if (this.f7530e == 0) {
            if (this.f7529d == null) {
                this.f7529d = b.a(getContext(), R.drawable.transparentgrid);
            }
            Drawable drawable = this.f7529d;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
            Drawable drawable2 = this.f7529d;
            if (drawable2 != null) {
                drawable2.draw(canvas);
            }
        } else {
            canvas.drawCircle(((float) getMeasuredWidth()) / 2.0f, ((float) getMeasuredHeight()) / 2.0f, (((float) getMeasuredWidth()) / 2.0f) - ((float) this.f7528c), this.f7527b);
        }
        canvas.drawCircle(((float) getMeasuredWidth()) / 2.0f, ((float) getMeasuredHeight()) / 2.0f, (((float) getMeasuredWidth()) / 2.0f) - ((float) this.f7528c), this.f7526a);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i2);
    }

    public final void setBorder(int i2) {
        this.f7531f = i2;
        this.f7526a.setColor(i2);
        invalidate();
    }

    public final void setColor(int i2) {
        this.f7530e = i2;
        this.f7527b.setColor(i2);
        invalidate();
    }
}
