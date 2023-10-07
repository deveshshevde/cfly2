package io.microshow.rxffmpeg.player;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.blankj.utilcode.constant.CacheConstants;

public class Helper {
    private static long lastClickTime;

    public static ViewGroup getDecorView(Activity activity) {
        if (activity == null) {
            return null;
        }
        return (ViewGroup) activity.getWindow().getDecorView();
    }

    public static ViewGroup getDecorView(Context context) {
        Activity scanForActivity = scanForActivity(context);
        if (scanForActivity == null) {
            return null;
        }
        return (ViewGroup) scanForActivity.getWindow().getDecorView();
    }

    public static int getFullScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        scanForActivity(context).getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static void hideSysBar(Activity activity, ViewGroup viewGroup) {
        int systemUiVisibility = viewGroup.getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= 16) {
            systemUiVisibility |= 2;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            systemUiVisibility |= 4096;
        }
        viewGroup.setSystemUiVisibility(systemUiVisibility);
        activity.getWindow().setFlags(1024, 1024);
    }

    public static synchronized boolean isFastClick() {
        boolean z2;
        synchronized (Helper.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastClickTime < 1000) {
                z2 = true;
            } else {
                lastClickTime = currentTimeMillis;
                z2 = false;
            }
        }
        return z2;
    }

    public static Activity scanForActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return scanForActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static String secdsToDateFormat(int i2, int i3) {
        String str;
        String str2;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        long j2 = (long) (i2 / CacheConstants.HOUR);
        long j3 = (long) ((i2 % CacheConstants.HOUR) / 60);
        long j4 = (long) (i2 % 60);
        String str3 = "00";
        if (j2 > 0) {
            if (j2 < 10) {
                sb3 = new StringBuilder();
                sb3.append("0");
                sb3.append(j2);
            } else {
                sb3 = new StringBuilder();
                sb3.append(j2);
                sb3.append("");
            }
            str = sb3.toString();
        } else {
            str = str3;
        }
        if (j3 > 0) {
            if (j3 < 10) {
                sb2 = new StringBuilder();
                sb2.append("0");
                sb2.append(j3);
            } else {
                sb2 = new StringBuilder();
                sb2.append(j3);
                sb2.append("");
            }
            str2 = sb2.toString();
        } else {
            str2 = str3;
        }
        if (j4 > 0) {
            if (j4 < 10) {
                str3 = "0" + j4;
            } else {
                str3 = j4 + "";
            }
        }
        if (i3 >= 3600) {
            sb = new StringBuilder();
            sb.append(str);
            sb.append(":");
        } else {
            sb = new StringBuilder();
        }
        sb.append(str2);
        sb.append(":");
        sb.append(str3);
        return sb.toString();
    }

    public static ViewGroup setFullScreen(Context context, boolean z2) {
        int i2;
        Activity scanForActivity = scanForActivity(context);
        ViewGroup decorView = getDecorView(scanForActivity);
        if (decorView == null) {
            return null;
        }
        if (z2) {
            hideSysBar(scanForActivity, decorView);
            i2 = 0;
        } else {
            showSysBar(scanForActivity, decorView);
            i2 = 1;
        }
        scanForActivity.setRequestedOrientation(i2);
        return decorView;
    }

    public static void showSysBar(Activity activity, ViewGroup viewGroup) {
        int systemUiVisibility = viewGroup.getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= 16) {
            systemUiVisibility &= -3;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            systemUiVisibility &= -4097;
        }
        viewGroup.setSystemUiVisibility(systemUiVisibility);
        activity.getWindow().clearFlags(1024);
    }
}
