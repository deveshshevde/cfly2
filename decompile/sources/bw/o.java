package bw;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public class o extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final a f6060a;

    /* renamed from: b  reason: collision with root package name */
    private final q f6061b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<o> f6062c;

    /* renamed from: d  reason: collision with root package name */
    private h f6063d;

    /* renamed from: e  reason: collision with root package name */
    private o f6064e;

    /* renamed from: f  reason: collision with root package name */
    private Fragment f6065f;

    private class a implements q {
        a() {
        }

        public Set<h> a() {
            Set<o> d2 = o.this.d();
            HashSet hashSet = new HashSet(d2.size());
            for (o next : d2) {
                if (next.b() != null) {
                    hashSet.add(next.b());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + o.this + "}";
        }
    }

    public o() {
        this(new a());
    }

    o(a aVar) {
        this.f6061b = new a();
        this.f6062c = new HashSet();
        this.f6060a = aVar;
    }

    private void a(Activity activity) {
        f();
        o b2 = c.a((Context) activity).g().b(activity);
        this.f6064e = b2;
        if (!equals(b2)) {
            this.f6064e.a(this);
        }
    }

    private void a(o oVar) {
        this.f6062c.add(oVar);
    }

    private void b(o oVar) {
        this.f6062c.remove(oVar);
    }

    private boolean b(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private Fragment e() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f6065f;
    }

    private void f() {
        o oVar = this.f6064e;
        if (oVar != null) {
            oVar.b(this);
            this.f6064e = null;
        }
    }

    /* access modifiers changed from: package-private */
    public a a() {
        return this.f6060a;
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        this.f6065f = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            a(fragment.getActivity());
        }
    }

    public void a(h hVar) {
        this.f6063d = hVar;
    }

    public h b() {
        return this.f6063d;
    }

    public q c() {
        return this.f6061b;
    }

    /* access modifiers changed from: package-private */
    public Set<o> d() {
        if (equals(this.f6064e)) {
            return Collections.unmodifiableSet(this.f6062c);
        }
        if (this.f6064e == null || Build.VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (o next : this.f6064e.d()) {
            if (b(next.getParentFragment())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f6060a.c();
        f();
    }

    public void onDetach() {
        super.onDetach();
        f();
    }

    public void onStart() {
        super.onStart();
        this.f6060a.a();
    }

    public void onStop() {
        super.onStop();
        this.f6060a.b();
    }

    public String toString() {
        return super.toString() + "{parent=" + e() + "}";
    }
}
