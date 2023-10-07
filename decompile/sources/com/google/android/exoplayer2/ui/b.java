package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class b {
    private float A;
    private float B;
    private int C;
    private int D;
    private int E;
    private int F;
    private StaticLayout G;
    private StaticLayout H;
    private int I;
    private int J;
    private int K;
    private Rect L;

    /* renamed from: a  reason: collision with root package name */
    private final float f11729a;

    /* renamed from: b  reason: collision with root package name */
    private final float f11730b;

    /* renamed from: c  reason: collision with root package name */
    private final float f11731c;

    /* renamed from: d  reason: collision with root package name */
    private final float f11732d;

    /* renamed from: e  reason: collision with root package name */
    private final float f11733e;

    /* renamed from: f  reason: collision with root package name */
    private final TextPaint f11734f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f11735g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f11736h;

    /* renamed from: i  reason: collision with root package name */
    private CharSequence f11737i;

    /* renamed from: j  reason: collision with root package name */
    private Layout.Alignment f11738j;

    /* renamed from: k  reason: collision with root package name */
    private Bitmap f11739k;

    /* renamed from: l  reason: collision with root package name */
    private float f11740l;

    /* renamed from: m  reason: collision with root package name */
    private int f11741m;

    /* renamed from: n  reason: collision with root package name */
    private int f11742n;

    /* renamed from: o  reason: collision with root package name */
    private float f11743o;

    /* renamed from: p  reason: collision with root package name */
    private int f11744p;

    /* renamed from: q  reason: collision with root package name */
    private float f11745q;

    /* renamed from: r  reason: collision with root package name */
    private float f11746r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f11747s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f11748t;

    /* renamed from: u  reason: collision with root package name */
    private int f11749u;

    /* renamed from: v  reason: collision with root package name */
    private int f11750v;

    /* renamed from: w  reason: collision with root package name */
    private int f11751w;

    /* renamed from: x  reason: collision with root package name */
    private int f11752x;

    /* renamed from: y  reason: collision with root package name */
    private int f11753y;

    /* renamed from: z  reason: collision with root package name */
    private float f11754z;

    public b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, new int[]{16843287, 16843288}, 0, 0);
        this.f11733e = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f11732d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = (float) Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.f11729a = round;
        this.f11730b = round;
        this.f11731c = round;
        TextPaint textPaint = new TextPaint();
        this.f11734f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f11735g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f11736h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012a A[LOOP:3: B:39:0x0128->B:40:0x012a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01dc  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"cueText"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r28 = this;
            r0 = r28
            java.lang.CharSequence r1 = r0.f11737i
            int r2 = r0.E
            int r3 = r0.C
            int r2 = r2 - r3
            int r3 = r0.F
            int r4 = r0.D
            int r3 = r3 - r4
            android.text.TextPaint r4 = r0.f11734f
            float r5 = r0.f11754z
            r4.setTextSize(r5)
            float r4 = r0.f11754z
            r5 = 1040187392(0x3e000000, float:0.125)
            float r4 = r4 * r5
            r5 = 1056964608(0x3f000000, float:0.5)
            float r4 = r4 + r5
            int r4 = (int) r4
            int r5 = r4 * 2
            int r6 = r2 - r5
            float r7 = r0.f11745q
            r8 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r9 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r9 == 0) goto L_0x0030
            float r6 = (float) r6
            float r6 = r6 * r7
            int r6 = (int) r6
        L_0x0030:
            java.lang.String r7 = "SubtitlePainter"
            if (r6 > 0) goto L_0x003a
            java.lang.String r1 = "Skipped drawing subtitle cue (insufficient space)"
            com.google.android.exoplayer2.util.k.c(r7, r1)
            return
        L_0x003a:
            boolean r9 = r0.f11747s
            r17 = 0
            r10 = 16711680(0xff0000, float:2.3418052E-38)
            r15 = 0
            if (r9 != 0) goto L_0x0048
            java.lang.String r1 = r1.toString()
            goto L_0x0098
        L_0x0048:
            boolean r9 = r0.f11748t
            if (r9 != 0) goto L_0x007d
            android.text.SpannableStringBuilder r9 = new android.text.SpannableStringBuilder
            r9.<init>(r1)
            int r1 = r9.length()
            java.lang.Class<android.text.style.AbsoluteSizeSpan> r11 = android.text.style.AbsoluteSizeSpan.class
            java.lang.Object[] r11 = r9.getSpans(r15, r1, r11)
            android.text.style.AbsoluteSizeSpan[] r11 = (android.text.style.AbsoluteSizeSpan[]) r11
            java.lang.Class<android.text.style.RelativeSizeSpan> r12 = android.text.style.RelativeSizeSpan.class
            java.lang.Object[] r1 = r9.getSpans(r15, r1, r12)
            android.text.style.RelativeSizeSpan[] r1 = (android.text.style.RelativeSizeSpan[]) r1
            int r12 = r11.length
            r13 = 0
        L_0x0067:
            if (r13 >= r12) goto L_0x0071
            r14 = r11[r13]
            r9.removeSpan(r14)
            int r13 = r13 + 1
            goto L_0x0067
        L_0x0071:
            int r11 = r1.length
            r12 = 0
        L_0x0073:
            if (r12 >= r11) goto L_0x0097
            r13 = r1[r12]
            r9.removeSpan(r13)
            int r12 = r12 + 1
            goto L_0x0073
        L_0x007d:
            float r9 = r0.A
            int r9 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r9 <= 0) goto L_0x0098
            android.text.SpannableStringBuilder r9 = new android.text.SpannableStringBuilder
            r9.<init>(r1)
            android.text.style.AbsoluteSizeSpan r1 = new android.text.style.AbsoluteSizeSpan
            float r11 = r0.A
            int r11 = (int) r11
            r1.<init>(r11)
            int r11 = r9.length()
            r9.setSpan(r1, r15, r11, r10)
        L_0x0097:
            r1 = r9
        L_0x0098:
            android.text.SpannableStringBuilder r14 = new android.text.SpannableStringBuilder
            r14.<init>(r1)
            int r9 = r0.f11753y
            r13 = 1
            if (r9 != r13) goto L_0x00bb
            int r9 = r14.length()
            java.lang.Class<android.text.style.ForegroundColorSpan> r11 = android.text.style.ForegroundColorSpan.class
            java.lang.Object[] r9 = r14.getSpans(r15, r9, r11)
            android.text.style.ForegroundColorSpan[] r9 = (android.text.style.ForegroundColorSpan[]) r9
            int r11 = r9.length
            r12 = 0
        L_0x00b0:
            if (r12 >= r11) goto L_0x00bb
            r13 = r9[r12]
            r14.removeSpan(r13)
            int r12 = r12 + 1
            r13 = 1
            goto L_0x00b0
        L_0x00bb:
            int r9 = r0.f11750v
            int r9 = android.graphics.Color.alpha(r9)
            r13 = 2
            if (r9 <= 0) goto L_0x00f0
            int r9 = r0.f11753y
            if (r9 == 0) goto L_0x00da
            if (r9 != r13) goto L_0x00cb
            goto L_0x00da
        L_0x00cb:
            android.text.style.BackgroundColorSpan r9 = new android.text.style.BackgroundColorSpan
            int r11 = r0.f11750v
            r9.<init>(r11)
            int r11 = r14.length()
            r14.setSpan(r9, r15, r11, r10)
            goto L_0x00f0
        L_0x00da:
            android.text.SpannableStringBuilder r9 = new android.text.SpannableStringBuilder
            r9.<init>(r1)
            android.text.style.BackgroundColorSpan r1 = new android.text.style.BackgroundColorSpan
            int r11 = r0.f11750v
            r1.<init>(r11)
            int r11 = r9.length()
            r9.setSpan(r1, r15, r11, r10)
            r19 = r9
            goto L_0x00f2
        L_0x00f0:
            r19 = r1
        L_0x00f2:
            android.text.Layout$Alignment r1 = r0.f11738j
            if (r1 != 0) goto L_0x00f8
            android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER
        L_0x00f8:
            android.text.StaticLayout r12 = new android.text.StaticLayout
            android.text.TextPaint r11 = r0.f11734f
            float r10 = r0.f11732d
            float r9 = r0.f11733e
            r18 = 1
            r20 = r9
            r9 = r12
            r21 = r10
            r10 = r19
            r8 = r12
            r12 = r6
            r26 = r4
            r4 = 1
            r13 = r1
            r27 = r14
            r14 = r21
            r15 = r20
            r16 = r18
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            r0.G = r8
            int r8 = r8.getHeight()
            android.text.StaticLayout r9 = r0.G
            int r9 = r9.getLineCount()
            r10 = 0
            r15 = 0
        L_0x0128:
            if (r15 >= r9) goto L_0x013d
            android.text.StaticLayout r11 = r0.G
            float r11 = r11.getLineWidth(r15)
            double r11 = (double) r11
            double r11 = java.lang.Math.ceil(r11)
            int r11 = (int) r11
            int r10 = java.lang.Math.max(r11, r10)
            int r15 = r15 + 1
            goto L_0x0128
        L_0x013d:
            float r9 = r0.f11745q
            r11 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L_0x0149
            if (r10 >= r6) goto L_0x0149
            goto L_0x014a
        L_0x0149:
            r6 = r10
        L_0x014a:
            int r6 = r6 + r5
            float r5 = r0.f11743o
            int r9 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r9 == 0) goto L_0x0175
            float r2 = (float) r2
            float r2 = r2 * r5
            int r2 = java.lang.Math.round(r2)
            int r5 = r0.C
            int r2 = r2 + r5
            int r9 = r0.f11744p
            r10 = 2
            if (r9 == r4) goto L_0x0165
            if (r9 == r10) goto L_0x0163
            goto L_0x0169
        L_0x0163:
            int r2 = r2 - r6
            goto L_0x0169
        L_0x0165:
            int r2 = r2 * 2
            int r2 = r2 - r6
            int r2 = r2 / r10
        L_0x0169:
            int r2 = java.lang.Math.max(r2, r5)
            int r6 = r6 + r2
            int r5 = r0.E
            int r5 = java.lang.Math.min(r6, r5)
            goto L_0x017d
        L_0x0175:
            r10 = 2
            int r2 = r2 - r6
            int r2 = r2 / r10
            int r5 = r0.C
            int r2 = r2 + r5
            int r5 = r2 + r6
        L_0x017d:
            int r5 = r5 - r2
            if (r5 > 0) goto L_0x0186
            java.lang.String r1 = "Skipped drawing subtitle cue (invalid horizontal positioning)"
            com.google.android.exoplayer2.util.k.c(r7, r1)
            return
        L_0x0186:
            float r6 = r0.f11740l
            r7 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x01e2
            int r7 = r0.f11741m
            if (r7 != 0) goto L_0x019e
            float r3 = (float) r3
            float r3 = r3 * r6
            int r3 = java.lang.Math.round(r3)
        L_0x019a:
            int r6 = r0.D
        L_0x019c:
            int r3 = r3 + r6
            goto L_0x01c7
        L_0x019e:
            android.text.StaticLayout r3 = r0.G
            r6 = 0
            int r3 = r3.getLineBottom(r6)
            android.text.StaticLayout r7 = r0.G
            int r6 = r7.getLineTop(r6)
            int r3 = r3 - r6
            float r6 = r0.f11740l
            int r7 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r7 < 0) goto L_0x01ba
            float r3 = (float) r3
            float r6 = r6 * r3
            int r3 = java.lang.Math.round(r6)
            goto L_0x019a
        L_0x01ba:
            r7 = 1065353216(0x3f800000, float:1.0)
            float r6 = r6 + r7
            float r3 = (float) r3
            float r6 = r6 * r3
            int r3 = java.lang.Math.round(r6)
            int r6 = r0.F
            goto L_0x019c
        L_0x01c7:
            int r6 = r0.f11742n
            if (r6 != r10) goto L_0x01cd
            int r3 = r3 - r8
            goto L_0x01d3
        L_0x01cd:
            if (r6 != r4) goto L_0x01d3
            int r3 = r3 * 2
            int r3 = r3 - r8
            int r3 = r3 / r10
        L_0x01d3:
            int r4 = r3 + r8
            int r6 = r0.F
            if (r4 <= r6) goto L_0x01dc
            int r3 = r6 - r8
            goto L_0x01ed
        L_0x01dc:
            int r4 = r0.D
            if (r3 >= r4) goto L_0x01ed
            r3 = r4
            goto L_0x01ed
        L_0x01e2:
            int r4 = r0.F
            int r4 = r4 - r8
            float r3 = (float) r3
            float r6 = r0.B
            float r3 = r3 * r6
            int r3 = (int) r3
            int r3 = r4 - r3
        L_0x01ed:
            android.text.StaticLayout r4 = new android.text.StaticLayout
            android.text.TextPaint r6 = r0.f11734f
            float r7 = r0.f11732d
            float r8 = r0.f11733e
            r25 = 1
            r18 = r4
            r20 = r6
            r21 = r5
            r22 = r1
            r23 = r7
            r24 = r8
            r18.<init>(r19, r20, r21, r22, r23, r24, r25)
            r0.G = r4
            android.text.StaticLayout r4 = new android.text.StaticLayout
            android.text.TextPaint r6 = r0.f11734f
            float r7 = r0.f11732d
            float r8 = r0.f11733e
            r18 = r4
            r19 = r27
            r20 = r6
            r23 = r7
            r24 = r8
            r18.<init>(r19, r20, r21, r22, r23, r24, r25)
            r0.H = r4
            r0.I = r2
            r0.J = r3
            r1 = r26
            r0.K = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.b.a():void");
    }

    private void a(Canvas canvas) {
        StaticLayout staticLayout = this.G;
        StaticLayout staticLayout2 = this.H;
        if (staticLayout != null && staticLayout2 != null) {
            int save = canvas.save();
            canvas.translate((float) this.I, (float) this.J);
            if (Color.alpha(this.f11751w) > 0) {
                this.f11735g.setColor(this.f11751w);
                canvas.drawRect((float) (-this.K), 0.0f, (float) (staticLayout.getWidth() + this.K), (float) staticLayout.getHeight(), this.f11735g);
            }
            int i2 = this.f11753y;
            boolean z2 = true;
            if (i2 == 1) {
                this.f11734f.setStrokeJoin(Paint.Join.ROUND);
                this.f11734f.setStrokeWidth(this.f11729a);
                this.f11734f.setColor(this.f11752x);
                this.f11734f.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout2.draw(canvas);
            } else if (i2 == 2) {
                TextPaint textPaint = this.f11734f;
                float f2 = this.f11730b;
                float f3 = this.f11731c;
                textPaint.setShadowLayer(f2, f3, f3, this.f11752x);
            } else if (i2 == 3 || i2 == 4) {
                if (i2 != 3) {
                    z2 = false;
                }
                int i3 = -1;
                int i4 = z2 ? -1 : this.f11752x;
                if (z2) {
                    i3 = this.f11752x;
                }
                float f4 = this.f11730b / 2.0f;
                this.f11734f.setColor(this.f11749u);
                this.f11734f.setStyle(Paint.Style.FILL);
                float f5 = -f4;
                this.f11734f.setShadowLayer(this.f11730b, f5, f5, i4);
                staticLayout2.draw(canvas);
                this.f11734f.setShadowLayer(this.f11730b, f4, f4, i3);
            }
            this.f11734f.setColor(this.f11749u);
            this.f11734f.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.f11734f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    private void a(Canvas canvas, boolean z2) {
        if (z2) {
            a(canvas);
            return;
        }
        a.b(this.L);
        a.b(this.f11739k);
        b(canvas);
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0058  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"cueBitmap"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r7 = this;
            android.graphics.Bitmap r0 = r7.f11739k
            int r1 = r7.E
            int r2 = r7.C
            int r1 = r1 - r2
            int r3 = r7.F
            int r4 = r7.D
            int r3 = r3 - r4
            float r2 = (float) r2
            float r1 = (float) r1
            float r5 = r7.f11743o
            float r5 = r5 * r1
            float r2 = r2 + r5
            float r4 = (float) r4
            float r3 = (float) r3
            float r5 = r7.f11740l
            float r5 = r5 * r3
            float r4 = r4 + r5
            float r5 = r7.f11745q
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            float r5 = r7.f11746r
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x002c
            goto L_0x0038
        L_0x002c:
            float r3 = (float) r1
            int r5 = r0.getHeight()
            float r5 = (float) r5
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
        L_0x0038:
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
            int r3 = r7.f11744p
            r5 = 1
            r6 = 2
            if (r3 != r6) goto L_0x0047
            float r3 = (float) r1
        L_0x0045:
            float r2 = r2 - r3
            goto L_0x004d
        L_0x0047:
            if (r3 != r5) goto L_0x004d
            int r3 = r1 / 2
            float r3 = (float) r3
            goto L_0x0045
        L_0x004d:
            int r2 = java.lang.Math.round(r2)
            int r3 = r7.f11742n
            if (r3 != r6) goto L_0x0058
            float r3 = (float) r0
        L_0x0056:
            float r4 = r4 - r3
            goto L_0x005e
        L_0x0058:
            if (r3 != r5) goto L_0x005e
            int r3 = r0 / 2
            float r3 = (float) r3
            goto L_0x0056
        L_0x005e:
            int r3 = java.lang.Math.round(r4)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r1 = r1 + r2
            int r0 = r0 + r3
            r4.<init>(r2, r3, r1, r0)
            r7.L = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.b.b():void");
    }

    @RequiresNonNull({"cueBitmap", "bitmapRect"})
    private void b(Canvas canvas) {
        canvas.drawBitmap(this.f11739k, (Rect) null, this.L, this.f11736h);
    }

    public void a(com.google.android.exoplayer2.text.b bVar, boolean z2, boolean z3, com.google.android.exoplayer2.text.a aVar, float f2, float f3, float f4, Canvas canvas, int i2, int i3, int i4, int i5) {
        com.google.android.exoplayer2.text.b bVar2 = bVar;
        boolean z4 = z2;
        boolean z5 = z3;
        com.google.android.exoplayer2.text.a aVar2 = aVar;
        float f5 = f2;
        float f6 = f3;
        float f7 = f4;
        Canvas canvas2 = canvas;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int i9 = i5;
        boolean z6 = bVar2.f16587d == null;
        int i10 = -16777216;
        if (z6) {
            if (!TextUtils.isEmpty(bVar2.f16585b)) {
                i10 = (!bVar2.f16595l || !z4) ? aVar2.f16580d : bVar2.f16596m;
            } else {
                return;
            }
        }
        if (a(this.f11737i, bVar2.f16585b) && ad.a((Object) this.f11738j, (Object) bVar2.f16586c) && this.f11739k == bVar2.f16587d && this.f11740l == bVar2.f16588e && this.f11741m == bVar2.f16589f && ad.a((Object) Integer.valueOf(this.f11742n), (Object) Integer.valueOf(bVar2.f16590g)) && this.f11743o == bVar2.f16591h && ad.a((Object) Integer.valueOf(this.f11744p), (Object) Integer.valueOf(bVar2.f16592i)) && this.f11745q == bVar2.f16593j && this.f11746r == bVar2.f16594k && this.f11747s == z4 && this.f11748t == z5 && this.f11749u == aVar2.f16578b && this.f11750v == aVar2.f16579c && this.f11751w == i10 && this.f11753y == aVar2.f16581e && this.f11752x == aVar2.f16582f && ad.a((Object) this.f11734f.getTypeface(), (Object) aVar2.f16583g) && this.f11754z == f5 && this.A == f6 && this.B == f7 && this.C == i6 && this.D == i7 && this.E == i8 && this.F == i9) {
            a(canvas, z6);
            return;
        }
        Canvas canvas3 = canvas;
        this.f11737i = bVar2.f16585b;
        this.f11738j = bVar2.f16586c;
        this.f11739k = bVar2.f16587d;
        this.f11740l = bVar2.f16588e;
        this.f11741m = bVar2.f16589f;
        this.f11742n = bVar2.f16590g;
        this.f11743o = bVar2.f16591h;
        this.f11744p = bVar2.f16592i;
        this.f11745q = bVar2.f16593j;
        this.f11746r = bVar2.f16594k;
        this.f11747s = z4;
        this.f11748t = z5;
        this.f11749u = aVar2.f16578b;
        this.f11750v = aVar2.f16579c;
        this.f11751w = i10;
        this.f11753y = aVar2.f16581e;
        this.f11752x = aVar2.f16582f;
        this.f11734f.setTypeface(aVar2.f16583g);
        this.f11754z = f5;
        this.A = f6;
        this.B = f7;
        this.C = i6;
        this.D = i7;
        this.E = i8;
        this.F = i9;
        if (z6) {
            a.b(this.f11737i);
            a();
        } else {
            a.b(this.f11739k);
            b();
        }
        a(canvas3, z6);
    }
}
