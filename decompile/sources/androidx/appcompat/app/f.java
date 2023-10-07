package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.c;

public class f extends c {
    public Dialog onCreateDialog(Bundle bundle) {
        return new e(getContext(), getTheme());
    }

    public void setupDialog(Dialog dialog, int i2) {
        if (dialog instanceof e) {
            e eVar = (e) dialog;
            if (!(i2 == 1 || i2 == 2)) {
                if (i2 == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            eVar.a(1);
            return;
        }
        super.setupDialog(dialog, i2);
    }
}
