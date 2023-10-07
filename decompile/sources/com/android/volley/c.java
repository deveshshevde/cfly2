package com.android.volley;

public class c implements k {

    /* renamed from: a  reason: collision with root package name */
    private int f9901a;

    /* renamed from: b  reason: collision with root package name */
    private int f9902b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9903c;

    /* renamed from: d  reason: collision with root package name */
    private final float f9904d;

    public c() {
        this(2500, 1, 1.0f);
    }

    public c(int i2, int i3, float f2) {
        this.f9901a = i2;
        this.f9903c = i3;
        this.f9904d = f2;
    }

    public int a() {
        return this.f9901a;
    }

    public void a(VolleyError volleyError) throws VolleyError {
        this.f9902b++;
        int i2 = this.f9901a;
        this.f9901a = (int) (((float) i2) + (((float) i2) * this.f9904d));
        if (!c()) {
            throw volleyError;
        }
    }

    public int b() {
        return this.f9902b;
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return this.f9902b <= this.f9903c;
    }
}
