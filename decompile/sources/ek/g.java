package ek;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.mission.MissionItemType;
import com.flypro.core.mission.a;
import java.util.List;

public class g extends e {

    /* renamed from: b  reason: collision with root package name */
    private int f26906b;

    /* renamed from: c  reason: collision with root package name */
    private int f26907c;

    public g(msg_mission_item msg_mission_item, a aVar) {
        super(aVar);
        a(msg_mission_item);
    }

    public MissionItemType a() {
        return null;
    }

    public List<msg_mission_item> a(Context context) {
        List<msg_mission_item> a2 = super.a(context);
        msg_mission_item msg_mission_item = a2.get(0);
        msg_mission_item.f6939l = 183;
        msg_mission_item.f6931d = (float) this.f26907c;
        msg_mission_item.f6932e = (float) this.f26906b;
        return a2;
    }

    public void a(int i2) {
        this.f26906b = i2;
    }

    public void a(msg_mission_item msg_mission_item) {
        this.f26907c = (int) msg_mission_item.f6931d;
        this.f26906b = (int) msg_mission_item.f6932e;
    }

    public void b(int i2) {
        this.f26907c = i2;
    }

    public int c() {
        return this.f26906b;
    }

    public int d() {
        return this.f26907c;
    }
}
