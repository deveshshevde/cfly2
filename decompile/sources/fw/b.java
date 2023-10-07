package fw;

import android.text.Layout;

final class b extends com.google.android.exoplayer2.text.b implements Comparable<b> {

    /* renamed from: p  reason: collision with root package name */
    public final int f28202p;

    public b(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4, boolean z2, int i5, int i6) {
        super(charSequence, alignment, f2, i2, i3, f3, i4, f4, z2, i5);
        this.f28202p = i6;
    }

    /* renamed from: a */
    public int compareTo(b bVar) {
        int i2 = bVar.f28202p;
        int i3 = this.f28202p;
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }
}
