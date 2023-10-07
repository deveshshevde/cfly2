package com.amap.api.mapcore.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.xeagle.android.login.common.StorageUtil;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class ez {
    private static String A = "";

    /* renamed from: a  reason: collision with root package name */
    static String f8700a = "";

    /* renamed from: b  reason: collision with root package name */
    static String f8701b = "";

    /* renamed from: c  reason: collision with root package name */
    static volatile boolean f8702c = true;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f8703d = false;

    /* renamed from: e  reason: collision with root package name */
    static String f8704e = "";

    /* renamed from: f  reason: collision with root package name */
    static boolean f8705f = false;

    /* renamed from: g  reason: collision with root package name */
    public static a f8706g = null;

    /* renamed from: h  reason: collision with root package name */
    static int f8707h = -1;

    /* renamed from: i  reason: collision with root package name */
    static String f8708i = "";

    /* renamed from: j  reason: collision with root package name */
    static String f8709j = "";

    /* renamed from: k  reason: collision with root package name */
    private static String f8710k = null;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f8711l = false;

    /* renamed from: m  reason: collision with root package name */
    private static volatile boolean f8712m = false;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static String f8713n = "";

    /* renamed from: o  reason: collision with root package name */
    private static boolean f8714o = false;

    /* renamed from: p  reason: collision with root package name */
    private static String f8715p = "";

    /* renamed from: q  reason: collision with root package name */
    private static String f8716q = "";

    /* renamed from: r  reason: collision with root package name */
    private static String f8717r = "";

    /* renamed from: s  reason: collision with root package name */
    private static String f8718s = "";

    /* renamed from: t  reason: collision with root package name */
    private static String f8719t = "";

    /* renamed from: u  reason: collision with root package name */
    private static String f8720u = "";

    /* renamed from: v  reason: collision with root package name */
    private static boolean f8721v = false;

    /* renamed from: w  reason: collision with root package name */
    private static String f8722w = "";

    /* renamed from: x  reason: collision with root package name */
    private static long f8723x;

    /* renamed from: y  reason: collision with root package name */
    private static int f8724y;

    /* renamed from: z  reason: collision with root package name */
    private static String f8725z;

    public interface a {
        hd a(byte[] bArr, Map<String, String> map);

        String a();

        String a(Context context, String str);

        String a(String str, String str2, String str3, String str4);

        Map<String, String> b();
    }

    static class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private static String f8728a;

        /* renamed from: b  reason: collision with root package name */
        private Context f8729b;

        /* renamed from: c  reason: collision with root package name */
        private int f8730c;

        b(Context context, int i2) {
            this.f8729b = context;
            this.f8730c = i2;
        }

        private String a() {
            try {
                if (!TextUtils.isEmpty(f8728a)) {
                    return f8728a;
                }
                byte[] digest = MessageDigest.getInstance(fg.c("IU0hBMQ")).digest(this.f8729b.getPackageManager().getPackageInfo(this.f8729b.getPackageName(), 64).signatures[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : digest) {
                    stringBuffer.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                }
                String stringBuffer2 = stringBuffer.toString();
                if (!TextUtils.isEmpty(stringBuffer2)) {
                    f8728a = stringBuffer2;
                }
                return stringBuffer2;
            } catch (Throwable unused) {
                return "";
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x004e A[Catch:{ all -> 0x0062, all -> 0x0075 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onServiceConnected(android.content.ComponentName r6, android.os.IBinder r7) {
            /*
                r5 = this;
                android.os.Parcel r6 = android.os.Parcel.obtain()
                android.os.Parcel r0 = android.os.Parcel.obtain()
                int r1 = r5.f8730c     // Catch:{ all -> 0x0062 }
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == r2) goto L_0x0044
                r2 = 4
                if (r1 == r2) goto L_0x003a
                r2 = 5
                if (r1 == r2) goto L_0x0017
                r1 = 0
                goto L_0x004c
            L_0x0017:
                java.lang.String r1 = "KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"
                java.lang.String r1 = com.amap.api.mapcore.util.fg.c((java.lang.String) r1)     // Catch:{ all -> 0x0062 }
                r6.writeInterfaceToken(r1)     // Catch:{ all -> 0x0062 }
                android.content.Context r1 = r5.f8729b     // Catch:{ all -> 0x0062 }
                java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x0062 }
                r6.writeString(r1)     // Catch:{ all -> 0x0062 }
                java.lang.String r1 = r5.a()     // Catch:{ all -> 0x0062 }
                r6.writeString(r1)     // Catch:{ all -> 0x0062 }
                java.lang.String r1 = "IT1VJRA"
                java.lang.String r1 = com.amap.api.mapcore.util.fg.c((java.lang.String) r1)     // Catch:{ all -> 0x0062 }
                r6.writeString(r1)     // Catch:{ all -> 0x0062 }
                goto L_0x004b
            L_0x003a:
                java.lang.String r1 = "UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ"
                java.lang.String r1 = com.amap.api.mapcore.util.fg.c((java.lang.String) r1)     // Catch:{ all -> 0x0062 }
            L_0x0040:
                r6.writeInterfaceToken(r1)     // Catch:{ all -> 0x0062 }
                goto L_0x004b
            L_0x0044:
                java.lang.String r1 = "UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U"
                java.lang.String r1 = com.amap.api.mapcore.util.fg.c((java.lang.String) r1)     // Catch:{ all -> 0x0062 }
                goto L_0x0040
            L_0x004b:
                r1 = 1
            L_0x004c:
                if (r1 == 0) goto L_0x005b
                r7.transact(r4, r6, r0, r3)     // Catch:{ all -> 0x0062 }
                r0.readException()     // Catch:{ all -> 0x0062 }
                java.lang.String r7 = r0.readString()     // Catch:{ all -> 0x0062 }
                java.lang.String unused = com.amap.api.mapcore.util.ez.f8713n = r7     // Catch:{ all -> 0x0062 }
            L_0x005b:
                r0.recycle()
                r6.recycle()
                return
            L_0x0062:
                r7 = move-exception
                java.lang.String r1 = "oac"
                int r2 = r5.f8730c     // Catch:{ all -> 0x0075 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0075 }
                com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r7, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0075 }
                r0.recycle()
                r6.recycle()
                return
            L_0x0075:
                r7 = move-exception
                r0.recycle()
                r6.recycle()
                goto L_0x007e
            L_0x007d:
                throw r7
            L_0x007e:
                goto L_0x007d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ez.b.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static String B(Context context) {
        try {
            String b2 = gb.b(context, "Alvin2", "UTDID2", "");
            return TextUtils.isEmpty(b2) ? gb.b(context, "Alvin2", "UTDID", "") : b2;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String C(android.content.Context r8) {
        /*
            r0 = 0
            java.lang.String r1 = "android.permission.READ_EXTERNAL_STORAGE"
            boolean r8 = com.amap.api.mapcore.util.fg.a((android.content.Context) r8, (java.lang.String) r1)     // Catch:{ all -> 0x0094 }
            if (r8 == 0) goto L_0x008e
            java.lang.String r8 = "mounted"
            java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch:{ all -> 0x0094 }
            boolean r8 = r8.equals(r1)     // Catch:{ all -> 0x0094 }
            if (r8 == 0) goto L_0x008e
            java.io.File r8 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x0094 }
            java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ all -> 0x0094 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0094 }
            r1.<init>()     // Catch:{ all -> 0x0094 }
            r1.append(r8)     // Catch:{ all -> 0x0094 }
            java.lang.String r8 = "/.UTSystemConfig/Global/Alvin2.xml"
            r1.append(r8)     // Catch:{ all -> 0x0094 }
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x0094 }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0094 }
            r1.<init>(r8)     // Catch:{ all -> 0x0094 }
            org.xmlpull.v1.XmlPullParser r8 = android.util.Xml.newPullParser()     // Catch:{ all -> 0x0094 }
            int r2 = r8.getEventType()     // Catch:{ all -> 0x0094 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0094 }
            r3.<init>(r1)     // Catch:{ all -> 0x0094 }
            java.lang.String r0 = "utf-8"
            r8.setInput(r3, r0)     // Catch:{ all -> 0x008c }
            r0 = 0
            r1 = 0
        L_0x0047:
            r4 = 1
            if (r4 == r2) goto L_0x008a
            r5 = 2
            if (r2 == r5) goto L_0x0060
            r4 = 3
            if (r2 == r4) goto L_0x005e
            r4 = 4
            if (r2 == r4) goto L_0x0054
            goto L_0x0085
        L_0x0054:
            if (r1 == 0) goto L_0x0085
            java.lang.String r8 = r8.getText()     // Catch:{ all -> 0x008c }
            r3.close()     // Catch:{ all -> 0x005d }
        L_0x005d:
            return r8
        L_0x005e:
            r1 = 0
            goto L_0x0085
        L_0x0060:
            int r2 = r8.getAttributeCount()     // Catch:{ all -> 0x008c }
            if (r2 <= 0) goto L_0x0085
            int r2 = r8.getAttributeCount()     // Catch:{ all -> 0x008c }
            r5 = 0
        L_0x006b:
            if (r5 >= r2) goto L_0x0085
            java.lang.String r6 = r8.getAttributeValue(r5)     // Catch:{ all -> 0x008c }
            java.lang.String r7 = "UTDID2"
            boolean r7 = r7.equals(r6)     // Catch:{ all -> 0x008c }
            if (r7 != 0) goto L_0x0081
            java.lang.String r7 = "UTDID"
            boolean r6 = r7.equals(r6)     // Catch:{ all -> 0x008c }
            if (r6 == 0) goto L_0x0082
        L_0x0081:
            r1 = 1
        L_0x0082:
            int r5 = r5 + 1
            goto L_0x006b
        L_0x0085:
            int r2 = r8.next()     // Catch:{ all -> 0x008c }
            goto L_0x0047
        L_0x008a:
            r0 = r3
            goto L_0x008e
        L_0x008c:
            r0 = r3
            goto L_0x0094
        L_0x008e:
            if (r0 == 0) goto L_0x0097
        L_0x0090:
            r0.close()     // Catch:{ all -> 0x0097 }
            goto L_0x0097
        L_0x0094:
            if (r0 == 0) goto L_0x0097
            goto L_0x0090
        L_0x0097:
            java.lang.String r8 = ""
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ez.C(android.content.Context):java.lang.String");
    }

    private static String D(Context context) {
        try {
            Class<?> cls = Class.forName(fg.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object newInstance = cls.newInstance();
            Object invoke = cls.getMethod(fg.c("MZ2V0T0FJRA"), new Class[]{Context.class}).invoke(newInstance, new Object[]{context});
            if (invoke != null) {
                String str = (String) invoke;
                f8713n = str;
                return str;
            }
        } catch (Throwable th) {
            fw.a(th, "oa", "xm");
            f8714o = true;
        }
        return f8713n;
    }

    private static String E(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(fg.c("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), (String[]) null, (String) null, (String[]) null, (String) null);
            if (query != null) {
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= columnCount) {
                            break;
                        } else if (fg.c("IdmFsdWU").equals(query.getColumnName(i2))) {
                            f8713n = query.getString(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                query.close();
            }
        } catch (Throwable th) {
            f8714o = true;
            fw.a(th, "oa", "vivo");
        }
        return f8713n;
    }

    /* access modifiers changed from: private */
    public static String F(Context context) {
        if (fg.c("IeGlhb21p").equalsIgnoreCase(Build.MANUFACTURER)) {
            return D(context);
        }
        if (fg.c("Idml2bw").equalsIgnoreCase(Build.MANUFACTURER)) {
            return E(context);
        }
        if (fg.c("IaHVhd2Vp").equalsIgnoreCase(Build.MANUFACTURER)) {
            return a(context, 2);
        }
        if (fg.c("Mc2Ftc3VuZw").equalsIgnoreCase(Build.MANUFACTURER)) {
            return a(context, 4);
        }
        if (fg.c("IT1BQTw").equalsIgnoreCase(Build.MANUFACTURER) || fg.c("MT25lUGx1cw").equalsIgnoreCase(Build.MANUFACTURER)) {
            return a(context, 5);
        }
        f8714o = true;
        return f8713n;
    }

    private static NetworkInfo G(Context context) {
        ConnectivityManager L;
        if (b(context, fg.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (L = L(context)) != null) {
            return L.getActiveNetworkInfo();
        }
        return null;
    }

    private static String H(Context context) {
        if (!TextUtils.isEmpty(f8722w)) {
            return f8722w;
        }
        try {
            String b2 = gb.b(context, "open_common", "a1", "");
            if (TextUtils.isEmpty(b2)) {
                f8722w = "amap" + UUID.randomUUID().toString().replace("_", "").toLowerCase();
                SharedPreferences.Editor a2 = gb.a(context, "open_common");
                gb.a(a2, "a1", fg.b(f8722w));
                gb.a(a2);
            } else {
                f8722w = fg.c(b2);
            }
        } catch (Throwable unused) {
        }
        return f8722w;
    }

    private static String I(Context context) throws InvocationTargetException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        String str = A;
        if (str != null && !"".equals(str)) {
            return A;
        }
        if (!b(context, fg.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return A;
        }
        TelephonyManager N = N(context);
        if (N == null) {
            return "";
        }
        Method a2 = fg.a((Class) N.getClass(), "UZ2V0U3Vic2NyaWJlcklk", (Class<?>[]) new Class[0]);
        if (a2 != null) {
            A = (String) a2.invoke(N, new Object[0]);
        }
        if (A == null) {
            A = "";
        }
        return A;
    }

    private static String J(Context context) {
        if (!b(context, fg.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return null;
        }
        TelephonyManager N = N(context);
        if (N == null) {
            return "";
        }
        String simOperatorName = N.getSimOperatorName();
        return TextUtils.isEmpty(simOperatorName) ? N.getNetworkOperatorName() : simOperatorName;
    }

    private static int K(Context context) {
        ConnectivityManager L;
        NetworkInfo activeNetworkInfo;
        if (context == null || !b(context, fg.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (L = L(context)) == null || (activeNetworkInfo = L.getActiveNetworkInfo()) == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    private static ConnectivityManager L(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static int M(Context context) {
        TelephonyManager N;
        if (b(context, fg.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (N = N(context)) != null) {
            return N.getNetworkType();
        }
        return -1;
    }

    private static TelephonyManager N(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static String O(Context context) {
        if (!f8702c) {
            return "";
        }
        String str = null;
        try {
            str = P(context);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str)) {
            f8702c = false;
            return "";
        }
        try {
            byte[] bytes = fg.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
            return new String(fa.a(fg.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), fa.b(str), bytes), "UTF-8");
        } catch (Throwable unused2) {
            f8702c = false;
            return "";
        }
    }

    private static String P(Context context) {
        String str;
        try {
            str = Q(context);
        } catch (Throwable unused) {
            str = "";
        }
        return !TextUtils.isEmpty(str) ? str : context == null ? "" : context.getSharedPreferences(fg.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(fd.b(fg.c("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    private static String Q(Context context) {
        RandomAccessFile randomAccessFile;
        String[] split;
        String b2 = fd.b(fg.c("LYW1hcF9kZXZpY2VfYWRpdQ"));
        String R = R(context);
        if (TextUtils.isEmpty(R)) {
            return "";
        }
        File file = new File(R + File.separator + fg.c("KYmFja3Vwcw"), fg.c("MLmFkaXU"));
        if (file.exists() && file.canRead()) {
            if (file.length() == 0) {
                file.delete();
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = randomAccessFile.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, read);
                        } catch (Throwable unused) {
                            byteArrayOutputStream = byteArrayOutputStream2;
                            a((Closeable) byteArrayOutputStream);
                            a((Closeable) randomAccessFile);
                            return "";
                        }
                    }
                    String str = new String(byteArrayOutputStream2.toByteArray(), "UTF-8");
                    if (TextUtils.isEmpty(str) || !str.contains(fg.c("SIw")) || (split = str.split(fg.c("SIw"))) == null || split.length != 2 || !TextUtils.equals(b2, split[0])) {
                        a((Closeable) byteArrayOutputStream2);
                        a((Closeable) randomAccessFile);
                    } else {
                        String str2 = split[1];
                        a((Closeable) byteArrayOutputStream2);
                        a((Closeable) randomAccessFile);
                        return str2;
                    }
                } catch (Throwable unused2) {
                    a((Closeable) byteArrayOutputStream);
                    a((Closeable) randomAccessFile);
                    return "";
                }
            } catch (Throwable unused3) {
                randomAccessFile = null;
                a((Closeable) byteArrayOutputStream);
                a((Closeable) randomAccessFile);
                return "";
            }
        }
        return "";
    }

    private static String R(Context context) {
        if (Build.VERSION.SDK_INT < 9) {
            return null;
        }
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName(fg.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(fg.c("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(fg.c("FZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(fg.c("DaXNSZW1vdmFibGU"), new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = Array.get(invoke, i2);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String a() {
        return f8710k;
    }

    public static String a(final Context context) {
        try {
            if (!TextUtils.isEmpty(f8701b)) {
                return f8701b;
            }
            if (context == null) {
                return "";
            }
            String O = O(context);
            f8701b = O;
            if (!TextUtils.isEmpty(O)) {
                return f8701b;
            }
            if (c() == null || f8712m) {
                return "";
            }
            f8712m = true;
            id.a().a(new ie() {
                public final void runTask() {
                    try {
                        Map<String, String> b2 = ez.f8706g.b();
                        String a2 = ez.f8706g.a(ez.h(context), "", "", ez.x(context));
                        if (!TextUtils.isEmpty(a2)) {
                            gw.a();
                            String a3 = ez.f8706g.a(context, new String(gw.b(ez.f8706g.a(a2.getBytes(), b2)).f9117a));
                            if (!TextUtils.isEmpty(a3)) {
                                ez.f8701b = a3;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
            return "";
        } catch (Throwable unused) {
        }
    }

    private static String a(Context context, int i2) {
        try {
            Intent intent = new Intent();
            if (i2 == 2) {
                intent.setAction(fg.c("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
                intent.setPackage(fg.c("UY29tLmh1YXdlaS5od2lk"));
            } else if (i2 == 4) {
                intent.setClassName(fg.c("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), fg.c("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));
            } else if (i2 != 5) {
                f8714o = true;
                return f8713n;
            } else {
                intent.setClassName(fg.c("YY29tLmhleXRhcC5vcGVuaWQ"), fg.c("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));
                intent.setAction(fg.c("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));
            }
            b bVar = new b(context, i2);
            if (context.bindService(intent, bVar, 1)) {
                int i3 = 0;
                while (i3 < 100 && TextUtils.isEmpty(f8713n)) {
                    i3++;
                    Thread.sleep(15);
                }
                context.unbindService(bVar);
            }
            return f8713n;
        } catch (Throwable th) {
            fw.a(th, "oa", String.valueOf(i2));
            f8714o = true;
            return f8713n;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:13|(2:15|16)|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r8 = r2.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007f, code lost:
        if (r8.length() == 0) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0081, code lost:
        f8707h = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0083, code lost:
        return "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
        r8 = r8.substring(0, r8.length() - 1);
        f8708i = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008f, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0090, code lost:
        return "";
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0040 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0077 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r8, java.lang.String r9) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = ""
            r2 = 29
            if (r0 < r2) goto L_0x0009
            return r1
        L_0x0009:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0090 }
            r2 = 21
            if (r0 >= r2) goto L_0x0010
            return r1
        L_0x0010:
            java.lang.String r0 = f8708i     // Catch:{ all -> 0x0090 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0090 }
            if (r0 != 0) goto L_0x001b
            java.lang.String r8 = f8708i     // Catch:{ all -> 0x0090 }
            return r8
        L_0x001b:
            android.telephony.TelephonyManager r8 = N(r8)     // Catch:{ all -> 0x0090 }
            int r0 = f8707h     // Catch:{ all -> 0x0090 }
            r2 = -1
            r3 = 0
            if (r0 != r2) goto L_0x0042
            java.lang.Class<android.telephony.TelephonyManager> r0 = android.telephony.TelephonyManager.class
            java.lang.String r2 = "UZ2V0UGhvbmVDb3VudA="
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0090 }
            java.lang.reflect.Method r0 = com.amap.api.mapcore.util.fg.a((java.lang.Class) r0, (java.lang.String) r2, (java.lang.Class<?>[]) r4)     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x0040
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x0040 }
            java.lang.Object r0 = r0.invoke(r8, r2)     // Catch:{ all -> 0x0040 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0040 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0040 }
            f8707h = r0     // Catch:{ all -> 0x0040 }
            goto L_0x0042
        L_0x0040:
            f8707h = r3     // Catch:{ all -> 0x0090 }
        L_0x0042:
            java.lang.Class<android.telephony.TelephonyManager> r0 = android.telephony.TelephonyManager.class
            java.lang.String r2 = "MZ2V0SW1laQ="
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x0090 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0090 }
            r5[r3] = r6     // Catch:{ all -> 0x0090 }
            java.lang.reflect.Method r0 = com.amap.api.mapcore.util.fg.a((java.lang.Class) r0, (java.lang.String) r2, (java.lang.Class<?>[]) r5)     // Catch:{ all -> 0x0090 }
            if (r0 != 0) goto L_0x0056
            f8707h = r3     // Catch:{ all -> 0x0090 }
            return r1
        L_0x0056:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r2.<init>()     // Catch:{ all -> 0x0090 }
            r5 = 0
        L_0x005c:
            int r6 = f8707h     // Catch:{ all -> 0x0077 }
            if (r5 >= r6) goto L_0x0077
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x0077 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0077 }
            r6[r3] = r7     // Catch:{ all -> 0x0077 }
            java.lang.Object r6 = r0.invoke(r8, r6)     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0077 }
            r2.append(r6)     // Catch:{ all -> 0x0077 }
            r2.append(r9)     // Catch:{ all -> 0x0077 }
            int r5 = r5 + 1
            goto L_0x005c
        L_0x0077:
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x0090 }
            int r9 = r8.length()     // Catch:{ all -> 0x0090 }
            if (r9 != 0) goto L_0x0084
            f8707h = r3     // Catch:{ all -> 0x0090 }
            return r1
        L_0x0084:
            int r9 = r8.length()     // Catch:{ all -> 0x0090 }
            int r9 = r9 - r4
            java.lang.String r8 = r8.substring(r3, r9)     // Catch:{ all -> 0x0090 }
            f8708i = r8     // Catch:{ all -> 0x0090 }
            return r8
        L_0x0090:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ez.a(android.content.Context, java.lang.String):java.lang.String");
    }

    private static List<ScanResult> a(List<ScanResult> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size - 1; i2++) {
            for (int i3 = 1; i3 < size - i2; i3++) {
                int i4 = i3 - 1;
                if (list.get(i4).level > list.get(i3).level) {
                    list.set(i4, list.get(i3));
                    list.set(i3, list.get(i4));
                }
            }
        }
        return list;
    }

    public static void a(a aVar) {
        if (f8706g == null) {
            f8706g = aVar;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String b() {
        try {
            if (!TextUtils.isEmpty(f8704e)) {
                return f8704e;
            }
            a aVar = f8706g;
            return aVar == null ? "" : aVar.a();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(Context context) {
        try {
            return J(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static boolean b(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static a c() {
        return f8706g;
    }

    public static String c(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String x2 = x(context);
            if (x2 != null) {
                if (x2.length() >= 5) {
                    return x2.substring(3, 5);
                }
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int d(Context context) {
        try {
            return M(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    static String[] d() {
        return new String[]{"", ""};
    }

    public static int e(Context context) {
        try {
            return K(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static long e() {
        long j2;
        long j3;
        long j4 = f8723x;
        if (j4 != 0) {
            return j4;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                j3 = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / StorageUtil.M;
                j2 = (statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / StorageUtil.M;
            } else {
                j3 = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / StorageUtil.M;
                j2 = (((long) statFs2.getBlockCount()) * ((long) statFs2.getBlockSize())) / StorageUtil.M;
            }
            f8723x = j3 + j2;
        } catch (Throwable unused) {
        }
        return f8723x;
    }

    public static String f() {
        if (!TextUtils.isEmpty(f8725z)) {
            return f8725z;
        }
        String property = System.getProperty("os.arch");
        f8725z = property;
        return property;
    }

    public static String f(Context context) {
        try {
            return I(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static String g() {
        try {
            for (T t2 : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (t2.getName().equalsIgnoreCase("wlan0")) {
                    byte[] bArr = null;
                    if (Build.VERSION.SDK_INT >= 9) {
                        bArr = t2.getHardwareAddress();
                    }
                    if (bArr == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : bArr) {
                        String upperCase = Integer.toHexString(b2 & 255).toUpperCase();
                        if (upperCase.length() == 1) {
                            sb.append("0");
                        }
                        sb.append(upperCase);
                        sb.append(":");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String g(final Context context) {
        try {
            if (f8714o) {
                return "";
            }
            if (!TextUtils.isEmpty(f8713n)) {
                return f8713n;
            }
            if (Looper.getMainLooper() != Looper.myLooper()) {
                return F(context);
            }
            id.a().a(new ie() {
                public final void runTask() {
                    String unused = ez.F(context);
                }
            });
            return f8713n;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|(1:10)|11|(2:13|14)|15|16|(2:18|19)|(2:20|21)|23|(1:25)(1:26)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0032 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0041 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e A[Catch:{ all -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String h(android.content.Context r3) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = f8700a     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x000f
            boolean r1 = r0.equals(r1)     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x000f
            java.lang.String r3 = f8700a     // Catch:{ all -> 0x0032 }
            return r3
        L_0x000f:
            java.lang.String r1 = "WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"
            java.lang.String r1 = com.amap.api.mapcore.util.fg.c((java.lang.String) r1)     // Catch:{ all -> 0x0032 }
            boolean r1 = b(r3, r1)     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0027
            android.content.ContentResolver r1 = r3.getContentResolver()     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = "mqBRboGZkQPcAkyk"
            java.lang.String r1 = android.provider.Settings.System.getString(r1, r2)     // Catch:{ all -> 0x0032 }
            f8700a = r1     // Catch:{ all -> 0x0032 }
        L_0x0027:
            java.lang.String r1 = f8700a     // Catch:{ all -> 0x0032 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0032
            java.lang.String r3 = f8700a     // Catch:{ all -> 0x0032 }
            return r3
        L_0x0032:
            java.lang.String r1 = B(r3)     // Catch:{ all -> 0x0041 }
            f8700a = r1     // Catch:{ all -> 0x0041 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0041 }
            if (r1 != 0) goto L_0x0041
            java.lang.String r3 = f8700a     // Catch:{ all -> 0x0041 }
            return r3
        L_0x0041:
            java.lang.String r3 = C(r3)     // Catch:{ all -> 0x0048 }
            f8700a = r3     // Catch:{ all -> 0x0048 }
            goto L_0x0049
        L_0x0048:
        L_0x0049:
            java.lang.String r3 = f8700a
            if (r3 != 0) goto L_0x004e
            return r0
        L_0x004e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ez.h(android.content.Context):java.lang.String");
    }

    public static String i(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        if (!TextUtils.isEmpty(f8716q)) {
            return f8716q;
        }
        if (!b(context, fg.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return (String) fg.a(Build.class, "MZ2V0U2VyaWFs", (Class<?>[]) new Class[0]).invoke(Build.class, new Object[0]);
            }
            if (Build.VERSION.SDK_INT >= 9) {
                f8716q = Build.SERIAL;
            }
            String str = f8716q;
            return str == null ? "" : str;
        } catch (Throwable unused) {
        }
    }

    public static String j(Context context) {
        if (!TextUtils.isEmpty(f8715p)) {
            return f8715p;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), fg.c(new String(fv.a(13))));
            f8715p = string;
            return string == null ? "" : string;
        } catch (Throwable unused) {
            return f8715p;
        }
    }

    static String k(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (!b(context, fg.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                return "";
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return (wifiManager != null && wifiManager.isWifiEnabled()) ? wifiManager.getConnectionInfo().getBSSID() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    static String l(Context context) {
        StringBuilder sb = new StringBuilder();
        if (context != null) {
            try {
                if (b(context, fg.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager == null) {
                        return "";
                    }
                    if (wifiManager.isWifiEnabled()) {
                        List<ScanResult> scanResults = wifiManager.getScanResults();
                        if (scanResults != null) {
                            if (scanResults.size() != 0) {
                                List<ScanResult> a2 = a(scanResults);
                                boolean z2 = true;
                                int i2 = 0;
                                while (i2 < a2.size() && i2 < 7) {
                                    ScanResult scanResult = a2.get(i2);
                                    if (z2) {
                                        z2 = false;
                                    } else {
                                        sb.append(";");
                                    }
                                    sb.append(scanResult.BSSID);
                                    i2++;
                                }
                            }
                        }
                        return sb.toString();
                    }
                    return sb.toString();
                }
            } catch (Throwable unused) {
            }
        }
        return sb.toString();
    }

    public static String m(Context context) {
        try {
            String str = f8717r;
            if (str != null) {
                if (!"".equals(str)) {
                    return f8717r;
                }
            }
            if (!b(context, fg.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                return f8717r;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            f8717r = wifiManager.getConnectionInfo().getMacAddress();
            if (fg.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(f8717r) || fg.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(f8717r)) {
                f8717r = g();
            }
            return f8717r;
        } catch (Throwable unused) {
        }
    }

    static String n(Context context) {
        try {
            TelephonyManager N = N(context);
            if (N == null) {
                return "";
            }
            String networkOperator = N.getNetworkOperator();
            return !TextUtils.isEmpty(networkOperator) ? networkOperator.length() < 3 ? "" : networkOperator.substring(3) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int o(Context context) {
        try {
            return M(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int p(Context context) {
        try {
            return K(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    static String q(Context context) {
        try {
            NetworkInfo G = G(context);
            if (G == null) {
                return null;
            }
            return G.getExtraInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    static String r(Context context) {
        StringBuilder sb;
        try {
            String str = f8718s;
            if (str != null) {
                if (!"".equals(str)) {
                    return f8718s;
                }
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            if (i3 > i2) {
                sb = new StringBuilder();
                sb.append(i2);
                sb.append("*");
                sb.append(i3);
            } else {
                sb = new StringBuilder();
                sb.append(i3);
                sb.append("*");
                sb.append(i2);
            }
            f8718s = sb.toString();
            return f8718s;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        r2 = (r2 = L(r2)).getActiveNetworkInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String s(android.content.Context r2) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"
            java.lang.String r1 = com.amap.api.mapcore.util.fg.c((java.lang.String) r1)     // Catch:{ all -> 0x0022 }
            boolean r1 = b(r2, r1)     // Catch:{ all -> 0x0022 }
            if (r1 != 0) goto L_0x000f
            return r0
        L_0x000f:
            android.net.ConnectivityManager r2 = L(r2)     // Catch:{ all -> 0x0022 }
            if (r2 != 0) goto L_0x0016
            return r0
        L_0x0016:
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()     // Catch:{ all -> 0x0022 }
            if (r2 != 0) goto L_0x001d
            return r0
        L_0x001d:
            java.lang.String r2 = r2.getTypeName()     // Catch:{ all -> 0x0022 }
            return r2
        L_0x0022:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ez.s(android.content.Context):java.lang.String");
    }

    public static String t(Context context) {
        try {
            String u2 = u(context);
            try {
                if (TextUtils.isEmpty(u2)) {
                    u2 = a(context);
                }
                if (TextUtils.isEmpty(u2)) {
                    u2 = h(context);
                }
                if (TextUtils.isEmpty(u2)) {
                    u2 = g(context);
                }
                if (TextUtils.isEmpty(u2)) {
                    u2 = j(context);
                }
                return TextUtils.isEmpty(u2) ? H(context) : u2;
            } catch (Throwable unused) {
                return u2;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String u(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return "";
            }
            String str = f8719t;
            if (str != null && !"".equals(str)) {
                return f8719t;
            }
            if (!b(context, fg.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return f8719t;
            }
            TelephonyManager N = N(context);
            if (N == null) {
                return "";
            }
            Method a2 = fg.a((Class) N.getClass(), "QZ2V0RGV2aWNlSWQ", (Class<?>[]) new Class[0]);
            if (Build.VERSION.SDK_INT >= 26) {
                a2 = fg.a((Class) N.getClass(), "QZ2V0SW1laQ==", (Class<?>[]) new Class[0]);
            }
            if (a2 != null) {
                f8719t = (String) a2.invoke(N, new Object[0]);
            }
            if (f8719t == null) {
                f8719t = "";
            }
            return f8719t;
        } catch (Throwable unused) {
        }
    }

    public static String v(Context context) {
        return u(context) + "#" + a(context) + "#" + t(context);
    }

    public static String w(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String str = f8720u;
            if (str != null && !"".equals(str)) {
                return f8720u;
            }
            if (!b(context, fg.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return f8720u;
            }
            TelephonyManager N = N(context);
            if (N == null) {
                return "";
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Method a2 = fg.a((Class) N.getClass(), "QZ2V0TWVpZA==", (Class<?>[]) new Class[0]);
                if (a2 != null) {
                    f8720u = (String) a2.invoke(N, new Object[0]);
                }
                if (f8720u == null) {
                    f8720u = "";
                }
            }
            return f8720u;
        } catch (Throwable unused) {
        }
    }

    public static String x(Context context) {
        try {
            return I(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054 A[Catch:{ IOException -> 0x0057 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int y(android.content.Context r4) {
        /*
            int r0 = f8724y
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 16
            r2 = 0
            if (r0 < r1) goto L_0x0026
            java.lang.String r0 = "activity"
            java.lang.Object r4 = r4.getSystemService(r0)
            android.app.ActivityManager r4 = (android.app.ActivityManager) r4
            if (r4 != 0) goto L_0x0017
            return r2
        L_0x0017:
            android.app.ActivityManager$MemoryInfo r0 = new android.app.ActivityManager$MemoryInfo
            r0.<init>()
            r4.getMemoryInfo(r0)
            long r0 = r0.totalMem
            r2 = 1024(0x400, double:5.06E-321)
            long r0 = r0 / r2
            int r2 = (int) r0
            goto L_0x0057
        L_0x0026:
            r4 = 0
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0052 }
            java.lang.String r1 = "/proc/meminfo"
            r0.<init>(r1)     // Catch:{ all -> 0x0052 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0052 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x0052 }
            r3.<init>(r0)     // Catch:{ all -> 0x0052 }
            r1.<init>(r3)     // Catch:{ all -> 0x0052 }
            java.lang.String r4 = r1.readLine()     // Catch:{ all -> 0x0051 }
            java.lang.String r0 = "\\s+"
            java.lang.String[] r4 = r4.split(r0)     // Catch:{ all -> 0x0051 }
            r0 = 1
            r4 = r4[r0]     // Catch:{ all -> 0x0051 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0051 }
            int r2 = r4.intValue()     // Catch:{ all -> 0x0051 }
            r1.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x0057
        L_0x0051:
            r4 = r1
        L_0x0052:
            if (r4 == 0) goto L_0x0057
            r4.close()     // Catch:{ IOException -> 0x0057 }
        L_0x0057:
            int r2 = r2 / 1024
            f8724y = r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ez.y(android.content.Context):int");
    }

    static String z(Context context) {
        try {
            return J(context);
        } catch (Throwable unused) {
            return "";
        }
    }
}
