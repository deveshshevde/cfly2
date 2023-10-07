package com.afollestad.materialdialogs.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.m;
import androidx.lifecycle.u;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.a;

public final class DialogLifecycleObserver implements m {

    /* renamed from: a  reason: collision with root package name */
    private final a<l> f7626a;

    public DialogLifecycleObserver(a<l> aVar) {
        h.c(aVar, "dismiss");
        this.f7626a = aVar;
    }

    @u(a = Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.f7626a.e_();
    }

    @u(a = Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        this.f7626a.e_();
    }
}
