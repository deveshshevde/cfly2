package com.facebook.drawee.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.drawable.q;
import com.facebook.drawee.drawable.r;
import df.c;
import dm.a;
import dm.b;

public class b<DH extends dm.b> implements r {

    /* renamed from: a  reason: collision with root package name */
    private boolean f11309a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11310b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11311c = true;

    /* renamed from: d  reason: collision with root package name */
    private DH f11312d;

    /* renamed from: e  reason: collision with root package name */
    private a f11313e = null;

    /* renamed from: f  reason: collision with root package name */
    private final DraweeEventTracker f11314f = DraweeEventTracker.a();

    public b(DH dh2) {
        if (dh2 != null) {
            a(dh2);
        }
    }

    public static <DH extends dm.b> b<DH> a(DH dh2, Context context) {
        b<DH> bVar = new b<>(dh2);
        bVar.a(context);
        return bVar;
    }

    private void a(r rVar) {
        Drawable f2 = f();
        if (f2 instanceof q) {
            ((q) f2).a(rVar);
        }
    }

    private void h() {
        if (!this.f11309a) {
            this.f11314f.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.f11309a = true;
            a aVar = this.f11313e;
            if (aVar != null && aVar.e() != null) {
                this.f11313e.f();
            }
        }
    }

    private void i() {
        if (this.f11309a) {
            this.f11314f.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.f11309a = false;
            if (g()) {
                this.f11313e.g();
            }
        }
    }

    private void j() {
        if (!this.f11310b || !this.f11311c) {
            i();
        } else {
            h();
        }
    }

    public void a() {
        if (!this.f11309a) {
            dg.a.b(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f11313e)), toString());
            this.f11310b = true;
            this.f11311c = true;
            j();
        }
    }

    public void a(Context context) {
    }

    public void a(a aVar) {
        boolean z2 = this.f11309a;
        if (z2) {
            i();
        }
        if (g()) {
            this.f11314f.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.f11313e.a((dm.b) null);
        }
        this.f11313e = aVar;
        if (aVar != null) {
            this.f11314f.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.f11313e.a((dm.b) this.f11312d);
        } else {
            this.f11314f.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z2) {
            h();
        }
    }

    public void a(DH dh2) {
        this.f11314f.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean g2 = g();
        a((r) null);
        DH dh3 = (dm.b) c.a(dh2);
        this.f11312d = dh3;
        Drawable a2 = dh3.a();
        a(a2 == null || a2.isVisible());
        a((r) this);
        if (g2) {
            this.f11313e.a((dm.b) dh2);
        }
    }

    public void a(boolean z2) {
        if (this.f11311c != z2) {
            this.f11314f.a(z2 ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.f11311c = z2;
            j();
        }
    }

    public boolean a(MotionEvent motionEvent) {
        if (!g()) {
            return false;
        }
        return this.f11313e.a(motionEvent);
    }

    public void b() {
        this.f11314f.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.f11310b = true;
        j();
    }

    public void c() {
        this.f11314f.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.f11310b = false;
        j();
    }

    public a d() {
        return this.f11313e;
    }

    public DH e() {
        return (dm.b) c.a(this.f11312d);
    }

    public Drawable f() {
        DH dh2 = this.f11312d;
        if (dh2 == null) {
            return null;
        }
        return dh2.a();
    }

    public boolean g() {
        a aVar = this.f11313e;
        return aVar != null && aVar.e() == this.f11312d;
    }

    public String toString() {
        return df.b.a((Object) this).a("controllerAttached", this.f11309a).a("holderAttached", this.f11310b).a("drawableVisible", this.f11311c).a("events", (Object) this.f11314f.toString()).toString();
    }
}
