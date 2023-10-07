package com.xeagle.android.helpers;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;
import kn.a;

public class RecordMe implements LocationListener {
    private static final float MIN_DISTANCE_M = 0.0f;
    private static final long MIN_TIME_MS = 2000;
    private Context context;
    private LocationManager locationManager;
    private final a missionProxy;
    private boolean recordMeEnabled = false;

    public RecordMe(Context context2, a aVar) {
        this.context = context2;
        this.missionProxy = aVar;
        this.locationManager = (LocationManager) context2.getSystemService("location");
    }

    private void finishRecordMe() {
        Toast.makeText(this.context, "Record Disabled", 0).show();
        this.locationManager.removeUpdates(this);
        this.recordMeEnabled = false;
    }

    private void startRecordMe() {
        Toast.makeText(this.context, "Record Enabled", 0).show();
        this.locationManager.requestLocationUpdates("gps", MIN_TIME_MS, 0.0f, this);
        this.recordMeEnabled = true;
    }

    public boolean isEnabled() {
        return this.recordMeEnabled;
    }

    public void onLocationChanged(Location location) {
        this.missionProxy.a(new ef.a(location.getLatitude(), location.getLongitude()));
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i2, Bundle bundle) {
    }

    public void toogleRecordMeState() {
        if (isEnabled()) {
            finishRecordMe();
        } else {
            startRecordMe();
        }
    }
}
