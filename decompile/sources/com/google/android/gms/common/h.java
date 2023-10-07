package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.c;
import com.google.android.gms.common.internal.m;

public class h extends c {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f17702a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f17703b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f17704c;

    public static h a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        h hVar = new h();
        Dialog dialog2 = (Dialog) m.a(dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        hVar.f17702a = dialog2;
        if (onCancelListener != null) {
            hVar.f17703b = onCancelListener;
        }
        return hVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f17703b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f17702a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f17704c == null) {
            this.f17704c = new AlertDialog.Builder((Context) m.a(getContext())).create();
        }
        return this.f17704c;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
