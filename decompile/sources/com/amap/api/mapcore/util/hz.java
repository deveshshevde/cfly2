package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;

public final class hz extends ia {

    /* renamed from: a  reason: collision with root package name */
    protected int f9186a;

    /* renamed from: b  reason: collision with root package name */
    protected long f9187b;

    /* renamed from: d  reason: collision with root package name */
    private String f9188d;

    /* renamed from: e  reason: collision with root package name */
    private Context f9189e;

    public hz(Context context, int i2, String str, ia iaVar) {
        super(iaVar);
        this.f9186a = i2;
        this.f9188d = str;
        this.f9189e = context;
    }

    public final void a_(boolean z2) {
        super.a_(z2);
        if (z2) {
            String str = this.f9188d;
            long currentTimeMillis = System.currentTimeMillis();
            this.f9187b = currentTimeMillis;
            fx.a(this.f9189e, str, String.valueOf(currentTimeMillis));
        }
    }

    /* access modifiers changed from: protected */
    public final boolean c() {
        long j2 = 0;
        if (this.f9187b == 0) {
            String a2 = fx.a(this.f9189e, this.f9188d);
            if (!TextUtils.isEmpty(a2)) {
                j2 = Long.parseLong(a2);
            }
            this.f9187b = j2;
        }
        return System.currentTimeMillis() - this.f9187b >= ((long) this.f9186a);
    }
}
