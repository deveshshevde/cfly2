package org.greenrobot.eventbus;

import android.os.Looper;

public interface g {

    public static class a implements g {

        /* renamed from: a  reason: collision with root package name */
        private final Looper f14045a;

        public a(Looper looper) {
            this.f14045a = looper;
        }

        public k a(c cVar) {
            return new e(cVar, this.f14045a, 10);
        }

        public boolean a() {
            return this.f14045a == Looper.myLooper();
        }
    }

    k a(c cVar);

    boolean a();
}
