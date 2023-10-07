package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.amap.api.mapcore.util.ew;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public final class j extends Thread {

    /* renamed from: a  reason: collision with root package name */
    WeakReference<IAMapDelegate> f9391a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f9392b;

    public j(Context context, IAMapDelegate iAMapDelegate) {
        this.f9392b = context;
        this.f9391a = new WeakReference<>(iAMapDelegate);
    }

    private Pair<JSONObject, ew.a.C0074a> a(StringBuilder sb) {
        String str;
        JSONObject jSONObject;
        ew.a.C0074a aVar;
        WeakReference<IAMapDelegate> weakReference;
        try {
            long longValue = db.a(this.f9392b, "cloud_config_pull", "cloud_config_pull_timestamp", (Long) 0L).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - longValue) >= 86400000) {
                str = sb.toString();
                str.replaceAll(";;", ";");
                db.a(this.f9392b, "cloud_config_pull", "cloud_config_pull_timestamp", (Object) new Long(currentTimeMillis));
            } else {
                str = "";
            }
            ew.a a2 = ew.a(this.f9392b, dl.a(), str, (Map<String, String>) null);
            if (!(ew.f8611a == 1 || str == "" || a2 == null || (weakReference = this.f9391a) == null || weakReference.get() == null)) {
                Message obtainMessage = ((IAMapDelegate) this.f9391a.get()).getMainHandler().obtainMessage();
                obtainMessage.what = 2;
                if (a2.f8643c != null) {
                    obtainMessage.obj = a2.f8643c;
                }
                ((IAMapDelegate) this.f9391a.get()).getMainHandler().sendMessage(obtainMessage);
            }
            String str2 = GLFileUtil.getCacheDir(this.f9392b).getAbsolutePath() + "/authCustomConfigName";
            if (TextUtils.isEmpty(str) || a2 == null || a2.f8646f == null) {
                jSONObject = new JSONObject(new String(GLFileUtil.readFileContents(str2)));
            } else {
                jSONObject = a2.f8646f;
                GLFileUtil.writeDatasToFile(str2, a2.f8646f.toString().getBytes());
            }
            String str3 = GLFileUtil.getCacheDir(this.f9392b).getAbsolutePath() + "/authLogConfigName";
            if (!TextUtils.isEmpty(str) && a2 != null) {
                if (a2.f8647g != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("IsExceptionUpdate", a2.f8647g.f8650a);
                    jSONObject2.put("mOfflineLoc", a2.f8647g.f8652c);
                    GLFileUtil.writeDatasToFile(str3, jSONObject2.toString().getBytes());
                    aVar = a2.f8647g;
                    return new Pair<>(jSONObject, aVar);
                }
            }
            byte[] readFileContents = GLFileUtil.readFileContents(str3);
            ew.a.C0074a aVar2 = new ew.a.C0074a();
            JSONObject jSONObject3 = new JSONObject(new String(readFileContents));
            aVar2.f8650a = jSONObject3.getBoolean("IsExceptionUpdate");
            if (jSONObject3.has("mOfflineLoc")) {
                aVar2.f8652c = jSONObject3.getJSONObject("mOfflineLoc");
            }
            aVar = aVar2;
            return new Pair<>(jSONObject, aVar);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void a(Context context, ff ffVar, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("16V");
                boolean a2 = ew.a(optJSONObject.optString("di", ""), false);
                String optString = optJSONObject.optString("dis", "");
                boolean a3 = ew.a(optJSONObject.optString("able", ""), false);
                boolean a4 = ew.a(optJSONObject.optString("isFilter", ""), true);
                if (!a2 || fg.f(optString)) {
                    gh.a(ffVar).a(context, a3, a4);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(ew.a.C0074a aVar) {
        if (aVar != null) {
            try {
                dh.a(this.f9392b, "maploc", "ue", Boolean.valueOf(aVar.f8650a));
                JSONObject jSONObject = aVar.f8652c;
                int optInt = jSONObject.optInt("fn", 1000);
                int optInt2 = jSONObject.optInt("mpn", 0);
                if (optInt2 > 500) {
                    optInt2 = 500;
                }
                if (optInt2 < 30) {
                    optInt2 = 30;
                }
                hk.a(optInt, ew.a(jSONObject.optString("igu"), false));
                dh.a(this.f9392b, "maploc", "opn", Integer.valueOf(optInt2));
            } catch (Throwable th) {
                fz.c(th, "AuthUtil", "loadConfigDataUploadException");
            }
        }
    }

    private static void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                dn.a(jSONObject.optJSONObject("17E"));
            } catch (Throwable unused) {
            }
        }
    }

    private static void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("16G");
                boolean a2 = ew.a(optJSONObject.optString("able", ""), false);
                boolean a3 = ew.a(optJSONObject.optString("removeCache", ""), false);
                boolean a4 = ew.a(optJSONObject.optString("uploadInfo", ""), false);
                dc.a(a2);
                dc.b(a3);
                dc.c(a4);
            } catch (Throwable unused) {
            }
        }
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean z2 = false;
                boolean a2 = ew.a(jSONObject.optJSONObject("17W").optString("able", ""), false);
                Context context = this.f9392b;
                if (!a2) {
                    z2 = true;
                }
                db.a(context, "amap_param", "overlay_use_old_type", (Object) Boolean.valueOf(z2));
            } catch (Throwable unused) {
            }
        }
    }

    public final void interrupt() {
        super.interrupt();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(22:5|6|7|(2:11|(2:13|(3:15|(1:18)|17)))|19|20|21|(3:23|24|(5:30|31|(2:33|34)|35|(1:37)))|(1:43)|(1:45)|(3:47|48|(4:56|(1:58)|59|(1:65)))|69|(3:73|74|(2:78|(3:82|(1:84)(1:85)|86)))|(1:95)|(1:99)|(1:105)|(3:107|108|(2:114|(1:116)))|(3:119|120|(1:122))|(1:126)|(1:130)|131|(1:141)(2:135|139)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x00b6 */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0237 A[SYNTHETIC, Splitter:B:107:0x0237] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0260 A[SYNTHETIC, Splitter:B:119:0x0260] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x029b A[Catch:{ all -> 0x017c, all -> 0x02a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00bf A[SYNTHETIC, Splitter:B:23:0x00bf] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010e A[Catch:{ all -> 0x017c, all -> 0x02a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0117 A[SYNTHETIC, Splitter:B:47:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01b3 A[Catch:{ all -> 0x01b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01b4 A[Catch:{ all -> 0x01b9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r14 = this;
            java.lang.String r0 = "time"
            java.lang.String r1 = "si"
            java.lang.String r2 = "mc"
            java.lang.String r3 = "15C"
            java.lang.String r4 = "156"
            java.lang.String r5 = "154"
            java.lang.String r6 = "14L"
            java.lang.String r7 = "14M"
            java.lang.String r8 = ";"
            boolean r9 = com.amap.api.maps.MapsInitializer.getNetWorkEnable()     // Catch:{ all -> 0x02a7 }
            if (r9 != 0) goto L_0x0019
            return
        L_0x0019:
            com.amap.api.mapcore.util.fb r9 = com.amap.api.mapcore.util.fb.a()     // Catch:{ all -> 0x02a7 }
            android.content.Context r10 = r14.f9392b     // Catch:{ all -> 0x02a7 }
            r9.a((android.content.Context) r10)     // Catch:{ all -> 0x02a7 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a7 }
            r9.<init>()     // Catch:{ all -> 0x02a7 }
            java.lang.String r10 = "14S"
            r9.append(r10)     // Catch:{ all -> 0x02a7 }
            r9.append(r8)     // Catch:{ all -> 0x02a7 }
            java.lang.String r10 = "11K"
            r9.append(r10)     // Catch:{ all -> 0x02a7 }
            r9.append(r8)     // Catch:{ all -> 0x02a7 }
            java.lang.String r10 = "001"
            r9.append(r10)     // Catch:{ all -> 0x02a7 }
            r9.append(r8)     // Catch:{ all -> 0x02a7 }
            r9.append(r7)     // Catch:{ all -> 0x02a7 }
            r9.append(r8)     // Catch:{ all -> 0x02a7 }
            r9.append(r6)     // Catch:{ all -> 0x02a7 }
            r9.append(r8)     // Catch:{ all -> 0x02a7 }
            java.lang.String r10 = "16V"
            r9.append(r10)     // Catch:{ all -> 0x02a7 }
            r9.append(r8)     // Catch:{ all -> 0x02a7 }
            java.lang.String r10 = "14Z"
            r9.append(r10)     // Catch:{ all -> 0x02a7 }
            r9.append(r8)     // Catch:{ all -> 0x02a7 }
            r9.append(r5)     // Catch:{ all -> 0x02a7 }
            r9.append(r8)     // Catch:{ all -> 0x02a7 }
            r9.append(r4)     // Catch:{ all -> 0x02a7 }
            r9.append(r8)     // Catch:{ all -> 0x02a7 }
            r9.append(r3)     // Catch:{ all -> 0x02a7 }
            r9.append(r8)     // Catch:{ all -> 0x02a7 }
            java.lang.String r10 = "16G"
            r9.append(r10)     // Catch:{ all -> 0x02a7 }
            r9.append(r8)     // Catch:{ all -> 0x02a7 }
            java.lang.String r10 = "17W"
            r9.append(r10)     // Catch:{ all -> 0x02a7 }
            r9.append(r8)     // Catch:{ all -> 0x02a7 }
            java.lang.String r10 = "17E"
            r9.append(r10)     // Catch:{ all -> 0x02a7 }
            java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> r10 = r14.f9391a     // Catch:{ all -> 0x00b6 }
            if (r10 == 0) goto L_0x00b6
            java.lang.Object r10 = r10.get()     // Catch:{ all -> 0x00b6 }
            if (r10 == 0) goto L_0x00b6
            java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> r10 = r14.f9391a     // Catch:{ all -> 0x00b6 }
            java.lang.Object r10 = r10.get()     // Catch:{ all -> 0x00b6 }
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r10 = (com.autonavi.base.amap.api.mapcore.IAMapDelegate) r10     // Catch:{ all -> 0x00b6 }
            com.autonavi.extra.b r11 = r10.getAMapExtraInterfaceManager()     // Catch:{ all -> 0x00b6 }
            if (r11 == 0) goto L_0x00b6
            com.autonavi.extra.b r10 = r10.getAMapExtraInterfaceManager()     // Catch:{ all -> 0x00b6 }
            java.lang.String r10 = r10.g()     // Catch:{ all -> 0x00b6 }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x00b6 }
            if (r11 != 0) goto L_0x00b6
            int r11 = r10.indexOf(r8)     // Catch:{ all -> 0x00b6 }
            if (r11 != 0) goto L_0x00b2
        L_0x00ae:
            r9.append(r10)     // Catch:{ all -> 0x00b6 }
            goto L_0x00b6
        L_0x00b2:
            r9.append(r8)     // Catch:{ all -> 0x00b6 }
            goto L_0x00ae
        L_0x00b6:
            android.util.Pair r10 = r14.a((java.lang.StringBuilder) r9)     // Catch:{ all -> 0x02a7 }
            r8 = 1
            java.lang.String r9 = "able"
            if (r10 == 0) goto L_0x00f7
            java.lang.Object r11 = r10.first     // Catch:{ all -> 0x02a7 }
            if (r11 == 0) goto L_0x00f7
            java.lang.Object r11 = r10.first     // Catch:{ all -> 0x02a7 }
            org.json.JSONObject r11 = (org.json.JSONObject) r11     // Catch:{ all -> 0x02a7 }
            org.json.JSONObject r5 = r11.optJSONObject(r5)     // Catch:{ all -> 0x02a7 }
            if (r5 == 0) goto L_0x00f7
            java.lang.String r11 = r5.getString(r9)     // Catch:{ all -> 0x02a7 }
            boolean r11 = com.amap.api.mapcore.util.ew.a((java.lang.String) r11, (boolean) r8)     // Catch:{ all -> 0x02a7 }
            if (r11 == 0) goto L_0x00f7
            java.lang.String r11 = r5.optString(r2)     // Catch:{ all -> 0x02a7 }
            java.lang.String r5 = r5.optString(r1)     // Catch:{ all -> 0x02a7 }
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x02a7 }
            java.lang.String r13 = "approval_number"
            if (r12 != 0) goto L_0x00ec
            android.content.Context r12 = r14.f9392b     // Catch:{ all -> 0x02a7 }
            com.amap.api.mapcore.util.db.a((android.content.Context) r12, (java.lang.String) r13, (java.lang.String) r2, (java.lang.Object) r11)     // Catch:{ all -> 0x02a7 }
        L_0x00ec:
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x02a7 }
            if (r2 != 0) goto L_0x00f7
            android.content.Context r2 = r14.f9392b     // Catch:{ all -> 0x02a7 }
            com.amap.api.mapcore.util.db.a((android.content.Context) r2, (java.lang.String) r13, (java.lang.String) r1, (java.lang.Object) r5)     // Catch:{ all -> 0x02a7 }
        L_0x00f7:
            if (r10 == 0) goto L_0x010c
            java.lang.Object r1 = r10.second     // Catch:{ all -> 0x02a7 }
            if (r1 == 0) goto L_0x010c
            com.amap.api.mapcore.util.ff r1 = com.amap.api.mapcore.util.dl.a()     // Catch:{ all -> 0x02a7 }
            if (r1 == 0) goto L_0x010c
            java.lang.Object r2 = r10.second     // Catch:{ all -> 0x02a7 }
            com.amap.api.mapcore.util.ew$a$a r2 = (com.amap.api.mapcore.util.ew.a.C0074a) r2     // Catch:{ all -> 0x02a7 }
            boolean r2 = r2.f8650a     // Catch:{ all -> 0x02a7 }
            r1.a((boolean) r2)     // Catch:{ all -> 0x02a7 }
        L_0x010c:
            if (r10 == 0) goto L_0x0115
            java.lang.Object r1 = r10.second     // Catch:{ all -> 0x02a7 }
            com.amap.api.mapcore.util.ew$a$a r1 = (com.amap.api.mapcore.util.ew.a.C0074a) r1     // Catch:{ all -> 0x02a7 }
            r14.a((com.amap.api.mapcore.util.ew.a.C0074a) r1)     // Catch:{ all -> 0x02a7 }
        L_0x0115:
            if (r10 == 0) goto L_0x0180
            java.lang.Object r1 = r10.first     // Catch:{ all -> 0x017c }
            if (r1 == 0) goto L_0x0180
            java.lang.Object r1 = r10.first     // Catch:{ all -> 0x017c }
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ all -> 0x017c }
            org.json.JSONObject r1 = r1.optJSONObject(r7)     // Catch:{ all -> 0x017c }
            if (r1 == 0) goto L_0x0180
            boolean r2 = r1.has(r9)     // Catch:{ all -> 0x017c }
            if (r2 == 0) goto L_0x0180
            java.lang.String r2 = r1.getString(r9)     // Catch:{ all -> 0x017c }
            boolean r2 = com.amap.api.mapcore.util.ew.a((java.lang.String) r2, (boolean) r8)     // Catch:{ all -> 0x017c }
            if (r2 == 0) goto L_0x0180
            r2 = 2592000(0x278d00, float:3.632166E-39)
            boolean r5 = r1.has(r0)     // Catch:{ all -> 0x017c }
            if (r5 == 0) goto L_0x0148
            int r1 = r1.getInt(r0)     // Catch:{ all -> 0x017c }
            r2 = 60
            int r2 = java.lang.Math.max(r2, r1)     // Catch:{ all -> 0x017c }
        L_0x0148:
            android.content.Context r1 = r14.f9392b     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Map3DCache"
            r11 = 0
            java.lang.Long r7 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x017c }
            java.lang.Long r0 = com.amap.api.mapcore.util.db.a((android.content.Context) r1, (java.lang.String) r5, (java.lang.String) r0, (java.lang.Long) r7)     // Catch:{ all -> 0x017c }
            long r0 = r0.longValue()     // Catch:{ all -> 0x017c }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x017c }
            long r11 = r11 - r0
            int r2 = r2 * 1000
            long r0 = (long) r2     // Catch:{ all -> 0x017c }
            int r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0180
            java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> r0 = r14.f9391a     // Catch:{ all -> 0x017c }
            if (r0 == 0) goto L_0x0180
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x017c }
            if (r0 == 0) goto L_0x0180
            java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> r0 = r14.f9391a     // Catch:{ all -> 0x017c }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x017c }
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r0 = (com.autonavi.base.amap.api.mapcore.IAMapDelegate) r0     // Catch:{ all -> 0x017c }
            r0.clearTileCache()     // Catch:{ all -> 0x017c }
            goto L_0x0180
        L_0x017c:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x02a7 }
        L_0x0180:
            r11 = 0
            if (r10 == 0) goto L_0x01bd
            java.lang.Object r0 = r10.first     // Catch:{ all -> 0x02a7 }
            if (r0 == 0) goto L_0x01bd
            java.lang.Object r0 = r10.first     // Catch:{ all -> 0x01b9 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x01b9 }
            org.json.JSONObject r0 = r0.optJSONObject(r6)     // Catch:{ all -> 0x01b9 }
            if (r0 == 0) goto L_0x01bd
            boolean r1 = r0.has(r9)     // Catch:{ all -> 0x01b9 }
            if (r1 == 0) goto L_0x01bd
            java.lang.String r0 = r0.getString(r9)     // Catch:{ all -> 0x01b9 }
            boolean r0 = com.amap.api.mapcore.util.ew.a((java.lang.String) r0, (boolean) r11)     // Catch:{ all -> 0x01b9 }
            java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> r1 = r14.f9391a     // Catch:{ all -> 0x01b9 }
            if (r1 == 0) goto L_0x01bd
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x01b9 }
            if (r1 == 0) goto L_0x01bd
            java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> r1 = r14.f9391a     // Catch:{ all -> 0x01b9 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x01b9 }
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r1 = (com.autonavi.base.amap.api.mapcore.IAMapDelegate) r1     // Catch:{ all -> 0x01b9 }
            if (r0 != 0) goto L_0x01b4
            goto L_0x01b5
        L_0x01b4:
            r8 = 0
        L_0x01b5:
            r1.setHideLogoEnble(r8)     // Catch:{ all -> 0x01b9 }
            goto L_0x01bd
        L_0x01b9:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x02a7 }
        L_0x01bd:
            if (r10 == 0) goto L_0x01d8
            java.lang.Object r0 = r10.first     // Catch:{ all -> 0x02a7 }
            if (r0 == 0) goto L_0x01d8
            java.lang.Object r0 = r10.first     // Catch:{ all -> 0x02a7 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x02a7 }
            org.json.JSONObject r0 = r0.optJSONObject(r4)     // Catch:{ all -> 0x02a7 }
            if (r0 == 0) goto L_0x01d8
            java.lang.String r0 = r0.optString(r9)     // Catch:{ all -> 0x02a7 }
            boolean r0 = com.amap.api.mapcore.util.ew.a((java.lang.String) r0, (boolean) r11)     // Catch:{ all -> 0x02a7 }
            com.amap.api.mapcore.util.cz.a((boolean) r0)     // Catch:{ all -> 0x02a7 }
        L_0x01d8:
            if (r10 == 0) goto L_0x01eb
            java.lang.Object r0 = r10.first     // Catch:{ all -> 0x02a7 }
            if (r0 == 0) goto L_0x01eb
            android.content.Context r0 = r14.f9392b     // Catch:{ all -> 0x02a7 }
            com.amap.api.mapcore.util.ff r1 = com.amap.api.mapcore.util.dl.a()     // Catch:{ all -> 0x02a7 }
            java.lang.Object r2 = r10.first     // Catch:{ all -> 0x02a7 }
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ all -> 0x02a7 }
            a(r0, r1, r2)     // Catch:{ all -> 0x02a7 }
        L_0x01eb:
            if (r10 == 0) goto L_0x0235
            java.lang.Object r0 = r10.first     // Catch:{ all -> 0x02a7 }
            if (r0 == 0) goto L_0x0235
            java.lang.Object r0 = r10.first     // Catch:{ all -> 0x02a7 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x02a7 }
            org.json.JSONObject r0 = r0.optJSONObject(r3)     // Catch:{ all -> 0x02a7 }
            if (r0 == 0) goto L_0x0235
            java.lang.String r1 = r0.optString(r9)     // Catch:{ all -> 0x02a7 }
            boolean r5 = com.amap.api.mapcore.util.ew.a((java.lang.String) r1, (boolean) r11)     // Catch:{ all -> 0x02a7 }
            java.lang.String r1 = "logo_day_url"
            java.lang.String r4 = r0.optString(r1)     // Catch:{ all -> 0x02a7 }
            java.lang.String r1 = "logo_day_md5"
            java.lang.String r3 = r0.optString(r1)     // Catch:{ all -> 0x02a7 }
            java.lang.String r1 = "logo_night_url"
            java.lang.String r8 = r0.optString(r1)     // Catch:{ all -> 0x02a7 }
            java.lang.String r1 = "logo_night_md5"
            java.lang.String r7 = r0.optString(r1)     // Catch:{ all -> 0x02a7 }
            java.lang.String r1 = "logo_day_ipv6_url"
            java.lang.String r6 = r0.optString(r1)     // Catch:{ all -> 0x02a7 }
            java.lang.String r1 = "logo_night_ipv6_url"
            java.lang.String r9 = r0.optString(r1)     // Catch:{ all -> 0x02a7 }
            com.amap.api.mapcore.util.dj r0 = com.amap.api.mapcore.util.dj.a()     // Catch:{ all -> 0x02a7 }
            com.amap.api.mapcore.util.j$1 r12 = new com.amap.api.mapcore.util.j$1     // Catch:{ all -> 0x02a7 }
            r1 = r12
            r2 = r14
            r1.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x02a7 }
            r0.a(r12)     // Catch:{ all -> 0x02a7 }
        L_0x0235:
            if (r10 == 0) goto L_0x025e
            java.lang.Object r0 = r10.first     // Catch:{ all -> 0x025d }
            if (r0 == 0) goto L_0x025e
            java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> r0 = r14.f9391a     // Catch:{ all -> 0x025d }
            if (r0 == 0) goto L_0x025e
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x025d }
            if (r0 == 0) goto L_0x025e
            java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> r0 = r14.f9391a     // Catch:{ all -> 0x025d }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x025d }
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r0 = (com.autonavi.base.amap.api.mapcore.IAMapDelegate) r0     // Catch:{ all -> 0x025d }
            com.autonavi.extra.b r1 = r0.getAMapExtraInterfaceManager()     // Catch:{ all -> 0x025d }
            if (r1 == 0) goto L_0x025e
            com.autonavi.extra.b r0 = r0.getAMapExtraInterfaceManager()     // Catch:{ all -> 0x025d }
            java.lang.Object r1 = r10.first     // Catch:{ all -> 0x025d }
            r0.h()     // Catch:{ all -> 0x025d }
            goto L_0x025e
        L_0x025d:
        L_0x025e:
            if (r10 == 0) goto L_0x026b
            java.lang.Object r0 = r10.first     // Catch:{ all -> 0x02a7 }
            if (r0 == 0) goto L_0x026b
            java.lang.Object r0 = r10.first     // Catch:{ all -> 0x02a7 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x02a7 }
            b(r0)     // Catch:{ all -> 0x02a7 }
        L_0x026b:
            if (r10 == 0) goto L_0x0278
            java.lang.Object r0 = r10.first     // Catch:{ all -> 0x02a7 }
            if (r0 == 0) goto L_0x0278
            java.lang.Object r0 = r10.first     // Catch:{ all -> 0x02a7 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x02a7 }
            r14.c(r0)     // Catch:{ all -> 0x02a7 }
        L_0x0278:
            if (r10 == 0) goto L_0x0285
            java.lang.Object r0 = r10.first     // Catch:{ all -> 0x02a7 }
            if (r0 == 0) goto L_0x0285
            java.lang.Object r0 = r10.first     // Catch:{ all -> 0x02a7 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x02a7 }
            a((org.json.JSONObject) r0)     // Catch:{ all -> 0x02a7 }
        L_0x0285:
            android.content.Context r0 = r14.f9392b     // Catch:{ all -> 0x02a7 }
            com.amap.api.mapcore.util.ff r1 = com.amap.api.mapcore.util.dl.a()     // Catch:{ all -> 0x02a7 }
            com.amap.api.mapcore.util.fz.a((android.content.Context) r0, (com.amap.api.mapcore.util.ff) r1)     // Catch:{ all -> 0x02a7 }
            r14.interrupt()     // Catch:{ all -> 0x02a7 }
            java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> r0 = r14.f9391a     // Catch:{ all -> 0x02a7 }
            if (r0 == 0) goto L_0x02a6
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x02a7 }
            if (r0 == 0) goto L_0x02a6
            java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> r0 = r14.f9391a     // Catch:{ all -> 0x02a7 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x02a7 }
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r0 = (com.autonavi.base.amap.api.mapcore.IAMapDelegate) r0     // Catch:{ all -> 0x02a7 }
            r0.setRunLowFrame(r11)     // Catch:{ all -> 0x02a7 }
        L_0x02a6:
            return
        L_0x02a7:
            r0 = move-exception
            r14.interrupt()
            java.lang.String r1 = "AMapDelegateImpGLSurfaceView"
            java.lang.String r2 = "mVerfy"
            com.amap.api.mapcore.util.fz.c(r0, r1, r2)
            r0.printStackTrace()
            java.lang.String r1 = com.amap.api.mapcore.util.dm.f8271e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "auth exception "
            r2.<init>(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.amap.api.mapcore.util.dn.b(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.j.run():void");
    }
}
