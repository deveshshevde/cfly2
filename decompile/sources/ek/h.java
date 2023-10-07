package ek;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.mission.MissionItemType;
import com.flypro.core.mission.b;
import ej.a;
import java.util.List;

public class h extends e {

    /* renamed from: b  reason: collision with root package name */
    private a f26908b = new a(10.0d);

    public h(msg_mission_item msg_mission_item, com.flypro.core.mission.a aVar) {
        super(aVar);
        a(msg_mission_item);
    }

    public h(com.flypro.core.mission.a aVar, a aVar2) {
        super(aVar);
        this.f26908b = aVar2;
    }

    public h(b bVar) {
        super(bVar);
    }

    public MissionItemType a() {
        return MissionItemType.TAKEOFF;
    }

    public List<msg_mission_item> a(Context context) {
        List<msg_mission_item> a2 = super.a(context);
        msg_mission_item msg_mission_item = a2.get(0);
        msg_mission_item.f6939l = 22;
        msg_mission_item.f6942o = 3;
        msg_mission_item.f6937j = (float) this.f26908b.a();
        return a2;
    }

    public void a(msg_mission_item msg_mission_item) {
        this.f26908b = new a((double) msg_mission_item.f6937j);
    }

    public void a(a aVar) {
        this.f26908b = aVar;
    }

    public a c() {
        return this.f26908b;
    }
}
