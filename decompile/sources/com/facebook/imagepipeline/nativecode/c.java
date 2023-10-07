package com.facebook.imagepipeline.nativecode;

import android.os.Build;
import com.facebook.soloader.SoLoader;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f11370a;

    public static synchronized void a() {
        synchronized (c.class) {
            if (!f11370a) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        SoLoader.a("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError unused) {
                    }
                }
                SoLoader.a("native-imagetranscoder");
                f11370a = true;
            }
        }
    }
}
