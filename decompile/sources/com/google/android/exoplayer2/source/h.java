package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.ad;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.trackselection.e;
import java.io.IOException;

public interface h extends p {

    public interface a extends p.a<h> {
        void a(h hVar);
    }

    long a(long j2, ad adVar);

    long a(e[] eVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j2);

    void a(long j2);

    void a(long j2, boolean z2);

    void a(a aVar, long j2);

    long b(long j2);

    TrackGroupArray b();

    long c();

    boolean c(long j2);

    long d();

    long e();

    boolean f();

    void n_() throws IOException;
}
