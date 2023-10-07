package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.util.ad;
import java.util.ArrayList;
import java.util.Map;

public abstract class d implements f {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f16981a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<t> f16982b = new ArrayList<>(1);

    /* renamed from: c  reason: collision with root package name */
    private int f16983c;

    /* renamed from: d  reason: collision with root package name */
    private h f16984d;

    protected d(boolean z2) {
        this.f16981a = z2;
    }

    /* access modifiers changed from: protected */
    public final void a(int i2) {
        h hVar = (h) ad.a(this.f16984d);
        for (int i3 = 0; i3 < this.f16983c; i3++) {
            this.f16982b.get(i3).a(this, hVar, this.f16981a, i2);
        }
    }

    public final void a(t tVar) {
        if (!this.f16982b.contains(tVar)) {
            this.f16982b.add(tVar);
            this.f16983c++;
        }
    }

    public /* synthetic */ Map b() {
        return f.CC.$default$b(this);
    }

    /* access modifiers changed from: protected */
    public final void b(h hVar) {
        for (int i2 = 0; i2 < this.f16983c; i2++) {
            this.f16982b.get(i2).a(this, hVar, this.f16981a);
        }
    }

    /* access modifiers changed from: protected */
    public final void c(h hVar) {
        this.f16984d = hVar;
        for (int i2 = 0; i2 < this.f16983c; i2++) {
            this.f16982b.get(i2).b(this, hVar, this.f16981a);
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        h hVar = (h) ad.a(this.f16984d);
        for (int i2 = 0; i2 < this.f16983c; i2++) {
            this.f16982b.get(i2).c(this, hVar, this.f16981a);
        }
        this.f16984d = null;
    }
}
