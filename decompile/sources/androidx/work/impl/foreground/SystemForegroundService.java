package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleService;
import androidx.work.impl.foreground.b;
import androidx.work.j;

public class SystemForegroundService extends LifecycleService implements b.a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f5243c = j.a("SystemFgService");

    /* renamed from: d  reason: collision with root package name */
    private static SystemForegroundService f5244d = null;

    /* renamed from: a  reason: collision with root package name */
    b f5245a;

    /* renamed from: b  reason: collision with root package name */
    NotificationManager f5246b;

    /* renamed from: e  reason: collision with root package name */
    private Handler f5247e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5248f;

    private void b() {
        this.f5247e = new Handler(Looper.getMainLooper());
        this.f5246b = (NotificationManager) getApplicationContext().getSystemService("notification");
        b bVar = new b(getApplicationContext());
        this.f5245a = bVar;
        bVar.a((b.a) this);
    }

    public void a() {
        this.f5248f = true;
        j.a().b(f5243c, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        f5244d = null;
        stopSelf();
    }

    public void a(final int i2) {
        this.f5247e.post(new Runnable() {
            public void run() {
                SystemForegroundService.this.f5246b.cancel(i2);
            }
        });
    }

    public void a(final int i2, final int i3, final Notification notification) {
        this.f5247e.post(new Runnable() {
            public void run() {
                if (Build.VERSION.SDK_INT >= 29) {
                    SystemForegroundService.this.startForeground(i2, notification, i3);
                } else {
                    SystemForegroundService.this.startForeground(i2, notification);
                }
            }
        });
    }

    public void a(final int i2, final Notification notification) {
        this.f5247e.post(new Runnable() {
            public void run() {
                SystemForegroundService.this.f5246b.notify(i2, notification);
            }
        });
    }

    public void onCreate() {
        super.onCreate();
        f5244d = this;
        b();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f5245a.a();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.f5248f) {
            j.a().c(f5243c, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f5245a.a();
            b();
            this.f5248f = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f5245a.a(intent);
        return 3;
    }
}
