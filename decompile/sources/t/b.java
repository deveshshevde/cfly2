package t;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f34477a;

    /* renamed from: b  reason: collision with root package name */
    private a f34478b;

    /* renamed from: c  reason: collision with root package name */
    private C0257b f34479c;

    public interface a {
        void d(boolean z2);
    }

    /* renamed from: t.b$b  reason: collision with other inner class name */
    public interface C0257b {
        void a(boolean z2);
    }

    public b(Context context) {
        this.f34477a = context;
    }

    public abstract View a();

    public View a(MenuItem menuItem) {
        return a();
    }

    public void a(SubMenu subMenu) {
    }

    public void a(a aVar) {
        this.f34478b = aVar;
    }

    public void a(C0257b bVar) {
        if (!(this.f34479c == null || bVar == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f34479c = bVar;
    }

    public void a(boolean z2) {
        a aVar = this.f34478b;
        if (aVar != null) {
            aVar.d(z2);
        }
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return true;
    }

    public void f() {
        this.f34479c = null;
        this.f34478b = null;
    }
}
