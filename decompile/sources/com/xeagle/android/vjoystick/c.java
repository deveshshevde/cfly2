package com.xeagle.android.vjoystick;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.gcs.follow.Follow;
import com.flypro.core.gcs.follow.FollowAlgorithm;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView;
import dy.ae;
import en.a;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class c extends d implements AdapterView.OnItemSelectedListener, DroneInterfaces.c {

    /* renamed from: b  reason: collision with root package name */
    private Follow f12941b;

    /* renamed from: c  reason: collision with root package name */
    private Spinner f12942c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayAdapter<FollowAlgorithm.FollowModes> f12943d;

    /* renamed from: e  reason: collision with root package name */
    private CardWheelHorizontalView f12944e;

    /* renamed from: com.xeagle.android.vjoystick.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24986a;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f24986a = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.FOLLOW_CHANGE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void a() {
        CardWheelHorizontalView cardWheelHorizontalView = this.f12944e;
        if (cardWheelHorizontalView != null) {
            cardWheelHorizontalView.setCurrentValue((int) this.f12941b.c().a());
        }
    }

    public void a(CardWheelHorizontalView cardWheelHorizontalView, int i2, int i3) {
        if (cardWheelHorizontalView.getId() != R.id.radius_spinner) {
            super.a(cardWheelHorizontalView, i2, i3);
        } else {
            this.f12941b.a((double) i3);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void followChangeTypeEvent(ae aeVar) {
        if (aeVar.a() == 35) {
            this.f12942c.setSelection(this.f12943d.getPosition(this.f12941b.d()));
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        Window window = create.getWindow();
        window.setGravity(48);
        create.show();
        window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 3) / 5, (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 4) / 5);
        return create;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        XEagleApp xEagleApp = (XEagleApp) getActivity().getApplication();
        this.f12941b = xEagleApp.l();
        this.f12945a = xEagleApp.k();
        return layoutInflater.inflate(R.layout.fragment_mode_follow, viewGroup, false);
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        if (AnonymousClass1.f24986a[droneEventsType.ordinal()] == 1) {
            this.f12942c.setSelection(this.f12943d.getPosition(this.f12941b.d()));
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f12941b.a(this.f12943d.getItem(i2));
        a();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Context applicationContext = getActivity().getApplicationContext();
        this.f12942c = (Spinner) view.findViewById(R.id.follow_type_spinner);
        ArrayAdapter<FollowAlgorithm.FollowModes> arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_setup_item, FollowAlgorithm.FollowModes.values());
        this.f12943d = arrayAdapter;
        this.f12942c.setAdapter(arrayAdapter);
        this.f12942c.setOnItemSelectedListener(this);
        ll.c cVar = new ll.c(applicationContext, R.layout.wheel_text_centered, 0, 20, "%d m");
        CardWheelHorizontalView cardWheelHorizontalView = (CardWheelHorizontalView) view.findViewById(R.id.radius_spinner);
        this.f12944e = cardWheelHorizontalView;
        cardWheelHorizontalView.setViewAdapter(cVar);
        this.f12944e.a((CardWheelHorizontalView.a) this);
        a();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
        this.f12945a.a((DroneInterfaces.c) this);
    }
}
