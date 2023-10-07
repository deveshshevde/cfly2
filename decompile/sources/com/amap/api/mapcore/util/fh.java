package com.amap.api.mapcore.util;

import java.util.HashMap;
import java.util.Map;

@Deprecated
final class fh extends hd {

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f8764e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private String f8765f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, String> f8766g = new HashMap();

    fh() {
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        this.f8765f = str;
    }

    /* access modifiers changed from: package-private */
    public final void a(Map<String, String> map) {
        this.f8764e.clear();
        this.f8764e.putAll(map);
    }

    /* access modifiers changed from: package-private */
    public final void b(Map<String, String> map) {
        this.f8766g.clear();
        this.f8766g.putAll(map);
    }

    public final Map<String, String> getParams() {
        return this.f8766g;
    }

    public final Map<String, String> getRequestHead() {
        return this.f8764e;
    }

    public final String getURL() {
        return this.f8765f;
    }
}
