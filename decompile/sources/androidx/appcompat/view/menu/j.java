package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;
import t.b;

public class j extends c implements MenuItem {

    /* renamed from: b  reason: collision with root package name */
    private final n.b f920b;

    /* renamed from: c  reason: collision with root package name */
    private Method f921c;

    private class a extends t.b {

        /* renamed from: a  reason: collision with root package name */
        final ActionProvider f922a;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f922a = actionProvider;
        }

        public View a() {
            return this.f922a.onCreateActionView();
        }

        public void a(SubMenu subMenu) {
            this.f922a.onPrepareSubMenu(j.this.a(subMenu));
        }

        public boolean b() {
            return this.f922a.onPerformDefaultAction();
        }

        public boolean c() {
            return this.f922a.hasSubMenu();
        }
    }

    private class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: d  reason: collision with root package name */
        private b.C0257b f925d;

        b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public View a(MenuItem menuItem) {
            return this.f922a.onCreateActionView(menuItem);
        }

        public void a(b.C0257b bVar) {
            this.f925d = bVar;
            this.f922a.setVisibilityListener(bVar != null ? this : null);
        }

        public boolean d() {
            return this.f922a.overridesItemVisibility();
        }

        public boolean e() {
            return this.f922a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean z2) {
            b.C0257b bVar = this.f925d;
            if (bVar != null) {
                bVar.a(z2);
            }
        }
    }

    static class c extends FrameLayout implements f.c {

        /* renamed from: a  reason: collision with root package name */
        final CollapsibleActionView f926a;

        c(View view) {
            super(view.getContext());
            this.f926a = (CollapsibleActionView) view;
            addView(view);
        }

        public void a() {
            this.f926a.onActionViewExpanded();
        }

        public void b() {
            this.f926a.onActionViewCollapsed();
        }

        /* access modifiers changed from: package-private */
        public View c() {
            return (View) this.f926a;
        }
    }

    private class d implements MenuItem.OnActionExpandListener {

        /* renamed from: b  reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f928b;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f928b = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f928b.onMenuItemActionCollapse(j.this.a(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f928b.onMenuItemActionExpand(j.this.a(menuItem));
        }
    }

    private class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f930b;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f930b = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f930b.onMenuItemClick(j.this.a(menuItem));
        }
    }

    public j(Context context, n.b bVar) {
        super(context);
        if (bVar != null) {
            this.f920b = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public void a(boolean z2) {
        try {
            if (this.f921c == null) {
                this.f921c = this.f920b.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f921c.invoke(this.f920b, new Object[]{Boolean.valueOf(z2)});
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    public boolean collapseActionView() {
        return this.f920b.collapseActionView();
    }

    public boolean expandActionView() {
        return this.f920b.expandActionView();
    }

    public ActionProvider getActionProvider() {
        t.b a2 = this.f920b.a();
        if (a2 instanceof a) {
            return ((a) a2).f922a;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.f920b.getActionView();
        return actionView instanceof c ? ((c) actionView).c() : actionView;
    }

    public int getAlphabeticModifiers() {
        return this.f920b.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.f920b.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.f920b.getContentDescription();
    }

    public int getGroupId() {
        return this.f920b.getGroupId();
    }

    public Drawable getIcon() {
        return this.f920b.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.f920b.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f920b.getIconTintMode();
    }

    public Intent getIntent() {
        return this.f920b.getIntent();
    }

    public int getItemId() {
        return this.f920b.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f920b.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.f920b.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.f920b.getNumericShortcut();
    }

    public int getOrder() {
        return this.f920b.getOrder();
    }

    public SubMenu getSubMenu() {
        return a(this.f920b.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.f920b.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.f920b.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.f920b.getTooltipText();
    }

    public boolean hasSubMenu() {
        return this.f920b.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.f920b.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.f920b.isCheckable();
    }

    public boolean isChecked() {
        return this.f920b.isChecked();
    }

    public boolean isEnabled() {
        return this.f920b.isEnabled();
    }

    public boolean isVisible() {
        return this.f920b.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        t.b bVar = Build.VERSION.SDK_INT >= 16 ? new b(this.f806a, actionProvider) : new a(this.f806a, actionProvider);
        n.b bVar2 = this.f920b;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    public MenuItem setActionView(int i2) {
        this.f920b.setActionView(i2);
        View actionView = this.f920b.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f920b.setActionView((View) new c(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f920b.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.f920b.setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f920b.setAlphabeticShortcut(c2, i2);
        return this;
    }

    public MenuItem setCheckable(boolean z2) {
        this.f920b.setCheckable(z2);
        return this;
    }

    public MenuItem setChecked(boolean z2) {
        this.f920b.setChecked(z2);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f920b.a(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z2) {
        this.f920b.setEnabled(z2);
        return this;
    }

    public MenuItem setIcon(int i2) {
        this.f920b.setIcon(i2);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f920b.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f920b.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f920b.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f920b.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.f920b.setNumericShortcut(c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f920b.setNumericShortcut(c2, i2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f920b.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f920b.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f920b.setShortcut(c2, c3);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f920b.setShortcut(c2, c3, i2, i3);
        return this;
    }

    public void setShowAsAction(int i2) {
        this.f920b.setShowAsAction(i2);
    }

    public MenuItem setShowAsActionFlags(int i2) {
        this.f920b.setShowAsActionFlags(i2);
        return this;
    }

    public MenuItem setTitle(int i2) {
        this.f920b.setTitle(i2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f920b.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f920b.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f920b.b(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z2) {
        return this.f920b.setVisible(z2);
    }
}
