package com.xeagle.android.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;

public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f12377a = true;

    public void dismiss() {
        dismissAllowingStateLoss();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int i2;
        int i3;
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        if (f12377a || window != null) {
            window.setGravity(17);
            create.show();
            int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
            int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
            if (width >= height) {
                i3 = width / 2;
                i2 = height * 3;
            } else {
                i3 = (width * 4) / 5;
                i2 = height * 2;
            }
            window.setLayout(i3, i2 / 5);
            return create;
        }
        throw new AssertionError();
    }

    public void show(FragmentManager fragmentManager, String str) {
        try {
            fragmentManager.a().a((Fragment) this).c();
            super.show(fragmentManager, str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
