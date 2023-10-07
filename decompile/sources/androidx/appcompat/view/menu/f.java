package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

public class f extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    g f857a;

    /* renamed from: b  reason: collision with root package name */
    private int f858b = -1;

    /* renamed from: c  reason: collision with root package name */
    private boolean f859c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f860d;

    /* renamed from: e  reason: collision with root package name */
    private final LayoutInflater f861e;

    /* renamed from: f  reason: collision with root package name */
    private final int f862f;

    public f(g gVar, LayoutInflater layoutInflater, boolean z2, int i2) {
        this.f860d = z2;
        this.f861e = layoutInflater;
        this.f857a = gVar;
        this.f862f = i2;
        b();
    }

    public g a() {
        return this.f857a;
    }

    /* renamed from: a */
    public i getItem(int i2) {
        ArrayList<i> m2 = this.f860d ? this.f857a.m() : this.f857a.j();
        int i3 = this.f858b;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return m2.get(i2);
    }

    public void a(boolean z2) {
        this.f859c = z2;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        i s2 = this.f857a.s();
        if (s2 != null) {
            ArrayList<i> m2 = this.f857a.m();
            int size = m2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (m2.get(i2) == s2) {
                    this.f858b = i2;
                    return;
                }
            }
        }
        this.f858b = -1;
    }

    public int getCount() {
        ArrayList<i> m2 = this.f860d ? this.f857a.m() : this.f857a.j();
        int i2 = this.f858b;
        int size = m2.size();
        return i2 < 0 ? size : size - 1;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f861e.inflate(this.f862f, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i3 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f857a.b() && groupId != (i3 >= 0 ? getItem(i3).getGroupId() : groupId));
        n.a aVar = (n.a) view;
        if (this.f859c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i2), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
