package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.p;
import f.b;
import f.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import t.ac;
import t.ag;
import t.ah;
import t.ai;
import t.aj;

public class m extends ActionBar implements ActionBarOverlayLayout.a {

    /* renamed from: s  reason: collision with root package name */
    private static final Interpolator f709s = new AccelerateInterpolator();

    /* renamed from: t  reason: collision with root package name */
    private static final Interpolator f710t = new DecelerateInterpolator();
    private ArrayList<ActionBar.a> A = new ArrayList<>();
    private boolean B;
    private int C = 0;
    private boolean D;
    private boolean E = true;
    private boolean F;

    /* renamed from: a  reason: collision with root package name */
    Context f711a;

    /* renamed from: b  reason: collision with root package name */
    ActionBarOverlayLayout f712b;

    /* renamed from: c  reason: collision with root package name */
    ActionBarContainer f713c;

    /* renamed from: d  reason: collision with root package name */
    p f714d;

    /* renamed from: e  reason: collision with root package name */
    ActionBarContextView f715e;

    /* renamed from: f  reason: collision with root package name */
    View f716f;

    /* renamed from: g  reason: collision with root package name */
    ScrollingTabContainerView f717g;

    /* renamed from: h  reason: collision with root package name */
    a f718h;

    /* renamed from: i  reason: collision with root package name */
    b f719i;

    /* renamed from: j  reason: collision with root package name */
    b.a f720j;

    /* renamed from: k  reason: collision with root package name */
    boolean f721k = true;

    /* renamed from: l  reason: collision with root package name */
    boolean f722l;

    /* renamed from: m  reason: collision with root package name */
    boolean f723m;

    /* renamed from: n  reason: collision with root package name */
    h f724n;

    /* renamed from: o  reason: collision with root package name */
    boolean f725o;

    /* renamed from: p  reason: collision with root package name */
    final ah f726p = new ai() {
        public void b(View view) {
            if (m.this.f721k && m.this.f716f != null) {
                m.this.f716f.setTranslationY(0.0f);
                m.this.f713c.setTranslationY(0.0f);
            }
            m.this.f713c.setVisibility(8);
            m.this.f713c.setTransitioning(false);
            m.this.f724n = null;
            m.this.j();
            if (m.this.f712b != null) {
                ac.w(m.this.f712b);
            }
        }
    };

    /* renamed from: q  reason: collision with root package name */
    final ah f727q = new ai() {
        public void b(View view) {
            m.this.f724n = null;
            m.this.f713c.requestLayout();
        }
    };

    /* renamed from: r  reason: collision with root package name */
    final aj f728r = new aj() {
        public void a(View view) {
            ((View) m.this.f713c.getParent()).invalidate();
        }
    };

    /* renamed from: u  reason: collision with root package name */
    private Context f729u;

    /* renamed from: v  reason: collision with root package name */
    private Activity f730v;

    /* renamed from: w  reason: collision with root package name */
    private ArrayList<Object> f731w = new ArrayList<>();

    /* renamed from: x  reason: collision with root package name */
    private int f732x = -1;

    /* renamed from: y  reason: collision with root package name */
    private boolean f733y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f734z;

    public class a extends b implements g.a {

        /* renamed from: b  reason: collision with root package name */
        private final Context f739b;

        /* renamed from: c  reason: collision with root package name */
        private final g f740c;

        /* renamed from: d  reason: collision with root package name */
        private b.a f741d;

        /* renamed from: e  reason: collision with root package name */
        private WeakReference<View> f742e;

        public a(Context context, b.a aVar) {
            this.f739b = context;
            this.f741d = aVar;
            g a2 = new g(context).a(1);
            this.f740c = a2;
            a2.a((g.a) this);
        }

        public MenuInflater a() {
            return new f.g(this.f739b);
        }

        public void a(int i2) {
            b((CharSequence) m.this.f711a.getResources().getString(i2));
        }

        public void a(View view) {
            m.this.f715e.setCustomView(view);
            this.f742e = new WeakReference<>(view);
        }

        public void a(g gVar) {
            if (this.f741d != null) {
                d();
                m.this.f715e.a();
            }
        }

        public void a(CharSequence charSequence) {
            m.this.f715e.setSubtitle(charSequence);
        }

        public void a(boolean z2) {
            super.a(z2);
            m.this.f715e.setTitleOptional(z2);
        }

        public boolean a(g gVar, MenuItem menuItem) {
            b.a aVar = this.f741d;
            if (aVar != null) {
                return aVar.a((b) this, menuItem);
            }
            return false;
        }

        public Menu b() {
            return this.f740c;
        }

        public void b(int i2) {
            a((CharSequence) m.this.f711a.getResources().getString(i2));
        }

        public void b(CharSequence charSequence) {
            m.this.f715e.setTitle(charSequence);
        }

        public void c() {
            if (m.this.f718h == this) {
                if (!m.a(m.this.f722l, m.this.f723m, false)) {
                    m.this.f719i = this;
                    m.this.f720j = this.f741d;
                } else {
                    this.f741d.a(this);
                }
                this.f741d = null;
                m.this.j(false);
                m.this.f715e.b();
                m.this.f714d.a().sendAccessibilityEvent(32);
                m.this.f712b.setHideOnContentScrollEnabled(m.this.f725o);
                m.this.f718h = null;
            }
        }

        public void d() {
            if (m.this.f718h == this) {
                this.f740c.h();
                try {
                    this.f741d.b(this, this.f740c);
                } finally {
                    this.f740c.i();
                }
            }
        }

        public boolean e() {
            this.f740c.h();
            try {
                return this.f741d.a((b) this, (Menu) this.f740c);
            } finally {
                this.f740c.i();
            }
        }

        public CharSequence f() {
            return m.this.f715e.getTitle();
        }

        public CharSequence g() {
            return m.this.f715e.getSubtitle();
        }

        public boolean h() {
            return m.this.f715e.d();
        }

        public View i() {
            WeakReference<View> weakReference = this.f742e;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }
    }

    public m(Activity activity, boolean z2) {
        this.f730v = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (!z2) {
            this.f716f = decorView.findViewById(16908290);
        }
    }

    public m(Dialog dialog) {
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        this.f712b = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f714d = b(view.findViewById(R.id.action_bar));
        this.f715e = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        this.f713c = actionBarContainer;
        p pVar = this.f714d;
        if (pVar == null || this.f715e == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f711a = pVar.b();
        boolean z2 = (this.f714d.o() & 4) != 0;
        if (z2) {
            this.f733y = true;
        }
        f.a a2 = f.a.a(this.f711a);
        a(a2.f() || z2);
        k(a2.d());
        TypedArray obtainStyledAttributes = this.f711a.obtainStyledAttributes((AttributeSet) null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
            b(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    static boolean a(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return !z2 && !z3;
    }

    private p b(View view) {
        if (view instanceof p) {
            return (p) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void k(boolean z2) {
        this.B = z2;
        if (!z2) {
            this.f714d.a((ScrollingTabContainerView) null);
            this.f713c.setTabContainer(this.f717g);
        } else {
            this.f713c.setTabContainer((ScrollingTabContainerView) null);
            this.f714d.a(this.f717g);
        }
        boolean z3 = true;
        boolean z4 = k() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.f717g;
        if (scrollingTabContainerView != null) {
            if (z4) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f712b;
                if (actionBarOverlayLayout != null) {
                    ac.w(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.f714d.a(!this.B && z4);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f712b;
        if (this.B || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z3);
    }

    private void l(boolean z2) {
        if (a(this.f722l, this.f723m, this.D)) {
            if (!this.E) {
                this.E = true;
                h(z2);
            }
        } else if (this.E) {
            this.E = false;
            i(z2);
        }
    }

    private void p() {
        if (!this.D) {
            this.D = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f712b;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            l(false);
        }
    }

    private void q() {
        if (this.D) {
            this.D = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f712b;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    private boolean r() {
        return ac.G(this.f713c);
    }

    public int a() {
        return this.f714d.o();
    }

    public b a(b.a aVar) {
        a aVar2 = this.f718h;
        if (aVar2 != null) {
            aVar2.c();
        }
        this.f712b.setHideOnContentScrollEnabled(false);
        this.f715e.c();
        a aVar3 = new a(this.f715e.getContext(), aVar);
        if (!aVar3.e()) {
            return null;
        }
        this.f718h = aVar3;
        aVar3.d();
        this.f715e.a(aVar3);
        j(true);
        this.f715e.sendAccessibilityEvent(32);
        return aVar3;
    }

    public void a(float f2) {
        ac.d((View) this.f713c, f2);
    }

    public void a(int i2) {
        this.f714d.d(i2);
    }

    public void a(int i2, int i3) {
        int o2 = this.f714d.o();
        if ((i3 & 4) != 0) {
            this.f733y = true;
        }
        this.f714d.c((i2 & i3) | ((i3 ^ -1) & o2));
    }

    public void a(Configuration configuration) {
        k(f.a.a(this.f711a).d());
    }

    public void a(CharSequence charSequence) {
        this.f714d.a(charSequence);
    }

    public void a(boolean z2) {
        this.f714d.b(z2);
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        Menu b2;
        a aVar = this.f718h;
        if (aVar == null || (b2 = aVar.b()) == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        b2.setQwertyMode(z2);
        return b2.performShortcut(i2, keyEvent, 0);
    }

    public void b() {
        if (this.f722l) {
            this.f722l = false;
            l(false);
        }
    }

    public void b(int i2) {
        this.C = i2;
    }

    public void b(boolean z2) {
        if (!z2 || this.f712b.a()) {
            this.f725o = z2;
            this.f712b.setHideOnContentScrollEnabled(z2);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void c() {
        if (!this.f722l) {
            this.f722l = true;
            l(false);
        }
    }

    public void c(boolean z2) {
        if (!this.f733y) {
            f(z2);
        }
    }

    public Context d() {
        if (this.f729u == null) {
            TypedValue typedValue = new TypedValue();
            this.f711a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f729u = new ContextThemeWrapper(this.f711a, i2);
            } else {
                this.f729u = this.f711a;
            }
        }
        return this.f729u;
    }

    public void d(boolean z2) {
        h hVar;
        this.F = z2;
        if (!z2 && (hVar = this.f724n) != null) {
            hVar.c();
        }
    }

    public void e(boolean z2) {
        if (z2 != this.f734z) {
            this.f734z = z2;
            int size = this.A.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.A.get(i2).a(z2);
            }
        }
    }

    public void f(boolean z2) {
        a(z2 ? 4 : 0, 4);
    }

    public void g(boolean z2) {
        this.f721k = z2;
    }

    public void h(boolean z2) {
        View view;
        View view2;
        h hVar = this.f724n;
        if (hVar != null) {
            hVar.c();
        }
        this.f713c.setVisibility(0);
        if (this.C != 0 || (!this.F && !z2)) {
            this.f713c.setAlpha(1.0f);
            this.f713c.setTranslationY(0.0f);
            if (this.f721k && (view = this.f716f) != null) {
                view.setTranslationY(0.0f);
            }
            this.f727q.b((View) null);
        } else {
            this.f713c.setTranslationY(0.0f);
            float f2 = (float) (-this.f713c.getHeight());
            if (z2) {
                int[] iArr = {0, 0};
                this.f713c.getLocationInWindow(iArr);
                f2 -= (float) iArr[1];
            }
            this.f713c.setTranslationY(f2);
            h hVar2 = new h();
            ag c2 = ac.r(this.f713c).c(0.0f);
            c2.a(this.f728r);
            hVar2.a(c2);
            if (this.f721k && (view2 = this.f716f) != null) {
                view2.setTranslationY(f2);
                hVar2.a(ac.r(this.f716f).c(0.0f));
            }
            hVar2.a(f710t);
            hVar2.a(250);
            hVar2.a(this.f727q);
            this.f724n = hVar2;
            hVar2.a();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f712b;
        if (actionBarOverlayLayout != null) {
            ac.w(actionBarOverlayLayout);
        }
    }

    public boolean h() {
        p pVar = this.f714d;
        if (pVar == null || !pVar.c()) {
            return false;
        }
        this.f714d.d();
        return true;
    }

    public void i(boolean z2) {
        View view;
        h hVar = this.f724n;
        if (hVar != null) {
            hVar.c();
        }
        if (this.C != 0 || (!this.F && !z2)) {
            this.f726p.b((View) null);
            return;
        }
        this.f713c.setAlpha(1.0f);
        this.f713c.setTransitioning(true);
        h hVar2 = new h();
        float f2 = (float) (-this.f713c.getHeight());
        if (z2) {
            int[] iArr = {0, 0};
            this.f713c.getLocationInWindow(iArr);
            f2 -= (float) iArr[1];
        }
        ag c2 = ac.r(this.f713c).c(f2);
        c2.a(this.f728r);
        hVar2.a(c2);
        if (this.f721k && (view = this.f716f) != null) {
            hVar2.a(ac.r(view).c(f2));
        }
        hVar2.a(f709s);
        hVar2.a(250);
        hVar2.a(this.f726p);
        this.f724n = hVar2;
        hVar2.a();
    }

    /* access modifiers changed from: package-private */
    public void j() {
        b.a aVar = this.f720j;
        if (aVar != null) {
            aVar.a(this.f719i);
            this.f719i = null;
            this.f720j = null;
        }
    }

    public void j(boolean z2) {
        ag agVar;
        ag agVar2;
        if (z2) {
            p();
        } else {
            q();
        }
        if (r()) {
            if (z2) {
                agVar = this.f714d.a(4, 100);
                agVar2 = this.f715e.a(0, 200);
            } else {
                agVar2 = this.f714d.a(0, 200);
                agVar = this.f715e.a(8, 100);
            }
            h hVar = new h();
            hVar.a(agVar, agVar2);
            hVar.a();
        } else if (z2) {
            this.f714d.e(4);
            this.f715e.setVisibility(0);
        } else {
            this.f714d.e(0);
            this.f715e.setVisibility(8);
        }
    }

    public int k() {
        return this.f714d.p();
    }

    public void l() {
        if (this.f723m) {
            this.f723m = false;
            l(true);
        }
    }

    public void m() {
        if (!this.f723m) {
            this.f723m = true;
            l(true);
        }
    }

    public void n() {
        h hVar = this.f724n;
        if (hVar != null) {
            hVar.c();
            this.f724n = null;
        }
    }

    public void o() {
    }
}
