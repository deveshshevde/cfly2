package fe;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import ex.a;
import fa.d;
import fg.e;
import fg.i;
import fg.j;
import java.lang.ref.WeakReference;

public class m extends g {

    /* renamed from: a  reason: collision with root package name */
    protected PieChart f27157a;

    /* renamed from: b  reason: collision with root package name */
    protected Paint f27158b;

    /* renamed from: c  reason: collision with root package name */
    protected Paint f27159c;

    /* renamed from: d  reason: collision with root package name */
    protected Paint f27160d;

    /* renamed from: e  reason: collision with root package name */
    protected WeakReference<Bitmap> f27161e;

    /* renamed from: f  reason: collision with root package name */
    protected Canvas f27162f;

    /* renamed from: l  reason: collision with root package name */
    protected Path f27163l = new Path();

    /* renamed from: m  reason: collision with root package name */
    protected RectF f27164m = new RectF();

    /* renamed from: n  reason: collision with root package name */
    private TextPaint f27165n;

    /* renamed from: p  reason: collision with root package name */
    private Paint f27166p;

    /* renamed from: q  reason: collision with root package name */
    private StaticLayout f27167q;

    /* renamed from: r  reason: collision with root package name */
    private CharSequence f27168r;

    /* renamed from: s  reason: collision with root package name */
    private RectF f27169s = new RectF();

    /* renamed from: t  reason: collision with root package name */
    private RectF[] f27170t = {new RectF(), new RectF(), new RectF()};

    /* renamed from: u  reason: collision with root package name */
    private Path f27171u = new Path();

    /* renamed from: v  reason: collision with root package name */
    private RectF f27172v = new RectF();

    /* renamed from: w  reason: collision with root package name */
    private Path f27173w = new Path();

    public m(PieChart pieChart, a aVar, j jVar) {
        super(aVar, jVar);
        this.f27157a = pieChart;
        Paint paint = new Paint(1);
        this.f27158b = paint;
        paint.setColor(-1);
        this.f27158b.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f27159c = paint2;
        paint2.setColor(-1);
        this.f27159c.setStyle(Paint.Style.FILL);
        this.f27159c.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.f27165n = textPaint;
        textPaint.setColor(-16777216);
        this.f27165n.setTextSize(i.a(12.0f));
        this.f27129k.setTextSize(i.a(13.0f));
        this.f27129k.setColor(-1);
        this.f27129k.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint(1);
        this.f27166p = paint3;
        paint3.setColor(-1);
        this.f27166p.setTextAlign(Paint.Align.CENTER);
        this.f27166p.setTextSize(i.a(13.0f));
        Paint paint4 = new Paint(1);
        this.f27160d = paint4;
        paint4.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public float a(fc.i iVar) {
        if (!iVar.A()) {
            return iVar.a();
        }
        if (iVar.a() / this.f27179o.o() > (iVar.w() / ((com.github.mikephil.charting.data.m) this.f27157a.getData()).k()) * 2.0f) {
            return 0.0f;
        }
        return iVar.a();
    }

    /* access modifiers changed from: protected */
    public float a(e eVar, float f2, float f3, float f4, float f5, float f6, float f7) {
        e eVar2 = eVar;
        double d2 = (double) ((f6 + f7) * 0.017453292f);
        float cos = eVar2.f27222a + (((float) Math.cos(d2)) * f2);
        float sin = eVar2.f27223b + (((float) Math.sin(d2)) * f2);
        double d3 = (double) ((f6 + (f7 / 2.0f)) * 0.017453292f);
        float cos2 = eVar2.f27222a + (((float) Math.cos(d3)) * f2);
        float sin2 = eVar2.f27223b + (((float) Math.sin(d3)) * f2);
        double d4 = (double) f3;
        Double.isNaN(d4);
        double sqrt = (double) (f2 - ((float) ((Math.sqrt(Math.pow((double) (cos - f4), 2.0d) + Math.pow((double) (sin - f5), 2.0d)) / 2.0d) * Math.tan(((180.0d - d4) / 2.0d) * 0.017453292519943295d))));
        double sqrt2 = Math.sqrt(Math.pow((double) (cos2 - ((cos + f4) / 2.0f)), 2.0d) + Math.pow((double) (sin2 - ((sin + f5) / 2.0f)), 2.0d));
        Double.isNaN(sqrt);
        return (float) (sqrt - sqrt2);
    }

    public void a() {
    }

    public void a(Canvas canvas) {
        int n2 = (int) this.f27179o.n();
        int m2 = (int) this.f27179o.m();
        WeakReference<Bitmap> weakReference = this.f27161e;
        Bitmap bitmap = weakReference == null ? null : (Bitmap) weakReference.get();
        if (!(bitmap != null && bitmap.getWidth() == n2 && bitmap.getHeight() == m2)) {
            if (n2 > 0 && m2 > 0) {
                bitmap = Bitmap.createBitmap(n2, m2, Bitmap.Config.ARGB_4444);
                this.f27161e = new WeakReference<>(bitmap);
                this.f27162f = new Canvas(bitmap);
            } else {
                return;
            }
        }
        bitmap.eraseColor(0);
        for (fc.i iVar : ((com.github.mikephil.charting.data.m) this.f27157a.getData()).h()) {
            if (iVar.s() && iVar.u() > 0) {
                a(canvas, iVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, fc.i iVar) {
        float f2;
        float[] fArr;
        int i2;
        RectF rectF;
        int i3;
        float f3;
        float f4;
        int i4;
        e eVar;
        float f5;
        RectF rectF2;
        int i5;
        RectF rectF3;
        float f6;
        float f7;
        float f8;
        float f9;
        int i6;
        RectF rectF4;
        RectF rectF5;
        RectF rectF6;
        float f10;
        int i7;
        e eVar2;
        fc.i iVar2 = iVar;
        float rotationAngle = this.f27157a.getRotationAngle();
        float b2 = this.f27125g.b();
        float a2 = this.f27125g.a();
        RectF circleBox = this.f27157a.getCircleBox();
        int u2 = iVar.u();
        float[] drawAngles = this.f27157a.getDrawAngles();
        e centerCircleBox = this.f27157a.getCenterCircleBox();
        float radius = this.f27157a.getRadius();
        boolean z2 = this.f27157a.d() && !this.f27157a.c();
        float holeRadius = z2 ? (this.f27157a.getHoleRadius() / 100.0f) * radius : 0.0f;
        float holeRadius2 = (radius - ((this.f27157a.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        RectF rectF7 = new RectF();
        boolean z3 = z2 && this.f27157a.g();
        int i8 = 0;
        for (int i9 = 0; i9 < u2; i9++) {
            if (Math.abs(((PieEntry) iVar2.d(i9)).b()) > i.f27245b) {
                i8++;
            }
        }
        float a3 = i8 <= 1 ? 0.0f : a(iVar2);
        int i10 = 0;
        float f11 = 0.0f;
        while (i10 < u2) {
            float f12 = drawAngles[i10];
            if (Math.abs(iVar2.d(i10).b()) > i.f27245b && (!this.f27157a.a(i10) || z3)) {
                boolean z4 = a3 > 0.0f && f12 <= 180.0f;
                this.f27126h.setColor(iVar2.a(i10));
                float f13 = i8 == 1 ? 0.0f : a3 / (radius * 0.017453292f);
                float f14 = rotationAngle + ((f11 + (f13 / 2.0f)) * a2);
                float f15 = (f12 - f13) * a2;
                if (f15 < 0.0f) {
                    f15 = 0.0f;
                }
                this.f27171u.reset();
                if (z3) {
                    float f16 = radius - holeRadius2;
                    i3 = i10;
                    i5 = i8;
                    double d2 = (double) (f14 * 0.017453292f);
                    i2 = u2;
                    fArr = drawAngles;
                    float cos = centerCircleBox.f27222a + (((float) Math.cos(d2)) * f16);
                    float sin = centerCircleBox.f27223b + (f16 * ((float) Math.sin(d2)));
                    rectF7.set(cos - holeRadius2, sin - holeRadius2, cos + holeRadius2, sin + holeRadius2);
                } else {
                    i3 = i10;
                    i5 = i8;
                    i2 = u2;
                    fArr = drawAngles;
                }
                double d3 = (double) (f14 * 0.017453292f);
                f3 = rotationAngle;
                f2 = b2;
                float cos2 = centerCircleBox.f27222a + (((float) Math.cos(d3)) * radius);
                float sin2 = centerCircleBox.f27223b + (((float) Math.sin(d3)) * radius);
                if (f15 < 360.0f || f15 % 360.0f > i.f27245b) {
                    if (z3) {
                        this.f27171u.arcTo(rectF7, f14 + 180.0f, -180.0f);
                    }
                    this.f27171u.arcTo(circleBox, f14, f15);
                } else {
                    this.f27171u.addCircle(centerCircleBox.f27222a, centerCircleBox.f27223b, radius, Path.Direction.CW);
                }
                this.f27172v.set(centerCircleBox.f27222a - holeRadius, centerCircleBox.f27223b - holeRadius, centerCircleBox.f27222a + holeRadius, centerCircleBox.f27223b + holeRadius);
                if (!z2) {
                    f6 = f15;
                    f8 = holeRadius;
                    f9 = radius;
                    i6 = i5;
                    rectF4 = circleBox;
                    eVar = centerCircleBox;
                    rectF5 = rectF7;
                    f7 = 360.0f;
                } else if (holeRadius > 0.0f || z4) {
                    if (z4) {
                        f10 = f15;
                        i4 = i5;
                        rectF = circleBox;
                        f5 = holeRadius;
                        rectF6 = rectF7;
                        i7 = 1;
                        f4 = radius;
                        float f17 = f14;
                        eVar2 = centerCircleBox;
                        float a4 = a(centerCircleBox, radius, f12 * a2, cos2, sin2, f17, f10);
                        if (a4 < 0.0f) {
                            a4 = -a4;
                        }
                        holeRadius = Math.max(f5, a4);
                    } else {
                        f10 = f15;
                        rectF6 = rectF7;
                        f5 = holeRadius;
                        f4 = radius;
                        eVar2 = centerCircleBox;
                        i4 = i5;
                        rectF = circleBox;
                        i7 = 1;
                    }
                    float f18 = (i4 == i7 || holeRadius == 0.0f) ? 0.0f : a3 / (holeRadius * 0.017453292f);
                    float f19 = f3 + ((f11 + (f18 / 2.0f)) * a2);
                    float f20 = (f12 - f18) * a2;
                    if (f20 < 0.0f) {
                        f20 = 0.0f;
                    }
                    float f21 = f19 + f20;
                    if (f10 < 360.0f || f10 % 360.0f > i.f27245b) {
                        if (z3) {
                            float f22 = f4 - holeRadius2;
                            double d4 = (double) (f21 * 0.017453292f);
                            float cos3 = eVar2.f27222a + (((float) Math.cos(d4)) * f22);
                            float sin3 = eVar2.f27223b + (f22 * ((float) Math.sin(d4)));
                            rectF3 = rectF6;
                            rectF3.set(cos3 - holeRadius2, sin3 - holeRadius2, cos3 + holeRadius2, sin3 + holeRadius2);
                            this.f27171u.arcTo(rectF3, f21, 180.0f);
                        } else {
                            rectF3 = rectF6;
                            double d5 = (double) (f21 * 0.017453292f);
                            this.f27171u.lineTo(eVar2.f27222a + (((float) Math.cos(d5)) * holeRadius), eVar2.f27223b + (holeRadius * ((float) Math.sin(d5))));
                        }
                        this.f27171u.arcTo(this.f27172v, f21, -f20);
                    } else {
                        this.f27171u.addCircle(eVar2.f27222a, eVar2.f27223b, holeRadius, Path.Direction.CCW);
                        rectF3 = rectF6;
                    }
                    eVar = eVar2;
                    rectF2 = rectF3;
                    this.f27171u.close();
                    this.f27162f.drawPath(this.f27171u, this.f27126h);
                    f11 += f12 * f2;
                } else {
                    f6 = f15;
                    f8 = holeRadius;
                    f9 = radius;
                    i6 = i5;
                    f7 = 360.0f;
                    rectF4 = circleBox;
                    eVar = centerCircleBox;
                    rectF5 = rectF7;
                }
                if (f6 % f7 > i.f27245b) {
                    if (z4) {
                        float f23 = f14 + (f6 / 2.0f);
                        float f24 = f14;
                        rectF2 = rectF3;
                        float a5 = a(eVar, f4, f12 * a2, cos2, sin2, f24, f6);
                        double d6 = (double) (f23 * 0.017453292f);
                        this.f27171u.lineTo(eVar.f27222a + (((float) Math.cos(d6)) * a5), eVar.f27223b + (a5 * ((float) Math.sin(d6))));
                    } else {
                        rectF2 = rectF3;
                        this.f27171u.lineTo(eVar.f27222a, eVar.f27223b);
                    }
                    this.f27171u.close();
                    this.f27162f.drawPath(this.f27171u, this.f27126h);
                    f11 += f12 * f2;
                }
                rectF2 = rectF3;
                this.f27171u.close();
                this.f27162f.drawPath(this.f27171u, this.f27126h);
                f11 += f12 * f2;
            } else {
                f11 += f12 * b2;
                i3 = i10;
                rectF2 = rectF7;
                f4 = radius;
                f3 = rotationAngle;
                f2 = b2;
                rectF = circleBox;
                i2 = u2;
                fArr = drawAngles;
                i4 = i8;
                f5 = holeRadius;
                eVar = centerCircleBox;
            }
            i10 = i3 + 1;
            rectF7 = rectF2;
            holeRadius = f5;
            centerCircleBox = eVar;
            i8 = i4;
            radius = f4;
            rotationAngle = f3;
            circleBox = rectF;
            u2 = i2;
            drawAngles = fArr;
            b2 = f2;
            iVar2 = iVar;
        }
        e.b(centerCircleBox);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, String str, float f2, float f3) {
        canvas.drawText(str, f2, f3, this.f27166p);
    }

    public void a(Canvas canvas, String str, float f2, float f3, int i2) {
        this.f27129k.setColor(i2);
        canvas.drawText(str, f2, f3, this.f27129k);
    }

    public void a(Canvas canvas, d[] dVarArr) {
        boolean z2;
        float[] fArr;
        float f2;
        e eVar;
        float f3;
        int i2;
        RectF rectF;
        float f4;
        fc.i b2;
        float f5;
        int i3;
        int i4;
        float f6;
        float[] fArr2;
        float f7;
        float f8;
        d[] dVarArr2 = dVarArr;
        boolean z3 = this.f27157a.d() && !this.f27157a.c();
        if (!z3 || !this.f27157a.g()) {
            float b3 = this.f27125g.b();
            float a2 = this.f27125g.a();
            float rotationAngle = this.f27157a.getRotationAngle();
            float[] drawAngles = this.f27157a.getDrawAngles();
            float[] absoluteAngles = this.f27157a.getAbsoluteAngles();
            e centerCircleBox = this.f27157a.getCenterCircleBox();
            float radius = this.f27157a.getRadius();
            float holeRadius = z3 ? (this.f27157a.getHoleRadius() / 100.0f) * radius : 0.0f;
            RectF rectF2 = this.f27164m;
            rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
            int i5 = 0;
            while (i5 < dVarArr2.length) {
                int a3 = (int) dVarArr2[i5].a();
                if (a3 < drawAngles.length && (b2 = ((com.github.mikephil.charting.data.m) this.f27157a.getData()).a(dVarArr2[i5].f())) != null && b2.g()) {
                    int u2 = b2.u();
                    int i6 = 0;
                    for (int i7 = 0; i7 < u2; i7++) {
                        if (Math.abs(((PieEntry) b2.d(i7)).b()) > i.f27245b) {
                            i6++;
                        }
                    }
                    if (a3 == 0) {
                        i3 = 1;
                        f5 = 0.0f;
                    } else {
                        f5 = absoluteAngles[a3 - 1] * b3;
                        i3 = 1;
                    }
                    float a4 = i6 <= i3 ? 0.0f : b2.a();
                    float f9 = drawAngles[a3];
                    float B = b2.B();
                    int i8 = i5;
                    float f10 = radius + B;
                    float f11 = holeRadius;
                    rectF2.set(this.f27157a.getCircleBox());
                    float f12 = -B;
                    rectF2.inset(f12, f12);
                    boolean z4 = a4 > 0.0f && f9 <= 180.0f;
                    this.f27126h.setColor(b2.a(a3));
                    float f13 = i6 == 1 ? 0.0f : a4 / (radius * 0.017453292f);
                    float f14 = i6 == 1 ? 0.0f : a4 / (f10 * 0.017453292f);
                    float f15 = rotationAngle + (((f13 / 2.0f) + f5) * a2);
                    float f16 = (f9 - f13) * a2;
                    float f17 = f16 < 0.0f ? 0.0f : f16;
                    float f18 = (((f14 / 2.0f) + f5) * a2) + rotationAngle;
                    float f19 = (f9 - f14) * a2;
                    if (f19 < 0.0f) {
                        f19 = 0.0f;
                    }
                    this.f27171u.reset();
                    if (f17 < 360.0f || f17 % 360.0f > i.f27245b) {
                        fArr2 = drawAngles;
                        f6 = f5;
                        double d2 = (double) (f18 * 0.017453292f);
                        i4 = i6;
                        z2 = z3;
                        this.f27171u.moveTo(centerCircleBox.f27222a + (((float) Math.cos(d2)) * f10), centerCircleBox.f27223b + (f10 * ((float) Math.sin(d2))));
                        this.f27171u.arcTo(rectF2, f18, f19);
                    } else {
                        this.f27171u.addCircle(centerCircleBox.f27222a, centerCircleBox.f27223b, f10, Path.Direction.CW);
                        fArr2 = drawAngles;
                        f6 = f5;
                        i4 = i6;
                        z2 = z3;
                    }
                    if (z4) {
                        double d3 = (double) (f15 * 0.017453292f);
                        i2 = i8;
                        rectF = rectF2;
                        f3 = f11;
                        eVar = centerCircleBox;
                        fArr = fArr2;
                        f7 = a(centerCircleBox, radius, f9 * a2, (((float) Math.cos(d3)) * radius) + centerCircleBox.f27222a, centerCircleBox.f27223b + (((float) Math.sin(d3)) * radius), f15, f17);
                    } else {
                        rectF = rectF2;
                        eVar = centerCircleBox;
                        i2 = i8;
                        f3 = f11;
                        fArr = fArr2;
                        f7 = 0.0f;
                    }
                    this.f27172v.set(eVar.f27222a - f3, eVar.f27223b - f3, eVar.f27222a + f3, eVar.f27223b + f3);
                    if (!z2 || (f3 <= 0.0f && !z4)) {
                        f4 = b3;
                        f2 = a2;
                        if (f17 % 360.0f > i.f27245b) {
                            if (z4) {
                                double d4 = (double) ((f15 + (f17 / 2.0f)) * 0.017453292f);
                                this.f27171u.lineTo(eVar.f27222a + (((float) Math.cos(d4)) * f7), eVar.f27223b + (f7 * ((float) Math.sin(d4))));
                            } else {
                                this.f27171u.lineTo(eVar.f27222a, eVar.f27223b);
                            }
                        }
                    } else {
                        if (z4) {
                            if (f7 < 0.0f) {
                                f7 = -f7;
                            }
                            f8 = Math.max(f3, f7);
                        } else {
                            f8 = f3;
                        }
                        float f20 = (i4 == 1 || f8 == 0.0f) ? 0.0f : a4 / (f8 * 0.017453292f);
                        float f21 = ((f6 + (f20 / 2.0f)) * a2) + rotationAngle;
                        float f22 = (f9 - f20) * a2;
                        if (f22 < 0.0f) {
                            f22 = 0.0f;
                        }
                        float f23 = f21 + f22;
                        if (f17 < 360.0f || f17 % 360.0f > i.f27245b) {
                            double d5 = (double) (f23 * 0.017453292f);
                            f4 = b3;
                            f2 = a2;
                            this.f27171u.lineTo(eVar.f27222a + (((float) Math.cos(d5)) * f8), eVar.f27223b + (f8 * ((float) Math.sin(d5))));
                            this.f27171u.arcTo(this.f27172v, f23, -f22);
                        } else {
                            this.f27171u.addCircle(eVar.f27222a, eVar.f27223b, f8, Path.Direction.CCW);
                            f4 = b3;
                            f2 = a2;
                        }
                    }
                    this.f27171u.close();
                    this.f27162f.drawPath(this.f27171u, this.f27126h);
                } else {
                    i2 = i5;
                    rectF = rectF2;
                    f3 = holeRadius;
                    fArr = drawAngles;
                    z2 = z3;
                    f4 = b3;
                    f2 = a2;
                    eVar = centerCircleBox;
                }
                i5 = i2 + 1;
                b3 = f4;
                rectF2 = rectF;
                holeRadius = f3;
                centerCircleBox = eVar;
                a2 = f2;
                drawAngles = fArr;
                z3 = z2;
                dVarArr2 = dVarArr;
            }
            e.b(centerCircleBox);
        }
    }

    public Paint b() {
        return this.f27158b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x03a5  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x03d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.graphics.Canvas r53) {
        /*
            r52 = this;
            r6 = r52
            r7 = r53
            com.github.mikephil.charting.charts.PieChart r0 = r6.f27157a
            fg.e r8 = r0.getCenterCircleBox()
            com.github.mikephil.charting.charts.PieChart r0 = r6.f27157a
            float r9 = r0.getRadius()
            com.github.mikephil.charting.charts.PieChart r0 = r6.f27157a
            float r0 = r0.getRotationAngle()
            com.github.mikephil.charting.charts.PieChart r1 = r6.f27157a
            float[] r10 = r1.getDrawAngles()
            com.github.mikephil.charting.charts.PieChart r1 = r6.f27157a
            float[] r11 = r1.getAbsoluteAngles()
            ex.a r1 = r6.f27125g
            float r12 = r1.b()
            ex.a r1 = r6.f27125g
            float r13 = r1.a()
            com.github.mikephil.charting.charts.PieChart r1 = r6.f27157a
            float r1 = r1.getHoleRadius()
            float r1 = r1 * r9
            r14 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r14
            float r1 = r9 - r1
            r15 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r15
            com.github.mikephil.charting.charts.PieChart r2 = r6.f27157a
            float r2 = r2.getHoleRadius()
            float r16 = r2 / r14
            r2 = 1092616192(0x41200000, float:10.0)
            float r2 = r9 / r2
            r3 = 1080452710(0x40666666, float:3.6)
            float r2 = r2 * r3
            com.github.mikephil.charting.charts.PieChart r3 = r6.f27157a
            boolean r3 = r3.d()
            if (r3 == 0) goto L_0x0086
            float r2 = r9 * r16
            float r2 = r9 - r2
            float r2 = r2 / r15
            com.github.mikephil.charting.charts.PieChart r3 = r6.f27157a
            boolean r3 = r3.c()
            if (r3 != 0) goto L_0x0086
            com.github.mikephil.charting.charts.PieChart r3 = r6.f27157a
            boolean r3 = r3.g()
            if (r3 == 0) goto L_0x0086
            double r3 = (double) r0
            r0 = 1135869952(0x43b40000, float:360.0)
            float r1 = r1 * r0
            double r0 = (double) r1
            r17 = 4618760256179416344(0x401921fb54442d18, double:6.283185307179586)
            double r14 = (double) r9
            java.lang.Double.isNaN(r14)
            double r14 = r14 * r17
            java.lang.Double.isNaN(r0)
            double r0 = r0 / r14
            java.lang.Double.isNaN(r3)
            double r3 = r3 + r0
            float r0 = (float) r3
        L_0x0086:
            r14 = r0
            float r15 = r9 - r2
            com.github.mikephil.charting.charts.PieChart r0 = r6.f27157a
            com.github.mikephil.charting.data.h r0 = r0.getData()
            r17 = r0
            com.github.mikephil.charting.data.m r17 = (com.github.mikephil.charting.data.m) r17
            java.util.List r5 = r17.h()
            float r18 = r17.k()
            com.github.mikephil.charting.charts.PieChart r0 = r6.f27157a
            boolean r21 = r0.f()
            r53.save()
            r0 = 1084227584(0x40a00000, float:5.0)
            float r22 = fg.i.a((float) r0)
            r23 = 0
            r0 = 0
            r4 = 0
        L_0x00ae:
            int r1 = r5.size()
            if (r4 >= r1) goto L_0x042a
            java.lang.Object r1 = r5.get(r4)
            r3 = r1
            fc.i r3 = (fc.i) r3
            boolean r24 = r3.p()
            if (r24 != 0) goto L_0x00dd
            if (r21 != 0) goto L_0x00dd
            r26 = r4
            r28 = r5
            r44 = r9
            r34 = r10
            r36 = r11
            r37 = r12
            r38 = r13
            r40 = r14
            r35 = r15
            r14 = 1073741824(0x40000000, float:2.0)
            r19 = 1120403456(0x42c80000, float:100.0)
            r9 = r7
            r10 = r8
            goto L_0x0414
        L_0x00dd:
            com.github.mikephil.charting.data.PieDataSet$ValuePosition r2 = r3.C()
            com.github.mikephil.charting.data.PieDataSet$ValuePosition r1 = r3.D()
            r6.b((fc.e) r3)
            r25 = r0
            android.graphics.Paint r0 = r6.f27129k
            r26 = r4
            java.lang.String r4 = "Q"
            int r0 = fg.i.b((android.graphics.Paint) r0, (java.lang.String) r4)
            float r0 = (float) r0
            r4 = 1082130432(0x40800000, float:4.0)
            float r4 = fg.i.a((float) r4)
            float r27 = r0 + r4
            ez.d r4 = r3.h()
            int r0 = r3.u()
            r28 = r5
            android.graphics.Paint r5 = r6.f27160d
            int r7 = r3.F()
            r5.setColor(r7)
            android.graphics.Paint r5 = r6.f27160d
            float r7 = r3.G()
            float r7 = fg.i.a((float) r7)
            r5.setStrokeWidth(r7)
            float r7 = r6.a((fc.i) r3)
            fg.e r5 = r3.r()
            fg.e r5 = fg.e.a((fg.e) r5)
            r29 = r8
            float r8 = r5.f27222a
            float r8 = fg.i.a((float) r8)
            r5.f27222a = r8
            float r8 = r5.f27223b
            float r8 = fg.i.a((float) r8)
            r5.f27223b = r8
            r8 = 0
        L_0x013c:
            if (r8 >= r0) goto L_0x03f8
            com.github.mikephil.charting.data.Entry r30 = r3.d(r8)
            r31 = r5
            r5 = r30
            com.github.mikephil.charting.data.PieEntry r5 = (com.github.mikephil.charting.data.PieEntry) r5
            if (r25 != 0) goto L_0x014d
            r30 = 0
            goto L_0x0153
        L_0x014d:
            int r30 = r25 + -1
            r30 = r11[r30]
            float r30 = r30 * r12
        L_0x0153:
            r32 = r10[r25]
            r33 = 1016003125(0x3c8efa35, float:0.017453292)
            float r34 = r15 * r33
            float r34 = r7 / r34
            r20 = 1073741824(0x40000000, float:2.0)
            float r34 = r34 / r20
            float r32 = r32 - r34
            float r32 = r32 / r20
            float r30 = r30 + r32
            float r30 = r30 * r13
            r32 = r0
            float r0 = r14 + r30
            r30 = r7
            com.github.mikephil.charting.charts.PieChart r7 = r6.f27157a
            boolean r7 = r7.i()
            if (r7 == 0) goto L_0x0181
            float r7 = r5.b()
            float r7 = r7 / r18
            r19 = 1120403456(0x42c80000, float:100.0)
            float r7 = r7 * r19
            goto L_0x0185
        L_0x0181:
            float r7 = r5.b()
        L_0x0185:
            java.lang.String r7 = r4.a((float) r7, (com.github.mikephil.charting.data.PieEntry) r5)
            r34 = r10
            java.lang.String r10 = r5.a()
            r35 = r4
            float r4 = r0 * r33
            r33 = r5
            double r4 = (double) r4
            r36 = r11
            r37 = r12
            double r11 = java.lang.Math.cos(r4)
            float r11 = (float) r11
            r38 = r13
            double r12 = java.lang.Math.sin(r4)
            float r12 = (float) r12
            if (r21 == 0) goto L_0x01ae
            com.github.mikephil.charting.data.PieDataSet$ValuePosition r13 = com.github.mikephil.charting.data.PieDataSet.ValuePosition.OUTSIDE_SLICE
            if (r2 != r13) goto L_0x01ae
            r13 = 1
            goto L_0x01af
        L_0x01ae:
            r13 = 0
        L_0x01af:
            r40 = r14
            if (r24 == 0) goto L_0x01b9
            com.github.mikephil.charting.data.PieDataSet$ValuePosition r14 = com.github.mikephil.charting.data.PieDataSet.ValuePosition.OUTSIDE_SLICE
            if (r1 != r14) goto L_0x01b9
            r14 = 1
            goto L_0x01ba
        L_0x01b9:
            r14 = 0
        L_0x01ba:
            r41 = r10
            if (r21 == 0) goto L_0x01c4
            com.github.mikephil.charting.data.PieDataSet$ValuePosition r10 = com.github.mikephil.charting.data.PieDataSet.ValuePosition.INSIDE_SLICE
            if (r2 != r10) goto L_0x01c4
            r10 = 1
            goto L_0x01c5
        L_0x01c4:
            r10 = 0
        L_0x01c5:
            r42 = r2
            if (r24 == 0) goto L_0x01d0
            com.github.mikephil.charting.data.PieDataSet$ValuePosition r2 = com.github.mikephil.charting.data.PieDataSet.ValuePosition.INSIDE_SLICE
            if (r1 != r2) goto L_0x01d0
            r39 = 1
            goto L_0x01d2
        L_0x01d0:
            r39 = 0
        L_0x01d2:
            if (r13 != 0) goto L_0x01f4
            if (r14 == 0) goto L_0x01d7
            goto L_0x01f4
        L_0x01d7:
            r45 = r1
            r44 = r9
            r47 = r10
            r46 = r11
            r50 = r29
            r51 = r31
            r31 = r33
            r48 = r35
            r11 = r41
            r19 = 1120403456(0x42c80000, float:100.0)
            r9 = r53
            r29 = r12
            r35 = r15
            r15 = r3
            goto L_0x0332
        L_0x01f4:
            float r2 = r3.I()
            float r43 = r3.J()
            float r44 = r3.H()
            r19 = 1120403456(0x42c80000, float:100.0)
            float r44 = r44 / r19
            r45 = r1
            com.github.mikephil.charting.charts.PieChart r1 = r6.f27157a
            boolean r1 = r1.d()
            if (r1 == 0) goto L_0x0217
            float r1 = r9 * r16
            float r46 = r9 - r1
            float r46 = r46 * r44
            float r46 = r46 + r1
            goto L_0x0219
        L_0x0217:
            float r46 = r9 * r44
        L_0x0219:
            boolean r1 = r3.K()
            float r43 = r43 * r15
            if (r1 == 0) goto L_0x022c
            double r4 = java.lang.Math.sin(r4)
            double r4 = java.lang.Math.abs(r4)
            float r1 = (float) r4
            float r43 = r43 * r1
        L_0x022c:
            float r1 = r46 * r11
            r5 = r29
            float r4 = r5.f27222a
            float r1 = r1 + r4
            float r46 = r46 * r12
            float r4 = r5.f27223b
            float r4 = r46 + r4
            r29 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 + r29
            float r2 = r2 * r15
            float r29 = r2 * r11
            r44 = r9
            float r9 = r5.f27222a
            float r9 = r29 + r9
            float r2 = r2 * r12
            r29 = r12
            float r12 = r5.f27223b
            float r12 = r12 + r2
            r47 = r10
            r46 = r11
            double r10 = (double) r0
            r48 = 4645040803167600640(0x4076800000000000, double:360.0)
            java.lang.Double.isNaN(r10)
            double r10 = r10 % r48
            r48 = 4636033603912859648(0x4056800000000000, double:90.0)
            int r0 = (r10 > r48 ? 1 : (r10 == r48 ? 0 : -1))
            if (r0 < 0) goto L_0x0287
            r48 = 4643457506423603200(0x4070e00000000000, double:270.0)
            int r0 = (r10 > r48 ? 1 : (r10 == r48 ? 0 : -1))
            if (r0 > 0) goto L_0x0287
            float r0 = r9 - r43
            android.graphics.Paint r2 = r6.f27129k
            android.graphics.Paint$Align r10 = android.graphics.Paint.Align.RIGHT
            r2.setTextAlign(r10)
            if (r13 == 0) goto L_0x0281
            android.graphics.Paint r2 = r6.f27166p
            android.graphics.Paint$Align r10 = android.graphics.Paint.Align.RIGHT
            r2.setTextAlign(r10)
        L_0x0281:
            float r2 = r0 - r22
            r43 = r0
            r10 = r2
            goto L_0x029c
        L_0x0287:
            float r43 = r9 + r43
            android.graphics.Paint r0 = r6.f27129k
            android.graphics.Paint$Align r2 = android.graphics.Paint.Align.LEFT
            r0.setTextAlign(r2)
            if (r13 == 0) goto L_0x0299
            android.graphics.Paint r0 = r6.f27166p
            android.graphics.Paint$Align r2 = android.graphics.Paint.Align.LEFT
            r0.setTextAlign(r2)
        L_0x0299:
            float r0 = r43 + r22
            r10 = r0
        L_0x029c:
            int r0 = r3.F()
            r2 = 1122867(0x112233, float:1.573472E-39)
            if (r0 == r2) goto L_0x02d5
            boolean r0 = r3.E()
            if (r0 == 0) goto L_0x02b4
            android.graphics.Paint r0 = r6.f27160d
            int r2 = r3.a((int) r8)
            r0.setColor(r2)
        L_0x02b4:
            android.graphics.Paint r11 = r6.f27160d
            r0 = r53
            r2 = r4
            r4 = r3
            r3 = r9
            r48 = r35
            r35 = r15
            r15 = r4
            r4 = r12
            r50 = r5
            r51 = r31
            r31 = r33
            r5 = r11
            r0.drawLine(r1, r2, r3, r4, r5)
            android.graphics.Paint r5 = r6.f27160d
            r1 = r9
            r2 = r12
            r3 = r43
            r0.drawLine(r1, r2, r3, r4, r5)
            goto L_0x02e0
        L_0x02d5:
            r50 = r5
            r51 = r31
            r31 = r33
            r48 = r35
            r35 = r15
            r15 = r3
        L_0x02e0:
            if (r13 == 0) goto L_0x0306
            if (r14 == 0) goto L_0x0306
            int r5 = r15.c(r8)
            r0 = r52
            r1 = r53
            r2 = r7
            r3 = r10
            r4 = r12
            r0.a(r1, r2, r3, r4, r5)
            int r0 = r17.i()
            if (r8 >= r0) goto L_0x0301
            if (r41 == 0) goto L_0x0301
            float r12 = r12 + r27
            r9 = r53
            r11 = r41
            goto L_0x0319
        L_0x0301:
            r9 = r53
            r11 = r41
            goto L_0x0332
        L_0x0306:
            r9 = r53
            r11 = r41
            if (r13 == 0) goto L_0x031d
            int r0 = r17.i()
            if (r8 >= r0) goto L_0x0332
            if (r11 == 0) goto L_0x0332
            r0 = 1073741824(0x40000000, float:2.0)
            float r1 = r27 / r0
            float r12 = r12 + r1
        L_0x0319:
            r6.a(r9, r11, r10, r12)
            goto L_0x0332
        L_0x031d:
            r0 = 1073741824(0x40000000, float:2.0)
            if (r14 == 0) goto L_0x0332
            float r1 = r27 / r0
            float r4 = r12 + r1
            int r5 = r15.c(r8)
            r0 = r52
            r1 = r53
            r2 = r7
            r3 = r10
            r0.a(r1, r2, r3, r4, r5)
        L_0x0332:
            if (r47 != 0) goto L_0x033c
            if (r39 == 0) goto L_0x0337
            goto L_0x033c
        L_0x0337:
            r10 = r50
        L_0x0339:
            r14 = 1073741824(0x40000000, float:2.0)
            goto L_0x0399
        L_0x033c:
            float r0 = r35 * r46
            r10 = r50
            float r1 = r10.f27222a
            float r12 = r0 + r1
            float r0 = r35 * r29
            float r1 = r10.f27223b
            float r13 = r0 + r1
            android.graphics.Paint r0 = r6.f27129k
            android.graphics.Paint$Align r1 = android.graphics.Paint.Align.CENTER
            r0.setTextAlign(r1)
            if (r47 == 0) goto L_0x0371
            if (r39 == 0) goto L_0x0371
            int r5 = r15.c(r8)
            r0 = r52
            r1 = r53
            r2 = r7
            r3 = r12
            r4 = r13
            r0.a(r1, r2, r3, r4, r5)
            int r0 = r17.i()
            if (r8 >= r0) goto L_0x0339
            if (r11 == 0) goto L_0x0339
            float r13 = r13 + r27
            r6.a(r9, r11, r12, r13)
            goto L_0x0339
        L_0x0371:
            if (r47 == 0) goto L_0x0384
            int r0 = r17.i()
            if (r8 >= r0) goto L_0x0339
            if (r11 == 0) goto L_0x0339
            r14 = 1073741824(0x40000000, float:2.0)
            float r0 = r27 / r14
            float r13 = r13 + r0
            r6.a(r9, r11, r12, r13)
            goto L_0x0399
        L_0x0384:
            r14 = 1073741824(0x40000000, float:2.0)
            if (r39 == 0) goto L_0x0399
            float r0 = r27 / r14
            float r4 = r13 + r0
            int r5 = r15.c(r8)
            r0 = r52
            r1 = r53
            r2 = r7
            r3 = r12
            r0.a(r1, r2, r3, r4, r5)
        L_0x0399:
            android.graphics.drawable.Drawable r0 = r31.g()
            if (r0 == 0) goto L_0x03d4
            boolean r0 = r15.q()
            if (r0 == 0) goto L_0x03d4
            android.graphics.drawable.Drawable r1 = r31.g()
            r7 = r51
            float r0 = r7.f27223b
            float r0 = r35 + r0
            float r0 = r0 * r46
            float r2 = r10.f27222a
            float r0 = r0 + r2
            float r2 = r7.f27223b
            float r2 = r35 + r2
            float r2 = r2 * r29
            float r3 = r10.f27223b
            float r2 = r2 + r3
            float r3 = r7.f27222a
            float r2 = r2 + r3
            int r3 = (int) r0
            int r4 = (int) r2
            int r5 = r1.getIntrinsicWidth()
            int r11 = r1.getIntrinsicHeight()
            r0 = r53
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r11
            fg.i.a(r0, r1, r2, r3, r4, r5)
            goto L_0x03d6
        L_0x03d4:
            r7 = r51
        L_0x03d6:
            int r25 = r25 + 1
            int r8 = r8 + 1
            r5 = r7
            r29 = r10
            r3 = r15
            r7 = r30
            r0 = r32
            r10 = r34
            r15 = r35
            r11 = r36
            r12 = r37
            r13 = r38
            r14 = r40
            r2 = r42
            r9 = r44
            r1 = r45
            r4 = r48
            goto L_0x013c
        L_0x03f8:
            r7 = r5
            r44 = r9
            r34 = r10
            r36 = r11
            r37 = r12
            r38 = r13
            r40 = r14
            r35 = r15
            r10 = r29
            r14 = 1073741824(0x40000000, float:2.0)
            r19 = 1120403456(0x42c80000, float:100.0)
            r9 = r53
            fg.e.b(r7)
            r0 = r25
        L_0x0414:
            int r4 = r26 + 1
            r7 = r9
            r8 = r10
            r5 = r28
            r10 = r34
            r15 = r35
            r11 = r36
            r12 = r37
            r13 = r38
            r14 = r40
            r9 = r44
            goto L_0x00ae
        L_0x042a:
            r9 = r7
            r10 = r8
            fg.e.b(r10)
            r53.restore()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.m.b(android.graphics.Canvas):void");
    }

    public Paint c() {
        return this.f27159c;
    }

    public void c(Canvas canvas) {
        d(canvas);
        canvas.drawBitmap((Bitmap) this.f27161e.get(), 0.0f, 0.0f, (Paint) null);
        e(canvas);
    }

    public TextPaint d() {
        return this.f27165n;
    }

    /* access modifiers changed from: protected */
    public void d(Canvas canvas) {
        if (this.f27157a.d() && this.f27162f != null) {
            float radius = this.f27157a.getRadius();
            float holeRadius = (this.f27157a.getHoleRadius() / 100.0f) * radius;
            e centerCircleBox = this.f27157a.getCenterCircleBox();
            if (Color.alpha(this.f27158b.getColor()) > 0) {
                this.f27162f.drawCircle(centerCircleBox.f27222a, centerCircleBox.f27223b, holeRadius, this.f27158b);
            }
            if (Color.alpha(this.f27159c.getColor()) > 0 && this.f27157a.getTransparentCircleRadius() > this.f27157a.getHoleRadius()) {
                int alpha = this.f27159c.getAlpha();
                float transparentCircleRadius = radius * (this.f27157a.getTransparentCircleRadius() / 100.0f);
                this.f27159c.setAlpha((int) (((float) alpha) * this.f27125g.b() * this.f27125g.a()));
                this.f27173w.reset();
                this.f27173w.addCircle(centerCircleBox.f27222a, centerCircleBox.f27223b, transparentCircleRadius, Path.Direction.CW);
                this.f27173w.addCircle(centerCircleBox.f27222a, centerCircleBox.f27223b, holeRadius, Path.Direction.CCW);
                this.f27162f.drawPath(this.f27173w, this.f27159c);
                this.f27159c.setAlpha(alpha);
            }
            e.b(centerCircleBox);
        }
    }

    public Paint e() {
        return this.f27166p;
    }

    /* access modifiers changed from: protected */
    public void e(Canvas canvas) {
        e eVar;
        Canvas canvas2 = canvas;
        CharSequence centerText = this.f27157a.getCenterText();
        if (this.f27157a.e() && centerText != null) {
            e centerCircleBox = this.f27157a.getCenterCircleBox();
            e centerTextOffset = this.f27157a.getCenterTextOffset();
            float f2 = centerCircleBox.f27222a + centerTextOffset.f27222a;
            float f3 = centerCircleBox.f27223b + centerTextOffset.f27223b;
            float radius = (!this.f27157a.d() || this.f27157a.c()) ? this.f27157a.getRadius() : this.f27157a.getRadius() * (this.f27157a.getHoleRadius() / 100.0f);
            RectF rectF = this.f27170t[0];
            rectF.left = f2 - radius;
            rectF.top = f3 - radius;
            rectF.right = f2 + radius;
            rectF.bottom = f3 + radius;
            RectF rectF2 = this.f27170t[1];
            rectF2.set(rectF);
            float centerTextRadiusPercent = this.f27157a.getCenterTextRadiusPercent() / 100.0f;
            if (((double) centerTextRadiusPercent) > i.f27244a) {
                rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
            }
            if (!centerText.equals(this.f27168r) || !rectF2.equals(this.f27169s)) {
                this.f27169s.set(rectF2);
                this.f27168r = centerText;
                eVar = centerTextOffset;
                StaticLayout staticLayout = r3;
                StaticLayout staticLayout2 = new StaticLayout(centerText, 0, centerText.length(), this.f27165n, (int) Math.max(Math.ceil((double) this.f27169s.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                this.f27167q = staticLayout;
            } else {
                eVar = centerTextOffset;
            }
            float height = (float) this.f27167q.getHeight();
            canvas.save();
            if (Build.VERSION.SDK_INT >= 18) {
                Path path = this.f27163l;
                path.reset();
                path.addOval(rectF, Path.Direction.CW);
                canvas2.clipPath(path);
            }
            canvas2.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
            this.f27167q.draw(canvas2);
            canvas.restore();
            e.b(centerCircleBox);
            e.b(eVar);
        }
    }

    public void f() {
        Canvas canvas = this.f27162f;
        if (canvas != null) {
            canvas.setBitmap((Bitmap) null);
            this.f27162f = null;
        }
        WeakReference<Bitmap> weakReference = this.f27161e;
        if (weakReference != null) {
            Bitmap bitmap = (Bitmap) weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f27161e.clear();
            this.f27161e = null;
        }
    }
}
