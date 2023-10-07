package com.xeagle.android.dialogs;

import android.os.Bundle;

public class ah extends i {
    private ah() {
    }

    public static ah a(String str, String str2, long j2) {
        ah ahVar = new ah();
        Bundle bundle = new Bundle();
        bundle.putString("extra_download_title", str);
        bundle.putLong("extra_download_size", j2);
        bundle.putString("extra_download_warn", str2);
        ahVar.setArguments(bundle);
        return ahVar;
    }
}
