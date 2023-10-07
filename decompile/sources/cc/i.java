package cc;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class i extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private int f6190a = Integer.MIN_VALUE;

    public i(InputStream inputStream) {
        super(inputStream);
    }

    private long a(long j2) {
        int i2 = this.f6190a;
        if (i2 == 0) {
            return -1;
        }
        return (i2 == Integer.MIN_VALUE || j2 <= ((long) i2)) ? j2 : (long) i2;
    }

    private void b(long j2) {
        int i2 = this.f6190a;
        if (i2 != Integer.MIN_VALUE && j2 != -1) {
            this.f6190a = (int) (((long) i2) - j2);
        }
    }

    public int available() throws IOException {
        int i2 = this.f6190a;
        return i2 == Integer.MIN_VALUE ? super.available() : Math.min(i2, super.available());
    }

    public synchronized void mark(int i2) {
        super.mark(i2);
        this.f6190a = i2;
    }

    public int read() throws IOException {
        if (a(1) == -1) {
            return -1;
        }
        int read = super.read();
        b(1);
        return read;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int a2 = (int) a((long) i3);
        if (a2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i2, a2);
        b((long) read);
        return read;
    }

    public synchronized void reset() throws IOException {
        super.reset();
        this.f6190a = Integer.MIN_VALUE;
    }

    public long skip(long j2) throws IOException {
        long a2 = a(j2);
        if (a2 == -1) {
            return 0;
        }
        long skip = super.skip(a2);
        b(skip);
        return skip;
    }
}
