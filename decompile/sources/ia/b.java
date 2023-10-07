package ia;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Method;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f13516a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f13517b = null;

    private b() {
    }

    public static b a() {
        if (f13516a == null) {
            synchronized (b.class) {
                if (f13516a == null) {
                    f13516a = new b();
                }
            }
        }
        return f13516a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[SYNTHETIC, Splitter:B:14:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC, Splitter:B:21:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0041, all -> 0x003a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0041, all -> 0x003a }
            r2.<init>()     // Catch:{ IOException -> 0x0041, all -> 0x003a }
            java.lang.String r3 = "getprop "
            r2.append(r3)     // Catch:{ IOException -> 0x0041, all -> 0x003a }
            r2.append(r5)     // Catch:{ IOException -> 0x0041, all -> 0x003a }
            java.lang.String r5 = r2.toString()     // Catch:{ IOException -> 0x0041, all -> 0x003a }
            java.lang.Process r5 = r1.exec(r5)     // Catch:{ IOException -> 0x0041, all -> 0x003a }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0041, all -> 0x003a }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0041, all -> 0x003a }
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ IOException -> 0x0041, all -> 0x003a }
            r2.<init>(r5)     // Catch:{ IOException -> 0x0041, all -> 0x003a }
            r5 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2, r5)     // Catch:{ IOException -> 0x0041, all -> 0x003a }
            java.lang.String r5 = r1.readLine()     // Catch:{ IOException -> 0x0038, all -> 0x0035 }
            r1.close()     // Catch:{ IOException -> 0x0038, all -> 0x0035 }
            r1.close()     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            return r5
        L_0x0035:
            r5 = move-exception
            r0 = r1
            goto L_0x003b
        L_0x0038:
            goto L_0x0042
        L_0x003a:
            r5 = move-exception
        L_0x003b:
            if (r0 == 0) goto L_0x0040
            r0.close()     // Catch:{ IOException -> 0x0040 }
        L_0x0040:
            throw r5
        L_0x0041:
            r1 = r0
        L_0x0042:
            if (r1 == 0) goto L_0x0047
            r1.close()     // Catch:{ IOException -> 0x0047 }
        L_0x0047:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ia.b.a(java.lang.String):java.lang.String");
    }

    private void b(Activity activity) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.flags |= 1024;
        activity.getWindow().setAttributes(attributes);
    }

    private void b(Activity activity, boolean z2) {
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
            Window window = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z2 ? i2 : 0);
            objArr[1] = Integer.valueOf(i2);
            method.invoke(window, objArr);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        c(activity, z2);
    }

    private boolean b() {
        String str = Build.DISPLAY;
        if (!TextUtils.isEmpty(str) && str.contains("Flyme")) {
            for (String matches : str.split(" ")) {
                if (matches.matches("^[4-9]\\.(\\d+\\.)+\\S*")) {
                    return true;
                }
            }
        }
        return false;
    }

    private void c(Activity activity) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.flags &= -1025;
        activity.getWindow().setAttributes(attributes);
    }

    private void c(Activity activity, boolean z2) {
        int i2;
        View view;
        if (Build.VERSION.SDK_INT >= 23) {
            Window window = activity.getWindow();
            if (z2) {
                window.addFlags(Integer.MIN_VALUE);
                window.clearFlags(67108864);
                view = window.getDecorView();
                i2 = 8192;
            } else {
                i2 = window.getDecorView().getSystemUiVisibility() & -8193;
                view = window.getDecorView();
            }
            view.setSystemUiVisibility(i2);
        }
    }

    private boolean c() {
        String a2 = a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        try {
            return Integer.parseInt(a2) >= 4;
        } catch (Exception unused) {
            return false;
        }
    }

    public int a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : (int) ((context.getResources().getDisplayMetrics().density * 23.0f) + 0.5f);
    }

    public void a(Activity activity, View view) {
        if (!a(activity)) {
            activity.getWindow().addFlags(256);
            activity.getWindow().addFlags(512);
        } else if (Build.VERSION.SDK_INT >= 16) {
            view.setSystemUiVisibility(512);
        }
    }

    public void a(Activity activity, boolean z2) {
        if (b()) {
            a.a(activity, z2);
        } else if (c()) {
            b(activity, z2);
        } else {
            c(activity, z2);
        }
    }

    public boolean a(Activity activity) {
        if (this.f13517b == null) {
            boolean z2 = true;
            if (Build.VERSION.SDK_INT >= 17) {
                int i2 = activity.getResources().getDisplayMetrics().heightPixels;
                DisplayMetrics displayMetrics = new DisplayMetrics();
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                if (displayMetrics.heightPixels - i2 <= 0) {
                    z2 = false;
                }
            }
            this.f13517b = Boolean.valueOf(z2);
        }
        return this.f13517b.booleanValue();
    }

    public void b(Activity activity, View view) {
        if (!a(activity)) {
            b(activity);
        } else if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(4871);
        } else if (Build.VERSION.SDK_INT >= 16) {
            view.setSystemUiVisibility(775);
        }
    }

    public void c(Activity activity, View view) {
        if (!a(activity)) {
            c(activity);
        } else if (Build.VERSION.SDK_INT >= 16) {
            view.setSystemUiVisibility(1536);
        }
    }
}
