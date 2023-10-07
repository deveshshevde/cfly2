package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import n.a;

public class o extends c implements Menu {

    /* renamed from: b  reason: collision with root package name */
    private final a f945b;

    public o(Context context, a aVar) {
        super(context);
        if (aVar != null) {
            this.f945b = aVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(int i2) {
        return a(this.f945b.add(i2));
    }

    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(this.f945b.add(i2, i3, i4, i5));
    }

    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(this.f945b.add(i2, i3, i4, charSequence));
    }

    public MenuItem add(CharSequence charSequence) {
        return a(this.f945b.add(charSequence));
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = this.f945b.addIntentOptions(i2, i3, i4, componentName, intentArr, intent, i5, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i6 = 0; i6 < length; i6++) {
                menuItemArr2[i6] = a(menuItemArr3[i6]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(int i2) {
        return a(this.f945b.addSubMenu(i2));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return a(this.f945b.addSubMenu(i2, i3, i4, i5));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        return a(this.f945b.addSubMenu(i2, i3, i4, charSequence));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(this.f945b.addSubMenu(charSequence));
    }

    public void clear() {
        a();
        this.f945b.clear();
    }

    public void close() {
        this.f945b.close();
    }

    public MenuItem findItem(int i2) {
        return a(this.f945b.findItem(i2));
    }

    public MenuItem getItem(int i2) {
        return a(this.f945b.getItem(i2));
    }

    public boolean hasVisibleItems() {
        return this.f945b.hasVisibleItems();
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return this.f945b.isShortcutKey(i2, keyEvent);
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return this.f945b.performIdentifierAction(i2, i3);
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        return this.f945b.performShortcut(i2, keyEvent, i3);
    }

    public void removeGroup(int i2) {
        a(i2);
        this.f945b.removeGroup(i2);
    }

    public void removeItem(int i2) {
        b(i2);
        this.f945b.removeItem(i2);
    }

    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        this.f945b.setGroupCheckable(i2, z2, z3);
    }

    public void setGroupEnabled(int i2, boolean z2) {
        this.f945b.setGroupEnabled(i2, z2);
    }

    public void setGroupVisible(int i2, boolean z2) {
        this.f945b.setGroupVisible(i2, z2);
    }

    public void setQwertyMode(boolean z2) {
        this.f945b.setQwertyMode(z2);
    }

    public int size() {
        return this.f945b.size();
    }
}
