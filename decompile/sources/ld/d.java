package ld;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.MAVLink.Messages.ApmModes;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.activities.helpers.b;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import jo.ak;
import org.greenrobot.eventbus.c;

public class d extends b implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public IButton f30774e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public IButton f30775f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public IButton f30776g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public IButton f30777h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public IButton f30778i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public IButton f30779j;

    /* renamed from: k  reason: collision with root package name */
    private FlightActionActivity f30780k;

    private void a(View view) {
        this.f30774e = (IButton) view.findViewById(R.id.normal_mode_btn);
        this.f30775f = (IButton) view.findViewById(R.id.sky_rocket_btn);
        this.f30776g = (IButton) view.findViewById(R.id.fly_away_btn);
        this.f30777h = (IButton) view.findViewById(R.id.spiral_btn);
        this.f30778i = (IButton) view.findViewById(R.id.comet_btn);
        this.f30779j = (IButton) view.findViewById(R.id.circle_btn);
        this.f30774e.setOnClickListener(this);
        this.f30775f.setOnClickListener(this);
        this.f30776g.setOnClickListener(this);
        this.f30777h.setOnClickListener(this);
        this.f30778i.setOnClickListener(this);
        this.f30779j.setOnClickListener(this);
        if (!this.f12363c.d().e().equals(ApmModes.ROTOR_POSHOLD)) {
            b();
            this.f30774e.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.normal_mode_pre, 0, 0);
            this.f30774e.setTextColor(Color.parseColor("#12a6ea"));
            c.a().d(new ak("normalMode"));
        }
    }

    private void b() {
        this.f30780k.runOnUiThread(new Runnable() {
            public void run() {
                d.this.f30774e.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.normal_nor, 0, 0);
                d.this.f30775f.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.sky_rocket_nor, 0, 0);
                d.this.f30776g.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.fly_away_nor, 0, 0);
                d.this.f30777h.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.spiral_nor, 0, 0);
                d.this.f30778i.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.comet_nor, 0, 0);
                d.this.f30779j.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.circle_mode_nor, 0, 0);
                d.this.f30774e.setTextColor(-1);
                d.this.f30775f.setTextColor(-1);
                d.this.f30776g.setTextColor(-1);
                d.this.f30777h.setTextColor(-1);
                d.this.f30778i.setTextColor(-1);
                d.this.f30779j.setTextColor(-1);
            }
        });
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f30780k = (FlightActionActivity) activity;
    }

    public void onClick(View view) {
        IButton iButton;
        switch (view.getId()) {
            case R.id.circle_btn:
                b();
                this.f30779j.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.circle_mode_pre, 0, 0);
                c.a().d(new ak("circleMode"));
                iButton = this.f30779j;
                break;
            case R.id.comet_btn:
                b();
                this.f30778i.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.comet_pre, 0, 0);
                c.a().d(new ak("cometMode"));
                iButton = this.f30778i;
                break;
            case R.id.fly_away_btn:
                b();
                this.f30776g.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.fly_away_pre, 0, 0);
                c.a().d(new ak("flyAway"));
                iButton = this.f30776g;
                break;
            case R.id.normal_mode_btn:
                b();
                this.f30774e.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.normal_mode_pre, 0, 0);
                this.f12363c.d().b(ApmModes.ROTOR_LOITER);
                c.a().d(new ak("normalMode"));
                iButton = this.f30774e;
                break;
            case R.id.sky_rocket_btn:
                b();
                this.f30775f.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.sky_rocket_pre, 0, 0);
                c.a().d(new ak("skyRocket"));
                iButton = this.f30775f;
                break;
            case R.id.spiral_btn:
                b();
                this.f30777h.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.spiral_pre, 0, 0);
                c.a().d(new ak("spiralFlight"));
                iButton = this.f30777h;
                break;
            default:
                return;
        }
        iButton.setTextColor(Color.parseColor("#12a6ea"));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.model_select_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(view);
    }
}
