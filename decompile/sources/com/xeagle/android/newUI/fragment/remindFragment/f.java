package com.xeagle.android.newUI.fragment.remindFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.newUI.activity.GuideActivity;

public class f extends b {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f24039b;

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        ((GuideActivity) this.f24034a).a(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_drone_guide, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        ImageView imageView;
        int i2;
        super.onViewCreated(view, bundle);
        this.f24039b = (ImageView) view.findViewById(R.id.iv_guide_drone);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("droneType", "808D");
            if (string.equalsIgnoreCase(UserGlobal.DRONE_NAME_DF816)) {
                imageView = this.f24039b;
                i2 = R.drawable.guide_816_tail;
            } else if (string.equalsIgnoreCase("808D")) {
                imageView = this.f24039b;
                i2 = R.drawable.guide_808_d_tail;
            } else if (string.equalsIgnoreCase("809d")) {
                imageView = this.f24039b;
                i2 = R.drawable.guide_809d_tail;
            } else if (string.equalsIgnoreCase("809e")) {
                imageView = this.f24039b;
                i2 = R.drawable.guide_809e_tail;
            }
            imageView.setImageResource(i2);
        }
        view.findViewById(R.id.bt_next).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                f.this.a(view);
            }
        });
    }
}
