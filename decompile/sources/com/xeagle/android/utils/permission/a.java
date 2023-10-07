package com.xeagle.android.utils.permission;

import android.content.Context;
import androidx.core.content.b;
import java.util.ArrayList;
import java.util.Iterator;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f24505a;

    public a(Context context) {
        this.f24505a = context.getApplicationContext();
    }

    private boolean a(String str) {
        return b.b(this.f24505a, str) == -1;
    }

    public boolean a(ArrayList<String> arrayList) {
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (a(it2.next())) {
                return true;
            }
        }
        return false;
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
