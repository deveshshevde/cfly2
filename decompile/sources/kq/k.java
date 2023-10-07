package kq;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import com.cfly.uav_pro.R;
import com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView;
import com.xeagle.android.widgets.spinners.SpinnerSelfSelect;
import em.f;
import eo.a;
import java.util.List;
import kp.b;
import ll.c;

public class k extends e implements CompoundButton.OnCheckedChangeListener, CardWheelHorizontalView.a {

    /* renamed from: c  reason: collision with root package name */
    private CheckBox f30530c;

    /* renamed from: d  reason: collision with root package name */
    private CardWheelHorizontalView f30531d;

    /* renamed from: e  reason: collision with root package name */
    private CardWheelHorizontalView f30532e;

    /* renamed from: f  reason: collision with root package name */
    private CardWheelHorizontalView f30533f;

    /* renamed from: g  reason: collision with root package name */
    private CardWheelHorizontalView f30534g;

    /* renamed from: h  reason: collision with root package name */
    private SpinnerSelfSelect f30535h;

    /* renamed from: i  reason: collision with root package name */
    private b f30536i;

    /* renamed from: j  reason: collision with root package name */
    private List<f> f30537j;

    private f d() {
        return (f) c().get(0);
    }

    /* access modifiers changed from: protected */
    public int a() {
        return R.layout.fragment_editor_detail_structure_scanner;
    }

    public void a(Spinner spinner, int i2) {
        if (spinner.getId() == R.id.cameraFileSpinner) {
            a a2 = this.f30536i.a(i2);
            this.f30536i.a(a2.f26931a);
            for (f a3 : this.f30537j) {
                a3.a(a2);
            }
            b().a().b();
        }
    }

    public void a(CardWheelHorizontalView cardWheelHorizontalView, int i2, int i3) {
        switch (cardWheelHorizontalView.getId()) {
            case R.id.heightStepPicker:
                d().b(i3);
                break;
            case R.id.radiusPicker:
                d().a(i3);
                break;
            case R.id.startAltitudePicker:
                d().a(new ej.a((double) i3));
                break;
            case R.id.stepsPicker:
                d().c(i3);
                break;
        }
        b().a().b();
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        d().a(z2);
        b().a().b();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Context applicationContext = getActivity().getApplicationContext();
        Log.d("DEBUG", "onViewCreated");
        this.f30524a.setSelection(this.f30525b.getPosition((Object) null));
        List<? extends com.flypro.core.mission.b> c2 = c();
        this.f30537j = c2;
        f fVar = (f) c2.get(0);
        this.f30536i = new b(getActivity(), 17367049);
        SpinnerSelfSelect spinnerSelfSelect = (SpinnerSelfSelect) view.findViewById(R.id.cameraFileSpinner);
        this.f30535h = spinnerSelfSelect;
        spinnerSelfSelect.setAdapter(this.f30536i);
        this.f30535h.setOnSpinnerItemSelectedListener(this);
        this.f30536i.a(fVar.h());
        CardWheelHorizontalView cardWheelHorizontalView = (CardWheelHorizontalView) view.findViewById(R.id.radiusPicker);
        this.f30531d = cardWheelHorizontalView;
        cardWheelHorizontalView.setViewAdapter(new c(applicationContext, R.layout.wheel_text_centered, 2, 100, "%d m"));
        this.f30531d.a((CardWheelHorizontalView.a) this);
        this.f30531d.setCurrentValue((int) fVar.f().a());
        CardWheelHorizontalView cardWheelHorizontalView2 = (CardWheelHorizontalView) view.findViewById(R.id.startAltitudePicker);
        this.f30532e = cardWheelHorizontalView2;
        cardWheelHorizontalView2.setViewAdapter(new c(applicationContext, R.layout.wheel_text_centered, -200, 200, "%d m"));
        this.f30532e.a((CardWheelHorizontalView.a) this);
        this.f30532e.setCurrentValue((int) fVar.e().g().a());
        CardWheelHorizontalView cardWheelHorizontalView3 = (CardWheelHorizontalView) view.findViewById(R.id.heightStepPicker);
        this.f30533f = cardWheelHorizontalView3;
        cardWheelHorizontalView3.setViewAdapter(new c(applicationContext, R.layout.wheel_text_centered, 1, 200, "%d m"));
        this.f30533f.a((CardWheelHorizontalView.a) this);
        this.f30533f.setCurrentValue((int) fVar.c().a());
        CardWheelHorizontalView cardWheelHorizontalView4 = (CardWheelHorizontalView) view.findViewById(R.id.stepsPicker);
        this.f30534g = cardWheelHorizontalView4;
        cardWheelHorizontalView4.setViewAdapter(new c(applicationContext, R.layout.wheel_text_centered, 1, 10, "%d"));
        this.f30534g.a((CardWheelHorizontalView.a) this);
        this.f30534g.setCurrentValue(fVar.d());
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBoxSurveyCrossHatch);
        this.f30530c = checkBox;
        checkBox.setOnCheckedChangeListener(this);
        this.f30530c.setChecked(fVar.g());
    }
}
