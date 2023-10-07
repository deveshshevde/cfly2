package com.xeagle.android.activities.helpers;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.app.f;
import com.cfly.uav_pro.R;
import com.flypro.core.MAVLink.g;
import com.flypro.core.MAVLink.m;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.e;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.dialogs.al;
import com.xeagle.android.dialogs.am;
import com.xeagle.android.newUI.activity.BaseActivity;
import com.xeagle.android.utils.Utils;
import dy.ar;
import dy.k;
import ec.a;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public abstract class SuperUI extends BaseActivity implements DroneInterfaces.c {

    /* renamed from: d  reason: collision with root package name */
    public static final String f12352d = (SuperUI.class.getName() + ".ACTION_TOGGLE_DRONE_CONNECTION");

    /* renamed from: j  reason: collision with root package name */
    static final /* synthetic */ boolean f12353j = true;

    /* renamed from: a  reason: collision with root package name */
    private a f12354a = new a(this);

    /* renamed from: b  reason: collision with root package name */
    private boolean f12355b;

    /* renamed from: e  reason: collision with root package name */
    public a f12356e;

    /* renamed from: f  reason: collision with root package name */
    public XEagleApp f12357f;

    /* renamed from: g  reason: collision with root package name */
    public en.a f12358g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12359h = true;

    /* renamed from: i  reason: collision with root package name */
    protected com.xeagle.android.utils.prefs.a f12360i;

    /* renamed from: com.xeagle.android.activities.helpers.SuperUI$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22366a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22366a = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22366a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.activities.helpers.SuperUI.AnonymousClass2.<clinit>():void");
        }
    }

    private void a() {
        if (this.f12360i.N()) {
            AudioManager audioManager = (AudioManager) getSystemService("audio");
            if (f12353j || audioManager != null) {
                audioManager.setStreamVolume(3, audioManager.getStreamMaxVolume(3), 0);
                return;
            }
            throw new AssertionError();
        }
    }

    private void a(Intent intent) {
        if (intent != null) {
            if (f12352d.equals(intent.getAction())) {
                i();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return false;
    }

    @l(a = ThreadMode.BACKGROUND)
    public void disConnectedEvent(dy.l lVar) {
        if (lVar.a() == 1 && this.f12355b) {
            this.f12356e.a(false);
            this.f12355b = false;
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void droneConnectEvent(k kVar) {
        if (kVar.a() == 0) {
            if (!this.f12355b) {
                this.f12356e.a(false);
                this.f12355b = true;
            }
            h();
        }
    }

    public boolean f() {
        return this.f12359h;
    }

    public String g() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void h() {
        e.a b2 = this.f12358g.k().b();
        m.a(this.f12358g.j(), b2.f14210a, b2.f14211b, b2.f14212c, b2.f14213d, b2.f14214e, b2.f14215f, b2.f14216g, b2.f14217h, b2.f14218i);
    }

    public void i() {
        this.f12358g.j().a(10);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(6);
        XEagleApp xEagleApp = (XEagleApp) getApplication();
        this.f12357f = xEagleApp;
        en.a k2 = xEagleApp.k();
        this.f12358g = k2;
        this.f12356e = new a(k2, 1);
        com.xeagle.android.utils.prefs.a j2 = this.f12357f.j();
        this.f12360i = j2;
        if (j2.M()) {
            getWindow().addFlags(128);
        }
        setVolumeControlStream(3);
        Utils.b(this);
        a(getIntent());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        int i2;
        getMenuInflater().inflate(R.menu.menu_super_activiy, menu);
        MenuItem findItem = menu.findItem(R.id.menu_connect);
        if (menu.findItem(R.id.menu_info_bar) != null) {
            if (this.f12358g.j().a()) {
                menu.setGroupEnabled(R.id.menu_group_connected, true);
                menu.setGroupVisible(R.id.menu_group_connected, true);
                boolean c2 = c();
                MenuItem findItem2 = menu.findItem(R.id.menu_send_mission);
                findItem2.setEnabled(c2);
                findItem2.setVisible(c2);
                MenuItem findItem3 = menu.findItem(R.id.menu_load_mission);
                findItem3.setEnabled(c2);
                findItem3.setVisible(c2);
                i2 = R.string.menu_disconnect;
            } else {
                menu.setGroupEnabled(R.id.menu_group_connected, false);
                menu.setGroupVisible(R.id.menu_group_connected, false);
                i2 = R.string.menu_connect;
            }
            findItem.setTitle(i2);
            findItem.setShowAsAction(0);
        }
        return super.onCreateOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        int i2 = AnonymousClass2.f22366a[droneEventsType.ordinal()];
        if (i2 == 1) {
            if (!this.f12355b) {
                this.f12356e.a(false);
                this.f12355b = true;
            }
            h();
        } else if (i2 == 2 && this.f12355b) {
            this.f12356e.a(false);
            this.f12355b = false;
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                f.a(this);
                return true;
            case R.id.menu_epm_grab /*2131298102*/:
                com.flypro.core.MAVLink.l.a(this.f12358g, false);
                return true;
            case R.id.menu_epm_release /*2131298103*/:
                com.flypro.core.MAVLink.l.a(this.f12358g, true);
                return true;
            case R.id.menu_load_mission /*2131298109*/:
                this.f12358g.l().a();
                return true;
            case R.id.menu_send_mission /*2131298124*/:
                kn.a o2 = this.f12357f.o();
                if (o2.b().isEmpty() || this.f12358g.r().f()) {
                    o2.a(getApplicationContext());
                } else {
                    am a2 = am.a(getApplicationContext(), "Mission Upload", "Do you want to append a Takeoff and RTL to your mission?", "Ok", "Skip", new al.a() {
                        public void a() {
                        }

                        public void b() {
                        }
                    }, getString(R.string.pref_auto_insert_mission_takeoff_rtl_land_key));
                    if (a2 != null) {
                        a2.show(getSupportFragmentManager(), "Mission Upload check.");
                    }
                }
                return true;
            case R.id.menu_triggerCamera /*2131298132*/:
                com.flypro.core.MAVLink.l.a(this.f12358g);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        a();
        this.f12358g.a((DroneInterfaces.c) this);
        this.f12358g.j().d();
        g.a(this.f12358g);
        c.a().d(new ar(20));
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f12358g.b((DroneInterfaces.c) this);
    }
}
