package com.flypro.core.MAVLink;

import android.util.Log;
import com.MAVLink.common.msg_mission_item;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.d;
import dy.as;
import ec.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.c;

public class WaypointManager extends d implements DroneInterfaces.e {

    /* renamed from: a  reason: collision with root package name */
    WaypointStates f14101a = WaypointStates.IDLE;

    /* renamed from: c  reason: collision with root package name */
    private TimeOut_Type f14102c = TimeOut_Type.NO_TIMEOUT;

    /* renamed from: d  reason: collision with root package name */
    private int f14103d;

    /* renamed from: e  reason: collision with root package name */
    private int f14104e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14105f = 5;

    /* renamed from: g  reason: collision with root package name */
    private a f14106g = new a(this);

    /* renamed from: h  reason: collision with root package name */
    private DroneInterfaces.f f14107h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14108i = false;

    /* renamed from: j  reason: collision with root package name */
    private b f14109j = new b();

    /* renamed from: k  reason: collision with root package name */
    private int f14110k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f14111l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f14112m = -1;

    /* renamed from: n  reason: collision with root package name */
    private List<msg_mission_item> f14113n = new ArrayList();

    /* renamed from: com.flypro.core.MAVLink.WaypointManager$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14114a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f14115b;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0063 */
        static {
            /*
                com.flypro.core.MAVLink.WaypointManager$TimeOut_Type[] r0 = com.flypro.core.MAVLink.WaypointManager.TimeOut_Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14115b = r0
                r1 = 1
                com.flypro.core.MAVLink.WaypointManager$TimeOut_Type r2 = com.flypro.core.MAVLink.WaypointManager.TimeOut_Type.NO_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f14115b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.MAVLink.WaypointManager$TimeOut_Type r3 = com.flypro.core.MAVLink.WaypointManager.TimeOut_Type.WP_COUNT_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f14115b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.MAVLink.WaypointManager$TimeOut_Type r4 = com.flypro.core.MAVLink.WaypointManager.TimeOut_Type.REQUEST_LIST_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.flypro.core.MAVLink.WaypointManager$WaypointStates[] r3 = com.flypro.core.MAVLink.WaypointManager.WaypointStates.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f14114a = r3
                com.flypro.core.MAVLink.WaypointManager$WaypointStates r4 = com.flypro.core.MAVLink.WaypointManager.WaypointStates.IDLE     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f14114a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.flypro.core.MAVLink.WaypointManager$WaypointStates r3 = com.flypro.core.MAVLink.WaypointManager.WaypointStates.READ_REQUEST     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f14114a     // Catch:{ NoSuchFieldError -> 0x004d }
                com.flypro.core.MAVLink.WaypointManager$WaypointStates r1 = com.flypro.core.MAVLink.WaypointManager.WaypointStates.READING_WP     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f14114a     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.flypro.core.MAVLink.WaypointManager$WaypointStates r1 = com.flypro.core.MAVLink.WaypointManager.WaypointStates.WRITING_WP_COUNT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f14114a     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.flypro.core.MAVLink.WaypointManager$WaypointStates r1 = com.flypro.core.MAVLink.WaypointManager.WaypointStates.WRITING_WP     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = f14114a     // Catch:{ NoSuchFieldError -> 0x006e }
                com.flypro.core.MAVLink.WaypointManager$WaypointStates r1 = com.flypro.core.MAVLink.WaypointManager.WaypointStates.WAITING_WRITE_ACK     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flypro.core.MAVLink.WaypointManager.AnonymousClass1.<clinit>():void");
        }
    }

    public enum TimeOut_Type {
        NO_TIMEOUT,
        WP_COUNT_TIMEOUT,
        REQUEST_LIST_TIMEOUT
    }

    public enum WaypointEvent_Type {
        WP_UPLOAD,
        WP_DOWNLOAD,
        WP_RETRY,
        WP_CONTINUE,
        WP_TIMED_OUT
    }

    enum WaypointStates {
        IDLE,
        READ_REQUEST,
        READING_WP,
        WRITING_WP_COUNT,
        WRITING_WP,
        WAITING_WRITE_ACK
    }

    private class a {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Timer f14134b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f14135c;

        /* renamed from: d  reason: collision with root package name */
        private long f14136d;

        /* renamed from: e  reason: collision with root package name */
        private int f14137e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public DroneInterfaces.e f14138f;

        public a(DroneInterfaces.e eVar) {
            this.f14138f = eVar;
        }

        static /* synthetic */ int b(a aVar) {
            int i2 = aVar.f14135c;
            aVar.f14135c = i2 + 1;
            return i2;
        }

        public int a() {
            int i2 = this.f14137e;
            if (i2 <= 0) {
                return 3;
            }
            return i2;
        }

        public void a(int i2) {
            this.f14137e = i2;
        }

        public void a(long j2) {
            this.f14136d = j2;
        }

        public synchronized void a(long j2, boolean z2) {
            b();
            if (z2) {
                this.f14135c = 0;
            }
            if (this.f14134b == null) {
                Timer timer = new Timer();
                this.f14134b = timer;
                timer.schedule(new TimerTask() {
                    public void run() {
                        if (a.this.f14134b != null) {
                            a.this.b();
                            a.b(a.this);
                            a.this.f14138f.notifyTimeOut(a.this.f14135c);
                        }
                    }
                }, j2);
            }
        }

        public void a(boolean z2) {
            a(this.f14136d, z2);
        }

        public synchronized void b() {
            Timer timer = this.f14134b;
            if (timer != null) {
                timer.cancel();
                this.f14134b = null;
            }
        }

        public void c() {
            a(this.f14136d, true);
        }
    }

    public WaypointManager(en.a aVar) {
        super(aVar);
    }

    private void a(WaypointEvent_Type waypointEvent_Type) {
        this.f14104e = 0;
        DroneInterfaces.f fVar = this.f14107h;
        if (fVar != null) {
            fVar.a(waypointEvent_Type);
        }
    }

    private void a(WaypointEvent_Type waypointEvent_Type, int i2, int i3) {
        this.f14104e = 0;
        DroneInterfaces.f fVar = this.f14107h;
        if (fVar != null) {
            fVar.a(waypointEvent_Type, i2, i3);
        }
    }

    public void a() {
        if (this.f14101a == WaypointStates.IDLE) {
            Log.i("google", "getWaypoints: --->>>>");
            a(WaypointEvent_Type.WP_DOWNLOAD);
            this.f14103d = -1;
            this.f14106g.a(3000);
            this.f14106g.a(5);
            this.f14101a = WaypointStates.READ_REQUEST;
            this.f14106g.c();
            o.a(this.f11557b);
        }
    }

    public void a(int i2) {
        if (this.f14113n != null) {
            o.a(this.f11557b, (short) i2);
        }
    }

    public void notifyTimeOut(int i2) {
        c a2;
        as asVar;
        Log.i("google", "notifyTimeOut:---->>>> " + i2 + "...type-----" + this.f14102c.name());
        if (i2 >= this.f14106g.a()) {
            this.f14101a = WaypointStates.IDLE;
            a(WaypointEvent_Type.WP_TIMED_OUT, this.f14104e, 5);
            a2 = c.a();
            asVar = new as(63);
        } else {
            this.f14106g.a(false);
            int i3 = AnonymousClass1.f14115b[this.f14102c.ordinal()];
            if (i3 == 1) {
                if (i2 >= this.f14106g.a()) {
                }
                return;
            } else if (i3 == 2) {
                o.a(this.f11557b, this.f14113n.size());
                if (i2 >= this.f14106g.a()) {
                    this.f14102c = TimeOut_Type.NO_TIMEOUT;
                    a2 = c.a();
                    asVar = new as(63);
                } else {
                    return;
                }
            } else if (i3 == 3) {
                o.a(this.f11557b);
                if (i2 >= this.f14106g.a()) {
                    this.f14102c = TimeOut_Type.NO_TIMEOUT;
                    this.f14108i = false;
                    a2 = c.a();
                    asVar = new as(63);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        a2.d(asVar);
    }
}
