package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public final class hx extends ia {

    /* renamed from: a  reason: collision with root package name */
    private String f9179a = "iKey";

    /* renamed from: b  reason: collision with root package name */
    private Context f9180b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9181d;

    /* renamed from: e  reason: collision with root package name */
    private int f9182e;

    /* renamed from: f  reason: collision with root package name */
    private int f9183f;

    /* renamed from: g  reason: collision with root package name */
    private int f9184g = 0;

    public hx(Context context, boolean z2, int i2, int i3, String str, int i4) {
        a(context, z2, i2, i3, str, i4);
    }

    private void a(Context context, boolean z2, int i2, int i3, String str, int i4) {
        this.f9180b = context;
        this.f9181d = z2;
        this.f9182e = i2;
        this.f9183f = i3;
        this.f9179a = str;
        this.f9184g = i4;
    }

    public final int a() {
        int i2;
        int p2 = ez.p(this.f9180b);
        int i3 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        if ((p2 != 1 && (i2 = this.f9182e) > 0) || ((i2 = this.f9184g) > 0 && i2 < Integer.MAX_VALUE)) {
            i3 = i2;
        }
        return this.f9196c != null ? Math.max(i3, this.f9196c.a()) : i3;
    }

    public final void a_(int i2) {
        if (ez.p(this.f9180b) != 1) {
            String a2 = fg.a(System.currentTimeMillis(), "yyyyMMdd");
            String a3 = fx.a(this.f9180b, this.f9179a);
            if (!TextUtils.isEmpty(a3)) {
                String[] split = a3.split("\\|");
                if (split == null || split.length < 2) {
                    fx.b(this.f9180b, this.f9179a);
                } else if (a2.equals(split[0])) {
                    i2 += Integer.parseInt(split[1]);
                }
            }
            Context context = this.f9180b;
            String str = this.f9179a;
            fx.a(context, str, a2 + "|" + i2);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean c() {
        if (ez.p(this.f9180b) == 1) {
            return true;
        }
        if (!this.f9181d) {
            return false;
        }
        String a2 = fx.a(this.f9180b, this.f9179a);
        if (TextUtils.isEmpty(a2)) {
            return true;
        }
        String[] split = a2.split("\\|");
        if (split == null || split.length < 2) {
            fx.b(this.f9180b, this.f9179a);
            return true;
        }
        return !fg.a(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f9183f;
    }
}
