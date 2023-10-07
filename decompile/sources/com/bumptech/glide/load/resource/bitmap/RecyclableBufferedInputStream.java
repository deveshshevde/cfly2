package com.bumptech.glide.load.resource.bitmap;

import bl.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private volatile byte[] f10440a;

    /* renamed from: b  reason: collision with root package name */
    private int f10441b;

    /* renamed from: c  reason: collision with root package name */
    private int f10442c;

    /* renamed from: d  reason: collision with root package name */
    private int f10443d;

    /* renamed from: e  reason: collision with root package name */
    private int f10444e;

    /* renamed from: f  reason: collision with root package name */
    private final b f10445f;

    static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(InputStream inputStream, b bVar) {
        this(inputStream, bVar, 65536);
    }

    RecyclableBufferedInputStream(InputStream inputStream, b bVar, int i2) {
        super(inputStream);
        this.f10443d = -1;
        this.f10445f = bVar;
        this.f10440a = (byte[]) bVar.a(i2, byte[].class);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i2;
        int i3 = this.f10443d;
        if (i3 == -1 || this.f10444e - i3 >= (i2 = this.f10442c)) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                this.f10443d = -1;
                this.f10444e = 0;
                this.f10441b = read;
            }
            return read;
        }
        if (i3 == 0 && i2 > bArr.length && this.f10441b == bArr.length) {
            int length = bArr.length * 2;
            if (length <= i2) {
                i2 = length;
            }
            byte[] bArr2 = (byte[]) this.f10445f.a(i2, byte[].class);
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f10440a = bArr2;
            this.f10445f.a(bArr);
            bArr = bArr2;
        } else if (i3 > 0) {
            System.arraycopy(bArr, i3, bArr, 0, bArr.length - i3);
        }
        int i4 = this.f10444e - this.f10443d;
        this.f10444e = i4;
        this.f10443d = 0;
        this.f10441b = 0;
        int read2 = inputStream.read(bArr, i4, bArr.length - i4);
        int i5 = this.f10444e;
        if (read2 > 0) {
            i5 += read2;
        }
        this.f10441b = i5;
        return read2;
    }

    private static IOException c() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void a() {
        this.f10442c = this.f10440a.length;
    }

    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f10440a == null || inputStream == null) {
            throw c();
        }
        return (this.f10441b - this.f10444e) + inputStream.available();
    }

    public synchronized void b() {
        if (this.f10440a != null) {
            this.f10445f.a(this.f10440a);
            this.f10440a = null;
        }
    }

    public void close() throws IOException {
        if (this.f10440a != null) {
            this.f10445f.a(this.f10440a);
            this.f10440a = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void mark(int i2) {
        this.f10442c = Math.max(this.f10442c, i2);
        this.f10443d = this.f10444e;
    }

    public boolean markSupported() {
        return true;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:11:0x0018=Splitter:B:11:0x0018, B:27:0x0039=Splitter:B:27:0x0039} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read() throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            byte[] r0 = r5.f10440a     // Catch:{ all -> 0x003e }
            java.io.InputStream r1 = r5.in     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x0039
            if (r1 == 0) goto L_0x0039
            int r2 = r5.f10444e     // Catch:{ all -> 0x003e }
            int r3 = r5.f10441b     // Catch:{ all -> 0x003e }
            r4 = -1
            if (r2 < r3) goto L_0x0018
            int r1 = r5.a(r1, r0)     // Catch:{ all -> 0x003e }
            if (r1 != r4) goto L_0x0018
            monitor-exit(r5)
            return r4
        L_0x0018:
            byte[] r1 = r5.f10440a     // Catch:{ all -> 0x003e }
            if (r0 == r1) goto L_0x0026
            byte[] r0 = r5.f10440a     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x0021
            goto L_0x0026
        L_0x0021:
            java.io.IOException r0 = c()     // Catch:{ all -> 0x003e }
            throw r0     // Catch:{ all -> 0x003e }
        L_0x0026:
            int r1 = r5.f10441b     // Catch:{ all -> 0x003e }
            int r2 = r5.f10444e     // Catch:{ all -> 0x003e }
            int r1 = r1 - r2
            if (r1 <= 0) goto L_0x0037
            int r1 = r2 + 1
            r5.f10444e = r1     // Catch:{ all -> 0x003e }
            byte r0 = r0[r2]     // Catch:{ all -> 0x003e }
            r0 = r0 & 255(0xff, float:3.57E-43)
            monitor-exit(r5)
            return r0
        L_0x0037:
            monitor-exit(r5)
            return r4
        L_0x0039:
            java.io.IOException r0 = c()     // Catch:{ all -> 0x003e }
            throw r0     // Catch:{ all -> 0x003e }
        L_0x003e:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream.read():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0031, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0047, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0054, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            byte[] r0 = r6.f10440a     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x008b
            if (r9 != 0) goto L_0x000a
            r7 = 0
            monitor-exit(r6)
            return r7
        L_0x000a:
            java.io.InputStream r1 = r6.in     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x0086
            int r2 = r6.f10444e     // Catch:{ all -> 0x0090 }
            int r3 = r6.f10441b     // Catch:{ all -> 0x0090 }
            if (r2 >= r3) goto L_0x0032
            int r4 = r3 - r2
            if (r4 < r9) goto L_0x001a
            r3 = r9
            goto L_0x001b
        L_0x001a:
            int r3 = r3 - r2
        L_0x001b:
            java.lang.System.arraycopy(r0, r2, r7, r8, r3)     // Catch:{ all -> 0x0090 }
            int r2 = r6.f10444e     // Catch:{ all -> 0x0090 }
            int r2 = r2 + r3
            r6.f10444e = r2     // Catch:{ all -> 0x0090 }
            if (r3 == r9) goto L_0x0030
            int r2 = r1.available()     // Catch:{ all -> 0x0090 }
            if (r2 != 0) goto L_0x002c
            goto L_0x0030
        L_0x002c:
            int r8 = r8 + r3
            int r2 = r9 - r3
            goto L_0x0033
        L_0x0030:
            monitor-exit(r6)
            return r3
        L_0x0032:
            r2 = r9
        L_0x0033:
            int r3 = r6.f10443d     // Catch:{ all -> 0x0090 }
            r4 = -1
            if (r3 != r4) goto L_0x0048
            int r3 = r0.length     // Catch:{ all -> 0x0090 }
            if (r2 < r3) goto L_0x0048
            int r3 = r1.read(r7, r8, r2)     // Catch:{ all -> 0x0090 }
            if (r3 != r4) goto L_0x0076
            if (r2 != r9) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            int r4 = r9 - r2
        L_0x0046:
            monitor-exit(r6)
            return r4
        L_0x0048:
            int r3 = r6.a(r1, r0)     // Catch:{ all -> 0x0090 }
            if (r3 != r4) goto L_0x0055
            if (r2 != r9) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            int r4 = r9 - r2
        L_0x0053:
            monitor-exit(r6)
            return r4
        L_0x0055:
            byte[] r3 = r6.f10440a     // Catch:{ all -> 0x0090 }
            if (r0 == r3) goto L_0x0063
            byte[] r0 = r6.f10440a     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x005e
            goto L_0x0063
        L_0x005e:
            java.io.IOException r7 = c()     // Catch:{ all -> 0x0090 }
            throw r7     // Catch:{ all -> 0x0090 }
        L_0x0063:
            int r3 = r6.f10441b     // Catch:{ all -> 0x0090 }
            int r4 = r6.f10444e     // Catch:{ all -> 0x0090 }
            int r5 = r3 - r4
            if (r5 < r2) goto L_0x006d
            r3 = r2
            goto L_0x006e
        L_0x006d:
            int r3 = r3 - r4
        L_0x006e:
            java.lang.System.arraycopy(r0, r4, r7, r8, r3)     // Catch:{ all -> 0x0090 }
            int r4 = r6.f10444e     // Catch:{ all -> 0x0090 }
            int r4 = r4 + r3
            r6.f10444e = r4     // Catch:{ all -> 0x0090 }
        L_0x0076:
            int r2 = r2 - r3
            if (r2 != 0) goto L_0x007b
            monitor-exit(r6)
            return r9
        L_0x007b:
            int r4 = r1.available()     // Catch:{ all -> 0x0090 }
            if (r4 != 0) goto L_0x0084
            int r9 = r9 - r2
            monitor-exit(r6)
            return r9
        L_0x0084:
            int r8 = r8 + r3
            goto L_0x0033
        L_0x0086:
            java.io.IOException r7 = c()     // Catch:{ all -> 0x0090 }
            throw r7     // Catch:{ all -> 0x0090 }
        L_0x008b:
            java.io.IOException r7 = c()     // Catch:{ all -> 0x0090 }
            throw r7     // Catch:{ all -> 0x0090 }
        L_0x0090:
            r7 = move-exception
            monitor-exit(r6)
            goto L_0x0094
        L_0x0093:
            throw r7
        L_0x0094:
            goto L_0x0093
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream.read(byte[], int, int):int");
    }

    public synchronized void reset() throws IOException {
        if (this.f10440a != null) {
            int i2 = this.f10443d;
            if (-1 != i2) {
                this.f10444e = i2;
            } else {
                throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f10444e + " markLimit: " + this.f10442c);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    public synchronized long skip(long j2) throws IOException {
        if (j2 < 1) {
            return 0;
        }
        byte[] bArr = this.f10440a;
        if (bArr != null) {
            InputStream inputStream = this.in;
            if (inputStream != null) {
                int i2 = this.f10441b;
                int i3 = this.f10444e;
                if (((long) (i2 - i3)) >= j2) {
                    this.f10444e = (int) (((long) i3) + j2);
                    return j2;
                }
                long j3 = ((long) i2) - ((long) i3);
                this.f10444e = i2;
                if (this.f10443d == -1 || j2 > ((long) this.f10442c)) {
                    long skip = inputStream.skip(j2 - j3);
                    if (skip > 0) {
                        this.f10443d = -1;
                    }
                    return j3 + skip;
                } else if (a(inputStream, bArr) == -1) {
                    return j3;
                } else {
                    int i4 = this.f10441b;
                    int i5 = this.f10444e;
                    if (((long) (i4 - i5)) >= j2 - j3) {
                        this.f10444e = (int) ((((long) i5) + j2) - j3);
                        return j2;
                    }
                    long j4 = (j3 + ((long) i4)) - ((long) i5);
                    this.f10444e = i4;
                    return j4;
                }
            } else {
                throw c();
            }
        } else {
            throw c();
        }
    }
}
