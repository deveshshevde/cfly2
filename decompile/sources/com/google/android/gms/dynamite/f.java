package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class f implements DynamiteModule.a {
    f() {
    }

    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.C0123a aVar) throws DynamiteModule.LoadingException {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        int a2 = aVar.a(context, str, true);
        bVar.f18027b = a2;
        if (a2 != 0) {
            bVar.f18028c = 1;
        } else {
            int a3 = aVar.a(context, str);
            bVar.f18026a = a3;
            if (a3 != 0) {
                bVar.f18028c = -1;
            }
        }
        return bVar;
    }
}
