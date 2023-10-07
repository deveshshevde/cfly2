package com.xeagle.android.newUI.widgets.timelapseProgress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
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
import com.xeagle.R;

public class CircleLineProgress extends View {
    private int A;
    private int B;
    private Paint.Cap C;
    private int D;
    private BlurMaskFilter.Blur E;

    /* renamed from: a  reason: collision with root package name */
    private final RectF f24180a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f24181b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f24182c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f24183d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f24184e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f24185f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f24186g;

    /* renamed from: h  reason: collision with root package name */
    private float f24187h;

    /* renamed from: i  reason: collision with root package name */
    private float f24188i;

    /* renamed from: j  reason: collision with root package name */
    private float f24189j;

    /* renamed from: k  reason: collision with root package name */
    private int f24190k;

    /* renamed from: l  reason: collision with root package name */
    private int f24191l;

    /* renamed from: m  reason: collision with root package name */
    private int f24192m;

    /* renamed from: n  reason: collision with root package name */
    private float f24193n;

    /* renamed from: o  reason: collision with root package name */
    private float f24194o;

    /* renamed from: p  reason: collision with root package name */
    private float f24195p;

    /* renamed from: q  reason: collision with root package name */
    private int f24196q;

    /* renamed from: r  reason: collision with root package name */
    private int f24197r;

    /* renamed from: s  reason: collision with root package name */
    private int f24198s;

    /* renamed from: t  reason: collision with root package name */
    private int f24199t;

    /* renamed from: u  reason: collision with root package name */
    private int f24200u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f24201v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f24202w;

    /* renamed from: x  reason: collision with root package name */
    private int f24203x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f24204y;

    /* renamed from: z  reason: collision with root package name */
    private b f24205z;

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
        int f24206a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f24206a = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f24206a);
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

    public CircleLineProgress(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircleLineProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24180a = new RectF();
        this.f24181b = new RectF();
        this.f24182c = new Rect();
        this.f24183d = new Paint(1);
        this.f24184e = new Paint(1);
        this.f24185f = new Paint(1);
        this.f24186g = new TextPaint(1);
        this.f24191l = 100;
        this.f24205z = new a();
        a(context, attributeSet);
        a();
    }

    private static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void a() {
        this.f24186g.setTextAlign(Paint.Align.CENTER);
        this.f24186g.setTextSize(this.f24195p);
        this.f24183d.setStyle(this.A == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f24183d.setStrokeWidth(this.f24194o);
        this.f24183d.setColor(this.f24196q);
        this.f24183d.setStrokeCap(this.C);
        b();
        this.f24184e.setStyle(this.A == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f24184e.setStrokeWidth(this.f24194o);
        this.f24184e.setColor(this.f24199t);
        this.f24184e.setStrokeCap(this.C);
        this.f24185f.setStyle(this.A == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f24185f.setStrokeWidth(this.f24194o);
        this.f24185f.setColor(this.f24200u);
        this.f24185f.setStrokeCap(this.C);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleLineProgress);
        this.f24192m = obtainStyledAttributes.getInt(1, 60);
        this.A = obtainStyledAttributes.getInt(14, 0);
        this.B = obtainStyledAttributes.getInt(9, 0);
        this.C = obtainStyledAttributes.hasValue(12) ? Paint.Cap.values()[obtainStyledAttributes.getInt(12, 0)] : Paint.Cap.BUTT;
        this.f24193n = (float) obtainStyledAttributes.getDimensionPixelSize(2, a(getContext(), 4.0f));
        this.f24195p = (float) obtainStyledAttributes.getDimensionPixelSize(17, a(getContext(), 11.0f));
        this.f24194o = (float) obtainStyledAttributes.getDimensionPixelSize(13, a(getContext(), 1.0f));
        this.f24196q = obtainStyledAttributes.getColor(10, Color.parseColor("#fff2a670"));
        this.f24197r = obtainStyledAttributes.getColor(7, Color.parseColor("#fff2a670"));
        this.f24198s = obtainStyledAttributes.getColor(15, Color.parseColor("#fff2a670"));
        this.f24199t = obtainStyledAttributes.getColor(4, Color.parseColor("#ffe3e3e5"));
        this.f24200u = obtainStyledAttributes.getColor(3, Color.parseColor("#ffe3e3e5"));
        this.f24203x = obtainStyledAttributes.getInt(11, -90);
        this.f24204y = obtainStyledAttributes.getBoolean(0, false);
        this.f24201v = obtainStyledAttributes.getBoolean(16, false);
        this.f24202w = obtainStyledAttributes.getBoolean(8, true);
        this.D = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        int i2 = obtainStyledAttributes.getInt(6, 0);
        this.E = i2 != 1 ? i2 != 2 ? i2 != 3 ? BlurMaskFilter.Blur.NORMAL : BlurMaskFilter.Blur.INNER : BlurMaskFilter.Blur.OUTER : BlurMaskFilter.Blur.SOLID;
        obtainStyledAttributes.recycle();
    }

    private void a(Canvas canvas) {
        b bVar = this.f24205z;
        if (bVar != null && this.f24201v) {
            CharSequence a2 = bVar.a(this.f24190k, this.f24191l);
            if (!TextUtils.isEmpty(a2)) {
                this.f24186g.setTextSize(this.f24195p);
                this.f24186g.setColor(this.f24198s);
                this.f24186g.getTextBounds(String.valueOf(a2), 0, a2.length(), this.f24182c);
                canvas.drawText(a2, 0, a2.length(), this.f24188i, this.f24189j + ((float) (this.f24182c.height() / 2)), this.f24186g);
            }
        }
    }

    private void b() {
        BlurMaskFilter blurMaskFilter;
        Paint paint;
        if (this.E == null || this.D <= 0) {
            paint = this.f24183d;
            blurMaskFilter = null;
        } else {
            setLayerType(1, this.f24183d);
            paint = this.f24183d;
            blurMaskFilter = new BlurMaskFilter((float) this.D, this.E);
        }
        paint.setMaskFilter(blurMaskFilter);
    }

    private void b(Canvas canvas) {
        int i2 = this.A;
        if (i2 == 1) {
            d(canvas);
        } else if (i2 != 2) {
            c(canvas);
        } else {
            e(canvas);
        }
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.graphics.Shader] */
    /* JADX WARNING: type inference failed for: r13v1, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: type inference failed for: r6v2, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
            r21 = this;
            r0 = r21
            int r1 = r0.f24196q
            int r2 = r0.f24197r
            r3 = 0
            if (r1 == r2) goto L_0x00b8
            int r1 = r0.B
            if (r1 == 0) goto L_0x007d
            r2 = 1
            if (r1 == r2) goto L_0x006a
            r4 = 2
            if (r1 == r4) goto L_0x0015
            goto L_0x00b2
        L_0x0015:
            float r1 = r0.f24194o
            double r5 = (double) r1
            r7 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            java.lang.Double.isNaN(r5)
            double r5 = r5 / r7
            r7 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r5 = r5 * r7
            float r1 = r0.f24187h
            double r7 = (double) r1
            java.lang.Double.isNaN(r7)
            double r5 = r5 / r7
            float r1 = (float) r5
            android.graphics.Paint$Cap r3 = r0.C
            android.graphics.Paint$Cap r5 = android.graphics.Paint.Cap.BUTT
            if (r3 != r5) goto L_0x003a
            int r3 = r0.A
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
            float r5 = r0.f24188i
            float r6 = r0.f24189j
            int[] r7 = new int[r4]
            r8 = 0
            int r9 = r0.f24196q
            r7[r8] = r9
            int r8 = r0.f24197r
            r7[r2] = r8
            float[] r2 = new float[r4]
            r2 = {0, 1065353216} // fill-array
            r3.<init>(r5, r6, r7, r2)
            android.graphics.Matrix r2 = new android.graphics.Matrix
            r2.<init>()
            float r4 = r0.f24188i
            float r5 = r0.f24189j
            r2.setRotate(r1, r4, r5)
            r3.setLocalMatrix(r2)
            goto L_0x00b2
        L_0x006a:
            android.graphics.RadialGradient r3 = new android.graphics.RadialGradient
            float r7 = r0.f24188i
            float r8 = r0.f24189j
            float r9 = r0.f24187h
            int r10 = r0.f24196q
            int r11 = r0.f24197r
            android.graphics.Shader$TileMode r12 = android.graphics.Shader.TileMode.CLAMP
            r6 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            goto L_0x00b2
        L_0x007d:
            android.graphics.LinearGradient r3 = new android.graphics.LinearGradient
            android.graphics.RectF r1 = r0.f24180a
            float r14 = r1.left
            android.graphics.RectF r1 = r0.f24180a
            float r15 = r1.top
            android.graphics.RectF r1 = r0.f24180a
            float r1 = r1.left
            android.graphics.RectF r2 = r0.f24180a
            float r2 = r2.bottom
            int r4 = r0.f24196q
            int r5 = r0.f24197r
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
            float r4 = r0.f24188i
            float r5 = r0.f24189j
            r1.setRotate(r2, r4, r5)
            r3.setLocalMatrix(r1)
        L_0x00b2:
            android.graphics.Paint r1 = r0.f24183d
            r1.setShader(r3)
            goto L_0x00c4
        L_0x00b8:
            android.graphics.Paint r1 = r0.f24183d
            r1.setShader(r3)
            android.graphics.Paint r1 = r0.f24183d
            int r2 = r0.f24196q
            r1.setColor(r2)
        L_0x00c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.newUI.widgets.timelapseProgress.CircleLineProgress.c():void");
    }

    private void c(Canvas canvas) {
        float f2;
        float f3;
        Paint paint;
        float f4;
        float f5;
        float f6;
        int i2 = this.f24192m;
        double d2 = (double) i2;
        Double.isNaN(d2);
        float f7 = (float) (6.283185307179586d / d2);
        float f8 = this.f24187h;
        float f9 = f8 - this.f24193n;
        int i3 = (int) ((((float) this.f24190k) / ((float) this.f24191l)) * ((float) i2));
        for (int i4 = 0; i4 < this.f24192m; i4++) {
            double d3 = (double) (((float) i4) * (-f7));
            float cos = this.f24188i + (((float) Math.cos(d3)) * f9);
            float sin = this.f24189j - (((float) Math.sin(d3)) * f9);
            if (!this.f24202w || (i4 + 1) % 10 != 0) {
                float f10 = f8 - 8.0f;
                f3 = this.f24189j - (((float) Math.sin(d3)) * f10);
                f2 = this.f24188i + (((float) Math.cos(d3)) * f10);
            } else {
                if (i4 == 29 || i4 == 59) {
                    float f11 = 10.0f + f9;
                    cos = (((float) Math.cos(d3)) * f11) + this.f24188i;
                    sin = this.f24189j - (((float) Math.sin(d3)) * f11);
                    f6 = this.f24189j;
                    f5 = (float) Math.sin(d3);
                    f4 = 12.0f;
                } else {
                    f6 = this.f24189j;
                    f5 = (float) Math.sin(d3);
                    f4 = 4.0f;
                }
                float f12 = f8 - f4;
                f3 = f6 - (f5 * f12);
                f2 = this.f24188i + (((float) Math.cos(d3)) * f12);
            }
            if (this.f24204y) {
                if (i4 >= i3 || (i4 + 1) % 10 == 0) {
                    paint = this.f24185f;
                }
                if (i4 < i3 && (i4 + 1) % 10 != 0) {
                    canvas.drawLine(cos, sin, f2, f3, this.f24183d);
                }
            } else {
                paint = this.f24184e;
            }
            canvas.drawLine(cos, sin, f2, f3, paint);
            canvas.drawLine(cos, sin, f2, f3, this.f24183d);
        }
    }

    private void d(Canvas canvas) {
        if (this.f24204y) {
            float f2 = (((float) this.f24190k) * 360.0f) / ((float) this.f24191l);
            Canvas canvas2 = canvas;
            canvas2.drawArc(this.f24180a, f2, 360.0f - f2, true, this.f24184e);
        } else {
            canvas.drawArc(this.f24180a, 0.0f, 360.0f, true, this.f24184e);
        }
        canvas.drawArc(this.f24180a, 0.0f, (((float) this.f24190k) * 360.0f) / ((float) this.f24191l), true, this.f24183d);
    }

    private void e(Canvas canvas) {
        if (this.f24204y) {
            float f2 = (((float) this.f24190k) * 360.0f) / ((float) this.f24191l);
            Canvas canvas2 = canvas;
            canvas2.drawArc(this.f24180a, f2, 360.0f - f2, false, this.f24184e);
        } else {
            canvas.drawArc(this.f24180a, 0.0f, 360.0f, false, this.f24184e);
        }
        canvas.drawArc(this.f24180a, 0.0f, (((float) this.f24190k) * 360.0f) / ((float) this.f24191l), false, this.f24183d);
    }

    public int getMax() {
        return this.f24191l;
    }

    public int getProgress() {
        return this.f24190k;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate((float) this.f24203x, this.f24188i, this.f24189j);
        b(canvas);
        canvas.restore();
        a(canvas);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.f24206a);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f24206a = this.f24190k;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f24181b.left = (float) getPaddingLeft();
        this.f24181b.top = (float) getPaddingTop();
        this.f24181b.right = (float) (i2 - getPaddingRight());
        this.f24181b.bottom = (float) (i3 - getPaddingBottom());
        this.f24188i = this.f24181b.centerX();
        this.f24189j = this.f24181b.centerY();
        this.f24187h = Math.min(this.f24181b.width(), this.f24181b.height()) / 2.0f;
        this.f24180a.set(this.f24181b);
        c();
        RectF rectF = this.f24180a;
        float f2 = this.f24194o;
        rectF.inset(f2 / 2.0f, f2 / 2.0f);
    }

    public void setBlurRadius(int i2) {
        this.D = i2;
        b();
        invalidate();
    }

    public void setBlurStyle(BlurMaskFilter.Blur blur) {
        this.E = blur;
        b();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.C = cap;
        this.f24183d.setStrokeCap(cap);
        this.f24184e.setStrokeCap(cap);
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z2) {
        this.f24204y = z2;
        invalidate();
    }

    public void setLineCount(int i2) {
        this.f24192m = i2;
        invalidate();
    }

    public void setLineWidth(float f2) {
        this.f24193n = f2;
        invalidate();
    }

    public void setLongLineColor(int i2) {
        this.f24200u = i2;
        this.f24185f.setColor(i2);
        invalidate();
    }

    public void setMax(int i2) {
        this.f24191l = i2;
        invalidate();
    }

    public void setProgress(int i2) {
        this.f24190k = i2;
        invalidate();
    }

    public void setProgressBackgroundColor(int i2) {
        this.f24199t = i2;
        this.f24184e.setColor(i2);
        invalidate();
    }

    public void setProgressEndColor(int i2) {
        this.f24197r = i2;
        c();
        invalidate();
    }

    public void setProgressFormatter(b bVar) {
        this.f24205z = bVar;
        invalidate();
    }

    public void setProgressStartColor(int i2) {
        this.f24196q = i2;
        c();
        invalidate();
    }

    public void setProgressStrokeWidth(float f2) {
        this.f24194o = f2;
        this.f24180a.set(this.f24181b);
        c();
        RectF rectF = this.f24180a;
        float f3 = this.f24194o;
        rectF.inset(f3 / 2.0f, f3 / 2.0f);
        invalidate();
    }

    public void setProgressTextColor(int i2) {
        this.f24198s = i2;
        invalidate();
    }

    public void setProgressTextSize(float f2) {
        this.f24195p = f2;
        invalidate();
    }

    public void setShader(int i2) {
        this.B = i2;
        c();
        invalidate();
    }

    public void setStartDegree(int i2) {
        this.f24203x = i2;
        invalidate();
    }

    public void setStyle(int i2) {
        this.A = i2;
        this.f24183d.setStyle(i2 == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f24184e.setStyle(this.A == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }
}
