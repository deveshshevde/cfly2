package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

public final class i extends en<String, a> {

    /* renamed from: j  reason: collision with root package name */
    private boolean f9190j = true;

    /* renamed from: k  reason: collision with root package name */
    private int[] f9191k = {10000, 0, 10018, 10019, 10020, 10021, 10022, 10023};

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f9192a = -1;

        /* renamed from: b  reason: collision with root package name */
        public String f9193b;

        /* renamed from: c  reason: collision with root package name */
        public String f9194c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f9195d = false;
    }

    public i(Context context, String str) {
        super(context, str);
        this.f8542h = "/feedback";
        this.isPostFlag = false;
        this.f9190j = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public a a(String str) throws em {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i2 = -1;
            String str3 = "";
            if (jSONObject.has("errcode")) {
                i2 = jSONObject.optInt("errcode");
                str3 = jSONObject.optString("errmsg");
                str2 = jSONObject.optString("errdetail");
            } else {
                str2 = str3;
            }
            a aVar = new a();
            aVar.f9192a = i2;
            aVar.f9193b = str3;
            aVar.f9194c = str2;
            int i3 = 0;
            aVar.f9195d = false;
            int[] iArr = this.f9191k;
            int length = iArr.length;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (iArr[i3] == i2) {
                    aVar.f9195d = true;
                    break;
                } else {
                    i3++;
                }
            }
            return aVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final String c() {
        return null;
    }

    public final String getIPV6URL() {
        return dl.a(getURL());
    }

    public final Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", ev.f(this.f8541g));
        if (this.f9190j) {
            hashtable.put("pname", "3dmap");
        }
        String a2 = ey.a();
        String a3 = ey.a(this.f8541g, a2, fg.b((Map<String, String>) hashtable));
        hashtable.put("ts", a2);
        hashtable.put("scode", a3);
        return hashtable;
    }

    public final String getURL() {
        return "http://restsdk.amap.com/v4" + this.f8542h;
    }

    public final boolean isSupportIPV6() {
        return true;
    }
}
