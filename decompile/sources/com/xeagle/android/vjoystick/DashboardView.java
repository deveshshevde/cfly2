package com.xeagle.android.vjoystick;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.xeagle.R;
import java.util.List;

public class DashboardView extends View {
    private float A;
    private float B;
    private Paint C;
    private Paint D;
    private Paint E;
    private Paint F;
    private Paint G;
    private RectF H;
    private RectF I;
    private Rect J;
    private Rect K;
    private Rect L;
    private Path M;
    private int N;
    private float O;
    private float P;
    private String[] Q;
    private float R;
    private boolean S;

    /* renamed from: a  reason: collision with root package name */
    private int f24546a;

    /* renamed from: b  reason: collision with root package name */
    private int f24547b;

    /* renamed from: c  reason: collision with root package name */
    private int f24548c;

    /* renamed from: d  reason: collision with root package name */
    private int f24549d;

    /* renamed from: e  reason: collision with root package name */
    private int f24550e;

    /* renamed from: f  reason: collision with root package name */
    private int f24551f;

    /* renamed from: g  reason: collision with root package name */
    private int f24552g;

    /* renamed from: h  reason: collision with root package name */
    private int f24553h;

    /* renamed from: i  reason: collision with root package name */
    private String f24554i;

    /* renamed from: j  reason: collision with root package name */
    private int f24555j;

    /* renamed from: k  reason: collision with root package name */
    private int f24556k;

    /* renamed from: l  reason: collision with root package name */
    private int f24557l;

    /* renamed from: m  reason: collision with root package name */
    private int f24558m;

    /* renamed from: n  reason: collision with root package name */
    private int f24559n;

    /* renamed from: o  reason: collision with root package name */
    private int f24560o;

    /* renamed from: p  reason: collision with root package name */
    private float f24561p;

    /* renamed from: q  reason: collision with root package name */
    private int f24562q;

    /* renamed from: r  reason: collision with root package name */
    private StripeMode f24563r;

    /* renamed from: s  reason: collision with root package name */
    private int f24564s;

    /* renamed from: t  reason: collision with root package name */
    private int f24565t;

    /* renamed from: u  reason: collision with root package name */
    private int f24566u;

    /* renamed from: v  reason: collision with root package name */
    private int f24567v;

    /* renamed from: w  reason: collision with root package name */
    private List<b> f24568w;

    /* renamed from: x  reason: collision with root package name */
    private int f24569x;

    /* renamed from: y  reason: collision with root package name */
    private int f24570y;

    /* renamed from: z  reason: collision with root package name */
    private int f24571z;

    /* renamed from: com.xeagle.android.vjoystick.DashboardView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24572a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.xeagle.android.vjoystick.DashboardView$StripeMode[] r0 = com.xeagle.android.vjoystick.DashboardView.StripeMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24572a = r0
                com.xeagle.android.vjoystick.DashboardView$StripeMode r1 = com.xeagle.android.vjoystick.DashboardView.StripeMode.NORMAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24572a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.vjoystick.DashboardView$StripeMode r1 = com.xeagle.android.vjoystick.DashboardView.StripeMode.INNER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24572a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xeagle.android.vjoystick.DashboardView$StripeMode r1 = com.xeagle.android.vjoystick.DashboardView.StripeMode.OUTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.DashboardView.AnonymousClass1.<clinit>():void");
        }
    }

    public enum StripeMode {
        NORMAL,
        INNER,
        OUTER
    }

    public DashboardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DashboardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DashboardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24554i = "";
        this.f24563r = StripeMode.NORMAL;
        this.S = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DashboardView, i2, 0);
        this.f24546a = obtainStyledAttributes.getDimensionPixelSize(11, a(80));
        this.f24547b = obtainStyledAttributes.getInteger(14, 180);
        this.f24548c = obtainStyledAttributes.getInteger(17, 180);
        this.f24549d = obtainStyledAttributes.getInteger(2, 5);
        this.f24550e = obtainStyledAttributes.getInteger(13, 5);
        this.f24551f = obtainStyledAttributes.getColor(0, -1);
        this.f24552g = obtainStyledAttributes.getDimensionPixelSize(8, b(12));
        this.f24553h = obtainStyledAttributes.getColor(18, this.f24551f);
        String string = obtainStyledAttributes.getString(6);
        this.f24554i = string;
        if (string == null) {
            this.f24554i = "";
        }
        this.f24555j = obtainStyledAttributes.getDimensionPixelSize(5, b(14));
        this.f24556k = obtainStyledAttributes.getDimensionPixelSize(4, this.f24546a / 3);
        this.f24557l = obtainStyledAttributes.getDimensionPixelSize(10, (this.f24546a / 3) * 2);
        this.f24558m = obtainStyledAttributes.getDimensionPixelSize(3, this.f24546a / 17);
        this.f24559n = obtainStyledAttributes.getInteger(9, 0);
        this.f24560o = obtainStyledAttributes.getInteger(7, 100);
        this.f24561p = obtainStyledAttributes.getFloat(12, 0.0f);
        this.f24562q = obtainStyledAttributes.getDimensionPixelSize(16, 0);
        this.f24567v = obtainStyledAttributes.getInt(15, 0);
        this.f24569x = obtainStyledAttributes.getColor(1, 0);
        obtainStyledAttributes.recycle();
        a();
    }

    private int a(int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, getResources().getDisplayMetrics());
    }

    public static String a(float f2) {
        return ((float) Math.round(f2)) - f2 == 0.0f ? String.valueOf((long) f2) : String.valueOf(f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x019d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r10 = this;
            int r0 = r10.f24548c
            r1 = 360(0x168, float:5.04E-43)
            if (r0 > r1) goto L_0x023d
            int r0 = r10.f24546a
            r1 = 10
            int r1 = r10.a((int) r1)
            int r0 = r0 - r1
            r10.f24565t = r0
            r1 = 8
            int r1 = r10.a((int) r1)
            int r0 = r0 - r1
            r10.f24564s = r0
            r1 = 2
            int r2 = r10.a((int) r1)
            int r0 = r0 - r2
            r10.f24566u = r0
            int r0 = r10.f24549d
            int r2 = r0 * 5
            r10.N = r2
            int r2 = r10.f24548c
            float r2 = (float) r2
            float r0 = (float) r0
            float r2 = r2 / r0
            r10.O = r2
            int r0 = r10.f24550e
            float r0 = (float) r0
            float r2 = r2 / r0
            r10.P = r2
            java.lang.String[] r0 = r10.getMeasureNumbers()
            r10.Q = r0
            int r0 = r10.f24567v
            r2 = 1
            if (r0 == 0) goto L_0x004b
            if (r0 == r2) goto L_0x0048
            if (r0 == r1) goto L_0x0045
            goto L_0x004f
        L_0x0045:
            com.xeagle.android.vjoystick.DashboardView$StripeMode r0 = com.xeagle.android.vjoystick.DashboardView.StripeMode.OUTER
            goto L_0x004d
        L_0x0048:
            com.xeagle.android.vjoystick.DashboardView$StripeMode r0 = com.xeagle.android.vjoystick.DashboardView.StripeMode.INNER
            goto L_0x004d
        L_0x004b:
            com.xeagle.android.vjoystick.DashboardView$StripeMode r0 = com.xeagle.android.vjoystick.DashboardView.StripeMode.NORMAL
        L_0x004d:
            r10.f24563r = r0
        L_0x004f:
            com.xeagle.android.vjoystick.DashboardView$StripeMode r0 = r10.f24563r
            com.xeagle.android.vjoystick.DashboardView$StripeMode r3 = com.xeagle.android.vjoystick.DashboardView.StripeMode.OUTER
            if (r0 != r3) goto L_0x005b
            int r0 = r10.f24546a
            int r3 = r10.f24562q
            int r0 = r0 + r3
            goto L_0x005d
        L_0x005b:
            int r0 = r10.f24546a
        L_0x005d:
            r3 = 0
            r10.B = r3
            r10.A = r3
            int r3 = r10.f24547b
            r4 = 180(0xb4, float:2.52E-43)
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = 0
            if (r3 > r4) goto L_0x0084
            int r7 = r10.f24548c
            int r7 = r7 + r3
            if (r7 < r4) goto L_0x0084
            int r3 = r0 * 2
            int r4 = r10.getPaddingLeft()
            int r3 = r3 + r4
            int r4 = r10.getPaddingRight()
            int r3 = r3 + r4
            int r4 = r10.a((int) r1)
            int r4 = r4 * 2
            int r3 = r3 + r4
            goto L_0x00ba
        L_0x0084:
            float r3 = (float) r3
            float[] r3 = r10.a(r0, r3)
            int r4 = r10.f24547b
            int r7 = r10.f24548c
            int r4 = r4 + r7
            float r4 = (float) r4
            float[] r4 = r10.a(r0, r4)
            r3 = r3[r6]
            float r3 = java.lang.Math.abs(r3)
            r4 = r4[r6]
            float r4 = java.lang.Math.abs(r4)
            float r3 = java.lang.Math.max(r3, r4)
            float r3 = r3 * r5
            int r4 = r10.getPaddingLeft()
            float r4 = (float) r4
            float r3 = r3 + r4
            int r4 = r10.getPaddingRight()
            float r4 = (float) r4
            float r3 = r3 + r4
            int r4 = r10.a((int) r1)
            int r4 = r4 * 2
            float r4 = (float) r4
            float r3 = r3 + r4
            int r3 = (int) r3
        L_0x00ba:
            r10.f24570y = r3
            int r3 = r10.f24547b
            r4 = 90
            if (r3 > r4) goto L_0x00c7
            int r7 = r10.f24548c
            int r7 = r7 + r3
            if (r7 >= r4) goto L_0x00d0
        L_0x00c7:
            r4 = 270(0x10e, float:3.78E-43)
            if (r3 > r4) goto L_0x00e4
            int r7 = r10.f24548c
            int r7 = r7 + r3
            if (r7 < r4) goto L_0x00e4
        L_0x00d0:
            int r0 = r0 * 2
            int r3 = r10.getPaddingLeft()
            int r0 = r0 + r3
            int r3 = r10.getPaddingRight()
            int r0 = r0 + r3
            int r3 = r10.a((int) r1)
            int r3 = r3 * 2
            int r0 = r0 + r3
            goto L_0x011a
        L_0x00e4:
            float r3 = (float) r3
            float[] r3 = r10.a(r0, r3)
            int r4 = r10.f24547b
            int r7 = r10.f24548c
            int r4 = r4 + r7
            float r4 = (float) r4
            float[] r0 = r10.a(r0, r4)
            r3 = r3[r2]
            float r3 = java.lang.Math.abs(r3)
            r0 = r0[r2]
            float r0 = java.lang.Math.abs(r0)
            float r0 = java.lang.Math.max(r3, r0)
            float r0 = r0 * r5
            int r3 = r10.getPaddingLeft()
            float r3 = (float) r3
            float r0 = r0 + r3
            int r3 = r10.getPaddingRight()
            float r3 = (float) r3
            float r0 = r0 + r3
            int r3 = r10.a((int) r1)
            int r3 = r3 * 2
            float r3 = (float) r3
            float r0 = r0 + r3
            int r0 = (int) r0
        L_0x011a:
            r10.f24571z = r0
            int r0 = r10.f24570y
            float r0 = (float) r0
            float r0 = r0 / r5
            r10.A = r0
            int r0 = r10.f24571z
            float r0 = (float) r0
            float r0 = r0 / r5
            r10.B = r0
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r10.C = r0
            r0.setAntiAlias(r2)
            android.graphics.Paint r0 = r10.C
            int r3 = r10.f24551f
            r0.setColor(r3)
            android.graphics.Paint r0 = r10.C
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.STROKE
            r0.setStyle(r3)
            android.graphics.Paint r0 = r10.C
            android.graphics.Paint$Cap r3 = android.graphics.Paint.Cap.ROUND
            r0.setStrokeCap(r3)
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r10.D = r0
            r0.setAntiAlias(r2)
            android.graphics.Paint r0 = r10.D
            int r3 = r10.f24553h
            r0.setColor(r3)
            android.graphics.Paint r0 = r10.D
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.STROKE
            r0.setStyle(r3)
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r10.E = r0
            r0.setAntiAlias(r2)
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r10.G = r0
            r0.setAntiAlias(r2)
            android.graphics.Paint r0 = r10.G
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.STROKE
            r0.setStyle(r3)
            android.graphics.Paint r0 = r10.G
            int r3 = r10.f24562q
            float r3 = (float) r3
            r0.setStrokeWidth(r3)
            android.graphics.RectF r0 = new android.graphics.RectF
            float r3 = r10.A
            int r4 = r10.f24546a
            float r5 = (float) r4
            float r5 = r3 - r5
            float r7 = r10.B
            float r8 = (float) r4
            float r8 = r7 - r8
            float r9 = (float) r4
            float r3 = r3 + r9
            float r4 = (float) r4
            float r7 = r7 + r4
            r0.<init>(r5, r8, r3, r7)
            r10.H = r0
            int r0 = r10.f24562q
            if (r0 <= 0) goto L_0x01d4
            com.xeagle.android.vjoystick.DashboardView$StripeMode r0 = r10.f24563r
            com.xeagle.android.vjoystick.DashboardView$StripeMode r3 = com.xeagle.android.vjoystick.DashboardView.StripeMode.OUTER
            if (r0 != r3) goto L_0x01af
            int r0 = r10.f24546a
            int r3 = r10.a((int) r2)
            int r0 = r0 + r3
            int r3 = r10.f24562q
            int r3 = r3 / r1
            int r0 = r0 + r3
            goto L_0x01c2
        L_0x01af:
            com.xeagle.android.vjoystick.DashboardView$StripeMode r0 = r10.f24563r
            com.xeagle.android.vjoystick.DashboardView$StripeMode r3 = com.xeagle.android.vjoystick.DashboardView.StripeMode.INNER
            if (r0 != r3) goto L_0x01c1
            int r0 = r10.f24546a
            int r3 = r10.a((int) r2)
            int r0 = r0 + r3
            int r3 = r10.f24562q
            int r3 = r3 / r1
            int r0 = r0 - r3
            goto L_0x01c2
        L_0x01c1:
            r0 = 0
        L_0x01c2:
            android.graphics.RectF r1 = new android.graphics.RectF
            float r3 = r10.A
            float r0 = (float) r0
            float r4 = r3 - r0
            float r5 = r10.B
            float r7 = r5 - r0
            float r3 = r3 + r0
            float r5 = r5 + r0
            r1.<init>(r4, r7, r3, r5)
            r10.I = r1
        L_0x01d4:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r10.J = r0
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r10.K = r0
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r10.L = r0
            android.graphics.Path r0 = new android.graphics.Path
            r0.<init>()
            r10.M = r0
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r10.F = r0
            r0.setAntiAlias(r2)
            android.graphics.Paint r0 = r10.F
            int r1 = r10.f24553h
            r0.setColor(r1)
            android.graphics.Paint r0 = r10.F
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.STROKE
            r0.setStyle(r1)
            android.graphics.Paint r0 = r10.F
            android.graphics.Paint$Align r1 = android.graphics.Paint.Align.CENTER
            r0.setTextAlign(r1)
            android.graphics.Paint r0 = r10.F
            int r1 = r10.f24555j
            int r2 = r10.f24552g
            int r1 = java.lang.Math.max(r1, r2)
            float r1 = (float) r1
            r0.setTextSize(r1)
            android.graphics.Paint r0 = r10.F
            float r1 = r10.f24561p
            java.lang.String r1 = a((float) r1)
            float r2 = r10.f24561p
            java.lang.String r2 = a((float) r2)
            int r2 = r2.length()
            android.graphics.Rect r3 = r10.L
            r0.getTextBounds(r1, r6, r2, r3)
            float r0 = r10.f24561p
            float r0 = r10.b((float) r0)
            r10.R = r0
            return
        L_0x023d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "sweepAngle must less than 360 degree"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.DashboardView.a():void");
    }

    private float b(float f2) {
        int i2 = this.f24560o;
        if (f2 > ((float) i2)) {
            return (float) i2;
        }
        int i3 = this.f24559n;
        return ((((float) this.f24548c) * (f2 - ((float) i3))) / ((float) (i2 - i3))) + ((float) this.f24547b);
    }

    private int b(int i2) {
        return (int) TypedValue.applyDimension(2, (float) i2, getResources().getDisplayMetrics());
    }

    private String[] getMeasureNumbers() {
        String[] strArr = new String[(this.f24549d + 1)];
        int i2 = 0;
        while (true) {
            int i3 = this.f24549d;
            if (i2 > i3) {
                return strArr;
            }
            if (i2 == 0) {
                strArr[i2] = String.valueOf(this.f24559n);
            } else if (i2 == i3) {
                strArr[i2] = String.valueOf(this.f24560o);
            } else {
                int i4 = this.f24559n;
                strArr[i2] = String.valueOf(i4 + (((this.f24560o - i4) / i3) * i2));
            }
            i2++;
        }
    }

    public float[] a(int i2, float f2) {
        float[] fArr = new float[2];
        double radians = Math.toRadians((double) f2);
        if (f2 < 90.0f) {
            double d2 = (double) this.A;
            double cos = Math.cos(radians);
            double d3 = (double) i2;
            Double.isNaN(d3);
            Double.isNaN(d2);
            fArr[0] = (float) (d2 + (cos * d3));
            double d4 = (double) this.B;
            double sin = Math.sin(radians);
            Double.isNaN(d3);
            Double.isNaN(d4);
            fArr[1] = (float) (d4 + (sin * d3));
        } else if (f2 == 90.0f) {
            fArr[0] = this.A;
            fArr[1] = this.B + ((float) i2);
        } else if (f2 > 90.0f && f2 < 180.0f) {
            double d5 = (double) (180.0f - f2);
            Double.isNaN(d5);
            double d6 = (d5 * 3.141592653589793d) / 180.0d;
            double d7 = (double) this.A;
            double cos2 = Math.cos(d6);
            double d8 = (double) i2;
            Double.isNaN(d8);
            Double.isNaN(d7);
            fArr[0] = (float) (d7 - (cos2 * d8));
            double d9 = (double) this.B;
            double sin2 = Math.sin(d6);
            Double.isNaN(d8);
            Double.isNaN(d9);
            fArr[1] = (float) (d9 + (sin2 * d8));
        } else if (f2 == 180.0f) {
            fArr[0] = this.A - ((float) i2);
            fArr[1] = this.B;
        } else if (f2 > 180.0f && f2 < 270.0f) {
            double d10 = (double) (f2 - 180.0f);
            Double.isNaN(d10);
            double d11 = (d10 * 3.141592653589793d) / 180.0d;
            double d12 = (double) this.A;
            double cos3 = Math.cos(d11);
            double d13 = (double) i2;
            Double.isNaN(d13);
            Double.isNaN(d12);
            fArr[0] = (float) (d12 - (cos3 * d13));
            double d14 = (double) this.B;
            double sin3 = Math.sin(d11);
            Double.isNaN(d13);
            Double.isNaN(d14);
            fArr[1] = (float) (d14 - (sin3 * d13));
        } else if (f2 == 270.0f) {
            fArr[0] = this.A;
            fArr[1] = this.B - ((float) i2);
        } else {
            double d15 = (double) (360.0f - f2);
            Double.isNaN(d15);
            double d16 = (d15 * 3.141592653589793d) / 180.0d;
            double d17 = (double) this.A;
            double cos4 = Math.cos(d16);
            double d18 = (double) i2;
            Double.isNaN(d18);
            Double.isNaN(d17);
            fArr[0] = (float) (d17 + (cos4 * d18));
            double d19 = (double) this.B;
            double sin4 = Math.sin(d16);
            Double.isNaN(d18);
            Double.isNaN(d19);
            fArr[1] = (float) (d19 - (sin4 * d18));
        }
        return fArr;
    }

    public int getArcColor() {
        return this.f24551f;
    }

    public int getBgColor() {
        return this.f24569x;
    }

    public int getBigSliceCount() {
        return this.f24549d;
    }

    public int getBigSliceRadius() {
        return this.f24564s;
    }

    public int getCircleRadius() {
        return this.f24558m;
    }

    public int getHeaderRadius() {
        return this.f24556k;
    }

    public int getHeaderTextSize() {
        return this.f24555j;
    }

    public String getHeaderTitle() {
        return this.f24554i;
    }

    public int getMaxValue() {
        return this.f24560o;
    }

    public int getMeasureTextSize() {
        return this.f24552g;
    }

    public int getMinValue() {
        return this.f24559n;
    }

    public int getNumMeaRadius() {
        return this.f24566u;
    }

    public int getPointerRadius() {
        return this.f24557l;
    }

    public int getRadius() {
        return this.f24546a;
    }

    public float getRealTimeValue() {
        return this.f24561p;
    }

    public int getSliceCountInOneBigSlice() {
        return this.f24550e;
    }

    public int getSmallSliceRadius() {
        return this.f24565t;
    }

    public int getStartAngle() {
        return this.f24547b;
    }

    public StripeMode getStripeMode() {
        return this.f24563r;
    }

    public int getStripeWidth() {
        return this.f24562q;
    }

    public int getSweepAngle() {
        return this.f24548c;
    }

    public int getTextColor() {
        return this.f24553h;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0291, code lost:
        if (r12.f24563r == com.xeagle.android.vjoystick.DashboardView.StripeMode.f24575c) goto L_0x0293;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r13) {
        /*
            r12 = this;
            int r0 = r12.f24569x
            if (r0 == 0) goto L_0x0007
            r13.drawColor(r0)
        L_0x0007:
            com.xeagle.android.vjoystick.DashboardView$StripeMode r0 = r12.f24563r
            com.xeagle.android.vjoystick.DashboardView$StripeMode r1 = com.xeagle.android.vjoystick.DashboardView.StripeMode.NORMAL
            r6 = 0
            if (r0 == r1) goto L_0x007a
            java.util.List<com.xeagle.android.vjoystick.b> r0 = r12.f24568w
            if (r0 == 0) goto L_0x007a
            r7 = 0
        L_0x0013:
            java.util.List<com.xeagle.android.vjoystick.b> r0 = r12.f24568w
            int r0 = r0.size()
            if (r7 >= r0) goto L_0x007a
            java.util.List<com.xeagle.android.vjoystick.b> r0 = r12.f24568w
            java.lang.Object r0 = r0.get(r7)
            com.xeagle.android.vjoystick.b r0 = (com.xeagle.android.vjoystick.b) r0
            int r1 = r0.c()
            if (r1 == 0) goto L_0x0077
            int r1 = r0.b()
            if (r1 != 0) goto L_0x0030
            goto L_0x0077
        L_0x0030:
            android.graphics.Paint r1 = r12.G
            int r2 = r0.c()
            r1.setColor(r2)
            int r1 = r0.a()
            int r2 = r0.b()
            int r1 = r1 + r2
            int r2 = r12.f24547b
            int r3 = r12.f24548c
            int r2 = r2 + r3
            if (r1 > r2) goto L_0x005d
            android.graphics.RectF r1 = r12.I
            int r2 = r0.a()
            float r2 = (float) r2
            int r0 = r0.b()
            float r3 = (float) r0
            r4 = 0
            android.graphics.Paint r5 = r12.G
            r0 = r13
            r0.drawArc(r1, r2, r3, r4, r5)
            goto L_0x0077
        L_0x005d:
            android.graphics.RectF r1 = r12.I
            int r2 = r0.a()
            float r2 = (float) r2
            int r3 = r12.f24547b
            int r4 = r12.f24548c
            int r3 = r3 + r4
            int r0 = r0.a()
            int r3 = r3 - r0
            float r3 = (float) r3
            r4 = 0
            android.graphics.Paint r5 = r12.G
            r0 = r13
            r0.drawArc(r1, r2, r3, r4, r5)
            goto L_0x007a
        L_0x0077:
            int r7 = r7 + 1
            goto L_0x0013
        L_0x007a:
            android.graphics.Paint r0 = r12.C
            r7 = 2
            int r1 = r12.a((int) r7)
            float r1 = (float) r1
            r0.setStrokeWidth(r1)
            r8 = 0
        L_0x0086:
            int r0 = r12.f24549d
            r9 = 1
            if (r8 > r0) goto L_0x017f
            float r0 = (float) r8
            float r1 = r12.O
            float r0 = r0 * r1
            int r1 = r12.f24547b
            float r1 = (float) r1
            float r10 = r0 + r1
            int r0 = r12.f24546a
            float[] r0 = r12.a(r0, r10)
            int r1 = r12.f24564s
            float[] r1 = r12.a(r1, r10)
            com.xeagle.android.vjoystick.DashboardView$StripeMode r2 = r12.f24563r
            com.xeagle.android.vjoystick.DashboardView$StripeMode r3 = com.xeagle.android.vjoystick.DashboardView.StripeMode.NORMAL
            if (r2 != r3) goto L_0x00e8
            java.util.List<com.xeagle.android.vjoystick.b> r2 = r12.f24568w
            if (r2 == 0) goto L_0x00e8
            r2 = 0
        L_0x00ac:
            java.util.List<com.xeagle.android.vjoystick.b> r3 = r12.f24568w
            int r3 = r3.size()
            if (r2 >= r3) goto L_0x00ef
            java.util.List<com.xeagle.android.vjoystick.b> r3 = r12.f24568w
            java.lang.Object r3 = r3.get(r2)
            com.xeagle.android.vjoystick.b r3 = (com.xeagle.android.vjoystick.b) r3
            int r4 = r3.c()
            if (r4 == 0) goto L_0x00e5
            int r4 = r3.b()
            if (r4 != 0) goto L_0x00c9
            goto L_0x00e5
        L_0x00c9:
            int r4 = r3.a()
            int r5 = r3.b()
            int r4 = r4 + r5
            float r4 = (float) r4
            int r4 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x00de
            android.graphics.Paint r2 = r12.C
            int r3 = r3.c()
            goto L_0x00ec
        L_0x00de:
            android.graphics.Paint r3 = r12.C
            int r4 = r12.f24551f
            r3.setColor(r4)
        L_0x00e5:
            int r2 = r2 + 1
            goto L_0x00ac
        L_0x00e8:
            android.graphics.Paint r2 = r12.C
            int r3 = r12.f24551f
        L_0x00ec:
            r2.setColor(r3)
        L_0x00ef:
            r2 = r0[r6]
            r3 = r0[r9]
            r4 = r1[r6]
            r5 = r1[r9]
            android.graphics.Paint r11 = r12.C
            r0 = r13
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r11
            r0.drawLine(r1, r2, r3, r4, r5)
            android.graphics.Paint r0 = r12.D
            int r1 = r12.f24552g
            float r1 = (float) r1
            r0.setTextSize(r1)
            java.lang.String[] r0 = r12.Q
            r0 = r0[r8]
            android.graphics.Paint r1 = r12.D
            int r2 = r0.length()
            android.graphics.Rect r3 = r12.J
            r1.getTextBounds(r0, r6, r2, r3)
            r1 = 1135869952(0x43b40000, float:360.0)
            float r2 = r10 % r1
            r3 = 1124532224(0x43070000, float:135.0)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0131
            r3 = 1129775104(0x43570000, float:215.0)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0131
            android.graphics.Paint r1 = r12.D
            android.graphics.Paint$Align r2 = android.graphics.Paint.Align.LEFT
        L_0x012d:
            r1.setTextAlign(r2)
            goto L_0x0151
        L_0x0131:
            r3 = 0
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x013c
            r3 = 1110704128(0x42340000, float:45.0)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x0147
        L_0x013c:
            r3 = 1134723072(0x43a28000, float:325.0)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x014c
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x014c
        L_0x0147:
            android.graphics.Paint r1 = r12.D
            android.graphics.Paint$Align r2 = android.graphics.Paint.Align.RIGHT
            goto L_0x012d
        L_0x014c:
            android.graphics.Paint r1 = r12.D
            android.graphics.Paint$Align r2 = android.graphics.Paint.Align.CENTER
            goto L_0x012d
        L_0x0151:
            int r1 = r12.f24566u
            float[] r1 = r12.a(r1, r10)
            if (r8 == 0) goto L_0x0169
            int r2 = r12.f24549d
            if (r8 != r2) goto L_0x015e
            goto L_0x0169
        L_0x015e:
            r2 = r1[r6]
            r1 = r1[r9]
            android.graphics.Rect r3 = r12.J
            int r3 = r3.height()
            goto L_0x0174
        L_0x0169:
            r2 = r1[r6]
            r1 = r1[r9]
            android.graphics.Rect r3 = r12.J
            int r3 = r3.height()
            int r3 = r3 / r7
        L_0x0174:
            float r3 = (float) r3
            float r1 = r1 + r3
            android.graphics.Paint r3 = r12.D
            r13.drawText(r0, r2, r1, r3)
            int r8 = r8 + 1
            goto L_0x0086
        L_0x017f:
            android.graphics.Paint r0 = r12.C
            int r1 = r12.a((int) r9)
            float r1 = (float) r1
            r0.setStrokeWidth(r1)
            r8 = 0
        L_0x018a:
            int r0 = r12.N
            if (r8 >= r0) goto L_0x0218
            int r0 = r12.f24550e
            int r0 = r8 % r0
            if (r0 == 0) goto L_0x0214
            float r0 = (float) r8
            float r1 = r12.P
            float r0 = r0 * r1
            int r1 = r12.f24547b
            float r1 = (float) r1
            float r0 = r0 + r1
            int r1 = r12.f24546a
            float[] r1 = r12.a(r1, r0)
            int r2 = r12.f24565t
            float[] r2 = r12.a(r2, r0)
            com.xeagle.android.vjoystick.DashboardView$StripeMode r3 = r12.f24563r
            com.xeagle.android.vjoystick.DashboardView$StripeMode r4 = com.xeagle.android.vjoystick.DashboardView.StripeMode.NORMAL
            if (r3 != r4) goto L_0x01f0
            java.util.List<com.xeagle.android.vjoystick.b> r3 = r12.f24568w
            if (r3 == 0) goto L_0x01f0
            r3 = 0
        L_0x01b4:
            java.util.List<com.xeagle.android.vjoystick.b> r4 = r12.f24568w
            int r4 = r4.size()
            if (r3 >= r4) goto L_0x01f7
            java.util.List<com.xeagle.android.vjoystick.b> r4 = r12.f24568w
            java.lang.Object r4 = r4.get(r3)
            com.xeagle.android.vjoystick.b r4 = (com.xeagle.android.vjoystick.b) r4
            int r5 = r4.c()
            if (r5 == 0) goto L_0x01ed
            int r5 = r4.b()
            if (r5 != 0) goto L_0x01d1
            goto L_0x01ed
        L_0x01d1:
            int r5 = r4.a()
            int r10 = r4.b()
            int r5 = r5 + r10
            float r5 = (float) r5
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x01e6
            android.graphics.Paint r0 = r12.C
            int r3 = r4.c()
            goto L_0x01f4
        L_0x01e6:
            android.graphics.Paint r4 = r12.C
            int r5 = r12.f24551f
            r4.setColor(r5)
        L_0x01ed:
            int r3 = r3 + 1
            goto L_0x01b4
        L_0x01f0:
            android.graphics.Paint r0 = r12.C
            int r3 = r12.f24551f
        L_0x01f4:
            r0.setColor(r3)
        L_0x01f7:
            android.graphics.Paint r0 = r12.C
            int r3 = r12.a((int) r9)
            float r3 = (float) r3
            r0.setStrokeWidth(r3)
            r3 = r1[r6]
            r4 = r1[r9]
            r5 = r2[r6]
            r10 = r2[r9]
            android.graphics.Paint r11 = r12.C
            r0 = r13
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r10
            r5 = r11
            r0.drawLine(r1, r2, r3, r4, r5)
        L_0x0214:
            int r8 = r8 + 1
            goto L_0x018a
        L_0x0218:
            android.graphics.Paint r0 = r12.C
            int r1 = r12.a((int) r7)
            float r1 = (float) r1
            r0.setStrokeWidth(r1)
            com.xeagle.android.vjoystick.DashboardView$StripeMode r0 = r12.f24563r
            com.xeagle.android.vjoystick.DashboardView$StripeMode r1 = com.xeagle.android.vjoystick.DashboardView.StripeMode.NORMAL
            if (r0 != r1) goto L_0x028d
            java.util.List<com.xeagle.android.vjoystick.b> r0 = r12.f24568w
            if (r0 == 0) goto L_0x0293
            r8 = 0
        L_0x022d:
            java.util.List<com.xeagle.android.vjoystick.b> r0 = r12.f24568w
            int r0 = r0.size()
            if (r8 >= r0) goto L_0x02a9
            java.util.List<com.xeagle.android.vjoystick.b> r0 = r12.f24568w
            java.lang.Object r0 = r0.get(r8)
            com.xeagle.android.vjoystick.b r0 = (com.xeagle.android.vjoystick.b) r0
            int r1 = r0.c()
            if (r1 == 0) goto L_0x028a
            int r1 = r0.b()
            if (r1 != 0) goto L_0x024a
            goto L_0x028a
        L_0x024a:
            android.graphics.Paint r1 = r12.C
            int r2 = r0.c()
            r1.setColor(r2)
            int r1 = r0.a()
            int r2 = r0.b()
            int r1 = r1 + r2
            int r2 = r12.f24547b
            int r3 = r12.f24548c
            int r2 = r2 + r3
            if (r1 > r2) goto L_0x0277
            android.graphics.RectF r1 = r12.H
            int r2 = r0.a()
            float r2 = (float) r2
            int r0 = r0.b()
            float r3 = (float) r0
            r4 = 0
            android.graphics.Paint r5 = r12.C
            r0 = r13
            r0.drawArc(r1, r2, r3, r4, r5)
            goto L_0x028a
        L_0x0277:
            android.graphics.RectF r1 = r12.H
            int r2 = r0.a()
            float r2 = (float) r2
            int r3 = r12.f24547b
            int r4 = r12.f24548c
            int r3 = r3 + r4
            int r0 = r0.a()
            int r3 = r3 - r0
            float r3 = (float) r3
            goto L_0x02a2
        L_0x028a:
            int r8 = r8 + 1
            goto L_0x022d
        L_0x028d:
            com.xeagle.android.vjoystick.DashboardView$StripeMode r0 = r12.f24563r
            com.xeagle.android.vjoystick.DashboardView$StripeMode r1 = com.xeagle.android.vjoystick.DashboardView.StripeMode.OUTER
            if (r0 != r1) goto L_0x02a9
        L_0x0293:
            android.graphics.Paint r0 = r12.C
            int r1 = r12.f24551f
            r0.setColor(r1)
            android.graphics.RectF r1 = r12.H
            int r0 = r12.f24547b
            float r2 = (float) r0
            int r0 = r12.f24548c
            float r3 = (float) r0
        L_0x02a2:
            r4 = 0
            android.graphics.Paint r5 = r12.C
            r0 = r13
            r0.drawArc(r1, r2, r3, r4, r5)
        L_0x02a9:
            android.graphics.Paint r0 = r12.D
            int r1 = r12.f24555j
            float r1 = (float) r1
            r0.setTextSize(r1)
            android.graphics.Paint r0 = r12.D
            android.graphics.Paint$Align r1 = android.graphics.Paint.Align.CENTER
            r0.setTextAlign(r1)
            android.graphics.Paint r0 = r12.D
            java.lang.String r1 = r12.f24554i
            int r2 = r1.length()
            android.graphics.Rect r3 = r12.K
            r0.getTextBounds(r1, r6, r2, r3)
            java.lang.String r0 = r12.f24554i
            float r1 = r12.A
            float r2 = r12.B
            int r3 = r12.f24556k
            float r3 = (float) r3
            float r2 = r2 - r3
            android.graphics.Rect r3 = r12.K
            int r3 = r3.height()
            float r3 = (float) r3
            float r2 = r2 + r3
            android.graphics.Paint r3 = r12.D
            r13.drawText(r0, r1, r2, r3)
            android.graphics.Paint r0 = r12.E
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.FILL
            r0.setStyle(r1)
            android.graphics.Paint r0 = r12.E
            java.lang.String r1 = "#e4e9e9"
            int r1 = android.graphics.Color.parseColor(r1)
            r0.setColor(r1)
            float r0 = r12.A
            float r1 = r12.B
            int r2 = r12.f24558m
            float r2 = (float) r2
            android.graphics.Paint r3 = r12.E
            r13.drawCircle(r0, r1, r2, r3)
            android.graphics.Paint r0 = r12.E
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.STROKE
            r0.setStyle(r1)
            android.graphics.Paint r0 = r12.E
            r1 = 4
            int r1 = r12.a((int) r1)
            float r1 = (float) r1
            r0.setStrokeWidth(r1)
            android.graphics.Paint r0 = r12.E
            int r1 = r12.f24551f
            r0.setColor(r1)
            float r0 = r12.A
            float r1 = r12.B
            int r2 = r12.f24558m
            int r3 = r12.a((int) r7)
            int r2 = r2 + r3
            float r2 = (float) r2
            android.graphics.Paint r3 = r12.E
            r13.drawCircle(r0, r1, r2, r3)
            android.graphics.Paint r0 = r12.E
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.FILL
            r0.setStyle(r1)
            android.graphics.Paint r0 = r12.E
            int r1 = r12.f24551f
            r0.setColor(r1)
            int r0 = r12.f24558m
            int r0 = r0 / r7
            float r1 = r12.R
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            float[] r0 = r12.a(r0, r1)
            android.graphics.Path r1 = r12.M
            r3 = r0[r6]
            r4 = r0[r9]
            r1.moveTo(r3, r4)
            int r1 = r12.f24558m
            int r1 = r1 / r7
            float r3 = r12.R
            float r3 = r3 - r2
            float[] r1 = r12.a(r1, r3)
            android.graphics.Path r2 = r12.M
            r3 = r1[r6]
            r4 = r1[r9]
            r2.lineTo(r3, r4)
            int r2 = r12.f24557l
            float r3 = r12.R
            float[] r2 = r12.a(r2, r3)
            android.graphics.Path r3 = r12.M
            r4 = r2[r6]
            r2 = r2[r9]
            r3.lineTo(r4, r2)
            android.graphics.Path r2 = r12.M
            r2.close()
            android.graphics.Path r2 = r12.M
            android.graphics.Paint r3 = r12.E
            r13.drawPath(r2, r3)
            r2 = r0[r6]
            r3 = r1[r6]
            float r2 = r2 + r3
            r3 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r3
            r0 = r0[r9]
            r1 = r1[r9]
            float r0 = r0 + r1
            float r0 = r0 / r3
            int r1 = r12.f24558m
            int r1 = r1 / r7
            float r1 = (float) r1
            android.graphics.Paint r3 = r12.E
            r13.drawCircle(r2, r0, r1, r3)
            float r0 = r12.f24561p
            java.lang.String r0 = a((float) r0)
            float r1 = r12.A
            float r2 = r12.B
            int r3 = r12.f24558m
            float r3 = (float) r3
            float r2 = r2 + r3
            int r3 = r12.a((int) r7)
            float r3 = (float) r3
            float r2 = r2 + r3
            r3 = 25
            int r3 = r12.a((int) r3)
            float r3 = (float) r3
            float r2 = r2 + r3
            android.graphics.Paint r3 = r12.F
            r13.drawText(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.DashboardView.onDraw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r9)
            int r9 = android.view.View.MeasureSpec.getSize(r9)
            int r1 = android.view.View.MeasureSpec.getMode(r10)
            int r10 = android.view.View.MeasureSpec.getSize(r10)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r0 != r3) goto L_0x001d
            int r4 = r8.a((int) r9)
        L_0x001a:
            r8.f24570y = r4
            goto L_0x0026
        L_0x001d:
            if (r0 != r2) goto L_0x0026
            int r4 = r8.f24570y
            int r4 = java.lang.Math.min(r4, r9)
            goto L_0x001a
        L_0x0026:
            if (r1 != r3) goto L_0x0030
            int r9 = r8.a((int) r10)
        L_0x002c:
            r8.f24571z = r9
            goto L_0x00ce
        L_0x0030:
            com.xeagle.android.vjoystick.DashboardView$StripeMode r10 = r8.f24563r
            com.xeagle.android.vjoystick.DashboardView$StripeMode r1 = com.xeagle.android.vjoystick.DashboardView.StripeMode.OUTER
            if (r10 != r1) goto L_0x003c
            int r10 = r8.f24546a
            int r1 = r8.f24562q
            int r10 = r10 + r1
            goto L_0x003e
        L_0x003c:
            int r10 = r8.f24546a
        L_0x003e:
            int r1 = r8.f24547b
            r3 = 180(0xb4, float:2.52E-43)
            r4 = 25
            r5 = 2
            if (r1 < r3) goto L_0x006d
            int r3 = r8.f24548c
            int r3 = r3 + r1
            r6 = 360(0x168, float:5.04E-43)
            if (r3 > r6) goto L_0x006d
            int r1 = r8.f24558m
            int r10 = r10 + r1
            int r1 = r8.a((int) r5)
            int r10 = r10 + r1
            int r1 = r8.a((int) r4)
            int r10 = r10 + r1
            int r1 = r8.getPaddingTop()
            int r10 = r10 + r1
            int r1 = r8.getPaddingBottom()
            int r10 = r10 + r1
            android.graphics.Rect r1 = r8.L
            int r1 = r1.height()
            int r10 = r10 + r1
            goto L_0x00c2
        L_0x006d:
            float r1 = (float) r1
            float[] r1 = r8.a(r10, r1)
            int r3 = r8.f24547b
            int r6 = r8.f24548c
            int r3 = r3 + r6
            float r3 = (float) r3
            float[] r3 = r8.a(r10, r3)
            r6 = 1
            r1 = r1[r6]
            float r1 = java.lang.Math.abs(r1)
            float r7 = r8.B
            float r1 = r1 - r7
            r3 = r3[r6]
            float r3 = java.lang.Math.abs(r3)
            float r6 = r8.B
            float r3 = r3 - r6
            float r1 = java.lang.Math.max(r1, r3)
            int r3 = r8.f24558m
            int r6 = r8.a((int) r5)
            int r3 = r3 + r6
            int r4 = r8.a((int) r4)
            int r3 = r3 + r4
            android.graphics.Rect r4 = r8.L
            int r4 = r4.height()
            int r3 = r3 + r4
            float r3 = (float) r3
            float r1 = java.lang.Math.max(r1, r3)
            float r10 = (float) r10
            float r1 = r1 + r10
            int r10 = r8.getPaddingTop()
            float r10 = (float) r10
            float r1 = r1 + r10
            int r10 = r8.getPaddingBottom()
            float r10 = (float) r10
            float r1 = r1 + r10
            int r10 = r8.a((int) r5)
            int r10 = r10 * 2
            float r10 = (float) r10
            float r1 = r1 + r10
            int r10 = (int) r1
        L_0x00c2:
            r8.f24571z = r10
            if (r0 != r2) goto L_0x00ce
            int r10 = r8.f24571z
            int r9 = java.lang.Math.min(r10, r9)
            goto L_0x002c
        L_0x00ce:
            int r9 = r8.f24570y
            int r10 = r8.f24571z
            r8.setMeasuredDimension(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.DashboardView.onMeasure(int, int):void");
    }

    public void setArcColor(int i2) {
        this.f24551f = i2;
        if (this.S) {
            this.f24553h = i2;
        }
        a();
    }

    public void setBgColor(int i2) {
        this.f24569x = i2;
        a();
    }

    public void setBigSliceCount(int i2) {
        this.f24549d = i2;
        a();
    }

    public void setBigSliceRadius(int i2) {
        this.f24564s = a(i2);
        a();
    }

    public void setCircleRadius(int i2) {
        this.f24558m = a(i2);
        a();
    }

    public void setHeaderRadius(int i2) {
        this.f24556k = a(i2);
        a();
    }

    public void setHeaderTextSize(int i2) {
        this.f24555j = b(i2);
        a();
    }

    public void setHeaderTitle(String str) {
        this.f24554i = str;
        a();
    }

    public void setMaxValue(int i2) {
        this.f24560o = i2;
        a();
    }

    public void setMeasureTextSize(int i2) {
        this.f24552g = b(i2);
        a();
    }

    public void setMinValue(int i2) {
        this.f24559n = i2;
        a();
    }

    public void setNumMeaRadius(int i2) {
        this.f24566u = a(i2);
        a();
    }

    public void setPointerRadius(int i2) {
        this.f24557l = a(i2);
        a();
    }

    public void setRadius(int i2) {
        this.f24546a = a(i2);
        a();
    }

    public void setRealTimeValue(float f2) {
        this.f24561p = f2;
        a();
    }

    public void setSliceCountInOneBigSlice(int i2) {
        this.f24550e = i2;
        a();
    }

    public void setSmallSliceRadius(int i2) {
        this.f24565t = a(i2);
        a();
    }

    public void setStartAngle(int i2) {
        this.f24547b = i2;
        a();
    }

    public void setStripeHighlightColorAndRange(List<b> list) {
        this.f24568w = list;
        a();
    }

    public void setStripeMode(StripeMode stripeMode) {
        this.f24563r = stripeMode;
        int i2 = AnonymousClass1.f24572a[stripeMode.ordinal()];
        if (i2 == 1) {
            this.f24567v = 0;
        } else if (i2 == 2) {
            this.f24567v = 1;
        } else if (i2 == 3) {
            this.f24567v = 2;
        }
        a();
    }

    public void setStripeWidth(int i2) {
        this.f24562q = a(i2);
        a();
    }

    public void setSweepAngle(int i2) {
        this.f24548c = i2;
        a();
    }

    public void setTextColor(int i2) {
        this.f24553h = i2;
        this.S = false;
        a();
    }
}
