package em;

import android.content.Context;
import android.util.Log;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.mission.MissionItemType;
import com.flypro.core.mission.a;
import ef.b;
import java.util.List;

public class g extends d {

    /* renamed from: c  reason: collision with root package name */
    private double f26926c;

    /* renamed from: d  reason: collision with root package name */
    private double f26927d;

    /* renamed from: e  reason: collision with root package name */
    private double f26928e;

    /* renamed from: f  reason: collision with root package name */
    private double f26929f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f26930g;

    public g(msg_mission_item msg_mission_item, a aVar) {
        super(aVar, (b) null);
        a(msg_mission_item);
    }

    public g(a aVar, b bVar) {
        super(aVar, bVar);
    }

    public g(com.flypro.core.mission.b bVar) {
        super(bVar);
    }

    public MissionItemType a() {
        return MissionItemType.WAYPOINT;
    }

    public List<msg_mission_item> a(Context context) {
        List<msg_mission_item> a2 = super.a(context);
        Log.i("google", "packMissionItem:--->>>>item lat--> " + a2.get(0).f6935h + "--lng-->" + a2.get(0).f6936i + "...alt..." + a2.get(0).f6937j);
        msg_mission_item msg_mission_item = a2.get(0);
        msg_mission_item.f6939l = 16;
        msg_mission_item.f6931d = (float) c();
        msg_mission_item.f6932e = (float) d();
        msg_mission_item.f6933f = (float) (h() ? g() * -1.0d : g());
        msg_mission_item.f6934g = (float) f();
        return a2;
    }

    public void a(double d2) {
        this.f26926c = d2;
    }

    public void a(msg_mission_item msg_mission_item) {
        super.a(msg_mission_item);
        Log.i("google", "unpackMAVMessage: --seq-->>" + msg_mission_item.f6938k + "---lat---" + msg_mission_item.f6935h + "---alt--" + msg_mission_item.f6937j);
        a((double) msg_mission_item.f6931d);
        b((double) msg_mission_item.f6932e);
        a(msg_mission_item.f6933f < 0.0f);
        d((double) Math.abs(msg_mission_item.f6933f));
        c((double) msg_mission_item.f6934g);
    }

    public void a(boolean z2) {
        this.f26930g = z2;
    }

    public void b(double d2) {
        this.f26927d = d2;
    }

    public double c() {
        return this.f26926c;
    }

    public void c(double d2) {
        this.f26928e = d2;
    }

    public double d() {
        return this.f26927d;
    }

    public void d(double d2) {
        this.f26929f = d2;
    }

    public double f() {
        return this.f26928e;
    }

    public double g() {
        return this.f26929f;
    }

    public boolean h() {
        return this.f26930g;
    }
}
