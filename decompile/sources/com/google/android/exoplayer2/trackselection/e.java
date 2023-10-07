package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.upstream.c;
import ft.l;
import ft.m;
import java.util.List;

public interface e {

    /* renamed from: com.google.android.exoplayer2.trackselection.e$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$k(e eVar) {
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TrackGroup f16740a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f16741b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16742c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f16743d;

        public a(TrackGroup trackGroup, int... iArr) {
            this(trackGroup, iArr, 0, (Object) null);
        }

        public a(TrackGroup trackGroup, int[] iArr, int i2, Object obj) {
            this.f16740a = trackGroup;
            this.f16741b = iArr;
            this.f16742c = i2;
            this.f16743d = obj;
        }
    }

    public interface b {
        e[] a(a[] aVarArr, c cVar);
    }

    int a();

    int a(long j2, List<? extends l> list);

    int a(Format format);

    Format a(int i2);

    void a(float f2);

    void a(long j2, long j3, long j4, List<? extends l> list, m[] mVarArr);

    boolean a(int i2, long j2);

    int b();

    int b(int i2);

    int c(int i2);

    Object c();

    void d();

    void f();

    TrackGroup g();

    int h();

    Format i();

    int j();

    void k();
}
