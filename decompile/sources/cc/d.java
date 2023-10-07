package cc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public final class d extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final Queue<d> f6176a = l.a(0);

    /* renamed from: b  reason: collision with root package name */
    private InputStream f6177b;

    /* renamed from: c  reason: collision with root package name */
    private IOException f6178c;

    d() {
    }

    public static d a(InputStream inputStream) {
        d poll;
        Queue<d> queue = f6176a;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new d();
        }
        poll.b(inputStream);
        return poll;
    }

    public IOException a() {
        return this.f6178c;
    }

    public int available() throws IOException {
        return this.f6177b.available();
    }

    public void b() {
        this.f6178c = null;
        this.f6177b = null;
        Queue<d> queue = f6176a;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(InputStream inputStream) {
        this.f6177b = inputStream;
    }

    public void close() throws IOException {
        this.f6177b.close();
    }

    public void mark(int i2) {
        this.f6177b.mark(i2);
    }

    public boolean markSupported() {
        return this.f6177b.markSupported();
    }

    public int read() throws IOException {
        try {
            return this.f6177b.read();
        } catch (IOException e2) {
            this.f6178c = e2;
            throw e2;
        }
    }

    public int read(byte[] bArr) throws IOException {
        try {
            return this.f6177b.read(bArr);
        } catch (IOException e2) {
            this.f6178c = e2;
            throw e2;
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        try {
            return this.f6177b.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f6178c = e2;
            throw e2;
        }
    }

    public synchronized void reset() throws IOException {
        this.f6177b.reset();
    }

    public long skip(long j2) throws IOException {
        try {
            return this.f6177b.skip(j2);
        } catch (IOException e2) {
            this.f6178c = e2;
            throw e2;
        }
    }
}
