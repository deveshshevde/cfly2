package com.xeagle.android.editor.widget.indicatorSeekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class ArrowView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final int f23032a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23033b;

    /* renamed from: c  reason: collision with root package name */
    private final Path f23034c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f23035d;

    public ArrowView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ArrowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int a2 = f.a(context, 12.0f);
        this.f23032a = a2;
        int a3 = f.a(context, 7.0f);
        this.f23033b = a3;
        Path path = new Path();
        this.f23034c = path;
        path.moveTo(0.0f, 0.0f);
        path.lineTo((float) a2, 0.0f);
        path.lineTo(((float) a2) / 2.0f, (float) a3);
        path.close();
        Paint paint = new Paint();
        this.f23035d = paint;
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1.0f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawPath(this.f23034c, this.f23035d);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(this.f23032a, this.f23033b);
    }

    /* access modifiers changed from: package-private */
    public void setColor(int i2) {
        this.f23035d.setColor(i2);
        invalidate();
    }
}
