package com.amap.api.mapcore.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

public class el {

    /* renamed from: a  reason: collision with root package name */
    public static int f8518a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static AssetManager f8519b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Resources f8520c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Resources f8521d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f8522e = true;

    /* renamed from: f  reason: collision with root package name */
    private static Context f8523f = null;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static String f8524g = "amap_resource";
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static String f8525h = "1_0_0";

    /* renamed from: i  reason: collision with root package name */
    private static String f8526i = ".png";
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static String f8527j = ".jar";

    /* renamed from: k  reason: collision with root package name */
    private static String f8528k = (f8524g + f8525h + f8527j);

    /* renamed from: l  reason: collision with root package name */
    private static String f8529l = (f8524g + f8525h + f8526i);

    /* renamed from: m  reason: collision with root package name */
    private static String f8530m = "";

    /* renamed from: n  reason: collision with root package name */
    private static String f8531n = (f8530m + f8528k);

    /* renamed from: o  reason: collision with root package name */
    private static Resources.Theme f8532o = null;

    /* renamed from: p  reason: collision with root package name */
    private static Resources.Theme f8533p = null;

    /* renamed from: q  reason: collision with root package name */
    private static Field f8534q = null;

    /* renamed from: r  reason: collision with root package name */
    private static Field f8535r = null;

    /* renamed from: s  reason: collision with root package name */
    private static Activity f8536s = null;

    static class a implements FilenameFilter {
        a() {
        }

        public final boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(el.f8525h);
            sb.append(el.f8527j);
            return str.startsWith(el.f8524g) && !str.endsWith(sb.toString());
        }
    }

    private static AssetManager a(String str) {
        AssetManager assetManager = null;
        try {
            Class<?> cls = Class.forName("android.content.res.AssetManager");
            AssetManager assetManager2 = (AssetManager) cls.getConstructor((Class[]) null).newInstance((Object[]) null);
            try {
                cls.getDeclaredMethod("addAssetPath", new Class[]{String.class}).invoke(assetManager2, new Object[]{str});
                return assetManager2;
            } catch (Throwable th) {
                th = th;
                assetManager = assetManager2;
            }
        } catch (Throwable th2) {
            th = th2;
            fz.c(th, "ResourcesUtil", "getAssetManager(String apkPath)");
            return assetManager;
        }
    }

    public static Resources a() {
        Resources resources = f8520c;
        return resources == null ? f8523f.getResources() : resources;
    }

    private static Resources a(Context context, AssetManager assetManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        return new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
    }

    public static View a(Context context, int i2) {
        XmlResourceParser xml = a().getXml(i2);
        View view = null;
        if (!f8522e) {
            return LayoutInflater.from(context).inflate(xml, (ViewGroup) null);
        }
        try {
            int i3 = f8518a;
            if (i3 == -1) {
                i3 = 0;
            }
            view = LayoutInflater.from(new ek(context, i3, el.class.getClassLoader())).inflate(xml, (ViewGroup) null);
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
        xml.close();
        return view;
    }

    private static OutputStream a(InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(f8530m, f8528k));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return fileOutputStream;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    public static boolean a(Context context) {
        try {
            f8523f = context;
            File b2 = b(context);
            if (b2 != null) {
                f8530m = b2.getAbsolutePath() + "/";
            }
            f8531n = f8530m + f8528k;
            if (!f8522e) {
                return true;
            }
            if (!c(context)) {
                return false;
            }
            AssetManager a2 = a(f8531n);
            f8519b = a2;
            f8520c = a(context, a2);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static File b(Context context) {
        if (context == null) {
            if (context != null) {
                context.getFilesDir();
            }
            return null;
        }
        try {
            File filesDir = (!Environment.getExternalStorageState().equals("mounted") || !Environment.getExternalStorageDirectory().canWrite()) ? context.getFilesDir() : context.getExternalFilesDir("LBS");
            if (filesDir == null && context != null) {
                context.getFilesDir();
            }
            return filesDir;
        } catch (Exception e2) {
            e2.printStackTrace();
            if (0 != 0 || context == null) {
                return null;
            }
            return context.getFilesDir();
        } catch (Throwable th) {
            if (0 == 0 && context != null) {
                context.getFilesDir();
            }
            throw th;
        }
    }

    private static boolean b(InputStream inputStream) throws IOException {
        File file = new File(f8531n);
        long length = file.length();
        int available = inputStream.available();
        if (!file.exists() || length != ((long) available)) {
            return false;
        }
        inputStream.close();
        return true;
    }

    private static boolean c(Context context) {
        d(context);
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open(f8529l);
            if (b(inputStream)) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        fz.c(e2, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                    }
                }
                return true;
            }
            e();
            OutputStream a2 = a(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                    fz.c(e3, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                }
            }
            if (a2 != null) {
                a2.close();
            }
            return true;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                    fz.c(e4, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                }
            }
            throw th;
        }
    }

    private static void d(Context context) {
        f8530m = context.getFilesDir().getAbsolutePath();
        f8531n = f8530m + "/" + f8528k;
    }

    private static void e() {
        File[] listFiles = new File(f8530m).listFiles(new a());
        if (listFiles != null && listFiles.length > 0) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }
}
