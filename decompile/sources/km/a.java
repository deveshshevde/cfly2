package km;

import android.content.Context;
import com.flypro.core.drone.DroneInterfaces;
import com.google.android.gms.analytics.HitBuilders;
import java.util.HashMap;

public class a implements DroneInterfaces.c {

    /* renamed from: a  reason: collision with root package name */
    private final b f13908a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, Long> f13909b = new HashMap<>();

    /* renamed from: km.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30136a;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f30136a = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.AUTOPILOT_WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: km.a$a  reason: collision with other inner class name */
    interface C0211a extends DroneInterfaces.c {
    }

    public a(Context context) {
        this.f13908a = new b(context);
    }

    public void a() {
        this.f13908a.a();
    }

    public void a(String str) {
        this.f13908a.b(str);
    }

    public void a(String str, boolean z2) {
        this.f13908a.a(str, z2);
    }

    public void b() {
        this.f13908a.c();
    }

    public void b(String str) {
        this.f13908a.a(str);
    }

    public void c() {
        this.f13908a.b();
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        this.f13908a.onDroneEvent(droneEventsType, aVar);
        if (AnonymousClass1.f30136a[droneEventsType.ordinal()] == 1) {
            kt.a.a(new HitBuilders.EventBuilder().setCategory("Failsafe").setAction("Autopilot warning").setLabel(aVar.d().f()));
        }
    }
}
