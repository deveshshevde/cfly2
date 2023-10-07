package ek;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.mission.MissionItemType;
import com.flypro.core.mission.b;
import ej.a;
import fg.i;
import java.util.List;

public class f extends e {

    /* renamed from: b  reason: collision with root package name */
    private a f26905b;

    public f(msg_mission_item msg_mission_item, com.flypro.core.mission.a aVar) {
        super(aVar);
        a(msg_mission_item);
    }

    public f(b bVar) {
        super(bVar);
        this.f26905b = new a(i.f27244a);
    }

    public MissionItemType a() {
        return MissionItemType.RTL;
    }

    public List<msg_mission_item> a(Context context) {
        List<msg_mission_item> a2 = super.a(context);
        msg_mission_item msg_mission_item = a2.get(0);
        msg_mission_item.f6939l = 20;
        msg_mission_item.f6942o = 3;
        msg_mission_item.f6937j = (float) this.f26905b.a();
        return a2;
    }

    public void a(msg_mission_item msg_mission_item) {
        this.f26905b = new a((double) msg_mission_item.f6937j);
    }

    public void a(a aVar) {
        this.f26905b = aVar;
    }
}
