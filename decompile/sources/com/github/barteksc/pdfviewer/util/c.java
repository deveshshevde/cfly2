package com.github.barteksc.pdfviewer.util;

import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private FitPolicy f14692a;

    /* renamed from: b  reason: collision with root package name */
    private final Size f14693b;

    /* renamed from: c  reason: collision with root package name */
    private final Size f14694c;

    /* renamed from: d  reason: collision with root package name */
    private final Size f14695d;

    /* renamed from: e  reason: collision with root package name */
    private SizeF f14696e;

    /* renamed from: f  reason: collision with root package name */
    private SizeF f14697f;

    /* renamed from: g  reason: collision with root package name */
    private float f14698g;

    /* renamed from: h  reason: collision with root package name */
    private float f14699h;

    /* renamed from: com.github.barteksc.pdfviewer.util.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14700a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.github.barteksc.pdfviewer.util.FitPolicy[] r0 = com.github.barteksc.pdfviewer.util.FitPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14700a = r0
                com.github.barteksc.pdfviewer.util.FitPolicy r1 = com.github.barteksc.pdfviewer.util.FitPolicy.HEIGHT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14700a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.barteksc.pdfviewer.util.FitPolicy r1 = com.github.barteksc.pdfviewer.util.FitPolicy.BOTH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.util.c.AnonymousClass1.<clinit>():void");
        }
    }

    public c(FitPolicy fitPolicy, Size size, Size size2, Size size3) {
        this.f14692a = fitPolicy;
        this.f14693b = size;
        this.f14694c = size2;
        this.f14695d = size3;
        c();
    }

    private SizeF a(Size size, float f2) {
        return new SizeF(f2, (float) Math.floor((double) (f2 / (((float) size.a()) / ((float) size.b())))));
    }

    private SizeF a(Size size, float f2, float f3) {
        float a2 = ((float) size.a()) / ((float) size.b());
        float floor = (float) Math.floor((double) (f2 / a2));
        if (floor > f3) {
            f2 = (float) Math.floor((double) (a2 * f3));
        } else {
            f3 = floor;
        }
        return new SizeF(f2, f3);
    }

    private SizeF b(Size size, float f2) {
        return new SizeF((float) Math.floor((double) (f2 / (((float) size.b()) / ((float) size.a())))), f2);
    }

    private void c() {
        int i2 = AnonymousClass1.f14700a[this.f14692a.ordinal()];
        if (i2 == 1) {
            SizeF b2 = b(this.f14694c, (float) this.f14695d.b());
            this.f14697f = b2;
            this.f14699h = b2.b() / ((float) this.f14694c.b());
            Size size = this.f14693b;
            this.f14696e = b(size, ((float) size.b()) * this.f14699h);
        } else if (i2 != 2) {
            SizeF a2 = a(this.f14693b, (float) this.f14695d.a());
            this.f14696e = a2;
            this.f14698g = a2.a() / ((float) this.f14693b.a());
            Size size2 = this.f14694c;
            this.f14697f = a(size2, ((float) size2.a()) * this.f14698g);
        } else {
            float a3 = a(this.f14693b, (float) this.f14695d.a(), (float) this.f14695d.b()).a() / ((float) this.f14693b.a());
            Size size3 = this.f14694c;
            SizeF a4 = a(size3, ((float) size3.a()) * a3, (float) this.f14695d.b());
            this.f14697f = a4;
            this.f14699h = a4.b() / ((float) this.f14694c.b());
            SizeF a5 = a(this.f14693b, (float) this.f14695d.a(), ((float) this.f14693b.b()) * this.f14699h);
            this.f14696e = a5;
            this.f14698g = a5.a() / ((float) this.f14693b.a());
        }
    }

    public SizeF a() {
        return this.f14696e;
    }

    public SizeF a(Size size) {
        if (size.a() <= 0 || size.b() <= 0) {
            return new SizeF(0.0f, 0.0f);
        }
        int i2 = AnonymousClass1.f14700a[this.f14692a.ordinal()];
        return i2 != 1 ? i2 != 2 ? a(size, ((float) size.a()) * this.f14698g) : a(size, ((float) size.a()) * this.f14698g, ((float) size.b()) * this.f14699h) : b(size, ((float) size.b()) * this.f14699h);
    }

    public SizeF b() {
        return this.f14697f;
    }
}
