package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class d extends ViewPager2.e {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayoutManager f5028a;

    /* renamed from: b  reason: collision with root package name */
    private ViewPager2.g f5029b;

    d(LinearLayoutManager linearLayoutManager) {
        this.f5028a = linearLayoutManager;
    }

    /* access modifiers changed from: package-private */
    public ViewPager2.g a() {
        return this.f5029b;
    }

    public void a(int i2) {
    }

    public void a(int i2, float f2, int i3) {
        if (this.f5029b != null) {
            float f3 = -f2;
            int i4 = 0;
            while (i4 < this.f5028a.z()) {
                View i5 = this.f5028a.i(i4);
                if (i5 != null) {
                    this.f5029b.a(i5, ((float) (this.f5028a.d(i5) - i2)) + f3);
                    i4++;
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.f5028a.z())}));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ViewPager2.g gVar) {
        this.f5029b = gVar;
    }

    public void b(int i2) {
    }
}
