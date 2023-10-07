package com.xeagle.android.vjoystick;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.variables.GuidedPoint;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView;
import en.a;

public class d extends c implements CardWheelHorizontalView.a {

    /* renamed from: a  reason: collision with root package name */
    public a f12945a;

    /* renamed from: b  reason: collision with root package name */
    private CardWheelHorizontalView f12946b;

    public void a(CardWheelHorizontalView cardWheelHorizontalView, int i2, int i3) {
        if (cardWheelHorizontalView.getId() == R.id.altitude_spinner) {
            this.f12945a.w().a((Context) getActivity(), (double) i3);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        Window window = create.getWindow();
        window.setGravity(48);
        create.show();
        window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 3) / 5, (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 4) / 5);
        return create;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f12945a = ((XEagleApp) getActivity().getApplication()).k();
        return layoutInflater.inflate(R.layout.fragment_mode_guided, viewGroup, false);
    }

    public void onDestroyView() {
        super.onDestroyView();
        CardWheelHorizontalView cardWheelHorizontalView = this.f12946b;
        if (cardWheelHorizontalView != null) {
            cardWheelHorizontalView.b((CardWheelHorizontalView.a) this);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ll.c cVar = new ll.c(getActivity().getApplicationContext(), R.layout.wheel_text_centered, 2, 50, "%d m");
        CardWheelHorizontalView cardWheelHorizontalView = (CardWheelHorizontalView) view.findViewById(R.id.altitude_spinner);
        this.f12946b = cardWheelHorizontalView;
        cardWheelHorizontalView.setViewAdapter(cVar);
        this.f12946b.setCurrentValue((int) Math.max(this.f12945a.w().b().a(), (double) GuidedPoint.b(this.f12945a)));
        this.f12946b.a((CardWheelHorizontalView.a) this);
    }
}
