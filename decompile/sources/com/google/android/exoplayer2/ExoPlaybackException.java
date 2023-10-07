package com.google.android.exoplayer2;

import android.os.SystemClock;
import java.io.IOException;

public final class ExoPlaybackException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final int f15078a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15079b;

    /* renamed from: c  reason: collision with root package name */
    public final Format f15080c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15081d;

    /* renamed from: e  reason: collision with root package name */
    public final long f15082e;

    /* renamed from: f  reason: collision with root package name */
    private final Throwable f15083f;

    private ExoPlaybackException(int i2, Throwable th) {
        this(i2, th, -1, (Format) null, 4);
    }

    private ExoPlaybackException(int i2, Throwable th, int i3, Format format, int i4) {
        super(th);
        this.f15078a = i2;
        this.f15083f = th;
        this.f15079b = i3;
        this.f15080c = format;
        this.f15081d = i4;
        this.f15082e = SystemClock.elapsedRealtime();
    }

    public static ExoPlaybackException a(IOException iOException) {
        return new ExoPlaybackException(0, iOException);
    }

    public static ExoPlaybackException a(Exception exc, int i2, Format format, int i3) {
        return new ExoPlaybackException(1, exc, i2, format, format == null ? 4 : i3);
    }

    public static ExoPlaybackException a(OutOfMemoryError outOfMemoryError) {
        return new ExoPlaybackException(4, outOfMemoryError);
    }

    public static ExoPlaybackException a(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, runtimeException);
    }
}
