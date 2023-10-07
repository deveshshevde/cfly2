package km;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.util.SparseBooleanArray;
import com.cfly.uav_pro.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.fragments.r;
import com.xeagle.android.utils.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import km.a;

public class b implements a.C0211a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f30137b = "b";

    /* renamed from: a  reason: collision with root package name */
    public final a f30138a = new a();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f30139c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private final BroadcastReceiver f30140d = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (r.f23475a.equals(intent.getAction())) {
                b.this.e();
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, String> f30141e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private int f30142f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f30143g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final com.xeagle.android.utils.prefs.a f30144h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<String> f30145i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final Handler f30146j = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f30147k;

    /* renamed from: l  reason: collision with root package name */
    private final MediaPlayer.OnCompletionListener f30148l = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    };

    /* renamed from: m  reason: collision with root package name */
    private int f30149m = 0;

    /* renamed from: n  reason: collision with root package name */
    private String f30150n = "";

    /* renamed from: o  reason: collision with root package name */
    private boolean f30151o = false;

    /* renamed from: km.b$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30154a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f30155b;

        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|(3:63|64|66)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|66) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|66) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|66) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|66) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0079 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x008d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0097 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00c5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00d1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00dd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00f5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0101 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x010d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0119 */
        static {
            /*
                com.MAVLink.Messages.ApmModes[] r0 = com.MAVLink.Messages.ApmModes.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30155b = r0
                r1 = 1
                com.MAVLink.Messages.ApmModes r2 = com.MAVLink.Messages.ApmModes.FIXED_WING_FLY_BY_WIRE_A     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f30155b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.MAVLink.Messages.ApmModes r3 = com.MAVLink.Messages.ApmModes.FIXED_WING_FLY_BY_WIRE_B     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f30155b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.MAVLink.Messages.ApmModes r4 = com.MAVLink.Messages.ApmModes.ROTOR_ALT_HOLD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f30155b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.MAVLink.Messages.ApmModes r5 = com.MAVLink.Messages.ApmModes.ROTOR_CIRCLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f30155b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.MAVLink.Messages.ApmModes r6 = com.MAVLink.Messages.ApmModes.ROTOR_LOITER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f30155b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.MAVLink.Messages.ApmModes r7 = com.MAVLink.Messages.ApmModes.FIXED_WING_RTL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f30155b     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.MAVLink.Messages.ApmModes r8 = com.MAVLink.Messages.ApmModes.ROTOR_RTL     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r7 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r7 = r7.length
                int[] r7 = new int[r7]
                f30154a = r7
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r8 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.INVALID_POLYGON     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r7[r8] = r1     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                int[] r1 = f30154a     // Catch:{ NoSuchFieldError -> 0x006f }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r7 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.ARMING     // Catch:{ NoSuchFieldError -> 0x006f }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r1[r7] = r0     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r0 = f30154a     // Catch:{ NoSuchFieldError -> 0x0079 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.ARMING_STARTED     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r0 = f30154a     // Catch:{ NoSuchFieldError -> 0x0083 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.BATTERY     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f30154a     // Catch:{ NoSuchFieldError -> 0x008d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MODE     // Catch:{ NoSuchFieldError -> 0x008d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008d }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x008d }
            L_0x008d:
                int[] r0 = f30154a     // Catch:{ NoSuchFieldError -> 0x0097 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MISSION_SENT     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                int[] r0 = f30154a     // Catch:{ NoSuchFieldError -> 0x00a1 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.GPS_FIX     // Catch:{ NoSuchFieldError -> 0x00a1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                int[] r0 = f30154a     // Catch:{ NoSuchFieldError -> 0x00ad }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MISSION_RECEIVED     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r0 = f30154a     // Catch:{ NoSuchFieldError -> 0x00b9 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_FIRST     // Catch:{ NoSuchFieldError -> 0x00b9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b9 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b9 }
            L_0x00b9:
                int[] r0 = f30154a     // Catch:{ NoSuchFieldError -> 0x00c5 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x00c5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c5 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c5 }
            L_0x00c5:
                int[] r0 = f30154a     // Catch:{ NoSuchFieldError -> 0x00d1 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_RESTORED     // Catch:{ NoSuchFieldError -> 0x00d1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d1 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d1 }
            L_0x00d1:
                int[] r0 = f30154a     // Catch:{ NoSuchFieldError -> 0x00dd }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x00dd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dd }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dd }
            L_0x00dd:
                int[] r0 = f30154a     // Catch:{ NoSuchFieldError -> 0x00e9 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MISSION_WP_UPDATE     // Catch:{ NoSuchFieldError -> 0x00e9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e9 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e9 }
            L_0x00e9:
                int[] r0 = f30154a     // Catch:{ NoSuchFieldError -> 0x00f5 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.FOLLOW_START     // Catch:{ NoSuchFieldError -> 0x00f5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f5 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f5 }
            L_0x00f5:
                int[] r0 = f30154a     // Catch:{ NoSuchFieldError -> 0x0101 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.WARNING_400FT_EXCEEDED     // Catch:{ NoSuchFieldError -> 0x0101 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0101 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0101 }
            L_0x0101:
                int[] r0 = f30154a     // Catch:{ NoSuchFieldError -> 0x010d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.AUTOPILOT_WARNING     // Catch:{ NoSuchFieldError -> 0x010d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010d }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x010d }
            L_0x010d:
                int[] r0 = f30154a     // Catch:{ NoSuchFieldError -> 0x0119 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.WARNING_SIGNAL_WEAK     // Catch:{ NoSuchFieldError -> 0x0119 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0119 }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0119 }
            L_0x0119:
                int[] r0 = f30154a     // Catch:{ NoSuchFieldError -> 0x0125 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.WARNING_NO_GPS     // Catch:{ NoSuchFieldError -> 0x0125 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0125 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0125 }
            L_0x0125:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: km.b.AnonymousClass3.<clinit>():void");
        }
    }

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final StringBuilder f30157b;

        /* renamed from: c  reason: collision with root package name */
        private en.a f30158c;

        private a() {
            this.f30157b = new StringBuilder();
        }

        private void b(en.a aVar) {
            if (b.this.f30139c.compareAndSet(false, true)) {
                SparseBooleanArray W = b.this.f30144h.W();
                this.f30157b.setLength(0);
                if (W.get(R.string.pref_tts_periodic_bat_volt_key)) {
                    this.f30157b.append(String.format("battery %2.1f volts. ", new Object[]{Double.valueOf(aVar.o().a())}));
                }
                if (W.get(R.string.pref_tts_periodic_alt_key)) {
                    StringBuilder sb = this.f30157b;
                    sb.append("altitude, " + ((int) aVar.t().a()) + " meters. ");
                }
                if (W.get(R.string.pref_tts_periodic_airspeed_key)) {
                    StringBuilder sb2 = this.f30157b;
                    sb2.append("airspeed, " + ((int) aVar.n().c().a()) + " meters per second. ");
                }
                if (W.get(R.string.pref_tts_periodic_rssi_key)) {
                    StringBuilder sb3 = this.f30157b;
                    sb3.append("r s s i, " + ((int) aVar.p().a()) + " decibels");
                }
                b.this.d(this.f30157b.toString());
            }
        }

        public void a(en.a aVar) {
            this.f30158c = aVar;
        }

        public void run() {
            b.this.f30146j.removeCallbacks(b.this.f30138a);
            en.a aVar = this.f30158c;
            if (aVar != null && aVar.j().a() && this.f30158c.d().c()) {
                b(this.f30158c);
            }
            if (b.this.f30147k != 0) {
                b.this.f30146j.postDelayed(b.this.f30138a, (long) (b.this.f30147k * 1000));
            }
        }
    }

    b(Context context) {
        this.f30143g = context;
        this.f30144h = ((XEagleApp) context).j();
        this.f30145i = new ArrayList<>();
        ab.b().a(context);
    }

    private void a(double d2) {
        int i2 = this.f30142f;
        int i3 = (int) ((d2 - 1.0d) / 10.0d);
        if (i2 > i3 || i2 + 1 < i3) {
            this.f30142f = i3;
            c("Battery at" + ((int) d2) + "%");
        }
    }

    private void a(int i2) {
        Context context;
        int i3;
        if (i2 == 2) {
            context = this.f30143g;
            i3 = R.string.string_gps_2d;
        } else if (i2 != 3) {
            context = this.f30143g;
            i3 = R.string.string_gps_lost;
        } else {
            context = this.f30143g;
            i3 = R.string.string_gps_3d;
        }
        c(context.getString(i3));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0079, code lost:
        r4.append(r0);
        r4 = r4.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0080, code lost:
        c(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0083, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x005f, code lost:
        r0 = r0.getString(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.MAVLink.Messages.ApmModes r4) {
        /*
            r3 = this;
            android.content.Context r0 = r3.f30143g
            r1 = 2131822841(0x7f1108f9, float:1.9278465E38)
            java.lang.String r0 = r0.getString(r1)
            int[] r1 = km.b.AnonymousClass3.f30155b
            int r2 = r4.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L_0x006f;
                case 2: goto L_0x0064;
                case 3: goto L_0x0052;
                case 4: goto L_0x0044;
                case 5: goto L_0x0036;
                case 6: goto L_0x0028;
                case 7: goto L_0x0028;
                default: goto L_0x0014;
            }
        L_0x0014:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r4 = r4.b()
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            goto L_0x0080
        L_0x0028:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            android.content.Context r0 = r3.f30143g
            r1 = 2131822849(0x7f110901, float:1.9278481E38)
            goto L_0x005f
        L_0x0036:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            android.content.Context r0 = r3.f30143g
            r1 = 2131822845(0x7f1108fd, float:1.9278473E38)
            goto L_0x005f
        L_0x0044:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            android.content.Context r0 = r3.f30143g
            r1 = 2131822843(0x7f1108fb, float:1.9278469E38)
            goto L_0x005f
        L_0x0052:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            android.content.Context r0 = r3.f30143g
            r1 = 2131822842(0x7f1108fa, float:1.9278467E38)
        L_0x005f:
            java.lang.String r0 = r0.getString(r1)
            goto L_0x0079
        L_0x0064:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = "Fly by wire B"
            goto L_0x0079
        L_0x006f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = "Fly by wire A"
        L_0x0079:
            r4.append(r0)
            java.lang.String r4 = r4.toString()
        L_0x0080:
            r3.c((java.lang.String) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: km.b.a(com.MAVLink.Messages.ApmModes):void");
    }

    private void a(boolean z2) {
        Context context;
        int i2;
        if (z2) {
            context = this.f30143g;
            i2 = R.string.string_arm;
        } else {
            context = this.f30143g;
            i2 = R.string.string_disarm;
        }
        c(context.getString(i2));
    }

    private void b(String str, boolean z2) {
        if (!z2) {
            if (!this.f30145i.contains(str)) {
                this.f30145i.add(str);
            } else {
                return;
            }
        }
        d(str);
    }

    private void c(String str) {
        b(str, false);
    }

    private void d() {
        ((Vibrator) this.f30143g.getSystemService("vibrator")).vibrate(1000);
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        ab.b().a(this.f30143g, str);
    }

    /* access modifiers changed from: private */
    public void e() {
        this.f30146j.removeCallbacks(this.f30138a);
        int X = this.f30144h.X();
        this.f30147k = X;
        if (X != 0) {
            this.f30146j.postDelayed(this.f30138a, (long) (X * 1000));
        }
    }

    public void a() {
        ArrayList<String> arrayList = this.f30145i;
        if (arrayList != null && arrayList.size() > 0) {
            this.f30145i.clear();
        }
    }

    public void a(String str) {
        this.f30145i.remove(str);
    }

    public void a(String str, boolean z2) {
        b(str, z2);
    }

    public void b() {
        if (this.f30144h.I()) {
            ab.b().b(this.f30143g);
        }
    }

    public void b(String str) {
        c(str);
    }

    public void c() {
        ab.b().a();
        ab.b().c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0078, code lost:
        r1.f30146j.removeCallbacks(r1.f30138a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f9, code lost:
        r2 = r2.getString(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00fd, code lost:
        c(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
        r2 = r2.getString(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        c(r2);
        d();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDroneEvent(com.flypro.core.drone.DroneInterfaces.DroneEventsType r2, en.a r3) {
        /*
            r1 = this;
            int[] r0 = km.b.AnonymousClass3.f30154a
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 0
            switch(r2) {
                case 1: goto L_0x010d;
                case 2: goto L_0x0101;
                case 3: goto L_0x00f4;
                case 4: goto L_0x00e8;
                case 5: goto L_0x00dc;
                case 6: goto L_0x00ca;
                case 7: goto L_0x00be;
                case 8: goto L_0x00ac;
                case 9: goto L_0x009e;
                case 10: goto L_0x008b;
                case 11: goto L_0x0081;
                case 12: goto L_0x0078;
                case 13: goto L_0x005d;
                case 14: goto L_0x0056;
                case 15: goto L_0x0048;
                case 16: goto L_0x002d;
                case 17: goto L_0x001f;
                case 18: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0119
        L_0x000e:
            android.content.Context r2 = r1.f30143g
            r3 = 2131822850(0x7f110902, float:1.9278483E38)
        L_0x0013:
            java.lang.String r2 = r2.getString(r3)
        L_0x0017:
            r1.c((java.lang.String) r2)
            r1.d()
            goto L_0x0119
        L_0x001f:
            com.xeagle.android.utils.prefs.a r2 = r1.f30144h
            boolean r2 = r2.aa()
            if (r2 == 0) goto L_0x0119
            android.content.Context r2 = r1.f30143g
            r3 = 2131822868(0x7f110914, float:1.927852E38)
            goto L_0x0013
        L_0x002d:
            com.flypro.core.drone.variables.aa r2 = r3.d()
            java.lang.String r2 = r2.f()
            com.flypro.core.drone.variables.aa r3 = r3.d()
            boolean r3 = r3.b()
            if (r3 == 0) goto L_0x0119
            com.xeagle.android.utils.prefs.a r3 = r1.f30144h
            boolean r3 = r3.ab()
            if (r3 == 0) goto L_0x0119
            goto L_0x0017
        L_0x0048:
            com.xeagle.android.utils.prefs.a r2 = r1.f30144h
            boolean r2 = r2.Y()
            if (r2 == 0) goto L_0x0119
            android.content.Context r2 = r1.f30143g
            r3 = 2131822818(0x7f1108e2, float:1.9278418E38)
            goto L_0x0013
        L_0x0056:
            android.content.Context r2 = r1.f30143g
            r3 = 2131822831(0x7f1108ef, float:1.9278445E38)
            goto L_0x00f9
        L_0x005d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = "Going for waypoint "
            r2.append(r0)
            com.flypro.core.drone.variables.p r3 = r3.s()
            int r3 = r3.a()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            goto L_0x00fd
        L_0x0078:
            android.os.Handler r2 = r1.f30146j
            km.b$a r3 = r1.f30138a
            r2.removeCallbacks(r3)
            goto L_0x0119
        L_0x0081:
            km.b$a r2 = r1.f30138a
            r2.a(r3)
            r1.e()
            goto L_0x0119
        L_0x008b:
            com.flypro.core.drone.variables.c r2 = r3.x()
            boolean r2 = r2.d()
            if (r2 != 0) goto L_0x0119
            com.xeagle.android.utils.prefs.a r2 = r1.f30144h
            boolean r2 = r2.Z()
            if (r2 == 0) goto L_0x0119
            goto L_0x0078
        L_0x009e:
            km.b$a r2 = r1.f30138a
            r2.a(r3)
            r1.e()
            android.content.Context r2 = r1.f30143g
            r3 = 2131822829(0x7f1108ed, float:1.927844E38)
            goto L_0x00f9
        L_0x00ac:
            android.content.Context r2 = r1.f30143g
            r3 = 2131822854(0x7f110906, float:1.9278491E38)
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r0)
            r2.show()
            android.content.Context r2 = r1.f30143g
            r3 = 2131822869(0x7f110915, float:1.9278522E38)
            goto L_0x00f9
        L_0x00be:
            com.flypro.core.drone.variables.j r2 = r3.b()
            int r2 = r2.g()
            r1.a((int) r2)
            goto L_0x0119
        L_0x00ca:
            android.content.Context r2 = r1.f30143g
            r3 = 2131822867(0x7f110913, float:1.9278518E38)
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r0)
            r2.show()
            android.content.Context r2 = r1.f30143g
            r3 = 2131822860(0x7f11090c, float:1.9278503E38)
            goto L_0x00f9
        L_0x00dc:
            com.flypro.core.drone.variables.aa r2 = r3.d()
            com.MAVLink.Messages.ApmModes r2 = r2.e()
            r1.a((com.MAVLink.Messages.ApmModes) r2)
            goto L_0x0119
        L_0x00e8:
            com.flypro.core.drone.variables.b r2 = r3.o()
            double r2 = r2.b()
            r1.a((double) r2)
            goto L_0x0119
        L_0x00f4:
            android.content.Context r2 = r1.f30143g
            r3 = 2131822820(0x7f1108e4, float:1.9278422E38)
        L_0x00f9:
            java.lang.String r2 = r2.getString(r3)
        L_0x00fd:
            r1.c((java.lang.String) r2)
            goto L_0x0119
        L_0x0101:
            com.flypro.core.drone.variables.aa r2 = r3.d()
            boolean r2 = r2.c()
            r1.a((boolean) r2)
            goto L_0x0119
        L_0x010d:
            android.content.Context r2 = r1.f30143g
            r3 = 2131821218(0x7f1102a2, float:1.9275173E38)
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r0)
            r2.show()
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: km.b.onDroneEvent(com.flypro.core.drone.DroneInterfaces$DroneEventsType, en.a):void");
    }
}
