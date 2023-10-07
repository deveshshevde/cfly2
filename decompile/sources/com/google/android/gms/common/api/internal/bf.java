package com.google.android.gms.common.api.internal;

final class bf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg f17495a;

    bf(bg bgVar) {
        this.f17495a = bgVar;
    }

    public final void run() {
        bh bhVar = this.f17495a.f17496a;
        bhVar.f11799c.disconnect(String.valueOf(bhVar.f11799c.getClass().getName()).concat(" disconnecting because it was signed out."));
    }
}
