package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class fq {

    /* renamed from: a  reason: collision with root package name */
    public static int f8803a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f8804b = 2;

    /* renamed from: c  reason: collision with root package name */
    private String f8805c;

    /* renamed from: d  reason: collision with root package name */
    private int f8806d;

    /* renamed from: e  reason: collision with root package name */
    private long f8807e = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    private String f8808f;

    private fq(int i2, String str, String str2) {
        this.f8805c = str2;
        this.f8806d = i2;
        this.f8808f = str;
    }

    public static fq a(String str, String str2) {
        return new fq(f8803a, str, str2);
    }

    public static String a(int i2) {
        return i2 == f8804b ? IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR : "info";
    }

    public static String a(List<fq> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (fq b2 : list) {
                        String b3 = b(b2);
                        if (!TextUtils.isEmpty(b3)) {
                            jSONArray.put(b3);
                        }
                    }
                    return jSONArray.toString();
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static boolean a(fq fqVar) {
        return fqVar != null && !TextUtils.isEmpty(fqVar.b());
    }

    public static fq b(String str, String str2) {
        return new fq(f8804b, str, str2);
    }

    private static String b(fq fqVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("info", fqVar.b());
            jSONObject.put("session", fqVar.d());
            jSONObject.put("timestamp", fqVar.f8807e);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    private String d() {
        return this.f8808f;
    }

    public final int a() {
        return this.f8806d;
    }

    public final String b() {
        new JSONObject();
        return this.f8805c;
    }

    public final String c() {
        return a(this.f8806d);
    }
}
