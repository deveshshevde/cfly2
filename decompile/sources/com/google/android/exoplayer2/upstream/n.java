package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.a;

public final class n extends HttpDataSource.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f17073a;

    /* renamed from: b  reason: collision with root package name */
    private final t f17074b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17075c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17076d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f17077e;

    public n(String str, t tVar) {
        this(str, tVar, 8000, 8000, false);
    }

    public n(String str, t tVar, int i2, int i3, boolean z2) {
        this.f17073a = a.a(str);
        this.f17074b = tVar;
        this.f17075c = i2;
        this.f17076d = i3;
        this.f17077e = z2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public m b(HttpDataSource.c cVar) {
        m mVar = new m(this.f17073a, this.f17075c, this.f17076d, this.f17077e, cVar);
        t tVar = this.f17074b;
        if (tVar != null) {
            mVar.a(tVar);
        }
        return mVar;
    }
}
