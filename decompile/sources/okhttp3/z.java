package okhttp3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import nb.c;
import nd.f;
import okhttp3.s;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    final t f32404a;

    /* renamed from: b  reason: collision with root package name */
    final String f32405b;

    /* renamed from: c  reason: collision with root package name */
    final s f32406c;

    /* renamed from: d  reason: collision with root package name */
    final aa f32407d;

    /* renamed from: e  reason: collision with root package name */
    final Map<Class<?>, Object> f32408e;

    /* renamed from: f  reason: collision with root package name */
    private volatile d f32409f;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        t f32410a;

        /* renamed from: b  reason: collision with root package name */
        String f32411b;

        /* renamed from: c  reason: collision with root package name */
        s.a f32412c;

        /* renamed from: d  reason: collision with root package name */
        aa f32413d;

        /* renamed from: e  reason: collision with root package name */
        Map<Class<?>, Object> f32414e;

        public a() {
            this.f32414e = Collections.emptyMap();
            this.f32411b = "GET";
            this.f32412c = new s.a();
        }

        a(z zVar) {
            this.f32414e = Collections.emptyMap();
            this.f32410a = zVar.f32404a;
            this.f32411b = zVar.f32405b;
            this.f32413d = zVar.f32407d;
            this.f32414e = zVar.f32408e.isEmpty() ? Collections.emptyMap() : new LinkedHashMap<>(zVar.f32408e);
            this.f32412c = zVar.f32406c.b();
        }

        public a a() {
            return a("GET", (aa) null);
        }

        public <T> a a(Class<? super T> cls, T t2) {
            Objects.requireNonNull(cls, "type == null");
            if (t2 == null) {
                this.f32414e.remove(cls);
            } else {
                if (this.f32414e.isEmpty()) {
                    this.f32414e = new LinkedHashMap();
                }
                this.f32414e.put(cls, cls.cast(t2));
            }
            return this;
        }

        public a a(String str) {
            StringBuilder sb;
            int i2;
            Objects.requireNonNull(str, "url == null");
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                sb = new StringBuilder();
                sb.append("http:");
                i2 = 3;
            } else {
                if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    sb = new StringBuilder();
                    sb.append("https:");
                    i2 = 4;
                }
                return a(t.e(str));
            }
            sb.append(str.substring(i2));
            str = sb.toString();
            return a(t.e(str));
        }

        public a a(String str, String str2) {
            this.f32412c.d(str, str2);
            return this;
        }

        public a a(String str, aa aaVar) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (aaVar != null && !f.c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (aaVar != null || !f.b(str)) {
                this.f32411b = str;
                this.f32413d = aaVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public a a(s sVar) {
            this.f32412c = sVar.b();
            return this;
        }

        public a a(t tVar) {
            Objects.requireNonNull(tVar, "url == null");
            this.f32410a = tVar;
            return this;
        }

        public a b(String str) {
            this.f32412c.b(str);
            return this;
        }

        public a b(String str, String str2) {
            this.f32412c.a(str, str2);
            return this;
        }

        public z b() {
            if (this.f32410a != null) {
                return new z(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    z(a aVar) {
        this.f32404a = aVar.f32410a;
        this.f32405b = aVar.f32411b;
        this.f32406c = aVar.f32412c.a();
        this.f32407d = aVar.f32413d;
        this.f32408e = c.a(aVar.f32414e);
    }

    public <T> T a(Class<? extends T> cls) {
        return cls.cast(this.f32408e.get(cls));
    }

    public String a(String str) {
        return this.f32406c.a(str);
    }

    public t a() {
        return this.f32404a;
    }

    public String b() {
        return this.f32405b;
    }

    public s c() {
        return this.f32406c;
    }

    public aa d() {
        return this.f32407d;
    }

    public a e() {
        return new a(this);
    }

    public d f() {
        d dVar = this.f32409f;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f32406c);
        this.f32409f = a2;
        return a2;
    }

    public boolean g() {
        return this.f32404a.c();
    }

    public String toString() {
        return "Request{method=" + this.f32405b + ", url=" + this.f32404a + ", tags=" + this.f32408e + '}';
    }
}
