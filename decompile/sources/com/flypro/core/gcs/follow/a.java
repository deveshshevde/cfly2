package com.flypro.core.gcs.follow;

import android.content.Context;
import aq.d;
import com.flypro.core.gcs.follow.FollowAlgorithm;
import ej.c;
import fg.i;

public class a extends FollowAlgorithm {
    public a(Context context, en.a aVar, c cVar) {
        super(context, aVar, cVar);
        d.a(context.getApplicationContext());
    }

    private double a(double d2) {
        return ((d2 < i.f27244a || d2 > 90.0d) && (d2 < 180.0d || d2 > 270.0d)) ? ((d2 <= 90.0d || d2 >= 180.0d) && (d2 <= 270.0d || d2 >= 360.0d)) ? i.f27244a : eg.a.c(270.0d - d2) : eg.a.c(90.0d - d2);
    }

    public FollowAlgorithm.FollowModes a() {
        return FollowAlgorithm.FollowModes.RELATE;
    }

    public void a(ed.a aVar) {
        boolean b2 = d.b("is_relate_key", false);
        ef.a a2 = aVar.a();
        ef.a b3 = this.f14419b.b().b();
        if (a2 != null && b3 != null && d.a("shoot_type_key", 0) != 8) {
            if (!b2) {
                double d2 = b3.d();
                double c2 = b3.c();
                d.a("first_lat_key", a2.d() + "");
                d.a("first_lng_key", a2.c() + "");
                d.a("drone_lat_key", d2 + "");
                d.a("drone_lng_key", c2 + "");
                d.a("is_relate_key", true);
            }
            double doubleValue = Double.valueOf(d.b("first_lat_key", a2.d() + "")).doubleValue();
            double doubleValue2 = Double.valueOf(d.b("first_lng_key", a2.c() + "")).doubleValue();
            double doubleValue3 = Double.valueOf(d.b("drone_lat_key", b3.d() + "")).doubleValue();
            double doubleValue4 = Double.valueOf(d.b("drone_lng_key", b3.c() + "")).doubleValue();
            this.f14419b.w().a(eg.a.a(new ef.a(doubleValue3 + (aVar.a().d() - doubleValue), doubleValue4 + (aVar.a().c() - doubleValue2)), a(eg.a.c(aVar.c())), aVar.d() * 2.0d));
        }
    }
}
