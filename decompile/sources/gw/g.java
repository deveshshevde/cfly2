package gw;

public final class g extends f {

    /* renamed from: a  reason: collision with root package name */
    private final float f13139a;

    public g(float f2) {
        this.f13139a = f2 - 0.001f;
    }

    public void a(float f2, float f3, float f4, o oVar) {
        double d2 = (double) this.f13139a;
        double sqrt = Math.sqrt(2.0d);
        Double.isNaN(d2);
        float f5 = (float) ((d2 * sqrt) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow((double) this.f13139a, 2.0d) - Math.pow((double) f5, 2.0d));
        double d3 = (double) this.f13139a;
        double sqrt3 = Math.sqrt(2.0d);
        Double.isNaN(d3);
        double d4 = d3 * sqrt3;
        double d5 = (double) this.f13139a;
        Double.isNaN(d5);
        oVar.a(f3 - f5, ((float) (-(d4 - d5))) + sqrt2);
        double d6 = (double) this.f13139a;
        double sqrt4 = Math.sqrt(2.0d);
        Double.isNaN(d6);
        double d7 = d6 * sqrt4;
        double d8 = (double) this.f13139a;
        Double.isNaN(d8);
        oVar.b(f3, (float) (-(d7 - d8)));
        double d9 = (double) this.f13139a;
        double sqrt5 = Math.sqrt(2.0d);
        Double.isNaN(d9);
        double d10 = d9 * sqrt5;
        double d11 = (double) this.f13139a;
        Double.isNaN(d11);
        oVar.b(f3 + f5, ((float) (-(d10 - d11))) + sqrt2);
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return true;
    }
}
