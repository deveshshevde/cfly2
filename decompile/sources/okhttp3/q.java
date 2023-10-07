package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import nb.c;
import okio.d;

public final class q extends aa {

    /* renamed from: a  reason: collision with root package name */
    private static final v f32289a = v.a("application/x-www-form-urlencoded");

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f32290b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f32291c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f32292a;

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f32293b;

        /* renamed from: c  reason: collision with root package name */
        private final Charset f32294c;

        public a() {
            this((Charset) null);
        }

        public a(Charset charset) {
            this.f32292a = new ArrayList();
            this.f32293b = new ArrayList();
            this.f32294c = charset;
        }

        public a a(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            Objects.requireNonNull(str2, "value == null");
            this.f32292a.add(t.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f32294c));
            this.f32293b.add(t.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f32294c));
            return this;
        }

        public q a() {
            return new q(this.f32292a, this.f32293b);
        }

        public a b(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            Objects.requireNonNull(str2, "value == null");
            this.f32292a.add(t.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f32294c));
            this.f32293b.add(t.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f32294c));
            return this;
        }
    }

    q(List<String> list, List<String> list2) {
        this.f32290b = c.a(list);
        this.f32291c = c.a(list2);
    }

    private long a(d dVar, boolean z2) {
        okio.c cVar = z2 ? new okio.c() : dVar.b();
        int size = this.f32290b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                cVar.i(38);
            }
            cVar.b(this.f32290b.get(i2));
            cVar.i(61);
            cVar.b(this.f32291c.get(i2));
        }
        if (!z2) {
            return 0;
        }
        long a2 = cVar.a();
        cVar.s();
        return a2;
    }

    public long contentLength() {
        return a((d) null, true);
    }

    public v contentType() {
        return f32289a;
    }

    public void writeTo(d dVar) throws IOException {
        a(dVar, false);
    }
}
