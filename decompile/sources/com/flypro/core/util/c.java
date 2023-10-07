package com.flypro.core.util;

import android.content.Context;
import androidx.core.content.b;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14470a;

    public c(Context context) {
        this.f14470a = context.getApplicationContext();
    }

    private boolean a(String str) {
        return b.b(this.f14470a, str) == -1;
    }

    public boolean a(String... strArr) {
        for (String a2 : strArr) {
            if (a(a2)) {
                return true;
            }
        }
        return false;
    }
}
