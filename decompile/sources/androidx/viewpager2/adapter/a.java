package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.s;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.amap.api.mapcore.util.fx;
import j.d;

public abstract class a extends RecyclerView.Adapter<b> implements c {

    /* renamed from: a  reason: collision with root package name */
    final Lifecycle f4970a;

    /* renamed from: b  reason: collision with root package name */
    final FragmentManager f4971b;

    /* renamed from: c  reason: collision with root package name */
    final d<Fragment> f4972c;

    /* renamed from: d  reason: collision with root package name */
    private C0042a f4973d;

    /* renamed from: androidx.viewpager2.adapter.a$a  reason: collision with other inner class name */
    class C0042a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f4977a;

        /* renamed from: b  reason: collision with root package name */
        private ViewPager2 f4978b;

        /* renamed from: c  reason: collision with root package name */
        private long f4979c;

        /* access modifiers changed from: package-private */
        public void a(boolean z2) {
            int currentItem;
            Fragment a2;
            if (!this.f4977a.a() && this.f4978b.getScrollState() == 0 && !this.f4977a.f4972c.c() && this.f4977a.getItemCount() != 0 && (currentItem = this.f4978b.getCurrentItem()) < this.f4977a.getItemCount()) {
                long itemId = this.f4977a.getItemId(currentItem);
                if ((itemId != this.f4979c || z2) && (a2 = this.f4977a.f4972c.a(itemId)) != null && a2.isAdded()) {
                    this.f4979c = itemId;
                    s a3 = this.f4977a.f4971b.a();
                    Fragment fragment = null;
                    for (int i2 = 0; i2 < this.f4977a.f4972c.b(); i2++) {
                        long b2 = this.f4977a.f4972c.b(i2);
                        Fragment c2 = this.f4977a.f4972c.c(i2);
                        if (c2.isAdded()) {
                            if (b2 != this.f4979c) {
                                a3.a(c2, Lifecycle.State.STARTED);
                            } else {
                                fragment = c2;
                            }
                            c2.setMenuVisibility(b2 == this.f4979c);
                        }
                    }
                    if (fragment != null) {
                        a3.a(fragment, Lifecycle.State.RESUMED);
                    }
                    if (!a3.j()) {
                        a3.e();
                    }
                }
            }
        }
    }

    private void a(final Fragment fragment, final FrameLayout frameLayout) {
        this.f4971b.a((FragmentManager.c) new FragmentManager.c() {
            public void a(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
                if (fragment == fragment) {
                    fragmentManager.a((FragmentManager.c) this);
                    a.this.a(view, frameLayout);
                }
            }
        }, false);
    }

    /* access modifiers changed from: package-private */
    public void a(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        Fragment a2 = this.f4972c.a(bVar.getItemId());
        if (a2 != null) {
            FrameLayout a3 = bVar.a();
            View view = a2.getView();
            if (!a2.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            } else if (a2.isAdded() && view == null) {
                a(a2, a3);
            } else if (!a2.isAdded() || view.getParent() == null) {
                if (a2.isAdded()) {
                    a(view, a3);
                } else if (!a()) {
                    a(a2, a3);
                    s a4 = this.f4971b.a();
                    a4.a(a2, fx.f8868i + bVar.getItemId()).a(a2, Lifecycle.State.STARTED).e();
                    this.f4973d.a(false);
                } else if (!this.f4971b.h()) {
                    this.f4970a.a(new FragmentStateAdapter$2(this, bVar));
                }
            } else if (view.getParent() != a3) {
                a(view, a3);
            }
        } else {
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f4971b.i();
    }

    public long getItemId(int i2) {
        return (long) i2;
    }
}
