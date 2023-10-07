package okhttp3.internal.http2;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.b;
import okio.ByteString;
import okio.c;
import okio.e;
import okio.r;
import okio.s;

final class f implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f32186a = Logger.getLogger(c.class.getName());

    /* renamed from: b  reason: collision with root package name */
    final b.a f32187b;

    /* renamed from: c  reason: collision with root package name */
    private final e f32188c;

    /* renamed from: d  reason: collision with root package name */
    private final a f32189d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f32190e;

    static final class a implements r {

        /* renamed from: a  reason: collision with root package name */
        int f32191a;

        /* renamed from: b  reason: collision with root package name */
        byte f32192b;

        /* renamed from: c  reason: collision with root package name */
        int f32193c;

        /* renamed from: d  reason: collision with root package name */
        int f32194d;

        /* renamed from: e  reason: collision with root package name */
        short f32195e;

        /* renamed from: f  reason: collision with root package name */
        private final e f32196f;

        a(e eVar) {
            this.f32196f = eVar;
        }

        private void a() throws IOException {
            int i2 = this.f32193c;
            int a2 = f.a(this.f32196f);
            this.f32194d = a2;
            this.f32191a = a2;
            byte i3 = (byte) (this.f32196f.i() & 255);
            this.f32192b = (byte) (this.f32196f.i() & 255);
            if (f.f32186a.isLoggable(Level.FINE)) {
                f.f32186a.fine(c.a(true, this.f32193c, this.f32191a, i3, this.f32192b));
            }
            int k2 = this.f32196f.k() & SubsamplingScaleImageView.TILE_SIZE_AUTO;
            this.f32193c = k2;
            if (i3 != 9) {
                throw c.b("%s != TYPE_CONTINUATION", Byte.valueOf(i3));
            } else if (k2 != i2) {
                throw c.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        public void close() throws IOException {
        }

        public long read(c cVar, long j2) throws IOException {
            while (true) {
                int i2 = this.f32194d;
                if (i2 == 0) {
                    this.f32196f.h((long) this.f32195e);
                    this.f32195e = 0;
                    if ((this.f32192b & 4) != 0) {
                        return -1;
                    }
                    a();
                } else {
                    long read = this.f32196f.read(cVar, Math.min(j2, (long) i2));
                    if (read == -1) {
                        return -1;
                    }
                    this.f32194d = (int) (((long) this.f32194d) - read);
                    return read;
                }
            }
        }

        public s timeout() {
            return this.f32196f.timeout();
        }
    }

    interface b {
        void a();

        void a(int i2, int i3, int i4, boolean z2);

        void a(int i2, int i3, List<a> list) throws IOException;

        void a(int i2, long j2);

        void a(int i2, ErrorCode errorCode);

        void a(int i2, ErrorCode errorCode, ByteString byteString);

        void a(boolean z2, int i2, int i3);

        void a(boolean z2, int i2, int i3, List<a> list);

        void a(boolean z2, int i2, e eVar, int i3) throws IOException;

        void a(boolean z2, k kVar);
    }

    f(e eVar, boolean z2) {
        this.f32188c = eVar;
        this.f32190e = z2;
        a aVar = new a(eVar);
        this.f32189d = aVar;
        this.f32187b = new b.a(4096, aVar);
    }

    static int a(int i2, byte b2, short s2) throws IOException {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s2 <= i2) {
            return (short) (i2 - s2);
        }
        throw c.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s2), Integer.valueOf(i2));
    }

    static int a(e eVar) throws IOException {
        return (eVar.i() & 255) | ((eVar.i() & 255) << 16) | ((eVar.i() & 255) << 8);
    }

    private List<a> a(int i2, short s2, byte b2, int i3) throws IOException {
        a aVar = this.f32189d;
        aVar.f32194d = i2;
        aVar.f32191a = i2;
        this.f32189d.f32195e = s2;
        this.f32189d.f32192b = b2;
        this.f32189d.f32193c = i3;
        this.f32187b.a();
        return this.f32187b.b();
    }

    private void a(b bVar, int i2) throws IOException {
        int k2 = this.f32188c.k();
        bVar.a(i2, k2 & SubsamplingScaleImageView.TILE_SIZE_AUTO, (this.f32188c.i() & 255) + 1, (Integer.MIN_VALUE & k2) != 0);
    }

    private void a(b bVar, int i2, byte b2, int i3) throws IOException {
        short s2 = 0;
        if (i3 != 0) {
            boolean z2 = (b2 & 1) != 0;
            if ((b2 & 8) != 0) {
                s2 = (short) (this.f32188c.i() & 255);
            }
            if ((b2 & 32) != 0) {
                a(bVar, i3);
                i2 -= 5;
            }
            bVar.a(z2, i3, -1, a(a(i2, b2, s2), s2, b2, i3));
            return;
        }
        throw c.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    private void b(b bVar, int i2, byte b2, int i3) throws IOException {
        short s2 = 0;
        if (i3 != 0) {
            boolean z2 = true;
            boolean z3 = (b2 & 1) != 0;
            if ((b2 & 32) == 0) {
                z2 = false;
            }
            if (!z2) {
                if ((b2 & 8) != 0) {
                    s2 = (short) (this.f32188c.i() & 255);
                }
                bVar.a(z3, i3, this.f32188c, a(i2, b2, s2));
                this.f32188c.h((long) s2);
                return;
            }
            throw c.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw c.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    private void c(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 5) {
            throw c.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
        } else if (i3 != 0) {
            a(bVar, i3);
        } else {
            throw c.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    private void d(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 4) {
            throw c.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
        } else if (i3 != 0) {
            int k2 = this.f32188c.k();
            ErrorCode a2 = ErrorCode.a(k2);
            if (a2 != null) {
                bVar.a(i3, a2);
            } else {
                throw c.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(k2));
            }
        } else {
            throw c.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    private void e(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 != 0) {
            throw c.b("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b2 & 1) != 0) {
            if (i2 == 0) {
                bVar.a();
                return;
            }
            throw c.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i2 % 6 == 0) {
            k kVar = new k();
            for (int i4 = 0; i4 < i2; i4 += 6) {
                short j2 = this.f32188c.j() & 65535;
                int k2 = this.f32188c.k();
                if (j2 != 2) {
                    if (j2 == 3) {
                        j2 = 4;
                    } else if (j2 == 4) {
                        j2 = 7;
                        if (k2 < 0) {
                            throw c.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    } else if (j2 == 5 && (k2 < 16384 || k2 > 16777215)) {
                        throw c.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(k2));
                    }
                } else if (!(k2 == 0 || k2 == 1)) {
                    throw c.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                kVar.a(j2, k2);
            }
            bVar.a(false, kVar);
        } else {
            throw c.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
        }
    }

    private void f(b bVar, int i2, byte b2, int i3) throws IOException {
        short s2 = 0;
        if (i3 != 0) {
            if ((b2 & 8) != 0) {
                s2 = (short) (this.f32188c.i() & 255);
            }
            bVar.a(i3, this.f32188c.k() & SubsamplingScaleImageView.TILE_SIZE_AUTO, a(a(i2 - 4, b2, s2), s2, b2, i3));
            return;
        }
        throw c.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void g(b bVar, int i2, byte b2, int i3) throws IOException {
        boolean z2 = false;
        if (i2 != 8) {
            throw c.b("TYPE_PING length != 8: %s", Integer.valueOf(i2));
        } else if (i3 == 0) {
            int k2 = this.f32188c.k();
            int k3 = this.f32188c.k();
            if ((b2 & 1) != 0) {
                z2 = true;
            }
            bVar.a(z2, k2, k3);
        } else {
            throw c.b("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    private void h(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 < 8) {
            throw c.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
        } else if (i3 == 0) {
            int k2 = this.f32188c.k();
            int k3 = this.f32188c.k();
            int i4 = i2 - 8;
            ErrorCode a2 = ErrorCode.a(k3);
            if (a2 != null) {
                ByteString byteString = ByteString.f32416b;
                if (i4 > 0) {
                    byteString = this.f32188c.c((long) i4);
                }
                bVar.a(k2, a2, byteString);
                return;
            }
            throw c.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(k3));
        } else {
            throw c.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    private void i(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 == 4) {
            long k2 = ((long) this.f32188c.k()) & 2147483647L;
            if (k2 != 0) {
                bVar.a(i3, k2);
            } else {
                throw c.b("windowSizeIncrement was 0", Long.valueOf(k2));
            }
        } else {
            throw c.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
        }
    }

    public void a(b bVar) throws IOException {
        if (!this.f32190e) {
            ByteString c2 = this.f32188c.c((long) c.f32104a.g());
            Logger logger = f32186a;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(nb.c.a("<< CONNECTION %s", c2.e()));
            }
            if (!c.f32104a.equals(c2)) {
                throw c.b("Expected a connection header but was %s", c2.a());
            }
        } else if (!a(true, bVar)) {
            throw c.b("Required SETTINGS preface not received", new Object[0]);
        }
    }

    public boolean a(boolean z2, b bVar) throws IOException {
        try {
            this.f32188c.a(9);
            int a2 = a(this.f32188c);
            if (a2 < 0 || a2 > 16384) {
                throw c.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
            }
            byte i2 = (byte) (this.f32188c.i() & 255);
            if (!z2 || i2 == 4) {
                byte i3 = (byte) (this.f32188c.i() & 255);
                int k2 = this.f32188c.k() & SubsamplingScaleImageView.TILE_SIZE_AUTO;
                Logger logger = f32186a;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(c.a(true, k2, a2, i2, i3));
                }
                switch (i2) {
                    case 0:
                        b(bVar, a2, i3, k2);
                        break;
                    case 1:
                        a(bVar, a2, i3, k2);
                        break;
                    case 2:
                        c(bVar, a2, i3, k2);
                        break;
                    case 3:
                        d(bVar, a2, i3, k2);
                        break;
                    case 4:
                        e(bVar, a2, i3, k2);
                        break;
                    case 5:
                        f(bVar, a2, i3, k2);
                        break;
                    case 6:
                        g(bVar, a2, i3, k2);
                        break;
                    case 7:
                        h(bVar, a2, i3, k2);
                        break;
                    case 8:
                        i(bVar, a2, i3, k2);
                        break;
                    default:
                        this.f32188c.h((long) a2);
                        break;
                }
                return true;
            }
            throw c.b("Expected a SETTINGS frame but was %s", Byte.valueOf(i2));
        } catch (EOFException unused) {
            return false;
        }
    }

    public void close() throws IOException {
        this.f32188c.close();
    }
}
