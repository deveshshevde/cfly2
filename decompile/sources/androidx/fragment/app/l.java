package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.aa;
import androidx.lifecycle.ab;
import androidx.lifecycle.ac;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

final class l extends aa {

    /* renamed from: a  reason: collision with root package name */
    private static final ab.b f3399a = new ab.b() {
        public <T extends aa> T a(Class<T> cls) {
            return new l(true);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Fragment> f3400b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, l> f3401c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, ac> f3402d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private final boolean f3403e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3404f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3405g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3406h = false;

    l(boolean z2) {
        this.f3403e = z2;
    }

    static l a(ac acVar) {
        return (l) new ab(acVar, f3399a).a(l.class);
    }

    /* access modifiers changed from: package-private */
    public Fragment a(String str) {
        return this.f3400b.get(str);
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f3404f = true;
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (this.f3406h) {
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (!this.f3400b.containsKey(fragment.mWho)) {
            this.f3400b.put(fragment.mWho, fragment);
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.f3406h = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f3404f;
    }

    /* access modifiers changed from: package-private */
    public boolean b(Fragment fragment) {
        if (!this.f3400b.containsKey(fragment.mWho)) {
            return true;
        }
        return this.f3403e ? this.f3404f : !this.f3405g;
    }

    /* access modifiers changed from: package-private */
    public Collection<Fragment> c() {
        return new ArrayList(this.f3400b.values());
    }

    /* access modifiers changed from: package-private */
    public void c(Fragment fragment) {
        if (!this.f3406h) {
            if ((this.f3400b.remove(fragment.mWho) != null) && FragmentManager.a(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
            }
        } else if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
        }
    }

    /* access modifiers changed from: package-private */
    public l d(Fragment fragment) {
        l lVar = this.f3401c.get(fragment.mWho);
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this.f3403e);
        this.f3401c.put(fragment.mWho, lVar2);
        return lVar2;
    }

    /* access modifiers changed from: package-private */
    public ac e(Fragment fragment) {
        ac acVar = this.f3402d.get(fragment.mWho);
        if (acVar != null) {
            return acVar;
        }
        ac acVar2 = new ac();
        this.f3402d.put(fragment.mWho, acVar2);
        return acVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f3400b.equals(lVar.f3400b) && this.f3401c.equals(lVar.f3401c) && this.f3402d.equals(lVar.f3402d);
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment) {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        l lVar = this.f3401c.get(fragment.mWho);
        if (lVar != null) {
            lVar.a();
            this.f3401c.remove(fragment.mWho);
        }
        ac acVar = this.f3402d.get(fragment.mWho);
        if (acVar != null) {
            acVar.b();
            this.f3402d.remove(fragment.mWho);
        }
    }

    public int hashCode() {
        return (((this.f3400b.hashCode() * 31) + this.f3401c.hashCode()) * 31) + this.f3402d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it2 = this.f3400b.values().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it3 = this.f3401c.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it4 = this.f3402d.keySet().iterator();
        while (it4.hasNext()) {
            sb.append(it4.next());
            if (it4.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
