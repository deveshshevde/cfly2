package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class j extends ByteArrayOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final b f10007a;

    public j(b bVar, int i2) {
        this.f10007a = bVar;
        this.buf = bVar.a(Math.max(i2, 256));
    }

    private void a(int i2) {
        if (this.count + i2 > this.buf.length) {
            byte[] a2 = this.f10007a.a((this.count + i2) * 2);
            System.arraycopy(this.buf, 0, a2, 0, this.count);
            this.f10007a.a(this.buf);
            this.buf = a2;
        }
    }

    public void close() throws IOException {
        this.f10007a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f10007a.a(this.buf);
    }

    public synchronized void write(int i2) {
        a(1);
        super.write(i2);
    }

    public synchronized void write(byte[] bArr, int i2, int i3) {
        a(i3);
        super.write(bArr, i2, i3);
    }
}
