package hz;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class a {
    public static void a(Activity activity, String str) {
        activity.startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + str)), 14);
    }
}
