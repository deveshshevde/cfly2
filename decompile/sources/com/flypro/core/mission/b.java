package com.flypro.core.mission;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import java.util.ArrayList;
import java.util.List;

public abstract class b implements Comparable<b> {

    /* renamed from: a  reason: collision with root package name */
    protected a f14435a;

    public b(a aVar) {
        this.f14435a = aVar;
    }

    public b(b bVar) {
        this(bVar.f14435a);
    }

    /* renamed from: a */
    public int compareTo(b bVar) {
        return this.f14435a.c(this) - this.f14435a.c(bVar);
    }

    public abstract MissionItemType a();

    public List<msg_mission_item> a(Context context) {
        ArrayList arrayList = new ArrayList();
        msg_mission_item msg_mission_item = new msg_mission_item(context);
        arrayList.add(msg_mission_item);
        msg_mission_item.f6941n = 1;
        msg_mission_item.f6940m = -1;
        msg_mission_item.f6942o = 0;
        msg_mission_item.f6944q = 1;
        return arrayList;
    }

    public a b() {
        return this.f14435a;
    }
}
