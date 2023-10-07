package el;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.mission.MissionItemType;
import com.flypro.core.mission.b;
import com.flypro.core.polygon.Polygon;
import ej.c;
import fg.i;
import java.util.ArrayList;
import java.util.List;

public class a extends b {

    /* renamed from: b  reason: collision with root package name */
    public Polygon f26909b = new Polygon();

    /* renamed from: c  reason: collision with root package name */
    public b f26910c = new b();

    /* renamed from: d  reason: collision with root package name */
    public com.flypro.core.mission.survey.grid.b f26911d;

    public a(com.flypro.core.mission.a aVar, List<ef.a> list) {
        super(aVar);
        this.f26909b.a(list);
    }

    public static msg_mission_item a(ef.a aVar, c cVar, Context context) {
        msg_mission_item msg_mission_item = new msg_mission_item(context);
        msg_mission_item.f6944q = 1;
        msg_mission_item.f6941n = 1;
        msg_mission_item.f6940m = 1;
        msg_mission_item.f6942o = 3;
        msg_mission_item.f6939l = 16;
        msg_mission_item.f6935h = (float) aVar.a();
        msg_mission_item.f6936i = (float) aVar.b();
        msg_mission_item.f6937j = (float) cVar.a();
        msg_mission_item.f6931d = 0.0f;
        msg_mission_item.f6932e = 0.0f;
        msg_mission_item.f6933f = 0.0f;
        msg_mission_item.f6934g = 0.0f;
        return msg_mission_item;
    }

    private void a(List<msg_mission_item> list, Context context) {
        for (ef.a a2 : this.f26911d.f14445a) {
            list.add(a(a2, this.f26910c.f(), context));
        }
    }

    public MissionItemType a() {
        return null;
    }

    public List<msg_mission_item> a(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            c();
            arrayList.addAll(new ek.a(this.f14435a, this.f26910c.d()).a(context));
            a(arrayList, context);
            arrayList.addAll(new ek.a(this.f14435a, new c(i.f27244a)).a(context));
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public void a(double d2, ej.a aVar, double d3, double d4) {
        this.f26910c.a(d2, aVar, d3, d4);
        this.f14435a.b();
    }

    public void a(eo.a aVar) {
        this.f26910c.a(aVar);
        this.f14435a.b();
    }

    public void c() throws Exception {
        this.f26911d = null;
        com.flypro.core.mission.survey.grid.c cVar = new com.flypro.core.mission.survey.grid.c(this.f26909b, this.f26910c, new ef.a(i.f27244a, i.f27244a));
        this.f26909b.d();
        this.f26911d = cVar.a(true);
    }
}
