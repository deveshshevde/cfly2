package com.flypro.core.drone.variables;

import android.content.Context;
import android.util.Log;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.drone.d;
import ef.a;
import ej.c;
import fg.i;

public class l extends d {

    /* renamed from: a  reason: collision with root package name */
    private a f14354a;

    /* renamed from: c  reason: collision with root package name */
    private ej.a f14355c = new ej.a(i.f27244a);

    /* renamed from: d  reason: collision with root package name */
    private Context f14356d;

    public l(en.a aVar, Context context) {
        super(aVar);
        this.f14356d = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.MAVLink.common.msg_mission_item r14) {
        /*
            r13 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "setHome: ---->>>>"
            r0.append(r1)
            float r1 = r14.f6935h
            r0.append(r1)
            java.lang.String r1 = "--->>>z:"
            r0.append(r1)
            float r1 = r14.f6937j
            r0.append(r1)
            java.lang.String r1 = "...seq..."
            r0.append(r1)
            short r1 = r14.f6938k
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "google"
            android.util.Log.i(r1, r0)
            short r0 = r14.f6938k
            if (r0 != 0) goto L_0x00b3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "setHome: ..."
            r0.append(r2)
            float r2 = r14.f6936i
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r1, r0)
            r0 = 0
            float r1 = r14.f6935h
            float r2 = r14.f6936i
            float r14 = r14.f6937j
            ef.a r3 = r13.f14354a
            r4 = 1
            r5 = 4626322717216342016(0x4034000000000000, double:20.0)
            if (r3 != 0) goto L_0x0066
            ef.a r14 = new ef.a
            double r0 = (double) r1
            double r2 = (double) r2
            r14.<init>(r0, r2)
            r13.f14354a = r14
            ej.a r14 = new ej.a
            r14.<init>(r5)
        L_0x0062:
            r13.f14355c = r14
            r0 = 1
            goto L_0x0091
        L_0x0066:
            double r7 = r3.d()
            double r9 = (double) r1
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x0085
            ef.a r1 = r13.f14354a
            double r7 = r1.c()
            double r11 = (double) r2
            int r1 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r1 != 0) goto L_0x0085
            ej.a r1 = r13.f14355c
            double r7 = r1.a()
            double r11 = (double) r14
            int r14 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r14 == 0) goto L_0x0091
        L_0x0085:
            ef.a r14 = r13.f14354a
            double r0 = (double) r2
            r14.a(r9, r0)
            ej.a r14 = new ej.a
            r14.<init>(r5)
            goto L_0x0062
        L_0x0091:
            if (r0 == 0) goto L_0x00b3
            com.flypro.core.util.a r14 = com.flypro.core.util.a.a()
            r14.j()
            org.greenrobot.eventbus.c r14 = org.greenrobot.eventbus.c.a()
            dy.q r0 = new dy.q
            r1 = 22
            r0.<init>(r1)
            r14.d(r0)
            en.a r14 = r13.f11557b
            com.flypro.core.drone.variables.ListenerData r14 = r14.Q()
            ef.a r0 = r13.f14354a
            r14.a((ef.a) r0)
        L_0x00b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flypro.core.drone.variables.l.a(com.MAVLink.common.msg_mission_item):void");
    }

    public boolean a() {
        return this.f14354a != null;
    }

    public c b() {
        return (!a() || !this.f11557b.b().a()) ? new c(i.f27244a) : eg.a.c(this.f14354a, this.f11557b.b().b());
    }

    public a c() {
        return this.f14354a;
    }

    public c d() {
        return this.f14355c;
    }

    public msg_mission_item e() {
        msg_mission_item msg_mission_item = new msg_mission_item(this.f14356d);
        msg_mission_item.f6944q = 1;
        msg_mission_item.f6939l = 16;
        msg_mission_item.f6943p = 0;
        msg_mission_item.f6942o = 0;
        msg_mission_item.f6941n = 1;
        msg_mission_item.f6940m = 1;
        if (a()) {
            Log.i("google", "packMavlink: --->>>" + ((float) d().a()));
            msg_mission_item.f6935h = (float) c().d();
            msg_mission_item.f6936i = (float) c().c();
            msg_mission_item.f6937j = (float) d().a();
        }
        return msg_mission_item;
    }
}
