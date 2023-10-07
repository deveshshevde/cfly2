package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.n;

class FragmentStateAdapter$5 implements k {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Handler f4967a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Runnable f4968b;

    public void a(n nVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f4967a.removeCallbacks(this.f4968b);
            nVar.getLifecycle().b(this);
        }
    }
}
