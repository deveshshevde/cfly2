package em;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.mission.MissionItemType;
import com.flypro.core.mission.a;
import ef.b;
import java.util.List;

public class c extends d {
    public c(msg_mission_item msg_mission_item, a aVar) {
        super(aVar, (b) null);
        a(msg_mission_item);
    }

    public c(a aVar, b bVar) {
        super(aVar, bVar);
    }

    public MissionItemType a() {
        return null;
    }

    public List<msg_mission_item> a(Context context) {
        List<msg_mission_item> a2 = super.a(context);
        a2.get(0).f6939l = 201;
        return a2;
    }

    public void a(msg_mission_item msg_mission_item) {
        super.a(msg_mission_item);
    }
}
