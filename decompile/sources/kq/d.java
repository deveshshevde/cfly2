package kq;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.cfly.uav_pro.R;
import com.flypro.core.mission.b;
import com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView;
import ek.c;

public class d extends e implements CompoundButton.OnCheckedChangeListener, CardWheelHorizontalView.a {

    /* renamed from: c  reason: collision with root package name */
    private CheckBox f30522c;

    /* access modifiers changed from: protected */
    public int a() {
        return R.layout.fragment_editor_detail_condition_yaw;
    }

    public void a(CardWheelHorizontalView cardWheelHorizontalView, int i2, int i3) {
        if (cardWheelHorizontalView.getId() == R.id.picker1) {
            for (b bVar : c()) {
                ((c) bVar).a((double) i3);
            }
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        if (compoundButton.getId() == R.id.checkBox1) {
            for (b bVar : c()) {
                ((c) bVar).a(z2);
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f30524a.setSelection(this.f30525b.getPosition((Object) null));
        c cVar = (c) c().get(0);
        ll.c cVar2 = new ll.c(getActivity().getApplicationContext(), R.layout.wheel_text_centered, 0, 359, "%d deg");
        CardWheelHorizontalView cardWheelHorizontalView = (CardWheelHorizontalView) view.findViewById(R.id.picker1);
        cardWheelHorizontalView.setViewAdapter(cVar2);
        cardWheelHorizontalView.a((CardWheelHorizontalView.a) this);
        cardWheelHorizontalView.setCurrentValue((int) cVar.c());
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBox1);
        this.f30522c = checkBox;
        checkBox.setOnCheckedChangeListener(this);
        this.f30522c.setChecked(cVar.d());
    }
}
