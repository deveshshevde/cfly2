package ld;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.MAVLink.Messages.ApmModes;
import com.cfly.uav_pro.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.FlightActionActivity;
import en.a;
import jo.ak;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class b extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public TextView f13973a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TextView f13974b;

    /* renamed from: c  reason: collision with root package name */
    private a f13975c;

    /* renamed from: d  reason: collision with root package name */
    private FlightActionActivity f13976d;

    private void a(View view) {
        this.f13973a = (TextView) view.findViewById(R.id.mode_title_tv);
        this.f13974b = (TextView) view.findViewById(R.id.mode_info_tv);
        if (!this.f13975c.d().e().equals(ApmModes.ROTOR_POSHOLD)) {
            this.f13973a.setText(this.f13976d.getString(R.string.normal_model));
            this.f13974b.setText(this.f13976d.getString(R.string.normal_mode_description));
        }
    }

    private void a(final String str, final String str2) {
        this.f13976d.runOnUiThread(new Runnable() {
            public void run() {
                b.this.f13973a.setText(str);
                b.this.f13974b.setText(str2);
            }
        });
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f13976d = (FlightActionActivity) activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.mode_info_layouot, viewGroup, false);
    }

    public void onStart() {
        super.onStart();
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
    }

    public void onStop() {
        super.onStop();
        if (c.a().b(this)) {
            c.a().c(this);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f13975c = ((XEagleApp) this.f13976d.getApplicationContext()).k();
        a(view);
    }

    @l(a = ThreadMode.MAIN)
    public void selectModel(ak akVar) {
        String string;
        FlightActionActivity flightActionActivity;
        int i2;
        String a2 = akVar.a();
        a2.hashCode();
        char c2 = 65535;
        switch (a2.hashCode()) {
            case -1729768619:
                if (a2.equals("skyRocket")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1711183949:
                if (a2.equals("cometMode")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1255891158:
                if (a2.equals("normalMode")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1111063917:
                if (a2.equals("circleMode")) {
                    c2 = 3;
                    break;
                }
                break;
            case -758156799:
                if (a2.equals("flyAway")) {
                    c2 = 4;
                    break;
                }
                break;
            case -58867007:
                if (a2.equals("spiralFlight")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                string = this.f13976d.getString(R.string.sky_rocket);
                flightActionActivity = this.f13976d;
                i2 = R.string.sky_rocket_description;
                break;
            case 1:
                string = this.f13976d.getString(R.string.comet_mode);
                flightActionActivity = this.f13976d;
                i2 = R.string.comet_mode_description;
                break;
            case 2:
                string = this.f13976d.getString(R.string.normal_model);
                flightActionActivity = this.f13976d;
                i2 = R.string.normal_mode_description;
                break;
            case 3:
                string = this.f13976d.getString(R.string.circle_model);
                flightActionActivity = this.f13976d;
                i2 = R.string.circle_mode_description;
                break;
            case 4:
                string = this.f13976d.getString(R.string.fly_away);
                flightActionActivity = this.f13976d;
                i2 = R.string.fly_away_description;
                break;
            case 5:
                string = this.f13976d.getString(R.string.spiral_flight);
                flightActionActivity = this.f13976d;
                i2 = R.string.spiral_flight_description;
                break;
            default:
                return;
        }
        a(string, flightActionActivity.getString(i2));
    }
}
