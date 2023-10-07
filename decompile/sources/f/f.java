package f;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import f.b;
import j.g;
import java.util.ArrayList;

public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f27024a;

    /* renamed from: b  reason: collision with root package name */
    final b f27025b;

    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f27026a;

        /* renamed from: b  reason: collision with root package name */
        final Context f27027b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<f> f27028c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        final g<Menu, Menu> f27029d = new g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f27027b = context;
            this.f27026a = callback;
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.f27029d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            o oVar = new o(this.f27027b, (n.a) menu);
            this.f27029d.put(menu, oVar);
            return oVar;
        }

        public void a(b bVar) {
            this.f27026a.onDestroyActionMode(b(bVar));
        }

        public boolean a(b bVar, Menu menu) {
            return this.f27026a.onCreateActionMode(b(bVar), a(menu));
        }

        public boolean a(b bVar, MenuItem menuItem) {
            return this.f27026a.onActionItemClicked(b(bVar), new j(this.f27027b, (n.b) menuItem));
        }

        public ActionMode b(b bVar) {
            int size = this.f27028c.size();
            for (int i2 = 0; i2 < size; i2++) {
                f fVar = this.f27028c.get(i2);
                if (fVar != null && fVar.f27025b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f27027b, bVar);
            this.f27028c.add(fVar2);
            return fVar2;
        }

        public boolean b(b bVar, Menu menu) {
            return this.f27026a.onPrepareActionMode(b(bVar), a(menu));
        }
    }

    public f(Context context, b bVar) {
        this.f27024a = context;
        this.f27025b = bVar;
    }

    public void finish() {
        this.f27025b.c();
    }

    public View getCustomView() {
        return this.f27025b.i();
    }

    public Menu getMenu() {
        return new o(this.f27024a, (n.a) this.f27025b.b());
    }

    public MenuInflater getMenuInflater() {
        return this.f27025b.a();
    }

    public CharSequence getSubtitle() {
        return this.f27025b.g();
    }

    public Object getTag() {
        return this.f27025b.j();
    }

    public CharSequence getTitle() {
        return this.f27025b.f();
    }

    public boolean getTitleOptionalHint() {
        return this.f27025b.k();
    }

    public void invalidate() {
        this.f27025b.d();
    }

    public boolean isTitleOptional() {
        return this.f27025b.h();
    }

    public void setCustomView(View view) {
        this.f27025b.a(view);
    }

    public void setSubtitle(int i2) {
        this.f27025b.b(i2);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f27025b.a(charSequence);
    }

    public void setTag(Object obj) {
        this.f27025b.a(obj);
    }

    public void setTitle(int i2) {
        this.f27025b.a(i2);
    }

    public void setTitle(CharSequence charSequence) {
        this.f27025b.b(charSequence);
    }

    public void setTitleOptionalHint(boolean z2) {
        this.f27025b.a(z2);
    }
}
