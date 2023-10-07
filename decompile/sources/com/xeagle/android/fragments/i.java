package com.xeagle.android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.google.android.gms.maps.model.LatLng;
import com.xeagle.android.dialogs.n;
import com.xeagle.android.utils.f;
import com.xeagle.android.utils.prefs.AutoPanMode;
import dy.h;
import kh.a;
import kh.b;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class i extends e implements DroneInterfaces.c, n.a, a.b, a.c, a.d {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f12676a = false;

    /* renamed from: b  reason: collision with root package name */
    private com.xeagle.android.utils.prefs.a f12677b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12678c;

    /* renamed from: com.xeagle.android.fragments.i$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23402a;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f23402a = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.ARMING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void a(LatLng latLng) {
        try {
            this.drone.w().b(this.context, f.a(latLng));
        } catch (Exception e2) {
            Toast.makeText(getActivity(), e2.getMessage(), 0).show();
        }
    }

    public void a(ef.a aVar) {
        if (!this.drone.j().a()) {
            return;
        }
        if (this.drone.w().e()) {
            this.drone.w().a(getActivity().getApplicationContext(), aVar);
        } else if (this.f12678c) {
            n nVar = new n();
            nVar.a(f.a(aVar));
            nVar.a((n.a) this);
            nVar.show(getChildFragmentManager(), "GUIDED dialog");
        }
    }

    public void a(b bVar) {
    }

    @l(a = ThreadMode.BACKGROUND)
    public void armStateEvent(h hVar) {
        if (hVar.a() == 9 && this.drone.d().c()) {
            this.mMapFragment.a();
        }
    }

    public void b(b bVar) {
    }

    public void c(b bVar) {
        this.drone.w().a(getActivity().getApplicationContext(), bVar.getPosition());
    }

    public boolean d(b bVar) {
        this.drone.w().a(getActivity().getApplicationContext(), bVar.getPosition());
        return true;
    }

    /* access modifiers changed from: protected */
    public int getMaxFlightPathSize() {
        return Integer.valueOf(com.xeagle.android.camera.widgets.ablum.b.b("pref_max_flight_path_size", "100")).intValue();
    }

    public void goToDroneLocation() {
        int b2;
        super.goToDroneLocation();
        if (this.drone.b().a() && (b2 = com.xeagle.android.camera.widgets.ablum.b.b("pref_drone_location_first_press", 0)) < 3) {
            Toast.makeText(this.context, R.string.drone_autopan_long_press, 1).show();
            com.xeagle.android.camera.widgets.ablum.b.a("pref_drone_location_first_press", b2 + 1);
        }
    }

    public void goToMyLocation() {
        super.goToMyLocation();
        int b2 = com.xeagle.android.camera.widgets.ablum.b.b("pref_user_location_first_press", 0);
        if (b2 < 3) {
            Toast.makeText(this.context, R.string.user_autopan_long_press, 1).show();
            com.xeagle.android.camera.widgets.ablum.b.a("pref_user_location_first_press", b2 + 1);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isMissionDraggable() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f12677b = new com.xeagle.android.utils.prefs.a(this.context);
        com.xeagle.android.camera.widgets.ablum.b.b(this.context);
        this.mMapFragment.a((a.b) this);
        this.mMapFragment.a((a.d) this);
        this.mMapFragment.a((a.c) this);
        return onCreateView;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        if (AnonymousClass1.f23402a[droneEventsType.ordinal()] == 1 && aVar.d().c()) {
            this.mMapFragment.a();
        }
        super.onDroneEvent(droneEventsType, aVar);
    }

    public void onPause() {
        super.onPause();
        this.mMapFragment.a(AutoPanMode.DISABLED);
        if (c.a().b(this)) {
            c.a().c(this);
        }
    }

    public void onResume() {
        super.onResume();
        this.mMapFragment.a(this.f12677b.Q());
        this.f12678c = this.f12677b.R();
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
        if (!f12676a) {
            super.goToMyLocation();
            f12676a = true;
        }
    }

    public boolean setAutoPanMode(AutoPanMode autoPanMode) {
        this.f12677b.a(autoPanMode);
        this.mMapFragment.a(autoPanMode);
        return true;
    }
}
