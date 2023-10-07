package okhttp3.internal.http2;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okio.ByteString;
import okio.c;
import okio.e;
import okio.k;
import okio.r;

final class b {

    /* renamed from: a  reason: collision with root package name */
    static final a[] f32084a = {new a(a.f32080f, ""), new a(a.f32077c, "GET"), new a(a.f32077c, "POST"), new a(a.f32078d, "/"), new a(a.f32078d, "/index.html"), new a(a.f32079e, "http"), new a(a.f32079e, "https"), new a(a.f32076b, "200"), new a(a.f32076b, "204"), new a(a.f32076b, "206"), new a(a.f32076b, "304"), new a(a.f32076b, "400"), new a(a.f32076b, "404"), new a(a.f32076b, "500"), new a("accept-charset", ""), new a("accept-encoding", "gzip, deflate"), new a("accept-language", ""), new a("accept-ranges", ""), new a("accept", ""), new a("access-control-allow-origin", ""), new a("age", ""), new a("allow", ""), new a("authorization", ""), new a("cache-control", ""), new a("content-disposition", ""), new a("content-encoding", ""), new a("content-language", ""), new a("content-length", ""), new a("content-location", ""), new a("content-range", ""), new a("content-type", ""), new a("cookie", ""), new a("date", ""), new a("etag", ""), new a("expect", ""), new a("expires", ""), new a("from", ""), new a("host", ""), new a("if-match", ""), new a("if-modified-since", ""), new a("if-none-match", ""), new a("if-range", ""), new a("if-unmodified-since", ""), new a("last-modified", ""), new a("link", ""), new a("location", ""), new a("max-forwards", ""), new a("proxy-authenticate", ""), new a("proxy-authorization", ""), new a("range", ""), new a("referer", ""), new a("refresh", ""), new a("retry-after", ""), new a("server", ""), new a("set-cookie", ""), new a("strict-transport-security", ""), new a("transfer-encoding", ""), new a("user-agent", ""), new a("vary", ""), new a("via", ""), new a("www-authenticate", "")};

    /* renamed from: b  reason: collision with root package name */
    static final Map<ByteString, Integer> f32085b = a();

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        a[] f32086a;

        /* renamed from: b  reason: collision with root package name */
        int f32087b;

        /* renamed from: c  reason: collision with root package name */
        int f32088c;

        /* renamed from: d  reason: collision with root package name */
        int f32089d;

        /* renamed from: e  reason: collision with root package name */
        private final List<a> f32090e;

        /* renamed from: f  reason: collision with root package name */
        private final e f32091f;

        /* renamed from: g  reason: collision with root package name */
        private final int f32092g;

        /* renamed from: h  reason: collision with root package name */
        private int f32093h;

        a(int i2, int i3, r rVar) {
            this.f32090e = new ArrayList();
            a[] aVarArr = new a[8];
            this.f32086a = aVarArr;
            this.f32087b = aVarArr.length - 1;
            this.f32088c = 0;
            this.f32089d = 0;
            this.f32092g = i2;
            this.f32093h = i3;
            this.f32091f = k.a(rVar);
        }

        a(int i2, r rVar) {
            this(i2, i2, rVar);
        }

        private int a(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.f32086a.length;
                while (true) {
                    length--;
                    i3 = this.f32087b;
                    if (length < i3 || i2 <= 0) {
                        a[] aVarArr = this.f32086a;
                        System.arraycopy(aVarArr, i3 + 1, aVarArr, i3 + 1 + i4, this.f32088c);
                        this.f32087b += i4;
                    } else {
                        i2 -= this.f32086a[length].f32083i;
                        this.f32089d -= this.f32086a[length].f32083i;
                        this.f32088c--;
                        i4++;
                    }
                }
                a[] aVarArr2 = this.f32086a;
                System.arraycopy(aVarArr2, i3 + 1, aVarArr2, i3 + 1 + i4, this.f32088c);
                this.f32087b += i4;
            }
            return i4;
        }

        private void a(int i2, a aVar) {
            this.f32090e.add(aVar);
            int i3 = aVar.f32083i;
            if (i2 != -1) {
                i3 -= this.f32086a[c(i2)].f32083i;
            }
            int i4 = this.f32093h;
            if (i3 > i4) {
                e();
                return;
            }
            int a2 = a((this.f32089d + i3) - i4);
            if (i2 == -1) {
                int i5 = this.f32088c + 1;
                a[] aVarArr = this.f32086a;
                if (i5 > aVarArr.length) {
                    a[] aVarArr2 = new a[(aVarArr.length * 2)];
                    System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                    this.f32087b = this.f32086a.length - 1;
                    this.f32086a = aVarArr2;
                }
                int i6 = this.f32087b;
                this.f32087b = i6 - 1;
                this.f32086a[i6] = aVar;
                this.f32088c++;
            } else {
                this.f32086a[i2 + c(i2) + a2] = aVar;
            }
            this.f32089d += i3;
        }

        private void b(int i2) throws IOException {
            if (g(i2)) {
                this.f32090e.add(b.f32084a[i2]);
                return;
            }
            int c2 = c(i2 - b.f32084a.length);
            if (c2 >= 0) {
                a[] aVarArr = this.f32086a;
                if (c2 < aVarArr.length) {
                    this.f32090e.add(aVarArr[c2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        private int c(int i2) {
            return this.f32087b + 1 + i2;
        }

        private void d() {
            int i2 = this.f32093h;
            int i3 = this.f32089d;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                e();
            } else {
                a(i3 - i2);
            }
        }

        private void d(int i2) throws IOException {
            this.f32090e.add(new a(f(i2), c()));
        }

        private void e() {
            Arrays.fill(this.f32086a, (Object) null);
            this.f32087b = this.f32086a.length - 1;
            this.f32088c = 0;
            this.f32089d = 0;
        }

        private void e(int i2) throws IOException {
            a(-1, new a(f(i2), c()));
        }

        private ByteString f(int i2) throws IOException {
            a aVar;
            if (g(i2)) {
                aVar = b.f32084a[i2];
            } else {
                int c2 = c(i2 - b.f32084a.length);
                if (c2 >= 0) {
                    a[] aVarArr = this.f32086a;
                    if (c2 < aVarArr.length) {
                        aVar = aVarArr[c2];
                    }
                }
                throw new IOException("Header index too large " + (i2 + 1));
            }
            return aVar.f32081g;
        }

        private void f() throws IOException {
            this.f32090e.add(new a(b.a(c()), c()));
        }

        private void g() throws IOException {
            a(-1, new a(b.a(c()), c()));
        }

        private boolean g(int i2) {
            return i2 >= 0 && i2 <= b.f32084a.length - 1;
        }

        private int h() throws IOException {
            return this.f32091f.i() & 255;
        }

        /* access modifiers changed from: package-private */
        public int a(int i2, int i3) throws IOException {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int h2 = h();
                if ((h2 & 128) == 0) {
                    return i3 + (h2 << i5);
                }
                i3 += (h2 & 127) << i5;
                i5 += 7;
            }
        }

        /* access modifiers changed from: package-private */
        public void a() throws IOException {
            while (!this.f32091f.f()) {
                byte i2 = this.f32091f.i() & 255;
                if (i2 == 128) {
                    throw new IOException("index == 0");
                } else if ((i2 & 128) == 128) {
                    b(a((int) i2, 127) - 1);
                } else if (i2 == 64) {
                    g();
                } else if ((i2 & 64) == 64) {
                    e(a((int) i2, 63) - 1);
                } else if ((i2 & 32) == 32) {
                    int a2 = a((int) i2, 31);
                    this.f32093h = a2;
                    if (a2 < 0 || a2 > this.f32092g) {
                        throw new IOException("Invalid dynamic table size update " + this.f32093h);
                    }
                    d();
                } else if (i2 == 16 || i2 == 0) {
                    f();
                } else {
                    d(a((int) i2, 15) - 1);
                }
            }
        }

        public List<a> b() {
            ArrayList arrayList = new ArrayList(this.f32090e);
            this.f32090e.clear();
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public ByteString c() throws IOException {
            int h2 = h();
            boolean z2 = (h2 & 128) == 128;
            int a2 = a(h2, 127);
            return z2 ? ByteString.a(i.a().a(this.f32091f.g((long) a2))) : this.f32091f.c((long) a2);
        }
    }

    /* renamed from: okhttp3.internal.http2.b$b  reason: collision with other inner class name */
    static final class C0236b {

        /* renamed from: a  reason: collision with root package name */
        int f32094a;

        /* renamed from: b  reason: collision with root package name */
        int f32095b;

        /* renamed from: c  reason: collision with root package name */
        a[] f32096c;

        /* renamed from: d  reason: collision with root package name */
        int f32097d;

        /* renamed from: e  reason: collision with root package name */
        int f32098e;

        /* renamed from: f  reason: collision with root package name */
        int f32099f;

        /* renamed from: g  reason: collision with root package name */
        private final c f32100g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f32101h;

        /* renamed from: i  reason: collision with root package name */
        private int f32102i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f32103j;

        C0236b(int i2, boolean z2, c cVar) {
            this.f32102i = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            a[] aVarArr = new a[8];
            this.f32096c = aVarArr;
            this.f32097d = aVarArr.length - 1;
            this.f32098e = 0;
            this.f32099f = 0;
            this.f32094a = i2;
            this.f32095b = i2;
            this.f32101h = z2;
            this.f32100g = cVar;
        }

        C0236b(c cVar) {
            this(4096, true, cVar);
        }

        private void a() {
            Arrays.fill(this.f32096c, (Object) null);
            this.f32097d = this.f32096c.length - 1;
            this.f32098e = 0;
            this.f32099f = 0;
        }

        private void a(a aVar) {
            int i2 = aVar.f32083i;
            int i3 = this.f32095b;
            if (i2 > i3) {
                a();
                return;
            }
            b((this.f32099f + i2) - i3);
            int i4 = this.f32098e + 1;
            a[] aVarArr = this.f32096c;
            if (i4 > aVarArr.length) {
                a[] aVarArr2 = new a[(aVarArr.length * 2)];
                System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                this.f32097d = this.f32096c.length - 1;
                this.f32096c = aVarArr2;
            }
            int i5 = this.f32097d;
            this.f32097d = i5 - 1;
            this.f32096c[i5] = aVar;
            this.f32098e++;
            this.f32099f += i2;
        }

        private int b(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.f32096c.length;
                while (true) {
                    length--;
                    i3 = this.f32097d;
                    if (length < i3 || i2 <= 0) {
                        a[] aVarArr = this.f32096c;
                        System.arraycopy(aVarArr, i3 + 1, aVarArr, i3 + 1 + i4, this.f32098e);
                        a[] aVarArr2 = this.f32096c;
                        int i5 = this.f32097d;
                        Arrays.fill(aVarArr2, i5 + 1, i5 + 1 + i4, (Object) null);
                        this.f32097d += i4;
                    } else {
                        i2 -= this.f32096c[length].f32083i;
                        this.f32099f -= this.f32096c[length].f32083i;
                        this.f32098e--;
                        i4++;
                    }
                }
                a[] aVarArr3 = this.f32096c;
                System.arraycopy(aVarArr3, i3 + 1, aVarArr3, i3 + 1 + i4, this.f32098e);
                a[] aVarArr22 = this.f32096c;
                int i52 = this.f32097d;
                Arrays.fill(aVarArr22, i52 + 1, i52 + 1 + i4, (Object) null);
                this.f32097d += i4;
            }
            return i4;
        }

        private void b() {
            int i2 = this.f32095b;
            int i3 = this.f32099f;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                a();
            } else {
                b(i3 - i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.f32094a = i2;
            int min = Math.min(i2, 16384);
            int i3 = this.f32095b;
            if (i3 != min) {
                if (min < i3) {
                    this.f32102i = Math.min(this.f32102i, min);
                }
                this.f32103j = true;
                this.f32095b = min;
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3, int i4) {
            int i5;
            c cVar;
            if (i2 < i3) {
                cVar = this.f32100g;
                i5 = i2 | i4;
            } else {
                this.f32100g.i(i4 | i3);
                i5 = i2 - i3;
                while (i5 >= 128) {
                    this.f32100g.i(128 | (i5 & 127));
                    i5 >>>= 7;
                }
                cVar = this.f32100g;
            }
            cVar.i(i5);
        }

        /* access modifiers changed from: package-private */
        public void a(List<a> list) throws IOException {
            int i2;
            int i3;
            if (this.f32103j) {
                int i4 = this.f32102i;
                if (i4 < this.f32095b) {
                    a(i4, 31, 32);
                }
                this.f32103j = false;
                this.f32102i = SubsamplingScaleImageView.TILE_SIZE_AUTO;
                a(this.f32095b, 31, 32);
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                a aVar = list.get(i5);
                ByteString f2 = aVar.f32081g.f();
                ByteString byteString = aVar.f32082h;
                Integer num = b.f32085b.get(f2);
                if (num != null) {
                    i3 = num.intValue() + 1;
                    if (i3 > 1 && i3 < 8) {
                        if (Objects.equals(b.f32084a[i3 - 1].f32082h, byteString)) {
                            i2 = i3;
                        } else if (Objects.equals(b.f32084a[i3].f32082h, byteString)) {
                            i2 = i3;
                            i3++;
                        }
                    }
                    i2 = i3;
                    i3 = -1;
                } else {
                    i3 = -1;
                    i2 = -1;
                }
                if (i3 == -1) {
                    int i6 = this.f32097d + 1;
                    int length = this.f32096c.length;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        }
                        if (Objects.equals(this.f32096c[i6].f32081g, f2)) {
                            if (Objects.equals(this.f32096c[i6].f32082h, byteString)) {
                                i3 = b.f32084a.length + (i6 - this.f32097d);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i6 - this.f32097d) + b.f32084a.length;
                            }
                        }
                        i6++;
                    }
                }
                if (i3 != -1) {
                    a(i3, 127, 128);
                } else {
                    if (i2 == -1) {
                        this.f32100g.i(64);
                        a(f2);
                    } else if (!f2.a(a.f32075a) || a.f32080f.equals(f2)) {
                        a(i2, 63, 64);
                    } else {
                        a(i2, 15, 0);
                        a(byteString);
                    }
                    a(byteString);
                    a(aVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(ByteString byteString) throws IOException {
            int i2;
            int i3;
            if (!this.f32101h || i.a().a(byteString) >= byteString.g()) {
                i3 = byteString.g();
                i2 = 0;
            } else {
                c cVar = new c();
                i.a().a(byteString, cVar);
                byteString = cVar.o();
                i3 = byteString.g();
                i2 = 128;
            }
            a(i3, 127, i2);
            this.f32100g.b(byteString);
        }
    }

    private static Map<ByteString, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f32084a.length);
        int i2 = 0;
        while (true) {
            a[] aVarArr = f32084a;
            if (i2 >= aVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(aVarArr[i2].f32081g)) {
                linkedHashMap.put(aVarArr[i2].f32081g, Integer.valueOf(i2));
            }
            i2++;
        }
    }

    static ByteString a(ByteString byteString) throws IOException {
        int g2 = byteString.g();
        int i2 = 0;
        while (i2 < g2) {
            byte a2 = byteString.a(i2);
            if (a2 < 65 || a2 > 90) {
                i2++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.a());
            }
        }
        return byteString;
    }
}
