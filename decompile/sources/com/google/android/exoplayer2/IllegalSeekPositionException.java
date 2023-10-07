package com.google.android.exoplayer2;

public final class IllegalSeekPositionException extends IllegalStateException {

    /* renamed from: a  reason: collision with root package name */
    public final af f15110a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15111b;

    /* renamed from: c  reason: collision with root package name */
    public final long f15112c;

    public IllegalSeekPositionException(af afVar, int i2, long j2) {
        this.f15110a = afVar;
        this.f15111b = i2;
        this.f15112c = j2;
    }
}
