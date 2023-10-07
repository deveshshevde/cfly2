package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Collections;
import java.util.List;

public final class d extends e {

    /* renamed from: a  reason: collision with root package name */
    public final int f16313a;

    /* renamed from: b  reason: collision with root package name */
    public final long f16314b;

    /* renamed from: c  reason: collision with root package name */
    public final long f16315c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f16316d;

    /* renamed from: e  reason: collision with root package name */
    public final int f16317e;

    /* renamed from: f  reason: collision with root package name */
    public final long f16318f;

    /* renamed from: g  reason: collision with root package name */
    public final int f16319g;

    /* renamed from: h  reason: collision with root package name */
    public final long f16320h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f16321i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f16322j;

    /* renamed from: k  reason: collision with root package name */
    public final DrmInitData f16323k;

    /* renamed from: l  reason: collision with root package name */
    public final List<a> f16324l;

    /* renamed from: m  reason: collision with root package name */
    public final long f16325m;

    public static final class a implements Comparable<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final String f16326a;

        /* renamed from: b  reason: collision with root package name */
        public final a f16327b;

        /* renamed from: c  reason: collision with root package name */
        public final long f16328c;

        /* renamed from: d  reason: collision with root package name */
        public final String f16329d;

        /* renamed from: e  reason: collision with root package name */
        public final int f16330e;

        /* renamed from: f  reason: collision with root package name */
        public final long f16331f;

        /* renamed from: g  reason: collision with root package name */
        public final DrmInitData f16332g;

        /* renamed from: h  reason: collision with root package name */
        public final String f16333h;

        /* renamed from: i  reason: collision with root package name */
        public final String f16334i;

        /* renamed from: j  reason: collision with root package name */
        public final long f16335j;

        /* renamed from: k  reason: collision with root package name */
        public final long f16336k;

        /* renamed from: l  reason: collision with root package name */
        public final boolean f16337l;

        public a(String str, long j2, long j3, String str2, String str3) {
            this(str, (a) null, "", 0, -1, -9223372036854775807L, (DrmInitData) null, str2, str3, j2, j3, false);
        }

        public a(String str, a aVar, String str2, long j2, int i2, long j3, DrmInitData drmInitData, String str3, String str4, long j4, long j5, boolean z2) {
            this.f16326a = str;
            this.f16327b = aVar;
            this.f16329d = str2;
            this.f16328c = j2;
            this.f16330e = i2;
            this.f16331f = j3;
            this.f16332g = drmInitData;
            this.f16333h = str3;
            this.f16334i = str4;
            this.f16335j = j4;
            this.f16336k = j5;
            this.f16337l = z2;
        }

        /* renamed from: a */
        public int compareTo(Long l2) {
            if (this.f16331f > l2.longValue()) {
                return 1;
            }
            return this.f16331f < l2.longValue() ? -1 : 0;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(int i2, String str, List<String> list, long j2, long j3, boolean z2, int i3, long j4, int i4, long j5, boolean z3, boolean z4, boolean z5, DrmInitData drmInitData, List<a> list2) {
        super(str, list, z3);
        String str2 = str;
        List<String> list3 = list;
        this.f16313a = i2;
        this.f16315c = j3;
        this.f16316d = z2;
        this.f16317e = i3;
        this.f16318f = j4;
        this.f16319g = i4;
        this.f16320h = j5;
        this.f16321i = z4;
        this.f16322j = z5;
        this.f16323k = drmInitData;
        this.f16324l = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            a aVar = list2.get(list2.size() - 1);
            this.f16325m = aVar.f16331f + aVar.f16328c;
        } else {
            this.f16325m = 0;
        }
        this.f16314b = j2 == -9223372036854775807L ? -9223372036854775807L : j2 >= 0 ? j2 : this.f16325m + j2;
    }

    public long a() {
        return this.f16315c + this.f16325m;
    }

    public d a(long j2, int i2) {
        return new d(this.f16313a, this.f16338n, this.f16339o, this.f16314b, j2, true, i2, this.f16318f, this.f16319g, this.f16320h, this.f16340p, this.f16321i, this.f16322j, this.f16323k, this.f16324l);
    }

    public boolean a(d dVar) {
        if (dVar == null) {
            return true;
        }
        long j2 = this.f16318f;
        long j3 = dVar.f16318f;
        if (j2 > j3) {
            return true;
        }
        if (j2 < j3) {
            return false;
        }
        int size = this.f16324l.size();
        int size2 = dVar.f16324l.size();
        if (size <= size2) {
            return size == size2 && this.f16321i && !dVar.f16321i;
        }
        return true;
    }

    public d b() {
        if (this.f16321i) {
            return this;
        }
        d dVar = r2;
        d dVar2 = new d(this.f16313a, this.f16338n, this.f16339o, this.f16314b, this.f16315c, this.f16316d, this.f16317e, this.f16318f, this.f16319g, this.f16320h, this.f16340p, true, this.f16322j, this.f16323k, this.f16324l);
        return dVar;
    }
}
