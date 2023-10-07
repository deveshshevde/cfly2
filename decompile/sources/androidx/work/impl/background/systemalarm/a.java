package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.c;
import androidx.work.j;
import ao.g;
import ao.h;
import com.autonavi.amap.mapcore.AMapEngineUtils;

class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5175a = j.a("Alarms");

    public static void a(Context context, androidx.work.impl.j jVar, String str) {
        h r2 = jVar.c().r();
        g a2 = r2.a(str);
        if (a2 != null) {
            a(context, str, a2.f5473b);
            j.a().b(f5175a, String.format("Removing SystemIdInfo for workSpecId (%s)", new Object[]{str}), new Throwable[0]);
            r2.b(str);
        }
    }

    public static void a(Context context, androidx.work.impl.j jVar, String str, long j2) {
        int i2;
        WorkDatabase c2 = jVar.c();
        h r2 = c2.r();
        g a2 = r2.a(str);
        if (a2 != null) {
            a(context, str, a2.f5473b);
            i2 = a2.f5473b;
        } else {
            i2 = new c(c2).a();
            r2.a(new g(str, i2));
        }
        a(context, str, i2, j2);
    }

    private static void a(Context context, String str, int i2) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i2, b.b(context, str), Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912);
        if (service != null && alarmManager != null) {
            j.a().b(f5175a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", new Object[]{str, Integer.valueOf(i2)}), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    private static void a(Context context, String str, int i2, long j2) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i2, b.b(context, str), Build.VERSION.SDK_INT >= 23 ? 201326592 : AMapEngineUtils.HALF_MAX_P20_WIDTH);
        if (alarmManager == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(0, j2, service);
        } else {
            alarmManager.set(0, j2, service);
        }
    }
}
