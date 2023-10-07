package com.xeagle.android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.fragments.h;
import en.a;

public class l extends Fragment implements View.OnClickListener, h.a {

    /* renamed from: a  reason: collision with root package name */
    private Button f23447a;

    public boolean a(a aVar) {
        return false;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.mc_connectBtn) {
            ((SuperUI) getActivity()).i();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_generic_mission_control, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Button button = (Button) view.findViewById(R.id.mc_connectBtn);
        this.f23447a = button;
        button.setOnClickListener(this);
    }
}
