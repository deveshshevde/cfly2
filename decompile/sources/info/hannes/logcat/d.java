package info.hannes.logcat;

import android.content.Context;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.n;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import kotlin.jvm.internal.h;

public final class d extends n implements TabHost.OnTabChangeListener, ViewPager.e {

    /* renamed from: a  reason: collision with root package name */
    private final Context f28662a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Fragment> f28663b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final TabHost f28664c;

    /* renamed from: d  reason: collision with root package name */
    private final ViewPager f28665d;

    private static final class a implements TabHost.TabContentFactory {

        /* renamed from: a  reason: collision with root package name */
        private final Context f28666a;

        public a(Context context) {
            h.d(context, "contextView");
            this.f28666a = context;
        }

        public View createTabContent(String str) {
            h.d(str, "tag");
            View view = new View(this.f28666a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(FragmentActivity fragmentActivity, TabHost tabHost, ViewPager viewPager) {
        super(fragmentActivity.getSupportFragmentManager());
        h.d(fragmentActivity, "activity");
        h.d(tabHost, "tabHost");
        h.d(viewPager, "viewPager");
        this.f28664c = tabHost;
        this.f28665d = viewPager;
        this.f28662a = fragmentActivity;
        tabHost.setOnTabChangedListener(this);
        viewPager.setAdapter(this);
        viewPager.addOnPageChangeListener(this);
    }

    public final void a(TabHost.TabSpec tabSpec, Fragment fragment) {
        h.d(tabSpec, "tabSpec");
        h.d(fragment, "fragment");
        tabSpec.setContent(new a(this.f28662a));
        this.f28664c.addTab(tabSpec);
        this.f28663b.add(fragment);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f28663b.size();
    }

    public Fragment getItem(int i2) {
        Fragment fragment = this.f28663b.get(i2);
        h.b(fragment, "fragments.get(position)");
        return fragment;
    }

    public void onPageScrollStateChanged(int i2) {
    }

    public void onPageScrolled(int i2, float f2, int i3) {
    }

    public void onPageSelected(int i2) {
        TabWidget tabWidget = this.f28664c.getTabWidget();
        h.b(tabWidget, "widget");
        int descendantFocusability = tabWidget.getDescendantFocusability();
        tabWidget.setDescendantFocusability(393216);
        try {
            this.f28664c.setCurrentTab(i2);
        } catch (Exception unused) {
        }
        tabWidget.setDescendantFocusability(descendantFocusability);
    }

    public void onTabChanged(String str) {
        h.d(str, "tabId");
        this.f28665d.setCurrentItem(this.f28664c.getCurrentTab());
    }
}
