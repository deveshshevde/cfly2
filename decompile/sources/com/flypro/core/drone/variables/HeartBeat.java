package com.flypro.core.drone.variables;

import android.util.Log;
import com.MAVLink.common.msg_heartbeat;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.d;
import dy.ak;
import dy.al;
import dy.am;
import dy.k;
import en.a;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class HeartBeat extends d implements DroneInterfaces.c {

    /* renamed from: a  reason: collision with root package name */
    public HeartbeatState f11562a = HeartbeatState.FIRST_HEARTBEAT;

    /* renamed from: c  reason: collision with root package name */
    public int f11563c = 1;

    /* renamed from: d  reason: collision with root package name */
    public final DroneInterfaces.b f11564d;

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f11565e = new Runnable() {
        public void run() {
            HeartBeat.this.e();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private byte f11566f = -1;

    /* renamed from: com.flypro.core.drone.variables.HeartBeat$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14230a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f14231b;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14231b = r0
                r1 = 1
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r2 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CALIBRATION_IMU     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f14231b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f14231b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r4 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.flypro.core.drone.variables.HeartBeat$HeartbeatState[] r3 = com.flypro.core.drone.variables.HeartBeat.HeartbeatState.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f14230a = r3
                com.flypro.core.drone.variables.HeartBeat$HeartbeatState r4 = com.flypro.core.drone.variables.HeartBeat.HeartbeatState.FIRST_HEARTBEAT     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f14230a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.flypro.core.drone.variables.HeartBeat$HeartbeatState r3 = com.flypro.core.drone.variables.HeartBeat.HeartbeatState.LOST_HEARTBEAT     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f14230a     // Catch:{ NoSuchFieldError -> 0x004d }
                com.flypro.core.drone.variables.HeartBeat$HeartbeatState r1 = com.flypro.core.drone.variables.HeartBeat.HeartbeatState.IMU_CALIBRATION     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flypro.core.drone.variables.HeartBeat.AnonymousClass2.<clinit>():void");
        }
    }

    public enum HeartbeatState {
        FIRST_HEARTBEAT,
        LOST_HEARTBEAT,
        NORMAL_HEARTBEAT,
        IMU_CALIBRATION
    }

    public HeartBeat(a aVar, DroneInterfaces.b bVar) {
        super(aVar);
        this.f11564d = bVar;
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
        aVar.a((DroneInterfaces.c) this);
    }

    private void a(long j2) {
        this.f11564d.removeCallbacks(this.f11565e);
        this.f11564d.postDelayed(this.f11565e, j2);
    }

    private void c() {
        a(5000);
    }

    private void d() {
        this.f11564d.removeCallbacks(this.f11565e);
        this.f11562a = HeartbeatState.FIRST_HEARTBEAT;
        this.f11566f = -1;
    }

    /* access modifiers changed from: private */
    public void e() {
        Object obj;
        c cVar;
        if (AnonymousClass2.f14230a[this.f11562a.ordinal()] != 3) {
            this.f11562a = HeartbeatState.LOST_HEARTBEAT;
            a(15000);
            Log.i("HEART", "onHeartbeatTimeout: ------DATA LINK LOST,CHECK CONNECTION");
            cVar = c.a();
            obj = new am(5);
        } else {
            a(35000);
            cVar = c.a();
            obj = new dy.d(28);
        }
        cVar.d(obj);
    }

    public byte a() {
        return this.f11566f;
    }

    public void a(msg_heartbeat msg_heartbeat) {
        c cVar;
        Object obj;
        this.f11563c = msg_heartbeat.f6278a;
        this.f11566f = msg_heartbeat.f6737i;
        int i2 = AnonymousClass2.f14230a[this.f11562a.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                Log.i("HEART", "onHeartbeat: ---->>>>heart restore");
                cVar = c.a();
                obj = new al(7);
            }
            this.f11562a = HeartbeatState.NORMAL_HEARTBEAT;
            a(5000);
        }
        Log.i("HEART", "onHeartbeat: --->>>first heart");
        cVar = c.a();
        obj = new ak(6);
        cVar.d(obj);
        this.f11562a = HeartbeatState.NORMAL_HEARTBEAT;
        a(5000);
    }

    public boolean b() {
        return this.f11562a != HeartbeatState.LOST_HEARTBEAT;
    }

    @l(a = ThreadMode.BACKGROUND)
    public void calibrateImuEvent(dy.c cVar) {
        if (cVar.a() == 27) {
            this.f11562a = HeartbeatState.IMU_CALIBRATION;
            a(35000);
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void disConnectedEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            Log.i("HEART", "disConnectedEvent:--------- ");
            d();
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void droneConnectEvent(k kVar) {
        if (kVar.a() == 0) {
            Log.i("HEART", "droneConnectEvent: NOTIFY CONNECT");
            c();
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        int i2 = AnonymousClass2.f14231b[droneEventsType.ordinal()];
        if (i2 == 1) {
            this.f11562a = HeartbeatState.IMU_CALIBRATION;
            a(35000);
        } else if (i2 == 2) {
            c();
        } else if (i2 == 3) {
            d();
        }
    }
}
