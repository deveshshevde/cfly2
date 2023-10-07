package com.xeagle.android.utils.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseBooleanArray;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.e;
import com.flypro.core.firmware.FirmwareType;
import com.xeagle.android.camera.widgets.ablum.b;
import com.xeagle.android.login.beans.AdBeans;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.maps.providers.DPMapProvider;
import com.xeagle.android.utils.Utils;
import com.xeagle.android.utils.file.IO.i;
import java.util.UUID;

public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12773a = Utils.ConnectionType.UDP.name();

    /* renamed from: d  reason: collision with root package name */
    private static final AutoPanMode f12774d = AutoPanMode.USER;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f12775b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12776c = false;

    /* renamed from: e  reason: collision with root package name */
    private Context f12777e;

    /* renamed from: f  reason: collision with root package name */
    private String f12778f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f12779g = null;

    /* renamed from: h  reason: collision with root package name */
    private int f12780h = -1;

    /* renamed from: i  reason: collision with root package name */
    private String f12781i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12782j = false;

    /* renamed from: k  reason: collision with root package name */
    private AdBeans f12783k = null;

    /* renamed from: l  reason: collision with root package name */
    private int f12784l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f12785m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f12786n = true;

    /* renamed from: o  reason: collision with root package name */
    private Boolean f12787o = null;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12788p;

    public a(Context context) {
        this.f12777e = context;
        this.f12775b = b.a(context);
    }

    public String A() {
        return b.b("splash_update_time", "0");
    }

    public void A(String str) {
        b.a("DF806_rc_key", str);
    }

    public void B(String str) {
        b.a("DF805_rc_key", str);
    }

    public boolean B() {
        return b.b("vision_follow_key", false);
    }

    public void C(String str) {
        b.a("DF801_img_key", str);
    }

    public boolean C() {
        return b.b("upload_error_key", false);
    }

    public String D() {
        return b.b("boot_version_key", "null");
    }

    public void D(String str) {
        b.a("DF803_img_key", str);
    }

    public int E() {
        return b.b("camera_mode_key", 1);
    }

    public void E(String str) {
        b.a("DF805_img_key", str);
    }

    public String F() {
        return b.b("wifi_channel_key", this.f12777e.getString(R.string.pref_tts_off));
    }

    public void F(String str) {
        b.a("DF806_img_key", str);
    }

    public int G() {
        return b.b("key_low_battery_action", 2);
    }

    public void G(String str) {
        if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF801)) {
            q(str);
        } else if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF803)) {
            r(str);
        } else if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF805)) {
            s(str);
        } else if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF806)) {
            t(str);
        }
    }

    public String H() {
        return b.b("real_wifi_channel", "14");
    }

    public void H(String str) {
        if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF801)) {
            u(str);
        } else if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF803)) {
            v(str);
        } else if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF805)) {
            w(str);
        } else if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF806)) {
            x(str);
        }
    }

    public void I(String str) {
        if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF801)) {
            y(str);
        } else if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF803)) {
            z(str);
        } else if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF805)) {
            B(str);
        } else if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF806)) {
            A(str);
        }
    }

    public boolean I() {
        if (this.f12779g == null) {
            this.f12779g = Boolean.valueOf(b.b("pref_enable_tts", true));
        }
        return this.f12779g.booleanValue();
    }

    public String J() {
        String trim = b.b("vehicle_id", "").trim();
        if (!trim.isEmpty()) {
            return trim;
        }
        String uuid = UUID.randomUUID().toString();
        b.a("vehicle_id", uuid);
        return uuid;
    }

    public void J(String str) {
        if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF801)) {
            C(str);
        } else if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF803)) {
            D(str);
        } else if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF805)) {
            E(str);
        } else if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF806)) {
            F(str);
        }
    }

    public void K(String str) {
        this.f12781i = str;
        b.a("user_id_key", str);
    }

    public boolean K() {
        return b.b(this.f12777e.getString(R.string.pref_usage_statistics_key), true);
    }

    public String L() {
        return b.b(this.f12777e.getString(R.string.pref_connection_type_key), f12773a);
    }

    public void L(String str) {
        b.a("app_version_key", str);
    }

    public boolean M() {
        return b.b(this.f12777e.getString(R.string.pref_keep_screen_bright_key), true);
    }

    public boolean N() {
        return b.b(this.f12777e.getString(R.string.pref_request_max_volume_key), false);
    }

    public boolean O() {
        return b.b(this.f12777e.getString(R.string.pref_advanced_use_offline_maps_key), false);
    }

    public String P() {
        return b.b(this.f12777e.getString(R.string.pref_map_type_key), "");
    }

    public AutoPanMode Q() {
        try {
            return AutoPanMode.valueOf(b.b("pref_auto_pan_mode", f12774d.name()));
        } catch (IllegalArgumentException unused) {
            return f12774d;
        }
    }

    public boolean R() {
        return b.b("pref_guided_mode_on_long_press", true);
    }

    public boolean S() {
        return b.b(this.f12777e.getString(R.string.pref_ui_gps_hdop_key), false);
    }

    public boolean T() {
        return b.b(this.f12777e.getString(R.string.pref_ui_language_english_key), false);
    }

    public boolean U() {
        return b.b(this.f12777e.getString(R.string.pref_ui_realtime_footprints_key), false);
    }

    public String V() {
        return b.b("pref_maps_providers_key", DPMapProvider.SYSTEM_LOC.name());
    }

    public SparseBooleanArray W() {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(4);
        sparseBooleanArray.put(R.string.pref_tts_periodic_bat_volt_key, b.b(this.f12777e.getString(R.string.pref_tts_periodic_bat_volt_key), true));
        sparseBooleanArray.put(R.string.pref_tts_periodic_alt_key, b.b(this.f12777e.getString(R.string.pref_tts_periodic_alt_key), true));
        sparseBooleanArray.put(R.string.pref_tts_periodic_airspeed_key, b.b(this.f12777e.getString(R.string.pref_tts_periodic_airspeed_key), true));
        sparseBooleanArray.put(R.string.pref_tts_periodic_rssi_key, b.b(this.f12777e.getString(R.string.pref_tts_periodic_rssi_key), true));
        return sparseBooleanArray;
    }

    public int X() {
        return Integer.parseInt(b.b(this.f12777e.getString(R.string.pref_tts_periodic_period_key), "0"));
    }

    public boolean Y() {
        return b.b(this.f12777e.getString(R.string.pref_tts_warning_400ft_ceiling_exceeded_key), true);
    }

    public boolean Z() {
        return b.b(this.f12777e.getString(R.string.pref_tts_warning_lost_signal_key), true);
    }

    public FirmwareType a() {
        return FirmwareType.a(b.b("pref_vehicle_type", FirmwareType.ARDU_COPTER.toString()));
    }

    public dz.b a(FirmwareType firmwareType) {
        return i.a(this.f12777e, firmwareType);
    }

    public void a(float f2) {
        b.a("drone_home_lat", f2);
    }

    public void a(int i2) {
        b.a("low_bat_key", i2);
    }

    public void a(long j2) {
        b.a("refuse_gps_key", j2);
    }

    public void a(AutoPanMode autoPanMode) {
        b.a("pref_auto_pan_mode", autoPanMode.name());
    }

    public void a(String str) {
        b.a(this.f12777e.getString(R.string.pref_dshare_username_key), str.trim());
    }

    public void a(boolean z2) {
        b.a(this.f12777e.getString(R.string.pref_dshare_enabled_key), z2);
    }

    public String aA() {
        return ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF801) ? ap() : ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF803) ? aq() : ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF805) ? ar() : ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF806) ? as() : "0";
    }

    public int aB() {
        if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF801)) {
            return at();
        }
        if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF803)) {
            return au();
        }
        if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF805)) {
            return av();
        }
        if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF806)) {
            return aw();
        }
        return 0;
    }

    public int aC() {
        return b.b("limit_height_key", 120);
    }

    public int aD() {
        if (this.f12780h == -1) {
            this.f12780h = b.b("grid_type_key", 0);
        }
        return this.f12780h;
    }

    public String aE() {
        if (this.f12781i == null) {
            this.f12781i = b.b("user_id_key", "-");
        }
        return this.f12781i;
    }

    public boolean aF() {
        return b.b("is_location_key", true);
    }

    public int aG() {
        return b.b("shoot_type_key", 0);
    }

    public boolean aH() {
        return b.b("is_debug_key", false);
    }

    public boolean aI() {
        return b.b("in_flight_key", false);
    }

    public boolean aJ() {
        return this.f12782j;
    }

    public long aK() {
        return b.b("refuse_gps_key", 0);
    }

    public long aL() {
        return b.b("refuse_permission_key", 0);
    }

    public boolean aM() {
        return b.b("drone_firmware_tips", false);
    }

    public String aN() {
        return b.b("app_version_key", "N/A");
    }

    public boolean aO() {
        return b.b("visual_follow_guide_show", true);
    }

    public void aP() {
        b.a("visual_follow_guide_show", false);
    }

    public boolean aQ() {
        int b2 = b.b("visual_follow_dialog_show", 2);
        this.f12784l = b2;
        return b2 > 0;
    }

    public void aR() {
        int i2 = this.f12784l - 1;
        this.f12784l = i2;
        b.a("visual_follow_dialog_show", i2);
    }

    public boolean aS() {
        return b.b("visual_follow_tip", true);
    }

    public void aT() {
        b.a("visual_follow_tip", false);
    }

    public void aU() {
        b.a("is_first_use_avoidance", false);
    }

    public boolean aV() {
        return b.b("is_first_use_avoidance", true);
    }

    public boolean aW() {
        if (this.f12787o == null) {
            this.f12787o = Boolean.valueOf(b.b("radar_chart_switch", true));
        }
        return this.f12787o.booleanValue();
    }

    public boolean aX() {
        return this.f12786n;
    }

    public boolean aY() {
        return this.f12788p;
    }

    public boolean aa() {
        return b.b(this.f12777e.getString(R.string.pref_tts_warning_low_signal_key), false);
    }

    public boolean ab() {
        return b.b(this.f12777e.getString(R.string.pref_tts_warning_autopilot_warnings_key), true);
    }

    public String ac() {
        return b.b("version_type_key", "0");
    }

    public String ad() {
        return b.b("DF801_drone_key", "0");
    }

    public String ae() {
        return b.b("DF803_drone_key", "0");
    }

    public String af() {
        return b.b("DF805_drone_key", "0");
    }

    public String ag() {
        return b.b("DF806_drone_key", "0");
    }

    public String ah() {
        return b.b("DF801_repeater_key", "0");
    }

    public String ai() {
        return b.b("DF803_repeater_key", "0");
    }

    public String aj() {
        return b.b("DF805_repeater_key", "0");
    }

    public String ak() {
        return b.b("DF806_repeater_key", "0");
    }

    public String al() {
        return b.b("DF801_rc_key", "0");
    }

    public String am() {
        return b.b("DF803_rc_key", "0");
    }

    public String an() {
        return b.b("DF806_rc_key", "0");
    }

    public String ao() {
        return b.b("DF805_rc_key", "0");
    }

    public String ap() {
        return b.b("DF801_img_key", "0");
    }

    public String aq() {
        return b.b("DF803_img_key", "0");
    }

    public String ar() {
        return b.b("DF805_img_key", "0");
    }

    public String as() {
        return b.b("DF806_img_key", "0");
    }

    public int at() {
        return b.b("DF801_rssi_key", 0);
    }

    public int au() {
        return b.b("DF803_rssi_key", 0);
    }

    public int av() {
        return b.b("DF805_rssi_key", 0);
    }

    public int aw() {
        return b.b("DF806_rssi_key", 0);
    }

    public String ax() {
        return ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF801) ? ad() : ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF803) ? ae() : ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF805) ? af() : ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF806) ? ag() : "0";
    }

    public String ay() {
        return ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF801) ? ah() : ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF803) ? ai() : ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF805) ? aj() : ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF806) ? ak() : "0";
    }

    public String az() {
        return ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF801) ? al() : ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF803) ? am() : ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF805) ? ao() : ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF806) ? an() : "0";
    }

    public e.a b() {
        e.a aVar = new e.a();
        aVar.f14210a = Integer.parseInt(b.b("pref_mavlink_stream_rate_ext_stat", "4"));
        aVar.f14211b = Integer.parseInt(b.b("pref_mavlink_stream_rate_extra1", "4"));
        aVar.f14212c = Integer.parseInt(b.b("pref_mavlink_stream_rate_extra2", "2"));
        aVar.f14213d = Integer.parseInt(b.b("pref_mavlink_stream_rate_extra3", "2"));
        aVar.f14214e = Integer.parseInt(b.b("pref_mavlink_stream_rate_position", "2"));
        aVar.f14215f = Integer.parseInt(b.b("pref_mavlink_stream_rate_rc_channels", "2"));
        aVar.f14216g = Integer.parseInt(b.b("pref_mavlink_stream_rate_raw_sensors", "2"));
        aVar.f14217h = Integer.parseInt(b.b("pref_mavlink_stream_rate_gcs", "3"));
        aVar.f14218i = Integer.parseInt(b.b("pref_mavlink_stream_rate_raw_controller", "0"));
        return aVar;
    }

    public void b(float f2) {
        b.a("drone_home_lng", f2);
    }

    public void b(int i2) {
        b.a("fence_alt_key", i2);
    }

    public void b(long j2) {
        b.a("refuse_permission_key", j2);
    }

    public void b(String str) {
        b.a("dshare_email", str.trim());
    }

    public void b(boolean z2) {
        b.a("stick_mode_key", z2);
    }

    public void c(int i2) {
        b.a("fence_radius_key", i2);
    }

    public void c(String str) {
        b.a(this.f12777e.getString(R.string.pref_dshare_password_key), str.trim());
    }

    public void c(boolean z2) {
        b.a("flight_mode_key", z2);
    }

    public boolean c() {
        return false;
    }

    public String d() {
        return b.b(this.f12777e.getString(R.string.pref_dshare_username_key), "").trim();
    }

    public void d(int i2) {
        b.a("secStream_fps_key", i2);
    }

    public void d(String str) {
        this.f12778f = str;
        b.a("drone_type_key", str);
    }

    public void d(boolean z2) {
        b.a("selfie_mode_key", z2);
    }

    public String e() {
        return b.b("dshare_email", "").trim();
    }

    public void e(int i2) {
        b.a("secStream_resolution_height_key", i2);
    }

    public void e(String str) {
        b.a("repeater_version", str);
        this.f12776c = true;
    }

    public void e(boolean z2) {
        b.a("enable_fence_key", z2);
    }

    public String f() {
        return b.b(this.f12777e.getString(R.string.pref_dshare_password_key), "").trim();
    }

    public void f(int i2) {
        b.a("secStream_resolution_width_key", i2);
    }

    public void f(String str) {
        b.a("rc_version_key", str);
    }

    public void f(boolean z2) {
        b.a("key_show_policy", z2);
    }

    public void g(int i2) {
        if (i2 != z()) {
            b.a("speed_mode_key", i2);
        }
    }

    public void g(String str) {
        b.a("camera_firmware_version", str);
    }

    public void g(boolean z2) {
        b.a("key_new_user", z2);
    }

    public boolean g() {
        return b.b(this.f12777e.getString(R.string.pref_dshare_enabled_key), true);
    }

    public void h(int i2) {
        b.a("camera_mode_key", i2);
    }

    public void h(String str) {
        b.a("camera_hardware_version", str);
    }

    public void h(boolean z2) {
        b.a("vision_follow_key", z2);
    }

    public boolean h() {
        return b.b("rc_handle_choose", true);
    }

    public void i(int i2) {
        b.a("key_low_battery_action", i2);
    }

    public void i(String str) {
        b.a("wifi_chan_bw", str);
    }

    public void i(boolean z2) {
        b.a("upload_error_key", z2);
    }

    public boolean i() {
        return b.b("flight_mode_key", true);
    }

    public String j() {
        String str = this.f12778f;
        if (str != null) {
            return str;
        }
        String b2 = b.b("drone_type_key", UserGlobal.DRONE_NAME_DF808_D);
        this.f12778f = b2;
        return b2;
    }

    public void j(int i2) {
        b.a("DF801_rssi_key", i2);
    }

    public void j(String str) {
        b.a("splash_update_time", str);
    }

    public void j(boolean z2) {
        b.a("upload_state_key", z2);
    }

    public void k(int i2) {
        b.a("DF803_rssi_key", i2);
    }

    public void k(String str) {
        b.a("splash_image_url", str);
    }

    public void k(boolean z2) {
        this.f12779g = Boolean.valueOf(z2);
        b.a("pref_enable_tts", z2);
    }

    public boolean k() {
        return b.b("selfie_mode_key", false);
    }

    public int l() {
        return b.b("low_bat_key", 10);
    }

    public void l(int i2) {
        b.a("DF805_rssi_key", i2);
    }

    public void l(String str) {
        b.a("splash_target_url", str);
    }

    public void l(boolean z2) {
        b.a("is_location_key", z2);
    }

    public void m(int i2) {
        b.a("DF806_rssi_key", i2);
    }

    public void m(String str) {
        b.a("boot_version_key", str);
    }

    public void m(boolean z2) {
        b.a("in_flight_key", z2);
    }

    public boolean m() {
        return b.b("enable_fence_key", false);
    }

    public int n() {
        return b.b("fence_alt_key", 30);
    }

    public void n(int i2) {
        if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF801)) {
            j(i2);
        } else if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF803)) {
            k(i2);
        } else if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF805)) {
            l(i2);
        } else if (ac().equalsIgnoreCase(UserGlobal.DRONE_TYPE_DF806)) {
            m(i2);
        }
    }

    public void n(String str) {
        b.a("wifi_channel_key", str);
    }

    public void n(boolean z2) {
        this.f12782j = z2;
    }

    public int o() {
        return b.b("fence_radius_key", 50);
    }

    public void o(int i2) {
        b.a("limit_height_key", i2);
    }

    public void o(String str) {
        b.a("real_wifi_channel", str);
    }

    public void o(boolean z2) {
        b.a("is_home_coord", z2);
    }

    public void p(int i2) {
        if (this.f12780h != i2) {
            this.f12780h = i2;
            b.a("grid_type_key", i2);
        }
    }

    public void p(String str) {
        b.a(this.f12777e.getString(R.string.pref_bluetooth_device_address_key), str);
    }

    public void p(boolean z2) {
        b.a("drone_firmware_tips", z2);
    }

    public boolean p() {
        return this.f12776c;
    }

    public String q() {
        return b.b("repeater_version", "N/A");
    }

    public void q(int i2) {
        b.a("shoot_type_key", i2);
    }

    public void q(String str) {
        b.a("DF801_drone_key", str);
    }

    public void q(boolean z2) {
        b.a("policy_agree_key", z2);
    }

    public String r() {
        return b.b("rc_version_key", "N/A");
    }

    public void r(String str) {
        b.a("DF803_drone_key", str);
    }

    public void r(boolean z2) {
        b.a("radar_chart_switch", z2);
        this.f12787o = Boolean.valueOf(z2);
    }

    public void s(String str) {
        b.a("DF805_drone_key", str);
    }

    public void s(boolean z2) {
        this.f12786n = z2;
    }

    public boolean s() {
        return b.b("key_show_policy", false);
    }

    public String t() {
        return b.b("camera_firmware_version", "1.0.1_2021040701");
    }

    public void t(String str) {
        b.a("DF806_drone_key", str);
    }

    public void t(boolean z2) {
        this.f12788p = z2;
    }

    public String u() {
        return b.b("camera_hardware_version", "D");
    }

    public void u(String str) {
        b.a("DF801_repeater_key", str);
    }

    public int v() {
        return b.b("secStream_fps_key", 30);
    }

    public void v(String str) {
        b.a("DF803_repeater_key", str);
    }

    public int w() {
        return b.b("secStream_resolution_height_key", 1080);
    }

    public void w(String str) {
        b.a("DF805_repeater_key", str);
    }

    public int x() {
        return b.b("secStream_resolution_width_key", 1920);
    }

    public void x(String str) {
        b.a("DF806_repeater_key", str);
    }

    public String y() {
        return b.b("wifi_chan_bw", "0");
    }

    public void y(String str) {
        b.a("DF801_rc_key", str);
    }

    public int z() {
        return b.b("speed_mode_key", 1000);
    }

    public void z(String str) {
        b.a("DF803_rc_key", str);
    }
}
