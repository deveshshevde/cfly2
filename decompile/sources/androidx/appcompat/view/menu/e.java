package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

public class e implements AdapterView.OnItemClickListener, m {

    /* renamed from: a  reason: collision with root package name */
    Context f845a;

    /* renamed from: b  reason: collision with root package name */
    LayoutInflater f846b;

    /* renamed from: c  reason: collision with root package name */
    g f847c;

    /* renamed from: d  reason: collision with root package name */
    ExpandedMenuView f848d;

    /* renamed from: e  reason: collision with root package name */
    int f849e;

    /* renamed from: f  reason: collision with root package name */
    int f850f;

    /* renamed from: g  reason: collision with root package name */
    int f851g;

    /* renamed from: h  reason: collision with root package name */
    a f852h;

    /* renamed from: i  reason: collision with root package name */
    private m.a f853i;

    /* renamed from: j  reason: collision with root package name */
    private int f854j;

    private class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private int f856b = -1;

        public a() {
            a();
        }

        /* renamed from: a */
        public i getItem(int i2) {
            ArrayList<i> m2 = e.this.f847c.m();
            int i3 = i2 + e.this.f849e;
            int i4 = this.f856b;
            if (i4 >= 0 && i3 >= i4) {
                i3++;
            }
            return m2.get(i3);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            i s2 = e.this.f847c.s();
            if (s2 != null) {
                ArrayList<i> m2 = e.this.f847c.m();
                int size = m2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (m2.get(i2) == s2) {
                        this.f856b = i2;
                        return;
                    }
                }
            }
            this.f856b = -1;
        }

        public int getCount() {
            int size = e.this.f847c.m().size() - e.this.f849e;
            return this.f856b < 0 ? size : size - 1;
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = e.this.f846b.inflate(e.this.f851g, viewGroup, false);
            }
            ((n.a) view).a(getItem(i2), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(int i2, int i3) {
        this.f851g = i2;
        this.f850f = i3;
    }

    public e(Context context, int i2) {
        this(i2, 0);
        this.f845a = context;
        this.f846b = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f852h == null) {
            this.f852h = new a();
        }
        return this.f852h;
    }

    public n a(ViewGroup viewGroup) {
        if (this.f848d == null) {
            this.f848d = (ExpandedMenuView) this.f846b.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f852h == null) {
                this.f852h = new a();
            }
            this.f848d.setAdapter(this.f852h);
            this.f848d.setOnItemClickListener(this);
        }
        return this.f848d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r3, androidx.appcompat.view.menu.g r4) {
        /*
            r2 = this;
            int r0 = r2.f850f
            if (r0 == 0) goto L_0x0014
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            int r1 = r2.f850f
            r0.<init>(r3, r1)
            r2.f845a = r0
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r0)
        L_0x0011:
            r2.f846b = r3
            goto L_0x0023
        L_0x0014:
            android.content.Context r0 = r2.f845a
            if (r0 == 0) goto L_0x0023
            r2.f845a = r3
            android.view.LayoutInflater r0 = r2.f846b
            if (r0 != 0) goto L_0x0023
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            goto L_0x0011
        L_0x0023:
            r2.f847c = r4
            androidx.appcompat.view.menu.e$a r3 = r2.f852h
            if (r3 == 0) goto L_0x002c
            r3.notifyDataSetChanged()
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.a(android.content.Context, androidx.appcompat.view.menu.g):void");
    }

    public void a(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.f848d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public void a(Parcelable parcelable) {
        b((Bundle) parcelable);
    }

    public void a(g gVar, boolean z2) {
        m.a aVar = this.f853i;
        if (aVar != null) {
            aVar.a(gVar, z2);
        }
    }

    public void a(m.a aVar) {
        this.f853i = aVar;
    }

    public void a(boolean z2) {
        a aVar = this.f852h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public boolean a(g gVar, i iVar) {
        return false;
    }

    public boolean a(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        new h(rVar).a((IBinder) null);
        m.a aVar = this.f853i;
        if (aVar == null) {
            return true;
        }
        aVar.a(rVar);
        return true;
    }

    public void b(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f848d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public boolean b() {
        return false;
    }

    public boolean b(g gVar, i iVar) {
        return false;
    }

    public int c() {
        return this.f854j;
    }

    public Parcelable f() {
        if (this.f848d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        a(bundle);
        return bundle;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f847c.a((MenuItem) this.f852h.getItem(i2), (m) this, 0);
    }
}
