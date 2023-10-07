package com.shuyu.gsyvideoplayer.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ac;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.constant.CacheConstants;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import com.xeagle.android.login.common.StorageUtil;
import f.d;
import java.io.File;
import java.util.Formatter;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class CommonUtil {
    public static void deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            if (!file.isFile()) {
                for (String str2 : file.list()) {
                    deleteFile(str + File.separator + str2);
                }
            }
            file.delete();
        }
    }

    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getActionBarHeight(Activity activity) {
        TypedValue typedValue = new TypedValue();
        if (activity.getTheme().resolveAttribute(16843499, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static Activity getActivityContext(Context context) {
        Context baseContext;
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ac) {
            baseContext = ((ac) context).getBaseContext();
        } else if (!(context instanceof ContextWrapper)) {
            return null;
        } else {
            baseContext = ((ContextWrapper) context).getBaseContext();
        }
        return scanForActivity(baseContext);
    }

    public static AppCompatActivity getAppCompActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        if (context instanceof d) {
            return getAppCompActivity(((d) context).getBaseContext());
        }
        return null;
    }

    public static boolean getCurrentScreenLand(Activity activity) {
        return activity.getWindowManager().getDefaultDisplay().getRotation() == 1 || activity.getWindowManager().getDefaultDisplay().getRotation() == 3;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String getTextSpeed(long j2) {
        if (j2 >= 0 && j2 < 1024) {
            return j2 + " KB/s";
        } else if (j2 >= 1024 && j2 < StorageUtil.M) {
            return Long.toString(j2 / 1024) + " KB/s";
        } else if (j2 < StorageUtil.M || j2 >= IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            return "";
        } else {
            return Long.toString(j2 / StorageUtil.M) + " MB/s";
        }
    }

    public static void hideNavKey(Context context) {
        View decorView;
        int i2;
        if (Build.VERSION.SDK_INT >= 29) {
            decorView = ((Activity) context).getWindow().getDecorView();
            i2 = 3074;
        } else {
            int i3 = Build.VERSION.SDK_INT;
            decorView = ((Activity) context).getWindow().getDecorView();
            i2 = i3 >= 19 ? 2562 : IChannelListener.DATA_CHANNEL_EVENT_GET_FINISH;
        }
        decorView.setSystemUiVisibility(i2);
    }

    public static void hideSupportActionBar(Context context, boolean z2, boolean z3) {
        AppCompatActivity appCompActivity;
        ActionBar supportActionBar;
        if (!(!z2 || (appCompActivity = getAppCompActivity(context)) == null || (supportActionBar = appCompActivity.getSupportActionBar()) == null)) {
            supportActionBar.d(false);
            supportActionBar.c();
        }
        if (z3) {
            (context instanceof FragmentActivity ? ((FragmentActivity) context).getWindow() : context instanceof Activity ? ((Activity) context).getWindow() : getAppCompActivity(context).getWindow()).setFlags(1024, 1024);
        }
    }

    public static boolean isWifiConnected(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
    }

    public static int px2dip(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Activity scanForActivity(Context context) {
        Context baseContext;
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ac) {
            baseContext = ((ac) context).getBaseContext();
        } else if (!(context instanceof ContextWrapper)) {
            return null;
        } else {
            baseContext = ((ContextWrapper) context).getBaseContext();
        }
        return scanForActivity(baseContext);
    }

    public static void showNavKey(Context context, int i2) {
        ((Activity) context).getWindow().getDecorView().setSystemUiVisibility(i2);
    }

    public static void showSupportActionBar(Context context, boolean z2, boolean z3) {
        AppCompatActivity appCompActivity;
        ActionBar supportActionBar;
        if (!(!z2 || (appCompActivity = getAppCompActivity(context)) == null || (supportActionBar = appCompActivity.getSupportActionBar()) == null)) {
            supportActionBar.d(false);
            supportActionBar.b();
        }
        if (z3) {
            (context instanceof FragmentActivity ? ((FragmentActivity) context).getWindow() : context instanceof Activity ? ((Activity) context).getWindow() : getAppCompActivity(context).getWindow()).clearFlags(1024);
        }
    }

    public static String stringForTime(int i2) {
        Formatter format;
        if (i2 <= 0 || i2 >= 86400000) {
            return "00:00";
        }
        int i3 = i2 / 1000;
        int i4 = i3 % 60;
        int i5 = (i3 / 60) % 60;
        int i6 = i3 / CacheConstants.HOUR;
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        if (i6 > 0) {
            format = formatter.format("%d:%02d:%02d", new Object[]{Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i4)});
        } else {
            format = formatter.format("%02d:%02d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4)});
        }
        return format.toString();
    }
}
