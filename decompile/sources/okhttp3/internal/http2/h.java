package okhttp3.internal.http2;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.b;
import okio.c;
import okio.d;

final class h implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f32225b = Logger.getLogger(c.class.getName());

    /* renamed from: a  reason: collision with root package name */
    final b.C0236b f32226a;

    /* renamed from: c  reason: collision with root package name */
    private final d f32227c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f32228d;

    /* renamed from: e  reason: collision with root package name */
    private final c f32229e;

    /* renamed from: f  reason: collision with root package name */
    private int f32230f = 16384;

    /* renamed from: g  reason: collision with root package name */
    private boolean f32231g;

    h(d dVar, boolean z2) {
        this.f32227c = dVar;
        this.f32228d = z2;
        c cVar = new c();
        this.f32229e = cVar;
        this.f32226a = new b.C0236b(cVar);
    }

    private static void a(d dVar, int i2) throws IOException {
        dVar.i((i2 >>> 16) & 255);
        dVar.i((i2 >>> 8) & 255);
        dVar.i(i2 & 255);
    }

    private void b(int i2, long j2) throws IOException {
        while (j2 > 0) {
            int min = (int) Math.min((long) this.f32230f, j2);
            long j3 = (long) min;
            j2 -= j3;
            a(i2, min, (byte) 9, j2 == 0 ? (byte) 4 : 0);
            this.f32227c.write(this.f32229e, j3);
        }
    }

    public synchronized void a() throws IOException {
        if (this.f32231g) {
            throw new IOException("closed");
        } else if (this.f32228d) {
            Logger logger = f32225b;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(nb.c.a(">> CONNECTION %s", c.f32104a.e()));
            }
            this.f32227c.c(c.f32104a.h());
            this.f32227c.flush();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, byte b2, c cVar, int i3) throws IOException {
        a(i2, i3, (byte) 0, b2);
        if (i3 > 0) {
            this.f32227c.write(cVar, (long) i3);
        }
    }

    public void a(int i2, int i3, byte b2, byte b3) throws IOException {
        Logger logger = f32225b;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(c.a(false, i2, i3, b2, b3));
        }
        int i4 = this.f32230f;
        if (i3 > i4) {
            throw c.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
        } else if ((Integer.MIN_VALUE & i2) == 0) {
            a(this.f32227c, i3);
            this.f32227c.i(b2 & 255);
            this.f32227c.i(b3 & 255);
            this.f32227c.g(i2 & SubsamplingScaleImageView.TILE_SIZE_AUTO);
        } else {
            throw c.a("reserved bit set: %s", Integer.valueOf(i2));
        }
    }

    public synchronized void a(int i2, int i3, List<a> list) throws IOException {
        if (!this.f32231g) {
            this.f32226a.a(list);
            long a2 = this.f32229e.a();
            int min = (int) Math.min((long) (this.f32230f - 4), a2);
            long j2 = (long) min;
            a(i2, min + 4, (byte) 5, a2 == j2 ? (byte) 4 : 0);
            this.f32227c.g(i3 & SubsamplingScaleImageView.TILE_SIZE_AUTO);
            this.f32227c.write(this.f32229e, j2);
            if (a2 > j2) {
                b(i2, a2 - j2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i2, long j2) throws IOException {
        if (this.f32231g) {
            throw new IOException("closed");
        } else if (j2 == 0 || j2 > 2147483647L) {
            throw c.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j2));
        } else {
            a(i2, 4, (byte) 8, (byte) 0);
            this.f32227c.g((int) j2);
            this.f32227c.flush();
        }
    }

    public synchronized void a(int i2, ErrorCode errorCode) throws IOException {
        if (this.f32231g) {
            throw new IOException("closed");
        } else if (errorCode.f32073l != -1) {
            a(i2, 4, (byte) 3, (byte) 0);
            this.f32227c.g(errorCode.f32073l);
            this.f32227c.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void a(int i2, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.f32231g) {
            throw new IOException("closed");
        } else if (errorCode.f32073l != -1) {
            a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f32227c.g(i2);
            this.f32227c.g(errorCode.f32073l);
            if (bArr.length > 0) {
                this.f32227c.c(bArr);
            }
            this.f32227c.flush();
        } else {
            throw c.a("errorCode.httpCode == -1", new Object[0]);
        }
    }

    public synchronized void a(k kVar) throws IOException {
        if (!this.f32231g) {
            this.f32230f = kVar.d(this.f32230f);
            if (kVar.c() != -1) {
                this.f32226a.a(kVar.c());
            }
            a(0, 0, (byte) 4, (byte) 1);
            this.f32227c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z2, int i2, int i3) throws IOException {
        if (!this.f32231g) {
            a(0, 8, (byte) 6, z2 ? (byte) 1 : 0);
            this.f32227c.g(i2);
            this.f32227c.g(i3);
            this.f32227c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z2, int i2, List<a> list) throws IOException {
        if (!this.f32231g) {
            this.f32226a.a(list);
            long a2 = this.f32229e.a();
            int min = (int) Math.min((long) this.f32230f, a2);
            long j2 = (long) min;
            byte b2 = a2 == j2 ? (byte) 4 : 0;
            if (z2) {
                b2 = (byte) (b2 | 1);
            }
            a(i2, min, (byte) 1, b2);
            this.f32227c.write(this.f32229e, j2);
            if (a2 > j2) {
                b(i2, a2 - j2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z2, int i2, c cVar, int i3) throws IOException {
        if (!this.f32231g) {
            byte b2 = 0;
            if (z2) {
                b2 = (byte) 1;
            }
            a(i2, b2, cVar, i3);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void b() throws IOException {
        if (!this.f32231g) {
            this.f32227c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void b(k kVar) throws IOException {
        if (!this.f32231g) {
            int i2 = 0;
            a(0, kVar.b() * 6, (byte) 4, (byte) 0);
            while (i2 < 10) {
                if (kVar.a(i2)) {
                    this.f32227c.h(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                    this.f32227c.g(kVar.b(i2));
                }
                i2++;
            }
            this.f32227c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public int c() {
        return this.f32230f;
    }

    public synchronized void close() throws IOException {
        this.f32231g = true;
        this.f32227c.close();
    }
}
