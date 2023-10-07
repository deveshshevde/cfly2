package gw;

public class e extends d {

    /* renamed from: a  reason: collision with root package name */
    float f13138a = -1.0f;

    public void a(o oVar, float f2, float f3, float f4) {
        oVar.a(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        double sin = Math.sin(Math.toRadians((double) f2));
        double d2 = (double) f4;
        Double.isNaN(d2);
        double d3 = (double) f3;
        Double.isNaN(d3);
        double sin2 = Math.sin(Math.toRadians((double) (90.0f - f2)));
        Double.isNaN(d2);
        Double.isNaN(d3);
        oVar.b((float) (sin * d2 * d3), (float) (sin2 * d2 * d3));
    }
}
