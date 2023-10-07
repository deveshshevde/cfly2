package ey;

public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    protected int f26994a;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f26995b;

    /* renamed from: c  reason: collision with root package name */
    protected float f26996c;

    /* renamed from: d  reason: collision with root package name */
    protected float f26997d;

    /* renamed from: e  reason: collision with root package name */
    protected int f26998e;

    /* renamed from: f  reason: collision with root package name */
    protected int f26999f;

    public a(int i2) {
        this.f26994a = 0;
        this.f26996c = 1.0f;
        this.f26997d = 1.0f;
        this.f26998e = 0;
        this.f26999f = 0;
        this.f26994a = 0;
        this.f26995b = new float[i2];
    }

    public void a() {
        this.f26994a = 0;
    }

    public void a(float f2, float f3) {
        this.f26996c = f2;
        this.f26997d = f3;
    }

    public int b() {
        return this.f26995b.length;
    }
}
