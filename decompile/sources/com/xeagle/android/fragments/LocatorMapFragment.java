package com.xeagle.android.fragments;

import android.location.LocationListener;
import android.widget.Toast;
import com.xeagle.android.utils.prefs.AutoPanMode;
import ef.a;
import java.util.Collections;
import ke.e;
import kh.b;

public class LocatorMapFragment extends e {

    /* renamed from: a  reason: collision with root package name */
    private final e f23241a = new e();

    public void a() {
        a position = this.f23241a.getPosition();
        if (position == null || position.e()) {
            this.mMapFragment.e();
        } else {
            this.mMapFragment.d(Collections.singletonList(position));
        }
    }

    public void a(LocationListener locationListener) {
        this.mMapFragment.a(locationListener);
    }

    public void a(a aVar) {
        this.f23241a.a(aVar);
        this.mMapFragment.a((b) this.f23241a);
    }

    /* access modifiers changed from: protected */
    public boolean isMissionDraggable() {
        return false;
    }

    public boolean setAutoPanMode(AutoPanMode autoPanMode) {
        if (autoPanMode == AutoPanMode.DISABLED) {
            return true;
        }
        Toast.makeText(getActivity(), "Auto pan is not supported on this map.", 1).show();
        return false;
    }
}
