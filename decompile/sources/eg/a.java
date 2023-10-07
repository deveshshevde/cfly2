package eg;

import com.flypro.core.polygon.Polygon;
import ej.b;
import ej.c;
import fg.i;
import java.util.List;

public class a {
    private static double a(double d2, double d3, double d4, double d5) {
        double d6 = d3 - d5;
        double d7 = d2 * d4;
        return Math.atan2(Math.sin(d6) * d7, (d7 * Math.cos(d6)) + 1.0d) * 2.0d;
    }

    public static ef.a a(ef.a aVar, double d2, double d3) {
        double d4 = aVar.d();
        double c2 = aVar.c();
        double radians = Math.toRadians(d4);
        double radians2 = Math.toRadians(c2);
        double radians3 = Math.toRadians(d2);
        double d5 = d3 / 6371000.0d;
        double asin = Math.asin((Math.sin(radians) * Math.cos(d5)) + (Math.cos(radians) * Math.sin(d5) * Math.cos(radians3)));
        return new ef.a(Math.toDegrees(asin), Math.toDegrees(radians2 + Math.atan2(Math.sin(radians3) * Math.sin(d5) * Math.cos(radians), Math.cos(d5) - (Math.sin(radians) * Math.sin(asin)))));
    }

    public static ef.a a(ef.a aVar, ef.a aVar2, int i2) {
        return a(aVar, d(aVar, aVar2), (double) i2);
    }

    public static b a(Polygon polygon) {
        List<ef.a> a2 = polygon.a();
        int size = a2.size();
        double d2 = i.f27244a;
        if (size < 3) {
            return new b(i.f27244a);
        }
        ef.a aVar = a2.get(size - 1);
        double tan = Math.tan((1.5707963267948966d - Math.toRadians(aVar.d())) / 2.0d);
        double radians = Math.toRadians(aVar.c());
        double d3 = tan;
        double d4 = radians;
        for (ef.a next : a2) {
            double tan2 = Math.tan((1.5707963267948966d - Math.toRadians(next.d())) / 2.0d);
            double radians2 = Math.toRadians(next.c());
            d2 += a(tan2, radians2, d3, d4);
            d3 = tan2;
            d4 = radians2;
        }
        return new b(Math.abs(d2 * 4.0589641E13d));
    }

    public static Double a(double d2) {
        return Double.valueOf(Math.toDegrees(d2 / 6371000.0d));
    }

    public static Double a(ef.a aVar, ef.a aVar2) {
        return Double.valueOf(Math.hypot(aVar.a() - aVar2.a(), aVar.b() - aVar2.b()));
    }

    static double b(ef.a aVar, ef.a aVar2) {
        double radians = Math.toRadians(aVar.d() - aVar2.d());
        double radians2 = Math.toRadians(aVar.c() - aVar2.c());
        double sin = Math.sin(radians * 0.5d);
        double sin2 = Math.sin(radians2 * 0.5d);
        return Math.toDegrees(Math.asin(Math.sqrt((sin * sin) + (Math.cos(Math.toRadians(aVar.d())) * Math.cos(Math.toRadians(aVar2.d())) * sin2 * sin2))) * 2.0d);
    }

    public static ef.a b(ef.a aVar, double d2, double d3) {
        double c2 = aVar.c();
        double d4 = aVar.d();
        double radians = Math.toRadians(c2);
        return new ef.a(Math.toDegrees(Math.toRadians(d4) + Math.toRadians(a(d3).doubleValue())), Math.toDegrees(radians + Math.toRadians(a(d2).doubleValue())));
    }

    public static Double b(double d2) {
        return Double.valueOf(Math.toRadians(d2) * 6371000.0d);
    }

    public static double c(double d2) {
        return d2 >= i.f27244a ? d2 : d2 + 360.0d;
    }

    public static c c(ef.a aVar, ef.a aVar2) {
        return new c(Math.toRadians(b(aVar, aVar2)) * 6371000.0d);
    }

    public static double d(ef.a aVar, ef.a aVar2) {
        double radians = Math.toRadians(aVar.d());
        double radians2 = Math.toRadians(aVar.c());
        double radians3 = Math.toRadians(aVar2.d());
        double radians4 = Math.toRadians(aVar2.c()) - radians2;
        return c(Math.toDegrees(Math.atan2(Math.sin(radians4) * Math.cos(radians3), (Math.cos(radians) * Math.sin(radians3)) - ((Math.sin(radians) * Math.cos(radians3)) * Math.cos(radians4)))));
    }
}
