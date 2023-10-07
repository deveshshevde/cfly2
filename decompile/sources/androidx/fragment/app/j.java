package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class j {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f3395a = new CopyOnWriteArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final FragmentManager f3396b;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        final FragmentManager.c f3397a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f3398b;

        a(FragmentManager.c cVar, boolean z2) {
            this.f3397a = cVar;
            this.f3398b = z2;
        }
    }

    j(FragmentManager fragmentManager) {
        this.f3396b = fragmentManager;
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment n2 = this.f3396b.n();
        if (n2 != null) {
            n2.getParentFragmentManager().G().a(fragment, bundle, true);
        }
        Iterator<a> it2 = this.f3395a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z2 || next.f3398b) {
                next.f3397a.a(this.f3396b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, View view, Bundle bundle, boolean z2) {
        Fragment n2 = this.f3396b.n();
        if (n2 != null) {
            n2.getParentFragmentManager().G().a(fragment, view, bundle, true);
        }
        Iterator<a> it2 = this.f3395a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z2 || next.f3398b) {
                next.f3397a.a(this.f3396b, fragment, view, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, boolean z2) {
        Context g2 = this.f3396b.m().g();
        Fragment n2 = this.f3396b.n();
        if (n2 != null) {
            n2.getParentFragmentManager().G().a(fragment, true);
        }
        Iterator<a> it2 = this.f3395a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z2 || next.f3398b) {
                next.f3397a.a(this.f3396b, fragment, g2);
            }
        }
    }

    public void a(FragmentManager.c cVar) {
        synchronized (this.f3395a) {
            int i2 = 0;
            int size = this.f3395a.size();
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (this.f3395a.get(i2).f3397a == cVar) {
                    this.f3395a.remove(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
    }

    public void a(FragmentManager.c cVar, boolean z2) {
        this.f3395a.add(new a(cVar, z2));
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment n2 = this.f3396b.n();
        if (n2 != null) {
            n2.getParentFragmentManager().G().b(fragment, bundle, true);
        }
        Iterator<a> it2 = this.f3395a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z2 || next.f3398b) {
                next.f3397a.b(this.f3396b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment, boolean z2) {
        Context g2 = this.f3396b.m().g();
        Fragment n2 = this.f3396b.n();
        if (n2 != null) {
            n2.getParentFragmentManager().G().b(fragment, true);
        }
        Iterator<a> it2 = this.f3395a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z2 || next.f3398b) {
                next.f3397a.b(this.f3396b, fragment, g2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment n2 = this.f3396b.n();
        if (n2 != null) {
            n2.getParentFragmentManager().G().c(fragment, bundle, true);
        }
        Iterator<a> it2 = this.f3395a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z2 || next.f3398b) {
                next.f3397a.c(this.f3396b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Fragment fragment, boolean z2) {
        Fragment n2 = this.f3396b.n();
        if (n2 != null) {
            n2.getParentFragmentManager().G().c(fragment, true);
        }
        Iterator<a> it2 = this.f3395a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z2 || next.f3398b) {
                next.f3397a.a(this.f3396b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment n2 = this.f3396b.n();
        if (n2 != null) {
            n2.getParentFragmentManager().G().d(fragment, bundle, true);
        }
        Iterator<a> it2 = this.f3395a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z2 || next.f3398b) {
                next.f3397a.d(this.f3396b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Fragment fragment, boolean z2) {
        Fragment n2 = this.f3396b.n();
        if (n2 != null) {
            n2.getParentFragmentManager().G().d(fragment, true);
        }
        Iterator<a> it2 = this.f3395a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z2 || next.f3398b) {
                next.f3397a.b(this.f3396b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(Fragment fragment, boolean z2) {
        Fragment n2 = this.f3396b.n();
        if (n2 != null) {
            n2.getParentFragmentManager().G().e(fragment, true);
        }
        Iterator<a> it2 = this.f3395a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z2 || next.f3398b) {
                next.f3397a.c(this.f3396b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment, boolean z2) {
        Fragment n2 = this.f3396b.n();
        if (n2 != null) {
            n2.getParentFragmentManager().G().f(fragment, true);
        }
        Iterator<a> it2 = this.f3395a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z2 || next.f3398b) {
                next.f3397a.d(this.f3396b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(Fragment fragment, boolean z2) {
        Fragment n2 = this.f3396b.n();
        if (n2 != null) {
            n2.getParentFragmentManager().G().g(fragment, true);
        }
        Iterator<a> it2 = this.f3395a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z2 || next.f3398b) {
                next.f3397a.e(this.f3396b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h(Fragment fragment, boolean z2) {
        Fragment n2 = this.f3396b.n();
        if (n2 != null) {
            n2.getParentFragmentManager().G().h(fragment, true);
        }
        Iterator<a> it2 = this.f3395a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z2 || next.f3398b) {
                next.f3397a.f(this.f3396b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i(Fragment fragment, boolean z2) {
        Fragment n2 = this.f3396b.n();
        if (n2 != null) {
            n2.getParentFragmentManager().G().i(fragment, true);
        }
        Iterator<a> it2 = this.f3395a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z2 || next.f3398b) {
                next.f3397a.g(this.f3396b, fragment);
            }
        }
    }
}
