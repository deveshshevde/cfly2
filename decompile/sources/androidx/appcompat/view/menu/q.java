package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.MenuPopupWindow;
import t.ac;

final class q extends k implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, m {

    /* renamed from: e  reason: collision with root package name */
    private static final int f946e = R.layout.abc_popup_menu_item_layout;

    /* renamed from: a  reason: collision with root package name */
    final MenuPopupWindow f947a;

    /* renamed from: b  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f948b = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (q.this.e() && !q.this.f947a.j()) {
                View view = q.this.f949c;
                if (view == null || !view.isShown()) {
                    q.this.d();
                } else {
                    q.this.f947a.c_();
                }
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    View f949c;

    /* renamed from: d  reason: collision with root package name */
    ViewTreeObserver f950d;

    /* renamed from: f  reason: collision with root package name */
    private final Context f951f;

    /* renamed from: g  reason: collision with root package name */
    private final g f952g;

    /* renamed from: h  reason: collision with root package name */
    private final f f953h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f954i;

    /* renamed from: j  reason: collision with root package name */
    private final int f955j;

    /* renamed from: k  reason: collision with root package name */
    private final int f956k;

    /* renamed from: l  reason: collision with root package name */
    private final int f957l;

    /* renamed from: m  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f958m = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (q.this.f950d != null) {
                if (!q.this.f950d.isAlive()) {
                    q.this.f950d = view.getViewTreeObserver();
                }
                q.this.f950d.removeGlobalOnLayoutListener(q.this.f948b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* renamed from: n  reason: collision with root package name */
    private PopupWindow.OnDismissListener f959n;

    /* renamed from: o  reason: collision with root package name */
    private View f960o;

    /* renamed from: p  reason: collision with root package name */
    private m.a f961p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f962q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f963r;

    /* renamed from: s  reason: collision with root package name */
    private int f964s;

    /* renamed from: t  reason: collision with root package name */
    private int f965t = 0;

    /* renamed from: u  reason: collision with root package name */
    private boolean f966u;

    public q(Context context, g gVar, View view, int i2, int i3, boolean z2) {
        this.f951f = context;
        this.f952g = gVar;
        this.f954i = z2;
        this.f953h = new f(gVar, LayoutInflater.from(context), z2, f946e);
        this.f956k = i2;
        this.f957l = i3;
        Resources resources = context.getResources();
        this.f955j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f960o = view;
        this.f947a = new MenuPopupWindow(context, (AttributeSet) null, i2, i3);
        gVar.a((m) this, context);
    }

    private boolean j() {
        View view;
        if (e()) {
            return true;
        }
        if (this.f962q || (view = this.f960o) == null) {
            return false;
        }
        this.f949c = view;
        this.f947a.a((PopupWindow.OnDismissListener) this);
        this.f947a.a((AdapterView.OnItemClickListener) this);
        this.f947a.a(true);
        View view2 = this.f949c;
        boolean z2 = this.f950d == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f950d = viewTreeObserver;
        if (z2) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f948b);
        }
        view2.addOnAttachStateChangeListener(this.f958m);
        this.f947a.b(view2);
        this.f947a.f(this.f965t);
        if (!this.f963r) {
            this.f964s = a(this.f953h, (ViewGroup) null, this.f951f, this.f955j);
            this.f963r = true;
        }
        this.f947a.h(this.f964s);
        this.f947a.i(2);
        this.f947a.a(i());
        this.f947a.c_();
        ListView g2 = this.f947a.g();
        g2.setOnKeyListener(this);
        if (this.f966u && this.f952g.n() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f951f).inflate(R.layout.abc_popup_menu_header_item_layout, g2, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f952g.n());
            }
            frameLayout.setEnabled(false);
            g2.addHeaderView(frameLayout, (Object) null, false);
        }
        this.f947a.a((ListAdapter) this.f953h);
        this.f947a.c_();
        return true;
    }

    public void a(int i2) {
        this.f965t = i2;
    }

    public void a(Parcelable parcelable) {
    }

    public void a(View view) {
        this.f960o = view;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.f959n = onDismissListener;
    }

    public void a(g gVar) {
    }

    public void a(g gVar, boolean z2) {
        if (gVar == this.f952g) {
            d();
            m.a aVar = this.f961p;
            if (aVar != null) {
                aVar.a(gVar, z2);
            }
        }
    }

    public void a(m.a aVar) {
        this.f961p = aVar;
    }

    public void a(boolean z2) {
        this.f963r = false;
        f fVar = this.f953h;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    public boolean a(r rVar) {
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.f951f, rVar, this.f949c, this.f954i, this.f956k, this.f957l);
            lVar.a(this.f961p);
            lVar.a(k.b((g) rVar));
            lVar.a(this.f959n);
            this.f959n = null;
            this.f952g.a(false);
            int f2 = this.f947a.f();
            int c2 = this.f947a.c();
            if ((Gravity.getAbsoluteGravity(this.f965t, ac.i(this.f960o)) & 7) == 5) {
                f2 += this.f960o.getWidth();
            }
            if (lVar.a(f2, c2)) {
                m.a aVar = this.f961p;
                if (aVar == null) {
                    return true;
                }
                aVar.a(rVar);
                return true;
            }
        }
        return false;
    }

    public void b(int i2) {
        this.f947a.b(i2);
    }

    public void b(boolean z2) {
        this.f953h.a(z2);
    }

    public boolean b() {
        return false;
    }

    public void c(int i2) {
        this.f947a.a(i2);
    }

    public void c(boolean z2) {
        this.f966u = z2;
    }

    public void c_() {
        if (!j()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void d() {
        if (e()) {
            this.f947a.d();
        }
    }

    public boolean e() {
        return !this.f962q && this.f947a.e();
    }

    public Parcelable f() {
        return null;
    }

    public ListView g() {
        return this.f947a.g();
    }

    public void onDismiss() {
        this.f962q = true;
        this.f952g.close();
        ViewTreeObserver viewTreeObserver = this.f950d;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f950d = this.f949c.getViewTreeObserver();
            }
            this.f950d.removeGlobalOnLayoutListener(this.f948b);
            this.f950d = null;
        }
        this.f949c.removeOnAttachStateChangeListener(this.f958m);
        PopupWindow.OnDismissListener onDismissListener = this.f959n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        d();
        return true;
    }
}
