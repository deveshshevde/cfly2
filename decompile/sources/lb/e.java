package lb;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.cfly.uav_pro.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import jo.ak;
import org.greenrobot.eventbus.c;

public class e extends Fragment implements ChipGroup.b {

    /* renamed from: a  reason: collision with root package name */
    private ChipGroup f30743a;

    /* renamed from: b  reason: collision with root package name */
    private Chip f30744b;

    /* renamed from: c  reason: collision with root package name */
    private Chip f30745c;

    /* renamed from: d  reason: collision with root package name */
    private Chip f30746d;

    /* renamed from: e  reason: collision with root package name */
    private Chip f30747e;

    private void a(View view) {
        this.f30743a = (ChipGroup) view.findViewById(R.id.chip_group);
        this.f30744b = (Chip) view.findViewById(R.id.sky_rocket_chip);
        this.f30745c = (Chip) view.findViewById(R.id.fly_away_chip);
        this.f30746d = (Chip) view.findViewById(R.id.spiral_flight_chip);
        this.f30747e = (Chip) view.findViewById(R.id.comet_mode_chip);
        this.f30743a.setOnCheckedChangeListener(this);
    }

    public void a(ChipGroup chipGroup, int i2) {
        ak akVar;
        c cVar;
        Log.i("Camera", "onCheckedChanged:---checkId--- " + i2);
        switch (i2) {
            case R.id.comet_mode_chip:
                cVar = c.a();
                akVar = new ak("cometMode");
                break;
            case R.id.fly_away_chip:
                cVar = c.a();
                akVar = new ak("flyAway");
                break;
            case R.id.sky_rocket_chip:
                cVar = c.a();
                akVar = new ak("skyRocket");
                break;
            case R.id.spiral_flight_chip:
                cVar = c.a();
                akVar = new ak("spiralFlight");
                break;
            default:
                return;
        }
        cVar.d(akVar);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.model_select_layout, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(view);
    }
}
