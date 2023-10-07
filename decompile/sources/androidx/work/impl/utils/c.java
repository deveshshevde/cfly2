package androidx.work.impl.utils;

import ag.b;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.impl.WorkDatabase;
import ao.d;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final WorkDatabase f5356a;

    public c(WorkDatabase workDatabase) {
        this.f5356a = workDatabase;
    }

    private int a(String str) {
        this.f5356a.g();
        try {
            Long a2 = this.f5356a.u().a(str);
            int i2 = 0;
            int intValue = a2 != null ? a2.intValue() : 0;
            if (intValue != Integer.MAX_VALUE) {
                i2 = intValue + 1;
            }
            a(str, i2);
            this.f5356a.j();
            return intValue;
        } finally {
            this.f5356a.h();
        }
    }

    public static void a(Context context, b bVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.id", 0);
        if (sharedPreferences.contains("next_job_scheduler_id") || sharedPreferences.contains("next_job_scheduler_id")) {
            int i2 = sharedPreferences.getInt("next_job_scheduler_id", 0);
            int i3 = sharedPreferences.getInt("next_alarm_manager_id", 0);
            bVar.a();
            try {
                bVar.a("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i2)});
                bVar.a("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i3)});
                sharedPreferences.edit().clear().apply();
                bVar.c();
            } finally {
                bVar.b();
            }
        }
    }

    private void a(String str, int i2) {
        this.f5356a.u().a(new d(str, (long) i2));
    }

    public int a() {
        int a2;
        synchronized (c.class) {
            a2 = a("next_alarm_manager_id");
        }
        return a2;
    }

    public int a(int i2, int i3) {
        synchronized (c.class) {
            int a2 = a("next_job_scheduler_id");
            if (a2 >= i2) {
                if (a2 <= i3) {
                    i2 = a2;
                }
            }
            a("next_job_scheduler_id", i2 + 1);
        }
        return i2;
    }
}
