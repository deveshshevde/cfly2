package androidx.appcompat.widget;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.l;

public class v {

    /* renamed from: a  reason: collision with root package name */
    final l f1579a;

    /* renamed from: b  reason: collision with root package name */
    b f1580b;

    /* renamed from: c  reason: collision with root package name */
    a f1581c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f1582d;

    /* renamed from: e  reason: collision with root package name */
    private final g f1583e;

    /* renamed from: f  reason: collision with root package name */
    private final View f1584f;

    public interface a {
        void a(v vVar);
    }

    public interface b {
        boolean a(MenuItem menuItem);
    }

    public v(Context context, View view) {
        this(context, view, 0);
    }

    public v(Context context, View view, int i2) {
        this(context, view, i2, R.attr.popupMenuStyle, 0);
    }

    public v(Context context, View view, int i2, int i3, int i4) {
        this.f1582d = context;
        this.f1584f = view;
        g gVar = new g(context);
        this.f1583e = gVar;
        gVar.a((g.a) new g.a() {
            public void a(g gVar) {
            }

            public boolean a(g gVar, MenuItem menuItem) {
                if (v.this.f1580b != null) {
                    return v.this.f1580b.a(menuItem);
                }
                return false;
            }
        });
        l lVar = new l(context, gVar, view, false, i3, i4);
        this.f1579a = lVar;
        lVar.a(i2);
        lVar.a((PopupWindow.OnDismissListener) new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                if (v.this.f1581c != null) {
                    v.this.f1581c.a(v.this);
                }
            }
        });
    }

    public MenuInflater a() {
        return new f.g(this.f1582d);
    }

    public void a(int i2) {
        a().inflate(i2, this.f1583e);
    }

    public void a(b bVar) {
        this.f1580b = bVar;
    }

    public void b() {
        this.f1579a.a();
    }
}
