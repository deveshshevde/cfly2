package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import n.b;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final int f776a;

    /* renamed from: b  reason: collision with root package name */
    private final int f777b;

    /* renamed from: c  reason: collision with root package name */
    private final int f778c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f779d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f780e;

    /* renamed from: f  reason: collision with root package name */
    private Intent f781f;

    /* renamed from: g  reason: collision with root package name */
    private char f782g;

    /* renamed from: h  reason: collision with root package name */
    private int f783h = 4096;

    /* renamed from: i  reason: collision with root package name */
    private char f784i;

    /* renamed from: j  reason: collision with root package name */
    private int f785j = 4096;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f786k;

    /* renamed from: l  reason: collision with root package name */
    private Context f787l;

    /* renamed from: m  reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f788m;

    /* renamed from: n  reason: collision with root package name */
    private CharSequence f789n;

    /* renamed from: o  reason: collision with root package name */
    private CharSequence f790o;

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f791p = null;

    /* renamed from: q  reason: collision with root package name */
    private PorterDuff.Mode f792q = null;

    /* renamed from: r  reason: collision with root package name */
    private boolean f793r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f794s = false;

    /* renamed from: t  reason: collision with root package name */
    private int f795t = 16;

    public a(Context context, int i2, int i3, int i4, int i5, CharSequence charSequence) {
        this.f787l = context;
        this.f776a = i3;
        this.f777b = i2;
        this.f778c = i5;
        this.f779d = charSequence;
    }

    private void b() {
        Drawable drawable = this.f786k;
        if (drawable == null) {
            return;
        }
        if (this.f793r || this.f794s) {
            Drawable g2 = androidx.core.graphics.drawable.a.g(drawable);
            this.f786k = g2;
            Drawable mutate = g2.mutate();
            this.f786k = mutate;
            if (this.f793r) {
                androidx.core.graphics.drawable.a.a(mutate, this.f791p);
            }
            if (this.f794s) {
                androidx.core.graphics.drawable.a.a(this.f786k, this.f792q);
            }
        }
    }

    /* renamed from: a */
    public b setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public b setContentDescription(CharSequence charSequence) {
        this.f789n = charSequence;
        return this;
    }

    public b a(t.b bVar) {
        throw new UnsupportedOperationException();
    }

    public t.b a() {
        return null;
    }

    /* renamed from: b */
    public b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    /* renamed from: b */
    public b setTooltipText(CharSequence charSequence) {
        this.f790o = charSequence;
        return this;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.f785j;
    }

    public char getAlphabeticShortcut() {
        return this.f784i;
    }

    public CharSequence getContentDescription() {
        return this.f789n;
    }

    public int getGroupId() {
        return this.f777b;
    }

    public Drawable getIcon() {
        return this.f786k;
    }

    public ColorStateList getIconTintList() {
        return this.f791p;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f792q;
    }

    public Intent getIntent() {
        return this.f781f;
    }

    public int getItemId() {
        return this.f776a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public int getNumericModifiers() {
        return this.f783h;
    }

    public char getNumericShortcut() {
        return this.f782g;
    }

    public int getOrder() {
        return this.f778c;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f779d;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f780e;
        return charSequence != null ? charSequence : this.f779d;
    }

    public CharSequence getTooltipText() {
        return this.f790o;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f795t & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f795t & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f795t & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f795t & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.f784i = Character.toLowerCase(c2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f784i = Character.toLowerCase(c2);
        this.f785j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public MenuItem setCheckable(boolean z2) {
        this.f795t = z2 | (this.f795t & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z2) {
        this.f795t = (z2 ? 2 : 0) | (this.f795t & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z2) {
        this.f795t = (z2 ? 16 : 0) | (this.f795t & -17);
        return this;
    }

    public MenuItem setIcon(int i2) {
        this.f786k = androidx.core.content.b.a(this.f787l, i2);
        b();
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f786k = drawable;
        b();
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f791p = colorStateList;
        this.f793r = true;
        b();
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f792q = mode;
        this.f794s = true;
        b();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f781f = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.f782g = c2;
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f782g = c2;
        this.f783h = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f788m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f782g = c2;
        this.f784i = Character.toLowerCase(c3);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f782g = c2;
        this.f783h = KeyEvent.normalizeMetaState(i2);
        this.f784i = Character.toLowerCase(c3);
        this.f785j = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    public void setShowAsAction(int i2) {
    }

    public MenuItem setTitle(int i2) {
        this.f779d = this.f787l.getResources().getString(i2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f779d = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f780e = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z2) {
        int i2 = 8;
        int i3 = this.f795t & 8;
        if (z2) {
            i2 = 0;
        }
        this.f795t = i3 | i2;
        return this;
    }
}
