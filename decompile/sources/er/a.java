package er;

import android.content.Context;
import android.widget.OverScroller;

public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    protected final OverScroller f26953a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f26954b = false;

    public a(Context context) {
        this.f26953a = new OverScroller(context);
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.f26953a.fling(i2, i3, i4, i5, i6, i7, i8, i9, i10, i11);
    }

    public void a(boolean z2) {
        this.f26953a.forceFinished(z2);
    }

    public boolean a() {
        if (this.f26954b) {
            this.f26953a.computeScrollOffset();
            this.f26954b = false;
        }
        return this.f26953a.computeScrollOffset();
    }

    public boolean b() {
        return this.f26953a.isFinished();
    }

    public int c() {
        return this.f26953a.getCurrX();
    }

    public int d() {
        return this.f26953a.getCurrY();
    }
}
