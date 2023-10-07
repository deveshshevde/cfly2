package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import t.ac;
import t.ah;
import t.ai;

public class ag implements p {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f1408a;

    /* renamed from: b  reason: collision with root package name */
    CharSequence f1409b;

    /* renamed from: c  reason: collision with root package name */
    Window.Callback f1410c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1411d;

    /* renamed from: e  reason: collision with root package name */
    private int f1412e;

    /* renamed from: f  reason: collision with root package name */
    private View f1413f;

    /* renamed from: g  reason: collision with root package name */
    private View f1414g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f1415h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f1416i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f1417j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1418k;

    /* renamed from: l  reason: collision with root package name */
    private CharSequence f1419l;

    /* renamed from: m  reason: collision with root package name */
    private CharSequence f1420m;

    /* renamed from: n  reason: collision with root package name */
    private ActionMenuPresenter f1421n;

    /* renamed from: o  reason: collision with root package name */
    private int f1422o;

    /* renamed from: p  reason: collision with root package name */
    private int f1423p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f1424q;

    public ag(Toolbar toolbar, boolean z2) {
        this(toolbar, z2, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    public ag(Toolbar toolbar, boolean z2, int i2, int i3) {
        Drawable drawable;
        this.f1422o = 0;
        this.f1423p = 0;
        this.f1408a = toolbar;
        this.f1409b = toolbar.getTitle();
        this.f1419l = toolbar.getSubtitle();
        this.f1418k = this.f1409b != null;
        this.f1417j = toolbar.getNavigationIcon();
        af a2 = af.a(toolbar.getContext(), (AttributeSet) null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.f1424q = a2.a(R.styleable.ActionBar_homeAsUpIndicator);
        if (z2) {
            CharSequence c2 = a2.c(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(c2)) {
                b(c2);
            }
            CharSequence c3 = a2.c(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c3)) {
                c(c3);
            }
            Drawable a3 = a2.a(R.styleable.ActionBar_logo);
            if (a3 != null) {
                b(a3);
            }
            Drawable a4 = a2.a(R.styleable.ActionBar_icon);
            if (a4 != null) {
                a(a4);
            }
            if (this.f1417j == null && (drawable = this.f1424q) != null) {
                c(drawable);
            }
            c(a2.a(R.styleable.ActionBar_displayOptions, 0));
            int g2 = a2.g(R.styleable.ActionBar_customNavigationLayout, 0);
            if (g2 != 0) {
                a(LayoutInflater.from(this.f1408a.getContext()).inflate(g2, this.f1408a, false));
                c(this.f1412e | 16);
            }
            int f2 = a2.f(R.styleable.ActionBar_height, 0);
            if (f2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1408a.getLayoutParams();
                layoutParams.height = f2;
                this.f1408a.setLayoutParams(layoutParams);
            }
            int d2 = a2.d(R.styleable.ActionBar_contentInsetStart, -1);
            int d3 = a2.d(R.styleable.ActionBar_contentInsetEnd, -1);
            if (d2 >= 0 || d3 >= 0) {
                this.f1408a.a(Math.max(d2, 0), Math.max(d3, 0));
            }
            int g3 = a2.g(R.styleable.ActionBar_titleTextStyle, 0);
            if (g3 != 0) {
                Toolbar toolbar2 = this.f1408a;
                toolbar2.a(toolbar2.getContext(), g3);
            }
            int g4 = a2.g(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (g4 != 0) {
                Toolbar toolbar3 = this.f1408a;
                toolbar3.b(toolbar3.getContext(), g4);
            }
            int g5 = a2.g(R.styleable.ActionBar_popupTheme, 0);
            if (g5 != 0) {
                this.f1408a.setPopupTheme(g5);
            }
        } else {
            this.f1412e = r();
        }
        a2.b();
        f(i2);
        this.f1420m = this.f1408a.getNavigationContentDescription();
        this.f1408a.setNavigationOnClickListener(new View.OnClickListener() {

            /* renamed from: a  reason: collision with root package name */
            final a f1425a;

            {
                this.f1425a = new a(ag.this.f1408a.getContext(), 0, 16908332, 0, 0, ag.this.f1409b);
            }

            public void onClick(View view) {
                if (ag.this.f1410c != null && ag.this.f1411d) {
                    ag.this.f1410c.onMenuItemSelected(0, this.f1425a);
                }
            }
        });
    }

    private void e(CharSequence charSequence) {
        this.f1409b = charSequence;
        if ((this.f1412e & 8) != 0) {
            this.f1408a.setTitle(charSequence);
        }
    }

    private int r() {
        if (this.f1408a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1424q = this.f1408a.getNavigationIcon();
        return 15;
    }

    private void s() {
        Drawable drawable;
        int i2 = this.f1412e;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) == 0 || (drawable = this.f1416i) == null) {
            drawable = this.f1415h;
        }
        this.f1408a.setLogo(drawable);
    }

    private void t() {
        Drawable drawable;
        Toolbar toolbar;
        if ((this.f1412e & 4) != 0) {
            toolbar = this.f1408a;
            drawable = this.f1417j;
            if (drawable == null) {
                drawable = this.f1424q;
            }
        } else {
            toolbar = this.f1408a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void u() {
        if ((this.f1412e & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f1420m)) {
            this.f1408a.setNavigationContentDescription(this.f1423p);
        } else {
            this.f1408a.setNavigationContentDescription(this.f1420m);
        }
    }

    public ViewGroup a() {
        return this.f1408a;
    }

    public t.ag a(final int i2, long j2) {
        return ac.r(this.f1408a).a(i2 == 0 ? 1.0f : 0.0f).a(j2).a((ah) new ai() {

            /* renamed from: c  reason: collision with root package name */
            private boolean f1429c = false;

            public void a(View view) {
                ag.this.f1408a.setVisibility(0);
            }

            public void b(View view) {
                if (!this.f1429c) {
                    ag.this.f1408a.setVisibility(i2);
                }
            }

            public void c(View view) {
                this.f1429c = true;
            }
        });
    }

    public void a(int i2) {
        a(i2 != 0 ? c.a.b(b(), i2) : null);
    }

    public void a(Drawable drawable) {
        this.f1415h = drawable;
        s();
    }

    public void a(Menu menu, m.a aVar) {
        if (this.f1421n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f1408a.getContext());
            this.f1421n = actionMenuPresenter;
            actionMenuPresenter.a(R.id.action_menu_presenter);
        }
        this.f1421n.a(aVar);
        this.f1408a.a((g) menu, this.f1421n);
    }

    public void a(View view) {
        View view2 = this.f1414g;
        if (!(view2 == null || (this.f1412e & 16) == 0)) {
            this.f1408a.removeView(view2);
        }
        this.f1414g = view;
        if (view != null && (this.f1412e & 16) != 0) {
            this.f1408a.addView(view);
        }
    }

    public void a(Window.Callback callback) {
        this.f1410c = callback;
    }

    public void a(m.a aVar, g.a aVar2) {
        this.f1408a.a(aVar, aVar2);
    }

    public void a(ScrollingTabContainerView scrollingTabContainerView) {
        Toolbar toolbar;
        View view = this.f1413f;
        if (view != null && view.getParent() == (toolbar = this.f1408a)) {
            toolbar.removeView(this.f1413f);
        }
        this.f1413f = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.f1422o == 2) {
            this.f1408a.addView(scrollingTabContainerView, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f1413f.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.f490a = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public void a(CharSequence charSequence) {
        if (!this.f1418k) {
            e(charSequence);
        }
    }

    public void a(boolean z2) {
        this.f1408a.setCollapsible(z2);
    }

    public Context b() {
        return this.f1408a.getContext();
    }

    public void b(int i2) {
        b(i2 != 0 ? c.a.b(b(), i2) : null);
    }

    public void b(Drawable drawable) {
        this.f1416i = drawable;
        s();
    }

    public void b(CharSequence charSequence) {
        this.f1418k = true;
        e(charSequence);
    }

    public void b(boolean z2) {
    }

    public void c(int i2) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i3 = this.f1412e ^ i2;
        this.f1412e = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    u();
                }
                t();
            }
            if ((i3 & 3) != 0) {
                s();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f1408a.setTitle(this.f1409b);
                    toolbar = this.f1408a;
                    charSequence = this.f1419l;
                } else {
                    charSequence = null;
                    this.f1408a.setTitle((CharSequence) null);
                    toolbar = this.f1408a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i3 & 16) != 0 && (view = this.f1414g) != null) {
                if ((i2 & 16) != 0) {
                    this.f1408a.addView(view);
                } else {
                    this.f1408a.removeView(view);
                }
            }
        }
    }

    public void c(Drawable drawable) {
        this.f1417j = drawable;
        t();
    }

    public void c(CharSequence charSequence) {
        this.f1419l = charSequence;
        if ((this.f1412e & 8) != 0) {
            this.f1408a.setSubtitle(charSequence);
        }
    }

    public boolean c() {
        return this.f1408a.g();
    }

    public void d() {
        this.f1408a.h();
    }

    public void d(int i2) {
        d((CharSequence) i2 == 0 ? null : b().getString(i2));
    }

    public void d(CharSequence charSequence) {
        this.f1420m = charSequence;
        u();
    }

    public CharSequence e() {
        return this.f1408a.getTitle();
    }

    public void e(int i2) {
        this.f1408a.setVisibility(i2);
    }

    public void f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void f(int i2) {
        if (i2 != this.f1423p) {
            this.f1423p = i2;
            if (TextUtils.isEmpty(this.f1408a.getNavigationContentDescription())) {
                d(this.f1423p);
            }
        }
    }

    public void g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean h() {
        return this.f1408a.a();
    }

    public boolean i() {
        return this.f1408a.b();
    }

    public boolean j() {
        return this.f1408a.c();
    }

    public boolean k() {
        return this.f1408a.d();
    }

    public boolean l() {
        return this.f1408a.e();
    }

    public void m() {
        this.f1411d = true;
    }

    public void n() {
        this.f1408a.f();
    }

    public int o() {
        return this.f1412e;
    }

    public int p() {
        return this.f1422o;
    }

    public Menu q() {
        return this.f1408a.getMenu();
    }
}
