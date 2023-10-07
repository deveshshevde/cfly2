package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.aa;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.upstream.c;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    private a f16747a;

    /* renamed from: b  reason: collision with root package name */
    private c f16748b;

    public interface a {
    }

    public abstract h a(aa[] aaVarArr, TrackGroupArray trackGroupArray, i.a aVar, af afVar) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    public final c a() {
        return (c) com.google.android.exoplayer2.util.a.b(this.f16748b);
    }

    public final void a(a aVar, c cVar) {
        this.f16747a = aVar;
        this.f16748b = cVar;
    }

    public abstract void a(Object obj);
}
