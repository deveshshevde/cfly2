package it.sephiroth.android.library.widget;

import android.database.DataSetObserver;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import it.sephiroth.android.library.widget.HListView;
import java.util.ArrayList;
import java.util.Iterator;

public class b implements Filterable, WrapperListAdapter {

    /* renamed from: c  reason: collision with root package name */
    static final ArrayList<HListView.b> f29343c = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    ArrayList<HListView.b> f29344a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<HListView.b> f29345b;

    /* renamed from: d  reason: collision with root package name */
    boolean f29346d;

    /* renamed from: e  reason: collision with root package name */
    private final ListAdapter f29347e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f29348f;

    public b(ArrayList<HListView.b> arrayList, ArrayList<HListView.b> arrayList2, ListAdapter listAdapter) {
        this.f29347e = listAdapter;
        this.f29348f = listAdapter instanceof Filterable;
        this.f29344a = arrayList == null ? f29343c : arrayList;
        if (arrayList2 == null) {
            this.f29345b = f29343c;
        } else {
            this.f29345b = arrayList2;
        }
        this.f29346d = a(this.f29344a) && a(this.f29345b);
    }

    private boolean a(ArrayList<HListView.b> arrayList) {
        if (arrayList == null) {
            return true;
        }
        Iterator<HListView.b> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (!it2.next().f29313c) {
                return false;
            }
        }
        return true;
    }

    public int a() {
        return this.f29344a.size();
    }

    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f29347e;
        if (listAdapter != null) {
            return this.f29346d && listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    public int b() {
        return this.f29345b.size();
    }

    public int getCount() {
        int b2;
        int a2;
        if (this.f29347e != null) {
            b2 = b() + a();
            a2 = this.f29347e.getCount();
        } else {
            b2 = b();
            a2 = a();
        }
        return b2 + a2;
    }

    public Filter getFilter() {
        if (this.f29348f) {
            return ((Filterable) this.f29347e).getFilter();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        r0 = r1.getCount();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getItem(int r3) {
        /*
            r2 = this;
            int r0 = r2.a()
            if (r3 >= r0) goto L_0x0011
            java.util.ArrayList<it.sephiroth.android.library.widget.HListView$b> r0 = r2.f29344a
            java.lang.Object r3 = r0.get(r3)
            it.sephiroth.android.library.widget.HListView$b r3 = (it.sephiroth.android.library.widget.HListView.b) r3
            java.lang.Object r3 = r3.f29312b
            return r3
        L_0x0011:
            int r3 = r3 - r0
            r0 = 0
            android.widget.ListAdapter r1 = r2.f29347e
            if (r1 == 0) goto L_0x0024
            int r0 = r1.getCount()
            if (r3 >= r0) goto L_0x0024
            android.widget.ListAdapter r0 = r2.f29347e
            java.lang.Object r3 = r0.getItem(r3)
            return r3
        L_0x0024:
            java.util.ArrayList<it.sephiroth.android.library.widget.HListView$b> r1 = r2.f29345b
            int r3 = r3 - r0
            java.lang.Object r3 = r1.get(r3)
            it.sephiroth.android.library.widget.HListView$b r3 = (it.sephiroth.android.library.widget.HListView.b) r3
            java.lang.Object r3 = r3.f29312b
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.b.getItem(int):java.lang.Object");
    }

    public long getItemId(int i2) {
        int i3;
        int a2 = a();
        ListAdapter listAdapter = this.f29347e;
        if (listAdapter == null || i2 < a2 || (i3 = i2 - a2) >= listAdapter.getCount()) {
            return -1;
        }
        return this.f29347e.getItemId(i3);
    }

    public int getItemViewType(int i2) {
        int i3;
        int a2 = a();
        ListAdapter listAdapter = this.f29347e;
        if (listAdapter == null || i2 < a2 || (i3 = i2 - a2) >= listAdapter.getCount()) {
            return -2;
        }
        return this.f29347e.getItemViewType(i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        r0 = r1.getCount();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r3, android.view.View r4, android.view.ViewGroup r5) {
        /*
            r2 = this;
            int r0 = r2.a()
            if (r3 >= r0) goto L_0x0011
            java.util.ArrayList<it.sephiroth.android.library.widget.HListView$b> r4 = r2.f29344a
            java.lang.Object r3 = r4.get(r3)
            it.sephiroth.android.library.widget.HListView$b r3 = (it.sephiroth.android.library.widget.HListView.b) r3
            android.view.View r3 = r3.f29311a
            return r3
        L_0x0011:
            int r3 = r3 - r0
            r0 = 0
            android.widget.ListAdapter r1 = r2.f29347e
            if (r1 == 0) goto L_0x0024
            int r0 = r1.getCount()
            if (r3 >= r0) goto L_0x0024
            android.widget.ListAdapter r0 = r2.f29347e
            android.view.View r3 = r0.getView(r3, r4, r5)
            return r3
        L_0x0024:
            java.util.ArrayList<it.sephiroth.android.library.widget.HListView$b> r4 = r2.f29345b
            int r3 = r3 - r0
            java.lang.Object r3 = r4.get(r3)
            it.sephiroth.android.library.widget.HListView$b r3 = (it.sephiroth.android.library.widget.HListView.b) r3
            android.view.View r3 = r3.f29311a
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.b.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public int getViewTypeCount() {
        ListAdapter listAdapter = this.f29347e;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount();
        }
        return 1;
    }

    public ListAdapter getWrappedAdapter() {
        return this.f29347e;
    }

    public boolean hasStableIds() {
        ListAdapter listAdapter = this.f29347e;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return false;
    }

    public boolean isEmpty() {
        ListAdapter listAdapter = this.f29347e;
        return listAdapter == null || listAdapter.isEmpty();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        r0 = r1.getCount();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEnabled(int r3) {
        /*
            r2 = this;
            int r0 = r2.a()
            if (r3 >= r0) goto L_0x0011
            java.util.ArrayList<it.sephiroth.android.library.widget.HListView$b> r0 = r2.f29344a
            java.lang.Object r3 = r0.get(r3)
            it.sephiroth.android.library.widget.HListView$b r3 = (it.sephiroth.android.library.widget.HListView.b) r3
            boolean r3 = r3.f29313c
            return r3
        L_0x0011:
            int r3 = r3 - r0
            r0 = 0
            android.widget.ListAdapter r1 = r2.f29347e
            if (r1 == 0) goto L_0x0024
            int r0 = r1.getCount()
            if (r3 >= r0) goto L_0x0024
            android.widget.ListAdapter r0 = r2.f29347e
            boolean r3 = r0.isEnabled(r3)
            return r3
        L_0x0024:
            java.util.ArrayList<it.sephiroth.android.library.widget.HListView$b> r1 = r2.f29345b
            int r3 = r3 - r0
            java.lang.Object r3 = r1.get(r3)
            it.sephiroth.android.library.widget.HListView$b r3 = (it.sephiroth.android.library.widget.HListView.b) r3
            boolean r3 = r3.f29313c
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.b.isEnabled(int):boolean");
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f29347e;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f29347e;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
