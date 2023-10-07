package com.xeagle.android.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.xeagle.android.dialogs.ag;
import com.xeagle.android.fragments.h;
import com.xeagle.android.fragments.i;
import com.xeagle.android.utils.prefs.AutoPanMode;
import com.xeagle.android.widgets.button.FloatingActionButton;
import en.a;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class FlightActivity extends DrawerNavigationUI implements LocationListener, DroneInterfaces.c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22143a = "FlightActivity";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f22144b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private final SlidingUpPanelLayout.b f22145c = new SlidingUpPanelLayout.b() {
        public void a(View view) {
            FlightActivity.this.f22150o.setSlidingEnabled(false);
            FlightActivity.this.f22150o.setPanelHeight(FlightActivity.this.f22151p.getHeight());
            FlightActivity.this.f22144b.set(false);
            FlightActivity.this.f22150o.setPanelSlideListener((SlidingUpPanelLayout.b) null);
        }

        public void a(View view, float f2) {
        }

        public void b(View view) {
        }

        public void c(View view) {
        }

        public void d(View view) {
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private FragmentManager f22146k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f22147l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f22148m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public i f22149n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public SlidingUpPanelLayout f22150o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public View f22151p;

    /* renamed from: q  reason: collision with root package name */
    private h f22152q;

    /* renamed from: r  reason: collision with root package name */
    private FloatingActionButton f22153r;

    /* renamed from: s  reason: collision with root package name */
    private FloatingActionButton f22154s;

    /* renamed from: t  reason: collision with root package name */
    private FloatingActionButton f22155t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f22156u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f22157v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f22158w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f22159x;

    /* renamed from: y  reason: collision with root package name */
    private CardView f22160y;

    /* renamed from: z  reason: collision with root package name */
    private long f22161z;

    /* renamed from: com.xeagle.android.activities.FlightActivity$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22165a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f22166b;

        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|29|30|31|32|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22166b = r0
                r1 = 1
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r2 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.AUTOPILOT_WARNING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f22166b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.ARMING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = f22166b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r2 = f22166b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r2 = f22166b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.STATE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r4 = 5
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r2 = f22166b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.FOLLOW_START     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r4 = 6
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r2 = f22166b     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.GPS_COUNT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r4 = 7
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r2 = f22166b     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.GPS_FIX     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r4 = 8
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r2 = f22166b     // Catch:{ NoSuchFieldError -> 0x006c }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.GPS     // Catch:{ NoSuchFieldError -> 0x006c }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r4 = 9
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r2 = f22166b     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HOME     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r4 = 10
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r2 = f22166b     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.BATTERY     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r4 = 11
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r2 = f22166b     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.ATTITUDE     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r4 = 12
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                com.xeagle.android.utils.prefs.AutoPanMode[] r2 = com.xeagle.android.utils.prefs.AutoPanMode.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f22165a = r2
                com.xeagle.android.utils.prefs.AutoPanMode r3 = com.xeagle.android.utils.prefs.AutoPanMode.DRONE     // Catch:{ NoSuchFieldError -> 0x00a1 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                int[] r1 = f22165a     // Catch:{ NoSuchFieldError -> 0x00ab }
                com.xeagle.android.utils.prefs.AutoPanMode r2 = com.xeagle.android.utils.prefs.AutoPanMode.USER     // Catch:{ NoSuchFieldError -> 0x00ab }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ab }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x00ab }
            L_0x00ab:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.activities.FlightActivity.AnonymousClass3.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void a(AutoPanMode autoPanMode) {
        FloatingActionButton floatingActionButton;
        this.f22153r.setActivated(false);
        this.f22154s.setActivated(false);
        i iVar = this.f22149n;
        if (iVar != null) {
            iVar.setAutoPanMode(autoPanMode);
        }
        int i2 = AnonymousClass3.f22165a[autoPanMode.ordinal()];
        if (i2 == 1) {
            floatingActionButton = this.f22154s;
        } else if (i2 == 2) {
            floatingActionButton = this.f22153r;
        } else {
            return;
        }
        floatingActionButton.setActivated(true);
    }

    private void d() {
        if (this.f22149n == null) {
            this.f22149n = (i) this.f22146k.d((int) R.id.mapFragment);
            LocationManager locationManager = (LocationManager) getSystemService("location");
            String bestProvider = locationManager.getBestProvider(new Criteria(), true);
            if (!locationManager.isProviderEnabled("gps")) {
                new AlertDialog.Builder(this).setTitle(R.string.gps_warning).setMessage(R.string.gps_message).setCancelable(false).setPositiveButton("Setting", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                        FlightActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                        Toast.makeText(FlightActivity.this, R.string.gps_close, 0).show();
                    }
                }).show();
            } else {
                Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                if (lastKnownLocation != null) {
                    onLocationChanged(lastKnownLocation);
                } else {
                    Toast.makeText(this, R.string.seek_gps, 0).show();
                }
                LocationManager locationManager2 = locationManager;
                locationManager2.requestLocationUpdates("gps", 1000, 0.0f, this);
                locationManager2.requestLocationUpdates("network", 1000, 0.0f, this);
            }
            if (this.f22149n == null) {
                this.f22149n = new i();
                this.f22146k.a().a((int) R.id.mapFragment, (Fragment) this.f22149n).c();
            }
        }
    }

    private void f(a aVar) {
        if (this.f22150o != null) {
            h hVar = this.f22152q;
            if (hVar != null && hVar.a(aVar)) {
                this.f22150o.setSlidingEnabled(true);
            } else if (this.f22144b.get()) {
            } else {
                if (this.f22150o.f()) {
                    this.f22150o.setPanelSlideListener(this.f22145c);
                    this.f22150o.d();
                    this.f22144b.set(true);
                    return;
                }
                this.f22150o.setSlidingEnabled(false);
                this.f22144b.set(false);
            }
        }
    }

    public void OpenRightMenu(View view) {
        super.OpenRightMenu(view);
    }

    /* access modifiers changed from: protected */
    public int a() {
        return R.id.navigation_flight_data;
    }

    public void a(float f2) {
        i iVar = this.f22149n;
        if (iVar != null) {
            iVar.updateMapBearing(f2);
        }
    }

    public void a(a aVar) {
        String str;
        if (this.f22158w != null) {
            if (aVar == null) {
                str = "--";
            } else {
                str = String.format("DistanceToHome\n%s", new Object[]{aVar.q().b().toString()});
            }
            this.f22158w.setText(str);
        }
    }

    public void b() {
        new ag().show(getSupportFragmentManager(), "dialogFragment");
    }

    public void b(a aVar) {
        this.f22156u.setText(String.format("Altitude  %3.1f m", new Object[]{Double.valueOf(aVar.t().a())}));
    }

    public void c(a aVar) {
        if (aVar == null || aVar.o() == null) {
            this.f22157v.setText("--");
            return;
        }
        this.f22157v.setText(String.format(Locale.ENGLISH, "Battery  %2.1f V", new Object[]{Double.valueOf(aVar.o().a())}));
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return true;
    }

    public void d(a aVar) {
        if (aVar == null || aVar.b() == null) {
            this.f22159x.setText(String.format(Locale.ENGLISH, "Satellites %d", new Object[]{0}));
            return;
        }
        this.f22159x.setText(String.format(Locale.ENGLISH, "Satellites %d", new Object[]{Integer.valueOf(aVar.b().d())}));
    }

    public void e(a aVar) {
        LinearLayout linearLayout;
        int i2;
        if (aVar.d().b()) {
            this.f22147l.setText(aVar.d().f());
            linearLayout = this.f22148m;
            i2 = 0;
        } else {
            linearLayout = this.f22148m;
            i2 = 8;
        }
        linearLayout.setVisibility(i2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_flight);
        Settings.System.putInt(getContentResolver(), "screen_brightness_mode", 1);
        getContentResolver().notifyChange(Settings.System.getUriFor("screen_brightness"), (ContentObserver) null);
        this.f22146k = getSupportFragmentManager();
        this.f22150o = (SlidingUpPanelLayout) findViewById(R.id.slidingPanelContainer);
        f(this.f12358g);
        this.f22148m = (LinearLayout) findViewById(R.id.ll_failsfae);
        this.f22147l = (TextView) findViewById(R.id.failsafeTextView);
        d();
        this.f22153r = (FloatingActionButton) findViewById(R.id.my_location_button);
        this.f22154s = (FloatingActionButton) findViewById(R.id.drone_location_button);
        this.f22155t = (FloatingActionButton) findViewById(R.id.telemetry_dialog);
        this.f22156u = (TextView) findViewById(R.id.altitude_flight);
        this.f22157v = (TextView) findViewById(R.id.battery_flight);
        this.f22158w = (TextView) findViewById(R.id.distance_flight);
        this.f22160y = (CardView) findViewById(R.id.flight_card);
        this.f22159x = (TextView) findViewById(R.id.gps_flight);
        this.f22155t.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FlightActivity.this.b();
            }
        });
        this.f22153r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (FlightActivity.this.f22149n != null) {
                    FlightActivity.this.f22149n.goToMyLocation();
                    FlightActivity.this.a(AutoPanMode.DISABLED);
                }
            }
        });
        this.f22153r.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (FlightActivity.this.f22149n == null) {
                    return false;
                }
                FlightActivity.this.f22149n.goToMyLocation();
                FlightActivity.this.a(AutoPanMode.USER);
                return true;
            }
        });
        this.f22154s.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (FlightActivity.this.f22149n != null) {
                    FlightActivity.this.f22149n.goToDroneLocation();
                    FlightActivity.this.a(AutoPanMode.DISABLED);
                }
            }
        });
        this.f22154s.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (FlightActivity.this.f22149n == null) {
                    return false;
                }
                FlightActivity.this.f22149n.goToDroneLocation();
                FlightActivity.this.a(AutoPanMode.DRONE);
                return true;
            }
        });
        h hVar = (h) this.f22146k.d((int) R.id.flightActionsFragment);
        this.f22152q = hVar;
        if (hVar == null) {
            this.f22152q = new h();
            this.f22146k.a().a((int) R.id.flightActionsFragment, (Fragment) this.f22152q).c();
        }
        View findViewById = findViewById(R.id.flightActionsFragment);
        this.f22151p = findViewById;
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (!FlightActivity.this.f22144b.get()) {
                    FlightActivity.this.f22150o.setPanelHeight(FlightActivity.this.f22151p.getHeight());
                }
            }
        });
        if (this.f22146k.d((int) R.id.sliding_drawer_content) == null) {
            this.f22146k.a().a((int) R.id.sliding_drawer_content, (Fragment) new kc.a()).c();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Settings.System.putInt(getContentResolver(), "screen_brightness_mode", 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.screenBrightness = -1.0f;
        getWindow().setAttributes(attributes);
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        int i2;
        CardView cardView;
        super.onDroneEvent(droneEventsType, aVar);
        switch (AnonymousClass3.f22166b[droneEventsType.ordinal()]) {
            case 1:
                e(aVar);
                return;
            case 2:
            case 5:
                f(aVar);
                return;
            case 3:
                f(aVar);
                cardView = this.f22160y;
                i2 = 0;
                break;
            case 4:
                f(aVar);
                cardView = this.f22160y;
                i2 = 8;
                break;
            case 6:
                if (!this.f22144b.get() && this.f22150o.a() && !this.f22150o.f()) {
                    this.f22150o.e();
                    return;
                }
                return;
            case 7:
            case 8:
                if (this.f22159x != null) {
                    d(aVar);
                    return;
                }
                return;
            case 9:
            case 10:
                if (this.f22158w != null) {
                    a(aVar);
                    return;
                }
                return;
            case 11:
                if (this.f22157v != null) {
                    c(aVar);
                    return;
                }
                return;
            case 12:
                if (this.f22156u != null) {
                    b(aVar);
                    return;
                }
                return;
            default:
                return;
        }
        cardView.setVisibility(i2);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (System.currentTimeMillis() - this.f22161z > 2000) {
            Toast.makeText(this, R.string.warning_back, 0).show();
            this.f22161z = System.currentTimeMillis();
            return true;
        }
        System.exit(0);
        return true;
    }

    public void onLocationChanged(Location location) {
        location.getLatitude();
        location.getLongitude();
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStart() {
        super.onStart();
        d();
    }

    public void onStatusChanged(String str, int i2, Bundle bundle) {
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        a(this.f12360i.Q());
    }
}
