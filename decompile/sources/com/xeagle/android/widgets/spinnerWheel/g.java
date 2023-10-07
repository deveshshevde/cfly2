package com.xeagle.android.widgets.spinnerWheel;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    protected Scroller f26074a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f26075b;

    /* renamed from: c  reason: collision with root package name */
    private Context f26076c;

    /* renamed from: d  reason: collision with root package name */
    private GestureDetector f26077d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f26078e;

    /* renamed from: f  reason: collision with root package name */
    private float f26079f;

    /* renamed from: g  reason: collision with root package name */
    private float f26080g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f26081h;

    /* renamed from: i  reason: collision with root package name */
    private final int f26082i = 0;

    /* renamed from: j  reason: collision with root package name */
    private final int f26083j = 1;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Handler f26084k = new Handler() {
        public void handleMessage(Message message) {
            g.this.f26074a.computeScrollOffset();
            int a2 = g.this.a();
            int a3 = g.this.f26078e - a2;
            int unused = g.this.f26078e = a2;
            if (a3 != 0) {
                g.this.f26075b.a(a3);
            }
            if (Math.abs(a2 - g.this.b()) < 1) {
                g.this.f26074a.forceFinished(true);
            }
            if (!g.this.f26074a.isFinished()) {
                g.this.f26084k.sendEmptyMessage(message.what);
            } else if (message.what == 0) {
                g.this.f();
            } else {
                g.this.d();
            }
        }
    };

    public interface a {
        void a();

        void a(int i2);

        void b();

        void c();

        void d();

        void e();
    }

    public g(Context context, a aVar) {
        GestureDetector gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                int unused = g.this.f26078e = 0;
                g gVar = g.this;
                gVar.a(gVar.f26078e, (int) f2, (int) f3);
                g.this.a(0);
                return true;
            }

            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                return true;
            }
        });
        this.f26077d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f26074a = new Scroller(context);
        this.f26075b = aVar;
        this.f26076c = context;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        e();
        this.f26084k.sendEmptyMessage(i2);
    }

    private void e() {
        this.f26084k.removeMessages(0);
        this.f26084k.removeMessages(1);
    }

    /* access modifiers changed from: private */
    public void f() {
        this.f26075b.e();
        a(1);
    }

    private void g() {
        if (!this.f26081h) {
            this.f26081h = true;
            this.f26075b.a();
        }
    }

    /* access modifiers changed from: protected */
    public abstract float a(MotionEvent motionEvent, float f2, float f3);

    /* access modifiers changed from: protected */
    public abstract int a();

    /* access modifiers changed from: protected */
    public abstract void a(int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract void a(int i2, int i3, int i4);

    public void a(Interpolator interpolator) {
        this.f26074a.forceFinished(true);
        this.f26074a = new Scroller(this.f26076c, interpolator);
    }

    public boolean a(ViewParent viewParent, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z2 = false;
        if (action == 0) {
            if (viewParent != null) {
                viewParent.requestDisallowInterceptTouchEvent(true);
            }
            this.f26079f = motionEvent.getX();
            this.f26080g = motionEvent.getY();
            this.f26074a.forceFinished(true);
            e();
            this.f26075b.b();
        } else if (action != 1) {
            if (action == 2) {
                int a2 = (int) a(motionEvent, this.f26079f, this.f26080g);
                if (a2 != 0) {
                    if (viewParent != null) {
                        viewParent.requestDisallowInterceptTouchEvent(true);
                    }
                    g();
                    this.f26075b.a(a2);
                    this.f26079f = motionEvent.getX();
                    this.f26080g = motionEvent.getY();
                } else {
                    if (viewParent != null) {
                        viewParent.requestDisallowInterceptTouchEvent(false);
                    }
                    if (z2 && !this.f26077d.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
                        f();
                    }
                    return z2;
                }
            }
        } else if (this.f26074a.isFinished()) {
            this.f26075b.c();
        }
        z2 = true;
        f();
        return z2;
    }

    /* access modifiers changed from: protected */
    public abstract int b();

    public void b(int i2, int i3) {
        this.f26074a.forceFinished(true);
        this.f26078e = 0;
        if (i3 == 0) {
            i3 = 400;
        }
        a(i2, i3);
        a(0);
        g();
    }

    public void c() {
        this.f26074a.forceFinished(true);
    }

    /* access modifiers changed from: protected */
    public void d() {
        if (this.f26081h) {
            this.f26075b.d();
            this.f26081h = false;
        }
    }
}
