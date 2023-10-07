package com.xeagle.android.newUI.widgets.timelapseProgress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import com.xeagle.R;

public class PedometerArcView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Paint f24207a;

    /* renamed from: b  reason: collision with root package name */
    private float f24208b;

    /* renamed from: c  reason: collision with root package name */
    private float f24209c;

    /* renamed from: d  reason: collision with root package name */
    private float f24210d;

    /* renamed from: e  reason: collision with root package name */
    private int f24211e;

    /* renamed from: f  reason: collision with root package name */
    private int f24212f;

    /* renamed from: g  reason: collision with root package name */
    private int f24213g;

    /* renamed from: h  reason: collision with root package name */
    private int f24214h;

    /* renamed from: i  reason: collision with root package name */
    private int f24215i;

    /* renamed from: j  reason: collision with root package name */
    private long f24216j;

    /* renamed from: k  reason: collision with root package name */
    private Context f24217k;

    /* renamed from: l  reason: collision with root package name */
    private AttributeSet f24218l;

    public PedometerArcView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PedometerArcView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PedometerArcView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24208b = 0.0f;
        this.f24209c = 5.0f;
        this.f24210d = 4.0f;
        this.f24211e = Color.parseColor("#E0E0E0");
        this.f24212f = Color.parseColor("#F36C60");
        this.f24213g = 0;
        this.f24214h = 0;
        this.f24215i = 0;
        this.f24216j = 1000;
        this.f24217k = context;
        this.f24218l = attributeSet;
        a();
        TypedArray obtainStyledAttributes = this.f24217k.obtainStyledAttributes(attributeSet, R.styleable.PedometerArcView, i2, 0);
        float dimensionPixelSize = (float) obtainStyledAttributes.getDimensionPixelSize(4, (int) this.f24208b);
        this.f24208b = dimensionPixelSize;
        this.f24207a.setStrokeWidth(dimensionPixelSize);
        this.f24211e = obtainStyledAttributes.getColor(0, this.f24211e);
        this.f24212f = obtainStyledAttributes.getColor(1, this.f24212f);
        this.f24213g = obtainStyledAttributes.getInt(3, this.f24213g);
        int i3 = obtainStyledAttributes.getInt(2, this.f24214h);
        this.f24214h = i3;
        this.f24215i = i3;
        obtainStyledAttributes.recycle();
    }

    private void a() {
        setWillNotDraw(false);
        this.f24208b = TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics());
        Paint paint = new Paint();
        this.f24207a = paint;
        paint.setAntiAlias(true);
        this.f24207a.setStrokeWidth(this.f24208b);
        this.f24207a.setStyle(Paint.Style.STROKE);
    }

    private void setorusWidth(float f2) {
        this.f24208b = f2;
        this.f24207a.setStrokeWidth(f2);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = this.f24208b / 2.0f;
        RectF rectF = new RectF(f2, f2, ((float) getWidth()) - f2, ((float) getHeight()) - f2);
        this.f24207a.setColor(this.f24211e);
        for (int i2 = 0; i2 < 72; i2++) {
            canvas.drawArc(rectF, (((float) i2) * this.f24209c) - 90.0f, this.f24210d, false, this.f24207a);
        }
        int i3 = this.f24213g;
        int i4 = this.f24215i;
        this.f24207a.setColor(this.f24212f);
        for (int i5 = i3; i5 < i4 + i3; i5++) {
            canvas.drawArc(rectF, (((float) (i5 % 72)) * this.f24209c) - 90.0f, this.f24210d, false, this.f24207a);
        }
    }

    public final void setShowTime(long j2) {
        this.f24216j = j2;
    }
}
