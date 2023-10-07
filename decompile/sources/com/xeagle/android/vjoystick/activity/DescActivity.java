package com.xeagle.android.vjoystick.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.cfly.uav_pro.R;
import com.xeagle.android.newUI.activity.BaseActivity;
import java.util.HashMap;

public final class DescActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f24952a;

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DescActivity f24953a;

        a(DescActivity descActivity) {
            this.f24953a = descActivity;
        }

        public final void onClick(View view) {
            this.f24953a.finish();
        }
    }

    public View a(int i2) {
        if (this.f24952a == null) {
            this.f24952a = new HashMap();
        }
        View view = (View) this.f24952a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f24952a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.desc_layout);
        ((ImageView) a(com.xeagle.R.id.imgClose)).setOnClickListener(new a(this));
    }
}
