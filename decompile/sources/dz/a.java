package dz;

import android.util.Log;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.common.msg_param_value;
import com.flypro.core.MAVLink.j;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.d;
import com.flypro.core.parameters.Parameter;
import dy.ak;
import dy.am;
import dy.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class a extends d implements DroneInterfaces.c {

    /* renamed from: a  reason: collision with root package name */
    public DroneInterfaces.b f13073a;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f13074c = new Runnable() {
        public void run() {
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<Parameter> f13075d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private final Object f13076e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private int f13077f;

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<Integer, Parameter> f13078g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final HashMap<String, Parameter> f13079h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private DroneInterfaces.d f13080i;

    /* renamed from: j  reason: collision with root package name */
    private C0168a f13081j;

    /* renamed from: dz.a$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26838a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f26838a = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_FIRST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f26838a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f26838a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: dz.a.AnonymousClass3.<clinit>():void");
        }
    }

    /* renamed from: dz.a$a  reason: collision with other inner class name */
    public interface C0168a {
        void a(Parameter parameter, String str);
    }

    public a(en.a aVar, DroneInterfaces.b bVar) {
        super(aVar);
        this.f13073a = bVar;
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
        aVar.a((DroneInterfaces.c) this);
    }

    private void a(msg_param_value msg_param_value) {
        Parameter parameter = new Parameter(msg_param_value);
        C0168a aVar = this.f13081j;
        if (aVar != null) {
            aVar.a(parameter, parameter.f14455a);
        }
        this.f13078g.put(Integer.valueOf(msg_param_value.f7018f), parameter);
        this.f13079h.put(msg_param_value.a(), parameter);
        this.f13077f = msg_param_value.f7017e;
        DroneInterfaces.d dVar = this.f13080i;
        if (dVar != null) {
            dVar.a(parameter, msg_param_value.f7018f, msg_param_value.f7017e);
        }
        if (this.f13078g.size() >= msg_param_value.f7017e) {
            this.f13075d.clear();
            for (Integer intValue : this.f13078g.keySet()) {
                this.f13075d.add(this.f13078g.get(Integer.valueOf(intValue.intValue())));
            }
            f();
            this.f11557b.a(DroneInterfaces.DroneEventsType.PARAMETERS_DOWNLOADED);
            DroneInterfaces.d dVar2 = this.f13080i;
            if (dVar2 != null) {
                dVar2.a(this.f13075d);
            }
        } else {
            e();
        }
        c.a().d(new u(parameter, parameter.f14455a));
    }

    private void e() {
        this.f13073a.removeCallbacks(this.f13074c);
        this.f13073a.postDelayed(this.f13074c, 1000);
    }

    private void f() {
        this.f13073a.removeCallbacks(this.f13074c);
    }

    public void a() {
        this.f13078g.clear();
        this.f13075d.clear();
        DroneInterfaces.d dVar = this.f13080i;
        if (dVar != null) {
            dVar.a();
        }
        j.a(this.f11557b);
        e();
    }

    public void a(DroneInterfaces.d dVar) {
        this.f13080i = dVar;
    }

    public void a(final Parameter parameter) {
        this.f13073a.postDelayed(new Runnable() {
            public void run() {
                j.a(a.this.f11557b, parameter);
            }
        }, 300);
    }

    public void a(String str) {
        j.a(this.f11557b, str);
    }

    public void a(String str, C0168a aVar) {
        this.f13081j = aVar;
        j.a(this.f11557b, str);
    }

    public boolean a(MAVLinkMessage mAVLinkMessage) {
        if (mAVLinkMessage.f6280c != 22) {
            return false;
        }
        a((msg_param_value) mAVLinkMessage);
        return true;
    }

    public Parameter b(String str) {
        if (!this.f13079h.containsKey(str)) {
            Log.i("Param", "getParameter: ----error:" + str);
            return null;
        } else if (this.f13079h.get(str) == null) {
            return null;
        } else {
            Log.i("Param", "getParameter: ----name----" + str);
            return this.f13079h.get(str);
        }
    }

    public List<Parameter> b() {
        return this.f13075d;
    }

    public void c() {
        a("COMPASS_OFS_X");
        a("COMPASS_OFS_Y");
        a("COMPASS_OFS_Z");
    }

    public void d() {
        a("COMPASS_OFS2_X");
        a("COMPASS_OFS2_Y");
        a("COMPASS_OFS2_Z");
    }

    @l(a = ThreadMode.BACKGROUND)
    public void disConnectedEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            f();
        }
    }

    @l(a = ThreadMode.ASYNC)
    public void heartbeatFirstEvent(ak akVar) {
        akVar.a();
    }

    @l(a = ThreadMode.BACKGROUND)
    public void heartbeatTimeoutEvent(am amVar) {
        if (amVar.a() == 5) {
            f();
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        int i2 = AnonymousClass3.f26838a[droneEventsType.ordinal()];
        if (i2 == 2 || i2 == 3) {
            f();
        }
    }
}
