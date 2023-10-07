package kq;

import android.os.Bundle;
import android.view.View;
import com.cfly.uav_pro.R;
import com.flypro.core.mission.b;
import com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView;
import ej.c;

public class a extends e implements CardWheelHorizontalView.a {
    /* access modifiers changed from: protected */
    public int a() {
        return R.layout.fragment_editor_detail_camera_trigger;
    }

    public void a(CardWheelHorizontalView cardWheelHorizontalView, int i2, int i3) {
        if (cardWheelHorizontalView.getId() == R.id.picker1) {
            for (b bVar : c()) {
                ((ek.a) bVar).a(new c((double) i3));
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f30524a.setSelection(this.f30525b.getPosition((Object) null));
        ll.c cVar = new ll.c(getActivity().getApplicationContext(), R.layout.wheel_text_centered, 0, 100, "%d m");
        CardWheelHorizontalView cardWheelHorizontalView = (CardWheelHorizontalView) view.findViewById(R.id.picker1);
        cardWheelHorizontalView.setViewAdapter(cVar);
        cardWheelHorizontalView.a((CardWheelHorizontalView.a) this);
        cardWheelHorizontalView.setCurrentValue((int) ((ek.a) c().get(0)).c().a());
    }
}
