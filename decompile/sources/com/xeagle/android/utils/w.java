package com.xeagle.android.utils;

import com.flypro.core.drone.DroneInterfaces;
import java.util.Timer;
import java.util.TimerTask;

public class w {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Timer f24534a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f24535b;

    /* renamed from: c  reason: collision with root package name */
    private long f24536c;

    /* renamed from: d  reason: collision with root package name */
    private int f24537d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public DroneInterfaces.e f24538e;

    public w(DroneInterfaces.e eVar) {
        this.f24538e = eVar;
    }

    static /* synthetic */ int b(w wVar) {
        int i2 = wVar.f24535b;
        wVar.f24535b = i2 + 1;
        return i2;
    }

    public int a() {
        int i2 = this.f24537d;
        if (i2 <= 0) {
            return 3;
        }
        return i2;
    }

    public void a(int i2) {
        this.f24537d = i2;
    }

    public void a(long j2) {
        this.f24536c = j2;
    }

    public synchronized void a(long j2, boolean z2) {
        b();
        if (z2) {
            this.f24535b = 0;
        }
        if (this.f24534a == null) {
            Timer timer = new Timer();
            this.f24534a = timer;
            timer.schedule(new TimerTask() {
                public void run() {
                    if (w.this.f24534a != null) {
                        w.this.b();
                        w.b(w.this);
                        w.this.f24538e.notifyTimeOut(w.this.f24535b);
                    }
                }
            }, j2);
        }
    }

    public void a(boolean z2) {
        a(this.f24536c, z2);
    }

    public synchronized void b() {
        Timer timer = this.f24534a;
        if (timer != null) {
            timer.cancel();
            this.f24534a = null;
        }
    }

    public void c() {
        a(this.f24536c, true);
    }
}
