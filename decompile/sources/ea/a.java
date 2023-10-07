package ea;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.util.Objects;

public class a {
    public static String a(Context context) {
        File file;
        if (Build.VERSION.SDK_INT >= 30) {
            File externalFilesDir = context.getExternalFilesDir("");
            Objects.requireNonNull(externalFilesDir);
            file = externalFilesDir;
        } else {
            file = Environment.getExternalStorageDirectory();
        }
        String absolutePath = file.getAbsolutePath();
        return absolutePath + "/C-FLY2";
    }

    public static String b(Context context) {
        return a(context) + "/Records/";
    }

    public static String c(Context context) {
        File file = new File(a(context) + "/Listener/");
        if (!file.exists()) {
            Log.i("Listener", "getListenerPath:--- " + file.mkdirs());
        }
        return a(context) + "/Listener/";
    }

    public static String d(Context context) {
        File file = new File(a(context) + "/Database/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/Database/";
    }

    public static String e(Context context) {
        return a(context) + "/Sonar/";
    }
}
