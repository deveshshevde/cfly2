package kq;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView;
import com.xeagle.android.widgets.spinners.SpinnerSelfSelect;
import el.a;
import java.util.List;
import kp.b;
import ll.c;

public class l extends e implements DroneInterfaces.c, CardWheelHorizontalView.a, SpinnerSelfSelect.a {

    /* renamed from: l  reason: collision with root package name */
    private static final String f30538l = "l";

    /* renamed from: c  reason: collision with root package name */
    public TextView f30539c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f30540d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f30541e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f30542f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f30543g;

    /* renamed from: h  reason: collision with root package name */
    public SpinnerSelfSelect f30544h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f30545i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f30546j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f30547k;

    /* renamed from: m  reason: collision with root package name */
    private CardWheelHorizontalView f30548m;

    /* renamed from: n  reason: collision with root package name */
    private CardWheelHorizontalView f30549n;

    /* renamed from: o  reason: collision with root package name */
    private CardWheelHorizontalView f30550o;

    /* renamed from: p  reason: collision with root package name */
    private CardWheelHorizontalView f30551p;

    /* renamed from: q  reason: collision with root package name */
    private b f30552q;

    /* renamed from: r  reason: collision with root package name */
    private List<a> f30553r;

    /* renamed from: kq.l$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30554a;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f30554a = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.MISSION_UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void d() {
        f();
        e();
    }

    private void e() {
        this.f30549n.setCurrentValue(this.f30553r.get(0).f26910c.g().intValue());
        this.f30548m.setCurrentValue((int) this.f30553r.get(0).f26910c.i());
        this.f30551p.setCurrentValue((int) this.f30553r.get(0).f26910c.h());
        this.f30550o.setCurrentValue((int) this.f30553r.get(0).f26910c.f().a());
    }

    private void f() {
        FragmentActivity activity = getActivity();
        try {
            TextView textView = this.f30542f;
            textView.setText(activity.getString(R.string.footprint) + ": " + this.f30553r.get(0).f26910c.a() + " x" + this.f30553r.get(0).f26910c.b());
            TextView textView2 = this.f30543g;
            textView2.setText(activity.getString(R.string.ground_resolution) + ": " + this.f30553r.get(0).f26910c.c() + "/px");
            TextView textView3 = this.f30541e;
            textView3.setText(activity.getString(R.string.distance_between_pictures) + ": " + this.f30553r.get(0).f26910c.d());
            TextView textView4 = this.f30539c;
            textView4.setText(activity.getString(R.string.distance_between_lines) + ": " + this.f30553r.get(0).f26910c.e());
            TextView textView5 = this.f30540d;
            textView5.setText(activity.getString(R.string.area) + ": " + this.f30553r.get(0).f26909b.c());
            TextView textView6 = this.f30547k;
            textView6.setText(activity.getString(R.string.mission_length) + ": " + this.f30553r.get(0).f26911d.a());
            TextView textView7 = this.f30545i;
            textView7.setText(activity.getString(R.string.pictures) + ": " + this.f30553r.get(0).f26911d.d());
            TextView textView8 = this.f30546j;
            textView8.setText(activity.getString(R.string.number_of_strips) + ": " + this.f30553r.get(0).f26911d.b());
        } catch (Exception unused) {
            TextView textView9 = this.f30542f;
            textView9.setText(activity.getString(R.string.footprint) + ": ???");
            TextView textView10 = this.f30543g;
            textView10.setText(activity.getString(R.string.ground_resolution) + ": ???");
            TextView textView11 = this.f30541e;
            textView11.setText(activity.getString(R.string.distance_between_pictures) + ": ???");
            TextView textView12 = this.f30539c;
            textView12.setText(activity.getString(R.string.distance_between_lines) + ": ???");
            TextView textView13 = this.f30540d;
            textView13.setText(activity.getString(R.string.area) + ": ???");
            TextView textView14 = this.f30547k;
            textView14.setText(activity.getString(R.string.mission_length) + ": ???");
            TextView textView15 = this.f30545i;
            textView15.setText(activity.getString(R.string.pictures) + "???");
            TextView textView16 = this.f30546j;
            textView16.setText(activity.getString(R.string.number_of_strips) + "???");
        }
    }

    /* access modifiers changed from: protected */
    public int a() {
        return R.layout.fragment_editor_detail_survey;
    }

    public void a(Spinner spinner, int i2) {
        if (spinner.getId() == R.id.cameraFileSpinner) {
            eo.a a2 = this.f30552q.a(i2);
            this.f30552q.a(a2.f26931a);
            for (a a3 : this.f30553r) {
                a3.a(a2);
            }
            a(this.f30549n, 0, 0);
            b().a().b();
        }
    }

    public void a(CardWheelHorizontalView cardWheelHorizontalView, int i2, int i3) {
        switch (cardWheelHorizontalView.getId()) {
            case R.id.altitudePicker:
            case R.id.anglePicker:
            case R.id.overlapPicker:
            case R.id.sidelapPicker:
                try {
                    for (a next : this.f30553r) {
                        next.a((double) this.f30549n.getCurrentValue(), new ej.a((double) this.f30550o.getCurrentValue()), (double) this.f30548m.getCurrentValue(), (double) this.f30551p.getCurrentValue());
                        next.c();
                    }
                    this.f30550o.setBackgroundResource(R.drawable.bg_cell_white);
                    return;
                } catch (Exception e2) {
                    Log.e(f30538l, "Error while building the survey.", e2);
                    this.f30550o.setBackgroundColor(-65536);
                    return;
                }
            default:
                return;
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        if (AnonymousClass1.f30554a[droneEventsType.ordinal()] == 1) {
            d();
        }
    }

    public void onStart() {
        super.onStart();
        ((XEagleApp) getActivity().getApplication()).k().a((DroneInterfaces.c) this);
    }

    public void onStop() {
        super.onStop();
        ((XEagleApp) getActivity().getApplication()).k().b((DroneInterfaces.c) this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Context applicationContext = getActivity().getApplicationContext();
        this.f30553r = c();
        this.f30552q = new b(getActivity(), 17367049);
        SpinnerSelfSelect spinnerSelfSelect = (SpinnerSelfSelect) view.findViewById(R.id.cameraFileSpinner);
        this.f30544h = spinnerSelfSelect;
        spinnerSelfSelect.setAdapter(this.f30552q);
        this.f30544h.setOnSpinnerItemSelectedListener(this);
        this.f30552q.a(this.f30553r.get(0).f26910c.j());
        CardWheelHorizontalView cardWheelHorizontalView = (CardWheelHorizontalView) view.findViewById(R.id.anglePicker);
        this.f30549n = cardWheelHorizontalView;
        Context context = applicationContext;
        cardWheelHorizontalView.setViewAdapter(new c(context, R.layout.wheel_text_centered, 0, 180, "%dº"));
        CardWheelHorizontalView cardWheelHorizontalView2 = (CardWheelHorizontalView) view.findViewById(R.id.overlapPicker);
        this.f30548m = cardWheelHorizontalView2;
        cardWheelHorizontalView2.setViewAdapter(new c(context, R.layout.wheel_text_centered, 0, 99, "%d %%"));
        CardWheelHorizontalView cardWheelHorizontalView3 = (CardWheelHorizontalView) view.findViewById(R.id.sidelapPicker);
        this.f30551p = cardWheelHorizontalView3;
        cardWheelHorizontalView3.setViewAdapter(new c(context, R.layout.wheel_text_centered, 0, 99, "%d %%"));
        CardWheelHorizontalView cardWheelHorizontalView4 = (CardWheelHorizontalView) view.findViewById(R.id.altitudePicker);
        this.f30550o = cardWheelHorizontalView4;
        cardWheelHorizontalView4.setViewAdapter(new c(context, R.layout.wheel_text_centered, 5, 200, "%d m"));
        this.f30540d = (TextView) view.findViewById(R.id.areaTextView);
        this.f30539c = (TextView) view.findViewById(R.id.distanceBetweenLinesTextView);
        this.f30542f = (TextView) view.findViewById(R.id.footprintTextView);
        this.f30543g = (TextView) view.findViewById(R.id.groundResolutionTextView);
        this.f30541e = (TextView) view.findViewById(R.id.distanceTextView);
        this.f30545i = (TextView) view.findViewById(R.id.numberOfPicturesTextView);
        this.f30546j = (TextView) view.findViewById(R.id.numberOfStripsTextView);
        this.f30547k = (TextView) view.findViewById(R.id.lengthTextView);
        d();
        this.f30549n.a((CardWheelHorizontalView.a) this);
        this.f30548m.a((CardWheelHorizontalView.a) this);
        this.f30551p.a((CardWheelHorizontalView.a) this);
        this.f30550o.a((CardWheelHorizontalView.a) this);
        this.f30524a.setSelection(this.f30525b.getPosition((Object) null));
    }
}
