package com.flypro.core.drone.variables;

import com.MAVLink.Messages.ApmModes;
import com.MAVLink.common.msg_rc_channels_override;
import com.flypro.core.MAVLink.k;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.d;
import en.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ab extends d {

    /* renamed from: a  reason: collision with root package name */
    public int[] f14273a = new int[10];

    /* renamed from: c  reason: collision with root package name */
    public boolean f14274c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14275d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14276e;

    /* renamed from: f  reason: collision with root package name */
    public int f14277f;

    /* renamed from: g  reason: collision with root package name */
    public String f14278g;

    /* renamed from: h  reason: collision with root package name */
    public List<msg_rc_channels_override> f14279h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public List<msg_rc_channels_override> f14280i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private ScheduledExecutorService f14281j;

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f14282k = new Runnable() {
        public void run() {
            DroneInterfaces.DroneEventsType droneEventsType;
            a aVar;
            if (ab.this.f14276e) {
                if (ab.this.f14277f < ab.this.f14280i.size()) {
                    k.a(ab.this.f11557b, ab.this.f14280i.get(ab.this.f14277f));
                    ab.this.f14277f++;
                    if (ab.this.f14277f % 25 == 0) {
                        aVar = ab.this.f11557b;
                        droneEventsType = DroneInterfaces.DroneEventsType.PLAY_PROGRESS;
                    } else {
                        return;
                    }
                } else {
                    ab.this.f14276e = false;
                    ab.this.f11557b.a(DroneInterfaces.DroneEventsType.PLAY_PROGRESS);
                    aVar = ab.this.f11557b;
                    droneEventsType = DroneInterfaces.DroneEventsType.PLAY_END;
                }
                aVar.a(droneEventsType);
            } else if (ab.this.f14274c) {
                ab.this.f11557b.d().b(ApmModes.ROTOR_LOITER);
            } else {
                k.a(ab.this.f11557b, ab.this.f14273a, ab.this.f14275d, ab.this.f14279h);
            }
        }
    };

    public ab(a aVar) {
        super(aVar);
    }

    private boolean f() {
        return this.f14281j != null;
    }

    public void a() {
        if (f()) {
            this.f14281j.shutdownNow();
            this.f14281j = null;
            b();
        }
    }

    public void a(int i2, double d2) {
        this.f14273a[i2] = (int) d2;
    }

    public void a(String str) {
        this.f14278g = str;
    }

    public void a(List<msg_rc_channels_override> list) {
        this.f14280i.clear();
        this.f14280i.addAll(list);
    }

    public void a(boolean z2) {
        if (this.f14276e != z2) {
            this.f14276e = z2;
        }
    }

    public void b() {
        this.f14276e = false;
        this.f14274c = false;
        this.f14275d = false;
        this.f14277f = 0;
    }

    public void b(boolean z2) {
        if (this.f14274c != z2) {
            this.f14274c = z2;
        }
    }

    public void c() {
        this.f14279h.clear();
    }

    public void c(boolean z2) {
        if (this.f14275d != z2) {
            this.f14275d = z2;
            this.f11557b.a(DroneInterfaces.DroneEventsType.RECORD_START);
        }
    }

    public List<msg_rc_channels_override> d() {
        return this.f14279h;
    }

    public void e() {
        if (!f()) {
            int[] iArr = this.f14273a;
            iArr[0] = 1500;
            iArr[1] = 1500;
            iArr[2] = 1500;
            iArr[3] = 1500;
            iArr[5] = 1100;
            iArr[6] = 1100;
            iArr[7] = 1400;
            iArr[8] = 1500;
            iArr[9] = 1500;
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f14281j = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.scheduleWithFixedDelay(this.f14282k, 0, 40, TimeUnit.MILLISECONDS);
        }
    }
}
