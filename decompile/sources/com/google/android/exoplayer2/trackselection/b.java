package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.e;
import com.google.android.exoplayer2.util.ad;
import ft.l;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public abstract class b implements e {

    /* renamed from: a  reason: collision with root package name */
    protected final TrackGroup f16724a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f16725b;

    /* renamed from: c  reason: collision with root package name */
    protected final int[] f16726c;

    /* renamed from: d  reason: collision with root package name */
    private final Format[] f16727d;

    /* renamed from: e  reason: collision with root package name */
    private final long[] f16728e;

    /* renamed from: f  reason: collision with root package name */
    private int f16729f;

    private static final class a implements Comparator<Format> {
        private a() {
        }

        /* renamed from: a */
        public int compare(Format format, Format format2) {
            return format2.f15088e - format.f15088e;
        }
    }

    public b(TrackGroup trackGroup, int... iArr) {
        int i2 = 0;
        com.google.android.exoplayer2.util.a.b(iArr.length > 0);
        this.f16724a = (TrackGroup) com.google.android.exoplayer2.util.a.b(trackGroup);
        int length = iArr.length;
        this.f16725b = length;
        this.f16727d = new Format[length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.f16727d[i3] = trackGroup.a(iArr[i3]);
        }
        Arrays.sort(this.f16727d, new a());
        this.f16726c = new int[this.f16725b];
        while (true) {
            int i4 = this.f16725b;
            if (i2 < i4) {
                this.f16726c[i2] = trackGroup.a(this.f16727d[i2]);
                i2++;
            } else {
                this.f16728e = new long[i4];
                return;
            }
        }
    }

    public int a(long j2, List<? extends l> list) {
        return list.size();
    }

    public final int a(Format format) {
        for (int i2 = 0; i2 < this.f16725b; i2++) {
            if (this.f16727d[i2] == format) {
                return i2;
            }
        }
        return -1;
    }

    public final Format a(int i2) {
        return this.f16727d[i2];
    }

    public void a(float f2) {
    }

    public final boolean a(int i2, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean b2 = b(i2, elapsedRealtime);
        int i3 = 0;
        while (i3 < this.f16725b && !b2) {
            b2 = i3 != i2 && !b(i3, elapsedRealtime);
            i3++;
        }
        if (!b2) {
            return false;
        }
        long[] jArr = this.f16728e;
        jArr[i2] = Math.max(jArr[i2], ad.b(elapsedRealtime, j2, Long.MAX_VALUE));
        return true;
    }

    public final int b(int i2) {
        return this.f16726c[i2];
    }

    /* access modifiers changed from: protected */
    public final boolean b(int i2, long j2) {
        return this.f16728e[i2] > j2;
    }

    public final int c(int i2) {
        for (int i3 = 0; i3 < this.f16725b; i3++) {
            if (this.f16726c[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    public void d() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f16724a == bVar.f16724a && Arrays.equals(this.f16726c, bVar.f16726c);
    }

    public void f() {
    }

    public final TrackGroup g() {
        return this.f16724a;
    }

    public final int h() {
        return this.f16726c.length;
    }

    public int hashCode() {
        if (this.f16729f == 0) {
            this.f16729f = (System.identityHashCode(this.f16724a) * 31) + Arrays.hashCode(this.f16726c);
        }
        return this.f16729f;
    }

    public final Format i() {
        return this.f16727d[a()];
    }

    public final int j() {
        return this.f16726c[a()];
    }

    public /* synthetic */ void k() {
        e.CC.$default$k(this);
    }
}
