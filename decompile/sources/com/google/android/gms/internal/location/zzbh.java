package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.j;

public final class zzbh implements j {
    public final e<LocationSettingsResult> checkLocationSettings(d dVar, LocationSettingsRequest locationSettingsRequest) {
        return dVar.a(new zzbk(this, dVar, locationSettingsRequest, (String) null));
    }
}
