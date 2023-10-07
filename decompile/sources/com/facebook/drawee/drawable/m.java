package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.n;
import df.b;
import df.c;

public class m extends g {

    /* renamed from: a  reason: collision with root package name */
    n.b f11232a;

    /* renamed from: c  reason: collision with root package name */
    Object f11233c;

    /* renamed from: d  reason: collision with root package name */
    PointF f11234d = null;

    /* renamed from: e  reason: collision with root package name */
    int f11235e = 0;

    /* renamed from: f  reason: collision with root package name */
    int f11236f = 0;

    /* renamed from: g  reason: collision with root package name */
    Matrix f11237g;

    /* renamed from: h  reason: collision with root package name */
    private Matrix f11238h = new Matrix();

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) c.a(drawable));
        this.f11232a = bVar;
    }

    private void c() {
        boolean z2;
        n.b bVar = this.f11232a;
        boolean z3 = true;
        if (bVar instanceof n.l) {
            Object a2 = ((n.l) bVar).a();
            z2 = a2 == null || !a2.equals(this.f11233c);
            this.f11233c = a2;
        } else {
            z2 = false;
        }
        if (this.f11235e == getCurrent().getIntrinsicWidth() && this.f11236f == getCurrent().getIntrinsicHeight()) {
            z3 = false;
        }
        if (z3 || z2) {
            b();
        }
    }

    public void a(Matrix matrix) {
        b(matrix);
        c();
        Matrix matrix2 = this.f11237g;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }

    public void a(PointF pointF) {
        if (!b.a(this.f11234d, pointF)) {
            if (this.f11234d == null) {
                this.f11234d = new PointF();
            }
            this.f11234d.set(pointF);
            b();
            invalidateSelf();
        }
    }

    public Drawable b(Drawable drawable) {
        Drawable b2 = super.b(drawable);
        b();
        return b2;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.f11235e = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.f11236f = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.f11237g = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.f11237g = null;
        } else if (this.f11232a == n.b.f11239a) {
            current.setBounds(bounds);
            this.f11237g = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            n.b bVar = this.f11232a;
            Matrix matrix = this.f11238h;
            PointF pointF = this.f11234d;
            float f2 = pointF != null ? pointF.x : 0.5f;
            PointF pointF2 = this.f11234d;
            bVar.a(matrix, bounds, intrinsicWidth, intrinsicHeight, f2, pointF2 != null ? pointF2.y : 0.5f);
            this.f11237g = this.f11238h;
        }
    }

    public void draw(Canvas canvas) {
        c();
        if (this.f11237g != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.f11237g);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        b();
    }
}
