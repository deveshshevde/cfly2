package androidx.recyclerview.widget;

import android.view.View;

class y {

    /* renamed from: a  reason: collision with root package name */
    final b f4330a;

    /* renamed from: b  reason: collision with root package name */
    a f4331b = new a();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f4332a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f4333b;

        /* renamed from: c  reason: collision with root package name */
        int f4334c;

        /* renamed from: d  reason: collision with root package name */
        int f4335d;

        /* renamed from: e  reason: collision with root package name */
        int f4336e;

        a() {
        }

        /* access modifiers changed from: package-private */
        public int a(int i2, int i3) {
            if (i2 > i3) {
                return 1;
            }
            return i2 == i3 ? 2 : 4;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f4332a = 0;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.f4332a = i2 | this.f4332a;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3, int i4, int i5) {
            this.f4333b = i2;
            this.f4334c = i3;
            this.f4335d = i4;
            this.f4336e = i5;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            int i2 = this.f4332a;
            if ((i2 & 7) != 0 && (i2 & (a(this.f4335d, this.f4333b) << 0)) == 0) {
                return false;
            }
            int i3 = this.f4332a;
            if ((i3 & 112) != 0 && (i3 & (a(this.f4335d, this.f4334c) << 4)) == 0) {
                return false;
            }
            int i4 = this.f4332a;
            if ((i4 & 1792) != 0 && (i4 & (a(this.f4336e, this.f4333b) << 8)) == 0) {
                return false;
            }
            int i5 = this.f4332a;
            return (i5 & 28672) == 0 || (i5 & (a(this.f4336e, this.f4334c) << 12)) != 0;
        }
    }

    interface b {
        int a();

        int a(View view);

        View a(int i2);

        int b();

        int b(View view);
    }

    y(b bVar) {
        this.f4330a = bVar;
    }

    /* access modifiers changed from: package-private */
    public View a(int i2, int i3, int i4, int i5) {
        int a2 = this.f4330a.a();
        int b2 = this.f4330a.b();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View a3 = this.f4330a.a(i2);
            this.f4331b.a(a2, b2, this.f4330a.a(a3), this.f4330a.b(a3));
            if (i4 != 0) {
                this.f4331b.a();
                this.f4331b.a(i4);
                if (this.f4331b.b()) {
                    return a3;
                }
            }
            if (i5 != 0) {
                this.f4331b.a();
                this.f4331b.a(i5);
                if (this.f4331b.b()) {
                    view = a3;
                }
            }
            i2 += i6;
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view, int i2) {
        this.f4331b.a(this.f4330a.a(), this.f4330a.b(), this.f4330a.a(view), this.f4330a.b(view));
        if (i2 == 0) {
            return false;
        }
        this.f4331b.a();
        this.f4331b.a(i2);
        return this.f4331b.b();
    }
}
