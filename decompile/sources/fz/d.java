package fz;

import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import java.util.Collections;
import java.util.List;

final class d implements e {

    /* renamed from: a  reason: collision with root package name */
    private final List<List<b>> f28345a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Long> f28346b;

    public d(List<List<b>> list, List<Long> list2) {
        this.f28345a = list;
        this.f28346b = list2;
    }

    public int a() {
        return this.f28346b.size();
    }

    public int a(long j2) {
        int b2 = ad.b(this.f28346b, Long.valueOf(j2), false, false);
        if (b2 < this.f28346b.size()) {
            return b2;
        }
        return -1;
    }

    public long a(int i2) {
        boolean z2 = true;
        a.a(i2 >= 0);
        if (i2 >= this.f28346b.size()) {
            z2 = false;
        }
        a.a(z2);
        return this.f28346b.get(i2).longValue();
    }

    public List<b> b(long j2) {
        int a2 = ad.a(this.f28346b, Long.valueOf(j2), true, false);
        return a2 == -1 ? Collections.emptyList() : this.f28345a.get(a2);
    }
}
