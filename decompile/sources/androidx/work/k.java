package androidx.work;

import android.os.Build;
import androidx.work.q;

public final class k extends q {

    public static final class a extends q.a<a, k> {
        public a(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.f5458c.f5498d = OverwritingInputMerger.class.getName();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public k d() {
            if (!this.f5456a || Build.VERSION.SDK_INT < 23 || !this.f5458c.f5504j.c()) {
                return new k(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public a c() {
            return this;
        }
    }

    k(a aVar) {
        super(aVar.f5457b, aVar.f5458c, aVar.f5459d);
    }

    public static k a(Class<? extends ListenableWorker> cls) {
        return (k) new a(cls).e();
    }
}
