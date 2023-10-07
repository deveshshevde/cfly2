package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class e extends RecyclerView.l {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager2.e f5030a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewPager2 f5031b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView f5032c;

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayoutManager f5033d;

    /* renamed from: e  reason: collision with root package name */
    private int f5034e;

    /* renamed from: f  reason: collision with root package name */
    private int f5035f;

    /* renamed from: g  reason: collision with root package name */
    private a f5036g = new a();

    /* renamed from: h  reason: collision with root package name */
    private int f5037h;

    /* renamed from: i  reason: collision with root package name */
    private int f5038i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5039j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5040k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5041l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f5042m;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f5043a;

        /* renamed from: b  reason: collision with root package name */
        float f5044b;

        /* renamed from: c  reason: collision with root package name */
        int f5045c;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f5043a = -1;
            this.f5044b = 0.0f;
            this.f5045c = 0;
        }
    }

    e(ViewPager2 viewPager2) {
        this.f5031b = viewPager2;
        RecyclerView recyclerView = viewPager2.f4983d;
        this.f5032c = recyclerView;
        this.f5033d = (LinearLayoutManager) recyclerView.getLayoutManager();
        f();
    }

    private void a(int i2) {
        if ((this.f5034e != 3 || this.f5035f != 0) && this.f5035f != i2) {
            this.f5035f = i2;
            ViewPager2.e eVar = this.f5030a;
            if (eVar != null) {
                eVar.b(i2);
            }
        }
    }

    private void a(int i2, float f2, int i3) {
        ViewPager2.e eVar = this.f5030a;
        if (eVar != null) {
            eVar.a(i2, f2, i3);
        }
    }

    private void a(boolean z2) {
        this.f5042m = z2;
        this.f5034e = z2 ? 4 : 1;
        int i2 = this.f5038i;
        if (i2 != -1) {
            this.f5037h = i2;
            this.f5038i = -1;
        } else if (this.f5037h == -1) {
            this.f5037h = i();
        }
        a(1);
    }

    private void b(int i2) {
        ViewPager2.e eVar = this.f5030a;
        if (eVar != null) {
            eVar.a(i2);
        }
    }

    private void f() {
        this.f5034e = 0;
        this.f5035f = 0;
        this.f5036g.a();
        this.f5037h = -1;
        this.f5038i = -1;
        this.f5039j = false;
        this.f5040k = false;
        this.f5042m = false;
        this.f5041l = false;
    }

    private void g() {
        int i2;
        a aVar = this.f5036g;
        aVar.f5043a = this.f5033d.o();
        if (aVar.f5043a == -1) {
            aVar.a();
            return;
        }
        View c2 = this.f5033d.c(aVar.f5043a);
        if (c2 == null) {
            aVar.a();
            return;
        }
        int n2 = this.f5033d.n(c2);
        int o2 = this.f5033d.o(c2);
        int l2 = this.f5033d.l(c2);
        int m2 = this.f5033d.m(c2);
        ViewGroup.LayoutParams layoutParams = c2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            n2 += marginLayoutParams.leftMargin;
            o2 += marginLayoutParams.rightMargin;
            l2 += marginLayoutParams.topMargin;
            m2 += marginLayoutParams.bottomMargin;
        }
        int height = c2.getHeight() + l2 + m2;
        int width = c2.getWidth() + n2 + o2;
        if (this.f5033d.h() == 0) {
            i2 = (c2.getLeft() - n2) - this.f5032c.getPaddingLeft();
            if (this.f5031b.b()) {
                i2 = -i2;
            }
            height = width;
        } else {
            i2 = (c2.getTop() - l2) - this.f5032c.getPaddingTop();
        }
        aVar.f5045c = -i2;
        if (aVar.f5045c >= 0) {
            aVar.f5044b = height == 0 ? 0.0f : ((float) aVar.f5045c) / ((float) height);
        } else if (new a(this.f5033d).a()) {
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        } else {
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[]{Integer.valueOf(aVar.f5045c)}));
        }
    }

    private boolean h() {
        int i2 = this.f5034e;
        return i2 == 1 || i2 == 4;
    }

    private int i() {
        return this.f5033d.o();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f5041l = true;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2) {
        this.f5034e = z2 ? 2 : 3;
        boolean z3 = false;
        this.f5042m = false;
        if (this.f5038i != i2) {
            z3 = true;
        }
        this.f5038i = i2;
        a(2);
        if (z3) {
            b(i2);
        }
    }

    public void a(RecyclerView recyclerView, int i2) {
        boolean z2 = true;
        if (!(this.f5034e == 1 && this.f5035f == 1) && i2 == 1) {
            a(false);
        } else if (!h() || i2 != 2) {
            if (h() && i2 == 0) {
                g();
                if (!this.f5040k) {
                    if (this.f5036g.f5043a != -1) {
                        a(this.f5036g.f5043a, 0.0f, 0);
                    }
                } else if (this.f5036g.f5045c != 0) {
                    z2 = false;
                } else if (this.f5037h != this.f5036g.f5043a) {
                    b(this.f5036g.f5043a);
                }
                if (z2) {
                    a(0);
                    f();
                }
            }
            if (this.f5034e == 2 && i2 == 0 && this.f5041l) {
                g();
                if (this.f5036g.f5045c == 0) {
                    if (this.f5038i != this.f5036g.f5043a) {
                        b(this.f5036g.f5043a == -1 ? 0 : this.f5036g.f5043a);
                    }
                    a(0);
                    f();
                }
            }
        } else if (this.f5040k) {
            a(2);
            this.f5039j = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r3.f5037h == r5) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if ((r5 < 0) == r3.f5031b.b()) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f5040k = r4
            r3.g()
            boolean r0 = r3.f5039j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L_0x003c
            r3.f5039j = r2
            if (r6 > 0) goto L_0x0022
            if (r6 != 0) goto L_0x0020
            if (r5 >= 0) goto L_0x0016
            r5 = 1
            goto L_0x0017
        L_0x0016:
            r5 = 0
        L_0x0017:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f5031b
            boolean r6 = r6.b()
            if (r5 != r6) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r5 = 0
            goto L_0x0023
        L_0x0022:
            r5 = 1
        L_0x0023:
            if (r5 == 0) goto L_0x0031
            androidx.viewpager2.widget.e$a r5 = r3.f5036g
            int r5 = r5.f5045c
            if (r5 == 0) goto L_0x0031
            androidx.viewpager2.widget.e$a r5 = r3.f5036g
            int r5 = r5.f5043a
            int r5 = r5 + r4
            goto L_0x0035
        L_0x0031:
            androidx.viewpager2.widget.e$a r5 = r3.f5036g
            int r5 = r5.f5043a
        L_0x0035:
            r3.f5038i = r5
            int r6 = r3.f5037h
            if (r6 == r5) goto L_0x004a
            goto L_0x0047
        L_0x003c:
            int r5 = r3.f5034e
            if (r5 != 0) goto L_0x004a
            androidx.viewpager2.widget.e$a r5 = r3.f5036g
            int r5 = r5.f5043a
            if (r5 != r1) goto L_0x0047
            r5 = 0
        L_0x0047:
            r3.b(r5)
        L_0x004a:
            androidx.viewpager2.widget.e$a r5 = r3.f5036g
            int r5 = r5.f5043a
            if (r5 != r1) goto L_0x0052
            r5 = 0
            goto L_0x0056
        L_0x0052:
            androidx.viewpager2.widget.e$a r5 = r3.f5036g
            int r5 = r5.f5043a
        L_0x0056:
            androidx.viewpager2.widget.e$a r6 = r3.f5036g
            float r6 = r6.f5044b
            androidx.viewpager2.widget.e$a r0 = r3.f5036g
            int r0 = r0.f5045c
            r3.a((int) r5, (float) r6, (int) r0)
            androidx.viewpager2.widget.e$a r5 = r3.f5036g
            int r5 = r5.f5043a
            int r6 = r3.f5038i
            if (r5 == r6) goto L_0x006b
            if (r6 != r1) goto L_0x007b
        L_0x006b:
            androidx.viewpager2.widget.e$a r5 = r3.f5036g
            int r5 = r5.f5045c
            if (r5 != 0) goto L_0x007b
            int r5 = r3.f5035f
            if (r5 == r4) goto L_0x007b
            r3.a((int) r2)
            r3.f()
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.e.a(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void a(ViewPager2.e eVar) {
        this.f5030a = eVar;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f5035f;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f5035f == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f5042m;
    }

    /* access modifiers changed from: package-private */
    public double e() {
        g();
        double d2 = (double) this.f5036g.f5043a;
        double d3 = (double) this.f5036g.f5044b;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 + d3;
    }
}
