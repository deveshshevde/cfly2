package com.xeagle.android.login.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.DisplayMetrics;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {
    public static File createFile(File file, String str, String str2) {
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA);
        return new File(file, str + simpleDateFormat.format(new Date(System.currentTimeMillis())) + str2);
    }

    public static boolean existSDCard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static void galleryAddPic(Context context, File file) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }

    public static int getImageItemWidth(Context context) {
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        int i3 = i2 / context.getResources().getDisplayMetrics().densityDpi;
        if (i3 < 4) {
            i3 = 4;
        }
        return (i2 - (((int) (context.getResources().getDisplayMetrics().density * 2.0f)) * (i3 - 1))) / i3;
    }

    public static DisplayMetrics getScreenPix(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }
}
