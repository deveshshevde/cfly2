package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class i implements DynamiteModule.a {
    i() {
    }

    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.C0123a aVar) throws DynamiteModule.LoadingException {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        bVar.f18026a = aVar.a(context, str);
        int a2 = aVar.a(context, str, true);
        bVar.f18027b = a2;
        int i2 = bVar.f18026a;
        if (i2 == 0) {
            if (a2 == 0) {
                bVar.f18028c = 0;
                return bVar;
            }
            i2 = 0;
        }
        if (i2 >= a2) {
            bVar.f18028c = -1;
        } else {
            bVar.f18028c = 1;
        }
        return bVar;
    }
}
