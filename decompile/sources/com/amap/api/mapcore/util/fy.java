package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.hd;
import java.util.HashMap;
import java.util.Map;

public final class fy extends fc {

    /* renamed from: e  reason: collision with root package name */
    private byte[] f8874e;

    /* renamed from: f  reason: collision with root package name */
    private String f8875f = "1";

    public fy(byte[] bArr, String str) {
        this.f8874e = (byte[]) bArr.clone();
        this.f8875f = str;
        setDegradeAbility(hd.a.SINGLE);
        setHttpProtocol(hd.c.HTTP);
    }

    public final byte[] getEntityBytes() {
        return this.f8874e;
    }

    public final Map<String, String> getParams() {
        return null;
    }

    public final Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f8874e.length));
        return hashMap;
    }

    public final String getURL() {
        String c2 = fg.c(fv.f8846b);
        byte[] a2 = fg.a(fv.f8845a);
        byte[] bArr = new byte[(a2.length + 50)];
        System.arraycopy(this.f8874e, 0, bArr, 0, 50);
        System.arraycopy(a2, 0, bArr, 50, a2.length);
        return String.format(c2, new Object[]{"1", this.f8875f, "1", "open", fd.a(bArr)});
    }

    public final boolean isHostToIP() {
        return false;
    }
}
