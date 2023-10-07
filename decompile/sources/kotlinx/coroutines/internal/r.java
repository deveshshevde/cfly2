package kotlinx.coroutines.internal;

import kotlinx.coroutines.ah;

public abstract class r {
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r7 = r7.b();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(kotlinx.coroutines.internal.r r7) {
        /*
            r6 = this;
            kotlinx.coroutines.internal.c r0 = r6.b()
            r1 = 0
            if (r0 == 0) goto L_0x001a
            kotlinx.coroutines.internal.c r7 = r7.b()
            if (r7 == 0) goto L_0x001a
            long r2 = r0.a()
            long r4 = r7.a()
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x001a
            r1 = 1
        L_0x001a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.r.a(kotlinx.coroutines.internal.r):boolean");
    }

    public abstract c<?> b();

    public abstract Object c(Object obj);

    public String toString() {
        return ah.b(this) + '@' + ah.a((Object) this);
    }
}
