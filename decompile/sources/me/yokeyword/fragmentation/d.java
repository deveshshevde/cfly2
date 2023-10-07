package me.yokeyword.fragmentation;

import android.os.Bundle;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import me.yokeyword.fragmentation.anim.DefaultVerticalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.fragmentation.debug.b;
import mw.a;

public class d {

    /* renamed from: a  reason: collision with root package name */
    boolean f31105a = false;

    /* renamed from: b  reason: collision with root package name */
    boolean f31106b = true;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public b f31107c;

    /* renamed from: d  reason: collision with root package name */
    private FragmentActivity f31108d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public h f31109e;

    /* renamed from: f  reason: collision with root package name */
    private FragmentAnimator f31110f;

    /* renamed from: g  reason: collision with root package name */
    private int f31111g = 0;

    /* renamed from: h  reason: collision with root package name */
    private b f31112h;

    public d(b bVar) {
        if (bVar instanceof FragmentActivity) {
            this.f31107c = bVar;
            FragmentActivity fragmentActivity = (FragmentActivity) bVar;
            this.f31108d = fragmentActivity;
            this.f31112h = new b(fragmentActivity);
            return;
        }
        throw new RuntimeException("Must extends FragmentActivity/AppCompatActivity");
    }

    /* access modifiers changed from: private */
    public FragmentManager i() {
        return this.f31108d.getSupportFragmentManager();
    }

    public h a() {
        if (this.f31109e == null) {
            this.f31109e = new h(this.f31107c);
        }
        return this.f31109e;
    }

    public void a(Bundle bundle) {
        this.f31109e = a();
        this.f31110f = this.f31107c.i();
        this.f31112h.a(a.a().c());
    }

    public boolean a(MotionEvent motionEvent) {
        return !this.f31106b;
    }

    public FragmentAnimator b() {
        return this.f31110f.a();
    }

    public void b(Bundle bundle) {
        this.f31112h.b(a.a().c());
    }

    public FragmentAnimator c() {
        return new DefaultVerticalAnimator();
    }

    public int d() {
        return this.f31111g;
    }

    public void e() {
        this.f31109e.f31171a.a((a) new a(3) {
            public void a() {
                if (!d.this.f31106b) {
                    d.this.f31106b = true;
                }
                if (!d.this.f31109e.a(g.a(d.this.i()))) {
                    d.this.f31107c.j();
                }
            }
        });
    }

    public void f() {
        if (i().f() > 1) {
            h();
        } else {
            androidx.core.app.a.b(this.f31108d);
        }
    }

    public void g() {
        this.f31112h.a();
    }

    public void h() {
        this.f31109e.a(i());
    }
}
