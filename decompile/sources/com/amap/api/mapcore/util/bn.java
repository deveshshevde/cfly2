package com.amap.api.mapcore.util;

import java.util.Hashtable;
import java.util.Map;

public final class bn extends cp {

    /* renamed from: e  reason: collision with root package name */
    private String f8089e;

    public bn(String str) {
        this.f8089e = str;
    }

    public final String getIPV6URL() {
        return getURL();
    }

    public final Map<String, String> getParams() {
        return null;
    }

    public final Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(32);
        hashtable.put("User-Agent", "MAC=channel:amapapi");
        return hashtable;
    }

    public final String getURL() {
        return this.f8089e;
    }

    public final boolean isSupportIPV6() {
        return false;
    }
}
