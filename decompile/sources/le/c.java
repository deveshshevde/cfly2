package le;

import java.io.IOException;
import okhttp3.ac;
import okhttp3.v;
import okio.e;
import okio.g;
import okio.k;
import okio.r;

public class c extends ac {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ac f30783a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f30784b;

    /* renamed from: c  reason: collision with root package name */
    private e f30785c;

    public c(ac acVar, b bVar) {
        this.f30783a = acVar;
        this.f30784b = bVar;
    }

    private r a(r rVar) {
        return new g(rVar) {

            /* renamed from: a  reason: collision with root package name */
            long f30786a = 0;

            /* renamed from: b  reason: collision with root package name */
            int f30787b = 0;

            public long read(okio.c cVar, long j2) throws IOException {
                int contentLength;
                long read = super.read(cVar, j2);
                this.f30786a += read != -1 ? read : 0;
                if (!(c.this.f30784b == null || read == -1 || (contentLength = (int) ((this.f30786a * 100) / c.this.f30783a.contentLength())) == this.f30787b)) {
                    c.this.f30784b.onProgress(contentLength);
                    this.f30787b = contentLength;
                }
                return read;
            }
        };
    }

    public long contentLength() {
        return this.f30783a.contentLength();
    }

    public v contentType() {
        return this.f30783a.contentType();
    }

    public e source() {
        if (this.f30785c == null) {
            this.f30785c = k.a(a((r) this.f30783a.source()));
        }
        return this.f30785c;
    }
}
