package com.xeagle.android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.gcs.follow.Follow;
import com.flypro.core.gcs.follow.FollowAlgorithm;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.widgets.scrollwheel.WheelView;
import com.xeagle.android.widgets.scrollwheel.b;
import dy.ae;
import en.a;
import kc.i;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class m extends i implements AdapterView.OnItemSelectedListener, DroneInterfaces.c, b {

    /* renamed from: b  reason: collision with root package name */
    private Follow f12679b;

    /* renamed from: c  reason: collision with root package name */
    private Spinner f12680c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayAdapter<FollowAlgorithm.FollowModes> f12681d;

    /* renamed from: e  reason: collision with root package name */
    private a f12682e;

    /* renamed from: f  reason: collision with root package name */
    private WheelView f12683f;

    /* renamed from: com.xeagle.android.fragments.m$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23448a;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f23448a = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.FOLLOW_CHANGE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void a() {
        WheelView wheelView = this.f12683f;
        if (wheelView != null) {
            wheelView.setCurrentItem((int) this.f12679b.c().a());
        }
    }

    public void a(WheelView wheelView, int i2, int i3) {
        if (wheelView.getId() == R.id.radius_spinner) {
            this.f12679b.a((double) i3);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void followChangeTypeEvent(ae aeVar) {
        if (aeVar.a() == 35) {
            this.f12680c.setSelection(this.f12681d.getPosition(this.f12679b.d()));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        XEagleApp xEagleApp = (XEagleApp) getActivity().getApplication();
        this.f12679b = xEagleApp.l();
        this.f12682e = xEagleApp.k();
        return layoutInflater.inflate(R.layout.fragment_mode_follow_seekbar, viewGroup, false);
    }

    public void onDestroyView() {
        super.onDestroyView();
        WheelView wheelView = this.f12683f;
        if (wheelView != null) {
            wheelView.b((b) this);
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        if (AnonymousClass1.f23448a[droneEventsType.ordinal()] == 1) {
            this.f12680c.setSelection(this.f12681d.getPosition(this.f12679b.d()));
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f12679b.a(this.f12681d.getItem(i2));
        a();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getActivity().getApplicationContext();
        com.xeagle.android.widgets.scrollwheel.a aVar = new com.xeagle.android.widgets.scrollwheel.a(0, 200, "%d m");
        WheelView wheelView = (WheelView) view.findViewById(R.id.radius_spinner);
        this.f12683f = wheelView;
        wheelView.setAdapter(aVar);
        a();
        this.f12683f.a((b) this);
        this.f12680c = (Spinner) view.findViewById(R.id.follow_type_spinner);
        ArrayAdapter<FollowAlgorithm.FollowModes> arrayAdapter = new ArrayAdapter<>(getActivity(), 17367048, FollowAlgorithm.FollowModes.values());
        this.f12681d = arrayAdapter;
        this.f12680c.setAdapter(arrayAdapter);
        this.f12680c.setOnItemSelectedListener(this);
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
        this.f12682e.a((DroneInterfaces.c) this);
    }
}
