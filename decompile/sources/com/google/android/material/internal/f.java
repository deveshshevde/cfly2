package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.r;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.u;
import com.google.android.material.R;
import java.util.ArrayList;
import t.ac;
import t.ak;
import u.c;

public class f implements m {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f19273a;

    /* renamed from: b  reason: collision with root package name */
    androidx.appcompat.view.menu.g f19274b;

    /* renamed from: c  reason: collision with root package name */
    b f19275c;

    /* renamed from: d  reason: collision with root package name */
    LayoutInflater f19276d;

    /* renamed from: e  reason: collision with root package name */
    int f19277e;

    /* renamed from: f  reason: collision with root package name */
    boolean f19278f;

    /* renamed from: g  reason: collision with root package name */
    ColorStateList f19279g;

    /* renamed from: h  reason: collision with root package name */
    ColorStateList f19280h;

    /* renamed from: i  reason: collision with root package name */
    Drawable f19281i;

    /* renamed from: j  reason: collision with root package name */
    int f19282j;

    /* renamed from: k  reason: collision with root package name */
    int f19283k;

    /* renamed from: l  reason: collision with root package name */
    int f19284l;

    /* renamed from: m  reason: collision with root package name */
    boolean f19285m;

    /* renamed from: n  reason: collision with root package name */
    boolean f19286n = true;

    /* renamed from: o  reason: collision with root package name */
    int f19287o;

    /* renamed from: p  reason: collision with root package name */
    final View.OnClickListener f19288p = new View.OnClickListener() {
        public void onClick(View view) {
            boolean z2 = true;
            f.this.b(true);
            androidx.appcompat.view.menu.i itemData = ((NavigationMenuItemView) view).getItemData();
            boolean a2 = f.this.f19274b.a((MenuItem) itemData, (m) f.this, 0);
            if (itemData == null || !itemData.isCheckable() || !a2) {
                z2 = false;
            } else {
                f.this.f19275c.a(itemData);
            }
            f.this.b(false);
            if (z2) {
                f.this.a(false);
            }
        }
    };

    /* renamed from: q  reason: collision with root package name */
    private NavigationMenuView f19289q;

    /* renamed from: r  reason: collision with root package name */
    private m.a f19290r;

    /* renamed from: s  reason: collision with root package name */
    private int f19291s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public int f19292t;

    /* renamed from: u  reason: collision with root package name */
    private int f19293u;

    /* renamed from: v  reason: collision with root package name */
    private int f19294v = -1;

    private static class a extends k {
        public a(View view) {
            super(view);
        }
    }

    private class b extends RecyclerView.Adapter<k> {

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<d> f19297b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private androidx.appcompat.view.menu.i f19298c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f19299d;

        b() {
            e();
        }

        private void a(int i2, int i3) {
            while (i2 < i3) {
                ((C0130f) this.f19297b.get(i2)).f19302a = true;
                i2++;
            }
        }

        private void e() {
            if (!this.f19299d) {
                this.f19299d = true;
                this.f19297b.clear();
                this.f19297b.add(new c());
                int i2 = -1;
                int size = f.this.f19274b.j().size();
                boolean z2 = false;
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    androidx.appcompat.view.menu.i iVar = f.this.f19274b.j().get(i4);
                    if (iVar.isChecked()) {
                        a(iVar);
                    }
                    if (iVar.isCheckable()) {
                        iVar.a(false);
                    }
                    if (iVar.hasSubMenu()) {
                        SubMenu subMenu = iVar.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i4 != 0) {
                                this.f19297b.add(new e(f.this.f19287o, 0));
                            }
                            this.f19297b.add(new C0130f(iVar));
                            int size2 = this.f19297b.size();
                            int size3 = subMenu.size();
                            boolean z3 = false;
                            for (int i5 = 0; i5 < size3; i5++) {
                                androidx.appcompat.view.menu.i iVar2 = (androidx.appcompat.view.menu.i) subMenu.getItem(i5);
                                if (iVar2.isVisible()) {
                                    if (!z3 && iVar2.getIcon() != null) {
                                        z3 = true;
                                    }
                                    if (iVar2.isCheckable()) {
                                        iVar2.a(false);
                                    }
                                    if (iVar.isChecked()) {
                                        a(iVar);
                                    }
                                    this.f19297b.add(new C0130f(iVar2));
                                }
                            }
                            if (z3) {
                                a(size2, this.f19297b.size());
                            }
                        }
                    } else {
                        int groupId = iVar.getGroupId();
                        if (groupId != i2) {
                            i3 = this.f19297b.size();
                            z2 = iVar.getIcon() != null;
                            if (i4 != 0) {
                                i3++;
                                this.f19297b.add(new e(f.this.f19287o, f.this.f19287o));
                            }
                        } else if (!z2 && iVar.getIcon() != null) {
                            a(i3, this.f19297b.size());
                            z2 = true;
                        }
                        C0130f fVar = new C0130f(iVar);
                        fVar.f19302a = z2;
                        this.f19297b.add(fVar);
                        i2 = groupId;
                    }
                }
                this.f19299d = false;
            }
        }

        /* renamed from: a */
        public k onCreateViewHolder(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                return new h(f.this.f19276d, viewGroup, f.this.f19288p);
            }
            if (i2 == 1) {
                return new j(f.this.f19276d, viewGroup);
            }
            if (i2 == 2) {
                return new i(f.this.f19276d, viewGroup);
            }
            if (i2 != 3) {
                return null;
            }
            return new a(f.this.f19273a);
        }

        public void a() {
            e();
            notifyDataSetChanged();
        }

        public void a(Bundle bundle) {
            androidx.appcompat.view.menu.i a2;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            androidx.appcompat.view.menu.i a3;
            int i2 = bundle.getInt("android:menu:checked", 0);
            if (i2 != 0) {
                this.f19299d = true;
                int size = this.f19297b.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    d dVar = this.f19297b.get(i3);
                    if ((dVar instanceof C0130f) && (a3 = ((C0130f) dVar).a()) != null && a3.getItemId() == i2) {
                        a(a3);
                        break;
                    }
                    i3++;
                }
                this.f19299d = false;
                e();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f19297b.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    d dVar2 = this.f19297b.get(i4);
                    if (!(!(dVar2 instanceof C0130f) || (a2 = ((C0130f) dVar2).a()) == null || (actionView = a2.getActionView()) == null || (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a2.getItemId())) == null)) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void a(androidx.appcompat.view.menu.i iVar) {
            if (this.f19298c != iVar && iVar.isCheckable()) {
                androidx.appcompat.view.menu.i iVar2 = this.f19298c;
                if (iVar2 != null) {
                    iVar2.setChecked(false);
                }
                this.f19298c = iVar;
                iVar.setChecked(true);
            }
        }

        /* renamed from: a */
        public void onViewRecycled(k kVar) {
            if (kVar instanceof h) {
                ((NavigationMenuItemView) kVar.itemView).b();
            }
        }

        /* renamed from: a */
        public void onBindViewHolder(k kVar, int i2) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) kVar.itemView;
                navigationMenuItemView.setIconTintList(f.this.f19280h);
                if (f.this.f19278f) {
                    navigationMenuItemView.setTextAppearance(f.this.f19277e);
                }
                if (f.this.f19279g != null) {
                    navigationMenuItemView.setTextColor(f.this.f19279g);
                }
                ac.a((View) navigationMenuItemView, f.this.f19281i != null ? f.this.f19281i.getConstantState().newDrawable() : null);
                C0130f fVar = (C0130f) this.f19297b.get(i2);
                navigationMenuItemView.setNeedsEmptyIcon(fVar.f19302a);
                navigationMenuItemView.setHorizontalPadding(f.this.f19282j);
                navigationMenuItemView.setIconPadding(f.this.f19283k);
                if (f.this.f19285m) {
                    navigationMenuItemView.setIconSize(f.this.f19284l);
                }
                navigationMenuItemView.setMaxLines(f.this.f19292t);
                navigationMenuItemView.a(fVar.a(), 0);
            } else if (itemViewType == 1) {
                ((TextView) kVar.itemView).setText(((C0130f) this.f19297b.get(i2)).a().getTitle());
            } else if (itemViewType == 2) {
                e eVar = (e) this.f19297b.get(i2);
                kVar.itemView.setPadding(0, eVar.a(), 0, eVar.b());
            }
        }

        public void a(boolean z2) {
            this.f19299d = z2;
        }

        public androidx.appcompat.view.menu.i b() {
            return this.f19298c;
        }

        public Bundle c() {
            Bundle bundle = new Bundle();
            androidx.appcompat.view.menu.i iVar = this.f19298c;
            if (iVar != null) {
                bundle.putInt("android:menu:checked", iVar.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            int size = this.f19297b.size();
            for (int i2 = 0; i2 < size; i2++) {
                d dVar = this.f19297b.get(i2);
                if (dVar instanceof C0130f) {
                    androidx.appcompat.view.menu.i a2 = ((C0130f) dVar).a();
                    View actionView = a2 != null ? a2.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a2.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        /* access modifiers changed from: package-private */
        public int d() {
            int i2 = f.this.f19273a.getChildCount() == 0 ? 0 : 1;
            for (int i3 = 0; i3 < f.this.f19275c.getItemCount(); i3++) {
                if (f.this.f19275c.getItemViewType(i3) == 0) {
                    i2++;
                }
            }
            return i2;
        }

        public int getItemCount() {
            return this.f19297b.size();
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public int getItemViewType(int i2) {
            d dVar = this.f19297b.get(i2);
            if (dVar instanceof e) {
                return 2;
            }
            if (dVar instanceof c) {
                return 3;
            }
            if (dVar instanceof C0130f) {
                return ((C0130f) dVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }
    }

    private static class c implements d {
        c() {
        }
    }

    private interface d {
    }

    private static class e implements d {

        /* renamed from: a  reason: collision with root package name */
        private final int f19300a;

        /* renamed from: b  reason: collision with root package name */
        private final int f19301b;

        public e(int i2, int i3) {
            this.f19300a = i2;
            this.f19301b = i3;
        }

        public int a() {
            return this.f19300a;
        }

        public int b() {
            return this.f19301b;
        }
    }

    /* renamed from: com.google.android.material.internal.f$f  reason: collision with other inner class name */
    private static class C0130f implements d {

        /* renamed from: a  reason: collision with root package name */
        boolean f19302a;

        /* renamed from: b  reason: collision with root package name */
        private final androidx.appcompat.view.menu.i f19303b;

        C0130f(androidx.appcompat.view.menu.i iVar) {
            this.f19303b = iVar;
        }

        public androidx.appcompat.view.menu.i a() {
            return this.f19303b;
        }
    }

    private class g extends u {
        g(RecyclerView recyclerView) {
            super(recyclerView);
        }

        public void a(View view, u.c cVar) {
            super.a(view, cVar);
            cVar.a((Object) c.b.a(f.this.f19275c.d(), 0, false));
        }
    }

    private static class h extends k {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    private static class i extends k {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    private static class j extends k {
        public j(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    private static abstract class k extends RecyclerView.v {
        public k(View view) {
            super(view);
        }
    }

    private void l() {
        int i2 = (this.f19273a.getChildCount() != 0 || !this.f19286n) ? 0 : this.f19293u;
        NavigationMenuView navigationMenuView = this.f19289q;
        navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
    }

    public androidx.appcompat.view.menu.i a() {
        return this.f19275c.b();
    }

    public n a(ViewGroup viewGroup) {
        if (this.f19289q == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f19276d.inflate(R.layout.design_navigation_menu, viewGroup, false);
            this.f19289q = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new g(navigationMenuView));
            if (this.f19275c == null) {
                this.f19275c = new b();
            }
            int i2 = this.f19294v;
            if (i2 != -1) {
                this.f19289q.setOverScrollMode(i2);
            }
            this.f19273a = (LinearLayout) this.f19276d.inflate(R.layout.design_navigation_item_header, this.f19289q, false);
            this.f19289q.setAdapter(this.f19275c);
        }
        return this.f19289q;
    }

    public void a(int i2) {
        this.f19291s = i2;
    }

    public void a(Context context, androidx.appcompat.view.menu.g gVar) {
        this.f19276d = LayoutInflater.from(context);
        this.f19274b = gVar;
        this.f19287o = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public void a(ColorStateList colorStateList) {
        this.f19280h = colorStateList;
        a(false);
    }

    public void a(Drawable drawable) {
        this.f19281i = drawable;
        a(false);
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f19289q.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f19275c.a(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f19273a.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    public void a(View view) {
        this.f19273a.addView(view);
        NavigationMenuView navigationMenuView = this.f19289q;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public void a(androidx.appcompat.view.menu.g gVar, boolean z2) {
        m.a aVar = this.f19290r;
        if (aVar != null) {
            aVar.a(gVar, z2);
        }
    }

    public void a(androidx.appcompat.view.menu.i iVar) {
        this.f19275c.a(iVar);
    }

    public void a(m.a aVar) {
        this.f19290r = aVar;
    }

    public void a(ak akVar) {
        int b2 = akVar.b();
        if (this.f19293u != b2) {
            this.f19293u = b2;
            l();
        }
        NavigationMenuView navigationMenuView = this.f19289q;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, akVar.d());
        ac.b((View) this.f19273a, akVar);
    }

    public void a(boolean z2) {
        b bVar = this.f19275c;
        if (bVar != null) {
            bVar.a();
        }
    }

    public boolean a(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
        return false;
    }

    public boolean a(r rVar) {
        return false;
    }

    public View b(int i2) {
        View inflate = this.f19276d.inflate(i2, this.f19273a, false);
        a(inflate);
        return inflate;
    }

    public void b(ColorStateList colorStateList) {
        this.f19279g = colorStateList;
        a(false);
    }

    public void b(boolean z2) {
        b bVar = this.f19275c;
        if (bVar != null) {
            bVar.a(z2);
        }
    }

    public boolean b() {
        return false;
    }

    public boolean b(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
        return false;
    }

    public int c() {
        return this.f19291s;
    }

    public void c(int i2) {
        this.f19277e = i2;
        this.f19278f = true;
        a(false);
    }

    public void c(boolean z2) {
        if (this.f19286n != z2) {
            this.f19286n = z2;
            l();
        }
    }

    public int d() {
        return this.f19273a.getChildCount();
    }

    public void d(int i2) {
        this.f19282j = i2;
        a(false);
    }

    public ColorStateList e() {
        return this.f19280h;
    }

    public void e(int i2) {
        this.f19283k = i2;
        a(false);
    }

    public Parcelable f() {
        Bundle bundle = new Bundle();
        if (this.f19289q != null) {
            SparseArray sparseArray = new SparseArray();
            this.f19289q.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        b bVar = this.f19275c;
        if (bVar != null) {
            bundle.putBundle("android:menu:adapter", bVar.c());
        }
        if (this.f19273a != null) {
            SparseArray sparseArray2 = new SparseArray();
            this.f19273a.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    public void f(int i2) {
        this.f19292t = i2;
        a(false);
    }

    public ColorStateList g() {
        return this.f19279g;
    }

    public void g(int i2) {
        if (this.f19284l != i2) {
            this.f19284l = i2;
            this.f19285m = true;
            a(false);
        }
    }

    public Drawable h() {
        return this.f19281i;
    }

    public void h(int i2) {
        this.f19294v = i2;
        NavigationMenuView navigationMenuView = this.f19289q;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i2);
        }
    }

    public int i() {
        return this.f19282j;
    }

    public int j() {
        return this.f19283k;
    }

    public int k() {
        return this.f19292t;
    }
}
