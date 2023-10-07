package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.core.os.d;
import androidx.work.n;

public class a implements n {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f5164a = d.a(Looper.getMainLooper());

    public void a(long j2, Runnable runnable) {
        this.f5164a.postDelayed(runnable, j2);
    }

    public void a(Runnable runnable) {
        this.f5164a.removeCallbacks(runnable);
    }
}
