package ek;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.mission.MissionItemType;
import com.flypro.core.mission.a;
import fg.i;
import java.util.List;

public class c extends e {

    /* renamed from: b  reason: collision with root package name */
    private boolean f26901b = false;

    /* renamed from: c  reason: collision with root package name */
    private double f26902c = i.f27244a;

    /* renamed from: d  reason: collision with root package name */
    private double f26903d = i.f27244a;

    public c(msg_mission_item msg_mission_item, a aVar) {
        super(aVar);
        a(msg_mission_item);
    }

    public MissionItemType a() {
        return null;
    }

    public List<msg_mission_item> a(Context context) {
        List<msg_mission_item> a2 = super.a(context);
        msg_mission_item msg_mission_item = a2.get(0);
        msg_mission_item.f6939l = 115;
        msg_mission_item.f6931d = (float) eg.a.c(this.f26902c);
        msg_mission_item.f6932e = (float) Math.abs(this.f26903d);
        float f2 = 1.0f;
        msg_mission_item.f6933f = this.f26903d < i.f27244a ? 1.0f : -1.0f;
        if (!this.f26901b) {
            f2 = 0.0f;
        }
        msg_mission_item.f6934g = f2;
        return a2;
    }

    public void a(double d2) {
        this.f26902c = d2;
    }

    public void a(msg_mission_item msg_mission_item) {
        int i2 = 1;
        this.f26901b = msg_mission_item.f6934g != 0.0f;
        this.f26902c = (double) msg_mission_item.f6931d;
        float f2 = msg_mission_item.f6932e;
        if (msg_mission_item.f6933f > 0.0f) {
            i2 = -1;
        }
        this.f26903d = (double) (f2 * ((float) i2));
    }

    public void a(boolean z2) {
        this.f26901b = z2;
    }

    public double c() {
        return this.f26902c;
    }

    public boolean d() {
        return this.f26901b;
    }
}
