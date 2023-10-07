package org.opencv.android;

import android.util.Log;
import java.util.StringTokenizer;
import org.opencv.core.Core;

class StaticHelper {
    private static boolean a(String str) {
        Log.d("OpenCV/StaticHelper", "Trying to load library " + str);
        try {
            System.loadLibrary(str);
            Log.d("OpenCV/StaticHelper", "Library " + str + " loaded");
            return true;
        } catch (UnsatisfiedLinkError e2) {
            Log.d("OpenCV/StaticHelper", "Cannot load library \"" + str + "\"");
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(boolean z2) {
        String str;
        if (z2) {
            a("cudart");
            a("nppc");
            a("nppi");
            a("npps");
            a("cufft");
            a("cublas");
        }
        Log.d("OpenCV/StaticHelper", "Trying to get library list");
        try {
            System.loadLibrary("opencv_info");
            str = getLibraryList();
        } catch (UnsatisfiedLinkError unused) {
            Log.e("OpenCV/StaticHelper", "OpenCV error: Cannot load info library for OpenCV");
            str = "";
        }
        Log.d("OpenCV/StaticHelper", "Library list: \"" + str + "\"");
        Log.d("OpenCV/StaticHelper", "First attempt to load libs");
        if (b(str)) {
            Log.d("OpenCV/StaticHelper", "First attempt to load libs is OK");
            for (String i2 : Core.a().split(System.getProperty("line.separator"))) {
                Log.i("OpenCV/StaticHelper", i2);
            }
            return true;
        }
        Log.d("OpenCV/StaticHelper", "First attempt to load libs fails");
        return false;
    }

    private static boolean b(String str) {
        Log.d("OpenCV/StaticHelper", "Trying to init OpenCV libs");
        if (str == null || str.length() == 0) {
            return a("opencv_java4");
        }
        Log.d("OpenCV/StaticHelper", "Trying to load libs by dependency list");
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        boolean z2 = true;
        while (stringTokenizer.hasMoreTokens()) {
            z2 &= a(stringTokenizer.nextToken());
        }
        return z2;
    }

    private static native String getLibraryList();
}
