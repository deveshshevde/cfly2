package kf;

import android.os.Build;
import android.util.Log;
import java.io.File;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f30002a = "192.168.1.10";

    /* renamed from: b  reason: collision with root package name */
    public static final a f30003b = new a("192.168.1.10");

    /* renamed from: c  reason: collision with root package name */
    public static File f30004c = null;

    static {
        a();
    }

    public static void a() {
        String str;
        int i2 = Build.VERSION.SDK_INT;
        Log.v("G", "Build.MODEL:" + Build.MODEL);
        try {
            Log.v("G", "load libffmpeg.so");
            System.loadLibrary("ffmpeg");
            if (i2 >= 14 && i2 != 18 && !Build.MODEL.contains("SM-G90")) {
                if (!Build.MODEL.equals("Galaxy Nexus")) {
                    if (Build.MODEL.contains("Hi3798")) {
                        str = "hi_camplayer_mediacodec";
                    } else if (i2 >= 21) {
                        Log.v("G", "load libhi_camplayer_lollipop.so");
                        str = "hi_camplayer_lollipop";
                    } else if (i2 >= 19) {
                        Log.v("G", "load libhi_camplayer_kitkat.so");
                        str = "hi_camplayer_kitkat";
                    } else if (i2 >= 14) {
                        Log.v("G", "load libhi_dvplayer_ics.so");
                        str = "hi_camplayer_ics";
                    } else {
                        return;
                    }
                    System.loadLibrary(str);
                }
            }
            Log.v("G", "load libhi_camplayer_ffmpeg.so");
            str = "hi_camplayer_ffmpeg";
            System.loadLibrary(str);
        } catch (UnsatisfiedLinkError e2) {
            Log.e("loadLibrarys()", e2.getMessage());
        }
    }
}
