package cl;

import ci.b;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private int f6238a = 1;

    /* renamed from: b  reason: collision with root package name */
    private boolean f6239b = false;

    private void a(b bVar, boolean z2) {
        bVar.b(d(), z2);
    }

    private void b(b bVar, boolean z2) {
        bVar.b(e(), z2);
    }

    private void c(b bVar, boolean z2) {
        int f2 = f();
        if (f2 != 0) {
            bVar.b(f2, z2);
        }
    }

    public int a() {
        return this.f6238a;
    }

    public void a(int i2) {
        this.f6238a = i2;
    }

    public void a(b bVar) {
        int i2 = this.f6238a;
        if (i2 == 1) {
            a(bVar, false);
        } else if (i2 == 2) {
            a(bVar, true);
        } else if (i2 == 3) {
            a(bVar, false);
            b(bVar, true);
            c(bVar, false);
        } else if (i2 == 4) {
            a(bVar, false);
            b(bVar, false);
            c(bVar, true);
            return;
        } else {
            return;
        }
        b(bVar, false);
        c(bVar, false);
    }

    public final void a(boolean z2) {
        this.f6239b = z2;
    }

    public final boolean b() {
        if (f() == 0) {
            return true;
        }
        return this.f6239b;
    }

    public abstract int c();

    /* access modifiers changed from: protected */
    public abstract int d();

    /* access modifiers changed from: protected */
    public abstract int e();

    /* access modifiers changed from: protected */
    public abstract int f();
}
