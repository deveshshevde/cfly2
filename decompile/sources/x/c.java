package x;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import t.ac;

public class c {

    /* renamed from: v  reason: collision with root package name */
    private static final Interpolator f34605v = new Interpolator() {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f34606a;

    /* renamed from: b  reason: collision with root package name */
    private int f34607b;

    /* renamed from: c  reason: collision with root package name */
    private int f34608c = -1;

    /* renamed from: d  reason: collision with root package name */
    private float[] f34609d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f34610e;

    /* renamed from: f  reason: collision with root package name */
    private float[] f34611f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f34612g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f34613h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f34614i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f34615j;

    /* renamed from: k  reason: collision with root package name */
    private int f34616k;

    /* renamed from: l  reason: collision with root package name */
    private VelocityTracker f34617l;

    /* renamed from: m  reason: collision with root package name */
    private float f34618m;

    /* renamed from: n  reason: collision with root package name */
    private float f34619n;

    /* renamed from: o  reason: collision with root package name */
    private int f34620o;

    /* renamed from: p  reason: collision with root package name */
    private int f34621p;

    /* renamed from: q  reason: collision with root package name */
    private OverScroller f34622q;

    /* renamed from: r  reason: collision with root package name */
    private final a f34623r;

    /* renamed from: s  reason: collision with root package name */
    private View f34624s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f34625t;

    /* renamed from: u  reason: collision with root package name */
    private final ViewGroup f34626u;

    /* renamed from: w  reason: collision with root package name */
    private final Runnable f34627w = new Runnable() {
        public void run() {
            c.this.c(0);
        }
    };

    public static abstract class a {
        public int a(View view) {
            return 0;
        }

        public int a(View view, int i2, int i3) {
            return 0;
        }

        public void a(int i2) {
        }

        public void a(int i2, int i3) {
        }

        public void a(View view, float f2, float f3) {
        }

        public void a(View view, int i2) {
        }

        public void a(View view, int i2, int i3, int i4, int i5) {
        }

        public int b(View view) {
            return 0;
        }

        public int b(View view, int i2, int i3) {
            return 0;
        }

        public void b(int i2, int i3) {
        }

        public boolean b(int i2) {
            return false;
        }

        public abstract boolean b(View view, int i2);

        public int c(int i2) {
            return i2;
        }
    }

    private c(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar != null) {
            this.f34626u = viewGroup;
            this.f34623r = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f34620o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f34607b = viewConfiguration.getScaledTouchSlop();
            this.f34618m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f34619n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f34622q = new OverScroller(context, f34605v);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    private float a(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        return abs > f4 ? f2 > 0.0f ? f4 : -f4 : f2;
    }

    private int a(int i2, int i3, int i4) {
        if (i2 == 0) {
            return 0;
        }
        int width = this.f34626u.getWidth();
        float f2 = (float) (width / 2);
        float b2 = f2 + (b(Math.min(1.0f, ((float) Math.abs(i2)) / ((float) width))) * f2);
        int abs = Math.abs(i3);
        return Math.min(abs > 0 ? Math.round(Math.abs(b2 / ((float) abs)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i2)) / ((float) i4)) + 1.0f) * 256.0f), 600);
    }

    private int a(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int b2 = b(i4, (int) this.f34619n, (int) this.f34618m);
        int b3 = b(i5, (int) this.f34619n, (int) this.f34618m);
        int abs = Math.abs(i2);
        int abs2 = Math.abs(i3);
        int abs3 = Math.abs(b2);
        int abs4 = Math.abs(b3);
        int i6 = abs3 + abs4;
        int i7 = abs + abs2;
        if (b2 != 0) {
            f3 = (float) abs3;
            f2 = (float) i6;
        } else {
            f3 = (float) abs;
            f2 = (float) i7;
        }
        float f6 = f3 / f2;
        if (b3 != 0) {
            f5 = (float) abs4;
            f4 = (float) i6;
        } else {
            f5 = (float) abs2;
            f4 = (float) i7;
        }
        float f7 = f5 / f4;
        return (int) ((((float) a(i2, b2, this.f34623r.a(view))) * f6) + (((float) a(i3, b3, this.f34623r.b(view))) * f7));
    }

    public static c a(ViewGroup viewGroup, float f2, a aVar) {
        c a2 = a(viewGroup, aVar);
        a2.f34607b = (int) (((float) a2.f34607b) * (1.0f / f2));
        return a2;
    }

    public static c a(ViewGroup viewGroup, a aVar) {
        return new c(viewGroup.getContext(), viewGroup, aVar);
    }

    private void a(float f2, float f3) {
        this.f34625t = true;
        this.f34623r.a(this.f34624s, f2, f3);
        this.f34625t = false;
        if (this.f34606a == 1) {
            c(0);
        }
    }

    private void a(float f2, float f3, int i2) {
        f(i2);
        float[] fArr = this.f34609d;
        this.f34611f[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.f34610e;
        this.f34612g[i2] = f3;
        fArr2[i2] = f3;
        this.f34613h[i2] = e((int) f2, (int) f3);
        this.f34616k |= 1 << i2;
    }

    private boolean a(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.f34613h[i2] & i3) != i3 || (this.f34621p & i3) == 0 || (this.f34615j[i2] & i3) == i3 || (this.f34614i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.f34607b;
        if (abs <= ((float) i4) && abs2 <= ((float) i4)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f34623r.b(i3)) {
            return (this.f34614i[i2] & i3) == 0 && abs > ((float) this.f34607b);
        }
        int[] iArr = this.f34615j;
        iArr[i2] = iArr[i2] | i3;
        return false;
    }

    private boolean a(int i2, int i3, int i4, int i5) {
        int left = this.f34624s.getLeft();
        int top = this.f34624s.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.f34622q.abortAnimation();
            c(0);
            return false;
        }
        this.f34622q.startScroll(left, top, i6, i7, a(this.f34624s, i6, i7, i4, i5));
        c(2);
        return true;
    }

    private boolean a(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z2 = this.f34623r.a(view) > 0;
        boolean z3 = this.f34623r.b(view) > 0;
        if (!z2 || !z3) {
            return z2 ? Math.abs(f2) > ((float) this.f34607b) : z3 && Math.abs(f3) > ((float) this.f34607b);
        }
        int i2 = this.f34607b;
        return (f2 * f2) + (f3 * f3) > ((float) (i2 * i2));
    }

    private float b(float f2) {
        return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
    }

    private int b(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        return abs > i4 ? i2 > 0 ? i4 : -i4 : i2;
    }

    private void b(float f2, float f3, int i2) {
        int i3 = 1;
        if (!a(f2, f3, i2, 1)) {
            i3 = 0;
        }
        if (a(f3, f2, i2, 4)) {
            i3 |= 4;
        }
        if (a(f2, f3, i2, 2)) {
            i3 |= 2;
        }
        if (a(f3, f2, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.f34614i;
            iArr[i2] = iArr[i2] | i3;
            this.f34623r.b(i3, i2);
        }
    }

    private void b(int i2, int i3, int i4, int i5) {
        int left = this.f34624s.getLeft();
        int top = this.f34624s.getTop();
        if (i4 != 0) {
            i2 = this.f34623r.a(this.f34624s, i2, i4);
            ac.f(this.f34624s, i2 - left);
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.f34623r.b(this.f34624s, i3, i5);
            ac.e(this.f34624s, i3 - top);
        }
        int i7 = i3;
        if (i4 != 0 || i5 != 0) {
            this.f34623r.a(this.f34624s, i6, i7, i6 - left, i7 - top);
        }
    }

    private void c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (g(pointerId)) {
                float x2 = motionEvent.getX(i2);
                float y2 = motionEvent.getY(i2);
                this.f34611f[pointerId] = x2;
                this.f34612g[pointerId] = y2;
            }
        }
    }

    private int e(int i2, int i3) {
        int i4 = i2 < this.f34626u.getLeft() + this.f34620o ? 1 : 0;
        if (i3 < this.f34626u.getTop() + this.f34620o) {
            i4 |= 4;
        }
        if (i2 > this.f34626u.getRight() - this.f34620o) {
            i4 |= 2;
        }
        return i3 > this.f34626u.getBottom() - this.f34620o ? i4 | 8 : i4;
    }

    private void e(int i2) {
        if (this.f34609d != null && b(i2)) {
            this.f34609d[i2] = 0.0f;
            this.f34610e[i2] = 0.0f;
            this.f34611f[i2] = 0.0f;
            this.f34612g[i2] = 0.0f;
            this.f34613h[i2] = 0;
            this.f34614i[i2] = 0;
            this.f34615j[i2] = 0;
            this.f34616k = ((1 << i2) ^ -1) & this.f34616k;
        }
    }

    private void f(int i2) {
        float[] fArr = this.f34609d;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f34610e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f34611f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f34612g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f34613h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f34614i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f34615j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f34609d = fArr2;
            this.f34610e = fArr3;
            this.f34611f = fArr4;
            this.f34612g = fArr5;
            this.f34613h = iArr;
            this.f34614i = iArr2;
            this.f34615j = iArr3;
        }
    }

    private void g() {
        float[] fArr = this.f34609d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f34610e, 0.0f);
            Arrays.fill(this.f34611f, 0.0f);
            Arrays.fill(this.f34612g, 0.0f);
            Arrays.fill(this.f34613h, 0);
            Arrays.fill(this.f34614i, 0);
            Arrays.fill(this.f34615j, 0);
            this.f34616k = 0;
        }
    }

    private boolean g(int i2) {
        if (b(i2)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i2 + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void h() {
        this.f34617l.computeCurrentVelocity(1000, this.f34618m);
        a(a(this.f34617l.getXVelocity(this.f34608c), this.f34619n, this.f34618m), a(this.f34617l.getYVelocity(this.f34608c), this.f34619n, this.f34618m));
    }

    public int a() {
        return this.f34606a;
    }

    public void a(float f2) {
        this.f34619n = f2;
    }

    public void a(int i2) {
        this.f34621p = i2;
    }

    public void a(View view, int i2) {
        if (view.getParent() == this.f34626u) {
            this.f34624s = view;
            this.f34608c = i2;
            this.f34623r.a(view, i2);
            c(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f34626u + ")");
    }

    public boolean a(int i2, int i3) {
        if (this.f34625t) {
            return a(i2, i3, (int) this.f34617l.getXVelocity(this.f34608c), (int) this.f34617l.getYVelocity(this.f34608c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r12 != r11) goto L_0x00e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r17.getActionMasked()
            int r3 = r17.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r16.e()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.f34617l
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f34617l = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.f34617l
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0104
            if (r2 == r6) goto L_0x00ff
            if (r2 == r4) goto L_0x0070
            r7 = 3
            if (r2 == r7) goto L_0x00ff
            r7 = 5
            if (r2 == r7) goto L_0x003c
            r4 = 6
            if (r2 == r4) goto L_0x0034
        L_0x0031:
            r5 = 0
            goto L_0x0135
        L_0x0034:
            int r1 = r1.getPointerId(r3)
            r0.e(r1)
            goto L_0x0031
        L_0x003c:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.a((float) r7, (float) r1, (int) r2)
            int r3 = r0.f34606a
            if (r3 != 0) goto L_0x0060
            int[] r1 = r0.f34613h
            r1 = r1[r2]
            int r3 = r0.f34621p
            r4 = r1 & r3
            if (r4 == 0) goto L_0x0031
            x.c$a r4 = r0.f34623r
            r1 = r1 & r3
            r4.a((int) r1, (int) r2)
            goto L_0x0031
        L_0x0060:
            if (r3 != r4) goto L_0x0031
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.d(r3, r1)
            android.view.View r3 = r0.f34624s
            if (r1 != r3) goto L_0x0031
            r0.b((android.view.View) r1, (int) r2)
            goto L_0x0031
        L_0x0070:
            float[] r2 = r0.f34609d
            if (r2 == 0) goto L_0x0031
            float[] r2 = r0.f34610e
            if (r2 != 0) goto L_0x0079
            goto L_0x0031
        L_0x0079:
            int r2 = r17.getPointerCount()
            r3 = 0
        L_0x007e:
            if (r3 >= r2) goto L_0x00fa
            int r4 = r1.getPointerId(r3)
            boolean r7 = r0.g(r4)
            if (r7 != 0) goto L_0x008c
            goto L_0x00f7
        L_0x008c:
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.f34609d
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.f34610e
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.d(r7, r8)
            if (r7 == 0) goto L_0x00b0
            boolean r8 = r0.a((android.view.View) r7, (float) r9, (float) r10)
            if (r8 == 0) goto L_0x00b0
            r8 = 1
            goto L_0x00b1
        L_0x00b0:
            r8 = 0
        L_0x00b1:
            if (r8 == 0) goto L_0x00e6
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r13 = r11 + r12
            x.c$a r14 = r0.f34623r
            int r12 = r14.a((android.view.View) r7, (int) r13, (int) r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r15 = r13 + r14
            x.c$a r5 = r0.f34623r
            int r5 = r5.b(r7, r15, r14)
            x.c$a r14 = r0.f34623r
            int r14 = r14.a((android.view.View) r7)
            x.c$a r15 = r0.f34623r
            int r15 = r15.b((android.view.View) r7)
            if (r14 == 0) goto L_0x00df
            if (r14 <= 0) goto L_0x00e6
            if (r12 != r11) goto L_0x00e6
        L_0x00df:
            if (r15 == 0) goto L_0x00fa
            if (r15 <= 0) goto L_0x00e6
            if (r5 != r13) goto L_0x00e6
            goto L_0x00fa
        L_0x00e6:
            r0.b((float) r9, (float) r10, (int) r4)
            int r5 = r0.f34606a
            if (r5 != r6) goto L_0x00ee
            goto L_0x00fa
        L_0x00ee:
            if (r8 == 0) goto L_0x00f7
            boolean r4 = r0.b((android.view.View) r7, (int) r4)
            if (r4 == 0) goto L_0x00f7
            goto L_0x00fa
        L_0x00f7:
            int r3 = r3 + 1
            goto L_0x007e
        L_0x00fa:
            r16.c((android.view.MotionEvent) r17)
            goto L_0x0031
        L_0x00ff:
            r16.e()
            goto L_0x0031
        L_0x0104:
            float r2 = r17.getX()
            float r3 = r17.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.a((float) r2, (float) r3, (int) r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.d(r2, r3)
            android.view.View r3 = r0.f34624s
            if (r2 != r3) goto L_0x0125
            int r3 = r0.f34606a
            if (r3 != r4) goto L_0x0125
            r0.b((android.view.View) r2, (int) r1)
        L_0x0125:
            int[] r2 = r0.f34613h
            r2 = r2[r1]
            int r3 = r0.f34621p
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0135
            x.c$a r4 = r0.f34623r
            r2 = r2 & r3
            r4.a((int) r2, (int) r1)
        L_0x0135:
            int r1 = r0.f34606a
            if (r1 != r6) goto L_0x013a
            r5 = 1
        L_0x013a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: x.c.a(android.view.MotionEvent):boolean");
    }

    public boolean a(View view, int i2, int i3) {
        this.f34624s = view;
        this.f34608c = -1;
        boolean a2 = a(i2, i3, 0, 0);
        if (!a2 && this.f34606a == 0 && this.f34624s != null) {
            this.f34624s = null;
        }
        return a2;
    }

    public boolean a(boolean z2) {
        if (this.f34606a == 2) {
            boolean computeScrollOffset = this.f34622q.computeScrollOffset();
            int currX = this.f34622q.getCurrX();
            int currY = this.f34622q.getCurrY();
            int left = currX - this.f34624s.getLeft();
            int top = currY - this.f34624s.getTop();
            if (left != 0) {
                ac.f(this.f34624s, left);
            }
            if (top != 0) {
                ac.e(this.f34624s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f34623r.a(this.f34624s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f34622q.getFinalX() && currY == this.f34622q.getFinalY()) {
                this.f34622q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z2) {
                    this.f34626u.post(this.f34627w);
                } else {
                    c(0);
                }
            }
        }
        return this.f34606a == 2;
    }

    public int b() {
        return this.f34620o;
    }

    public void b(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            e();
        }
        if (this.f34617l == null) {
            this.f34617l = VelocityTracker.obtain();
        }
        this.f34617l.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f34606a != 1) {
                        int pointerCount = motionEvent.getPointerCount();
                        while (i3 < pointerCount) {
                            int pointerId = motionEvent.getPointerId(i3);
                            if (g(pointerId)) {
                                float x2 = motionEvent.getX(i3);
                                float y2 = motionEvent.getY(i3);
                                float f2 = x2 - this.f34609d[pointerId];
                                float f3 = y2 - this.f34610e[pointerId];
                                b(f2, f3, pointerId);
                                if (this.f34606a != 1) {
                                    View d2 = d((int) x2, (int) y2);
                                    if (a(d2, f2, f3) && b(d2, pointerId)) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            i3++;
                        }
                    } else if (g(this.f34608c)) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f34608c);
                        float x3 = motionEvent.getX(findPointerIndex);
                        float y3 = motionEvent.getY(findPointerIndex);
                        float[] fArr = this.f34611f;
                        int i4 = this.f34608c;
                        int i5 = (int) (x3 - fArr[i4]);
                        int i6 = (int) (y3 - this.f34612g[i4]);
                        b(this.f34624s.getLeft() + i5, this.f34624s.getTop() + i6, i5, i6);
                    } else {
                        return;
                    }
                    c(motionEvent);
                    return;
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int pointerId2 = motionEvent.getPointerId(actionIndex);
                        float x4 = motionEvent.getX(actionIndex);
                        float y4 = motionEvent.getY(actionIndex);
                        a(x4, y4, pointerId2);
                        if (this.f34606a == 0) {
                            b(d((int) x4, (int) y4), pointerId2);
                            int i7 = this.f34613h[pointerId2];
                            int i8 = this.f34621p;
                            if ((i7 & i8) != 0) {
                                this.f34623r.a(i7 & i8, pointerId2);
                                return;
                            }
                            return;
                        } else if (c((int) x4, (int) y4)) {
                            b(this.f34624s, pointerId2);
                            return;
                        } else {
                            return;
                        }
                    } else if (actionMasked == 6) {
                        int pointerId3 = motionEvent.getPointerId(actionIndex);
                        if (this.f34606a == 1 && pointerId3 == this.f34608c) {
                            int pointerCount2 = motionEvent.getPointerCount();
                            while (true) {
                                if (i3 >= pointerCount2) {
                                    i2 = -1;
                                    break;
                                }
                                int pointerId4 = motionEvent.getPointerId(i3);
                                if (pointerId4 != this.f34608c) {
                                    View d3 = d((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                                    View view = this.f34624s;
                                    if (d3 == view && b(view, pointerId4)) {
                                        i2 = this.f34608c;
                                        break;
                                    }
                                }
                                i3++;
                            }
                            if (i2 == -1) {
                                h();
                            }
                        }
                        e(pointerId3);
                        return;
                    } else {
                        return;
                    }
                } else if (this.f34606a == 1) {
                    a(0.0f, 0.0f);
                }
            } else if (this.f34606a == 1) {
                h();
            }
            e();
            return;
        }
        float x5 = motionEvent.getX();
        float y5 = motionEvent.getY();
        int pointerId5 = motionEvent.getPointerId(0);
        View d4 = d((int) x5, (int) y5);
        a(x5, y5, pointerId5);
        b(d4, pointerId5);
        int i9 = this.f34613h[pointerId5];
        int i10 = this.f34621p;
        if ((i9 & i10) != 0) {
            this.f34623r.a(i9 & i10, pointerId5);
        }
    }

    public boolean b(int i2) {
        return ((1 << i2) & this.f34616k) != 0;
    }

    public boolean b(int i2, int i3) {
        if (!b(i3)) {
            return false;
        }
        boolean z2 = (i2 & 1) == 1;
        boolean z3 = (i2 & 2) == 2;
        float f2 = this.f34611f[i3] - this.f34609d[i3];
        float f3 = this.f34612g[i3] - this.f34610e[i3];
        if (!z2 || !z3) {
            return z2 ? Math.abs(f2) > ((float) this.f34607b) : z3 && Math.abs(f3) > ((float) this.f34607b);
        }
        int i4 = this.f34607b;
        return (f2 * f2) + (f3 * f3) > ((float) (i4 * i4));
    }

    /* access modifiers changed from: package-private */
    public boolean b(View view, int i2) {
        if (view == this.f34624s && this.f34608c == i2) {
            return true;
        }
        if (view == null || !this.f34623r.b(view, i2)) {
            return false;
        }
        this.f34608c = i2;
        a(view, i2);
        return true;
    }

    public boolean b(View view, int i2, int i3) {
        return view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom();
    }

    public View c() {
        return this.f34624s;
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        this.f34626u.removeCallbacks(this.f34627w);
        if (this.f34606a != i2) {
            this.f34606a = i2;
            this.f34623r.a(i2);
            if (this.f34606a == 0) {
                this.f34624s = null;
            }
        }
    }

    public boolean c(int i2, int i3) {
        return b(this.f34624s, i2, i3);
    }

    public int d() {
        return this.f34607b;
    }

    public View d(int i2, int i3) {
        for (int childCount = this.f34626u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f34626u.getChildAt(this.f34623r.c(childCount));
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public boolean d(int i2) {
        int length = this.f34609d.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (b(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public void e() {
        this.f34608c = -1;
        g();
        VelocityTracker velocityTracker = this.f34617l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f34617l = null;
        }
    }

    public void f() {
        e();
        if (this.f34606a == 2) {
            int currX = this.f34622q.getCurrX();
            int currY = this.f34622q.getCurrY();
            this.f34622q.abortAnimation();
            int currX2 = this.f34622q.getCurrX();
            int currY2 = this.f34622q.getCurrY();
            this.f34623r.a(this.f34624s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        c(0);
    }
}
