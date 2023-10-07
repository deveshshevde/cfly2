package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Objects;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

final class m implements d {

    /* renamed from: a  reason: collision with root package name */
    public final c f32457a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final q f32458b;

    /* renamed from: c  reason: collision with root package name */
    boolean f32459c;

    m(q qVar) {
        Objects.requireNonNull(qVar, "sink == null");
        this.f32458b = qVar;
    }

    public long a(r rVar) throws IOException {
        if (rVar != null) {
            long j2 = 0;
            while (true) {
                long read = rVar.read(this.f32457a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER);
                if (read == -1) {
                    return j2;
                }
                j2 += read;
                v();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public c b() {
        return this.f32457a;
    }

    public d b(String str) throws IOException {
        if (!this.f32459c) {
            this.f32457a.b(str);
            return v();
        }
        throw new IllegalStateException("closed");
    }

    public d b(ByteString byteString) throws IOException {
        if (!this.f32459c) {
            this.f32457a.b(byteString);
            return v();
        }
        throw new IllegalStateException("closed");
    }

    public d c(byte[] bArr) throws IOException {
        if (!this.f32459c) {
            this.f32457a.c(bArr);
            return v();
        }
        throw new IllegalStateException("closed");
    }

    public d c(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f32459c) {
            this.f32457a.c(bArr, i2, i3);
            return v();
        }
        throw new IllegalStateException("closed");
    }

    public void close() throws IOException {
        if (!this.f32459c) {
            Throwable th = null;
            try {
                if (this.f32457a.f32436b > 0) {
                    q qVar = this.f32458b;
                    c cVar = this.f32457a;
                    qVar.write(cVar, cVar.f32436b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f32458b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f32459c = true;
            if (th != null) {
                t.a(th);
            }
        }
    }

    public OutputStream d() {
        return new OutputStream() {
            public void close() throws IOException {
                m.this.close();
            }

            public void flush() throws IOException {
                if (!m.this.f32459c) {
                    m.this.flush();
                }
            }

            public String toString() {
                return m.this + ".outputStream()";
            }

            public void write(int i2) throws IOException {
                if (!m.this.f32459c) {
                    m.this.f32457a.i((int) (byte) i2);
                    m.this.v();
                    return;
                }
                throw new IOException("closed");
            }

            public void write(byte[] bArr, int i2, int i3) throws IOException {
                if (!m.this.f32459c) {
                    m.this.f32457a.c(bArr, i2, i3);
                    m.this.v();
                    return;
                }
                throw new IOException("closed");
            }
        };
    }

    public void flush() throws IOException {
        if (!this.f32459c) {
            if (this.f32457a.f32436b > 0) {
                q qVar = this.f32458b;
                c cVar = this.f32457a;
                qVar.write(cVar, cVar.f32436b);
            }
            this.f32458b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public d g(int i2) throws IOException {
        if (!this.f32459c) {
            this.f32457a.g(i2);
            return v();
        }
        throw new IllegalStateException("closed");
    }

    public d h(int i2) throws IOException {
        if (!this.f32459c) {
            this.f32457a.h(i2);
            return v();
        }
        throw new IllegalStateException("closed");
    }

    public d i(int i2) throws IOException {
        if (!this.f32459c) {
            this.f32457a.i(i2);
            return v();
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.f32459c;
    }

    public d k(long j2) throws IOException {
        if (!this.f32459c) {
            this.f32457a.k(j2);
            return v();
        }
        throw new IllegalStateException("closed");
    }

    public d l(long j2) throws IOException {
        if (!this.f32459c) {
            this.f32457a.l(j2);
            return v();
        }
        throw new IllegalStateException("closed");
    }

    public s timeout() {
        return this.f32458b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f32458b + ")";
    }

    public d v() throws IOException {
        if (!this.f32459c) {
            long h2 = this.f32457a.h();
            if (h2 > 0) {
                this.f32458b.write(this.f32457a, h2);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f32459c) {
            int write = this.f32457a.write(byteBuffer);
            v();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    public void write(c cVar, long j2) throws IOException {
        if (!this.f32459c) {
            this.f32457a.write(cVar, j2);
            v();
            return;
        }
        throw new IllegalStateException("closed");
    }
}
