package kc;

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
import com.xeagle.android.widgets.wheelVerticalView.CardWheelVerticalView;
import dy.ae;
import en.a;
import ll.c;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class h extends i implements AdapterView.OnItemSelectedListener, DroneInterfaces.c {

    /* renamed from: b  reason: collision with root package name */
    private Follow f13824b;

    /* renamed from: c  reason: collision with root package name */
    private Spinner f13825c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayAdapter<FollowAlgorithm.FollowModes> f13826d;

    /* renamed from: e  reason: collision with root package name */
    private CardWheelVerticalView f13827e;

    /* renamed from: kc.h$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f29972a;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f29972a = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.FOLLOW_CHANGE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void a() {
        CardWheelVerticalView cardWheelVerticalView = this.f13827e;
        if (cardWheelVerticalView != null) {
            cardWheelVerticalView.setCurrentValue((int) this.f13824b.c().a());
        }
    }

    public void a(CardWheelVerticalView cardWheelVerticalView, int i2, int i3) {
        if (cardWheelVerticalView.getId() != R.id.radius_spinner) {
            super.a(cardWheelVerticalView, i2, i3);
        } else {
            this.f13824b.a((double) i3);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void followChangeTypeEvent(ae aeVar) {
        if (aeVar.a() == 35) {
            this.f13825c.setSelection(this.f13826d.getPosition(this.f13824b.d()));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        XEagleApp xEagleApp = (XEagleApp) getActivity().getApplication();
        this.f13824b = xEagleApp.l();
        this.f13828a = xEagleApp.k();
        return layoutInflater.inflate(R.layout.fragment_mode_follow, viewGroup, false);
    }

    public void onDestroyView() {
        super.onDestroyView();
        CardWheelVerticalView cardWheelVerticalView = this.f13827e;
        if (cardWheelVerticalView != null) {
            cardWheelVerticalView.b((CardWheelVerticalView.a) this);
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        if (AnonymousClass1.f29972a[droneEventsType.ordinal()] == 1) {
            this.f13825c.setSelection(this.f13826d.getPosition(this.f13824b.d()));
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f13824b.a(this.f13826d.getItem(i2));
        a();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        c cVar = new c(getActivity().getApplicationContext(), R.layout.wheel_text_centered, 0, 20, "%d m");
        CardWheelVerticalView cardWheelVerticalView = (CardWheelVerticalView) view.findViewById(R.id.radius_spinner);
        this.f13827e = cardWheelVerticalView;
        cardWheelVerticalView.setViewAdapter(cVar);
        a();
        this.f13827e.a((CardWheelVerticalView.a) this);
        this.f13825c = (Spinner) view.findViewById(R.id.follow_type_spinner);
        ArrayAdapter<FollowAlgorithm.FollowModes> arrayAdapter = new ArrayAdapter<>(getActivity(), 17367048, FollowAlgorithm.FollowModes.values());
        this.f13826d = arrayAdapter;
        this.f13825c.setAdapter(arrayAdapter);
        this.f13825c.setOnItemSelectedListener(this);
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
        this.f13828a.a((DroneInterfaces.c) this);
    }
}
