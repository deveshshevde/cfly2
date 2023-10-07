package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.m;
import java.util.concurrent.Executor;

public final class j<L> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f17610a;

    /* renamed from: b  reason: collision with root package name */
    private volatile L f17611b;

    /* renamed from: c  reason: collision with root package name */
    private volatile a<L> f17612c;

    public static final class a<L> {

        /* renamed from: a  reason: collision with root package name */
        private final L f17613a;

        /* renamed from: b  reason: collision with root package name */
        private final String f17614b;

        a(L l2, String str) {
            this.f17613a = l2;
            this.f17614b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f17613a == aVar.f17613a && this.f17614b.equals(aVar.f17614b);
        }

        public int hashCode() {
            return (System.identityHashCode(this.f17613a) * 31) + this.f17614b.hashCode();
        }
    }

    public interface b<L> {
        void notifyListener(L l2);

        void onNotifyListenerFailed();
    }

    j(Looper looper, L l2, String str) {
        this.f17610a = new gh.a(looper);
        this.f17611b = m.a(l2, (Object) "Listener must not be null");
        this.f17612c = new a<>(l2, m.a(str));
    }

    public a<L> a() {
        return this.f17612c;
    }

    public void a(b<? super L> bVar) {
        m.a(bVar, (Object) "Notifier must not be null");
        this.f17610a.execute(new br(this, bVar));
    }

    public void b() {
        this.f17611b = null;
        this.f17612c = null;
    }

    /* access modifiers changed from: package-private */
    public final void b(b<? super L> bVar) {
        L l2 = this.f17611b;
        if (l2 == null) {
            bVar.onNotifyListenerFailed();
            return;
        }
        try {
            bVar.notifyListener(l2);
        } catch (RuntimeException e2) {
            bVar.onNotifyListenerFailed();
            throw e2;
        }
    }
}
