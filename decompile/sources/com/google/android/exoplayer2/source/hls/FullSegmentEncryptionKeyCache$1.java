package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;

class FullSegmentEncryptionKeyCache$1 extends LinkedHashMap<Uri, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f16158a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FullSegmentEncryptionKeyCache$1(d dVar, int i2, float f2, boolean z2, int i3) {
        super(i2, f2, z2);
        this.f16158a = i3;
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Map.Entry<Uri, byte[]> entry) {
        return size() > this.f16158a;
    }
}
