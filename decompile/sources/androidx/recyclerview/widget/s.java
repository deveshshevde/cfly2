package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.h f4313a;

    /* renamed from: b  reason: collision with root package name */
    final Rect f4314b;

    /* renamed from: c  reason: collision with root package name */
    private int f4315c;

    private s(RecyclerView.h hVar) {
        this.f4315c = Integer.MIN_VALUE;
        this.f4314b = new Rect();
        this.f4313a = hVar;
    }

    public static s a(RecyclerView.h hVar) {
        return new s(hVar) {
            public int a(View view) {
                return this.f4313a.h(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public void a(int i2) {
                this.f4313a.j(i2);
            }

            public int b(View view) {
                return this.f4313a.j(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
            }

            public int c() {
                return this.f4313a.E();
            }

            public int c(View view) {
                this.f4313a.a(view, true, this.f4314b);
                return this.f4314b.right;
            }

            public int d() {
                return this.f4313a.C() - this.f4313a.G();
            }

            public int d(View view) {
                this.f4313a.a(view, true, this.f4314b);
                return this.f4314b.left;
            }

            public int e() {
                return this.f4313a.C();
            }

            public int e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f4313a.f(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            public int f() {
                return (this.f4313a.C() - this.f4313a.E()) - this.f4313a.G();
            }

            public int f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f4313a.g(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            public int g() {
                return this.f4313a.G();
            }

            public int h() {
                return this.f4313a.A();
            }

            public int i() {
                return this.f4313a.B();
            }
        };
    }

    public static s a(RecyclerView.h hVar, int i2) {
        if (i2 == 0) {
            return a(hVar);
        }
        if (i2 == 1) {
            return b(hVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static s b(RecyclerView.h hVar) {
        return new s(hVar) {
            public int a(View view) {
                return this.f4313a.i(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
            }

            public void a(int i2) {
                this.f4313a.k(i2);
            }

            public int b(View view) {
                return this.f4313a.k(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
            }

            public int c() {
                return this.f4313a.F();
            }

            public int c(View view) {
                this.f4313a.a(view, true, this.f4314b);
                return this.f4314b.bottom;
            }

            public int d() {
                return this.f4313a.D() - this.f4313a.H();
            }

            public int d(View view) {
                this.f4313a.a(view, true, this.f4314b);
                return this.f4314b.top;
            }

            public int e() {
                return this.f4313a.D();
            }

            public int e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f4313a.g(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            public int f() {
                return (this.f4313a.D() - this.f4313a.F()) - this.f4313a.H();
            }

            public int f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f4313a.f(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            public int g() {
                return this.f4313a.H();
            }

            public int h() {
                return this.f4313a.B();
            }

            public int i() {
                return this.f4313a.A();
            }
        };
    }

    public abstract int a(View view);

    public void a() {
        this.f4315c = f();
    }

    public abstract void a(int i2);

    public int b() {
        if (Integer.MIN_VALUE == this.f4315c) {
            return 0;
        }
        return f() - this.f4315c;
    }

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public abstract int h();

    public abstract int i();
}
