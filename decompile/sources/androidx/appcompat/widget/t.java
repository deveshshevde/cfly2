package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.p;

public abstract class t implements View.OnAttachStateChangeListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final float f1568a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1569b;

    /* renamed from: c  reason: collision with root package name */
    final View f1570c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1571d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f1572e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f1573f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1574g;

    /* renamed from: h  reason: collision with root package name */
    private int f1575h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f1576i = new int[2];

    private class a implements Runnable {
        a() {
        }

        public void run() {
            ViewParent parent = t.this.f1570c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void run() {
            t.this.d();
        }
    }

    public t(View view) {
        this.f1570c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1568a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1569b = tapTimeout;
        this.f1571d = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f1570c
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L_0x0041
            r3 = 1
            if (r1 == r3) goto L_0x003d
            r4 = 2
            if (r1 == r4) goto L_0x001a
            r6 = 3
            if (r1 == r6) goto L_0x003d
            goto L_0x006d
        L_0x001a:
            int r1 = r5.f1575h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L_0x006d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f1568a
            boolean r6 = a(r0, r4, r6, r1)
            if (r6 != 0) goto L_0x006d
            r5.e()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L_0x003d:
            r5.e()
            goto L_0x006d
        L_0x0041:
            int r6 = r6.getPointerId(r2)
            r5.f1575h = r6
            java.lang.Runnable r6 = r5.f1572e
            if (r6 != 0) goto L_0x0052
            androidx.appcompat.widget.t$a r6 = new androidx.appcompat.widget.t$a
            r6.<init>()
            r5.f1572e = r6
        L_0x0052:
            java.lang.Runnable r6 = r5.f1572e
            int r1 = r5.f1569b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f1573f
            if (r6 != 0) goto L_0x0065
            androidx.appcompat.widget.t$b r6 = new androidx.appcompat.widget.t$b
            r6.<init>()
            r5.f1573f = r6
        L_0x0065:
            java.lang.Runnable r6 = r5.f1573f
            int r1 = r5.f1571d
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.t.a(android.view.MotionEvent):boolean");
    }

    private static boolean a(View view, float f2, float f3, float f4) {
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1576i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    private boolean b(MotionEvent motionEvent) {
        r rVar;
        View view = this.f1570c;
        p a2 = a();
        if (a2 == null || !a2.e() || (rVar = (r) a2.g()) == null || !rVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        b(view, obtainNoHistory);
        a(rVar, obtainNoHistory);
        boolean a3 = rVar.a(obtainNoHistory, this.f1575h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return a3 && (actionMasked != 1 && actionMasked != 3);
    }

    private boolean b(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1576i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private void e() {
        Runnable runnable = this.f1573f;
        if (runnable != null) {
            this.f1570c.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1572e;
        if (runnable2 != null) {
            this.f1570c.removeCallbacks(runnable2);
        }
    }

    public abstract p a();

    /* access modifiers changed from: protected */
    public boolean b() {
        p a2 = a();
        if (a2 == null || a2.e()) {
            return true;
        }
        a2.c_();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        p a2 = a();
        if (a2 == null || !a2.e()) {
            return true;
        }
        a2.d();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        e();
        View view = this.f1570c;
        if (view.isEnabled() && !view.isLongClickable() && b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1574g = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z2;
        boolean z3 = this.f1574g;
        if (z3) {
            z2 = b(motionEvent) || !c();
        } else {
            z2 = a(motionEvent) && b();
            if (z2) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1570c.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f1574g = z2;
        return z2 || z3;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.f1574g = false;
        this.f1575h = -1;
        Runnable runnable = this.f1572e;
        if (runnable != null) {
            this.f1570c.removeCallbacks(runnable);
        }
    }
}
