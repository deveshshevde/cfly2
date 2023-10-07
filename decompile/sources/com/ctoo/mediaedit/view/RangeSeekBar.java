package com.ctoo.mediaedit.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import fg.i;
import java.text.DecimalFormat;

public class RangeSeekBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10993a = "RangeSeekBar";
    private double A = 1.0d;
    private boolean B = false;
    private boolean C = false;
    private a D;

    /* renamed from: b  reason: collision with root package name */
    private double f10994b;

    /* renamed from: c  reason: collision with root package name */
    private double f10995c;

    /* renamed from: d  reason: collision with root package name */
    private double f10996d = i.f27244a;

    /* renamed from: e  reason: collision with root package name */
    private double f10997e = 1.0d;

    /* renamed from: f  reason: collision with root package name */
    private long f10998f = 3000;

    /* renamed from: g  reason: collision with root package name */
    private double f10999g = i.f27244a;

    /* renamed from: h  reason: collision with root package name */
    private double f11000h = 1.0d;

    /* renamed from: i  reason: collision with root package name */
    private int f11001i;

    /* renamed from: j  reason: collision with root package name */
    private Bitmap f11002j;

    /* renamed from: k  reason: collision with root package name */
    private Bitmap f11003k;

    /* renamed from: l  reason: collision with root package name */
    private Paint f11004l;

    /* renamed from: m  reason: collision with root package name */
    private Paint f11005m;

    /* renamed from: n  reason: collision with root package name */
    private Paint f11006n;

    /* renamed from: o  reason: collision with root package name */
    private int f11007o;

    /* renamed from: p  reason: collision with root package name */
    private int f11008p;

    /* renamed from: q  reason: collision with root package name */
    private float f11009q;

    /* renamed from: r  reason: collision with root package name */
    private final float f11010r = 0.0f;

    /* renamed from: s  reason: collision with root package name */
    private float f11011s = 0.0f;

    /* renamed from: t  reason: collision with root package name */
    private float f11012t = 0.0f;

    /* renamed from: u  reason: collision with root package name */
    private boolean f11013u;

    /* renamed from: v  reason: collision with root package name */
    private int f11014v = 255;

    /* renamed from: w  reason: collision with root package name */
    private float f11015w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f11016x;

    /* renamed from: y  reason: collision with root package name */
    private Thumb f11017y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f11018z;

    public enum Thumb {
        MIN,
        MAX
    }

    public interface a {
        void a(RangeSeekBar rangeSeekBar, long j2, long j3, int i2, boolean z2, Thumb thumb);
    }

    public RangeSeekBar(Context context) {
        super(context);
    }

    public RangeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RangeSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    private double a(float f2, int i2) {
        double d2;
        double d3;
        double max;
        double d4;
        double d5;
        int width = getWidth();
        float f3 = (float) width;
        if (f3 <= 0.0f) {
            return i.f27244a;
        }
        this.f11018z = false;
        double d6 = (double) f2;
        float a2 = a(this.f10996d);
        float a3 = a(this.f10997e);
        double d7 = (double) this.f10998f;
        double d8 = this.f10995c;
        Double.isNaN(d7);
        double d9 = d7 / (d8 - this.f10994b);
        double d10 = (double) (width - (this.f11007o * 2));
        Double.isNaN(d10);
        double d11 = d9 * d10;
        this.A = d8 > 300000.0d ? Double.parseDouble(new DecimalFormat("0.0000").format(d11)) : (double) Math.round(d11 + 0.5d);
        if (i2 == 0) {
            if (b(f2, this.f10996d, 0.5d)) {
                return this.f10996d;
            }
            float width2 = ((float) getWidth()) - a3 >= 0.0f ? ((float) getWidth()) - a3 : 0.0f;
            double valueLength = (double) getValueLength();
            double d12 = (double) width2;
            double d13 = this.A;
            Double.isNaN(d12);
            Double.isNaN(valueLength);
            double d14 = valueLength - (d12 + d13);
            double d15 = (double) a2;
            if (d6 > d15) {
                Double.isNaN(d6);
                Double.isNaN(d15);
                Double.isNaN(d15);
                d6 = (d6 - d15) + d15;
            } else if (d6 <= d15) {
                Double.isNaN(d15);
                Double.isNaN(d6);
                Double.isNaN(d15);
                d6 = d15 - (d15 - d6);
            }
            if (d6 > d14) {
                this.f11018z = true;
            } else {
                d14 = d6;
            }
            int i3 = this.f11007o;
            if (d14 < ((double) ((i3 * 2) / 3))) {
                d5 = i.f27244a;
                d4 = i.f27244a;
            } else {
                d4 = d14;
                d5 = i.f27244a;
            }
            double d16 = d4 - d5;
            double d17 = (double) (width - (i3 * 2));
            Double.isNaN(d17);
            d2 = 1.0d;
            this.f10999g = Math.min(1.0d, Math.max(d5, d16 / d17));
            double d18 = (double) (f3 - 0.0f);
            Double.isNaN(d18);
            max = Math.max(d5, d16 / d18);
        } else {
            d2 = 1.0d;
            if (a(f2, this.f10997e, 0.5d)) {
                return this.f10997e;
            }
            double valueLength2 = (double) getValueLength();
            double d19 = (double) a2;
            double d20 = this.A;
            Double.isNaN(d19);
            Double.isNaN(valueLength2);
            double d21 = valueLength2 - (d19 + d20);
            double d22 = (double) a3;
            if (d6 > d22) {
                Double.isNaN(d6);
                Double.isNaN(d22);
                Double.isNaN(d22);
                d6 = (d6 - d22) + d22;
            } else if (d6 <= d22) {
                Double.isNaN(d22);
                Double.isNaN(d6);
                Double.isNaN(d22);
                d6 = d22 - (d22 - d6);
            }
            double width3 = (double) getWidth();
            Double.isNaN(width3);
            double d23 = width3 - d6;
            if (d23 > d21) {
                this.f11018z = true;
                double width4 = (double) getWidth();
                Double.isNaN(width4);
                d6 = width4 - d21;
                d3 = d21;
            } else {
                d3 = d23;
            }
            if (d3 < ((double) ((this.f11007o * 2) / 3))) {
                d6 = (double) getWidth();
                d3 = i.f27244a;
            }
            double d24 = d3 - i.f27244a;
            double d25 = (double) (width - (this.f11007o * 2));
            Double.isNaN(d25);
            this.f11000h = Math.min(1.0d, Math.max(i.f27244a, 1.0d - (d24 / d25)));
            double d26 = d6 - i.f27244a;
            double d27 = (double) (f3 - 0.0f);
            Double.isNaN(d27);
            max = Math.max(i.f27244a, d26 / d27);
        }
        return Math.min(d2, max);
    }

    private double a(long j2) {
        double d2 = this.f10995c;
        double d3 = this.f10994b;
        if (i.f27244a == d2 - d3) {
            return i.f27244a;
        }
        double d4 = (double) j2;
        Double.isNaN(d4);
        return (d4 - d3) / (d2 - d3);
    }

    private float a(double d2) {
        double paddingLeft = (double) getPaddingLeft();
        double width = (double) ((getWidth() - getPaddingLeft()) - getPaddingRight());
        Double.isNaN(width);
        Double.isNaN(paddingLeft);
        return (float) (paddingLeft + (d2 * width));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0022, code lost:
        if ((r8 / ((float) getWidth())) > 0.5f) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.ctoo.mediaedit.view.RangeSeekBar.Thumb a(float r8) {
        /*
            r7 = this;
            double r2 = r7.f10996d
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            r0 = r7
            r1 = r8
            boolean r0 = r0.a(r1, r2, r4)
            double r3 = r7.f10997e
            r5 = 4611686018427387904(0x4000000000000000, double:2.0)
            r1 = r7
            r2 = r8
            boolean r1 = r1.a(r2, r3, r5)
            if (r0 == 0) goto L_0x0025
            if (r1 == 0) goto L_0x0025
            int r0 = r7.getWidth()
            float r0 = (float) r0
            float r8 = r8 / r0
            r0 = 1056964608(0x3f000000, float:0.5)
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 <= 0) goto L_0x002c
            goto L_0x0027
        L_0x0025:
            if (r0 == 0) goto L_0x002a
        L_0x0027:
            com.ctoo.mediaedit.view.RangeSeekBar$Thumb r8 = com.ctoo.mediaedit.view.RangeSeekBar.Thumb.MIN
            goto L_0x0030
        L_0x002a:
            if (r1 == 0) goto L_0x002f
        L_0x002c:
            com.ctoo.mediaedit.view.RangeSeekBar$Thumb r8 = com.ctoo.mediaedit.view.RangeSeekBar.Thumb.MAX
            goto L_0x0030
        L_0x002f:
            r8 = 0
        L_0x0030:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ctoo.mediaedit.view.RangeSeekBar.a(float):com.ctoo.mediaedit.view.RangeSeekBar$Thumb");
    }

    private void a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.f11014v) {
            int i2 = action == 0 ? 1 : 0;
            this.f11015w = motionEvent.getX(i2);
            this.f11014v = motionEvent.getPointerId(i2);
        }
    }

    private boolean a(float f2, double d2, double d3) {
        double d4 = (double) this.f11009q;
        Double.isNaN(d4);
        return ((double) Math.abs(f2 - a(d2))) <= d4 * d3;
    }

    private long b(double d2) {
        double d3 = this.f10994b;
        return (long) (d3 + (d2 * (this.f10995c - d3)));
    }

    private void b(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() <= 1) {
            String str = f10993a;
            Log.e(str, "trackTouchEvent: " + motionEvent.getAction() + " x: " + motionEvent.getX());
            try {
                float x2 = motionEvent.getX(motionEvent.findPointerIndex(this.f11014v));
                if (Thumb.MIN.equals(this.f11017y)) {
                    setNormalizedMinValue(a(x2, 0));
                } else if (Thumb.MAX.equals(this.f11017y)) {
                    setNormalizedMaxValue(a(x2, 1));
                }
            } catch (Exception unused) {
            }
        }
    }

    private boolean b(float f2, double d2, double d3) {
        double d4 = (double) this.f11009q;
        Double.isNaN(d4);
        return ((double) Math.abs((f2 - a(d2)) - ((float) this.f11007o))) <= d4 * d3;
    }

    private void c() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private int getValueLength() {
        return getWidth() - (this.f11007o * 2);
    }

    public int a(int i2) {
        return (int) ((((float) i2) * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f11016x = true;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f11016x = false;
    }

    public long getSelectedMaxValue() {
        return b(this.f11000h);
    }

    public long getSelectedMinValue() {
        return b(this.f10999g);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        float width = (((float) (getWidth() - getPaddingRight())) - 0.0f) / ((float) this.f11003k.getWidth());
        float a2 = a(this.f10996d);
        float a3 = a(this.f10997e);
        float width2 = (a3 - a2) / ((float) this.f11003k.getWidth());
        if (width2 > 0.0f) {
            try {
                Matrix matrix = new Matrix();
                matrix.postScale(width2, 1.0f);
                Bitmap bitmap = this.f11003k;
                canvas2.drawBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.f11003k.getHeight(), matrix, true), a2, this.f11011s, this.f11004l);
                Matrix matrix2 = new Matrix();
                matrix2.postScale(width, 1.0f);
                Bitmap bitmap2 = this.f11002j;
                Bitmap createBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.f11002j.getHeight(), matrix2, true);
                canvas2.drawBitmap(Bitmap.createBitmap(createBitmap, 0, 0, ((int) (a2 - 0.0f)) + (this.f11007o / 2), this.f11002j.getHeight()), 0.0f, this.f11011s, this.f11004l);
                canvas2.drawBitmap(Bitmap.createBitmap(createBitmap, (int) (a3 - ((float) (this.f11007o / 2))), 0, ((int) (((float) getWidth()) - a3)) + (this.f11007o / 2), this.f11002j.getHeight()), (float) ((int) (a3 - ((float) (this.f11007o / 2)))), this.f11011s, this.f11004l);
                float f2 = this.f11011s;
                canvas.drawRect(a2, f2, a3, f2 + ((float) a(2)), this.f11005m);
                canvas.drawRect(a2, (float) (getHeight() - a(2)), a3, (float) getHeight(), this.f11005m);
                Canvas canvas3 = canvas;
                canvas3.drawRect(a(this.f10996d), this.f11011s, ((float) this.f11007o) + a(this.f10996d), ((float) this.f11008p) + this.f11011s, this.f11005m);
                Canvas canvas4 = canvas;
                canvas4.drawRect(a(this.f10997e) - ((float) this.f11007o), this.f11011s, a(this.f10997e), ((float) this.f11008p) + this.f11011s, this.f11005m);
                Canvas canvas5 = canvas;
                canvas5.drawLine(((float) ((this.f11007o * 3) / 4)) + a(this.f10996d), ((float) (this.f11008p / 4)) + this.f11011s, ((float) (this.f11007o / 4)) + a(this.f10996d), ((float) (this.f11008p / 2)) + this.f11011s, this.f11006n);
                Canvas canvas6 = canvas;
                canvas6.drawLine(((float) (this.f11007o / 4)) + a(this.f10996d), ((float) (this.f11008p / 2)) + this.f11011s, ((float) ((this.f11007o * 3) / 4)) + a(this.f10996d), ((float) ((this.f11008p * 3) / 4)) + this.f11011s, this.f11006n);
                Canvas canvas7 = canvas;
                canvas7.drawLine(a(this.f10997e) - ((float) ((this.f11007o * 3) / 4)), ((float) (this.f11008p / 4)) + this.f11011s, a(this.f10997e) - ((float) (this.f11007o / 4)), ((float) (this.f11008p / 2)) + this.f11011s, this.f11006n);
                Canvas canvas8 = canvas;
                canvas8.drawLine(a(this.f10997e) - ((float) (this.f11007o / 4)), ((float) (this.f11008p / 2)) + this.f11011s, a(this.f10997e) - ((float) ((this.f11007o * 3) / 4)), ((float) ((this.f11008p * 3) / 4)) + this.f11011s, this.f11006n);
            } catch (Exception e2) {
                String str = f10993a;
                Log.e(str, "IllegalArgumentException--width=" + this.f11003k.getWidth() + "Height=" + this.f11003k.getHeight() + "scale_pro=" + width2, e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getMode(i2) != 0 ? View.MeasureSpec.getSize(i2) : 300;
        int i4 = 120;
        if (View.MeasureSpec.getMode(i3) != 0) {
            i4 = View.MeasureSpec.getSize(i3);
        }
        setMeasuredDimension(size, i4);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("SUPER"));
        this.f10996d = bundle.getDouble("MIN");
        this.f10997e = bundle.getDouble("MAX");
        this.f10999g = bundle.getDouble("MIN_TIME");
        this.f11000h = bundle.getDouble("MAX_TIME");
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER", super.onSaveInstanceState());
        bundle.putDouble("MIN", this.f10996d);
        bundle.putDouble("MAX", this.f10997e);
        bundle.putDouble("MIN_TIME", this.f10999g);
        bundle.putDouble("MAX_TIME", this.f11000h);
        return bundle;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        long j2;
        long j3;
        a aVar;
        if (this.f11013u) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getPointerCount() > 1) {
            return super.onTouchEvent(motionEvent);
        }
        if (!isEnabled()) {
            return false;
        }
        if (this.f10995c <= ((double) this.f10998f)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1) {
                if (this.f11016x) {
                    b(motionEvent);
                    b();
                    setPressed(false);
                } else {
                    a();
                    b(motionEvent);
                    b();
                }
                invalidate();
                a aVar2 = this.D;
                if (aVar2 != null) {
                    aVar2.a(this, getSelectedMinValue(), getSelectedMaxValue(), 1, this.f11018z, this.f11017y);
                }
                this.f11017y = null;
            } else if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int pointerCount = motionEvent.getPointerCount() - 1;
                        this.f11015w = motionEvent.getX(pointerCount);
                        this.f11014v = motionEvent.getPointerId(pointerCount);
                    } else if (action == 6) {
                        a(motionEvent);
                    }
                } else if (this.f11016x) {
                    b();
                    setPressed(false);
                }
                invalidate();
            } else if (this.f11017y != null) {
                if (this.f11016x) {
                    b(motionEvent);
                } else if (Math.abs(motionEvent.getX(motionEvent.findPointerIndex(this.f11014v)) - this.f11015w) > ((float) this.f11001i)) {
                    setPressed(true);
                    Log.e(f10993a, "没有拖住最大最小值");
                    invalidate();
                    a();
                    b(motionEvent);
                    c();
                }
                if (this.B && (aVar = this.D) != null) {
                    j3 = getSelectedMinValue();
                    j2 = getSelectedMaxValue();
                    i2 = 2;
                }
            }
            return true;
        }
        int pointerId = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
        this.f11014v = pointerId;
        float x2 = motionEvent.getX(motionEvent.findPointerIndex(pointerId));
        this.f11015w = x2;
        Thumb a2 = a(x2);
        this.f11017y = a2;
        if (a2 == null) {
            return super.onTouchEvent(motionEvent);
        }
        setPressed(true);
        a();
        b(motionEvent);
        c();
        aVar = this.D;
        if (aVar != null) {
            j3 = getSelectedMinValue();
            j2 = getSelectedMaxValue();
            i2 = 0;
        }
        return true;
        aVar.a(this, j3, j2, i2, this.f11018z, this.f11017y);
        return true;
    }

    public void setMin_cut_time(long j2) {
        this.f10998f = j2;
    }

    public void setNormalizedMaxValue(double d2) {
        this.f10997e = Math.max(i.f27244a, Math.min(1.0d, Math.max(d2, this.f10996d)));
        invalidate();
    }

    public void setNormalizedMinValue(double d2) {
        this.f10996d = Math.max(i.f27244a, Math.min(1.0d, Math.min(d2, this.f10997e)));
        invalidate();
    }

    public void setNotifyWhileDragging(boolean z2) {
        this.B = z2;
    }

    public void setOnRangeSeekBarChangeListener(a aVar) {
        this.D = aVar;
    }

    public void setSelectedMaxValue(long j2) {
        setNormalizedMaxValue(i.f27244a == this.f10995c - this.f10994b ? 1.0d : a(j2));
    }

    public void setSelectedMinValue(long j2) {
        if (i.f27244a == this.f10995c - this.f10994b) {
            setNormalizedMinValue(i.f27244a);
        } else {
            setNormalizedMinValue(a(j2));
        }
    }

    public void setSelectedStatus(boolean z2) {
        Paint paint;
        String str;
        this.C = z2;
        if (z2) {
            paint = this.f11005m;
            str = "#ffffff";
        } else {
            paint = this.f11005m;
            str = "#000000";
        }
        paint.setColor(Color.parseColor(str));
        postInvalidate();
    }

    public void setTouchDown(boolean z2) {
        this.f11013u = z2;
    }
}
