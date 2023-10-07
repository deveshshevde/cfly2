package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.f;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class b extends f {

    /* renamed from: a  reason: collision with root package name */
    private boolean f18673a;

    private class a extends BottomSheetBehavior.a {
        private a() {
        }

        public void a(View view, float f2) {
        }

        public void a(View view, int i2) {
            if (i2 == 5) {
                b.this.a();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        if (this.f18673a) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void a(BottomSheetBehavior<?> bottomSheetBehavior, boolean z2) {
        this.f18673a = z2;
        if (bottomSheetBehavior.e() == 5) {
            a();
            return;
        }
        if (getDialog() instanceof a) {
            ((a) getDialog()).e();
        }
        bottomSheetBehavior.a((BottomSheetBehavior.a) new a());
        bottomSheetBehavior.e(5);
    }

    private boolean a(boolean z2) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof a)) {
            return false;
        }
        a aVar = (a) dialog;
        BottomSheetBehavior<FrameLayout> a2 = aVar.a();
        if (!a2.c() || !aVar.c()) {
            return false;
        }
        a(a2, z2);
        return true;
    }

    public void dismiss() {
        if (!a(false)) {
            super.dismiss();
        }
    }

    public void dismissAllowingStateLoss() {
        if (!a(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new a(getContext(), getTheme());
    }
}
