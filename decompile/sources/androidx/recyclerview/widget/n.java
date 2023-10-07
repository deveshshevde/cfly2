package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class n {

    /* renamed from: a  reason: collision with root package name */
    boolean f4293a = true;

    /* renamed from: b  reason: collision with root package name */
    int f4294b;

    /* renamed from: c  reason: collision with root package name */
    int f4295c;

    /* renamed from: d  reason: collision with root package name */
    int f4296d;

    /* renamed from: e  reason: collision with root package name */
    int f4297e;

    /* renamed from: f  reason: collision with root package name */
    int f4298f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f4299g = 0;

    /* renamed from: h  reason: collision with root package name */
    boolean f4300h;

    /* renamed from: i  reason: collision with root package name */
    boolean f4301i;

    n() {
    }

    /* access modifiers changed from: package-private */
    public View a(RecyclerView.n nVar) {
        View c2 = nVar.c(this.f4295c);
        this.f4295c += this.f4296d;
        return c2;
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.s sVar) {
        int i2 = this.f4295c;
        return i2 >= 0 && i2 < sVar.e();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f4294b + ", mCurrentPosition=" + this.f4295c + ", mItemDirection=" + this.f4296d + ", mLayoutDirection=" + this.f4297e + ", mStartLine=" + this.f4298f + ", mEndLine=" + this.f4299g + '}';
    }
}
