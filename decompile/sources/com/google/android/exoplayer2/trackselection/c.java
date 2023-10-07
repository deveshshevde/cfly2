package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import ft.l;
import ft.m;
import java.util.List;

public final class c extends b {

    /* renamed from: d  reason: collision with root package name */
    private final int f16730d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f16731e;

    public c(TrackGroup trackGroup, int i2, int i3, Object obj) {
        super(trackGroup, i2);
        this.f16730d = i3;
        this.f16731e = obj;
    }

    public int a() {
        return 0;
    }

    public void a(long j2, long j3, long j4, List<? extends l> list, m[] mVarArr) {
    }

    public int b() {
        return this.f16730d;
    }

    public Object c() {
        return this.f16731e;
    }
}
