package em;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.mission.MissionItemType;
import com.flypro.core.mission.a;
import fg.i;
import java.util.List;

public class b extends d {
    public b(msg_mission_item msg_mission_item, a aVar) {
        super(aVar, (ef.b) null);
        a(msg_mission_item);
    }

    public b(a aVar, ef.a aVar2) {
        super(aVar, new ef.b(aVar2, new ej.a(i.f27244a)));
    }

    public b(com.flypro.core.mission.b bVar) {
        super(bVar);
        a(new ej.a(i.f27244a));
    }

    public MissionItemType a() {
        return MissionItemType.LAND;
    }

    public List<msg_mission_item> a(Context context) {
        List<msg_mission_item> a2 = super.a(context);
        a2.get(0).f6939l = 21;
        return a2;
    }

    public void a(msg_mission_item msg_mission_item) {
        super.a(msg_mission_item);
    }
}
