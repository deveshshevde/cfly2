package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import com.google.android.exoplayer2.util.ad;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f15267a = new a().a();

    /* renamed from: b  reason: collision with root package name */
    public final int f15268b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15269c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15270d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15271e;

    /* renamed from: f  reason: collision with root package name */
    private AudioAttributes f15272f;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private int f15273a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f15274b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f15275c = 1;

        /* renamed from: d  reason: collision with root package name */
        private int f15276d = 1;

        public c a() {
            return new c(this.f15273a, this.f15274b, this.f15275c, this.f15276d);
        }
    }

    private c(int i2, int i3, int i4, int i5) {
        this.f15268b = i2;
        this.f15269c = i3;
        this.f15270d = i4;
        this.f15271e = i5;
    }

    public AudioAttributes a() {
        if (this.f15272f == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.f15268b).setFlags(this.f15269c).setUsage(this.f15270d);
            if (ad.f11755a >= 29) {
                usage.setAllowedCapturePolicy(this.f15271e);
            }
            this.f15272f = usage.build();
        }
        return this.f15272f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f15268b == cVar.f15268b && this.f15269c == cVar.f15269c && this.f15270d == cVar.f15270d && this.f15271e == cVar.f15271e;
    }

    public int hashCode() {
        return ((((((527 + this.f15268b) * 31) + this.f15269c) * 31) + this.f15270d) * 31) + this.f15271e;
    }
}
