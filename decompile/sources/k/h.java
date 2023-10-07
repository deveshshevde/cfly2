package k;

import androidx.constraintlayout.motion.widget.g;
import androidx.constraintlayout.motion.widget.r;

public class h {

    /* renamed from: g  reason: collision with root package name */
    private static String f29945g = "VelocityMatrix";

    /* renamed from: a  reason: collision with root package name */
    float f29946a;

    /* renamed from: b  reason: collision with root package name */
    float f29947b;

    /* renamed from: c  reason: collision with root package name */
    float f29948c;

    /* renamed from: d  reason: collision with root package name */
    float f29949d;

    /* renamed from: e  reason: collision with root package name */
    float f29950e;

    /* renamed from: f  reason: collision with root package name */
    float f29951f;

    public void a() {
        this.f29950e = 0.0f;
        this.f29949d = 0.0f;
        this.f29948c = 0.0f;
        this.f29947b = 0.0f;
        this.f29946a = 0.0f;
    }

    public void a(float f2, float f3, int i2, int i3, float[] fArr) {
        int i4 = i2;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = (f2 - 0.5f) * 2.0f;
        float f7 = (f3 - 0.5f) * 2.0f;
        float f8 = f4 + this.f29948c;
        float f9 = f5 + this.f29949d;
        float f10 = f8 + (this.f29946a * f6);
        float f11 = f9 + (this.f29947b * f7);
        float radians = (float) Math.toRadians((double) this.f29950e);
        double d2 = (double) (((float) (-i4)) * f6);
        double radians2 = (double) ((float) Math.toRadians((double) this.f29951f));
        double sin = Math.sin(radians2);
        Double.isNaN(d2);
        double d3 = d2 * sin;
        double d4 = (double) (((float) i3) * f7);
        double cos = Math.cos(radians2);
        Double.isNaN(d4);
        float f12 = f10 + (((float) (d3 - (cos * d4))) * radians);
        double d5 = (double) (((float) i4) * f6);
        double cos2 = Math.cos(radians2);
        Double.isNaN(d5);
        double d6 = d5 * cos2;
        double sin2 = Math.sin(radians2);
        Double.isNaN(d4);
        fArr[0] = f12;
        fArr[1] = f11 + (radians * ((float) (d6 - (d4 * sin2))));
    }

    public void a(g gVar, float f2) {
        if (gVar != null) {
            this.f29950e = gVar.b(f2);
        }
    }

    public void a(g gVar, g gVar2, float f2) {
        if (gVar != null) {
            this.f29948c = gVar.b(f2);
        }
        if (gVar2 != null) {
            this.f29949d = gVar2.b(f2);
        }
    }

    public void a(r rVar, float f2) {
        if (rVar != null) {
            this.f29950e = rVar.b(f2);
            this.f29951f = rVar.a(f2);
        }
    }

    public void a(r rVar, r rVar2, float f2) {
        if (rVar != null) {
            this.f29948c = rVar.b(f2);
        }
        if (rVar2 != null) {
            this.f29949d = rVar2.b(f2);
        }
    }

    public void b(g gVar, g gVar2, float f2) {
        if (gVar != null || gVar2 != null) {
            if (gVar == null) {
                this.f29946a = gVar.b(f2);
            }
            if (gVar2 == null) {
                this.f29947b = gVar2.b(f2);
            }
        }
    }

    public void b(r rVar, r rVar2, float f2) {
        if (rVar != null) {
            this.f29946a = rVar.b(f2);
        }
        if (rVar2 != null) {
            this.f29947b = rVar2.b(f2);
        }
    }
}
