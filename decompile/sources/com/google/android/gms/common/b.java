package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.m;

public class b extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f17665a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f17666b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f17667c;

    public static b a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        b bVar = new b();
        Dialog dialog2 = (Dialog) m.a(dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        bVar.f17665a = dialog2;
        if (onCancelListener != null) {
            bVar.f17666b = onCancelListener;
        }
        return bVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f17666b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f17665a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f17667c == null) {
            this.f17667c = new AlertDialog.Builder((Context) m.a(getActivity())).create();
        }
        return this.f17667c;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
