package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;

public final class af {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f17777a;

    /* renamed from: b  reason: collision with root package name */
    private d f17778b;

    public af() {
        this(c.a());
    }

    public af(d dVar) {
        this.f17777a = new SparseIntArray();
        m.a(dVar);
        this.f17778b = dVar;
    }

    public final int a(Context context, int i2) {
        return this.f17777a.get(i2, -1);
    }

    public final int a(Context context, a.f fVar) {
        m.a(context);
        m.a(fVar);
        int i2 = 0;
        if (!fVar.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = fVar.getMinApkVersion();
        int a2 = a(context, minApkVersion);
        if (a2 == -1) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.f17777a.size()) {
                    i2 = -1;
                    break;
                }
                int keyAt = this.f17777a.keyAt(i3);
                if (keyAt > minApkVersion && this.f17777a.get(keyAt) == 0) {
                    break;
                }
                i3++;
            }
            a2 = i2 == -1 ? this.f17778b.a(context, minApkVersion) : i2;
            this.f17777a.put(minApkVersion, a2);
        }
        return a2;
    }

    public final void a() {
        this.f17777a.clear();
    }
}
