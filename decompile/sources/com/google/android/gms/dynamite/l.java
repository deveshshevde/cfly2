package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class l implements DynamiteModule.a {
    l() {
    }

    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.C0123a aVar) throws DynamiteModule.LoadingException {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        int a2 = aVar.a(context, str);
        bVar.f18026a = a2;
        int i2 = 0;
        int a3 = a2 != 0 ? aVar.a(context, str, false) : aVar.a(context, str, true);
        bVar.f18027b = a3;
        int i3 = bVar.f18026a;
        if (i3 != 0) {
            i2 = i3;
        } else if (a3 == 0) {
            bVar.f18028c = 0;
            return bVar;
        }
        if (a3 >= i2) {
            bVar.f18028c = 1;
        } else {
            bVar.f18028c = -1;
        }
        return bVar;
    }
}
