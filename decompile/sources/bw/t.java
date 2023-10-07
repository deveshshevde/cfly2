package bw;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class t extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final a f6100a;

    /* renamed from: b  reason: collision with root package name */
    private final q f6101b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<t> f6102c;

    /* renamed from: d  reason: collision with root package name */
    private t f6103d;

    /* renamed from: e  reason: collision with root package name */
    private h f6104e;

    /* renamed from: f  reason: collision with root package name */
    private Fragment f6105f;

    private class a implements q {
        a() {
        }

        public Set<h> a() {
            Set<t> d2 = t.this.d();
            HashSet hashSet = new HashSet(d2.size());
            for (t next : d2) {
                if (next.b() != null) {
                    hashSet.add(next.b());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + t.this + "}";
        }
    }

    public t() {
        this(new a());
    }

    public t(a aVar) {
        this.f6101b = new a();
        this.f6102c = new HashSet();
        this.f6100a = aVar;
    }

    private void a(Context context, FragmentManager fragmentManager) {
        f();
        t a2 = c.a(context).g().a(fragmentManager);
        this.f6103d = a2;
        if (!equals(a2)) {
            this.f6103d.a(this);
        }
    }

    private void a(t tVar) {
        this.f6102c.add(tVar);
    }

    private static FragmentManager b(Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private void b(t tVar) {
        this.f6102c.remove(tVar);
    }

    private boolean c(Fragment fragment) {
        Fragment e2 = e();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(e2)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private Fragment e() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f6105f;
    }

    private void f() {
        t tVar = this.f6103d;
        if (tVar != null) {
            tVar.b(this);
            this.f6103d = null;
        }
    }

    /* access modifiers changed from: package-private */
    public a a() {
        return this.f6100a;
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        FragmentManager b2;
        this.f6105f = fragment;
        if (fragment != null && fragment.getContext() != null && (b2 = b(fragment)) != null) {
            a(fragment.getContext(), b2);
        }
    }

    public void a(h hVar) {
        this.f6104e = hVar;
    }

    public h b() {
        return this.f6104e;
    }

    public q c() {
        return this.f6101b;
    }

    /* access modifiers changed from: package-private */
    public Set<t> d() {
        t tVar = this.f6103d;
        if (tVar == null) {
            return Collections.emptySet();
        }
        if (equals(tVar)) {
            return Collections.unmodifiableSet(this.f6102c);
        }
        HashSet hashSet = new HashSet();
        for (t next : this.f6103d.d()) {
            if (c(next.e())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager b2 = b((Fragment) this);
        if (b2 != null) {
            try {
                a(getContext(), b2);
            } catch (IllegalStateException e2) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e2);
                }
            }
        } else if (Log.isLoggable("SupportRMFragment", 5)) {
            Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f6100a.c();
        f();
    }

    public void onDetach() {
        super.onDetach();
        this.f6105f = null;
        f();
    }

    public void onStart() {
        super.onStart();
        this.f6100a.a();
    }

    public void onStop() {
        super.onStop();
        this.f6100a.b();
    }

    public String toString() {
        return super.toString() + "{parent=" + e() + "}";
    }
}
