package com.xeagle.android.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.xeagle.android.maps.providers.DPMapProvider;
import java.util.Locale;
import ju.a;
import ju.b;

public class Utils {

    public enum ConnectionType {
        UDP(2) {
            /* renamed from: b */
            public b a(Context context) {
                return new b(context);
            }
        };
        

        /* renamed from: b  reason: collision with root package name */
        private final int f24354b;

        private ConnectionType(int i2) {
            this.f24354b = i2;
        }

        public int a() {
            return this.f24354b;
        }

        public abstract a a(Context context);
    }

    public static DPMapProvider a(Context context) {
        String V = new com.xeagle.android.utils.prefs.a(context).V();
        return V == null ? DPMapProvider.f23809d : DPMapProvider.a(V);
    }

    public static void b(Context context) {
        com.xeagle.android.utils.prefs.a aVar = new com.xeagle.android.utils.prefs.a(context);
        Configuration configuration = new Configuration();
        Resources resources = context.getResources();
        configuration.locale = aVar.T() ? Locale.ENGLISH : Locale.getDefault();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
