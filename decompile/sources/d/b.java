package d;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
import com.autonavi.amap.mapcore.tools.GlMapUtil;

class b extends Drawable implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    private c f26631a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f26632b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f26633c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f26634d;

    /* renamed from: e  reason: collision with root package name */
    private int f26635e = 255;

    /* renamed from: f  reason: collision with root package name */
    private boolean f26636f;

    /* renamed from: g  reason: collision with root package name */
    private int f26637g = -1;

    /* renamed from: h  reason: collision with root package name */
    private boolean f26638h;

    /* renamed from: i  reason: collision with root package name */
    private Runnable f26639i;

    /* renamed from: j  reason: collision with root package name */
    private long f26640j;

    /* renamed from: k  reason: collision with root package name */
    private long f26641k;

    /* renamed from: l  reason: collision with root package name */
    private C0163b f26642l;

    private static class a {
        public static Resources a(Resources.Theme theme) {
            return theme.getResources();
        }

        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }
    }

    /* renamed from: d.b$b  reason: collision with other inner class name */
    static class C0163b implements Drawable.Callback {

        /* renamed from: a  reason: collision with root package name */
        private Drawable.Callback f26644a;

        C0163b() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f26644a;
            this.f26644a = null;
            return callback;
        }

        public C0163b a(Drawable.Callback callback) {
            this.f26644a = callback;
            return this;
        }

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            Drawable.Callback callback = this.f26644a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j2);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f26644a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static abstract class c extends Drawable.ConstantState {
        boolean A;
        int B;
        int C = 0;
        int D = 0;
        boolean E;
        ColorFilter F;
        boolean G;
        ColorStateList H;
        PorterDuff.Mode I;
        boolean J;
        boolean K;

        /* renamed from: c  reason: collision with root package name */
        final b f26645c;

        /* renamed from: d  reason: collision with root package name */
        Resources f26646d;

        /* renamed from: e  reason: collision with root package name */
        int f26647e;

        /* renamed from: f  reason: collision with root package name */
        int f26648f;

        /* renamed from: g  reason: collision with root package name */
        int f26649g;

        /* renamed from: h  reason: collision with root package name */
        SparseArray<Drawable.ConstantState> f26650h;

        /* renamed from: i  reason: collision with root package name */
        Drawable[] f26651i;

        /* renamed from: j  reason: collision with root package name */
        int f26652j;

        /* renamed from: k  reason: collision with root package name */
        boolean f26653k = false;

        /* renamed from: l  reason: collision with root package name */
        boolean f26654l;

        /* renamed from: m  reason: collision with root package name */
        Rect f26655m;

        /* renamed from: n  reason: collision with root package name */
        boolean f26656n = false;

        /* renamed from: o  reason: collision with root package name */
        boolean f26657o;

        /* renamed from: p  reason: collision with root package name */
        int f26658p;

        /* renamed from: q  reason: collision with root package name */
        int f26659q;

        /* renamed from: r  reason: collision with root package name */
        int f26660r;

        /* renamed from: s  reason: collision with root package name */
        int f26661s;

        /* renamed from: t  reason: collision with root package name */
        boolean f26662t;

        /* renamed from: u  reason: collision with root package name */
        int f26663u;

        /* renamed from: v  reason: collision with root package name */
        boolean f26664v;

        /* renamed from: w  reason: collision with root package name */
        boolean f26665w;

        /* renamed from: x  reason: collision with root package name */
        boolean f26666x;

        /* renamed from: y  reason: collision with root package name */
        boolean f26667y;

        /* renamed from: z  reason: collision with root package name */
        boolean f26668z = true;

        c(c cVar, b bVar, Resources resources) {
            this.f26645c = bVar;
            Rect rect = null;
            this.f26646d = resources != null ? resources : cVar != null ? cVar.f26646d : null;
            int a2 = b.a(resources, cVar != null ? cVar.f26647e : 0);
            this.f26647e = a2;
            if (cVar != null) {
                this.f26648f = cVar.f26648f;
                this.f26649g = cVar.f26649g;
                this.f26666x = true;
                this.f26667y = true;
                this.f26653k = cVar.f26653k;
                this.f26656n = cVar.f26656n;
                this.f26668z = cVar.f26668z;
                this.A = cVar.A;
                this.B = cVar.B;
                this.C = cVar.C;
                this.D = cVar.D;
                this.E = cVar.E;
                this.F = cVar.F;
                this.G = cVar.G;
                this.H = cVar.H;
                this.I = cVar.I;
                this.J = cVar.J;
                this.K = cVar.K;
                if (cVar.f26647e == a2) {
                    if (cVar.f26654l) {
                        this.f26655m = cVar.f26655m != null ? new Rect(cVar.f26655m) : rect;
                        this.f26654l = true;
                    }
                    if (cVar.f26657o) {
                        this.f26658p = cVar.f26658p;
                        this.f26659q = cVar.f26659q;
                        this.f26660r = cVar.f26660r;
                        this.f26661s = cVar.f26661s;
                        this.f26657o = true;
                    }
                }
                if (cVar.f26662t) {
                    this.f26663u = cVar.f26663u;
                    this.f26662t = true;
                }
                if (cVar.f26664v) {
                    this.f26665w = cVar.f26665w;
                    this.f26664v = true;
                }
                Drawable[] drawableArr = cVar.f26651i;
                this.f26651i = new Drawable[drawableArr.length];
                this.f26652j = cVar.f26652j;
                SparseArray<Drawable.ConstantState> sparseArray = cVar.f26650h;
                this.f26650h = sparseArray != null ? sparseArray.clone() : new SparseArray<>(this.f26652j);
                int i2 = this.f26652j;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null) {
                        Drawable.ConstantState constantState = drawableArr[i3].getConstantState();
                        if (constantState != null) {
                            this.f26650h.put(i3, constantState);
                        } else {
                            this.f26651i[i3] = drawableArr[i3];
                        }
                    }
                }
                return;
            }
            this.f26651i = new Drawable[10];
            this.f26652j = 0;
        }

        private Drawable b(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                androidx.core.graphics.drawable.a.b(drawable, this.B);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f26645c);
            return mutate;
        }

        private void o() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f26650h;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f26651i[this.f26650h.keyAt(i2)] = b(this.f26650h.valueAt(i2).newDrawable(this.f26646d));
                }
                this.f26650h = null;
            }
        }

        public final int a(Drawable drawable) {
            int i2 = this.f26652j;
            if (i2 >= this.f26651i.length) {
                e(i2, i2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f26645c);
            this.f26651i[i2] = drawable;
            this.f26652j++;
            this.f26649g = drawable.getChangingConfigurations() | this.f26649g;
            b();
            this.f26655m = null;
            this.f26654l = false;
            this.f26657o = false;
            this.f26666x = false;
            return i2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i2 = this.f26652j;
            Drawable[] drawableArr = this.f26651i;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3] != null) {
                    drawableArr[i3].mutate();
                }
            }
            this.A = true;
        }

        /* access modifiers changed from: package-private */
        public final void a(Resources.Theme theme) {
            if (theme != null) {
                o();
                int i2 = this.f26652j;
                Drawable[] drawableArr = this.f26651i;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null && androidx.core.graphics.drawable.a.d(drawableArr[i3])) {
                        androidx.core.graphics.drawable.a.a(drawableArr[i3], theme);
                        this.f26649g |= drawableArr[i3].getChangingConfigurations();
                    }
                }
                a(a.a(theme));
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(Resources resources) {
            if (resources != null) {
                this.f26646d = resources;
                int a2 = b.a(resources, this.f26647e);
                int i2 = this.f26647e;
                this.f26647e = a2;
                if (i2 != a2) {
                    this.f26657o = false;
                    this.f26654l = false;
                }
            }
        }

        public final void a(boolean z2) {
            this.f26653k = z2;
        }

        public final Drawable b(int i2) {
            int indexOfKey;
            Drawable drawable = this.f26651i[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f26650h;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable b2 = b(this.f26650h.valueAt(indexOfKey).newDrawable(this.f26646d));
            this.f26651i[i2] = b2;
            this.f26650h.removeAt(indexOfKey);
            if (this.f26650h.size() == 0) {
                this.f26650h = null;
            }
            return b2;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f26662t = false;
            this.f26664v = false;
        }

        public final void b(boolean z2) {
            this.f26656n = z2;
        }

        /* access modifiers changed from: package-private */
        public final int c() {
            return this.f26651i.length;
        }

        public final void c(int i2) {
            this.C = i2;
        }

        public boolean canApplyTheme() {
            int i2 = this.f26652j;
            Drawable[] drawableArr = this.f26651i;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f26650h.get(i3);
                    if (constantState != null && a.a(constantState)) {
                        return true;
                    }
                } else if (androidx.core.graphics.drawable.a.d(drawable)) {
                    return true;
                }
            }
            return false;
        }

        public final int d() {
            return this.f26652j;
        }

        public final void d(int i2) {
            this.D = i2;
        }

        /* access modifiers changed from: package-private */
        public final boolean d(int i2, int i3) {
            int i4 = this.f26652j;
            Drawable[] drawableArr = this.f26651i;
            boolean z2 = false;
            for (int i5 = 0; i5 < i4; i5++) {
                if (drawableArr[i5] != null) {
                    boolean b2 = Build.VERSION.SDK_INT >= 23 ? androidx.core.graphics.drawable.a.b(drawableArr[i5], i2) : false;
                    if (i5 == i3) {
                        z2 = b2;
                    }
                }
            }
            this.B = i2;
            return z2;
        }

        public final Rect e() {
            Rect rect = null;
            if (this.f26653k) {
                return null;
            }
            Rect rect2 = this.f26655m;
            if (rect2 != null || this.f26654l) {
                return rect2;
            }
            o();
            Rect rect3 = new Rect();
            int i2 = this.f26652j;
            Drawable[] drawableArr = this.f26651i;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    if (rect3.left > rect.left) {
                        rect.left = rect3.left;
                    }
                    if (rect3.top > rect.top) {
                        rect.top = rect3.top;
                    }
                    if (rect3.right > rect.right) {
                        rect.right = rect3.right;
                    }
                    if (rect3.bottom > rect.bottom) {
                        rect.bottom = rect3.bottom;
                    }
                }
            }
            this.f26654l = true;
            this.f26655m = rect;
            return rect;
        }

        public void e(int i2, int i3) {
            Drawable[] drawableArr = new Drawable[i3];
            Drawable[] drawableArr2 = this.f26651i;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i2);
            }
            this.f26651i = drawableArr;
        }

        public final boolean f() {
            return this.f26656n;
        }

        public final int g() {
            if (!this.f26657o) {
                k();
            }
            return this.f26658p;
        }

        public int getChangingConfigurations() {
            return this.f26648f | this.f26649g;
        }

        public final int h() {
            if (!this.f26657o) {
                k();
            }
            return this.f26659q;
        }

        public final int i() {
            if (!this.f26657o) {
                k();
            }
            return this.f26660r;
        }

        public final int j() {
            if (!this.f26657o) {
                k();
            }
            return this.f26661s;
        }

        /* access modifiers changed from: protected */
        public void k() {
            this.f26657o = true;
            o();
            int i2 = this.f26652j;
            Drawable[] drawableArr = this.f26651i;
            this.f26659q = -1;
            this.f26658p = -1;
            this.f26661s = 0;
            this.f26660r = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f26658p) {
                    this.f26658p = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f26659q) {
                    this.f26659q = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f26660r) {
                    this.f26660r = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f26661s) {
                    this.f26661s = minimumHeight;
                }
            }
        }

        public final int l() {
            if (this.f26662t) {
                return this.f26663u;
            }
            o();
            int i2 = this.f26652j;
            Drawable[] drawableArr = this.f26651i;
            int opacity = i2 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i3 = 1; i3 < i2; i3++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
            }
            this.f26663u = opacity;
            this.f26662t = true;
            return opacity;
        }

        public final boolean m() {
            if (this.f26664v) {
                return this.f26665w;
            }
            o();
            int i2 = this.f26652j;
            Drawable[] drawableArr = this.f26651i;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                } else if (drawableArr[i3].isStateful()) {
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            this.f26665w = z2;
            this.f26664v = true;
            return z2;
        }

        public boolean n() {
            if (this.f26666x) {
                return this.f26667y;
            }
            o();
            this.f26666x = true;
            int i2 = this.f26652j;
            Drawable[] drawableArr = this.f26651i;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getConstantState() == null) {
                    this.f26667y = false;
                    return false;
                }
            }
            this.f26667y = true;
            return true;
        }
    }

    b() {
    }

    static int a(Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        return i2 == 0 ? GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL : i2;
    }

    private void a(Drawable drawable) {
        if (this.f26642l == null) {
            this.f26642l = new C0163b();
        }
        drawable.setCallback(this.f26642l.a(drawable.getCallback()));
        try {
            if (this.f26631a.C <= 0 && this.f26636f) {
                drawable.setAlpha(this.f26635e);
            }
            if (this.f26631a.G) {
                drawable.setColorFilter(this.f26631a.F);
            } else {
                if (this.f26631a.J) {
                    androidx.core.graphics.drawable.a.a(drawable, this.f26631a.H);
                }
                if (this.f26631a.K) {
                    androidx.core.graphics.drawable.a.a(drawable, this.f26631a.I);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f26631a.f26668z);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                androidx.core.graphics.drawable.a.b(drawable, androidx.core.graphics.drawable.a.i(this));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                androidx.core.graphics.drawable.a.a(drawable, this.f26631a.E);
            }
            Rect rect = this.f26632b;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                androidx.core.graphics.drawable.a.a(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f26642l.a());
        }
    }

    private boolean a() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.i(this) == 1;
    }

    /* access modifiers changed from: package-private */
    public final void a(Resources resources) {
        this.f26631a.a(resources);
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        this.f26631a = cVar;
        int i2 = this.f26637g;
        if (i2 >= 0) {
            Drawable b2 = cVar.b(i2);
            this.f26633c = b2;
            if (b2 != null) {
                a(b2);
            }
        }
        this.f26634d = null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f26636f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f26633c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L_0x0038
            long r9 = r13.f26640j
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x003a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L_0x0020
            int r9 = r13.f26635e
            r3.setAlpha(r9)
            goto L_0x0038
        L_0x0020:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r3 = (int) r9
            d.b$c r9 = r13.f26631a
            int r9 = r9.C
            int r3 = r3 / r9
            android.graphics.drawable.Drawable r9 = r13.f26633c
            int r3 = 255 - r3
            int r10 = r13.f26635e
            int r3 = r3 * r10
            int r3 = r3 / 255
            r9.setAlpha(r3)
            r3 = 1
            goto L_0x003b
        L_0x0038:
            r13.f26640j = r7
        L_0x003a:
            r3 = 0
        L_0x003b:
            android.graphics.drawable.Drawable r9 = r13.f26634d
            if (r9 == 0) goto L_0x0065
            long r10 = r13.f26641k
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x0067
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0050
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f26634d = r0
            goto L_0x0065
        L_0x0050:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            d.b$c r4 = r13.f26631a
            int r4 = r4.D
            int r3 = r3 / r4
            android.graphics.drawable.Drawable r4 = r13.f26634d
            int r5 = r13.f26635e
            int r3 = r3 * r5
            int r3 = r3 / 255
            r4.setAlpha(r3)
            goto L_0x0068
        L_0x0065:
            r13.f26641k = r7
        L_0x0067:
            r0 = r3
        L_0x0068:
            if (r14 == 0) goto L_0x0074
            if (r0 == 0) goto L_0x0074
            java.lang.Runnable r14 = r13.f26639i
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.a(boolean):void");
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        if (i2 == this.f26637g) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f26631a.D > 0) {
            Drawable drawable = this.f26634d;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f26633c;
            if (drawable2 != null) {
                this.f26634d = drawable2;
                this.f26641k = ((long) this.f26631a.D) + uptimeMillis;
            } else {
                this.f26634d = null;
                this.f26641k = 0;
            }
        } else {
            Drawable drawable3 = this.f26633c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i2 < 0 || i2 >= this.f26631a.f26652j) {
            this.f26633c = null;
            this.f26637g = -1;
        } else {
            Drawable b2 = this.f26631a.b(i2);
            this.f26633c = b2;
            this.f26637g = i2;
            if (b2 != null) {
                if (this.f26631a.C > 0) {
                    this.f26640j = uptimeMillis + ((long) this.f26631a.C);
                }
                a(b2);
            }
        }
        if (!(this.f26640j == 0 && this.f26641k == 0)) {
            Runnable runnable = this.f26639i;
            if (runnable == null) {
                this.f26639i = new Runnable() {
                    public void run() {
                        b.this.a(true);
                        b.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(runnable);
            }
            a(true);
        }
        invalidateSelf();
        return true;
    }

    public void applyTheme(Resources.Theme theme) {
        this.f26631a.a(theme);
    }

    /* access modifiers changed from: package-private */
    public c c() {
        return this.f26631a;
    }

    public boolean canApplyTheme() {
        return this.f26631a.canApplyTheme();
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f26637g;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f26633c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f26634d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public int getAlpha() {
        return this.f26635e;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f26631a.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.f26631a.n()) {
            return null;
        }
        this.f26631a.f26648f = getChangingConfigurations();
        return this.f26631a;
    }

    public Drawable getCurrent() {
        return this.f26633c;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f26632b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        if (this.f26631a.f()) {
            return this.f26631a.h();
        }
        Drawable drawable = this.f26633c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        if (this.f26631a.f()) {
            return this.f26631a.g();
        }
        Drawable drawable = this.f26633c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        if (this.f26631a.f()) {
            return this.f26631a.j();
        }
        Drawable drawable = this.f26633c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        if (this.f26631a.f()) {
            return this.f26631a.i();
        }
        Drawable drawable = this.f26633c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.f26633c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f26631a.l();
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.f26633c;
        if (drawable != null) {
            a.a(drawable, outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean z2;
        Rect e2 = this.f26631a.e();
        if (e2 != null) {
            rect.set(e2);
            z2 = (e2.right | ((e2.left | e2.top) | e2.bottom)) != 0;
        } else {
            Drawable drawable = this.f26633c;
            z2 = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (a()) {
            int i2 = rect.left;
            rect.left = rect.right;
            rect.right = i2;
        }
        return z2;
    }

    public void invalidateDrawable(Drawable drawable) {
        c cVar = this.f26631a;
        if (cVar != null) {
            cVar.b();
        }
        if (drawable == this.f26633c && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.f26631a.E;
    }

    public boolean isStateful() {
        return this.f26631a.m();
    }

    public void jumpToCurrentState() {
        boolean z2;
        Drawable drawable = this.f26634d;
        boolean z3 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f26634d = null;
            z2 = true;
        } else {
            z2 = false;
        }
        Drawable drawable2 = this.f26633c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f26636f) {
                this.f26633c.setAlpha(this.f26635e);
            }
        }
        if (this.f26641k != 0) {
            this.f26641k = 0;
            z2 = true;
        }
        if (this.f26640j != 0) {
            this.f26640j = 0;
        } else {
            z3 = z2;
        }
        if (z3) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.f26638h && super.mutate() == this) {
            c c2 = c();
            c2.a();
            a(c2);
            this.f26638h = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f26634d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f26633c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        return this.f26631a.d(i2, d());
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f26634d;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f26633c;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f26634d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f26633c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        if (drawable == this.f26633c && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        if (!this.f26636f || this.f26635e != i2) {
            this.f26636f = true;
            this.f26635e = i2;
            Drawable drawable = this.f26633c;
            if (drawable == null) {
                return;
            }
            if (this.f26640j == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z2) {
        if (this.f26631a.E != z2) {
            this.f26631a.E = z2;
            Drawable drawable = this.f26633c;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.a(drawable, this.f26631a.E);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f26631a.G = true;
        if (this.f26631a.F != colorFilter) {
            this.f26631a.F = colorFilter;
            Drawable drawable = this.f26633c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z2) {
        if (this.f26631a.f26668z != z2) {
            this.f26631a.f26668z = z2;
            Drawable drawable = this.f26633c;
            if (drawable != null) {
                drawable.setDither(this.f26631a.f26668z);
            }
        }
    }

    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f26633c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, f2, f3);
        }
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.f26632b;
        if (rect == null) {
            this.f26632b = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f26633c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, i2, i3, i4, i5);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f26631a.J = true;
        if (this.f26631a.H != colorStateList) {
            this.f26631a.H = colorStateList;
            androidx.core.graphics.drawable.a.a(this.f26633c, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f26631a.K = true;
        if (this.f26631a.I != mode) {
            this.f26631a.I = mode;
            androidx.core.graphics.drawable.a.a(this.f26633c, mode);
        }
    }

    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        Drawable drawable = this.f26634d;
        if (drawable != null) {
            drawable.setVisible(z2, z3);
        }
        Drawable drawable2 = this.f26633c;
        if (drawable2 != null) {
            drawable2.setVisible(z2, z3);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f26633c && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
