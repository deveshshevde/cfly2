package com.xeagle.android.newUI.fragment.remindFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cfly.uav_pro.R;
import com.xeagle.android.newUI.activity.GuideActivity;

public class e extends b {
    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        ((GuideActivity) this.f24034a).a(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_controller_guide, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.bt_next).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                e.this.a(view);
            }
        });
    }
}
