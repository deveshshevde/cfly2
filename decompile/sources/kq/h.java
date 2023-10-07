package kq;

import android.os.Bundle;
import android.view.View;
import com.cfly.uav_pro.R;
import com.flypro.core.mission.MissionItemType;

public class h extends e {
    /* access modifiers changed from: protected */
    public int a() {
        return R.layout.fragment_editor_detail_rtl;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f30524a.setSelection(this.f30525b.getPosition(MissionItemType.RTL));
    }
}
