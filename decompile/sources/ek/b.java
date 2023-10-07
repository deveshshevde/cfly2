package ek;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.mission.MissionItemType;
import com.flypro.core.mission.a;
import ej.d;
import java.util.List;

public class b extends e {

    /* renamed from: b  reason: collision with root package name */
    private d f26900b = new d(5.0d);

    public b(msg_mission_item msg_mission_item, a aVar) {
        super(aVar);
        a(msg_mission_item);
    }

    public b(a aVar, d dVar) {
        super(aVar);
        this.f26900b = dVar;
    }

    public b(com.flypro.core.mission.b bVar) {
        super(bVar);
    }

    public MissionItemType a() {
        return MissionItemType.CHANGE_SPEED;
    }

    public List<msg_mission_item> a(Context context) {
        List<msg_mission_item> a2 = super.a(context);
        msg_mission_item msg_mission_item = a2.get(0);
        msg_mission_item.f6939l = 178;
        msg_mission_item.f6942o = 3;
        msg_mission_item.f6932e = (float) this.f26900b.a();
        return a2;
    }

    public void a(msg_mission_item msg_mission_item) {
        this.f26900b = new d((double) msg_mission_item.f6932e);
    }

    public void a(d dVar) {
        this.f26900b = dVar;
    }

    public d c() {
        return this.f26900b;
    }
}
