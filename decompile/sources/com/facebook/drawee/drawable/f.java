package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import df.c;
import java.util.Arrays;

public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    int f11172a;

    /* renamed from: b  reason: collision with root package name */
    int f11173b;

    /* renamed from: c  reason: collision with root package name */
    long f11174c;

    /* renamed from: d  reason: collision with root package name */
    int[] f11175d;

    /* renamed from: e  reason: collision with root package name */
    int[] f11176e;

    /* renamed from: f  reason: collision with root package name */
    int f11177f;

    /* renamed from: g  reason: collision with root package name */
    boolean[] f11178g;

    /* renamed from: h  reason: collision with root package name */
    int f11179h;

    /* renamed from: i  reason: collision with root package name */
    private final Drawable[] f11180i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f11181j;

    /* renamed from: k  reason: collision with root package name */
    private final int f11182k;

    public f(Drawable[] drawableArr) {
        this(drawableArr, false);
    }

    public f(Drawable[] drawableArr, boolean z2) {
        super(drawableArr);
        int i2 = 0;
        c.b(drawableArr.length < 1 ? false : true, "At least one layer required!");
        this.f11180i = drawableArr;
        this.f11175d = new int[drawableArr.length];
        this.f11176e = new int[drawableArr.length];
        this.f11177f = 255;
        this.f11178g = new boolean[drawableArr.length];
        this.f11179h = 0;
        this.f11181j = z2;
        this.f11182k = z2 ? 255 : i2;
        f();
    }

    private void a(Canvas canvas, Drawable drawable, int i2) {
        if (drawable != null && i2 > 0) {
            this.f11179h++;
            drawable.mutate().setAlpha(i2);
            this.f11179h--;
            drawable.draw(canvas);
        }
    }

    private boolean a(float f2) {
        boolean z2 = true;
        for (int i2 = 0; i2 < this.f11180i.length; i2++) {
            boolean[] zArr = this.f11178g;
            int i3 = zArr[i2] ? 1 : -1;
            int[] iArr = this.f11176e;
            iArr[i2] = (int) (((float) this.f11175d[i2]) + (((float) (i3 * 255)) * f2));
            if (iArr[i2] < 0) {
                iArr[i2] = 0;
            }
            if (iArr[i2] > 255) {
                iArr[i2] = 255;
            }
            if (zArr[i2] && iArr[i2] < 255) {
                z2 = false;
            }
            if (!zArr[i2] && iArr[i2] > 0) {
                z2 = false;
            }
        }
        return z2;
    }

    private void f() {
        this.f11172a = 2;
        Arrays.fill(this.f11175d, this.f11182k);
        this.f11175d[0] = 255;
        Arrays.fill(this.f11176e, this.f11182k);
        this.f11176e[0] = 255;
        Arrays.fill(this.f11178g, this.f11181j);
        this.f11178g[0] = true;
    }

    public void a() {
        this.f11179h++;
    }

    public void b() {
        this.f11179h--;
        invalidateSelf();
    }

    public void b(int i2) {
        this.f11173b = i2;
        if (this.f11172a == 1) {
            this.f11172a = 0;
        }
    }

    public void c() {
        this.f11172a = 0;
        Arrays.fill(this.f11178g, true);
        invalidateSelf();
    }

    public void c(int i2) {
        this.f11172a = 0;
        this.f11178g[i2] = true;
        invalidateSelf();
    }

    public void d() {
        this.f11172a = 2;
        for (int i2 = 0; i2 < this.f11180i.length; i2++) {
            this.f11176e[i2] = this.f11178g[i2] ? 255 : 0;
        }
        invalidateSelf();
    }

    public void d(int i2) {
        this.f11172a = 0;
        this.f11178g[i2] = false;
        invalidateSelf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        if (r0 != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (r0 != false) goto L_0x0047;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f A[LOOP:0: B:17:0x004a->B:19:0x004f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0061 A[EDGE_INSN: B:22:0x0061->B:20:0x0061 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r9) {
        /*
            r8 = this;
            int r0 = r8.f11172a
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0027
            if (r0 == r3) goto L_0x000a
            goto L_0x004a
        L_0x000a:
            int r0 = r8.f11173b
            if (r0 <= 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            df.c.b(r0)
            long r4 = r8.e()
            long r6 = r8.f11174c
            long r4 = r4 - r6
            float r0 = (float) r4
            int r4 = r8.f11173b
            float r4 = (float) r4
            float r0 = r0 / r4
            boolean r0 = r8.a(r0)
            if (r0 == 0) goto L_0x0046
            goto L_0x0047
        L_0x0027:
            int[] r0 = r8.f11176e
            int[] r4 = r8.f11175d
            android.graphics.drawable.Drawable[] r5 = r8.f11180i
            int r5 = r5.length
            java.lang.System.arraycopy(r0, r2, r4, r2, r5)
            long r4 = r8.e()
            r8.f11174c = r4
            int r0 = r8.f11173b
            if (r0 != 0) goto L_0x003e
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x003f
        L_0x003e:
            r0 = 0
        L_0x003f:
            boolean r0 = r8.a(r0)
            if (r0 == 0) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            r1 = 1
        L_0x0047:
            r8.f11172a = r1
            r3 = r0
        L_0x004a:
            android.graphics.drawable.Drawable[] r0 = r8.f11180i
            int r1 = r0.length
            if (r2 >= r1) goto L_0x0061
            r0 = r0[r2]
            int[] r1 = r8.f11176e
            r1 = r1[r2]
            int r4 = r8.f11177f
            int r1 = r1 * r4
            int r1 = r1 / 255
            r8.a(r9, r0, r1)
            int r2 = r2 + 1
            goto L_0x004a
        L_0x0061:
            if (r3 != 0) goto L_0x0066
            r8.invalidateSelf()
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.drawable.f.draw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public long e() {
        return SystemClock.uptimeMillis();
    }

    public int getAlpha() {
        return this.f11177f;
    }

    public void invalidateSelf() {
        if (this.f11179h == 0) {
            super.invalidateSelf();
        }
    }

    public void setAlpha(int i2) {
        if (this.f11177f != i2) {
            this.f11177f = i2;
            invalidateSelf();
        }
    }
}
