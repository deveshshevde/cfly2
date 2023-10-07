package com.flypro.core.mission;

import android.content.Context;
import android.util.Log;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.d;
import dy.ap;
import dy.ar;
import ek.b;
import ek.c;
import ek.f;
import ek.h;
import em.e;
import em.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private List<b> f11608a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private ej.a f11609c = new ej.a(30.0d);

    public a(en.a aVar) {
        super(aVar);
    }

    private List<b> e(List<msg_mission_item> list) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (msg_mission_item next : list) {
            short s2 = next.f6939l;
            if (s2 == 16) {
                obj = new g(next, this);
            } else if (s2 == 18) {
                obj = new em.a(next, this);
            } else if (s2 == 82) {
                obj = new e(next, this);
            } else if (s2 == 115) {
                obj = new c(next, this);
            } else if (s2 == 178) {
                obj = new b(next, this);
            } else if (s2 == 183) {
                obj = new ek.g(next, this);
            } else if (s2 == 201) {
                obj = new em.c(next, this);
            } else if (s2 == 206) {
                obj = new ek.a(next, this);
            } else if (s2 != 211) {
                switch (s2) {
                    case 20:
                        obj = new f(next, this);
                        break;
                    case 21:
                        obj = new em.b(next, this);
                        break;
                    case 22:
                        obj = new h(next, this);
                        break;
                }
            } else {
                obj = new ek.d(next, this);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public ej.a a() {
        return this.f11609c;
    }

    public ej.c a(em.d dVar) throws IllegalArgumentException {
        int indexOf = this.f11608a.indexOf(dVar);
        if (indexOf > 0) {
            b bVar = this.f11608a.get(indexOf - 1);
            if (bVar instanceof em.d) {
                return dVar.e().g().a(((em.d) bVar).e().g());
            }
        }
        throw new IllegalArgumentException("Last waypoint doesn't have an altitude");
    }

    public List<b> a(ef.a aVar, ef.a aVar2) {
        ef.a aVar3 = aVar;
        ef.a aVar4 = aVar2;
        ef.a a2 = eg.a.a(aVar3, aVar4, 5);
        ej.d d2 = this.f11557b.n().d();
        if (d2 == null) {
            d2 = new ej.d(5.0d);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new h(this, new ej.a(4.0d)));
        arrayList.add(new em.c(this, new ef.b(eg.a.a(aVar3, aVar4, -8), new ej.a(1.0d))));
        arrayList.add(new g(this, new ef.b(aVar4, new ej.a((eg.a.c(aVar, aVar2).a() / 2.0d) + 4.0d))));
        arrayList.add(new g(this, new ef.b(a2, new ej.a((eg.a.c(aVar3, a2).a() / 2.0d) + 4.0d))));
        arrayList.add(new b(this, new ej.d(1.0d)));
        arrayList.add(new g(this, new ef.b(aVar3, new ej.a(4.0d))));
        arrayList.add(new b(this, d2));
        arrayList.add(new em.b(this, aVar3));
        return arrayList;
    }

    public void a(Context context) {
    }

    public void a(Context context, boolean z2) {
        this.f11557b.N().a(z2, b(context));
    }

    public void a(b bVar) {
        this.f11608a.remove(bVar);
        b();
    }

    public void a(ej.a aVar) {
        this.f11609c = aVar;
    }

    public void a(List<b> list) {
        this.f11608a.removeAll(list);
        b();
    }

    public ej.c b(em.d dVar) throws IllegalArgumentException {
        int indexOf = this.f11608a.indexOf(dVar);
        if (indexOf > 0) {
            b bVar = this.f11608a.get(indexOf - 1);
            if (bVar instanceof em.d) {
                return eg.a.c(dVar.e(), ((em.d) bVar).e());
            }
        }
        throw new IllegalArgumentException("Last waypoint doesn't have a coordinate");
    }

    public List<msg_mission_item> b(Context context) {
        ArrayList arrayList = new ArrayList();
        msg_mission_item e2 = this.f11557b.q().e();
        e2.f6935h = this.f11608a.get(0).a(context).get(0).f6935h;
        e2.f6936i = this.f11608a.get(0).a(context).get(0).f6936i;
        e2.f6937j = this.f11608a.get(0).a(context).get(0).f6937j;
        e2.f6938k = (short) 0;
        e2.f6937j = 30.0f;
        Log.i("google", "getMsgMissionItems:--->>>> " + e2.f6935h + "...alt..." + e2.f6937j + "...seq..." + e2.f6938k);
        arrayList.add(e2);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f11608a.size(); i3++) {
            for (msg_mission_item next : this.f11608a.get(i3).a(context)) {
                next.f6938k = (short) i2;
                arrayList.add(next);
                i2++;
            }
        }
        return arrayList;
    }

    public void b() {
        org.greenrobot.eventbus.c.a().d(new ar(20));
    }

    public void b(b bVar) {
        this.f11608a.add(bVar);
        b();
    }

    public void b(List<b> list) {
        this.f11608a.addAll(list);
        b();
    }

    public double c(Context context) {
        ef.a b2 = this.f11557b.b().b();
        if (b2 == null || this.f11557b.b().d() <= 5) {
            this.f11557b.a(DroneInterfaces.DroneEventsType.WARNING_NO_GPS);
            return -1.0d;
        }
        double c2 = this.f11557b.u().c() + 180.0d;
        this.f11608a.clear();
        this.f11608a.addAll(a(b2, eg.a.a(b2, c2, 50.0d)));
        a(context);
        b();
        return c2;
    }

    public int c(b bVar) {
        return this.f11608a.indexOf(bVar) + 1;
    }

    public ej.a c() {
        ej.a aVar = this.f11609c;
        try {
            List<b> list = this.f11608a;
            em.d dVar = (em.d) list.get(list.size() - 1);
            return !(dVar instanceof em.c) ? dVar.e().g() : aVar;
        } catch (Exception unused) {
            return aVar;
        }
    }

    public void c(List<com.flypro.core.util.b<b, b>> list) {
        if (list != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.flypro.core.util.b next : list) {
                int indexOf = this.f11608a.indexOf((b) next.f14468a);
                if (indexOf != -1) {
                    this.f11608a.remove(indexOf);
                    this.f11608a.add(indexOf, (b) next.f14469b);
                    z2 = true;
                }
            }
            if (z2) {
                b();
            }
        }
    }

    public void d() {
        Collections.reverse(this.f11608a);
        b();
    }

    public void d(List<msg_mission_item> list) {
        if (list != null) {
            this.f11557b.q().a(list.get(0));
            list.remove(0);
            this.f11608a.clear();
            this.f11608a.addAll(e(list));
            org.greenrobot.eventbus.c.a().d(new ap(21));
            b();
        }
    }

    public List<b> e() {
        return this.f11608a;
    }

    public boolean f() {
        return this.f11608a.size() >= 2 && g() && h();
    }

    public boolean g() {
        return !this.f11608a.isEmpty() && (this.f11608a.get(0) instanceof h);
    }

    public boolean h() {
        if (this.f11608a.isEmpty()) {
            return false;
        }
        List<b> list = this.f11608a;
        b bVar = list.get(list.size() - 1);
        return (bVar instanceof f) || (bVar instanceof em.b);
    }
}
