package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.f;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.n;
import dm.c;
import ds.b;

public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f11269a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f11270b;

    /* renamed from: c  reason: collision with root package name */
    private RoundingParams f11271c;

    /* renamed from: d  reason: collision with root package name */
    private final d f11272d;

    /* renamed from: e  reason: collision with root package name */
    private final f f11273e;

    /* renamed from: f  reason: collision with root package name */
    private final g f11274f;

    a(b bVar) {
        int i2 = 0;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        this.f11269a = colorDrawable;
        if (b.b()) {
            b.a("GenericDraweeHierarchy()");
        }
        this.f11270b = bVar.a();
        this.f11271c = bVar.r();
        g gVar = new g(colorDrawable);
        this.f11274f = gVar;
        int i3 = 1;
        int size = (bVar.p() != null ? bVar.p().size() : 1) + (bVar.q() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[(size + 6)];
        drawableArr[0] = a(bVar.o(), (n.b) null);
        drawableArr[1] = a(bVar.d(), bVar.e());
        drawableArr[2] = a(gVar, bVar.l(), bVar.m(), bVar.n());
        drawableArr[3] = a(bVar.j(), bVar.k());
        drawableArr[4] = a(bVar.f(), bVar.g());
        drawableArr[5] = a(bVar.h(), bVar.i());
        if (size > 0) {
            if (bVar.p() != null) {
                for (Drawable a2 : bVar.p()) {
                    drawableArr[i2 + 6] = a(a2, (n.b) null);
                    i2++;
                }
                i3 = i2;
            }
            if (bVar.q() != null) {
                drawableArr[i3 + 6] = a(bVar.q(), (n.b) null);
            }
        }
        f fVar = new f(drawableArr);
        this.f11273e = fVar;
        fVar.b(bVar.b());
        d dVar = new d(e.a((Drawable) fVar, this.f11271c));
        this.f11272d = dVar;
        dVar.mutate();
        d();
        if (b.b()) {
            b.a();
        }
    }

    private Drawable a(Drawable drawable, n.b bVar) {
        return e.a(e.a(drawable, this.f11271c, this.f11270b), bVar);
    }

    private Drawable a(Drawable drawable, n.b bVar, PointF pointF, ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    private void a(float f2) {
        Drawable a2 = this.f11273e.a(3);
        if (a2 != null) {
            if (f2 >= 0.999f) {
                if (a2 instanceof Animatable) {
                    ((Animatable) a2).stop();
                }
                b(3);
            } else {
                if (a2 instanceof Animatable) {
                    ((Animatable) a2).start();
                }
                a(3);
            }
            a2.setLevel(Math.round(f2 * 10000.0f));
        }
    }

    private void a(int i2) {
        if (i2 >= 0) {
            this.f11273e.c(i2);
        }
    }

    private void b(int i2) {
        if (i2 >= 0) {
            this.f11273e.d(i2);
        }
    }

    private void c() {
        this.f11274f.a(this.f11269a);
    }

    private void d() {
        f fVar = this.f11273e;
        if (fVar != null) {
            fVar.a();
            this.f11273e.c();
            e();
            a(1);
            this.f11273e.d();
            this.f11273e.b();
        }
    }

    private void e() {
        b(1);
        b(2);
        b(3);
        b(4);
        b(5);
    }

    public Drawable a() {
        return this.f11272d;
    }

    public void a(float f2, boolean z2) {
        if (this.f11273e.a(3) != null) {
            this.f11273e.a();
            a(f2);
            if (z2) {
                this.f11273e.d();
            }
            this.f11273e.b();
        }
    }

    public void a(Drawable drawable) {
        this.f11272d.d(drawable);
    }

    public void a(Drawable drawable, float f2, boolean z2) {
        Drawable a2 = e.a(drawable, this.f11271c, this.f11270b);
        a2.mutate();
        this.f11274f.a(a2);
        this.f11273e.a();
        e();
        a(2);
        a(f2);
        if (z2) {
            this.f11273e.d();
        }
        this.f11273e.b();
    }

    public void a(Throwable th) {
        this.f11273e.a();
        e();
        if (this.f11273e.a(5) != null) {
            a(5);
        } else {
            a(1);
        }
        this.f11273e.b();
    }

    public void b() {
        c();
        d();
    }

    public void b(Throwable th) {
        this.f11273e.a();
        e();
        if (this.f11273e.a(4) != null) {
            a(4);
        } else {
            a(1);
        }
        this.f11273e.b();
    }
}
