package mw;

import androidx.fragment.app.FragmentManager;

public abstract class a {

    /* renamed from: c  reason: collision with root package name */
    public FragmentManager f31289c;

    /* renamed from: d  reason: collision with root package name */
    public int f31290d;

    /* renamed from: e  reason: collision with root package name */
    public long f31291e;

    public a() {
        this.f31290d = 0;
        this.f31291e = 0;
    }

    public a(int i2) {
        this.f31290d = 0;
        this.f31291e = 0;
        this.f31290d = i2;
    }

    public a(int i2, FragmentManager fragmentManager) {
        this(i2);
        this.f31289c = fragmentManager;
    }

    public abstract void a();
}
