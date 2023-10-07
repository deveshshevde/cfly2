package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.appcompat.widget.u;
import java.util.ArrayList;
import java.util.List;
import t.ac;
import t.f;

final class d extends k implements View.OnKeyListener, PopupWindow.OnDismissListener, m {

    /* renamed from: g  reason: collision with root package name */
    private static final int f809g = R.layout.abc_cascading_menu_item_layout;
    private PopupWindow.OnDismissListener A;

    /* renamed from: a  reason: collision with root package name */
    final Handler f810a;

    /* renamed from: b  reason: collision with root package name */
    final List<a> f811b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f812c = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (d.this.e() && d.this.f811b.size() > 0 && !d.this.f811b.get(0).f842a.j()) {
                View view = d.this.f813d;
                if (view == null || !view.isShown()) {
                    d.this.d();
                    return;
                }
                for (a aVar : d.this.f811b) {
                    aVar.f842a.c_();
                }
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    View f813d;

    /* renamed from: e  reason: collision with root package name */
    ViewTreeObserver f814e;

    /* renamed from: f  reason: collision with root package name */
    boolean f815f;

    /* renamed from: h  reason: collision with root package name */
    private final Context f816h;

    /* renamed from: i  reason: collision with root package name */
    private final int f817i;

    /* renamed from: j  reason: collision with root package name */
    private final int f818j;

    /* renamed from: k  reason: collision with root package name */
    private final int f819k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f820l;

    /* renamed from: m  reason: collision with root package name */
    private final List<g> f821m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f822n = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (d.this.f814e != null) {
                if (!d.this.f814e.isAlive()) {
                    d.this.f814e = view.getViewTreeObserver();
                }
                d.this.f814e.removeGlobalOnLayoutListener(d.this.f812c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* renamed from: o  reason: collision with root package name */
    private final u f823o = new u() {
        public void a(g gVar, MenuItem menuItem) {
            d.this.f810a.removeCallbacksAndMessages(gVar);
        }

        public void b(final g gVar, final MenuItem menuItem) {
            final a aVar = null;
            d.this.f810a.removeCallbacksAndMessages((Object) null);
            int size = d.this.f811b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (gVar == d.this.f811b.get(i2).f843b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                int i3 = i2 + 1;
                if (i3 < d.this.f811b.size()) {
                    aVar = d.this.f811b.get(i3);
                }
                d.this.f810a.postAtTime(new Runnable() {
                    public void run() {
                        if (aVar != null) {
                            d.this.f815f = true;
                            aVar.f843b.a(false);
                            d.this.f815f = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            gVar.a(menuItem, 4);
                        }
                    }
                }, gVar, SystemClock.uptimeMillis() + 200);
            }
        }
    };

    /* renamed from: p  reason: collision with root package name */
    private int f824p = 0;

    /* renamed from: q  reason: collision with root package name */
    private int f825q = 0;

    /* renamed from: r  reason: collision with root package name */
    private View f826r;

    /* renamed from: s  reason: collision with root package name */
    private int f827s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f828t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f829u;

    /* renamed from: v  reason: collision with root package name */
    private int f830v;

    /* renamed from: w  reason: collision with root package name */
    private int f831w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f832x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f833y;

    /* renamed from: z  reason: collision with root package name */
    private m.a f834z;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public final MenuPopupWindow f842a;

        /* renamed from: b  reason: collision with root package name */
        public final g f843b;

        /* renamed from: c  reason: collision with root package name */
        public final int f844c;

        public a(MenuPopupWindow menuPopupWindow, g gVar, int i2) {
            this.f842a = menuPopupWindow;
            this.f843b = gVar;
            this.f844c = i2;
        }

        public ListView a() {
            return this.f842a.g();
        }
    }

    public d(Context context, View view, int i2, int i3, boolean z2) {
        this.f816h = context;
        this.f826r = view;
        this.f818j = i2;
        this.f819k = i3;
        this.f820l = z2;
        this.f832x = false;
        this.f827s = k();
        Resources resources = context.getResources();
        this.f817i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f810a = new Handler();
    }

    private MenuItem a(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = gVar.getItem(i2);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, g gVar) {
        int i2;
        f fVar;
        int firstVisiblePosition;
        MenuItem a2 = a(aVar.f843b, gVar);
        if (a2 == null) {
            return null;
        }
        ListView a3 = aVar.a();
        ListAdapter adapter = a3.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i2 = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            } else if (a2 == fVar.getItem(i3)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1 && (firstVisiblePosition = (i3 + i2) - a3.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a3.getChildCount()) {
            return a3.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private void c(g gVar) {
        View view;
        a aVar;
        int i2;
        int i3;
        int i4;
        LayoutInflater from = LayoutInflater.from(this.f816h);
        f fVar = new f(gVar, from, this.f820l, f809g);
        if (!e() && this.f832x) {
            fVar.a(true);
        } else if (e()) {
            fVar.a(k.b(gVar));
        }
        int a2 = a(fVar, (ViewGroup) null, this.f816h, this.f817i);
        MenuPopupWindow j2 = j();
        j2.a((ListAdapter) fVar);
        j2.h(a2);
        j2.f(this.f825q);
        if (this.f811b.size() > 0) {
            List<a> list = this.f811b;
            aVar = list.get(list.size() - 1);
            view = a(aVar, gVar);
        } else {
            aVar = null;
            view = null;
        }
        if (view != null) {
            j2.c(false);
            j2.a((Object) null);
            int d2 = d(a2);
            boolean z2 = d2 == 1;
            this.f827s = d2;
            if (Build.VERSION.SDK_INT >= 26) {
                j2.b(view);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.f826r.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f825q & 7) == 5) {
                    iArr[0] = iArr[0] + this.f826r.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.f825q & 5) != 5) {
                if (z2) {
                    a2 = view.getWidth();
                }
                i4 = i2 - a2;
                j2.b(i4);
                j2.b(true);
                j2.a(i3);
            } else if (!z2) {
                a2 = view.getWidth();
                i4 = i2 - a2;
                j2.b(i4);
                j2.b(true);
                j2.a(i3);
            }
            i4 = i2 + a2;
            j2.b(i4);
            j2.b(true);
            j2.a(i3);
        } else {
            if (this.f828t) {
                j2.b(this.f830v);
            }
            if (this.f829u) {
                j2.a(this.f831w);
            }
            j2.a(i());
        }
        this.f811b.add(new a(j2, gVar, this.f827s));
        j2.c_();
        ListView g2 = j2.g();
        g2.setOnKeyListener(this);
        if (aVar == null && this.f833y && gVar.n() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, g2, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(gVar.n());
            g2.addHeaderView(frameLayout, (Object) null, false);
            j2.c_();
        }
    }

    private int d(int i2) {
        List<a> list = this.f811b;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f813d.getWindowVisibleDisplayFrame(rect);
        return this.f827s == 1 ? (iArr[0] + a2.getWidth()) + i2 > rect.right ? 0 : 1 : iArr[0] - i2 < 0 ? 1 : 0;
    }

    private int d(g gVar) {
        int size = this.f811b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (gVar == this.f811b.get(i2).f843b) {
                return i2;
            }
        }
        return -1;
    }

    private MenuPopupWindow j() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f816h, (AttributeSet) null, this.f818j, this.f819k);
        menuPopupWindow.a(this.f823o);
        menuPopupWindow.a((AdapterView.OnItemClickListener) this);
        menuPopupWindow.a((PopupWindow.OnDismissListener) this);
        menuPopupWindow.b(this.f826r);
        menuPopupWindow.f(this.f825q);
        menuPopupWindow.a(true);
        menuPopupWindow.i(2);
        return menuPopupWindow;
    }

    private int k() {
        return ac.i(this.f826r) == 1 ? 0 : 1;
    }

    public void a(int i2) {
        if (this.f824p != i2) {
            this.f824p = i2;
            this.f825q = f.a(i2, ac.i(this.f826r));
        }
    }

    public void a(Parcelable parcelable) {
    }

    public void a(View view) {
        if (this.f826r != view) {
            this.f826r = view;
            this.f825q = f.a(this.f824p, ac.i(view));
        }
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    public void a(g gVar) {
        gVar.a((m) this, this.f816h);
        if (e()) {
            c(gVar);
        } else {
            this.f821m.add(gVar);
        }
    }

    public void a(g gVar, boolean z2) {
        int d2 = d(gVar);
        if (d2 >= 0) {
            int i2 = d2 + 1;
            if (i2 < this.f811b.size()) {
                this.f811b.get(i2).f843b.a(false);
            }
            a remove = this.f811b.remove(d2);
            remove.f843b.b((m) this);
            if (this.f815f) {
                remove.f842a.b((Object) null);
                remove.f842a.e(0);
            }
            remove.f842a.d();
            int size = this.f811b.size();
            this.f827s = size > 0 ? this.f811b.get(size - 1).f844c : k();
            if (size == 0) {
                d();
                m.a aVar = this.f834z;
                if (aVar != null) {
                    aVar.a(gVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.f814e;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.f814e.removeGlobalOnLayoutListener(this.f812c);
                    }
                    this.f814e = null;
                }
                this.f813d.removeOnAttachStateChangeListener(this.f822n);
                this.A.onDismiss();
            } else if (z2) {
                this.f811b.get(0).f843b.a(false);
            }
        }
    }

    public void a(m.a aVar) {
        this.f834z = aVar;
    }

    public void a(boolean z2) {
        for (a a2 : this.f811b) {
            a(a2.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public boolean a(r rVar) {
        for (a next : this.f811b) {
            if (rVar == next.f843b) {
                next.a().requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        a((g) rVar);
        m.a aVar = this.f834z;
        if (aVar != null) {
            aVar.a(rVar);
        }
        return true;
    }

    public void b(int i2) {
        this.f828t = true;
        this.f830v = i2;
    }

    public void b(boolean z2) {
        this.f832x = z2;
    }

    public boolean b() {
        return false;
    }

    public void c(int i2) {
        this.f829u = true;
        this.f831w = i2;
    }

    public void c(boolean z2) {
        this.f833y = z2;
    }

    public void c_() {
        if (!e()) {
            for (g c2 : this.f821m) {
                c(c2);
            }
            this.f821m.clear();
            View view = this.f826r;
            this.f813d = view;
            if (view != null) {
                boolean z2 = this.f814e == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.f814e = viewTreeObserver;
                if (z2) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f812c);
                }
                this.f813d.addOnAttachStateChangeListener(this.f822n);
            }
        }
    }

    public void d() {
        int size = this.f811b.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.f811b.toArray(new a[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                a aVar = aVarArr[i2];
                if (aVar.f842a.e()) {
                    aVar.f842a.d();
                }
            }
        }
    }

    public boolean e() {
        return this.f811b.size() > 0 && this.f811b.get(0).f842a.e();
    }

    public Parcelable f() {
        return null;
    }

    public ListView g() {
        if (this.f811b.isEmpty()) {
            return null;
        }
        List<a> list = this.f811b;
        return list.get(list.size() - 1).a();
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        return false;
    }

    public void onDismiss() {
        a aVar;
        int size = this.f811b.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                aVar = null;
                break;
            }
            aVar = this.f811b.get(i2);
            if (!aVar.f842a.e()) {
                break;
            }
            i2++;
        }
        if (aVar != null) {
            aVar.f843b.a(false);
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
