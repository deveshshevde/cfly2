package com.google.android.exoplayer2.util;

import android.os.Handler;
import com.google.android.exoplayer2.util.g;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class g<T> {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<b<T>> f17109a = new CopyOnWriteArrayList<>();

    public interface a<T> {
        void sendTo(T t2);
    }

    private static final class b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f17110a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final T f17111b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f17112c;

        public b(Handler handler, T t2) {
            this.f17110a = handler;
            this.f17111b = t2;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(a aVar) {
            if (!this.f17112c) {
                aVar.sendTo(this.f17111b);
            }
        }

        public void a() {
            this.f17112c = true;
        }

        public void a(a<T> aVar) {
            this.f17110a.post(new Runnable(aVar) {
                public final /* synthetic */ g.a f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    g.b.this.b(this.f$1);
                }
            });
        }
    }

    public void a(Handler handler, T t2) {
        a.a((handler == null || t2 == null) ? false : true);
        a(t2);
        this.f17109a.add(new b(handler, t2));
    }

    public void a(a<T> aVar) {
        Iterator<b<T>> it2 = this.f17109a.iterator();
        while (it2.hasNext()) {
            it2.next().a(aVar);
        }
    }

    public void a(T t2) {
        Iterator<b<T>> it2 = this.f17109a.iterator();
        while (it2.hasNext()) {
            b next = it2.next();
            if (next.f17111b == t2) {
                next.a();
                this.f17109a.remove(next);
            }
        }
    }
}
