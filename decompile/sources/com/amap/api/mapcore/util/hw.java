package com.amap.api.mapcore.util;

import java.io.File;

public final class hw extends ia {

    /* renamed from: a  reason: collision with root package name */
    private int f9177a = 30;

    /* renamed from: b  reason: collision with root package name */
    private String f9178b;

    public hw(String str, ia iaVar) {
        super(iaVar);
        this.f9178b = str;
    }

    private static int a(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return 0;
            }
            return file.list().length;
        } catch (Throwable th) {
            fz.c(th, "fus", "gfn");
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean c() {
        return a(this.f9178b) >= this.f9177a;
    }
}
