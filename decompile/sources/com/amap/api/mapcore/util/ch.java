package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public final class ch extends en<String, a> {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f8151a;

        /* renamed from: b  reason: collision with root package name */
        public int f8152b = -1;
    }

    public ch(Context context, String str) {
        super(context, str);
        this.f8542h = "/map/styles";
    }

    private static a b(byte[] bArr) throws em {
        a aVar = new a();
        aVar.f8151a = bArr;
        return aVar;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object a(String str) throws em {
        return null;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object a(byte[] bArr) throws em {
        return b(bArr);
    }

    public final void b(String str) {
        this.f8542h = str;
    }

    /* access modifiers changed from: protected */
    public final String c() {
        return null;
    }

    public final String getIPV6URL() {
        return dl.a(getURL());
    }

    public final Map<String, String> getParams() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", ev.f(this.f8541g));
        hashMap.put("output", "bin");
        String a2 = ey.a();
        String a3 = ey.a(this.f8541g, a2, fg.b((Map<String, String>) hashMap));
        hashMap.put("ts", a2);
        hashMap.put("scode", a3);
        return hashMap;
    }

    public final String getURL() {
        return this.f8542h;
    }

    public final boolean isSupportIPV6() {
        return true;
    }
}
