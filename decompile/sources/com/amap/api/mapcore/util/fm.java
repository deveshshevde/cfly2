package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore.util.ez;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class fm {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8790a = fg.c("SRFZHZUVZT3BOa0ZiemZRQQ");

    /* renamed from: b  reason: collision with root package name */
    private static final String f8791b = fg.c("FbGJzX3Nkaw");

    /* renamed from: c  reason: collision with root package name */
    private static final String f8792c = fg.c("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");

    /* renamed from: d  reason: collision with root package name */
    private static final String f8793d = fg.c("FQU5EU0RLMTA");

    /* renamed from: e  reason: collision with root package name */
    private static final String f8794e = fg.c("FMTAw");

    /* renamed from: f  reason: collision with root package name */
    private static boolean f8795f = false;

    /* renamed from: g  reason: collision with root package name */
    private String f8796g = "";

    public static ez.a a() {
        return new ez.a() {

            /* renamed from: a  reason: collision with root package name */
            private fm f8797a = new fm();

            public final hd a(byte[] bArr, Map<String, String> map) {
                return new gv(bArr, map);
            }

            public final String a() {
                return fm.c();
            }

            public final String a(Context context, String str) {
                return fm.a(context, str);
            }

            public final String a(String str, String str2, String str3, String str4) {
                return this.f8797a.a(str, str2, str3, str4);
            }

            public final Map<String, String> b() {
                return this.f8797a.b();
            }
        };
    }

    public static String a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(fg.c("UY29kZQ")) != 1) {
                return "";
            }
            String optString = new JSONObject(jSONObject.optString(fg.c("FZGF0YQ"))).optString(fg.c("FYWRpdQ"));
            if (TextUtils.isEmpty(optString)) {
                return "";
            }
            fn.a(optString);
            fi.a(context).a(optString);
            return optString;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String c() {
        return fn.a();
    }

    private String d() {
        if (!TextUtils.isEmpty(this.f8796g)) {
            return this.f8796g;
        }
        String a2 = fa.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < a2.length(); i2++) {
            stringBuffer.append((char) (a2.charAt(i2) - (i2 % 48)));
        }
        String stringBuffer2 = stringBuffer.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i3 = 0; i3 < stringBuffer2.length() / 2; i3++) {
            stringBuffer3.append((char) ((stringBuffer2.charAt(i3) + stringBuffer2.charAt((stringBuffer2.length() - 1) - i3)) / 2));
        }
        String stringBuffer4 = stringBuffer3.toString();
        this.f8796g = stringBuffer4;
        return stringBuffer4;
    }

    public final String a(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(fg.c("LdGlk"), str);
            jSONObject.put(fg.c("FZGl1"), str2);
            jSONObject.put(fg.c("AZGl1Mg"), str3);
            jSONObject.put(fg.c("EZGl1Mw"), str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        String a2 = fp.a();
        if (!TextUtils.isEmpty(a2)) {
            String a3 = fk.a(gm.a((jSONObject2 + "\u0000").getBytes(), a2.getBytes()));
            if (!TextUtils.isEmpty(a3)) {
                try {
                    String a4 = fk.a(fo.a(a2.getBytes("utf-8"), fo.a(d())));
                    return fg.c("Fa2V5PQ") + URLEncoder.encode(a4) + fg.c("SJmRhdGE9") + URLEncoder.encode(a3);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    public final synchronized Map<String, String> b() {
        if (f8795f) {
            return null;
        }
        f8795f = true;
        HashMap hashMap = new HashMap();
        hashMap.put(fg.c("FZW50"), fg.c("FMg"));
        StringBuilder sb = new StringBuilder();
        sb.append(fg.c("SY2hhbm5lbD0"));
        String str = f8791b;
        sb.append(str);
        sb.append(fg.c("SJmRpdj0"));
        String str2 = f8793d;
        sb.append(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(fg.c("FQA"));
        stringBuffer.append(f8792c);
        String a2 = fp.a(stringBuffer.toString());
        sb.append(fg.c("FJnNpZ249"));
        sb.append(a2.toUpperCase(Locale.US));
        sb.append(fg.c("SJm91dHB1dD1qc29u") + "\u0000");
        hashMap.put(fg.c("FaW4"), fk.a(gm.a(sb.toString().getBytes(), f8790a.getBytes())));
        hashMap.put(fg.c("Sa2V5dA"), f8794e);
        return hashMap;
    }
}
