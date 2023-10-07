package com.xeagle.android.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.util.Log;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.MapPreferencesActivity;
import com.xeagle.android.maps.providers.DPMapProvider;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import kt.a;
import kx.d;

public class r extends d implements SharedPreferences.OnSharedPreferenceChangeListener, DroneInterfaces.c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23475a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f23476b = "r";

    /* renamed from: c  reason: collision with root package name */
    private static final String f23477c;

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<String> f23478d = new HashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Handler f23479e = new Handler();

    /* renamed from: com.xeagle.android.fragments.r$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23488a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23488a = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23488a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_FIRST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23488a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_RESTORED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23488a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.FIRMWARE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.r.AnonymousClass5.<clinit>():void");
        }
    }

    static {
        String name = r.class.getPackage().getName();
        f23477c = name;
        f23475a = name + ".ACTION_UPDATED_STATUS_PERIOD";
    }

    private void a() {
        this.f23478d.clear();
        this.f23478d.add(getString(R.string.pref_connection_type_key));
        this.f23478d.add(getString(R.string.pref_baud_type_key));
        this.f23478d.add(getString(R.string.pref_server_port_key));
        this.f23478d.add(getString(R.string.pref_server_ip_key));
        this.f23478d.add(getString(R.string.pref_udp_server_port_key));
        this.f23478d.add(getString(R.string.pref_bluetooth_device_address_key));
        this.f23478d.add(getString(R.string.pref_vehicle_type_key));
        this.f23478d.add(getString(R.string.pref_rc_quickmode_left_key));
        this.f23478d.add(getString(R.string.pref_rc_quickmode_right_key));
    }

    private void a(String str) {
        Preference findPreference = findPreference(getString(R.string.pref_mavlink_version_key));
        if (findPreference != null) {
            HitBuilders.EventBuilder category = new HitBuilders.EventBuilder().setCategory("Mavlink connection");
            if (str == null) {
                findPreference.setSummary(getString(R.string.empty_content));
                category.setAction("Mavlink version unset");
            } else {
                findPreference.setSummary('v' + str);
                category.setAction("Mavlink version set").setLabel(str);
            }
            a.a(category);
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference(getString(R.string.pref_tts_periodic_key));
        boolean z2 = false;
        ListPreference listPreference = (ListPreference) preferenceCategory.getPreference(0);
        listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, final Object obj) {
                r.this.f23479e.post(new Runnable() {
                    public void run() {
                        ad.a.a((Context) r.this.getActivity()).a(new Intent(r.f23475a).putExtra("extra_updated_status_period", (String) obj));
                        r.this.b();
                    }
                });
                return true;
            }
        });
        int parseInt = Integer.parseInt(listPreference.getValue());
        if (parseInt != 0) {
            z2 = true;
        }
        if (z2) {
            listPreference.setSummary(getString(R.string.pref_tts_status_every) + " " + parseInt + " " + getString(R.string.pref_tts_seconds));
        } else {
            listPreference.setSummary(R.string.pref_tts_periodic_status_disabled);
        }
        for (int i2 = 1; i2 < preferenceCategory.getPreferenceCount(); i2++) {
            preferenceCategory.getPreference(i2).setEnabled(z2);
        }
    }

    private void b(String str) {
        Preference findPreference = findPreference(getString(R.string.pref_firmware_version_key));
        if (findPreference != null) {
            HitBuilders.EventBuilder category = new HitBuilders.EventBuilder().setCategory("Mavlink connection");
            if (str == null) {
                findPreference.setSummary(getString(R.string.empty_content));
                category.setAction("Firmware version unset");
            } else {
                findPreference.setSummary(str);
                category.setAction("Firmware version set").setLabel(str);
            }
            a.a(category);
        }
    }

    /* access modifiers changed from: private */
    public boolean c(final String str) {
        if (DPMapProvider.a(str) == null) {
            return false;
        }
        Preference findPreference = findPreference(getText(R.string.pref_map_provider_settings_key));
        if (findPreference == null) {
            return true;
        }
        findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                r.this.startActivity(new Intent(r.this.getActivity(), MapPreferencesActivity.class).putExtra("EXTRA_MAP_PROVIDER_NAME", str));
                return true;
            }
        });
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences);
        a();
        final Context applicationContext = getActivity().getApplicationContext();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        b();
        ListPreference listPreference = (ListPreference) findPreference(getString(R.string.pref_maps_providers_key));
        if (listPreference != null) {
            DPMapProvider[] dPMapProviderArr = {DPMapProvider.GOOGLE_MAP};
            CharSequence[] charSequenceArr = new CharSequence[1];
            CharSequence[] charSequenceArr2 = new CharSequence[1];
            for (int i2 = 0; i2 < 1; i2++) {
                String name = dPMapProviderArr[i2].name();
                charSequenceArr2[i2] = name;
                charSequenceArr[i2] = name.toLowerCase(Locale.ENGLISH).replace('_', ' ');
            }
            String name2 = DPMapProvider.f23809d.name();
            listPreference.setEntries(charSequenceArr);
            listPreference.setEntryValues(charSequenceArr2);
            listPreference.setValue(name2);
            listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    return r.this.c(obj.toString());
                }
            });
            c(name2);
        }
        Iterator<String> it2 = this.f23478d.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            Preference findPreference = findPreference(next);
            if (findPreference != null) {
                findPreference.setSummary(defaultSharedPreferences.getString(next, ""));
            }
        }
        String string = getString(R.string.pref_max_flight_path_size_key);
        Preference findPreference2 = findPreference(string);
        if (findPreference2 != null) {
            findPreference2.setSummary(defaultSharedPreferences.getString(string, "") + " " + getString(R.string.set_to_zero_to_disable));
        }
        String string2 = getString(R.string.pref_rc_mode_key);
        Preference findPreference3 = findPreference(string2);
        if (findPreference3 != null) {
            findPreference3.setSummary(getString(defaultSharedPreferences.getString(string2, "MODE2").equalsIgnoreCase("MODE1") ? R.string.mode1_throttle_on_right_stick : R.string.mode2_throttle_on_left_stick));
        }
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference(getString(R.string.pref_usage_statistics_key));
        if (checkBoxPreference != null) {
            checkBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    GoogleAnalytics.getInstance(applicationContext).setAppOptOut(!((Boolean) obj).booleanValue());
                    return true;
                }
            });
        }
        Preference findPreference4 = findPreference(getString(R.string.pref_storage_key));
        if (findPreference4 != null) {
            findPreference4.setSummary(d.a(getActivity().getApplicationContext()));
        }
        try {
            Preference findPreference5 = findPreference("pref_version");
            if (findPreference5 != null) {
                findPreference5.setSummary(applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(f23476b, "Unable to retrieve version name.", e2);
        }
        a((String) null);
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        String str;
        int i2 = AnonymousClass5.f23488a[droneEventsType.ordinal()];
        if (i2 == 1) {
            str = null;
            a((String) null);
        } else if (i2 == 2 || i2 == 3) {
            a(String.valueOf(aVar.c()));
            return;
        } else if (i2 == 4) {
            str = aVar.y();
        } else {
            return;
        }
        b(str);
    }

    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Preference findPreference = findPreference(str);
        if (findPreference != null) {
            if (this.f23478d.contains(str)) {
                findPreference.setSummary(sharedPreferences.getString(str, ""));
            }
            if (str.equals(getString(R.string.pref_max_flight_path_size_key))) {
                findPreference.setSummary(sharedPreferences.getString(str, "") + " " + getString(R.string.set_to_zero_to_disable));
            }
            XEagleApp xEagleApp = (XEagleApp) getActivity().getApplication();
            if (str.equals(getString(R.string.pref_vehicle_type_key))) {
                xEagleApp.k().a(DroneInterfaces.DroneEventsType.TYPE);
            }
            if (str.equals(getString(R.string.pref_rc_mode_key))) {
                findPreference.setSummary(sharedPreferences.getString(str, "MODE2").equalsIgnoreCase("MODE1") ? R.string.mode1_throttle_on_right_stick : R.string.mode2_throttle_on_left_stick);
            }
        }
    }

    public void onStart() {
        super.onStart();
        en.a k2 = ((XEagleApp) getActivity().getApplication()).k();
        int c2 = k2.c();
        a(c2 != -1 ? String.valueOf(c2) : null);
        if (k2.y() != null) {
            b(k2.y());
        }
        k2.a((DroneInterfaces.c) this);
    }

    public void onStop() {
        super.onStop();
        ((XEagleApp) getActivity().getApplication()).k().b((DroneInterfaces.c) this);
    }
}
