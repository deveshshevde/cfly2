package em;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.mission.a;
import com.flypro.core.mission.b;
import fg.i;
import java.util.List;

public abstract class d extends b {

    /* renamed from: b  reason: collision with root package name */
    protected ef.b f26919b;

    public d(a aVar, ef.b bVar) {
        super(aVar);
        this.f26919b = bVar;
    }

    public d(b bVar) {
        super(bVar);
        this.f26919b = bVar instanceof d ? ((d) bVar).e() : new ef.b(i.f27244a, i.f27244a, new ej.a(30.0d));
    }

    public List<msg_mission_item> a(Context context) {
        List<msg_mission_item> a2 = super.a(context);
        msg_mission_item msg_mission_item = a2.get(0);
        msg_mission_item.f6936i = (float) this.f26919b.c();
        msg_mission_item.f6935h = (float) this.f26919b.d();
        msg_mission_item.f6937j = (float) this.f26919b.g().a();
        return a2;
    }

    public void a(msg_mission_item msg_mission_item) {
        a(new ef.b((double) msg_mission_item.f6935h, (double) msg_mission_item.f6936i, new ej.a((double) msg_mission_item.f6937j)));
    }

    public void a(ef.a aVar) {
        this.f26919b.a(aVar);
    }

    public void a(ef.b bVar) {
        this.f26919b = bVar;
    }

    public void a(ej.a aVar) {
        ef.b bVar = this.f26919b;
        bVar.a(bVar.d(), this.f26919b.c(), aVar);
    }

    public ef.b e() {
        return this.f26919b;
    }
}
