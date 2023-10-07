package androidx.recyclerview.widget;

public class c implements q {

    /* renamed from: a  reason: collision with root package name */
    final q f4101a;

    /* renamed from: b  reason: collision with root package name */
    int f4102b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f4103c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f4104d = -1;

    /* renamed from: e  reason: collision with root package name */
    Object f4105e = null;

    public c(q qVar) {
        this.f4101a = qVar;
    }

    public void a() {
        int i2 = this.f4102b;
        if (i2 != 0) {
            if (i2 == 1) {
                this.f4101a.a(this.f4103c, this.f4104d);
            } else if (i2 == 2) {
                this.f4101a.b(this.f4103c, this.f4104d);
            } else if (i2 == 3) {
                this.f4101a.a(this.f4103c, this.f4104d, this.f4105e);
            }
            this.f4105e = null;
            this.f4102b = 0;
        }
    }

    public void a(int i2, int i3) {
        int i4;
        if (this.f4102b == 1 && i2 >= (i4 = this.f4103c)) {
            int i5 = this.f4104d;
            if (i2 <= i4 + i5) {
                this.f4104d = i5 + i3;
                this.f4103c = Math.min(i2, i4);
                return;
            }
        }
        a();
        this.f4103c = i2;
        this.f4104d = i3;
        this.f4102b = 1;
    }

    public void a(int i2, int i3, Object obj) {
        int i4;
        if (this.f4102b == 3) {
            int i5 = this.f4103c;
            int i6 = this.f4104d;
            if (i2 <= i5 + i6 && (i4 = i2 + i3) >= i5 && this.f4105e == obj) {
                this.f4103c = Math.min(i2, i5);
                this.f4104d = Math.max(i6 + i5, i4) - this.f4103c;
                return;
            }
        }
        a();
        this.f4103c = i2;
        this.f4104d = i3;
        this.f4105e = obj;
        this.f4102b = 3;
    }

    public void b(int i2, int i3) {
        int i4;
        if (this.f4102b != 2 || (i4 = this.f4103c) < i2 || i4 > i2 + i3) {
            a();
            this.f4103c = i2;
            this.f4104d = i3;
            this.f4102b = 2;
            return;
        }
        this.f4104d += i3;
        this.f4103c = i2;
    }

    public void c(int i2, int i3) {
        a();
        this.f4101a.c(i2, i3);
    }
}
