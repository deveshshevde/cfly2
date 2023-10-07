package com.xeagle.android.widgets.actionProviders;

import android.content.Context;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.widgets.actionProviders.a;
import en.a;

public class InfoBarActionProvider extends ActionProvider implements DroneInterfaces.c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f25679a;

    /* renamed from: b  reason: collision with root package name */
    private a f25680b;

    /* renamed from: c  reason: collision with root package name */
    private View f25681c;

    /* renamed from: d  reason: collision with root package name */
    private a.C0160a f25682d;

    /* renamed from: com.xeagle.android.widgets.actionProviders.InfoBarActionProvider$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25683a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f25683a = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f25683a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f25683a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MODE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f25683a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.TYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.widgets.actionProviders.InfoBarActionProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public InfoBarActionProvider(Context context) {
        super(context);
        this.f25679a = context;
    }

    private void a() {
        this.f25682d = new a.C0160a(this.f25679a, this.f25681c, this.f25680b);
    }

    private void b() {
        a.C0160a aVar = this.f25682d;
        if (aVar != null) {
            aVar.a(this.f25679a, this.f25680b);
        }
    }

    public void a(en.a aVar) {
        this.f25680b = aVar;
    }

    public View onCreateActionView() {
        this.f25681c = LayoutInflater.from(this.f25679a).inflate(R.layout.action_provider_info_bar, (ViewGroup) null);
        a();
        b();
        return this.f25681c;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        a.C0160a aVar2;
        a(aVar);
        int i2 = AnonymousClass1.f25683a[droneEventsType.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                a((en.a) null);
            } else if ((i2 == 3 || i2 == 4) && (aVar2 = this.f25682d) != null) {
                aVar2.a(this.f25679a, this.f25680b);
                return;
            } else {
                return;
            }
        }
        b();
    }
}
