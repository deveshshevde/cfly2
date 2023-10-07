package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
public final class i {

    /* renamed from: a  reason: collision with root package name */
    OverScroller f3075a;

    i(Context context, Interpolator interpolator) {
        OverScroller overScroller;
        if (interpolator == null) {
            overScroller = new OverScroller(context);
        }
        this.f3075a = overScroller;
    }

    @Deprecated
    public static i a(Context context, Interpolator interpolator) {
        return new i(context, interpolator);
    }

    @Deprecated
    public void a(int i2, int i3, int i4, int i5, int i6) {
        this.f3075a.startScroll(i2, i3, i4, i5, i6);
    }

    @Deprecated
    public boolean a() {
        return this.f3075a.isFinished();
    }

    @Deprecated
    public int b() {
        return this.f3075a.getCurrX();
    }

    @Deprecated
    public int c() {
        return this.f3075a.getCurrY();
    }

    @Deprecated
    public int d() {
        return this.f3075a.getFinalX();
    }

    @Deprecated
    public int e() {
        return this.f3075a.getFinalY();
    }

    @Deprecated
    public boolean f() {
        return this.f3075a.computeScrollOffset();
    }

    @Deprecated
    public void g() {
        this.f3075a.abortAnimation();
    }
}
