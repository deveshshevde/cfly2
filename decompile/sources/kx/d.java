package kx;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class d {
    public static File a(File file, String str, String str2) {
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA);
        return new File(file, str + simpleDateFormat.format(new Date(System.currentTimeMillis())) + str2);
    }

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
        return absolutePath + "/" + "C-FLY2";
    }

    public static String a(Context context, String str) {
        File file = new File(a(context) + "/Trim/" + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/Trim/" + str;
    }

    public static String b(Context context) {
        return a(context) + "/Parameters/";
    }

    public static String c(Context context) {
        return a(context) + "/Waypoints/";
    }

    public static String d(Context context) {
        File file = new File(a(context) + "/Listener/");
        if (!file.exists()) {
            Log.i("Listener", "getListenerPath:--- " + file.mkdirs());
        }
        return a(context) + "/Listener/";
    }

    public static String e(Context context) {
        File file = new File(a(context) + "/Database/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/Database/";
    }

    public static String f(Context context) {
        return a(context) + "/Trim/";
    }

    public static String g(Context context) {
        File file = new File(a(context) + "/temp/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/temp/bitmap.jpg";
    }

    public static String h(Context context) {
        File file = new File(a(context) + "/Splash/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/Splash/";
    }

    public static String i(Context context) {
        File file = new File(a(context) + "/Firmware/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/Firmware/";
    }

    public static String j(Context context) {
        File file = new File(a(context) + "/Apk/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/Apk/";
    }

    public static String k(Context context) {
        File file = new File(a(context) + "/Avatar/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/Avatar/";
    }

    public static String l(Context context) {
        File file = new File(a(context) + "/Movie/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/Movie/";
    }

    public static String m(Context context) {
        File file = new File(a(context) + "/pdf/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/Pdf/";
    }

    public static File n(Context context) {
        File file = new File(a(context) + "/Logs/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File o(Context context) {
        File file = new File(n(context) + "/Sent/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String p(Context context) {
        File file = new File(a(context) + "/Thumb/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/Thumb/";
    }

    public static String q(Context context) {
        File file = new File(a(context) + "/Videos/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/Videos/";
    }

    public static String r(Context context) {
        File file = new File(a(context) + "/Videos/tmp/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/Videos/tmp/";
    }

    public static String s(Context context) {
        File file = new File(a(context) + "/Photos/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/Photos/";
    }

    public static String t(Context context) {
        File file = new File(a(context) + "/Cache/Images");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/Cache/Images";
    }

    public static String u(Context context) {
        File file = new File(a(context) + "/ImageSynthesis/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/ImageSynthesis/";
    }

    public static String v(Context context) {
        File file = new File(a(context) + "/Maps/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/Maps/";
    }

    public static String w(Context context) {
        return a(context) + "/CameraInfo/";
    }

    public static String x(Context context) {
        File file = new File(a(context) + "/LogCat/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/LogCat/";
    }

    public static String y(Context context) {
        File file = new File(a(context) + "/Yolo/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return a(context) + "/Yolo/";
    }
}
