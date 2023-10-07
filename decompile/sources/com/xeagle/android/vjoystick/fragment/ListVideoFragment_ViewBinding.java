package com.xeagle.android.vjoystick.fragment;

import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.cfly.uav_pro.R;

public class ListVideoFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private b f24987a;

    public ListVideoFragment_ViewBinding(b bVar, View view) {
        this.f24987a = bVar;
        bVar.listVideo = (ListView) Utils.findRequiredViewAsType(view, R.id.left_stick, "field 'listVideo'", ListView.class);
    }

    public void unbind() {
        b bVar = this.f24987a;
        if (bVar != null) {
            this.f24987a = null;
            bVar.listVideo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
