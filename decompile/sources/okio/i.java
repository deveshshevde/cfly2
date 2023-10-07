package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class i implements r {

    /* renamed from: a  reason: collision with root package name */
    private int f32440a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final e f32441b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f32442c;

    /* renamed from: d  reason: collision with root package name */
    private final j f32443d;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f32444e = new CRC32();

    public i(r rVar) {
        if (rVar != null) {
            Inflater inflater = new Inflater(true);
            this.f32442c = inflater;
            e a2 = k.a(rVar);
            this.f32441b = a2;
            this.f32443d = new j(a2, inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void a() throws IOException {
        this.f32441b.a(10);
        byte b2 = this.f32441b.b().b(3);
        boolean z2 = ((b2 >> 1) & 1) == 1;
        if (z2) {
            a(this.f32441b.b(), 0, 10);
        }
        a("ID1ID2", 8075, (int) this.f32441b.j());
        this.f32441b.h(8);
        if (((b2 >> 2) & 1) == 1) {
            this.f32441b.a(2);
            if (z2) {
                a(this.f32441b.b(), 0, 2);
            }
            long l2 = (long) this.f32441b.b().l();
            this.f32441b.a(l2);
            if (z2) {
                a(this.f32441b.b(), 0, l2);
            }
            this.f32441b.h(l2);
        }
        if (((b2 >> 3) & 1) == 1) {
            long a2 = this.f32441b.a((byte) 0);
            if (a2 != -1) {
                if (z2) {
                    a(this.f32441b.b(), 0, a2 + 1);
                }
                this.f32441b.h(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((b2 >> 4) & 1) == 1) {
            long a3 = this.f32441b.a((byte) 0);
            if (a3 != -1) {
                if (z2) {
                    a(this.f32441b.b(), 0, a3 + 1);
                }
                this.f32441b.h(a3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z2) {
            a("FHCRC", (int) this.f32441b.l(), (int) (short) ((int) this.f32444e.getValue()));
            this.f32444e.reset();
        }
    }

    private void a(String str, int i2, int i3) throws IOException {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i2)}));
        }
    }

    private void a(c cVar, long j2, long j3) {
        o oVar = cVar.f32435a;
        while (j2 >= ((long) (oVar.f32467c - oVar.f32466b))) {
            j2 -= (long) (oVar.f32467c - oVar.f32466b);
            oVar = oVar.f32470f;
        }
        while (j3 > 0) {
            int i2 = (int) (((long) oVar.f32466b) + j2);
            int min = (int) Math.min((long) (oVar.f32467c - i2), j3);
            this.f32444e.update(oVar.f32465a, i2, min);
            j3 -= (long) min;
            oVar = oVar.f32470f;
            j2 = 0;
        }
    }

    private void b() throws IOException {
        a("CRC", this.f32441b.m(), (int) this.f32444e.getValue());
        a("ISIZE", this.f32441b.m(), (int) this.f32442c.getBytesWritten());
    }

    public void close() throws IOException {
        this.f32443d.close();
    }

    public long read(c cVar, long j2) throws IOException {
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (j2 == 0) {
            return 0;
        } else {
            if (this.f32440a == 0) {
                a();
                this.f32440a = 1;
            }
            if (this.f32440a == 1) {
                long j3 = cVar.f32436b;
                long read = this.f32443d.read(cVar, j2);
                if (read != -1) {
                    a(cVar, j3, read);
                    return read;
                }
                this.f32440a = 2;
            }
            if (this.f32440a == 2) {
                b();
                this.f32440a = 3;
                if (!this.f32441b.f()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public s timeout() {
        return this.f32441b.timeout();
    }
}
