package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.impl.e;
import androidx.work.j;
import ao.p;

public class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5211a = j.a("SystemAlarmScheduler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f5212b;

    public f(Context context) {
        this.f5212b = context.getApplicationContext();
    }

    private void a(p pVar) {
        j.a().b(f5211a, String.format("Scheduling work with workSpecId %s", new Object[]{pVar.f5495a}), new Throwable[0]);
        this.f5212b.startService(b.a(this.f5212b, pVar.f5495a));
    }

    public void a(String str) {
        this.f5212b.startService(b.c(this.f5212b, str));
    }

    public void a(p... pVarArr) {
        for (p a2 : pVarArr) {
            a(a2);
        }
    }

    public boolean a() {
        return true;
    }
}
