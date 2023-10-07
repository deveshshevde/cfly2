package t;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final a f34491a;

    interface a {
        void a(boolean z2);

        boolean a(MotionEvent motionEvent);
    }

    static class b implements a {

        /* renamed from: j  reason: collision with root package name */
        private static final int f34492j = ViewConfiguration.getTapTimeout();

        /* renamed from: k  reason: collision with root package name */
        private static final int f34493k = ViewConfiguration.getDoubleTapTimeout();

        /* renamed from: a  reason: collision with root package name */
        final GestureDetector.OnGestureListener f34494a;

        /* renamed from: b  reason: collision with root package name */
        GestureDetector.OnDoubleTapListener f34495b;

        /* renamed from: c  reason: collision with root package name */
        boolean f34496c;

        /* renamed from: d  reason: collision with root package name */
        boolean f34497d;

        /* renamed from: e  reason: collision with root package name */
        MotionEvent f34498e;

        /* renamed from: f  reason: collision with root package name */
        private int f34499f;

        /* renamed from: g  reason: collision with root package name */
        private int f34500g;

        /* renamed from: h  reason: collision with root package name */
        private int f34501h;

        /* renamed from: i  reason: collision with root package name */
        private int f34502i;

        /* renamed from: l  reason: collision with root package name */
        private final Handler f34503l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f34504m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f34505n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f34506o;

        /* renamed from: p  reason: collision with root package name */
        private MotionEvent f34507p;

        /* renamed from: q  reason: collision with root package name */
        private boolean f34508q;

        /* renamed from: r  reason: collision with root package name */
        private float f34509r;

        /* renamed from: s  reason: collision with root package name */
        private float f34510s;

        /* renamed from: t  reason: collision with root package name */
        private float f34511t;

        /* renamed from: u  reason: collision with root package name */
        private float f34512u;

        /* renamed from: v  reason: collision with root package name */
        private boolean f34513v;

        /* renamed from: w  reason: collision with root package name */
        private VelocityTracker f34514w;

        private class a extends Handler {
            a() {
            }

            a(Handler handler) {
                super(handler.getLooper());
            }

            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1) {
                    b.this.f34494a.onShowPress(b.this.f34498e);
                } else if (i2 == 2) {
                    b.this.a();
                } else if (i2 != 3) {
                    throw new RuntimeException("Unknown message " + message);
                } else if (b.this.f34495b == null) {
                } else {
                    if (!b.this.f34496c) {
                        b.this.f34495b.onSingleTapConfirmed(b.this.f34498e);
                    } else {
                        b.this.f34497d = true;
                    }
                }
            }
        }

        b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f34503l = new a(handler);
            } else {
                this.f34503l = new a();
            }
            this.f34494a = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                a((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            a(context);
        }

        private void a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.f34494a != null) {
                this.f34513v = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.f34501h = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f34502i = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f34499f = scaledTouchSlop * scaledTouchSlop;
                this.f34500g = scaledDoubleTapSlop * scaledDoubleTapSlop;
            } else {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
        }

        private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.f34506o || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) f34493k)) {
                return false;
            }
            int x2 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y2 = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x2 * x2) + (y2 * y2) < this.f34500g;
        }

        private void b() {
            this.f34503l.removeMessages(1);
            this.f34503l.removeMessages(2);
            this.f34503l.removeMessages(3);
            this.f34514w.recycle();
            this.f34514w = null;
            this.f34508q = false;
            this.f34496c = false;
            this.f34505n = false;
            this.f34506o = false;
            this.f34497d = false;
            if (this.f34504m) {
                this.f34504m = false;
            }
        }

        private void c() {
            this.f34503l.removeMessages(1);
            this.f34503l.removeMessages(2);
            this.f34503l.removeMessages(3);
            this.f34508q = false;
            this.f34505n = false;
            this.f34506o = false;
            this.f34497d = false;
            if (this.f34504m) {
                this.f34504m = false;
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f34503l.removeMessages(3);
            this.f34497d = false;
            this.f34504m = true;
            this.f34494a.onLongPress(this.f34498e);
        }

        public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f34495b = onDoubleTapListener;
        }

        public void a(boolean z2) {
            this.f34513v = z2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:100:0x0208  */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x021f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.view.MotionEvent r13) {
            /*
                r12 = this;
                int r0 = r13.getAction()
                android.view.VelocityTracker r1 = r12.f34514w
                if (r1 != 0) goto L_0x000e
                android.view.VelocityTracker r1 = android.view.VelocityTracker.obtain()
                r12.f34514w = r1
            L_0x000e:
                android.view.VelocityTracker r1 = r12.f34514w
                r1.addMovement(r13)
                r0 = r0 & 255(0xff, float:3.57E-43)
                r1 = 6
                r2 = 1
                r3 = 0
                if (r0 != r1) goto L_0x001c
                r4 = 1
                goto L_0x001d
            L_0x001c:
                r4 = 0
            L_0x001d:
                if (r4 == 0) goto L_0x0024
                int r5 = r13.getActionIndex()
                goto L_0x0025
            L_0x0024:
                r5 = -1
            L_0x0025:
                int r6 = r13.getPointerCount()
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
            L_0x002d:
                if (r8 >= r6) goto L_0x003f
                if (r5 != r8) goto L_0x0032
                goto L_0x003c
            L_0x0032:
                float r11 = r13.getX(r8)
                float r9 = r9 + r11
                float r11 = r13.getY(r8)
                float r10 = r10 + r11
            L_0x003c:
                int r8 = r8 + 1
                goto L_0x002d
            L_0x003f:
                if (r4 == 0) goto L_0x0044
                int r4 = r6 + -1
                goto L_0x0045
            L_0x0044:
                r4 = r6
            L_0x0045:
                float r4 = (float) r4
                float r9 = r9 / r4
                float r10 = r10 / r4
                r4 = 2
                r5 = 3
                if (r0 == 0) goto L_0x01bf
                r8 = 1000(0x3e8, float:1.401E-42)
                if (r0 == r2) goto L_0x0131
                if (r0 == r4) goto L_0x00ba
                if (r0 == r5) goto L_0x00b5
                r2 = 5
                if (r0 == r2) goto L_0x00a8
                if (r0 == r1) goto L_0x005b
                goto L_0x0250
            L_0x005b:
                r12.f34509r = r9
                r12.f34511t = r9
                r12.f34510s = r10
                r12.f34512u = r10
                android.view.VelocityTracker r0 = r12.f34514w
                int r1 = r12.f34502i
                float r1 = (float) r1
                r0.computeCurrentVelocity(r8, r1)
                int r0 = r13.getActionIndex()
                int r1 = r13.getPointerId(r0)
                android.view.VelocityTracker r2 = r12.f34514w
                float r2 = r2.getXVelocity(r1)
                android.view.VelocityTracker r4 = r12.f34514w
                float r1 = r4.getYVelocity(r1)
                r4 = 0
            L_0x0080:
                if (r4 >= r6) goto L_0x0250
                if (r4 != r0) goto L_0x0085
                goto L_0x00a5
            L_0x0085:
                int r5 = r13.getPointerId(r4)
                android.view.VelocityTracker r8 = r12.f34514w
                float r8 = r8.getXVelocity(r5)
                float r8 = r8 * r2
                android.view.VelocityTracker r9 = r12.f34514w
                float r5 = r9.getYVelocity(r5)
                float r5 = r5 * r1
                float r8 = r8 + r5
                int r5 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
                if (r5 >= 0) goto L_0x00a5
                android.view.VelocityTracker r13 = r12.f34514w
                r13.clear()
                goto L_0x0250
            L_0x00a5:
                int r4 = r4 + 1
                goto L_0x0080
            L_0x00a8:
                r12.f34509r = r9
                r12.f34511t = r9
                r12.f34510s = r10
                r12.f34512u = r10
                r12.c()
                goto L_0x0250
            L_0x00b5:
                r12.b()
                goto L_0x0250
            L_0x00ba:
                boolean r0 = r12.f34504m
                if (r0 == 0) goto L_0x00c0
                goto L_0x0250
            L_0x00c0:
                float r0 = r12.f34509r
                float r0 = r0 - r9
                float r1 = r12.f34510s
                float r1 = r1 - r10
                boolean r6 = r12.f34508q
                if (r6 == 0) goto L_0x00d3
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.f34495b
                boolean r13 = r0.onDoubleTapEvent(r13)
                r3 = r3 | r13
                goto L_0x0250
            L_0x00d3:
                boolean r6 = r12.f34505n
                if (r6 == 0) goto L_0x0111
                float r6 = r12.f34511t
                float r6 = r9 - r6
                int r6 = (int) r6
                float r7 = r12.f34512u
                float r7 = r10 - r7
                int r7 = (int) r7
                int r6 = r6 * r6
                int r7 = r7 * r7
                int r6 = r6 + r7
                int r7 = r12.f34499f
                if (r6 <= r7) goto L_0x0108
                android.view.GestureDetector$OnGestureListener r7 = r12.f34494a
                android.view.MotionEvent r8 = r12.f34498e
                boolean r13 = r7.onScroll(r8, r13, r0, r1)
                r12.f34509r = r9
                r12.f34510s = r10
                r12.f34505n = r3
                android.os.Handler r0 = r12.f34503l
                r0.removeMessages(r5)
                android.os.Handler r0 = r12.f34503l
                r0.removeMessages(r2)
                android.os.Handler r0 = r12.f34503l
                r0.removeMessages(r4)
                goto L_0x0109
            L_0x0108:
                r13 = 0
            L_0x0109:
                int r0 = r12.f34499f
                if (r6 <= r0) goto L_0x01bc
                r12.f34506o = r3
                goto L_0x01bc
            L_0x0111:
                float r2 = java.lang.Math.abs(r0)
                r4 = 1065353216(0x3f800000, float:1.0)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 >= 0) goto L_0x0123
                float r2 = java.lang.Math.abs(r1)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 < 0) goto L_0x0250
            L_0x0123:
                android.view.GestureDetector$OnGestureListener r2 = r12.f34494a
                android.view.MotionEvent r3 = r12.f34498e
                boolean r3 = r2.onScroll(r3, r13, r0, r1)
                r12.f34509r = r9
                r12.f34510s = r10
                goto L_0x0250
            L_0x0131:
                r12.f34496c = r3
                android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r13)
                boolean r1 = r12.f34508q
                if (r1 == 0) goto L_0x0143
                android.view.GestureDetector$OnDoubleTapListener r1 = r12.f34495b
                boolean r13 = r1.onDoubleTapEvent(r13)
                r13 = r13 | r3
                goto L_0x019b
            L_0x0143:
                boolean r1 = r12.f34504m
                if (r1 == 0) goto L_0x014f
                android.os.Handler r13 = r12.f34503l
                r13.removeMessages(r5)
                r12.f34504m = r3
                goto L_0x0191
            L_0x014f:
                boolean r1 = r12.f34505n
                if (r1 == 0) goto L_0x0166
                android.view.GestureDetector$OnGestureListener r1 = r12.f34494a
                boolean r1 = r1.onSingleTapUp(r13)
                boolean r5 = r12.f34497d
                if (r5 == 0) goto L_0x0164
                android.view.GestureDetector$OnDoubleTapListener r5 = r12.f34495b
                if (r5 == 0) goto L_0x0164
                r5.onSingleTapConfirmed(r13)
            L_0x0164:
                r13 = r1
                goto L_0x019b
            L_0x0166:
                android.view.VelocityTracker r1 = r12.f34514w
                int r5 = r13.getPointerId(r3)
                int r6 = r12.f34502i
                float r6 = (float) r6
                r1.computeCurrentVelocity(r8, r6)
                float r6 = r1.getYVelocity(r5)
                float r1 = r1.getXVelocity(r5)
                float r5 = java.lang.Math.abs(r6)
                int r7 = r12.f34501h
                float r7 = (float) r7
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 > 0) goto L_0x0193
                float r5 = java.lang.Math.abs(r1)
                int r7 = r12.f34501h
                float r7 = (float) r7
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 <= 0) goto L_0x0191
                goto L_0x0193
            L_0x0191:
                r13 = 0
                goto L_0x019b
            L_0x0193:
                android.view.GestureDetector$OnGestureListener r5 = r12.f34494a
                android.view.MotionEvent r7 = r12.f34498e
                boolean r13 = r5.onFling(r7, r13, r1, r6)
            L_0x019b:
                android.view.MotionEvent r1 = r12.f34507p
                if (r1 == 0) goto L_0x01a2
                r1.recycle()
            L_0x01a2:
                r12.f34507p = r0
                android.view.VelocityTracker r0 = r12.f34514w
                if (r0 == 0) goto L_0x01ae
                r0.recycle()
                r0 = 0
                r12.f34514w = r0
            L_0x01ae:
                r12.f34508q = r3
                r12.f34497d = r3
                android.os.Handler r0 = r12.f34503l
                r0.removeMessages(r2)
                android.os.Handler r0 = r12.f34503l
                r0.removeMessages(r4)
            L_0x01bc:
                r3 = r13
                goto L_0x0250
            L_0x01bf:
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.f34495b
                if (r0 == 0) goto L_0x01fb
                android.os.Handler r0 = r12.f34503l
                boolean r0 = r0.hasMessages(r5)
                if (r0 == 0) goto L_0x01d0
                android.os.Handler r1 = r12.f34503l
                r1.removeMessages(r5)
            L_0x01d0:
                android.view.MotionEvent r1 = r12.f34498e
                if (r1 == 0) goto L_0x01f3
                android.view.MotionEvent r6 = r12.f34507p
                if (r6 == 0) goto L_0x01f3
                if (r0 == 0) goto L_0x01f3
                boolean r0 = r12.a(r1, r6, r13)
                if (r0 == 0) goto L_0x01f3
                r12.f34508q = r2
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.f34495b
                android.view.MotionEvent r1 = r12.f34498e
                boolean r0 = r0.onDoubleTap(r1)
                r0 = r0 | r3
                android.view.GestureDetector$OnDoubleTapListener r1 = r12.f34495b
                boolean r1 = r1.onDoubleTapEvent(r13)
                r0 = r0 | r1
                goto L_0x01fc
            L_0x01f3:
                android.os.Handler r0 = r12.f34503l
                int r1 = f34493k
                long r6 = (long) r1
                r0.sendEmptyMessageDelayed(r5, r6)
            L_0x01fb:
                r0 = 0
            L_0x01fc:
                r12.f34509r = r9
                r12.f34511t = r9
                r12.f34510s = r10
                r12.f34512u = r10
                android.view.MotionEvent r1 = r12.f34498e
                if (r1 == 0) goto L_0x020b
                r1.recycle()
            L_0x020b:
                android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r13)
                r12.f34498e = r1
                r12.f34505n = r2
                r12.f34506o = r2
                r12.f34496c = r2
                r12.f34504m = r3
                r12.f34497d = r3
                boolean r1 = r12.f34513v
                if (r1 == 0) goto L_0x0239
                android.os.Handler r1 = r12.f34503l
                r1.removeMessages(r4)
                android.os.Handler r1 = r12.f34503l
                android.view.MotionEvent r3 = r12.f34498e
                long r5 = r3.getDownTime()
                int r3 = f34492j
                long r7 = (long) r3
                long r5 = r5 + r7
                int r3 = android.view.ViewConfiguration.getLongPressTimeout()
                long r7 = (long) r3
                long r5 = r5 + r7
                r1.sendEmptyMessageAtTime(r4, r5)
            L_0x0239:
                android.os.Handler r1 = r12.f34503l
                android.view.MotionEvent r3 = r12.f34498e
                long r3 = r3.getDownTime()
                int r5 = f34492j
                long r5 = (long) r5
                long r3 = r3 + r5
                r1.sendEmptyMessageAtTime(r2, r3)
                android.view.GestureDetector$OnGestureListener r1 = r12.f34494a
                boolean r13 = r1.onDown(r13)
                r3 = r0 | r13
            L_0x0250:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: t.e.b.a(android.view.MotionEvent):boolean");
        }
    }

    static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        private final GestureDetector f34516a;

        c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f34516a = new GestureDetector(context, onGestureListener, handler);
        }

        public void a(boolean z2) {
            this.f34516a.setIsLongpressEnabled(z2);
        }

        public boolean a(MotionEvent motionEvent) {
            return this.f34516a.onTouchEvent(motionEvent);
        }
    }

    public e(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, (Handler) null);
    }

    public e(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f34491a = Build.VERSION.SDK_INT > 17 ? new c(context, onGestureListener, handler) : new b(context, onGestureListener, handler);
    }

    public void a(boolean z2) {
        this.f34491a.a(z2);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f34491a.a(motionEvent);
    }
}
