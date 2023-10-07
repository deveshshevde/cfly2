package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class d {

    /* renamed from: a  reason: collision with root package name */
    final b f4106a;

    /* renamed from: b  reason: collision with root package name */
    final a f4107b = new a();

    /* renamed from: c  reason: collision with root package name */
    final List<View> f4108c = new ArrayList();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        long f4109a = 0;

        /* renamed from: b  reason: collision with root package name */
        a f4110b;

        a() {
        }

        private void b() {
            if (this.f4110b == null) {
                this.f4110b = new a();
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f4109a = 0;
            a aVar = this.f4110b;
            if (aVar != null) {
                aVar.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            if (i2 >= 64) {
                b();
                this.f4110b.a(i2 - 64);
                return;
            }
            this.f4109a |= 1 << i2;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, boolean z2) {
            if (i2 >= 64) {
                b();
                this.f4110b.a(i2 - 64, z2);
                return;
            }
            long j2 = this.f4109a;
            boolean z3 = (Long.MIN_VALUE & j2) != 0;
            long j3 = (1 << i2) - 1;
            this.f4109a = ((j2 & (j3 ^ -1)) << 1) | (j2 & j3);
            if (z2) {
                a(i2);
            } else {
                b(i2);
            }
            if (z3 || this.f4110b != null) {
                b();
                this.f4110b.a(0, z3);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            if (i2 >= 64) {
                a aVar = this.f4110b;
                if (aVar != null) {
                    aVar.b(i2 - 64);
                    return;
                }
                return;
            }
            this.f4109a &= (1 << i2) ^ -1;
        }

        /* access modifiers changed from: package-private */
        public boolean c(int i2) {
            if (i2 < 64) {
                return (this.f4109a & (1 << i2)) != 0;
            }
            b();
            return this.f4110b.c(i2 - 64);
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i2) {
            if (i2 >= 64) {
                b();
                return this.f4110b.d(i2 - 64);
            }
            long j2 = 1 << i2;
            long j3 = this.f4109a;
            boolean z2 = (j3 & j2) != 0;
            long j4 = j3 & (j2 ^ -1);
            this.f4109a = j4;
            long j5 = j2 - 1;
            this.f4109a = (j4 & j5) | Long.rotateRight((j5 ^ -1) & j4, 1);
            a aVar = this.f4110b;
            if (aVar != null) {
                if (aVar.c(0)) {
                    a(63);
                }
                this.f4110b.d(0);
            }
            return z2;
        }

        /* access modifiers changed from: package-private */
        public int e(int i2) {
            a aVar = this.f4110b;
            return aVar == null ? i2 >= 64 ? Long.bitCount(this.f4109a) : Long.bitCount(this.f4109a & ((1 << i2) - 1)) : i2 < 64 ? Long.bitCount(this.f4109a & ((1 << i2) - 1)) : aVar.e(i2 - 64) + Long.bitCount(this.f4109a);
        }

        public String toString() {
            if (this.f4110b == null) {
                return Long.toBinaryString(this.f4109a);
            }
            return this.f4110b.toString() + "xx" + Long.toBinaryString(this.f4109a);
        }
    }

    interface b {
        int a();

        int a(View view);

        void a(int i2);

        void a(View view, int i2);

        void a(View view, int i2, ViewGroup.LayoutParams layoutParams);

        View b(int i2);

        RecyclerView.v b(View view);

        void b();

        void c(int i2);

        void c(View view);

        void d(View view);
    }

    d(b bVar) {
        this.f4106a = bVar;
    }

    private int f(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int a2 = this.f4106a.a();
        int i3 = i2;
        while (i3 < a2) {
            int e2 = i2 - (i3 - this.f4107b.e(i3));
            if (e2 == 0) {
                while (this.f4107b.c(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += e2;
        }
        return -1;
    }

    private void g(View view) {
        this.f4108c.add(view);
        this.f4106a.c(view);
    }

    private boolean h(View view) {
        if (!this.f4108c.remove(view)) {
            return false;
        }
        this.f4106a.d(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f4107b.a();
        for (int size = this.f4108c.size() - 1; size >= 0; size--) {
            this.f4106a.d(this.f4108c.get(size));
            this.f4108c.remove(size);
        }
        this.f4106a.b();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        int f2 = f(i2);
        View b2 = this.f4106a.b(f2);
        if (b2 != null) {
            if (this.f4107b.d(f2)) {
                h(b2);
            }
            this.f4106a.a(f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        int a2 = this.f4106a.a(view);
        if (a2 >= 0) {
            if (this.f4107b.d(a2)) {
                h(view);
            }
            this.f4106a.a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z2) {
        int a2 = i2 < 0 ? this.f4106a.a() : f(i2);
        this.f4107b.a(a2, z2);
        if (z2) {
            g(view);
        }
        this.f4106a.a(view, a2, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i2, boolean z2) {
        int a2 = i2 < 0 ? this.f4106a.a() : f(i2);
        this.f4107b.a(a2, z2);
        if (z2) {
            g(view);
        }
        this.f4106a.a(view, a2);
    }

    /* access modifiers changed from: package-private */
    public void a(View view, boolean z2) {
        a(view, -1, z2);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f4106a.a() - this.f4108c.size();
    }

    /* access modifiers changed from: package-private */
    public int b(View view) {
        int a2 = this.f4106a.a(view);
        if (a2 != -1 && !this.f4107b.c(a2)) {
            return a2 - this.f4107b.e(a2);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public View b(int i2) {
        return this.f4106a.b(f(i2));
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f4106a.a();
    }

    /* access modifiers changed from: package-private */
    public View c(int i2) {
        int size = this.f4108c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.f4108c.get(i3);
            RecyclerView.v b2 = this.f4106a.b(view);
            if (b2.getLayoutPosition() == i2 && !b2.isInvalid() && !b2.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean c(View view) {
        return this.f4108c.contains(view);
    }

    /* access modifiers changed from: package-private */
    public View d(int i2) {
        return this.f4106a.b(i2);
    }

    /* access modifiers changed from: package-private */
    public void d(View view) {
        int a2 = this.f4106a.a(view);
        if (a2 >= 0) {
            this.f4107b.a(a2);
            g(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* access modifiers changed from: package-private */
    public void e(int i2) {
        int f2 = f(i2);
        this.f4107b.d(f2);
        this.f4106a.c(f2);
    }

    /* access modifiers changed from: package-private */
    public void e(View view) {
        int a2 = this.f4106a.a(view);
        if (a2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f4107b.c(a2)) {
            this.f4107b.b(a2);
            h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean f(View view) {
        int a2 = this.f4106a.a(view);
        if (a2 == -1) {
            h(view);
            return true;
        } else if (!this.f4107b.c(a2)) {
            return false;
        } else {
            this.f4107b.d(a2);
            h(view);
            this.f4106a.a(a2);
            return true;
        }
    }

    public String toString() {
        return this.f4107b.toString() + ", hidden list:" + this.f4108c.size();
    }
}
