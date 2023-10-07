package com.bumptech.glide.load.data;

import bl.b;
import java.io.IOException;
import java.io.OutputStream;

public final class c extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f10164a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f10165b;

    /* renamed from: c  reason: collision with root package name */
    private b f10166c;

    /* renamed from: d  reason: collision with root package name */
    private int f10167d;

    public c(OutputStream outputStream, b bVar) {
        this(outputStream, bVar, 65536);
    }

    c(OutputStream outputStream, b bVar, int i2) {
        this.f10164a = outputStream;
        this.f10166c = bVar;
        this.f10165b = (byte[]) bVar.a(i2, byte[].class);
    }

    private void a() throws IOException {
        int i2 = this.f10167d;
        if (i2 > 0) {
            this.f10164a.write(this.f10165b, 0, i2);
            this.f10167d = 0;
        }
    }

    private void b() throws IOException {
        if (this.f10167d == this.f10165b.length) {
            a();
        }
    }

    private void c() {
        byte[] bArr = this.f10165b;
        if (bArr != null) {
            this.f10166c.a(bArr);
            this.f10165b = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void close() throws IOException {
        try {
            flush();
            this.f10164a.close();
            c();
        } catch (Throwable th) {
            this.f10164a.close();
            throw th;
        }
    }

    public void flush() throws IOException {
        a();
        this.f10164a.flush();
    }

    public void write(int i2) throws IOException {
        byte[] bArr = this.f10165b;
        int i3 = this.f10167d;
        this.f10167d = i3 + 1;
        bArr[i3] = (byte) i2;
        b();
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            int i7 = this.f10167d;
            if (i7 != 0 || i5 < this.f10165b.length) {
                int min = Math.min(i5, this.f10165b.length - i7);
                System.arraycopy(bArr, i6, this.f10165b, this.f10167d, min);
                this.f10167d += min;
                i4 += min;
                b();
            } else {
                this.f10164a.write(bArr, i6, i5);
                return;
            }
        } while (i4 < i3);
    }
}
