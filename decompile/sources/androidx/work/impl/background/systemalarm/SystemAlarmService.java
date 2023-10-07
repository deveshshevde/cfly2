package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import androidx.work.impl.background.systemalarm.e;
import androidx.work.j;

public class SystemAlarmService extends LifecycleService implements e.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5172a = j.a("SystemAlarmService");

    /* renamed from: b  reason: collision with root package name */
    private e f5173b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5174c;

    private void b() {
        e eVar = new e(this);
        this.f5173b = eVar;
        eVar.a((e.b) this);
    }

    public void a() {
        this.f5174c = true;
        j.a().b(f5172a, "All commands completed in dispatcher", new Throwable[0]);
        androidx.work.impl.utils.j.a();
        stopSelf();
    }

    public void onCreate() {
        super.onCreate();
        b();
        this.f5174c = false;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f5174c = true;
        this.f5173b.a();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.f5174c) {
            j.a().c(f5172a, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f5173b.a();
            b();
            this.f5174c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f5173b.a(intent, i3);
        return 3;
    }
}
