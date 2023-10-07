package gb;

import android.text.Layout;
import com.google.android.exoplayer2.util.a;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private String f28400a;

    /* renamed from: b  reason: collision with root package name */
    private int f28401b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f28402c;

    /* renamed from: d  reason: collision with root package name */
    private int f28403d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f28404e;

    /* renamed from: f  reason: collision with root package name */
    private int f28405f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f28406g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f28407h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f28408i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f28409j = -1;

    /* renamed from: k  reason: collision with root package name */
    private float f28410k;

    /* renamed from: l  reason: collision with root package name */
    private String f28411l;

    /* renamed from: m  reason: collision with root package name */
    private e f28412m;

    /* renamed from: n  reason: collision with root package name */
    private Layout.Alignment f28413n;

    private e a(e eVar, boolean z2) {
        if (eVar != null) {
            if (!this.f28402c && eVar.f28402c) {
                a(eVar.f28401b);
            }
            if (this.f28407h == -1) {
                this.f28407h = eVar.f28407h;
            }
            if (this.f28408i == -1) {
                this.f28408i = eVar.f28408i;
            }
            if (this.f28400a == null) {
                this.f28400a = eVar.f28400a;
            }
            if (this.f28405f == -1) {
                this.f28405f = eVar.f28405f;
            }
            if (this.f28406g == -1) {
                this.f28406g = eVar.f28406g;
            }
            if (this.f28413n == null) {
                this.f28413n = eVar.f28413n;
            }
            if (this.f28409j == -1) {
                this.f28409j = eVar.f28409j;
                this.f28410k = eVar.f28410k;
            }
            if (z2 && !this.f28404e && eVar.f28404e) {
                b(eVar.f28403d);
            }
        }
        return this;
    }

    public int a() {
        int i2 = this.f28407h;
        if (i2 == -1 && this.f28408i == -1) {
            return -1;
        }
        int i3 = 0;
        int i4 = i2 == 1 ? 1 : 0;
        if (this.f28408i == 1) {
            i3 = 2;
        }
        return i4 | i3;
    }

    public e a(float f2) {
        this.f28410k = f2;
        return this;
    }

    public e a(int i2) {
        a.b(this.f28412m == null);
        this.f28401b = i2;
        this.f28402c = true;
        return this;
    }

    public e a(Layout.Alignment alignment) {
        this.f28413n = alignment;
        return this;
    }

    public e a(e eVar) {
        return a(eVar, true);
    }

    public e a(String str) {
        a.b(this.f28412m == null);
        this.f28400a = str;
        return this;
    }

    public e a(boolean z2) {
        a.b(this.f28412m == null);
        this.f28405f = z2 ? 1 : 0;
        return this;
    }

    public e b(int i2) {
        this.f28403d = i2;
        this.f28404e = true;
        return this;
    }

    public e b(String str) {
        this.f28411l = str;
        return this;
    }

    public e b(boolean z2) {
        a.b(this.f28412m == null);
        this.f28406g = z2 ? 1 : 0;
        return this;
    }

    public boolean b() {
        return this.f28405f == 1;
    }

    public e c(int i2) {
        this.f28409j = i2;
        return this;
    }

    public e c(boolean z2) {
        a.b(this.f28412m == null);
        this.f28407h = z2 ? 1 : 0;
        return this;
    }

    public boolean c() {
        return this.f28406g == 1;
    }

    public e d(boolean z2) {
        a.b(this.f28412m == null);
        this.f28408i = z2 ? 1 : 0;
        return this;
    }

    public String d() {
        return this.f28400a;
    }

    public int e() {
        if (this.f28402c) {
            return this.f28401b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public boolean f() {
        return this.f28402c;
    }

    public int g() {
        if (this.f28404e) {
            return this.f28403d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public boolean h() {
        return this.f28404e;
    }

    public String i() {
        return this.f28411l;
    }

    public Layout.Alignment j() {
        return this.f28413n;
    }

    public int k() {
        return this.f28409j;
    }

    public float l() {
        return this.f28410k;
    }
}
