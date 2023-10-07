package ii;

import ih.e;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

abstract class b extends HttpEntityWrapper implements d {

    /* renamed from: a  reason: collision with root package name */
    private InputStream f13561a;

    /* renamed from: b  reason: collision with root package name */
    private long f13562b;

    /* renamed from: c  reason: collision with root package name */
    private long f13563c = 0;

    /* renamed from: d  reason: collision with root package name */
    private e f13564d = null;

    public b(HttpEntity httpEntity) {
        super(httpEntity);
        this.f13562b = httpEntity.getContentLength();
    }

    private InputStream a() throws IOException {
        try {
            return a(this.wrappedEntity.getContent());
        } catch (IOException e2) {
            il.b.a((Closeable) null);
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract InputStream a(InputStream inputStream) throws IOException;

    public void a(e eVar) {
        this.f13564d = eVar;
    }

    public InputStream getContent() throws IOException {
        if (!this.wrappedEntity.isStreaming()) {
            return a();
        }
        if (this.f13561a == null) {
            this.f13561a = a();
        }
        return this.f13561a;
    }

    public long getContentLength() {
        return -1;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            InputStream inputStream = null;
            try {
                inputStream = getContent();
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        outputStream.flush();
                        e eVar = this.f13564d;
                        if (eVar != null) {
                            eVar.a(this.f13562b, this.f13563c, true);
                        }
                        return;
                    }
                    outputStream.write(bArr, 0, read);
                    long j2 = this.f13563c + ((long) read);
                    this.f13563c = j2;
                    e eVar2 = this.f13564d;
                    if (eVar2 != null) {
                        if (!eVar2.a(this.f13562b, j2, false)) {
                            throw new InterruptedIOException("cancel");
                        }
                    }
                }
            } finally {
                il.b.a(inputStream);
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }
}
