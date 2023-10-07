package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.mapcore.util.ff;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public final class fg {

    /* renamed from: a  reason: collision with root package name */
    static String f8761a;

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f8762b = {"arm64-v8a", "x86_64"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f8763c = {"arm", "x86"};

    static {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 80; i2++) {
            sb.append("=");
        }
        f8761a = sb.toString();
    }

    public static ff a() throws eu {
        return new ff.a("collection", "1.0", "AMap_collection_1.0").a(new String[]{"com.amap.api.collection"}).a();
    }

    public static String a(long j2) {
        return a(j2, "yyyyMMdd HH:mm:ss:SSS");
    }

    public static String a(long j2, String str) {
        try {
            return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j2));
        } catch (Throwable th) {
            fw.a(th, "ut", "ctt");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r7) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            java.lang.String r2 = "ut"
            r3 = 28
            r4 = 21
            if (r0 < r4) goto L_0x0033
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 >= r3) goto L_0x0033
            android.content.pm.ApplicationInfo r0 = r7.getApplicationInfo()     // Catch:{ all -> 0x002d }
            java.lang.Class<android.content.pm.ApplicationInfo> r4 = android.content.pm.ApplicationInfo.class
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x002d }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x002d }
            java.lang.String r5 = "primaryCpuAbi"
            java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch:{ all -> 0x002d }
            r4.setAccessible(r1)     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r4.get(r0)     // Catch:{ all -> 0x002d }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x002d }
            goto L_0x0035
        L_0x002d:
            r0 = move-exception
            java.lang.String r4 = "gct"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r2, (java.lang.String) r4)
        L_0x0033:
            java.lang.String r0 = ""
        L_0x0035:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r3) goto L_0x00a6
            java.lang.Class<android.os.Build> r3 = android.os.Build.class
            java.lang.String r4 = "SUPPORTED_ABIS"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch:{ all -> 0x00a0 }
            r4 = 0
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x00a0 }
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ all -> 0x00a0 }
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ all -> 0x00a0 }
            r5 = 0
            if (r3 == 0) goto L_0x0052
            int r6 = r3.length     // Catch:{ all -> 0x00a0 }
            if (r6 <= 0) goto L_0x0052
            r0 = r3[r5]     // Catch:{ all -> 0x00a0 }
        L_0x0052:
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00a0 }
            if (r3 != 0) goto L_0x00a6
            java.lang.String[] r3 = f8762b     // Catch:{ all -> 0x00a0 }
            java.util.List r3 = java.util.Arrays.asList(r3)     // Catch:{ all -> 0x00a0 }
            boolean r3 = r3.contains(r0)     // Catch:{ all -> 0x00a0 }
            if (r3 == 0) goto L_0x00a6
            android.content.pm.ApplicationInfo r7 = r7.getApplicationInfo()     // Catch:{ all -> 0x00a0 }
            java.lang.String r7 = r7.nativeLibraryDir     // Catch:{ all -> 0x00a0 }
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00a0 }
            if (r3 != 0) goto L_0x00a6
            java.lang.String r3 = java.io.File.separator     // Catch:{ all -> 0x00a0 }
            int r3 = r7.lastIndexOf(r3)     // Catch:{ all -> 0x00a0 }
            int r3 = r3 + r1
            java.lang.String r7 = r7.substring(r3)     // Catch:{ all -> 0x00a0 }
            java.lang.String[] r1 = f8763c     // Catch:{ all -> 0x00a0 }
            java.util.List r1 = java.util.Arrays.asList(r1)     // Catch:{ all -> 0x00a0 }
            boolean r7 = r1.contains(r7)     // Catch:{ all -> 0x00a0 }
            if (r7 == 0) goto L_0x00a6
            java.lang.Class<android.os.Build> r7 = android.os.Build.class
            java.lang.String r1 = "SUPPORTED_32_BIT_ABIS"
            java.lang.reflect.Field r7 = r7.getDeclaredField(r1)     // Catch:{ all -> 0x00a0 }
            java.lang.Object r7 = r7.get(r4)     // Catch:{ all -> 0x00a0 }
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch:{ all -> 0x00a0 }
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch:{ all -> 0x00a0 }
            if (r7 == 0) goto L_0x00a6
            int r1 = r7.length     // Catch:{ all -> 0x00a0 }
            if (r1 <= 0) goto L_0x00a6
            r7 = r7[r5]     // Catch:{ all -> 0x00a0 }
            r0 = r7
            goto L_0x00a6
        L_0x00a0:
            r7 = move-exception
            java.lang.String r1 = "gct_p"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r7, (java.lang.String) r2, (java.lang.String) r1)
        L_0x00a6:
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 == 0) goto L_0x00ae
            java.lang.String r0 = android.os.Build.CPU_ABI
        L_0x00ae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.fg.a(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x003a A[SYNTHETIC, Splitter:B:28:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0044 A[SYNTHETIC, Splitter:B:33:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.Throwable r3) {
        /*
            r0 = 0
            java.io.StringWriter r1 = new java.io.StringWriter     // Catch:{ all -> 0x0032 }
            r1.<init>()     // Catch:{ all -> 0x0032 }
            java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch:{ all -> 0x002f }
            r2.<init>(r1)     // Catch:{ all -> 0x002f }
            r3.printStackTrace(r2)     // Catch:{ all -> 0x002d }
        L_0x000e:
            java.lang.Throwable r3 = r3.getCause()     // Catch:{ all -> 0x002d }
            if (r3 == 0) goto L_0x0018
            r3.printStackTrace(r2)     // Catch:{ all -> 0x002d }
            goto L_0x000e
        L_0x0018:
            java.lang.String r3 = r1.toString()     // Catch:{ all -> 0x002d }
            r1.close()     // Catch:{ all -> 0x0020 }
            goto L_0x0024
        L_0x0020:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0024:
            r2.close()     // Catch:{ all -> 0x0028 }
            goto L_0x002c
        L_0x0028:
            r0 = move-exception
            r0.printStackTrace()
        L_0x002c:
            return r3
        L_0x002d:
            r3 = move-exception
            goto L_0x0035
        L_0x002f:
            r3 = move-exception
            r2 = r0
            goto L_0x0035
        L_0x0032:
            r3 = move-exception
            r1 = r0
            r2 = r1
        L_0x0035:
            r3.printStackTrace()     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x0042
            r1.close()     // Catch:{ all -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0042:
            if (r2 == 0) goto L_0x004c
            r2.close()     // Catch:{ all -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r3 = move-exception
            r3.printStackTrace()
        L_0x004c:
            return r0
        L_0x004d:
            r3 = move-exception
            if (r1 == 0) goto L_0x0058
            r1.close()     // Catch:{ all -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0058:
            if (r2 == 0) goto L_0x0062
            r2.close()     // Catch:{ all -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0062:
            goto L_0x0064
        L_0x0063:
            throw r3
        L_0x0064:
            goto L_0x0063
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.fg.a(java.lang.Throwable):java.lang.String");
    }

    public static String a(Map<String, String> map) {
        Object value;
        if (map.size() == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z2 = true;
        try {
            for (Map.Entry next : map.entrySet()) {
                if (z2) {
                    z2 = false;
                    stringBuffer.append((String) next.getKey());
                    stringBuffer.append("=");
                    value = next.getValue();
                } else {
                    stringBuffer.append("&");
                    stringBuffer.append((String) next.getKey());
                    stringBuffer.append("=");
                    value = next.getValue();
                }
                stringBuffer.append((String) value);
            }
        } catch (Throwable th) {
            fw.a(th, "ut", "abP");
        }
        return stringBuffer.toString();
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static Method a(Class cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(c(str), clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Calendar a(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.CHINA);
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(simpleDateFormat.parse(str));
            instance.set(instance.get(1), instance.get(2), instance.get(5), instance2.get(11), instance2.get(12), instance2.get(13));
            return instance;
        } catch (ParseException e2) {
            fw.a((Throwable) e2, "ut", "ctt");
            return null;
        }
    }

    public static void a(Context context, String str, String str2, JSONObject jSONObject) {
        String str3;
        String str4;
        String str5;
        String str6 = "";
        String e2 = ev.e(context);
        String b2 = fd.b(e2);
        String a2 = ev.a(context);
        try {
            if (jSONObject.has("info")) {
                str5 = jSONObject.getString("info");
                str4 = "请在高德开放平台官网中搜索\"" + str5 + "\"相关内容进行解决";
            } else {
                str5 = str6;
                str4 = str5;
            }
            try {
                if ("INVALID_USER_SCODE".equals(str5)) {
                    String string = jSONObject.has("sec_code") ? jSONObject.getString("sec_code") : str6;
                    if (jSONObject.has("sec_code_debug")) {
                        str6 = jSONObject.getString("sec_code_debug");
                    }
                    if (b2.equals(string) || b2.equals(str6)) {
                        str3 = c("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5Lit5pCc57Si") + "\"请求内容过长导致业务调用失败\"相关内容进行解决";
                        Log.i("authErrLog", f8761a);
                        Log.i("authErrLog", "                                   鉴权错误信息                                  ");
                        Log.i("authErrLog", f8761a);
                        g("SHA1Package:".concat(String.valueOf(e2)));
                        g("key:".concat(String.valueOf(a2)));
                        g("csid:".concat(String.valueOf(str)));
                        g("gsid:".concat(String.valueOf(str2)));
                        g("json:" + jSONObject.toString());
                        Log.i("authErrLog", "                                                                               ");
                        Log.i("authErrLog", str3);
                        Log.i("authErrLog", f8761a);
                    }
                } else if ("INVALID_USER_KEY".equals(str5)) {
                    if (jSONObject.has("key")) {
                        str6 = jSONObject.getString("key");
                    }
                    if (str6.length() > 0 && !a2.equals(str6)) {
                        str4 = c("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5LiK5Y+R6LW35oqA5pyv5ZKo6K+i5bel5Y2V4oCUPui0puWPt+S4jktleemXrumimO+8jOWSqOivoklOVkFMSURfVVNFUl9LRVnlpoLkvZXop6PlhrM=");
                    }
                }
                str3 = str4;
            } catch (Throwable unused) {
                str6 = str4;
                str3 = str6;
                Log.i("authErrLog", f8761a);
                Log.i("authErrLog", "                                   鉴权错误信息                                  ");
                Log.i("authErrLog", f8761a);
                g("SHA1Package:".concat(String.valueOf(e2)));
                g("key:".concat(String.valueOf(a2)));
                g("csid:".concat(String.valueOf(str)));
                g("gsid:".concat(String.valueOf(str2)));
                g("json:" + jSONObject.toString());
                Log.i("authErrLog", "                                                                               ");
                Log.i("authErrLog", str3);
                Log.i("authErrLog", f8761a);
            }
        } catch (Throwable unused2) {
            str3 = str6;
            Log.i("authErrLog", f8761a);
            Log.i("authErrLog", "                                   鉴权错误信息                                  ");
            Log.i("authErrLog", f8761a);
            g("SHA1Package:".concat(String.valueOf(e2)));
            g("key:".concat(String.valueOf(a2)));
            g("csid:".concat(String.valueOf(str)));
            g("gsid:".concat(String.valueOf(str2)));
            g("json:" + jSONObject.toString());
            Log.i("authErrLog", "                                                                               ");
            Log.i("authErrLog", str3);
            Log.i("authErrLog", f8761a);
        }
        Log.i("authErrLog", f8761a);
        Log.i("authErrLog", "                                   鉴权错误信息                                  ");
        Log.i("authErrLog", f8761a);
        g("SHA1Package:".concat(String.valueOf(e2)));
        g("key:".concat(String.valueOf(a2)));
        g("csid:".concat(String.valueOf(str)));
        g("gsid:".concat(String.valueOf(str2)));
        g("json:" + jSONObject.toString());
        Log.i("authErrLog", "                                                                               ");
        Log.i("authErrLog", str3);
        Log.i("authErrLog", f8761a);
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, byte b2, byte[] bArr) {
        try {
            byteArrayOutputStream.write(new byte[]{b2});
            byte b3 = b2 & 255;
            if (b3 < 255 && b3 > 0) {
                byteArrayOutputStream.write(bArr);
            } else if (b3 == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (IOException e2) {
            fw.a((Throwable) e2, "ut", "wFie");
        }
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            try {
                byteArrayOutputStream.write(new byte[]{0});
            } catch (IOException e2) {
                fw.a((Throwable) e2, "ut", "wsf");
            }
        } else {
            int length = str.length();
            if (length > 255) {
                length = 255;
            }
            a(byteArrayOutputStream, (byte) length, a(str));
        }
    }

    public static boolean a(Context context, String str) {
        if (context == null || context.checkCallingOrSelfPermission(str) != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            try {
                if (((Integer) context.getClass().getMethod("checkSelfPermission", new Class[]{String.class}).invoke(context, new Object[]{str})).intValue() != 0) {
                    return false;
                }
            } catch (Throwable th) {
                fw.a(th, "ut", "cpm");
            }
        }
        return true;
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    public static byte[] a(int i2) {
        return new byte[]{(byte) (i2 / 256), (byte) (i2 % 256)};
    }

    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static ff b() throws eu {
        return new ff.a("co", "1.0.0", "AMap_co_1.0.0").a(new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}).a();
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        String c2 = fa.c(a(str));
        try {
            return ((char) ((c2.length() % 26) + 65)) + c2;
        } catch (Throwable th) {
            fw.a(th, "ut", "tsfb64");
            return "";
        }
    }

    public static String b(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append((String) next.getValue());
        }
        return d(sb.toString());
    }

    public static byte[] b(byte[] bArr) {
        try {
            return h(bArr);
        } catch (Throwable th) {
            fw.a(th, "ut", "gZp");
            return new byte[0];
        }
    }

    public static String c(String str) {
        return str.length() < 2 ? "" : fa.a(str.substring(1));
    }

    public static byte[] c() {
        try {
            String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");
            byte[] bArr = new byte[split.length];
            for (int i2 = 0; i2 < split.length; i2++) {
                bArr[i2] = Byte.parseByte(split[i2]);
            }
            String[] split2 = new StringBuffer(new String(fa.b(new String(bArr)))).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i3 = 0; i3 < split2.length; i3++) {
                bArr2[i3] = Byte.parseByte(split2[i3]);
            }
            return bArr2;
        } catch (Throwable th) {
            fw.a(th, "ut", "gIV");
            return new byte[16];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004f A[SYNTHETIC, Splitter:B:27:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0059 A[SYNTHETIC, Splitter:B:32:0x0059] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] c(byte[] r8) {
        /*
            java.lang.String r0 = "zp2"
            java.lang.String r1 = "zp1"
            java.lang.String r2 = "ut"
            r3 = 0
            if (r8 == 0) goto L_0x0073
            int r4 = r8.length
            if (r4 != 0) goto L_0x000e
            goto L_0x0073
        L_0x000e:
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0045 }
            r4.<init>()     // Catch:{ all -> 0x0045 }
            java.util.zip.ZipOutputStream r5 = new java.util.zip.ZipOutputStream     // Catch:{ all -> 0x0042 }
            r5.<init>(r4)     // Catch:{ all -> 0x0042 }
            java.util.zip.ZipEntry r6 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x0040 }
            java.lang.String r7 = "log"
            r6.<init>(r7)     // Catch:{ all -> 0x0040 }
            r5.putNextEntry(r6)     // Catch:{ all -> 0x0040 }
            r5.write(r8)     // Catch:{ all -> 0x0040 }
            r5.closeEntry()     // Catch:{ all -> 0x0040 }
            r5.finish()     // Catch:{ all -> 0x0040 }
            byte[] r3 = r4.toByteArray()     // Catch:{ all -> 0x0040 }
            r5.close()     // Catch:{ all -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r8 = move-exception
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r8, (java.lang.String) r2, (java.lang.String) r1)
        L_0x0037:
            r4.close()     // Catch:{ all -> 0x003b }
            goto L_0x005c
        L_0x003b:
            r8 = move-exception
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r8, (java.lang.String) r2, (java.lang.String) r0)
            goto L_0x005c
        L_0x0040:
            r8 = move-exception
            goto L_0x0048
        L_0x0042:
            r8 = move-exception
            r5 = r3
            goto L_0x0048
        L_0x0045:
            r8 = move-exception
            r4 = r3
            r5 = r4
        L_0x0048:
            java.lang.String r6 = "zp"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r8, (java.lang.String) r2, (java.lang.String) r6)     // Catch:{ all -> 0x005d }
            if (r5 == 0) goto L_0x0057
            r5.close()     // Catch:{ all -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r8 = move-exception
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r8, (java.lang.String) r2, (java.lang.String) r1)
        L_0x0057:
            if (r4 == 0) goto L_0x005c
            r4.close()     // Catch:{ all -> 0x003b }
        L_0x005c:
            return r3
        L_0x005d:
            r8 = move-exception
            if (r5 == 0) goto L_0x0068
            r5.close()     // Catch:{ all -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r3 = move-exception
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r3, (java.lang.String) r2, (java.lang.String) r1)
        L_0x0068:
            if (r4 == 0) goto L_0x0072
            r4.close()     // Catch:{ all -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r1 = move-exception
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r0)
        L_0x0072:
            throw r8
        L_0x0073:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.fg.c(byte[]):byte[]");
    }

    public static String d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String[] split = str.split("&");
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String append : split) {
                stringBuffer.append(append);
                stringBuffer.append("&");
            }
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2.length() > 1) {
                return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
            }
            return str;
        } catch (Throwable th) {
            fw.a(th, "ut", "sPa");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f A[SYNTHETIC, Splitter:B:24:0x004f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.security.PublicKey d() throws java.security.cert.CertificateException, java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.lang.NullPointerException, java.io.IOException {
        /*
            java.lang.String r0 = "MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="
            r1 = 0
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x004c }
            byte[] r0 = com.amap.api.mapcore.util.fa.b((java.lang.String) r0)     // Catch:{ all -> 0x004c }
            r2.<init>(r0)     // Catch:{ all -> 0x004c }
            java.lang.String r0 = "IWC41MDk"
            java.lang.String r0 = c((java.lang.String) r0)     // Catch:{ all -> 0x004d }
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)     // Catch:{ all -> 0x004d }
            java.lang.String r3 = "EUlNB"
            java.lang.String r3 = c((java.lang.String) r3)     // Catch:{ all -> 0x004d }
            java.security.KeyFactory r3 = java.security.KeyFactory.getInstance(r3)     // Catch:{ all -> 0x004d }
            java.security.cert.Certificate r0 = r0.generateCertificate(r2)     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0043
            if (r3 != 0) goto L_0x0029
            goto L_0x0043
        L_0x0029:
            java.security.spec.X509EncodedKeySpec r4 = new java.security.spec.X509EncodedKeySpec     // Catch:{ all -> 0x004d }
            java.security.PublicKey r0 = r0.getPublicKey()     // Catch:{ all -> 0x004d }
            byte[] r0 = r0.getEncoded()     // Catch:{ all -> 0x004d }
            r4.<init>(r0)     // Catch:{ all -> 0x004d }
            java.security.PublicKey r0 = r3.generatePublic(r4)     // Catch:{ all -> 0x004d }
            r2.close()     // Catch:{ all -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0042:
            return r0
        L_0x0043:
            r2.close()     // Catch:{ all -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004b:
            return r1
        L_0x004c:
            r2 = r1
        L_0x004d:
            if (r2 == 0) goto L_0x0057
            r2.close()     // Catch:{ all -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0057:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.fg.d():java.security.PublicKey");
    }

    public static byte[] d(byte[] bArr) {
        try {
            return h(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    static String e(byte[] bArr) {
        try {
            return g(bArr);
        } catch (Throwable th) {
            fw.a(th, "ut", "h2s");
            return null;
        }
    }

    public static byte[] e(String str) {
        if (str.length() % 2 != 0) {
            str = "0".concat(String.valueOf(str));
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
        }
        return bArr;
    }

    static String f(byte[] bArr) {
        try {
            return g(bArr);
        } catch (Throwable th) {
            fw.a(th, "ut", "csb2h");
            return null;
        }
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String a2 = fa.a(str);
            return a2.contains(Build.MODEL + Build.VERSION.SDK_INT);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String g(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = "0".concat(String.valueOf(hexString));
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static void g(String str) {
        int i2;
        while (true) {
            if (str.length() < 78) {
                break;
            }
            String substring = str.substring(0, 78);
            Log.i("authErrLog", "|" + substring + "|");
            str = str.substring(78);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        sb.append(str);
        for (i2 = 0; i2 < 78 - str.length(); i2++) {
            sb.append(" ");
        }
        sb.append("|");
        Log.i("authErrLog", sb.toString());
    }

    private static byte[] h(byte[] bArr) throws IOException, Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        if (bArr == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream2.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            throw th;
        }
    }
}
