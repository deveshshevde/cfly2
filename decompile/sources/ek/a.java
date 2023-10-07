package ek;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.mission.MissionItemType;
import ej.c;
import fg.i;
import java.util.List;

public class a extends e {

    /* renamed from: b  reason: collision with root package name */
    private c f26899b = new c(i.f27244a);

    public a(msg_mission_item msg_mission_item, com.flypro.core.mission.a aVar) {
        super(aVar);
        a(msg_mission_item);
    }

    public a(com.flypro.core.mission.a aVar, c cVar) {
        super(aVar);
        this.f26899b = cVar;
    }

    public MissionItemType a() {
        return null;
    }

    public List<msg_mission_item> a(Context context) {
        List<msg_mission_item> a2 = super.a(context);
        msg_mission_item msg_mission_item = a2.get(0);
        msg_mission_item.f6939l = 206;
        msg_mission_item.f6931d = (float) this.f26899b.a();
        return a2;
    }

    public void a(msg_mission_item msg_mission_item) {
        this.f26899b = new c((double) msg_mission_item.f6931d);
    }

    public void a(c cVar) {
        this.f26899b = cVar;
    }

    public c c() {
        return this.f26899b;
    }
}
