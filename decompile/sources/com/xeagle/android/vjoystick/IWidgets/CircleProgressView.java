package com.xeagle.android.vjoystick.IWidgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;
import com.xeagle.R;

public class CircleProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f24652a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Paint f24653b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f24654c;

    /* renamed from: d  reason: collision with root package name */
    private a f24655d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public float f24656e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public float f24657f;

    /* renamed from: g  reason: collision with root package name */
    private int f24658g;

    /* renamed from: h  reason: collision with root package name */
    private int f24659h;

    /* renamed from: i  reason: collision with root package name */
    private float f24660i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public float f24661j;

    /* renamed from: k  reason: collision with root package name */
    private float f24662k;

    /* renamed from: l  reason: collision with root package name */
    private int f24663l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public float f24664m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public TextView f24665n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public b f24666o;

    public class a extends Animation {
        public a() {
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f2, Transformation transformation) {
            super.applyTransformation(f2, transformation);
            CircleProgressView circleProgressView = CircleProgressView.this;
            float unused = circleProgressView.f24664m = ((circleProgressView.f24661j * f2) * CircleProgressView.this.f24656e) / CircleProgressView.this.f24657f;
            if (CircleProgressView.this.f24666o != null) {
                if (CircleProgressView.this.f24665n != null) {
                    CircleProgressView.this.f24665n.setText(CircleProgressView.this.f24666o.a(f2, CircleProgressView.this.f24656e, CircleProgressView.this.f24657f));
                }
                CircleProgressView.this.f24666o.a(CircleProgressView.this.f24653b, f2, CircleProgressView.this.f24656e, CircleProgressView.this.f24657f);
            }
            CircleProgressView.this.postInvalidate();
        }
    }

    public interface b {
        String a(float f2, float f3, float f4);

        void a(Paint paint, float f2, float f3, float f4);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private int a(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleBarView);
        this.f24658g = obtainStyledAttributes.getColor(3, -16711936);
        this.f24659h = obtainStyledAttributes.getColor(1, -7829368);
        this.f24660i = obtainStyledAttributes.getFloat(2, 0.0f);
        this.f24661j = obtainStyledAttributes.getFloat(4, 360.0f);
        this.f24662k = obtainStyledAttributes.getDimension(0, (float) com.xeagle.android.vjoystick.utils.a.a(context, 10.0f));
        obtainStyledAttributes.recycle();
        this.f24656e = 0.0f;
        this.f24657f = 100.0f;
        this.f24663l = com.xeagle.android.vjoystick.utils.a.a(context, 100.0f);
        this.f24654c = new RectF();
        Paint paint = new Paint();
        this.f24653b = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f24653b.setColor(this.f24658g);
        this.f24653b.setAntiAlias(true);
        this.f24653b.setStrokeWidth(this.f24662k);
        this.f24653b.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.f24652a = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f24652a.setColor(this.f24659h);
        this.f24652a.setAntiAlias(true);
        this.f24652a.setStrokeWidth(this.f24662k);
        this.f24652a.setStrokeCap(Paint.Cap.ROUND);
        this.f24655d = new a();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f24654c, this.f24660i, this.f24661j, false, this.f24652a);
        canvas.drawArc(this.f24654c, this.f24660i, this.f24664m, false, this.f24653b);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int min = Math.min(a(this.f24663l, i2), a(this.f24663l, i3));
        setMeasuredDimension(min, min);
        float f2 = (float) min;
        float f3 = this.f24662k;
        if (f2 >= f3 * 2.0f) {
            this.f24654c.set(f3 / 2.0f, f3 / 2.0f, f2 - (f3 / 2.0f), f2 - (f3 / 2.0f));
        }
    }

    public void setMaxNum(float f2) {
        this.f24657f = f2;
    }

    public void setOnAnimationListener(b bVar) {
        this.f24666o = bVar;
    }

    public void setTextView(TextView textView) {
        this.f24665n = textView;
    }
}
