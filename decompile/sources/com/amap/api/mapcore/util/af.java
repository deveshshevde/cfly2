package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class af {
    private int A = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Context f7745a;

    /* renamed from: b  reason: collision with root package name */
    private final a f7746b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7747c;

    /* renamed from: d  reason: collision with root package name */
    private MotionEvent f7748d;

    /* renamed from: e  reason: collision with root package name */
    private MotionEvent f7749e;

    /* renamed from: f  reason: collision with root package name */
    private float f7750f;

    /* renamed from: g  reason: collision with root package name */
    private float f7751g;

    /* renamed from: h  reason: collision with root package name */
    private float f7752h;

    /* renamed from: i  reason: collision with root package name */
    private float f7753i;

    /* renamed from: j  reason: collision with root package name */
    private float f7754j;

    /* renamed from: k  reason: collision with root package name */
    private float f7755k;

    /* renamed from: l  reason: collision with root package name */
    private float f7756l;

    /* renamed from: m  reason: collision with root package name */
    private float f7757m;

    /* renamed from: n  reason: collision with root package name */
    private float f7758n;

    /* renamed from: o  reason: collision with root package name */
    private float f7759o;

    /* renamed from: p  reason: collision with root package name */
    private float f7760p;

    /* renamed from: q  reason: collision with root package name */
    private long f7761q;

    /* renamed from: r  reason: collision with root package name */
    private final float f7762r;

    /* renamed from: s  reason: collision with root package name */
    private float f7763s;

    /* renamed from: t  reason: collision with root package name */
    private float f7764t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f7765u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f7766v;

    /* renamed from: w  reason: collision with root package name */
    private int f7767w;

    /* renamed from: x  reason: collision with root package name */
    private int f7768x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f7769y;

    /* renamed from: z  reason: collision with root package name */
    private int f7770z = 0;

    public interface a {
        boolean a(af afVar);

        boolean b(af afVar);

        void c(af afVar);
    }

    public af(Context context, a aVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f7745a = context;
        this.f7746b = aVar;
        this.f7762r = (float) viewConfiguration.getScaledEdgeSlop();
    }

    private static float a(MotionEvent motionEvent, int i2) {
        if (i2 < 0) {
            return Float.MIN_VALUE;
        }
        if (i2 == 0) {
            return motionEvent.getRawX();
        }
        return motionEvent.getX(i2) + (motionEvent.getRawX() - motionEvent.getX());
    }

    private int a(MotionEvent motionEvent, int i2, int i3) {
        int pointerCount = motionEvent.getPointerCount();
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        for (int i4 = 0; i4 < pointerCount; i4++) {
            if (!(i4 == i3 || i4 == findPointerIndex)) {
                float f2 = this.f7762r;
                float f3 = this.f7763s;
                float f4 = this.f7764t;
                float a2 = a(motionEvent, i4);
                float b2 = b(motionEvent, i4);
                if (a2 >= f2 && b2 >= f2 && a2 <= f3 && b2 <= f4) {
                    return i4;
                }
            }
        }
        return -1;
    }

    private static float b(MotionEvent motionEvent, int i2) {
        if (i2 < 0) {
            return Float.MIN_VALUE;
        }
        if (i2 == 0) {
            return motionEvent.getRawY();
        }
        return motionEvent.getY(i2) + (motionEvent.getRawY() - motionEvent.getY());
    }

    private void b(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.f7749e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.f7749e = MotionEvent.obtain(motionEvent);
        this.f7756l = -1.0f;
        this.f7757m = -1.0f;
        this.f7758n = -1.0f;
        MotionEvent motionEvent3 = this.f7748d;
        int findPointerIndex = motionEvent3.findPointerIndex(this.f7767w);
        int findPointerIndex2 = motionEvent3.findPointerIndex(this.f7768x);
        int findPointerIndex3 = motionEvent.findPointerIndex(this.f7767w);
        int findPointerIndex4 = motionEvent.findPointerIndex(this.f7768x);
        if (findPointerIndex < 0 || findPointerIndex2 < 0 || findPointerIndex3 < 0 || findPointerIndex4 < 0) {
            this.f7766v = true;
            if (this.f7747c) {
                this.f7746b.c(this);
                return;
            }
            return;
        }
        float x2 = motionEvent3.getX(findPointerIndex);
        float y2 = motionEvent3.getY(findPointerIndex);
        float x3 = motionEvent3.getX(findPointerIndex2);
        float y3 = motionEvent3.getY(findPointerIndex2);
        float x4 = motionEvent.getX(findPointerIndex3);
        float y4 = motionEvent.getY(findPointerIndex3);
        float x5 = motionEvent.getX(findPointerIndex4) - x4;
        float y5 = motionEvent.getY(findPointerIndex4) - y4;
        this.f7752h = x3 - x2;
        this.f7753i = y3 - y2;
        this.f7754j = x5;
        this.f7755k = y5;
        this.f7750f = x4 + (x5 * 0.5f);
        this.f7751g = y4 + (y5 * 0.5f);
        this.f7761q = motionEvent.getEventTime() - motionEvent3.getEventTime();
        this.f7759o = motionEvent.getPressure(findPointerIndex3) + motionEvent.getPressure(findPointerIndex4);
        this.f7760p = motionEvent3.getPressure(findPointerIndex) + motionEvent3.getPressure(findPointerIndex2);
    }

    private void j() {
        MotionEvent motionEvent = this.f7748d;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f7748d = null;
        }
        MotionEvent motionEvent2 = this.f7749e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f7749e = null;
        }
        this.f7765u = false;
        this.f7747c = false;
        this.f7767w = -1;
        this.f7768x = -1;
        this.f7766v = false;
    }

    private float k() {
        if (this.f7756l == -1.0f) {
            float f2 = this.f7754j;
            float f3 = this.f7755k;
            this.f7756l = (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
        }
        return this.f7756l;
    }

    private float l() {
        if (this.f7757m == -1.0f) {
            float f2 = this.f7752h;
            float f3 = this.f7753i;
            this.f7757m = (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
        }
        return this.f7757m;
    }

    public final MotionEvent a() {
        return this.f7749e;
    }

    public final void a(int i2, int i3) {
        this.f7770z = i2;
        this.A = i3;
    }

    public final boolean a(MotionEvent motionEvent) {
        float f2;
        int a2;
        int a3;
        float f3;
        int i2;
        int i3;
        float y2;
        int i4;
        int a4;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            j();
        }
        boolean z2 = false;
        if (this.f7766v) {
            return false;
        }
        int i5 = -1;
        if (this.f7747c) {
            if (action != 1) {
                if (action == 2) {
                    b(motionEvent);
                    if (this.f7759o / this.f7760p > 0.67f && this.f7746b.a(this)) {
                        this.f7748d.recycle();
                        this.f7748d = MotionEvent.obtain(motionEvent);
                    }
                } else if (action == 3) {
                    this.f7746b.c(this);
                } else if (action == 5) {
                    this.f7746b.c(this);
                    int i6 = this.f7767w;
                    int i7 = this.f7768x;
                    j();
                    this.f7748d = MotionEvent.obtain(motionEvent);
                    if (!this.f7769y) {
                        i6 = i7;
                    }
                    this.f7767w = i6;
                    this.f7768x = Build.VERSION.SDK_INT >= 8 ? motionEvent.getPointerId(motionEvent.getActionIndex()) : motionEvent.getPointerId(1);
                    this.f7769y = false;
                    int findPointerIndex = motionEvent.findPointerIndex(this.f7767w);
                    if (findPointerIndex < 0 || this.f7767w == this.f7768x) {
                        int i8 = this.f7767w;
                        int i9 = this.f7768x;
                        if (i8 != i9) {
                            i5 = i9;
                        }
                        this.f7767w = motionEvent.getPointerId(a(motionEvent, i5, findPointerIndex));
                    }
                    b(motionEvent);
                    this.f7747c = this.f7746b.b(this);
                } else if (action == 6) {
                    int pointerCount = motionEvent.getPointerCount();
                    int actionIndex = Build.VERSION.SDK_INT >= 8 ? motionEvent.getActionIndex() : 0;
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    if (pointerCount > 2) {
                        int i10 = this.f7767w;
                        if (pointerId == i10) {
                            int a5 = a(motionEvent, this.f7768x, actionIndex);
                            if (a5 >= 0) {
                                this.f7746b.c(this);
                                this.f7767w = motionEvent.getPointerId(a5);
                                this.f7769y = true;
                            }
                            z2 = true;
                            this.f7748d.recycle();
                            this.f7748d = MotionEvent.obtain(motionEvent);
                            b(motionEvent);
                        } else {
                            if (pointerId == this.f7768x) {
                                int a6 = a(motionEvent, i10, actionIndex);
                                if (a6 >= 0) {
                                    this.f7746b.c(this);
                                    this.f7768x = motionEvent.getPointerId(a6);
                                    this.f7769y = false;
                                }
                                z2 = true;
                            }
                            this.f7748d.recycle();
                            this.f7748d = MotionEvent.obtain(motionEvent);
                            b(motionEvent);
                        }
                        this.f7748d = MotionEvent.obtain(motionEvent);
                        b(motionEvent);
                        this.f7747c = this.f7746b.b(this);
                        this.f7748d.recycle();
                        this.f7748d = MotionEvent.obtain(motionEvent);
                        b(motionEvent);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        b(motionEvent);
                        int i11 = this.f7767w;
                        if (pointerId == i11) {
                            i11 = this.f7768x;
                        }
                        int findPointerIndex2 = motionEvent.findPointerIndex(i11);
                        this.f7750f = motionEvent.getX(findPointerIndex2);
                        this.f7751g = motionEvent.getY(findPointerIndex2);
                        this.f7746b.c(this);
                        j();
                        this.f7767w = i11;
                    }
                }
                return true;
            }
            j();
            return true;
        } else if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 5) {
                        int i12 = this.f7770z;
                        if (i12 == 0 || (i4 = this.A) == 0) {
                            DisplayMetrics displayMetrics = this.f7745a.getResources().getDisplayMetrics();
                            this.f7763s = ((float) displayMetrics.widthPixels) - this.f7762r;
                            f3 = ((float) displayMetrics.heightPixels) - this.f7762r;
                        } else {
                            float f4 = this.f7762r;
                            this.f7763s = ((float) i12) - f4;
                            f3 = ((float) i4) - f4;
                        }
                        this.f7764t = f3;
                        MotionEvent motionEvent2 = this.f7748d;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                        }
                        this.f7748d = MotionEvent.obtain(motionEvent);
                        this.f7761q = 0;
                        if (Build.VERSION.SDK_INT >= 8) {
                            i3 = motionEvent.getActionIndex();
                            i2 = motionEvent.findPointerIndex(this.f7767w);
                            int pointerId2 = motionEvent.getPointerId(i3);
                            this.f7768x = pointerId2;
                            if (i2 < 0 || i2 == i3) {
                                if (i2 != i3) {
                                    i5 = pointerId2;
                                }
                                i2 = a(motionEvent, i5, i2);
                                this.f7767w = motionEvent.getPointerId(i2);
                            }
                        } else if (motionEvent.getPointerCount() > 0) {
                            i3 = motionEvent.findPointerIndex(1);
                            i2 = motionEvent.findPointerIndex(this.f7767w);
                            this.f7768x = motionEvent.getPointerId(i3);
                        } else {
                            i3 = 0;
                            i2 = 0;
                        }
                        this.f7769y = false;
                        b(motionEvent);
                        float f5 = this.f7762r;
                        float f6 = this.f7763s;
                        float f7 = this.f7764t;
                        float a7 = a(motionEvent, i2);
                        float b2 = b(motionEvent, i2);
                        float a8 = a(motionEvent, i3);
                        float b3 = b(motionEvent, i3);
                        boolean z3 = a7 < f5 || b2 < f5 || a7 > f6 || b2 > f7;
                        boolean z4 = a8 < f5 || b3 < f5 || a8 > f6 || b3 > f7;
                        if (!z3 || !z4) {
                            if (z3) {
                                this.f7750f = motionEvent.getX(i3);
                                y2 = motionEvent.getY(i3);
                            } else {
                                if (z4) {
                                    this.f7750f = motionEvent.getX(i2);
                                    y2 = motionEvent.getY(i2);
                                }
                                this.f7765u = false;
                                this.f7747c = this.f7746b.b(this);
                            }
                            this.f7751g = y2;
                        } else {
                            this.f7750f = -1.0f;
                            this.f7751g = -1.0f;
                        }
                        this.f7765u = true;
                    } else if (action == 6 && this.f7765u) {
                        int pointerCount2 = motionEvent.getPointerCount();
                        int actionIndex2 = Build.VERSION.SDK_INT >= 8 ? motionEvent.getActionIndex() : 0;
                        int pointerId3 = motionEvent.getPointerId(actionIndex2);
                        if (pointerCount2 > 2) {
                            int i13 = this.f7767w;
                            if (pointerId3 == i13) {
                                int a9 = a(motionEvent, this.f7768x, actionIndex2);
                                if (a9 >= 0) {
                                    this.f7767w = motionEvent.getPointerId(a9);
                                }
                            } else if (pointerId3 == this.f7768x && (a4 = a(motionEvent, i13, actionIndex2)) >= 0) {
                                this.f7768x = motionEvent.getPointerId(a4);
                            }
                        } else {
                            int i14 = this.f7767w;
                            if (pointerId3 == i14) {
                                i14 = this.f7768x;
                            }
                            int findPointerIndex3 = motionEvent.findPointerIndex(i14);
                            if (findPointerIndex3 < 0) {
                                this.f7766v = true;
                                if (this.f7747c) {
                                    this.f7746b.c(this);
                                }
                                return false;
                            }
                            this.f7767w = motionEvent.getPointerId(findPointerIndex3);
                            this.f7769y = true;
                            this.f7768x = -1;
                            this.f7750f = motionEvent.getX(findPointerIndex3);
                            f2 = motionEvent.getY(findPointerIndex3);
                        }
                    }
                    return true;
                }
                if (this.f7765u) {
                    float f8 = this.f7762r;
                    float f9 = this.f7763s;
                    float f10 = this.f7764t;
                    int findPointerIndex4 = motionEvent.findPointerIndex(this.f7767w);
                    int findPointerIndex5 = motionEvent.findPointerIndex(this.f7768x);
                    float a10 = a(motionEvent, findPointerIndex4);
                    float b4 = b(motionEvent, findPointerIndex4);
                    float a11 = a(motionEvent, findPointerIndex5);
                    float b5 = b(motionEvent, findPointerIndex5);
                    boolean z5 = a10 < f8 || b4 < f8 || a10 > f9 || b4 > f10;
                    boolean z6 = a11 < f8 || b5 < f8 || a11 > f9 || b5 > f10;
                    if (z5 && (a3 = a(motionEvent, this.f7768x, findPointerIndex4)) >= 0) {
                        this.f7767w = motionEvent.getPointerId(a3);
                        a(motionEvent, a3);
                        b(motionEvent, a3);
                        findPointerIndex4 = a3;
                        z5 = false;
                    }
                    if (z6 && (a2 = a(motionEvent, this.f7767w, findPointerIndex5)) >= 0) {
                        this.f7768x = motionEvent.getPointerId(a2);
                        a(motionEvent, a2);
                        b(motionEvent, a2);
                        findPointerIndex5 = a2;
                        z6 = false;
                    }
                    if (z5 && z6) {
                        this.f7750f = -1.0f;
                        this.f7751g = -1.0f;
                    } else if (z5) {
                        this.f7750f = motionEvent.getX(findPointerIndex5);
                        f2 = motionEvent.getY(findPointerIndex5);
                    } else {
                        if (z6) {
                            this.f7750f = motionEvent.getX(findPointerIndex4);
                            f2 = motionEvent.getY(findPointerIndex4);
                        }
                        this.f7765u = false;
                        this.f7747c = this.f7746b.b(this);
                    }
                }
                return true;
                this.f7751g = f2;
                return true;
            }
            j();
            return true;
        } else {
            this.f7767w = motionEvent.getPointerId(0);
        }
        this.f7769y = true;
        return true;
    }

    public final float b() {
        return this.f7750f;
    }

    public final float c() {
        return this.f7751g;
    }

    public final float d() {
        return this.f7754j;
    }

    public final float e() {
        return this.f7755k;
    }

    public final float f() {
        return this.f7752h;
    }

    public final float g() {
        return this.f7753i;
    }

    public final float h() {
        if (this.f7758n == -1.0f) {
            this.f7758n = k() / l();
        }
        return this.f7758n;
    }

    public final long i() {
        return this.f7761q;
    }
}
