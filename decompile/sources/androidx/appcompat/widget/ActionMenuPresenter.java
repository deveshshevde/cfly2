package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.r;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
import t.b;

class ActionMenuPresenter extends androidx.appcompat.view.menu.b implements b.a {

    /* renamed from: g  reason: collision with root package name */
    d f1025g;

    /* renamed from: h  reason: collision with root package name */
    e f1026h;

    /* renamed from: i  reason: collision with root package name */
    a f1027i;

    /* renamed from: j  reason: collision with root package name */
    c f1028j;

    /* renamed from: k  reason: collision with root package name */
    final f f1029k = new f();

    /* renamed from: l  reason: collision with root package name */
    int f1030l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f1031m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1032n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f1033o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f1034p;

    /* renamed from: q  reason: collision with root package name */
    private int f1035q;

    /* renamed from: r  reason: collision with root package name */
    private int f1036r;

    /* renamed from: s  reason: collision with root package name */
    private int f1037s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f1038t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f1039u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f1040v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f1041w;

    /* renamed from: x  reason: collision with root package name */
    private int f1042x;

    /* renamed from: y  reason: collision with root package name */
    private final SparseBooleanArray f1043y = new SparseBooleanArray();

    /* renamed from: z  reason: collision with root package name */
    private b f1044z;

    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public int f1045a;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f1045a = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f1045a);
        }
    }

    private class a extends l {
        public a(Context context, r rVar, View view) {
            super(context, rVar, view, false, R.attr.actionOverflowMenuStyle);
            if (!((i) rVar.getItem()).j()) {
                a(ActionMenuPresenter.this.f1025g == null ? (View) ActionMenuPresenter.this.f801f : ActionMenuPresenter.this.f1025g);
            }
            a((m.a) ActionMenuPresenter.this.f1029k);
        }

        /* access modifiers changed from: protected */
        public void e() {
            ActionMenuPresenter.this.f1027i = null;
            ActionMenuPresenter.this.f1030l = 0;
            super.e();
        }
    }

    private class b extends ActionMenuItemView.b {
        b() {
        }

        public p a() {
            if (ActionMenuPresenter.this.f1027i != null) {
                return ActionMenuPresenter.this.f1027i.b();
            }
            return null;
        }
    }

    private class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private e f1049b;

        public c(e eVar) {
            this.f1049b = eVar;
        }

        public void run() {
            if (ActionMenuPresenter.this.f798c != null) {
                ActionMenuPresenter.this.f798c.g();
            }
            View view = (View) ActionMenuPresenter.this.f801f;
            if (!(view == null || view.getWindowToken() == null || !this.f1049b.c())) {
                ActionMenuPresenter.this.f1026h = this.f1049b;
            }
            ActionMenuPresenter.this.f1028j = null;
        }
    }

    private class d extends AppCompatImageView implements ActionMenuView.a {
        public d(Context context) {
            super(context, (AttributeSet) null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            ah.a(this, getContentDescription());
            setOnTouchListener(new t(this, ActionMenuPresenter.this) {
                public p a() {
                    if (ActionMenuPresenter.this.f1026h == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.f1026h.b();
                }

                public boolean b() {
                    ActionMenuPresenter.this.e();
                    return true;
                }

                public boolean c() {
                    if (ActionMenuPresenter.this.f1028j != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.g();
                    return true;
                }
            });
        }

        public boolean c() {
            return false;
        }

        public boolean d() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.e();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    private class e extends l {
        public e(Context context, g gVar, View view, boolean z2) {
            super(context, gVar, view, z2, R.attr.actionOverflowMenuStyle);
            a(8388613);
            a((m.a) ActionMenuPresenter.this.f1029k);
        }

        /* access modifiers changed from: protected */
        public void e() {
            if (ActionMenuPresenter.this.f798c != null) {
                ActionMenuPresenter.this.f798c.close();
            }
            ActionMenuPresenter.this.f1026h = null;
            super.e();
        }
    }

    private class f implements m.a {
        f() {
        }

        public void a(g gVar, boolean z2) {
            if (gVar instanceof r) {
                gVar.q().a(false);
            }
            m.a a2 = ActionMenuPresenter.this.a();
            if (a2 != null) {
                a2.a(gVar, z2);
            }
        }

        public boolean a(g gVar) {
            if (gVar == ActionMenuPresenter.this.f798c) {
                return false;
            }
            ActionMenuPresenter.this.f1030l = ((r) gVar).getItem().getItemId();
            m.a a2 = ActionMenuPresenter.this.a();
            if (a2 != null) {
                return a2.a(gVar);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f801f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public View a(i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.n()) {
            actionView = super.a(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public n a(ViewGroup viewGroup) {
        n nVar = this.f801f;
        n a2 = super.a(viewGroup);
        if (nVar != a2) {
            ((ActionMenuView) a2).setPresenter(this);
        }
        return a2;
    }

    public void a(Context context, g gVar) {
        super.a(context, gVar);
        Resources resources = context.getResources();
        f.a a2 = f.a.a(context);
        if (!this.f1034p) {
            this.f1033o = a2.b();
        }
        if (!this.f1040v) {
            this.f1035q = a2.c();
        }
        if (!this.f1038t) {
            this.f1037s = a2.a();
        }
        int i2 = this.f1035q;
        if (this.f1033o) {
            if (this.f1025g == null) {
                d dVar = new d(this.f796a);
                this.f1025g = dVar;
                if (this.f1032n) {
                    dVar.setImageDrawable(this.f1031m);
                    this.f1031m = null;
                    this.f1032n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1025g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i2 -= this.f1025g.getMeasuredWidth();
        } else {
            this.f1025g = null;
        }
        this.f1036r = i2;
        this.f1042x = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public void a(Configuration configuration) {
        if (!this.f1038t) {
            this.f1037s = f.a.a(this.f797b).a();
        }
        if (this.f798c != null) {
            this.f798c.b(true);
        }
    }

    public void a(Drawable drawable) {
        d dVar = this.f1025g;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.f1032n = true;
        this.f1031m = drawable;
    }

    public void a(Parcelable parcelable) {
        MenuItem findItem;
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.f1045a > 0 && (findItem = this.f798c.findItem(savedState.f1045a)) != null) {
                a((r) findItem.getSubMenu());
            }
        }
    }

    public void a(g gVar, boolean z2) {
        h();
        super.a(gVar, z2);
    }

    public void a(i iVar, n.a aVar) {
        aVar.a(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f801f);
        if (this.f1044z == null) {
            this.f1044z = new b();
        }
        actionMenuItemView.setPopupCallback(this.f1044z);
    }

    public void a(ActionMenuView actionMenuView) {
        this.f801f = actionMenuView;
        actionMenuView.a(this.f798c);
    }

    public void a(boolean z2) {
        super.a(z2);
        ((View) this.f801f).requestLayout();
        boolean z3 = false;
        if (this.f798c != null) {
            ArrayList<i> l2 = this.f798c.l();
            int size = l2.size();
            for (int i2 = 0; i2 < size; i2++) {
                t.b a2 = l2.get(i2).a();
                if (a2 != null) {
                    a2.a((b.a) this);
                }
            }
        }
        ArrayList<i> m2 = this.f798c != null ? this.f798c.m() : null;
        if (this.f1033o && m2 != null) {
            int size2 = m2.size();
            if (size2 == 1) {
                z3 = !m2.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        d dVar = this.f1025g;
        if (z3) {
            if (dVar == null) {
                this.f1025g = new d(this.f796a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1025g.getParent();
            if (viewGroup != this.f801f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1025g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f801f;
                actionMenuView.addView(this.f1025g, actionMenuView.c());
            }
        } else if (dVar != null && dVar.getParent() == this.f801f) {
            ((ViewGroup) this.f801f).removeView(this.f1025g);
        }
        ((ActionMenuView) this.f801f).setOverflowReserved(this.f1033o);
    }

    public boolean a(int i2, i iVar) {
        return iVar.j();
    }

    public boolean a(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.f1025g) {
            return false;
        }
        return super.a(viewGroup, i2);
    }

    public boolean a(r rVar) {
        boolean z2 = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        r rVar2 = rVar;
        while (rVar2.t() != this.f798c) {
            rVar2 = (r) rVar2.t();
        }
        View a2 = a(rVar2.getItem());
        if (a2 == null) {
            return false;
        }
        this.f1030l = rVar.getItem().getItemId();
        int size = rVar.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
            i2++;
        }
        a aVar = new a(this.f797b, rVar, a2);
        this.f1027i = aVar;
        aVar.a(z2);
        this.f1027i.a();
        super.a(rVar);
        return true;
    }

    public void b(boolean z2) {
        this.f1033o = z2;
        this.f1034p = true;
    }

    public boolean b() {
        int i2;
        ArrayList<i> arrayList;
        int i3;
        int i4;
        int i5;
        ActionMenuPresenter actionMenuPresenter = this;
        View view = null;
        int i6 = 0;
        if (actionMenuPresenter.f798c != null) {
            arrayList = actionMenuPresenter.f798c.j();
            i2 = arrayList.size();
        } else {
            arrayList = null;
            i2 = 0;
        }
        int i7 = actionMenuPresenter.f1037s;
        int i8 = actionMenuPresenter.f1036r;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f801f;
        boolean z2 = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i2; i11++) {
            i iVar = arrayList.get(i11);
            if (iVar.l()) {
                i9++;
            } else if (iVar.k()) {
                i10++;
            } else {
                z2 = true;
            }
            if (actionMenuPresenter.f1041w && iVar.isActionViewExpanded()) {
                i7 = 0;
            }
        }
        if (actionMenuPresenter.f1033o && (z2 || i10 + i9 > i7)) {
            i7--;
        }
        int i12 = i7 - i9;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f1043y;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f1039u) {
            int i13 = actionMenuPresenter.f1042x;
            i3 = i8 / i13;
            i4 = i13 + ((i8 % i13) / i3);
        } else {
            i4 = 0;
            i3 = 0;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < i2) {
            i iVar2 = arrayList.get(i14);
            if (iVar2.l()) {
                View a2 = actionMenuPresenter.a(iVar2, view, viewGroup);
                if (actionMenuPresenter.f1039u) {
                    i3 -= ActionMenuView.a(a2, i4, i3, makeMeasureSpec, i6);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a2.getMeasuredWidth();
                i8 -= measuredWidth;
                if (i15 == 0) {
                    i15 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.d(true);
                i5 = i2;
            } else if (iVar2.k()) {
                int groupId2 = iVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i12 > 0 || z3) && i8 > 0 && (!actionMenuPresenter.f1039u || i3 > 0);
                boolean z5 = z4;
                i5 = i2;
                if (z4) {
                    View a3 = actionMenuPresenter.a(iVar2, (View) null, viewGroup);
                    if (actionMenuPresenter.f1039u) {
                        int a4 = ActionMenuView.a(a3, i4, i3, makeMeasureSpec, 0);
                        i3 -= a4;
                        if (a4 == 0) {
                            z5 = false;
                        }
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z6 = z5;
                    int measuredWidth2 = a3.getMeasuredWidth();
                    i8 -= measuredWidth2;
                    if (i15 == 0) {
                        i15 = measuredWidth2;
                    }
                    z4 = z6 & (!actionMenuPresenter.f1039u ? i8 + i15 > 0 : i8 >= 0);
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    int i16 = 0;
                    while (i16 < i14) {
                        i iVar3 = arrayList.get(i16);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.j()) {
                                i12++;
                            }
                            iVar3.d(false);
                        }
                        i16++;
                    }
                }
                if (z4) {
                    i12--;
                }
                iVar2.d(z4);
            } else {
                i5 = i2;
                iVar2.d(false);
                i14++;
                view = null;
                actionMenuPresenter = this;
                i2 = i5;
                i6 = 0;
            }
            i14++;
            view = null;
            actionMenuPresenter = this;
            i2 = i5;
            i6 = 0;
        }
        return true;
    }

    public void c(boolean z2) {
        this.f1041w = z2;
    }

    public Drawable d() {
        d dVar = this.f1025g;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f1032n) {
            return this.f1031m;
        }
        return null;
    }

    public void d(boolean z2) {
        if (z2) {
            super.a((r) null);
        } else if (this.f798c != null) {
            this.f798c.a(false);
        }
    }

    public boolean e() {
        if (!this.f1033o || j() || this.f798c == null || this.f801f == null || this.f1028j != null || this.f798c.m().isEmpty()) {
            return false;
        }
        this.f1028j = new c(new e(this.f797b, this.f798c, this.f1025g, true));
        ((View) this.f801f).post(this.f1028j);
        return true;
    }

    public Parcelable f() {
        SavedState savedState = new SavedState();
        savedState.f1045a = this.f1030l;
        return savedState;
    }

    public boolean g() {
        if (this.f1028j == null || this.f801f == null) {
            e eVar = this.f1026h;
            if (eVar == null) {
                return false;
            }
            eVar.d();
            return true;
        }
        ((View) this.f801f).removeCallbacks(this.f1028j);
        this.f1028j = null;
        return true;
    }

    public boolean h() {
        return g() | i();
    }

    public boolean i() {
        a aVar = this.f1027i;
        if (aVar == null) {
            return false;
        }
        aVar.d();
        return true;
    }

    public boolean j() {
        e eVar = this.f1026h;
        return eVar != null && eVar.f();
    }

    public boolean k() {
        return this.f1028j != null || j();
    }
}
