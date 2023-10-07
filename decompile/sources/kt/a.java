package kt;

import android.content.Context;
import android.util.Log;
import com.cfly.uav_pro.R;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.xeagle.android.XEagleApp;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13913a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static Tracker f13914b;

    private a() {
    }

    public static void a(Context context) {
        com.xeagle.android.utils.prefs.a aVar = new com.xeagle.android.utils.prefs.a(context);
        a(((HitBuilders.AppViewBuilder) ((HitBuilders.AppViewBuilder) ((HitBuilders.AppViewBuilder) new HitBuilders.AppViewBuilder().setNewSession()).setCustomDimension(1, aVar.L())).setCustomDimension(2, String.valueOf(aVar.c() && !aVar.d().isEmpty() && !aVar.f().isEmpty()))).build());
    }

    public static void a(HitBuilders.EventBuilder eventBuilder) {
        if (eventBuilder != null) {
            a(eventBuilder.build());
        }
    }

    public static void a(HitBuilders.SocialBuilder socialBuilder) {
        if (socialBuilder != null) {
            a(socialBuilder.build());
        }
    }

    public static void a(XEagleApp xEagleApp) {
        if (f13914b == null) {
            Context applicationContext = xEagleApp.getApplicationContext();
            GoogleAnalytics instance = GoogleAnalytics.getInstance(applicationContext);
            instance.enableAutoActivityReports(xEagleApp);
            instance.setAppOptOut(!new com.xeagle.android.utils.prefs.a(applicationContext).K());
            f13914b = instance.newTracker((int) R.xml.google_analytics_tracker);
        }
    }

    private static void a(Map<String, String> map) {
        Tracker tracker = f13914b;
        if (tracker == null) {
            Log.w(f13913a, "Google Analytics tracker is not initialized.");
        } else {
            tracker.send(map);
        }
    }
}
