package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.g;

public class r extends g implements SubMenu {

    /* renamed from: d  reason: collision with root package name */
    private g f969d;

    /* renamed from: e  reason: collision with root package name */
    private i f970e;

    public r(Context context, g gVar, i iVar) {
        super(context);
        this.f969d = gVar;
        this.f970e = iVar;
    }

    public String a() {
        i iVar = this.f970e;
        int itemId = iVar != null ? iVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.a() + ":" + itemId;
    }

    public void a(g.a aVar) {
        this.f969d.a(aVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a(g gVar, MenuItem menuItem) {
        return super.a(gVar, menuItem) || this.f969d.a(gVar, menuItem);
    }

    public boolean b() {
        return this.f969d.b();
    }

    public boolean c() {
        return this.f969d.c();
    }

    public boolean c(i iVar) {
        return this.f969d.c(iVar);
    }

    public boolean d() {
        return this.f969d.d();
    }

    public boolean d(i iVar) {
        return this.f969d.d(iVar);
    }

    public MenuItem getItem() {
        return this.f970e;
    }

    public g q() {
        return this.f969d.q();
    }

    public void setGroupDividerEnabled(boolean z2) {
        this.f969d.setGroupDividerEnabled(z2);
    }

    public SubMenu setHeaderIcon(int i2) {
        return (SubMenu) super.e(i2);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.a(drawable);
    }

    public SubMenu setHeaderTitle(int i2) {
        return (SubMenu) super.d(i2);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.a(charSequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.a(view);
    }

    public SubMenu setIcon(int i2) {
        this.f970e.setIcon(i2);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f970e.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z2) {
        this.f969d.setQwertyMode(z2);
    }

    public Menu t() {
        return this.f969d;
    }
}
