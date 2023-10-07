package kq;

import android.os.Bundle;
import android.view.View;
import com.cfly.uav_pro.R;
import com.flypro.core.mission.MissionItemType;
import com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView;
import ej.d;
import ll.c;

public class b extends e implements CardWheelHorizontalView.a {
    /* access modifiers changed from: protected */
    public int a() {
        return R.layout.fragment_editor_detail_change_speed;
    }

    public void a(CardWheelHorizontalView cardWheelHorizontalView, int i2, int i3) {
        if (cardWheelHorizontalView.getId() == R.id.picker1) {
            for (com.flypro.core.mission.b bVar : c()) {
                ((ek.b) bVar).a(new d((double) i3));
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f30524a.setSelection(this.f30525b.getPosition(MissionItemType.CHANGE_SPEED));
        c cVar = new c(getActivity().getApplicationContext(), R.layout.wheel_text_centered, 1, 20, "%d m/s");
        CardWheelHorizontalView cardWheelHorizontalView = (CardWheelHorizontalView) view.findViewById(R.id.picker1);
        cardWheelHorizontalView.setViewAdapter(cVar);
        cardWheelHorizontalView.a((CardWheelHorizontalView.a) this);
        cardWheelHorizontalView.setCurrentValue((int) ((ek.b) c().get(0)).c().a());
    }
}
