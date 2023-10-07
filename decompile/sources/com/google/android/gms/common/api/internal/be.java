package com.google.android.gms.common.api.internal;

final class be implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f17493a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ bh f17494b;

    be(bh bhVar, int i2) {
        this.f17494b = bhVar;
        this.f17493a = i2;
    }

    public final void run() {
        this.f17494b.b(this.f17493a);
    }
}
