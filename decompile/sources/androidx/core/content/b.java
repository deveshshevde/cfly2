package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import java.io.File;
import java.util.HashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2952a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f2953b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static TypedValue f2954c;

    static class a {
        static void a(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }

        static void a(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }
    }

    /* renamed from: androidx.core.content.b$b  reason: collision with other inner class name */
    static class C0026b {
        static File[] a(Context context) {
            return context.getExternalCacheDirs();
        }

        static File[] a(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        static File[] b(Context context) {
            return context.getObbDirs();
        }
    }

    static class c {
        static Drawable a(Context context, int i2) {
            return context.getDrawable(i2);
        }

        static File a(Context context) {
            return context.getNoBackupFilesDir();
        }

        static File b(Context context) {
            return context.getCodeCacheDir();
        }
    }

    static class d {
        static ColorStateList a(Context context, int i2) {
            return context.getColorStateList(i2);
        }

        static <T> T a(Context context, Class<T> cls) {
            return context.getSystemService(cls);
        }

        static int b(Context context, int i2) {
            return context.getColor(i2);
        }

        static String b(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    static class e {
        static ComponentName a(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    private static final class f {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<Class<?>, String> f2955a;

        static {
            HashMap<Class<?>, String> hashMap = new HashMap<>();
            f2955a = hashMap;
            if (Build.VERSION.SDK_INT >= 22) {
                hashMap.put(SubscriptionManager.class, "telephony_subscription_service");
                hashMap.put(UsageStatsManager.class, "usagestats");
            }
            if (Build.VERSION.SDK_INT >= 21) {
                hashMap.put(AppWidgetManager.class, "appwidget");
                hashMap.put(BatteryManager.class, "batterymanager");
                hashMap.put(CameraManager.class, "camera");
                hashMap.put(JobScheduler.class, "jobscheduler");
                hashMap.put(LauncherApps.class, "launcherapps");
                hashMap.put(MediaProjectionManager.class, "media_projection");
                hashMap.put(MediaSessionManager.class, "media_session");
                hashMap.put(RestrictionsManager.class, "restrictions");
                hashMap.put(TelecomManager.class, "telecom");
                hashMap.put(TvInputManager.class, "tv_input");
            }
            if (Build.VERSION.SDK_INT >= 19) {
                hashMap.put(AppOpsManager.class, "appops");
                hashMap.put(CaptioningManager.class, "captioning");
                hashMap.put(ConsumerIrManager.class, "consumer_ir");
                hashMap.put(PrintManager.class, "print");
            }
            if (Build.VERSION.SDK_INT >= 18) {
                hashMap.put(BluetoothManager.class, "bluetooth");
            }
            if (Build.VERSION.SDK_INT >= 17) {
                hashMap.put(DisplayManager.class, "display");
                hashMap.put(UserManager.class, "user");
            }
            if (Build.VERSION.SDK_INT >= 16) {
                hashMap.put(InputManager.class, "input");
                hashMap.put(MediaRouter.class, "media_router");
                hashMap.put(NsdManager.class, "servicediscovery");
            }
            hashMap.put(AccessibilityManager.class, "accessibility");
            hashMap.put(AccountManager.class, "account");
            hashMap.put(ActivityManager.class, "activity");
            hashMap.put(AlarmManager.class, "alarm");
            hashMap.put(AudioManager.class, "audio");
            hashMap.put(ClipboardManager.class, "clipboard");
            hashMap.put(ConnectivityManager.class, "connectivity");
            hashMap.put(DevicePolicyManager.class, "device_policy");
            hashMap.put(DownloadManager.class, "download");
            hashMap.put(DropBoxManager.class, "dropbox");
            hashMap.put(InputMethodManager.class, "input_method");
            hashMap.put(KeyguardManager.class, "keyguard");
            hashMap.put(LayoutInflater.class, "layout_inflater");
            hashMap.put(LocationManager.class, "location");
            hashMap.put(NfcManager.class, "nfc");
            hashMap.put(NotificationManager.class, "notification");
            hashMap.put(PowerManager.class, "power");
            hashMap.put(SearchManager.class, "search");
            hashMap.put(SensorManager.class, "sensor");
            hashMap.put(StorageManager.class, "storage");
            hashMap.put(TelephonyManager.class, "phone");
            hashMap.put(TextServicesManager.class, "textservices");
            hashMap.put(UiModeManager.class, "uimode");
            hashMap.put(UsbManager.class, "usb");
            hashMap.put(Vibrator.class, "vibrator");
            hashMap.put(WallpaperManager.class, "wallpaper");
            hashMap.put(WifiP2pManager.class, "wifip2p");
            hashMap.put(WifiManager.class, "wifi");
            hashMap.put(WindowManager.class, "window");
        }
    }

    public static Drawable a(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return c.a(context, i2);
        }
        if (Build.VERSION.SDK_INT < 16) {
            synchronized (f2952a) {
                if (f2954c == null) {
                    f2954c = new TypedValue();
                }
                context.getResources().getValue(i2, f2954c, true);
                i2 = f2954c.resourceId;
            }
        }
        return context.getResources().getDrawable(i2);
    }

    public static <T> T a(Context context, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 23) {
            return d.a(context, cls);
        }
        String b2 = b(context, (Class<?>) cls);
        if (b2 != null) {
            return context.getSystemService(b2);
        }
        return null;
    }

    public static void a(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            e.a(context, intent);
        } else {
            context.startService(intent);
        }
    }

    public static void a(Context context, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            a.a(context, intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }

    public static boolean a(Context context, Intent[] intentArr, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            a.a(context, intentArr, bundle);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    public static File[] a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return C0026b.a(context);
        }
        return new File[]{context.getExternalCacheDir()};
    }

    public static File[] a(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            return C0026b.a(context, str);
        }
        return new File[]{context.getExternalFilesDir(str)};
    }

    public static int b(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static ColorStateList b(Context context, int i2) {
        return l.f.c(context.getResources(), i2, context.getTheme());
    }

    public static String b(Context context, Class<?> cls) {
        return Build.VERSION.SDK_INT >= 23 ? d.b(context, cls) : f.f2955a.get(cls);
    }

    public static int c(Context context, int i2) {
        return Build.VERSION.SDK_INT >= 23 ? d.b(context, i2) : context.getResources().getColor(i2);
    }
}
