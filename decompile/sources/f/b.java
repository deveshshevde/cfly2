package f;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private Object f27010a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f27011b;

    public interface a {
        void a(b bVar);

        boolean a(b bVar, Menu menu);

        boolean a(b bVar, MenuItem menuItem);

        boolean b(b bVar, Menu menu);
    }

    public abstract MenuInflater a();

    public abstract void a(int i2);

    public abstract void a(View view);

    public abstract void a(CharSequence charSequence);

    public void a(Object obj) {
        this.f27010a = obj;
    }

    public void a(boolean z2) {
        this.f27011b = z2;
    }

    public abstract Menu b();

    public abstract void b(int i2);

    public abstract void b(CharSequence charSequence);

    public abstract void c();

    public abstract void d();

    public abstract CharSequence f();

    public abstract CharSequence g();

    public boolean h() {
        return false;
    }

    public abstract View i();

    public Object j() {
        return this.f27010a;
    }

    public boolean k() {
        return this.f27011b;
    }
}
