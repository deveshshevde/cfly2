package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.j;
import ao.g;
import ao.h;
import ao.k;
import ao.p;
import ao.q;
import ao.t;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DiagnosticsWorker extends Worker {

    /* renamed from: b  reason: collision with root package name */
    private static final String f5446b = j.a("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private static String a(k kVar, t tVar, h hVar, List<p> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", new Object[]{Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id"}));
        for (p next : list) {
            Integer num = null;
            g a2 = hVar.a(next.f5495a);
            if (a2 != null) {
                num = Integer.valueOf(a2.f5473b);
            }
            sb.append(a(next, TextUtils.join(",", kVar.a(next.f5495a)), num, TextUtils.join(",", tVar.a(next.f5495a))));
        }
        return sb.toString();
    }

    private static String a(p pVar, String str, Integer num, String str2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", new Object[]{pVar.f5495a, pVar.f5497c, num, pVar.f5496b.name(), str, str2});
    }

    public ListenableWorker.a o() {
        WorkDatabase c2 = androidx.work.impl.j.b(a()).c();
        q o2 = c2.o();
        k s2 = c2.s();
        t q2 = c2.q();
        h r2 = c2.r();
        List<p> a2 = o2.a(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        List<p> d2 = o2.d();
        List<p> b2 = o2.b(200);
        if (a2 != null && !a2.isEmpty()) {
            j a3 = j.a();
            String str = f5446b;
            a3.c(str, "Recently completed work:\n\n", new Throwable[0]);
            j.a().c(str, a(s2, q2, r2, a2), new Throwable[0]);
        }
        if (d2 != null && !d2.isEmpty()) {
            j a4 = j.a();
            String str2 = f5446b;
            a4.c(str2, "Running work:\n\n", new Throwable[0]);
            j.a().c(str2, a(s2, q2, r2, d2), new Throwable[0]);
        }
        if (b2 != null && !b2.isEmpty()) {
            j a5 = j.a();
            String str3 = f5446b;
            a5.c(str3, "Enqueued work:\n\n", new Throwable[0]);
            j.a().c(str3, a(s2, q2, r2, b2), new Throwable[0]);
        }
        return ListenableWorker.a.a();
    }
}
