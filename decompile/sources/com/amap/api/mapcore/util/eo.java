package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class eo<T, V> extends en<T, V> {
    public eo(Context context, T t2) {
        super(context, t2);
    }

    /* access modifiers changed from: protected */
    public abstract V a(String str) throws em;

    /* access modifiers changed from: protected */
    public abstract String c();

    public byte[] getEntityBytes() {
        try {
            return c().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public Map<String, String> getParams() {
        return null;
    }

    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("Content-Type", " application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Trace 8.0.0");
        hashMap.put("x-INFO", ey.b(this.f8541g));
        hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{"8.0.0", "trace"}));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }
}
