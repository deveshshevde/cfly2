package com.xeagle.android.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentTabHost;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.fragments.ParamsFragment;
import com.xeagle.android.fragments.q;
import com.xeagle.android.vjoystick.view.a;

public class MainTabActivity extends SuperUI {

    /* renamed from: a  reason: collision with root package name */
    private FragmentTabHost f22205a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f22206b;

    /* renamed from: c  reason: collision with root package name */
    private Class[] f22207c = {q.class, ParamsFragment.class};

    /* renamed from: k  reason: collision with root package name */
    private int[] f22208k = {R.drawable.tab_more_btn, R.drawable.tab_home_btn};

    /* renamed from: l  reason: collision with root package name */
    private int[] f22209l = {R.string.button_setup_calibrate, R.string.screen_parameters};

    /* renamed from: m  reason: collision with root package name */
    private a f22210m;

    /* renamed from: n  reason: collision with root package name */
    private int f22211n;

    private View a(int i2) {
        View inflate = this.f22206b.inflate(R.layout.tab_item_view, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.imageview)).setImageResource(this.f22208k[i2]);
        ((TextView) inflate.findViewById(R.id.textview)).setText(this.f22209l[i2]);
        return inflate;
    }

    private void a() {
        this.f22206b = LayoutInflater.from(this);
        FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(16908306);
        this.f22205a = fragmentTabHost;
        fragmentTabHost.setBackgroundColor(this.f22211n);
        this.f22205a.a((Context) this, getSupportFragmentManager(), (int) R.id.realtabcontent);
        int length = this.f22207c.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f22205a.a(this.f22205a.newTabSpec(getString(this.f22209l[i2])).setIndicator(a(i2)), (Class<?>) this.f22207c[i2], (Bundle) null);
        }
    }

    public void onCreate(Bundle bundle) {
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        setContentView((int) R.layout.main_tab_layout);
        a aVar = new a(this);
        this.f22210m = aVar;
        aVar.a(false);
        this.f22210m.b(true);
        int a2 = com.xeagle.android.camera.widgets.ablum.a.a(this);
        this.f22211n = a2;
        this.f22210m.a(a2);
        a();
    }
}
