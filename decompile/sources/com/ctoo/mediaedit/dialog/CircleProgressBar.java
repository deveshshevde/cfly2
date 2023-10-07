package com.ctoo.mediaedit.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.ctoo.mediaedit.R;

public class CircleProgressBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private final RectF f10789a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f10790b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f10791c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f10792d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f10793e;

    /* renamed from: f  reason: collision with root package name */
    private float f10794f;

    /* renamed from: g  reason: collision with root package name */
    private float f10795g;

    /* renamed from: h  reason: collision with root package name */
    private float f10796h;

    /* renamed from: i  reason: collision with root package name */
    private int f10797i;

    /* renamed from: j  reason: collision with root package name */
    private int f10798j;

    /* renamed from: k  reason: collision with root package name */
    private int f10799k;

    /* renamed from: l  reason: collision with root package name */
    private float f10800l;

    /* renamed from: m  reason: collision with root package name */
    private float f10801m;

    /* renamed from: n  reason: collision with root package name */
    private float f10802n;

    /* renamed from: o  reason: collision with root package name */
    private int f10803o;

    /* renamed from: p  reason: collision with root package name */
    private int f10804p;

    /* renamed from: q  reason: collision with root package name */
    private int f10805q;

    /* renamed from: r  reason: collision with root package name */
    private int f10806r;

    /* renamed from: s  reason: collision with root package name */
    private int f10807s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f10808t;

    /* renamed from: u  reason: collision with root package name */
    private b f10809u;

    /* renamed from: v  reason: collision with root package name */
    private int f10810v;

    /* renamed from: w  reason: collision with root package name */
    private int f10811w;

    /* renamed from: x  reason: collision with root package name */
    private Paint.Cap f10812x;

    private static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f10813a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f10813a = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f10813a);
        }
    }

    private static final class a implements b {
        private a() {
        }

        public CharSequence a(int i2, int i3) {
            return String.format("%d%%", new Object[]{Integer.valueOf((int) ((((float) i2) / ((float) i3)) * 100.0f))});
        }
    }

    public interface b {
        CharSequence a(int i2, int i3);
    }

    public CircleProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10789a = new RectF();
        this.f10790b = new Rect();
        this.f10791c = new Paint(1);
        this.f10792d = new Paint(1);
        this.f10793e = new TextPaint(1);
        this.f10798j = 100;
        this.f10809u = new a();
        this.f10811w = 0;
        a(context, attributeSet);
        a();
    }

    private void a() {
        this.f10793e.setTextAlign(Paint.Align.CENTER);
        this.f10793e.setTextSize(this.f10802n);
        this.f10791c.setStyle(this.f10810v == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f10791c.setStrokeWidth(this.f10801m);
        this.f10791c.setColor(this.f10803o);
        this.f10791c.setStrokeCap(this.f10812x);
        this.f10792d.setStyle(this.f10810v == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f10792d.setStrokeWidth(this.f10801m);
        this.f10792d.setColor(this.f10806r);
        this.f10792d.setStrokeCap(this.f10812x);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleProgressBar);
        this.f10799k = obtainStyledAttributes.getInt(R.styleable.CircleProgressBar_line_count, 45);
        this.f10810v = obtainStyledAttributes.getInt(R.styleable.CircleProgressBar_style, 0);
        this.f10812x = Paint.Cap.BUTT;
        this.f10800l = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressBar_line_width, b.a(getContext(), 4.0f));
        this.f10802n = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressBar_progress_text_size, b.a(getContext(), 11.0f));
        this.f10801m = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressBar_progress_stroke_width, b.a(getContext(), 1.0f));
        this.f10803o = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progress_start_color, Color.parseColor("#fff2a670"));
        this.f10804p = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progress_end_color, Color.parseColor("#fff2a670"));
        this.f10805q = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progress_text_color, Color.parseColor("#fff2a670"));
        this.f10806r = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progress_background_color, Color.parseColor("#ffe3e3e5"));
        this.f10807s = obtainStyledAttributes.getInt(R.styleable.CircleProgressBar_progress_start_degree, -90);
        this.f10808t = obtainStyledAttributes.getBoolean(R.styleable.CircleProgressBar_drawBackgroundOutsideProgress, false);
        obtainStyledAttributes.recycle();
    }

    private void a(Canvas canvas) {
        b bVar = this.f10809u;
        if (bVar != null) {
            CharSequence a2 = bVar.a(this.f10797i, this.f10798j);
            if (!TextUtils.isEmpty(a2)) {
                this.f10793e.setTextSize(this.f10802n);
                this.f10793e.setColor(this.f10805q);
                this.f10793e.getTextBounds(String.valueOf(a2), 0, a2.length(), this.f10790b);
                canvas.drawText(a2, 0, a2.length(), this.f10795g, this.f10796h + ((float) (this.f10790b.height() / 2)), this.f10793e);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.graphics.Shader] */
    /* JADX WARNING: type inference failed for: r13v1, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: type inference failed for: r6v2, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r21 = this;
            r0 = r21
            int r1 = r0.f10803o
            int r2 = r0.f10804p
            r3 = 0
            if (r1 == r2) goto L_0x00b8
            int r1 = r0.f10811w
            if (r1 == 0) goto L_0x007d
            r2 = 1
            if (r1 == r2) goto L_0x006a
            r4 = 2
            if (r1 == r4) goto L_0x0015
            goto L_0x00b2
        L_0x0015:
            float r1 = r0.f10801m
            double r5 = (double) r1
            r7 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            java.lang.Double.isNaN(r5)
            double r5 = r5 / r7
            r7 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r5 = r5 * r7
            float r1 = r0.f10794f
            double r7 = (double) r1
            java.lang.Double.isNaN(r7)
            double r5 = r5 / r7
            float r1 = (float) r5
            android.graphics.Paint$Cap r3 = r0.f10812x
            android.graphics.Paint$Cap r5 = android.graphics.Paint.Cap.BUTT
            if (r3 != r5) goto L_0x003a
            int r3 = r0.f10810v
            if (r3 != r4) goto L_0x003a
            r5 = 0
            goto L_0x003f
        L_0x003a:
            double r5 = (double) r1
            double r5 = java.lang.Math.toDegrees(r5)
        L_0x003f:
            double r5 = -r5
            float r1 = (float) r5
            android.graphics.SweepGradient r3 = new android.graphics.SweepGradient
            float r5 = r0.f10795g
            float r6 = r0.f10796h
            int[] r7 = new int[r4]
            r8 = 0
            int r9 = r0.f10803o
            r7[r8] = r9
            int r8 = r0.f10804p
            r7[r2] = r8
            float[] r2 = new float[r4]
            r2 = {0, 1065353216} // fill-array
            r3.<init>(r5, r6, r7, r2)
            android.graphics.Matrix r2 = new android.graphics.Matrix
            r2.<init>()
            float r4 = r0.f10795g
            float r5 = r0.f10796h
            r2.setRotate(r1, r4, r5)
            r3.setLocalMatrix(r2)
            goto L_0x00b2
        L_0x006a:
            android.graphics.RadialGradient r3 = new android.graphics.RadialGradient
            float r7 = r0.f10795g
            float r8 = r0.f10796h
            float r9 = r0.f10794f
            int r10 = r0.f10803o
            int r11 = r0.f10804p
            android.graphics.Shader$TileMode r12 = android.graphics.Shader.TileMode.CLAMP
            r6 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            goto L_0x00b2
        L_0x007d:
            android.graphics.LinearGradient r3 = new android.graphics.LinearGradient
            android.graphics.RectF r1 = r0.f10789a
            float r14 = r1.left
            android.graphics.RectF r1 = r0.f10789a
            float r15 = r1.top
            android.graphics.RectF r1 = r0.f10789a
            float r1 = r1.left
            android.graphics.RectF r2 = r0.f10789a
            float r2 = r2.bottom
            int r4 = r0.f10803o
            int r5 = r0.f10804p
            android.graphics.Shader$TileMode r20 = android.graphics.Shader.TileMode.CLAMP
            r13 = r3
            r16 = r1
            r17 = r2
            r18 = r4
            r19 = r5
            r13.<init>(r14, r15, r16, r17, r18, r19, r20)
            android.graphics.Matrix r1 = new android.graphics.Matrix
            r1.<init>()
            r2 = 1119092736(0x42b40000, float:90.0)
            float r4 = r0.f10795g
            float r5 = r0.f10796h
            r1.setRotate(r2, r4, r5)
            r3.setLocalMatrix(r1)
        L_0x00b2:
            android.graphics.Paint r1 = r0.f10791c
            r1.setShader(r3)
            goto L_0x00c4
        L_0x00b8:
            android.graphics.Paint r1 = r0.f10791c
            r1.setShader(r3)
            android.graphics.Paint r1 = r0.f10791c
            int r2 = r0.f10803o
            r1.setColor(r2)
        L_0x00c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ctoo.mediaedit.dialog.CircleProgressBar.b():void");
    }

    private void b(Canvas canvas) {
        int i2 = this.f10810v;
        if (i2 == 1) {
            d(canvas);
        } else if (i2 != 2) {
            c(canvas);
        } else {
            e(canvas);
        }
    }

    private void c(Canvas canvas) {
        int i2 = this.f10799k;
        double d2 = (double) i2;
        Double.isNaN(d2);
        float f2 = (float) (6.283185307179586d / d2);
        float f3 = this.f10794f;
        float f4 = f3 - this.f10800l;
        int i3 = (int) ((((float) this.f10797i) / ((float) this.f10798j)) * ((float) i2));
        for (int i4 = 0; i4 < this.f10799k; i4++) {
            double d3 = (double) (((float) i4) * (-f2));
            float cos = (((float) Math.cos(d3)) * f4) + this.f10795g;
            float sin = this.f10796h - (((float) Math.sin(d3)) * f4);
            float cos2 = this.f10795g + (((float) Math.cos(d3)) * f3);
            float sin2 = this.f10796h - (((float) Math.sin(d3)) * f3);
            if (!this.f10808t || i4 >= i3) {
                canvas.drawLine(cos, sin, cos2, sin2, this.f10792d);
            }
            if (i4 < i3) {
                canvas.drawLine(cos, sin, cos2, sin2, this.f10791c);
            }
        }
    }

    private void d(Canvas canvas) {
        if (this.f10808t) {
            float f2 = (((float) this.f10797i) * 360.0f) / ((float) this.f10798j);
            Canvas canvas2 = canvas;
            canvas2.drawArc(this.f10789a, f2, 360.0f - f2, true, this.f10792d);
        } else {
            canvas.drawArc(this.f10789a, 0.0f, 360.0f, true, this.f10792d);
        }
        canvas.drawArc(this.f10789a, 0.0f, (((float) this.f10797i) * 360.0f) / ((float) this.f10798j), true, this.f10791c);
    }

    private void e(Canvas canvas) {
        if (this.f10808t) {
            float f2 = (((float) this.f10797i) * 360.0f) / ((float) this.f10798j);
            Canvas canvas2 = canvas;
            canvas2.drawArc(this.f10789a, f2, 360.0f - f2, false, this.f10792d);
        } else {
            canvas.drawArc(this.f10789a, 0.0f, 360.0f, false, this.f10792d);
        }
        canvas.drawArc(this.f10789a, 0.0f, (((float) this.f10797i) * 360.0f) / ((float) this.f10798j), false, this.f10791c);
    }

    public int getMax() {
        return this.f10798j;
    }

    public int getProgress() {
        return this.f10797i;
    }

    public int getStartDegree() {
        return this.f10807s;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate((float) this.f10807s, this.f10795g, this.f10796h);
        b(canvas);
        canvas.restore();
        a(canvas);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.f10813a);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f10813a = this.f10797i;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        float f2 = (float) (i2 / 2);
        this.f10795g = f2;
        float f3 = (float) (i3 / 2);
        this.f10796h = f3;
        float min = Math.min(f2, f3);
        this.f10794f = min;
        this.f10789a.top = this.f10796h - min;
        this.f10789a.bottom = this.f10796h + this.f10794f;
        this.f10789a.left = this.f10795g - this.f10794f;
        this.f10789a.right = this.f10795g + this.f10794f;
        b();
        RectF rectF = this.f10789a;
        float f4 = this.f10801m;
        rectF.inset(f4 / 2.0f, f4 / 2.0f);
    }

    public void setCap(Paint.Cap cap) {
        this.f10812x = cap;
        this.f10791c.setStrokeCap(cap);
        this.f10792d.setStrokeCap(cap);
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z2) {
        this.f10808t = z2;
        invalidate();
    }

    public void setLineCount(int i2) {
        this.f10799k = i2;
        invalidate();
    }

    public void setLineWidth(float f2) {
        this.f10800l = f2;
        invalidate();
    }

    public void setMax(int i2) {
        this.f10798j = i2;
        invalidate();
    }

    public void setProgress(int i2) {
        this.f10797i = i2;
        invalidate();
    }

    public void setProgressBackgroundColor(int i2) {
        this.f10806r = i2;
        this.f10792d.setColor(i2);
        invalidate();
    }

    public void setProgressEndColor(int i2) {
        this.f10804p = i2;
        b();
        invalidate();
    }

    public void setProgressFormatter(b bVar) {
        this.f10809u = bVar;
        invalidate();
    }

    public void setProgressStartColor(int i2) {
        this.f10803o = i2;
        b();
        invalidate();
    }

    public void setProgressStrokeWidth(float f2) {
        this.f10801m = f2;
        this.f10789a.inset(f2 / 2.0f, f2 / 2.0f);
        invalidate();
    }

    public void setProgressTextColor(int i2) {
        this.f10805q = i2;
        invalidate();
    }

    public void setProgressTextSize(float f2) {
        this.f10802n = f2;
        invalidate();
    }

    public void setShader(int i2) {
        this.f10811w = i2;
        b();
        invalidate();
    }

    public void setStartDegree(int i2) {
        this.f10807s = i2;
        invalidate();
    }

    public void setStyle(int i2) {
        this.f10810v = i2;
        this.f10791c.setStyle(i2 == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f10792d.setStyle(this.f10810v == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }
}
