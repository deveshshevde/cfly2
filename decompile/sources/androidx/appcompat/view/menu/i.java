package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.n;
import androidx.core.graphics.drawable.a;
import n.b;
import t.b;

public final class i implements b {
    private View A;
    private t.b B;
    private MenuItem.OnActionExpandListener C;
    private boolean D = false;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a  reason: collision with root package name */
    g f893a;

    /* renamed from: b  reason: collision with root package name */
    private final int f894b;

    /* renamed from: c  reason: collision with root package name */
    private final int f895c;

    /* renamed from: d  reason: collision with root package name */
    private final int f896d;

    /* renamed from: e  reason: collision with root package name */
    private final int f897e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f898f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f899g;

    /* renamed from: h  reason: collision with root package name */
    private Intent f900h;

    /* renamed from: i  reason: collision with root package name */
    private char f901i;

    /* renamed from: j  reason: collision with root package name */
    private int f902j = 4096;

    /* renamed from: k  reason: collision with root package name */
    private char f903k;

    /* renamed from: l  reason: collision with root package name */
    private int f904l = 4096;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f905m;

    /* renamed from: n  reason: collision with root package name */
    private int f906n = 0;

    /* renamed from: o  reason: collision with root package name */
    private r f907o;

    /* renamed from: p  reason: collision with root package name */
    private Runnable f908p;

    /* renamed from: q  reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f909q;

    /* renamed from: r  reason: collision with root package name */
    private CharSequence f910r;

    /* renamed from: s  reason: collision with root package name */
    private CharSequence f911s;

    /* renamed from: t  reason: collision with root package name */
    private ColorStateList f912t = null;

    /* renamed from: u  reason: collision with root package name */
    private PorterDuff.Mode f913u = null;

    /* renamed from: v  reason: collision with root package name */
    private boolean f914v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f915w = false;

    /* renamed from: x  reason: collision with root package name */
    private boolean f916x = false;

    /* renamed from: y  reason: collision with root package name */
    private int f917y = 16;

    /* renamed from: z  reason: collision with root package name */
    private int f918z = 0;

    i(g gVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.f893a = gVar;
        this.f894b = i3;
        this.f895c = i2;
        this.f896d = i4;
        this.f897e = i5;
        this.f898f = charSequence;
        this.f918z = i6;
    }

    private Drawable a(Drawable drawable) {
        if (drawable != null && this.f916x && (this.f914v || this.f915w)) {
            drawable = a.g(drawable).mutate();
            if (this.f914v) {
                a.a(drawable, this.f912t);
            }
            if (this.f915w) {
                a.a(drawable, this.f913u);
            }
            this.f916x = false;
        }
        return drawable;
    }

    private static void a(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    /* access modifiers changed from: package-private */
    public CharSequence a(n.a aVar) {
        return (aVar == null || !aVar.a()) ? getTitle() : getTitleCondensed();
    }

    /* renamed from: a */
    public b setActionView(int i2) {
        Context f2 = this.f893a.f();
        setActionView(LayoutInflater.from(f2).inflate(i2, new LinearLayout(f2), false));
        return this;
    }

    /* renamed from: a */
    public b setActionView(View view) {
        int i2;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i2 = this.f894b) > 0) {
            view.setId(i2);
        }
        this.f893a.b(this);
        return this;
    }

    /* renamed from: a */
    public b setContentDescription(CharSequence charSequence) {
        this.f910r = charSequence;
        this.f893a.b(false);
        return this;
    }

    public b a(t.b bVar) {
        t.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.f();
        }
        this.A = null;
        this.B = bVar;
        this.f893a.b(true);
        t.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.a((b.C0257b) new b.C0257b() {
                public void a(boolean z2) {
                    i.this.f893a.a(i.this);
                }
            });
        }
        return this;
    }

    public t.b a() {
        return this.B;
    }

    /* access modifiers changed from: package-private */
    public void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    public void a(r rVar) {
        this.f907o = rVar;
        rVar.setHeaderTitle(getTitle());
    }

    public void a(boolean z2) {
        this.f917y = (z2 ? 4 : 0) | (this.f917y & -5);
    }

    /* renamed from: b */
    public n.b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    /* renamed from: b */
    public n.b setTooltipText(CharSequence charSequence) {
        this.f911s = charSequence;
        this.f893a.b(false);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        int i2 = this.f917y;
        int i3 = (z2 ? 2 : 0) | (i2 & -3);
        this.f917y = i3;
        if (i2 != i3) {
            this.f893a.b(false);
        }
    }

    public boolean b() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f909q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        g gVar = this.f893a;
        if (gVar.a(gVar, (MenuItem) this)) {
            return true;
        }
        Runnable runnable = this.f908p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f900h != null) {
            try {
                this.f893a.f().startActivity(this.f900h);
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e2);
            }
        }
        t.b bVar = this.B;
        return bVar != null && bVar.b();
    }

    public int c() {
        return this.f897e;
    }

    /* access modifiers changed from: package-private */
    public boolean c(boolean z2) {
        int i2 = this.f917y;
        int i3 = (z2 ? 0 : 8) | (i2 & -9);
        this.f917y = i3;
        return i2 != i3;
    }

    public boolean collapseActionView() {
        if ((this.f918z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f893a.d(this);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public char d() {
        return this.f893a.c() ? this.f903k : this.f901i;
    }

    public void d(boolean z2) {
        this.f917y = z2 ? this.f917y | 32 : this.f917y & -33;
    }

    /* access modifiers changed from: package-private */
    public String e() {
        int i2;
        char d2 = d();
        if (d2 == 0) {
            return "";
        }
        Resources resources = this.f893a.f().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f893a.f()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
        }
        int i3 = this.f893a.c() ? this.f904l : this.f902j;
        a(sb, i3, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
        a(sb, i3, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
        a(sb, i3, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
        a(sb, i3, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
        a(sb, i3, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
        a(sb, i3, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
        if (d2 == 8) {
            i2 = R.string.abc_menu_delete_shortcut_label;
        } else if (d2 == 10) {
            i2 = R.string.abc_menu_enter_shortcut_label;
        } else if (d2 != ' ') {
            sb.append(d2);
            return sb.toString();
        } else {
            i2 = R.string.abc_menu_space_shortcut_label;
        }
        sb.append(resources.getString(i2));
        return sb.toString();
    }

    public void e(boolean z2) {
        this.D = z2;
        this.f893a.b(false);
    }

    public boolean expandActionView() {
        if (!n()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f893a.c(this);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.f893a.d() && d() != 0;
    }

    public boolean g() {
        return (this.f917y & 4) != 0;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        t.b bVar = this.B;
        if (bVar == null) {
            return null;
        }
        View a2 = bVar.a((MenuItem) this);
        this.A = a2;
        return a2;
    }

    public int getAlphabeticModifiers() {
        return this.f904l;
    }

    public char getAlphabeticShortcut() {
        return this.f903k;
    }

    public CharSequence getContentDescription() {
        return this.f910r;
    }

    public int getGroupId() {
        return this.f895c;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f905m;
        if (drawable != null) {
            return a(drawable);
        }
        if (this.f906n == 0) {
            return null;
        }
        Drawable b2 = c.a.b(this.f893a.f(), this.f906n);
        this.f906n = 0;
        this.f905m = b2;
        return a(b2);
    }

    public ColorStateList getIconTintList() {
        return this.f912t;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f913u;
    }

    public Intent getIntent() {
        return this.f900h;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f894b;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    public int getNumericModifiers() {
        return this.f902j;
    }

    public char getNumericShortcut() {
        return this.f901i;
    }

    public int getOrder() {
        return this.f896d;
    }

    public SubMenu getSubMenu() {
        return this.f907o;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f898f;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f899g;
        if (charSequence == null) {
            charSequence = this.f898f;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public CharSequence getTooltipText() {
        return this.f911s;
    }

    public void h() {
        this.f893a.b(this);
    }

    public boolean hasSubMenu() {
        return this.f907o != null;
    }

    public boolean i() {
        return this.f893a.r();
    }

    public boolean isActionViewExpanded() {
        return this.D;
    }

    public boolean isCheckable() {
        return (this.f917y & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f917y & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f917y & 16) != 0;
    }

    public boolean isVisible() {
        t.b bVar = this.B;
        return (bVar == null || !bVar.d()) ? (this.f917y & 8) == 0 : (this.f917y & 8) == 0 && this.B.e();
    }

    public boolean j() {
        return (this.f917y & 32) == 32;
    }

    public boolean k() {
        return (this.f918z & 1) == 1;
    }

    public boolean l() {
        return (this.f918z & 2) == 2;
    }

    public boolean m() {
        return (this.f918z & 4) == 4;
    }

    public boolean n() {
        t.b bVar;
        if ((this.f918z & 8) == 0) {
            return false;
        }
        if (this.A == null && (bVar = this.B) != null) {
            this.A = bVar.a((MenuItem) this);
        }
        return this.A != null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.f903k == c2) {
            return this;
        }
        this.f903k = Character.toLowerCase(c2);
        this.f893a.b(false);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.f903k == c2 && this.f904l == i2) {
            return this;
        }
        this.f903k = Character.toLowerCase(c2);
        this.f904l = KeyEvent.normalizeMetaState(i2);
        this.f893a.b(false);
        return this;
    }

    public MenuItem setCheckable(boolean z2) {
        int i2 = this.f917y;
        boolean z3 = z2 | (i2 & true);
        this.f917y = z3 ? 1 : 0;
        if (i2 != z3) {
            this.f893a.b(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z2) {
        if ((this.f917y & 4) != 0) {
            this.f893a.a((MenuItem) this);
        } else {
            b(z2);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z2) {
        this.f917y = z2 ? this.f917y | 16 : this.f917y & -17;
        this.f893a.b(false);
        return this;
    }

    public MenuItem setIcon(int i2) {
        this.f905m = null;
        this.f906n = i2;
        this.f916x = true;
        this.f893a.b(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f906n = 0;
        this.f905m = drawable;
        this.f916x = true;
        this.f893a.b(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f912t = colorStateList;
        this.f914v = true;
        this.f916x = true;
        this.f893a.b(false);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f913u = mode;
        this.f915w = true;
        this.f916x = true;
        this.f893a.b(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f900h = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        if (this.f901i == c2) {
            return this;
        }
        this.f901i = c2;
        this.f893a.b(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        if (this.f901i == c2 && this.f902j == i2) {
            return this;
        }
        this.f901i = c2;
        this.f902j = KeyEvent.normalizeMetaState(i2);
        this.f893a.b(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f909q = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f901i = c2;
        this.f903k = Character.toLowerCase(c3);
        this.f893a.b(false);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f901i = c2;
        this.f902j = KeyEvent.normalizeMetaState(i2);
        this.f903k = Character.toLowerCase(c3);
        this.f904l = KeyEvent.normalizeMetaState(i3);
        this.f893a.b(false);
        return this;
    }

    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            this.f918z = i2;
            this.f893a.b(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public MenuItem setTitle(int i2) {
        return setTitle((CharSequence) this.f893a.f().getString(i2));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f898f = charSequence;
        this.f893a.b(false);
        r rVar = this.f907o;
        if (rVar != null) {
            rVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f899g = charSequence;
        this.f893a.b(false);
        return this;
    }

    public MenuItem setVisible(boolean z2) {
        if (c(z2)) {
            this.f893a.a(this);
        }
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f898f;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }
}
