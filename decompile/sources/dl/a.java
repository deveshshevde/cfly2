package dl;

import android.content.Context;
import android.view.ViewConfiguration;

public class a {

    /* renamed from: a  reason: collision with root package name */
    C0166a f26748a;

    /* renamed from: b  reason: collision with root package name */
    final float f26749b;

    /* renamed from: c  reason: collision with root package name */
    boolean f26750c;

    /* renamed from: d  reason: collision with root package name */
    boolean f26751d;

    /* renamed from: e  reason: collision with root package name */
    long f26752e;

    /* renamed from: f  reason: collision with root package name */
    float f26753f;

    /* renamed from: g  reason: collision with root package name */
    float f26754g;

    /* renamed from: dl.a$a  reason: collision with other inner class name */
    public interface C0166a {
        boolean i();
    }

    public a(Context context) {
        this.f26749b = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        a();
    }

    public static a a(Context context) {
        return new a(context);
    }

    public void a() {
        this.f26748a = null;
        b();
    }

    public void a(C0166a aVar) {
        this.f26748a = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        if (java.lang.Math.abs(r8.getY() - r7.f26754g) <= r7.f26749b) goto L_0x0093;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getAction()
            r1 = 1
            if (r0 == 0) goto L_0x007d
            r2 = 0
            if (r0 == r1) goto L_0x003b
            r3 = 2
            if (r0 == r3) goto L_0x0018
            r8 = 3
            if (r0 == r8) goto L_0x0012
            goto L_0x0093
        L_0x0012:
            r7.f26750c = r2
        L_0x0014:
            r7.f26751d = r2
            goto L_0x0093
        L_0x0018:
            float r0 = r8.getX()
            float r3 = r7.f26753f
            float r0 = r0 - r3
            float r0 = java.lang.Math.abs(r0)
            float r3 = r7.f26749b
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x0014
            float r8 = r8.getY()
            float r0 = r7.f26754g
            float r8 = r8 - r0
            float r8 = java.lang.Math.abs(r8)
            float r0 = r7.f26749b
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 <= 0) goto L_0x0093
            goto L_0x0014
        L_0x003b:
            r7.f26750c = r2
            float r0 = r8.getX()
            float r3 = r7.f26753f
            float r0 = r0 - r3
            float r0 = java.lang.Math.abs(r0)
            float r3 = r7.f26749b
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x005f
            float r0 = r8.getY()
            float r3 = r7.f26754g
            float r0 = r0 - r3
            float r0 = java.lang.Math.abs(r0)
            float r3 = r7.f26749b
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0061
        L_0x005f:
            r7.f26751d = r2
        L_0x0061:
            boolean r0 = r7.f26751d
            if (r0 == 0) goto L_0x0014
            long r3 = r8.getEventTime()
            long r5 = r7.f26752e
            long r3 = r3 - r5
            int r8 = android.view.ViewConfiguration.getLongPressTimeout()
            long r5 = (long) r8
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 > 0) goto L_0x0014
            dl.a$a r8 = r7.f26748a
            if (r8 == 0) goto L_0x0014
            r8.i()
            goto L_0x0014
        L_0x007d:
            r7.f26750c = r1
            r7.f26751d = r1
            long r2 = r8.getEventTime()
            r7.f26752e = r2
            float r0 = r8.getX()
            r7.f26753f = r0
            float r8 = r8.getY()
            r7.f26754g = r8
        L_0x0093:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dl.a.a(android.view.MotionEvent):boolean");
    }

    public void b() {
        this.f26750c = false;
        this.f26751d = false;
    }

    public boolean c() {
        return this.f26750c;
    }
}
