package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.f;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;

public class h implements p {

    /* renamed from: a  reason: collision with root package name */
    private final i f15668a;

    /* renamed from: b  reason: collision with root package name */
    private final long f15669b;

    /* renamed from: c  reason: collision with root package name */
    private final long f15670c;

    /* renamed from: d  reason: collision with root package name */
    private final long f15671d;

    /* renamed from: e  reason: collision with root package name */
    private final long f15672e;

    /* renamed from: f  reason: collision with root package name */
    private final long f15673f;

    /* renamed from: g  reason: collision with root package name */
    private final int f15674g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f15675h;

    /* renamed from: i  reason: collision with root package name */
    private final long f15676i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f15677j;

    /* renamed from: k  reason: collision with root package name */
    private int f15678k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f15679l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f15680m;

    public h() {
        this(new i(true, 65536));
    }

    @Deprecated
    public h(i iVar) {
        this(iVar, 15000, 50000, 50000, 2500, 5000, -1, true, 0, false);
    }

    protected h(i iVar, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2, int i8, boolean z3) {
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        int i13 = i8;
        a(i11, 0, "bufferForPlaybackMs", "0");
        a(i12, 0, "bufferForPlaybackAfterRebufferMs", "0");
        a(i2, i11, "minBufferAudioMs", "bufferForPlaybackMs");
        a(i9, i11, "minBufferVideoMs", "bufferForPlaybackMs");
        a(i2, i12, "minBufferAudioMs", "bufferForPlaybackAfterRebufferMs");
        a(i9, i12, "minBufferVideoMs", "bufferForPlaybackAfterRebufferMs");
        a(i10, i2, "maxBufferMs", "minBufferAudioMs");
        a(i10, i9, "maxBufferMs", "minBufferVideoMs");
        a(i13, 0, "backBufferDurationMs", "0");
        this.f15668a = iVar;
        this.f15669b = e.b((long) i2);
        this.f15670c = e.b((long) i9);
        this.f15671d = e.b((long) i10);
        this.f15672e = e.b((long) i11);
        this.f15673f = e.b((long) i12);
        this.f15674g = i7;
        this.f15675h = z2;
        this.f15676i = e.b((long) i13);
        this.f15677j = z3;
    }

    private static int a(int i2) {
        switch (i2) {
            case 0:
                return 36438016;
            case 1:
                return 3538944;
            case 2:
                return 32768000;
            case 3:
            case 4:
            case 5:
                return 131072;
            case 6:
                return 0;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static void a(int i2, int i3, String str, String str2) {
        boolean z2 = i2 >= i3;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" cannot be less than ");
        sb.append(str2);
        a.a(z2, (Object) sb.toString());
    }

    private void a(boolean z2) {
        this.f15678k = 0;
        this.f15679l = false;
        if (z2) {
            this.f15668a.d();
        }
    }

    private static boolean b(z[] zVarArr, f fVar) {
        for (int i2 = 0; i2 < zVarArr.length; i2++) {
            if (zVarArr[i2].a() == 2 && fVar.a(i2) != null) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int a(z[] zVarArr, f fVar) {
        int i2 = 0;
        for (int i3 = 0; i3 < zVarArr.length; i3++) {
            if (fVar.a(i3) != null) {
                i2 += a(zVarArr[i3].a());
            }
        }
        return i2;
    }

    public void a() {
        a(false);
    }

    public void a(z[] zVarArr, TrackGroupArray trackGroupArray, f fVar) {
        this.f15680m = b(zVarArr, fVar);
        int i2 = this.f15674g;
        if (i2 == -1) {
            i2 = a(zVarArr, fVar);
        }
        this.f15678k = i2;
        this.f15668a.a(i2);
    }

    public boolean a(long j2, float f2) {
        boolean z2 = true;
        boolean z3 = this.f15668a.e() >= this.f15678k;
        long j3 = this.f15680m ? this.f15670c : this.f15669b;
        if (f2 > 1.0f) {
            j3 = Math.min(ad.a(j3, f2), this.f15671d);
        }
        if (j2 < j3) {
            if (!this.f15675h && z3) {
                z2 = false;
            }
            this.f15679l = z2;
        } else if (j2 >= this.f15671d || z3) {
            this.f15679l = false;
        }
        return this.f15679l;
    }

    public boolean a(long j2, float f2, boolean z2) {
        long b2 = ad.b(j2, f2);
        long j3 = z2 ? this.f15673f : this.f15672e;
        return j3 <= 0 || b2 >= j3 || (!this.f15675h && this.f15668a.e() >= this.f15678k);
    }

    public void b() {
        a(true);
    }

    public void c() {
        a(true);
    }

    public b d() {
        return this.f15668a;
    }

    public long e() {
        return this.f15676i;
    }

    public boolean f() {
        return this.f15677j;
    }
}
