package me.yokeyword.fragmentation.helper.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.x;
import java.util.List;
import me.yokeyword.fragmentation.c;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f31190a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f31191b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31192c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f31193d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f31194e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31195f = false;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Runnable f31196g;

    /* renamed from: h  reason: collision with root package name */
    private Handler f31197h;

    /* renamed from: i  reason: collision with root package name */
    private Bundle f31198i;

    /* renamed from: j  reason: collision with root package name */
    private c f31199j;

    /* renamed from: k  reason: collision with root package name */
    private Fragment f31200k;

    public b(c cVar) {
        this.f31199j = cVar;
        this.f31200k = (Fragment) cVar;
    }

    private boolean a(Fragment fragment) {
        return !fragment.isHidden() && fragment.getUserVisibleHint();
    }

    private void c(boolean z2) {
        if (!this.f31193d) {
            d(z2);
        } else if (z2) {
            h();
        }
    }

    /* access modifiers changed from: private */
    public void d(boolean z2) {
        if (z2 && i()) {
            return;
        }
        if (this.f31190a == z2) {
            this.f31191b = true;
            return;
        }
        this.f31190a = z2;
        if (!z2) {
            e(false);
            this.f31199j.i_();
        } else if (!j()) {
            this.f31199j.h_();
            if (this.f31193d) {
                this.f31193d = false;
                this.f31199j.b(this.f31198i);
            }
            e(true);
        }
    }

    private void e() {
        if (!this.f31192c && !this.f31200k.isHidden() && this.f31200k.getUserVisibleHint()) {
            if ((this.f31200k.getParentFragment() != null && a(this.f31200k.getParentFragment())) || this.f31200k.getParentFragment() == null) {
                this.f31191b = false;
                c(true);
            }
        }
    }

    private void e(boolean z2) {
        List<Fragment> c2;
        if (!this.f31191b) {
            this.f31191b = true;
        } else if (!j() && (c2 = x.c(this.f31200k.getChildFragmentManager())) != null) {
            for (Fragment next : c2) {
                if ((next instanceof c) && !next.isHidden() && next.getUserVisibleHint()) {
                    ((c) next).i().k().d(z2);
                }
            }
        }
    }

    private void f() {
        this.f31192c = false;
        g();
    }

    private void g() {
        List<Fragment> c2 = x.c(this.f31200k.getChildFragmentManager());
        if (c2 != null) {
            for (Fragment next : c2) {
                if ((next instanceof c) && !next.isHidden() && next.getUserVisibleHint()) {
                    ((c) next).i().k().f();
                }
            }
        }
    }

    private void h() {
        this.f31196g = new Runnable() {
            public void run() {
                Runnable unused = b.this.f31196g = null;
                b.this.d(true);
            }
        };
        k().post(this.f31196g);
    }

    private boolean i() {
        Fragment parentFragment = this.f31200k.getParentFragment();
        return parentFragment instanceof c ? !((c) parentFragment).j() : parentFragment != null && !parentFragment.isVisible();
    }

    private boolean j() {
        if (this.f31200k.isAdded()) {
            return false;
        }
        this.f31190a = !this.f31190a;
        return true;
    }

    private Handler k() {
        if (this.f31197h == null) {
            this.f31197h = new Handler(Looper.getMainLooper());
        }
        return this.f31197h;
    }

    public void a() {
        if (!this.f31193d) {
            if (!this.f31190a && !this.f31192c && a(this.f31200k)) {
                this.f31191b = false;
                d(true);
            }
        } else if (this.f31195f) {
            this.f31195f = false;
            e();
        }
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            this.f31198i = bundle;
            this.f31192c = bundle.getBoolean("fragmentation_invisible_when_leave");
            this.f31194e = bundle.getBoolean("fragmentation_compat_replace");
        }
    }

    public void a(boolean z2) {
        if (!z2 && !this.f31200k.isResumed()) {
            f();
        } else if (z2) {
            c(false);
        } else {
            h();
        }
    }

    public void b() {
        if (this.f31196g != null) {
            k().removeCallbacks(this.f31196g);
            this.f31195f = true;
        } else if (!this.f31190a || !a(this.f31200k)) {
            this.f31192c = true;
        } else {
            this.f31191b = false;
            this.f31192c = false;
            d(false);
        }
    }

    public void b(Bundle bundle) {
        bundle.putBoolean("fragmentation_invisible_when_leave", this.f31192c);
        bundle.putBoolean("fragmentation_compat_replace", this.f31194e);
    }

    public void b(boolean z2) {
        if (this.f31200k.isResumed() || (!this.f31200k.isAdded() && z2)) {
            boolean z3 = this.f31190a;
            if (!z3 && z2) {
                c(true);
            } else if (z3 && !z2) {
                d(false);
            }
        }
    }

    public void c() {
        this.f31193d = true;
    }

    public void c(Bundle bundle) {
        if (this.f31194e || this.f31200k.getTag() == null || !this.f31200k.getTag().startsWith("android:switcher:")) {
            if (this.f31194e) {
                this.f31194e = false;
            }
            e();
        }
    }

    public boolean d() {
        return this.f31190a;
    }
}
