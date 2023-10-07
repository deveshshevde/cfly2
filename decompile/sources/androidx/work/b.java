package androidx.work;

import android.os.Build;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f5126a = new a().a();

    /* renamed from: b  reason: collision with root package name */
    private NetworkType f5127b = NetworkType.NOT_REQUIRED;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5128c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5129d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5130e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5131f;

    /* renamed from: g  reason: collision with root package name */
    private long f5132g = -1;

    /* renamed from: h  reason: collision with root package name */
    private long f5133h = -1;

    /* renamed from: i  reason: collision with root package name */
    private c f5134i = new c();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f5135a = false;

        /* renamed from: b  reason: collision with root package name */
        boolean f5136b = false;

        /* renamed from: c  reason: collision with root package name */
        NetworkType f5137c = NetworkType.NOT_REQUIRED;

        /* renamed from: d  reason: collision with root package name */
        boolean f5138d = false;

        /* renamed from: e  reason: collision with root package name */
        boolean f5139e = false;

        /* renamed from: f  reason: collision with root package name */
        long f5140f = -1;

        /* renamed from: g  reason: collision with root package name */
        long f5141g = -1;

        /* renamed from: h  reason: collision with root package name */
        c f5142h = new c();

        public b a() {
            return new b(this);
        }
    }

    public b() {
    }

    b(a aVar) {
        this.f5128c = aVar.f5135a;
        this.f5129d = Build.VERSION.SDK_INT >= 23 && aVar.f5136b;
        this.f5127b = aVar.f5137c;
        this.f5130e = aVar.f5138d;
        this.f5131f = aVar.f5139e;
        if (Build.VERSION.SDK_INT >= 24) {
            this.f5134i = aVar.f5142h;
            this.f5132g = aVar.f5140f;
            this.f5133h = aVar.f5141g;
        }
    }

    public b(b bVar) {
        this.f5128c = bVar.f5128c;
        this.f5129d = bVar.f5129d;
        this.f5127b = bVar.f5127b;
        this.f5130e = bVar.f5130e;
        this.f5131f = bVar.f5131f;
        this.f5134i = bVar.f5134i;
    }

    public NetworkType a() {
        return this.f5127b;
    }

    public void a(long j2) {
        this.f5132g = j2;
    }

    public void a(NetworkType networkType) {
        this.f5127b = networkType;
    }

    public void a(c cVar) {
        this.f5134i = cVar;
    }

    public void a(boolean z2) {
        this.f5128c = z2;
    }

    public void b(long j2) {
        this.f5133h = j2;
    }

    public void b(boolean z2) {
        this.f5129d = z2;
    }

    public boolean b() {
        return this.f5128c;
    }

    public void c(boolean z2) {
        this.f5130e = z2;
    }

    public boolean c() {
        return this.f5129d;
    }

    public void d(boolean z2) {
        this.f5131f = z2;
    }

    public boolean d() {
        return this.f5130e;
    }

    public boolean e() {
        return this.f5131f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f5128c == bVar.f5128c && this.f5129d == bVar.f5129d && this.f5130e == bVar.f5130e && this.f5131f == bVar.f5131f && this.f5132g == bVar.f5132g && this.f5133h == bVar.f5133h && this.f5127b == bVar.f5127b) {
            return this.f5134i.equals(bVar.f5134i);
        }
        return false;
    }

    public long f() {
        return this.f5132g;
    }

    public long g() {
        return this.f5133h;
    }

    public c h() {
        return this.f5134i;
    }

    public int hashCode() {
        long j2 = this.f5132g;
        long j3 = this.f5133h;
        return (((((((((((((this.f5127b.hashCode() * 31) + (this.f5128c ? 1 : 0)) * 31) + (this.f5129d ? 1 : 0)) * 31) + (this.f5130e ? 1 : 0)) * 31) + (this.f5131f ? 1 : 0)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.f5134i.hashCode();
    }

    public boolean i() {
        return this.f5134i.b() > 0;
    }
}
