package kq;

import android.os.Bundle;
import android.view.View;
import com.cfly.uav_pro.R;
import com.flypro.core.mission.b;
import com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView;
import ej.a;
import em.c;

public class i extends e implements CardWheelHorizontalView.a {
    /* access modifiers changed from: protected */
    public int a() {
        return R.layout.fragment_editor_detail_roi;
    }

    public void a(CardWheelHorizontalView cardWheelHorizontalView, int i2, int i3) {
        if (cardWheelHorizontalView.getId() == R.id.altitudePicker) {
            for (b bVar : c()) {
                ((c) bVar).a(new a((double) i3));
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f30524a.setSelection(this.f30525b.getPosition((Object) null));
        ll.c cVar = new ll.c(getActivity().getApplicationContext(), R.layout.wheel_text_centered, -200, 200, "%d m");
        CardWheelHorizontalView cardWheelHorizontalView = (CardWheelHorizontalView) view.findViewById(R.id.altitudePicker);
        cardWheelHorizontalView.setViewAdapter(cVar);
        cardWheelHorizontalView.a((CardWheelHorizontalView.a) this);
        cardWheelHorizontalView.setCurrentValue((int) ((c) c().get(0)).e().g().a());
    }
}
