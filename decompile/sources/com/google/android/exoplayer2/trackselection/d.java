package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.aa;
import com.google.android.exoplayer2.ab;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.n;
import java.util.Arrays;

public abstract class d extends g {

    /* renamed from: a  reason: collision with root package name */
    private a f16732a;

    public static final class a {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public final int f16733a;

        /* renamed from: b  reason: collision with root package name */
        private final int f16734b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f16735c;

        /* renamed from: d  reason: collision with root package name */
        private final TrackGroupArray[] f16736d;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f16737e;

        /* renamed from: f  reason: collision with root package name */
        private final int[][][] f16738f;

        /* renamed from: g  reason: collision with root package name */
        private final TrackGroupArray f16739g;

        a(int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.f16735c = iArr;
            this.f16736d = trackGroupArrayArr;
            this.f16738f = iArr3;
            this.f16737e = iArr2;
            this.f16739g = trackGroupArray;
            int length = iArr.length;
            this.f16734b = length;
            this.f16733a = length;
        }

        public int a() {
            return this.f16734b;
        }

        public int a(int i2) {
            return this.f16735c[i2];
        }

        public int a(int i2, int i3, int i4) {
            return aa.CC.c(this.f16738f[i2][i3][i4]);
        }

        public int a(int i2, int i3, boolean z2) {
            int i4 = this.f16736d[i2].a(i3).f16005a;
            int[] iArr = new int[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                int a2 = a(i2, i3, i6);
                if (a2 == 4 || (z2 && a2 == 3)) {
                    iArr[i5] = i6;
                    i5++;
                }
            }
            return a(i2, i3, Arrays.copyOf(iArr, i5));
        }

        public int a(int i2, int i3, int[] iArr) {
            int i4 = 0;
            String str = null;
            boolean z2 = false;
            int i5 = 0;
            int i6 = 16;
            while (i4 < iArr.length) {
                String str2 = this.f16736d[i2].a(i3).a(iArr[i4]).f15092i;
                int i7 = i5 + 1;
                if (i5 == 0) {
                    str = str2;
                } else {
                    z2 |= !ad.a((Object) str, (Object) str2);
                }
                i6 = Math.min(i6, aa.CC.d(this.f16738f[i2][i3][i4]));
                i4++;
                i5 = i7;
            }
            return z2 ? Math.min(i6, this.f16737e[i2]) : i6;
        }

        public TrackGroupArray b(int i2) {
            return this.f16736d[i2];
        }
    }

    private static int a(aa[] aaVarArr, TrackGroup trackGroup, int[] iArr, boolean z2) throws ExoPlaybackException {
        int length = aaVarArr.length;
        int i2 = 0;
        boolean z3 = true;
        for (int i3 = 0; i3 < aaVarArr.length; i3++) {
            aa aaVar = aaVarArr[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < trackGroup.f16005a; i5++) {
                i4 = Math.max(i4, aa.CC.c(aaVar.a(trackGroup.a(i5))));
            }
            boolean z4 = iArr[i3] == 0;
            if (i4 > i2 || (i4 == i2 && z2 && !z3 && z4)) {
                length = i3;
                z3 = z4;
                i2 = i4;
            }
        }
        return length;
    }

    private static int[] a(aa aaVar, TrackGroup trackGroup) throws ExoPlaybackException {
        int[] iArr = new int[trackGroup.f16005a];
        for (int i2 = 0; i2 < trackGroup.f16005a; i2++) {
            iArr[i2] = aaVar.a(trackGroup.a(i2));
        }
        return iArr;
    }

    private static int[] a(aa[] aaVarArr) throws ExoPlaybackException {
        int length = aaVarArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = aaVarArr[i2].o();
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public abstract Pair<ab[], e[]> a(a aVar, int[][][] iArr, int[] iArr2) throws ExoPlaybackException;

    public final h a(aa[] aaVarArr, TrackGroupArray trackGroupArray, i.a aVar, af afVar) throws ExoPlaybackException {
        int[] iArr = new int[(aaVarArr.length + 1)];
        int length = aaVarArr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr2 = new int[(aaVarArr.length + 1)][][];
        for (int i2 = 0; i2 < length; i2++) {
            trackGroupArr[i2] = new TrackGroup[trackGroupArray.f16009b];
            iArr2[i2] = new int[trackGroupArray.f16009b][];
        }
        int[] a2 = a(aaVarArr);
        for (int i3 = 0; i3 < trackGroupArray.f16009b; i3++) {
            TrackGroup a3 = trackGroupArray.a(i3);
            int a4 = a(aaVarArr, a3, iArr, n.h(a3.a(0).f15092i) == 4);
            int[] a5 = a4 == aaVarArr.length ? new int[a3.f16005a] : a(aaVarArr[a4], a3);
            int i4 = iArr[a4];
            trackGroupArr[a4][i4] = a3;
            iArr2[a4][i4] = a5;
            iArr[a4] = iArr[a4] + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[aaVarArr.length];
        int[] iArr3 = new int[aaVarArr.length];
        for (int i5 = 0; i5 < aaVarArr.length; i5++) {
            int i6 = iArr[i5];
            trackGroupArrayArr[i5] = new TrackGroupArray((TrackGroup[]) ad.a((T[]) trackGroupArr[i5], i6));
            iArr2[i5] = (int[][]) ad.a((T[]) iArr2[i5], i6);
            iArr3[i5] = aaVarArr[i5].a();
        }
        a aVar2 = new a(iArr3, trackGroupArrayArr, a2, iArr2, new TrackGroupArray((TrackGroup[]) ad.a((T[]) trackGroupArr[aaVarArr.length], iArr[aaVarArr.length])));
        Pair<ab[], e[]> a6 = a(aVar2, iArr2, a2);
        return new h((ab[]) a6.first, (e[]) a6.second, aVar2);
    }

    public final void a(Object obj) {
        this.f16732a = (a) obj;
    }
}
