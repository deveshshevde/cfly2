package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

public final class ak implements LocationSource, Inner_3dMap_locationListener {

    /* renamed from: a  reason: collision with root package name */
    boolean f7802a = false;

    /* renamed from: b  reason: collision with root package name */
    long f7803b = 2000;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f7804c = null;

    /* renamed from: d  reason: collision with root package name */
    private LocationSource.OnLocationChangedListener f7805d;

    /* renamed from: e  reason: collision with root package name */
    private eb f7806e;

    /* renamed from: f  reason: collision with root package name */
    private Inner_3dMap_locationOption f7807f;

    /* renamed from: g  reason: collision with root package name */
    private Context f7808g;

    public ak(Context context) {
        this.f7808g = context;
    }

    private void a(boolean z2) {
        eb ebVar;
        if (!(this.f7807f == null || (ebVar = this.f7806e) == null)) {
            ebVar.c();
            eb ebVar2 = new eb(this.f7808g);
            this.f7806e = ebVar2;
            ebVar2.a((Inner_3dMap_locationListener) this);
            this.f7807f.setOnceLocation(z2);
            if (!z2) {
                this.f7807f.setInterval(this.f7803b);
            }
            this.f7806e.a(this.f7807f);
            this.f7806e.a();
        }
        this.f7802a = z2;
    }

    public final void a(int i2) {
        if (i2 == 1 || i2 == 0) {
            a(true);
        } else {
            a(false);
        }
    }

    public final void a(long j2) {
        Inner_3dMap_locationOption inner_3dMap_locationOption = this.f7807f;
        if (!(inner_3dMap_locationOption == null || this.f7806e == null || inner_3dMap_locationOption.getInterval() == j2)) {
            this.f7807f.setInterval(j2);
            this.f7806e.a(this.f7807f);
        }
        this.f7803b = j2;
    }

    public final void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        this.f7805d = onLocationChangedListener;
        if (this.f7806e == null) {
            this.f7806e = new eb(this.f7808g);
            this.f7807f = new Inner_3dMap_locationOption();
            this.f7806e.a((Inner_3dMap_locationListener) this);
            this.f7807f.setInterval(this.f7803b);
            this.f7807f.setOnceLocation(this.f7802a);
            this.f7807f.setLocationMode(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy);
            this.f7806e.a(this.f7807f);
            this.f7806e.a();
        }
    }

    public final void deactivate() {
        this.f7805d = null;
        eb ebVar = this.f7806e;
        if (ebVar != null) {
            ebVar.b();
            this.f7806e.c();
        }
        this.f7806e = null;
    }

    public final void onLocationChanged(Inner_3dMap_location inner_3dMap_location) {
        try {
            if (this.f7805d != null && inner_3dMap_location != null) {
                Bundle extras = inner_3dMap_location.getExtras();
                this.f7804c = extras;
                if (extras == null) {
                    this.f7804c = new Bundle();
                }
                this.f7804c.putInt(MyLocationStyle.ERROR_CODE, inner_3dMap_location.getErrorCode());
                this.f7804c.putString(MyLocationStyle.ERROR_INFO, inner_3dMap_location.getErrorInfo());
                this.f7804c.putInt(MyLocationStyle.LOCATION_TYPE, inner_3dMap_location.getLocationType());
                this.f7804c.putFloat("Accuracy", inner_3dMap_location.getAccuracy());
                this.f7804c.putString("AdCode", inner_3dMap_location.getAdCode());
                this.f7804c.putString("Address", inner_3dMap_location.getAddress());
                this.f7804c.putString("AoiName", inner_3dMap_location.getAoiName());
                this.f7804c.putString("City", inner_3dMap_location.getCity());
                this.f7804c.putString("CityCode", inner_3dMap_location.getCityCode());
                this.f7804c.putString("Country", inner_3dMap_location.getCountry());
                this.f7804c.putString("District", inner_3dMap_location.getDistrict());
                this.f7804c.putString("Street", inner_3dMap_location.getStreet());
                this.f7804c.putString("StreetNum", inner_3dMap_location.getStreetNum());
                this.f7804c.putString("PoiName", inner_3dMap_location.getPoiName());
                this.f7804c.putString("Province", inner_3dMap_location.getProvince());
                this.f7804c.putFloat("Speed", inner_3dMap_location.getSpeed());
                this.f7804c.putString("Floor", inner_3dMap_location.getFloor());
                this.f7804c.putFloat("Bearing", inner_3dMap_location.getBearing());
                this.f7804c.putString("BuildingId", inner_3dMap_location.getBuildingId());
                this.f7804c.putDouble("Altitude", inner_3dMap_location.getAltitude());
                inner_3dMap_location.setExtras(this.f7804c);
                this.f7805d.onLocationChanged(inner_3dMap_location);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
