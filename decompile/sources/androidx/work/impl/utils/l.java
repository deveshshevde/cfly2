package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.WorkInfo;
import androidx.work.e;
import androidx.work.f;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.a;
import androidx.work.impl.utils.futures.b;
import androidx.work.j;
import ao.q;
import java.util.UUID;

public class l implements f {

    /* renamed from: c  reason: collision with root package name */
    private static final String f5415c = j.a("WMFgUpdater");

    /* renamed from: a  reason: collision with root package name */
    final a f5416a;

    /* renamed from: b  reason: collision with root package name */
    final q f5417b;

    /* renamed from: d  reason: collision with root package name */
    private final ap.a f5418d;

    public l(WorkDatabase workDatabase, a aVar, ap.a aVar2) {
        this.f5416a = aVar;
        this.f5418d = aVar2;
        this.f5417b = workDatabase.o();
    }

    public gz.a<Void> a(Context context, UUID uuid, e eVar) {
        b d2 = b.d();
        final b bVar = d2;
        final UUID uuid2 = uuid;
        final e eVar2 = eVar;
        final Context context2 = context;
        this.f5418d.a(new Runnable() {
            public void run() {
                try {
                    if (!bVar.isCancelled()) {
                        String uuid = uuid2.toString();
                        WorkInfo.State f2 = l.this.f5417b.f(uuid);
                        if (f2 == null || f2.a()) {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        l.this.f5416a.a(uuid, eVar2);
                        context2.startService(androidx.work.impl.foreground.b.b(context2, uuid, eVar2));
                    }
                    bVar.a(null);
                } catch (Throwable th) {
                    bVar.a(th);
                }
            }
        });
        return d2;
    }
}
