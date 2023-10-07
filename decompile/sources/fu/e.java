package fu;

import java.util.List;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f28137a;

    /* renamed from: b  reason: collision with root package name */
    public final long f28138b;

    /* renamed from: c  reason: collision with root package name */
    public final List<a> f28139c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d> f28140d;

    public int a(int i2) {
        int size = this.f28139c.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f28139c.get(i3).f28115b == i2) {
                return i3;
            }
        }
        return -1;
    }
}
