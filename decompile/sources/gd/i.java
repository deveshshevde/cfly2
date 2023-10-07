package gd;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import gd.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class i implements e {

    /* renamed from: a  reason: collision with root package name */
    private final List<e> f28462a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28463b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f28464c;

    /* renamed from: d  reason: collision with root package name */
    private final long[] f28465d;

    public i(List<e> list) {
        this.f28462a = list;
        int size = list.size();
        this.f28463b = size;
        this.f28464c = new long[(size * 2)];
        for (int i2 = 0; i2 < this.f28463b; i2++) {
            e eVar = list.get(i2);
            int i3 = i2 * 2;
            this.f28464c[i3] = eVar.f28434p;
            this.f28464c[i3 + 1] = eVar.f28435q;
        }
        long[] jArr = this.f28464c;
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        this.f28465d = copyOf;
        Arrays.sort(copyOf);
    }

    public int a() {
        return this.f28465d.length;
    }

    public int a(long j2) {
        int b2 = ad.b(this.f28465d, j2, false, false);
        if (b2 < this.f28465d.length) {
            return b2;
        }
        return -1;
    }

    public long a(int i2) {
        boolean z2 = true;
        a.a(i2 >= 0);
        if (i2 >= this.f28465d.length) {
            z2 = false;
        }
        a.a(z2);
        return this.f28465d[i2];
    }

    public List<b> b(long j2) {
        SpannableStringBuilder append;
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = null;
        e eVar = null;
        for (int i2 = 0; i2 < this.f28463b; i2++) {
            long[] jArr = this.f28464c;
            int i3 = i2 * 2;
            if (jArr[i3] <= j2 && j2 < jArr[i3 + 1]) {
                e eVar2 = this.f28462a.get(i2);
                if (!eVar2.a()) {
                    arrayList.add(eVar2);
                } else if (eVar == null) {
                    eVar = eVar2;
                } else {
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        append = spannableStringBuilder.append((CharSequence) a.b(eVar.f16585b)).append("\n");
                    } else {
                        append = spannableStringBuilder.append("\n");
                    }
                    append.append((CharSequence) a.b(eVar2.f16585b));
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new e.a().a((CharSequence) spannableStringBuilder).b());
        } else if (eVar != null) {
            arrayList.add(eVar);
        }
        return arrayList;
    }
}
