package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ag;
import androidx.appcompat.widget.p;
import f.i;
import java.util.ArrayList;
import t.ac;

class j extends ActionBar {

    /* renamed from: a  reason: collision with root package name */
    p f681a;

    /* renamed from: b  reason: collision with root package name */
    boolean f682b;

    /* renamed from: c  reason: collision with root package name */
    Window.Callback f683c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f684d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f685e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<ActionBar.a> f686f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f687g = new Runnable() {
        public void run() {
            j.this.k();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private final Toolbar.b f688h;

    private final class a implements m.a {

        /* renamed from: b  reason: collision with root package name */
        private boolean f692b;

        a() {
        }

        public void a(g gVar, boolean z2) {
            if (!this.f692b) {
                this.f692b = true;
                j.this.f681a.n();
                if (j.this.f683c != null) {
                    j.this.f683c.onPanelClosed(108, gVar);
                }
                this.f692b = false;
            }
        }

        public boolean a(g gVar) {
            if (j.this.f683c == null) {
                return false;
            }
            j.this.f683c.onMenuOpened(108, gVar);
            return true;
        }
    }

    private final class b implements g.a {
        b() {
        }

        public void a(g gVar) {
            if (j.this.f683c == null) {
                return;
            }
            if (j.this.f681a.i()) {
                j.this.f683c.onPanelClosed(108, gVar);
            } else if (j.this.f683c.onPreparePanel(0, (View) null, gVar)) {
                j.this.f683c.onMenuOpened(108, gVar);
            }
        }

        public boolean a(g gVar, MenuItem menuItem) {
            return false;
        }
    }

    private class c extends i {
        public c(Window.Callback callback) {
            super(callback);
        }

        public View onCreatePanelView(int i2) {
            return i2 == 0 ? new View(j.this.f681a.b()) : super.onCreatePanelView(i2);
        }

        public boolean onPreparePanel(int i2, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (onPreparePanel && !j.this.f682b) {
                j.this.f681a.m();
                j.this.f682b = true;
            }
            return onPreparePanel;
        }
    }

    j(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        AnonymousClass2 r0 = new Toolbar.b() {
            public boolean a(MenuItem menuItem) {
                return j.this.f683c.onMenuItemSelected(0, menuItem);
            }
        };
        this.f688h = r0;
        this.f681a = new ag(toolbar, false);
        c cVar = new c(callback);
        this.f683c = cVar;
        this.f681a.a((Window.Callback) cVar);
        toolbar.setOnMenuItemClickListener(r0);
        this.f681a.a(charSequence);
    }

    private Menu l() {
        if (!this.f684d) {
            this.f681a.a((m.a) new a(), (g.a) new b());
            this.f684d = true;
        }
        return this.f681a.q();
    }

    public int a() {
        return this.f681a.o();
    }

    public void a(float f2) {
        ac.d((View) this.f681a.a(), f2);
    }

    public void a(int i2) {
        this.f681a.d(i2);
    }

    public void a(Configuration configuration) {
        super.a(configuration);
    }

    public void a(CharSequence charSequence) {
        this.f681a.a(charSequence);
    }

    public void a(boolean z2) {
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        Menu l2 = l();
        if (l2 == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        l2.setQwertyMode(z2);
        return l2.performShortcut(i2, keyEvent, 0);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            e();
        }
        return true;
    }

    public void b() {
        this.f681a.e(0);
    }

    public void c() {
        this.f681a.e(8);
    }

    public void c(boolean z2) {
    }

    public Context d() {
        return this.f681a.b();
    }

    public void d(boolean z2) {
    }

    public void e(boolean z2) {
        if (z2 != this.f685e) {
            this.f685e = z2;
            int size = this.f686f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f686f.get(i2).a(z2);
            }
        }
    }

    public boolean e() {
        return this.f681a.k();
    }

    public boolean f() {
        return this.f681a.l();
    }

    public boolean g() {
        this.f681a.a().removeCallbacks(this.f687g);
        ac.a((View) this.f681a.a(), this.f687g);
        return true;
    }

    public boolean h() {
        if (!this.f681a.c()) {
            return false;
        }
        this.f681a.d();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        this.f681a.a().removeCallbacks(this.f687g);
    }

    public Window.Callback j() {
        return this.f683c;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        Menu l2 = l();
        g gVar = l2 instanceof g ? (g) l2 : null;
        if (gVar != null) {
            gVar.h();
        }
        try {
            l2.clear();
            if (!this.f683c.onCreatePanelMenu(0, l2) || !this.f683c.onPreparePanel(0, (View) null, l2)) {
                l2.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.i();
            }
        }
    }
}
