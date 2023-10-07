package com.xeagle.android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.variables.ad;
import com.xeagle.android.XEagleApp;

public class h extends Fragment implements DroneInterfaces.c {

    /* renamed from: a  reason: collision with root package name */
    private a f23384a;

    interface a {
        boolean a(en.a aVar);
    }

    /* renamed from: com.xeagle.android.fragments.h$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23385a;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f23385a = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void a(int i2) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Fragment cVar = ad.b(i2) ? new c() : ad.c(i2) ? new n() : new l();
        childFragmentManager.a().b(R.id.flight_actions_bar, cVar).c();
        this.f23384a = (a) cVar;
    }

    public boolean a(en.a aVar) {
        a aVar2 = this.f23384a;
        return aVar2 != null && aVar2.a(aVar);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_flight_actions_bar, viewGroup, false);
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        if (AnonymousClass1.f23385a[droneEventsType.ordinal()] == 1) {
            a(aVar.f());
        }
    }

    public void onStart() {
        super.onStart();
        en.a k2 = ((XEagleApp) getActivity().getApplication()).k();
        a(k2.f());
        k2.a((DroneInterfaces.c) this);
    }

    public void onStop() {
        super.onStop();
        ((XEagleApp) getActivity().getApplication()).k().b((DroneInterfaces.c) this);
    }
}
