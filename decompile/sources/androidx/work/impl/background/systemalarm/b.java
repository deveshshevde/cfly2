package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.e;
import androidx.work.j;
import ao.p;
import java.util.HashMap;
import java.util.Map;

public class b implements androidx.work.impl.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5176a = j.a("CommandHandler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f5177b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, androidx.work.impl.b> f5178c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Object f5179d = new Object();

    b(Context context) {
        this.f5177b = context;
    }

    static Intent a(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    static Intent a(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent a(Context context, String str, boolean z2) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z2);
        return intent;
    }

    private void a(Intent intent, int i2) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z2 = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        j.a().b(f5176a, String.format("Handling onExecutionCompleted %s, %s", new Object[]{intent, Integer.valueOf(i2)}), new Throwable[0]);
        a(string, z2);
    }

    private void a(Intent intent, e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        j.a().b(f5176a, String.format("Handing stopWork work for %s", new Object[]{string}), new Throwable[0]);
        eVar.d().b(string);
        a.a(this.f5177b, eVar.d(), string);
        eVar.a(string, false);
    }

    private static boolean a(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    static Intent b(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    static Intent b(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    private void b(Intent intent, int i2, e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        j a2 = j.a();
        String str = f5176a;
        a2.b(str, String.format("Handling schedule work for %s", new Object[]{string}), new Throwable[0]);
        WorkDatabase c2 = eVar.d().c();
        c2.g();
        try {
            p b2 = c2.o().b(string);
            if (b2 == null) {
                j a3 = j.a();
                a3.d(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
            } else if (b2.f5496b.a()) {
                j a4 = j.a();
                a4.d(str, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                c2.h();
            } else {
                long c3 = b2.c();
                if (!b2.d()) {
                    j.a().b(str, String.format("Setting up Alarms for %s at %s", new Object[]{string, Long.valueOf(c3)}), new Throwable[0]);
                    a.a(this.f5177b, eVar.d(), string, c3);
                } else {
                    j.a().b(str, String.format("Opportunistically setting an alarm for %s at %s", new Object[]{string, Long.valueOf(c3)}), new Throwable[0]);
                    a.a(this.f5177b, eVar.d(), string, c3);
                    eVar.a((Runnable) new e.a(eVar, a(this.f5177b), i2));
                }
                c2.j();
                c2.h();
            }
        } finally {
            c2.h();
        }
    }

    static Intent c(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    private void c(Intent intent, int i2, e eVar) {
        Bundle extras = intent.getExtras();
        synchronized (this.f5179d) {
            String string = extras.getString("KEY_WORKSPEC_ID");
            j a2 = j.a();
            String str = f5176a;
            a2.b(str, String.format("Handing delay met for %s", new Object[]{string}), new Throwable[0]);
            if (!this.f5178c.containsKey(string)) {
                d dVar = new d(this.f5177b, i2, string, eVar);
                this.f5178c.put(string, dVar);
                dVar.a();
            } else {
                j.a().b(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", new Object[]{string}), new Throwable[0]);
            }
        }
    }

    private void d(Intent intent, int i2, e eVar) {
        j.a().b(f5176a, String.format("Handling constraints changed %s", new Object[]{intent}), new Throwable[0]);
        new c(this.f5177b, i2, eVar).a();
    }

    private void e(Intent intent, int i2, e eVar) {
        j.a().b(f5176a, String.format("Handling reschedule %s, %s", new Object[]{intent, Integer.valueOf(i2)}), new Throwable[0]);
        eVar.d().i();
    }

    /* access modifiers changed from: package-private */
    public void a(Intent intent, int i2, e eVar) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            d(intent, i2, eVar);
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            e(intent, i2, eVar);
        } else if (!a(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            j.a().e(f5176a, String.format("Invalid request for %s, requires %s.", new Object[]{action, "KEY_WORKSPEC_ID"}), new Throwable[0]);
        } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
            b(intent, i2, eVar);
        } else if ("ACTION_DELAY_MET".equals(action)) {
            c(intent, i2, eVar);
        } else if ("ACTION_STOP_WORK".equals(action)) {
            a(intent, eVar);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            a(intent, i2);
        } else {
            j.a().d(f5176a, String.format("Ignoring intent %s", new Object[]{intent}), new Throwable[0]);
        }
    }

    public void a(String str, boolean z2) {
        synchronized (this.f5179d) {
            androidx.work.impl.b remove = this.f5178c.remove(str);
            if (remove != null) {
                remove.a(str, z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        boolean z2;
        synchronized (this.f5179d) {
            z2 = !this.f5178c.isEmpty();
        }
        return z2;
    }
}
