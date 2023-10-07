package ga;

import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import java.util.Collections;
import java.util.List;

final class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.text.b[] f28361a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f28362b;

    public b(com.google.android.exoplayer2.text.b[] bVarArr, long[] jArr) {
        this.f28361a = bVarArr;
        this.f28362b = jArr;
    }

    public int a() {
        return this.f28362b.length;
    }

    public int a(long j2) {
        int b2 = ad.b(this.f28362b, j2, false, false);
        if (b2 < this.f28362b.length) {
            return b2;
        }
        return -1;
    }

    public long a(int i2) {
        boolean z2 = true;
        a.a(i2 >= 0);
        if (i2 >= this.f28362b.length) {
            z2 = false;
        }
        a.a(z2);
        return this.f28362b[i2];
    }

    public List<com.google.android.exoplayer2.text.b> b(long j2) {
        int a2 = ad.a(this.f28362b, j2, true, false);
        return (a2 == -1 || this.f28361a[a2] == com.google.android.exoplayer2.text.b.f16584a) ? Collections.emptyList() : Collections.singletonList(this.f28361a[a2]);
    }
}
