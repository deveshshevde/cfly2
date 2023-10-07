package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.aa;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<aa> f16261a = new SparseArray<>();

    public aa a(int i2) {
        aa aaVar = this.f16261a.get(i2);
        if (aaVar != null) {
            return aaVar;
        }
        aa aaVar2 = new aa(Long.MAX_VALUE);
        this.f16261a.put(i2, aaVar2);
        return aaVar2;
    }

    public void a() {
        this.f16261a.clear();
    }
}
