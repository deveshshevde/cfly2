package com.flypro.core.gcs.follow;

import android.content.Context;
import aq.d;
import com.MAVLink.Messages.ApmModes;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.variables.GuidedPoint;
import com.flypro.core.gcs.follow.FollowAlgorithm;
import dy.ae;
import dy.af;
import dy.ag;
import dy.ah;
import dy.s;
import ed.a;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class Follow implements DroneInterfaces.c, a.b {

    /* renamed from: a  reason: collision with root package name */
    private FollowStates f11602a = FollowStates.FOLLOW_INVALID_STATE;

    /* renamed from: b  reason: collision with root package name */
    private en.a f11603b;

    /* renamed from: c  reason: collision with root package name */
    private Context f11604c;

    /* renamed from: d  reason: collision with root package name */
    private ee.a f11605d;

    /* renamed from: e  reason: collision with root package name */
    private a.C0091a f11606e;

    /* renamed from: f  reason: collision with root package name */
    private FollowAlgorithm f11607f;

    /* renamed from: com.flypro.core.gcs.follow.Follow$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14410a;

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
                f14410a = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MODE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14410a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flypro.core.gcs.follow.Follow.AnonymousClass1.<clinit>():void");
        }
    }

    public enum FollowStates {
        FOLLOW_INVALID_STATE,
        FOLLOW_DRONE_NOT_ARMED,
        FOLLOW_DRONE_DISCONNECTED,
        FOLLOW_START,
        FOLLOW_RUNNING,
        FOLLOW_END
    }

    public Follow(Context context, en.a aVar, DroneInterfaces.b bVar, a.C0091a aVar2) {
        this.f11604c = context;
        this.f11603b = aVar;
        d.a(context.getApplicationContext());
        this.f11607f = FollowAlgorithm.FollowModes.RELATE.a(aVar, context);
        this.f11606e = aVar2;
        aVar2.a(this);
        this.f11605d = new ee.a(bVar, aVar, context);
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
        aVar.a((DroneInterfaces.c) this);
    }

    private void f() {
        this.f11606e.a();
        this.f11602a = FollowStates.FOLLOW_START;
        c.a().d(new af(32));
    }

    private void g() {
        this.f11606e.b();
        d.a("is_relate_key", false);
        if (this.f11603b.b().a()) {
            d.a("drone_lat_key", this.f11603b.b().b().d() + "");
            d.a("drone_lng_key", this.f11603b.b().b().c() + "");
        }
        if (b()) {
            this.f11602a = FollowStates.FOLLOW_END;
            this.f11603b.d().b(ApmModes.ROTOR_LOITER);
            c.a().d(new ag(33));
        }
    }

    public void a() {
        FollowStates followStates;
        if (this.f11603b.d() == null) {
            this.f11602a = FollowStates.FOLLOW_INVALID_STATE;
        } else if (b()) {
            g();
        } else {
            if (!this.f11603b.j().a()) {
                followStates = FollowStates.FOLLOW_DRONE_DISCONNECTED;
            } else if (this.f11603b.d().c()) {
                GuidedPoint.a(this.f11603b, this.f11604c);
                f();
                return;
            } else {
                followStates = FollowStates.FOLLOW_DRONE_NOT_ARMED;
            }
            this.f11602a = followStates;
        }
    }

    public void a(double d2) {
        this.f11607f.a(Double.valueOf(d2));
    }

    public void a(FollowAlgorithm.FollowModes followModes) {
        this.f11607f = followModes.a(this.f11603b, this.f11604c.getApplicationContext());
        c.a().d(new ae(35));
    }

    public void a(a aVar) {
        if (!aVar.b() || !this.f11603b.b().a()) {
            this.f11602a = FollowStates.FOLLOW_START;
        } else {
            this.f11602a = FollowStates.FOLLOW_RUNNING;
            this.f11607f.a(aVar);
            this.f11605d.a(aVar);
        }
        c.a().d(new ah(34));
    }

    public boolean b() {
        return this.f11602a == FollowStates.FOLLOW_RUNNING || this.f11602a == FollowStates.FOLLOW_START;
    }

    public ej.c c() {
        return this.f11607f.f14420c;
    }

    public FollowAlgorithm.FollowModes d() {
        return this.f11607f.a();
    }

    @l(a = ThreadMode.BACKGROUND)
    public void disConnectedEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            g();
        }
    }

    public FollowStates e() {
        return this.f11602a;
    }

    @l(a = ThreadMode.BACKGROUND)
    public void modeEvent(s sVar) {
        if (sVar.a() == 4 && !GuidedPoint.a(this.f11603b)) {
            g();
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        int i2 = AnonymousClass1.f14410a[droneEventsType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
        } else if (GuidedPoint.a(aVar)) {
            return;
        }
        g();
    }
}
