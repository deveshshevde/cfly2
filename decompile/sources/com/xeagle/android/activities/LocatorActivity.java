package com.xeagle.android.activities;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.MAVLink.common.msg_global_position_int;
import com.cfly.uav_pro.R;
import com.xeagle.android.fragments.LocatorListFragment;
import com.xeagle.android.fragments.LocatorMapFragment;
import com.xeagle.android.utils.prefs.AutoPanMode;
import ef.a;
import fg.i;
import java.util.LinkedList;
import java.util.List;

public class LocatorActivity extends DrawerNavigationUI implements LocationListener, LocatorListFragment.a {

    /* renamed from: a  reason: collision with root package name */
    private static final List<msg_global_position_int> f22188a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    private FragmentManager f22189b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public LocatorMapFragment f22190c;

    /* renamed from: k  reason: collision with root package name */
    private LocatorListFragment f22191k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayout f22192l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f22193m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f22194n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f22195o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f22196p;

    /* renamed from: q  reason: collision with root package name */
    private msg_global_position_int f22197q;

    /* renamed from: r  reason: collision with root package name */
    private a f22198r;

    /* renamed from: s  reason: collision with root package name */
    private float f22199s = Float.MAX_VALUE;

    /* renamed from: t  reason: collision with root package name */
    private double f22200t = Double.MAX_VALUE;

    private static a c(msg_global_position_int msg_global_position_int) {
        double d2 = (double) msg_global_position_int.f6645e;
        Double.isNaN(d2);
        double d3 = (double) msg_global_position_int.f6646f;
        Double.isNaN(d3);
        return new a(d2 / 1.0E7d, d3 / 1.0E7d);
    }

    private void d() {
        this.f22190c.setMapPadding(0, 0, 0, f22188a.size() > 0 ? this.f22191k.getView().getHeight() : 0);
    }

    private void e() {
        String str = "";
        if (this.f22197q != null) {
            this.f22192l.setVisibility(0);
            a c2 = c(this.f22197q);
            a aVar = this.f22198r;
            if (aVar == null || aVar.e()) {
                this.f22195o.setText(R.string.status_waiting_for_gps, TextView.BufferType.NORMAL);
            } else {
                String format = String.format("Distance: %.01fm", new Object[]{Double.valueOf(eg.a.c(this.f22198r, c2).a())});
                float f2 = this.f22199s;
                if (f2 != Float.MAX_VALUE) {
                    format = format + String.format(" @ %.0f°", new Object[]{Float.valueOf(f2)});
                }
                this.f22195o.setText(format);
                double d2 = this.f22200t;
                if (d2 != Double.MAX_VALUE) {
                    str = String.format("Heading: %.0f°", new Object[]{Double.valueOf(d2)});
                }
                this.f22193m.setText(String.format("Latitude: %f°", new Object[]{Double.valueOf(c2.d())}));
                this.f22194n.setText(String.format("Longitude: %f°", new Object[]{Double.valueOf(c2.c())}));
                return;
            }
            this.f22196p.setText(str);
            this.f22193m.setText(String.format("Latitude: %f°", new Object[]{Double.valueOf(c2.d())}));
            this.f22194n.setText(String.format("Longitude: %f°", new Object[]{Double.valueOf(c2.c())}));
            return;
        }
        this.f22192l.setVisibility(4);
        this.f22193m.setText(str);
        this.f22194n.setText(str);
        this.f22195o.setText(str);
        this.f22196p.setText(str);
    }

    /* access modifiers changed from: protected */
    public int a() {
        return 0;
    }

    public void a(msg_global_position_int msg_global_position_int) {
        b(msg_global_position_int);
        this.f22190c.a();
        e();
    }

    public List<msg_global_position_int> b() {
        return f22188a;
    }

    public void b(msg_global_position_int msg_global_position_int) {
        this.f22197q = msg_global_position_int;
        this.f22190c.a(msg_global_position_int != null ? c(msg_global_position_int) : new a(i.f27244a, i.f27244a));
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.f22190c.saveCameraPosition();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_locator);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.f22189b = supportFragmentManager;
        this.f22190c = (LocatorMapFragment) supportFragmentManager.d((int) R.id.mapFragment);
        this.f22191k = (LocatorListFragment) this.f22189b.d((int) R.id.locatorListFragment);
        this.f22192l = (LinearLayout) findViewById(R.id.statusView);
        this.f22193m = (TextView) findViewById(R.id.latView);
        this.f22194n = (TextView) findViewById(R.id.lonView);
        this.f22195o = (TextView) findViewById(R.id.distanceView);
        this.f22196p = (TextView) findViewById(R.id.azimuthView);
        ((ImageButton) findViewById(R.id.map_orientation_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (LocatorActivity.this.f22190c != null) {
                    LocatorActivity.this.f22190c.updateMapBearing(0.0f);
                }
            }
        });
        ImageButton imageButton = (ImageButton) findViewById(R.id.zoom_to_fit_button);
        imageButton.setVisibility(0);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (LocatorActivity.this.f22190c != null) {
                    LocatorActivity.this.f22190c.a();
                }
            }
        });
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.my_location_button);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LocatorActivity.this.f22190c.goToMyLocation();
            }
        });
        imageButton2.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                LocatorActivity.this.f22190c.setAutoPanMode(AutoPanMode.USER);
                return true;
            }
        });
        ((ImageButton) findViewById(R.id.drone_location_button)).setVisibility(8);
        if (bundle == null) {
            f22188a.clear();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_locator, menu);
        return true;
    }

    public void onLocationChanged(Location location) {
        float f2;
        this.f22198r = new a(location.getLatitude(), location.getLongitude());
        this.f22200t = (double) location.getBearing();
        msg_global_position_int msg_global_position_int = this.f22197q;
        if (msg_global_position_int != null) {
            a c2 = c(msg_global_position_int);
            Location location2 = new Location(location);
            location2.setLatitude(c2.d());
            location2.setLongitude(c2.c());
            float round = (float) Math.round(location.bearingTo(location2));
            this.f22199s = round;
            f2 = (round + 360.0f) % 360.0f;
        } else {
            f2 = Float.MAX_VALUE;
        }
        this.f22199s = f2;
        e();
    }

    public void onPause() {
        super.onPause();
        this.f22190c.a((LocationListener) null);
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i2 = bundle.getInt("STATE_LAST_SELECTED_POSITION", -1);
        if (i2 != -1) {
            List<msg_global_position_int> list = f22188a;
            if (i2 < list.size()) {
                b(list.get(i2));
            }
        }
    }

    public void onResume() {
        super.onResume();
        this.f22190c.a((LocationListener) this);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("STATE_LAST_SELECTED_POSITION", f22188a.indexOf(this.f22197q));
    }

    public void onStatusChanged(String str, int i2, Bundle bundle) {
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        d();
    }
}
