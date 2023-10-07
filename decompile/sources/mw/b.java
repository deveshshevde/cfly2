package mw;

import android.os.Handler;
import android.os.Looper;
import java.util.LinkedList;
import java.util.Queue;
import me.yokeyword.fragmentation.c;
import me.yokeyword.fragmentation.g;

public class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Queue<a> f31292a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    private Handler f31293b;

    public b(Handler handler) {
        this.f31293b = handler;
    }

    /* access modifiers changed from: private */
    public void a() {
        if (!this.f31292a.isEmpty()) {
            a peek = this.f31292a.peek();
            peek.a();
            c(peek);
        }
    }

    /* access modifiers changed from: private */
    public void b(a aVar) {
        this.f31292a.add(aVar);
        if (this.f31292a.size() == 1) {
            a();
        }
    }

    private void c(a aVar) {
        if (aVar.f31290d == 1) {
            c b2 = g.b(aVar.f31289c);
            aVar.f31291e = b2 == null ? 300 : b2.i().m();
        }
        this.f31293b.postDelayed(new Runnable() {
            public void run() {
                b.this.f31292a.poll();
                b.this.a();
            }
        }, aVar.f31291e);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r2 = r1.f31292a.peek();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean d(mw.a r2) {
        /*
            r1 = this;
            int r2 = r2.f31290d
            r0 = 3
            if (r2 != r0) goto L_0x0015
            java.util.Queue<mw.a> r2 = r1.f31292a
            java.lang.Object r2 = r2.peek()
            mw.a r2 = (mw.a) r2
            if (r2 == 0) goto L_0x0015
            int r2 = r2.f31290d
            r0 = 1
            if (r2 != r0) goto L_0x0015
            return r0
        L_0x0015:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: mw.b.d(mw.a):boolean");
    }

    public void a(final a aVar) {
        if (!d(aVar)) {
            if (aVar.f31290d == 4 && this.f31292a.isEmpty() && Thread.currentThread() == Looper.getMainLooper().getThread()) {
                aVar.a();
            } else {
                this.f31293b.post(new Runnable() {
                    public void run() {
                        b.this.b(aVar);
                    }
                });
            }
        }
    }
}
