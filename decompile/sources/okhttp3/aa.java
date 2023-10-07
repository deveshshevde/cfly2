package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import nb.c;
import okio.ByteString;
import okio.d;

public abstract class aa {
    public static aa create(final v vVar, final File file) {
        Objects.requireNonNull(file, "file == null");
        return new aa() {
            public long contentLength() {
                return file.length();
            }

            public v contentType() {
                return v.this;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
                r0.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
                r3.addSuppressed(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
                throw r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
                r1 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
                if (r0 != null) goto L_0x0014;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void writeTo(okio.d r3) throws java.io.IOException {
                /*
                    r2 = this;
                    java.io.File r0 = r2
                    okio.r r0 = okio.k.a((java.io.File) r0)
                    r3.a(r0)     // Catch:{ all -> 0x000f }
                    if (r0 == 0) goto L_0x000e
                    r0.close()
                L_0x000e:
                    return
                L_0x000f:
                    r3 = move-exception
                    throw r3     // Catch:{ all -> 0x0011 }
                L_0x0011:
                    r1 = move-exception
                    if (r0 == 0) goto L_0x001c
                    r0.close()     // Catch:{ all -> 0x0018 }
                    goto L_0x001c
                L_0x0018:
                    r0 = move-exception
                    r3.addSuppressed(r0)
                L_0x001c:
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: okhttp3.aa.AnonymousClass3.writeTo(okio.d):void");
            }
        };
    }

    public static aa create(v vVar, String str) {
        Charset charset = StandardCharsets.UTF_8;
        if (vVar != null && (charset = vVar.b()) == null) {
            charset = StandardCharsets.UTF_8;
            vVar = v.b(vVar + "; charset=utf-8");
        }
        return create(vVar, str.getBytes(charset));
    }

    public static aa create(final v vVar, final ByteString byteString) {
        return new aa() {
            public long contentLength() throws IOException {
                return (long) byteString.g();
            }

            public v contentType() {
                return v.this;
            }

            public void writeTo(d dVar) throws IOException {
                dVar.b(byteString);
            }
        };
    }

    public static aa create(v vVar, byte[] bArr) {
        return create(vVar, bArr, 0, bArr.length);
    }

    public static aa create(final v vVar, final byte[] bArr, final int i2, final int i3) {
        Objects.requireNonNull(bArr, "content == null");
        c.a((long) bArr.length, (long) i2, (long) i3);
        return new aa() {
            public long contentLength() {
                return (long) i3;
            }

            public v contentType() {
                return v.this;
            }

            public void writeTo(d dVar) throws IOException {
                dVar.c(bArr, i2, i3);
            }
        };
    }

    public long contentLength() throws IOException {
        return -1;
    }

    public abstract v contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(d dVar) throws IOException;
}
