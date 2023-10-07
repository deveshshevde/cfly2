package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import n.c;

class s extends o implements SubMenu {

    /* renamed from: b  reason: collision with root package name */
    private final c f971b;

    s(Context context, c cVar) {
        super(context, cVar);
        this.f971b = cVar;
    }

    public void clearHeader() {
        this.f971b.clearHeader();
    }

    public MenuItem getItem() {
        return a(this.f971b.getItem());
    }

    public SubMenu setHeaderIcon(int i2) {
        this.f971b.setHeaderIcon(i2);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f971b.setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i2) {
        this.f971b.setHeaderTitle(i2);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f971b.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.f971b.setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i2) {
        this.f971b.setIcon(i2);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f971b.setIcon(drawable);
        return this;
    }
}
