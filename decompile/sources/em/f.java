package em;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.mission.MissionItemType;
import com.flypro.core.polygon.Polygon;
import ej.a;
import ej.c;
import el.b;
import fg.i;
import java.util.ArrayList;
import java.util.List;

public class f extends d {

    /* renamed from: c  reason: collision with root package name */
    b f26921c;

    /* renamed from: d  reason: collision with root package name */
    private c f26922d;

    /* renamed from: e  reason: collision with root package name */
    private a f26923e;

    /* renamed from: f  reason: collision with root package name */
    private int f26924f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f26925g;

    private void a(List<msg_mission_item> list, Context context) {
        list.addAll(new c(this.f14435a, new ef.b(this.f26919b, new a(i.f27244a))).a(context));
    }

    private void b(List<msg_mission_item> list, Context context) {
        double a2 = this.f26919b.g().a();
        while (a2 <= i().a()) {
            a aVar = new a(this.f14435a, new ef.b(this.f26919b, new a(a2)));
            aVar.a(this.f26922d.a());
            list.addAll(aVar.a(context));
            a2 += this.f26923e.a();
        }
    }

    private void c(List<msg_mission_item> list, Context context) {
        Polygon polygon = new Polygon();
        for (double d2 = i.f27244a; d2 <= 360.0d; d2 += 10.0d) {
            polygon.a(eg.a.a((ef.a) this.f26919b, d2, this.f26922d.a()));
        }
        ef.a a2 = eg.a.a((ef.a) this.f26919b, -45.0d, this.f26922d.a() * 2.0d);
        this.f26921c.a(i());
        try {
            b bVar = this.f26921c;
            bVar.a(i.f27244a, bVar.f(), this.f26921c.i(), this.f26921c.h());
            for (ef.a a3 : new com.flypro.core.mission.survey.grid.c(polygon, this.f26921c, a2).a(false).f14445a) {
                list.add(el.a.a(a3, i(), context));
            }
            b bVar2 = this.f26921c;
            bVar2.a(90.0d, bVar2.f(), this.f26921c.i(), this.f26921c.h());
            for (ef.a a4 : new com.flypro.core.mission.survey.grid.c(polygon, this.f26921c, a2).a(false).f14445a) {
                list.add(el.a.a(a4, i(), context));
            }
        } catch (Exception unused) {
        }
    }

    private a i() {
        double a2 = this.f26919b.g().a();
        double d2 = (double) (this.f26924f - 1);
        double a3 = this.f26923e.a();
        Double.isNaN(d2);
        return new a(a2 + (d2 * a3));
    }

    public MissionItemType a() {
        return null;
    }

    public List<msg_mission_item> a(Context context) {
        ArrayList arrayList = new ArrayList();
        a(arrayList, context);
        b(arrayList, context);
        if (this.f26925g) {
            c(arrayList, context);
        }
        return arrayList;
    }

    public void a(int i2) {
        this.f26922d = new c((double) i2);
    }

    public void a(msg_mission_item msg_mission_item) {
    }

    public void a(eo.a aVar) {
        this.f26921c.a(aVar);
    }

    public void a(boolean z2) {
        this.f26925g = z2;
    }

    public void b(int i2) {
        this.f26923e = new a((double) i2);
    }

    public a c() {
        return this.f26923e;
    }

    public void c(int i2) {
        this.f26924f = i2;
    }

    public int d() {
        return this.f26924f;
    }

    public c f() {
        return this.f26922d;
    }

    public boolean g() {
        return this.f26925g;
    }

    public String h() {
        return this.f26921c.j();
    }
}
