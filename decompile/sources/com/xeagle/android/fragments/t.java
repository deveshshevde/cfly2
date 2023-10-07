package com.xeagle.android.fragments;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.widgets.AttitudeIndicator;
import en.a;

public class t extends Fragment implements DroneInterfaces.c {

    /* renamed from: a  reason: collision with root package name */
    private AttitudeIndicator f23495a;

    /* renamed from: b  reason: collision with root package name */
    private a f23496b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f23497c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f23498d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f23499e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f23500f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f23501g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f23502h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f23503i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f23504j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f23505k;

    /* renamed from: com.xeagle.android.fragments.t$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23506a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23506a = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.NAVIGATION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23506a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.ATTITUDE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23506a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.SPEED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.t.AnonymousClass1.<clinit>():void");
        }
    }

    public void a(a aVar) {
        float a2 = (float) aVar.u().a();
        float b2 = (float) aVar.u().b();
        float c2 = (float) aVar.u().c();
        if ((!this.f23505k) && (c2 < 0.0f)) {
            c2 += 360.0f;
        }
        this.f23495a.a(a2, b2, c2);
        this.f23497c.setText(String.format("%3.0f°", new Object[]{Float.valueOf(a2)}));
        this.f23499e.setText(String.format("%3.0f°", new Object[]{Float.valueOf(b2)}));
        this.f23498d.setText(String.format("%3.0f°", new Object[]{Float.valueOf(c2)}));
    }

    public void b(a aVar) {
        this.f23501g.setText(String.format("%3.1f", new Object[]{Double.valueOf(aVar.n().c().a())}));
        this.f23500f.setText(String.format("%3.1f", new Object[]{Double.valueOf(aVar.n().b().a())}));
        this.f23502h.setText(String.format("%3.1f", new Object[]{Double.valueOf(aVar.n().a().a())}));
        double a2 = aVar.t().a();
        double c2 = aVar.t().c();
        this.f23503i.setText(String.format("%3.1f", new Object[]{Double.valueOf(a2)}));
        this.f23504j.setText(String.format("%3.1f", new Object[]{Double.valueOf(c2)}));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_telemetry, viewGroup, false);
        this.f23495a = (AttitudeIndicator) inflate.findViewById(R.id.aiView);
        this.f23497c = (TextView) inflate.findViewById(R.id.rollValueText);
        this.f23498d = (TextView) inflate.findViewById(R.id.yawValueText);
        this.f23499e = (TextView) inflate.findViewById(R.id.pitchValueText);
        this.f23500f = (TextView) inflate.findViewById(R.id.groundSpeedValue);
        this.f23501g = (TextView) inflate.findViewById(R.id.airSpeedValue);
        this.f23502h = (TextView) inflate.findViewById(R.id.climbRateValue);
        this.f23503i = (TextView) inflate.findViewById(R.id.altitudeValue);
        this.f23504j = (TextView) inflate.findViewById(R.id.targetAltitudeValue);
        this.f23496b = ((XEagleApp) getActivity().getApplication()).k();
        return inflate;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        int i2 = AnonymousClass1.f23506a[droneEventsType.ordinal()];
        if (i2 == 2) {
            a(aVar);
        } else if (i2 == 3) {
            b(aVar);
        }
    }

    public void onStart() {
        super.onStart();
        this.f23496b.a((DroneInterfaces.c) this);
        this.f23505k = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext()).getBoolean("pref_heading_mode", false);
    }

    public void onStop() {
        super.onStop();
        this.f23496b.b((DroneInterfaces.c) this);
    }
}
