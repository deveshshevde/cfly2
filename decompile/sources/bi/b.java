package bi;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f5678a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Charset f5679b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f5680c;

    /* renamed from: d  reason: collision with root package name */
    private int f5681d;

    /* renamed from: e  reason: collision with root package name */
    private int f5682e;

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(c.f5684a)) {
            this.f5678a = inputStream;
            this.f5679b = charset;
            this.f5680c = new byte[i2];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() throws IOException {
        InputStream inputStream = this.f5678a;
        byte[] bArr = this.f5680c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f5681d = 0;
            this.f5682e = read;
            return;
        }
        throw new EOFException();
    }

    public String a() throws IOException {
        int i2;
        byte[] bArr;
        int i3;
        synchronized (this.f5678a) {
            if (this.f5680c != null) {
                if (this.f5681d >= this.f5682e) {
                    c();
                }
                for (int i4 = this.f5681d; i4 != this.f5682e; i4++) {
                    byte[] bArr2 = this.f5680c;
                    if (bArr2[i4] == 10) {
                        if (i4 != this.f5681d) {
                            i3 = i4 - 1;
                            if (bArr2[i3] == 13) {
                                byte[] bArr3 = this.f5680c;
                                int i5 = this.f5681d;
                                String str = new String(bArr3, i5, i3 - i5, this.f5679b.name());
                                this.f5681d = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        byte[] bArr32 = this.f5680c;
                        int i52 = this.f5681d;
                        String str2 = new String(bArr32, i52, i3 - i52, this.f5679b.name());
                        this.f5681d = i4 + 1;
                        return str2;
                    }
                }
                AnonymousClass1 r1 = new ByteArrayOutputStream((this.f5682e - this.f5681d) + 80) {
                    public String toString() {
                        try {
                            return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, b.this.f5679b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1:
                while (true) {
                    byte[] bArr4 = this.f5680c;
                    int i6 = this.f5681d;
                    r1.write(bArr4, i6, this.f5682e - i6);
                    this.f5682e = -1;
                    c();
                    i2 = this.f5681d;
                    while (true) {
                        if (i2 != this.f5682e) {
                            bArr = this.f5680c;
                            if (bArr[i2] == 10) {
                                break loop1;
                            }
                            i2++;
                        }
                    }
                }
                int i7 = this.f5681d;
                if (i2 != i7) {
                    r1.write(bArr, i7, i2 - i7);
                }
                this.f5681d = i2 + 1;
                String byteArrayOutputStream = r1.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean b() {
        return this.f5682e == -1;
    }

    public void close() throws IOException {
        synchronized (this.f5678a) {
            if (this.f5680c != null) {
                this.f5680c = null;
                this.f5678a.close();
            }
        }
    }
}
