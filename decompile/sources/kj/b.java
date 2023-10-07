package kj;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import com.cfly.uav_pro.R;
import com.xeagle.android.maps.providers.DPMapProvider;
import com.xeagle.android.maps.providers.a;

public class b extends a {
    private void b() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String string = getString(R.string.pref_map_type_key);
        final Preference findPreference = findPreference(string);
        if (findPreference != null) {
            findPreference.setSummary(defaultSharedPreferences.getString(string, ""));
            findPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    findPreference.setSummary(obj.toString());
                    return true;
                }
            });
        }
    }

    public DPMapProvider a() {
        return DPMapProvider.GOOGLE_MAP;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences_google_map);
        b();
    }
}
