package com.xeagle.android.vjoystick.shimmerFrameLayout;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.xeagle.R;

public class ShimmerFrameLayout extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private static final PorterDuffXfermode f25319c = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    /* renamed from: a  reason: collision with root package name */
    protected ValueAnimator f25320a;

    /* renamed from: b  reason: collision with root package name */
    protected Bitmap f25321b;

    /* renamed from: d  reason: collision with root package name */
    private Paint f25322d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f25323e;

    /* renamed from: f  reason: collision with root package name */
    private a f25324f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public b f25325g;

    /* renamed from: h  reason: collision with root package name */
    private Bitmap f25326h;

    /* renamed from: i  reason: collision with root package name */
    private Bitmap f25327i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f25328j;

    /* renamed from: k  reason: collision with root package name */
    private int f25329k;

    /* renamed from: l  reason: collision with root package name */
    private int f25330l;

    /* renamed from: m  reason: collision with root package name */
    private int f25331m;

    /* renamed from: n  reason: collision with root package name */
    private int f25332n;

    /* renamed from: o  reason: collision with root package name */
    private int f25333o;

    /* renamed from: p  reason: collision with root package name */
    private int f25334p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f25335q;

    /* renamed from: r  reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f25336r;

    /* renamed from: com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25339a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f25340b;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|5|6|7|8|(2:9|10)|11|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        static {
            /*
                com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$MaskAngle[] r0 = com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout.MaskAngle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f25340b = r0
                r1 = 1
                com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$MaskAngle r2 = com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout.MaskAngle.CW_0     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f25340b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$MaskAngle r3 = com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout.MaskAngle.CW_90     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = f25340b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$MaskAngle r3 = com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout.MaskAngle.CW_180     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r2 = f25340b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$MaskAngle r3 = com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout.MaskAngle.CW_270     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$MaskShape[] r2 = com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout.MaskShape.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f25339a = r2
                com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$MaskShape r3 = com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout.MaskShape.LINEAR     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f25339a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$MaskShape r2 = com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout.MaskShape.RADIAL     // Catch:{ NoSuchFieldError -> 0x004e }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout.AnonymousClass3.<clinit>():void");
        }
    }

    public enum MaskAngle {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    public enum MaskShape {
        LINEAR,
        RADIAL
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public MaskAngle f25349a;

        /* renamed from: b  reason: collision with root package name */
        public float f25350b;

        /* renamed from: c  reason: collision with root package name */
        public float f25351c;

        /* renamed from: d  reason: collision with root package name */
        public int f25352d;

        /* renamed from: e  reason: collision with root package name */
        public int f25353e;

        /* renamed from: f  reason: collision with root package name */
        public float f25354f;

        /* renamed from: g  reason: collision with root package name */
        public float f25355g;

        /* renamed from: h  reason: collision with root package name */
        public float f25356h;

        /* renamed from: i  reason: collision with root package name */
        public MaskShape f25357i;

        private a() {
        }

        public int a(int i2) {
            int i3 = this.f25352d;
            return i3 > 0 ? i3 : (int) (((float) i2) * this.f25355g);
        }

        public int[] a() {
            return AnonymousClass3.f25339a[this.f25357i.ordinal()] != 2 ? new int[]{0, -16777216, -16777216, 0} : new int[]{-16777216, -16777216, 0};
        }

        public int b(int i2) {
            int i3 = this.f25353e;
            return i3 > 0 ? i3 : (int) (((float) i2) * this.f25356h);
        }

        public float[] b() {
            if (AnonymousClass3.f25339a[this.f25357i.ordinal()] != 2) {
                return new float[]{Math.max(((1.0f - this.f25354f) - this.f25351c) / 2.0f, 0.0f), Math.max((1.0f - this.f25354f) / 2.0f, 0.0f), Math.min((this.f25354f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f25354f + 1.0f) + this.f25351c) / 2.0f, 1.0f)};
            }
            return new float[]{0.0f, Math.min(this.f25354f, 1.0f), Math.min(this.f25354f + this.f25351c, 1.0f)};
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f25358a;

        /* renamed from: b  reason: collision with root package name */
        public int f25359b;

        /* renamed from: c  reason: collision with root package name */
        public int f25360c;

        /* renamed from: d  reason: collision with root package name */
        public int f25361d;

        private b() {
        }

        public void a(int i2, int i3, int i4, int i5) {
            this.f25358a = i2;
            this.f25359b = i3;
            this.f25360c = i4;
            this.f25361d = i5;
        }
    }

    public ShimmerFrameLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a aVar;
        MaskShape maskShape;
        a aVar2;
        MaskAngle maskAngle;
        setWillNotDraw(false);
        this.f25324f = new a();
        this.f25322d = new Paint();
        Paint paint = new Paint();
        this.f25323e = paint;
        paint.setAntiAlias(true);
        this.f25323e.setDither(true);
        this.f25323e.setFilterBitmap(true);
        this.f25323e.setXfermode(f25319c);
        b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
            try {
                if (obtainStyledAttributes.hasValue(1)) {
                    setAutoStart(obtainStyledAttributes.getBoolean(1, false));
                }
                if (obtainStyledAttributes.hasValue(2)) {
                    setBaseAlpha(obtainStyledAttributes.getFloat(2, 0.0f));
                }
                if (obtainStyledAttributes.hasValue(4)) {
                    setDuration(obtainStyledAttributes.getInt(4, 0));
                }
                if (obtainStyledAttributes.hasValue(10)) {
                    setRepeatCount(obtainStyledAttributes.getInt(10, 0));
                }
                if (obtainStyledAttributes.hasValue(11)) {
                    setRepeatDelay(obtainStyledAttributes.getInt(11, 0));
                }
                if (obtainStyledAttributes.hasValue(12)) {
                    setRepeatMode(obtainStyledAttributes.getInt(12, 0));
                }
                if (obtainStyledAttributes.hasValue(0)) {
                    int i3 = obtainStyledAttributes.getInt(0, 0);
                    if (i3 == 90) {
                        aVar2 = this.f25324f;
                        maskAngle = MaskAngle.CW_90;
                    } else if (i3 == 180) {
                        aVar2 = this.f25324f;
                        maskAngle = MaskAngle.CW_180;
                    } else if (i3 != 270) {
                        aVar2 = this.f25324f;
                        maskAngle = MaskAngle.CW_0;
                    } else {
                        aVar2 = this.f25324f;
                        maskAngle = MaskAngle.CW_270;
                    }
                    aVar2.f25349a = maskAngle;
                }
                if (obtainStyledAttributes.hasValue(13)) {
                    if (obtainStyledAttributes.getInt(13, 0) != 1) {
                        aVar = this.f25324f;
                        maskShape = MaskShape.LINEAR;
                    } else {
                        aVar = this.f25324f;
                        maskShape = MaskShape.RADIAL;
                    }
                    aVar.f25357i = maskShape;
                }
                if (obtainStyledAttributes.hasValue(3)) {
                    this.f25324f.f25351c = obtainStyledAttributes.getFloat(3, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(6)) {
                    this.f25324f.f25352d = obtainStyledAttributes.getDimensionPixelSize(6, 0);
                }
                if (obtainStyledAttributes.hasValue(5)) {
                    this.f25324f.f25353e = obtainStyledAttributes.getDimensionPixelSize(5, 0);
                }
                if (obtainStyledAttributes.hasValue(7)) {
                    this.f25324f.f25354f = obtainStyledAttributes.getFloat(7, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(9)) {
                    this.f25324f.f25355g = obtainStyledAttributes.getFloat(9, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(8)) {
                    this.f25324f.f25356h = obtainStyledAttributes.getFloat(8, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(14)) {
                    this.f25324f.f25350b = obtainStyledAttributes.getFloat(14, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private float a(float f2, float f3, float f4) {
        return Math.min(f3, Math.max(f2, f4));
    }

    protected static Bitmap a(int i2, int i3) {
        try {
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
    }

    private void a(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    private void b(Canvas canvas) {
        Bitmap maskBitMap = getMaskBitMap();
        if (maskBitMap != null) {
            int i2 = this.f25333o;
            canvas.clipRect(i2, this.f25334p, maskBitMap.getWidth() + i2, this.f25334p + maskBitMap.getHeight());
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitMap, (float) this.f25333o, (float) this.f25334p, this.f25323e);
        }
    }

    private boolean c(Canvas canvas) {
        Bitmap i2 = i();
        Bitmap h2 = h();
        if (i2 == null || h2 == null) {
            return false;
        }
        a(new Canvas(i2));
        canvas.drawBitmap(i2, 0.0f, 0.0f, this.f25322d);
        b(new Canvas(h2));
        canvas.drawBitmap(h2, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    /* access modifiers changed from: private */
    public void d() {
        a();
        f();
        e();
    }

    private void e() {
        Bitmap bitmap = this.f25327i;
        if (bitmap != null) {
            bitmap.recycle();
            this.f25327i = null;
        }
        Bitmap bitmap2 = this.f25326h;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f25326h = null;
        }
    }

    private void f() {
        Bitmap bitmap = this.f25321b;
        if (bitmap != null) {
            bitmap.recycle();
            this.f25321b = null;
        }
    }

    private Bitmap g() {
        int width = getWidth();
        int height = getHeight();
        try {
            return a(width, height);
        } catch (OutOfMemoryError unused) {
            StringBuilder sb = new StringBuilder("ShimmerFrameLayout failed to create working bitmap");
            sb.append("(width = ");
            sb.append(width);
            sb.append(",height = ");
            sb.append(height);
            sb.append(")\n\n");
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
            Log.d("ShimmerFrameLayout", sb.toString());
            return null;
        }
    }

    private ViewTreeObserver.OnGlobalLayoutListener getLayoutListener() {
        return new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                boolean b2 = ShimmerFrameLayout.this.f25335q;
                ShimmerFrameLayout.this.d();
                if (ShimmerFrameLayout.this.f25328j || b2) {
                    ShimmerFrameLayout.this.c();
                }
            }
        };
    }

    /* JADX WARNING: type inference failed for: r19v0 */
    /* JADX WARNING: type inference failed for: r9v11, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r11v2, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap getMaskBitMap() {
        /*
            r20 = this;
            r0 = r20
            android.graphics.Bitmap r1 = r0.f25321b
            if (r1 == 0) goto L_0x0007
            return r1
        L_0x0007:
            com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$a r1 = r0.f25324f
            int r2 = r20.getWidth()
            int r1 = r1.a(r2)
            com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$a r2 = r0.f25324f
            int r3 = r20.getHeight()
            int r2 = r2.b(r3)
            android.graphics.Bitmap r3 = a(r1, r2)
            r0.f25321b = r3
            android.graphics.Canvas r4 = new android.graphics.Canvas
            android.graphics.Bitmap r3 = r0.f25321b
            r4.<init>(r3)
            int[] r3 = com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout.AnonymousClass3.f25339a
            com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$a r5 = r0.f25324f
            com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$MaskShape r5 = r5.f25357i
            int r5 = r5.ordinal()
            r3 = r3[r5]
            r5 = 4611686018427387904(0x4000000000000000, double:2.0)
            r7 = 2
            if (r3 == r7) goto L_0x0075
            int[] r3 = com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout.AnonymousClass3.f25340b
            com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$a r8 = r0.f25324f
            com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$MaskAngle r8 = r8.f25349a
            int r8 = r8.ordinal()
            r3 = r3[r8]
            r8 = 0
            if (r3 == r7) goto L_0x0058
            r9 = 3
            if (r3 == r9) goto L_0x0054
            r9 = 4
            if (r3 == r9) goto L_0x0052
            r9 = r1
            r3 = 0
        L_0x0050:
            r10 = 0
            goto L_0x005b
        L_0x0052:
            r3 = r2
            goto L_0x0056
        L_0x0054:
            r8 = r1
            r3 = 0
        L_0x0056:
            r9 = 0
            goto L_0x0050
        L_0x0058:
            r10 = r2
            r3 = 0
            r9 = 0
        L_0x005b:
            android.graphics.LinearGradient r19 = new android.graphics.LinearGradient
            float r12 = (float) r8
            float r13 = (float) r3
            float r14 = (float) r9
            float r15 = (float) r10
            com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$a r3 = r0.f25324f
            int[] r16 = r3.a()
            com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$a r3 = r0.f25324f
            float[] r17 = r3.b()
            android.graphics.Shader$TileMode r18 = android.graphics.Shader.TileMode.REPEAT
            r11 = r19
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)
            goto L_0x009e
        L_0x0075:
            int r3 = r1 / 2
            int r8 = r2 / 2
            android.graphics.RadialGradient r19 = new android.graphics.RadialGradient
            float r10 = (float) r3
            float r11 = (float) r8
            int r3 = java.lang.Math.max(r1, r2)
            double r8 = (double) r3
            double r12 = java.lang.Math.sqrt(r5)
            java.lang.Double.isNaN(r8)
            double r8 = r8 / r12
            float r12 = (float) r8
            com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$a r3 = r0.f25324f
            int[] r13 = r3.a()
            com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$a r3 = r0.f25324f
            float[] r14 = r3.b()
            android.graphics.Shader$TileMode r15 = android.graphics.Shader.TileMode.REPEAT
            r9 = r19
            r9.<init>(r10, r11, r12, r13, r14, r15)
        L_0x009e:
            r3 = r19
            com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout$a r8 = r0.f25324f
            float r8 = r8.f25350b
            int r9 = r1 / 2
            float r9 = (float) r9
            int r10 = r2 / 2
            float r10 = (float) r10
            r4.rotate(r8, r9, r10)
            android.graphics.Paint r9 = new android.graphics.Paint
            r9.<init>()
            r9.setShader(r3)
            double r5 = java.lang.Math.sqrt(r5)
            int r3 = java.lang.Math.max(r1, r2)
            double r10 = (double) r3
            java.lang.Double.isNaN(r10)
            double r5 = r5 * r10
            int r3 = (int) r5
            int r3 = r3 / r7
            int r5 = -r3
            float r6 = (float) r5
            int r1 = r1 + r3
            float r7 = (float) r1
            int r2 = r2 + r3
            float r8 = (float) r2
            r5 = r6
            r4.drawRect(r5, r6, r7, r8, r9)
            android.graphics.Bitmap r1 = r0.f25321b
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.shimmerFrameLayout.ShimmerFrameLayout.getMaskBitMap():android.graphics.Bitmap");
    }

    private Animator getShimmerAnimation() {
        ValueAnimator valueAnimator = this.f25320a;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i2 = AnonymousClass3.f25339a[this.f25324f.f25357i.ordinal()];
        int i3 = AnonymousClass3.f25340b[this.f25324f.f25349a.ordinal()];
        if (i3 == 2) {
            this.f25325g.a(0, -height, 0, height);
        } else if (i3 == 3) {
            this.f25325g.a(width, 0, width, 0);
        } else if (i3 != 4) {
            this.f25325g.a(-width, 0, width, 0);
        } else {
            this.f25325g.a(0, height, 0, -height);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, (((float) this.f25331m) / ((float) this.f25329k)) + 1.0f});
        this.f25320a = ofFloat;
        ofFloat.setDuration((long) (this.f25329k + this.f25331m));
        this.f25320a.setRepeatCount(this.f25330l);
        this.f25320a.setRepeatMode(this.f25332n);
        this.f25320a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout shimmerFrameLayout = ShimmerFrameLayout.this;
                float f2 = 1.0f - max;
                shimmerFrameLayout.setMaskOffsetX((int) ((((float) shimmerFrameLayout.f25325g.f25358a) * f2) + (((float) ShimmerFrameLayout.this.f25325g.f25360c) * max)));
                ShimmerFrameLayout shimmerFrameLayout2 = ShimmerFrameLayout.this;
                shimmerFrameLayout2.setMaskOffsetY((int) ((((float) shimmerFrameLayout2.f25325g.f25359b) * f2) + (((float) ShimmerFrameLayout.this.f25325g.f25361d) * max)));
            }
        });
        return this.f25320a;
    }

    private Bitmap h() {
        if (this.f25326h == null) {
            this.f25326h = g();
        }
        return this.f25326h;
    }

    private Bitmap i() {
        if (this.f25327i == null) {
            this.f25327i = g();
        }
        return this.f25327i;
    }

    private void setBaseAlpha(float f2) {
        this.f25322d.setAlpha((int) (a(0.0f, 1.0f, f2) * 255.0f));
    }

    public void a() {
        ValueAnimator valueAnimator = this.f25320a;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f25320a.removeAllUpdateListeners();
            this.f25320a.cancel();
        }
        this.f25320a = null;
        this.f25335q = false;
    }

    public void b() {
        setAutoStart(false);
        setDuration(1000);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.f25324f.f25349a = MaskAngle.CW_0;
        this.f25324f.f25357i = MaskShape.LINEAR;
        this.f25324f.f25351c = 0.5f;
        this.f25324f.f25352d = 0;
        this.f25324f.f25353e = 0;
        this.f25324f.f25354f = 0.0f;
        this.f25324f.f25355g = 1.0f;
        this.f25324f.f25356h = 1.0f;
        this.f25324f.f25350b = 20.0f;
        this.f25325g = new b();
        setBaseAlpha(0.3f);
        d();
    }

    public void c() {
        if (!this.f25335q) {
            getShimmerAnimation().start();
            this.f25335q = true;
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (!this.f25335q || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            c(canvas);
        }
    }

    public MaskAngle getAngle() {
        return this.f25324f.f25349a;
    }

    public float getDropOff() {
        return this.f25324f.f25351c;
    }

    public int getDuration() {
        return this.f25329k;
    }

    public int getFixedHeight() {
        return this.f25324f.f25353e;
    }

    public int getFixedWidth() {
        return this.f25324f.f25352d;
    }

    public float getIntensity() {
        return this.f25324f.f25354f;
    }

    public MaskShape getMaskShape() {
        return this.f25324f.f25357i;
    }

    public float getRelativeHeight() {
        return this.f25324f.f25356h;
    }

    public float getRelativeWidth() {
        return this.f25324f.f25355g;
    }

    public int getRepeatCount() {
        return this.f25330l;
    }

    public int getRepeatDelay() {
        return this.f25331m;
    }

    public int getRepeatMode() {
        return this.f25332n;
    }

    public float getTilt() {
        return this.f25324f.f25350b;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f25336r == null) {
            this.f25336r = getLayoutListener();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f25336r);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        a();
        if (this.f25336r != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.f25336r);
            this.f25336r = null;
        }
        super.onDetachedFromWindow();
    }

    public void setAngle(MaskAngle maskAngle) {
        this.f25324f.f25349a = maskAngle;
        d();
    }

    public void setAnimationStarted(boolean z2) {
        this.f25335q = z2;
    }

    public void setAutoStart(boolean z2) {
        this.f25328j = z2;
        d();
    }

    public void setDropOff(float f2) {
        this.f25324f.f25351c = f2;
        d();
    }

    public void setDuration(int i2) {
        this.f25329k = i2;
        d();
    }

    public void setFixedHeight(int i2) {
        this.f25324f.f25353e = i2;
        d();
    }

    public void setFixedWidth(int i2) {
        this.f25324f.f25352d = i2;
        d();
    }

    public void setIntensity(float f2) {
        this.f25324f.f25354f = f2;
        d();
    }

    public void setMaskOffsetX(int i2) {
        if (this.f25333o != i2) {
            this.f25333o = i2;
            invalidate();
        }
    }

    public void setMaskOffsetY(int i2) {
        if (this.f25334p != i2) {
            this.f25334p = i2;
            invalidate();
        }
    }

    public void setMaskShape(MaskShape maskShape) {
        this.f25324f.f25357i = maskShape;
        d();
    }

    public void setRelativeHeight(int i2) {
        this.f25324f.f25356h = (float) i2;
        d();
    }

    public void setRelativeWidth(int i2) {
        this.f25324f.f25355g = (float) i2;
        d();
    }

    public void setRepeatCount(int i2) {
        this.f25330l = i2;
        d();
    }

    public void setRepeatDelay(int i2) {
        this.f25331m = i2;
        d();
    }

    public void setRepeatMode(int i2) {
        this.f25332n = i2;
        d();
    }

    public void setTilt(float f2) {
        this.f25324f.f25350b = f2;
        d();
    }
}
