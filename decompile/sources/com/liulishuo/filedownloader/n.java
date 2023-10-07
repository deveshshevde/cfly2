package com.liulishuo.filedownloader;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.services.FileDownloadService;
import com.liulishuo.filedownloader.services.e;
import iq.a;
import iq.d;
import iq.f;
import java.util.ArrayList;
import java.util.List;

class n implements e.a, u {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f21426a = FileDownloadService.SharedMainProcessService.class;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21427b = false;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<Runnable> f21428c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private e f21429d;

    n() {
    }

    public void a(Context context) {
        a(context, (Runnable) null);
    }

    public void a(Context context, Runnable runnable) {
        if (runnable != null && !this.f21428c.contains(runnable)) {
            this.f21428c.add(runnable);
        }
        Intent intent = new Intent(context, f21426a);
        boolean d2 = f.d(context);
        this.f21427b = d2;
        intent.putExtra("is_foreground", d2);
        if (this.f21427b) {
            if (d.f29057a) {
                d.c(this, "start foreground service", new Object[0]);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
                return;
            }
            return;
        }
        context.startService(intent);
    }

    public void a(e eVar) {
        this.f21429d = eVar;
        this.f21428c.clear();
        for (Runnable run : (List) this.f21428c.clone()) {
            run.run();
        }
        f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, f21426a));
    }

    public void a(boolean z2) {
        if (!d()) {
            a.a(z2);
            return;
        }
        this.f21429d.a(z2);
        this.f21427b = false;
    }

    public boolean a(int i2) {
        return !d() ? a.a(i2) : this.f21429d.a(i2);
    }

    public boolean a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, FileDownloadHeader fileDownloadHeader, boolean z4) {
        if (!d()) {
            return a.a(str, str2, z2);
        }
        this.f21429d.a(str, str2, z2, i2, i3, i4, z3, fileDownloadHeader, z4);
        return true;
    }

    public byte b(int i2) {
        return !d() ? a.b(i2) : this.f21429d.e(i2);
    }

    public void b(Context context) {
        context.stopService(new Intent(context, f21426a));
        this.f21429d = null;
    }

    public void c() {
        if (!d()) {
            a.a();
        } else {
            this.f21429d.a();
        }
    }

    public boolean c(int i2) {
        return !d() ? a.c(i2) : this.f21429d.b(i2);
    }

    public boolean d() {
        return this.f21429d != null;
    }

    public void e() {
        if (!d()) {
            a.b();
        } else {
            this.f21429d.c();
        }
    }

    public boolean f() {
        return this.f21427b;
    }
}
