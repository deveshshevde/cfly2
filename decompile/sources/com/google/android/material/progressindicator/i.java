package com.google.android.material.progressindicator;

import aj.b;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.os.Build;
import com.google.android.material.progressindicator.b;

public final class i<S extends b> extends f {

    /* renamed from: e  reason: collision with root package name */
    private g<S> f19497e;

    /* renamed from: f  reason: collision with root package name */
    private h<ObjectAnimator> f19498f;

    i(Context context, b bVar, g<S> gVar, h<ObjectAnimator> hVar) {
        super(context, bVar);
        a(gVar);
        a(hVar);
    }

    public static i<CircularProgressIndicatorSpec> a(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new i<>(context, circularProgressIndicatorSpec, new c(circularProgressIndicatorSpec), new d(circularProgressIndicatorSpec));
    }

    public static i<LinearProgressIndicatorSpec> a(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new i<>(context, linearProgressIndicatorSpec, new j(linearProgressIndicatorSpec), linearProgressIndicatorSpec.f19440g == 0 ? new k(linearProgressIndicatorSpec) : new l(context, linearProgressIndicatorSpec));
    }

    /* access modifiers changed from: package-private */
    public h<ObjectAnimator> a() {
        return this.f19498f;
    }

    /* access modifiers changed from: package-private */
    public void a(g<S> gVar) {
        this.f19497e = gVar;
        gVar.a(this);
    }

    /* access modifiers changed from: package-private */
    public void a(h<ObjectAnimator> hVar) {
        this.f19498f = hVar;
        hVar.a(this);
    }

    public /* bridge */ /* synthetic */ boolean a(b.a aVar) {
        return super.a(aVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a(boolean z2, boolean z3, boolean z4) {
        boolean a2 = super.a(z2, z3, z4);
        if (!isRunning()) {
            this.f19498f.b();
        }
        float a3 = this.f19478c.a(this.f19476a.getContentResolver());
        if (z2 && (z4 || (Build.VERSION.SDK_INT <= 21 && a3 > 0.0f))) {
            this.f19498f.a();
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
            this.f19497e.b(canvas, e());
            this.f19497e.a(canvas, this.f19479d);
            for (int i2 = 0; i2 < this.f19498f.f19496d.length; i2++) {
                int i3 = i2 * 2;
                this.f19497e.a(canvas, this.f19479d, this.f19498f.f19495c[i3], this.f19498f.f19495c[i3 + 1], this.f19498f.f19496d[i2]);
            }
            canvas.restore();
        }
    }

    /* access modifiers changed from: package-private */
    public g<S> f() {
        return this.f19497e;
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public int getIntrinsicHeight() {
        return this.f19497e.b();
    }

    public int getIntrinsicWidth() {
        return this.f19497e.a();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
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
