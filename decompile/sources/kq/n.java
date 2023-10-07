package kq;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.cfly.uav_pro.R;
import com.flypro.core.mission.MissionItemType;
import com.flypro.core.mission.b;
import com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView;
import ej.a;
import em.g;
import ll.c;

public class n extends e implements CardWheelHorizontalView.a {
    /* access modifiers changed from: protected */
    public int a() {
        return R.layout.fragment_editor_detail_waypoint;
    }

    public void a(CardWheelHorizontalView cardWheelHorizontalView, int i2, int i3) {
        int id2 = cardWheelHorizontalView.getId();
        if (id2 == R.id.altitudePicker) {
            for (b bVar : c()) {
                ((g) bVar).a(new a((double) i3));
            }
        } else if (id2 == R.id.waypointDelayPicker) {
            for (b bVar2 : c()) {
                ((g) bVar2).a((double) i3);
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Context applicationContext = getActivity().getApplicationContext();
        this.f30524a.setSelection(this.f30525b.getPosition(MissionItemType.WAYPOINT));
        g gVar = (g) c().get(0);
        c cVar = new c(applicationContext, R.layout.wheel_text_centered, 0, 60, "%d s");
        CardWheelHorizontalView cardWheelHorizontalView = (CardWheelHorizontalView) view.findViewById(R.id.waypointDelayPicker);
        cardWheelHorizontalView.setViewAdapter(cVar);
        cardWheelHorizontalView.a((CardWheelHorizontalView.a) this);
        cardWheelHorizontalView.setCurrentValue((int) gVar.c());
        c cVar2 = new c(applicationContext, R.layout.wheel_text_centered, -200, 200, "%d m");
        CardWheelHorizontalView cardWheelHorizontalView2 = (CardWheelHorizontalView) view.findViewById(R.id.altitudePicker);
        cardWheelHorizontalView2.setViewAdapter(cVar2);
        cardWheelHorizontalView2.a((CardWheelHorizontalView.a) this);
        cardWheelHorizontalView2.setCurrentValue((int) gVar.e().g().a());
    }
}
