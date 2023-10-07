package kx;

import android.os.Environment;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class f {
    public static String a() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss", Locale.US).format(new Date());
    }

    public static boolean b() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
