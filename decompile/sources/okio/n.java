package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

final class n implements e {

    /* renamed from: a  reason: collision with root package name */
    public final c f32461a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final r f32462b;

    /* renamed from: c  reason: collision with root package name */
    boolean f32463c;

    n(r rVar) {
        Objects.requireNonNull(rVar, "source == null");
        this.f32462b = rVar;
    }

    public int a(l lVar) throws IOException {
        if (!this.f32463c) {
            do {
                int a2 = this.f32461a.a(lVar, true);
                if (a2 == -1) {
                    return -1;
                }
                if (a2 != -2) {
                    this.f32461a.h((long) lVar.f32455a[a2].g());
                    return a2;
                }
            } while (this.f32462b.read(this.f32461a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) != -1);
            return -1;
        }
        throw new IllegalStateException("closed");
    }

    public long a(byte b2) throws IOException {
        return a(b2, 0, Long.MAX_VALUE);
    }

    public long a(byte b2, long j2, long j3) throws IOException {
        if (this.f32463c) {
            throw new IllegalStateException("closed");
        } else if (j2 < 0 || j3 < j2) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j2), Long.valueOf(j3)}));
        } else {
            while (j2 < j3) {
                long a2 = this.f32461a.a(b2, j2, j3);
                if (a2 == -1) {
                    long j4 = this.f32461a.f32436b;
                    if (j4 >= j3 || this.f32462b.read(this.f32461a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                        break;
                    }
                    j2 = Math.max(j2, j4);
                } else {
                    return a2;
                }
            }
            return -1;
        }
    }

    public long a(q qVar) throws IOException {
        c cVar;
        if (qVar != null) {
            long j2 = 0;
            while (true) {
                int i2 = (this.f32462b.read(this.f32461a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) > -1 ? 1 : (this.f32462b.read(this.f32461a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1 ? 0 : -1));
                cVar = this.f32461a;
                if (i2 == 0) {
                    break;
                }
                long h2 = cVar.h();
                if (h2 > 0) {
                    j2 += h2;
                    qVar.write(this.f32461a, h2);
                }
            }
            if (cVar.a() <= 0) {
                return j2;
            }
            long a2 = j2 + this.f32461a.a();
            c cVar2 = this.f32461a;
            qVar.write(cVar2, cVar2.a());
            return a2;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public String a(Charset charset) throws IOException {
        if (charset != null) {
            this.f32461a.a(this.f32462b);
            return this.f32461a.a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public void a(long j2) throws IOException {
        if (!b(j2)) {
            throw new EOFException();
        }
    }

    public void a(byte[] bArr) throws IOException {
        try {
            a((long) bArr.length);
            this.f32461a.a(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (this.f32461a.f32436b > 0) {
                c cVar = this.f32461a;
                int a2 = cVar.a(bArr, i2, (int) cVar.f32436b);
                if (a2 != -1) {
                    i2 += a2;
                } else {
                    throw new AssertionError();
                }
            }
            throw e2;
        }
    }

    public c b() {
        return this.f32461a;
    }

    public boolean b(long j2) throws IOException {
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (!this.f32463c) {
            while (this.f32461a.f32436b < j2) {
                if (this.f32462b.read(this.f32461a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public ByteString c(long j2) throws IOException {
        a(j2);
        return this.f32461a.c(j2);
    }

    public c c() {
        return this.f32461a;
    }

    public void close() throws IOException {
        if (!this.f32463c) {
            this.f32463c = true;
            this.f32462b.close();
            this.f32461a.s();
        }
    }

    public String e(long j2) throws IOException {
        if (j2 >= 0) {
            long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
            long a2 = a((byte) 10, 0, j3);
            if (a2 != -1) {
                return this.f32461a.f(a2);
            }
            if (j3 < Long.MAX_VALUE && b(j3) && this.f32461a.b(j3 - 1) == 13 && b(1 + j3) && this.f32461a.b(j3) == 10) {
                return this.f32461a.f(j3);
            }
            c cVar = new c();
            c cVar2 = this.f32461a;
            cVar2.a(cVar, 0, Math.min(32, cVar2.a()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f32461a.a(), j2) + " content=" + cVar.o().e() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j2);
    }

    public boolean f() throws IOException {
        if (!this.f32463c) {
            return this.f32461a.f() && this.f32462b.read(this.f32461a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public InputStream g() {
        return new InputStream() {
            public int available() throws IOException {
                if (!n.this.f32463c) {
                    return (int) Math.min(n.this.f32461a.f32436b, 2147483647L);
                }
                throw new IOException("closed");
            }

            public void close() throws IOException {
                n.this.close();
            }

            public int read() throws IOException {
                if (n.this.f32463c) {
                    throw new IOException("closed");
                } else if (n.this.f32461a.f32436b == 0 && n.this.f32462b.read(n.this.f32461a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                    return -1;
                } else {
                    return n.this.f32461a.i() & 255;
                }
            }

            public int read(byte[] bArr, int i2, int i3) throws IOException {
                if (!n.this.f32463c) {
                    t.a((long) bArr.length, (long) i2, (long) i3);
                    if (n.this.f32461a.f32436b == 0 && n.this.f32462b.read(n.this.f32461a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                        return -1;
                    }
                    return n.this.f32461a.a(bArr, i2, i3);
                }
                throw new IOException("closed");
            }

            public String toString() {
                return n.this + ".inputStream()";
            }
        };
    }

    public byte[] g(long j2) throws IOException {
        a(j2);
        return this.f32461a.g(j2);
    }

    public void h(long j2) throws IOException {
        if (!this.f32463c) {
            while (j2 > 0) {
                if (this.f32461a.f32436b == 0 && this.f32462b.read(this.f32461a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j2, this.f32461a.a());
                this.f32461a.h(min);
                j2 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public byte i() throws IOException {
        a(1);
        return this.f32461a.i();
    }

    public boolean isOpen() {
        return !this.f32463c;
    }

    public short j() throws IOException {
        a(2);
        return this.f32461a.j();
    }

    public int k() throws IOException {
        a(4);
        return this.f32461a.k();
    }

    public short l() throws IOException {
        a(2);
        return this.f32461a.l();
    }

    public int m() throws IOException {
        a(4);
        return this.f32461a.m();
    }

    public long n() throws IOException {
        a(1);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!b((long) i3)) {
                break;
            }
            byte b2 = this.f32461a.b((long) i2);
            if ((b2 >= 48 && b2 <= 57) || ((b2 >= 97 && b2 <= 102) || (b2 >= 65 && b2 <= 70))) {
                i2 = i3;
            } else if (i2 == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b2)}));
            }
        }
        return this.f32461a.n();
    }

    public String q() throws IOException {
        return e(Long.MAX_VALUE);
    }

    public byte[] r() throws IOException {
        this.f32461a.a(this.f32462b);
        return this.f32461a.r();
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.f32461a.f32436b == 0 && this.f32462b.read(this.f32461a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
            return -1;
        }
        return this.f32461a.read(byteBuffer);
    }

    public long read(c cVar, long j2) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (this.f32463c) {
            throw new IllegalStateException("closed");
        } else if (this.f32461a.f32436b == 0 && this.f32462b.read(this.f32461a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
            return -1;
        } else {
            return this.f32461a.read(cVar, Math.min(j2, this.f32461a.f32436b));
        }
    }

    public s timeout() {
        return this.f32462b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f32462b + ")";
    }
}
