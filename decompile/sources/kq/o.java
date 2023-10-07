package kq;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.cfly.uav_pro.R;
import com.flypro.core.mission.b;
import com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView;
import ek.g;
import ll.c;

public class o extends e implements TextWatcher, CardWheelHorizontalView.a {
    /* access modifiers changed from: protected */
    public int a() {
        return R.layout.fragment_editor_detail_set_servo;
    }

    public void a(CardWheelHorizontalView cardWheelHorizontalView, int i2, int i3) {
        if (cardWheelHorizontalView.getId() == R.id.picker1) {
            for (b bVar : c()) {
                ((g) bVar).b(i3);
            }
        }
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (!charSequence.toString().isEmpty()) {
            for (b bVar : c()) {
                ((g) bVar).a(Integer.valueOf(charSequence.toString()).intValue());
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f30524a.setSelection(this.f30525b.getPosition((Object) null));
        g gVar = (g) c().get(0);
        c cVar = new c(getActivity().getApplicationContext(), R.layout.wheel_text_centered, 1, 8, "%d");
        CardWheelHorizontalView cardWheelHorizontalView = (CardWheelHorizontalView) view.findViewById(R.id.picker1);
        EditText editText = (EditText) view.findViewById(R.id.PwmEditText);
        cardWheelHorizontalView.setViewAdapter(cVar);
        cardWheelHorizontalView.a((CardWheelHorizontalView.a) this);
        cardWheelHorizontalView.setCurrentValue(gVar.d());
        editText.setText(Integer.toString(gVar.c()));
        editText.addTextChangedListener(this);
    }
}
