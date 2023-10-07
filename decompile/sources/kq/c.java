package kq;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.cfly.uav_pro.R;
import com.flypro.core.mission.MissionItemType;
import com.flypro.core.mission.b;
import com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView;
import em.a;
import java.util.List;

public class c extends e implements CardWheelHorizontalView.a {

    /* renamed from: c  reason: collision with root package name */
    private List<a> f30521c;

    /* access modifiers changed from: protected */
    public int a() {
        return R.layout.fragment_editor_detail_circle;
    }

    public void a(CardWheelHorizontalView cardWheelHorizontalView, int i2, int i3) {
        int id2 = cardWheelHorizontalView.getId();
        if (id2 == R.id.altitudePicker) {
            for (a a2 : this.f30521c) {
                a2.a(new ej.a((double) i3));
            }
        } else if (id2 == R.id.loiterRadiusPicker) {
            for (a a3 : this.f30521c) {
                a3.a((double) i3);
            }
            b().a().b();
        } else if (id2 == R.id.loiterTurnPicker) {
            for (a a4 : this.f30521c) {
                a4.a(i3);
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Context applicationContext = getActivity().getApplicationContext();
        this.f30524a.setSelection(this.f30525b.getPosition(MissionItemType.CIRCLE));
        List<? extends b> c2 = c();
        this.f30521c = c2;
        a aVar = (a) c2.get(0);
        ll.c cVar = new ll.c(applicationContext, -200, 200, "%d m");
        cVar.a((int) R.layout.wheel_text_centered);
        CardWheelHorizontalView cardWheelHorizontalView = (CardWheelHorizontalView) view.findViewById(R.id.altitudePicker);
        cardWheelHorizontalView.setViewAdapter(cVar);
        cardWheelHorizontalView.a((CardWheelHorizontalView.a) this);
        cardWheelHorizontalView.setCurrentValue((int) aVar.e().g().a());
        ll.c cVar2 = new ll.c(applicationContext, R.layout.wheel_text_centered, 0, 10, "%d");
        CardWheelHorizontalView cardWheelHorizontalView2 = (CardWheelHorizontalView) view.findViewById(R.id.loiterTurnPicker);
        cardWheelHorizontalView2.setViewAdapter(cVar2);
        cardWheelHorizontalView2.a((CardWheelHorizontalView.a) this);
        cardWheelHorizontalView2.setCurrentValue(aVar.c());
        ll.c cVar3 = new ll.c(applicationContext, 0, 50, "%d m");
        cVar3.a((int) R.layout.wheel_text_centered);
        CardWheelHorizontalView cardWheelHorizontalView3 = (CardWheelHorizontalView) view.findViewById(R.id.loiterRadiusPicker);
        cardWheelHorizontalView3.setViewAdapter(cVar3);
        cardWheelHorizontalView3.a((CardWheelHorizontalView.a) this);
        cardWheelHorizontalView3.setCurrentValue((int) aVar.d());
    }
}
