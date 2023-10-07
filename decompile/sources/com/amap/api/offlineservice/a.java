package com.amap.api.offlineservice;

import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.offlinemap.OfflineMapActivity;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected OfflineMapActivity f9849a = null;

    public final int a(float f2) {
        OfflineMapActivity offlineMapActivity = this.f9849a;
        return offlineMapActivity != null ? (int) ((f2 * (((float) offlineMapActivity.getResources().getDisplayMetrics().densityDpi) / 160.0f)) + 0.5f) : (int) f2;
    }

    public final void a() {
        this.f9849a.showScr();
    }

    public abstract void a(View view);

    public final void a(OfflineMapActivity offlineMapActivity) {
        this.f9849a = offlineMapActivity;
    }

    public abstract void b();

    public boolean c() {
        return true;
    }

    public abstract RelativeLayout d();

    public abstract void e();
}
