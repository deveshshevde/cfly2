package lq;

import android.graphics.PointF;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected int f30974a = 0;

    /* renamed from: b  reason: collision with root package name */
    private PointF f30975b = new PointF();

    /* renamed from: c  reason: collision with root package name */
    private float f30976c;

    /* renamed from: d  reason: collision with root package name */
    private float f30977d;

    /* renamed from: e  reason: collision with root package name */
    private int f30978e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f30979f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f30980g;

    /* renamed from: h  reason: collision with root package name */
    private int f30981h = 0;

    /* renamed from: i  reason: collision with root package name */
    private float f30982i = 1.2f;

    /* renamed from: j  reason: collision with root package name */
    private float f30983j = 1.7f;

    /* renamed from: k  reason: collision with root package name */
    private boolean f30984k = false;

    /* renamed from: l  reason: collision with root package name */
    private int f30985l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f30986m = 0;

    public void a(float f2) {
        this.f30983j = f2;
    }

    public void a(float f2, float f3) {
        this.f30984k = true;
        this.f30981h = this.f30978e;
        this.f30975b.set(f2, f3);
    }

    /* access modifiers changed from: protected */
    public void a(float f2, float f3, float f4, float f5) {
        c(f4, f5 / this.f30983j);
    }

    public void a(int i2) {
        this.f30982i = (((float) this.f30980g) * 1.0f) / ((float) i2);
        this.f30974a = i2;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3) {
    }

    public void a(a aVar) {
        this.f30978e = aVar.f30978e;
        this.f30979f = aVar.f30979f;
        this.f30980g = aVar.f30980g;
    }

    public boolean a() {
        return this.f30984k;
    }

    public float b() {
        return this.f30983j;
    }

    public void b(float f2) {
        this.f30982i = f2;
        this.f30974a = (int) (((float) this.f30980g) * f2);
    }

    public final void b(float f2, float f3) {
        a(f2, f3, f2 - this.f30975b.x, f3 - this.f30975b.y);
        this.f30975b.set(f2, f3);
    }

    public final void b(int i2) {
        int i3 = this.f30978e;
        this.f30979f = i3;
        this.f30978e = i2;
        a(i2, i3);
    }

    public void c() {
        this.f30984k = false;
    }

    /* access modifiers changed from: protected */
    public void c(float f2, float f3) {
        this.f30976c = f2;
        this.f30977d = f3;
    }

    public void c(int i2) {
        this.f30980g = i2;
        l();
    }

    public void d() {
        this.f30986m = this.f30978e;
    }

    public void d(int i2) {
        this.f30985l = i2;
    }

    public boolean e() {
        return this.f30978e >= this.f30986m;
    }

    public boolean e(int i2) {
        return this.f30978e == i2;
    }

    public float f() {
        return this.f30982i;
    }

    public boolean f(int i2) {
        return i2 < 0;
    }

    public int g() {
        return this.f30974a;
    }

    public float h() {
        return this.f30976c;
    }

    public float i() {
        return this.f30977d;
    }

    public int j() {
        return this.f30979f;
    }

    public int k() {
        return this.f30978e;
    }

    /* access modifiers changed from: protected */
    public void l() {
        this.f30974a = (int) (this.f30982i * ((float) this.f30980g));
    }

    public boolean m() {
        return this.f30978e > 0;
    }

    public boolean n() {
        return this.f30979f == 0 && m();
    }

    public boolean o() {
        return this.f30979f != 0 && r();
    }

    public boolean p() {
        return this.f30978e >= g();
    }

    public boolean q() {
        return this.f30978e != this.f30981h;
    }

    public boolean r() {
        return this.f30978e == 0;
    }

    public boolean s() {
        return this.f30979f < g() && this.f30978e >= g();
    }

    public boolean t() {
        int i2 = this.f30979f;
        int i3 = this.f30980g;
        return i2 < i3 && this.f30978e >= i3;
    }

    public boolean u() {
        return this.f30978e > v();
    }

    public int v() {
        int i2 = this.f30985l;
        return i2 >= 0 ? i2 : this.f30980g;
    }

    public float w() {
        int i2 = this.f30980g;
        if (i2 == 0) {
            return 0.0f;
        }
        return (((float) this.f30978e) * 1.0f) / ((float) i2);
    }
}
