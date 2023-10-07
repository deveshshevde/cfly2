package com.xeagle.android.activities.helpers;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.cfly.uav_pro.R;
import com.xeagle.android.maps.providers.DPMapProvider;
import com.xeagle.android.maps.providers.a;

public class MapPreferencesActivity extends FragmentActivity {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22364a = "MapPreferencesActivity";

    private void a(Intent intent) {
        if (intent == null) {
            Log.w(f22364a, "No intent was used when starting this class.");
        } else {
            String stringExtra = intent.getStringExtra("EXTRA_MAP_PROVIDER_NAME");
            DPMapProvider a2 = DPMapProvider.a(stringExtra);
            if (a2 == null) {
                String str = f22364a;
                Log.w(str, "Invalid map provider name: " + stringExtra);
            } else {
                FragmentManager fragmentManager = getFragmentManager();
                a aVar = (a) fragmentManager.findFragmentById(R.id.map_preferences_container);
                if (aVar == null || aVar.a() != a2) {
                    a b2 = a2.b();
                    if (b2 == null) {
                        String str2 = f22364a;
                        Log.w(str2, "Undefined map provider preferences for provider " + stringExtra);
                        finish();
                        return;
                    }
                    fragmentManager.beginTransaction().replace(R.id.map_preferences_container, b2).commit();
                    return;
                }
                return;
            }
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_map_preferences);
        a(getIntent());
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }
}
