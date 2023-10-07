package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

final class b extends ViewPager2.e {

    /* renamed from: a  reason: collision with root package name */
    private final List<ViewPager2.e> f5024a;

    b(int i2) {
        this.f5024a = new ArrayList(i2);
    }

    private void a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    public void a(int i2) {
        try {
            for (ViewPager2.e a2 : this.f5024a) {
                a2.a(i2);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
        }
    }

    public void a(int i2, float f2, int i3) {
        try {
            for (ViewPager2.e a2 : this.f5024a) {
                a2.a(i2, f2, i3);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ViewPager2.e eVar) {
        this.f5024a.add(eVar);
    }

    public void b(int i2) {
        try {
            for (ViewPager2.e b2 : this.f5024a) {
                b2.b(i2);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
        }
    }
}
