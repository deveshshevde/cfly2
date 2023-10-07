package com.google.android.material.progressindicator;

import aj.b;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import com.google.android.material.progressindicator.b;
import gn.a;
import y.c;
import y.d;

public final class e<S extends b> extends f {

    /* renamed from: j  reason: collision with root package name */
    private static final c<e> f19469j = new c<e>("indicatorLevel") {
        public float a(e eVar) {
            return eVar.f() * 10000.0f;
        }

        public void a(e eVar, float f2) {
            eVar.c(f2 / 10000.0f);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private g<S> f19470e;

    /* renamed from: f  reason: collision with root package name */
    private final y.e f19471f;

    /* renamed from: g  reason: collision with root package name */
    private final d f19472g;

    /* renamed from: h  reason: collision with root package name */
    private float f19473h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f19474i = false;

    e(Context context, b bVar, g<S> gVar) {
        super(context, bVar);
        a(gVar);
        y.e eVar = new y.e();
        this.f19471f = eVar;
        eVar.b(1.0f);
        eVar.a(50.0f);
        d dVar = new d(this, f19469j);
        this.f19472g = dVar;
        dVar.a(eVar);
        b(1.0f);
    }

    public static e<CircularProgressIndicatorSpec> a(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new e<>(context, circularProgressIndicatorSpec, new c(circularProgressIndicatorSpec));
    }

    public static e<LinearProgressIndicatorSpec> a(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new e<>(context, linearProgressIndicatorSpec, new j(linearProgressIndicatorSpec));
    }

    /* access modifiers changed from: private */
    public void c(float f2) {
        this.f19473h = f2;
        invalidateSelf();
    }

    /* access modifiers changed from: private */
    public float f() {
        return this.f19473h;
    }

    /* access modifiers changed from: package-private */
    public g<S> a() {
        return this.f19470e;
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        setLevel((int) (f2 * 10000.0f));
    }

    /* access modifiers changed from: package-private */
    public void a(g<S> gVar) {
        this.f19470e = gVar;
        gVar.a(this);
    }

    public /* bridge */ /* synthetic */ boolean a(b.a aVar) {
        return super.a(aVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a(boolean z2, boolean z3, boolean z4) {
        boolean a2 = super.a(z2, z3, z4);
        float a3 = this.f19478c.a(this.f19476a.getContentResolver());
        if (a3 == 0.0f) {
            this.f19474i = true;
        } else {
            this.f19474i = false;
            this.f19471f.a(50.0f / a3);
        }
        return a2;
    }

    public /* bridge */ /* synthetic */ void b(b.a aVar) {
        super.b(aVar);
    }

    public /* bridge */ /* synthetic */ boolean b() {
        return super.b();
    }

    public /* bridge */ /* synthetic */ boolean b(boolean z2, boolean z3, boolean z4) {
        return super.b(z2, z3, z4);
    }

    public /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    public /* bridge */ /* synthetic */ boolean d() {
        return super.d();
    }

    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.f19470e.b(canvas, e());
            this.f19470e.a(canvas, this.f19479d);
            Canvas canvas2 = canvas;
            this.f19470e.a(canvas2, this.f19479d, 0.0f, f(), a.b(this.f19477b.f19446c[0], getAlpha()));
            canvas.restore();
        }
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public int getIntrinsicHeight() {
        return this.f19470e.b();
    }

    public int getIntrinsicWidth() {
        return this.f19470e.a();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    public void jumpToCurrentState() {
        this.f19472g.b();
        c(((float) getLevel()) / 10000.0f);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        if (this.f19474i) {
            this.f19472g.b();
            c(((float) i2) / 10000.0f);
            return true;
        }
        this.f19472g.a(f() * 10000.0f);
        this.f19472g.c((float) i2);
        return true;
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i2) {
        super.setAlpha(i2);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ boolean setVisible(boolean z2, boolean z3) {
        return super.setVisible(z2, z3);
    }

    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }
}
