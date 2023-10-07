package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.b;
import com.google.android.material.internal.i;
import com.google.android.material.internal.s;
import gt.d;
import gw.h;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class a extends h implements Drawable.Callback, b, i.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f18804a = {16842910};

    /* renamed from: b  reason: collision with root package name */
    private static final ShapeDrawable f18805b = new ShapeDrawable(new OvalShape());
    private gl.h A;
    private float B;
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private float H;
    private float I;
    private final Context J;
    private final Paint K = new Paint(1);
    private final Paint L;
    private final Paint.FontMetrics M = new Paint.FontMetrics();
    private final RectF N = new RectF();
    private final PointF O = new PointF();
    private final Path P = new Path();
    private final i Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private boolean X;
    private int Y;
    private int Z = 255;

    /* renamed from: aa  reason: collision with root package name */
    private ColorFilter f18806aa;

    /* renamed from: ab  reason: collision with root package name */
    private PorterDuffColorFilter f18807ab;

    /* renamed from: ac  reason: collision with root package name */
    private ColorStateList f18808ac;

    /* renamed from: ad  reason: collision with root package name */
    private PorterDuff.Mode f18809ad = PorterDuff.Mode.SRC_IN;

    /* renamed from: ae  reason: collision with root package name */
    private int[] f18810ae;

    /* renamed from: af  reason: collision with root package name */
    private boolean f18811af;

    /* renamed from: ag  reason: collision with root package name */
    private ColorStateList f18812ag;

    /* renamed from: ah  reason: collision with root package name */
    private WeakReference<C0127a> f18813ah = new WeakReference<>((Object) null);

    /* renamed from: ai  reason: collision with root package name */
    private TextUtils.TruncateAt f18814ai;

    /* renamed from: aj  reason: collision with root package name */
    private boolean f18815aj;

    /* renamed from: ak  reason: collision with root package name */
    private int f18816ak;

    /* renamed from: al  reason: collision with root package name */
    private boolean f18817al;

    /* renamed from: c  reason: collision with root package name */
    private ColorStateList f18818c;

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f18819d;

    /* renamed from: e  reason: collision with root package name */
    private float f18820e;

    /* renamed from: f  reason: collision with root package name */
    private float f18821f = -1.0f;

    /* renamed from: g  reason: collision with root package name */
    private ColorStateList f18822g;

    /* renamed from: h  reason: collision with root package name */
    private float f18823h;

    /* renamed from: i  reason: collision with root package name */
    private ColorStateList f18824i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f18825j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f18826k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f18827l;

    /* renamed from: m  reason: collision with root package name */
    private ColorStateList f18828m;

    /* renamed from: n  reason: collision with root package name */
    private float f18829n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f18830o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f18831p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f18832q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f18833r;

    /* renamed from: s  reason: collision with root package name */
    private ColorStateList f18834s;

    /* renamed from: t  reason: collision with root package name */
    private float f18835t;

    /* renamed from: u  reason: collision with root package name */
    private CharSequence f18836u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f18837v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f18838w;

    /* renamed from: x  reason: collision with root package name */
    private Drawable f18839x;

    /* renamed from: y  reason: collision with root package name */
    private ColorStateList f18840y;

    /* renamed from: z  reason: collision with root package name */
    private gl.h f18841z;

    /* renamed from: com.google.android.material.chip.a$a  reason: collision with other inner class name */
    public interface C0127a {
        void a();
    }

    private a(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context);
        this.J = context;
        i iVar = new i(this);
        this.Q = iVar;
        this.f18825j = "";
        iVar.a().density = context.getResources().getDisplayMetrics().density;
        this.L = null;
        int[] iArr = f18804a;
        setState(iArr);
        a(iArr);
        this.f18815aj = true;
        if (gu.b.f28598a) {
            f18805b.setTint(-1);
        }
    }

    public static a a(Context context, AttributeSet attributeSet, int i2, int i3) {
        a aVar = new a(context, attributeSet, i2, i3);
        aVar.a(attributeSet, i2, i3);
        return aVar;
    }

    private void a(Canvas canvas, Rect rect) {
        if (!this.f18817al) {
            this.K.setColor(this.R);
            this.K.setStyle(Paint.Style.FILL);
            this.N.set(rect);
            canvas.drawRoundRect(this.N, j(), j(), this.K);
        }
    }

    private void a(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (ah() || ai()) {
            float f2 = this.B + this.C;
            float al2 = al();
            if (androidx.core.graphics.drawable.a.i(this) == 0) {
                rectF.left = ((float) rect.left) + f2;
                rectF.right = rectF.left + al2;
            } else {
                rectF.right = ((float) rect.right) - f2;
                rectF.left = rectF.right - al2;
            }
            float am2 = am();
            rectF.top = rect.exactCenterY() - (am2 / 2.0f);
            rectF.bottom = rectF.top + am2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.util.AttributeSet r8, int r9, int r10) {
        /*
            r7 = this;
            android.content.Context r0 = r7.J
            int[] r2 = com.google.android.material.R.styleable.Chip
            r6 = 0
            int[] r5 = new int[r6]
            r1 = r8
            r3 = r9
            r4 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.l.a(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.Chip_shapeAppearance
            boolean r10 = r9.hasValue(r10)
            r7.f18817al = r10
            android.content.Context r10 = r7.J
            int r0 = com.google.android.material.R.styleable.Chip_chipSurfaceColor
            android.content.res.ColorStateList r10 = gt.c.a((android.content.Context) r10, (android.content.res.TypedArray) r9, (int) r0)
            r7.j((android.content.res.ColorStateList) r10)
            android.content.Context r10 = r7.J
            int r0 = com.google.android.material.R.styleable.Chip_chipBackgroundColor
            android.content.res.ColorStateList r10 = gt.c.a((android.content.Context) r10, (android.content.res.TypedArray) r9, (int) r0)
            r7.a((android.content.res.ColorStateList) r10)
            int r10 = com.google.android.material.R.styleable.Chip_chipMinHeight
            r0 = 0
            float r10 = r9.getDimension(r10, r0)
            r7.a((float) r10)
            int r10 = com.google.android.material.R.styleable.Chip_chipCornerRadius
            boolean r10 = r9.hasValue(r10)
            if (r10 == 0) goto L_0x0047
            int r10 = com.google.android.material.R.styleable.Chip_chipCornerRadius
            float r10 = r9.getDimension(r10, r0)
            r7.b((float) r10)
        L_0x0047:
            android.content.Context r10 = r7.J
            int r1 = com.google.android.material.R.styleable.Chip_chipStrokeColor
            android.content.res.ColorStateList r10 = gt.c.a((android.content.Context) r10, (android.content.res.TypedArray) r9, (int) r1)
            r7.b((android.content.res.ColorStateList) r10)
            int r10 = com.google.android.material.R.styleable.Chip_chipStrokeWidth
            float r10 = r9.getDimension(r10, r0)
            r7.c((float) r10)
            android.content.Context r10 = r7.J
            int r1 = com.google.android.material.R.styleable.Chip_rippleColor
            android.content.res.ColorStateList r10 = gt.c.a((android.content.Context) r10, (android.content.res.TypedArray) r9, (int) r1)
            r7.c((android.content.res.ColorStateList) r10)
            int r10 = com.google.android.material.R.styleable.Chip_android_text
            java.lang.CharSequence r10 = r9.getText(r10)
            r7.a((java.lang.CharSequence) r10)
            android.content.Context r10 = r7.J
            int r1 = com.google.android.material.R.styleable.Chip_android_textAppearance
            gt.d r10 = gt.c.c(r10, r9, r1)
            int r1 = com.google.android.material.R.styleable.Chip_android_textSize
            float r2 = r10.f28585n
            float r1 = r9.getDimension(r1, r2)
            r10.f28585n = r1
            r7.a((gt.d) r10)
            int r10 = com.google.android.material.R.styleable.Chip_android_ellipsize
            int r10 = r9.getInt(r10, r6)
            r1 = 1
            if (r10 == r1) goto L_0x009a
            r1 = 2
            if (r10 == r1) goto L_0x0097
            r1 = 3
            if (r10 == r1) goto L_0x0094
            goto L_0x009f
        L_0x0094:
            android.text.TextUtils$TruncateAt r10 = android.text.TextUtils.TruncateAt.END
            goto L_0x009c
        L_0x0097:
            android.text.TextUtils$TruncateAt r10 = android.text.TextUtils.TruncateAt.MIDDLE
            goto L_0x009c
        L_0x009a:
            android.text.TextUtils$TruncateAt r10 = android.text.TextUtils.TruncateAt.START
        L_0x009c:
            r7.a((android.text.TextUtils.TruncateAt) r10)
        L_0x009f:
            int r10 = com.google.android.material.R.styleable.Chip_chipIconVisible
            boolean r10 = r9.getBoolean(r10, r6)
            r7.b((boolean) r10)
            java.lang.String r10 = "http://schemas.android.com/apk/res-auto"
            if (r8 == 0) goto L_0x00c5
            java.lang.String r1 = "chipIconEnabled"
            java.lang.String r1 = r8.getAttributeValue(r10, r1)
            if (r1 == 0) goto L_0x00c5
            java.lang.String r1 = "chipIconVisible"
            java.lang.String r1 = r8.getAttributeValue(r10, r1)
            if (r1 != 0) goto L_0x00c5
            int r1 = com.google.android.material.R.styleable.Chip_chipIconEnabled
            boolean r1 = r9.getBoolean(r1, r6)
            r7.b((boolean) r1)
        L_0x00c5:
            android.content.Context r1 = r7.J
            int r2 = com.google.android.material.R.styleable.Chip_chipIcon
            android.graphics.drawable.Drawable r1 = gt.c.b(r1, r9, r2)
            r7.a((android.graphics.drawable.Drawable) r1)
            int r1 = com.google.android.material.R.styleable.Chip_chipIconTint
            boolean r1 = r9.hasValue(r1)
            if (r1 == 0) goto L_0x00e3
            android.content.Context r1 = r7.J
            int r2 = com.google.android.material.R.styleable.Chip_chipIconTint
            android.content.res.ColorStateList r1 = gt.c.a((android.content.Context) r1, (android.content.res.TypedArray) r9, (int) r2)
            r7.d((android.content.res.ColorStateList) r1)
        L_0x00e3:
            int r1 = com.google.android.material.R.styleable.Chip_chipIconSize
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r1 = r9.getDimension(r1, r2)
            r7.d((float) r1)
            int r1 = com.google.android.material.R.styleable.Chip_closeIconVisible
            boolean r1 = r9.getBoolean(r1, r6)
            r7.c((boolean) r1)
            if (r8 == 0) goto L_0x0112
            java.lang.String r1 = "closeIconEnabled"
            java.lang.String r1 = r8.getAttributeValue(r10, r1)
            if (r1 == 0) goto L_0x0112
            java.lang.String r1 = "closeIconVisible"
            java.lang.String r1 = r8.getAttributeValue(r10, r1)
            if (r1 != 0) goto L_0x0112
            int r1 = com.google.android.material.R.styleable.Chip_closeIconEnabled
            boolean r1 = r9.getBoolean(r1, r6)
            r7.c((boolean) r1)
        L_0x0112:
            android.content.Context r1 = r7.J
            int r2 = com.google.android.material.R.styleable.Chip_closeIcon
            android.graphics.drawable.Drawable r1 = gt.c.b(r1, r9, r2)
            r7.b((android.graphics.drawable.Drawable) r1)
            android.content.Context r1 = r7.J
            int r2 = com.google.android.material.R.styleable.Chip_closeIconTint
            android.content.res.ColorStateList r1 = gt.c.a((android.content.Context) r1, (android.content.res.TypedArray) r9, (int) r2)
            r7.e((android.content.res.ColorStateList) r1)
            int r1 = com.google.android.material.R.styleable.Chip_closeIconSize
            float r1 = r9.getDimension(r1, r0)
            r7.e((float) r1)
            int r1 = com.google.android.material.R.styleable.Chip_android_checkable
            boolean r1 = r9.getBoolean(r1, r6)
            r7.d((boolean) r1)
            int r1 = com.google.android.material.R.styleable.Chip_checkedIconVisible
            boolean r1 = r9.getBoolean(r1, r6)
            r7.e((boolean) r1)
            if (r8 == 0) goto L_0x015e
            java.lang.String r1 = "checkedIconEnabled"
            java.lang.String r1 = r8.getAttributeValue(r10, r1)
            if (r1 == 0) goto L_0x015e
            java.lang.String r1 = "checkedIconVisible"
            java.lang.String r8 = r8.getAttributeValue(r10, r1)
            if (r8 != 0) goto L_0x015e
            int r8 = com.google.android.material.R.styleable.Chip_checkedIconEnabled
            boolean r8 = r9.getBoolean(r8, r6)
            r7.e((boolean) r8)
        L_0x015e:
            android.content.Context r8 = r7.J
            int r10 = com.google.android.material.R.styleable.Chip_checkedIcon
            android.graphics.drawable.Drawable r8 = gt.c.b(r8, r9, r10)
            r7.c((android.graphics.drawable.Drawable) r8)
            int r8 = com.google.android.material.R.styleable.Chip_checkedIconTint
            boolean r8 = r9.hasValue(r8)
            if (r8 == 0) goto L_0x017c
            android.content.Context r8 = r7.J
            int r10 = com.google.android.material.R.styleable.Chip_checkedIconTint
            android.content.res.ColorStateList r8 = gt.c.a((android.content.Context) r8, (android.content.res.TypedArray) r9, (int) r10)
            r7.f((android.content.res.ColorStateList) r8)
        L_0x017c:
            android.content.Context r8 = r7.J
            int r10 = com.google.android.material.R.styleable.Chip_showMotionSpec
            gl.h r8 = gl.h.a((android.content.Context) r8, (android.content.res.TypedArray) r9, (int) r10)
            r7.a((gl.h) r8)
            android.content.Context r8 = r7.J
            int r10 = com.google.android.material.R.styleable.Chip_hideMotionSpec
            gl.h r8 = gl.h.a((android.content.Context) r8, (android.content.res.TypedArray) r9, (int) r10)
            r7.b((gl.h) r8)
            int r8 = com.google.android.material.R.styleable.Chip_chipStartPadding
            float r8 = r9.getDimension(r8, r0)
            r7.f((float) r8)
            int r8 = com.google.android.material.R.styleable.Chip_iconStartPadding
            float r8 = r9.getDimension(r8, r0)
            r7.g((float) r8)
            int r8 = com.google.android.material.R.styleable.Chip_iconEndPadding
            float r8 = r9.getDimension(r8, r0)
            r7.h((float) r8)
            int r8 = com.google.android.material.R.styleable.Chip_textStartPadding
            float r8 = r9.getDimension(r8, r0)
            r7.i((float) r8)
            int r8 = com.google.android.material.R.styleable.Chip_textEndPadding
            float r8 = r9.getDimension(r8, r0)
            r7.j((float) r8)
            int r8 = com.google.android.material.R.styleable.Chip_closeIconStartPadding
            float r8 = r9.getDimension(r8, r0)
            r7.k((float) r8)
            int r8 = com.google.android.material.R.styleable.Chip_closeIconEndPadding
            float r8 = r9.getDimension(r8, r0)
            r7.l((float) r8)
            int r8 = com.google.android.material.R.styleable.Chip_chipEndPadding
            float r8 = r9.getDimension(r8, r0)
            r7.m((float) r8)
            int r8 = com.google.android.material.R.styleable.Chip_android_maxWidth
            r10 = 2147483647(0x7fffffff, float:NaN)
            int r8 = r9.getDimensionPixelSize(r8, r10)
            r7.C(r8)
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.a.a(android.util.AttributeSet, int, int):void");
    }

    private static boolean a(int[] iArr, int i2) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0152  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int[] r7, int[] r8) {
        /*
            r6 = this;
            boolean r0 = super.onStateChange(r7)
            android.content.res.ColorStateList r1 = r6.f18818c
            r2 = 0
            if (r1 == 0) goto L_0x0010
            int r3 = r6.R
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            int r1 = r6.E(r1)
            int r3 = r6.R
            r4 = 1
            if (r3 == r1) goto L_0x001d
            r6.R = r1
            r0 = 1
        L_0x001d:
            android.content.res.ColorStateList r3 = r6.f18819d
            if (r3 == 0) goto L_0x0028
            int r5 = r6.S
            int r3 = r3.getColorForState(r7, r5)
            goto L_0x0029
        L_0x0028:
            r3 = 0
        L_0x0029:
            int r3 = r6.E(r3)
            int r5 = r6.S
            if (r5 == r3) goto L_0x0034
            r6.S = r3
            r0 = 1
        L_0x0034:
            int r1 = gn.a.a((int) r1, (int) r3)
            int r3 = r6.T
            if (r3 == r1) goto L_0x003e
            r3 = 1
            goto L_0x003f
        L_0x003e:
            r3 = 0
        L_0x003f:
            android.content.res.ColorStateList r5 = r6.N()
            if (r5 != 0) goto L_0x0047
            r5 = 1
            goto L_0x0048
        L_0x0047:
            r5 = 0
        L_0x0048:
            r3 = r3 | r5
            if (r3 == 0) goto L_0x0055
            r6.T = r1
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r1)
            r6.g((android.content.res.ColorStateList) r0)
            r0 = 1
        L_0x0055:
            android.content.res.ColorStateList r1 = r6.f18822g
            if (r1 == 0) goto L_0x0060
            int r3 = r6.U
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x0061
        L_0x0060:
            r1 = 0
        L_0x0061:
            int r3 = r6.U
            if (r3 == r1) goto L_0x0068
            r6.U = r1
            r0 = 1
        L_0x0068:
            android.content.res.ColorStateList r1 = r6.f18812ag
            if (r1 == 0) goto L_0x007b
            boolean r1 = gu.b.a((int[]) r7)
            if (r1 == 0) goto L_0x007b
            android.content.res.ColorStateList r1 = r6.f18812ag
            int r3 = r6.V
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x007c
        L_0x007b:
            r1 = 0
        L_0x007c:
            int r3 = r6.V
            if (r3 == r1) goto L_0x0087
            r6.V = r1
            boolean r1 = r6.f18811af
            if (r1 == 0) goto L_0x0087
            r0 = 1
        L_0x0087:
            com.google.android.material.internal.i r1 = r6.Q
            gt.d r1 = r1.b()
            if (r1 == 0) goto L_0x00a8
            com.google.android.material.internal.i r1 = r6.Q
            gt.d r1 = r1.b()
            android.content.res.ColorStateList r1 = r1.f28572a
            if (r1 == 0) goto L_0x00a8
            com.google.android.material.internal.i r1 = r6.Q
            gt.d r1 = r1.b()
            android.content.res.ColorStateList r1 = r1.f28572a
            int r3 = r6.W
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x00a9
        L_0x00a8:
            r1 = 0
        L_0x00a9:
            int r3 = r6.W
            if (r3 == r1) goto L_0x00b0
            r6.W = r1
            r0 = 1
        L_0x00b0:
            int[] r1 = r6.getState()
            r3 = 16842912(0x10100a0, float:2.3694006E-38)
            boolean r1 = a((int[]) r1, (int) r3)
            if (r1 == 0) goto L_0x00c3
            boolean r1 = r6.f18837v
            if (r1 == 0) goto L_0x00c3
            r1 = 1
            goto L_0x00c4
        L_0x00c3:
            r1 = 0
        L_0x00c4:
            boolean r3 = r6.X
            if (r3 == r1) goto L_0x00de
            android.graphics.drawable.Drawable r3 = r6.f18839x
            if (r3 == 0) goto L_0x00de
            float r0 = r6.c()
            r6.X = r1
            float r1 = r6.c()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00dd
            r0 = 1
            r1 = 1
            goto L_0x00df
        L_0x00dd:
            r0 = 1
        L_0x00de:
            r1 = 0
        L_0x00df:
            android.content.res.ColorStateList r3 = r6.f18808ac
            if (r3 == 0) goto L_0x00ea
            int r5 = r6.Y
            int r3 = r3.getColorForState(r7, r5)
            goto L_0x00eb
        L_0x00ea:
            r3 = 0
        L_0x00eb:
            int r5 = r6.Y
            if (r5 == r3) goto L_0x00fc
            r6.Y = r3
            android.content.res.ColorStateList r0 = r6.f18808ac
            android.graphics.PorterDuff$Mode r3 = r6.f18809ad
            android.graphics.PorterDuffColorFilter r0 = gp.a.a(r6, r0, r3)
            r6.f18807ab = r0
            goto L_0x00fd
        L_0x00fc:
            r4 = r0
        L_0x00fd:
            android.graphics.drawable.Drawable r0 = r6.f18827l
            boolean r0 = d((android.graphics.drawable.Drawable) r0)
            if (r0 == 0) goto L_0x010c
            android.graphics.drawable.Drawable r0 = r6.f18827l
            boolean r0 = r0.setState(r7)
            r4 = r4 | r0
        L_0x010c:
            android.graphics.drawable.Drawable r0 = r6.f18839x
            boolean r0 = d((android.graphics.drawable.Drawable) r0)
            if (r0 == 0) goto L_0x011b
            android.graphics.drawable.Drawable r0 = r6.f18839x
            boolean r0 = r0.setState(r7)
            r4 = r4 | r0
        L_0x011b:
            android.graphics.drawable.Drawable r0 = r6.f18832q
            boolean r0 = d((android.graphics.drawable.Drawable) r0)
            if (r0 == 0) goto L_0x0138
            int r0 = r7.length
            int r3 = r8.length
            int r0 = r0 + r3
            int[] r0 = new int[r0]
            int r3 = r7.length
            java.lang.System.arraycopy(r7, r2, r0, r2, r3)
            int r7 = r7.length
            int r3 = r8.length
            java.lang.System.arraycopy(r8, r2, r0, r7, r3)
            android.graphics.drawable.Drawable r7 = r6.f18832q
            boolean r7 = r7.setState(r0)
            r4 = r4 | r7
        L_0x0138:
            boolean r7 = gu.b.f28598a
            if (r7 == 0) goto L_0x014b
            android.graphics.drawable.Drawable r7 = r6.f18833r
            boolean r7 = d((android.graphics.drawable.Drawable) r7)
            if (r7 == 0) goto L_0x014b
            android.graphics.drawable.Drawable r7 = r6.f18833r
            boolean r7 = r7.setState(r8)
            r4 = r4 | r7
        L_0x014b:
            if (r4 == 0) goto L_0x0150
            r6.invalidateSelf()
        L_0x0150:
            if (r1 == 0) goto L_0x0155
            r6.b()
        L_0x0155:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.a.a(int[], int[]):boolean");
    }

    private boolean ah() {
        return this.f18826k && this.f18827l != null;
    }

    private boolean ai() {
        return this.f18838w && this.f18839x != null && this.X;
    }

    private boolean aj() {
        return this.f18831p && this.f18832q != null;
    }

    private boolean ak() {
        return this.f18838w && this.f18839x != null && this.f18837v;
    }

    private float al() {
        Drawable drawable = this.X ? this.f18839x : this.f18827l;
        float f2 = this.f18829n;
        return (f2 > 0.0f || drawable == null) ? f2 : (float) drawable.getIntrinsicWidth();
    }

    private float am() {
        Drawable drawable = this.X ? this.f18839x : this.f18827l;
        float f2 = this.f18829n;
        if (f2 <= 0.0f && drawable != null) {
            f2 = (float) Math.ceil((double) s.a(this.J, 24));
            if (((float) drawable.getIntrinsicHeight()) <= f2) {
                return (float) drawable.getIntrinsicHeight();
            }
        }
        return f2;
    }

    private float an() {
        this.Q.a().getFontMetrics(this.M);
        return (this.M.descent + this.M.ascent) / 2.0f;
    }

    private ColorFilter ao() {
        ColorFilter colorFilter = this.f18806aa;
        return colorFilter != null ? colorFilter : this.f18807ab;
    }

    private void ap() {
        this.f18812ag = this.f18811af ? gu.b.b(this.f18824i) : null;
    }

    private void aq() {
        this.f18833r = new RippleDrawable(gu.b.b(m()), this.f18832q, f18805b);
    }

    private void b(Canvas canvas, Rect rect) {
        if (!this.f18817al) {
            this.K.setColor(this.S);
            this.K.setStyle(Paint.Style.FILL);
            this.K.setColorFilter(ao());
            this.N.set(rect);
            canvas.drawRoundRect(this.N, j(), j(), this.K);
        }
    }

    private void b(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.f18825j != null) {
            float c2 = this.B + c() + this.E;
            float d2 = this.I + d() + this.F;
            if (androidx.core.graphics.drawable.a.i(this) == 0) {
                rectF.left = ((float) rect.left) + c2;
                rectF.right = ((float) rect.right) - d2;
            } else {
                rectF.left = ((float) rect.left) + d2;
                rectF.right = ((float) rect.right) - c2;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    private static boolean b(d dVar) {
        return (dVar == null || dVar.f28572a == null || !dVar.f28572a.isStateful()) ? false : true;
    }

    private void c(Canvas canvas, Rect rect) {
        if (this.f18823h > 0.0f && !this.f18817al) {
            this.K.setColor(this.U);
            this.K.setStyle(Paint.Style.STROKE);
            if (!this.f18817al) {
                this.K.setColorFilter(ao());
            }
            this.N.set(((float) rect.left) + (this.f18823h / 2.0f), ((float) rect.top) + (this.f18823h / 2.0f), ((float) rect.right) - (this.f18823h / 2.0f), ((float) rect.bottom) - (this.f18823h / 2.0f));
            float f2 = this.f18821f - (this.f18823h / 2.0f);
            canvas.drawRoundRect(this.N, f2, f2, this.K);
        }
    }

    private void c(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (aj()) {
            float f2 = this.I + this.H;
            if (androidx.core.graphics.drawable.a.i(this) == 0) {
                rectF.right = ((float) rect.right) - f2;
                rectF.left = rectF.right - this.f18835t;
            } else {
                rectF.left = ((float) rect.left) + f2;
                rectF.right = rectF.left + this.f18835t;
            }
            rectF.top = rect.exactCenterY() - (this.f18835t / 2.0f);
            rectF.bottom = rectF.top + this.f18835t;
        }
    }

    private void d(Canvas canvas, Rect rect) {
        this.K.setColor(this.V);
        this.K.setStyle(Paint.Style.FILL);
        this.N.set(rect);
        if (!this.f18817al) {
            canvas.drawRoundRect(this.N, j(), j(), this.K);
            return;
        }
        a(new RectF(rect), this.P);
        super.a(canvas, this.K, this.P, R());
    }

    private void d(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (aj()) {
            float f2 = this.I + this.H + this.f18835t + this.G + this.F;
            if (androidx.core.graphics.drawable.a.i(this) == 0) {
                rectF.right = ((float) rect.right) - f2;
            } else {
                rectF.left = ((float) rect.left) + f2;
            }
        }
    }

    private static boolean d(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private void e(Canvas canvas, Rect rect) {
        if (ah()) {
            a(rect, this.N);
            float f2 = this.N.left;
            float f3 = this.N.top;
            canvas.translate(f2, f3);
            this.f18827l.setBounds(0, 0, (int) this.N.width(), (int) this.N.height());
            this.f18827l.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void e(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (aj()) {
            float f2 = this.I + this.H + this.f18835t + this.G + this.F;
            if (androidx.core.graphics.drawable.a.i(this) == 0) {
                rectF.right = (float) rect.right;
                rectF.left = rectF.right - f2;
            } else {
                rectF.left = (float) rect.left;
                rectF.right = ((float) rect.left) + f2;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    private void e(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    private void f(Canvas canvas, Rect rect) {
        if (ai()) {
            a(rect, this.N);
            float f2 = this.N.left;
            float f3 = this.N.top;
            canvas.translate(f2, f3);
            this.f18839x.setBounds(0, 0, (int) this.N.width(), (int) this.N.height());
            this.f18839x.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void f(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            androidx.core.graphics.drawable.a.b(drawable, androidx.core.graphics.drawable.a.i(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.f18832q) {
                if (drawable.isStateful()) {
                    drawable.setState(g());
                }
                androidx.core.graphics.drawable.a.a(drawable, this.f18834s);
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
            Drawable drawable2 = this.f18827l;
            if (drawable == drawable2 && this.f18830o) {
                androidx.core.graphics.drawable.a.a(drawable2, this.f18828m);
            }
        }
    }

    private void g(Canvas canvas, Rect rect) {
        if (this.f18825j != null) {
            Paint.Align a2 = a(rect, this.O);
            b(rect, this.N);
            if (this.Q.b() != null) {
                this.Q.a().drawableState = getState();
                this.Q.a(this.J);
            }
            this.Q.a().setTextAlign(a2);
            int i2 = 0;
            boolean z2 = Math.round(this.Q.a(n().toString())) > Math.round(this.N.width());
            if (z2) {
                i2 = canvas.save();
                canvas.clipRect(this.N);
            }
            CharSequence charSequence = this.f18825j;
            if (z2 && this.f18814ai != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.Q.a(), this.N.width(), this.f18814ai);
            }
            CharSequence charSequence2 = charSequence;
            canvas.drawText(charSequence2, 0, charSequence2.length(), this.O.x, this.O.y, this.Q.a());
            if (z2) {
                canvas.restoreToCount(i2);
            }
        }
    }

    private void h(Canvas canvas, Rect rect) {
        Drawable drawable;
        if (aj()) {
            c(rect, this.N);
            float f2 = this.N.left;
            float f3 = this.N.top;
            canvas.translate(f2, f3);
            this.f18832q.setBounds(0, 0, (int) this.N.width(), (int) this.N.height());
            if (gu.b.f28598a) {
                this.f18833r.setBounds(this.f18832q.getBounds());
                this.f18833r.jumpToCurrentState();
                drawable = this.f18833r;
            } else {
                drawable = this.f18832q;
            }
            drawable.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void i(Canvas canvas, Rect rect) {
        Paint paint = this.L;
        if (paint != null) {
            paint.setColor(m.a.b(-16777216, 127));
            canvas.drawRect(rect, this.L);
            if (ah() || ai()) {
                a(rect, this.N);
                canvas.drawRect(this.N, this.L);
            }
            if (this.f18825j != null) {
                canvas.drawLine((float) rect.left, rect.exactCenterY(), (float) rect.right, rect.exactCenterY(), this.L);
            }
            if (aj()) {
                c(rect, this.N);
                canvas.drawRect(this.N, this.L);
            }
            this.L.setColor(m.a.b(-65536, 127));
            d(rect, this.N);
            canvas.drawRect(this.N, this.L);
            this.L.setColor(m.a.b(-16711936, 127));
            e(rect, this.N);
            canvas.drawRect(this.N, this.L);
        }
    }

    private static boolean i(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private void j(ColorStateList colorStateList) {
        if (this.f18818c != colorStateList) {
            this.f18818c = colorStateList;
            onStateChange(getState());
        }
    }

    public ColorStateList A() {
        return this.f18840y;
    }

    public void A(int i2) {
        l(this.J.getResources().getDimension(i2));
    }

    public gl.h B() {
        return this.f18841z;
    }

    public void B(int i2) {
        m(this.J.getResources().getDimension(i2));
    }

    public gl.h C() {
        return this.A;
    }

    public void C(int i2) {
        this.f18816ak = i2;
    }

    public float D() {
        return this.B;
    }

    public float E() {
        return this.C;
    }

    public float F() {
        return this.D;
    }

    public float G() {
        return this.E;
    }

    public float H() {
        return this.F;
    }

    public float I() {
        return this.G;
    }

    public float J() {
        return this.H;
    }

    public float K() {
        return this.I;
    }

    /* access modifiers changed from: package-private */
    public boolean L() {
        return this.f18815aj;
    }

    /* access modifiers changed from: package-private */
    public Paint.Align a(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.f18825j != null) {
            float c2 = this.B + c() + this.E;
            if (androidx.core.graphics.drawable.a.i(this) == 0) {
                pointF.x = ((float) rect.left) + c2;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = ((float) rect.right) - c2;
                align = Paint.Align.RIGHT;
            }
            pointF.y = ((float) rect.centerY()) - an();
        }
        return align;
    }

    public void a(float f2) {
        if (this.f18820e != f2) {
            this.f18820e = f2;
            invalidateSelf();
            b();
        }
    }

    public void a(int i2) {
        a(c.a.a(this.J, i2));
    }

    public void a(ColorStateList colorStateList) {
        if (this.f18819d != colorStateList) {
            this.f18819d = colorStateList;
            onStateChange(getState());
        }
    }

    public void a(RectF rectF) {
        e(getBounds(), rectF);
    }

    public void a(Drawable drawable) {
        Drawable q2 = q();
        if (q2 != drawable) {
            float c2 = c();
            this.f18827l = drawable != null ? androidx.core.graphics.drawable.a.g(drawable).mutate() : null;
            float c3 = c();
            e(q2);
            if (ah()) {
                f(this.f18827l);
            }
            invalidateSelf();
            if (c2 != c3) {
                b();
            }
        }
    }

    public void a(TextUtils.TruncateAt truncateAt) {
        this.f18814ai = truncateAt;
    }

    public void a(C0127a aVar) {
        this.f18813ah = new WeakReference<>(aVar);
    }

    public void a(gl.h hVar) {
        this.f18841z = hVar;
    }

    public void a(d dVar) {
        this.Q.a(dVar, this.J);
    }

    public void a(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.f18825j, charSequence)) {
            this.f18825j = charSequence;
            this.Q.a(true);
            invalidateSelf();
            b();
        }
    }

    public void a(boolean z2) {
        if (this.f18811af != z2) {
            this.f18811af = z2;
            ap();
            onStateChange(getState());
        }
    }

    public boolean a() {
        return this.f18811af;
    }

    public boolean a(int[] iArr) {
        if (Arrays.equals(this.f18810ae, iArr)) {
            return false;
        }
        this.f18810ae = iArr;
        if (aj()) {
            return a(getState(), iArr);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void b() {
        C0127a aVar = (C0127a) this.f18813ah.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    @Deprecated
    public void b(float f2) {
        if (this.f18821f != f2) {
            this.f18821f = f2;
            setShapeAppearanceModel(M().a(f2));
        }
    }

    public void b(int i2) {
        a(this.J.getResources().getDimension(i2));
    }

    public void b(ColorStateList colorStateList) {
        if (this.f18822g != colorStateList) {
            this.f18822g = colorStateList;
            if (this.f18817al) {
                h(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void b(Drawable drawable) {
        Drawable u2 = u();
        if (u2 != drawable) {
            float d2 = d();
            this.f18832q = drawable != null ? androidx.core.graphics.drawable.a.g(drawable).mutate() : null;
            if (gu.b.f28598a) {
                aq();
            }
            float d3 = d();
            e(u2);
            if (aj()) {
                f(this.f18832q);
            }
            invalidateSelf();
            if (d2 != d3) {
                b();
            }
        }
    }

    public void b(gl.h hVar) {
        this.A = hVar;
    }

    public void b(CharSequence charSequence) {
        if (this.f18836u != charSequence) {
            this.f18836u = r.a.a().a(charSequence);
            invalidateSelf();
        }
    }

    public void b(boolean z2) {
        if (this.f18826k != z2) {
            boolean ah2 = ah();
            this.f18826k = z2;
            boolean ah3 = ah();
            if (ah2 != ah3) {
                if (ah3) {
                    f(this.f18827l);
                } else {
                    e(this.f18827l);
                }
                invalidateSelf();
                b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public float c() {
        if (ah() || ai()) {
            return this.C + al() + this.D;
        }
        return 0.0f;
    }

    public void c(float f2) {
        if (this.f18823h != f2) {
            this.f18823h = f2;
            this.K.setStrokeWidth(f2);
            if (this.f18817al) {
                super.n(f2);
            }
            invalidateSelf();
        }
    }

    @Deprecated
    public void c(int i2) {
        b(this.J.getResources().getDimension(i2));
    }

    public void c(ColorStateList colorStateList) {
        if (this.f18824i != colorStateList) {
            this.f18824i = colorStateList;
            ap();
            onStateChange(getState());
        }
    }

    public void c(Drawable drawable) {
        if (this.f18839x != drawable) {
            float c2 = c();
            this.f18839x = drawable;
            float c3 = c();
            e(this.f18839x);
            f(this.f18839x);
            invalidateSelf();
            if (c2 != c3) {
                b();
            }
        }
    }

    public void c(boolean z2) {
        if (this.f18831p != z2) {
            boolean aj2 = aj();
            this.f18831p = z2;
            boolean aj3 = aj();
            if (aj2 != aj3) {
                if (aj3) {
                    f(this.f18832q);
                } else {
                    e(this.f18832q);
                }
                invalidateSelf();
                b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public float d() {
        if (aj()) {
            return this.G + this.f18835t + this.H;
        }
        return 0.0f;
    }

    public void d(float f2) {
        if (this.f18829n != f2) {
            float c2 = c();
            this.f18829n = f2;
            float c3 = c();
            invalidateSelf();
            if (c2 != c3) {
                b();
            }
        }
    }

    public void d(int i2) {
        b(c.a.a(this.J, i2));
    }

    public void d(ColorStateList colorStateList) {
        this.f18830o = true;
        if (this.f18828m != colorStateList) {
            this.f18828m = colorStateList;
            if (ah()) {
                androidx.core.graphics.drawable.a.a(this.f18827l, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void d(boolean z2) {
        if (this.f18837v != z2) {
            this.f18837v = z2;
            float c2 = c();
            if (!z2 && this.X) {
                this.X = false;
            }
            float c3 = c();
            invalidateSelf();
            if (c2 != c3) {
                b();
            }
        }
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i2 = 0;
            if (this.Z < 255) {
                i2 = gm.a.a(canvas, (float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.Z);
            }
            a(canvas, bounds);
            b(canvas, bounds);
            if (this.f18817al) {
                super.draw(canvas);
            }
            c(canvas, bounds);
            d(canvas, bounds);
            e(canvas, bounds);
            f(canvas, bounds);
            if (this.f18815aj) {
                g(canvas, bounds);
            }
            h(canvas, bounds);
            i(canvas, bounds);
            if (this.Z < 255) {
                canvas.restoreToCount(i2);
            }
        }
    }

    public void e(float f2) {
        if (this.f18835t != f2) {
            this.f18835t = f2;
            invalidateSelf();
            if (aj()) {
                b();
            }
        }
    }

    public void e(int i2) {
        c(this.J.getResources().getDimension(i2));
    }

    public void e(ColorStateList colorStateList) {
        if (this.f18834s != colorStateList) {
            this.f18834s = colorStateList;
            if (aj()) {
                androidx.core.graphics.drawable.a.a(this.f18832q, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void e(boolean z2) {
        if (this.f18838w != z2) {
            boolean ai2 = ai();
            this.f18838w = z2;
            boolean ai3 = ai();
            if (ai2 != ai3) {
                if (ai3) {
                    f(this.f18839x);
                } else {
                    e(this.f18839x);
                }
                invalidateSelf();
                b();
            }
        }
    }

    public boolean e() {
        return d(this.f18832q);
    }

    public void f() {
        b();
        invalidateSelf();
    }

    public void f(float f2) {
        if (this.B != f2) {
            this.B = f2;
            invalidateSelf();
            b();
        }
    }

    public void f(int i2) {
        c(c.a.a(this.J, i2));
    }

    public void f(ColorStateList colorStateList) {
        if (this.f18840y != colorStateList) {
            this.f18840y = colorStateList;
            if (ak()) {
                androidx.core.graphics.drawable.a.a(this.f18839x, colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* access modifiers changed from: package-private */
    public void f(boolean z2) {
        this.f18815aj = z2;
    }

    public void g(float f2) {
        if (this.C != f2) {
            float c2 = c();
            this.C = f2;
            float c3 = c();
            invalidateSelf();
            if (c2 != c3) {
                b();
            }
        }
    }

    public void g(int i2) {
        a(new d(this.J, i2));
    }

    public int[] g() {
        return this.f18810ae;
    }

    public int getAlpha() {
        return this.Z;
    }

    public ColorFilter getColorFilter() {
        return this.f18806aa;
    }

    public int getIntrinsicHeight() {
        return (int) this.f18820e;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.B + c() + this.E + this.Q.a(n().toString()) + this.F + d() + this.I), this.f18816ak);
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        if (this.f18817al) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.f18821f);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f18821f);
        }
        outline.setAlpha(((float) getAlpha()) / 255.0f);
    }

    public ColorStateList h() {
        return this.f18819d;
    }

    public void h(float f2) {
        if (this.D != f2) {
            float c2 = c();
            this.D = f2;
            float c3 = c();
            invalidateSelf();
            if (c2 != c3) {
                b();
            }
        }
    }

    public void h(int i2) {
        b(this.J.getResources().getBoolean(i2));
    }

    public float i() {
        return this.f18820e;
    }

    public void i(float f2) {
        if (this.E != f2) {
            this.E = f2;
            invalidateSelf();
            b();
        }
    }

    public void i(int i2) {
        a(c.a.b(this.J, i2));
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isStateful() {
        return i(this.f18818c) || i(this.f18819d) || i(this.f18822g) || (this.f18811af && i(this.f18812ag)) || b(this.Q.b()) || ak() || d(this.f18827l) || d(this.f18839x) || i(this.f18808ac);
    }

    public float j() {
        return this.f18817al ? ac() : this.f18821f;
    }

    public void j(float f2) {
        if (this.F != f2) {
            this.F = f2;
            invalidateSelf();
            b();
        }
    }

    public void j(int i2) {
        d(c.a.a(this.J, i2));
    }

    public ColorStateList k() {
        return this.f18822g;
    }

    public void k(float f2) {
        if (this.G != f2) {
            this.G = f2;
            invalidateSelf();
            if (aj()) {
                b();
            }
        }
    }

    public void k(int i2) {
        d(this.J.getResources().getDimension(i2));
    }

    public float l() {
        return this.f18823h;
    }

    public void l(float f2) {
        if (this.H != f2) {
            this.H = f2;
            invalidateSelf();
            if (aj()) {
                b();
            }
        }
    }

    public void l(int i2) {
        b(c.a.b(this.J, i2));
    }

    public ColorStateList m() {
        return this.f18824i;
    }

    public void m(float f2) {
        if (this.I != f2) {
            this.I = f2;
            invalidateSelf();
            b();
        }
    }

    public void m(int i2) {
        e(c.a.a(this.J, i2));
    }

    public CharSequence n() {
        return this.f18825j;
    }

    public void n(int i2) {
        e(this.J.getResources().getDimension(i2));
    }

    public d o() {
        return this.Q.b();
    }

    public void o(int i2) {
        d(this.J.getResources().getBoolean(i2));
    }

    public boolean onLayoutDirectionChanged(int i2) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (ah()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.b(this.f18827l, i2);
        }
        if (ai()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.b(this.f18839x, i2);
        }
        if (aj()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.b(this.f18832q, i2);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        boolean onLevelChange = super.onLevelChange(i2);
        if (ah()) {
            onLevelChange |= this.f18827l.setLevel(i2);
        }
        if (ai()) {
            onLevelChange |= this.f18839x.setLevel(i2);
        }
        if (aj()) {
            onLevelChange |= this.f18832q.setLevel(i2);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public boolean onStateChange(int[] iArr) {
        if (this.f18817al) {
            super.onStateChange(iArr);
        }
        return a(iArr, g());
    }

    public TextUtils.TruncateAt p() {
        return this.f18814ai;
    }

    public void p(int i2) {
        e(this.J.getResources().getBoolean(i2));
    }

    public Drawable q() {
        Drawable drawable = this.f18827l;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return null;
    }

    public void q(int i2) {
        c(c.a.b(this.J, i2));
    }

    public ColorStateList r() {
        return this.f18828m;
    }

    public void r(int i2) {
        f(c.a.a(this.J, i2));
    }

    public float s() {
        return this.f18829n;
    }

    public void s(int i2) {
        a(gl.h.a(this.J, i2));
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        if (this.Z != i2) {
            this.Z = i2;
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f18806aa != colorFilter) {
            this.f18806aa = colorFilter;
            invalidateSelf();
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.f18808ac != colorStateList) {
            this.f18808ac = colorStateList;
            onStateChange(getState());
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f18809ad != mode) {
            this.f18809ad = mode;
            this.f18807ab = gp.a.a(this, this.f18808ac, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        if (ah()) {
            visible |= this.f18827l.setVisible(z2, z3);
        }
        if (ai()) {
            visible |= this.f18839x.setVisible(z2, z3);
        }
        if (aj()) {
            visible |= this.f18832q.setVisible(z2, z3);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t(int i2) {
        b(gl.h.a(this.J, i2));
    }

    public boolean t() {
        return this.f18831p;
    }

    public Drawable u() {
        Drawable drawable = this.f18832q;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return null;
    }

    public void u(int i2) {
        f(this.J.getResources().getDimension(i2));
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public ColorStateList v() {
        return this.f18834s;
    }

    public void v(int i2) {
        g(this.J.getResources().getDimension(i2));
    }

    public float w() {
        return this.f18835t;
    }

    public void w(int i2) {
        h(this.J.getResources().getDimension(i2));
    }

    public CharSequence x() {
        return this.f18836u;
    }

    public void x(int i2) {
        i(this.J.getResources().getDimension(i2));
    }

    public void y(int i2) {
        j(this.J.getResources().getDimension(i2));
    }

    public boolean y() {
        return this.f18837v;
    }

    public Drawable z() {
        return this.f18839x;
    }

    public void z(int i2) {
        k(this.J.getResources().getDimension(i2));
    }
}
