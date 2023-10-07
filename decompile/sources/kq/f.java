package kq;

import android.os.Bundle;
import android.view.View;
import com.cfly.uav_pro.R;

public class f extends e {
    /* access modifiers changed from: protected */
    public int a() {
        return R.layout.fragment_editor_detail_epm_grabber;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f30524a.setSelection(this.f30525b.getPosition((Object) null));
    }
}
