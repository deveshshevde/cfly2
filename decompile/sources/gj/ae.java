package gj;

import android.os.Bundle;
import android.os.Parcelable;

public final class ae {
    private ae() {
    }

    private static <T extends Parcelable> T a(Bundle bundle, String str) {
        Class<ae> cls = ae.class;
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(cls.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(cls.getClassLoader());
        return bundle2.getParcelable(str);
    }

    public static void a(Bundle bundle, Bundle bundle2) {
        if (bundle != null && bundle2 != null) {
            Parcelable a2 = a(bundle, "MapOptions");
            if (a2 != null) {
                a(bundle2, "MapOptions", a2);
            }
            Parcelable a3 = a(bundle, "StreetViewPanoramaOptions");
            if (a3 != null) {
                a(bundle2, "StreetViewPanoramaOptions", a3);
            }
            Parcelable a4 = a(bundle, "camera");
            if (a4 != null) {
                a(bundle2, "camera", a4);
            }
            if (bundle.containsKey("position")) {
                bundle2.putString("position", bundle.getString("position"));
            }
            if (bundle.containsKey("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT")) {
                bundle2.putBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", bundle.getBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", false));
            }
        }
    }

    public static void a(Bundle bundle, String str, Parcelable parcelable) {
        Class<ae> cls = ae.class;
        bundle.setClassLoader(cls.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(cls.getClassLoader());
        bundle2.putParcelable(str, parcelable);
        bundle.putBundle("map_state", bundle2);
    }
}
