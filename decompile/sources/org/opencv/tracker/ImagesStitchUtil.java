package org.opencv.tracker;

import android.app.Activity;
import android.graphics.Bitmap;
import java.io.File;
import org.opencv.tracker.ImagesStitchUtil;

public class ImagesStitchUtil {

    public interface a {
        void a(int i2);

        void a(String str);
    }

    static {
        System.loadLibrary("Stitcher");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(int i2, a aVar, String str) {
        if (i2 == 0) {
            aVar.a(str);
        } else {
            aVar.a(i2);
        }
    }

    public static void a(Activity activity, String[] strArr, String str, boolean z2, a aVar) {
        for (String file : strArr) {
            if (!new File(file).exists()) {
                activity.runOnUiThread(new Runnable() {
                    public final void run() {
                        ImagesStitchUtil.a.this.a(1);
                    }
                });
                return;
            }
        }
        ka.a.a().b().execute(new Runnable(strArr, str, z2, activity, aVar) {
            public final /* synthetic */ String[] f$0;
            public final /* synthetic */ String f$1;
            public final /* synthetic */ boolean f$2;
            public final /* synthetic */ Activity f$3;
            public final /* synthetic */ ImagesStitchUtil.a f$4;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void run() {
                ImagesStitchUtil.a(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(String[] strArr, String str, boolean z2, Activity activity, a aVar) {
        int i2;
        if (strArr.length == 3) {
            i2 = stitchImages(2, strArr, str, z2);
        } else {
            if (strArr.length != 9) {
                int length = strArr.length;
            }
            i2 = stitchImages(1, strArr, str, z2);
        }
        activity.runOnUiThread(new Runnable(i2, aVar, str) {
            public final /* synthetic */ int f$0;
            public final /* synthetic */ ImagesStitchUtil.a f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                ImagesStitchUtil.a(this.f$0, this.f$1, this.f$2);
            }
        });
    }

    public static native int adjustmentBox(Bitmap bitmap);

    public static native boolean antiShakeByFile(String str, String str2);

    private static native int getBitmap(Bitmap bitmap);

    private static native void getMat(long j2);

    public static native String initTrackerByBitmap(Bitmap bitmap, int i2, int i3, int i4, int i5, String str, String str2, String str3);

    private static native int stitchImages(int i2, String[] strArr, String str, boolean z2);

    public static native int updateTrackerByBitmap(Bitmap bitmap, int[] iArr);
}
