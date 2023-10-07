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
import dy.ae;
import en.a;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class p extends i implements AdapterView.OnItemSelectedListener, DroneInterfaces.c {

    /* renamed from: b  reason: collision with root package name */
    private Follow f13831b;

    /* renamed from: c  reason: collision with root package name */
    private Spinner f13832c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayAdapter<FollowAlgorithm.FollowModes> f13833d;

    /* renamed from: kc.p$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f29974a;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f29974a = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.FOLLOW_CHANGE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @l(a = ThreadMode.MAIN)
    public void followChangeTypeEvent(ae aeVar) {
        if (aeVar.a() == 35) {
            this.f13832c.setSelection(this.f13833d.getPosition(this.f13831b.d()));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        XEagleApp xEagleApp = (XEagleApp) getActivity().getApplication();
        this.f13831b = xEagleApp.l();
        this.f13828a = xEagleApp.k();
        return layoutInflater.inflate(R.layout.fragment_follow_relate, viewGroup, false);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        if (AnonymousClass1.f29974a[droneEventsType.ordinal()] == 1) {
            this.f13832c.setSelection(this.f13833d.getPosition(this.f13831b.d()));
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f13831b.a(this.f13833d.getItem(i2));
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f13832c = (Spinner) view.findViewById(R.id.follow_type_spinner);
        ArrayAdapter<FollowAlgorithm.FollowModes> arrayAdapter = new ArrayAdapter<>(getActivity(), 17367048, FollowAlgorithm.FollowModes.values());
        this.f13833d = arrayAdapter;
        this.f13832c.setAdapter(arrayAdapter);
        this.f13832c.setOnItemSelectedListener(this);
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
        this.f13828a.a((DroneInterfaces.c) this);
    }
}
