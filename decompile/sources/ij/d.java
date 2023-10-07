package ij;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class d extends a {

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f13569b;

    /* renamed from: c  reason: collision with root package name */
    private final Charset f13570c;

    public d(String str) throws UnsupportedEncodingException {
        this(str, "text/plain", (Charset) null);
    }

    public d(String str, String str2, Charset charset) throws UnsupportedEncodingException {
        super(str2);
        if (str != null) {
            charset = charset == null ? Charset.forName("UTF-8") : charset;
            this.f13569b = str.getBytes(charset.name());
            this.f13570c = charset;
            return;
        }
        throw new IllegalArgumentException("Text may not be null");
    }

    public void a(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.f13569b);
            byte[] bArr = new byte[4096];
            do {
                int read = byteArrayInputStream.read(bArr);
                if (read == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, read);
                this.f13565a.f21117d += (long) read;
            } while (this.f13565a.a(false));
            throw new InterruptedIOException("cancel");
        }
        throw new IllegalArgumentException("Output stream may not be null");
    }

    public String b() {
        return null;
    }

    public String c() {
        return this.f13570c.name();
    }

    public String d() {
        return "8bit";
    }

    public long e() {
        return (long) this.f13569b.length;
    }
}
