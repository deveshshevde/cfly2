package em;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.mission.MissionItemType;
import com.flypro.core.mission.a;
import ef.b;
import java.util.List;

public class e extends d {

    /* renamed from: c  reason: collision with root package name */
    private double f26920c;

    public e(msg_mission_item msg_mission_item, a aVar) {
        super(aVar, (b) null);
        a(msg_mission_item);
    }

    public e(a aVar, b bVar) {
        super(aVar, bVar);
    }

    public e(com.flypro.core.mission.b bVar) {
        super(bVar);
    }

    public MissionItemType a() {
        return MissionItemType.SPLINE_WAYPOINT;
    }

    public List<msg_mission_item> a(Context context) {
        List<msg_mission_item> a2 = super.a(context);
        msg_mission_item msg_mission_item = a2.get(0);
        msg_mission_item.f6939l = 82;
        msg_mission_item.f6931d = (float) this.f26920c;
        return a2;
    }

    public void a(double d2) {
        this.f26920c = d2;
    }

    public void a(msg_mission_item msg_mission_item) {
        super.a(msg_mission_item);
        a((double) msg_mission_item.f6931d);
    }

    public double c() {
        return this.f26920c;
    }
}
