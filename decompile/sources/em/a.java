package em;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.mission.MissionItemType;
import ef.b;
import java.util.ArrayList;
import java.util.List;

public class a extends d {

    /* renamed from: c  reason: collision with root package name */
    private double f26917c = 10.0d;

    /* renamed from: d  reason: collision with root package name */
    private int f26918d = 1;

    public a(msg_mission_item msg_mission_item, com.flypro.core.mission.a aVar) {
        super(aVar, (b) null);
        a(msg_mission_item);
    }

    public a(com.flypro.core.mission.a aVar, b bVar) {
        super(aVar, bVar);
    }

    public a(com.flypro.core.mission.b bVar) {
        super(bVar);
    }

    private void a(List<msg_mission_item> list, Context context) {
        msg_mission_item msg_mission_item = new msg_mission_item(context);
        list.add(msg_mission_item);
        msg_mission_item.f6944q = 1;
        msg_mission_item.f6941n = 1;
        msg_mission_item.f6940m = 1;
        msg_mission_item.f6942o = 3;
        msg_mission_item.f6935h = (float) this.f26919b.d();
        msg_mission_item.f6936i = (float) this.f26919b.c();
        msg_mission_item.f6937j = (float) this.f26919b.g().a();
        msg_mission_item.f6939l = 18;
        msg_mission_item.f6931d = (float) Math.abs(this.f26918d);
        msg_mission_item.f6933f = (float) this.f26917c;
    }

    public MissionItemType a() {
        return MissionItemType.CIRCLE;
    }

    public List<msg_mission_item> a(Context context) {
        ArrayList arrayList = new ArrayList();
        a(arrayList, context);
        return arrayList;
    }

    public void a(double d2) {
        this.f26917c = Math.abs(d2);
    }

    public void a(int i2) {
        this.f26918d = Math.abs(i2);
    }

    public void a(msg_mission_item msg_mission_item) {
        super.a(msg_mission_item);
        a((int) msg_mission_item.f6931d);
        a((double) msg_mission_item.f6933f);
    }

    public int c() {
        return this.f26918d;
    }

    public double d() {
        return this.f26917c;
    }
}
