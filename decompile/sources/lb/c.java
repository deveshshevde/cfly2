package lb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.helpers.b;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import java.util.Locale;
import jo.aa;
import jo.ab;
import jo.ac;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class c extends b implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    /* renamed from: e  reason: collision with root package name */
    private IImageButton f13942e;

    /* renamed from: f  reason: collision with root package name */
    private SeekBar f13943f;

    /* renamed from: g  reason: collision with root package name */
    private SeekBar f13944g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f13945h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextView f13946i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f13947j;

    /* renamed from: k  reason: collision with root package name */
    private int f13948k;

    /* renamed from: l  reason: collision with root package name */
    private int f13949l;

    /* renamed from: m  reason: collision with root package name */
    private String f13950m;

    private void a(View view) {
        int i2;
        SeekBar seekBar;
        int i3;
        SeekBar seekBar2;
        this.f13942e = (IImageButton) view.findViewById(R.id.fragment_back);
        this.f13943f = (SeekBar) view.findViewById(R.id.seek_alt);
        this.f13944g = (SeekBar) view.findViewById(R.id.seek_radius);
        this.f13945h = (TextView) view.findViewById(R.id.model_radius);
        this.f13946i = (TextView) view.findViewById(R.id.model_alt);
        this.f13947j = (TextView) view.findViewById(R.id.settingDescription);
        int b2 = (int) this.f12363c.t().b();
        double f2 = this.f12363c.b().f();
        this.f13942e.setOnClickListener(this);
        if (b2 <= 5) {
            this.f13943f.setMin(5);
            seekBar = this.f13943f;
            i2 = 205;
        } else {
            this.f13943f.setMin(b2);
            seekBar = this.f13943f;
            i2 = b2 + 200;
        }
        seekBar.setMax(i2);
        if (f2 <= 200.0d) {
            seekBar2 = this.f13944g;
            i3 = 0;
        } else {
            seekBar2 = this.f13944g;
            i3 = (int) (f2 - 200.0d);
        }
        seekBar2.setMin(i3);
        this.f13944g.setMax((int) (200.0d + f2));
        this.f13943f.setProgress(b2);
        this.f13944g.setProgress((int) f2);
        this.f13944g.setOnSeekBarChangeListener(this);
        this.f13943f.setOnSeekBarChangeListener(this);
    }

    public void a(String str) {
        this.f13950m = str;
    }

    @l(a = ThreadMode.MAIN)
    public void modelSendEvent(aa aaVar) {
        if (aaVar.a()) {
            org.greenrobot.eventbus.c.a().d(new ac(this.f13950m, this.f13949l, this.f13948k));
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.fragment_back) {
            org.greenrobot.eventbus.c.a().d(new ab(true));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.model_setting_layout, viewGroup, false);
    }

    public void onProgressChanged(SeekBar seekBar, final int i2, boolean z2) {
        if (seekBar.getId() == R.id.seek_alt) {
            this.f13946i.post(new Runnable() {
                public void run() {
                    c.this.f13946i.setText(String.format(Locale.US, "%s:%d", new Object[]{c.this.getString(R.string.altitude_label), Integer.valueOf(i2)}));
                }
            });
        } else if (seekBar.getId() == R.id.seek_radius) {
            this.f13945h.setText(String.format(Locale.US, "%s:%d", new Object[]{getString(R.string.waypoint_distance), Integer.valueOf(i2)}));
        }
    }

    public void onStart() {
        super.onStart();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStop() {
        super.onStop();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar.getId() == R.id.seek_alt) {
            this.f13948k = seekBar.getProgress();
        } else if (seekBar.getId() == R.id.seek_radius) {
            this.f13949l = seekBar.getProgress();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(view);
    }
}
