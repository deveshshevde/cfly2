package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class g extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f10171a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f10172b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f10173c;

    /* renamed from: d  reason: collision with root package name */
    private final byte f10174d;

    /* renamed from: e  reason: collision with root package name */
    private int f10175e;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f10171a = bArr;
        int length = bArr.length;
        f10172b = length;
        f10173c = length + 2;
    }

    public g(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 < -1 || i2 > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i2);
        }
        this.f10174d = (byte) i2;
    }

    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        int i2;
        int i3 = this.f10175e;
        int read = (i3 < 2 || i3 > (i2 = f10173c)) ? super.read() : i3 == i2 ? this.f10174d : f10171a[i3 - 2] & 255;
        if (read != -1) {
            this.f10175e++;
        }
        return read;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.f10175e;
        int i6 = f10173c;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f10174d;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int min = Math.min(i6 - i5, i3);
            System.arraycopy(f10171a, this.f10175e - 2, bArr, i2, min);
            i4 = min;
        }
        if (i4 > 0) {
            this.f10175e += i4;
        }
        return i4;
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public long skip(long j2) throws IOException {
        long skip = super.skip(j2);
        if (skip > 0) {
            this.f10175e = (int) (((long) this.f10175e) + skip);
        }
        return skip;
    }
}
