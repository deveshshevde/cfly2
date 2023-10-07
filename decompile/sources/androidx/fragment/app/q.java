package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.a;
import com.amap.api.mapcore.util.fx;
import java.util.ArrayList;

@Deprecated
public abstract class q extends a {

    /* renamed from: a  reason: collision with root package name */
    private final FragmentManager f3415a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3416b;

    /* renamed from: c  reason: collision with root package name */
    private s f3417c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<Fragment.SavedState> f3418d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Fragment> f3419e;

    /* renamed from: f  reason: collision with root package name */
    private Fragment f3420f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3421g;

    public abstract Fragment a(int i2);

    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f3417c == null) {
            this.f3417c = this.f3415a.a();
        }
        while (this.f3418d.size() <= i2) {
            this.f3418d.add((Object) null);
        }
        this.f3418d.set(i2, fragment.isAdded() ? this.f3415a.f(fragment) : null);
        this.f3419e.set(i2, (Object) null);
        this.f3417c.a(fragment);
        if (fragment.equals(this.f3420f)) {
            this.f3420f = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void finishUpdate(ViewGroup viewGroup) {
        s sVar = this.f3417c;
        if (sVar != null) {
            if (!this.f3421g) {
                try {
                    this.f3421g = true;
                    sVar.f();
                    this.f3421g = false;
                } catch (Throwable th) {
                    this.f3421g = false;
                    throw th;
                }
            }
            this.f3417c = null;
        }
    }

    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f3419e.size() > i2 && (fragment = this.f3419e.get(i2)) != null) {
            return fragment;
        }
        if (this.f3417c == null) {
            this.f3417c = this.f3415a.a();
        }
        Fragment a2 = a(i2);
        if (this.f3418d.size() > i2 && (savedState = this.f3418d.get(i2)) != null) {
            a2.setInitialSavedState(savedState);
        }
        while (this.f3419e.size() <= i2) {
            this.f3419e.add((Object) null);
        }
        a2.setMenuVisibility(false);
        if (this.f3416b == 0) {
            a2.setUserVisibleHint(false);
        }
        this.f3419e.set(i2, a2);
        this.f3417c.a(viewGroup.getId(), a2);
        if (this.f3416b == 1) {
            this.f3417c.a(a2, Lifecycle.State.STARTED);
        }
        return a2;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f3418d.clear();
            this.f3419e.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f3418d.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith(fx.f8868i)) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a2 = this.f3415a.a(bundle, str);
                    if (a2 != null) {
                        while (this.f3419e.size() <= parseInt) {
                            this.f3419e.add((Object) null);
                        }
                        a2.setMenuVisibility(false);
                        this.f3419e.set(parseInt, a2);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    public Parcelable saveState() {
        Bundle bundle;
        if (this.f3418d.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f3418d.size()];
            this.f3418d.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i2 = 0; i2 < this.f3419e.size(); i2++) {
            Fragment fragment = this.f3419e.get(i2);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f3415a.a(bundle, fx.f8868i + i2, fragment);
            }
        }
        return bundle;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f3420f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f3416b == 1) {
                    if (this.f3417c == null) {
                        this.f3417c = this.f3415a.a();
                    }
                    this.f3417c.a(this.f3420f, Lifecycle.State.STARTED);
                } else {
                    this.f3420f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f3416b == 1) {
                if (this.f3417c == null) {
                    this.f3417c = this.f3415a.a();
                }
                this.f3417c.a(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f3420f = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }
}
