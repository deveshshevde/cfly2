package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.a;
import androidx.work.WorkInfo;
import androidx.work.g;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.b;
import androidx.work.impl.f;
import androidx.work.impl.i;
import androidx.work.j;
import ao.n;
import ao.p;
import ao.q;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ForceStopRunnable implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5341a = j.a("ForceStopRunnable");

    /* renamed from: b  reason: collision with root package name */
    private static final long f5342b = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: c  reason: collision with root package name */
    private final Context f5343c;

    /* renamed from: d  reason: collision with root package name */
    private final androidx.work.impl.j f5344d;

    /* renamed from: e  reason: collision with root package name */
    private int f5345e = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private static final String f5346a = j.a("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                j.a().a(f5346a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
                ForceStopRunnable.b(context);
            }
        }
    }

    public ForceStopRunnable(Context context, androidx.work.impl.j jVar) {
        this.f5343c = context.getApplicationContext();
        this.f5344d = jVar;
    }

    private static PendingIntent a(Context context, int i2) {
        return PendingIntent.getBroadcast(context, -1, a(context), i2);
    }

    static Intent a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    static void b(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent a2 = a(context, a.b() ? 167772160 : AMapEngineUtils.HALF_MAX_P20_WIDTH);
        long currentTimeMillis = System.currentTimeMillis() + f5342b;
        if (alarmManager == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(0, currentTimeMillis, a2);
        } else {
            alarmManager.set(0, currentTimeMillis, a2);
        }
    }

    public void a(long j2) {
        try {
            Thread.sleep(j2);
        } catch (InterruptedException unused) {
        }
    }

    public boolean a() {
        int i2 = 536870912;
        try {
            if (a.b()) {
                i2 = 570425344;
            }
            PendingIntent a2 = a(this.f5343c, i2);
            if (Build.VERSION.SDK_INT >= 30) {
                if (a2 != null) {
                    a2.cancel();
                }
                List historicalProcessExitReasons = ((ActivityManager) this.f5343c.getSystemService("activity")).getHistoricalProcessExitReasons((String) null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    for (int i3 = 0; i3 < historicalProcessExitReasons.size(); i3++) {
                        if (((ApplicationExitInfo) historicalProcessExitReasons.get(i3)).getReason() == 10) {
                            return true;
                        }
                    }
                }
            } else if (a2 == null) {
                b(this.f5343c);
                return true;
            }
            return false;
        } catch (IllegalArgumentException | SecurityException e2) {
            j.a().d(f5341a, "Ignoring exception", e2);
            return true;
        }
    }

    public void b() {
        boolean c2 = c();
        if (d()) {
            j.a().b(f5341a, "Rescheduling Workers.", new Throwable[0]);
            this.f5344d.i();
            this.f5344d.h().a(false);
        } else if (a()) {
            j.a().b(f5341a, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.f5344d.i();
        } else if (c2) {
            j.a().b(f5341a, "Found unfinished work, scheduling it.", new Throwable[0]);
            f.a(this.f5344d.d(), this.f5344d.c(), this.f5344d.e());
        }
    }

    public boolean c() {
        boolean a2 = Build.VERSION.SDK_INT >= 23 ? b.a(this.f5343c, this.f5344d) : false;
        WorkDatabase c2 = this.f5344d.c();
        q o2 = c2.o();
        n t2 = c2.t();
        c2.g();
        try {
            List<p> d2 = o2.d();
            boolean z2 = d2 != null && !d2.isEmpty();
            if (z2) {
                for (p next : d2) {
                    o2.a(WorkInfo.State.ENQUEUED, next.f5495a);
                    o2.b(next.f5495a, -1);
                }
            }
            t2.a();
            c2.j();
            return z2 || a2;
        } finally {
            c2.h();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f5344d.h().a();
    }

    public boolean e() {
        androidx.work.a d2 = this.f5344d.d();
        if (TextUtils.isEmpty(d2.i())) {
            j.a().b(f5341a, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean a2 = f.a(this.f5343c, d2);
        j.a().b(f5341a, String.format("Is default app process = %s", new Object[]{Boolean.valueOf(a2)}), new Throwable[0]);
        return a2;
    }

    public void run() {
        try {
            if (!e()) {
                this.f5344d.j();
                return;
            }
            while (true) {
                i.a(this.f5343c);
                j.a().b(f5341a, "Performing cleanup operations.", new Throwable[0]);
                b();
                break;
            }
            this.f5344d.j();
        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e2) {
            int i2 = this.f5345e + 1;
            this.f5345e = i2;
            if (i2 >= 3) {
                j a2 = j.a();
                String str = f5341a;
                a2.e(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                g k2 = this.f5344d.d().k();
                if (k2 != null) {
                    j.a().b(str, "Routing exception to the specified exception handler", illegalStateException);
                    k2.a(illegalStateException);
                } else {
                    throw illegalStateException;
                }
            } else {
                j.a().b(f5341a, String.format("Retrying after %s", new Object[]{Long.valueOf(((long) i2) * 300)}), e2);
                a(((long) this.f5345e) * 300);
            }
        } catch (Throwable th) {
            this.f5344d.j();
            throw th;
        }
    }
}
