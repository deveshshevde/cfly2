package oh;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import org.jsoup.helper.c;

public final class a extends BufferedInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f31759a;

    /* renamed from: b  reason: collision with root package name */
    private final int f31760b;

    /* renamed from: c  reason: collision with root package name */
    private long f31761c;

    /* renamed from: d  reason: collision with root package name */
    private long f31762d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f31763e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31764f;

    private a(InputStream inputStream, int i2, int i3) {
        super(inputStream, i2);
        boolean z2 = true;
        c.a(i3 >= 0);
        this.f31760b = i3;
        this.f31763e = i3;
        this.f31759a = i3 == 0 ? false : z2;
        this.f31761c = System.nanoTime();
    }

    public static a a(InputStream inputStream, int i2, int i3) {
        return inputStream instanceof a ? (a) inputStream : new a(inputStream, i2, i3);
    }

    private boolean a() {
        return this.f31762d != 0 && System.nanoTime() - this.f31761c > this.f31762d;
    }

    public ByteBuffer a(int i2) throws IOException {
        boolean z2 = true;
        c.a(i2 >= 0, "maxSize must be 0 (unlimited) or larger");
        if (i2 <= 0) {
            z2 = false;
        }
        int i3 = 32768;
        if (z2 && i2 < 32768) {
            i3 = i2;
        }
        byte[] bArr = new byte[i3];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i3);
        while (true) {
            int read = read(bArr);
            if (read == -1) {
                break;
            }
            if (z2) {
                if (read >= i2) {
                    byteArrayOutputStream.write(bArr, 0, i2);
                    break;
                }
                i2 -= read;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    public a a(long j2, long j3) {
        this.f31761c = j2;
        this.f31762d = j3 * 1000000;
        return this;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        if (this.f31764f || (this.f31759a && this.f31763e <= 0)) {
            return -1;
        }
        if (Thread.interrupted()) {
            this.f31764f = true;
            return -1;
        } else if (!a()) {
            if (this.f31759a && i3 > (i4 = this.f31763e)) {
                i3 = i4;
            }
            try {
                int read = super.read(bArr, i2, i3);
                this.f31763e -= read;
                return read;
            } catch (SocketTimeoutException unused) {
                return 0;
            }
        } else {
            throw new SocketTimeoutException("Read timeout");
        }
    }

    public void reset() throws IOException {
        super.reset();
        this.f31763e = this.f31760b - this.markpos;
    }
}
