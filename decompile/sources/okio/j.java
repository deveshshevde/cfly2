package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class j implements r {

    /* renamed from: a  reason: collision with root package name */
    private final e f32445a;

    /* renamed from: b  reason: collision with root package name */
    private final Inflater f32446b;

    /* renamed from: c  reason: collision with root package name */
    private int f32447c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f32448d;

    j(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f32445a = eVar;
            this.f32446b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    private void b() throws IOException {
        int i2 = this.f32447c;
        if (i2 != 0) {
            int remaining = i2 - this.f32446b.getRemaining();
            this.f32447c -= remaining;
            this.f32445a.h((long) remaining);
        }
    }

    public final boolean a() throws IOException {
        if (!this.f32446b.needsInput()) {
            return false;
        }
        b();
        if (this.f32446b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f32445a.f()) {
            return true;
        } else {
            o oVar = this.f32445a.b().f32435a;
            this.f32447c = oVar.f32467c - oVar.f32466b;
            this.f32446b.setInput(oVar.f32465a, oVar.f32466b, this.f32447c);
            return false;
        }
    }

    public void close() throws IOException {
        if (!this.f32448d) {
            this.f32446b.end();
            this.f32448d = true;
            this.f32445a.close();
        }
    }

    public long read(c cVar, long j2) throws IOException {
        o e2;
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (this.f32448d) {
            throw new IllegalStateException("closed");
        } else if (j2 == 0) {
            return 0;
        } else {
            while (true) {
                boolean a2 = a();
                try {
                    e2 = cVar.e(1);
                    int inflate = this.f32446b.inflate(e2.f32465a, e2.f32467c, (int) Math.min(j2, (long) (8192 - e2.f32467c)));
                    if (inflate > 0) {
                        e2.f32467c += inflate;
                        long j3 = (long) inflate;
                        cVar.f32436b += j3;
                        return j3;
                    } else if (this.f32446b.finished()) {
                        break;
                    } else if (this.f32446b.needsDictionary()) {
                        break;
                    } else if (a2) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e3) {
                    throw new IOException(e3);
                }
            }
            b();
            if (e2.f32466b != e2.f32467c) {
                return -1;
            }
            cVar.f32435a = e2.b();
            p.a(e2);
            return -1;
        }
    }

    public s timeout() {
        return this.f32445a.timeout();
    }
}
