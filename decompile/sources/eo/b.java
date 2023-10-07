package eo;

import ef.a;
import ej.c;
import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f26939a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private double f26940b;

    public b(a aVar, a aVar2, double d2, double d3, double d4, double d5) {
        double doubleValue = aVar.a().doubleValue() / 2.0d;
        double doubleValue2 = aVar.b().doubleValue() / 2.0d;
        double doubleValue3 = aVar.f26935e.doubleValue();
        double[][] b2 = ei.a.b(Math.toRadians(d3), Math.toRadians((-d4) + 180.0d), Math.toRadians(-d5));
        List<a> list = this.f26939a;
        double d6 = -doubleValue;
        double d7 = -doubleValue2;
        a aVar3 = new a(d6, d7);
        double[][] dArr = b2;
        double d8 = doubleValue2;
        double d9 = d7;
        double d10 = d2;
        double d11 = d6;
        double d12 = doubleValue3;
        List<a> list2 = list;
        a aVar4 = aVar2;
        list2.add(a(aVar3, dArr, d10, d12, aVar4));
        this.f26939a.add(a(new a(doubleValue, d9), dArr, d10, d12, aVar4));
        double d13 = d8;
        this.f26939a.add(a(new a(doubleValue, d13), dArr, d10, d12, aVar4));
        this.f26939a.add(a(new a(d11, d13), b2, d2, d12, aVar4));
        this.f26940b = ((a().a() * 0.001d) * (d13 / doubleValue)) / Math.sqrt(aVar.f26934d.doubleValue());
    }

    private static a a(a aVar, double[][] dArr, double d2, double d3, a aVar2) {
        double d4 = -d3;
        return eg.a.b(aVar2, ((((dArr[0][0] * aVar.a()) + (dArr[1][0] * aVar.b())) + (dArr[2][0] * d4)) * d2) / (((dArr[0][2] * aVar.a()) + (dArr[1][2] * aVar.b())) + (dArr[2][2] * d4)), (d2 * (((dArr[0][1] * aVar.a()) + (dArr[1][1] * aVar.b())) + (dArr[2][1] * d4))) / (((dArr[0][2] * aVar.a()) + (dArr[1][2] * aVar.b())) + (dArr[2][2] * d4)));
    }

    public c a() {
        return new c((eg.a.c(this.f26939a.get(0), this.f26939a.get(1)).a() + eg.a.c(this.f26939a.get(2), this.f26939a.get(3)).a()) / 2.0d);
    }

    public List<a> b() {
        return this.f26939a;
    }
}
