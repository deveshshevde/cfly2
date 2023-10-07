package com.flypro.core.drone.variables;

import com.flypro.core.MAVLink.m;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.d;
import com.flypro.core.drone.e;
import dy.ak;
import dy.al;
import en.a;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class ac extends d implements DroneInterfaces.c {

    /* renamed from: com.flypro.core.drone.variables.ac$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14284a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14284a = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_FIRST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14284a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_RESTORED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flypro.core.drone.variables.ac.AnonymousClass1.<clinit>():void");
        }
    }

    public ac(a aVar) {
        super(aVar);
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
        aVar.a((DroneInterfaces.c) this);
    }

    public void a() {
        e.a b2 = this.f11557b.k().b();
        System.out.println(String.format("setupStreamRate: extendedStatus %dhz extra1 %dhz extra2 %dhz extra3 %dhz position %dhz rcChan %dhz rawSensor %dhz rawCtrl %dhz", new Object[]{Integer.valueOf(b2.f14210a), Integer.valueOf(b2.f14211b), Integer.valueOf(b2.f14212c), Integer.valueOf(b2.f14213d), Integer.valueOf(b2.f14214e), Integer.valueOf(b2.f14215f), Integer.valueOf(b2.f14216g), Integer.valueOf(b2.f14218i)}));
        m.a(this.f11557b.j(), b2.f14210a, b2.f14211b, b2.f14212c, b2.f14213d, b2.f14214e, b2.f14215f, b2.f14216g, b2.f14217h, b2.f14218i);
    }

    @l(a = ThreadMode.ASYNC)
    public void heartbeatFirst(ak akVar) {
        if (akVar.a() == 6) {
            a();
        }
    }

    @l(a = ThreadMode.ASYNC)
    public void heartbeatRestoredEvent(al alVar) {
        if (alVar.a() == 7) {
            a();
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        int i2 = AnonymousClass1.f14284a[droneEventsType.ordinal()];
        if (i2 == 1 || i2 == 2) {
            a();
        }
    }
}
