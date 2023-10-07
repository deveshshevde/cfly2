package okio;

final class o {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f32465a;

    /* renamed from: b  reason: collision with root package name */
    int f32466b;

    /* renamed from: c  reason: collision with root package name */
    int f32467c;

    /* renamed from: d  reason: collision with root package name */
    boolean f32468d;

    /* renamed from: e  reason: collision with root package name */
    boolean f32469e;

    /* renamed from: f  reason: collision with root package name */
    o f32470f;

    /* renamed from: g  reason: collision with root package name */
    o f32471g;

    o() {
        this.f32465a = new byte[8192];
        this.f32469e = true;
        this.f32468d = false;
    }

    o(byte[] bArr, int i2, int i3, boolean z2, boolean z3) {
        this.f32465a = bArr;
        this.f32466b = i2;
        this.f32467c = i3;
        this.f32468d = z2;
        this.f32469e = z3;
    }

    /* access modifiers changed from: package-private */
    public final o a() {
        this.f32468d = true;
        return new o(this.f32465a, this.f32466b, this.f32467c, true, false);
    }

    public final o a(int i2) {
        o oVar;
        if (i2 <= 0 || i2 > this.f32467c - this.f32466b) {
            throw new IllegalArgumentException();
        }
        if (i2 >= 1024) {
            oVar = a();
        } else {
            oVar = p.a();
            System.arraycopy(this.f32465a, this.f32466b, oVar.f32465a, 0, i2);
        }
        oVar.f32467c = oVar.f32466b + i2;
        this.f32466b += i2;
        this.f32471g.a(oVar);
        return oVar;
    }

    public final o a(o oVar) {
        oVar.f32471g = this;
        oVar.f32470f = this.f32470f;
        this.f32470f.f32471g = oVar;
        this.f32470f = oVar;
        return oVar;
    }

    public final void a(o oVar, int i2) {
        if (oVar.f32469e) {
            int i3 = oVar.f32467c;
            if (i3 + i2 > 8192) {
                if (!oVar.f32468d) {
                    int i4 = oVar.f32466b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = oVar.f32465a;
                        System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                        oVar.f32467c -= oVar.f32466b;
                        oVar.f32466b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f32465a, this.f32466b, oVar.f32465a, oVar.f32467c, i2);
            oVar.f32467c += i2;
            this.f32466b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final o b() {
        o oVar = this.f32470f;
        o oVar2 = oVar != this ? oVar : null;
        o oVar3 = this.f32471g;
        oVar3.f32470f = oVar;
        this.f32470f.f32471g = oVar3;
        this.f32470f = null;
        this.f32471g = null;
        return oVar2;
    }

    public final void c() {
        o oVar = this.f32471g;
        if (oVar == this) {
            throw new IllegalStateException();
        } else if (oVar.f32469e) {
            int i2 = this.f32467c - this.f32466b;
            if (i2 <= (8192 - oVar.f32467c) + (oVar.f32468d ? 0 : oVar.f32466b)) {
                a(oVar, i2);
                b();
                p.a(this);
            }
        }
    }
}
