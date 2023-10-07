package javax.mail.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import javax.mail.internet.SharedInputStream;

public class SharedFileInputStream extends BufferedInputStream implements SharedInputStream {
    private static int defaultBufferSize = 2048;
    protected long bufpos;
    protected int bufsize;
    protected long datalen;

    /* renamed from: in  reason: collision with root package name */
    protected RandomAccessFile f29480in;
    private boolean master;
    private SharedFile sf;
    protected long start;

    static class SharedFile {
        private int cnt;

        /* renamed from: in  reason: collision with root package name */
        private RandomAccessFile f29481in;

        SharedFile(File file) throws IOException {
            this.f29481in = new RandomAccessFile(file, "r");
        }

        SharedFile(String str) throws IOException {
            this.f29481in = new RandomAccessFile(str, "r");
        }

        public synchronized void close() throws IOException {
            int i2 = this.cnt;
            if (i2 > 0) {
                int i3 = i2 - 1;
                this.cnt = i3;
                if (i3 <= 0) {
                    this.f29481in.close();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            super.finalize();
            this.f29481in.close();
        }

        public synchronized void forceClose() throws IOException {
            if (this.cnt > 0) {
                this.cnt = 0;
                this.f29481in.close();
            } else {
                try {
                    this.f29481in.close();
                } catch (IOException unused) {
                }
            }
        }

        public RandomAccessFile open() {
            this.cnt++;
            return this.f29481in;
        }
    }

    public SharedFileInputStream(File file) throws IOException {
        this(file, defaultBufferSize);
    }

    public SharedFileInputStream(File file, int i2) throws IOException {
        super((InputStream) null);
        this.start = 0;
        this.master = true;
        if (i2 > 0) {
            init(new SharedFile(file), i2);
            return;
        }
        throw new IllegalArgumentException("Buffer size <= 0");
    }

    public SharedFileInputStream(String str) throws IOException {
        this(str, defaultBufferSize);
    }

    public SharedFileInputStream(String str, int i2) throws IOException {
        super((InputStream) null);
        this.start = 0;
        this.master = true;
        if (i2 > 0) {
            init(new SharedFile(str), i2);
            return;
        }
        throw new IllegalArgumentException("Buffer size <= 0");
    }

    private SharedFileInputStream(SharedFile sharedFile, long j2, long j3, int i2) {
        super((InputStream) null);
        this.start = 0;
        this.master = true;
        this.master = false;
        this.sf = sharedFile;
        this.f29480in = sharedFile.open();
        this.start = j2;
        this.bufpos = j2;
        this.datalen = j3;
        this.bufsize = i2;
        this.buf = new byte[i2];
    }

    private void ensureOpen() throws IOException {
        if (this.f29480in == null) {
            throw new IOException("Stream closed");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fill() throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r7.markpos
            r1 = 0
            if (r0 >= 0) goto L_0x0010
        L_0x0005:
            r7.pos = r1
            long r0 = r7.bufpos
            int r2 = r7.count
            long r2 = (long) r2
            long r0 = r0 + r2
            r7.bufpos = r0
            goto L_0x0056
        L_0x0010:
            int r0 = r7.pos
            byte[] r2 = r7.buf
            int r2 = r2.length
            if (r0 < r2) goto L_0x0056
            int r0 = r7.markpos
            if (r0 <= 0) goto L_0x0036
            int r0 = r7.pos
            int r2 = r7.markpos
            int r0 = r0 - r2
            byte[] r2 = r7.buf
            int r3 = r7.markpos
            byte[] r4 = r7.buf
            java.lang.System.arraycopy(r2, r3, r4, r1, r0)
            r7.pos = r0
            long r2 = r7.bufpos
            int r0 = r7.markpos
            long r4 = (long) r0
            long r2 = r2 + r4
            r7.bufpos = r2
            r7.markpos = r1
            goto L_0x0056
        L_0x0036:
            byte[] r0 = r7.buf
            int r0 = r0.length
            int r2 = r7.marklimit
            if (r0 < r2) goto L_0x0041
            r0 = -1
            r7.markpos = r0
            goto L_0x0005
        L_0x0041:
            int r0 = r7.pos
            int r0 = r0 * 2
            int r2 = r7.marklimit
            if (r0 <= r2) goto L_0x004b
            int r0 = r7.marklimit
        L_0x004b:
            byte[] r0 = new byte[r0]
            byte[] r2 = r7.buf
            int r3 = r7.pos
            java.lang.System.arraycopy(r2, r1, r0, r1, r3)
            r7.buf = r0
        L_0x0056:
            int r0 = r7.pos
            r7.count = r0
            java.io.RandomAccessFile r0 = r7.f29480in
            long r1 = r7.bufpos
            int r3 = r7.pos
            long r3 = (long) r3
            long r1 = r1 + r3
            r0.seek(r1)
            byte[] r0 = r7.buf
            int r0 = r0.length
            int r1 = r7.pos
            int r0 = r0 - r1
            long r1 = r7.bufpos
            long r3 = r7.start
            long r1 = r1 - r3
            int r3 = r7.pos
            long r3 = (long) r3
            long r1 = r1 + r3
            long r3 = (long) r0
            long r1 = r1 + r3
            long r3 = r7.datalen
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0087
            long r0 = r7.bufpos
            long r5 = r7.start
            long r0 = r0 - r5
            int r2 = r7.pos
            long r5 = (long) r2
            long r0 = r0 + r5
            long r3 = r3 - r0
            int r0 = (int) r3
        L_0x0087:
            java.io.RandomAccessFile r1 = r7.f29480in
            byte[] r2 = r7.buf
            int r3 = r7.pos
            int r0 = r1.read(r2, r3, r0)
            if (r0 <= 0) goto L_0x0098
            int r1 = r7.pos
            int r0 = r0 + r1
            r7.count = r0
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.util.SharedFileInputStream.fill():void");
    }

    private int in_available() throws IOException {
        return (int) ((this.start + this.datalen) - (this.bufpos + ((long) this.count)));
    }

    private void init(SharedFile sharedFile, int i2) throws IOException {
        this.sf = sharedFile;
        RandomAccessFile open = sharedFile.open();
        this.f29480in = open;
        this.start = 0;
        this.datalen = open.length();
        this.bufsize = i2;
        this.buf = new byte[i2];
    }

    private int read1(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.count - this.pos;
        if (i4 <= 0) {
            fill();
            i4 = this.count - this.pos;
            if (i4 <= 0) {
                return -1;
            }
        }
        if (i4 < i3) {
            i3 = i4;
        }
        System.arraycopy(this.buf, this.pos, bArr, i2, i3);
        this.pos += i3;
        return i3;
    }

    public synchronized int available() throws IOException {
        ensureOpen();
        return (this.count - this.pos) + in_available();
    }

    public void close() throws IOException {
        if (this.f29480in != null) {
            try {
                if (this.master) {
                    this.sf.forceClose();
                } else {
                    this.sf.close();
                }
            } finally {
                this.sf = null;
                this.f29480in = null;
                this.buf = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    public long getPosition() {
        if (this.f29480in != null) {
            return (this.bufpos + ((long) this.pos)) - this.start;
        }
        throw new RuntimeException("Stream closed");
    }

    public synchronized void mark(int i2) {
        this.marklimit = i2;
        this.markpos = this.pos;
    }

    public boolean markSupported() {
        return true;
    }

    public InputStream newStream(long j2, long j3) {
        if (this.f29480in == null) {
            throw new RuntimeException("Stream closed");
        } else if (j2 >= 0) {
            if (j3 == -1) {
                j3 = this.datalen;
            }
            return new SharedFileInputStream(this.sf, this.start + ((long) ((int) j2)), (long) ((int) (j3 - j2)), this.bufsize);
        } else {
            throw new IllegalArgumentException("start < 0");
        }
    }

    public synchronized int read() throws IOException {
        byte b2;
        ensureOpen();
        if (this.pos >= this.count) {
            fill();
            if (this.pos >= this.count) {
                b2 = -1;
            }
        }
        byte[] bArr = this.buf;
        int i2 = this.pos;
        this.pos = i2 + 1;
        b2 = bArr[i2] & 255;
        return b2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r4, int r5, int r6) throws java.io.IOException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.ensureOpen()     // Catch:{ all -> 0x0032 }
            r0 = r5 | r6
            int r1 = r5 + r6
            r0 = r0 | r1
            int r2 = r4.length     // Catch:{ all -> 0x0032 }
            int r2 = r2 - r1
            r0 = r0 | r2
            if (r0 < 0) goto L_0x002c
            if (r6 != 0) goto L_0x0013
            r4 = 0
            monitor-exit(r3)
            return r4
        L_0x0013:
            int r0 = r3.read1(r4, r5, r6)     // Catch:{ all -> 0x0032 }
            if (r0 > 0) goto L_0x001b
            monitor-exit(r3)
            return r0
        L_0x001b:
            if (r0 < r6) goto L_0x001e
            goto L_0x0028
        L_0x001e:
            int r1 = r5 + r0
            int r2 = r6 - r0
            int r1 = r3.read1(r4, r1, r2)     // Catch:{ all -> 0x0032 }
            if (r1 > 0) goto L_0x002a
        L_0x0028:
            monitor-exit(r3)
            return r0
        L_0x002a:
            int r0 = r0 + r1
            goto L_0x001b
        L_0x002c:
            java.lang.IndexOutOfBoundsException r4 = new java.lang.IndexOutOfBoundsException     // Catch:{ all -> 0x0032 }
            r4.<init>()     // Catch:{ all -> 0x0032 }
            throw r4     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x0036
        L_0x0035:
            throw r4
        L_0x0036:
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.util.SharedFileInputStream.read(byte[], int, int):int");
    }

    public synchronized void reset() throws IOException {
        ensureOpen();
        if (this.markpos >= 0) {
            this.pos = this.markpos;
        } else {
            throw new IOException("Resetting to invalid mark");
        }
    }

    public synchronized long skip(long j2) throws IOException {
        ensureOpen();
        if (j2 <= 0) {
            return 0;
        }
        long j3 = (long) (this.count - this.pos);
        if (j3 <= 0) {
            fill();
            j3 = (long) (this.count - this.pos);
            if (j3 <= 0) {
                return 0;
            }
        }
        if (j3 < j2) {
            j2 = j3;
        }
        this.pos = (int) (((long) this.pos) + j2);
        return j2;
    }
}
