package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseBooleanArray;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.github.barteksc.pdfviewer.util.c;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;
import java.util.ArrayList;
import java.util.List;

class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f14628a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private PdfDocument f14629b;

    /* renamed from: c  reason: collision with root package name */
    private PdfiumCore f14630c;

    /* renamed from: d  reason: collision with root package name */
    private int f14631d = 0;

    /* renamed from: e  reason: collision with root package name */
    private List<Size> f14632e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private List<SizeF> f14633f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private SparseBooleanArray f14634g = new SparseBooleanArray();

    /* renamed from: h  reason: collision with root package name */
    private Size f14635h = new Size(0, 0);

    /* renamed from: i  reason: collision with root package name */
    private Size f14636i = new Size(0, 0);

    /* renamed from: j  reason: collision with root package name */
    private SizeF f14637j = new SizeF(0.0f, 0.0f);

    /* renamed from: k  reason: collision with root package name */
    private SizeF f14638k = new SizeF(0.0f, 0.0f);

    /* renamed from: l  reason: collision with root package name */
    private boolean f14639l = true;

    /* renamed from: m  reason: collision with root package name */
    private int f14640m = 0;

    /* renamed from: n  reason: collision with root package name */
    private boolean f14641n;

    /* renamed from: o  reason: collision with root package name */
    private List<Float> f14642o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private List<Float> f14643p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private float f14644q = 0.0f;

    /* renamed from: r  reason: collision with root package name */
    private final FitPolicy f14645r;

    /* renamed from: s  reason: collision with root package name */
    private int[] f14646s;

    f(PdfiumCore pdfiumCore, PdfDocument pdfDocument, FitPolicy fitPolicy, Size size, int[] iArr, boolean z2, int i2, boolean z3) {
        this.f14630c = pdfiumCore;
        this.f14629b = pdfDocument;
        this.f14645r = fitPolicy;
        this.f14646s = iArr;
        this.f14639l = z2;
        this.f14640m = i2;
        this.f14641n = z3;
        b(size);
    }

    private void b(Size size) {
        int[] iArr = this.f14646s;
        this.f14631d = iArr != null ? iArr.length : this.f14630c.a(this.f14629b);
        for (int i2 = 0; i2 < this.f14631d; i2++) {
            Size b2 = this.f14630c.b(this.f14629b, f(i2));
            if (b2.a() > this.f14635h.a()) {
                this.f14635h = b2;
            }
            if (b2.b() > this.f14636i.b()) {
                this.f14636i = b2;
            }
            this.f14632e.add(b2);
        }
        a(size);
    }

    private void c(Size size) {
        float f2;
        float f3;
        this.f14643p.clear();
        for (int i2 = 0; i2 < a(); i2++) {
            SizeF sizeF = this.f14633f.get(i2);
            if (this.f14639l) {
                f2 = (float) size.b();
                f3 = sizeF.b();
            } else {
                f2 = (float) size.a();
                f3 = sizeF.a();
            }
            float max = Math.max(0.0f, f2 - f3);
            if (i2 < a() - 1) {
                max += (float) this.f14640m;
            }
            this.f14643p.add(Float.valueOf(max));
        }
    }

    private void h() {
        float f2;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < a(); i2++) {
            SizeF sizeF = this.f14633f.get(i2);
            f3 += this.f14639l ? sizeF.b() : sizeF.a();
            if (this.f14641n) {
                f2 = this.f14643p.get(i2).floatValue();
            } else if (i2 < a() - 1) {
                f2 = (float) this.f14640m;
            }
            f3 += f2;
        }
        this.f14644q = f3;
    }

    private void i() {
        float f2;
        float f3;
        this.f14642o.clear();
        float f4 = 0.0f;
        for (int i2 = 0; i2 < a(); i2++) {
            SizeF sizeF = this.f14633f.get(i2);
            float b2 = this.f14639l ? sizeF.b() : sizeF.a();
            if (this.f14641n) {
                f2 += this.f14643p.get(i2).floatValue() / 2.0f;
                if (i2 == 0) {
                    f2 -= ((float) this.f14640m) / 2.0f;
                } else if (i2 == a() - 1) {
                    f2 += ((float) this.f14640m) / 2.0f;
                }
                this.f14642o.add(Float.valueOf(f2));
                f3 = this.f14643p.get(i2).floatValue() / 2.0f;
            } else {
                this.f14642o.add(Float.valueOf(f2));
                f3 = (float) this.f14640m;
            }
            f4 = f2 + b2 + f3;
        }
    }

    public float a(float f2) {
        return this.f14644q * f2;
    }

    public int a() {
        return this.f14631d;
    }

    public int a(float f2, float f3) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < a() && (this.f14642o.get(i2).floatValue() * f3) - (c(i2, f3) / 2.0f) < f2) {
            i3++;
            i2++;
        }
        int i4 = i3 - 1;
        if (i4 >= 0) {
            return i4;
        }
        return 0;
    }

    public RectF a(int i2, int i3, int i4, int i5, int i6, RectF rectF) {
        return this.f14630c.a(this.f14629b, f(i2), i3, i4, i5, i6, 0, rectF);
    }

    public SizeF a(int i2) {
        return f(i2) < 0 ? new SizeF(0.0f, 0.0f) : this.f14633f.get(i2);
    }

    public SizeF a(int i2, float f2) {
        SizeF a2 = a(i2);
        return new SizeF(a2.a() * f2, a2.b() * f2);
    }

    public void a(Bitmap bitmap, int i2, Rect rect, boolean z2) {
        Bitmap bitmap2 = bitmap;
        this.f14630c.a(this.f14629b, bitmap2, f(i2), rect.left, rect.top, rect.width(), rect.height(), z2);
    }

    public void a(Size size) {
        this.f14633f.clear();
        c cVar = new c(this.f14645r, this.f14635h, this.f14636i, size);
        this.f14638k = cVar.a();
        this.f14637j = cVar.b();
        for (Size a2 : this.f14632e) {
            this.f14633f.add(cVar.a(a2));
        }
        if (this.f14641n) {
            c(size);
        }
        h();
        i();
    }

    public float b(int i2, float f2) {
        SizeF a2 = a(i2);
        return (this.f14639l ? a2.b() : a2.a()) * f2;
    }

    public SizeF b() {
        return this.f14639l ? this.f14638k : this.f14637j;
    }

    public boolean b(int i2) throws PageRenderingException {
        int f2 = f(i2);
        if (f2 < 0) {
            return false;
        }
        synchronized (f14628a) {
            if (this.f14634g.indexOfKey(f2) >= 0) {
                return false;
            }
            try {
                this.f14630c.a(this.f14629b, f2);
                this.f14634g.put(f2, true);
                return true;
            } catch (Exception e2) {
                this.f14634g.put(f2, false);
                throw new PageRenderingException(i2, e2);
            }
        }
    }

    public float c() {
        return b().a();
    }

    public float c(int i2, float f2) {
        return (this.f14641n ? this.f14643p.get(i2).floatValue() : (float) this.f14640m) * f2;
    }

    public boolean c(int i2) {
        return !this.f14634g.get(f(i2), false);
    }

    public float d() {
        return b().b();
    }

    public float d(int i2, float f2) {
        if (f(i2) < 0) {
            return 0.0f;
        }
        return this.f14642o.get(i2).floatValue() * f2;
    }

    public List<PdfDocument.Link> d(int i2) {
        return this.f14630c.c(this.f14629b, f(i2));
    }

    public float e(int i2, float f2) {
        float d2;
        float b2;
        SizeF a2 = a(i2);
        if (this.f14639l) {
            d2 = c();
            b2 = a2.a();
        } else {
            d2 = d();
            b2 = a2.b();
        }
        return (f2 * (d2 - b2)) / 2.0f;
    }

    public int e(int i2) {
        int a2;
        if (i2 <= 0) {
            return 0;
        }
        int[] iArr = this.f14646s;
        if (iArr != null) {
            if (i2 >= iArr.length) {
                a2 = iArr.length;
            }
            return i2;
        }
        if (i2 >= a()) {
            a2 = a();
        }
        return i2;
        return a2 - 1;
    }

    public PdfDocument.Meta e() {
        PdfDocument pdfDocument = this.f14629b;
        if (pdfDocument == null) {
            return null;
        }
        return this.f14630c.c(pdfDocument);
    }

    public int f(int i2) {
        int i3;
        int[] iArr = this.f14646s;
        if (iArr == null) {
            i3 = i2;
        } else if (i2 < 0 || i2 >= iArr.length) {
            return -1;
        } else {
            i3 = iArr[i2];
        }
        if (i3 < 0 || i2 >= a()) {
            return -1;
        }
        return i3;
    }

    public List<PdfDocument.Bookmark> f() {
        PdfDocument pdfDocument = this.f14629b;
        return pdfDocument == null ? new ArrayList() : this.f14630c.d(pdfDocument);
    }

    public void g() {
        PdfDocument pdfDocument;
        PdfiumCore pdfiumCore = this.f14630c;
        if (!(pdfiumCore == null || (pdfDocument = this.f14629b) == null)) {
            pdfiumCore.b(pdfDocument);
        }
        this.f14629b = null;
        this.f14646s = null;
    }
}
