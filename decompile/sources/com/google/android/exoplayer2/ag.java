package com.google.android.exoplayer2;

import android.content.Context;
import android.os.PowerManager;

final class ag {

    /* renamed from: a  reason: collision with root package name */
    private final PowerManager f15186a;

    /* renamed from: b  reason: collision with root package name */
    private PowerManager.WakeLock f15187b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15188c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15189d;

    public ag(Context context) {
        this.f15186a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    private void a() {
        PowerManager.WakeLock wakeLock = this.f15187b;
        if (wakeLock != null) {
            if (!this.f15188c || !this.f15189d) {
                wakeLock.release();
            } else {
                wakeLock.acquire();
            }
        }
    }

    public void a(boolean z2) {
        this.f15189d = z2;
        a();
    }
}
