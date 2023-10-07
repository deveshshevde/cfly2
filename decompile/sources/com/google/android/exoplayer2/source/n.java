package com.google.android.exoplayer2.source;

import android.os.Looper;
import com.blankj.utilcode.constant.MemoryConstants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.q;
import fi.e;
import fj.h;
import fj.u;
import java.io.IOException;

public class n implements u {
    private int A;
    private boolean B;
    private Format C;
    private long D;
    private boolean E;

    /* renamed from: a  reason: collision with root package name */
    private final m f16474a;

    /* renamed from: b  reason: collision with root package name */
    private final a f16475b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.exoplayer2.drm.b<?> f16476c;

    /* renamed from: d  reason: collision with root package name */
    private b f16477d;

    /* renamed from: e  reason: collision with root package name */
    private final Looper f16478e;

    /* renamed from: f  reason: collision with root package name */
    private Format f16479f;

    /* renamed from: g  reason: collision with root package name */
    private DrmSession<?> f16480g;

    /* renamed from: h  reason: collision with root package name */
    private int f16481h = 1000;

    /* renamed from: i  reason: collision with root package name */
    private int[] f16482i = new int[1000];

    /* renamed from: j  reason: collision with root package name */
    private long[] f16483j = new long[1000];

    /* renamed from: k  reason: collision with root package name */
    private int[] f16484k = new int[1000];

    /* renamed from: l  reason: collision with root package name */
    private int[] f16485l = new int[1000];

    /* renamed from: m  reason: collision with root package name */
    private long[] f16486m = new long[1000];

    /* renamed from: n  reason: collision with root package name */
    private u.a[] f16487n = new u.a[1000];

    /* renamed from: o  reason: collision with root package name */
    private Format[] f16488o = new Format[1000];

    /* renamed from: p  reason: collision with root package name */
    private int f16489p;

    /* renamed from: q  reason: collision with root package name */
    private int f16490q;

    /* renamed from: r  reason: collision with root package name */
    private int f16491r;

    /* renamed from: s  reason: collision with root package name */
    private int f16492s;

    /* renamed from: t  reason: collision with root package name */
    private long f16493t = Long.MIN_VALUE;

    /* renamed from: u  reason: collision with root package name */
    private long f16494u = Long.MIN_VALUE;

    /* renamed from: v  reason: collision with root package name */
    private boolean f16495v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f16496w = true;

    /* renamed from: x  reason: collision with root package name */
    private boolean f16497x = true;

    /* renamed from: y  reason: collision with root package name */
    private Format f16498y;

    /* renamed from: z  reason: collision with root package name */
    private Format f16499z;

    public interface b {
        void a(Format format);
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f16500a;

        /* renamed from: b  reason: collision with root package name */
        public long f16501b;

        /* renamed from: c  reason: collision with root package name */
        public u.a f16502c;

        a() {
        }
    }

    public n(com.google.android.exoplayer2.upstream.b bVar, Looper looper, com.google.android.exoplayer2.drm.b<?> bVar2) {
        this.f16474a = new m(bVar);
        this.f16478e = looper;
        this.f16476c = bVar2;
    }

    private int a(int i2, int i3, long j2, boolean z2) {
        int i4 = -1;
        for (int i5 = 0; i5 < i3 && this.f16486m[i2] <= j2; i5++) {
            if (!z2 || (this.f16485l[i2] & 1) != 0) {
                i4 = i5;
            }
            i2++;
            if (i2 == this.f16481h) {
                i2 = 0;
            }
        }
        return i4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004e, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized int a(com.google.android.exoplayer2.o r7, fi.e r8, boolean r9, boolean r10, long r11, com.google.android.exoplayer2.source.n.a r13) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            r8.f13100c = r0     // Catch:{ all -> 0x00ac }
            r0 = -1
        L_0x0005:
            boolean r1 = r6.v()     // Catch:{ all -> 0x00ac }
            r2 = 1
            if (r1 == 0) goto L_0x002c
            int r0 = r6.f16492s     // Catch:{ all -> 0x00ac }
            int r0 = r6.h(r0)     // Catch:{ all -> 0x00ac }
            long[] r3 = r6.f16486m     // Catch:{ all -> 0x00ac }
            r4 = r3[r0]     // Catch:{ all -> 0x00ac }
            int r3 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r3 >= 0) goto L_0x002c
            com.google.android.exoplayer2.Format[] r3 = r6.f16488o     // Catch:{ all -> 0x00ac }
            r3 = r3[r0]     // Catch:{ all -> 0x00ac }
            java.lang.String r3 = r3.f15092i     // Catch:{ all -> 0x00ac }
            boolean r3 = com.google.android.exoplayer2.util.n.d(r3)     // Catch:{ all -> 0x00ac }
            if (r3 == 0) goto L_0x002c
            int r1 = r6.f16492s     // Catch:{ all -> 0x00ac }
            int r1 = r1 + r2
            r6.f16492s = r1     // Catch:{ all -> 0x00ac }
            goto L_0x0005
        L_0x002c:
            r3 = -3
            r4 = -5
            r5 = -4
            if (r1 != 0) goto L_0x0055
            if (r10 != 0) goto L_0x004f
            boolean r10 = r6.f16495v     // Catch:{ all -> 0x00ac }
            if (r10 == 0) goto L_0x0038
            goto L_0x004f
        L_0x0038:
            com.google.android.exoplayer2.Format r8 = r6.f16498y     // Catch:{ all -> 0x00ac }
            if (r8 == 0) goto L_0x004d
            if (r9 != 0) goto L_0x0042
            com.google.android.exoplayer2.Format r9 = r6.f16479f     // Catch:{ all -> 0x00ac }
            if (r8 == r9) goto L_0x004d
        L_0x0042:
            java.lang.Object r8 = com.google.android.exoplayer2.util.a.b(r8)     // Catch:{ all -> 0x00ac }
            com.google.android.exoplayer2.Format r8 = (com.google.android.exoplayer2.Format) r8     // Catch:{ all -> 0x00ac }
            r6.a((com.google.android.exoplayer2.Format) r8, (com.google.android.exoplayer2.o) r7)     // Catch:{ all -> 0x00ac }
            monitor-exit(r6)
            return r4
        L_0x004d:
            monitor-exit(r6)
            return r3
        L_0x004f:
            r7 = 4
            r8.setFlags(r7)     // Catch:{ all -> 0x00ac }
            monitor-exit(r6)
            return r5
        L_0x0055:
            if (r9 != 0) goto L_0x00a3
            com.google.android.exoplayer2.Format[] r9 = r6.f16488o     // Catch:{ all -> 0x00ac }
            r9 = r9[r0]     // Catch:{ all -> 0x00ac }
            com.google.android.exoplayer2.Format r10 = r6.f16479f     // Catch:{ all -> 0x00ac }
            if (r9 == r10) goto L_0x0060
            goto L_0x00a3
        L_0x0060:
            boolean r7 = r6.e(r0)     // Catch:{ all -> 0x00ac }
            if (r7 != 0) goto L_0x006a
            r8.f13100c = r2     // Catch:{ all -> 0x00ac }
            monitor-exit(r6)
            return r3
        L_0x006a:
            int[] r7 = r6.f16485l     // Catch:{ all -> 0x00ac }
            r7 = r7[r0]     // Catch:{ all -> 0x00ac }
            r8.setFlags(r7)     // Catch:{ all -> 0x00ac }
            long[] r7 = r6.f16486m     // Catch:{ all -> 0x00ac }
            r9 = r7[r0]     // Catch:{ all -> 0x00ac }
            r8.f13101d = r9     // Catch:{ all -> 0x00ac }
            long r9 = r8.f13101d     // Catch:{ all -> 0x00ac }
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 >= 0) goto L_0x0082
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r8.addFlag(r7)     // Catch:{ all -> 0x00ac }
        L_0x0082:
            boolean r7 = r8.b()     // Catch:{ all -> 0x00ac }
            if (r7 == 0) goto L_0x008a
            monitor-exit(r6)
            return r5
        L_0x008a:
            int[] r7 = r6.f16484k     // Catch:{ all -> 0x00ac }
            r7 = r7[r0]     // Catch:{ all -> 0x00ac }
            r13.f16500a = r7     // Catch:{ all -> 0x00ac }
            long[] r7 = r6.f16483j     // Catch:{ all -> 0x00ac }
            r8 = r7[r0]     // Catch:{ all -> 0x00ac }
            r13.f16501b = r8     // Catch:{ all -> 0x00ac }
            fj.u$a[] r7 = r6.f16487n     // Catch:{ all -> 0x00ac }
            r7 = r7[r0]     // Catch:{ all -> 0x00ac }
            r13.f16502c = r7     // Catch:{ all -> 0x00ac }
            int r7 = r6.f16492s     // Catch:{ all -> 0x00ac }
            int r7 = r7 + r2
            r6.f16492s = r7     // Catch:{ all -> 0x00ac }
            monitor-exit(r6)
            return r5
        L_0x00a3:
            com.google.android.exoplayer2.Format[] r8 = r6.f16488o     // Catch:{ all -> 0x00ac }
            r8 = r8[r0]     // Catch:{ all -> 0x00ac }
            r6.a((com.google.android.exoplayer2.Format) r8, (com.google.android.exoplayer2.o) r7)     // Catch:{ all -> 0x00ac }
            monitor-exit(r6)
            return r4
        L_0x00ac:
            r7 = move-exception
            monitor-exit(r6)
            goto L_0x00b0
        L_0x00af:
            throw r7
        L_0x00b0:
            goto L_0x00af
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.n.a(com.google.android.exoplayer2.o, fi.e, boolean, boolean, long, com.google.android.exoplayer2.source.n$a):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(long r6, int r8, long r9, int r11, fj.u.a r12) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.f16496w     // Catch:{ all -> 0x00d5 }
            r1 = 0
            if (r0 == 0) goto L_0x000e
            r0 = r8 & 1
            if (r0 != 0) goto L_0x000c
            monitor-exit(r5)
            return
        L_0x000c:
            r5.f16496w = r1     // Catch:{ all -> 0x00d5 }
        L_0x000e:
            boolean r0 = r5.f16497x     // Catch:{ all -> 0x00d5 }
            r2 = 1
            if (r0 != 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            com.google.android.exoplayer2.util.a.b((boolean) r0)     // Catch:{ all -> 0x00d5 }
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r8
            if (r0 == 0) goto L_0x0020
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            r5.f16495v = r0     // Catch:{ all -> 0x00d5 }
            long r3 = r5.f16494u     // Catch:{ all -> 0x00d5 }
            long r3 = java.lang.Math.max(r3, r6)     // Catch:{ all -> 0x00d5 }
            r5.f16494u = r3     // Catch:{ all -> 0x00d5 }
            int r0 = r5.f16489p     // Catch:{ all -> 0x00d5 }
            int r0 = r5.h(r0)     // Catch:{ all -> 0x00d5 }
            long[] r3 = r5.f16486m     // Catch:{ all -> 0x00d5 }
            r3[r0] = r6     // Catch:{ all -> 0x00d5 }
            long[] r6 = r5.f16483j     // Catch:{ all -> 0x00d5 }
            r6[r0] = r9     // Catch:{ all -> 0x00d5 }
            int[] r7 = r5.f16484k     // Catch:{ all -> 0x00d5 }
            r7[r0] = r11     // Catch:{ all -> 0x00d5 }
            int[] r7 = r5.f16485l     // Catch:{ all -> 0x00d5 }
            r7[r0] = r8     // Catch:{ all -> 0x00d5 }
            fj.u$a[] r7 = r5.f16487n     // Catch:{ all -> 0x00d5 }
            r7[r0] = r12     // Catch:{ all -> 0x00d5 }
            com.google.android.exoplayer2.Format[] r7 = r5.f16488o     // Catch:{ all -> 0x00d5 }
            com.google.android.exoplayer2.Format r8 = r5.f16498y     // Catch:{ all -> 0x00d5 }
            r7[r0] = r8     // Catch:{ all -> 0x00d5 }
            int[] r7 = r5.f16482i     // Catch:{ all -> 0x00d5 }
            int r9 = r5.A     // Catch:{ all -> 0x00d5 }
            r7[r0] = r9     // Catch:{ all -> 0x00d5 }
            r5.f16499z = r8     // Catch:{ all -> 0x00d5 }
            int r7 = r5.f16489p     // Catch:{ all -> 0x00d5 }
            int r7 = r7 + r2
            r5.f16489p = r7     // Catch:{ all -> 0x00d5 }
            int r8 = r5.f16481h     // Catch:{ all -> 0x00d5 }
            if (r7 != r8) goto L_0x00d3
            int r7 = r8 + 1000
            int[] r9 = new int[r7]     // Catch:{ all -> 0x00d5 }
            long[] r10 = new long[r7]     // Catch:{ all -> 0x00d5 }
            long[] r11 = new long[r7]     // Catch:{ all -> 0x00d5 }
            int[] r12 = new int[r7]     // Catch:{ all -> 0x00d5 }
            int[] r0 = new int[r7]     // Catch:{ all -> 0x00d5 }
            fj.u$a[] r2 = new fj.u.a[r7]     // Catch:{ all -> 0x00d5 }
            com.google.android.exoplayer2.Format[] r3 = new com.google.android.exoplayer2.Format[r7]     // Catch:{ all -> 0x00d5 }
            int r4 = r5.f16491r     // Catch:{ all -> 0x00d5 }
            int r8 = r8 - r4
            java.lang.System.arraycopy(r6, r4, r10, r1, r8)     // Catch:{ all -> 0x00d5 }
            long[] r6 = r5.f16486m     // Catch:{ all -> 0x00d5 }
            int r4 = r5.f16491r     // Catch:{ all -> 0x00d5 }
            java.lang.System.arraycopy(r6, r4, r11, r1, r8)     // Catch:{ all -> 0x00d5 }
            int[] r6 = r5.f16485l     // Catch:{ all -> 0x00d5 }
            int r4 = r5.f16491r     // Catch:{ all -> 0x00d5 }
            java.lang.System.arraycopy(r6, r4, r12, r1, r8)     // Catch:{ all -> 0x00d5 }
            int[] r6 = r5.f16484k     // Catch:{ all -> 0x00d5 }
            int r4 = r5.f16491r     // Catch:{ all -> 0x00d5 }
            java.lang.System.arraycopy(r6, r4, r0, r1, r8)     // Catch:{ all -> 0x00d5 }
            fj.u$a[] r6 = r5.f16487n     // Catch:{ all -> 0x00d5 }
            int r4 = r5.f16491r     // Catch:{ all -> 0x00d5 }
            java.lang.System.arraycopy(r6, r4, r2, r1, r8)     // Catch:{ all -> 0x00d5 }
            com.google.android.exoplayer2.Format[] r6 = r5.f16488o     // Catch:{ all -> 0x00d5 }
            int r4 = r5.f16491r     // Catch:{ all -> 0x00d5 }
            java.lang.System.arraycopy(r6, r4, r3, r1, r8)     // Catch:{ all -> 0x00d5 }
            int[] r6 = r5.f16482i     // Catch:{ all -> 0x00d5 }
            int r4 = r5.f16491r     // Catch:{ all -> 0x00d5 }
            java.lang.System.arraycopy(r6, r4, r9, r1, r8)     // Catch:{ all -> 0x00d5 }
            int r6 = r5.f16491r     // Catch:{ all -> 0x00d5 }
            long[] r4 = r5.f16483j     // Catch:{ all -> 0x00d5 }
            java.lang.System.arraycopy(r4, r1, r10, r8, r6)     // Catch:{ all -> 0x00d5 }
            long[] r4 = r5.f16486m     // Catch:{ all -> 0x00d5 }
            java.lang.System.arraycopy(r4, r1, r11, r8, r6)     // Catch:{ all -> 0x00d5 }
            int[] r4 = r5.f16485l     // Catch:{ all -> 0x00d5 }
            java.lang.System.arraycopy(r4, r1, r12, r8, r6)     // Catch:{ all -> 0x00d5 }
            int[] r4 = r5.f16484k     // Catch:{ all -> 0x00d5 }
            java.lang.System.arraycopy(r4, r1, r0, r8, r6)     // Catch:{ all -> 0x00d5 }
            fj.u$a[] r4 = r5.f16487n     // Catch:{ all -> 0x00d5 }
            java.lang.System.arraycopy(r4, r1, r2, r8, r6)     // Catch:{ all -> 0x00d5 }
            com.google.android.exoplayer2.Format[] r4 = r5.f16488o     // Catch:{ all -> 0x00d5 }
            java.lang.System.arraycopy(r4, r1, r3, r8, r6)     // Catch:{ all -> 0x00d5 }
            int[] r4 = r5.f16482i     // Catch:{ all -> 0x00d5 }
            java.lang.System.arraycopy(r4, r1, r9, r8, r6)     // Catch:{ all -> 0x00d5 }
            r5.f16483j = r10     // Catch:{ all -> 0x00d5 }
            r5.f16486m = r11     // Catch:{ all -> 0x00d5 }
            r5.f16485l = r12     // Catch:{ all -> 0x00d5 }
            r5.f16484k = r0     // Catch:{ all -> 0x00d5 }
            r5.f16487n = r2     // Catch:{ all -> 0x00d5 }
            r5.f16488o = r3     // Catch:{ all -> 0x00d5 }
            r5.f16482i = r9     // Catch:{ all -> 0x00d5 }
            r5.f16491r = r1     // Catch:{ all -> 0x00d5 }
            r5.f16481h = r7     // Catch:{ all -> 0x00d5 }
        L_0x00d3:
            monitor-exit(r5)
            return
        L_0x00d5:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.n.a(long, int, long, int, fj.u$a):void");
    }

    private void a(Format format, o oVar) {
        oVar.f15972c = format;
        Format format2 = this.f16479f;
        boolean z2 = format2 == null;
        DrmInitData drmInitData = z2 ? null : format2.f15095l;
        this.f16479f = format;
        if (this.f16476c != com.google.android.exoplayer2.drm.b.f15471b) {
            DrmInitData drmInitData2 = format.f15095l;
            oVar.f15970a = true;
            oVar.f15971b = this.f16480g;
            if (z2 || !ad.a((Object) drmInitData, (Object) drmInitData2)) {
                DrmSession<?> drmSession = this.f16480g;
                DrmSession<?> a2 = drmInitData2 != null ? this.f16476c.a(this.f16478e, drmInitData2) : this.f16476c.a(this.f16478e, com.google.android.exoplayer2.util.n.h(format.f15092i));
                this.f16480g = a2;
                oVar.f15971b = a2;
                if (drmSession != null) {
                    drmSession.i();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized long b(long r11, boolean r13, boolean r14) {
        /*
            r10 = this;
            monitor-enter(r10)
            int r0 = r10.f16489p     // Catch:{ all -> 0x002f }
            r1 = -1
            if (r0 == 0) goto L_0x002d
            long[] r3 = r10.f16486m     // Catch:{ all -> 0x002f }
            int r5 = r10.f16491r     // Catch:{ all -> 0x002f }
            r6 = r3[r5]     // Catch:{ all -> 0x002f }
            int r3 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x0012
            goto L_0x002d
        L_0x0012:
            if (r14 == 0) goto L_0x001a
            int r14 = r10.f16492s     // Catch:{ all -> 0x002f }
            if (r14 == r0) goto L_0x001a
            int r0 = r14 + 1
        L_0x001a:
            r6 = r0
            r4 = r10
            r7 = r11
            r9 = r13
            int r11 = r4.a(r5, r6, r7, r9)     // Catch:{ all -> 0x002f }
            r12 = -1
            if (r11 != r12) goto L_0x0027
            monitor-exit(r10)
            return r1
        L_0x0027:
            long r11 = r10.f(r11)     // Catch:{ all -> 0x002f }
            monitor-exit(r10)
            return r11
        L_0x002d:
            monitor-exit(r10)
            return r1
        L_0x002f:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.n.b(long, boolean, boolean):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean c(long r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r7.f16489p     // Catch:{ all -> 0x0049 }
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0010
            long r3 = r7.f16493t     // Catch:{ all -> 0x0049 }
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x000e
            r1 = 1
        L_0x000e:
            monitor-exit(r7)
            return r1
        L_0x0010:
            long r3 = r7.f16493t     // Catch:{ all -> 0x0049 }
            int r0 = r7.f16492s     // Catch:{ all -> 0x0049 }
            long r5 = r7.g(r0)     // Catch:{ all -> 0x0049 }
            long r3 = java.lang.Math.max(r3, r5)     // Catch:{ all -> 0x0049 }
            int r0 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x0022
            monitor-exit(r7)
            return r1
        L_0x0022:
            int r0 = r7.f16489p     // Catch:{ all -> 0x0049 }
            int r1 = r0 + -1
            int r1 = r7.h(r1)     // Catch:{ all -> 0x0049 }
        L_0x002a:
            int r3 = r7.f16492s     // Catch:{ all -> 0x0049 }
            if (r0 <= r3) goto L_0x0041
            long[] r3 = r7.f16486m     // Catch:{ all -> 0x0049 }
            r4 = r3[r1]     // Catch:{ all -> 0x0049 }
            int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x0041
            int r0 = r0 + -1
            int r1 = r1 + -1
            r3 = -1
            if (r1 != r3) goto L_0x002a
            int r1 = r7.f16481h     // Catch:{ all -> 0x0049 }
            int r1 = r1 - r2
            goto L_0x002a
        L_0x0041:
            int r8 = r7.f16490q     // Catch:{ all -> 0x0049 }
            int r8 = r8 + r0
            r7.d(r8)     // Catch:{ all -> 0x0049 }
            monitor-exit(r7)
            return r2
        L_0x0049:
            r8 = move-exception
            monitor-exit(r7)
            goto L_0x004d
        L_0x004c:
            throw r8
        L_0x004d:
            goto L_0x004c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.n.c(long):boolean");
    }

    private synchronized boolean c(Format format) {
        if (format == null) {
            this.f16497x = true;
            return false;
        }
        this.f16497x = false;
        if (ad.a((Object) format, (Object) this.f16498y)) {
            return false;
        }
        if (ad.a((Object) format, (Object) this.f16499z)) {
            this.f16498y = this.f16499z;
            return true;
        }
        this.f16498y = format;
        return true;
    }

    private long d(int i2) {
        int d2 = d() - i2;
        boolean z2 = false;
        com.google.android.exoplayer2.util.a.a(d2 >= 0 && d2 <= this.f16489p - this.f16492s);
        int i3 = this.f16489p - d2;
        this.f16489p = i3;
        this.f16494u = Math.max(this.f16493t, g(i3));
        if (d2 == 0 && this.f16495v) {
            z2 = true;
        }
        this.f16495v = z2;
        int i4 = this.f16489p;
        if (i4 == 0) {
            return 0;
        }
        int h2 = h(i4 - 1);
        return this.f16483j[h2] + ((long) this.f16484k[h2]);
    }

    private boolean e(int i2) {
        DrmSession<?> drmSession;
        if (this.f16476c == com.google.android.exoplayer2.drm.b.f15471b || (drmSession = this.f16480g) == null || drmSession.c() == 4) {
            return true;
        }
        return (this.f16485l[i2] & MemoryConstants.GB) == 0 && this.f16480g.d();
    }

    private long f(int i2) {
        this.f16493t = Math.max(this.f16493t, g(i2));
        int i3 = this.f16489p - i2;
        this.f16489p = i3;
        this.f16490q += i2;
        int i4 = this.f16491r + i2;
        this.f16491r = i4;
        int i5 = this.f16481h;
        if (i4 >= i5) {
            this.f16491r = i4 - i5;
        }
        int i6 = this.f16492s - i2;
        this.f16492s = i6;
        if (i6 < 0) {
            this.f16492s = 0;
        }
        if (i3 != 0) {
            return this.f16483j[this.f16491r];
        }
        int i7 = this.f16491r;
        if (i7 != 0) {
            i5 = i7;
        }
        int i8 = i5 - 1;
        return this.f16483j[i8] + ((long) this.f16484k[i8]);
    }

    private long g(int i2) {
        long j2 = Long.MIN_VALUE;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int h2 = h(i2 - 1);
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = Math.max(j2, this.f16486m[h2]);
            if ((this.f16485l[h2] & 1) != 0) {
                break;
            }
            h2--;
            if (h2 == -1) {
                h2 = this.f16481h - 1;
            }
        }
        return j2;
    }

    private int h(int i2) {
        int i3 = this.f16491r + i2;
        int i4 = this.f16481h;
        return i3 < i4 ? i3 : i3 - i4;
    }

    private synchronized void s() {
        this.f16492s = 0;
        this.f16474a.b();
    }

    private synchronized long t() {
        int i2 = this.f16489p;
        if (i2 == 0) {
            return -1;
        }
        return f(i2);
    }

    private void u() {
        DrmSession<?> drmSession = this.f16480g;
        if (drmSession != null) {
            drmSession.i();
            this.f16480g = null;
            this.f16479f = null;
        }
    }

    private boolean v() {
        return this.f16492s != this.f16489p;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int a(long r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.f16492s     // Catch:{ all -> 0x0032 }
            int r2 = r8.h(r0)     // Catch:{ all -> 0x0032 }
            boolean r0 = r8.v()     // Catch:{ all -> 0x0032 }
            r7 = 0
            if (r0 == 0) goto L_0x0030
            long[] r0 = r8.f16486m     // Catch:{ all -> 0x0032 }
            r3 = r0[r2]     // Catch:{ all -> 0x0032 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0017
            goto L_0x0030
        L_0x0017:
            int r0 = r8.f16489p     // Catch:{ all -> 0x0032 }
            int r1 = r8.f16492s     // Catch:{ all -> 0x0032 }
            int r3 = r0 - r1
            r6 = 1
            r1 = r8
            r4 = r9
            int r9 = r1.a(r2, r3, r4, r6)     // Catch:{ all -> 0x0032 }
            r10 = -1
            if (r9 != r10) goto L_0x0029
            monitor-exit(r8)
            return r7
        L_0x0029:
            int r10 = r8.f16492s     // Catch:{ all -> 0x0032 }
            int r10 = r10 + r9
            r8.f16492s = r10     // Catch:{ all -> 0x0032 }
            monitor-exit(r8)
            return r9
        L_0x0030:
            monitor-exit(r8)
            return r7
        L_0x0032:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.n.a(long):int");
    }

    public int a(o oVar, e eVar, boolean z2, boolean z3, long j2) {
        int a2 = a(oVar, eVar, z2, z3, j2, this.f16475b);
        if (a2 == -4 && !eVar.isEndOfStream() && !eVar.b()) {
            this.f16474a.a(eVar, this.f16475b);
        }
        return a2;
    }

    public final int a(h hVar, int i2, boolean z2) throws IOException, InterruptedException {
        return this.f16474a.a(hVar, i2, z2);
    }

    public void a() {
        a(true);
        u();
    }

    public final void a(int i2) {
        this.A = i2;
    }

    public final void a(long j2, int i2, int i3, int i4, u.a aVar) {
        if (this.B) {
            a(this.C);
        }
        long j3 = j2 + this.D;
        if (this.E) {
            if ((i2 & 1) != 0 && c(j3)) {
                this.E = false;
            } else {
                return;
            }
        }
        a(j3, i2, (this.f16474a.c() - ((long) i3)) - ((long) i4), i3, aVar);
    }

    public final void a(long j2, boolean z2, boolean z3) {
        this.f16474a.b(b(j2, z2, z3));
    }

    public final void a(Format format) {
        Format b2 = b(format);
        this.B = false;
        this.C = format;
        boolean c2 = c(b2);
        b bVar = this.f16477d;
        if (bVar != null && c2) {
            bVar.a(b2);
        }
    }

    public final void a(b bVar) {
        this.f16477d = bVar;
    }

    public final void a(q qVar, int i2) {
        this.f16474a.a(qVar, i2);
    }

    public void a(boolean z2) {
        this.f16474a.a();
        this.f16489p = 0;
        this.f16490q = 0;
        this.f16491r = 0;
        this.f16492s = 0;
        this.f16496w = true;
        this.f16493t = Long.MIN_VALUE;
        this.f16494u = Long.MIN_VALUE;
        this.f16495v = false;
        this.f16499z = null;
        if (z2) {
            this.C = null;
            this.f16498y = null;
            this.f16497x = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.s()     // Catch:{ all -> 0x003e }
            int r0 = r8.f16492s     // Catch:{ all -> 0x003e }
            int r2 = r8.h(r0)     // Catch:{ all -> 0x003e }
            boolean r0 = r8.v()     // Catch:{ all -> 0x003e }
            r7 = 0
            if (r0 == 0) goto L_0x003c
            long[] r0 = r8.f16486m     // Catch:{ all -> 0x003e }
            r3 = r0[r2]     // Catch:{ all -> 0x003e }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x003c
            long r0 = r8.f16494u     // Catch:{ all -> 0x003e }
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0022
            if (r11 != 0) goto L_0x0022
            goto L_0x003c
        L_0x0022:
            int r11 = r8.f16489p     // Catch:{ all -> 0x003e }
            int r0 = r8.f16492s     // Catch:{ all -> 0x003e }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r9 = r1.a(r2, r3, r4, r6)     // Catch:{ all -> 0x003e }
            r10 = -1
            if (r9 != r10) goto L_0x0034
            monitor-exit(r8)
            return r7
        L_0x0034:
            int r10 = r8.f16492s     // Catch:{ all -> 0x003e }
            int r10 = r10 + r9
            r8.f16492s = r10     // Catch:{ all -> 0x003e }
            r9 = 1
            monitor-exit(r8)
            return r9
        L_0x003c:
            monitor-exit(r8)
            return r7
        L_0x003e:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.n.a(long, boolean):boolean");
    }

    /* access modifiers changed from: protected */
    public Format b(Format format) {
        return (this.D == 0 || format.f15096m == Long.MAX_VALUE) ? format : format.a(format.f15096m + this.D);
    }

    public final void b() {
        a(false);
    }

    public final void b(int i2) {
        this.f16474a.a(d(i2));
    }

    public final void b(long j2) {
        if (this.D != j2) {
            this.D = j2;
            q();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean b(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.v()     // Catch:{ all -> 0x0030 }
            r1 = 1
            if (r0 != 0) goto L_0x001a
            if (r4 != 0) goto L_0x0018
            boolean r4 = r3.f16495v     // Catch:{ all -> 0x0030 }
            if (r4 != 0) goto L_0x0018
            com.google.android.exoplayer2.Format r4 = r3.f16498y     // Catch:{ all -> 0x0030 }
            if (r4 == 0) goto L_0x0017
            com.google.android.exoplayer2.Format r0 = r3.f16479f     // Catch:{ all -> 0x0030 }
            if (r4 == r0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            monitor-exit(r3)
            return r1
        L_0x001a:
            int r4 = r3.f16492s     // Catch:{ all -> 0x0030 }
            int r4 = r3.h(r4)     // Catch:{ all -> 0x0030 }
            com.google.android.exoplayer2.Format[] r0 = r3.f16488o     // Catch:{ all -> 0x0030 }
            r0 = r0[r4]     // Catch:{ all -> 0x0030 }
            com.google.android.exoplayer2.Format r2 = r3.f16479f     // Catch:{ all -> 0x0030 }
            if (r0 == r2) goto L_0x002a
            monitor-exit(r3)
            return r1
        L_0x002a:
            boolean r4 = r3.e(r4)     // Catch:{ all -> 0x0030 }
            monitor-exit(r3)
            return r4
        L_0x0030:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.n.b(boolean):boolean");
    }

    public final void c() {
        this.E = true;
    }

    public final synchronized boolean c(int i2) {
        boolean z2;
        s();
        int i3 = this.f16490q;
        if (i2 >= i3) {
            if (i2 <= this.f16489p + i3) {
                this.f16492s = i2 - i3;
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public final int d() {
        return this.f16490q + this.f16489p;
    }

    public void e() {
        p();
        u();
    }

    public void f() throws IOException {
        DrmSession<?> drmSession = this.f16480g;
        if (drmSession != null && drmSession.c() == 1) {
            throw ((DrmSession.DrmSessionException) com.google.android.exoplayer2.util.a.b(this.f16480g.e()));
        }
    }

    public final int g() {
        return this.f16490q;
    }

    public final int h() {
        return this.f16490q + this.f16492s;
    }

    public final synchronized int i() {
        return v() ? this.f16482i[h(this.f16492s)] : this.A;
    }

    public final synchronized Format j() {
        return this.f16497x ? null : this.f16498y;
    }

    public final synchronized long k() {
        return this.f16494u;
    }

    public final synchronized boolean l() {
        return this.f16495v;
    }

    public final synchronized long m() {
        return this.f16489p == 0 ? Long.MIN_VALUE : this.f16486m[this.f16491r];
    }

    public final synchronized int n() {
        int i2;
        int i3 = this.f16489p;
        i2 = i3 - this.f16492s;
        this.f16492s = i3;
        return i2;
    }

    public final void o() {
        this.f16474a.b(r());
    }

    public final void p() {
        this.f16474a.b(t());
    }

    /* access modifiers changed from: protected */
    public final void q() {
        this.B = true;
    }

    public synchronized long r() {
        int i2 = this.f16492s;
        if (i2 == 0) {
            return -1;
        }
        return f(i2);
    }
}
