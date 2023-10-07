package fe;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import fa.d;
import fb.g;
import fc.e;
import fc.f;
import fe.c;
import fg.i;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public class j extends k {

    /* renamed from: a  reason: collision with root package name */
    protected g f27141a;

    /* renamed from: b  reason: collision with root package name */
    protected Paint f27142b;

    /* renamed from: c  reason: collision with root package name */
    protected WeakReference<Bitmap> f27143c;

    /* renamed from: d  reason: collision with root package name */
    protected Canvas f27144d;

    /* renamed from: e  reason: collision with root package name */
    protected Bitmap.Config f27145e = Bitmap.Config.ARGB_8888;

    /* renamed from: l  reason: collision with root package name */
    protected Path f27146l = new Path();

    /* renamed from: m  reason: collision with root package name */
    protected Path f27147m = new Path();

    /* renamed from: n  reason: collision with root package name */
    protected Path f27148n = new Path();

    /* renamed from: p  reason: collision with root package name */
    private float[] f27149p = new float[4];

    /* renamed from: q  reason: collision with root package name */
    private HashMap<e, a> f27150q = new HashMap<>();

    /* renamed from: r  reason: collision with root package name */
    private float[] f27151r = new float[2];

    /* renamed from: fe.j$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27152a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.github.mikephil.charting.data.LineDataSet$Mode[] r0 = com.github.mikephil.charting.data.LineDataSet.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27152a = r0
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.LINEAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27152a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.STEPPED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f27152a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.CUBIC_BEZIER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f27152a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.HORIZONTAL_BEZIER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.j.AnonymousClass1.<clinit>():void");
        }
    }

    private class a {

        /* renamed from: b  reason: collision with root package name */
        private Path f27154b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap[] f27155c;

        private a() {
            this.f27154b = new Path();
        }

        /* synthetic */ a(j jVar, AnonymousClass1 r2) {
            this();
        }

        /* access modifiers changed from: protected */
        public Bitmap a(int i2) {
            Bitmap[] bitmapArr = this.f27155c;
            return bitmapArr[i2 % bitmapArr.length];
        }

        /* access modifiers changed from: protected */
        public void a(f fVar, boolean z2, boolean z3) {
            int H = fVar.H();
            float C = fVar.C();
            float D = fVar.D();
            for (int i2 = 0; i2 < H; i2++) {
                Bitmap.Config config = Bitmap.Config.ARGB_4444;
                double d2 = (double) C;
                Double.isNaN(d2);
                int i3 = (int) (d2 * 2.1d);
                Bitmap createBitmap = Bitmap.createBitmap(i3, i3, config);
                Canvas canvas = new Canvas(createBitmap);
                this.f27155c[i2] = createBitmap;
                j.this.f27126h.setColor(fVar.e(i2));
                if (z3) {
                    this.f27154b.reset();
                    this.f27154b.addCircle(C, C, C, Path.Direction.CW);
                    this.f27154b.addCircle(C, C, D, Path.Direction.CCW);
                    canvas.drawPath(this.f27154b, j.this.f27126h);
                } else {
                    canvas.drawCircle(C, C, C, j.this.f27126h);
                    if (z2) {
                        canvas.drawCircle(C, C, D, j.this.f27142b);
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public boolean a(f fVar) {
            int H = fVar.H();
            Bitmap[] bitmapArr = this.f27155c;
            if (bitmapArr == null) {
                this.f27155c = new Bitmap[H];
                return true;
            } else if (bitmapArr.length == H) {
                return false;
            } else {
                this.f27155c = new Bitmap[H];
                return true;
            }
        }
    }

    public j(g gVar, ex.a aVar, fg.j jVar) {
        super(aVar, jVar);
        this.f27141a = gVar;
        Paint paint = new Paint(1);
        this.f27142b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f27142b.setColor(-1);
    }

    private void a(f fVar, int i2, int i3, Path path) {
        float a2 = fVar.K().a(fVar, this.f27141a);
        float a3 = this.f27125g.a();
        boolean z2 = fVar.A() == LineDataSet.Mode.STEPPED;
        path.reset();
        Entry d2 = fVar.d(i2);
        path.moveTo(d2.i(), a2);
        path.lineTo(d2.i(), d2.b() * a3);
        Entry entry = null;
        int i4 = i2 + 1;
        while (i4 <= i3) {
            entry = fVar.d(i4);
            if (z2) {
                path.lineTo(entry.i(), d2.b() * a3);
            }
            path.lineTo(entry.i(), entry.b() * a3);
            i4++;
            d2 = entry;
        }
        if (entry != null) {
            path.lineTo(entry.i(), a2);
        }
        path.close();
    }

    public void a() {
    }

    public void a(Canvas canvas) {
        int n2 = (int) this.f27179o.n();
        int m2 = (int) this.f27179o.m();
        WeakReference<Bitmap> weakReference = this.f27143c;
        Bitmap bitmap = weakReference == null ? null : (Bitmap) weakReference.get();
        if (!(bitmap != null && bitmap.getWidth() == n2 && bitmap.getHeight() == m2)) {
            if (n2 > 0 && m2 > 0) {
                bitmap = Bitmap.createBitmap(n2, m2, this.f27145e);
                this.f27143c = new WeakReference<>(bitmap);
                this.f27144d = new Canvas(bitmap);
            } else {
                return;
            }
        }
        bitmap.eraseColor(0);
        for (f fVar : this.f27141a.getLineData().h()) {
            if (fVar.s()) {
                a(canvas, fVar);
            }
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f27126h);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, f fVar) {
        if (fVar.u() >= 1) {
            this.f27126h.setStrokeWidth(fVar.O());
            this.f27126h.setPathEffect(fVar.F());
            int i2 = AnonymousClass1.f27152a[fVar.A().ordinal()];
            if (i2 == 3) {
                b(fVar);
            } else if (i2 != 4) {
                b(canvas, fVar);
            } else {
                a(fVar);
            }
            this.f27126h.setPathEffect((PathEffect) null);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, f fVar, Path path, fg.g gVar, c.a aVar) {
        float a2 = fVar.K().a(fVar, this.f27141a);
        path.lineTo(fVar.d(aVar.f27107a + aVar.f27109c).i(), a2);
        path.lineTo(fVar.d(aVar.f27107a).i(), a2);
        path.close();
        gVar.a(path);
        Drawable M = fVar.M();
        if (M != null) {
            a(canvas, path, M);
        } else {
            a(canvas, path, fVar.L(), fVar.N());
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, f fVar, fg.g gVar, c.a aVar) {
        int i2;
        int i3;
        Path path = this.f27148n;
        int i4 = aVar.f27107a;
        int i5 = aVar.f27109c + aVar.f27107a;
        int i6 = 0;
        do {
            i2 = (i6 * 128) + i4;
            i3 = i2 + 128;
            if (i3 > i5) {
                i3 = i5;
            }
            if (i2 <= i3) {
                a(fVar, i2, i3, path);
                gVar.a(path);
                Drawable M = fVar.M();
                if (M != null) {
                    a(canvas, path, M);
                } else {
                    a(canvas, path, fVar.L(), fVar.N());
                }
            }
            i6++;
        } while (i2 <= i3);
    }

    public void a(Canvas canvas, String str, float f2, float f3, int i2) {
        this.f27129k.setColor(i2);
        canvas.drawText(str, f2, f3, this.f27129k);
    }

    public void a(Canvas canvas, d[] dVarArr) {
        com.github.mikephil.charting.data.j lineData = this.f27141a.getLineData();
        for (d dVar : dVarArr) {
            f fVar = (f) lineData.a(dVar.f());
            if (fVar != null && fVar.g()) {
                Entry b2 = fVar.b(dVar.a(), dVar.b());
                if (a(b2, fVar)) {
                    fg.d b3 = this.f27141a.a(fVar.t()).b(b2.i(), b2.b() * this.f27125g.a());
                    dVar.a((float) b3.f27218a, (float) b3.f27219b);
                    a(canvas, (float) b3.f27218a, (float) b3.f27219b, fVar);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(f fVar) {
        float a2 = this.f27125g.a();
        fg.g a3 = this.f27141a.a(fVar.t());
        this.f27106f.a(this.f27141a, fVar);
        this.f27146l.reset();
        if (this.f27106f.f27109c >= 1) {
            Entry d2 = fVar.d(this.f27106f.f27107a);
            this.f27146l.moveTo(d2.i(), d2.b() * a2);
            int i2 = this.f27106f.f27107a + 1;
            while (i2 <= this.f27106f.f27109c + this.f27106f.f27107a) {
                Entry d3 = fVar.d(i2);
                float i3 = d2.i() + ((d3.i() - d2.i()) / 2.0f);
                this.f27146l.cubicTo(i3, d2.b() * a2, i3, d3.b() * a2, d3.i(), d3.b() * a2);
                i2++;
                d2 = d3;
            }
        }
        if (fVar.P()) {
            this.f27147m.reset();
            this.f27147m.addPath(this.f27146l);
            a(this.f27144d, fVar, this.f27147m, a3, this.f27106f);
        }
        this.f27126h.setColor(fVar.c());
        this.f27126h.setStyle(Paint.Style.STROKE);
        a3.a(this.f27146l);
        this.f27144d.drawPath(this.f27146l, this.f27126h);
        this.f27126h.setPathEffect((PathEffect) null);
    }

    public void b() {
        Canvas canvas = this.f27144d;
        if (canvas != null) {
            canvas.setBitmap((Bitmap) null);
            this.f27144d = null;
        }
        WeakReference<Bitmap> weakReference = this.f27143c;
        if (weakReference != null) {
            Bitmap bitmap = (Bitmap) weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f27143c.clear();
            this.f27143c = null;
        }
    }

    public void b(Canvas canvas) {
        int i2;
        f fVar;
        Entry entry;
        if (a((fb.e) this.f27141a)) {
            List h2 = this.f27141a.getLineData().h();
            for (int i3 = 0; i3 < h2.size(); i3++) {
                f fVar2 = (f) h2.get(i3);
                if (a(fVar2) && fVar2.u() >= 1) {
                    b((e) fVar2);
                    fg.g a2 = this.f27141a.a(fVar2.t());
                    int C = (int) (fVar2.C() * 1.75f);
                    if (!fVar2.G()) {
                        C /= 2;
                    }
                    int i4 = C;
                    this.f27106f.a(this.f27141a, fVar2);
                    float[] a3 = a2.a(fVar2, this.f27125g.b(), this.f27125g.a(), this.f27106f.f27107a, this.f27106f.f27108b);
                    ez.d h3 = fVar2.h();
                    fg.e a4 = fg.e.a(fVar2.r());
                    a4.f27222a = i.a(a4.f27222a);
                    a4.f27223b = i.a(a4.f27223b);
                    int i5 = 0;
                    while (i5 < a3.length) {
                        float f2 = a3[i5];
                        float f3 = a3[i5 + 1];
                        if (!this.f27179o.h(f2)) {
                            break;
                        }
                        if (!this.f27179o.g(f2) || !this.f27179o.f(f3)) {
                            i2 = i4;
                            fVar = fVar2;
                        } else {
                            int i6 = i5 / 2;
                            Entry d2 = fVar2.d(this.f27106f.f27107a + i6);
                            if (fVar2.p()) {
                                entry = d2;
                                i2 = i4;
                                float f4 = f3 - ((float) i4);
                                fVar = fVar2;
                                a(canvas, h3.a(d2), f2, f4, fVar2.c(i6));
                            } else {
                                entry = d2;
                                i2 = i4;
                                fVar = fVar2;
                            }
                            if (entry.g() != null && fVar.q()) {
                                Drawable g2 = entry.g();
                                i.a(canvas, g2, (int) (f2 + a4.f27222a), (int) (f3 + a4.f27223b), g2.getIntrinsicWidth(), g2.getIntrinsicHeight());
                            }
                        }
                        i5 += 2;
                        fVar2 = fVar;
                        i4 = i2;
                    }
                    fg.e.b(a4);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(Canvas canvas, f fVar) {
        f fVar2 = fVar;
        int u2 = fVar.u();
        boolean z2 = fVar.A() == LineDataSet.Mode.STEPPED;
        int i2 = z2 ? 4 : 2;
        fg.g a2 = this.f27141a.a(fVar.t());
        float a3 = this.f27125g.a();
        this.f27126h.setStyle(Paint.Style.STROKE);
        Canvas canvas2 = fVar.E() ? this.f27144d : canvas;
        this.f27106f.a(this.f27141a, fVar2);
        if (fVar.P() && u2 > 0) {
            a(canvas, fVar2, a2, this.f27106f);
        }
        if (fVar.b().size() > 1) {
            int i3 = i2 * 2;
            if (this.f27149p.length <= i3) {
                this.f27149p = new float[(i2 * 4)];
            }
            for (int i4 = this.f27106f.f27107a; i4 <= this.f27106f.f27109c + this.f27106f.f27107a; i4++) {
                Entry d2 = fVar2.d(i4);
                if (d2 != null) {
                    this.f27149p[0] = d2.i();
                    this.f27149p[1] = d2.b() * a3;
                    if (i4 < this.f27106f.f27108b) {
                        Entry d3 = fVar2.d(i4 + 1);
                        if (d3 == null) {
                            break;
                        }
                        float[] fArr = this.f27149p;
                        float i5 = d3.i();
                        if (z2) {
                            fArr[2] = i5;
                            float[] fArr2 = this.f27149p;
                            fArr2[3] = fArr2[1];
                            fArr2[4] = fArr2[2];
                            fArr2[5] = fArr2[3];
                            fArr2[6] = d3.i();
                            this.f27149p[7] = d3.b() * a3;
                        } else {
                            fArr[2] = i5;
                            this.f27149p[3] = d3.b() * a3;
                        }
                    } else {
                        float[] fArr3 = this.f27149p;
                        fArr3[2] = fArr3[0];
                        fArr3[3] = fArr3[1];
                    }
                    a2.a(this.f27149p);
                    if (!this.f27179o.h(this.f27149p[0])) {
                        break;
                    } else if (this.f27179o.g(this.f27149p[2]) && (this.f27179o.i(this.f27149p[1]) || this.f27179o.j(this.f27149p[3]))) {
                        this.f27126h.setColor(fVar2.a(i4));
                        canvas2.drawLines(this.f27149p, 0, i3, this.f27126h);
                    }
                }
            }
        } else {
            int i6 = u2 * i2;
            if (this.f27149p.length < Math.max(i6, i2) * 2) {
                this.f27149p = new float[(Math.max(i6, i2) * 4)];
            }
            if (fVar2.d(this.f27106f.f27107a) != null) {
                int i7 = this.f27106f.f27107a;
                int i8 = 0;
                while (i7 <= this.f27106f.f27109c + this.f27106f.f27107a) {
                    Entry d4 = fVar2.d(i7 == 0 ? 0 : i7 - 1);
                    Entry d5 = fVar2.d(i7);
                    if (!(d4 == null || d5 == null)) {
                        int i9 = i8 + 1;
                        this.f27149p[i8] = d4.i();
                        int i10 = i9 + 1;
                        this.f27149p[i9] = d4.b() * a3;
                        if (z2) {
                            int i11 = i10 + 1;
                            this.f27149p[i10] = d5.i();
                            int i12 = i11 + 1;
                            this.f27149p[i11] = d4.b() * a3;
                            int i13 = i12 + 1;
                            this.f27149p[i12] = d5.i();
                            i10 = i13 + 1;
                            this.f27149p[i13] = d4.b() * a3;
                        }
                        int i14 = i10 + 1;
                        this.f27149p[i10] = d5.i();
                        this.f27149p[i14] = d5.b() * a3;
                        i8 = i14 + 1;
                    }
                    i7++;
                }
                if (i8 > 0) {
                    a2.a(this.f27149p);
                    this.f27126h.setColor(fVar.c());
                    canvas2.drawLines(this.f27149p, 0, Math.max((this.f27106f.f27109c + 1) * i2, i2) * 2, this.f27126h);
                }
            }
        }
        this.f27126h.setPathEffect((PathEffect) null);
    }

    /* access modifiers changed from: protected */
    public void b(f fVar) {
        f fVar2 = fVar;
        float a2 = this.f27125g.a();
        fg.g a3 = this.f27141a.a(fVar.t());
        this.f27106f.a(this.f27141a, fVar2);
        float B = fVar.B();
        this.f27146l.reset();
        if (this.f27106f.f27109c >= 1) {
            int i2 = this.f27106f.f27107a + 1;
            int i3 = this.f27106f.f27107a;
            int i4 = this.f27106f.f27109c;
            Entry d2 = fVar2.d(Math.max(i2 - 2, 0));
            Entry d3 = fVar2.d(Math.max(i2 - 1, 0));
            int i5 = -1;
            if (d3 != null) {
                this.f27146l.moveTo(d3.i(), d3.b() * a2);
                int i6 = this.f27106f.f27107a + 1;
                Entry entry = d3;
                while (i6 <= this.f27106f.f27109c + this.f27106f.f27107a) {
                    if (i5 != i6) {
                        d3 = fVar2.d(i6);
                    }
                    int i7 = i6 + 1;
                    if (i7 < fVar.u()) {
                        i6 = i7;
                    }
                    Entry d4 = fVar2.d(i6);
                    this.f27146l.cubicTo(entry.i() + ((d3.i() - d2.i()) * B), (entry.b() + ((d3.b() - d2.b()) * B)) * a2, d3.i() - ((d4.i() - entry.i()) * B), (d3.b() - ((d4.b() - entry.b()) * B)) * a2, d3.i(), d3.b() * a2);
                    d2 = entry;
                    entry = d3;
                    d3 = d4;
                    int i8 = i6;
                    i6 = i7;
                    i5 = i8;
                }
            } else {
                return;
            }
        }
        if (fVar.P()) {
            this.f27147m.reset();
            this.f27147m.addPath(this.f27146l);
            a(this.f27144d, fVar, this.f27147m, a3, this.f27106f);
        }
        this.f27126h.setColor(fVar.c());
        this.f27126h.setStyle(Paint.Style.STROKE);
        a3.a(this.f27146l);
        this.f27144d.drawPath(this.f27146l, this.f27126h);
        this.f27126h.setPathEffect((PathEffect) null);
    }

    public void c(Canvas canvas) {
        d(canvas);
    }

    /* access modifiers changed from: protected */
    public void d(Canvas canvas) {
        a aVar;
        Bitmap a2;
        this.f27126h.setStyle(Paint.Style.FILL);
        float a3 = this.f27125g.a();
        float[] fArr = this.f27151r;
        char c2 = 0;
        float f2 = 0.0f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        List h2 = this.f27141a.getLineData().h();
        int i2 = 0;
        while (i2 < h2.size()) {
            f fVar = (f) h2.get(i2);
            if (fVar.s() && fVar.G() && fVar.u() != 0) {
                this.f27142b.setColor(fVar.I());
                fg.g a4 = this.f27141a.a(fVar.t());
                this.f27106f.a(this.f27141a, fVar);
                float C = fVar.C();
                float D = fVar.D();
                boolean z2 = fVar.J() && D < C && D > f2;
                boolean z3 = z2 && fVar.I() == 1122867;
                if (this.f27150q.containsKey(fVar)) {
                    aVar = this.f27150q.get(fVar);
                } else {
                    aVar = new a(this, (AnonymousClass1) null);
                    this.f27150q.put(fVar, aVar);
                }
                if (aVar.a(fVar)) {
                    aVar.a(fVar, z2, z3);
                }
                int i3 = this.f27106f.f27109c + this.f27106f.f27107a;
                int i4 = this.f27106f.f27107a;
                while (i4 <= i3) {
                    Entry d2 = fVar.d(i4);
                    if (d2 == null) {
                        break;
                    }
                    this.f27151r[c2] = d2.i();
                    this.f27151r[1] = d2.b() * a3;
                    a4.a(this.f27151r);
                    if (!this.f27179o.h(this.f27151r[c2])) {
                        break;
                    }
                    if (!this.f27179o.g(this.f27151r[c2]) || !this.f27179o.f(this.f27151r[1]) || (a2 = aVar.a(i4)) == null) {
                        Canvas canvas2 = canvas;
                    } else {
                        float[] fArr2 = this.f27151r;
                        canvas.drawBitmap(a2, fArr2[c2] - C, fArr2[1] - C, (Paint) null);
                    }
                    i4++;
                    c2 = 0;
                }
            }
            Canvas canvas3 = canvas;
            i2++;
            c2 = 0;
            f2 = 0.0f;
        }
    }
}
