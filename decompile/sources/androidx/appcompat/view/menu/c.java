package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import j.g;
import n.b;

abstract class c {

    /* renamed from: a  reason: collision with root package name */
    final Context f806a;

    /* renamed from: b  reason: collision with root package name */
    private g<b, MenuItem> f807b;

    /* renamed from: c  reason: collision with root package name */
    private g<n.c, SubMenu> f808c;

    c(Context context) {
        this.f806a = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.f807b == null) {
            this.f807b = new g<>();
        }
        MenuItem menuItem2 = this.f807b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j jVar = new j(this.f806a, bVar);
        this.f807b.put(bVar, jVar);
        return jVar;
    }

    /* access modifiers changed from: package-private */
    public final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof n.c)) {
            return subMenu;
        }
        n.c cVar = (n.c) subMenu;
        if (this.f808c == null) {
            this.f808c = new g<>();
        }
        SubMenu subMenu2 = this.f808c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        s sVar = new s(this.f806a, cVar);
        this.f808c.put(cVar, sVar);
        return sVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        g<b, MenuItem> gVar = this.f807b;
        if (gVar != null) {
            gVar.clear();
        }
        g<n.c, SubMenu> gVar2 = this.f808c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        if (this.f807b != null) {
            int i3 = 0;
            while (i3 < this.f807b.size()) {
                if (this.f807b.b(i3).getGroupId() == i2) {
                    this.f807b.d(i3);
                    i3--;
                }
                i3++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2) {
        if (this.f807b != null) {
            for (int i3 = 0; i3 < this.f807b.size(); i3++) {
                if (this.f807b.b(i3).getItemId() == i2) {
                    this.f807b.d(i3);
                    return;
                }
            }
        }
    }
}
