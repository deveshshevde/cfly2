package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class cf extends en<String, a> {

    /* renamed from: j  reason: collision with root package name */
    private String f8133j;

    /* renamed from: k  reason: collision with root package name */
    private String f8134k = "1.0";

    /* renamed from: l  reason: collision with root package name */
    private String f8135l = "0";

    /* renamed from: m  reason: collision with root package name */
    private final String f8136m = "lastModified";

    /* renamed from: n  reason: collision with root package name */
    private boolean f8137n = false;

    /* renamed from: o  reason: collision with root package name */
    private String f8138o = null;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f8139a;

        /* renamed from: b  reason: collision with root package name */
        public int f8140b = -1;

        /* renamed from: c  reason: collision with root package name */
        public String f8141c = null;

        /* renamed from: d  reason: collision with root package name */
        public boolean f8142d = false;
    }

    public cf(Context context, String str) {
        super(context, str);
        this.f8542h = "/map/styles";
        this.f8543i = true;
    }

    public cf(Context context, String str, boolean z2) {
        super(context, str);
        this.f8137n = z2;
        if (z2) {
            this.f8542h = "/sdk/map/styles";
            this.isPostFlag = false;
        } else {
            this.f8542h = "/map/styles";
        }
        this.f8543i = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public a a(he heVar) throws em {
        List list;
        if (heVar == null) {
            return null;
        }
        a b2 = a(heVar.f9117a);
        b2.f8142d = b2.f8139a != null;
        if (heVar.f9118b == null || !heVar.f9118b.containsKey("lastModified") || (list = heVar.f9118b.get("lastModified")) == null || list.size() <= 0) {
            return b2;
        }
        b2.f8141c = (String) list.get(0);
        return b2;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public a a(byte[] bArr) throws em {
        a aVar = new a();
        aVar.f8139a = bArr;
        if (this.f8137n && bArr != null) {
            if (bArr.length == 0) {
                aVar.f8139a = null;
            } else if (aVar.f8139a.length <= 1024) {
                try {
                    if (new String(bArr, "utf-8").contains("errcode")) {
                        aVar.f8139a = null;
                    }
                } catch (Exception e2) {
                    fz.c(e2, "CustomStyleRequest", "loadData");
                }
            }
        }
        return aVar;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object a(String str) throws em {
        return null;
    }

    public final void b(String str) {
        this.f8138o = str;
    }

    /* access modifiers changed from: protected */
    public final String c() {
        return null;
    }

    public final void c(String str) {
        this.f8133j = str;
    }

    public final void d(String str) {
        this.f8135l = str;
    }

    public final String getIPV6URL() {
        return dl.a(getURL());
    }

    public final Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", ev.f(this.f8541g));
        if (!this.f8137n) {
            hashtable.put("output", "bin");
        } else {
            hashtable.put("sdkType", this.f8138o);
        }
        hashtable.put("styleid", this.f8133j);
        hashtable.put("protocol", this.f8134k);
        hashtable.put("ispublic", "1");
        hashtable.put("lastModified", this.f8135l);
        String a2 = ey.a();
        String a3 = ey.a(this.f8541g, a2, fg.b((Map<String, String>) hashtable));
        hashtable.put("ts", a2);
        hashtable.put("scode", a3);
        return hashtable;
    }

    public final Map<String, String> getRequestHead() {
        ff a2 = dl.a();
        String b2 = a2 != null ? a2.b() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", l.f9556c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{b2, "3dmap"}));
        hashtable.put("x-INFO", ey.a(this.f8541g));
        hashtable.put("key", ev.f(this.f8541g));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    public final String getURL() {
        return "http://restsdk.amap.com/v4" + this.f8542h;
    }

    public final boolean isSupportIPV6() {
        return true;
    }
}
