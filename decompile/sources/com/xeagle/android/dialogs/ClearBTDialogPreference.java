package com.xeagle.android.dialogs;

import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import com.xeagle.android.utils.prefs.a;

public class ClearBTDialogPreference extends DialogPreference {

    /* renamed from: a  reason: collision with root package name */
    private a f22495a;

    public ClearBTDialogPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22495a = new a(context.getApplicationContext());
    }

    /* access modifiers changed from: protected */
    public void onDialogClosed(boolean z2) {
        super.onDialogClosed(z2);
        if (z2) {
            this.f22495a.p("");
        }
    }
}
