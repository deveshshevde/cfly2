package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class s {

    /* renamed from: c  reason: collision with root package name */
    public static final s f32474c = new s() {
        public s a(long j2) {
            return this;
        }

        public s a(long j2, TimeUnit timeUnit) {
            return this;
        }

        public void g() throws IOException {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private boolean f32475a;

    /* renamed from: b  reason: collision with root package name */
    private long f32476b;

    /* renamed from: d  reason: collision with root package name */
    private long f32477d;

    public boolean B_() {
        return this.f32475a;
    }

    public s C_() {
        this.f32477d = 0;
        return this;
    }

    public long D_() {
        return this.f32477d;
    }

    public s a(long j2) {
        this.f32475a = true;
        this.f32476b = j2;
        return this;
    }

    public s a(long j2, TimeUnit timeUnit) {
        if (j2 < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j2);
        } else if (timeUnit != null) {
            this.f32477d = timeUnit.toNanos(j2);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public long d() {
        if (this.f32475a) {
            return this.f32476b;
        }
        throw new IllegalStateException("No deadline");
    }

    public s f() {
        this.f32475a = false;
        return this;
    }

    public void g() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f32475a && this.f32476b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
