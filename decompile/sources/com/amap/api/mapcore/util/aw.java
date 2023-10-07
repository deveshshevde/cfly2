package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

@ge(a = "update_item", b = true)
public class aw extends az {

    /* renamed from: n  reason: collision with root package name */
    private String f7875n = "";

    /* renamed from: o  reason: collision with root package name */
    private Context f7876o;

    public aw() {
    }

    public aw(OfflineMapCity offlineMapCity, Context context) {
        this.f7876o = context;
        this.f7884a = offlineMapCity.getCity();
        this.f7886c = offlineMapCity.getAdcode();
        this.f7885b = offlineMapCity.getUrl();
        this.f7890g = offlineMapCity.getSize();
        this.f7888e = offlineMapCity.getVersion();
        this.f7894k = offlineMapCity.getCode();
        this.f7892i = 0;
        this.f7895l = offlineMapCity.getState();
        this.f7893j = offlineMapCity.getcompleteCode();
        this.f7896m = offlineMapCity.getPinyin();
        i();
    }

    public aw(OfflineMapProvince offlineMapProvince, Context context) {
        this.f7876o = context;
        this.f7884a = offlineMapProvince.getProvinceName();
        this.f7886c = offlineMapProvince.getProvinceCode();
        this.f7885b = offlineMapProvince.getUrl();
        this.f7890g = offlineMapProvince.getSize();
        this.f7888e = offlineMapProvince.getVersion();
        this.f7892i = 1;
        this.f7895l = offlineMapProvince.getState();
        this.f7893j = offlineMapProvince.getcompleteCode();
        this.f7896m = offlineMapProvince.getPinyin();
        i();
    }

    private static String a(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject != null && jSONObject.has(str) && !"[]".equals(jSONObject.getString(str))) ? jSONObject.optString(str).trim() : "";
    }

    private void i() {
        String c2 = dl.c(this.f7876o);
        this.f7887d = c2 + this.f7896m + ".zip.tmp";
    }

    public final String a() {
        return this.f7875n;
    }

    public final void a(String str) {
        this.f7875n = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c1 A[SYNTHETIC, Splitter:B:26:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cc A[SYNTHETIC, Splitter:B:32:0x00cc] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r7 = this;
            java.lang.String r0 = "UpdateItem"
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x00d5 }
            r2.<init>()     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "title"
            java.lang.String r4 = r7.f7884a     // Catch:{ all -> 0x00d5 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "code"
            java.lang.String r4 = r7.f7886c     // Catch:{ all -> 0x00d5 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "url"
            java.lang.String r4 = r7.f7885b     // Catch:{ all -> 0x00d5 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "fileName"
            java.lang.String r4 = r7.f7887d     // Catch:{ all -> 0x00d5 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "lLocalLength"
            long r4 = r7.f7889f     // Catch:{ all -> 0x00d5 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "lRemoteLength"
            long r4 = r7.f7890g     // Catch:{ all -> 0x00d5 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "mState"
            int r4 = r7.f7895l     // Catch:{ all -> 0x00d5 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "version"
            java.lang.String r4 = r7.f7888e     // Catch:{ all -> 0x00d5 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "localPath"
            java.lang.String r4 = r7.f7891h     // Catch:{ all -> 0x00d5 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = r7.f7875n     // Catch:{ all -> 0x00d5 }
            if (r3 == 0) goto L_0x0054
            java.lang.String r4 = "vMapFileNames"
            r2.put(r4, r3)     // Catch:{ all -> 0x00d5 }
        L_0x0054:
            java.lang.String r3 = "isSheng"
            int r4 = r7.f7892i     // Catch:{ all -> 0x00d5 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "mCompleteCode"
            int r4 = r7.f7893j     // Catch:{ all -> 0x00d5 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "mCityCode"
            java.lang.String r4 = r7.f7894k     // Catch:{ all -> 0x00d5 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "pinyin"
            java.lang.String r4 = r7.f7896m     // Catch:{ all -> 0x00d5 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "file"
            r1.put(r3, r2)     // Catch:{ all -> 0x00d5 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00d5 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r3.<init>()     // Catch:{ all -> 0x00d5 }
            java.lang.String r4 = r7.f7887d     // Catch:{ all -> 0x00d5 }
            r3.append(r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r4 = ".dt"
            r3.append(r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00d5 }
            r2.<init>(r3)     // Catch:{ all -> 0x00d5 }
            r2.delete()     // Catch:{ all -> 0x00d5 }
            r3 = 0
            java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x00b6 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00b6 }
            r6 = 1
            r5.<init>(r2, r6)     // Catch:{ IOException -> 0x00b6 }
            java.lang.String r2 = "utf-8"
            r4.<init>(r5, r2)     // Catch:{ IOException -> 0x00b6 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x00b1, all -> 0x00ae }
            r4.write(r1)     // Catch:{ IOException -> 0x00b1, all -> 0x00ae }
            r4.close()     // Catch:{ IOException -> 0x00a9 }
            goto L_0x00ad
        L_0x00a9:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x00d5 }
        L_0x00ad:
            return
        L_0x00ae:
            r1 = move-exception
            r3 = r4
            goto L_0x00ca
        L_0x00b1:
            r1 = move-exception
            r3 = r4
            goto L_0x00b7
        L_0x00b4:
            r1 = move-exception
            goto L_0x00ca
        L_0x00b6:
            r1 = move-exception
        L_0x00b7:
            java.lang.String r2 = "saveJSONObjectToFile"
            com.amap.api.mapcore.util.fz.c(r1, r0, r2)     // Catch:{ all -> 0x00b4 }
            r1.printStackTrace()     // Catch:{ all -> 0x00b4 }
            if (r3 == 0) goto L_0x00c9
            r3.close()     // Catch:{ IOException -> 0x00c5 }
            goto L_0x00c9
        L_0x00c5:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x00d5 }
        L_0x00c9:
            return
        L_0x00ca:
            if (r3 == 0) goto L_0x00d4
            r3.close()     // Catch:{ IOException -> 0x00d0 }
            goto L_0x00d4
        L_0x00d0:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x00d5 }
        L_0x00d4:
            throw r1     // Catch:{ all -> 0x00d5 }
        L_0x00d5:
            r1 = move-exception
            java.lang.String r2 = "saveJSONObjectToFile parseJson"
            com.amap.api.mapcore.util.fz.c(r1, r0, r2)
            r1.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.aw.b():void");
    }

    public final void b(String str) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("file");
                    if (jSONObject != null) {
                        this.f7884a = jSONObject.optString("title");
                        this.f7886c = jSONObject.optString("code");
                        this.f7885b = jSONObject.optString(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
                        this.f7887d = jSONObject.optString("fileName");
                        this.f7889f = jSONObject.optLong("lLocalLength");
                        this.f7890g = jSONObject.optLong("lRemoteLength");
                        this.f7895l = jSONObject.optInt("mState");
                        this.f7888e = jSONObject.optString("version");
                        this.f7891h = jSONObject.optString("localPath");
                        this.f7875n = jSONObject.optString("vMapFileNames");
                        this.f7892i = jSONObject.optInt("isSheng");
                        this.f7893j = jSONObject.optInt("mCompleteCode");
                        this.f7894k = jSONObject.optString("mCityCode");
                        this.f7896m = a(jSONObject, "pinyin");
                        if ("".equals(this.f7896m)) {
                            String substring = this.f7885b.substring(this.f7885b.lastIndexOf("/") + 1);
                            this.f7896m = substring.substring(0, substring.lastIndexOf("."));
                        }
                    }
                }
            } catch (Throwable th) {
                fz.c(th, "UpdateItem", "readFileToJSONObject");
                th.printStackTrace();
            }
        }
    }
}
