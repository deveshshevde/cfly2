package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.a;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.background.systemjob.b;
import androidx.work.impl.utils.d;
import androidx.work.j;
import ao.p;
import ao.q;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5242a = j.a("Schedulers");

    private static e a(Context context) {
        try {
            e eVar = (e) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            j.a().b(f5242a, String.format("Created %s", new Object[]{"androidx.work.impl.background.gcm.GcmScheduler"}), new Throwable[0]);
            return eVar;
        } catch (Throwable th) {
            j.a().b(f5242a, "Unable to create GCM Scheduler", th);
            return null;
        }
    }

    static e a(Context context, j jVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            b bVar = new b(context, jVar);
            d.a(context, SystemJobService.class, true);
            j.a().b(f5242a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return bVar;
        }
        e a2 = a(context);
        if (a2 != null) {
            return a2;
        }
        androidx.work.impl.background.systemalarm.f fVar = new androidx.work.impl.background.systemalarm.f(context);
        d.a(context, SystemAlarmService.class, true);
        j.a().b(f5242a, "Created SystemAlarmScheduler", new Throwable[0]);
        return fVar;
    }

    public static void a(a aVar, WorkDatabase workDatabase, List<e> list) {
        if (list != null && list.size() != 0) {
            q o2 = workDatabase.o();
            workDatabase.g();
            try {
                List<p> a2 = o2.a(aVar.j());
                List<p> b2 = o2.b(200);
                if (a2 != null && a2.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (p pVar : a2) {
                        o2.b(pVar.f5495a, currentTimeMillis);
                    }
                }
                workDatabase.j();
                if (a2 != null && a2.size() > 0) {
                    p[] pVarArr = (p[]) a2.toArray(new p[a2.size()]);
                    for (e next : list) {
                        if (next.a()) {
                            next.a(pVarArr);
                        }
                    }
                }
                if (b2 != null && b2.size() > 0) {
                    p[] pVarArr2 = (p[]) b2.toArray(new p[b2.size()]);
                    for (e next2 : list) {
                        if (!next2.a()) {
                            next2.a(pVarArr2);
                        }
                    }
                }
            } finally {
                workDatabase.h();
            }
        }
    }
}
