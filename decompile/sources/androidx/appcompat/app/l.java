package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.d;
import java.util.Calendar;

class l {

    /* renamed from: a  reason: collision with root package name */
    private static l f699a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f700b;

    /* renamed from: c  reason: collision with root package name */
    private final LocationManager f701c;

    /* renamed from: d  reason: collision with root package name */
    private final a f702d = new a();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f703a;

        /* renamed from: b  reason: collision with root package name */
        long f704b;

        /* renamed from: c  reason: collision with root package name */
        long f705c;

        /* renamed from: d  reason: collision with root package name */
        long f706d;

        /* renamed from: e  reason: collision with root package name */
        long f707e;

        /* renamed from: f  reason: collision with root package name */
        long f708f;

        a() {
        }
    }

    l(Context context, LocationManager locationManager) {
        this.f700b = context;
        this.f701c = locationManager;
    }

    private Location a(String str) {
        try {
            if (this.f701c.isProviderEnabled(str)) {
                return this.f701c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
            return null;
        }
    }

    static l a(Context context) {
        if (f699a == null) {
            Context applicationContext = context.getApplicationContext();
            f699a = new l(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f699a;
    }

    private void a(Location location) {
        long j2;
        a aVar = this.f702d;
        long currentTimeMillis = System.currentTimeMillis();
        k a2 = k.a();
        k kVar = a2;
        kVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j3 = a2.f696a;
        kVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z2 = a2.f698c == 1;
        long j4 = a2.f697b;
        long j5 = j3;
        long j6 = a2.f696a;
        long j7 = j4;
        boolean z3 = z2;
        a2.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j8 = a2.f697b;
        if (j7 == -1 || j6 == -1) {
            j2 = 43200000 + currentTimeMillis;
        } else {
            j2 = (currentTimeMillis > j6 ? 0 + j8 : currentTimeMillis > j7 ? 0 + j6 : 0 + j7) + 60000;
        }
        aVar.f703a = z3;
        aVar.f704b = j5;
        aVar.f705c = j7;
        aVar.f706d = j6;
        aVar.f707e = j8;
        aVar.f708f = j2;
    }

    private Location b() {
        Location location = null;
        Location a2 = d.a(this.f700b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        if (d.a(this.f700b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = a("gps");
        }
        return (location == null || a2 == null) ? location != null ? location : a2 : location.getTime() > a2.getTime() ? location : a2;
    }

    private boolean c() {
        return this.f702d.f708f > System.currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        a aVar = this.f702d;
        if (c()) {
            return aVar.f703a;
        }
        Location b2 = b();
        if (b2 != null) {
            a(b2);
            return aVar.f703a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i2 = Calendar.getInstance().get(11);
        return i2 < 6 || i2 >= 22;
    }
}
