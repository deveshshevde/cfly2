package androidx.work.impl.utils;

import ag.b;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.impl.WorkDatabase;
import ao.d;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final WorkDatabase f5358a;

    public e(WorkDatabase workDatabase) {
        this.f5358a = workDatabase;
    }

    public static void a(Context context, b bVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j2 = 0;
            long j3 = sharedPreferences.getLong("last_cancel_all_time_ms", 0);
            if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                j2 = 1;
            }
            bVar.a();
            try {
                bVar.a("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j3)});
                bVar.a("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j2)});
                sharedPreferences.edit().clear().apply();
                bVar.c();
            } finally {
                bVar.b();
            }
        }
    }

    public void a(boolean z2) {
        this.f5358a.u().a(new d("reschedule_needed", z2));
    }

    public boolean a() {
        Long a2 = this.f5358a.u().a("reschedule_needed");
        return a2 != null && a2.longValue() == 1;
    }
}
