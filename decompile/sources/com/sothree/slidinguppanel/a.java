package com.sothree.slidinguppanel;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.widget.i;
import java.util.Arrays;
import t.ab;
import t.l;

public class a {

    /* renamed from: v  reason: collision with root package name */
    private static final Interpolator f21731v = new Interpolator() {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f21732a;

    /* renamed from: b  reason: collision with root package name */
    private int f21733b;

    /* renamed from: c  reason: collision with root package name */
    private int f21734c = -1;

    /* renamed from: d  reason: collision with root package name */
    private float[] f21735d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f21736e;

    /* renamed from: f  reason: collision with root package name */
    private float[] f21737f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f21738g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f21739h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f21740i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f21741j;

    /* renamed from: k  reason: collision with root package name */
    private int f21742k;

    /* renamed from: l  reason: collision with root package name */
    private VelocityTracker f21743l;

    /* renamed from: m  reason: collision with root package name */
    private float f21744m;

    /* renamed from: n  reason: collision with root package name */
    private float f21745n;

    /* renamed from: o  reason: collision with root package name */
    private int f21746o;

    /* renamed from: p  reason: collision with root package name */
    private int f21747p;

    /* renamed from: q  reason: collision with root package name */
    private i f21748q;

    /* renamed from: r  reason: collision with root package name */
    private final C0142a f21749r;

    /* renamed from: s  reason: collision with root package name */
    private View f21750s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f21751t;

    /* renamed from: u  reason: collision with root package name */
    private final ViewGroup f21752u;

    /* renamed from: w  reason: collision with root package name */
    private final Runnable f21753w = new Runnable() {
        public void run() {
            a.this.a(0);
        }
    };

    /* renamed from: com.sothree.slidinguppanel.a$a  reason: collision with other inner class name */
    public static abstract class C0142a {
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

        public void a(View view, int i2, int i3, int i4, int i5) {
        }

        public abstract boolean a(View view, int i2);

        public int b(View view) {
            return 0;
        }

        public int b(View view, int i2, int i3) {
            return 0;
        }

        public void b(int i2, int i3) {
        }

        public void b(View view, int i2) {
        }

        public boolean b(int i2) {
            return false;
        }

        public int c(int i2) {
            return i2;
        }
    }

    private a(Context context, ViewGroup viewGroup, C0142a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar != null) {
            this.f21752u = viewGroup;
            this.f21749r = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f21746o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f21733b = viewConfiguration.getScaledTouchSlop();
            this.f21744m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f21745n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f21748q = i.a(context, f21731v);
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
        int width = this.f21752u.getWidth();
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
        int b2 = b(i4, (int) this.f21745n, (int) this.f21744m);
        int b3 = b(i5, (int) this.f21745n, (int) this.f21744m);
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
        return (int) ((((float) a(i2, b2, this.f21749r.b(view))) * f6) + (((float) a(i3, b3, this.f21749r.a(view))) * f7));
    }

    public static a a(ViewGroup viewGroup, float f2, C0142a aVar) {
        a a2 = a(viewGroup, aVar);
        a2.f21733b = (int) (((float) a2.f21733b) * (1.0f / f2));
        return a2;
    }

    public static a a(ViewGroup viewGroup, C0142a aVar) {
        return new a(viewGroup.getContext(), viewGroup, aVar);
    }

    private void a(float f2, float f3) {
        this.f21751t = true;
        this.f21749r.a(this.f21750s, f2, f3);
        this.f21751t = false;
        if (this.f21732a == 1) {
            a(0);
        }
    }

    private void a(float f2, float f3, int i2) {
        c(i2);
        float[] fArr = this.f21735d;
        this.f21737f[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.f21736e;
        this.f21738g[i2] = f3;
        fArr2[i2] = f3;
        this.f21739h[i2] = d((int) f2, (int) f3);
        this.f21742k |= 1 << i2;
    }

    private boolean a(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.f21739h[i2] & i3) != i3 || (this.f21747p & i3) == 0 || (this.f21741j[i2] & i3) == i3 || (this.f21740i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.f21733b;
        if (abs <= ((float) i4) && abs2 <= ((float) i4)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f21749r.b(i3)) {
            return (this.f21740i[i2] & i3) == 0 && abs > ((float) this.f21733b);
        }
        int[] iArr = this.f21741j;
        iArr[i2] = iArr[i2] | i3;
        return false;
    }

    private boolean a(int i2, int i3, int i4, int i5) {
        int left = this.f21750s.getLeft();
        int top = this.f21750s.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.f21748q.g();
            a(0);
            return false;
        }
        this.f21748q.a(left, top, i6, i7, a(this.f21750s, i6, i7, i4, i5));
        a(2);
        return true;
    }

    private boolean a(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z2 = this.f21749r.b(view) > 0;
        boolean z3 = this.f21749r.a(view) > 0;
        if (!z2 || !z3) {
            return z2 ? Math.abs(f2) > ((float) this.f21733b) : z3 && Math.abs(f3) > ((float) this.f21733b);
        }
        int i2 = this.f21733b;
        return (f2 * f2) + (f3 * f3) > ((float) (i2 * i2));
    }

    private float b(float f2) {
        double d2 = (double) (f2 - 0.5f);
        Double.isNaN(d2);
        return (float) Math.sin((double) ((float) (d2 * 0.4712389167638204d)));
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
            int[] iArr = this.f21740i;
            iArr[i2] = iArr[i2] | i3;
            this.f21749r.b(i3, i2);
        }
    }

    private void b(int i2) {
        float[] fArr = this.f21735d;
        if (fArr != null) {
            fArr[i2] = 0.0f;
            this.f21736e[i2] = 0.0f;
            this.f21737f[i2] = 0.0f;
            this.f21738g[i2] = 0.0f;
            this.f21739h[i2] = 0;
            this.f21740i[i2] = 0;
            this.f21741j[i2] = 0;
            this.f21742k = ((1 << i2) ^ -1) & this.f21742k;
        }
    }

    private void b(int i2, int i3, int i4, int i5) {
        int left = this.f21750s.getLeft();
        int top = this.f21750s.getTop();
        if (i4 != 0) {
            i2 = this.f21749r.b(this.f21750s, i2, i4);
            this.f21750s.offsetLeftAndRight(i2 - left);
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.f21749r.a(this.f21750s, i3, i5);
            this.f21750s.offsetTopAndBottom(i3 - top);
        }
        int i7 = i3;
        if (i4 != 0 || i5 != 0) {
            this.f21749r.a(this.f21750s, i6, i7, i6 - left, i7 - top);
        }
    }

    private void c(int i2) {
        float[] fArr = this.f21735d;
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
                float[] fArr6 = this.f21736e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f21737f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f21738g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f21739h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f21740i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f21741j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f21735d = fArr2;
            this.f21736e = fArr3;
            this.f21737f = fArr4;
            this.f21738g = fArr5;
            this.f21739h = iArr;
            this.f21740i = iArr2;
            this.f21741j = iArr3;
        }
    }

    private void c(MotionEvent motionEvent) {
        int c2 = l.c(motionEvent);
        for (int i2 = 0; i2 < c2; i2++) {
            int b2 = l.b(motionEvent, i2);
            float c3 = l.c(motionEvent, i2);
            float d2 = l.d(motionEvent, i2);
            this.f21737f[b2] = c3;
            this.f21738g[b2] = d2;
        }
    }

    private int d(int i2, int i3) {
        int i4 = i2 < this.f21752u.getLeft() + this.f21746o ? 1 : 0;
        if (i3 < this.f21752u.getTop() + this.f21746o) {
            i4 |= 4;
        }
        if (i2 > this.f21752u.getRight() - this.f21746o) {
            i4 |= 2;
        }
        return i3 > this.f21752u.getBottom() - this.f21746o ? i4 | 8 : i4;
    }

    private void e() {
        float[] fArr = this.f21735d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f21736e, 0.0f);
            Arrays.fill(this.f21737f, 0.0f);
            Arrays.fill(this.f21738g, 0.0f);
            Arrays.fill(this.f21739h, 0);
            Arrays.fill(this.f21740i, 0);
            Arrays.fill(this.f21741j, 0);
            this.f21742k = 0;
        }
    }

    private void f() {
        this.f21743l.computeCurrentVelocity(1000, this.f21744m);
        a(a(ab.a(this.f21743l, this.f21734c), this.f21745n, this.f21744m), a(ab.b(this.f21743l, this.f21734c), this.f21745n, this.f21744m));
    }

    public int a() {
        return this.f21732a;
    }

    public void a(float f2) {
        this.f21745n = f2;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.f21732a != i2) {
            this.f21732a = i2;
            this.f21749r.a(i2);
            if (i2 == 0) {
                this.f21750s = null;
            }
        }
    }

    public void a(View view, int i2) {
        if (view.getParent() == this.f21752u) {
            this.f21750s = view;
            this.f21734c = i2;
            this.f21749r.b(view, i2);
            a(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f21752u + ")");
    }

    public boolean a(int i2, int i3) {
        if (this.f21751t) {
            return a(i2, i3, (int) ab.a(this.f21743l, this.f21734c), (int) ab.b(this.f21743l, this.f21734c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean a(MotionEvent motionEvent) {
        View c2;
        View c3;
        int a2 = l.a(motionEvent);
        int b2 = l.b(motionEvent);
        if (a2 == 0) {
            c();
        }
        if (this.f21743l == null) {
            this.f21743l = VelocityTracker.obtain();
        }
        this.f21743l.addMovement(motionEvent);
        if (a2 != 0) {
            if (a2 != 1) {
                if (a2 == 2) {
                    int c4 = l.c(motionEvent);
                    for (int i2 = 0; i2 < c4 && this.f21735d != null && this.f21736e != null; i2++) {
                        int b3 = l.b(motionEvent, i2);
                        float c5 = l.c(motionEvent, i2);
                        float d2 = l.d(motionEvent, i2);
                        float f2 = c5 - this.f21735d[b3];
                        float f3 = d2 - this.f21736e[b3];
                        b(f2, f3, b3);
                        if (this.f21732a == 1 || ((c2 = c((int) this.f21735d[b3], (int) this.f21736e[b3])) != null && a(c2, f2, f3) && b(c2, b3))) {
                            break;
                        }
                    }
                    c(motionEvent);
                } else if (a2 != 3) {
                    if (a2 == 5) {
                        int b4 = l.b(motionEvent, b2);
                        float c6 = l.c(motionEvent, b2);
                        float d3 = l.d(motionEvent, b2);
                        a(c6, d3, b4);
                        int i3 = this.f21732a;
                        if (i3 == 0) {
                            int i4 = this.f21739h[b4];
                            int i5 = this.f21747p;
                            if ((i4 & i5) != 0) {
                                this.f21749r.a(i4 & i5, b4);
                            }
                        } else if (i3 == 2 && (c3 = c((int) c6, (int) d3)) == this.f21750s) {
                            b(c3, b4);
                        }
                    } else if (a2 == 6) {
                        b(l.b(motionEvent, b2));
                    }
                }
            }
            c();
        } else {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            int b5 = l.b(motionEvent, 0);
            a(x2, y2, b5);
            View c7 = c((int) x2, (int) y2);
            if (c7 == this.f21750s && this.f21732a == 2) {
                b(c7, b5);
            }
            int i6 = this.f21739h[b5];
            int i7 = this.f21747p;
            if ((i6 & i7) != 0) {
                this.f21749r.a(i6 & i7, b5);
            }
        }
        return this.f21732a == 1;
    }

    public boolean a(View view, int i2, int i3) {
        this.f21750s = view;
        this.f21734c = -1;
        return a(i2, i3, 0, 0);
    }

    public boolean a(boolean z2) {
        if (this.f21750s == null) {
            return false;
        }
        if (this.f21732a == 2) {
            boolean f2 = this.f21748q.f();
            int b2 = this.f21748q.b();
            int c2 = this.f21748q.c();
            int left = b2 - this.f21750s.getLeft();
            int top = c2 - this.f21750s.getTop();
            if (left != 0) {
                this.f21750s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f21750s.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.f21749r.a(this.f21750s, b2, c2, left, top);
            }
            if (f2 && b2 == this.f21748q.d() && c2 == this.f21748q.e()) {
                this.f21748q.g();
                f2 = this.f21748q.a();
            }
            if (!f2) {
                if (z2) {
                    this.f21752u.post(this.f21753w);
                } else {
                    a(0);
                }
            }
        }
        return this.f21732a == 2;
    }

    public int b() {
        return this.f21733b;
    }

    public void b(MotionEvent motionEvent) {
        int i2;
        int a2 = l.a(motionEvent);
        int b2 = l.b(motionEvent);
        if (a2 == 0) {
            c();
        }
        if (this.f21743l == null) {
            this.f21743l = VelocityTracker.obtain();
        }
        this.f21743l.addMovement(motionEvent);
        int i3 = 0;
        if (a2 != 0) {
            if (a2 != 1) {
                if (a2 == 2) {
                    if (this.f21732a != 1) {
                        int c2 = l.c(motionEvent);
                        while (i3 < c2) {
                            int b3 = l.b(motionEvent, i3);
                            float c3 = l.c(motionEvent, i3);
                            float d2 = l.d(motionEvent, i3);
                            float f2 = c3 - this.f21735d[b3];
                            float f3 = d2 - this.f21736e[b3];
                            b(f2, f3, b3);
                            if (this.f21732a != 1) {
                                View c4 = c((int) c3, (int) d2);
                                if (a(c4, f2, f3) && b(c4, b3)) {
                                    break;
                                }
                                i3++;
                            } else {
                                break;
                            }
                        }
                    } else {
                        int a3 = l.a(motionEvent, this.f21734c);
                        float c5 = l.c(motionEvent, a3);
                        float d3 = l.d(motionEvent, a3);
                        float[] fArr = this.f21737f;
                        int i4 = this.f21734c;
                        int i5 = (int) (c5 - fArr[i4]);
                        int i6 = (int) (d3 - this.f21738g[i4]);
                        b(this.f21750s.getLeft() + i5, this.f21750s.getTop() + i6, i5, i6);
                    }
                    c(motionEvent);
                    return;
                } else if (a2 != 3) {
                    if (a2 == 5) {
                        int b4 = l.b(motionEvent, b2);
                        float c6 = l.c(motionEvent, b2);
                        float d4 = l.d(motionEvent, b2);
                        a(c6, d4, b4);
                        if (this.f21732a == 0) {
                            b(c((int) c6, (int) d4), b4);
                            int i7 = this.f21739h[b4];
                            int i8 = this.f21747p;
                            if ((i7 & i8) != 0) {
                                this.f21749r.a(i7 & i8, b4);
                                return;
                            }
                            return;
                        } else if (b((int) c6, (int) d4)) {
                            b(this.f21750s, b4);
                            return;
                        } else {
                            return;
                        }
                    } else if (a2 == 6) {
                        int b5 = l.b(motionEvent, b2);
                        if (this.f21732a == 1 && b5 == this.f21734c) {
                            int c7 = l.c(motionEvent);
                            while (true) {
                                if (i3 >= c7) {
                                    i2 = -1;
                                    break;
                                }
                                int b6 = l.b(motionEvent, i3);
                                if (b6 != this.f21734c) {
                                    View c8 = c((int) l.c(motionEvent, i3), (int) l.d(motionEvent, i3));
                                    View view = this.f21750s;
                                    if (c8 == view && b(view, b6)) {
                                        i2 = this.f21734c;
                                        break;
                                    }
                                }
                                i3++;
                            }
                            if (i2 == -1) {
                                f();
                            }
                        }
                        b(b5);
                        return;
                    } else {
                        return;
                    }
                } else if (this.f21732a == 1) {
                    a(0.0f, 0.0f);
                }
            } else if (this.f21732a == 1) {
                f();
            }
            c();
            return;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        int b7 = l.b(motionEvent, 0);
        View c9 = c((int) x2, (int) y2);
        a(x2, y2, b7);
        b(c9, b7);
        int i9 = this.f21739h[b7];
        int i10 = this.f21747p;
        if ((i9 & i10) != 0) {
            this.f21749r.a(i9 & i10, b7);
        }
    }

    public boolean b(int i2, int i3) {
        return b(this.f21750s, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public boolean b(View view, int i2) {
        if (view == this.f21750s && this.f21734c == i2) {
            return true;
        }
        if (view == null || !this.f21749r.a(view, i2)) {
            return false;
        }
        this.f21734c = i2;
        a(view, i2);
        return true;
    }

    public boolean b(View view, int i2, int i3) {
        return view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom();
    }

    public View c(int i2, int i3) {
        for (int childCount = this.f21752u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f21752u.getChildAt(this.f21749r.c(childCount));
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void c() {
        this.f21734c = -1;
        e();
        VelocityTracker velocityTracker = this.f21743l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f21743l = null;
        }
    }

    public void d() {
        c();
        if (this.f21732a == 2) {
            int b2 = this.f21748q.b();
            int c2 = this.f21748q.c();
            this.f21748q.g();
            int b3 = this.f21748q.b();
            int c3 = this.f21748q.c();
            this.f21749r.a(this.f21750s, b3, c3, b3 - b2, c3 - c2);
        }
        a(0);
    }
}
