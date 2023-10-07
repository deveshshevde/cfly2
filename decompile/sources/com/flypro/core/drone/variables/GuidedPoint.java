package com.flypro.core.drone.variables;

import android.content.Context;
import android.util.Log;
import com.MAVLink.Messages.ApmModes;
import com.flypro.core.MAVLink.h;
import com.flypro.core.MAVLink.n;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.d;
import dy.ai;
import dy.ak;
import dy.al;
import dy.am;
import dy.s;
import ef.a;
import fg.i;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class GuidedPoint extends d implements DroneInterfaces.c {

    /* renamed from: a  reason: collision with root package name */
    private GuidedStates f11558a = GuidedStates.UNINITIALIZED;

    /* renamed from: c  reason: collision with root package name */
    private a f11559c = new a(i.f27244a, i.f27244a);

    /* renamed from: d  reason: collision with root package name */
    private ej.a f11560d = new ej.a(20.0d);

    /* renamed from: e  reason: collision with root package name */
    private Runnable f11561e;

    /* renamed from: com.flypro.core.drone.variables.GuidedPoint$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14223a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f14224b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0058 */
        static {
            /*
                com.flypro.core.drone.variables.GuidedPoint$GuidedStates[] r0 = com.flypro.core.drone.variables.GuidedPoint.GuidedStates.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14224b = r0
                r1 = 1
                com.flypro.core.drone.variables.GuidedPoint$GuidedStates r2 = com.flypro.core.drone.variables.GuidedPoint.GuidedStates.UNINITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f14224b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.variables.GuidedPoint$GuidedStates r3 = com.flypro.core.drone.variables.GuidedPoint.GuidedStates.IDLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f14224b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.variables.GuidedPoint$GuidedStates r4 = com.flypro.core.drone.variables.GuidedPoint.GuidedStates.ACTIVE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f14223a = r3
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r4 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MODE     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f14223a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_FIRST     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f14223a     // Catch:{ NoSuchFieldError -> 0x004d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_RESTORED     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f14223a     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f14223a     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flypro.core.drone.variables.GuidedPoint.AnonymousClass2.<clinit>():void");
        }
    }

    private enum GuidedStates {
        UNINITIALIZED,
        IDLE,
        ACTIVE
    }

    public GuidedPoint(en.a aVar) {
        super(aVar);
        aVar.a((DroneInterfaces.c) this);
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
    }

    public static void a(Context context, en.a aVar, a aVar2, double d2) {
        c.a().d(new ai(13));
        if (aVar2 != null) {
            h.a(context, aVar, aVar2.d(), aVar2.c(), d2);
        }
    }

    public static void a(en.a aVar, Context context) {
        ApmModes apmModes;
        aa d2 = aVar.d();
        int f2 = aVar.f();
        if (ad.b(f2)) {
            apmModes = ApmModes.ROTOR_GUIDED;
        } else if (ad.c(f2)) {
            a(context, aVar, aVar.b().b(), c(aVar));
            return;
        } else if (ad.d(f2)) {
            apmModes = ApmModes.ROVER_GUIDED;
        } else {
            return;
        }
        d2.b(apmModes);
    }

    public static void a(en.a aVar, a aVar2, double d2) {
        if (aVar2 != null) {
            h.a(aVar, aVar2.d(), aVar2.c(), d2);
        }
    }

    public static boolean a(en.a aVar) {
        int f2 = aVar.f();
        ApmModes e2 = aVar.d().e();
        return ad.b(f2) ? e2 == ApmModes.ROTOR_GUIDED : ad.c(f2) ? e2 == ApmModes.FIXED_WING_GUIDED : ad.d(f2) && e2 == ApmModes.ROVER_GUIDED;
    }

    public static float b(en.a aVar) {
        int f2 = aVar.f();
        if (ad.b(f2)) {
            return 2.0f;
        }
        return ad.c(f2) ? 15.0f : 0.0f;
    }

    private void b(Context context) {
        if (this.f11558a == GuidedStates.ACTIVE) {
            a(context, this.f11557b, this.f11559c, this.f11560d.a());
        }
    }

    private void b(Context context, double d2) {
        int i2 = AnonymousClass2.f14224b[this.f11558a.ordinal()];
        if (i2 == 2) {
            this.f11558a = GuidedStates.ACTIVE;
        } else if (i2 != 3) {
            return;
        }
        this.f11560d.a(Math.max(d2, (double) b(this.f11557b)));
        b(context);
    }

    private void b(a aVar) {
        int i2 = AnonymousClass2.f14224b[this.f11558a.ordinal()];
        if (i2 == 2) {
            this.f11558a = GuidedStates.ACTIVE;
        } else if (i2 != 3) {
            return;
        }
        this.f11559c = aVar;
        h();
    }

    private static double c(en.a aVar) {
        return Math.max(Math.floor(aVar.t().a()), (double) b(aVar));
    }

    /* access modifiers changed from: private */
    public void c(Context context, a aVar) {
        int i2 = AnonymousClass2.f14224b[this.f11558a.ordinal()];
        if (i2 == 2) {
            this.f11558a = GuidedStates.ACTIVE;
        } else if (i2 != 3) {
            return;
        }
        this.f11559c = aVar;
        b(context);
    }

    private void f() {
        if (this.f11558a == GuidedStates.UNINITIALIZED) {
            this.f11559c = this.f11557b.b().b();
            this.f11560d.a(c(this.f11557b));
            this.f11558a = GuidedStates.IDLE;
            c.a().d(new ai(13));
        }
        Runnable runnable = this.f11561e;
        if (runnable != null) {
            runnable.run();
            this.f11561e = null;
        }
    }

    private void g() {
        this.f11558a = GuidedStates.UNINITIALIZED;
        c.a().d(new ai(13));
    }

    private void h() {
        if (this.f11558a == GuidedStates.ACTIVE) {
            a(this.f11557b, this.f11559c, this.f11560d.a());
        }
    }

    public a a() {
        return this.f11559c;
    }

    public void a(Context context) {
        if (this.f11558a != GuidedStates.ACTIVE) {
            a(this.f11557b, context);
        } else {
            a(context, this.f11557b.b().b());
        }
    }

    public void a(Context context, double d2) {
        b(context, d2);
    }

    public void a(Context context, a aVar) {
        c(context, aVar);
    }

    public void a(Context context, ej.a aVar) {
        if (ad.b(this.f11557b.f())) {
            this.f11559c = this.f11557b.b().b();
            this.f11560d.a(aVar.a());
            this.f11558a = GuidedStates.IDLE;
            a(this.f11557b, context);
            n.a(this.f11557b, aVar);
            c.a().d(new ai(13));
        }
    }

    public void a(a aVar) {
        b(aVar);
    }

    public ej.a b() {
        return this.f11560d;
    }

    public void b(final Context context, final a aVar) throws Exception {
        if (this.f11557b.b().g() == 3) {
            Log.i("google", "forcedGuidedCoordinate:---->>> " + aVar.d());
            if (e()) {
                c(context, aVar);
                return;
            }
            this.f11561e = new Runnable() {
                public void run() {
                    GuidedPoint.this.c(context, aVar);
                }
            };
            a(this.f11557b, context);
            return;
        }
        throw new Exception("Bad GPS for guided");
    }

    public boolean c() {
        return this.f11558a == GuidedStates.ACTIVE;
    }

    public boolean d() {
        return this.f11558a == GuidedStates.IDLE;
    }

    @l(a = ThreadMode.BACKGROUND)
    public void disConnectedEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            g();
        }
    }

    public boolean e() {
        return this.f11558a != GuidedStates.UNINITIALIZED;
    }

    @l(a = ThreadMode.BACKGROUND)
    public void heartbearFirst(ak akVar) {
        if (akVar.a() != 6) {
            return;
        }
        if (a(this.f11557b)) {
            f();
        } else {
            g();
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void heartbeatRestoredEvent(al alVar) {
        if (alVar.a() != 7) {
            return;
        }
        if (a(this.f11557b)) {
            f();
        } else {
            g();
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void heartbeatTimeoutEvent(am amVar) {
        if (amVar.a() == 5) {
            g();
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void modeEvent(s sVar) {
        if (sVar.a() != 4) {
            return;
        }
        if (a(this.f11557b)) {
            f();
        } else {
            g();
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        int i2 = AnonymousClass2.f14223a[droneEventsType.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            if (a(this.f11557b)) {
                f();
                return;
            }
        } else if (!(i2 == 4 || i2 == 5)) {
            return;
        }
        g();
    }
}
