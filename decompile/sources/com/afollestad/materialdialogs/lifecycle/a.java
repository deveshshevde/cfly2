package com.afollestad.materialdialogs.lifecycle;

import android.content.Context;
import androidx.lifecycle.n;
import com.afollestad.materialdialogs.b;
import kotlin.jvm.internal.h;

public final class a {
    public static final b a(b bVar, n nVar) {
        h.c(bVar, "$this$lifecycleOwner");
        DialogLifecycleObserver dialogLifecycleObserver = new DialogLifecycleObserver(new LifecycleExtKt$lifecycleOwner$observer$1(bVar));
        if (nVar == null) {
            Context d2 = bVar.d();
            if (!(d2 instanceof n)) {
                d2 = null;
            }
            nVar = (n) d2;
            if (nVar == null) {
                throw new IllegalStateException(bVar.d() + " is not a LifecycleOwner.");
            }
        }
        nVar.getLifecycle().a(dialogLifecycleObserver);
        return bVar;
    }
}
