package com.huantansheng.easyphotos.models.puzzle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.b;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.huantansheng.easyphotos.R;

public class DegreeSeekBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f20320a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f20321b;

    /* renamed from: c  reason: collision with root package name */
    private Paint.FontMetricsInt f20322c;

    /* renamed from: d  reason: collision with root package name */
    private int f20323d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f20324e;

    /* renamed from: f  reason: collision with root package name */
    private final Rect f20325f;

    /* renamed from: g  reason: collision with root package name */
    private a f20326g;

    /* renamed from: h  reason: collision with root package name */
    private float f20327h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f20328i;

    /* renamed from: j  reason: collision with root package name */
    private float f20329j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f20330k;

    /* renamed from: l  reason: collision with root package name */
    private int f20331l;

    /* renamed from: m  reason: collision with root package name */
    private Path f20332m;

    /* renamed from: n  reason: collision with root package name */
    private int f20333n;

    /* renamed from: o  reason: collision with root package name */
    private int f20334o;

    /* renamed from: p  reason: collision with root package name */
    private int f20335p;

    /* renamed from: q  reason: collision with root package name */
    private int f20336q;

    /* renamed from: r  reason: collision with root package name */
    private int f20337r;

    /* renamed from: s  reason: collision with root package name */
    private float f20338s;

    /* renamed from: t  reason: collision with root package name */
    private int f20339t;

    /* renamed from: u  reason: collision with root package name */
    private int f20340u;

    /* renamed from: v  reason: collision with root package name */
    private String f20341v;

    public interface a {
        void a();

        void a(int i2);

        void b();
    }

    public DegreeSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public DegreeSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DegreeSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20325f = new Rect();
        this.f20332m = new Path();
        this.f20333n = 0;
        this.f20334o = 51;
        this.f20338s = 2.1f;
        this.f20339t = -45;
        this.f20340u = 45;
        this.f20341v = "";
        a();
    }

    private void a() {
        this.f20335p = b.c(getContext(), R.color.easy_photos_fg_primary);
        this.f20336q = b.c(getContext(), R.color.easy_photos_fg_primary);
        this.f20337r = b.c(getContext(), R.color.easy_photos_fg_accent);
        Paint paint = new Paint(1);
        this.f20328i = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f20328i.setColor(this.f20335p);
        this.f20328i.setStrokeWidth(2.0f);
        Paint paint2 = new Paint();
        this.f20320a = paint2;
        paint2.setColor(this.f20336q);
        this.f20320a.setStyle(Paint.Style.STROKE);
        this.f20320a.setAntiAlias(true);
        this.f20320a.setTextSize(24.0f);
        this.f20320a.setTextAlign(Paint.Align.LEFT);
        this.f20320a.setAlpha(100);
        this.f20322c = this.f20320a.getFontMetricsInt();
        float[] fArr = new float[1];
        this.f20324e = fArr;
        this.f20320a.getTextWidths("0", fArr);
        Paint paint3 = new Paint();
        this.f20321b = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.f20321b.setAlpha(255);
        this.f20321b.setAntiAlias(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002a, code lost:
        if (java.lang.Math.abs(r6 - r5.f20333n) <= 7) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003a, code lost:
        if (java.lang.Math.abs(r6 - r5.f20333n) <= 7) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r6, android.graphics.Canvas r7, boolean r8) {
        /*
            r5 = this;
            r0 = 15
            r1 = 100
            r2 = 0
            if (r8 == 0) goto L_0x0042
            boolean r8 = r5.f20330k
            r3 = 7
            if (r8 == 0) goto L_0x002d
            android.graphics.Paint r8 = r5.f20320a
            int r1 = r5.f20333n
            int r1 = r6 - r1
            int r1 = java.lang.Math.abs(r1)
            r4 = 255(0xff, float:3.57E-43)
            int r1 = r1 * 255
            int r1 = r1 / r0
            int r1 = java.lang.Math.min(r4, r1)
            r8.setAlpha(r1)
            int r8 = r5.f20333n
            int r8 = r6 - r8
            int r8 = java.lang.Math.abs(r8)
            if (r8 > r3) goto L_0x0047
            goto L_0x003c
        L_0x002d:
            android.graphics.Paint r8 = r5.f20320a
            r8.setAlpha(r1)
            int r8 = r5.f20333n
            int r8 = r6 - r8
            int r8 = java.lang.Math.abs(r8)
            if (r8 > r3) goto L_0x0047
        L_0x003c:
            android.graphics.Paint r8 = r5.f20320a
            r8.setAlpha(r2)
            goto L_0x0047
        L_0x0042:
            android.graphics.Paint r8 = r5.f20320a
            r8.setAlpha(r1)
        L_0x0047:
            r8 = 1073741824(0x40000000, float:2.0)
            if (r6 != 0) goto L_0x0086
            int r6 = r5.f20333n
            int r6 = java.lang.Math.abs(r6)
            if (r6 < r0) goto L_0x005e
            boolean r6 = r5.f20330k
            if (r6 != 0) goto L_0x005e
            android.graphics.Paint r6 = r5.f20320a
            r0 = 180(0xb4, float:2.52E-43)
            r6.setAlpha(r0)
        L_0x005e:
            int r6 = r5.getWidth()
            int r6 = r6 / 2
            float r6 = (float) r6
            float[] r0 = r5.f20324e
            r0 = r0[r2]
            float r0 = r0 / r8
            float r6 = r6 - r0
            int r8 = r5.f20333n
            int r8 = r8 / 2
            float r8 = (float) r8
            float r0 = r5.f20329j
            float r8 = r8 * r0
            float r6 = r6 - r8
            int r8 = r5.getHeight()
            int r8 = r8 / 2
            int r8 = r8 + -10
            float r8 = (float) r8
            android.graphics.Paint r0 = r5.f20320a
            java.lang.String r1 = "0°"
            r7.drawText(r1, r6, r8, r0)
            goto L_0x00c5
        L_0x0086:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r1 = r5.f20341v
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            int r1 = r5.getWidth()
            int r1 = r1 / 2
            float r1 = (float) r1
            float r3 = r5.f20329j
            float r6 = (float) r6
            float r6 = r6 * r3
            float r6 = r6 / r8
            float r1 = r1 + r6
            float[] r6 = r5.f20324e
            r6 = r6[r2]
            float r6 = r6 / r8
            r8 = 1077936128(0x40400000, float:3.0)
            float r6 = r6 * r8
            float r1 = r1 - r6
            int r6 = r5.f20333n
            int r6 = r6 / 2
            float r6 = (float) r6
            float r6 = r6 * r3
            float r1 = r1 - r6
            int r6 = r5.getHeight()
            int r6 = r6 / 2
            int r6 = r6 + -10
            float r6 = (float) r6
            android.graphics.Paint r8 = r5.f20320a
            r7.drawText(r0, r1, r6, r8)
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huantansheng.easyphotos.models.puzzle.DegreeSeekBar.a(int, android.graphics.Canvas, boolean):void");
    }

    private void a(MotionEvent motionEvent, float f2) {
        this.f20331l = (int) (((float) this.f20331l) - f2);
        postInvalidate();
        this.f20327h = motionEvent.getX();
        int i2 = (int) ((((float) this.f20331l) * this.f20338s) / this.f20329j);
        this.f20333n = i2;
        a aVar = this.f20326g;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    public void a(int i2, int i3) {
        if (i2 > i3) {
            Log.e("DegreeSeekBar", "setDegreeRange: error, max must greater than min");
            return;
        }
        this.f20339t = i2;
        this.f20340u = i3;
        int i4 = this.f20333n;
        if (i4 > i3 || i4 < i2) {
            this.f20333n = (i2 + i3) / 2;
        }
        this.f20331l = (int) ((((float) this.f20333n) * this.f20329j) / this.f20338s);
        invalidate();
    }

    public int getCenterTextColor() {
        return this.f20337r;
    }

    public float getDragFactor() {
        return this.f20338s;
    }

    public int getPointColor() {
        return this.f20335p;
    }

    public int getTextColor() {
        return this.f20336q;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        String str;
        float width;
        float f2;
        Paint paint;
        int i2;
        Paint paint2;
        super.onDraw(canvas);
        canvas.getClipBounds(this.f20325f);
        int i3 = (this.f20334o / 2) + ((0 - this.f20333n) / 2);
        this.f20328i.setColor(this.f20335p);
        int i4 = 0;
        while (true) {
            int i5 = 255;
            if (i4 >= this.f20334o) {
                break;
            }
            if (i4 <= i3 - (Math.abs(this.f20339t) / 2) || i4 >= (Math.abs(this.f20340u) / 2) + i3 || !this.f20330k) {
                this.f20328i.setAlpha(100);
            } else {
                this.f20328i.setAlpha(255);
            }
            int i6 = this.f20334o;
            if (i4 > (i6 / 2) - 8 && i4 < (i6 / 2) + 8 && i4 > i3 - (Math.abs(this.f20339t) / 2) && i4 < (Math.abs(this.f20340u) / 2) + i3) {
                if (this.f20330k) {
                    paint2 = this.f20328i;
                    i2 = Math.abs((this.f20334o / 2) - i4) * 255;
                } else {
                    paint2 = this.f20328i;
                    i2 = Math.abs((this.f20334o / 2) - i4) * 100;
                }
                paint2.setAlpha(i2 / 8);
            }
            canvas.drawPoint(((float) this.f20325f.centerX()) + (((float) (i4 - (this.f20334o / 2))) * this.f20329j), (float) this.f20325f.centerY(), this.f20328i);
            if (this.f20333n != 0 && i4 == i3) {
                if (this.f20330k) {
                    paint = this.f20320a;
                } else {
                    paint = this.f20320a;
                    i5 = 192;
                }
                paint.setAlpha(i5);
                this.f20328i.setStrokeWidth(4.0f);
                canvas.drawPoint(((float) this.f20325f.centerX()) + (((float) (i4 - (this.f20334o / 2))) * this.f20329j), (float) this.f20325f.centerY(), this.f20328i);
                this.f20328i.setStrokeWidth(2.0f);
                this.f20320a.setAlpha(100);
            }
            i4++;
        }
        for (int i7 = AMapEngineUtils.MIN_LONGITUDE_DEGREE; i7 <= 180; i7 += 15) {
            if (i7 < this.f20339t || i7 > this.f20340u) {
                a(i7, canvas, false);
            } else {
                a(i7, canvas, true);
            }
        }
        this.f20320a.setTextSize(28.0f);
        this.f20320a.setAlpha(255);
        this.f20320a.setColor(this.f20337r);
        int i8 = this.f20333n;
        if (i8 >= 10) {
            str = this.f20333n + this.f20341v;
            width = (float) (getWidth() / 2);
            f2 = this.f20324e[0];
        } else if (i8 <= -10) {
            str = this.f20333n + this.f20341v;
            width = (float) (getWidth() / 2);
            f2 = (this.f20324e[0] / 2.0f) * 3.0f;
        } else if (i8 < 0) {
            str = this.f20333n + this.f20341v;
            width = (float) (getWidth() / 2);
            f2 = this.f20324e[0];
        } else {
            str = this.f20333n + this.f20341v;
            width = (float) (getWidth() / 2);
            f2 = this.f20324e[0] / 2.0f;
        }
        canvas.drawText(str, width - f2, (float) this.f20323d, this.f20320a);
        this.f20320a.setAlpha(100);
        this.f20320a.setTextSize(24.0f);
        this.f20320a.setColor(this.f20336q);
        this.f20321b.setColor(this.f20337r);
        canvas.drawPath(this.f20332m, this.f20321b);
        this.f20321b.setColor(this.f20337r);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f20329j = ((float) i2) / ((float) this.f20334o);
        this.f20323d = (((i3 - this.f20322c.bottom) + this.f20322c.top) / 2) - this.f20322c.top;
        this.f20332m.moveTo((float) (i2 / 2), (float) (((i3 / 2) + (this.f20322c.top / 2)) - 18));
        this.f20332m.rLineTo(-8.0f, -8.0f);
        this.f20332m.rLineTo(16.0f, 0.0f);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.f20330k = false;
                a aVar = this.f20326g;
                if (aVar != null) {
                    aVar.b();
                }
            } else if (action == 2) {
                float x2 = motionEvent.getX() - this.f20327h;
                int i2 = this.f20333n;
                int i3 = this.f20340u;
                if ((i2 >= i3 && x2 < 0.0f) || (i2 <= (i3 = this.f20339t) && x2 > 0.0f)) {
                    this.f20333n = i3;
                } else if (x2 != 0.0f) {
                    a(motionEvent, x2);
                }
            }
            invalidate();
        } else {
            this.f20327h = motionEvent.getX();
            if (!this.f20330k) {
                this.f20330k = true;
                a aVar2 = this.f20326g;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        }
        return true;
    }

    public void setCenterTextColor(int i2) {
        this.f20337r = i2;
        postInvalidate();
    }

    public void setCurrentDegrees(int i2) {
        if (i2 <= this.f20340u && i2 >= this.f20339t) {
            this.f20333n = i2;
            this.f20331l = (int) ((((float) i2) * this.f20329j) / this.f20338s);
            invalidate();
        }
    }

    public void setDragFactor(float f2) {
        this.f20338s = f2;
    }

    public void setPointColor(int i2) {
        this.f20335p = i2;
        this.f20328i.setColor(i2);
        postInvalidate();
    }

    public void setScrollingListener(a aVar) {
        this.f20326g = aVar;
    }

    public void setSuffix(String str) {
        this.f20341v = str;
    }

    public void setTextColor(int i2) {
        this.f20336q = i2;
        this.f20320a.setColor(i2);
        postInvalidate();
    }
}
