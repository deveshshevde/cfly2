package er;

import android.content.Context;
import android.widget.Scroller;

public class c extends d {

    /* renamed from: a  reason: collision with root package name */
    private final Scroller f26955a;

    public c(Context context) {
        this.f26955a = new Scroller(context);
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.f26955a.fling(i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public void a(boolean z2) {
        this.f26955a.forceFinished(z2);
    }

    public boolean a() {
        return this.f26955a.computeScrollOffset();
    }

    public boolean b() {
        return this.f26955a.isFinished();
    }

    public int c() {
        return this.f26955a.getCurrX();
    }

    public int d() {
        return this.f26955a.getCurrY();
    }
}
