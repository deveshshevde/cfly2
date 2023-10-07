package cc;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class c extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final long f6174a;

    /* renamed from: b  reason: collision with root package name */
    private int f6175b;

    private c(InputStream inputStream, long j2) {
        super(inputStream);
        this.f6174a = j2;
    }

    private int a(int i2) throws IOException {
        if (i2 >= 0) {
            this.f6175b += i2;
        } else if (this.f6174a - ((long) this.f6175b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f6174a + ", but read: " + this.f6175b);
        }
        return i2;
    }

    public static InputStream a(InputStream inputStream, long j2) {
        return new c(inputStream, j2);
    }

    public synchronized int available() throws IOException {
        return (int) Math.max(this.f6174a - ((long) this.f6175b), (long) this.in.available());
    }

    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        return a(super.read(bArr, i2, i3));
    }
}
