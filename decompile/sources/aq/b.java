package aq;

public class b {
    public static double a(a aVar, a aVar2) {
        double radians = Math.toRadians(aVar.b() - aVar2.b());
        double radians2 = Math.toRadians(aVar.a() - aVar2.a());
        double sin = Math.sin(radians * 0.5d);
        double sin2 = Math.sin(radians2 * 0.5d);
        return Math.toDegrees(Math.asin(Math.sqrt((sin * sin) + (Math.cos(Math.toRadians(aVar.b())) * Math.cos(Math.toRadians(aVar2.b())) * sin2 * sin2))) * 2.0d);
    }

    public static c b(a aVar, a aVar2) {
        return new c(Math.toRadians(a(aVar, aVar2)) * 6378137.0d);
    }
}
