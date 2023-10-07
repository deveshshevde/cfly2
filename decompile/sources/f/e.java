package f;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContextView;
import f.b;
import java.lang.ref.WeakReference;

public class e extends b implements g.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f27017a;

    /* renamed from: b  reason: collision with root package name */
    private ActionBarContextView f27018b;

    /* renamed from: c  reason: collision with root package name */
    private b.a f27019c;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<View> f27020d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27021e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f27022f;

    /* renamed from: g  reason: collision with root package name */
    private g f27023g;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z2) {
        this.f27017a = context;
        this.f27018b = actionBarContextView;
        this.f27019c = aVar;
        g a2 = new g(actionBarContextView.getContext()).a(1);
        this.f27023g = a2;
        a2.a((g.a) this);
        this.f27022f = z2;
    }

    public MenuInflater a() {
        return new g(this.f27018b.getContext());
    }

    public void a(int i2) {
        b((CharSequence) this.f27017a.getString(i2));
    }

    public void a(View view) {
        this.f27018b.setCustomView(view);
        this.f27020d = view != null ? new WeakReference<>(view) : null;
    }

    public void a(g gVar) {
        d();
        this.f27018b.a();
    }

    public void a(CharSequence charSequence) {
        this.f27018b.setSubtitle(charSequence);
    }

    public void a(boolean z2) {
        super.a(z2);
        this.f27018b.setTitleOptional(z2);
    }

    public boolean a(g gVar, MenuItem menuItem) {
        return this.f27019c.a((b) this, menuItem);
    }

    public Menu b() {
        return this.f27023g;
    }

    public void b(int i2) {
        a((CharSequence) this.f27017a.getString(i2));
    }

    public void b(CharSequence charSequence) {
        this.f27018b.setTitle(charSequence);
    }

    public void c() {
        if (!this.f27021e) {
            this.f27021e = true;
            this.f27018b.sendAccessibilityEvent(32);
            this.f27019c.a(this);
        }
    }

    public void d() {
        this.f27019c.b(this, this.f27023g);
    }

    public CharSequence f() {
        return this.f27018b.getTitle();
    }

    public CharSequence g() {
        return this.f27018b.getSubtitle();
    }

    public boolean h() {
        return this.f27018b.d();
    }

    public View i() {
        WeakReference<View> weakReference = this.f27020d;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }
}
