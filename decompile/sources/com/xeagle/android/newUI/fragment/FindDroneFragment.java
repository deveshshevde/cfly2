package com.xeagle.android.newUI.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xeagle.android.fragments.e;
import com.xeagle.android.newUI.beans.a;
import com.xeagle.android.utils.prefs.AutoPanMode;
import java.util.Locale;
import jo.w;
import kh.b;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class FindDroneFragment extends e {

    /* renamed from: a  reason: collision with root package name */
    private a f12733a;

    /* renamed from: b  reason: collision with root package name */
    private double f12734b;

    /* renamed from: c  reason: collision with root package name */
    private double f12735c;

    public void a(ef.a aVar) {
        this.f12733a = new a(aVar);
        Log.i("newUI", "updateHomePosition:---lat-- " + aVar.d());
        this.mMapFragment.a((b) this.f12733a);
        this.mMapFragment.a(this.f12733a.getPosition(), 18.0f);
        SystemClock.sleep(500);
        this.mMapFragment.a(this.f12733a.getPosition(), 18.0f);
        this.mMapFragment.b(aVar);
    }

    /* access modifiers changed from: protected */
    public boolean isMissionDraggable() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public boolean setAutoPanMode(AutoPanMode autoPanMode) {
        return false;
    }

    @l(a = ThreadMode.MAIN)
    public void updateSelfLoc(w wVar) {
        if (this.f12734b != wVar.a().getLatitude() || this.f12735c != wVar.a().getLongitude()) {
            this.f12734b = wVar.a().getLatitude();
            this.f12735c = wVar.a().getLongitude();
            a aVar = this.f12733a;
            if (aVar != null && aVar.getPosition() != null) {
                double a2 = eg.a.c(new ef.a(this.f12734b, this.f12735c), this.f12733a.getPosition()).a();
                this.f12733a.a(String.format(Locale.US, "%.1fm", new Object[]{Double.valueOf(a2)}));
                this.mMapFragment.a((b) this.f12733a);
                this.mMapFragment.b(this.f12733a.getPosition());
            }
        }
    }
}
