package androidx.work.impl;

import ag.b;
import ag.c;
import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.h;
import androidx.work.impl.h;
import ao.e;
import ao.k;
import ao.n;
import ao.q;
import ao.t;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class WorkDatabase extends RoomDatabase {

    /* renamed from: d  reason: collision with root package name */
    private static final long f5154d = TimeUnit.DAYS.toMillis(1);

    public static WorkDatabase a(final Context context, Executor executor, boolean z2) {
        RoomDatabase.a<WorkDatabase> aVar;
        Class<WorkDatabase> cls = WorkDatabase.class;
        if (z2) {
            aVar = h.a(context, cls).a();
        } else {
            aVar = h.a(context, cls, i.a());
            aVar.a((c.C0004c) new c.C0004c() {
                public c a(c.b bVar) {
                    c.b.a a2 = c.b.a(context);
                    a2.a(bVar.f94b).a(bVar.f95c).a(true);
                    return new ah.c().a(a2.a());
                }
            });
        }
        return aVar.a(executor).a(l()).a(h.f5282a).a(new h.a(context, 2, 3)).a(h.f5283b).a(h.f5284c).a(new h.a(context, 5, 6)).a(h.f5285d).a(h.f5286e).a(h.f5287f).a(new h.b(context)).a(new h.a(context, 10, 11)).a(h.f5288g).b().c();
    }

    static RoomDatabase.b l() {
        return new RoomDatabase.b() {
            public void b(b bVar) {
                super.b(bVar);
                bVar.a();
                try {
                    bVar.c(WorkDatabase.m());
                    bVar.c();
                } finally {
                    bVar.b();
                }
            }
        };
    }

    static String m() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + n() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    static long n() {
        return System.currentTimeMillis() - f5154d;
    }

    public abstract q o();

    public abstract ao.b p();

    public abstract t q();

    public abstract ao.h r();

    public abstract k s();

    public abstract n t();

    public abstract e u();
}
