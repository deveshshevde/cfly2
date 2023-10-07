package com.flypro.core.drone.variables;

import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.d;
import com.flypro.core.firmware.FirmwareType;
import dy.aa;
import dy.ab;
import en.a;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class ad extends d implements DroneInterfaces.c {

    /* renamed from: a  reason: collision with root package name */
    private int f11583a = 0;

    /* renamed from: c  reason: collision with root package name */
    private String f11584c = null;

    /* renamed from: com.flypro.core.drone.variables.ad$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14285a;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f14285a = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public ad(a aVar) {
        super(aVar);
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
        aVar.a((DroneInterfaces.c) this);
    }

    public static boolean b(int i2) {
        if (i2 == 2 || i2 == 4) {
            return true;
        }
        switch (i2) {
            case 13:
            case 14:
            case 15:
                return true;
            default:
                return false;
        }
    }

    public static boolean c(int i2) {
        return i2 == 1;
    }

    public static boolean d(int i2) {
        return i2 == 10;
    }

    public int a() {
        return this.f11583a;
    }

    public void a(int i2) {
        if (this.f11583a != i2) {
            this.f11583a = i2;
            c.a().d(new aa(3));
            this.f11557b.h();
        }
    }

    public void a(String str) {
        this.f11584c = str;
        c.a().d(new ab(65));
    }

    public FirmwareType b() {
        if (this.f11557b.j().a()) {
            int i2 = this.f11583a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (!(i2 == 2 || i2 == 3 || i2 == 4)) {
                        if (i2 != 10 && i2 != 11) {
                            switch (i2) {
                                case 13:
                                case 14:
                                case 15:
                                    break;
                            }
                        } else {
                            return FirmwareType.ARDU_ROVER;
                        }
                    }
                } else {
                    return FirmwareType.ARDU_PLANE;
                }
            }
            return FirmwareType.ARDU_COPTER;
        }
        return this.f11557b.k().a();
    }

    public String c() {
        return this.f11584c;
    }

    @l(a = ThreadMode.BACKGROUND)
    public void disConnectedEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            a(0);
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        if (AnonymousClass1.f14285a[droneEventsType.ordinal()] == 1) {
            a(0);
        }
    }
}
