package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.hd;
import java.util.Map;

public final class gv extends hd {

    /* renamed from: e  reason: collision with root package name */
    private byte[] f8979e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, String> f8980f;

    public gv(byte[] bArr, Map<String, String> map) {
        this.f8979e = bArr;
        this.f8980f = map;
        setDegradeAbility(hd.a.SINGLE);
        setHttpProtocol(hd.c.HTTPS);
    }

    public final byte[] getEntityBytes() {
        return this.f8979e;
    }

    public final Map<String, String> getParams() {
        return this.f8980f;
    }

    public final Map<String, String> getRequestHead() {
        return null;
    }

    public final String getURL() {
        return "https://adiu.amap.com/ws/device/adius";
    }
}
