package ek;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.mission.MissionItemType;
import com.flypro.core.mission.a;
import java.util.List;

public class d extends e {

    /* renamed from: b  reason: collision with root package name */
    private boolean f26904b = true;

    public d(msg_mission_item msg_mission_item, a aVar) {
        super(aVar);
        a(msg_mission_item);
    }

    public MissionItemType a() {
        return null;
    }

    public List<msg_mission_item> a(Context context) {
        List<msg_mission_item> a2 = super.a(context);
        msg_mission_item msg_mission_item = a2.get(0);
        msg_mission_item.f6939l = 211;
        msg_mission_item.f6932e = this.f26904b ? 0.0f : 1.0f;
        return a2;
    }

    public void a(msg_mission_item msg_mission_item) {
        boolean z2;
        if (msg_mission_item.f6932e == 1.0f) {
            z2 = false;
        } else if (msg_mission_item.f6932e == 0.0f) {
            z2 = true;
        } else {
            return;
        }
        this.f26904b = z2;
    }
}
