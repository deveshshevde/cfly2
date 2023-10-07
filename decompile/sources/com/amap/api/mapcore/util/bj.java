package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.xeagle.android.login.pickImage.data.GLImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class bj {
    public static long a() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return 0;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize());
    }

    public static long a(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j2 = 0;
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            j2 += file2.isDirectory() ? a(file2) : file2.length();
        }
        return j2;
    }

    private static OfflineMapProvince a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        offlineMapProvince.setUrl(a(jSONObject, IjkMediaPlayer.OnNativeInvokeListener.ARG_URL));
        offlineMapProvince.setProvinceName(a(jSONObject, "name"));
        offlineMapProvince.setJianpin(a(jSONObject, "jianpin"));
        offlineMapProvince.setPinyin(a(jSONObject, "pinyin"));
        offlineMapProvince.setProvinceCode(c(a(jSONObject, "adcode")));
        offlineMapProvince.setVersion(a(jSONObject, "version"));
        offlineMapProvince.setSize(Long.parseLong(a(jSONObject, GLImage.KEY_SIZE)));
        offlineMapProvince.setCityList(b(jSONObject));
        return offlineMapProvince;
    }

    public static String a(Context context, String str) {
        try {
            return dl.a(df.a(context).open(str));
        } catch (Throwable th) {
            fz.c(th, "MapDownloadManager", "readOfflineAsset");
            th.printStackTrace();
            return null;
        }
    }

    private static String a(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject != null && jSONObject.has(str) && !"[]".equals(jSONObject.getString(str))) ? jSONObject.optString(str).trim() : "";
    }

    public static List<OfflineMapProvince> a(String str, Context context) throws JSONException {
        return (str == null || "".equals(str)) ? new ArrayList() : a(new JSONObject(str), context);
    }

    public static List<OfflineMapProvince> a(JSONObject jSONObject, Context context) throws JSONException {
        JSONObject jSONObject2;
        JSONObject optJSONObject;
        ArrayList arrayList = new ArrayList();
        if (!jSONObject.has("result")) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("result", new JSONObject().put("offlinemap_with_province_vfour", jSONObject));
                c(jSONObject3.toString(), context);
                jSONObject2 = jSONObject3.optJSONObject("result");
            } catch (JSONException e2) {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("result");
                fz.c(e2, "Utility", "parseJson");
                e2.printStackTrace();
                jSONObject2 = optJSONObject2;
            }
        } else {
            jSONObject2 = jSONObject.optJSONObject("result");
        }
        if ((jSONObject2 != null && (jSONObject = jSONObject2.optJSONObject("offlinemap_with_province_vfour")) == null) || (optJSONObject = jSONObject.optJSONObject("offlinemapinfo_with_province")) == null) {
            return arrayList;
        }
        if (optJSONObject.has("version")) {
            am.f7832d = a(optJSONObject, "version");
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("provinces");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
            if (optJSONObject3 != null) {
                arrayList.add(a(optJSONObject3));
            }
        }
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("others");
        JSONObject jSONObject4 = null;
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            jSONObject4 = optJSONArray2.getJSONObject(0);
        }
        if (jSONObject4 == null) {
            return arrayList;
        }
        arrayList.add(a(jSONObject4));
        return arrayList;
    }

    public static void a(String str) {
        File[] listFiles;
        String[] list;
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.exists() && file2.isDirectory() && ((list = file2.list()) == null || list.length == 0)) {
                    file2.delete();
                }
            }
        }
    }

    public static String b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return str.substring(str.lastIndexOf("/") + 1, str.indexOf(".zip"));
            }
            return null;
        } catch (Throwable th) {
            fz.c(th, "Utility", "getZipFileNameFromUrl");
            return null;
        }
    }

    private static ArrayList<OfflineMapCity> b(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        if (optJSONArray == null) {
            return arrayList;
        }
        if (optJSONArray.length() == 0) {
            arrayList.add(c(jSONObject));
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                arrayList.add(c(optJSONObject));
            }
        }
        return arrayList;
    }

    public static void b(String str, Context context) throws IOException, Exception {
        File[] listFiles = new File(dl.c(context)).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.exists() && file.getName().contains(str)) {
                    b(file);
                }
            }
            a(dl.c(context));
        }
    }

    public static boolean b(File file) throws IOException, Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                if (listFiles[i2].isFile()) {
                    if (!listFiles[i2].delete()) {
                        return false;
                    }
                } else if (!b(listFiles[i2])) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private static OfflineMapCity c(JSONObject jSONObject) throws JSONException {
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        offlineMapCity.setAdcode(c(a(jSONObject, "adcode")));
        offlineMapCity.setUrl(a(jSONObject, IjkMediaPlayer.OnNativeInvokeListener.ARG_URL));
        offlineMapCity.setCity(a(jSONObject, "name"));
        offlineMapCity.setCode(a(jSONObject, "citycode"));
        offlineMapCity.setPinyin(a(jSONObject, "pinyin"));
        offlineMapCity.setJianpin(a(jSONObject, "jianpin"));
        offlineMapCity.setVersion(a(jSONObject, "version"));
        offlineMapCity.setSize(Long.parseLong(a(jSONObject, GLImage.KEY_SIZE)));
        return offlineMapCity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0054 A[SYNTHETIC, Splitter:B:34:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005e A[SYNTHETIC, Splitter:B:39:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0074 A[SYNTHETIC, Splitter:B:49:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x007e A[SYNTHETIC, Splitter:B:54:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0086 A[SYNTHETIC, Splitter:B:60:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0090 A[SYNTHETIC, Splitter:B:65:0x0090] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.io.File r6) {
        /*
            java.lang.String r0 = "MapDownloadManager"
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0067, IOException -> 0x0047, all -> 0x0044 }
            r3.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0067, IOException -> 0x0047, all -> 0x0044 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0041, IOException -> 0x003e, all -> 0x003c }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x0041, IOException -> 0x003e, all -> 0x003c }
            java.lang.String r5 = "utf-8"
            r4.<init>(r3, r5)     // Catch:{ FileNotFoundException -> 0x0041, IOException -> 0x003e, all -> 0x003c }
            r6.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0041, IOException -> 0x003e, all -> 0x003c }
        L_0x0019:
            java.lang.String r4 = r6.readLine()     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0038 }
            if (r4 == 0) goto L_0x0023
            r1.append(r4)     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0038 }
            goto L_0x0019
        L_0x0023:
            java.lang.String r0 = r1.toString()     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0038 }
            r6.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r6 = move-exception
            r6.printStackTrace()
        L_0x002f:
            r3.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0037:
            return r0
        L_0x0038:
            r1 = move-exception
            goto L_0x004a
        L_0x003a:
            r1 = move-exception
            goto L_0x006a
        L_0x003c:
            r0 = move-exception
            goto L_0x0084
        L_0x003e:
            r1 = move-exception
            r6 = r2
            goto L_0x004a
        L_0x0041:
            r1 = move-exception
            r6 = r2
            goto L_0x006a
        L_0x0044:
            r0 = move-exception
            r3 = r2
            goto L_0x0084
        L_0x0047:
            r1 = move-exception
            r6 = r2
            r3 = r6
        L_0x004a:
            java.lang.String r4 = "readOfflineSD io"
            com.amap.api.mapcore.util.fz.c(r1, r0, r4)     // Catch:{ all -> 0x0082 }
            r1.printStackTrace()     // Catch:{ all -> 0x0082 }
            if (r6 == 0) goto L_0x005c
            r6.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r6 = move-exception
            r6.printStackTrace()
        L_0x005c:
            if (r3 == 0) goto L_0x0081
            r3.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0081
        L_0x0062:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0081
        L_0x0067:
            r1 = move-exception
            r6 = r2
            r3 = r6
        L_0x006a:
            java.lang.String r4 = "readOfflineSD filenotfound"
            com.amap.api.mapcore.util.fz.c(r1, r0, r4)     // Catch:{ all -> 0x0082 }
            r1.printStackTrace()     // Catch:{ all -> 0x0082 }
            if (r6 == 0) goto L_0x007c
            r6.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x007c
        L_0x0078:
            r6 = move-exception
            r6.printStackTrace()
        L_0x007c:
            if (r3 == 0) goto L_0x0081
            r3.close()     // Catch:{ IOException -> 0x0062 }
        L_0x0081:
            return r2
        L_0x0082:
            r0 = move-exception
            r2 = r6
        L_0x0084:
            if (r2 == 0) goto L_0x008e
            r2.close()     // Catch:{ IOException -> 0x008a }
            goto L_0x008e
        L_0x008a:
            r6 = move-exception
            r6.printStackTrace()
        L_0x008e:
            if (r3 == 0) goto L_0x0098
            r3.close()     // Catch:{ IOException -> 0x0094 }
            goto L_0x0098
        L_0x0094:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0098:
            goto L_0x009a
        L_0x0099:
            throw r0
        L_0x009a:
            goto L_0x0099
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bj.c(java.io.File):java.lang.String");
    }

    private static String c(String str) {
        return "000001".equals(str) ? "100000" : str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0075 A[SYNTHETIC, Splitter:B:33:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0089 A[SYNTHETIC, Splitter:B:42:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0094 A[SYNTHETIC, Splitter:B:47:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(java.lang.String r6, android.content.Context r7) {
        /*
            java.lang.String r0 = com.amap.api.mapcore.util.dl.c((android.content.Context) r7)
            java.lang.String r1 = ""
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x000d
            return
        L_0x000d:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r7 = com.amap.api.mapcore.util.dl.c((android.content.Context) r7)
            r1.append(r7)
            java.lang.String r7 = "offlinemapv4.png"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            boolean r7 = r0.exists()
            java.lang.String r1 = "OfflineUpdateCityHandlerAbstract"
            if (r7 != 0) goto L_0x003c
            r0.createNewFile()     // Catch:{ IOException -> 0x0033 }
            goto L_0x003c
        L_0x0033:
            r7 = move-exception
            java.lang.String r2 = "writeSD dirCreate"
            com.amap.api.mapcore.util.fz.c(r7, r1, r2)
            r7.printStackTrace()
        L_0x003c:
            long r2 = a()
            r4 = 1048576(0x100000, double:5.180654E-318)
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x009d
            r7 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x007e, IOException -> 0x006a }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x007e, IOException -> 0x006a }
            java.lang.String r7 = "utf-8"
            byte[] r6 = r6.getBytes(r7)     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0062, all -> 0x005f }
            r2.write(r6)     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0062, all -> 0x005f }
            r2.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r6 = move-exception
            r6.printStackTrace()
        L_0x005e:
            return
        L_0x005f:
            r6 = move-exception
            r7 = r2
            goto L_0x0092
        L_0x0062:
            r6 = move-exception
            r7 = r2
            goto L_0x006b
        L_0x0065:
            r6 = move-exception
            r7 = r2
            goto L_0x007f
        L_0x0068:
            r6 = move-exception
            goto L_0x0092
        L_0x006a:
            r6 = move-exception
        L_0x006b:
            java.lang.String r0 = "writeSD io"
            com.amap.api.mapcore.util.fz.c(r6, r1, r0)     // Catch:{ all -> 0x0068 }
            r6.printStackTrace()     // Catch:{ all -> 0x0068 }
            if (r7 == 0) goto L_0x007d
            r7.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x0079:
            r6 = move-exception
            r6.printStackTrace()
        L_0x007d:
            return
        L_0x007e:
            r6 = move-exception
        L_0x007f:
            java.lang.String r0 = "writeSD filenotfound"
            com.amap.api.mapcore.util.fz.c(r6, r1, r0)     // Catch:{ all -> 0x0068 }
            r6.printStackTrace()     // Catch:{ all -> 0x0068 }
            if (r7 == 0) goto L_0x0091
            r7.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x0091
        L_0x008d:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0091:
            return
        L_0x0092:
            if (r7 == 0) goto L_0x009c
            r7.close()     // Catch:{ IOException -> 0x0098 }
            goto L_0x009c
        L_0x0098:
            r7 = move-exception
            r7.printStackTrace()
        L_0x009c:
            throw r6
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bj.c(java.lang.String, android.content.Context):void");
    }
}
