package com.github.barteksc.pdfviewer;

import android.graphics.RectF;
import com.github.barteksc.pdfviewer.util.a;
import com.github.barteksc.pdfviewer.util.d;
import com.shockwave.pdfium.util.SizeF;

class e {

    /* renamed from: a  reason: collision with root package name */
    private PDFView f14605a;

    /* renamed from: b  reason: collision with root package name */
    private int f14606b;

    /* renamed from: c  reason: collision with root package name */
    private float f14607c;

    /* renamed from: d  reason: collision with root package name */
    private float f14608d;

    /* renamed from: e  reason: collision with root package name */
    private float f14609e;

    /* renamed from: f  reason: collision with root package name */
    private float f14610f;

    /* renamed from: g  reason: collision with root package name */
    private float f14611g;

    /* renamed from: h  reason: collision with root package name */
    private float f14612h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f14613i = new RectF(0.0f, 0.0f, 1.0f, 1.0f);

    /* renamed from: j  reason: collision with root package name */
    private final int f14614j;

    /* renamed from: k  reason: collision with root package name */
    private final b f14615k = new b();

    /* renamed from: l  reason: collision with root package name */
    private final b f14616l = new b();

    /* renamed from: m  reason: collision with root package name */
    private final a f14617m = new a();

    /* renamed from: n  reason: collision with root package name */
    private final a f14618n = new a();

    /* renamed from: o  reason: collision with root package name */
    private final a f14619o = new a();

    private class a {

        /* renamed from: a  reason: collision with root package name */
        int f14620a;

        /* renamed from: b  reason: collision with root package name */
        int f14621b;

        private a() {
        }
    }

    private class b {

        /* renamed from: a  reason: collision with root package name */
        int f14623a;

        /* renamed from: b  reason: collision with root package name */
        int f14624b;

        /* renamed from: c  reason: collision with root package name */
        int f14625c;

        private b() {
        }
    }

    e(PDFView pDFView) {
        this.f14605a = pDFView;
        this.f14614j = d.a(pDFView.getContext(), com.github.barteksc.pdfviewer.util.a.f14687d);
    }

    private int a(int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = 0;
        while (i3 <= i4) {
            for (int i9 = i5; i9 <= i6; i9++) {
                if (a(i2, i3, i9, this.f14609e, this.f14610f)) {
                    i8++;
                }
                if (i8 >= i7) {
                    return i8;
                }
            }
            i3++;
        }
        return i8;
    }

    private int a(int i2, a aVar, int i3) {
        a(aVar);
        return a(i2, 0, aVar.f14620a - 1, 0, aVar.f14621b - 1, i3);
    }

    private int a(b bVar, a aVar, int i2) {
        a(aVar);
        if (this.f14605a.m()) {
            return a(bVar.f14623a, bVar.f14624b, aVar.f14620a - 1, 0, aVar.f14621b - 1, i2);
        }
        return a(bVar.f14623a, 0, aVar.f14620a - 1, bVar.f14625c, aVar.f14621b - 1, i2);
    }

    private int a(b bVar, b bVar2, a aVar, int i2) {
        a(aVar);
        return a(bVar.f14623a, bVar.f14624b, bVar2.f14624b, bVar.f14625c, bVar2.f14625c, i2);
    }

    private b a(b bVar, a aVar, float f2, float f3, boolean z2) {
        float f4;
        float f5;
        int i2;
        float f6 = -com.github.barteksc.pdfviewer.util.b.a(f2, 0.0f);
        float f7 = -com.github.barteksc.pdfviewer.util.b.a(f3, 0.0f);
        bVar.f14623a = this.f14605a.f14515b.a(this.f14605a.m() ? f7 : f6, this.f14605a.getZoom());
        a(aVar, bVar.f14623a);
        SizeF a2 = this.f14605a.f14515b.a(bVar.f14623a, this.f14605a.getZoom());
        float b2 = a2.b() / ((float) aVar.f14620a);
        float a3 = a2.a() / ((float) aVar.f14621b);
        float e2 = this.f14605a.f14515b.e(bVar.f14623a, this.f14605a.getZoom());
        if (this.f14605a.m()) {
            f4 = Math.abs(f7 - this.f14605a.f14515b.d(bVar.f14623a, this.f14605a.getZoom())) / b2;
            f5 = com.github.barteksc.pdfviewer.util.b.b(f6 - e2, 0.0f) / a3;
        } else {
            f4 = com.github.barteksc.pdfviewer.util.b.b(f7 - e2, 0.0f) / b2;
            f5 = Math.abs(f6 - this.f14605a.f14515b.d(bVar.f14623a, this.f14605a.getZoom())) / a3;
        }
        if (z2) {
            bVar.f14624b = com.github.barteksc.pdfviewer.util.b.b(f4);
            i2 = com.github.barteksc.pdfviewer.util.b.b(f5);
        } else {
            bVar.f14624b = com.github.barteksc.pdfviewer.util.b.a(f4);
            i2 = com.github.barteksc.pdfviewer.util.b.a(f5);
        }
        bVar.f14625c = i2;
        return bVar;
    }

    private void a(int i2) {
        SizeF a2 = this.f14605a.f14515b.a(i2);
        float a3 = a2.a() * com.github.barteksc.pdfviewer.util.a.f14685b;
        float b2 = a2.b() * com.github.barteksc.pdfviewer.util.a.f14685b;
        if (!this.f14605a.f14514a.a(i2, this.f14613i)) {
            this.f14605a.f14516c.a(i2, a3, b2, this.f14613i, true, 0, this.f14605a.l(), this.f14605a.o());
        }
    }

    private void a(a aVar) {
        this.f14609e = 1.0f / ((float) aVar.f14621b);
        this.f14610f = 1.0f / ((float) aVar.f14620a);
        this.f14611g = com.github.barteksc.pdfviewer.util.a.f14686c / this.f14609e;
        this.f14612h = com.github.barteksc.pdfviewer.util.a.f14686c / this.f14610f;
    }

    private void a(a aVar, int i2) {
        SizeF a2 = this.f14605a.f14515b.a(i2);
        float b2 = (com.github.barteksc.pdfviewer.util.a.f14686c * (1.0f / a2.b())) / this.f14605a.getZoom();
        float a3 = (com.github.barteksc.pdfviewer.util.a.f14686c * (1.0f / a2.a())) / this.f14605a.getZoom();
        aVar.f14620a = com.github.barteksc.pdfviewer.util.b.b(1.0f / b2);
        aVar.f14621b = com.github.barteksc.pdfviewer.util.b.b(1.0f / a3);
    }

    private boolean a(int i2, int i3, int i4, float f2, float f3) {
        float f4 = ((float) i4) * f2;
        float f5 = ((float) i3) * f3;
        float f6 = this.f14611g;
        float f7 = this.f14612h;
        float f8 = f4 + f2 > 1.0f ? 1.0f - f4 : f2;
        float f9 = f5 + f3 > 1.0f ? 1.0f - f5 : f3;
        float f10 = f6 * f8;
        float f11 = f7 * f9;
        RectF rectF = new RectF(f4, f5, f8 + f4, f9 + f5);
        if (f10 <= 0.0f || f11 <= 0.0f) {
            return false;
        }
        if (!this.f14605a.f14514a.a(i2, rectF, this.f14606b)) {
            this.f14605a.f14516c.a(i2, f10, f11, rectF, false, this.f14606b, this.f14605a.l(), this.f14605a.o());
        }
        this.f14606b++;
        return true;
    }

    private int b(b bVar, a aVar, int i2) {
        a(aVar);
        if (this.f14605a.m()) {
            return a(bVar.f14623a, 0, bVar.f14624b, 0, aVar.f14621b - 1, i2);
        }
        return a(bVar.f14623a, 0, aVar.f14620a - 1, 0, bVar.f14625c, i2);
    }

    private void b() {
        int a2;
        float zoom = ((float) this.f14614j) * this.f14605a.getZoom();
        float f2 = this.f14607c;
        float f3 = (-f2) + zoom;
        float width = ((-f2) - ((float) this.f14605a.getWidth())) - zoom;
        float f4 = this.f14608d;
        a(this.f14615k, this.f14617m, f3, (-f4) + zoom, false);
        a(this.f14616l, this.f14618n, width, ((-f4) - ((float) this.f14605a.getHeight())) - zoom, true);
        for (int i2 = this.f14615k.f14623a; i2 <= this.f14616l.f14623a; i2++) {
            a(i2);
        }
        int i3 = (this.f14616l.f14623a - this.f14615k.f14623a) + 1;
        int i4 = 0;
        for (int i5 = this.f14615k.f14623a; i5 <= this.f14616l.f14623a && i4 < a.C0106a.f14688a; i5++) {
            if (i5 == this.f14615k.f14623a && i3 > 1) {
                a2 = a(this.f14615k, this.f14617m, a.C0106a.f14688a - i4);
            } else if (i5 == this.f14616l.f14623a && i3 > 1) {
                a2 = b(this.f14616l, this.f14618n, a.C0106a.f14688a - i4);
            } else if (i3 == 1) {
                a2 = a(this.f14615k, this.f14616l, this.f14617m, a.C0106a.f14688a - i4);
            } else {
                a(this.f14619o, i5);
                a2 = a(i5, this.f14619o, a.C0106a.f14688a - i4);
            }
            i4 += a2;
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f14606b = 1;
        this.f14607c = -com.github.barteksc.pdfviewer.util.b.a(this.f14605a.getCurrentXOffset(), 0.0f);
        this.f14608d = -com.github.barteksc.pdfviewer.util.b.a(this.f14605a.getCurrentYOffset(), 0.0f);
        b();
    }
}
