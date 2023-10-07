package gr;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final View f28566a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f28567b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f28568c = 0;

    public c(b bVar) {
        this.f28566a = (View) bVar;
    }

    private void d() {
        ViewParent parent = this.f28566a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).b(this.f28566a);
        }
    }

    public void a(int i2) {
        this.f28568c = i2;
    }

    public void a(Bundle bundle) {
        this.f28567b = bundle.getBoolean("expanded", false);
        this.f28568c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f28567b) {
            d();
        }
    }

    public boolean a() {
        return this.f28567b;
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f28567b);
        bundle.putInt("expandedComponentIdHint", this.f28568c);
        return bundle;
    }

    public int c() {
        return this.f28568c;
    }
}
