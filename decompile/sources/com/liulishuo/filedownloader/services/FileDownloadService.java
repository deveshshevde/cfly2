package com.liulishuo.filedownloader.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.liulishuo.filedownloader.ab;
import com.liulishuo.filedownloader.download.c;
import io.b;
import iq.d;
import iq.e;
import iq.f;
import java.lang.ref.WeakReference;

public class FileDownloadService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private j f21441a;

    /* renamed from: b  reason: collision with root package name */
    private ab f21442b;

    public static class SeparateProcessService extends FileDownloadService {
    }

    public static class SharedMainProcessService extends FileDownloadService {
    }

    private void a(Intent intent) {
        if (intent != null && intent.getBooleanExtra("is_foreground", false)) {
            i d2 = c.a().d();
            if (d2.d() && Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(d2.b(), d2.c(), 2);
                NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.createNotificationChannel(notificationChannel);
                } else {
                    return;
                }
            }
            startForeground(d2.a(), d2.a((Context) this));
            if (d.f29057a) {
                d.c(this, "run service foreground with config: %s", d2);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f21441a.a(intent);
    }

    public void onCreate() {
        super.onCreate();
        iq.c.a(this);
        try {
            f.a(e.a().f29058a);
            f.a(e.a().f29059b);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        g gVar = new g();
        this.f21441a = e.a().f29061d ? new e(new WeakReference(this), gVar) : new d(new WeakReference(this), gVar);
        ab.b();
        ab abVar = new ab((b) this.f21441a);
        this.f21442b = abVar;
        abVar.c();
    }

    public void onDestroy() {
        this.f21442b.d();
        stopForeground(true);
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        this.f21441a.a(intent, i2, i3);
        a(intent);
        return 1;
    }
}
