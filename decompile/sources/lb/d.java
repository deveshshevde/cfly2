package lb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.s;
import com.cfly.uav_pro.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class d extends Fragment implements MaterialButtonToggleGroup.c {

    /* renamed from: a  reason: collision with root package name */
    private MaterialButtonToggleGroup f30740a;

    /* renamed from: b  reason: collision with root package name */
    private MaterialButton f30741b;

    /* renamed from: c  reason: collision with root package name */
    private MaterialButton f30742c;

    private void a(View view) {
        this.f30740a = (MaterialButtonToggleGroup) view.findViewById(R.id.toggle_group);
        this.f30741b = (MaterialButton) view.findViewById(R.id.mode_btn);
        this.f30742c = (MaterialButton) view.findViewById(R.id.shot_btn);
        this.f30740a.a((MaterialButtonToggleGroup.c) this);
    }

    public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z2) {
        Fragment fragment;
        s a2 = getChildFragmentManager().a();
        if (i2 == R.id.mode_btn) {
            fragment = new b();
        } else if (i2 == R.id.shot_btn) {
            fragment = new e();
        } else {
            return;
        }
        a2.b(R.id.modelContent, fragment);
        a2.a("recordModel");
        a2.c(4097);
        a2.d();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.record_model_layout, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        s a2 = getChildFragmentManager().a();
        if (bundle == null) {
            a2.a((int) R.id.modelContent, (Fragment) new e());
            a2.d();
        }
        a(view);
    }
}
