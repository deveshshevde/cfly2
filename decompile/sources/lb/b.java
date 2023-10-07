package lb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.cfly.uav_pro.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import jo.ak;
import org.greenrobot.eventbus.c;

public class b extends Fragment implements ChipGroup.b {

    /* renamed from: a  reason: collision with root package name */
    private ChipGroup f30735a;

    /* renamed from: b  reason: collision with root package name */
    private Chip f30736b;

    /* renamed from: c  reason: collision with root package name */
    private Chip f30737c;

    private void a(View view) {
        this.f30735a = (ChipGroup) view.findViewById(R.id.chip_group);
        this.f30736b = (Chip) view.findViewById(R.id.circle_model_chip);
        this.f30737c = (Chip) view.findViewById(R.id.follow_model_chip);
        this.f30735a.setOnCheckedChangeListener(this);
    }

    public void a(ChipGroup chipGroup, int i2) {
        ak akVar;
        c cVar;
        if (i2 == R.id.circle_model_chip) {
            cVar = c.a();
            akVar = new ak("circleMode");
        } else if (i2 == R.id.follow_model_chip) {
            cVar = c.a();
            akVar = new ak("followMode");
        } else {
            return;
        }
        cVar.d(akVar);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.drone_mode_layout, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(view);
    }
}
