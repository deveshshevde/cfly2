package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.ad;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final h<?> f3385a;

    private f(h<?> hVar) {
        this.f3385a = hVar;
    }

    public static f a(h<?> hVar) {
        return new f((h) s.f.a(hVar, (Object) "callbacks == null"));
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f3385a.f3388b.I().onCreateView(view, str, context, attributeSet);
    }

    public FragmentManager a() {
        return this.f3385a.f3388b;
    }

    public void a(Configuration configuration) {
        this.f3385a.f3388b.a(configuration);
    }

    public void a(Parcelable parcelable) {
        h<?> hVar = this.f3385a;
        if (hVar instanceof ad) {
            hVar.f3388b.a(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    public void a(Fragment fragment) {
        FragmentManager fragmentManager = this.f3385a.f3388b;
        h<?> hVar = this.f3385a;
        fragmentManager.a(hVar, (e) hVar, fragment);
    }

    public void a(boolean z2) {
        this.f3385a.f3388b.b(z2);
    }

    public boolean a(Menu menu) {
        return this.f3385a.f3388b.a(menu);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.f3385a.f3388b.a(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.f3385a.f3388b.a(menuItem);
    }

    public void b() {
        this.f3385a.f3388b.q();
    }

    public void b(Menu menu) {
        this.f3385a.f3388b.b(menu);
    }

    public void b(boolean z2) {
        this.f3385a.f3388b.c(z2);
    }

    public boolean b(MenuItem menuItem) {
        return this.f3385a.f3388b.b(menuItem);
    }

    public Parcelable c() {
        return this.f3385a.f3388b.l();
    }

    public void d() {
        this.f3385a.f3388b.s();
    }

    public void e() {
        this.f3385a.f3388b.u();
    }

    public void f() {
        this.f3385a.f3388b.v();
    }

    public void g() {
        this.f3385a.f3388b.w();
    }

    public void h() {
        this.f3385a.f3388b.x();
    }

    public void i() {
        this.f3385a.f3388b.y();
    }

    public void j() {
        this.f3385a.f3388b.A();
    }

    public void k() {
        this.f3385a.f3388b.B();
    }

    public boolean l() {
        return this.f3385a.f3388b.a(true);
    }
}
