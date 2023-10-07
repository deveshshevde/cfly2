package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

public class o extends RecyclerView.r {

    /* renamed from: a  reason: collision with root package name */
    protected final LinearInterpolator f4302a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    protected final DecelerateInterpolator f4303b = new DecelerateInterpolator();

    /* renamed from: c  reason: collision with root package name */
    protected PointF f4304c;

    /* renamed from: d  reason: collision with root package name */
    protected int f4305d = 0;

    /* renamed from: e  reason: collision with root package name */
    protected int f4306e = 0;

    /* renamed from: f  reason: collision with root package name */
    private final DisplayMetrics f4307f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4308g = false;

    /* renamed from: h  reason: collision with root package name */
    private float f4309h;

    public o(Context context) {
        this.f4307f = context.getResources().getDisplayMetrics();
    }

    private int b(int i2, int i3) {
        int i4 = i2 - i3;
        if (i2 * i4 <= 0) {
            return 0;
        }
        return i4;
    }

    private float k() {
        if (!this.f4308g) {
            this.f4309h = a(this.f4307f);
            this.f4308g = true;
        }
        return this.f4309h;
    }

    /* access modifiers changed from: protected */
    public float a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    /* access modifiers changed from: protected */
    public int a(int i2) {
        double b2 = (double) b(i2);
        Double.isNaN(b2);
        return (int) Math.ceil(b2 / 0.3356d);
    }

    public int a(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == -1) {
            return i4 - i2;
        }
        if (i6 == 0) {
            int i7 = i4 - i2;
            if (i7 > 0) {
                return i7;
            }
            int i8 = i5 - i3;
            if (i8 < 0) {
                return i8;
            }
            return 0;
        } else if (i6 == 1) {
            return i5 - i3;
        } else {
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int a(View view, int i2) {
        RecyclerView.h e2 = e();
        if (e2 == null || !e2.g()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return a(e2.i(view) - layoutParams.topMargin, e2.k(view) + layoutParams.bottomMargin, e2.F(), e2.D() - e2.H(), i2);
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3, RecyclerView.s sVar, RecyclerView.r.a aVar) {
        if (j() == 0) {
            f();
            return;
        }
        this.f4305d = b(this.f4305d, i2);
        int b2 = b(this.f4306e, i3);
        this.f4306e = b2;
        if (this.f4305d == 0 && b2 == 0) {
            a(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void a(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
        int b2 = b(view, c());
        int a2 = a(view, d());
        int a3 = a((int) Math.sqrt((double) ((b2 * b2) + (a2 * a2))));
        if (a3 > 0) {
            aVar.a(-b2, -a2, a3, this.f4303b);
        }
    }

    /* access modifiers changed from: protected */
    public void a(RecyclerView.r.a aVar) {
        PointF d2 = d(i());
        if (d2 == null || (d2.x == 0.0f && d2.y == 0.0f)) {
            aVar.a(i());
            f();
            return;
        }
        a(d2);
        this.f4304c = d2;
        this.f4305d = (int) (d2.x * 10000.0f);
        this.f4306e = (int) (d2.y * 10000.0f);
        aVar.a((int) (((float) this.f4305d) * 1.2f), (int) (((float) this.f4306e) * 1.2f), (int) (((float) b(10000)) * 1.2f), this.f4302a);
    }

    /* access modifiers changed from: protected */
    public int b(int i2) {
        return (int) Math.ceil((double) (((float) Math.abs(i2)) * k()));
    }

    public int b(View view, int i2) {
        RecyclerView.h e2 = e();
        if (e2 == null || !e2.f()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return a(e2.h(view) - layoutParams.leftMargin, e2.j(view) + layoutParams.rightMargin, e2.E(), e2.C() - e2.G(), i2);
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f4306e = 0;
        this.f4305d = 0;
        this.f4304c = null;
    }

    /* access modifiers changed from: protected */
    public int c() {
        PointF pointF = this.f4304c;
        if (pointF == null || pointF.x == 0.0f) {
            return 0;
        }
        return this.f4304c.x > 0.0f ? 1 : -1;
    }

    /* access modifiers changed from: protected */
    public int d() {
        PointF pointF = this.f4304c;
        if (pointF == null || pointF.y == 0.0f) {
            return 0;
        }
        return this.f4304c.y > 0.0f ? 1 : -1;
    }
}
