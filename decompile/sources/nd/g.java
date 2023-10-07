package nd;

import java.io.IOException;
import java.util.List;
import okhttp3.ab;
import okhttp3.e;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.i;
import okhttp3.u;
import okhttp3.z;

public final class g implements u.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<u> f31378a;

    /* renamed from: b  reason: collision with root package name */
    private final i f31379b;

    /* renamed from: c  reason: collision with root package name */
    private final c f31380c;

    /* renamed from: d  reason: collision with root package name */
    private final int f31381d;

    /* renamed from: e  reason: collision with root package name */
    private final z f31382e;

    /* renamed from: f  reason: collision with root package name */
    private final e f31383f;

    /* renamed from: g  reason: collision with root package name */
    private final int f31384g;

    /* renamed from: h  reason: collision with root package name */
    private final int f31385h;

    /* renamed from: i  reason: collision with root package name */
    private final int f31386i;

    /* renamed from: j  reason: collision with root package name */
    private int f31387j;

    public g(List<u> list, i iVar, c cVar, int i2, z zVar, e eVar, int i3, int i4, int i5) {
        this.f31378a = list;
        this.f31379b = iVar;
        this.f31380c = cVar;
        this.f31381d = i2;
        this.f31382e = zVar;
        this.f31383f = eVar;
        this.f31384g = i3;
        this.f31385h = i4;
        this.f31386i = i5;
    }

    public ab a(z zVar) throws IOException {
        return a(zVar, this.f31379b, this.f31380c);
    }

    public ab a(z zVar, i iVar, c cVar) throws IOException {
        if (this.f31381d < this.f31378a.size()) {
            this.f31387j++;
            c cVar2 = this.f31380c;
            if (cVar2 != null && !cVar2.a().a(zVar.a())) {
                throw new IllegalStateException("network interceptor " + this.f31378a.get(this.f31381d - 1) + " must retain the same host and port");
            } else if (this.f31380c == null || this.f31387j <= 1) {
                g gVar = new g(this.f31378a, iVar, cVar, this.f31381d + 1, zVar, this.f31383f, this.f31384g, this.f31385h, this.f31386i);
                u uVar = this.f31378a.get(this.f31381d);
                ab intercept = uVar.intercept(gVar);
                if (cVar != null && this.f31381d + 1 < this.f31378a.size() && gVar.f31387j != 1) {
                    throw new IllegalStateException("network interceptor " + uVar + " must call proceed() exactly once");
                } else if (intercept == null) {
                    throw new NullPointerException("interceptor " + uVar + " returned null");
                } else if (intercept.g() != null) {
                    return intercept;
                } else {
                    throw new IllegalStateException("interceptor " + uVar + " returned a response with no body");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.f31378a.get(this.f31381d - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }

    public z a() {
        return this.f31382e;
    }

    public int b() {
        return this.f31384g;
    }

    public int c() {
        return this.f31385h;
    }

    public int d() {
        return this.f31386i;
    }

    public i e() {
        return this.f31379b;
    }

    public c f() {
        c cVar = this.f31380c;
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalStateException();
    }
}
