package com.google.android.exoplayer2;

import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.trackselection.h;

final class u {

    /* renamed from: n  reason: collision with root package name */
    private static final i.a f16753n = new i.a(new Object());

    /* renamed from: a  reason: collision with root package name */
    public final af f16754a;

    /* renamed from: b  reason: collision with root package name */
    public final i.a f16755b;

    /* renamed from: c  reason: collision with root package name */
    public final long f16756c;

    /* renamed from: d  reason: collision with root package name */
    public final long f16757d;

    /* renamed from: e  reason: collision with root package name */
    public final int f16758e;

    /* renamed from: f  reason: collision with root package name */
    public final ExoPlaybackException f16759f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f16760g;

    /* renamed from: h  reason: collision with root package name */
    public final TrackGroupArray f16761h;

    /* renamed from: i  reason: collision with root package name */
    public final h f16762i;

    /* renamed from: j  reason: collision with root package name */
    public final i.a f16763j;

    /* renamed from: k  reason: collision with root package name */
    public volatile long f16764k;

    /* renamed from: l  reason: collision with root package name */
    public volatile long f16765l;

    /* renamed from: m  reason: collision with root package name */
    public volatile long f16766m;

    public u(af afVar, i.a aVar, long j2, long j3, int i2, ExoPlaybackException exoPlaybackException, boolean z2, TrackGroupArray trackGroupArray, h hVar, i.a aVar2, long j4, long j5, long j6) {
        this.f16754a = afVar;
        this.f16755b = aVar;
        this.f16756c = j2;
        this.f16757d = j3;
        this.f16758e = i2;
        this.f16759f = exoPlaybackException;
        this.f16760g = z2;
        this.f16761h = trackGroupArray;
        this.f16762i = hVar;
        this.f16763j = aVar2;
        this.f16764k = j4;
        this.f16765l = j5;
        this.f16766m = j6;
    }

    public static u a(long j2, h hVar) {
        h hVar2 = hVar;
        af afVar = af.f15165a;
        i.a aVar = f16753n;
        i.a aVar2 = aVar;
        return new u(afVar, aVar, j2, -9223372036854775807L, 1, (ExoPlaybackException) null, false, TrackGroupArray.f16008a, hVar2, aVar2, j2, 0, j2);
    }

    public i.a a(boolean z2, af.b bVar, af.a aVar) {
        if (this.f16754a.a()) {
            return f16753n;
        }
        int b2 = this.f16754a.b(z2);
        int i2 = this.f16754a.a(b2, bVar).f15181j;
        int a2 = this.f16754a.a(this.f16755b.f16367a);
        long j2 = -1;
        if (a2 != -1 && b2 == this.f16754a.a(a2, aVar).f15168c) {
            j2 = this.f16755b.f16370d;
        }
        return new i.a(this.f16754a.a(i2), j2);
    }

    public u a(int i2) {
        af afVar = this.f16754a;
        return new u(afVar, this.f16755b, this.f16756c, this.f16757d, i2, this.f16759f, this.f16760g, this.f16761h, this.f16762i, this.f16763j, this.f16764k, this.f16765l, this.f16766m);
    }

    public u a(ExoPlaybackException exoPlaybackException) {
        af afVar = this.f16754a;
        return new u(afVar, this.f16755b, this.f16756c, this.f16757d, this.f16758e, exoPlaybackException, this.f16760g, this.f16761h, this.f16762i, this.f16763j, this.f16764k, this.f16765l, this.f16766m);
    }

    public u a(af afVar) {
        af afVar2 = afVar;
        return new u(afVar, this.f16755b, this.f16756c, this.f16757d, this.f16758e, this.f16759f, this.f16760g, this.f16761h, this.f16762i, this.f16763j, this.f16764k, this.f16765l, this.f16766m);
    }

    public u a(TrackGroupArray trackGroupArray, h hVar) {
        af afVar = this.f16754a;
        return new u(afVar, this.f16755b, this.f16756c, this.f16757d, this.f16758e, this.f16759f, this.f16760g, trackGroupArray, hVar, this.f16763j, this.f16764k, this.f16765l, this.f16766m);
    }

    public u a(i.a aVar) {
        af afVar = this.f16754a;
        return new u(afVar, this.f16755b, this.f16756c, this.f16757d, this.f16758e, this.f16759f, this.f16760g, this.f16761h, this.f16762i, aVar, this.f16764k, this.f16765l, this.f16766m);
    }

    public u a(i.a aVar, long j2, long j3, long j4) {
        return new u(this.f16754a, aVar, j2, aVar.a() ? j3 : -9223372036854775807L, this.f16758e, this.f16759f, this.f16760g, this.f16761h, this.f16762i, this.f16763j, this.f16764k, j4, j2);
    }

    public u a(boolean z2) {
        af afVar = this.f16754a;
        return new u(afVar, this.f16755b, this.f16756c, this.f16757d, this.f16758e, this.f16759f, z2, this.f16761h, this.f16762i, this.f16763j, this.f16764k, this.f16765l, this.f16766m);
    }
}
