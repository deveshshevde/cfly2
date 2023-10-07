package q;

import android.graphics.Typeface;
import android.os.Handler;
import q.e;
import q.f;

class a {

    /* renamed from: a  reason: collision with root package name */
    private final f.c f34112a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f34113b;

    a(f.c cVar, Handler handler) {
        this.f34112a = cVar;
        this.f34113b = handler;
    }

    private void a(final int i2) {
        final f.c cVar = this.f34112a;
        this.f34113b.post(new Runnable() {
            public void run() {
                cVar.a(i2);
            }
        });
    }

    private void a(final Typeface typeface) {
        final f.c cVar = this.f34112a;
        this.f34113b.post(new Runnable() {
            public void run() {
                cVar.a(typeface);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(e.a aVar) {
        if (aVar.a()) {
            a(aVar.f34141a);
        } else {
            a(aVar.f34142b);
        }
    }
}
