package androidx.viewpager2.adapter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.n;
import t.ac;

class FragmentStateAdapter$2 implements k {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4965a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f4966b;

    FragmentStateAdapter$2(a aVar, b bVar) {
        this.f4966b = aVar;
        this.f4965a = bVar;
    }

    public void a(n nVar, Lifecycle.Event event) {
        if (!this.f4966b.a()) {
            nVar.getLifecycle().b(this);
            if (ac.J(this.f4965a.a())) {
                this.f4966b.a(this.f4965a);
            }
        }
    }
}
