package fj;

import com.google.android.exoplayer2.util.ad;
import fj.s;
import java.util.Arrays;

public final class b implements s {

    /* renamed from: a  reason: collision with root package name */
    public final int f27350a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f27351b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f27352c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f27353d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f27354e;

    /* renamed from: f  reason: collision with root package name */
    private final long f27355f;

    public b(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f27351b = iArr;
        this.f27352c = jArr;
        this.f27353d = jArr2;
        this.f27354e = jArr3;
        int length = iArr.length;
        this.f27350a = length;
        if (length > 0) {
            this.f27355f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f27355f = 0;
        }
    }

    public s.a a(long j2) {
        int b2 = b(j2);
        t tVar = new t(this.f27354e[b2], this.f27352c[b2]);
        if (tVar.f27407b >= j2 || b2 == this.f27350a - 1) {
            return new s.a(tVar);
        }
        int i2 = b2 + 1;
        return new s.a(tVar, new t(this.f27354e[i2], this.f27352c[i2]));
    }

    public boolean a() {
        return true;
    }

    public int b(long j2) {
        return ad.a(this.f27354e, j2, true, true);
    }

    public long b() {
        return this.f27355f;
    }

    public String toString() {
        int i2 = this.f27350a;
        String arrays = Arrays.toString(this.f27351b);
        String arrays2 = Arrays.toString(this.f27352c);
        String arrays3 = Arrays.toString(this.f27354e);
        String arrays4 = Arrays.toString(this.f27353d);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 71 + String.valueOf(arrays2).length() + String.valueOf(arrays3).length() + String.valueOf(arrays4).length());
        sb.append("ChunkIndex(length=");
        sb.append(i2);
        sb.append(", sizes=");
        sb.append(arrays);
        sb.append(", offsets=");
        sb.append(arrays2);
        sb.append(", timeUs=");
        sb.append(arrays3);
        sb.append(", durationsUs=");
        sb.append(arrays4);
        sb.append(")");
        return sb.toString();
    }
}
