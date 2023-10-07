package com.xeagle.android.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;
import com.google.android.gms.maps.model.LatLng;

public class n extends c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f22699a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public LatLng f22700b;

    public interface a {
        void a(LatLng latLng);
    }

    public void a(LatLng latLng) {
        this.f22700b = latLng;
    }

    public void a(a aVar) {
        this.f22699a = aVar;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.guided_mode_warning).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (n.this.f22700b != null) {
                    n.this.f22699a.a(n.this.f22700b);
                }
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        return builder.create();
    }
}
