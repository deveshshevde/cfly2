package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import gt.a;
import gt.d;
import r.e;
import s.f;
import t.ac;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f19232a = (Build.VERSION.SDK_INT < 18);

    /* renamed from: b  reason: collision with root package name */
    private static final Paint f19233b;
    private Typeface A;
    private gt.a B;
    private gt.a C;
    private CharSequence D;
    private CharSequence E;
    private boolean F;
    private boolean G = true;
    private boolean H;
    private Bitmap I;
    private Paint J;
    private float K;
    private float L;
    private int[] M;
    private boolean N;
    private final TextPaint O;
    private final TextPaint P;
    private TimeInterpolator Q;
    private TimeInterpolator R;
    private float S;
    private float T;
    private float U;
    private ColorStateList V;
    private float W;
    private float X;
    private float Y;
    private ColorStateList Z;

    /* renamed from: aa  reason: collision with root package name */
    private float f19234aa;

    /* renamed from: ab  reason: collision with root package name */
    private float f19235ab;

    /* renamed from: ac  reason: collision with root package name */
    private StaticLayout f19236ac;

    /* renamed from: ad  reason: collision with root package name */
    private float f19237ad;

    /* renamed from: ae  reason: collision with root package name */
    private float f19238ae;

    /* renamed from: af  reason: collision with root package name */
    private float f19239af;

    /* renamed from: ag  reason: collision with root package name */
    private CharSequence f19240ag;

    /* renamed from: ah  reason: collision with root package name */
    private int f19241ah = 1;

    /* renamed from: ai  reason: collision with root package name */
    private float f19242ai = 0.0f;

    /* renamed from: aj  reason: collision with root package name */
    private float f19243aj = 1.0f;

    /* renamed from: ak  reason: collision with root package name */
    private int f19244ak = StaticLayoutBuilderCompat.f19214a;

    /* renamed from: c  reason: collision with root package name */
    private final View f19245c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19246d;

    /* renamed from: e  reason: collision with root package name */
    private float f19247e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19248f;

    /* renamed from: g  reason: collision with root package name */
    private float f19249g;

    /* renamed from: h  reason: collision with root package name */
    private float f19250h;

    /* renamed from: i  reason: collision with root package name */
    private int f19251i;

    /* renamed from: j  reason: collision with root package name */
    private final Rect f19252j;

    /* renamed from: k  reason: collision with root package name */
    private final Rect f19253k;

    /* renamed from: l  reason: collision with root package name */
    private final RectF f19254l;

    /* renamed from: m  reason: collision with root package name */
    private int f19255m = 16;

    /* renamed from: n  reason: collision with root package name */
    private int f19256n = 16;

    /* renamed from: o  reason: collision with root package name */
    private float f19257o = 15.0f;

    /* renamed from: p  reason: collision with root package name */
    private float f19258p = 15.0f;

    /* renamed from: q  reason: collision with root package name */
    private ColorStateList f19259q;

    /* renamed from: r  reason: collision with root package name */
    private ColorStateList f19260r;

    /* renamed from: s  reason: collision with root package name */
    private float f19261s;

    /* renamed from: t  reason: collision with root package name */
    private float f19262t;

    /* renamed from: u  reason: collision with root package name */
    private float f19263u;

    /* renamed from: v  reason: collision with root package name */
    private float f19264v;

    /* renamed from: w  reason: collision with root package name */
    private float f19265w;

    /* renamed from: x  reason: collision with root package name */
    private float f19266x;

    /* renamed from: y  reason: collision with root package name */
    private Typeface f19267y;

    /* renamed from: z  reason: collision with root package name */
    private Typeface f19268z;

    static {
        Paint paint = null;
        f19233b = paint;
        if (paint != null) {
            paint.setAntiAlias(true);
            paint.setColor(-65281);
        }
    }

    public a(View view) {
        this.f19245c = view;
        TextPaint textPaint = new TextPaint(IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN);
        this.O = textPaint;
        this.P = new TextPaint(textPaint);
        this.f19253k = new Rect();
        this.f19252j = new Rect();
        this.f19254l = new RectF();
        this.f19250h = v();
    }

    private void A() {
        if (this.I == null && !this.f19252j.isEmpty() && !TextUtils.isEmpty(this.E)) {
            f(0.0f);
            int width = this.f19236ac.getWidth();
            int height = this.f19236ac.getHeight();
            if (width > 0 && height > 0) {
                this.I = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.f19236ac.draw(new Canvas(this.I));
                if (this.J == null) {
                    this.J = new Paint(3);
                }
            }
        }
    }

    private void B() {
        Bitmap bitmap = this.I;
        if (bitmap != null) {
            bitmap.recycle();
            this.I = null;
        }
    }

    private static float a(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return gl.a.a(f2, f3, f4);
    }

    private float a(int i2, int i3) {
        return (i3 == 17 || (i3 & 7) == 1) ? (((float) i2) / 2.0f) - (a() / 2.0f) : ((i3 & 8388613) == 8388613 || (i3 & 5) == 5) ? this.F ? (float) this.f19253k.left : ((float) this.f19253k.right) - a() : this.F ? ((float) this.f19253k.right) - a() : (float) this.f19253k.left;
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i2)) * f3) + (((float) Color.alpha(i3)) * f2)), (int) ((((float) Color.red(i2)) * f3) + (((float) Color.red(i3)) * f2)), (int) ((((float) Color.green(i2)) * f3) + (((float) Color.green(i3)) * f2)), (int) ((((float) Color.blue(i2)) * f3) + (((float) Color.blue(i3)) * f2)));
    }

    private StaticLayout a(int i2, float f2, boolean z2) {
        StaticLayout staticLayout;
        try {
            staticLayout = StaticLayoutBuilderCompat.a(this.D, this.O, (int) f2).a(TextUtils.TruncateAt.END).b(z2).a(Layout.Alignment.ALIGN_NORMAL).a(false).a(i2).a(this.f19242ai, this.f19243aj).b(this.f19244ak).a();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e2) {
            Log.e("CollapsingTextHelper", e2.getCause().getMessage(), e2);
            staticLayout = null;
        }
        return (StaticLayout) f.a(staticLayout);
    }

    private void a(float f2, boolean z2) {
        boolean z3;
        float f3;
        boolean z4;
        if (this.D != null) {
            float width = (float) this.f19253k.width();
            float width2 = (float) this.f19252j.width();
            boolean z5 = false;
            int i2 = 1;
            if (a(f2, this.f19258p)) {
                f3 = this.f19258p;
                this.K = 1.0f;
                Typeface typeface = this.A;
                Typeface typeface2 = this.f19267y;
                if (typeface != typeface2) {
                    this.A = typeface2;
                    z3 = true;
                } else {
                    z3 = false;
                }
            } else {
                float f4 = this.f19257o;
                Typeface typeface3 = this.A;
                Typeface typeface4 = this.f19268z;
                if (typeface3 != typeface4) {
                    this.A = typeface4;
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (a(f2, f4)) {
                    this.K = 1.0f;
                } else {
                    this.K = f2 / this.f19257o;
                }
                float f5 = this.f19258p / this.f19257o;
                width = (!z2 && width2 * f5 > width) ? Math.min(width / f5, width2) : width2;
                f3 = f4;
                z3 = z4;
            }
            if (width > 0.0f) {
                z3 = this.L != f3 || this.N || z3;
                this.L = f3;
                this.N = false;
            }
            if (this.E == null || z3) {
                this.O.setTextSize(this.L);
                this.O.setTypeface(this.A);
                TextPaint textPaint = this.O;
                if (this.K != 1.0f) {
                    z5 = true;
                }
                textPaint.setLinearText(z5);
                this.F = b(this.D);
                if (y()) {
                    i2 = this.f19241ah;
                }
                StaticLayout a2 = a(i2, width, this.F);
                this.f19236ac = a2;
                this.E = a2.getText();
            }
        }
    }

    private void a(Canvas canvas, float f2, float f3) {
        int alpha = this.O.getAlpha();
        canvas.translate(f2, f3);
        float f4 = (float) alpha;
        this.O.setAlpha((int) (this.f19238ae * f4));
        this.f19236ac.draw(canvas);
        this.O.setAlpha((int) (this.f19237ad * f4));
        int lineBaseline = this.f19236ac.getLineBaseline(0);
        CharSequence charSequence = this.f19240ag;
        float f5 = (float) lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f5, this.O);
        if (!this.f19248f) {
            String trim = this.f19240ag.toString().trim();
            if (trim.endsWith("…")) {
                trim = trim.substring(0, trim.length() - 1);
            }
            String str = trim;
            this.O.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.f19236ac.getLineEnd(0), str.length()), 0.0f, f5, this.O);
        }
    }

    private void a(TextPaint textPaint) {
        textPaint.setTextSize(this.f19257o);
        textPaint.setTypeface(this.f19268z);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.f19235ab);
        }
    }

    private static boolean a(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    private static boolean a(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    private boolean a(CharSequence charSequence, boolean z2) {
        return (z2 ? e.f34195d : e.f34194c).a(charSequence, 0, charSequence.length());
    }

    private float b(RectF rectF, int i2, int i3) {
        return (i3 == 17 || (i3 & 7) == 1) ? (((float) i2) / 2.0f) + (a() / 2.0f) : ((i3 & 8388613) == 8388613 || (i3 & 5) == 5) ? this.F ? rectF.left + a() : (float) this.f19253k.right : this.F ? (float) this.f19253k.right : rectF.left + a();
    }

    private void b(TextPaint textPaint) {
        textPaint.setTextSize(this.f19258p);
        textPaint.setTypeface(this.f19267y);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.f19234aa);
        }
    }

    private boolean b(CharSequence charSequence) {
        boolean z2 = z();
        return this.G ? a(charSequence, z2) : z2;
    }

    private int c(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.M;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0116  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(boolean r13) {
        /*
            r12 = this;
            float r0 = r12.L
            float r1 = r12.f19258p
            r12.a((float) r1, (boolean) r13)
            java.lang.CharSequence r1 = r12.E
            if (r1 == 0) goto L_0x001e
            android.text.StaticLayout r2 = r12.f19236ac
            if (r2 == 0) goto L_0x001e
            android.text.TextPaint r3 = r12.O
            int r2 = r2.getWidth()
            float r2 = (float) r2
            android.text.TextUtils$TruncateAt r4 = android.text.TextUtils.TruncateAt.END
            java.lang.CharSequence r1 = android.text.TextUtils.ellipsize(r1, r3, r2, r4)
            r12.f19240ag = r1
        L_0x001e:
            java.lang.CharSequence r1 = r12.f19240ag
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x002f
            android.text.TextPaint r4 = r12.O
            int r5 = r1.length()
            float r1 = r4.measureText(r1, r2, r5)
            goto L_0x0030
        L_0x002f:
            r1 = 0
        L_0x0030:
            int r4 = r12.f19256n
            boolean r5 = r12.F
            int r4 = t.f.a(r4, r5)
            r5 = r4 & 112(0x70, float:1.57E-43)
            r6 = 80
            r7 = 48
            r8 = 1073741824(0x40000000, float:2.0)
            if (r5 == r7) goto L_0x006a
            if (r5 == r6) goto L_0x005d
            android.text.TextPaint r5 = r12.O
            float r5 = r5.descent()
            android.text.TextPaint r9 = r12.O
            float r9 = r9.ascent()
            float r5 = r5 - r9
            float r5 = r5 / r8
            android.graphics.Rect r9 = r12.f19253k
            int r9 = r9.centerY()
            float r9 = (float) r9
            float r9 = r9 - r5
            r12.f19262t = r9
            goto L_0x0071
        L_0x005d:
            android.graphics.Rect r5 = r12.f19253k
            int r5 = r5.bottom
            float r5 = (float) r5
            android.text.TextPaint r9 = r12.O
            float r9 = r9.ascent()
            float r5 = r5 + r9
            goto L_0x006f
        L_0x006a:
            android.graphics.Rect r5 = r12.f19253k
            int r5 = r5.top
            float r5 = (float) r5
        L_0x006f:
            r12.f19262t = r5
        L_0x0071:
            r5 = 8388615(0x800007, float:1.1754953E-38)
            r4 = r4 & r5
            r9 = 5
            r10 = 1
            if (r4 == r10) goto L_0x0089
            if (r4 == r9) goto L_0x0083
            android.graphics.Rect r1 = r12.f19253k
            int r1 = r1.left
            float r1 = (float) r1
            r12.f19264v = r1
            goto L_0x0094
        L_0x0083:
            android.graphics.Rect r4 = r12.f19253k
            int r4 = r4.right
            float r4 = (float) r4
            goto L_0x0091
        L_0x0089:
            android.graphics.Rect r4 = r12.f19253k
            int r4 = r4.centerX()
            float r4 = (float) r4
            float r1 = r1 / r8
        L_0x0091:
            float r4 = r4 - r1
            r12.f19264v = r4
        L_0x0094:
            float r1 = r12.f19257o
            r12.a((float) r1, (boolean) r13)
            android.text.StaticLayout r13 = r12.f19236ac
            if (r13 == 0) goto L_0x00a3
            int r13 = r13.getHeight()
            float r13 = (float) r13
            goto L_0x00a4
        L_0x00a3:
            r13 = 0
        L_0x00a4:
            java.lang.CharSequence r1 = r12.E
            if (r1 == 0) goto L_0x00b3
            android.text.TextPaint r4 = r12.O
            int r11 = r1.length()
            float r1 = r4.measureText(r1, r2, r11)
            goto L_0x00b4
        L_0x00b3:
            r1 = 0
        L_0x00b4:
            android.text.StaticLayout r4 = r12.f19236ac
            if (r4 == 0) goto L_0x00c1
            int r11 = r12.f19241ah
            if (r11 <= r10) goto L_0x00c1
            int r1 = r4.getWidth()
            float r1 = (float) r1
        L_0x00c1:
            android.text.StaticLayout r4 = r12.f19236ac
            if (r4 == 0) goto L_0x00d3
            int r3 = r12.f19241ah
            if (r3 <= r10) goto L_0x00cf
            int r2 = r4.getLineStart(r2)
            float r3 = (float) r2
            goto L_0x00d3
        L_0x00cf:
            float r3 = r4.getLineLeft(r2)
        L_0x00d3:
            r12.f19239af = r3
            int r2 = r12.f19255m
            boolean r3 = r12.F
            int r2 = t.f.a(r2, r3)
            r3 = r2 & 112(0x70, float:1.57E-43)
            if (r3 == r7) goto L_0x00fd
            if (r3 == r6) goto L_0x00ef
            float r13 = r13 / r8
            android.graphics.Rect r3 = r12.f19252j
            int r3 = r3.centerY()
            float r3 = (float) r3
            float r3 = r3 - r13
        L_0x00ec:
            r12.f19261s = r3
            goto L_0x0104
        L_0x00ef:
            android.graphics.Rect r3 = r12.f19252j
            int r3 = r3.bottom
            float r3 = (float) r3
            float r3 = r3 - r13
            android.text.TextPaint r13 = r12.O
            float r13 = r13.descent()
            float r3 = r3 + r13
            goto L_0x00ec
        L_0x00fd:
            android.graphics.Rect r13 = r12.f19252j
            int r13 = r13.top
            float r13 = (float) r13
            r12.f19261s = r13
        L_0x0104:
            r13 = r2 & r5
            if (r13 == r10) goto L_0x0116
            if (r13 == r9) goto L_0x0110
            android.graphics.Rect r13 = r12.f19252j
            int r13 = r13.left
            float r13 = (float) r13
            goto L_0x011f
        L_0x0110:
            android.graphics.Rect r13 = r12.f19252j
            int r13 = r13.right
            float r13 = (float) r13
            goto L_0x011e
        L_0x0116:
            android.graphics.Rect r13 = r12.f19252j
            int r13 = r13.centerX()
            float r13 = (float) r13
            float r1 = r1 / r8
        L_0x011e:
            float r13 = r13 - r1
        L_0x011f:
            r12.f19263u = r13
            r12.B()
            r12.k(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.a.d(boolean):void");
    }

    private boolean d(Typeface typeface) {
        gt.a aVar = this.C;
        if (aVar != null) {
            aVar.a();
        }
        if (this.f19267y == typeface) {
            return false;
        }
        this.f19267y = typeface;
        return true;
    }

    private boolean e(Typeface typeface) {
        gt.a aVar = this.B;
        if (aVar != null) {
            aVar.a();
        }
        if (this.f19268z == typeface) {
            return false;
        }
        this.f19268z = typeface;
        return true;
    }

    private void f(float f2) {
        float f3;
        h(f2);
        if (!this.f19248f) {
            this.f19265w = a(this.f19263u, this.f19264v, f2, this.Q);
            this.f19266x = a(this.f19261s, this.f19262t, f2, this.Q);
            k(a(this.f19257o, this.f19258p, f2, this.R));
            f3 = f2;
        } else if (f2 < this.f19250h) {
            this.f19265w = this.f19263u;
            this.f19266x = this.f19261s;
            k(this.f19257o);
            f3 = 0.0f;
        } else {
            this.f19265w = this.f19264v;
            this.f19266x = this.f19262t - ((float) Math.max(0, this.f19251i));
            k(this.f19258p);
            f3 = 1.0f;
        }
        i(1.0f - a(0.0f, 1.0f, 1.0f - f2, gl.a.f28536b));
        j(a(1.0f, 0.0f, f2, gl.a.f28536b));
        if (this.f19260r != this.f19259q) {
            this.O.setColor(a(x(), m(), f3));
        } else {
            this.O.setColor(m());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            float f4 = this.f19234aa;
            float f5 = this.f19235ab;
            if (f4 != f5) {
                this.O.setLetterSpacing(a(f5, f4, f2, gl.a.f28536b));
            } else {
                this.O.setLetterSpacing(f4);
            }
        }
        this.O.setShadowLayer(a(this.W, this.S, f2, (TimeInterpolator) null), a(this.X, this.T, f2, (TimeInterpolator) null), a(this.Y, this.U, f2, (TimeInterpolator) null), a(c(this.Z), c(this.V), f2));
        if (this.f19248f) {
            this.O.setAlpha((int) (g(f2) * 255.0f));
        }
        ac.e(this.f19245c);
    }

    private float g(float f2) {
        float f3 = this.f19250h;
        return f2 <= f3 ? gl.a.a(1.0f, 0.0f, this.f19249g, f3, f2) : gl.a.a(0.0f, 1.0f, f3, 1.0f, f2);
    }

    private void h(float f2) {
        if (this.f19248f) {
            this.f19254l.set(f2 < this.f19250h ? this.f19252j : this.f19253k);
            return;
        }
        this.f19254l.left = a((float) this.f19252j.left, (float) this.f19253k.left, f2, this.Q);
        this.f19254l.top = a(this.f19261s, this.f19262t, f2, this.Q);
        this.f19254l.right = a((float) this.f19252j.right, (float) this.f19253k.right, f2, this.Q);
        this.f19254l.bottom = a((float) this.f19252j.bottom, (float) this.f19253k.bottom, f2, this.Q);
    }

    private void i(float f2) {
        this.f19237ad = f2;
        ac.e(this.f19245c);
    }

    private void j(float f2) {
        this.f19238ae = f2;
        ac.e(this.f19245c);
    }

    private void k(float f2) {
        l(f2);
        boolean z2 = f19232a && this.K != 1.0f;
        this.H = z2;
        if (z2) {
            A();
        }
        ac.e(this.f19245c);
    }

    private void l(float f2) {
        a(f2, false);
    }

    private float v() {
        float f2 = this.f19249g;
        return f2 + ((1.0f - f2) * 0.5f);
    }

    private void w() {
        f(this.f19247e);
    }

    private int x() {
        return c(this.f19259q);
    }

    private boolean y() {
        return this.f19241ah > 1 && (!this.F || this.f19248f) && !this.H;
    }

    private boolean z() {
        return ac.i(this.f19245c) == 1;
    }

    public float a() {
        if (this.D == null) {
            return 0.0f;
        }
        b(this.P);
        TextPaint textPaint = this.P;
        CharSequence charSequence = this.D;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void a(float f2) {
        if (this.f19257o != f2) {
            this.f19257o = f2;
            n();
        }
    }

    public void a(int i2) {
        this.f19251i = i2;
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (!a(this.f19252j, i2, i3, i4, i5)) {
            this.f19252j.set(i2, i3, i4, i5);
            this.N = true;
            e();
        }
    }

    public void a(TimeInterpolator timeInterpolator) {
        this.R = timeInterpolator;
        n();
    }

    public void a(ColorStateList colorStateList) {
        if (this.f19260r != colorStateList) {
            this.f19260r = colorStateList;
            n();
        }
    }

    public void a(Canvas canvas) {
        int save = canvas.save();
        if (this.E != null && this.f19246d) {
            boolean z2 = true;
            float lineStart = (this.f19265w + (this.f19241ah > 1 ? (float) this.f19236ac.getLineStart(0) : this.f19236ac.getLineLeft(0))) - (this.f19239af * 2.0f);
            this.O.setTextSize(this.L);
            float f2 = this.f19265w;
            float f3 = this.f19266x;
            if (!this.H || this.I == null) {
                z2 = false;
            }
            float f4 = this.K;
            if (f4 != 1.0f && !this.f19248f) {
                canvas.scale(f4, f4, f2, f3);
            }
            if (z2) {
                canvas.drawBitmap(this.I, f2, f3, this.J);
                canvas.restoreToCount(save);
                return;
            }
            if (!y() || (this.f19248f && this.f19247e <= this.f19250h)) {
                canvas.translate(f2, f3);
                this.f19236ac.draw(canvas);
            } else {
                a(canvas, lineStart, f3);
            }
            canvas.restoreToCount(save);
        }
    }

    public void a(Rect rect) {
        a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void a(RectF rectF, int i2, int i3) {
        this.F = b(this.D);
        rectF.left = a(i2, i3);
        rectF.top = (float) this.f19253k.top;
        rectF.right = b(rectF, i2, i3);
        rectF.bottom = ((float) this.f19253k.top) + d();
    }

    public void a(Typeface typeface) {
        if (d(typeface)) {
            n();
        }
    }

    public void a(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.D, charSequence)) {
            this.D = charSequence;
            this.E = null;
            B();
            n();
        }
    }

    public void a(boolean z2) {
        this.f19248f = z2;
    }

    public final boolean a(int[] iArr) {
        this.M = iArr;
        if (!j()) {
            return false;
        }
        n();
        return true;
    }

    public float b() {
        a(this.P);
        return -this.P.ascent();
    }

    public void b(float f2) {
        this.f19249g = f2;
        this.f19250h = v();
    }

    public void b(int i2) {
        if (this.f19255m != i2) {
            this.f19255m = i2;
            n();
        }
    }

    public void b(int i2, int i3, int i4, int i5) {
        if (!a(this.f19253k, i2, i3, i4, i5)) {
            this.f19253k.set(i2, i3, i4, i5);
            this.N = true;
            e();
        }
    }

    public void b(TimeInterpolator timeInterpolator) {
        this.Q = timeInterpolator;
        n();
    }

    public void b(ColorStateList colorStateList) {
        if (this.f19259q != colorStateList) {
            this.f19259q = colorStateList;
            n();
        }
    }

    public void b(Rect rect) {
        b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void b(Typeface typeface) {
        if (e(typeface)) {
            n();
        }
    }

    public void b(boolean z2) {
        this.G = z2;
    }

    public float c() {
        a(this.P);
        return (-this.P.ascent()) + this.P.descent();
    }

    public void c(float f2) {
        float a2 = o.a.a(f2, 0.0f, 1.0f);
        if (a2 != this.f19247e) {
            this.f19247e = a2;
            w();
        }
    }

    public void c(int i2) {
        if (this.f19256n != i2) {
            this.f19256n = i2;
            n();
        }
    }

    public void c(Typeface typeface) {
        boolean d2 = d(typeface);
        boolean e2 = e(typeface);
        if (d2 || e2) {
            n();
        }
    }

    public void c(boolean z2) {
        if ((this.f19245c.getHeight() > 0 && this.f19245c.getWidth() > 0) || z2) {
            d(z2);
            w();
        }
    }

    public float d() {
        b(this.P);
        return -this.P.ascent();
    }

    public void d(float f2) {
        this.f19242ai = f2;
    }

    public void d(int i2) {
        d dVar = new d(this.f19245c.getContext(), i2);
        if (dVar.f28572a != null) {
            this.f19260r = dVar.f28572a;
        }
        if (dVar.f28585n != 0.0f) {
            this.f19258p = dVar.f28585n;
        }
        if (dVar.f28575d != null) {
            this.V = dVar.f28575d;
        }
        this.T = dVar.f28580i;
        this.U = dVar.f28581j;
        this.S = dVar.f28582k;
        this.f19234aa = dVar.f28584m;
        gt.a aVar = this.C;
        if (aVar != null) {
            aVar.a();
        }
        this.C = new gt.a(new a.C0185a() {
            public void a(Typeface typeface) {
                a.this.a(typeface);
            }
        }, dVar.a());
        dVar.a(this.f19245c.getContext(), (gt.f) this.C);
        n();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f19246d = this.f19253k.width() > 0 && this.f19253k.height() > 0 && this.f19252j.width() > 0 && this.f19252j.height() > 0;
    }

    public void e(float f2) {
        this.f19243aj = f2;
    }

    public void e(int i2) {
        d dVar = new d(this.f19245c.getContext(), i2);
        if (dVar.f28572a != null) {
            this.f19259q = dVar.f28572a;
        }
        if (dVar.f28585n != 0.0f) {
            this.f19257o = dVar.f28585n;
        }
        if (dVar.f28575d != null) {
            this.Z = dVar.f28575d;
        }
        this.X = dVar.f28580i;
        this.Y = dVar.f28581j;
        this.W = dVar.f28582k;
        this.f19235ab = dVar.f28584m;
        gt.a aVar = this.B;
        if (aVar != null) {
            aVar.a();
        }
        this.B = new gt.a(new a.C0185a() {
            public void a(Typeface typeface) {
                a.this.b(typeface);
            }
        }, dVar.a());
        dVar.a(this.f19245c.getContext(), (gt.f) this.B);
        n();
    }

    public int f() {
        return this.f19255m;
    }

    public void f(int i2) {
        if (i2 != this.f19241ah) {
            this.f19241ah = i2;
            B();
            n();
        }
    }

    public int g() {
        return this.f19256n;
    }

    public void g(int i2) {
        this.f19244ak = i2;
    }

    public Typeface h() {
        Typeface typeface = this.f19267y;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public Typeface i() {
        Typeface typeface = this.f19268z;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f19259q;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.f19260r
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0014
        L_0x000a:
            android.content.res.ColorStateList r0 = r1.f19259q
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.a.j():boolean");
    }

    public float k() {
        return this.f19250h;
    }

    public float l() {
        return this.f19247e;
    }

    public int m() {
        return c(this.f19260r);
    }

    public void n() {
        c(false);
    }

    public CharSequence o() {
        return this.D;
    }

    public int p() {
        return this.f19241ah;
    }

    public int q() {
        StaticLayout staticLayout = this.f19236ac;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public float r() {
        return this.f19236ac.getSpacingAdd();
    }

    public float s() {
        return this.f19236ac.getSpacingMultiplier();
    }

    public int t() {
        return this.f19244ak;
    }

    public ColorStateList u() {
        return this.f19260r;
    }
}
