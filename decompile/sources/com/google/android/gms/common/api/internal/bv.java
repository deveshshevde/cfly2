package com.google.android.gms.common.api.internal;

import android.os.IBinder;

public final /* synthetic */ class bv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f17519a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IBinder f17520b;

    public /* synthetic */ bv(l lVar, IBinder iBinder) {
        this.f17519a = lVar;
        this.f17520b = iBinder;
    }

    public final void run() {
        this.f17519a.a(this.f17520b);
    }
}
