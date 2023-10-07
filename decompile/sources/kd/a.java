package kd;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.g;
import com.google.android.gms.location.h;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.maps.providers.DPMapProvider;
import com.xeagle.android.utils.j;
import ed.a;
import fg.i;
import java.util.List;
import java.util.Locale;
import jo.w;

public class a implements a.C0091a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13834a = "a";

    /* renamed from: b  reason: collision with root package name */
    private j f13835b;

    /* renamed from: c  reason: collision with root package name */
    private j.a f13836c;

    /* renamed from: d  reason: collision with root package name */
    private j.a f13837d;

    /* renamed from: e  reason: collision with root package name */
    private a.b f13838e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Location f13839f;

    /* renamed from: g  reason: collision with root package name */
    private float f13840g;

    /* renamed from: h  reason: collision with root package name */
    private long f13841h;

    /* renamed from: i  reason: collision with root package name */
    private String f13842i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public en.a f13843j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Location f13844k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public LocationManager f13845l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Context f13846m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f13847n;

    /* renamed from: o  reason: collision with root package name */
    private Handler f13848o = new Handler();

    /* renamed from: p  reason: collision with root package name */
    private String f13849p;

    /* renamed from: q  reason: collision with root package name */
    private Criteria f13850q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public boolean f13851r = false;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public C0207a f13852s = new C0207a();

    /* renamed from: t  reason: collision with root package name */
    private c f13853t = new c();

    /* renamed from: u  reason: collision with root package name */
    private b f13854u = new b();
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public double[] f13855v = new double[10];
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public double[] f13856w = new double[10];
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public double[] f13857x = new double[10];

    /* renamed from: y  reason: collision with root package name */
    private Runnable f13858y = new Runnable() {
        public void run() {
            if (androidx.core.app.a.b(a.this.f13846m, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.b(a.this.f13846m, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                Location lastKnownLocation = a.this.f13845l.getLastKnownLocation("gps");
                if (!(lastKnownLocation == null || (lastKnownLocation.getLatitude() == i.f27244a && lastKnownLocation.getLongitude() == i.f27244a))) {
                    Location unused = a.this.f13844k = lastKnownLocation;
                    org.greenrobot.eventbus.c.a().d(new w(lastKnownLocation));
                    a.this.f13843j.Q().b(new ef.a(a.this.f13844k.getLatitude(), a.this.f13844k.getLongitude()));
                    a.this.f13843j.Q().e(Double.parseDouble(String.format(Locale.US, "%.1f", new Object[]{Float.valueOf(a.this.f13844k.getAccuracy() / 5.0f)})));
                }
                a aVar = a.this;
                boolean unused2 = aVar.f13851r = aVar.a(lastKnownLocation);
                if (a.this.f13847n) {
                    a.this.b(lastKnownLocation);
                }
                Location unused3 = a.this.f13839f = lastKnownLocation;
                a.this.g();
            }
        }
    };

    /* renamed from: kd.a$a  reason: collision with other inner class name */
    public class C0207a implements g {
        public C0207a() {
        }

        public void a(Location location) {
            Location unused = a.this.f13844k = location;
            a aVar = a.this;
            boolean unused2 = aVar.f13851r = aVar.a(location);
            if (a.this.f13844k != null) {
                org.greenrobot.eventbus.c.a().d(new w(a.this.f13844k));
                a.this.f13843j.Q().b(new ef.a(a.this.f13844k.getLatitude(), a.this.f13844k.getLongitude()));
                a.this.f13843j.Q().e(Double.parseDouble(String.format(Locale.US, "%.1f", new Object[]{Float.valueOf(a.this.f13844k.getAccuracy() / 5.0f)})));
            }
            if (a.this.f13847n) {
                a.this.b(location);
            }
        }
    }

    public class b implements LocationListener {
        public b() {
        }

        public void onLocationChanged(Location location) {
            Location unused = a.this.f13844k = location;
            a.this.f13844k.setLatitude(com.xeagle.android.utils.c.a(location.getLatitude(), a.this.f13855v));
            a.this.f13844k.setLongitude(com.xeagle.android.utils.c.a(location.getLongitude(), a.this.f13856w));
            a.this.f13844k.setAccuracy((float) com.xeagle.android.utils.c.a((double) location.getAccuracy(), a.this.f13857x));
            a aVar = a.this;
            boolean unused2 = aVar.f13851r = aVar.a(location);
            if (a.this.f13844k != null) {
                org.greenrobot.eventbus.c.a().d(new w(a.this.f13844k));
                a.this.f13843j.Q().b(new ef.a(a.this.f13844k.getLatitude(), a.this.f13844k.getLongitude()));
                a.this.f13843j.Q().e(Double.parseDouble(String.format(Locale.US, "%.1f", new Object[]{Float.valueOf(a.this.f13844k.getAccuracy() / 5.0f)})));
            }
            Location unused3 = a.this.f13839f = location;
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }
    }

    public class c implements LocationListener {
        public c() {
        }

        public void onLocationChanged(Location location) {
            Location unused = a.this.f13844k = location;
            a.this.f13844k.setLatitude(com.xeagle.android.utils.c.a(location.getLatitude(), a.this.f13855v));
            a.this.f13844k.setLongitude(com.xeagle.android.utils.c.a(location.getLongitude(), a.this.f13856w));
            a.this.f13844k.setAccuracy((float) com.xeagle.android.utils.c.a((double) location.getAccuracy(), a.this.f13857x));
            a aVar = a.this;
            boolean unused2 = aVar.f13851r = aVar.a(location);
            if (a.this.f13847n) {
                a.this.b(location);
            }
            if (a.this.f13844k != null) {
                org.greenrobot.eventbus.c.a().d(new w(a.this.f13844k));
                a.this.f13843j.Q().b(new ef.a(a.this.f13844k.getLatitude(), a.this.f13844k.getLongitude()));
                a.this.f13843j.Q().e(Double.parseDouble(String.format(Locale.US, "%.1f", new Object[]{Float.valueOf(a.this.f13844k.getAccuracy() / 5.0f)})));
            }
            Location unused3 = a.this.f13839f = location;
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }
    }

    public a(Context context) {
        j.a aVar;
        this.f13846m = context;
        this.f13843j = ((XEagleApp) context).k();
        String b2 = com.xeagle.android.camera.widgets.ablum.b.b("pref_maps_providers_key", DPMapProvider.SYSTEM_LOC.name());
        this.f13842i = b2;
        if (b2.equals(DPMapProvider.GOOGLE_MAP.name())) {
            Log.i("AMap", "....google LOCATION");
            this.f13835b = new j(context, new Handler(), new com.google.android.gms.common.api.a[]{h.f18096a});
            this.f13836c = new j.a() {
                /* access modifiers changed from: protected */
                public void a() {
                    LocationRequest a2 = LocationRequest.a();
                    a2.a(100);
                    a2.a(0);
                    a2.b(0);
                    a2.a(0.0f);
                    h.f18097b.requestLocationUpdates(b(), a2, a.this.f13852s);
                }
            };
            this.f13837d = new j.a() {
                /* access modifiers changed from: protected */
                public void a() {
                    h.f18097b.removeLocationUpdates(b(), (g) a.this.f13852s);
                }
            };
            this.f13835b.a();
            j jVar = this.f13835b;
            if (jVar != null && (aVar = this.f13836c) != null) {
                jVar.a(aVar);
            }
        } else if (!this.f13842i.equals(DPMapProvider.LBS_AMAP.name()) && this.f13842i.equals(DPMapProvider.SYSTEM_LOC.name())) {
            Log.i("AMap", "...SYSTEM loc");
            this.f13845l = (LocationManager) context.getSystemService("location");
            Criteria criteria = new Criteria();
            this.f13850q = criteria;
            criteria.setBearingRequired(true);
            this.f13850q.setAltitudeRequired(false);
        }
    }

    private boolean a(float f2, float f3) {
        if (f2 >= 15.0f) {
            return false;
        }
        float f4 = this.f13840g + f3;
        this.f13840g = f4;
        long j2 = this.f13841h + 1;
        this.f13841h = j2;
        float f5 = f4 / ((float) j2);
        if (f3 <= 0.0f || ((double) f5) < 1.8d || f3 < f5 * 4.0f) {
            return true;
        }
        String str = f13834a;
        Log.d(str, "High current speed: " + f3);
        return false;
    }

    /* access modifiers changed from: private */
    public boolean a(Location location) {
        Location location2 = this.f13839f;
        if (location2 == null) {
            return false;
        }
        float distanceTo = location.distanceTo(location2);
        long time = (location.getTime() - this.f13839f.getTime()) / 1000;
        float f2 = 0.0f;
        if (distanceTo > 0.0f && time > 0) {
            f2 = distanceTo / ((float) time);
        }
        return a(location.getAccuracy(), f2);
    }

    /* access modifiers changed from: private */
    public void b(Location location) {
        if (this.f13838e != null) {
            ed.a aVar = new ed.a(new ef.a(location.getLatitude(), location.getLongitude()), location.getBearing(), location.getSpeed(), this.f13851r);
            this.f13839f = location;
            this.f13838e.a(aVar);
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        this.f13848o.removeCallbacks(this.f13858y);
        this.f13848o.postDelayed(this.f13858y, 500);
    }

    public void a() {
        this.f13847n = true;
    }

    public void a(a.b bVar) {
        this.f13838e = bVar;
    }

    public void b() {
        this.f13847n = false;
    }

    public Location c() {
        return this.f13844k;
    }

    public boolean d() {
        return this.f13851r;
    }

    public void e() {
        if (androidx.core.app.a.b(this.f13846m, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.b(this.f13846m, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.f13849p = this.f13845l.getBestProvider(this.f13850q, true);
            Log.i("AMap", "startLoc:--best provider--- " + this.f13849p);
            List<String> providers = this.f13845l.getProviders(true);
            if (providers.contains("gps")) {
                this.f13845l.requestLocationUpdates("gps", 500, 0.0f, this.f13853t);
            }
            if (providers.contains("network")) {
                this.f13845l.requestLocationUpdates("network", 1000, 0.0f, this.f13854u);
            }
        }
    }

    public void f() {
        c cVar;
        j.a aVar;
        if (androidx.core.app.a.b(this.f13846m, "android.permission.ACCESS_FINE_LOCATION") != 0 && androidx.core.app.a.b(this.f13846m, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return;
        }
        if (this.f13842i.equals(DPMapProvider.GOOGLE_MAP.name())) {
            j jVar = this.f13835b;
            if (jVar != null && (aVar = this.f13837d) != null) {
                jVar.a(aVar);
            }
        } else if (this.f13842i.equals(DPMapProvider.SYSTEM_LOC.name()) && (cVar = this.f13853t) != null) {
            this.f13845l.removeUpdates(cVar);
        }
    }
}
