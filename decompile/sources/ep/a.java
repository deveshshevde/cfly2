package ep;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    protected e f26941a;

    /* renamed from: b  reason: collision with root package name */
    float f26942b;

    /* renamed from: c  reason: collision with root package name */
    float f26943c;

    /* renamed from: d  reason: collision with root package name */
    final float f26944d;

    /* renamed from: e  reason: collision with root package name */
    final float f26945e;

    /* renamed from: f  reason: collision with root package name */
    private VelocityTracker f26946f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f26947g;

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f26945e = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f26944d = (float) viewConfiguration.getScaledTouchSlop();
    }

    /* access modifiers changed from: package-private */
    public float a(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    public void a(e eVar) {
        this.f26941a = eVar;
    }

    public boolean a() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public float b(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a6, code lost:
        if (r9 != null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r9 == null) goto L_0x00cb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getAction()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00aa
            r3 = 0
            if (r0 == r2) goto L_0x005b
            r4 = 2
            if (r0 == r4) goto L_0x001e
            r9 = 3
            if (r0 == r9) goto L_0x0013
            goto L_0x00cb
        L_0x0013:
            android.view.VelocityTracker r9 = r8.f26946f
            if (r9 == 0) goto L_0x00cb
        L_0x0017:
            r9.recycle()
            r8.f26946f = r3
            goto L_0x00cb
        L_0x001e:
            float r0 = r8.a((android.view.MotionEvent) r9)
            float r3 = r8.b(r9)
            float r4 = r8.f26942b
            float r4 = r0 - r4
            float r5 = r8.f26943c
            float r5 = r3 - r5
            boolean r6 = r8.f26947g
            if (r6 != 0) goto L_0x0046
            float r6 = r4 * r4
            float r7 = r5 * r5
            float r6 = r6 + r7
            double r6 = (double) r6
            double r6 = java.lang.Math.sqrt(r6)
            float r6 = (float) r6
            float r7 = r8.f26944d
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 < 0) goto L_0x0044
            r1 = 1
        L_0x0044:
            r8.f26947g = r1
        L_0x0046:
            boolean r1 = r8.f26947g
            if (r1 == 0) goto L_0x00cb
            ep.e r1 = r8.f26941a
            r1.a(r4, r5)
            r8.f26942b = r0
            r8.f26943c = r3
            android.view.VelocityTracker r0 = r8.f26946f
            if (r0 == 0) goto L_0x00cb
            r0.addMovement(r9)
            goto L_0x00cb
        L_0x005b:
            boolean r0 = r8.f26947g
            if (r0 == 0) goto L_0x00a4
            android.view.VelocityTracker r0 = r8.f26946f
            if (r0 == 0) goto L_0x00a4
            float r0 = r8.a((android.view.MotionEvent) r9)
            r8.f26942b = r0
            float r0 = r8.b(r9)
            r8.f26943c = r0
            android.view.VelocityTracker r0 = r8.f26946f
            r0.addMovement(r9)
            android.view.VelocityTracker r9 = r8.f26946f
            r0 = 1000(0x3e8, float:1.401E-42)
            r9.computeCurrentVelocity(r0)
            android.view.VelocityTracker r9 = r8.f26946f
            float r9 = r9.getXVelocity()
            android.view.VelocityTracker r0 = r8.f26946f
            float r0 = r0.getYVelocity()
            float r1 = java.lang.Math.abs(r9)
            float r4 = java.lang.Math.abs(r0)
            float r1 = java.lang.Math.max(r1, r4)
            float r4 = r8.f26945e
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 < 0) goto L_0x00a4
            ep.e r1 = r8.f26941a
            float r4 = r8.f26942b
            float r5 = r8.f26943c
            float r9 = -r9
            float r0 = -r0
            r1.a(r4, r5, r9, r0)
        L_0x00a4:
            android.view.VelocityTracker r9 = r8.f26946f
            if (r9 == 0) goto L_0x00cb
            goto L_0x0017
        L_0x00aa:
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r8.f26946f = r0
            if (r0 == 0) goto L_0x00b6
            r0.addMovement(r9)
            goto L_0x00bd
        L_0x00b6:
            java.lang.String r0 = "CupcakeGestureDetector"
            java.lang.String r3 = "Velocity tracker is null"
            android.util.Log.i(r0, r3)
        L_0x00bd:
            float r0 = r8.a((android.view.MotionEvent) r9)
            r8.f26942b = r0
            float r9 = r8.b(r9)
            r8.f26943c = r9
            r8.f26947g = r1
        L_0x00cb:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ep.a.c(android.view.MotionEvent):boolean");
    }
}
