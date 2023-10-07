package com.google.android.exoplayer2.source.hls.playlist;

import java.util.Collections;
import java.util.List;

public abstract class e {

    /* renamed from: n  reason: collision with root package name */
    public final String f16338n;

    /* renamed from: o  reason: collision with root package name */
    public final List<String> f16339o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f16340p;

    protected e(String str, List<String> list, boolean z2) {
        this.f16338n = str;
        this.f16339o = Collections.unmodifiableList(list);
        this.f16340p = z2;
    }
}
