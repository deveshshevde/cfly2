package com.amap.api.mapcore.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public final class gu implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f8972a = Charset.forName("US-ASCII");

    /* renamed from: b  reason: collision with root package name */
    private final InputStream f8973b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Charset f8974c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f8975d;

    /* renamed from: e  reason: collision with root package name */
    private int f8976e;

    /* renamed from: f  reason: collision with root package name */
    private int f8977f;

    public gu(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private gu(InputStream inputStream, Charset charset, byte b2) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (charset.equals(f8972a)) {
            this.f8973b = inputStream;
            this.f8974c = charset;
            this.f8975d = new byte[8192];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    private void b() throws IOException {
        InputStream inputStream = this.f8973b;
        byte[] bArr = this.f8975d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f8976e = 0;
            this.f8977f = read;
            return;
        }
        throw new EOFException();
    }

    public final String a() throws IOException {
        int i2;
        byte[] bArr;
        int i3;
        synchronized (this.f8973b) {
            if (this.f8975d != null) {
                if (this.f8976e >= this.f8977f) {
                    b();
                }
                for (int i4 = this.f8976e; i4 != this.f8977f; i4++) {
                    byte[] bArr2 = this.f8975d;
                    if (bArr2[i4] == 10) {
                        if (i4 != this.f8976e) {
                            i3 = i4 - 1;
                            if (bArr2[i3] == 13) {
                                byte[] bArr3 = this.f8975d;
                                int i5 = this.f8976e;
                                String str = new String(bArr3, i5, i3 - i5, this.f8974c.name());
                                this.f8976e = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        byte[] bArr32 = this.f8975d;
                        int i52 = this.f8976e;
                        String str2 = new String(bArr32, i52, i3 - i52, this.f8974c.name());
                        this.f8976e = i4 + 1;
                        return str2;
                    }
                }
                AnonymousClass1 r1 = new ByteArrayOutputStream((this.f8977f - this.f8976e) + 80) {
                    public final String toString() {
                        try {
                            return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, gu.this.f8974c.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1:
                while (true) {
                    byte[] bArr4 = this.f8975d;
                    int i6 = this.f8976e;
                    r1.write(bArr4, i6, this.f8977f - i6);
                    this.f8977f = -1;
                    b();
                    i2 = this.f8976e;
                    while (true) {
                        if (i2 != this.f8977f) {
                            bArr = this.f8975d;
                            if (bArr[i2] == 10) {
                                break loop1;
                            }
                            i2++;
                        }
                    }
                }
                int i7 = this.f8976e;
                if (i2 != i7) {
                    r1.write(bArr, i7, i2 - i7);
                }
                this.f8976e = i2 + 1;
                String byteArrayOutputStream = r1.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    public final void close() throws IOException {
        synchronized (this.f8973b) {
            if (this.f8975d != null) {
                this.f8975d = null;
                this.f8973b.close();
            }
        }
    }
}
