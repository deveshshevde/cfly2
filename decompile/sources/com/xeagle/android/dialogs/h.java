package com.xeagle.android.dialogs;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.c;

public class h extends c {
    /* access modifiers changed from: protected */
    public void a() {
        int i2;
        View view;
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
            view = getActivity().getWindow().getDecorView();
            i2 = 8;
        } else if (Build.VERSION.SDK_INT >= 19) {
            view = getActivity().getWindow().getDecorView();
            i2 = 4102;
        } else {
            return;
        }
        view.setSystemUiVisibility(i2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }
}
